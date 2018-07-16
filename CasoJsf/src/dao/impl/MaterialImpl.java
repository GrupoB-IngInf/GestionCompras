package dao.impl;

import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;

public class MaterialImpl extends JPA implements DAO<Material>{

	@Override
	public Material getById(Long id) {
		Material result = getEntityManager().find(Material.class, id);
		closeEntityManager();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> getAll() {
		String sql = "SELECT g FROM Material g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Material> list = query.getResultList();
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
	public Material update(Material DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Material updateObj = getEntityManager().find(Material.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setDescripcion(DTO.getDescripcion());
		updateObj.setEstado(DTO.getEstado());
		updateObj.setGrupo(DTO.getGrupo());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Material create(Material DTO) {
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

		Material obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Material g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	public Material unSuscribe(Material DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Material updateObj = getEntityManager().find(Material.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setDescripcion(DTO.getDescripcion());
		updateObj.setEstado("Baja");
		updateObj.setGrupo(DTO.getGrupo());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}
	
}