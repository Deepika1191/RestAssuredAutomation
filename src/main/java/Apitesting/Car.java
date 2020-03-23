package Apitesting;

public class Car {
	
	static int wheels = 4;
	int price = 5;
	String color;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			stop();
		
	}

	void start() {
		int a = 5;
		stop();
		System.out.println("Start");
		System.out.println(wheels);
	}
	
	static void stop() {
		Car c = new Car();
		Car c1 = new Car();
		c1.price = 10;
		//c.start();
		System.out.println(c1.price);
		System.out.println(c.price);
		
		c1.wheels= 6;
		
		System.out.println("Stop");
		System.out.println(c.wheels);
		System.out.println(c1.wheels);
	}
	
}
