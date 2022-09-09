package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private Map<String, String> mapDictionary = new HashMap<>();

    @Override
    public String translate(String english) {
        {
            mapDictionary.put("hello", "xin chào");
            mapDictionary.put("world","thế giới");
            mapDictionary.put("bear","con gấu");
            mapDictionary.put("street","con đường");
            mapDictionary.put("bean","hạt đậu");
        }
        return mapDictionary.get(english);
    }
}
