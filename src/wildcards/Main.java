package wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Building());
        printBuildings(buildings);

        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices);

        List<House> houses = new ArrayList<>();
        houses.add(new House());
        houses.add(new House());
        printBuildings(houses);

        addHouseToList(houses);
        addHouseToList(buildings);


    }

    static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }

    static void printBuildings(List<? extends Building> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + ": " + buildings.get(i).toString());
        }
    }

    static void addHouseToList(List<? super House> buildings) {
        buildings.add(new House());
        System.out.println();
    }



}
