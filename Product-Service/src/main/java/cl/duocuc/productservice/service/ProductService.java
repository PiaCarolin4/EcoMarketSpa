package cl.duocuc.productservice.service;

import cl.duocuc.productservice.model.Product;
import org.springframework.stereotype.Service; // ← IMPORTANTE

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Service // ← Habilita la inyección de este servicio
public class ProductService {

    private static List<Product> products = new ArrayList<>();

    static {
        products.addAll(
                List.of(
                        new Product("P001", "Cepillo de bambú", "Cepillo dental ecológico de bambú biodegradable", 1990),
                        new Product("P002", "Bolsas reutilizables", "Set de bolsas reutilizables para compras", 4990),
                        new Product("P003", "Botella de acero inoxidable", "Botella térmica reutilizable, 500 ml", 12990),
                        new Product("P004", "Shampoo sólido", "Shampoo ecológico en barra sin plásticos", 5990),
                        new Product("P005", "Desodorante natural", "Desodorante sin aluminio, biodegradable", 6490),
                        new Product("P006", "Pajillas de acero", "Set de 4 pajillas de acero inoxidable con cepillo", 3990),
                        new Product("P007", "Toallas de tela reutilizables", "Set de toallas sanitarias de algodón orgánico", 12990),
                        new Product("P008", "Detergente ecológico", "Detergente concentrado biodegradable", 8490),
                        new Product("P009", "Esponja vegetal", "Esponja natural de luffa para limpieza", 2490),
                        new Product("P010", "Jabón artesanal", "Jabón natural sin químicos ni envase plástico", 2990),
                        new Product("P011", "Compostera doméstica", "Mini compostera para residuos orgánicos", 34990),
                        new Product("P012", "Copa menstrual", "Alternativa ecológica a toallas y tampones", 15990),
                        new Product("P013", "Servilletas de tela", "Pack de 6 servilletas reutilizables", 7990),
                        new Product("P014", "Cepillo para verduras", "Cepillo de madera con fibras naturales", 3490),
                        new Product("P015", "Vasos de bambú", "Set de 4 vasos biodegradables", 8990),
                        new Product("P016", "Cera para envolver alimentos", "Paños de algodón con cera de abeja", 11990),
                        new Product("P017", "Café orgánico", "Café molido certificado 100% orgánico", 7490),
                        new Product("P018", "Aceite de coco natural", "Aceite de coco virgen sin refinar", 5990),
                        new Product("P019", "Papel reciclado", "Bloc de notas hecho con papel reciclado", 1990),
                        new Product("P020", "Tetera solar", "Tetera portátil que calienta con energía solar", 49990),
                        new Product("P021", "Bolsas compostables", "Bolsa de basura 100% compostable", 4590),
                        new Product("P022", "Ropa de algodón orgánico", "Camiseta sin químicos ni pesticidas", 13990),
                        new Product("P023", "Filtros de café reutilizables", "Filtros de tela lavables", 3490),
                        new Product("P024", "Fiambrera de vidrio", "Contenedor de vidrio con tapa de bambú", 10990),
                        new Product("P025", "Cargador solar", "Cargador USB alimentado por energía solar", 19990),
                        new Product("P026", "Crema natural", "Crema hidratante vegana sin plástico", 6490),
                        new Product("P027", "Kit de afeitado ecológico", "Navaja de acero y brocha de bambú", 21990),
                        new Product("P028", "Bicicleta de bambú", "Bicicleta artesanal con marco de bambú", 389990),
                        new Product("P029", "Macetas biodegradables", "Set de macetas hechas de fibras vegetales", 5990),
                        new Product("P030", "Lámpara solar de jardín", "Luz decorativa alimentada por energía solar", 10490),
                        new Product("P031", "Cubiertos de bambú", "Set reutilizable de tenedor, cuchillo y cuchara", 3790),
                        new Product("P032", "Filtro de agua portátil", "Filtro ecológico para agua en exteriores", 18990),
                        new Product("P033", "Bolsa térmica reciclada", "Bolso térmico hecho de materiales reciclados", 13990),
                        new Product("P034", "Té orgánico", "Infusión de hierbas cultivadas sin pesticidas", 3990),
                        new Product("P035", "Sillas de cartón reciclado", "Silla ligera y resistente hecha de cartón", 29990),
                        new Product("P036", "Velas de soya", "Velas ecológicas sin parafina", 5490),
                        new Product("P037", "Papel higiénico reciclado", "Papel suave, 100% reciclado", 3490),
                        new Product("P038", "Juguetes de madera", "Set de bloques educativos de madera", 12990),
                        new Product("P039", "Funda de celular biodegradable", "Carcasa hecha de materiales compostables", 7990),
                        new Product("P040", "Bolso de corcho", "Bolso vegano hecho de corcho natural", 27990),
                        new Product("P041", "Almohada ecológica", "Rellena con fibras recicladas y funda orgánica", 18990),
                        new Product("P042", "Champú vegano sin sulfatos", "Hecho con ingredientes naturales", 5990),
                        new Product("P043", "Incienso natural", "Incienso sin químicos artificiales", 2590),
                        new Product("P044", "Jabón para ropa ecológico", "Sin fosfatos ni fragancias artificiales", 7290),
                        new Product("P045", "Cubo de reciclaje doméstico", "Contenedor de separación de residuos", 16990),
                        new Product("P046", "Comida para mascotas orgánica", "Alimento sin aditivos ni químicos", 11990),
                        new Product("P047", "Bolsa para pan de lino", "Bolsa reutilizable de lino natural", 4890),
                        new Product("P048", "Camiseta de cáñamo", "Ropa hecha con fibra de cáñamo ecológico", 14990),
                        new Product("P049", "Papel de regalo reciclado", "Diseños coloridos impresos en papel reciclado", 1990),
                        new Product("P050", "Guantes de jardinería reciclados", "Fabricados con plástico recuperado", 4990)
                )
        );
    }

    public static List<Product> findAll() {
        return products;
    }

    // ✅ Métodos agregados para CRUD completo

    public static Product findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static boolean addProduct(Product product) {
        if (findById(product.getId()) != null) {
            return false; // Ya existe
        }
        return products.add(product);
    }

    public static boolean updateProduct(String id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public static boolean removeProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
