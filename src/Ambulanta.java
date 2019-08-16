import java.util.ArrayList;

public class Ambulanta {
	
	private String naziv;
	private String adresa;
	private String pib;
	private ArrayList<Pregled> pregledi = new ArrayList<>();
	
	public Ambulanta() {
		super();
	}

	public Ambulanta(String naziv, String adresa, String pib) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public ArrayList<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(ArrayList<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	@Override
	public String toString() {
		return String.format("Naziv: %s\nAdresa: %s\nPib: %s", naziv, adresa, pib);
	}
	
	public static void header() {
		System.out.printf("%-6d %-14s %-14s %-14s %-14s %-14s %-14s "
				+ "%-10.2f %-14s ", "Id", "Ime zivotinje", "Ime Veterinara", "Prezime Veterinara",
				"Bolest", "Terapija", "Datum", "Cena", "Vrsta");
		System.out.println("------------------------------------------------------------"
				+ "-------------------------------------------------------");
	}
	
	// ispis svih pregleda
	public void ispis() {
		header();
		for (Pregled temp : pregledi) {
			System.out.println(temp);
		}
	}
	
	
	// provera za dodavanje pregleda
	public boolean dodaj(Pregled add) {
		for (Pregled temp : pregledi) {
			if (temp.getId() == add.getId()) {
				return false;
			}
		}
		pregledi.add(add);
		return true;
	}
	
	// izmena
	public Pregled izmena(Pregled replace) {
		
		for (Pregled temp : pregledi) {
			if (temp.getId() == replace.getId()) {
				pregledi.set(temp.getId(), replace);
				return temp;
			}
		}	
		return null;	
	}
	
	public Pregled brisanje(int id) {
		for (Pregled temp : pregledi) {
			if (temp.getId() == id) {
				pregledi.remove(temp);
				return temp;
			}
		}
		return null;
	}
	
	
	
	
	

}
