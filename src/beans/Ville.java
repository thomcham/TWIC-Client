package beans;

import java.io.Serializable;
import java.text.DecimalFormat;
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Ville implements Serializable {


	private static final long serialVersionUID = -8050478362033217382L;

	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne;
	private String latitude;
	private String longitude;

	public Ville() {
		
	}
	
	public Ville(String codeCommune2, String nomCommune2, String codePostal2, String libelle, String ligne2,String latitude, String longitude) {
		this.setCodeCommune(codeCommune2);
		this.setCodePostal(codePostal2);
		this.setLibelleAcheminement(libelle);
		this.setLigne(ligne2);
		this.setnomCommune(nomCommune2);
		this.setLongitude(longitude);
		this.setLatitude(latitude);
	}
	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	public String getnomCommune() {
		return nomCommune;
	}
	public void setnomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String calculDistance(Ville v2) {
		double lat1 = Double.parseDouble(this.getLatitude());
		double lon1 = Double.parseDouble(this.getLongitude());
		double lat2 = Double.parseDouble(v2.getLatitude());
		double lon2 = Double.parseDouble(v2.getLongitude());
		double latR1 = lat1*Math.PI/180;
		double lonR1 = lon1*Math.PI/180;
		double latR2 = lat2*Math.PI/180;
		double lonR2 = lon2*Math.PI/180;
		
		double dist = 6400 * Math.acos( Math.sin(latR1)*Math.sin(latR2) + Math.cos(latR1)*Math.cos(latR2)*Math.cos(lonR2-lonR1));
		
		DecimalFormat df = new DecimalFormat("####.##");
		
		return df.format(dist);
	}

}
