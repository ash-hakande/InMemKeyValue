package com.company.Models;

import java.util.HashMap;
import java.util.Map;

public class ValueImpl implements Value{

    Map<String, AttributeValue> attributeValueMap = new HashMap<>();

    public boolean put(String attributeKey, AttributeValue value)
    {
        if(attributeValueMap.containsKey(attributeKey))
        {
            AttributeValue attributeValue =(AttributeValueImpl) attributeValueMap.get(attributeKey);
            if(((AttributeValueImpl)value).compareType(attributeValue))
            {
                synchronized (this) {
                    attributeValueMap.put(attributeKey, value);
                    return true;
                }
            }
            return false;
        }
        else
        {
            synchronized (this)
            {
                attributeValueMap.put(attributeKey, value);
                return true;
            }
        }
    }

    public Map<String, AttributeValue> getAttributeValueMap()
    {
        return this.attributeValueMap;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for(String key : attributeValueMap.keySet())
        {
            builder.append(key).append(" : ").append(attributeValueMap.get(key)).append(", ");
        }
        return builder.toString();
    }

    public boolean search(String attributeKey, AttributeValue attributeValue)
    {
        for(String key : attributeValueMap.keySet())
        {
            if(key.equals(attributeKey)&& attributeValueMap.get(key).equals(attributeValue))
                return true;
        }
        return false;
    }
}
