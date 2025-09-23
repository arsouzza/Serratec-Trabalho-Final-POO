package controllers;

import models.Funcionario;
import services.FuncionarioService;

import java.sql.SQLException;
import java.util.List;

import Daos.FuncionarioDAO;

public class FuncionarioController {

    private FuncionarioService service;
    private FuncionarioDAO repository;

    public FuncionarioController(FuncionarioService service, FuncionarioDAO repository) {
        this.service = service;
        this.repository = repository;
    }

    public void cadastrarFuncionario(Funcionario f) throws SQLException {
        if (service.validarCpfUnico(f.getCpf())) {
            repository.salvar(f);
        } else {
            throw new IllegalArgumentException("CPF duplicado!");
        }
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        return repository.listarTodos();
    }

    public Funcionario buscarPorCpf(String cpf) throws SQLException {
        return repository.buscarPorCpf(cpf);
    }
}
