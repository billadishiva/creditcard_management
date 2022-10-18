package cards.credit.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cards.credit.management.dto.CreditCardDTO;
import cards.credit.management.model.CreditCard;
import cards.credit.management.service.CreditCardService;
import cards.credit.management.utils.Utils;

/**
 * @author billa
 * Represents controller Part and holds all the REST end-point
 */
@RestController
@RequestMapping(value = "/creditcards", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class CreditCardController {

	CreditCardService creditCardService;

	@Autowired
	public CreditCardController(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}

	/**
	 * Read all Cards Details from DB
	 */
	@GetMapping("/getall")
	public List<CreditCardDTO> getAllDetails() {
		return creditCardService.getAllDetails();

	}

	/**
	 * accept new card details and insert to DB
	 */
	
	@PostMapping("/add")
	public ResponseEntity<?> saveCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		if (null != creditCardDto) {
			creditCard = Utils.convertToEntity(creditCardDto);
		}
		try {
			String cardNumber = "";
			if (null != creditCard.getCardNumber()) {
				cardNumber = creditCard.getCardNumber();
				if (Utils.isValidCreditCardNumber(cardNumber) && Utils.isValidLength(cardNumber)
						&& Utils.isNumeric(cardNumber)) {
					creditCard.setPurchaseLimit(5000);
					creditCardService.addCreditCard(creditCard);
					HttpHeaders responseHeaders = new HttpHeaders();
					responseHeaders.set("consumer transction", "123456");
					return new ResponseEntity<String>("Successfully Created", responseHeaders, HttpStatus.OK);

				} else {
					return new ResponseEntity<String>("Invalid Request-Please verify your Card Number",HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>("Invalid Request-Please verify your Card Number",HttpStatus.BAD_REQUEST);
			}

		} catch (Exception ex) {
			return new ResponseEntity<String>("Invalid Request- Please check your details",HttpStatus.BAD_REQUEST);
		}

	}

}
