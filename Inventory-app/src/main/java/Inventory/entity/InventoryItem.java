package Inventory.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
@Table(name = "inventory")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uniq_id")
    private String id;
    private String sku;
    @Transient
    private Boolean available = random();
    private static Boolean random(){
        return new Random().nextBoolean();
    }
}
