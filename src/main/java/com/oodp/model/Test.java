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
        notifyFlight("Take-off approved", f);
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
    private AirTrafficController airTrafficController;

    public String getNumber() {
        return number;
    }

    public void requestTakeoff() {
        airTrafficController.requestTakeOff(this);
    }

    public void requestLanding() {
        airTrafficController.requestLanding(this);
    }

    public abstract void receiveMessage(String message);
}

class FlightA extends Flight {
    public FlightA(String number, AirTrafficController airTrafficController) {

    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(getNumber() + " new message: " + message);
    }
}

class FlightB extends Flight {
    public FlightB(String number, AirTrafficController airTrafficController) {

    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(getNumber() + " new message: " + message);

    }
}

public class Test {
}
