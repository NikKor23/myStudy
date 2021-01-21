package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.util.*;

public class MetroHTMLParser {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static Map<String, Object> metro = new LinkedHashMap<>();
    private static Map<String, List<String>> stationList = new LinkedHashMap<>();
    private static List<Line> lineList = new ArrayList<>();
    private static ArrayList<ArrayList<Station>> connectionsList = new ArrayList<>();

    public MetroHTMLParser(String site, String jsonFilePath) throws Exception {
        Document metroSiteDocument = Jsoup.connect(site).maxBodySize(0).get();
        Elements stationElements = metroSiteDocument.getElementsByAttributeValue("class", "js-metro-stations t-metrostation-list-table");
        Elements lineElements = metroSiteDocument.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
        lineElements.forEach(l1E -> {
            Line line = new Line(l1E.text(), l1E.attr("data-line"));
            lineList.add(line);
        });
        stationElements.forEach(s1E -> {
            stationList.put(s1E.attr("data-line"),s1E.select("span.name").eachText());
        });

        connectionsList = getConnectionsFromDocument(metroSiteDocument);

        metro.put("stations", stationList);
        metro.put("lines", lineList);
        metro.put("connections", connectionsList);

        toJsonFile(jsonFilePath, metro);
    }

    private static void toJsonFile(String path, Map metro) throws Exception {
        String string = GSON.toJson(metro);
        FileWriter file = new FileWriter(path);
        file.write(string);
        file.flush();
        file.close();
    }


    private static ArrayList<ArrayList<Station>> getConnectionsFromDocument(Document document) {
        List<TreeSet<Station>> connections = new ArrayList<>();
        Elements lines = document.select("div.js-metro-stations.t-metrostation-list-table");
        lines.forEach(l -> {
            l.select("p>a").select("a").forEach(s -> {
                s.select("span.t-icon-metroln").forEach(c -> {
                    Station src = new Station(s.select("span.name").text(), l.attr("data-line"));
                    String lineNumber = c.toString().substring(c.toString().indexOf("ln-") + 3, c.toString().indexOf("\" title"));
                    String lineName = c.toString().substring(c.toString().indexOf("«") + 1, c.toString().indexOf("»"));
                    Station dst = new Station(lineName, lineNumber);

                    boolean isAdded = false;
                    for (TreeSet<Station> set : connections){
                        if (set.contains(src) || set.contains(dst)) {
                            set.add(src);
                            set.add(dst);
                            isAdded = true;
                        }
                    }
                    if (!isAdded) connections.add(new TreeSet<Station>() {{
                        add(src);
                        add(dst);
                    }});
                });
            });
        });
        ArrayList<ArrayList<Station>> array = new ArrayList<>();
        for (TreeSet<Station> set : connections) {
            ArrayList<Station> newArray = new ArrayList(set);
            array.add(newArray);
        }
        return array;
    }
}
