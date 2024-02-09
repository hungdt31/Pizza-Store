// Builder interface declares product construction steps
// that are common to all types of builders
interface Builder {
	void setSeats(Integer number);
	void setEngine(String engine);
	void setTripComputer();
	void setGPS();
}
// Concrete Builders provide different implementations of the
// construction steps. Concrete builders may produce products
// that don’t follow the common interface
class SportBuilder implements Builder{
	String car = "Car";
	public void setSeats(Integer number) {
		car += " has " + number + " seats";
	};
	public void setEngine(String engine) {
		car += ", uses " + engine;
	};
	public void setTripComputer() {
		car += ", trip-computer ";
	};
	public void setGPS() {
		car += ", GPS ";
	};
	public void getProduct() {
		System.out.println(car);
	}
}
// The Director class defines the order in which to call construction steps, 
// so you can create and reuse specific configurations of products.
class Director {
	public void constructSportCar(Builder b) {
		b.setSeats(2);
		b.setEngine("sport-engine");
		b.setTripComputer();
	}
}
public class BuilderExample {
    public static void main(String[] args) {
    	Director director = new Director();
    	SportBuilder sport_builder = new SportBuilder();
    	director.constructSportCar(sport_builder);
    	sport_builder.getProduct();
    }
}
