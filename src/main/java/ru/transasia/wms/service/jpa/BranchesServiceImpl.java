package ru.transasia.wms.service.jpa;

import ru.transasia.wms.domain.Branches;
import ru.transasia.wms.repository.BranchesRepository;
import ru.transasia.wms.service.BranchesService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaBranchService")
@Repository
@Transactional
public class BranchesServiceImpl implements BranchesService {

	@Autowired
	private BranchesRepository branchRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public List<Branches> getAllBranches() {
		return branchRepository.findAll(new Sort(Direction.ASC, "branchName"));
	}

	@Override
	@Transactional(readOnly=true)
	public Branches getBranchByID(Integer branchID) {
		return branchRepository.findOne(branchID);
	}

	@Override
	@Transactional(readOnly=true)
	public Branches getBranchByName(String branchName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}