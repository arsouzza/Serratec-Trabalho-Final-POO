package repositories;

import configs.DatabaseConfig;
import models.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

	public void salvar(Funcionario f) throws SQLException {
		String sql = "INSERT INTO funcionario(nome, cpf, data_nascimento, salario_bruto) VALUES (?, ?, ?, ?) RETURNING id";
		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, f.getNome());
			ps.setString(2, f.getCpf());
			ps.setDate(3, Date.valueOf(f.getDataNascimento()));
			ps.setDouble(4, f.getSalarioBruto());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					f.setId(rs.getInt(1));
			}
		}
	}

	public List<Funcionario> listarTodos() throws SQLException {
		List<Funcionario> lista = new ArrayList<>();
		String sql = "SELECT id, nome, cpf, data_nascimento, salario_bruto FROM funcionario";
		try (Connection conn = DatabaseConfig.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
						rs.getDate("data_nascimento").toLocalDate(), rs.getDouble("salario_bruto"));
				lista.add(f);
			}
		}
		return lista;
	}

	public Funcionario buscarPorCpf(String cpf) throws SQLException {
		String sql = "SELECT id, nome, cpf, data_nascimento, salario_bruto FROM funcionario WHERE cpf = ?";
		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cpf);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
							rs.getDate("data_nascimento").toLocalDate(), rs.getDouble("salario_bruto"));
				}
			}
		}
		return null;
	}
}
