package com.convert.service.impl;

import com.convert.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {

    @Override
    public Double money(Double usd) {
        return usd * 23000;
    }
}
