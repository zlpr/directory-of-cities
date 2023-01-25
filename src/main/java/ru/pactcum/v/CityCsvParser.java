package ru.pactcum.v;

import java.util.List;
import java.util.stream.Collectors;

public class CityCsvParser implements CityParser{
    private static final String COLUMN_SEPARATOR = ";";
    @Override
    public City parseFrom(String line) {
        String[] city = line.split(COLUMN_SEPARATOR);
        if (city.length < 5) {
            throw new IllegalArgumentException(line);
        }
        var foundation = city.length == 6 ? city[5] : "";
        return new City(city[1], city[2], city[3],
                Integer.valueOf(city[4]),
                foundation);
    }

    @Override
    public List<City> parseLinesFrom(List<String> lines) {
        return lines.stream()
                .map(this::parseFrom)
                .collect(Collectors.toList());
    }
}
