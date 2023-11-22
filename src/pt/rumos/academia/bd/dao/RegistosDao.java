package pt.rumos.academia.bd.dao;

import java.util.List;
import java.util.Optional;

import pt.rumos.academia.bd.entities.Registo;

public interface RegistosDao {

	List<Registo> obter();

	Optional<Registo> obterByEmail(String curEmail);

	void criar(Registo registo);

	void remover(String email);

	void atualizar(String email, String data);

	void atualizarpw(String email, String password, String novapassword);

	Optional<Registo> obterByUsername(String username);

}