package id.noeandfriends.eproc.model.external;

import java.util.List;

public class ApiErrorResponsePayload {
	private List<Message> errors;

	public List<Message> getErrors() {
		return errors;
	}

	public void setErrors(List<Message> errors) {
		this.errors = errors;
	}
}
