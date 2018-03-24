package id.noeandfriends.eproc.model;

public class Account {
	
	private String userId;
	private String nama;
	private String nomorRekening;
	private double saldo;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNomorRekening() {
		return nomorRekening;
	}
	public void setNomorRekening(String nomorRekening) {
		this.nomorRekening = nomorRekening;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
