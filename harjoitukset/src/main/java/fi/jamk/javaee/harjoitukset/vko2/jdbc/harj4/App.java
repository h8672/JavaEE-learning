package fi.jamk.javaee.harjoitukset.vko2.jdbc.harj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	private static void tulosta(String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = TietokantayhteysTehdas.getConnection();
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			stmt.executeUpdate( 
					 "INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika)"
					 + "VALUES ('Musta','Pekka', '010626', 1200.00, '1926-06-01')"); 
			stmt.executeUpdate(
					 "INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika)"
					 + "VALUES ('Musta','Kaapu', '300539', 12900.90,'1939-05-30')"); 
			try{
				conn.commit();
			} catch(SQLException e){
				conn.rollback();
			}
			conn.setAutoCommit(true);
			
			//Haetaan tietoa tietokannasta
			ResultSet rs = stmt.executeQuery("SELECT * FROM henkilo");
			rs.last();
			rs.previous();
			rs.previous();
			//Näyttää viimeiset muutokset
			while(rs.next()){
				tulosta(
					rs.getRow() + " " +
					rs.getString("etunimi") + " " +
					rs.getString("sukunimi") + " " +
					rs.getString("sotu") + " " +
					rs.getString("palkka") + " " +
					rs.getString("syntymaaika") + " "
				);
			}
			
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
