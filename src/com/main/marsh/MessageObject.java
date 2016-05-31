package com.main.marsh;

import java.util.HashMap;
import java.util.Map;


public class MessageObject implements IObject{
    
    private Map<String, Object> hm = new HashMap<String, Object>();

    @Override
    public Object getValue(String key) {
        Object value = hm.get(key);
        return value;
    }

    @Override
    public void setValue(String key, Object value) {
     hm.put(key, value);   
    }
    
}
