/**
 * 
 */
package cards.credit.management.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import cards.credit.management.model.CreditCard;

/**
 * @author billa
 *
 */
@DataJpaTest
public class CreditCardRepositoryTest {

	@Autowired
	private CreditCardRepository creditCardRepository;

	CreditCard creditCard;

	@Test
	public void saveCreditCard() {
		CreditCard creditCardActual = new CreditCard(4324, 60000, "5425233430109903", "Billa Shivaraj", 100000);
		CreditCard creditCard = creditCardRepository.save(creditCardActual);

		assertThat(creditCard.getCardNumber()).isEqualTo(creditCardActual.getCardNumber());
		assertThat(creditCard.getCardHolderName()).isEqualTo(creditCardActual.getCardHolderName());

	}

	@Test
	public void findAllCards() {
		CreditCard creditCardActualOne = new CreditCard(1, 60000, "5425233430109903", "Billa Shivaraj", 100000);
		creditCardRepository.save(creditCardActualOne);

		CreditCard creditCardActualTwo = new CreditCard(2, 60000, "3566000020000410", "Billa Shetty", 100000);
		creditCardRepository.save(creditCardActualTwo);

		CreditCard creditCardActualThree = new CreditCard(3, 60000, "5425233430109903", "shetty Shivaraj", 100000);
		creditCardRepository.save(creditCardActualThree);

		List<CreditCard> cards = (List<CreditCard>) creditCardRepository.findAll();

		assertThat(cards.get(0)).isEqualTo(creditCardActualOne);
		assertThat(cards.get(1)).isEqualTo(creditCardActualTwo);
		assertThat(cards.get(2)).isEqualTo(creditCardActualThree);
	}

}
