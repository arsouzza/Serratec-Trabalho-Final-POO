package interfaces;

import java.sql.SQLException;

import models.FolhaPagamento;

public interface IFolhaPagamentoDAO {
	void salvar(FolhaPagamento f) throws SQLException;
}
