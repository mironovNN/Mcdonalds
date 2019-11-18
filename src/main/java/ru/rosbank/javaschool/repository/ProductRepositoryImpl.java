package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.domain.model.AbstractProduct;
import ru.rosbank.javaschool.exception.DataSaveException;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;


public class ProductRepositoryImpl implements ProductRepository {
    private final Collection<AbstractProduct> products = new LinkedList<>();
    private int nextId = 1;

    @Override
    public AbstractProduct create(AbstractProduct product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    @Override
    public Collection<AbstractProduct> getAll(){
        return Collections.unmodifiableCollection(products);
    }

    @Override
    public Optional<AbstractProduct> getById(int id){
        return products.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    @Override
    public AbstractProduct update(AbstractProduct product){
        for (AbstractProduct newProduct : products) {
            if (newProduct.getId() == product.getId()){
                newProduct.setName(product.getName());
                newProduct.setPrice(product.getPrice());
                newProduct.setDescription(product.getDescription());
                return product;
            }

        }
        throw new DataSaveException("Product id " + product.getId() + " not found");
    }

    @Override
    public boolean removeById(int id){
        return products.removeIf(o -> o.getId() == id);
    }

}
