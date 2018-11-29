package br.com.vr.repositories;

import br.com.vr.domains.CommercialStore;
import br.com.vr.domains.CommercialStoreId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface DynamoRepository extends CrudRepository<CommercialStore, CommercialStoreId> {

}