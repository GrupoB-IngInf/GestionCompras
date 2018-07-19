package dao.impl;

import java.util.List;
import javax.persistence.*;
import base.*;
import dao.*;
import dto.*;

//Controlador
public class ProveedorImpl extends JPA implements DAO<Proveedor>{

	@Override
	public Proveedor getById(Long id) {
		Proveedor result = getEntityManager().find(Proveedor.class, id);
		closeEntityManager();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> getAll() {
		String sql = "SELECT p FROM Proveedor p";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Proveedor> list = query.getResultList();
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
	public Proveedor update(Proveedor DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Proveedor updateObj = getEntityManager().find(Proveedor.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setRuc(DTO.getRuc());
		updateObj.setDireccion(DTO.getDireccion());
		updateObj.setContacto(DTO.getContacto());
		updateObj.setCorreo(DTO.getCorreo());
		updateObj.setCuenta_corriente(DTO.getCuenta_corriente());
		updateObj.setEstado(DTO.getEstado());
		updateObj.setBanco(DTO.getBanco());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Proveedor create(Proveedor DTO) {   
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

		Proveedor obj = getById(id);
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
		String sql = "SELECT max(p.id) + 1 FROM Provedor p";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	public Proveedor unSuscribe(Proveedor DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Proveedor updateObj = getEntityManager().find(Proveedor.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombre(DTO.getNombre());
		updateObj.setRuc(DTO.getRuc());
		updateObj.setDireccion(DTO.getDireccion());
		updateObj.setContacto(DTO.getContacto());
		updateObj.setCorreo(DTO.getCorreo());
		updateObj.setCuenta_corriente(DTO.getCuenta_corriente());
		updateObj.setEstado(DTO.getEstado());
		updateObj.setBanco(DTO.getBanco());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}
	
}
