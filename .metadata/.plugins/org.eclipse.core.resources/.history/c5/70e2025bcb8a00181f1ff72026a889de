package dao.impl;
import java.util.List;

import javax.persistence.*;

import base.*;
import dao.*;
import dto.*;
public class EtapaImpl  extends JPA implements DAO<Etapa>{
	
	@Override
	public Etapa getById(Long id) 
	{
		Etapa result = getEntityManager().find(Etapa.class, id);
		closeEntityManager();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Etapa> getAll() 
	{
		String sql = "SELECT e FROM Etapa e";
		Query query = getEntityManager().createQuery(sql, Long.class);
		List<Etapa> list = query.getResultList();
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
	public Etapa update(Etapa DTO) 
	{
		if (DTO == null && DTO.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Etapa updateObj = getEntityManager().find(Etapa.class, DTO.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setDenominacion(DTO.getDenominacion());
		updateObj.setUbicacion(DTO.getUbicacion());
		updateObj.setProyecto(DTO.getProyecto());
		
		t.commit();
		closeEntityManager();
		return DTO;
	}

	@Override
	public Etapa create(Etapa DTO) 
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
	public boolean delete(Long id) 
	{
		if (id == 0) {
			return false;
		}

		Etapa obj = getById(id);
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
	public Long getMaxId() 
	{
		String sql = "SELECT max(g.id) + 1 FROM Etapa g";
		Query query = getEntityManager().createQuery(sql, Long.class);
		Long maxId = (query.getSingleResult() == null) ? 1L : (Long) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}


	
}
