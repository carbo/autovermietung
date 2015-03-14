package model;

public class KFZ {
	@Override
	public String toString() {
		return "KFZ [Kennzeichen=" + kennzeichen + ", KMStand=" + KMStand
				+ ", KMSeitInsp=" + KMSeitInsp + ", AbstandInsp=" + AbstandInsp
				+ ", frei=" + frei + ", Preis=" + Preis + "]";
	}

	String kennzeichen;
	int KMStand;
	int KMSeitInsp;
	int AbstandInsp;
	boolean frei;
	int Preis;

	public KFZ(String Kennz, int KM) {
		kennzeichen = Kennz;
		KMStand = KM;
		KMSeitInsp = KM;
		frei = true;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public int getKMStand() {
		return KMStand;
	}

	public void setKMStand(int kMStand) {
		KMStand = kMStand;
	}

	public int getKMSeitInsp() {
		return KMSeitInsp;
	}

	public void setKMSeitInsp(int kMSeitInsp) {
		KMSeitInsp = kMSeitInsp;
	}

	public int getAbstandInsp() {
		return AbstandInsp;
	}

	public void setAbstandInsp(int abstandInsp) {
		AbstandInsp = abstandInsp;
	}

	public boolean isFrei() {
		return frei;
	}

	public void setFrei(boolean frei) {
		this.frei = frei;
	}

	public int getPreis() {
		return Preis;
	}

	public void setPreis(int preis) {
		Preis = preis;
	}
}
