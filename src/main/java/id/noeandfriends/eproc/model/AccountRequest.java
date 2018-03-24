package id.noeandfriends.eproc.model;

public class AccountRequest {
	
	private int nik;
	private String nama;
	private String tglLahir;
	private String namaIbuKandung;
	private double amount;
	
	public int getNik() {
		return nik;
	}
	public void setNik(int nik) {
		this.nik = nik;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(String tglLahir) {
		this.tglLahir = tglLahir;
	}
	public String getNamaIbuKandung() {
		return namaIbuKandung;
	}
	public void setNamaIbuKandung(String namaIbuKandung) {
		this.namaIbuKandung = namaIbuKandung;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
