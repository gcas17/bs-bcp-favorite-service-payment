package bcp.bootcamp.bsbcpfavoriteservicepayment.handlers;

import bcp.bootcamp.bsbcpfavoriteservicepayment.core.exception.ServicePaymentFavoriteBaseException;
import bcp.bootcamp.bsbcpfavoriteservicepayment.entities.ServicePaymentFavorite;
import bcp.bootcamp.bsbcpfavoriteservicepayment.services.ServicePaymentFavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ServicePaymentFavoriteHandler {

    @Autowired
    private ServicePaymentFavoriteService servicePaymentFavoriteService;

    public Mono<ServerResponse> getServicePaymentFavorites(ServerRequest request) {
        Integer clientId = Integer.parseInt(request.queryParam("clientId").get());
        return this.servicePaymentFavoriteService.findByClientId(clientId)
                .switchIfEmpty(Mono.error(new ServicePaymentFavoriteBaseException("No se encontró elementos")))
                .collectList()
                .flatMap(list -> ServerResponse.ok().body(Mono.just(list), ServicePaymentFavorite.class));
    }

    public Mono<ServerResponse> saveServicePaymentFavorite(ServerRequest request) {
        return request.bodyToMono(ServicePaymentFavorite.class)
                .flatMap(servicePaymentFavorite -> this.servicePaymentFavoriteService.save(servicePaymentFavorite))
                .flatMap(servicePaymentFavorite -> ServerResponse.ok().body(Mono.just(servicePaymentFavorite), ServicePaymentFavorite.class));
    }

    public Mono<ServerResponse> deleteServicePaymentFavorite(ServerRequest request) {
        String id = request.pathVariable("clientId");

        return this.servicePaymentFavoriteService.delete(id)
                .switchIfEmpty(Mono.error(new ServicePaymentFavoriteBaseException("No se encontró elementos")))
                .then(ServerResponse.ok().build());
    }

}
