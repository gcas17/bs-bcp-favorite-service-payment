package bcp.bootcamp.bsbcpfavoriteservicepayment.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "service-payment-favorite")
public class ServicePaymentFavorite {
    @Id
    private String id;

    @Field(name = "ClientId")
    private Integer clientId;

    @Field(name = "ServicePaymentId")
    private Integer servicePaymentId;

    @Field(name = "FavoriteName")
    private String favoriteName;

    @Field(name = "FavoriteType")
    private String favoriteType;

    @Field(name = "CreationDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate creationDate;
}
