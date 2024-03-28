package br.com.learningjpa.model;

import br.com.learningjpa.enums.ProductStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity
{
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum status;
}
