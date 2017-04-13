package fi.agileo.javaee.jaxrs;

import java.sql.Connection;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fi.agileo.javaee.api.Calculation;

@Path("/calculator")
public class Calculator {
	
	@GET
	@Path("/calc/{op}/{left}/{right}")
	@Produces(MediaType.APPLICATION_JSON)
	public Calculation calculate(@PathParam("op") String op,
			@PathParam("left") Integer left, @PathParam("right") Integer right) {
		Calculation result = new Calculation();
		
		if(op.equalsIgnoreCase("add")) result.setOperation("+");
		else if(op.equalsIgnoreCase("substract")) result.setOperation("-");
		else if(op.equalsIgnoreCase("multiply")) result.setOperation("*");
		else if(op.equalsIgnoreCase("divide")) result.setOperation("/");
		else result.setOperation(op);
		result.setLeft(left);
		result.setRight(right);
		return doCalc(result);
	}

	@POST
	@Path("/calcform")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Calculation calculate(Calculation calc) {
		return doCalc(calc);
	}

	enum Substract { substract, erotus, miinus }
	enum Multiply { multiply, tulo, kerto }
	enum Divide { divide, jako, jaa }
	enum Modulus { modulus, jakojäännös, jäännös }
	
	private Calculation doCalc(Calculation c) {
		String op = c.getOperation();
		int left = c.getLeft();
		int right = c.getRight();
		
		for(Substract a: Substract.values()) if(a.name().equals(op)) op = "-";
		for(Multiply a: Multiply.values()) if(a.name().equals(op)) op = "*";
		for(Divide a: Divide.values()) if(a.name().equals(op)) op = "/";
		for(Modulus a: Modulus.values()) if(a.name().equals(op)) op = "%";
		
		if (op.equalsIgnoreCase("-")) { c.setResult(left - right);}
		else if (op.equalsIgnoreCase("*"))	{c.setResult(left * right);}
		else if (op.equalsIgnoreCase("/"))	{c.setResult(left / right);}
		else if (op.equalsIgnoreCase("%"))	{c.setResult(left % right);}
		else 								{c.setResult(left + right);}
		c.setOperation(op);
		postCalc(c);
		return c;
	}
	
	
	
	final static String lauseet[] = {
			"INSERT INTO lasku (operaatio,vasen,oikea,tulos) VALUES "
					+ "('+,'5','13','18')"
			};
	final static String taulu = "CREATE TABLE lasku (id int NOT NULL auto_increment, "
			+ "operaatio varchar(1), "
			+ "vasen varchar(32), "
			+ "oikea varchar(32), "
			+ "tulos varchar(64), "
			+ "primary key (id))";

	Connection conn = null;
	static boolean taululuotu = false;
	private void postCalc(Calculation c){
		//HUOM: h2 kansio tulee tällä hetkellä ~/workspace/ sisään.
		
		String lause = "INSERT INTO lasku (operaatio,vasen,oikea,tulos) VALUES "
				+ "('"+c.getOperation()+"','"+c.getLeft()+"','"+c.getRight()+"','"+c.getResult()+"')";
		try {
			if(conn == null) conn = TietokantayhteysTehdas.getConnection();
			Statement stmt = conn.createStatement();
			
			//Laitetaan tietoa tietokantaan
			//Jos taulu pitää luoda...
			if(!taululuotu){
				stmt.executeUpdate(taulu);
				taululuotu = true;
			}
			stmt.executeUpdate(lause);
			System.out.println("Lause: " + lause);
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			if(!taululuotu) taululuotu = true;
		}
	}

}
