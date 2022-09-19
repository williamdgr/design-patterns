import java.math.BigDecimal;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesDescontos {

	public static void main(String[] args) {
		
		//Chain of Responsability (Cadeia de responsabilidades)
		Orcamento primeiro = new Orcamento();
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		
		Orcamento segundo = new Orcamento();
		segundo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(primeiro)); //Template Method nos métodos de calculo
		System.out.println(calculadora.calcular(segundo));

	}

}
