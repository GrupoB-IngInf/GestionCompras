package dao.impl;
import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;

public class UsuarioImpl extends JPA implements DAO<Usuario>{

	@Override
	public Usuario getById(Long id) {
		Usuario result = getEntityManager().find(Usuario.class, id);
		closeEntityManager();
		return result;
	}

	@Override
	public List<Usuario> getAll() {
		String sql = "SELECT g FROM Usuario g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Usuario> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	@Override
	public Usuario update(Usuario DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Usuario updateObj = getEntityManager().find(Usuario.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombres(DTO.getNombres());
		updateObj.setApellidos(DTO.getApellidos());
		updateObj.setCorreo(DTO.getCorreo());
		updateObj.setPassword(DTO.getPassword());
		updateObj.setTelefono(DTO.getTelefono());
		updateObj.setEstado(DTO.getEstado());
		updateObj.setRol(DTO.getRol());
		
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Usuario create(Usuario DTO) {
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

		Usuario obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Usuario g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
	
	public Usuario unSuscribe(Usuario DTO) {
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Usuario updateObj = getEntityManager().find(Usuario.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombres(DTO.getNombres());
		updateObj.setApellidos(DTO.getApellidos());
		updateObj.setCorreo(DTO.getCorreo());
		updateObj.setPassword(DTO.getPassword());
		updateObj.setTelefono(DTO.getTelefono());
		updateObj.setEstado("Baja");
		updateObj.setRol(DTO.getRol());
		
		
		t.commit();
		closeEntityManager();
		return DTO;
	}
	

}
