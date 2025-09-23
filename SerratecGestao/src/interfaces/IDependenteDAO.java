package interfaces;

import java.sql.SQLException;

import models.Dependente;

public interface IDependenteDAO {
	void salvar(Dependente d, int funcionarioId) throws SQLException;
	Dependente buscarPorCpf(String cpf) throws SQLException;
}
