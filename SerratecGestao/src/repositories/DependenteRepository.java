package repositories;

import configs.DatabaseConfig;
import models.Dependente;

import java.sql.*;

public class DependenteRepository {

	public void salvar(Dependente d, int funcionarioId) throws SQLException {
		String sql = "INSERT INTO dependente(nome, cpf, data_nascimento, parentesco, funcionario_id) VALUES (?, ?, ?, ?, ?) RETURNING id";
		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, d.getNome());
			ps.setString(2, d.getCpf());
			ps.setDate(3, Date.valueOf(d.getDataNascimento()));
			ps.setString(4, d.getParentesco().name());
			ps.setInt(5, funcionarioId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					d.setId(rs.getInt(1));
			}
		}
	}

	public Dependente buscarPorCpf(String cpf) throws SQLException {
		String sql = "SELECT id, nome, cpf, data_nascimento, parentesco FROM dependente WHERE cpf = ?";
		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cpf);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					// binding omitted for brevity; we only check existence in service
					Dependente d = new Dependente();
					d.setId(rs.getInt("id"));
					d.setNome(rs.getString("nome"));
					d.setCpf(rs.getString("cpf"));
					d.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
					return d;
				}
			}
		}
		return null;
	}
}
