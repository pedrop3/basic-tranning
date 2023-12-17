package DesignPatterns.Builder.Director.builder;

import DesignPatterns.Builder.Director.car.Enum.CarType;
import DesignPatterns.Builder.Director.components.Engine;
import DesignPatterns.Builder.Director.components.GPSNavigator;
import DesignPatterns.Builder.Director.components.Transmission;
import DesignPatterns.Builder.Director.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {

    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}