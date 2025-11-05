package week09.kristian.umn.ac.id;

public class NestedInheritance {
	class Vehicle {
	    interface Action {
	        void start();
	        void stop();
	    }

	    private String name;

	    public Vehicle(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    public void displayInfo() {
	        System.out.println("Vehicle: " + name);
	    }
	}

	class Car implements Vehicle.Action {
	    private Vehicle vehicle;

	    public Car(String name) {
	        vehicle = new Vehicle(name);
	    }

	    @Override
	    public void start() {
	        System.out.println(vehicle.getName() + " is starting.");
	    }
	    @Override
	    public void stop() {
	        System.out.println(vehicle.getName() + " is stopping.");
	    }

	    public void showVehicleInfo() {
	        vehicle.displayInfo();
	    }
	}

	public class main {
	    public static void main(String[] args) {
	        Car myCar = new Car("Honda Civic");
	        myCar.showVehicleInfo();
	        myCar.start();
	        myCar.stop();
	    }
	}
}
