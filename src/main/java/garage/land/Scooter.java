package garage.land;

import garage.Vehicle;
import garage.land.ILandVehicle;

public class Scooter extends Vehicle implements ILandVehicle {
    private int numberOfWheels;
    public Scooter(float weight, int maxSpeed){
        super(weight, maxSpeed);
        this.numberOfWheels = 2;
    }

    @Override
    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }

    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
    public void doTailWhip(){
        System.out.println("Doing some red moves");
    }
}
