package br.com.learningjpa.model;

import br.com.learningjpa.enums.ProductStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    @OneToMany(mappedBy = "product")
    private Set<OrderLine> orderLines;
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Category> categories;

}
