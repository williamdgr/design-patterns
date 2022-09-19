package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Imposto {
	
	private Imposto outro;
	
	public Imposto(Imposto outro) {
		this.outro = outro;
	}
	
	protected abstract BigDecimal realizarCalculo(Orcamento orcamento) ;

	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		BigDecimal valorImposto = imposto.realizarCalculo(orcamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;
		
		if (outro != null) {
			valorOutroImposto = outro.realizarCalculo(orcamento);
		}
		return valorImposto.add(valorOutroImposto);
	}

}
