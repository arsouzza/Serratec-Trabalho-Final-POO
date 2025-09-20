package services;

import models.Funcionario;
import repositories.FuncionarioRepository;

import java.sql.SQLException;

public class FuncionarioService {

	private FuncionarioRepository repository;

	public FuncionarioService(FuncionarioRepository repository) {
		this.repository = repository;
	}

	public boolean validarCpfUnico(String cpf) throws SQLException {
		return repository.buscarPorCpf(cpf) == null;
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
		repository.salvar(f);
	}
}
