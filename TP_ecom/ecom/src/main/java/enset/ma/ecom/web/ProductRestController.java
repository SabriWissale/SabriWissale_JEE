package enset.ma.ecom.web;

import enset.ma.ecom.dtos.ProductDTO;
import enset.ma.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<ProductDTO> productList(){
        return productService.lisProducts();
    }


    @GetMapping("/products/{id}")
    public  ProductDTO getProduct(@PathVariable(name="id") String id){
        return productService.getProduct(id);
    }


    @PostMapping("/products")
    public  ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public  ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable String id){
        productDTO.setId(id);
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id){
         productService.deleteProduct(id);
    }
}
