package ru.rosbank.javaschool.domain.dto;

import lombok.Data;
import ru.rosbank.javaschool.domain.model.Burger;

@Data
public class BurgerDto extends AbstractProductDto {
    private String cutlet;

    public BurgerDto(int id, String name, int price, String description, String cutlet){
        super(id, name, price, description);
        this.cutlet = cutlet;
    }

    @Override
    public Burger toModel(){
        return new Burger(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getCutlet()
        );
    }
}
