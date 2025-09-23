package services;

import models.Funcionario;

import java.sql.SQLException;

import daos.FuncionarioDAO;

public class FuncionarioService {

	private FuncionarioDAO funcionarioDAO;

	public FuncionarioService(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	public boolean validarCpfUnico(String cpf) throws SQLException {
		return funcionarioDAO.buscarPorCpf(cpf) == null;
	}

	public boolean validarFormatoCpf(String cpf) {
		return cpf != null && cpf.matches("\\d{11}");
	}

	public void cadastrarFuncionario(Funcionario f) throws SQLException {
		if (!validarFormatoCpf(f.getCpf())) {
			throw new IllegalArgumentException("CPF inválido: deve conter 11 dígitos numéricos.");
		}
		if (!validarCpfUnico(f.getCpf())) {
			throw new IllegalArgumentException("CPF já cadastrado: " + f.getCpf());
		}
		funcionarioDAO.salvar(f);
	}
}
