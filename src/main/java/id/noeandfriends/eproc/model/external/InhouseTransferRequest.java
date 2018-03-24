package id.noeandfriends.eproc.model.external;

public class InhouseTransferRequest {
	
	private String rekening_asal;
	private String rekening_tujuan;
	private double amount;
	public String getRekening_asal() {
		return rekening_asal;
	}
	public void setRekening_asal(String rekening_asal) {
		this.rekening_asal = rekening_asal;
	}
	public String getRekening_tujuan() {
		return rekening_tujuan;
	}
	public void setRekening_tujuan(String rekening_tujuan) {
		this.rekening_tujuan = rekening_tujuan;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
