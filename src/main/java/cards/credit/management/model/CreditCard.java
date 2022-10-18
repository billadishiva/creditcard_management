/**
 * 
 */
package cards.credit.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import cards.credit.management.dto.CreditCardDTO;

/**
 * @author billa
 *
 */
@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int customerNumber;

	@Column(name = "balance")
	private int balance;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_holder_name")
	private String cardHolderName;

	@Column(name = "purchase_limit")
	private int purchaseLimit;

	/**
	 * @param customerNumber
	 * @param balance
	 * @param cardNumber
	 * @param cardHolderName
	 */
	public CreditCard(int customerNumber, int balance, String cardNumber, String cardHolderName, int purchaseLimit) {
		super();
		this.customerNumber = customerNumber;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.purchaseLimit = purchaseLimit;
	}

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
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
	public boolean equals(Object creditCard) {
		return this.cardNumber == ((CreditCard) creditCard).cardNumber;
	}

}
