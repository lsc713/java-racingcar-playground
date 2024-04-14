import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MOVE_CONDITION = 4;
    private static final int MAX_BOUND = 10;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        if (StringUtils.isBlank(names)) {
            throw new IllegalArgumentException("이름은 빈값일 수 없습니다.");
        }

        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getList() {
        return this.cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            if (movable()) {
                car.move();
            }
        }
    }


    private int generateRandomNo() {
        return new Random().nextInt(MAX_BOUND);
    }

    private boolean movable() {
       return generateRandomNo() > MOVE_CONDITION;
    }

    public List<Car> findWinners() {
        Position position = new Position(0);
        for (Car car : cars) {
            position = car.getMaxposition(position);
        }

        List<Car> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(position)) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }



}
