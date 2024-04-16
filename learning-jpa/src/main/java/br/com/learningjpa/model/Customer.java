package br.com.learningjpa.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(
            name = "address.address",
            column = @Column(name = "customer_address")
    ),
    @AttributeOverride(
            name = "address.city",
            column = @Column(name = "customer_city")
    ),
    @AttributeOverride(
            name = "address.state",
            column = @Column(name = "customer_state")
    ),
    @AttributeOverride(
            name = "address.zipCode",
            column = @Column(name = "customer_zip_code")
    )
})
public class Customer extends BaseEntity
{
    @Length(max = 100)
    private String name;
    @Valid
    @Embedded
    private Address address;
    private String email;
    @Length(max = 50)
    @Length(max = 255)
    private String phone;
    @Version
    private Integer version;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderHeader> orderHeaders = new HashSet<>();
}
