package fi.jamk.javaee.harjoitukset.vko2.jdbc.harj7;

import java.util.List;

public class MonivalintaDTO {
	  private int id; 
	  private String kysymys; 
	  private List<VaihtoehtoDTO> vaihtoehdot; 
	  // ... 
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public List<VaihtoehtoDTO> getVaihtoehdot() {
		return vaihtoehdot;
	}
	public void setVaihtoehdot(List<VaihtoehtoDTO> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}
	  
}
