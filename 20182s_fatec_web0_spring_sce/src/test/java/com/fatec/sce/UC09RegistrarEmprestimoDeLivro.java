package com.fatec.sce;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.ServicoEmprestimo;

public class UC09RegistrarEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	@Test
	public void CT01RegistrarEmprestimoDeLivro_com_sucesso() {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		// acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
		livro = resultadoEsperado.getLivro();
		usuario = resultadoEsperado.getUsuario();
		// verificação
		assertNotNull(resultadoEsperado);
	}

	@Test
	public void CT02RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		Emprestimo emprestimo = null;
		// acao
		emprestimo = ObtemEmprestimo.comDadosValidos();
		// verificação
		assertNotNull(emprestimo);
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}
	
	@Test
	public void CT03RegistraEmprestimoDeLivro_nulo() {
		try {
			// cenario
			Emprestimo emprestimo = null;
			// acao
			emprestimo = ObtemEmprestimo.comDadosNulos();
			// verificação
				
		}
		catch(RuntimeException e){
			assertEquals("Dados inválidos.", e.getMessage());
		}
		
	}
	
	@Test
	public void CT04Set_Livro_nulo() {
		try {
			// cenario
			Emprestimo emprestimo = new Emprestimo();
			livro = null;
			// acao
			emprestimo.setLivro(livro);;
			// verificação
				
		}
		catch(RuntimeException e){
			assertEquals("Dados invalidos.", e.getMessage());
		}
		
	}
	
	@Test
	public void CT05Set_Usuario_nulo() {
		try {
			// cenario
			Emprestimo emprestimo = new Emprestimo();
			usuario = null;
			// acao
			emprestimo.setUsuario(usuario);;
			// verificação
				
		}
		catch(RuntimeException e){
			assertEquals("Dados invalidos.", e.getMessage());
		}
		
	}
	
	@Test
	public void CT06Set_Data_emprestimo_invalida() {
		try {
			// cenario
			Emprestimo emprestimo = new Emprestimo();
			String dataInvalida = "0/0/0";
			// acao
			emprestimo.setDataEmprestimo(dataInvalida);
			// verificação
				
		}
		catch(RuntimeException e){
			assertEquals("Data invalida.", e.getMessage());
		}
		
	}
	
	@Test
	public void CT07ValidaData_false() {
			// cenario
			Emprestimo emprestimo = new Emprestimo();
			String dataInvalida = "0/0/0";
			Boolean resultado;
			// acao
			resultado = emprestimo.validaData(dataInvalida);
			// verificação
			assertFalse(resultado);
		
	}
	
	

}
