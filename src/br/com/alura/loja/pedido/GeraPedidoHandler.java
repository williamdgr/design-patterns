package br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class GeraPedidoHandler {
	
	private java.util.List<AcaoAposGerarPedido> acoes;
	
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	//construtor com injeção de dependencias: repository, service, etc..
	
	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(dados.getValorOrcamento()));
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		EnviarEmailPedido email = new EnviarEmailPedido();
		SalvarPedidoNoBancoDeDados salvar = new SalvarPedidoNoBancoDeDados();
		
		acoes.forEach(a -> a.executarAcao(pedido));
	}

}
