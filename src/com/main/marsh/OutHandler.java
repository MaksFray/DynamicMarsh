package com.main.marsh;


public class OutHandler implements IHandler{

    @Override
    public void Handle(IObject object) {
        System.out.println((String)object.getValue("body"));
    }
    
}
