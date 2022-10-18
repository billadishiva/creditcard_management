package cards.credit.management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import cards.credit.management.dto.CreditCardDTO;
import cards.credit.management.service.CreditCardService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author billa
 *
 */
@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreditCardService creditCardService;
	CreditCardDTO creditCardDtoOne;
	CreditCardDTO creditCardDtoTwo;
	CreditCardDTO creditCardDtoThree;
	CreditCardDTO creditCardDtoFour;
	CreditCardDTO creditCardDtoFive;

	List<CreditCardDTO> creditCardList = new ArrayList<CreditCardDTO>();

	@BeforeEach
	void setUp() {

		// valid credit-cards
		creditCardDtoOne = new CreditCardDTO(30000, "1234567812345670", "Shivaraj", 0);
		creditCardDtoTwo = new CreditCardDTO(30000, "49927398716", "Shetty", 0);

		// invalid credit-card
		creditCardDtoThree = new CreditCardDTO(30000, "49927398717", "Shetty", 0);

		// invalid credit-card having more numbers
		creditCardDtoFour = new CreditCardDTO(30000, "49927398716ad", "Shetty", 0);

		// invalid credit-card with non-numeric character
		creditCardDtoFive = new CreditCardDTO(30000, "49927398749927398717174992739871749927398717", "Shetty", 0);

		creditCardList.add(creditCardDtoOne);
		creditCardList.add(creditCardDtoTwo);
	}

	@AfterEach
	void tearDown() {

	}

	@Test
	void findAllCards() throws Exception {
		when(creditCardService.getAllDetails()).thenReturn(creditCardList);
		this.mockMvc.perform(get("/creditcards/getall").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void saveCreditCard() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(creditCardDtoOne);
		this.mockMvc.perform(post("/creditcards/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void checkInvalidNumber() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(creditCardDtoThree);
		this.mockMvc.perform(post("/creditcards/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void checkForString() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(creditCardDtoFour);
		this.mockMvc.perform(post("/creditcards/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void checkForLength() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(creditCardDtoFive);
		this.mockMvc.perform(post("/creditcards/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isBadRequest());
	}

}
