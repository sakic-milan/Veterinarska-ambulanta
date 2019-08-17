
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
	
	public static Scanner sc = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	
	/*
	 * isDigit
	 */
	
	public static boolean isDigit(String unos, Ambulanta amb){
		try {
			int y = Integer.parseInt(unos);
			if (y <= 0) {
				return false;
			}
			for (int i = 0; i < amb.getListaPregleda().size() ;i++) {
				Pregled temp = amb.getListaPregleda().get(i);
				if (temp.getId() == y) {
					return false;
				}
			}	
			
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	/*
	 * provera izmena i brisanje
	 */
	
	public static boolean proveraIzmenaBrisanje(String unos, Ambulanta amb) {
		try {
			int y = Integer.parseInt(unos);
			if (y <= 0) {
				return false;
			}	
			for (int i = 0; i < amb.getListaPregleda().size() ;i++) {
				Pregled temp = amb.getListaPregleda().get(i);
				if (temp.getId() == y) {
					return true;
				}
			}		
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	/*
	 * isDate
	 */
	
	public static boolean isDate(String unos) {
		try {
			LocalDate.parse(unos, dtf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * isDouble && >=0
	 */
	
	public static boolean isDoubleAndPositive(String unos) {
		try {
			double x = Double.parseDouble(unos);			
			if (x > 0) {
				return true;
			}		
			return false;		
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	// unos opstih podataka
	
	private static void unosOpstih(Ambulanta amb) {
		System.out.println("Unesi naziv:");
		String naziv = sc.nextLine();
		amb.setNaziv(naziv);
		
		System.out.println("Unesi adresu:");
		String adresa = sc.nextLine();
		amb.setAdresa(adresa);
		
		System.out.println("Unesi PIB:");
		String pib = sc.nextLine();
		amb.setPib(pib);
		
		System.out.println("Uspesno upisano.");
		
	}
	
	
	//ispis
	
	public static void ispisivanje (Ambulanta amb) {
		amb.ispis();
	}
	
	//unos novog
	
	public static void unesiNovi(Ambulanta amb) {
		
		int id; // >0 , moze parse , ne postoji
		String idString; //pomocni
		String ime;
		String veterinarIme;
		String veterinarPrezime;
		String bolest;
		String terapija;
		LocalDate datum;
		String datumString;//pomocni
		double cena; //>0
		String cenaString;//pomocni
		String vrsta; //pas, macka, ptica, ribica, kornjaca, gmizavac, ostalo
		
		
		do {
			System.out.println("Unesi id:");
			idString = sc.nextLine();		
		}while(!isDigit(idString, amb));
		id = Integer.parseInt(idString);
		
		System.out.println("Unesi ime zivotinje:");
		ime = sc.nextLine();
		
		System.out.println("Unesi ime veterinara:");
		veterinarIme = sc.nextLine();
		
		System.out.println("Unesi prezime veterinara:");
		veterinarPrezime = sc.nextLine();
		
		System.out.println("Unesi bolest:");
		bolest = sc.nextLine();
		
		System.out.println("Unesi terapiju:");
		terapija = sc.nextLine();
		
		do {
			System.out.println("Unesi datum:");
			datumString = sc.nextLine();
		}while(!isDate(datumString));
		datum = LocalDate.parse(datumString, dtf);
		
		do {
			System.out.println("Unesi cenu:");
			cenaString = sc.nextLine();
		}while(!isDoubleAndPositive(cenaString));
		cena = Double.parseDouble(cenaString);
		
		do {
			System.out.println("Unesi vrstu:");
			vrsta = sc.nextLine();
		}while(!(  vrsta.equals("pas") || vrsta.equals("macka") || vrsta.equals("ptica") ||vrsta.equals("ribica") ||
				vrsta.equals("kornjaca") || vrsta.equals("gmizavac") || vrsta.equals("ostalo") ));
		
		
		Pregled novi = new Pregled(id, ime, veterinarIme, veterinarPrezime, bolest, terapija,
				 datum, cena, vrsta);
		
		boolean provera = amb.dodaj(novi);
		
		if (provera) {
			System.out.println("Dodato.");
		}else {
			System.out.println("Greska!");
		}
		
		
	}
	
	
	// izmena
	
	
	public static void izmena(Ambulanta amb) {
		
		int id; // >0 , moze parse, POSTOJI
		String idString; //pomocni
		String ime;
		String veterinarIme;
		String veterinarPrezime;
		String bolest;
		String terapija;
		LocalDate datum;
		String datumString;//pomocni
		double cena; //>0
		String cenaString;//pomocni
		String vrsta; //pas, macka, ptica, ribica, kornjaca, gmizavac, ostalo
		
		
		do {
			System.out.println("Unesi id:");
			idString = sc.nextLine();		
		}while(!proveraIzmenaBrisanje(idString, amb));
		id = Integer.parseInt(idString);
		
		System.out.println("Unesi ime zivotinje:");
		ime = sc.nextLine();
		
		System.out.println("Unesi ime veterinara:");
		veterinarIme = sc.nextLine();
		
		System.out.println("Unesi prezime veterinara:");
		veterinarPrezime = sc.nextLine();
		
		System.out.println("Unesi bolest:");
		bolest = sc.nextLine();
		
		System.out.println("Unesi terapiju:");
		terapija = sc.nextLine();
		
		do {
			System.out.println("Unesi datum:");
			datumString = sc.nextLine();
		}while(!isDate(datumString));
		datum = LocalDate.parse(datumString, dtf);
		
		do {
			System.out.println("Unesi cenu:");
			cenaString = sc.nextLine();
		}while(!isDoubleAndPositive(cenaString));
		cena = Double.parseDouble(cenaString);
		
		do {
			System.out.println("Unesi vrstu:");
			vrsta = sc.nextLine();
		}while(!(  vrsta.equals("pas") || vrsta.equals("macka") || vrsta.equals("ptica") ||vrsta.equals("ribica") ||
				vrsta.equals("kornjaca") || vrsta.equals("gmizavac") || vrsta.equals("ostalo") ));
		
		
		Pregled ubaciOvaj = new Pregled(id, ime, veterinarIme, veterinarPrezime, bolest, terapija,
				 datum, cena, vrsta);
		
		Pregled stari = amb.izmena(ubaciOvaj);
		
		if (stari == null){
			System.out.println("Greska!");
		}else {
			System.out.println("Uspesno izmenjeno");
		}
			
	}
	
	
	// brisanje
	
	public static void brisanje (Ambulanta amb) {
		int id;
		String idString;
	
		System.out.println("Unesi id za brisanje:");
		idString = sc.nextLine();
		
		id = Integer.parseInt(idString);
		
		Pregled obrisan = amb.brisanje(id);
		
		if (obrisan == null) {
			System.out.println("Neuspesno!");
		}else {
			System.out.println("Obrisano.");
		}
		
		
	}
	
	
	// pretraga, sadrzi string
	
	public static void ispisSadrzi(Ambulanta amb) {
		
		System.out.println("Unesi ime zivotinje:");
		String unos = sc.nextLine();
		
		amb.pretragaSadrzi(unos);
		
	}
	
	
	// ispis ista  VRSTA, BOLEST TERAPJIA 
	
	
	public static void triIstaZadata(Ambulanta amb) {
		
		System.out.println("Unesi vrstu:");
		String vrsta = sc.nextLine();
		
		System.out.println("Unesi boslest:");
		String bolest = sc.nextLine();
		
		System.out.println("Unesi terapiju:");
		String terapija = sc.nextLine();
		
		amb.pretraga7(vrsta, bolest, terapija);
		
	}
	
	// procenat zarade veterinara
	
	public static void procenatZarade(Ambulanta amb) {
		
		System.out.println("Unesi ime veterinara:");
		String imeVet = sc.nextLine();
		
		System.out.println("Prezime veterinara:");
		String prezimeVet = sc.nextLine();
		
		String datumPocString;
		LocalDate datumPoc;
		do {
			System.out.println("Pocetni datum:");
			datumPocString = sc.nextLine();
		}while(!isDate(datumPocString));
		datumPoc = LocalDate.parse(datumPocString, dtf);
		
		String datumKrajString;
		LocalDate datumKraj;
		do {
			System.out.println("Krajnji datum:");
			datumKrajString = sc.nextLine();
		}while(!isDate(datumKrajString));
		datumKraj = LocalDate.parse(datumKrajString, dtf);
		
		double procenat = amb.izracunavanjeProcenta(imeVet, prezimeVet, datumPoc, datumKraj);
		
		System.out.printf("Procenat je %-5.2f\n", procenat);
		
					
	}
	
	// tacka 9
	
	/*
	 * KOJA VRSTA ZIVOTINJE SE MAJCESCE JAVLJALA U PERIODU
	 * 
	 */
	
	public static void uslov9(Ambulanta amb) {
		
	
		String datumPocString;
		LocalDate datumPoc;
		do {
			System.out.println("Pocetni datum:");
			datumPocString = sc.nextLine();
		}while(!isDate(datumPocString));
		datumPoc = LocalDate.parse(datumPocString, dtf);
		
		String datumKrajString;
		LocalDate datumKraj;
		do {
			System.out.println("Krajnji datum:");
			datumKrajString = sc.nextLine();
		}while(!isDate(datumKrajString));
		datumKraj = LocalDate.parse(datumKrajString, dtf);
		
		amb.pretragaNajcesci(datumPoc, datumKraj);
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		
		
		Ambulanta povodac = new Ambulanta();
		povodac.load("pregledi.txt");
		
		String answer = null;
		
		do {

			System.out.println("Meni:");
			System.out.println("1. Unos podataka o ambulanti");
			System.out.println("2. Unos novog pregleda");
			System.out.println("3. Ispis svih pregleda");
			System.out.println("4. Izmena podataka o pregledu");
			System.out.println("5. Brisanje pregleda");
			System.out.println("6. Pretraga pregleda po zivotinji (contains)");
			System.out.println("7. Pretraga - ista vrsta, bolest, terapija (zadati)");
			System.out.println("8. Procenat zarade");
			System.out.println("9. "); /// po pola od 286. u Ambulanat klasi pokusano.
			System.out.println("10. Ispis opstih");

			answer = sc.nextLine();

			switch (answer) {
			case "1":
				unosOpstih(povodac);
				break;
			case "2":
				unesiNovi(povodac);
				povodac.save("pregledi.txt");
				break;
			case "3":
				ispisivanje(povodac);
				break;
			case "4":
				izmena(povodac);
				povodac.save("pregledi.txt");
				break;			
			case "5":
				brisanje(povodac);
				povodac.save("pregledi.txt");
				break;
			case "6":
				ispisSadrzi(povodac);
				break;
			case "7":
				triIstaZadata(povodac);
				break;
			case "8":
				procenatZarade(povodac);
				break;
			case "9":	// uradio do pola, morao sam menjati kompletan nacin rada...			
				break;
			case "10":
				System.out.println(povodac);
				break;
			case "x":
				break;
			default:
				System.out.println("Nepostojeca opcija!");
			}

		} while (!answer.equals("x"));
		
		
		povodac.save("pregledi.txt");
		
		
		
		
		

	}

}
