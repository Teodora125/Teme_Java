public class VehicleSystem {
    public static void main(String[] args) {
        Garage garage = new Garage(10);

        garage.add(new Car(
                "C1", "BMW", 220,
                12000, 4));

        garage.add(new Car(
                "C2", "Audi", 210,
                8000, 2));

        garage.add(new Motorcycle(
                "M1", "Yamaha", 180,
                7000, true));

        garage.add(new Motorcycle(
                "M2", "Kawasaki", 170,
                3000, false));

        garage.add(new Truck(
                "T1", "Volvo", 140,
                16000, 5000));


        garage.rentById("C1");
        garage.rentById("M1");


        garage.returnById("C1", 500);


        garage.printAvailable();


        garage.printNeedsService();


        garage.printRentalEstimate("T1", 5);


        Car car1 = new Car(
                "X1", "BMW",
                200, 5000, 4);

        Car car2 = new Car(
                "X1", "BMW",
                200, 5000, 4);

        System.out.println(
                "\nCars equal? " +
                        car1.equals(car2)
        );
    }
}
