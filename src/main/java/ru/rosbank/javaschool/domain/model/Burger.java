package ru.rosbank.javaschool.domain.model;

import lombok.Data;
import ru.rosbank.javaschool.domain.dto.BurgerDto;

@Data
public class Burger extends AbstractProduct {
    private String cutlet;

    public Burger(int id, String name, int price, String description, String cutlet) {
        super(id, name, price, description);
        this.cutlet = cutlet;
    }

    @Override
    public BurgerDto toDto() {
        return new BurgerDto(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getCutlet()
        );
    }
}
