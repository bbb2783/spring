package com.example.p1;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;	

@RestController
public class BusinessNumberController {

    public String apiUrl = "https://api.odcloud.kr/api/nts-businessman/v1/status";
    public String apiKey = ""; // URL-encoded API 키

    @PostMapping("/lookup")
    public ResponseEntity<String> lookupBusinessNumber(@RequestBody String businessNumber) {
        // UriComponentsBuilder를 사용하여 URL을 빌드
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
            .queryParam("serviceKey", apiKey)
            .queryParam("returnType", "json");

        // RestTemplate을 초기화
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            // POST 요청 및 응답 처리
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(builder.toUriString(), businessNumber, String.class);
            return ResponseEntity.ok(responseEntity.getBody());
        } catch (HttpClientErrorException e) {
            // 에러 발생 시, 에러 상태 코드와 응답 메시지 반환
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        }
    }
}

