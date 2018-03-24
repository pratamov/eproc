package id.noeandfriends.eproc.model.external;

public class VaCreationResponsePayload {
	
	private String va_code;
	private String nomor_rekening;
	private String kode_institusi;
	private double amount;
	private String status;
	private String expired;
	public String getVa_code() {
		return va_code;
	}
	public void setVa_code(String va_code) {
		this.va_code = va_code;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	
}
