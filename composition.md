# Association: Composition & Aggregation

## Learning Objectives

* Be able to explain the differences between the 2 association types - composition and aggregation
* Recognize the problem inheritance causes and how associations can alliveate this problem 
* Understand the pros and cons of using composition and when to use it
* To be able to implement composition patterns in a project

## What is Association?
In this lesson we'll be learning about associations.

Associatons are created as a counterpart to inheritance, and both are used for both polymorphism and to create maintanable code that follows the SOLID principles. However, they achieve it in a different way.

Inheritance is used to describe ***is-a*** relationships, like the one between `Bird` and `Parrot` - a `Bird` ***is-a*** `Parrot`.

Associations on the other hand describe a **has-a** relationship - the way we create objects out from other objects, also referred to as *aggregation*, or *composition*. A `Vehicle` ***has-an*** `Engine`, or in other words - composed of an `Engine`.

Before we cover associations deeper, let's explore what issues could arise when we rely on inheritance too much!

## Problems with Inheritance

One of the core principles of object oriented programming is encapsulation - the restriction of access to an objects data and inner-workings. As you have already observed, we enforce encapsulation using access modifiers, such as private, only exposing public methods where needed, such as getters and setters. 

When we use inheritance, we run into some issues:
- It creates *tight coupling* between superclasses (parent) and the subclasses (child). 
- It contravenes the OO principle of *encapsulation*, since the the sublcass can override the public and protected methods of the superclass. 
- Inappropriate or excessive use of inheritance can lead to large inheritance hierarchies, which are a tightly-coupled disaster, very difficult to maintain, and less scalable.

So, does this mean we should *never* use inheritance? No. Inheritance *does* have it's appropriate use cases, which allow us to take advantage of it's intrinsic **code reuse** properties (which in turn helps to keep our code uncluttered and **DRY** - when we want to share attributes/properties between classes, inhertiance is still our best tool!). However, it is not to be used for *everything* - a mistake which new developers often make. In many situations, the cons *outweight* the pros. In such cases, our objectives are better served by utilizing a form of association.

## Composition vs Aggregation
As we mentioned earlier, composition and aggregation are two specific kinds of association in OOP. An association (i.e relationship) just means 2 objects speak to eachother somehow. Most commonly, an association is implemented as either a *composition* or an *aggregation*. The difference between the two can be subtle and more conceptual, but essentially, in **aggregation** one object *uses* another (which may also be used by other objects), whereas in **composition**, one object *owns* another. General benefits of association (over inheritance) include the following:

- It respects the principle of encapsulation
- When combined with interfaces, it makes **loose-coupling** possible (not possible with inheritance)
- And most importantly, it allows us to change the composed part at runtime!

This does come at a *some* cost, however - our code can become a bit more verbose - a little more boilerplate. However, the benefits often outweight these relatively minor drawbacks.

## How Composition Works
So, how does composition work? Put simply, when using composition we compose an object of smaller objects, which belong to it. These sub-objects are often injected into the main object as dependencies. We build a more complex whole by *attaching* various elements, like components, to a core object, instead of extending sub-classes with super-classes, as we do in the case of inheritance. Composition creates what's known as a **Has-A** relation, in contrast to inheritence, which is termed an **Is-A** relation. Has-A relationships allow for loose coupling, whereas Is-A relationships are *always* tightly coupled. That makes them less maintainable, and less scaleable. 

Here are some key points to remember when working with composition:

- It denotes a **Has-A** relationship.
- One class is considered to *own* another class, rather than simply *use* it, as is the case with aggregation.
- In composition, the *owning* object is responsible for the lifecyle of the *owned* object. I.e, if you had a class called *Car* (owner), with a sub-object property called *Seat* (owned), *Car* would be responsible for destroying *Seat* when it is, itself, destroyed. In other words...
- The owned object is considered to be incapable of existing without the owning object (i.e a room cannot exist without a building), since it is a compositional element of the owner. In this sense, it is like a sub-object, and only makes sense as part of the larger whole. If the sub-object can exist without the main object, that would be a case of aggregation, *not* composition.

### Example Associations

Let's consider some examples. Notice the nature of the association between A classes and students in the following diagram:

![](./img/aggregation-example.png)

Can you tell the type of association this is? Well, as you can see, a student keeps track of the classes they're enrolled in via a classes collection, which can have many classes in it, or potentially, none at all. However, classes can exist even if a student has not enrolled. Therefore, they do not belong to any particular student, but are merely used by them. Hence, this is an **aggregation** relation, as denoted by the open diamond. 

Here is another, slightly more complicated example:

![](./img/composition_v_aggregation.png)

Here, we have 4 domain classes - **Building**, **Address**, **Room** and **Furniture**, and various associations between them. Let's break down the associations, and how they are determinted:

