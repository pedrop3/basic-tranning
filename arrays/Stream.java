package arrays;

import java.util.ArrayList;
import java.util.List;

public class Stream {

    static class Weather {
        String place;
        Double temperature;

        public Weather() {

        }

        public Weather(String place, Double temperature) {
            this.place = place;
            this.temperature = temperature;
        }

        public Double getTemperature() {
            return temperature;
        }

        public String getPlace() {
            return place;
        }

        public String toString() {
            return new StringBuffer(" Place : ")
                    .append(this.place)
                    .append(" Temperature : ")
                    .append(this.temperature)
                    .toString();
        }
    }

    public static void main(String[] args) {
        List<Weather> weathers = new ArrayList<>();

        weathers.add(new Weather("Sunny", 33.0));
        weathers.add(new Weather("Rainy", 17.0));
        weathers.add(new Weather("Cloudy", 23.0));
        weathers.add(new Weather("Cold", 3.0));
        weathers.add(new Weather("Hot", 37.0));
        weathers.add(new Weather("Windy", 13.0));
        weathers.add(new Weather("Snowy", 0.0));
        weathers.add(new Weather("Freezing", -15.0));



        weathers.stream() .sorted((p1, p2) -> p1.getTemperature().compareTo(p2.getTemperature())) .forEach(System.out::println);
        
        weathers.stream() .map(Weather::getTemperature) .sorted((p1, p2) -> p1.compareTo(p2)) .forEach(System.out::println);


    }
}
