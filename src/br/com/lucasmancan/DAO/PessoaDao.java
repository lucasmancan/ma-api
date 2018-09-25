package br.com.lucasmancan.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.lucasmancan.models.Pessoa;

@SuppressWarnings("unchecked")
public class PessoaDao extends AbstractDao<Long, Pessoa> {

	public Pessoa findById(Long id) {
		Pessoa pessoa = getByKey(id);
		return pessoa;
	}

	public Pessoa findById(String registroInstituicao) throws Exception {
		try {
			Pessoa pessoa = (Pessoa) getEntityManager().createQuery("Pessoa.FetchById", Pessoa.class)
					.setParameter("id", 1).setParameter("registroInstituicao", registroInstituicao).getSingleResult();
			return pessoa;
		} catch (NoResultException ex) {
			throw new Exception(ex);
		}
	}

	public List<Pessoa> findAll() throws Exception {
		try {
			List<Pessoa> pessoas = getEntityManager().createQuery("Pessoas.fetchAll", Pessoa.class).getResultList();
			return pessoas;

		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public Pessoa findByName(String nome) throws Exception {
		try {
			Pessoa pessoa = (Pessoa) getEntityManager().createQuery("Pessoa.FetchByName", Pessoa.class)
					.setParameter("id", 1).setParameter("nome", nome).getSingleResult();
			return pessoa;
		} catch (NoResultException ex) {
			throw new Exception(ex);
		}
	}

	public Pessoa Add(Pessoa pessoa) throws Exception {
		try {
			persist(pessoa);
			return pessoa;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public boolean delete(Pessoa pessoa) {
		if (!delete(pessoa)) {
			return false;
		}
		return true;
	}

	public boolean apdate(Pessoa pessoa) {
		if (!update(pessoa)) {
			return false;
		}
		return true;
	}

}
