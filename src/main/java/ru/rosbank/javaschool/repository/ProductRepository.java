package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.domain.model.AbstractProduct;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {
    AbstractProduct create(AbstractProduct product);
    Collection<AbstractProduct> getAll();
    Optional<AbstractProduct> getById(int id);
    AbstractProduct update(AbstractProduct product);
    boolean removeById(int id);
}
