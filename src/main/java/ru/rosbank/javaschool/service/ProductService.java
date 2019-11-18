package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.domain.dto.AbstractProductDto;
import ru.rosbank.javaschool.domain.dto.ProductDto;
import ru.rosbank.javaschool.domain.model.AbstractProduct;
import ru.rosbank.javaschool.domain.sale.Check;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.exception.NotFoundException;
import ru.rosbank.javaschool.repository.CheckRepository;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ProductService implements ProductServiceInterface {
    private final ProductRepository productRepository;
    private final CheckRepository checkRepository;

    public ProductService(ProductRepository productRepository, CheckRepository checkRepository) {
        this.productRepository = productRepository;
        this.checkRepository = checkRepository;
    }

    @Override
    public AbstractProduct saveProduct(AbstractProductDto dto) {
        if(dto.getId() < 0){
            throw new InvalidDataException("Id incorrect");
        }
        if(dto.getId() == 0){
            return productRepository.create(dto.toModel());
        }
        return productRepository.update(dto.toModel());
    }

    @Override
    public Check saveCheck(Check check) {
        if(check.getId() < 0){
            throw new InvalidDataException("Id incorrect");
        }
        if(check.getId() == 0){
            return checkRepository.create(check);
        }
        return checkRepository.update(check);
    }

    @Override
    public Collection<ProductDto> searchProduct(String product) {
        return productRepository.getAll().stream()
                .filter(o -> o.getName().contains(product))
                .map(ProductDto :: from)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ProductDto> getProductCategory(String category) {
        return productRepository.getAll().stream()
                .filter(o -> o.getClass().getSimpleName().contains(category))
                .map(ProductDto :: from)
                .collect(Collectors.toList());
    }

    @Override
    public AbstractProductDto getProductById(int id) {
        return productRepository.getById(id)
                .map(AbstractProduct::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Check getCheckById(int id) {
        return checkRepository.getById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Collection<ProductDto> getAllProduct() {
        return productRepository.getAll().stream()
                .map(ProductDto :: from)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Check> getAllCheck() {
        return checkRepository.getAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeProductById(int id) {
        boolean remove = productRepository.removeById(id);
        if(!remove){
            throw new NotFoundException("Not found product");
        }
        return true;
    }

    @Override
    public boolean removeCheckById(int id) {
        boolean remove = checkRepository.removeById(id);
        if(!remove){
            throw new NotFoundException("Not found check");
        }
        return true;
    }

}
