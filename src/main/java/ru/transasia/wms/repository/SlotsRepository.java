package ru.transasia.wms.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import ru.transasia.wms.domain.Slots;

import java.lang.Integer;
import java.util.List;
import java.lang.String;

public interface SlotsRepository extends CrudRepository<Slots, Integer>{
	
	List<Slots> findAll(Sort sort);

	Slots findByCell(String cell);
	
	void deleteAll();

}
