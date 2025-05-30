package cl.duocuc.inventoryservice.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private String id;
    private String productId;
    private String storeId;
    private int quantity;


}
