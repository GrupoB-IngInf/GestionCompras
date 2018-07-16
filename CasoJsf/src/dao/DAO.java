package dao;

import java.util.List;

public interface DAO<DTO> {
	
public DTO getById(Long id);
	
public List<DTO> getAll();

public DTO update(DTO DTO);

public DTO create (DTO DTO);

public boolean delete (Long id);

public Long getMaxId();


}