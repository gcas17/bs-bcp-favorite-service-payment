package bcp.bootcamp.bsbcpfavoriteservicepayment.repositories;

import bcp.bootcamp.bsbcpfavoriteservicepayment.entities.ServicePaymentFavorite;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ServicePaymentFavoriteRepository extends ReactiveMongoRepository<ServicePaymentFavorite,String> {

    Flux<ServicePaymentFavorite> findByClientId(Integer clientId);

}
