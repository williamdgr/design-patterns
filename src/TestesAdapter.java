import java.math.BigDecimal;

import br.com.alura.loja.http.HttpClient;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;

public class TestesAdapter {

	public static void main(String[] args) {
		
		//Padrao Adapter
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
		orcamento.aprovar(); //Padrão State para trocar de estado o objeto
		orcamento.finalizar();
		
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new HttpClient());
		registro.registrar(orcamento);
	}

}
