package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {
/**
 * Objetivo - verificar o comportamento da aplicacao na inclusao de dados invalidos
 */

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			Usuario umUsuario;
			// acao
			umUsuario = ObtemUsuario.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}
	
	@Test
	public void CT02UsuarioRaBranco() {
		// cenario
		Usuario usuario = new Usuario();
		//acao
		try {
			//acao
			usuario = ObtemUsuario.comDadosInvalidosRaBranco();
			fail("Deveria Lancar uma Exception");
		} catch (RuntimeException e) {
			//verificacao
			assertEquals("RA invalido", e.getMessage());
		}
		
	}
	@Test
	public void CT03UsuarioRaNulo() {
		//cenario
		Usuario usuario = new Usuario();
		//acao
		try {
			//acao
			usuario = ObtemUsuario.comDadosInvalidosRaNulo();
			fail("Deveria Lancar uma Exception");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04UsuarioNomeBranco() {
		//cenario
		Usuario usuario = new Usuario();
		//acao
		try {
			//acao
			usuario = ObtemUsuario.comDadosInvalidosNomeBranco();
			fail("Deveria Lancar uma Exception");
		}catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	};
	
	@Test public void CT05UsuarioNomeNulo() {
		//cenario
				Usuario usuario = new Usuario();
				//acao
				try {
					//acao
					usuario = ObtemUsuario.comDadosInvalidosNomeNulo();
					fail("Deveria Lancar uma Exception");
				}catch (RuntimeException e) {
					// verificacao
					assertEquals("Nome invalido", e.getMessage());
				}
	}
	@Test
	public void CT06cadsatrarUusario_getNome_com_sucesso() {
		//cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		assertEquals("Jose Silva", usuario.getNome());
	}
	
	@Test
	public void CT07cadsatrarUusario_getRa_com_sucesso() {
		//cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		assertEquals("222222", usuario.getRa());
	}
}