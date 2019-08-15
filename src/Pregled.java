import java.time.LocalDate;

public class Pregled {
	
	// atributi
	private int id; // mora biti >0
	private String imeZivotinje;
	private String imeVeterinara;
	private String prezimeVeterinara;
	private String bolest;
	private String terapija;
	private LocalDate datum;
	private double cena; // mora biti >0
	private String vrsta; // mora biti: pas, macka, ptica, ribica, kornjaca, gmizavac ili ostalo
	
	public Pregled() {
		super();
	}
	
	public Pregled(int id, String imeZivotinje, String imeVeterinara, String prezimeVeterinara, String bolest,
			String terapija, LocalDate datum, double cena, String vrsta) {
		super();
		this.id = id;
		this.imeZivotinje = imeZivotinje;
		this.imeVeterinara = imeVeterinara;
		this.prezimeVeterinara = prezimeVeterinara;
		this.bolest = bolest;
		this.terapija = terapija;
		this.datum = datum;
		this.cena = cena;
		this.vrsta = vrsta;
	}

	// geteri i seteri
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImeZivotinje() {
		return imeZivotinje;
	}
	public void setImeZivotinje(String imeZivotinje) {
		this.imeZivotinje = imeZivotinje;
	}
	public String getImeVeterinara() {
		return imeVeterinara;
	}
	public void setImeVeterinara(String imeVeterinara) {
		this.imeVeterinara = imeVeterinara;
	}
	public String getPrezimeVeterinara() {
		return prezimeVeterinara;
	}
	public void setPrezimeVeterinara(String prezimeVeterinara) {
		this.prezimeVeterinara = prezimeVeterinara;
	}
	public String getBolest() {
		return bolest;
	}
	public void setBolest(String bolest) {
		this.bolest = bolest;
	}
	public String getTerapija() {
		return terapija;
	}
	public void setTerapija(String terapija) {
		this.terapija = terapija;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	@Override
	public String toString() {
		return "Pregled [id=" + id + ", imeZivotinje=" + imeZivotinje + ", imeVeterinara=" + imeVeterinara
				+ ", prezimeVeterinara=" + prezimeVeterinara + ", bolest=" + bolest + ", terapija=" + terapija
				+ ", datum=" + datum + ", cena=" + cena + ", vrsta=" + vrsta + "]";
	}
	
	
	
	
	

}
