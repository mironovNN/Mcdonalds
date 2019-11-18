package ru.rosbank.javaschool.domain.model;

import lombok.Data;
import ru.rosbank.javaschool.domain.dto.DrinkDto;

@Data
public class Drink extends AbstractProduct {
    private String volume;

    public Drink(int id, String name, int price, String description, String volume) {
        super(id, name, price, description);
        this.volume = volume;
    }

    @Override
    public DrinkDto toDto() {
        return new DrinkDto(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getVolume()
        );
    }

}
