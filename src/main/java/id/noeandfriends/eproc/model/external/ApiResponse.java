package id.noeandfriends.eproc.model.external;

public class ApiResponse <PAYLOAD_TYPE> {
	
	private String status;
	private int statusCode;
	private PAYLOAD_TYPE payload;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public PAYLOAD_TYPE getPayload() {
		return payload;
	}
	public void setPayload(PAYLOAD_TYPE payload) {
		this.payload = payload;
	}
	
	
}
