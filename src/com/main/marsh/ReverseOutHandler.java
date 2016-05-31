package com.main.marsh;


public class ReverseOutHandler implements IHandler {

    @Override
    public void Handle(IObject object) {
        String b = new StringBuffer((String)object.getValue("body")).reverse().toString();
        System.out.println(b);
    }
    
}
