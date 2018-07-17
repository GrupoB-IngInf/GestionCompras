package dao.impl;

import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;

public class GrupoImpl extends JPA implements DAO<Grupo> {

	@Override
	public Grupo getById(Long id) {
		Grupo result = getEntityManager().find(Grupo.class, id);
		closeEntityManager();
		return result;
	}


	@Override
	public List<Grupo> getAll() {
		String sql = "SELECT g FROM Grupo g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Grupo> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	
	@Override
	public Grupo update(Grupo DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Grupo updateObj = getEntityManager().find(Grupo.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
	
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Grupo create(Grupo DTO) {
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

		Grupo obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Grupo g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	
}
