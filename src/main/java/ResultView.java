import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < car.getPosition(); i++) {
                sb.append("-");
            }

            System.out.println(car.getName()+" : "+ sb);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(",",winnerNames)+ "가 최종 우승했습니다.");
    }
}
