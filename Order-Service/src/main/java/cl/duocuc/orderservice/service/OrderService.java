package cl.duocuc.orderservice.service;

import cl.duocuc.orderservice.client.UserClient;
import cl.duocuc.orderservice.client.ProductClient;
import cl.duocuc.orderservice.client.InventoryClient;
import cl.duocuc.orderservice.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class OrderService {
    private static final List<Order> orders = new ArrayList<>();

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private InventoryClient inventoryClient;

    public List<Order> findAll() {
        return orders;
    }

    public Optional<Order> findById(String id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
    }

    public Optional<Order> create(Order order) {
        // Evitar duplicados
        if (findById(order.getId()).isPresent()) {
            return Optional.empty();
        }

        // Validar existencia
        /*if (!userClient.userExists(order.getUserId()) ||
                !productClient.allProductsExist(order.getProductId())) {
            return Optional.empty();
        }

        // Calcular total
        order.setTotal(productClient.calculateTotal(order.getProductId()));

        // Ajustar inventario
        for (String productId : order.getProductId()) {
            inventoryClient.adjustStock(productId, 1); // descuenta 1 unidad
        }*/

        orders.add(order);
        return Optional.of(order);
    }

    public boolean delete(String id) {
        return orders.removeIf(o -> o.getId().equals(id));
    }

    public Optional<Order> update(String id, Order updatedOrder) {
        return findById(id).map(order -> {
            order.setProductId(updatedOrder.getProductId());
            order.setTotal(updatedOrder.getTotal());
            order.setStatus(updatedOrder.getStatus());
            return order;
        });
    }
}
