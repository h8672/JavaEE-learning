package fi.jamk.javaee.harjoitukset.vko1.harj5;



public class Autokisat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Auto a1 = new Auto();
		Ajaja temp = a1.getDriver();
		temp.setCar(a1);
		a1.setDriver(temp);
		Auto a2 = new Auto(new Moottori(1200, 12, 6), new Ajaja());
		temp = new Ajaja(a2);
		a2.setDriver(temp);
		//temp.setCar(a2);
		a2.setMark("Mobiili");
		a2.setModel("Supreme");
		a2.setTopSpeed(360);
		Auto a3 = new Auto();
		temp = a3.getDriver();
		temp.setCar(a3);
		a3.setMark("Mobiili");
		a3.setModel("Supreme");
		a3.setTopSpeed(360);
		a3.setEngine(new Moottori(500, 50, 10));
		a3.setDriver(new Ajaja(a3, "Hauki Kuusakoskelta", behaviors.aggressive));
		
		String viesti = a1.getInformation();
		viesti += "\n\n" + a2.getInformation();
		viesti += "\n\n" + a3.getInformation();
		
		System.out.println(viesti);
		
		viesti = a1.getDriver().getName() + " on ajanut kovan ajan, pisteillä " + a1.getDriver().aja(2.5)
				+ "\nValitettavasti hänen kilpailijansa " + a2.getDriver().getName()
				+ " päättyi moottoririkon vuoksi telakalle kun hänen " + a2.getEngine().getBrokenCylinders()
				+ " rikkoontuneet sylinterit lisääntyivät " +a2.getEngine().meneRikki() + ":llä"
				+ "\nPäivän nopein ajaja oli " + a3.getDriver().getName() + " huikealla ennätys nopeudella "
				+ a3.laskeNopeus();
		
		System.out.println(viesti);
	}

}
