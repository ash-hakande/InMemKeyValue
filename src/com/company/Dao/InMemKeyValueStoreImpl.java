package com.company.Dao;

import java.util.*;
import com.company.Models.*;

public class InMemKeyValueStoreImpl implements  KeyValueStore{

    static Map<String, Value> keyValueStore = new HashMap<>();

    @Override
    public Object get(String key) {
        if(this.keyValueStore.containsKey(key))
            return this.keyValueStore.get(key);
        return null;
    }

    @Override
    public List<String> search(String attributeKey, String attributeValue) {

        List<String> keyList = new ArrayList<>();
        for(String key : keyValueStore.keySet())
        {
            AttributeValueImpl<String> value = new AttributeValueImpl();
            value.setValue(attributeValue);
            if( ((ValueImpl)keyValueStore.get(key)).search(attributeKey,value)) {
                keyList.add(key);
            }
        }
        return keyList;
    }

    @Override
    public Boolean put(String key, List<Pair<String, String>> listOfAttributePairs) {
           if (keyValueStore.containsKey(key)) {
               for (Pair p : listOfAttributePairs) {
                   AttributeValueImpl<String> attributeValue = new AttributeValueImpl();
                   attributeValue.setValue((String)p.getItem2());
                   ((ValueImpl) keyValueStore.get(key)).put((String) p.getItem1(), attributeValue);
               }
           }
           else
           {
               ValueImpl value = new ValueImpl();
               for(Pair p : listOfAttributePairs)
               {
                   AttributeValueImpl<String> attributeValue = new AttributeValueImpl();
                   attributeValue.setValue((String)p.getItem2());
                   value.put((String) p.getItem1(),attributeValue);
               }
               synchronized (this) {
                   keyValueStore.put(key, value);
               }
           }
        return true;
    }

    @Override
    public Boolean delete(String key) {
        if(keyValueStore.containsKey(key))
        {
            keyValueStore.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public List<String> keys() {
        List<String> list = new ArrayList<>();
        for(String key : keyValueStore.keySet())
        {
            list.add(key + ": " + keyValueStore.get(key).toString());
        }
        return list;
    }
}
