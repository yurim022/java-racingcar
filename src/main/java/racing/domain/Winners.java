package racing.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners of(Cars cars) {
        return new Winners(cars.findWinner());
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}