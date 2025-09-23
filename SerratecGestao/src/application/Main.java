package application;

import controllers.ProcessamentoController;
import models.FolhaPagamento;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			String entrada = "D:\\OneDrive\\Serratec\\csvs\\folha.csv";
			String saida = "D:\\OneDrive\\Serratec\\csvs\\saida_folha.csv";
			String rejeitados = "D:\\OneDrive\\Serratec\\csvs\\rejeitados.csv";

			ProcessamentoController controller = new ProcessamentoController();
			List<FolhaPagamento> folhas = controller.processarArquivo(entrada, saida, rejeitados);

			System.out.println("Processamento finalizado. " + folhas.size() + " folhas geradas.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
