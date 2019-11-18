package ru.rosbank.javaschool.domain.sale;

import lombok.AllArgsConstructor;

import lombok.Data;
import ru.rosbank.javaschool.domain.model.AbstractProduct;

@Data
@AllArgsConstructor
public class Sale {
    private int productId;
    private String productName;
    private int number;
    private int price;

    public Sale(AbstractProduct product, int number){
        productId = product.getId();
        productName = product.getName();
        this.number = number;
        this.price = product.getPrice();

    }

}
