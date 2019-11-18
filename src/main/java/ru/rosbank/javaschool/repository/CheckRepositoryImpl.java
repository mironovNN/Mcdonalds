package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.domain.sale.Check;
import ru.rosbank.javaschool.exception.DataSaveException;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

public class CheckRepositoryImpl implements CheckRepository {
    private final Collection<Check> checks = new LinkedList<>();
    private int nextId = 1;

    @Override
    public Check create(Check check){
        check.setId(nextId++);
        checks.add(check);
        return check;
    }

    @Override
    public Collection<Check> getAll(){
        return Collections.unmodifiableCollection(checks);
    }

    @Override
    public Optional<Check> getById(int id){
        return checks.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    @Override
    public Check update(Check newCheck){
        for (Check check : checks) {
            if(check.getId() == newCheck.getId()){
                check = Check.copy(newCheck);
                return check;
            }

        }
        throw new DataSaveException("Check id " + newCheck.getId() + " not found");
    }

    @Override
    public boolean removeById(int id){
        return checks.removeIf(o -> o.getId() == id);
    }
}
