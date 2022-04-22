package bcp.bootcamp.bsbcpfavoriteservicepayment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@OpenAPIDefinition(info = @Info(title = "Api BS Favorite Service Payment V1.0.0", version = "1.0", description = "Api de negocio para el manejo de servicios BCP favoritos del cliente"))
public class FavoriteServicePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteServicePaymentApplication.class, args);
	}

}
