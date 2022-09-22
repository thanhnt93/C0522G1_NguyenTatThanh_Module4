package com.codegym.model.contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double cost;
    private String unit;
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    Set <ContractDetail> contractDetail;

    public AttachFacility() {
    }

    public AttachFacility(int id, String name, Double cost, String unit, String status, Set<ContractDetail> contractDetail) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetail = contractDetail;
    }
}
