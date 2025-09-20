package models;

import java.time.LocalDate;

public class FolhaPagamento {
    private Integer id;
    private String codigo;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoInss;
    private double descontoIr;
    private double salarioLiquido;

    public FolhaPagamento() {
    }

    public FolhaPagamento(String codigo, Funcionario funcionario, LocalDate dataPagamento, double descontoInss,
            double descontoIr, double salarioLiquido) {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIr;
        this.salarioLiquido = salarioLiquido;
    }

    // getters / setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
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
}package models;

import java.time.LocalDate;

public class FolhaPagamento {
    private Integer id;
    private String codigo;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoInss;
    private double descontoIr;
    private double salarioLiquido;

    public FolhaPagamento() {
    }

    public FolhaPagamento(String codigo, Funcionario funcionario, LocalDate dataPagamento, double descontoInss,
            double descontoIr, double salarioLiquido) {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIr;
        this.salarioLiquido = salarioLiquido;
    }

    // getters / setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
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
}