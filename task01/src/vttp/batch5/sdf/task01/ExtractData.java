package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vttp.batch5.sdf.task01.models.BikeEntry;

public class ExtractData {

    private Reader reader;
    private List<BikeEntry> bikeEntryList;

    public ExtractData(Reader reader) {
        this.reader = reader;

    }

    public List<BikeEntry> readCSV() throws IOException {

        List<BikeEntry> bikeEntryList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(reader)) {
            String currentLine;
            boolean first = true;
            bikeEntryList = new ArrayList<>();

            while ((currentLine = br.readLine()) != null) {
                String[] cols = currentLine.split(",");

                if (first) {
                    continue;
                }
                
                BikeEntry bike = BikeEntry.toBikeEntry(cols); // creating my objects of BikeEntry
                bikeEntryList.add(bike);


            }
            return bikeEntryList;

        }

    }

    public Map<Integer, Integer> count(List<BikeEntry> bikeEntryList) {
        Map<Integer, Integer> countOfCyclists = new HashMap<>();

        for (BikeEntry bike : bikeEntryList) {
            countOfCyclists.compute(bike.getSeason(), (k,v) -> (v == null) ? (bike.getCasual() + bike.getRegistered()): (v + bike.getCasual() + bike.getRegistered()));
        }
        return countOfCyclists;

    }

    public Map<Integer, String> month(List<BikeEntry> bikeEntryList) {
        Map<Integer, String> monthMap = new HashMap<>();
        
        for(BikeEntry bike : bikeEntryList) {
            monthMap.compute(bike.getMonth(), (k,v) -> (v == null) ? (Utilities.toMonth(bike.getMonth())) : v);
            
        }

        return monthMap;
    }

    public Map<Integer, String> weekDay(List<BikeEntry> bikeEntryList) {
        Map<Integer, String> weekDayMap = new HashMap<>();

        // I want to map 0 -> Sunday 1 -> Monday etc
        for (BikeEntry bike : bikeEntryList) {
            weekDayMap.compute(bike.getWeekday(), (k,v) -> (v == null) ? (Utilities.toWeekday(bike.getWeekday())) : v);

        }

        return weekDayMap;
    }

    public Map<Integer, String> weather(List<BikeEntry> bikeEntryList) {
        Map<Integer, String> weatherMap = new HashMap<>();
        // I want to map 1 ->
        //  1: Clear, Few clouds, Partly cloudy, Partly cloudy
		//  2: Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist
		//  3: Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds
		//  4: Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog

        for (BikeEntry bike : bikeEntryList) {
            // weatherMap.compute(bike.getWeather(), (k,v) -> (v == null) ? )

        }

            

        return weatherMap;
    }

    public Map<Integer,  BikeEntry> holiday(List<BikeEntry> bikeEntryList) {
        Map<Integer, BikeEntry> holidayMap = new HashMap<>();

        // I want to map 
        for(BikeEntry bike : bikeEntryList) {
            
            
        }

        return holidayMap;
    }

    public void transformingData(List<BikeEntry> bikeEntryList) {
        

        for(BikeEntry bike : bikeEntryList) {
            String weekday = Utilities.toWeekday(bike.getWeekday());
            String season = Utilities.toSeason(bike.getSeason());
            String month = Utilities.toMonth(bike.getMonth());


        }
    }

    

}
