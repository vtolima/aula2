package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.Livro;

public class UC01CadastrarLivro {
/**
 * Objetivo - Verificar o comportamento da aplicacao na inclusao de dados invalidos
 */
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}
	/**
	 * Objetivo - Verificar o comportamento da aplicacao na inclusao de ISBN em branco
	 */
	@Test
	public void CT02CadastrarLivroComISBNBranco() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comISBNInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido",e.getMessage());
		}
	}
	/**
	 * Objetivo - Verificar o comportamento da aplicacao na inclusao de ISBN Nulo
	 */
	@Test
	public void CT03CadastrarLivroComISBNNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comISBNInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido",e.getMessage());
		}
	}
	/**
	 * Objetivo - Verificar o comportamento da aplicacao na inclusao de dados invalidos
	 */
	@Test
	public void CT04CadastrarLivroComDadosValidos() {
		
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("1111");
			umLivro.setTitulo("Engenharia de Software");
			umLivro.setAutor("Pressman");
			// verificacao
			assertEquals("1111",umLivro.getIsbn());
		
	}
	/**
	 * Objetivo - Verificar o comportamento da aplicacao na inclusao de dados invalidos
	 */
	@Test
	public void CT05CadastrarLivroComDadosValidos() {
		
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comDadosValidos();
			// verificacao
			assertEquals("Engenharia de Software",umLivro.getTitulo());
		
	}
	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Livro com Titulo Em Branco
	 */
	@Test
	public void CT06CadastrarLivroComTituloBranco() {
		
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comTituloBranco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido",e.getMessage());
		}
		
	}
	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Livro com Titulo Nulo
	 */
	@Test
	public void CT07CadastrarLivroComTituloNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comTituloNulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido",e.getMessage());
		}
		
	}
	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Livro com Titulo Nulo
	 */
	@Test
	public void CT08CadastrarLivroComTituloNulo() {
		// cenario
		Livro umLivro = new Livro();
		// acao
		umLivro = ObtemLivro.comDadosValidos();
		// verificacao
		assertEquals("Pressman",umLivro.getAutor());
		
	}
	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Livro com Autor em Branco
	 */
	@Test
	public void CT09CadastrarLivroComAutorBranco() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comAutorBranco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor invalido",e.getMessage());
		}
	}
	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Livro com Autor Nulo
	 */
	@Test
	public void CT10CadastrarLivroComAutorNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comAutorNulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor invalido",e.getMessage());
		}
		
	}
	
}
