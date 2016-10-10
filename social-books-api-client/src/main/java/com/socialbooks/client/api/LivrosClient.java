package com.socialbooks.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.socialbooks.client.entity.Livro;


public class LivrosClient {
	private String URI_BASE = "http://localhost:8080/livros";
	private StringBuffer authorization = new StringBuffer();
	private RestTemplate restTemplate;
	
	public LivrosClient(String nome, String senha) {
		restTemplate = new RestTemplate();
		authorization.append("Basic ");
	    authorization.append(Base64.getEncoder().encodeToString((nome + ":" + senha).getBytes()));
		
	}
	
	public List<Livro> listar() {
		RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(URI_BASE)).
				header("Authorization", authorization.toString()).build();
		ResponseEntity<Livro[]> response = restTemplate.exchange(requestEntity, Livro[].class);
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Livro livro){
		RequestEntity<Livro> requestEntity = RequestEntity.
				post(URI.create(URI_BASE)).header("Authorization", authorization.toString()).
				body(livro);
		ResponseEntity<Void> response = restTemplate.exchange(requestEntity, Void.class);
		return response.getHeaders().getLocation().toString();
	}
	
	public Livro buscar(String uri){
		RequestEntity<Void> requestEntity = RequestEntity.
				get(URI.create(uri)).header("Authorization", authorization.toString()).
				build();
		ResponseEntity<Livro> response = restTemplate.exchange(requestEntity, Livro.class);
		return response.getBody();
	}
}