- A **room** *cannot* exist without a **building**. The room is built when the building is, and if you knock down (destroy) a building, the room will be destroyed as well. Therefore, you can say the building *owns* the room. Hence, this is a **compositional** relationship.
- A **building** has an **address**. Without a relationship to a building, an adddress has no purpose. Hence, we've made this a **compositional** relation; the building *owns* the address.
- Furniture is different. While our room *can* have furniture, furniture can also exist *seperate* from a room. We can *add* and *take away* furniture as we please, without affecting the Room itself. For example, we could move furniture from one room to another. We could even demolish a room, and move the furniture to a different one without issue. Therefore, this relationship is best described as **aggregational**. The room doesn't explicitly *own* the furniture, it just *uses* it.

## Tightly Coupled Inheritance Tree:

	Task: Hand out start code, and send away students in pairs/groups to breakout rooms. Create a UML diagram of the inheritance tree based off from the start code (10-15 minutes)

Let's see what is the major issue with our use of inheritance!

![Nightmare inheritance hierarchy](./img/tightly-coupled-hierarchy.png)

A new developer may naively conclude that it would be best to model a system such as the above using inheritance, but notice how these Is-A relationships create tightly coupled relationships between sub-types and super types, such that there is very little, or no, flexibility. Code reusue becomes difficult, since multiple inheritance is not possible in many languages, including Java - and even if we could, inheriting from multiple classes would overcomplicate the relationships, and would make it much harder to follow what properties are passed down to subclasses, and what behaviours are forced on other subclasses that we would've avoided if we could've.

As an example of this inflexibility, notice the classes LandVehicle and MotorisedLandVehicle - they define the same properties. The difference? They inherit from different super-classes. Without composition, there was no way to share the 'Land' behavior and attributes we wanted for both of them, so we had to define it twice, in two seperate places, which is not very DRY.

## Codealong

Now that we've learned the concepts, and looked at several example, it's time to tackle writing some composition code head-on! 
 
With our start code at hand, we are going to tackle the rigid structure of the code, and refactor it to accomodate to changes, thus allowing us to adhere to multiple principles of OOP!

First off, let's plan our approach!

1. Remove unnecessary classes from our hierarchy, simplifying it to only use a single layer of inheritance
2. Modify our classes to compose them of other classes
3. Do so in a way that we follow the SOLID principles (mainly Interface Segregation and Dependency Inversion), with interfaces instead of concrete implementations, and with small interfaces where possible!

First off, we delete all our abstract classes - except `Vehicle`! This will generate a lot of errors, but we will fix these individually. In the interest of time, we will not write tests, but using TDD and having tests to pass could help us immensely to ensure our code is refactored without losing functionality and is still doing what it's supposed to!

> Change all remaining concrete classes to inherit from Vehicle directly

```java
// Bicycle.java

public class Bicycle extends Vehicle { // MODIFIED

    private int frameSize;
    ...
    
// Bus.java
public class Bus extends Vehicle { // MODIFIED

    private boolean isDoubleDecker;
    ...
    
 // etc.

```

This will obviously cause a bunch of errors - we were relying on the abstract classes of `LandVehicles` and `WaterVehicles` to give us the properties of `numberOfWheels` and `hullType`, but we saw what happens if we rely on inheritance too much - what alternatives do we have? Interfaces, of course!

Since interfaces cannot contain properties, only methods, we will rely on writing appropriate getter and setter methods to force us as developers to create the properties alongside with it!

> Create an ILandVehicle interface

```java
public interface ILandVehicle {
    int getNumberOfWheels();
    void setNumberOfWheels(int numberOfWheels);
}
```

Implementing this interface will mean that we are obligated to add the appropriate methods and properties along with them!

> Implement the appropriate interface and properties to land based vehicles!

```java
// Bicycle.java
public class Bicycle extends Vehicle implements ILandVehicle { //UPDATED

    private int frameSize;
    private int numberOfWheels; // NEW

    public Bicycle(float weight, int maxSpeed, int frameSize){
        super(weight, maxSpeed);
        this.numberOfWheels = 2; // NEW
        this.frameSize = frameSize;
    }

    public int getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }

	 // NEW
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    // NEW
    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
```
```java
//Scooter.java
public class Scooter extends Vehicle implements ILandVehicle { // UPDATED
    private int numberOfWheels; // NEW

    public Scooter(float weight, int maxSpeed, boolean hasBreaks){
        super(weight, maxSpeed);
        this.numberOfWheels = 2; // NEW
    }

    // NEW
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }


    // NEW
    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public void doTailWhip(){
        System.out.println("Doing some rad moves");
    }
}
```
```java
//Bus.java
public class Bus extends Vehicle implements ILandVehicle { // UPDATED

    private boolean isDoubleDecker;
    private int numberOfWheels; // NEW

    public Bus(float weight, int maxSpeed, boolean isDoubleDecker){
        super(weight, maxSpeed);
        this.numberOfWheels = 8; // NEW
        this.isDoubleDecker = isDoubleDecker; 
    }

    public boolean getIsDoubleDecker() {
        return isDoubleDecker;
    }

    public void setDoubleDecker(boolean doubleDecker) {
        isDoubleDecker = doubleDecker;
    }

    // NEW
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    //NEW
    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
```
```java
// Car.java
public class Car extends Vehicle implements ILandVehicle { //UPDATED

    private String type;
    private int numberOfWheels;

    public Car(float weight, int maxSpeed, String type){ // UPDATED
        super(weight, maxSpeed);
        this.numberOfWheels = 4; // NEW
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // NEW
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    // NEW
    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
```

