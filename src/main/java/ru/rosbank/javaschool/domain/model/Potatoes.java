package ru.rosbank.javaschool.domain.model;

import lombok.Data;
import ru.rosbank.javaschool.domain.dto.PotatoesDto;

@Data
public class Potatoes extends AbstractProduct {
    private String size;

    public Potatoes(int id, String name, int price, String description, String size) {
        super(id, name, price, description);
        this.size = size;
    }

    @Override
    public PotatoesDto toDto() {
        return new PotatoesDto(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getSize()
        );
    }

}

