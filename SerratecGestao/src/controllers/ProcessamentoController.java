package controllers;

import models.Dependente;
import models.FolhaPagamento;
import models.Funcionario;
import models.exceptions.DependenteException;
import repositories.DependenteRepository;
import repositories.FolhaPagamentoRepository;
import repositories.FuncionarioRepository;
import services.DependenteService;
import services.FolhaPagamentoService;
import services.FuncionarioService;
import utils.CsvReader;
import utils.CsvWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessamentoController {

	private FuncionarioRepository funcionarioRepo = new FuncionarioRepository();
	private DependenteRepository dependenteRepo = new DependenteRepository();
	private FolhaPagamentoRepository folhaRepo = new FolhaPagamentoRepository();

	private FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepo);
	private DependenteService dependenteService = new DependenteService(dependenteRepo);
	private FolhaPagamentoService folhaService = new FolhaPagamentoService(folhaRepo);

	private CsvReader csvReader = new CsvReader();
	private CsvWriter csvWriter = new CsvWriter();

	public List<FolhaPagamento> processarArquivo(String entradaPath, String saidaPath, String rejeitadosPath)
			throws IOException {
		List<FolhaPagamento> folhasGeradas = new ArrayList<>();
		List<String> linhasRejeitadas = new ArrayList<>();

		List<Funcionario> funcionarios = csvReader.lerFuncionariosComDependentes(entradaPath);

		for (Funcionario f : funcionarios) {
			try {
				
				if (!funcionarioService.validarFormatoCpf(f.getCpf())) {
					linhasRejeitadas.add("FUNCIONARIO;CPF_INVALIDO;" + f.getNome() + ";" + f.getCpf());
					continue;
				}
				if (!funcionarioService.validarCpfUnico(f.getCpf())) {
					linhasRejeitadas.add("FUNCIONARIO;CPF_DUPLICADO;" + f.getNome() + ";" + f.getCpf());
					continue;
				}
				funcionarioRepo.salvar(f);

				for (Dependente d : f.getDependentes()) {
					try {
						dependenteService.validarDependente(d);
						dependenteRepo.salvar(d, f.getId());
					} catch (DependenteException | SQLException ex) {
						linhasRejeitadas
								.add("DEPENDENTE;REJEITADO;" + d.getNome() + ";" + d.getCpf() + ";" + ex.getMessage());
					}
				}

				FolhaPagamento folha = folhaService.processar(f);
				folhaRepo.salvar(folha);
				folhasGeradas.add(folha);

			} catch (SQLException ex) {
				linhasRejeitadas.add("FUNCIONARIO;ERRO_BD;" + f.getNome() + ";" + f.getCpf() + ";" + ex.getMessage());
			} catch (Exception ex) {
				linhasRejeitadas.add("FUNCIONARIO;ERRO;" + f.getNome() + ";" + f.getCpf() + ";" + ex.getMessage());
			}
		}

		csvWriter.escreverFolhas(saidaPath, folhasGeradas);
		csvWriter.escreverRejeitados(rejeitadosPath, linhasRejeitadas);

		return folhasGeradas;
	}
}
