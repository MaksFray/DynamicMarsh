package com.main.marsh;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    public Map <String, Object> changeMap(Map<String, String> map) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Map<String, Object> changemap = new HashMap<>();
        for (String key : map.keySet()) {
            Class bb = Class.forName(map.get(key));
            Object obj = bb.newInstance();
            changemap.put(key, obj);
        }
        return changemap;
    }

    public Object changeIntoClass(String value) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class bb = Class.forName(value);
        Object obj = bb.newInstance();
        return obj;
    }
}
