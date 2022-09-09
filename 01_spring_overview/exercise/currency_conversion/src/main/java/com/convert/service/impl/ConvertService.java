package com.convert.service.impl;

import com.convert.service.IConvert;
import org.springframework.stereotype.Service;

@Service
public class Convert implements IConvert {
    @Override
    public Double money(Double usd) {

        return usd * 23000;
    }
}
