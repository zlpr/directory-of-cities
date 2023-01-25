package ru.pactcum.v;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class Main {
    private static final Comparator<City> caseInsensitiveSortingByName = Comparator.comparing(City::name, String.CASE_INSENSITIVE_ORDER);
    private static final Comparator<City> sortingByDistrictAndName = Comparator.comparing(City::district).thenComparing(City::name);
    private static final String RESOURCES = "src/main/resources/";
    public static void main(String[] args) throws IOException {
        var path = Path.of(RESOURCES + "Задача ВС Java Сбер.csv");
        //var path = Path.of(args[0]);
        CityParser parser = new CityCsvParser();
        List<City> cities = parser.parseLinesFrom(readAllNoEmptyLines(path));
        CitiesProcessor processor = new CitiesProcessor(cities);


        processor.getCities(caseInsensitiveSortingByName).forEach(System.out::println);

        processor.getCities(sortingByDistrictAndName).forEach(System.out::println);

        processor.getCityWithMaxPopulation().ifPresent(System.out::println);

        processor.getNumberOfCitiesInEachRegion().entrySet().forEach(System.out::println);


    }

    private static List<String> readAllNoEmptyLines(Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        try (var scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }
}
