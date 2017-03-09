package fi.jamk.javaee.harjoitukset.vko1.harj4;

public class Moottori {
	private int power;
	private int cylinders;
	private int brokenCylinders;

	//Constructors
	Moottori(){
			this.power = 1000;
			this.cylinders = 8;
			this.brokenCylinders = 0;
	}
	Moottori(int power, int cylinders, int brokencylinders){
		this.power = power;
		this.cylinders = cylinders;
		this.brokenCylinders = brokencylinders;
	}
	
	//Set new value to private values
	public void setPower(int power) {this.power = power;}
	public void setCylinders(int number) {this.cylinders = number;}
	public void setBrokenCylinders(int number) {this.brokenCylinders = number;}
	public void cylinderBroke() {this.brokenCylinders++;}
	
	//Get values from private values
	public int getPower(){return this.power;}
	public int getCylinders(){return this.cylinders;}
	public int getBrokenCylinders(){return this.brokenCylinders;}
}
