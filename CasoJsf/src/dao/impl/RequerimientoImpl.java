package dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import base.JPA;
import dao.DAO;
import dto.*;

public class RequerimientoImpl extends JPA implements DAO<Requerimiento> {

	@Override
	public Requerimiento getById(Long id) {
		Requerimiento result = getEntityManager().find(Requerimiento.class, id);
		closeEntityManager();
		return result;
	}

	@Override
	public List<Requerimiento> getAll() {
		String sql = "SELECT r FROM Requerimiento r";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Requerimiento> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	@Override
	public Requerimiento update(Requerimiento DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}
		EntityTransaction t = getEntityManager().getTransaction();
		Requerimiento updateObj = getEntityManager().find(Requerimiento.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Requerimiento create(Requerimiento DTO) {
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

		Requerimiento obj = getById(id);
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
		String sql = "SELECT max(r.id) + 1 FROM Requerimiento r";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	

}
