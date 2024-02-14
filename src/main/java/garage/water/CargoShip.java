package garage.water;

import garage.Vehicle;
import garage.engine.IEngine;

public class CargoShip extends Vehicle implements IWaterVehicle, IEngine {

    private int numberOfContainers;
    private String hullType;
    private IEngine engine;

    public CargoShip(float weight, int maxSpeed, int numberOfContainers, IEngine engine){
        super(weight, maxSpeed);
        this.numberOfContainers = numberOfContainers;
        this.engine = engine;
    }

    @Override
    public String getHullType() {
        return this.hullType;
    }

    @Override
    public void setHullType(String hullType) {
        this.hullType = hullType;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    public int getHorsePower(){
        return this.engine.getHorsePower();
    }

    public void setHorsePower(int horsePower){
        this.engine.setHorsePower(horsePower);
    }
    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public IEngine getEngine(){
        return this.engine;
    }

}
