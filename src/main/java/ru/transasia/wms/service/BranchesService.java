package ru.transasia.wms.service;

import java.util.List;

import ru.transasia.wms.domain.Branches;

public interface BranchesService {
    
	public List<Branches> getAllBranches();
	
	public Branches getBranchByID(Integer branchID);
	
	public Branches getBranchByName(String branchName);

}