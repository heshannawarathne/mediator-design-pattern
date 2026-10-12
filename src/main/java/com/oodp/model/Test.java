package com.oodp.model;

interface AirTrafficController {
    public void requestTakeOff(Flight f);

    public void requestLanding(Flight f);

    public abstract void notifyFlight(String message, Flight f);
}

class AirportControllerTower implements AirTrafficController {

    @Override
    public void requestTakeOff(Flight f) {
        System.out.println("Flight : " + f.getNumber() + " request permission to take off");
        notifyFlight("Take-off approved", f);
    }

    @Override
    public void requestLanding(Flight f) {
        System.out.println("Flight : " + f.getNumber() + " request permission to land");
        notifyFlight("Landing approved", f);
    }

    @Override
    public void notifyFlight(String message, Flight f) {
        f.receiveMessage(message);
    }
}

abstract class Flight {
    private String number;
    private AirTrafficController airTrafficController;

    // Added constructor to initialize fields
    public Flight(String number, AirTrafficController airTrafficController) {
        this.number = number;
        this.airTrafficController = airTrafficController;
    }

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
    public FlightA(AirTrafficController airTrafficController, String number) {
        super(number, airTrafficController);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(getNumber() + " new message: " + message);
    }
}

class FlightB extends Flight {
    public FlightB(AirTrafficController airTrafficController, String number) {
        super(number, airTrafficController);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(getNumber() + " new message: " + message);
    }
}

public class Test {

    public static void main(String[] args) {

        AirportControllerTower airportControlTower = new AirportControllerTower();

        Flight fa1 = new FlightA(airportControlTower, "123");

        Flight fb1 = new FlightB(airportControlTower, "456");
        Flight fb2 = new FlightB(airportControlTower, "789");

        fa1.requestLanding();

        fb1.requestLanding();

        fb2.requestTakeoff();

    }
}