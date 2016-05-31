
package com.main.marsh;

public class CheckHandler implements IHandler{

    @Override
    public void Handle(IObject object) {
        throw new ChannelException("Checked"); 
    }
    
}
