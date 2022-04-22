package bcp.bootcamp.bsbcpfavoriteservicepayment.services;

import bcp.bootcamp.bsbcpfavoriteservicepayment.entities.ServicePaymentFavorite;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicePaymentFavoriteService {

    Flux<ServicePaymentFavorite> findByClientId(Integer clientId);

    Mono<ServicePaymentFavorite> save(ServicePaymentFavorite servicePaymentFavorite);

    Mono<Void> delete(String id);

}
