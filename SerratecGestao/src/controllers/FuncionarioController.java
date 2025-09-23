package controllers;

import models.Funcionario;
import services.FuncionarioService;

import java.sql.SQLException;
import java.util.List;

import Daos.FuncionarioDAO;

public class FuncionarioController {

    private FuncionarioService service;
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController(FuncionarioService service, FuncionarioDAO repository) {
        this.service = service;
        this.funcionarioDAO = repository;
    }

    public void cadastrarFuncionario(Funcionario f) throws SQLException {
        if (service.validarCpfUnico(f.getCpf())) {
        	funcionarioDAO.salvar(f);
        } else {
            throw new IllegalArgumentException("CPF duplicado!");
        }
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        return funcionarioDAO.listarTodos();
    }

    public Funcionario buscarPorCpf(String cpf) throws SQLException {
        return funcionarioDAO.buscarPorCpf(cpf);
    }
}
