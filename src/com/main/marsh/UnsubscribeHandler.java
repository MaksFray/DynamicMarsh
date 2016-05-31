
package com.main.marsh;

import java.util.logging.Level;
import java.util.logging.Logger;


public class UnsubscribeHandler implements IHandler{

    private Router rout;
    
    public UnsubscribeHandler(Router rout)
    {
        this.rout=rout;
    }
    
    @Override
    public void Handle(IObject object) {
        rout.unsubscribe((String) object.getValue("channel"));
        Logger log = Logger.getLogger(UnsubscribeHandler.class.getName());
        log.log(Level.INFO, (String) object.getValue("body")+" deleted channel: "+ (String) object.getValue("channel"));
    }
    
}
