import java.util.List;

public class RacingCar {


    private int tryNo;
    private final Cars cars;

    public RacingCar(String carName, int tryNo) {
        cars = initCars(carName);
        this.tryNo = tryNo;
    }

    private Cars initCars(String carNames) {
        return new Cars(carNames);
    }

    public List<Car> race() {
        this.tryNo--;
        cars.moveCars();
        return cars.getList();
    }

    public List<Car> findWinner() {
        return cars.findWinners();
    }

    public boolean isEnd() {
        return tryNo == 0;
    }
}
