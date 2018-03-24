package id.noeandfriends.eproc.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "procurements")
public class Procurement {
	@Id
	private String id;
	private String title;		// judul
	private String description;	// deskripsi singkat
	private String alamat;		// alamat
	private User user;			// orang yang buat 
	private Date created;		// tanggal dibuat
	private Date dueDate;		// tanggal deadline
	private String layoutURL;	// url layout rumah
	private String filePendukungURL;		// url file pendukung
	private String lainlain;		// Notes dari user
	@DBRef
	private Procurement accepted;	// proposal id that is accepted by user
	private Date acceptedDate;	// tanggal diterima
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
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getLayoutURL() {
		return layoutURL;
	}
	public void setLayoutURL(String layoutURL) {
		this.layoutURL = layoutURL;
	}
	public String getFilePendukungURL() {
		return filePendukungURL;
	}
	public void setFilePendukungURL(String filePendukungURL) {
		this.filePendukungURL = filePendukungURL;
	}
	public String getLainlain() {
		return lainlain;
	}
	public void setLainlain(String lainlain) {
		this.lainlain = lainlain;
	}
	public Date getAcceptedDate() {
		return acceptedDate;
	}
	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}
	public Procurement getAccepted() {
		return accepted;
	}
	public void setAccepted(Procurement accepted) {
		this.accepted = accepted;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
