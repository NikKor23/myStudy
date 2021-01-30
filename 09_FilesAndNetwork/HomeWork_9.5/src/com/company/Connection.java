package com.company;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Connection implements Comparable<Connection>{

    private Set<Station> connect;

    public Connection() {
        connect = new TreeSet<>();
    }

    public void addStation(Station station) {

        if (!connect.contains(station)) connect.add(station);

    }

    public boolean contains(Station station) {
        if (connect.contains(station)) return true;
        else return false;
    }

    public Set<Station> getConnect(Station station) {

        if (connect.contains(station)) return connect;
        else return null;
    }

    @Override
    public int compareTo(Connection o) {
        if (this.connect == o.connect) return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return new ArrayList(connect).toString();
    }

    public Set getStations(){
        return connect;
    }

}
