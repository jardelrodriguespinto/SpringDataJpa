package br.com.learningjpa.model;

import br.com.learningjpa.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_header")
@AttributeOverrides({
        @AttributeOverride(
                name = "shippingAddress.address",
                column = @Column(name = "shipping_address")
        ),
        @AttributeOverride(
                name = "shippingAddress.city",
                column = @Column(name = "shipping_city")
        ),
        @AttributeOverride(
                name = "shippingAddress.state",
                column = @Column(name = "shipping_state")
        ),
        @AttributeOverride(
                name = "shippingAddress.zipCode",
                column = @Column(name = "shipping_zip_code")
        ),
        @AttributeOverride(
                name = "billToAddress.address",
                column = @Column(name = "bill_to_address")
        ),
        @AttributeOverride(
                name = "billToAddress.city",
                column = @Column(name = "bill_to_city")
        ),
        @AttributeOverride(
                name = "billToAddress.state",
                column = @Column(name = "bill_to_state")
        ),
        @AttributeOverride(
                name = "billToAddress.zipCode",
                column = @Column(name = "bill_to_zip_code")
        )
    })
public class OrderHeader extends BaseEntity
{
    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billToAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    @OneToMany(mappedBy = "orderHeader", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<OrderLine> orderLines;
    @ManyToOne
    private Customer customer;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private OrderApproval orderApproval;

    public void addOrderLine(OrderLine orderLine)
    {
        if (orderLines == null)
            orderLines = new HashSet<>();

        orderLines.add(orderLine);
        orderLine.setOrderHeader(this);
    }
}
