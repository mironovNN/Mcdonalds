package ru.rosbank.javaschool.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.rosbank.javaschool.domain.model.AbstractProduct;

@Data
@AllArgsConstructor
public abstract class AbstractProductDto {
    private int id;
    private String name;
    private int price;
    private String description;

    public abstract AbstractProduct toModel();
}
