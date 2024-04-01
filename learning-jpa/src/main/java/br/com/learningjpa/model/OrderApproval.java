package br.com.learningjpa.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderApproval extends BaseEntity
{
    private String approvedBy;
}
