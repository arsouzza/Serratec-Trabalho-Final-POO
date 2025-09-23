package interfaces;

import java.sql.SQLException;

import models.Dependente;
import models.exceptions.DependenteException;

public interface IDependenteService {
	void validarDependente(Dependente d) throws DependenteException, SQLException;
	void cadastrarDependente(Dependente d, int funcionarioId) throws DependenteException, SQLException;
}
