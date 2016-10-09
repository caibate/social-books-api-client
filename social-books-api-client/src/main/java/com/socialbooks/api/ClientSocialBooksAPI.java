
package com.socialbooks.api;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.socialbooks.api.entity.Livro;

@Component
public class ClientSocialBooksAPI {
	private static String url = "http://localhost:8080/livros";
	
	public ClientSocialBooksAPI() {
		enviarRequisicao();
	}
	
	public void enviarRequisicao(){
		listaLivros();
	}
	private void listaLivros() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(url)).header("Authorization", "Basic dGVzdGU6MQ==").build();
		ResponseEntity<Livro[]> response = restTemplate.exchange(requestEntity, Livro[].class);
		
		for(Livro livro : response.getBody()){
			System.out.println("Nome do livro" + livro.getNome());
		}
	}
}
