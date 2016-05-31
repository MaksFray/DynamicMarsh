package com.main.marsh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/com/main/marsh/config.properties");
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        
        Router r = new Router(property);
        IObject obj = new MessageObject();
        obj.setValue("body", "controlsubscribe");
        obj.setValue("target", "reverse");
        r.control(obj);
        
    }

}
