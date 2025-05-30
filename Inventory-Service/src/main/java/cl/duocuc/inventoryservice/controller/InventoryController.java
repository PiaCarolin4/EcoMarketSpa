package cl.duocuc.inventoryservice.controller;

import cl.duocuc.inventoryservice.model.Inventory;
import cl.duocuc.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Inventory>> getByProductId(@PathVariable String productId) {
        return ResponseEntity.ok(service.findByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@RequestBody Inventory inventory) {
        return service.create(inventory)
                .map(i -> ResponseEntity.status(201).body(i))
                .orElse(ResponseEntity.status(409).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(@PathVariable String id, @RequestBody Inventory updated) {
        return service.update(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/adjust")
    public ResponseEntity<Inventory> adjustQuantity(@PathVariable String id, @RequestParam int delta) {
        return service.adjustQuantity(id, delta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
