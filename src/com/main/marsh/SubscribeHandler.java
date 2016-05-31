package com.main.marsh;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscribeHandler implements IHandler {

    private Router rout;

    public SubscribeHandler(Router rout) {
        this.rout = rout;
    }

    @Override
    public void Handle(IObject object) {
        rout.subscribe((String) object.getValue("channel"), (String) object.getValue("handler"));
        Logger log = Logger.getLogger(SubscribeHandler.class.getName());
        log.log(Level.INFO, (String) object.getValue("body")+" added channel: "+(String) object.getValue("channel"));
    }

}
