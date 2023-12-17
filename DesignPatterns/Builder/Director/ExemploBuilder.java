package DesignPatterns.Builder.Director;

import DesignPatterns.Builder.Director.builder.Builder;
import DesignPatterns.Builder.Director.builder.CarBuilder;
import DesignPatterns.Builder.Director.builder.CarManualBuilder;
import DesignPatterns.Builder.Director.car.Car;
import DesignPatterns.Builder.Director.car.Manual;

public class ExemploBuilder {

    public static void main(String[] args) {

        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        director.constructCityCar(builder);

        Car car = builder.getResult();

        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        // System.out.println("\nCar manual built:\n" + carManual.print());

    }

}
