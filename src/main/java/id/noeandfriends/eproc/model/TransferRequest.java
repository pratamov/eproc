package id.noeandfriends.eproc.model;

public class TransferRequest {
	private double amount;
	private String rekeningTujuan;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRekeningTujuan() {
		return rekeningTujuan;
	}
	public void setRekeningTujuan(String rekeningTujuan) {
		this.rekeningTujuan = rekeningTujuan;
	}
	
}
