import garage.air.Plane;
import garage.land.Car;
import garage.engine.CombustionEngine;
import garage.engine.ElectricEngine;
import garage.engine.IEngine;
import garage.water.CargoShip;

public class Runner {

    public static void main(String[] args) {
        IEngine combustionEngine = new CombustionEngine(99, "01/01/2024");
        Car hondaJazz = new Car(1300, 150, "hatchback", combustionEngine);
        System.out.println(hondaJazz.getHorsePower());

        
        IEngine electricEngine = new ElectricEngine(399, 100);
        hondaJazz.setEngine(electricEngine);
        System.out.println(hondaJazz.getHorsePower());

        
        CargoShip ship = new CargoShip(20000,500,100,combustionEngine);
        System.out.println(ship.getHorsePower());

        
        ship.setEngine(electricEngine);
        System.out.println(ship.getHorsePower());

        

        Plane plane = new Plane(true,combustionEngine );
        System.out.println(plane.getHorsePower());

        
        plane.setEngine(electricEngine);
        System.out.println(plane.getHorsePower());
        System.out.println(plane.getEngine());

    }

}
