package ru.pactcum.v;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CitiesProcessor {
    private final List<City> cities;

    public CitiesProcessor(List<City> cities) {
        this.cities = cities;
    }

    public Optional<City> getCityWithMaxPopulation() {
        return cities.stream()
                .reduce((c1, c2) -> c1.population() > c2.population() ? c1 : c2);
    }

    public Map<String, Long> getNumberOfCitiesInEachRegion() {
        return cities.stream()
                .collect(groupingBy(City::region, counting()));
    }

    public List<City> getCities(Comparator<? super City> comparator) {
        return cities.stream()
                .sorted(comparator)
                .collect(toList());
    }

    public List<City> getCities() {
        return cities.stream()
                .sorted()
                .collect(toList());
    }


}
