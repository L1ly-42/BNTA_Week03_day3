package garage.air;

import garage.engine.IEngine;

public class Helicopter implements IAirVehicle, IEngine {

    private IEngine engine;
    private boolean hasRadar;

    public Helicopter(IEngine engine){
        this.engine = engine;
        this.hasRadar = true;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public IEngine getEngine(){
        return this.engine;
    }

    public boolean getHasRadar() {
        return hasRadar;
    }

    public void setHasRadar(boolean radar) {
        this.hasRadar = radar;
    }

    public int getHorsePower() {
        return this.engine.getHorsePower();
    }

    public void setHorsePower(int horsePower) {
        this.engine.setHorsePower(horsePower);
    }
}
