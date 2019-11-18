package ru.rosbank.javaschool.domain.dto;

import lombok.Data;
import ru.rosbank.javaschool.domain.model.Potatoes;

@Data
public class PotatoesDto extends AbstractProductDto {
    private String size;

    public PotatoesDto(int id, String name, int price, String description, String size){
        super(id, name, price, description);
        this.size = size;
    }

    @Override
    public Potatoes toModel(){
        return new Potatoes(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getSize()
        );
    }

}
