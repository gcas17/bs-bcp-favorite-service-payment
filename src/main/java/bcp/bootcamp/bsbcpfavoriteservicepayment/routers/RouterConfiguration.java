package bcp.bootcamp.bsbcpfavoriteservicepayment.routers;

import bcp.bootcamp.bsbcpfavoriteservicepayment.core.exception.GlobalExceptionHandler;
import bcp.bootcamp.bsbcpfavoriteservicepayment.entities.ServicePaymentFavorite;
import bcp.bootcamp.bsbcpfavoriteservicepayment.handlers.ServicePaymentFavoriteHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfiguration {
    @Bean
    @RouterOperations( {
        @RouterOperation (
            path = "/service-payment-favorite",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET,
            beanClass = ServicePaymentFavoriteHandler.class,
            beanMethod = "getServicePaymentFavorites",
            operation = @Operation(
                summary = "Listar servicios de pago favoritos",
                description = "Listar servicios de pago favoritos",
                operationId = "getServicePaymentFavorites",
                responses = {
                    @ApiResponse(responseCode = "200",
                        description = "Operación exitosa",
                        content = @Content(array=@ArraySchema(schema = @Schema(implementation = ServicePaymentFavorite.class)))),
                    @ApiResponse(
                        responseCode = "404",
                        description = "No se encontró elementos",
                        content = @Content(schema = @Schema(implementation= GlobalExceptionHandler.HttpError.class))
                    )
                },
                parameters = {
                        @Parameter(in = ParameterIn.QUERY, name = "clientId", required = true)
                }
            )
        ),
        @RouterOperation (
            path = "/service-payment-favorite",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST,
            beanClass = ServicePaymentFavoriteHandler.class,
            beanMethod = "saveServicePaymentFavorite",
            operation = @Operation(
                summary = "Guardar servicio favorito del cliente",
                description="Guardar servicio favorito del cliente",
                operationId = "saveServicePaymentFavorite",
                responses = {
                    @ApiResponse(
                        responseCode = "200",
                        description = "Operación exitosa",
                        content = @Content(schema = @Schema(implementation = ServicePaymentFavorite.class))
                    )
                },
                parameters = {},
                requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ServicePaymentFavorite.class)))
            )
        ),
        @RouterOperation (
            path = "/service-payment-favorite/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.DELETE,
            beanClass = ServicePaymentFavoriteHandler.class,
            beanMethod = "deleteServicePaymentFavorite",
            operation = @Operation(
                summary = "Eliminar servicio favorito del cliente",
                description="Eliminar servicio favorito del cliente",
                operationId = "deleteServicePaymentFavorite",
                responses = {
                    @ApiResponse(
                        responseCode = "200",
                        description = "Operación exitosa",
                        content = @Content(schema = @Schema(implementation = ServicePaymentFavorite.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "No se encontró el servicio de pago")
                },
                parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id")
                },
                requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ServicePaymentFavorite.class)))
            )
        )
    })
    public RouterFunction<ServerResponse> servicePaymentRoutes(ServicePaymentFavoriteHandler servicePaymentFavoriteHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/service-payment-favorite"),
            RouterFunctions
                .route(GET(""), servicePaymentFavoriteHandler::getServicePaymentFavorites)
                .andRoute(POST("").and(contentType(APPLICATION_JSON)), servicePaymentFavoriteHandler::saveServicePaymentFavorite)
                .andRoute(DELETE("/{id}").and(contentType(APPLICATION_JSON)), servicePaymentFavoriteHandler::deleteServicePaymentFavorite)
        );
    }
}
