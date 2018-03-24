package id.noeandfriends.eproc.model.external;

public class InhouseTransferResponsePayload {
	
	private boolean success;
	private String ref_number;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getRef_number() {
		return ref_number;
	}
	public void setRef_number(String ref_number) {
		this.ref_number = ref_number;
	}
	
	
}
