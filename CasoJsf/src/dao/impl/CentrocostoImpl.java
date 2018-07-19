package dao.impl;

import java.util.List;

import javax.persistence.*;
import base.*;
import dao.*;
import dto.*;

public class CentrocostoImpl extends JPA implements DAO<Centrocosto> {
	
	@Override
	public Centrocosto getById(Long id) {
		Centrocosto result = getEntityManager().find(Centrocosto.class, id);
		closeEntityManager();
		return result;
	}

	//@SuppressWarnings("unchecked")
	@Override
	public List<Centrocosto> getAll() {
		String sql = "SELECT g FROM Centrocosto g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Centrocosto> list = query.getResultList();
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
	public Centrocosto update(Centrocosto DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Centrocosto updateObj = getEntityManager().find(Centrocosto.class, DTO.getId());
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
	public Centrocosto create(Centrocosto DTO) {
		EntityTransaction t = getEntityManager().getTransaction();
		if (!t.isActive()) {
			t.begin();
		}
		DTO.setEstado("Activo");
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

		Centrocosto obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Centrocosto g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	public Centrocosto unSuscribe(Centrocosto DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Centrocosto updateObj = getEntityManager().find(Centrocosto.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setEstado("Baja");
		
		t.commit();
		closeEntityManager();
		return DTO;
	}
	
}
