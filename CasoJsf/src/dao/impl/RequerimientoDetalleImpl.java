package dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import base.JPA;
import dao.DAO;
import dto.Requerimiento;
import dto.RequerimientoDetalle;

public class RequerimientoDetalleImpl extends JPA implements DAO<RequerimientoDetalle>{
	
	
	@Override
	public RequerimientoDetalle getById(Long id) {
		RequerimientoDetalle result = getEntityManager().find(RequerimientoDetalle.class, id);
		closeEntityManager();
		return result;
	}

	@Override
	public List<RequerimientoDetalle> getAll() {
		String sql = "SELECT r FROM Requerimiento r";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<RequerimientoDetalle> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	@Override
	public RequerimientoDetalle update(RequerimientoDetalle DTO) {
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
	public RequerimientoDetalle create(RequerimientoDetalle DTO) {
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

		RequerimientoDetalle obj = getById(id);
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
