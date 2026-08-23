import java.util.*;

class Car {
    String modelName;
    double price;

    Car(String modelName, double price) {
        this.modelName = modelName;
        this.price = price;
    }
    @Override
    public boolean equals(Object obj) {
        Car c = (Car) obj;
        return this.modelName.equals(c.modelName);
    }
    @Override
    public int hashCode() {
        return modelName.hashCode();
    }
}

public class CarClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Car> cars = new HashSet<>();
        System.out.print("Enter number of cars: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double price = sc.nextDouble();
            cars.add(new Car(name, price));
        }
        double maxPrice = 0;
        for (Car car : cars) {
            if (car.price > maxPrice) {
                maxPrice = car.price;
            }
        }
        int count = 0;
        for (Car car : cars) {
            if (car.price == maxPrice) {
                System.out.println(car.modelName);
                count++;
            }
        }
        System.out.println("Number of cars: " + count);
    }
}
