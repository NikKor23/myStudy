package com.company;

import java.util.ArrayList;

public class Line {
    private String name;
    private String number;
    private ArrayList<Station> stations;

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
        stations =  new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public String toString() {
        return number + " " + name;
    }




}
