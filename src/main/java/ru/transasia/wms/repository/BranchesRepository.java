package ru.transasia.wms.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import ru.transasia.wms.domain.Branches;

import java.lang.Integer;
import java.util.List;

public interface BranchesRepository extends CrudRepository<Branches, Integer>{
	
	List<Branches> findAll(Sort sort);
	
	Branches findOne(Integer branchID);

}
