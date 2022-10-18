package cards.credit.management.service;

import java.util.List;

import cards.credit.management.dto.CreditCardDTO;
import cards.credit.management.model.CreditCard;

/**
 * @author billa
 * Interface consists all needed methods to be implemented
 */
public interface CreditCardService {

	/**
	 * This method is used to fetch all the card details from DB
	 * 
	 * @return List This returns collection of DTO's
	 */
	List<CreditCardDTO> getAllDetails();

	/**
	 * This method is used to add new card details to DB
	 * 
	 * @return String 
	 */
	String addCreditCard(CreditCard creditCard);

}
