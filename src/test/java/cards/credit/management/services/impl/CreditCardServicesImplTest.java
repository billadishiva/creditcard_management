package cards.credit.management.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assert;
import org.assertj.core.api.CollectionAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import static org.mockito.BDDMockito.given;

import cards.credit.management.dto.CreditCardDTO;
import cards.credit.management.model.CreditCard;
import cards.credit.management.repository.CreditCardRepository;
import cards.credit.management.service.CreditCardService;
import cards.credit.management.service.impl.CreditCardServicesImpl;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author billa
 *
 */
public class CreditCardServicesImplTest {

	@Mock
	private CreditCardRepository creditCardRepository;
	private CreditCardService creditCardService;
	AutoCloseable autoCloseable;
	CreditCard creditCard;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		creditCardService = new CreditCardServicesImpl(creditCardRepository);
		creditCard = new CreditCard(5425, 533, "49927398717", "billa", 0);

	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void saveCreditCard() {
		mock(CreditCard.class);
		mock(CreditCardRepository.class);
		assertThat(creditCardService.addCreditCard(creditCard)).isEqualTo("Success");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Test
	void findAllCards() {
		mock(CreditCard.class);
		mock(CreditCardRepository.class);
		List<CreditCard> cards = new ArrayList<CreditCard>();
		cards.add(new CreditCard(23, 3455, "49927398716", "billashiva", 20000));
		cards.add(new CreditCard(25, 5643, "1234567812345670", "billashetty", 20000));
		cards.add(new CreditCard(28, 9900, "5555555555554444", "billashetty", 20000));

		given(creditCardRepository.findAll()).willReturn(cards);
		List<CreditCardDTO> cardsExpected = creditCardService.getAllDetails();
		List<CreditCardDTO> cardsActual = cards.stream()
				.map(CreditCard -> modelMapper().map(CreditCard, CreditCardDTO.class)).collect(Collectors.toList());
		assertThat(cardsExpected.get(0)).isEqualTo(cardsActual.get(0));
		assertThat(cardsExpected.get(1)).isEqualTo(cardsActual.get(1));
		assertThat(cardsExpected.get(2)).isEqualTo(cardsActual.get(2));

	}
}
