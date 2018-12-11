package br.com.vr.domains.repository;

import br.com.vr.domains.PurchaseCard;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PurchaseCardRepository extends CrudRepository<PurchaseCard, String> {

}
