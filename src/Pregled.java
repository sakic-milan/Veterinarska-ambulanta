

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pregled {
	
	// atributi
	private int id; // >0
	private String ime;
	private String veterinarIme;
	private String veterinarPrezime;
	private String bolest;
	private String terapija;
	private LocalDate datum;
	private double cena; //>0
	private String vrsta; //pas, macka, ptica, ribica, kornjaca, gmizavac, ostalo
	
	
	// konstruktori
	
	public Pregled() {
	}
	
	public Pregled(int id, String ime, String bolest) {
		this.id = id;
		this.ime = ime;
		this.bolest = bolest;
	}
	
	
	public Pregled(int id, String ime, String veterinarIme, String veterinarPrezime, String bolest, String terapija,
			LocalDate datum, double cena, String vrsta) {
		this.id = id;
		this.ime = ime;
		this.veterinarIme = veterinarIme;
		this.veterinarPrezime = veterinarPrezime;
		this.bolest = bolest;
		this.terapija = terapija;
		this.datum = datum;
		this.cena = cena;
		this.vrsta = vrsta;
	}
	
	// getteri i setteri

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getVeterinarIme() {
		return veterinarIme;
	}

	public void setVeterinarIme(String veterinarIme) {
		this.veterinarIme = veterinarIme;
	}

	public String getVeterinarPrezime() {
		return veterinarPrezime;
	}

	public void setVeterinarPrezime(String veterinarPrezime) {
		this.veterinarPrezime = veterinarPrezime;
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
	
	
	// toString
	
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		return String.format("%-6d %-14s %-14s %-14s %-14s %-14s %-14s %-10.2f %-12s", id, ime, 
					veterinarIme, veterinarPrezime, bolest, terapija, dtf.format(datum), cena, vrsta);
	}
	
	
	
	
	

}
