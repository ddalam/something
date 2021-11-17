package com.example.Something.structure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InfoTest {

	@LocalServerPort
	int port;

	RestTemplate client = new RestTemplate();

	@DisplayName("상속 관계에 있는 클래스를 return 했을 때 결과가 어떤 응답인지")
	@Test
	void test() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity entity = new HttpEntity(null, headers);
		ResponseEntity<Info> resp = client.exchange("http://localhost:8080/api/info", HttpMethod.GET, entity, Info.class);

		System.out.println(resp.getBody());
//		assertEquals("hello", resp.getBody());
	}
}