package cl.duocuc.userservice.service;

import cl.duocuc.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<User> users = new ArrayList<>(List.of(
            User.builder().name("Benjamín Andrés Aguilar Ledezma").rut("20428923-9").id("1").active(true).rol("ADMIN").build(),
            User.builder().name("Camila Fernanda Soto Rivas").rut("19567382-7").id("2").active(true).rol("GERENTE").build(),
            User.builder().name("José Miguel Pizarro Reyes").rut("18345678-3").id("3").active(true).rol("EMPLEADO").build(),
            User.builder().name("Antonia Valentina Fuentes Mora").rut("21456789-4").id("4").active(true).rol("CLIENTE").build(),
            User.builder().name("Lucas Sebastián Rojas Vargas").rut("17432156-8").id("5").active(true).rol("CLIENTE").build(),
            User.builder().name("Martina Paz Castillo Núñez").rut("18654789-2").id("6").active(true).rol("CLIENTE").build(),
            User.builder().name("Matías Ignacio Herrera Soto").rut("20987654-1").id("7").active(true).rol("EMPLEADO").build(),
            User.builder().name("Javiera Alejandra Torres Gutiérrez").rut("20123456-7").id("8").active(true).rol("CLIENTE").build(),
            User.builder().name("Diego Alejandro Morales Peña").rut("19345678-5").id("9").active(true).rol("GERENTE").build(),
            User.builder().name("Francisca Isidora Salazar León").rut("21234567-9").id("10").active(true).rol("CLIENTE").build(),
            User.builder().name("Cristóbal Esteban Vega Rojas").rut("18234567-2").id("11").active(true).rol("EMPLEADO").build(),
            User.builder().name("Valentina Belén Orellana Campos").rut("19678901-6").id("12").active(true).rol("CLIENTE").build(),
            User.builder().name("Sebastián Nicolás Alarcón Díaz").rut("20345678-4").id("13").active(true).rol("CLIENTE").build(),
            User.builder().name("Catalina Antonia Fuenzalida Moya").rut("21123456-5").id("14").active(true).rol("CLIENTE").build(),
            User.builder().name("Tomás Enrique Cáceres Muñoz").rut("17765432-1").id("15").active(true).rol("EMPLEADO").build(),
            User.builder().name("Fernanda Andrea Navarro Rivas").rut("18543210-8").id("16").active(true).rol("GERENTE").build(),
            User.builder().name("Ignacio Esteban Pino Rojas").rut("19432165-7").id("17").active(true).rol("CLIENTE").build(),
            User.builder().name("Isidora María Díaz Fuentes").rut("20456789-0").id("18").active(true).rol("CLIENTE").build(),
            User.builder().name("Vicente Alonso Bravo Soto").rut("18321098-3").id("19").active(true).rol("EMPLEADO").build(),
            User.builder().name("Daniela Paz Ramírez Contreras").rut("20234567-1").id("20").active(true).rol("CLIENTE").build(),
            User.builder().name("Renato Felipe Castillo Herrera").rut("19765432-3").id("21").active(true).rol("GERENTE").build(),
            User.builder().name("Amanda Lucía Gallardo Pérez").rut("21098765-6").id("22").active(true).rol("CLIENTE").build(),
            User.builder().name("Benjamín Tomás Farías Díaz").rut("19321098-4").id("23").active(true).rol("CLIENTE").build(),
            User.builder().name("Constanza Ignacia Carrasco Paredes").rut("20432109-7").id("24").active(true).rol("EMPLEADO").build(),
            User.builder().name("Joaquín Alonso Sanhueza Lagos").rut("18456789-0").id("25").active(true).rol("CLIENTE").build(),
            User.builder().name("Trinidad Emilia Leiva Rojas").rut("19987654-9").id("26").active(true).rol("CLIENTE").build(),
            User.builder().name("Agustín Rafael Paredes Fuentes").rut("18765432-2").id("27").active(true).rol("CLIENTE").build(),
            User.builder().name("Josefa Antonia Godoy Campos").rut("21111111-1").id("28").active(true).rol("EMPLEADO").build(),
            User.builder().name("Gabriel Andrés Escobar Núñez").rut("20555555-5").id("29").active(true).rol("GERENTE").build(),
            User.builder().name("Emilia Soledad Araya Valenzuela").rut("20666666-6").id("30").active(true).rol("ADMIN").build()
    ));

    public static List<User> findAll() {
        return users;
    }

    public User findById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().orElse(null);
    }

    public boolean removeUser(String id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    public boolean updateUser(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean desactivateUser(String id) {
        User user = findById(id);
        if (user != null) {
            user.setActive(false);
            return true;
        }
        return false;
    }

    // Nuevo método para agregar usuarios
    public boolean addUser(User user) {
        if (findById(user.getId()) != null) {
            return false; // ID ya existe
        }
        return users.add(user);
    }
}
