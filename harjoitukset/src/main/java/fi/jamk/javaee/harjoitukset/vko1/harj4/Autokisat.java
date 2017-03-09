package fi.jamk.javaee.harjoitukset.vko1.harj4;

public class Autokisat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Auto a1 = new Auto();
		Ajaja temp = a1.getDriver();
		temp.setCar(a1);
		a1.setDriver(temp);
		Auto a2 = new Auto(new Moottori(1200, 12, 6), new Ajaja());
		a2.setMark("Mobiili");
		a2.setModel("Supreme");
		a2.setTopSpeed(360);
		Auto a3 = new Auto();
		a3.setMark("Mobiili");
		a3.setModel("Supreme");
		a3.setTopSpeed(360);
		a3.setEngine(new Moottori());
		a3.setDriver(new Driver(a3, ));
		
	}

}
