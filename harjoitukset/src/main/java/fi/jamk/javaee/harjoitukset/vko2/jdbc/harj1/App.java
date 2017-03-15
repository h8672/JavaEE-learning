package fi.jamk.javaee.harjoitukset.vko2.jdbc.harj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 * 
 */
public class App {
	final static String lauseet[] = {
			"CREATE TABLE henkilo (id int NOT NULL auto_increment, etunimi "
					+ "varchar(32), sukunimi varchar(64), sotu char(11), palkka decimal(7,2), syntymaaika "
					+ "date, primary key (id))",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Aku','Ankka','210534-123B',3500.00,'1934-05-21')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Hessu','Hopo','060132-543C',3200.00, '1932-06-01')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Mikki','Hiiri','181128-765B',7800.95,'1928-11-18')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Iines','Ankka','010640-741A',2950.95,'1940-06-01')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Heluna','Koninkaulus','010629-642D',2400.00,'1929-06-01')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Minni','Hiiri','181128-579E',4700.90,'1928-11-18')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Tupu','Ankka','010637-329D',120.50,'1937-06-01')",
			"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES "
					+ "('Eka','Vekara','010547-012A',19999.50,'1947-05-01')",
			//"SELECT * FROM henkilo",
			//Ei hae tietoa, vaan päivittää sitä
			//"DROP TABLE henkilo"
			};

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = TietokantayhteysTehdas.getConnection();

			Statement stmt = conn.createStatement();

			int tulos = 0;
			for (String sql : lauseet) {
				tulos += stmt.executeUpdate(sql);
			}
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM henkilo");
			System.out.println("Päivityksiä yhteensä " + tulos + " kappaletta\n");
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
