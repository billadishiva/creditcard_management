/**
 * 
 */
package cards.credit.management.dto;

import javax.persistence.Entity;

import com.sun.istack.NotNull;

/**
 * @author billa
 *
 */
@Entity
public class CreditCardDTO {

	@NotNull
	private int balance;
	
	@NotNull
	private String cardNumber;
	
	@NotNull
	private String cardHolderName;
	
	@NotNull
	private int purchaseLimit;

	/**
	 * @return the balance
	 */
	
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 * @param cardNumber
	 * @param cardHolderName
	 * @param purchaseLimit
	 */
	public CreditCardDTO(int balance, String cardNumber, String cardHolderName, int purchaseLimit) {
		super();
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.purchaseLimit = purchaseLimit;
	}
	
	public CreditCardDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * @return the purchaseLimit
	 */
	public int getPurchaseLimit() {
		return purchaseLimit;
	}

	/**
	 * @param purchaseLimit the purchaseLimit to set
	 */
	public void setPurchaseLimit(int purchaseLimit) {
		this.purchaseLimit = purchaseLimit;
	}
	
	
	/**
	 * @return boolean by comparing card number
	 */
	public boolean equals(Object creditCardDto) {
        return this.cardNumber == ((CreditCardDTO)creditCardDto).cardNumber;
     }
}
