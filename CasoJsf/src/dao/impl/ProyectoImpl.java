package dao.impl;
import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;
public class ProyectoImpl extends JPA implements DAO<Proyecto> {
	
	@Override
	public Proyecto getById(Long id) {
		Proyecto result = getEntityManager().find(Proyecto.class, id);
		closeEntityManager();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> getAll() 
	{
		String sql = "SELECT p FROM Proyecto p";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Proyecto> list = query.getResultList();
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
	public Proyecto update(Proyecto DTO) 
	{
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Proyecto updateObj = getEntityManager().find(Proyecto.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		System.out.print(DTO.getNombre());
		System.out.print(DTO.getUbicacion());
		updateObj.setNombre(DTO.getNombre());
		updateObj.setUbicacion(DTO.getUbicacion());
		
		t.commit();
		closeEntityManager();

		return DTO;
	}

	@Override
	public Proyecto create(Proyecto DTO) 
	{   //Llega el material con el estado incompleto,le falta el estado
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

		Proyecto obj = getById(id);
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
		String sql = "SELECT max(g.id) + 1 FROM Proyecto g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
}
