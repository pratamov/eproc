package id.noeandfriends.eproc.model.external;

public class AccountCreationRequest {
	
	private String nomor_cif;
	private double amount;
	public String getNomor_cif() {
		return nomor_cif;
	}
	public void setNomor_cif(String nomor_cif) {
		this.nomor_cif = nomor_cif;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
