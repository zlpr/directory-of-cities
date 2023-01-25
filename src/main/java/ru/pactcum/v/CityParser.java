package ru.pactcum.v;

import java.util.List;

public interface CityParser {
    City parseFrom(String line);
    List<City> parseLinesFrom(List<String> lines);
}
