package services;

import models.Dependente;
import models.exceptions.DependenteException;

import java.sql.SQLException;

import Daos.DependenteDAO;
import interfaces.IDependenteService;

public class DependenteService implements IDependenteService{

    private DependenteDAO repository;

    public DependenteService(DependenteDAO repository) {
        this.repository = repository;
    }

    public void validarDependente(Dependente d) throws DependenteException, SQLException {
        if (d.getIdade() >= 18) {
            throw new DependenteException("Dependente tem 18 anos ou mais: " + d.getNome());
        }
        if (!d.getCpf().matches("\\d{11}")) {
            throw new DependenteException("CPF inválido dependente: " + d.getCpf());
        }
        if (repository.buscarPorCpf(d.getCpf()) != null) {
            throw new DependenteException("CPF de dependente já cadastrado: " + d.getCpf());
        }
    }

    public void cadastrarDependente(Dependente d, int funcionarioId) throws DependenteException, SQLException {
        validarDependente(d);
        repository.salvar(d, funcionarioId);
    }
}
