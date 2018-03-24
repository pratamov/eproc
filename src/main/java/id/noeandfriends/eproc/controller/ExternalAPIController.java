package id.noeandfriends.eproc.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import id.noeandfriends.eproc.model.external.AccountCreationRequest;
import id.noeandfriends.eproc.model.external.AccountCreationResponsePayload;
import id.noeandfriends.eproc.model.external.AccountStatementRequest;
import id.noeandfriends.eproc.model.external.AccountStatementResponsePayload;
import id.noeandfriends.eproc.model.external.ApiErrorResponsePayload;
import id.noeandfriends.eproc.model.external.ApiResponse;
import id.noeandfriends.eproc.model.external.AtmLocationRequest;
import id.noeandfriends.eproc.model.external.AtmLocationResponsePayload;
import id.noeandfriends.eproc.model.external.BalanceInformationRequest;
import id.noeandfriends.eproc.model.external.BalanceInformationResponsePayload;
import id.noeandfriends.eproc.model.external.InhouseTransferRequest;
import id.noeandfriends.eproc.model.external.InhouseTransferResponsePayload;
import id.noeandfriends.eproc.model.external.UserRegisterRequest;
import id.noeandfriends.eproc.model.external.UserRegisterResponsePayload;
import id.noeandfriends.eproc.model.external.VaCreationRequest;
import id.noeandfriends.eproc.model.external.VaCreationResponsePayload;

public class ExternalAPIController {
	
	public static final String APIKEY = "YB6d8eqSxLoqaG1pExGKUnjd9kzGbsC7";
	
	private String endpoint(String serviceName) {
		return "http://mortgtech-eval-prod.apigee.net/btn-mortgtech/" + serviceName;
	}
	
	public ApiResponse<UserRegisterResponsePayload> userRegister(UserRegisterRequest request){
		
		String endpoint = endpoint("user-register");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<UserRegisterRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ApiResponse<UserRegisterResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<UserRegisterResponsePayload>>() {}).getBody();
			
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		
		return response;
	}
	
	public ApiResponse<AccountCreationResponsePayload> accountCreation(AccountCreationRequest request){
		
		String endpoint = endpoint("account-creation");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<AccountCreationRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		ApiResponse<AccountCreationResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<AccountCreationResponsePayload>>() {}).getBody();
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		return response;
		
	}
	
	public ApiResponse<BalanceInformationResponsePayload> balanceInformation(BalanceInformationRequest request){
		
		String endpoint = endpoint("balance-information");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<BalanceInformationRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<BalanceInformationResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<BalanceInformationResponsePayload>>() {}).getBody();
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		return response;
	}
	
	public ApiResponse<InhouseTransferResponsePayload> inhouseTransfer(InhouseTransferRequest request){
		
		String endpoint = endpoint("inhouse-transfer");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<InhouseTransferRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<InhouseTransferResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<InhouseTransferResponsePayload>>() {}).getBody();
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		return response;
		
	}
	
	public ApiResponse<AccountStatementResponsePayload> accountStatement(AccountStatementRequest request){
		
		String endpoint = endpoint("account-statement");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<AccountStatementRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<AccountStatementResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<AccountStatementResponsePayload>>() {}).getBody();
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		
		return response;
		
	}
	
	public ApiResponse<VaCreationResponsePayload> vaCreation(VaCreationRequest request){
		
		String endpoint = endpoint("account-statement");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<VaCreationRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<VaCreationResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<VaCreationResponsePayload>>() {}).getBody();
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		
		return response;
		
	}
	
	public ApiResponse<AtmLocationResponsePayload> atmLocation(AtmLocationRequest request){
		
		String endpoint = endpoint("atm-location");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", APIKEY);
		
		HttpEntity<AtmLocationRequest> httpEntity = new HttpEntity<>(request, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<AtmLocationResponsePayload> response = new ApiResponse<>();
		
		try {
			response = restTemplate.exchange(
				endpoint , HttpMethod.POST, httpEntity, 
				new ParameterizedTypeReference<ApiResponse<AtmLocationResponsePayload>>() {}).getBody();
		}
		catch (HttpServerErrorException exception) {
			ApiResponse<ApiErrorResponsePayload> error =
					restTemplate.exchange(
							endpoint , HttpMethod.POST, httpEntity, 
							new ParameterizedTypeReference<ApiResponse<ApiErrorResponsePayload>>() {}).getBody();
			
			response.setStatus(error.getPayload().getErrors().get(0).getMessage());
			response.setStatusCode(error.getStatusCode());
		}
		
		return response;
		
	}
	
}
