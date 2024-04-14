import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move() {
        position.move();
    }

    public Position getMaxposition(Position position) {
        if (this.position.lessThan(position)) {
            return position;
        }
        return this.position;
    }

    public boolean isWinner(Position position) {
        return this.position.isSame(position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
