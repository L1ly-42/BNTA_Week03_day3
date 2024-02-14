package garage.land;

import garage.Vehicle;
import garage.engine.IEngine;

public class Bus extends Vehicle implements ILandVehicle, IEngine {

    private boolean isDoubleDecker;
    private int numberOfWheels;
    private IEngine engine;
    public Bus(float weight, int maxSpeed, boolean isDoubleDecker,IEngine engine){
        super(weight, maxSpeed);
        this.isDoubleDecker = isDoubleDecker;
        this.numberOfWheels = 8;
        this.engine = engine;
    }
    public int getHorsePower(){
        return this.engine.getHorsePower();
    }
    public void setHorsePower(int horsePower){
        this.engine.setHorsePower(horsePower);
    }
    @Override
    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }
    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public boolean getIsDoubleDecker() {
        return isDoubleDecker;
    }

    public void setDoubleDecker(boolean doubleDecker) {
        isDoubleDecker = doubleDecker;
    }

    public IEngine getEngine() {
        return engine;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }
}
