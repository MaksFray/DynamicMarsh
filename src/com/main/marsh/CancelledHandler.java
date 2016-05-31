package com.main.marsh;

public class CancelledHandler implements IHandler {

    @Override
    public void Handle(IObject object) {
        throw new ChannelException("Invslid Message" + object.getValue("body"));
    }
}
