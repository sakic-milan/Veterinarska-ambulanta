
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ambulanta {
	
	//atributi
	private String naziv;
	private String adresa;
	private String pib;
	private ArrayList<Pregled> listaPregleda = new ArrayList<Pregled>();
	
	// konstruktori
	public Ambulanta() {
	}
	
	
	public Ambulanta(String naziv, String adresa, String pib) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
	}


	// getteri i setteri
	
	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
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


	public ArrayList<Pregled> getListaPregleda() {
		return listaPregleda;
	}


	public void setListaPregleda(ArrayList<Pregled> listaPregleda) {
		this.listaPregleda = listaPregleda;
	}
	
	
	// toString
	
	public String toString() {
		return String.format("Naziv: %s \nAdresa: %s \nPIB: %s", this.naziv, this.adresa, this.pib);
	}
	
	
	// header 
	
	public void header() {
		System.out.printf("%-6s %-14s %-14s %-14s %-14s %-14s %-14s %-10s %-12s\n", "ID", "IME", 
				"Vet. IME", "Vet. PREZIME", "BOLEST", "TERAPIJA", "DATUM", "CENA", "VRSTA");
				System.out.println("------------------------------------------------------------"
						+ "-------------------------------------------------------");
	}
	
	
	//ispis
	
	public void ispis() {
		header();
		for (int i = 0; i < listaPregleda.size(); i++) {
			System.out.println(listaPregleda.get(i));
		}
	}
	
	
	// dodavanje
	
	public boolean dodaj(Pregled pregled) {
		for (int i = 0; i < listaPregleda.size(); i++) {
			if (listaPregleda.get(i).getId() == pregled.getId()) {
				return false;
			}
		}
		listaPregleda.add(pregled);
		return true;
	}
	
	// izmena
	
	public Pregled izmena(Pregled novi) {
		for (int i = 0; i < listaPregleda.size(); i++) {
			if (listaPregleda.get(i).getId() == novi.getId()) {
				Pregled stari = listaPregleda.set(i, novi);
				return stari;
			}
		}
		return null;
	}
	
	
	//brisanje
	
	public Pregled brisanje(int id) {
		for (int i = 0; i < listaPregleda.size(); i++) {
			if (listaPregleda.get(i).getId() == id) {
				Pregled obrisan = listaPregleda.remove(i);
				return obrisan;
			}
		}
		return null;
	}
	
	
	
	
	// save
	
	public void save(String path) {
		
		ArrayList<String> zaUpis = new ArrayList <>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		for (int i = 0; i < listaPregleda.size(); i++) {
			Pregled temp = listaPregleda.get(i);
			
			int id = temp.getId(); 
			String ime = temp.getIme();
			String veterinarIme = temp.getVeterinarIme();
			String veterinarPrezime = temp.getVeterinarPrezime();
			String bolest = temp.getBolest();
			String terapija = temp.getTerapija();
			LocalDate datum = temp.getDatum();
			double cena = temp.getCena(); 
			String vrsta = temp.getVrsta(); 
			
			String datumString = dtf.format(datum);
			
			String line = id + ";" + ime + ";" + veterinarIme + ";" + veterinarPrezime + ";" + bolest + ";" + 
					terapija + ";" + datumString + ";" + cena + ";" + vrsta;
			
			zaUpis.add(line);		
		}
		
		
		try {
			Files.write(Paths.get(path), zaUpis, Charset.defaultCharset(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			System.out.println("Neuspesno cuvanje!");
		}
			
	}
	
	
	
	// load
	
	
	public void load(String path) {
		
		listaPregleda.clear();
		List<String> ucitani;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		try {
			ucitani = Files.readAllLines(Paths.get(path));
			
			for (String line : ucitani) {
				
				String[] atr = line.split(";");
				
				int id = Integer.parseInt(atr[0]); 
				String ime = atr[1];
				String veterinarIme = atr[2];
				String veterinarPrezime = atr[3];
				String bolest = atr[4];
				String terapija = atr[5];
				LocalDate datum = LocalDate.parse(atr[6], dtf);
				double cena =Double.parseDouble(atr[7]);
				String vrsta = atr[8]; 
				
				Pregled dodaj = new Pregled ( id,  ime,  veterinarIme,  veterinarPrezime,  bolest,  terapija,
						 datum,  cena,  vrsta);
				
				listaPregleda.add(dodaj);
			}
			
			
		} catch (IOException e) {
			System.out.println("Nema ucitanih stavki...");
		}
		
			
	}
	
	
	
	public void pretragaSadrzi(String unos) {
		header();		
		for (int i = 0; i < listaPregleda.size(); i++) {
			Pregled temp = listaPregleda.get(i);
			if (temp.getIme().toLowerCase().contains(unos.toLowerCase())) {
				System.out.println(temp);
			}		
		}
		
	}
	
	// pretraga 7. 3 ista atributa
	
	public void pretraga7(String vrsta,  String bolest, String terapija) {
		
		header();		
		for (int i = 0; i < listaPregleda.size(); i++) {
			Pregled temp = listaPregleda.get(i);
			if (temp.getVrsta().equals(vrsta) && temp.getBolest().equals(bolest) &&
					temp.getTerapija().equals(terapija)) {
				System.out.println(temp);
				
			}
		}
		
		
	}
	
	
	// procenti
	
	public double izracunavanjeProcenta(String imeVet, String  prezimeVet, LocalDate datumPoc, LocalDate datumKraj) {
		
		double zaradaVeterinara = 0;
		double ukupnaZarada = 0;
		
		
		for (int i = 0; i < listaPregleda.size(); i++) {
			Pregled temp = listaPregleda.get(i);
			
			if (temp.getDatum().compareTo(datumPoc) >= 0 && temp.getDatum().compareTo(datumKraj) <=0) {
				ukupnaZarada += temp.getCena();
			}
			if (temp.getDatum().compareTo(datumPoc) >= 0 && temp.getDatum().compareTo(datumKraj) <=0 &&
					temp.getVeterinarIme().equals(imeVet) && temp.getVeterinarPrezime().equals(prezimeVet)) {
				zaradaVeterinara += temp.getCena();
			}
			
		}
		
		if (ukupnaZarada == 0) {
			return 0;
		}else {
			return zaradaVeterinara/ukupnaZarada *100;
		}
		
				
	}
	
	
	// najcesci u ambulanti
	
	public void pretragaNajcesci(LocalDate datumPoc, LocalDate datumKraj){
		
		int pas = 0;
		int macka = 0;
		int ptica = 0;
		int ribica = 0;
		int kornjaca = 0;
		int gmizavac = 0;
		int ostalo = 0;
		
		
		
		
		ArrayList<Pregled> period = new ArrayList<>();
		
		for (int i = 0; i < listaPregleda.size(); i++) {
			Pregled temp = listaPregleda.get(i);
			if (temp.getDatum().compareTo(datumPoc) >= 0 && temp.getDatum().compareTo(datumKraj) <= 0) {
				period.add(temp);		
			}		
		}
		
		
		if (period.isEmpty()) {
			System.out.println("Nema pregleda u periodu!");
		}
		
		
		
		for (int i = 0; i < period.size() ; i++) {
			Pregled priv = period.get(i);
			if (priv.getVrsta().equals("pas")) {
				pas++;
			}
			if (priv.getVrsta().equals("macka")) {
				macka++;
			}
			if (priv.getVrsta().equals("ptica")) {
				ptica++;
			}
			if (priv.getVrsta().equals("ribica")) {
				ribica++;
			}
			if (priv.getVrsta().equals("kornjaca")) {
				 kornjaca++;
			}
			if (priv.getVrsta().equals("gmizavac")) {
				gmizavac++;
			}
			if (priv.getVrsta().equals("ostalo")) {
				ostalo++;
			}
				
		}
		
	
	}
	
	
	//najveci
	
	
	
	
	
	
	
	

}
