package dao.impl;
import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;

public class RolesImpl extends JPA implements DAO<Rol>{

	@Override
	public Rol getById(Long id) {
		Rol result = getEntityManager().find(Rol.class, id);
		closeEntityManager();
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> getAll() {
		String sql = "SELECT g FROM Rol g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Rol> list = query.getResultList();
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
	public Rol update(Rol DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Rol updateObj = getEntityManager().find(Rol.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setPermisos(DTO.getPermisos());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Rol create(Rol DTO) {
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

		Rol obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Rol g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	

}
