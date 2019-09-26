package testvezbanje;

public class Pitanje {
	private String naziv;
	private int brPoena;
	private PonudjeniOdgovor[] odgovori;
	private int brOdgovora = 0;

	public Pitanje(String naziv, int brPoena) {
		this.naziv = naziv;
		this.brPoena = brPoena;
		odgovori = new PonudjeniOdgovor[5];
	}

	public void dodajOdgovor(PonudjeniOdgovor po) {
		if (po.isTacan()) {
			for (int i = 0; i < brOdgovora; i++) {
				if (odgovori[i].isTacan()) {
					System.out.println("Greska");
					return;
				}
			}
		}
		if (brOdgovora < odgovori.length) {
			odgovori[brOdgovora++] = po;
		} else {
			PonudjeniOdgovor[] odgovori2 = new PonudjeniOdgovor[2 * odgovori.length];
			for (int i = 0; i < odgovori.length; i++) {
				odgovori2[i] = odgovori[i];
			}
			odgovori = odgovori2;
			odgovori[brOdgovora++] = po;
		}

	}

	public String getNaziv() {
		return naziv;
	}

	public int getBrPoena() {
		return brPoena;
	}

	public PonudjeniOdgovor getOdgovor(int redBr) {
		redBr--;
		if (redBr < 0 || redBr >= brOdgovora) {
			System.out.println("Pogresan unos");
			return null;
		} else {
			return odgovori[redBr];
		}
	}

	public int odgovoriNaPitanje(int redBr) {
		redBr--;
		if (redBr < 0 || redBr >= brOdgovora) {
			System.out.println("Pogresan unos");
			return 0;
		} else if (odgovori[redBr].isTacan()) {
			return brPoena;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv + " (" + brPoena + ")");
		for (int i = 0; i < brOdgovora; i++) {
			sb.append("\n\t" + (i + 1) + ". " + odgovori[i].toString());
		}
		return sb.toString();
	}

}
