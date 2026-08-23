import java.util.*;

class Car {
    String modelName;
    double price;

    Car(String modelName, double price) {
        this.modelName = modelName;
        this.price = price;
    }
}

public class CarClass1
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        System.out.print("Enter number of cars: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Enter model name: ");
            String name = sc.next();
            System.out.print("Enter price: ");
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
        System.out.println("\nCars with highest price:");
        for (Car car : cars) {
            if (car.price == maxPrice) {
                System.out.println(car.modelName);
                count++;
            }
        }
        System.out.println("Highest Price: " + maxPrice);
        System.out.println("Number of cars: " + count);
    }
}
