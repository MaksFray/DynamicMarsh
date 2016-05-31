package com.main.marsh;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Router {

    Map<String, Object> map = new HashMap<>();
    private Controller controll = new Controller();

    public Router(Map map) {
        try {
            this.map = controll.changeMap(map);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NullPointerException ex) {
           //throw new ChannelException(ex);
        }
        this.map.put("subscribe", new SubscribeHandler(this));
        this.map.put("unsubscribe", new UnsubscribeHandler(this));
    }

    public void control(IObject object) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IHandler h = findHandler(object);
        h.Handle(object);
    }

    public void subscribe(String key, String value) {
        try {
            map.put(key, controll.changeIntoClass(value));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new ChannelException(ex);
        }
    }

    public void unsubscribe(String key) {
        map.remove(key);
    }

    public IHandler findHandler(IObject object) {
        IHandler h = (IHandler) map.getOrDefault((String) object.getValue("target"), new CancelledHandler());
        return h;
    }
}
