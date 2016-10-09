
package com.socialbooks.client.controller;

import org.springframework.stereotype.Controller;

import com.socialbooks.client.api.LivrosClient;
import com.socialbooks.client.entity.Livro;
@Controller
public class ControllerSocialBooksAPI {
	private LivrosClient livrosClient;
	
	public ControllerSocialBooksAPI() {
		System.out.println("Controler");
		livrosClient = new LivrosClient();
		enviarRequisicao();
	}
	
	public void enviarRequisicao(){
		System.out.println("*** ENVIA REQUISIÇÃO ***");
		for(Livro livro: livrosClient.listar()){
				System.out.println("Nome do livro" + livro.getNome());
		}
	}
	
}
