package br.com.vr.repositories;

import br.com.vr.domains.PurchaseCard;
import br.com.vr.domains.PurchaseCardId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PurchaseCardRepository extends CrudRepository<PurchaseCard, PurchaseCardId> {

}
