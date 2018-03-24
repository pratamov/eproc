package id.noeandfriends.eproc.model.external;

public class VaCreationRequest {
	
	private String nomor_rekening;
	private String kode_institusi;
	private double amount;
	public String getNomor_rekening() {
		return nomor_rekening;
	}
	public void setNomor_rekening(String nomor_rekening) {
		this.nomor_rekening = nomor_rekening;
	}
	public String getKode_institusi() {
		return kode_institusi;
	}
	public void setKode_institusi(String kode_institusi) {
		this.kode_institusi = kode_institusi;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
