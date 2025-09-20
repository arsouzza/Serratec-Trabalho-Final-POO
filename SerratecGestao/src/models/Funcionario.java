package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    private double salarioBruto;
    private double descontoInss;
    private double descontoIr;
    private double salarioLiquido;
    private List<Dependente> dependentes = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
        super(id, nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
    }

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
        this(null, nome, cpf, dataNascimento, salarioBruto);
    }

    // getters / setters
    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getDescontoInss() {
        return descontoInss;
    }

    public void setDescontoInss(double descontoInss) {
        this.descontoInss = descontoInss;
    }

    public double getDescontoIr() {
        return descontoIr;
    }

    public void setDescontoIr(double descontoIr) {
        this.descontoIr = descontoIr;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public void addDependente(Dependente d) {
        this.dependentes.add(d);
    }
}