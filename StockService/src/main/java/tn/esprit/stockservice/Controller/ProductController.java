package tn.esprit.stockservice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.stockservice.Entity.Product;
import tn.esprit.stockservice.Interface.IProductService;
import tn.esprit.stockservice.Mapper.ProductMapper;
import tn.esprit.stockservice.dto.ProductDto;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/stock")
public class ProductController {
    IProductService productService;
    @PostMapping()
    public ProductDto addProduct(ProductDto productDto) {
        final Product product = ProductMapper.mapToEntity(productDto);
        return ProductMapper.mapToDto(productService.addProduct(product));
    }
    @GetMapping
    public Set<ProductDto> getAllProduct(){
        final Set<Product> productSet = productService.getAllProduct();
        return productSet.stream().map(p -> ProductMapper.mapToDto(p)).collect(Collectors.toSet());
    }
}
