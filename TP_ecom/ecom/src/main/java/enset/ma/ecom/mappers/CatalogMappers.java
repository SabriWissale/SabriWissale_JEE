package enset.ma.ecom.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import enset.ma.ecom.dtos.CategoryDTO;
import enset.ma.ecom.dtos.ProductDTO;
import enset.ma.ecom.entities.Category;
import enset.ma.ecom.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



@Service
public class CatalogMappers {
    public ProductDTO fromProduct(Product product){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        productDTO.setCategoryDTO(fromCategory(product.getCategory()));
        return productDTO;
    }
    public Product fromProdcutDTO(ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setCategory((fromCategoryDTO(productDTO.getCategoryDTO())));
        return product;
    }

    public CategoryDTO fromCategory(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category,categoryDTO);
        return categoryDTO;
    }

    public Category fromCategoryDTO(CategoryDTO categoryDTO){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        return category;
    }
}
