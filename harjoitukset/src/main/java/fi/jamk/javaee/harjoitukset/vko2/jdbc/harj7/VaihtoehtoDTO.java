package fi.jamk.javaee.harjoitukset.vko2.jdbc.harj7;

public class VaihtoehtoDTO {
	  private int id; 
	  private int kysymysId; 
	  private String teksti; 
	  private Boolean oikein; 
	  // ... 
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKysymysId() {
		return kysymysId;
	}
	public void setKysymysId(int kysymysId) {
		this.kysymysId = kysymysId;
	}
	public String getTeksti() {
		return teksti;
	}
	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}
	public Boolean getOikein() {
		return oikein;
	}
	public void setOikein(Boolean oikein) {
		this.oikein = oikein;
	}
	  
}
