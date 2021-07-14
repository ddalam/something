package com.example.Something.firstService.controller;

import com.example.Something.firstService.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	 * 리소스를 생성
	 * Request body 를 JSON 형태로 받을 때
	 * - 컨트롤러 메서드의 파라미터로 @RequestBody Annotation 을 사용해 받을 수 있다
	 * - Map 으로 받을 수도 있다. (@RequestBody Map<String, Object> requestData) 이 때는 value 는 [], {}, boolean 등 다양한 값이 될 수 있기 때문에 Object 로 받았다 -> 단점은 key 값을 알 수 없다
	 * - DTO 매핑을 사용할 수 있다 (@RequestBody UserRequest userRequest) -> Query Parameter 를 DTO 로 받을 때는 @RequestParam 을 사용하지 않아도 됐지만, @RequestBody 는 붙여줘야 된다
	 *
	 * JSON 의 key 와 DTO 의 변수명이 매핑이 되는데,
	 * JSON 은 snake case 를 사용하고, Java 는 camel case 를 사용한다 -> 따라서, 매핑하지 못하는 경우가 있는데
	 * 이 때 해결하는 방법은
	 * - DTO 의 각 변수에 @JsonProperty("phone_number") 이렇게 일일이 지정할 수 있다 -> 일일이 지정해야 하는 단점이 있다. 하지만 OTP 와 같은 약어나 어떤 케이스인지 구분하기 어려운 경우에는 직접 지정하는 방법이 필요하다
	 * - DTO 클래스 전체에 같은 룰을 적용시킬 수 있다 @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class) 이 외 더 다양한 값을 사용할 수 있다.
	 *
	 * RestController 에서는
	 * DTO 를 받을 때와 마차간지로 객체를 API 의 응답으로 객체를 return 하면 설정에 따라 (@JsonNaming or @JsonProperty 와 같은) 객체를 JSON으로 바꿔 응답해준다
	 *
	 * json (request) -> object mapper -> object -> 비즈니스 로직 -> return object -> obejct mapper -> json (response)
	 */
	@PostMapping("")
	public void post() {

	}

	/**
	 * POST 메서드와 같이 주로 @RequestBody 를 받아 처리한다
	 * 리소스가 없으면 생성, 있으면 전체 리소스 값을 덮어씌울 경우에 사용한다
	 *
	 * POST와 PUT의 가장 큰 차이점은 PUT은 클라이언트가 리소스의 전체 경로를 알고 요청한다는 것이다
	 *
	 * 201 상태 코드로 응답을 주려면 -> ResponseEntity<> 를 사용한다
	 *
	 * 정리하면, Response를 주는 방법은
	 * - 그냥 단일 값 ex) String, Integer, Boolean, ...
	 * - JSON -> 객체를 리턴하는 방법으로 처리 가능
	 * - 위 두 방법은 성공하면 200 OK 로 HTTP 상태 코드가 설정되는데, 특정 상태 코드로 응답을 주고싶을 때 -> ResponseEntity<>
	 * - @Controller 같은 경우에는 html 파일을 응답으로 리턴하는데 return type 은 String 이고, resource 디렉토리 아래 return String 과 일치하는 html 파일을 리턴한다 (참고 : PageController)
	 * - @Controller에서 JSON을 리턴하고 싶을 때는 컨트롤러 메서드에 @ResponseBody Annotaion을 붙여준다 (참고 : PageController). @Controller Annotation은 String을 리턴하면 리소스를 찾게 되지만, @ResponseBody를 붙여주면 객체를 리턴했을 때 리소스를 찾거나 하지 않고 response body 를 만들어 응답해준다
	 *
	 * ResponseEntity의 body 부분은 JSON으로 바뀜
	 * header를 추가할 수도 있다
	 */
	@PutMapping("")
	public ResponseEntity<UserRequest> put(@RequestBody UserRequest userRequest) {

		return ResponseEntity.status(HttpStatus.CREATED).body(userRequest);
	}

	/**
	 * 만약 삭제를 요청한 리소스가 없어도 리소스가 없다는 에러를 던지는게 아니라 200 OK 로 응답한다.
	 * 왜냐하면, Delete가 삭제를 요청한 것이기 때문에 없어도, 있어도 결국 없어야 할 리소스이기 때문이다.
	 */
	@DeleteMapping("/{userId}")
	public void delete(@PathVariable String userId) {

	}
}
