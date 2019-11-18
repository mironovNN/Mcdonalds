package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.domain.sale.Check;

import java.util.Collection;
import java.util.Optional;

public interface CheckRepository {
    Check create(Check check);
    Collection<Check> getAll();
    Optional<Check> getById(int id);
    Check update(Check newCheck);
    boolean removeById(int id);
}
