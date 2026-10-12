package com.oodp.model;

interface AirTrafficController {
    public void requestTakeOff(Flight f);

    public void requestLanding(Flight f);

    public abstract void notifyFlight(String message, Flight f);
}


class AirportControllerTower implements AirTrafficController {

    @Override
    public void requestTakeOff(Flight f) {
        System.out.println("Flight : " + f.getNumber() + "request permission to take off");
    }

    @Override
    public void requestLanding(Flight f) {
        System.out.println("Flight : " + f.getNumber() + "request permission to landing");

    }

    @Override
    public void notifyFlight(String message, Flight f) {
        f.receiveMessage(message);
    }
}

abstract class Flight {
    private String number;

    public String getNumber() {
        return number;
    }

    public void requestTakeoff() {

    }

    public void requestLanding() {

    }

    public abstract void receiveMessage(String message);
}


public class Test {
}
