package com.company;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, 2);
        Date then = calendar.getTime();
        airport.getTerminals().stream().map(Terminal::getFlights)
                    .flatMap(Collection::stream)
                    .filter(f -> f.getType() == Flight.Type.DEPARTURE)
                    .filter(f -> f.getDate().compareTo(now) >= 0 && f.getDate().compareTo(then) <= 0)
                    .peek(f -> System.out.print(f.getAircraft() + " "))
                    .forEach(System.out::println);
    }
}
