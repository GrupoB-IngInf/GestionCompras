package dao.impl;
import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;

public class BancoImpl extends JPA implements DAO<Banco> {

	@Override
	public Banco getById(Long id) {
		Banco result = getEntityManager().find(Banco.class, id);
		closeEntityManager();
		return result;
	}
	
	@Override
	public List<Banco> getAll() {
		String sql = "SELECT b FROM Banco b";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Banco> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	
	@Override
	public Banco update(Banco DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Banco updateObj = getEntityManager().find(Banco.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setEstado(DTO.getEstado());
	
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Banco create(Banco DTO) {
		EntityTransaction t = getEntityManager().getTransaction();
		if (!t.isActive()) {
			t.begin();
		}
		getEntityManager().persist(DTO);
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public boolean delete(Long id) {
		if (id == 0) {
			return false;
		}

		Banco obj = getById(id);
		if (obj == null) {
			return false;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		if (!t.isActive()) {
			t.begin();
		}
		getEntityManager().remove(getEntityManager().merge(obj));
		t.commit();
		closeEntityManager();
		return true;
	}

	@Override
	public Long getMaxId() {
		String sql = "SELECT max(b.id) + 1 FROM Banco b";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	
	
}
