package id.noeandfriends.eproc.model.external;

public class Transaction {
	
	private int type;
	private double debit;
	private double credit;
	private double saldo;
	private String date;
	private String time;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
