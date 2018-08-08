package dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import base.JPA;
import dao.DAO;
import dto.AreaNegocio;

public class AreaNegocioImpl extends JPA implements DAO<AreaNegocio> {

	@Override
	public AreaNegocio getById(Long id) {
		AreaNegocio result = getEntityManager().find(AreaNegocio.class, id);
		closeEntityManager();
		return result;
	}


	@Override
	public List<AreaNegocio> getAll() {
		String sql = "SELECT g FROM AreaNegocio g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<AreaNegocio> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	
	@Override
	public AreaNegocio update(AreaNegocio DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		AreaNegocio updateObj = getEntityManager().find(AreaNegocio.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
	
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public AreaNegocio create(AreaNegocio DTO) {
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

		AreaNegocio obj = getById(id);
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