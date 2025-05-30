package cl.duocuc.productservice.controller;

import cl.duocuc.productservice.controller.response.MessageResponse;
import cl.duocuc.productservice.model.Product;
import cl.duocuc.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // Constructor con inyección
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(ProductService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = ProductService.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createProduct(@RequestBody Product request) {
        boolean added = ProductService.addProduct(request);
        if (!added) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("Error: Producto ya existe"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Producto creado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteProduct(@PathVariable String id) {
        boolean removed = ProductService.removeProduct(id);
        if (removed) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("Producto eliminado"));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> replaceProduct(@PathVariable String id, @RequestBody Product request) {
        boolean updated = ProductService.updateProduct(id, request);
        if (updated) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Producto actualizado"));
        }
        return ResponseEntity.notFound().build();
    }
}

