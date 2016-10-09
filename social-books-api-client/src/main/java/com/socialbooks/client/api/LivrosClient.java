package com.socialbooks.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.socialbooks.client.entity.Livro;

@Component
public class LivrosClient {
	private static String url = "http://localhost:8080/livros";
	
	public List<Livro> listar() {
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(url)).header("Authorization", "Basic dGVzdGU6MQ==").build();
		ResponseEntity<Livro[]> response = restTemplate.exchange(requestEntity, Livro[].class);
		return Arrays.asList(response.getBody());
	}
}
