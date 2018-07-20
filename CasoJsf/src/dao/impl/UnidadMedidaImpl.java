package dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import base.JPA;
import dao.DAO;
import dto.UnidadMedida;

public class UnidadMedidaImpl extends JPA implements DAO<UnidadMedida>{

	@Override
	public UnidadMedida getById(Long id) {
		UnidadMedida result = getEntityManager().find(UnidadMedida.class, id);
		closeEntityManager();
		return result;
	}


	@Override
	public List<UnidadMedida> getAll() {
		String sql = "SELECT g FROM UnidadMedida g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<UnidadMedida> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	
	@Override
	public UnidadMedida update(UnidadMedida DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		UnidadMedida updateObj = getEntityManager().find(UnidadMedida.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
	
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public UnidadMedida create(UnidadMedida DTO) {
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

		UnidadMedida obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM UnidadMedida g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
}