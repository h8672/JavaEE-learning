package fi.agileo.javaee.jaxrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* TietokantayhteysTehdas

Tätä käytetään kaikissa esimerkeissä ja harjoituksissa.
Sisältää tuen eri tietokannoille tehden tietokannan vaihtamisesta melko vaivatonta.
 
Luokka kapseloi sisäänsä kaikki tietokantayhteyden avaaminen liittyvät asiat
  
Tukee eri tietokantoja, kunhan muuttujaa TIETOKANTA muutetaan.
  
Tukee seuraavia tietokantoja 
  MySQL
  H2 
  
 * @author Juha Peltomäki
 */

public class TietokantayhteysTehdas {
	public enum TK {
		MySQL, DB2, H2
	}

	// Valitse mitä tietokantaa käytetään.
	// private static final Enum<?> TIETOKANTA = TK.MySQL; // käytetään MySQL:ää
	private static final Enum<?> TIETOKANTA = TK.H2; // käytetään h2:sta

	// Tietoyhteyksien alustamiseen käytettävät staattiset muuttujat
	private static TietokantayhteysTehdas instance = new TietokantayhteysTehdas();

	public static final String MYSQL_URL = "jdbc:mysql://localhost/jdbcesim";
	public static final String MYSQL_KAYTTAJA = "root";
	public static final String MYSQL_SALASANA = "root66";
	public static final String MYSQL_AJURI = "com.mysql.jdbc.Driver";

	// H2 kannan asetukset
	//public static final String H2_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false"; // ;MODE=MySQL ???
	public static final String H2_URL = "jdbc:h2:~/workspace/h2/demo;DATABASE_TO_UPPER=false;MODE=MySQL";
			//"jdbc:h2:tcp://localhost/~/workspace/h2/demo;DATABASE_TO_UPPER=false;MODE=MySQL;";
	private static final String H2_AJURI = "org.h2.Driver";
	private static final String H2_KAYTTAJA = "sa";
	private static final String H2_SALASANA = "";

	// DB2 kannan asetukset

	// privaatti konstruktori, ei voi kutsua ulkopuolelta
	private TietokantayhteysTehdas() {
		// ei tarvita enää Java 6 ja uudemmissa JDBC ajurien lataamista!
		try {
			if (TIETOKANTA == TK.MySQL) {
				Class.forName(MYSQL_AJURI);
				System.out.println("MySQL ajuri käytössä");
			} else if (TIETOKANTA == TK.H2) {
				Class.forName(H2_AJURI);
				System.out.println("H2 ajuri käytössä");
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection luoYhteys() {
		Connection yhteys = null;
		try {
			System.out.println("Tietokanta: " + TIETOKANTA);
			if (TIETOKANTA == TK.MySQL)
				yhteys = DriverManager.getConnection(MYSQL_URL, MYSQL_KAYTTAJA, MYSQL_SALASANA);
			else if (TIETOKANTA == TK.H2)
				yhteys = DriverManager.getConnection(H2_URL, H2_KAYTTAJA, H2_SALASANA);

		} catch (SQLException e) {
			System.out.println("VIRHE: Kytkeytyminen kantaan ei onnistunut.");
		}
		return yhteys;
	}

	public static Connection getConnection() {
		// kutsuu privaattia konstruktoria luoden olion ja palauttaa luoYhteys()
		// metodilla luodun yhteyden
		return instance.luoYhteys();
	}
}
