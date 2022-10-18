/**
 * 
 */
package cards.credit.management.utils;

import java.util.Arrays;

import org.aspectj.apache.bcel.generic.RET;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import cards.credit.management.dto.CreditCardDTO;
import cards.credit.management.model.CreditCard;

import org.modelmapper.ModelMapper;

/**
 * @author billa
 * 
 */
@Component
public class Utils {
	 
public static boolean isValidCreditCardNumber(String cardNumber)
{
   // int array for processing the cardNumber
   int[] cardIntArray=new int[cardNumber.length()];

   for(int i=0;i<cardNumber.length();i++)
   {
       char c= cardNumber.charAt(i);
       cardIntArray[i]=  Integer.parseInt(""+c);
   }

   for(int i=cardIntArray.length-2;i>=0;i=i-2)
   {
       int num = cardIntArray[i];
       num = num * 2;  // step 1
       if(num>9)
       {
           num = num%10 + num/10;  // step 2
       }
       cardIntArray[i]=num;
   }

   int sum = sumDigits(cardIntArray);  // step 3

   System.out.println(sum);

   if(sum%10==0)  // step 4
   {
       return true;
   }

   return false;

}

public static int sumDigits(int[] arr)
{
   return Arrays.stream(arr).sum();
}

public static boolean isValidLength(String cardNumber) {
	if(cardNumber.length()> 19) {
	 return false;
	}
	return true;
	
}

public static boolean isNumeric(String cardNumber) {
	
	if (cardNumber.contains("[a-zA-Z]+") == true){
	    return false;
	}
	return true;
	
}

public static CreditCard convertToEntity(CreditCardDTO creditCardDto) {
	CreditCard creditCard = new CreditCard();
	creditCard.setBalance(creditCardDto.getBalance());
	creditCard.setCardHolderName(creditCardDto.getCardHolderName());
	creditCard.setCardNumber(creditCardDto.getCardNumber());
	creditCard.setPurchaseLimit(creditCardDto.getPurchaseLimit());
	return creditCard;
}



}
