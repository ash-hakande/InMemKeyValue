package com.company.Services;

import com.company.Models.Pair;
import java.util.List;

public interface KeyValueService {
    Object get(String key);

    List<String> search(String attributeKey, String attributeValue);

    Boolean put(String key, List<Pair<String, String>> listOfAttributePairs);

    Boolean delete(String key);

    List<String> keys();
}
