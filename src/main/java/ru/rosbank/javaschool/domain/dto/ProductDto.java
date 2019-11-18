package ru.rosbank.javaschool.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.rosbank.javaschool.domain.model.AbstractProduct;

@Data
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private int price;

    public static ProductDto from(AbstractProduct model){
        return new ProductDto(
                model.getId(),
                model.getName(),
                model.getPrice()
        );
    }
}
