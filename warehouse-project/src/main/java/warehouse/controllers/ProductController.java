package warehouse.controllers;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import warehouse.entities.WarehouseProduct;
import warehouse.exceptions.GarmentNotFoundException;
import warehouse.services.ProductService;

import java.util.List;

@Slf4j
@RestController
@Transactional
@RequestMapping("/warehouse")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*@GetMapping
    public ResponseEntity<Page<WarehouseProduct>> getProducts(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<WarehouseProduct> products = productService.getAll(name, page, pageSize);
        return ResponseEntity.ok(products);
    }*/

    @GetMapping("/availability")
    public ResponseEntity<List<WarehouseProduct>> getAvailableProductsInWarehouse() {
        List<WarehouseProduct> products = productService.getAvailableProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<WarehouseProduct>> all() {
        List<WarehouseProduct> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/page")
    List<WarehouseProduct> allPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {

        Page<WarehouseProduct> garments = productService.getAllProductsPage(page, pageSize);
        return garments.getContent();
    }


    @PostMapping("/garments")
    WarehouseProduct newGarment(@RequestBody WarehouseProduct newGarment) {
        try {
            return productService.createProduct(newGarment);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @GetMapping("/garments/{id}")
    WarehouseProduct one(@PathVariable Long id) {

        return productService.getGarment(id)
                .orElseThrow(() -> new GarmentNotFoundException(id));
    }

    /*@PutMapping("/garments/{id}")
    WarehouseProduct replaceGarment(@RequestBody WarehouseProductDTO newGarment, @PathVariable Long id) {
        return productService.updateProduct(id, newGarment);
    }*/

    @DeleteMapping("/garments/{id}")
    void deleteGarment(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
