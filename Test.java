package testvezbanje;

public class Test {
	private String naziv;
	private Pitanje[] nizPitanja;
	private static int ukupanBrojPoenaOstvarenNaTestu = 0;
	private static int ukupanBrojPoenaKojiNosiTest = 0;
	private int brPitanja = 0;
	public static double procenatPotrebanZaPolaganje = 0.5;

	public Test(String naziv) {
		this.naziv = naziv;
		nizPitanja = new Pitanje[5];
	}

	public void dodajPitanje(Pitanje p) {
		if (brPitanja < nizPitanja.length) {
			nizPitanja[brPitanja++] = p;
			ukupanBrojPoenaKojiNosiTest += p.getBrPoena();
		} else {
			Pitanje[] noviNiz = new Pitanje[2 * nizPitanja.length];
			for (int i = 0; i < nizPitanja.length; i++) {
				noviNiz[i] = nizPitanja[i];
			}
			nizPitanja = noviNiz;
			nizPitanja[brPitanja++] = p;
			ukupanBrojPoenaKojiNosiTest += p.getBrPoena();
		}
	}

	public Pitanje getPitanje(int redBr) {
		redBr--;
		if (redBr < 0 || redBr >= brPitanja) {
			System.out.println("Greska");
			return null;
		} else {
			return nizPitanja[redBr];
		}
	}

	public String getNaziv() {
		return naziv;
	}

	public static int getUkupanBrojPoenaOstvarenNaTestu() {
		return ukupanBrojPoenaOstvarenNaTestu;
	}

	public static int getUkupanBrojPoenaKojiNosiTest() {
		return ukupanBrojPoenaKojiNosiTest;
	}

	public int getBrPitanja() {
		return brPitanja;
	}

	public void odgovoriNaPitanje(int redBrPitanja, int redBrOdgovora) {
		if (nizPitanja[redBrPitanja].getOdgovor(redBrOdgovora).isTacan()) {
			ukupanBrojPoenaOstvarenNaTestu += nizPitanja[redBrPitanja].getBrPoena();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		for (int i = 0; i < brPitanja; i++) {
			sb.append("\n" + (i + 1) + ". " + nizPitanja[i].toString());
		}
		return sb.toString();
	}
}
