package services;

import models.FolhaPagamento;
import models.Funcionario;
import repositories.FolhaPagamentoRepository;

import java.time.LocalDate;
import java.util.UUID;

public class FolhaPagamentoService {

    private CalculoInssService inssService = new CalculoInssService();
    private CalculoIrService irService = new CalculoIrService();
    private FolhaPagamentoRepository folhaRepository;

    public FolhaPagamentoService(FolhaPagamentoRepository folhaRepository) {
        this.folhaRepository = folhaRepository;
    }

    public FolhaPagamento processar(Funcionario f) {
        double inss = inssService.calcularInss(f.getSalarioBruto());
        double ir = irService.calcularIr(f.getSalarioBruto(), inss, f.getDependentes().size());
        double liquido = f.getSalarioBruto() - inss - ir;

        f.setDescontoInss(round2(inss));
        f.setDescontoIr(round2(ir));
        f.setSalarioLiquido(round2(liquido));

        FolhaPagamento folha = new FolhaPagamento(UUID.randomUUID().toString(), f, LocalDate.now(),
                f.getDescontoInss(), f.getDescontoIr(), f.getSalarioLiquido());

        return folha;
    }

    public void salvarFolha(FolhaPagamento folha) throws Exception {
        folhaRepository.salvar(folha);
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
