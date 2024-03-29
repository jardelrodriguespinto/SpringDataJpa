package br.com.learningjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;
    @Embedded
    private Address address;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderHeader> orderHeaders;
}
