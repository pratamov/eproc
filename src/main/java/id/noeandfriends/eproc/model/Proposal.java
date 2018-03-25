package id.noeandfriends.eproc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proposals")
public class Proposal {
	@Id
	private String id;
	private String title;
	private String description;
	@DBRef
	private Procurement procurement;	// corresponds to which procurement
	private User contractor;				// creator of this proposal
	private String proposalURL;			// url dokumen proposal
	private int harga;					// proposed price
	private int durasiPengerjaan;		// prososed durasi pengerjaan dalam bulan
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getContractor() {
		return contractor;
	}
	public void setContractor(User contractor) {
		this.contractor = contractor;
	}
	public String getProposalURL() {
		return proposalURL;
	}
	public void setProposalURL(String proposalURL) {
		this.proposalURL = proposalURL;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public int getDurasiPengerjaan() {
		return durasiPengerjaan;
	}
	public void setDurasiPengerjaan(int durasiPengerjaan) {
		this.durasiPengerjaan = durasiPengerjaan;
	}
	public Procurement getProcurement() {
		return procurement;
	}
	public void setProcurement(Procurement procurement) {
		this.procurement = procurement;
	}
	
}
