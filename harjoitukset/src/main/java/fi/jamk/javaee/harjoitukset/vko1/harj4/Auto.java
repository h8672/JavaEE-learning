package fi.jamk.javaee.harjoitukset.vko1.harj4;

public class Auto {
	private String mark;
	private String model;
	private int topSpeed;
	private Moottori engine;
	private Ajaja driver;
	
	//Constructors
	Auto(){
		this.mark = "Bemari";
		this.model = "Jaguar";
		this.topSpeed = 400;
		this.engine = new Moottori();
		this.driver = new Ajaja();
	}
	Auto(Moottori engine, Ajaja driver){
		this.mark = "Bemari";
		this.model = "Jaguar";
		this.topSpeed = 400;
		this.engine = engine;
		this.driver = driver;
	}
	Auto(String mark, String model, int topSpeed){
		this.mark = mark;
		this.model = model;
		this.topSpeed = topSpeed;
		this.engine = new Moottori();
		this.driver = new Ajaja();
	}
	
	//Set new value to private values
	public void setMark(String mark) {this.mark = mark;}
	public void setModel(String model) {this.model = model;}
	public void setTopSpeed(int speed) {this.topSpeed = speed;}
	public void setEngine(Moottori engine) {this.engine = engine;}
	public void setDriver(Ajaja driver) {this.driver = driver;}
	
	//Get values from private values
	public String getMark() {return this.mark;}
	public String getModel() {return this.model;}
	public int getTopSpeed() {return this.topSpeed;}
	public Moottori getEngine() {return this.engine;}
	public Ajaja getDriver() {return this.driver;}
}
