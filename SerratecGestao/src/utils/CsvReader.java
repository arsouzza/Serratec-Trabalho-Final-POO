package utils;

import models.Dependente;
import models.Funcionario;
import models.enums.Parentesco;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	public List<Funcionario> lerFuncionariosComDependentes(String caminho) throws IOException {
		List<Funcionario> resultado = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String linha;
			Funcionario atual = null;
			while ((linha = br.readLine()) != null) {
				linha = linha.trim();
				if (linha.isEmpty()) {
					if (atual != null) {
						resultado.add(atual);
						atual = null;
					}
					continue;
				}
				String[] cols = linha.split(";");
				if (cols.length < 4)
					continue;
				String campo4 = cols[3].trim();

				if (campo4.matches("\\d+\\.\\d{2}")) {
					String nome = cols[0].trim();
					String cpf = cols[1].trim().replaceAll("\\D", "");
					LocalDate dataNasc = DateUtils.parseFromCsv(cols[2].trim());
					double salario = Double.parseDouble(campo4);
					if (atual != null) {
						resultado.add(atual);
					}
					atual = new Funcionario(nome, cpf, dataNasc, salario);
				} else {
					if (atual == null) {
						continue;
					}
					String nome = cols[0].trim();
					String cpf = cols[1].trim().replaceAll("\\D", "");
					LocalDate dataNasc = DateUtils.parseFromCsv(cols[2].trim());
					Parentesco par = Parentesco.fromString(campo4);
					Dependente d = new Dependente(nome, cpf, dataNasc, par);
					atual.addDependente(d);
				}
			}
			if (atual != null)
				resultado.add(atual);
		}
		return resultado;
	}
}