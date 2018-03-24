package id.noeandfriends.eproc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String instansi;		// nama instansi
	private String npwp;			// nomer npwp
	private String ppURL;			// url profile picture
	private int userType;			// user type: 1: User biasa, 2: Kontraktor
	private double rating;
	private double balance;
	private String nomorRekening;
	private String kodeVirtualAccount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInstansi() {
		return instansi;
	}
	public void setInstansi(String instansi) {
		this.instansi = instansi;
	}
	public String getNpwp() {
		return npwp;
	}
	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}
	public String getPpURL() {
		return ppURL;
	}
	public void setPpURL(String ppURL) {
		this.ppURL = ppURL;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getNomorRekening() {
		return nomorRekening;
	}
	public void setNomorRekening(String nomorRekening) {
		this.nomorRekening = nomorRekening;
	}
	public String getKodeVirtualAccount() {
		return kodeVirtualAccount;
	}
	public void setKodeVirtualAccount(String kodeVirtualAccount) {
		this.kodeVirtualAccount = kodeVirtualAccount;
	}
	
}
