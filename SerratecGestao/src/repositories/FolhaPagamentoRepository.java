package repositories;

import configs.DatabaseConfig;
import models.FolhaPagamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FolhaPagamentoRepository {

	public void salvar(FolhaPagamento f) throws SQLException {
		String sql = "INSERT INTO folha_pagamento(funcionario_id, data_pagamento, desconto_inss, desconto_ir, salario_liquido, codigo) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, f.getFuncionario().getId());
			ps.setDate(2, Date.valueOf(f.getDataPagamento()));
			ps.setDouble(3, f.getDescontoInss());
			ps.setDouble(4, f.getDescontoIr());
			ps.setDouble(5, f.getSalarioLiquido());
			ps.setString(6, f.getCodigo());
			try (java.sql.ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					f.setId(rs.getInt(1));
			}
		}
	}
}
