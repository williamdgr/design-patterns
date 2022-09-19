package br.com.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class Reprovado  extends SituacaoOrcamento {
	
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Reprovado());
	}
}
