package fi.jamk.javaee.harjoitukset.vko1.harj4;

enum behaviors {
	aggressive, normal, relaxed
};

public class Ajaja {
	private Auto car;
	private String name; 
	private behaviors behavior;

	//Constructors
	Ajaja(){
		this.car = new Auto();
		this.name = "Mika Häkkinen";
		this.behavior = behaviors.relaxed;
	}
	Ajaja(Auto car){
		this.car = car;
		this.name = "Muka Ruusberg";
		this.behavior = behaviors.normal;
	}
	Ajaja(String name, behaviors behavior){
		this.car = new Auto();
		this.name = name;
		this.behavior = behavior;
	}
	Ajaja(Auto car, String name, behaviors behavior){
		this.car = car;
		this.name = name;
		this.behavior = behavior;
	}
	
	//Set new value to private values
	public void setCar(Auto car) {this.car = car;}
	public void setName(String name) {this.name = name;}
	public void setBehavior(behaviors beh) {this.behavior = beh;}
	
	//Get values from private values
	public Auto getCar(){return this.car;}
	public String getName(){return this.name;}
	public double getBehavior(){
		double value;
		switch(this.behavior){
		case aggressive:
			value = 1;
			break;
		case normal:
			value = 0.7;
			break;
		case relaxed:
			value = 0.4;
			break;
		default:
			value = -1;
			break;
		}
		return value;
	}
}
