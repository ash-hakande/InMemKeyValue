package com.company.Services;

import com.company.Dao.InMemKeyValueStoreImpl;
import com.company.Dao.KeyValueStore;
import com.company.Models.Pair;
import java.util.List;

public class KeyValueServiceImpl implements KeyValueService{

    KeyValueStore keyValueStore = new InMemKeyValueStoreImpl();

    @Override
    public Object get(String key) {
        return keyValueStore.get(key);
    }

    @Override
    public List<String> search(String attributeKey, String attributeValue) {
        return keyValueStore.search(attributeKey, attributeValue);
    }

    @Override
    public Boolean put(String key, List<Pair<String, String>> listOfAttributePairs) {
        return keyValueStore.put(key, listOfAttributePairs);
    }

    @Override
    public Boolean delete(String key) {
        return keyValueStore.delete(key);
    }

    @Override
    public List<String> keys() {
       return keyValueStore.keys();
    }
}
