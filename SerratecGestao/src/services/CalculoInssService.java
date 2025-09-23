package services;

import interfaces.ICalculoInssService;

public class CalculoInssService implements ICalculoInssService {

    public double calcularInss(double salarioBruto) {
        if (salarioBruto <= 1518.00) {
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 2793.88) {
            return (salarioBruto * 0.09) - 22.77;
        } else if (salarioBruto <= 4190.83) {
            return (salarioBruto * 0.12) - 106.59;
        } else if (salarioBruto <= 8157.41) {
            return (salarioBruto * 0.14) - 190.40;
        } else {
            return (8157.41 * 0.14) - 190.40;
        }
    }
}