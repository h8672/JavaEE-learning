package fi.jamk.javaee.harjoitukset.vko2.jdbc.harj7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	final static String lauseet2[] = { 
		  "CREATE TABLE Monivalinta (id int not null, kysymys varchar(255), primary key ( id ))", 
		  "CREATE TABLE Vaihtoehto (id int not null auto_increment, kys_id int, teksti varchar(255), "
		  + "oikein boolean, foreign key (kys_id) references Monivalinta(id), primary key ( id ))", 
		  "Insert into Monivalinta (id, kysymys) values (1, 'Ruotsin pääkaupunki')", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Oslo', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Tukholma', true)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Göteborg', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Luulaja', false)", 
		  "Insert into Monivalinta (id, kysymys) values (2, 'Suosituin ohjelmointikieli')", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (2, 'C', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (2, 'C#', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (2, 'Java', true)", 
		  "Insert into Monivalinta (id, kysymys) values (3, 'Web selainten ohjelmointikieli')", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (3, 'TypeX', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (3, 'perl', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (3, 'JavaScript', true)", 
		  "Insert into Monivalinta (id, kysymys) values (4, 'Käytetyin merkintäkieli Webissä')", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (4, 'XML', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (4, 'JavaScript', false)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (4, 'HTML', true)", 
		  "Insert into Monivalinta (id, kysymys) values (5, 'JavaEE Framework?')", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (5, 'JSF', true)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (5, 'JPA', true)", 
		  "Insert into Vaihtoehto (kys_id, teksti, oikein) values (5, 'EJB', true)" 
		}; 

	private static void tulosta(String str){
		System.out.println(str);
	}
	
	private static void luokannat(Connection conn){
		try{
		Statement stmt = conn.createStatement();
		//Haetaan tietoa tietokannasta
		int lkm = 0;
		for(String str : lauseet2){
			stmt.executeUpdate(str);
			lkm++;
		}
		tulosta("Montas oli? " + lkm);
		
		//Näyttää viimeiset muutokset
		ResultSet rs = stmt.executeQuery("SELECT * FROM Monivalinta");
		while(rs.next()){
			tulosta(rs.getString("kysymys"));
		}
		
		rs = stmt.executeQuery("SELECT * FROM Vaihtoehto");
		while(rs.next()){
			tulosta(rs.getString("teksti"));
		}
		
		stmt.close();
		
		} catch(Exception e){
			tulosta(e.toString());
		}
	}

	
	public static void main(String[] args) {
		Connection conn = null;
		List<MonivalintaDTO> monet;
		List<VaihtoehtoDTO> ehdot;
		
		try {
			monet = new ArrayList<MonivalintaDTO>();
			ehdot = new ArrayList<VaihtoehtoDTO>();
			
			conn = TietokantayhteysTehdas.getConnection();
			
			//Jos pitää luoda kantoja
			//luokannat(conn);
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Monivalinta");
			//Näyttää viimeiset muutokset
			while(rs.next()){
				MonivalintaDTO mv = new MonivalintaDTO();
				mv.setId(rs.getInt("id"));
				mv.setKysymys(rs.getString("kysymys"));
				tulosta(rs.getString("kysymys"));
			}
			rs = stmt.executeQuery("SELECT * FROM Vaihtoehto");
			//Näyttää viimeiset muutokset
			while(rs.next()){
				VaihtoehtoDTO ve = new VaihtoehtoDTO();
				ve.setId(rs.getInt("id"));
				ve.setKysymysId(rs.getInt("kys_id"));
				ve.setTeksti(rs.getString("teksti"));
				ve.setOikein(rs.getBoolean("oikein"));
				tulosta(rs.getString("teksti"));
			}
			
			
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
