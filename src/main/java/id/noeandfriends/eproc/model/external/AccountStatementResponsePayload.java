package id.noeandfriends.eproc.model.external;

import java.util.List;

public class AccountStatementResponsePayload {
	
	private String nama;
	private String nomor_rekening;
	private List<Transaction> data_transaksi;
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
	public List<Transaction> getData_transaksi() {
		return data_transaksi;
	}
	public void setData_transaksi(List<Transaction> data_transaksi) {
		this.data_transaksi = data_transaksi;
	} 
	
}