At this point we've retained our apps polymorphic properties, while also enabling a more flexible approach on setting up new classes and making them fit into our architecture.

## Rev the engines

However, based on our original plans, we lost the motorised property of some classes - buses, cars need to have engines. Let's create them!

> Create an interface called IEngine

```java
//IEngine.java
package garage.engine;

public interface IEngine {

    int getHorsePower();
    void setHorsePower(int horsePower);

}
```

Implement it on our classes that require it, along with appropriate getters and setters:

```java
//Bus.java
public class Bus extends Vehicle implements ILandVehicle, IEngine { // UPDATED

    private boolean isDoubleDecker;
    private int numberOfWheels; 
    private IEngine engine // NEW

    public Bus(float weight, int maxSpeed, boolean isDoubleDecker, IEngine engine){
        super(weight, maxSpeed);
        this.numberOfWheels = 8; // NEW
        this.isDoubleDecker = isDoubleDecker;
        this.engine = engine; 
    }

    // AS BEFORE
    
    public IEngine getEngine() {
        return engine;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public int getHorsePower(){
        return this.engine.getHorsePower();
    }

    public void setHorsePower(int horsePower){
        this.engine.setHorsePower(horsePower);
    }
}
```
```java
// Car.java
public class Car extends Vehicle implements ILandVehicle, IEngine { //UPDATED

    private String type;
    private int numberOfWheels;
    private IEngine engine;

    public Car(float weight, int maxSpeed, String type, IEngine engine){ // UPDATED
        super(weight, maxSpeed);
        this.numberOfWheels = 4; // NEW
        this.type = type;
        this.engine = engine;
    }

    // AS BEFORE
    
    public IEngine getEngine() {
        return engine;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public int getHorsePower(){
        return this.engine.getHorsePower();
    }

    public void setHorsePower(int horsePower){
        this.engine.setHorsePower(horsePower);
    }
}
```

By composing our engine-dependent classes of IEngine type objects and also implementing the IEngine interface on the concrete classes, we achieve 2 goals at the same time: We can compose our objects from parts, but we also have a guarantee that Cars and Buses will be able to access their engine's details, regardless of what implementation of engines will be given to them!

We are, however, missing an important piece of the puzzle - our code theoretically works, but we lack a concrete implementation for our IEngine class! Let's create a `CombustionEngine.java` and an `ElectricEngine.java`, both of which will implement IEngine, along with some custom properties.

```java
public class CombustionEngine implements IEngine {

    private int horsePower;
    private String lastOilChange;

    public CombustionEngine(int horsePower, String lastOilChange){
        this.horsePower = horsePower;
        this.lastOilChange = lastOilChange;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getLastOilChange() {
        return lastOilChange;
    }

    public void setLastOilChange(String lastOilChange) {
        this.lastOilChange = lastOilChange;
    }
}
```
```java
public class ElectricEngine implements IEngine {

    private int horsePower;
    private int batteryLevel;

    public ElectricEngine(int horsePower, int batteryLevel){
        this.horsePower = horsePower;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
```

Now we can try out our app!

In the `Runner` file, let's create a combustion engine, compose a car from it, then change its engine at runtime, and confirm the change happened!

```java
public class Runner {

    public static void main(String[] args) {
//        Create entities composed of each other
        IEngine hondaJazzEngine = new CombustionEngine(99, "01/01/2023");
        Car hondaJazz = new Car(1100.0f, 160, "hatchback", hondaJazzEngine);
        System.out.println(hondaJazz.getHorsePower());
//        As time goes by, we would like to upgrade the car at runtime
        IEngine electricHondaJazzEngine = new ElectricEngine(399, 100);
        hondaJazz.setEngine(electricHondaJazzEngine);

        System.out.println(hondaJazz.getHorsePower());
    }

}
```

Fantastic work!

## Packaging

Before we finish up, we will create some packages to store our classes in a more organized manner!

Packages are essentially just folders, but they enable us to structure our code better and to use import statements in a more orderly fashion.

> Create a package called `garage` in `main/java`, and move all our files to there except the `Runner`. This enables us to import any class we want with no restrictions - without it, classes staying in the `main/java` wouldn't be visible for imports.

In the `garage` package, we will create sub-packages to group related classes together

> Create a `engine`, `land` and `water` package, and move the appropriate files to their corresponding folder via drag&dropping it (make sure you click on refactor, it will fix the imports!)

>Note, you might have errors appearing in your files, especially ones that extends `Vehicle` - look through the files and fix import issues.

Much better!
