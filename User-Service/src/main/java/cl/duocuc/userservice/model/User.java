package cl.duocuc.userservice.model;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String rut;
    private String id;
    private boolean active;
    private String rol;


}
