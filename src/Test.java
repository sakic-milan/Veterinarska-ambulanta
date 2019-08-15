import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {

		LocalDate dt = LocalDate.now();
		
		Pregled testPregled = new Pregled(1, "Lesi", "Nikola", "Nikolic", "vaske", 
				"inekcija", dt, 650.0, "pas");
		
		System.out.println(testPregled);
		
		
	}

}
