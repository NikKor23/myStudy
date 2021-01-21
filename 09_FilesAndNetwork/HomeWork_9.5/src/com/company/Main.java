package com.company;

import com.google.gson.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static String site = "https://www.moscowmap.ru/metro.html#lines";
    static String filePath = "map.json";
    static MetroHTMLParser metroParser;
    static List<Line> lineList = new ArrayList<>();
    static List<Station> stationList = new ArrayList<>();

    public static void main(String[] args){

        try {

            metroParser = new MetroHTMLParser(site, filePath);
            ParseFile();

            lineList.forEach(l -> {
                System.out.println("Line " + l + " has " + l.getStations().size() + " stations");
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void ParseFile() {

        JsonElement element = JsonParser.parseString(getJsonFile());
        JsonObject object = element.getAsJsonObject();

        JsonArray linesJsonArray = object.getAsJsonArray("lines");
        linesJsonArray.forEach(jsonLineElement -> {
            JsonObject lineObject = jsonLineElement.getAsJsonObject();
            Line line = new Line(
                    lineObject.get("name").toString(),
                    lineObject.get("number").getAsString()
            );
            lineList.add(line);
        });

        JsonObject stationsJsonObject = object.getAsJsonObject("stations");
        Set<String> lineNumbers = stationsJsonObject.keySet();
        lineNumbers.forEach(lineNumber -> {
            JsonArray stationArray = stationsJsonObject.get(lineNumber).getAsJsonArray();
            stationArray.forEach(jsonElement -> {
                Station station = new Station(
                        jsonElement.getAsString(),
                        lineNumber
                );
                stationList.add(station);
            });
        });

        FillLineWithStations();

    }

    private static String getJsonFile() {

        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.forEach(builder::append);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();

    }

    private static void FillLineWithStations(){

        stationList.forEach(s -> {
            lineList.forEach(l -> {
                if (s.getLine().equals(l.getNumber())) {
                    l.addStation(s);
                }
            });
        });

    }
}

