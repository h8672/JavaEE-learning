package fi.jamk.javaee.harjoitukset.vko2.jdbc.harj5;

import java.math.BigDecimal;
import java.sql.Date;

public class HenkiloDTO { 
	  private String etunimi,sukunimi,sotu; 
	  private BigDecimal palkka; 
	  private Date syntymaaika; 
	  // ... 
	public String getSotu() {
		return sotu;
	}
	public void setSotu(String sotu) {
		this.sotu = sotu;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public BigDecimal getPalkka() {
		return palkka;
	}
	public void setPalkka(BigDecimal palkka) {
		this.palkka = palkka;
	}
	public Date getSyntymaaika() {
		return syntymaaika;
	}
	public void setSyntymaaika(Date syntymaaika) {
		this.syntymaaika = syntymaaika;
	}
	public String getTiedot(){
		return getEtunimi() + " " + getSukunimi() + " " + getSotu() + " " + getPalkka() + " " + getSyntymaaika();
	}
	} 