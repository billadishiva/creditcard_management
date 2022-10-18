/**
 * 
 */
package cards.credit.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cards.credit.management.model.CreditCard;

/**
 * @author billa
 * 
 */
@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

}
