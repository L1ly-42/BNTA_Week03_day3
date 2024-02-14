package garage.air;

import garage.engine.IEngine;

public class Plane implements IAirVehicle, IEngine {
    private boolean hasRadar;
    private IEngine engine;

    public Plane(boolean hasRadar, IEngine engine){
        this.hasRadar = hasRadar;
        this.engine = engine;
    }
    @Override
    public int getHorsePower() {
        return this.engine.getHorsePower();
    }
    @Override
    public void setHorsePower(int horsePower) {
        this.engine.setHorsePower(horsePower);
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public IEngine getEngine(){
        return this.engine;
    }

    public boolean getHasRadar() {
        return this.hasRadar;
    }


    public void setHasRadar(boolean radar) {
        this.hasRadar = radar;
    }
}
