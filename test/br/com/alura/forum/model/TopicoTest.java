package br.com.alura.forum.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopicoTest {

	private Usuario joao;
	private Categoria frontend;
	private Categoria html;
	private Curso htmlBasico;

	@BeforeEach
	public void before() {
		this.joao = new Usuario("Jo�o", "joao@email.com.br", "123456");
		this.frontend = new Categoria("FRONT-END");
		this.html = new Categoria("HTML", frontend);
		this.htmlBasico = new Curso("HTML B�sico", html);
	}

	@Test
	public void aoFecharUmTopicoSeuStatusDeveriaSerAlteradoParaFechado() {
		Topico duvida = new Topico("D�vida HTML", "Qual tag utilizar?", joao, htmlBasico);
		duvida.fechar();
		Assertions.assertEquals(StatusTopico.FECHADO, duvida.getStatus());
	}

}
