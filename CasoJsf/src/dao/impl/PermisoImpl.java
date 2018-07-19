package dao.impl;
import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;
public class PermisoImpl  extends JPA implements DAO<Permiso> {

	@Override
	public Permiso getById(Long id) {
		Permiso result = getEntityManager().find(Permiso.class, id);
		closeEntityManager();
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Permiso> getAll() {
		String sql = "SELECT g FROM Permiso g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Permiso> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}
	@SuppressWarnings("null")
	@Override
	public Permiso update(Permiso DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Permiso updateObj = getEntityManager().find(Permiso.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setRoles(DTO.getRoles());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Permiso create(Permiso DTO) {
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

		Permiso obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Permiso g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}

}
