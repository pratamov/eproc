package id.noeandfriends.eproc.model.external;

public class BalanceInformationResponsePayload {
	private int id_balance;
	private String nama;
	private String nomor_rekening;
	private double saldo;
	private String created_at;
	private String updated_at;
	public int getId_balance() {
		return id_balance;
	}
	public void setId_balance(int id_balance) {
		this.id_balance = id_balance;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNomor_rekening() {
		return nomor_rekening;
	}
	public void setNomor_rekening(String nomor_rekening) {
		this.nomor_rekening = nomor_rekening;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
}
