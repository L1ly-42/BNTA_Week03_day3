# Composition Lab: Finish the Vehicle Store

As you can see in the source code, much of the changes have been implemented, but we did not change our water based vehicles! Use the same code that you used for the lesson!

## MVP
- create an `IWaterVehicle` interface, with the correct abstract methods - `getHullType()` and `setHullType(String hulltype)`, very similar to what we did with the land vehicles!
- Update `Kayak`, `Pedalboat`, `Speedboat` and `Cargoship` with the appropriate interfaces and method implementations!
- Implement `IEngine` on `Cargoship` and `Speedboat`
- Test that you can create an engine-using water vehicle, change its engine, then check its properties in the `Runner`!

## Extensions

- Create a package called `air`, for air vehicles
- Create interfaces, classes (i.e. Plane, Helicopter) and components (i.e. Radar) in the air vehicles package
- Implement instances of the concrete classes you produced, using composition in the  `Runner`!
