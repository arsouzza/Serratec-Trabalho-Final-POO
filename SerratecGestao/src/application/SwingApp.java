package application;

import controllers.ProcessamentoController;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SwingApp extends JFrame {

    private JTextField txtEntrada;
    private JTextField txtSaida;
    private JTextField txtRejeitados;
    private JTextArea logArea;
    private ProcessamentoController controller = new ProcessamentoController();

    public SwingApp() {
        super("Processador de Folha - POO");
        criarInterface();
    }

    private void criarInterface() {
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelTop = new JPanel(new GridLayout(4, 3, 5, 5));
        txtEntrada = new JTextField();
        txtSaida = new JTextField();
        txtRejeitados = new JTextField();

        JButton btnBrowseEntrada = new JButton("Abrir...");
        btnBrowseEntrada.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                txtEntrada.setText(f.getAbsolutePath());
            }
        });

        JButton btnBrowseSaida = new JButton("Salvar como...");
        btnBrowseSaida.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                txtSaida.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });

        JButton btnBrowseRejeitados = new JButton("Salvar rejeitados...");
        btnBrowseRejeitados.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                txtRejeitados.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });

        painelTop.add(new JLabel("Arquivo de Entrada:"));
        painelTop.add(txtEntrada);
        painelTop.add(btnBrowseEntrada);

        painelTop.add(new JLabel("Arquivo de Saída (folha):"));
        painelTop.add(txtSaida);
        painelTop.add(btnBrowseSaida);

        painelTop.add(new JLabel("Arquivo de Rejeitados:"));
        painelTop.add(txtRejeitados);
        painelTop.add(btnBrowseRejeitados);

        JButton btnProcessar = new JButton("Processar");
        btnProcessar.addActionListener(e -> processar());
        painelTop.add(new JLabel());
        painelTop.add(btnProcessar);
        painelTop.add(new JLabel());

        add(painelTop, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.CENTER);
    }

    private void processar() {
        String entrada = txtEntrada.getText().trim();
        String saida = txtSaida.getText().trim();
        String rejeitados = txtRejeitados.getText().trim();

        if (entrada.isEmpty() || saida.isEmpty() || rejeitados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha os arquivos de entrada/saída/rejeitados.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        logArea.setText("Iniciando processamento...\n");
        try {
            controller.processarArquivo(entrada, saida, rejeitados);
            logArea.append("Processamento finalizado. Arquivo escrito em: " + saida + "\n");
            logArea.append("Arquivo de rejeitados: " + rejeitados + "\n");
        } catch (Exception ex) {
            ex.printStackTrace();
            logArea.append("Erro: " + ex.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "Erro ao processar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwingApp().setVisible(true);
        });
    }
}
