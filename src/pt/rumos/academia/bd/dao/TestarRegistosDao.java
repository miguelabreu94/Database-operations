package pt.rumos.academia.bd.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import pt.rumos.academia.bd.entities.Registo;

public class TestarRegistosDao implements RegistosDao {

	@Override
	public List<Registo> obter() {
		
		var listaRegistos = new ArrayList <Registo>();
		
		listaRegistos.add(new Registo("a@b.c", new Date(), "joaoantonio76", "xpto"));
		listaRegistos.add(new Registo("ola@gmail.com", new Date(), "luisaluisa", "sadasd"));
		listaRegistos.add(new Registo("xab@hotmail.com", new Date(), "marica2131", "sdasd"));
		
		return listaRegistos;
	}

	@Override
	public Optional<Registo> obterByEmail(String curEmail) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void criar(Registo registo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(String email, String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarpw(String email, String password, String novapassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Registo> obterByUsername(String username) {
		
		
		return Optional.empty();
	}

}
