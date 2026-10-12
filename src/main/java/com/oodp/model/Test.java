package com.oodp.model;

interface AirTrafficController{
    public void requestTakeOff(Flight f);
    public  void requestLanding(Flight f);
    public abstract void requestFlight(String message,Flight f);
}




abstract class Flight{
    private String number;

    public String getNumber() {
        return number;
    }
    public void requestTakeoff(){

    }

    public  void requestLanding(){

    }

    public abstract void requestFlight(String message);
}




public class Test {
}
