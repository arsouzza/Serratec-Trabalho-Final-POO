package interfaces;

import java.sql.SQLException;

import models.Funcionario;

public interface IFuncionarioService {
	boolean validarCpfUnico(String cpf) throws SQLException;
	boolean validarFormatoCpf(String cpf);
	void cadastrarFuncionario(Funcionario f) throws SQLException;
}
