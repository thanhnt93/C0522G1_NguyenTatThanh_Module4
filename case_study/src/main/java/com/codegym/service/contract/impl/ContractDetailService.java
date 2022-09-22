package com.codegym.service.contract.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.IContractDetailRepository;
import com.codegym.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> getContractDetail(int id) {
        return contractDetailRepository.getContractDetail(id);
    }

    @Override
    public void remove(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }
}
