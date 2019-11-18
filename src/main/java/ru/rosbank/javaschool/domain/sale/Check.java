package ru.rosbank.javaschool.domain.sale;

import lombok.Data;

import java.util.List;

@Data
public class Check {
    private final List<Sale> sales;
    private int id;

    public Check(int id, List<Sale> sales){
        this.sales = sales;
        this.id = id;
    }

    public static Check copy(Check check){
        return new Check(check.getId(), check.getSales());
    }
    public void Add(Sale sale){
        sales.add(sale);
    }

}
