package ru.rosbank.javaschool.domain.dto;

import lombok.Data;
import ru.rosbank.javaschool.domain.model.Drink;

@Data
public class DrinkDto extends AbstractProductDto {
    private String volume;

    public DrinkDto(int id, String name, int price, String description, String volume){
        super(id, name, price, description);
        this.volume = volume;
    }

    @Override
    public Drink toModel(){
        return new Drink(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getVolume()

        );
    }
}
