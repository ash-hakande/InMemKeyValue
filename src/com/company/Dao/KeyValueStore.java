package com.company.Dao;

import java.util.List;
import com.company.Models.*;

public interface KeyValueStore {

    Object get(String key);

    List<String> search(String attributeKey, String attributeValue);

    Boolean put(String key, List<Pair<String, String>> listOfAttributePairs);

    Boolean delete(String key);

    List<String> keys();

}
