package utils;

import models.FolhaPagamento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public void escreverFolhas(String caminho, List<FolhaPagamento> folhas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (FolhaPagamento f : folhas) {
                String linha = String.format("%s;%s;%.2f;%.2f;%.2f",
                        f.getFuncionario().getNome(),
                        f.getFuncionario().getCpf(),
                        f.getDescontoInss(),
                        f.getDescontoIr(),
                        f.getSalarioLiquido());
                bw.write(linha);
                bw.newLine();
            }
        }
    }

    public void escreverRejeitados(String caminho, List<String> linhas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String l : linhas) {
                bw.write(l);
                bw.newLine();
            }
        }
    }
}
