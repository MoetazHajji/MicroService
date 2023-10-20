package tn.esprit.stockservice.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name_product;
    String reference;
    Double price;
    Double size_product;
    String description;
    String image;
    Long count_order;

    @Enumerated(EnumType.STRING)
    Type_product type_product;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    Set<Stock> stocks;
}
