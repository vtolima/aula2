package com.fatec.sce;

import com.fatec.sce.model.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome("Jose Silva");
		return usuario;
	}
	
	public static Usuario comDadosInvalidosRaNulo() {
		Usuario usuario = new Usuario();
		usuario.setRa(null);
		usuario.setNome("Jose Silva");
		return usuario;
	}
	
	public static Usuario comDadosInvalidosRaBranco() {
		Usuario usuario = new Usuario();
		usuario.setRa("");
		usuario.setNome("Jose Silva");
		return usuario;
	}
	public static Usuario comDadosInvalidosNomeNulo() {
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome(null);
		return usuario;
	}
	
	public static Usuario comDadosInvalidosNomeBranco() {
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome("");
		return usuario;
	}
}