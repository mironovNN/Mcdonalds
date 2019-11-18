package ru.rosbank.javaschool.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.rosbank.javaschool.domain.dto.AbstractProductDto;


@Data
@AllArgsConstructor
public abstract class AbstractProduct {

    private int id;
    private String name;
    private int price;
    private String description;

    public abstract AbstractProductDto toDto();

}
