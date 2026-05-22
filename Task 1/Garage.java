class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        fleet = new Vehicle[capacity];
        size = 0;
    }

    // ADD VEHICLE
    public void add(Vehicle v) {

        if (size >= fleet.length) {
            throw new GarageFullException(
                    "Garage is full!");
        }

        if (findById(v.getId()) != null) {
            throw new DuplicateVehicleException(
                    "Duplicate vehicle id!");
        }

        fleet[size++] = v;
    }

    public Vehicle findById(String id) {

        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }

        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);

        if (v != null) {
            v.rent();
        }
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);

        if (v != null) {
            v.returnVehicle(drivenKm);
        }
    }

    public void printAvailable() {
        System.out.println("\n=== AVAILABLE VEHICLES ===");

        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i]);
            }
        }
    }

    public void printNeedsService() {
        System.out.println("\n=== VEHICLES NEEDING SERVICE ===");

        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i]);
            }
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);

        if (v != null) {
            System.out.println(
                    "Rental price for " + id +
                            " for " + days + " days = " +
                            v.rentalPrice(days)
            );
        }
    }
}
