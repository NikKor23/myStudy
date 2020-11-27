import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase
{
    List<Station> noneConnectionsRoute;
    List<Station> oneConnectionRoute;
    List<Station> twoConnectionsRoute;
    StationIndex stationIndex;
    RouteCalculator calculator;

    @Override
    protected void setUp() throws Exception {
        noneConnectionsRoute = new ArrayList<>();
        oneConnectionRoute = new ArrayList<>();
        twoConnectionsRoute = new ArrayList<>();
        List<Station> connections1 = new ArrayList<>();
        List<Station> connections2 = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        Station station1 = new Station("Петровская", line1);
        line1.addStation(station1);
        Station station2 = new Station("Арбузная", line1);
        line1.addStation(station2);
        Station station3 = new Station("Морковная", line2);
        line2.addStation(station3);
        Station station4 = new Station("Яблочная", line2);
        line2.addStation(station4);
        Station station5 = new Station("Вечерняя", line3);
        line3.addStation(station5);
        Station station6 = new Station("Ночная", line3);
        line3.addStation(station6);

        connections1.add(station2);
        connections1.add(station3);
        connections2.add(station4);
        connections2.add(station5);

        stationIndex = new StationIndex();
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addConnection(connections1);
        stationIndex.addConnection(connections2);

        noneConnectionsRoute.add(station1);
        noneConnectionsRoute.add(station2);

        oneConnectionRoute.add(station1);
        oneConnectionRoute.add(station2);
        oneConnectionRoute.add(station3);
        oneConnectionRoute.add(station4);

        twoConnectionsRoute.add(station1);
        twoConnectionsRoute.add(station2);
        twoConnectionsRoute.add(station3);
        twoConnectionsRoute.add(station4);
        twoConnectionsRoute.add(station5);
        twoConnectionsRoute.add(station6);

        calculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration() {
         double actual = RouteCalculator.calculateDuration(twoConnectionsRoute);
         double expected = 14.5;
         assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        List<Station> newRoute = calculator.getShortestRoute(stationIndex.getStation("петровская"),
                stationIndex.getStation("Арбузная"));
        assertEquals(noneConnectionsRoute, newRoute);
        List<Station> newRoute2 = calculator.getShortestRoute(stationIndex.getStation("петровская"),
                stationIndex.getStation("Яблочная"));
        assertEquals(oneConnectionRoute, newRoute2);
        List<Station> newRoute3 = calculator.getShortestRoute(stationIndex.getStation("петровская"),
                stationIndex.getStation("ночная"));
        assertEquals(twoConnectionsRoute, newRoute3);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
