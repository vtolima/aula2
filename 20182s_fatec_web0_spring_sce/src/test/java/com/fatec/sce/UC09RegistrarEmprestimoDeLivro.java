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
	
	
	public void CT08se_data_devolucao_for_domingo_retorna_true() {
		// cenario
		String data = "2018/09/02"; // domingo
		// acao
		Emprestimo umEmprestimo = new Emprestimo();
		// verificacao
		assertTrue(umEmprestimo.ehDomingo(data));
	}

	@Test
	public void CT09_quando_entrega_atrasado_quant_dias_negativo() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias < 0); // quant de dias entre a data de emprestimo e a de devolucao
	}

	@Test
	public void CT10_quando_entrega_no_mesmo_dia() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoIgual_DataDeEmprestimo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias == 0); // quant de dias entre a data de emprestimo e a de devolucao
	}

	/**
	 * Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com
	 * formato valido dia invalido (domingo).
	 */


	@Test
	public void CT11se_data_formato_invalido() {
		// cenario
		String data = "2018/0900/0200"; // data invalida
		// acao
		Emprestimo umEmprestimo = new Emprestimo();
		// verificacao
		assertFalse(umEmprestimo.ehDomingo(data));
	}

	@Test
	public void CT12se_data_devolucao_menor_que_o_fim() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias < 0); // data de devolucao menor
	}
	
	@Test
	public void CT13se_data_devolucao_1_dia_depois() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoMais1DiaDataDeEmprestimo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacaod
		assertTrue(quantDias == 1); // data de devolucao 1
	}
	
	

}
