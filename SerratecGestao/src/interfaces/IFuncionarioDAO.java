package interfaces;

import models.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface IFuncionarioDAO{
	void salvar(Funcionario f) throws SQLException;

	List<Funcionario> listarTodos() throws SQLException;

	Funcionario buscarPorCpf(String cpf) throws SQLException;
}
