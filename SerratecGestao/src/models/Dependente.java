package models;

import models.enums.Parentesco;

import java.time.LocalDate;

public class Dependente extends Pessoa {
    private Parentesco parentesco;

    public Dependente() {
    }

    public Dependente(Integer id, String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
        super(id, nome, cpf, dataNascimento);
        this.parentesco = parentesco;
    }

    public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
        this(null, nome, cpf, dataNascimento, parentesco);
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
}