package com.example.Something.restTemplate;

import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ClientService {

	public UserResponse getRequest() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user")
				.queryParam("name", "steve")
				.queryParam("age", 10)
				.encode()
				.build()
				.toUri();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class); // client - server로 요청하는 지점
		ResponseEntity<UserResponse> entity = restTemplate.getForEntity(uri, UserResponse.class);

		System.out.println(entity.getStatusCode());
		System.out.println(entity.getBody());

		return entity.getBody();
	}

	public UserResponse postRequest() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand(100, "steve") // 순서대로 path variable과 매칭 ( build() 대신 buildAndExpand() 도 사용 가능 )
				.toUri();

		// request body : object -> object mapper -> json -> rest template -> http body json
		UserRequest request = new UserRequest();
		request.setName("steve");
		request.setAge(10);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> entity = restTemplate.postForEntity(uri, request, UserResponse.class);

		return entity.getBody();
	}

	public UserResponse exchange() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand(100, "steve")
				.toUri();

		UserRequest request = new UserRequest();
		request.setName("steve");
		request.setAge(10);

		RequestEntity<UserRequest> requestEntity = RequestEntity
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "abcd")
				.header("custom-header", "ffff") // headers로 넣어도 된다
				.body(request);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> entity = restTemplate.exchange(requestEntity, UserResponse.class);

		return entity.getBody();
	}

}
