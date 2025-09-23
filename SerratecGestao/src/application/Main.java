package application;

import controllers.ProcessamentoController;
import models.FolhaPagamento;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			String entrada = "C:\\Serratec\\folha.csv";
			String saida = "C:\\Serratec\\folha_saida.csv";
			String rejeitados = "C:\\Serratec\\rejeitados.csv";

			ProcessamentoController controller = new ProcessamentoController();
			List<FolhaPagamento> folhas = controller.processarArquivo(entrada, saida, rejeitados);

			System.out.println("Processamento finalizado. " + folhas.size() + " folhas geradas.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
