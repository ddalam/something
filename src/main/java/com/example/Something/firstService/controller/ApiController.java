package com.example.Something.firstService.controller;

import com.example.Something.firstService.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 해당 Class 는 REST API 를 처리하는 Controller
@RequestMapping("/api")	// URI 를 지정해주는 Annotation
public class ApiController {

	/**
	 * 주소 매핑은
	 * @GetMapping("/hello") 이렇게 할 수도 있고,
	 * 명시적으로 @GetMapping(path = "/hello") 이렇게 할 수도 있다
	 *
	 * 주소에는 대문자를 사용하지 않는다. ex) /hello/pathVariable (X)  /hello/path-variable (O)
	 *
	 * Path Variable : 변화하는 값들을 받을 때
	 * - 컨트롤러 메서드의 파라미터로 @PathVariable Annotation 을 사용해 변수로 받을 수 있다
	 * - URI {} 안에 명시한 이름과 컨트롤러 메서드 파라미터명을 일치시켜야 한다
	 * - 만약 일치시키기 어려울 때는 @PathVariable(name = "name") String path 와 같이 name 속성을 사용한다
	 *
	 * Query Parameter : URI 의 ? 뒤 key = value & 연산자로 연결된 내용을 받을 때
	 * - 컨트롤러 메서드의 파라미터로 @RequestParam Annotation 을 사용해 받을 수 있다
	 * - Map 을 통해 받을 수 있고 (@RequestParam Map<String, String> queryParam) -> 딘점은 key 값을 알 수 없다
	 * - Query Parameter 를 하나씩 변수로 받을 수도 있다 (@RequestParam String name, @RequestParam int age) -> 단점은 변수가 많아지면 모두 선언해야 하고, 메서드 파라미터의 길이가 길어진다
	 * - DTO 매핑을 사용할 수 있다 (UserRequest userRequest) 이 때는 @RequestParam 을 사용하지 않는다. Query Parameter 의 key 와 DTO 의 변수명의 매핑해서 스프링이 알아서 값을 세팅한다.
	 * @return
	 */
	@GetMapping("/{name}")
	public String get(@PathVariable String name, UserRequest userRequest) {

		StringBuilder sb = new StringBuilder();

//		queryParam.entrySet().forEach( entry -> {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//
//			sb.append(entry.getKey()).append(" : ").append(entry.getValue());
//		});

		sb.append(userRequest.getName()).append(userRequest.getEmail()).append(userRequest.getAge());

		return sb.toString();
	}

	/**
	 * Request body 를 JSON 형태로 받을 때
	 * - 컨트롤러 메서드의 파라미터로 @RequestBody Annotation 을 사용해 받을 수 있다
	 * - Map 으로 받을 수도 있다. (@RequestBody Map<String, Object> requestData) 이 때는 value 는 [], {}, boolean 등 다양한 값이 될 수 있기 때문에 Object 로 받았다 -> 단점은 key 값을 알 수 없다
	 * - DTO 매핑을 사용할 수 있다 (@RequestBody UserRequest userRequest) -> Query Parameter 를 DTO 로 받을 때는 @RequestParam 을 사용하지 않아도 됐지만, @RequestBody 는 붙여줘야 된다
	 *
	 * JSON 의 key 와 DTO 의 변수명이 매핑이 되는데,
	 * JSON 은 snake case 를 사용하고, Java 는 camel case 를 사용한다 -> 따라서, 매핑하지 못하는 경우가 있는데
	 * 이 때 해결하는 방법은
	 * - DTO 의 각 변수에 @JsonProperty("phone_number") 이렇게 일일이 지정할 수 있다 -> 일일이 지정해야 하는 단점이 있다. 하지만 OTP 와 같은 약어나 어떤 케이스인지 구분하기 어려운 경우에는 직접 지정하는 방법이 필요하다
	 *
	 */
	@PostMapping("")
	public void post() {

	}

	@PutMapping("")
	public void put() {
		
	}
}
