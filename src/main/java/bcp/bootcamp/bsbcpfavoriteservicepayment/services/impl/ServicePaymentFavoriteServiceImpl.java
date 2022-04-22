package bcp.bootcamp.bsbcpfavoriteservicepayment.services.impl;

import bcp.bootcamp.bsbcpfavoriteservicepayment.entities.ServicePaymentFavorite;
import bcp.bootcamp.bsbcpfavoriteservicepayment.repositories.ServicePaymentFavoriteRepository;
import bcp.bootcamp.bsbcpfavoriteservicepayment.services.ServicePaymentFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicePaymentFavoriteServiceImpl implements ServicePaymentFavoriteService {

    @Autowired
    private ServicePaymentFavoriteRepository servicePaymentFavoriteRepository;

    @Override
    public Mono<ServicePaymentFavorite> findById(String id) {
        return this.servicePaymentFavoriteRepository.findById(id);
    }

    @Override
    public Flux<ServicePaymentFavorite> findByClientId(Integer clientId) {
        return this.servicePaymentFavoriteRepository.findByClientId(clientId);
    }

    @Override
    public Mono<ServicePaymentFavorite> save(ServicePaymentFavorite servicePaymentFavorite) {
        return this.servicePaymentFavoriteRepository.save(servicePaymentFavorite);
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.servicePaymentFavoriteRepository.deleteById(id);
    }

}
