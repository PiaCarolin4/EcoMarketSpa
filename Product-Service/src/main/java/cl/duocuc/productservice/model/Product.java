package cl.duocuc.productservice.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
}