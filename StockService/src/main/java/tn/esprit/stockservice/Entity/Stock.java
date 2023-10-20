package tn.esprit.stockservice.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long nbProduct;
    String unit;
    Double total_quantity;
    Double storage;
    Double free_storage;
    Double used_storage;
    LocalDate date;
    String location;

    @Enumerated(EnumType.STRING)
    Type_product type_product;
    @Enumerated(EnumType.STRING)
    State state;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Set<Product> products;
}
