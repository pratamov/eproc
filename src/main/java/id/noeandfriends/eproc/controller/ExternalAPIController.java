package id.noeandfriends.eproc.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import id.noeandfriends.eproc.model.external.AccountCreationRequest;
import id.noeandfriends.eproc.model.external.AccountCreationResponsePayload;
import id.noeandfriends.eproc.model.external.ApiResponse;
import id.noeandfriends.eproc.model.external.BalanceInformationRequest;
import id.noeandfriends.eproc.model.external.BalanceInformationResponsePayload;
import id.noeandfriends.eproc.model.external.UserRegisterRequest;
import id.noeandfriends.eproc.model.external.UserRegisterResponsePayload;

public class ExternalAPIController {
	
	private String endpoint(String serviceName) {
		return "http://mortgtech-eval-prod.apigee.net/btn-mortgtech/" + serviceName;
	}
	
	public ApiResponse<UserRegisterResponsePayload> userRegister(UserRegisterRequest request){
		
		String endpoint = endpoint("user-register");
		
		HttpEntity<UserRegisterRequest> httpEntity = new HttpEntity<>(request);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<UserRegisterResponsePayload> response = 
				restTemplate.exchange(
						endpoint , HttpMethod.POST, httpEntity, 
						new ParameterizedTypeReference<ApiResponse<UserRegisterResponsePayload>>() {}).getBody();
		
		return response;
	}
	
	public ApiResponse<AccountCreationResponsePayload> accountCreation(AccountCreationRequest request){
		
		String endpoint = endpoint("account-creation");
		
		HttpEntity<AccountCreationRequest> httpEntity = new HttpEntity<>(request);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<AccountCreationResponsePayload> response = 
				restTemplate.exchange(
						endpoint , HttpMethod.POST, httpEntity, 
						new ParameterizedTypeReference<ApiResponse<AccountCreationResponsePayload>>() {}).getBody();
		
		return response;
		
	}
	
	public ApiResponse<BalanceInformationResponsePayload> balanceInformation(BalanceInformationRequest request){
		
		String endpoint = endpoint("balance-information");
		
		HttpEntity<BalanceInformationRequest> httpEntity = new HttpEntity<>(request);
		
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse<BalanceInformationResponsePayload> response = 
				restTemplate.exchange(
						endpoint , HttpMethod.POST, httpEntity, 
						new ParameterizedTypeReference<ApiResponse<BalanceInformationResponsePayload>>() {}).getBody();
		
		return response;
	}
	
}
