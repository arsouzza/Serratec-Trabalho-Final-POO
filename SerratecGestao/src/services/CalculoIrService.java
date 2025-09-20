package services;

public class CalculoIrService {
    private static final double DEDUCAO_DEPENDENTE = 189.59;

    public double calcularIr(double salarioBruto, double descontoInss, int qtdDependentes) {
        double base = salarioBruto - descontoInss - (qtdDependentes * DEDUCAO_DEPENDENTE);
        if (base <= 2259.00)
            return 0.0;
        else if (base <= 2826.65)
            return (base * 0.075) - 169.44;
        else if (base <= 3751.05)
            return (base * 0.15) - 381.44;
        else if (base <= 4664.68)
            return (base * 0.225) - 662.77;
        else
            return (base * 0.275) - 896.00;
    }
}