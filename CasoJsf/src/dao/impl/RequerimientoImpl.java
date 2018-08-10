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
		
		updateObj.setFecha(DTO.getFecha());
		updateObj.setAreaNegocio(DTO.getAreaNegocio());
		updateObj.setCentroCosto(DTO.getCentroCosto());
		updateObj.setDetalles(DTO.getDetalles());
		
		
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
	
	public List<RequerimientoDetalle> getAllApproved() {
		String sql = "SELECT d FROM RequerimientoDetalle d JOIN d.requerimiento r WHERE r.estado=:estado AND d.atendido=false";
		Query query = getEntityManager().createQuery(sql, Long.class);
		query.setParameter("estado", Estado.APROBADO);
		List<RequerimientoDetalle> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}	

}