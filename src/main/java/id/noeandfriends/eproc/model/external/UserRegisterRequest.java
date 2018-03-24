package id.noeandfriends.eproc.model.external;

public class UserRegisterRequest {
	
	private int nik;
	private String nama;
	private String tgl_lahir;
	private String nama_ibu_kandung;
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
	public String getTgl_lahir() {
		return tgl_lahir;
	}
	public void setTgl_lahir(String tgl_lahir) {
		this.tgl_lahir = tgl_lahir;
	}
	public String getNama_ibu_kandung() {
		return nama_ibu_kandung;
	}
	public void setNama_ibu_kandung(String nama_ibu_kandung) {
		this.nama_ibu_kandung = nama_ibu_kandung;
	}
	
	
}
