package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.domain.dto.AbstractProductDto;
import ru.rosbank.javaschool.domain.dto.ProductDto;
import ru.rosbank.javaschool.domain.model.AbstractProduct;
import ru.rosbank.javaschool.domain.sale.Check;

import java.util.Collection;

public interface ProductServiceInterface {
    AbstractProduct saveProduct(AbstractProductDto dto);
    Check saveCheck(Check check);
    Collection<ProductDto> searchProduct(String product);
    Collection<ProductDto> getProductCategory(String category);
    AbstractProductDto getProductById(int id);
    Check getCheckById(int id);
    Collection<ProductDto> getAllProduct();
    Collection<Check> getAllCheck();
    boolean removeProductById(int id);
    boolean removeCheckById(int id);
}
