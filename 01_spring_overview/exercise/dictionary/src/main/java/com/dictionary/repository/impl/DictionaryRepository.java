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
        }
        return mapDictionary.get(english);
    }
}
