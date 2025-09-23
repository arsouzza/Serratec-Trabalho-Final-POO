package interfaces;

import models.FolhaPagamento;
import models.Funcionario;

public interface IFolhaPagamentoService {
	FolhaPagamento processar(Funcionario f);
	void salvarFolha(FolhaPagamento folha) throws Exception;
	double round2(double v);
}
