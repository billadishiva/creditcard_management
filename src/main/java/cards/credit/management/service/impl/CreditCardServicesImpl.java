/**
 * 
 */
package cards.credit.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import cards.credit.management.dto.CreditCardDTO;
import cards.credit.management.model.CreditCard;
import cards.credit.management.repository.CreditCardRepository;
import cards.credit.management.service.CreditCardService;

/**
 * @author billa
 * Service Implementation class which contains method to invoke repository
 */
@Service
public class CreditCardServicesImpl implements CreditCardService{

	
	/**
	 * Creating CreditCardRepository object
	 */
	CreditCardRepository creditCardRepository;
	
	@Autowired
	public CreditCardServicesImpl(CreditCardRepository creditCardRepository) {
		this.creditCardRepository = creditCardRepository;
	}

	/**
	 *This method is used to insert creditcard details to DB
	 *@return String
	 */
	public String addCreditCard(CreditCard creditCard) {
		// TODO Auto-generated method stub
		creditCardRepository.save(creditCard);
		return "Success";

	}
    
	/**
	 * This method is used to fetch all the card details from DB
	 * 
	 * @return List This returns collection of DTO's
	 */
	public List<CreditCardDTO> getAllDetails() {
		List<CreditCardDTO> creditCardDTOs = new ArrayList<CreditCardDTO>();
		List<CreditCard> creditCardDetails = (List<CreditCard>) creditCardRepository.findAll();
		if(null != creditCardDetails) {
		//BeanUtils.copyProperties(creditCardDetails, creditCardDetails); 
		creditCardDTOs = creditCardDetails.stream().map(CreditCard -> modelMapper().map(CreditCard,
		CreditCardDTO.class)).collect(Collectors.toList());
		}
		
		return creditCardDTOs;

	}

	/**
	 * This method is used to inject ModelMapper
	 * 
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	/*
	 * public List<CreditCardDTO> getDtoList(List<CreditCard> entityList) {
	 * List<CreditCardDTO> dtoList = new ArrayList<CreditCardDTO>(); Type listType =
	 * new TypeToken<List<CreditCardDTO>>() { }.getType(); List<CreditCardDTO>
	 * postDtoList = modelMapper().map(dtoList, listType);
	 * 
	 * return postDtoList;
	 * 
	 * }
	 */



}
