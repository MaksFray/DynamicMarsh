package com.main.marsh;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class tester {
    static Properties property= new Properties();
    
    
    public tester() {
    }

    @BeforeClass
    public static void setUpClass() {
        FileInputStream fis;
        String channel = "";
        String way = "";
        try {
            fis = new FileInputStream("src/com/main/marsh/config.properties");
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testControl() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Router r = new Router(property);
        IObject obj = new MessageObject();
        obj.setValue("body", "controlsubscribe");
        obj.setValue("target", "subscribe");
        obj.setValue("channel", "mew");
        obj.setValue("handler", "com.main.marsh.CheckHandler");
        r.control(obj);
        obj.setValue("body", "controlunsubscribe");
        obj.setValue("target", "unsubscribe");
        r.control(obj);
        obj.setValue("body", "controlsubscribe");
        obj.setValue("target", "subscribe");
        r.control(obj);
        assertEquals(r.map.containsKey("mew"), true);
    }

}
