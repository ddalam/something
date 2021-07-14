package com.example.Something.firstService;

import com.example.Something.firstService.dto.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class ObjectMapperTest {

    @Test
    void objectMapperTest() throws JsonProcessingException {
        // object mapper : Text JSON -> Object / Object -> Text JSON 이렇게 바꿔주는 역할을 한다

        var objectMapper = new ObjectMapper();

        // object -> text : 이 때 object mapper는 get 메서드를 사용하기 때문에 객체에 get 메서드들이 정의되어 있어야 한다,
        // 만약 오브젝트를 텍스트로 구성하는 필드들의 값에 대한 get 메서드가 아닌 다른 메서드에 get 이 붙어있으면 예외가 발생한다
        var user = new UserRequest();
        user.setEmail("aa@aa.com");
        user.setName("aaa");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object : object mapper는 기본 생성자를 필요로 한다
        var objectUser = objectMapper.readValue(text, UserRequest.class);
        System.out.println(objectUser);
    }
}
