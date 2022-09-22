package com.codegym.service.contract;

import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    List<ContractDetail> getContractDetail(int id);


    void remove(ContractDetail contractDetail);
}
