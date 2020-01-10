package wuerfler;

public class SpielSteuerung {

	private GUI dieGUI; // dieGUI
	private int gesamtPunkte;
	private int anzahlWuerfe;
	private Muenze dieMuenzen[] = new Muenze[2];

	public SpielSteuerung(GUI pGUI) {
		gesamtPunkte = 0;
		anzahlWuerfe = 0;
		dieGUI = pGUI;
		dieMuenzen[0] = new Muenze();
		dieMuenzen[1] = new Muenze();
	}

	public void werfeMuenzen() {
		anzahlWuerfe += 1;

		dieMuenzen[0].werfen();
		dieMuenzen[1].werfen();
		berechnePunktzahl(dieMuenzen[0].gibLetzterWurf(), dieMuenzen[1].gibLetzterWurf());

		aktualisiereAnzeige();
	}

	private void berechnePunktzahl(int P1, int P2) {
		if (P1 == P2) {
			if (P1 == 1) {
				gesamtPunkte += 3;
			} else {
				gesamtPunkte += 1;
			}
		} else {
			gesamtPunkte -= 1;
		}
	}

	private void aktualisiereAnzeige() {
		dieGUI.anzeigenMuenze1(dieMuenzen[0].gibLetzterWurf());
		dieGUI.anzeigenMuenze2(dieMuenzen[1].gibLetzterWurf());

		dieGUI.anzeigenPunkte(gesamtPunkte);
		dieGUI.anzeigenAnzahlWuerfe(anzahlWuerfe);
	}

}
