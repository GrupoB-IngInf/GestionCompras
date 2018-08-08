package dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import base.JPA;
import dao.DAO;
import dto.Estado;
import dto.OrdenCompra;

public class OrdenCompraImpl extends JPA implements DAO<OrdenCompra> {

	@Override
	public OrdenCompra getById(Long id) {
		OrdenCompra result = getEntityManager().find(OrdenCompra.class, id);
		closeEntityManager();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompra> getAll() {
		String sql = "SELECT o FROM OrdenCompra o";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<OrdenCompra> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	@Override
	public OrdenCompra update(OrdenCompra DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		OrdenCompra updateObj = getEntityManager().find(OrdenCompra.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setCodigo(DTO.getCodigo());
		updateObj.setFechaEmision(DTO.getFechaEmision());
		updateObj.setFechaEntrega(DTO.getFechaEntrega());
		updateObj.setVersion(DTO.getVersion());
		updateObj.setMoneda(DTO.getMoneda());
		updateObj.setPago(DTO.getPago());
		updateObj.setFormaPago(DTO.getFormaPago());
		updateObj.setObservaciones(DTO.getObservaciones());
		updateObj.setEstado(DTO.getEstado());
		updateObj.setProveedor(DTO.getProveedor());
		updateObj.setResponsable(DTO.getResponsable());
		updateObj.setDetalle(DTO.getDetalle());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public OrdenCompra create(OrdenCompra DTO) {
		EntityTransaction t = getEntityManager().getTransaction();
		if (!t.isActive()) {
			t.begin();
		}
		DTO.setEstado(Estado.PENDIENTE);
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

		OrdenCompra obj = getById(id);
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
		String sql = "SELECT max(o.id) + 1 FROM OrdenCompra o";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	public OrdenCompra unSuscribe(OrdenCompra DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		OrdenCompra updateObj = getEntityManager().find(OrdenCompra.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setEstado(Estado.ANULADO);
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

}
