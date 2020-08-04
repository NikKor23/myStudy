package com.company;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts());
        List<Aircraft> a = airport.getAllAircrafts();
        System.out.println(a.size());

	}
}
