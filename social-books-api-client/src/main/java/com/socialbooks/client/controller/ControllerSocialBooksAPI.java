
package com.socialbooks.client.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;

import com.socialbooks.client.api.LivrosClient;
import com.socialbooks.client.entity.Livro;
@Controller
public class ControllerSocialBooksAPI {
	private LivrosClient livrosClient;
	
	public ControllerSocialBooksAPI() throws ParseException {
		System.out.println("Controler");
		livrosClient = new LivrosClient("teste", "1");
		enviarRequisicao();
	}
	
	public void enviarRequisicao() throws ParseException{
		System.out.println("*** ENVIA REQUISIÇÃO ***");
		
		Livro livro = new Livro();
		// Livro 1 
		livro.setNome("History and Life");
		livro.setEditora("Caibas Editora");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(sdf.parse("11/08/1987"));
		livro.setResumo("Livro aborda vida, obra e história de Caibaté");
		
		String localizacao =livrosClient.salvar(livro);
		livro = null;
		System.out.println("- Localização do livro salvo: " + localizacao);
		
		//busca livros
		livro = livrosClient.buscar(localizacao);
		System.out.println("- Nome do livro persistido: " + livro.getNome() + System.lineSeparator());
		
		
		//Lista Livros
		for(Livro l: livrosClient.listar()){
				System.out.println("- Nome do livro: " + l.getNome() + System.lineSeparator());
		}
		
		
	}
	
}
