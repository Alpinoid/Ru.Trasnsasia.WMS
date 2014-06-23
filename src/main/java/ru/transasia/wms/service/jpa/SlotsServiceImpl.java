package ru.transasia.wms.service.jpa;

import ru.transasia.wms.domain.Slots;
import ru.transasia.wms.repository.SlotsRepository;
import ru.transasia.wms.service.SlotsService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaSlotService")
@Repository
@Transactional
public class SlotsServiceImpl implements SlotsService {

	@Autowired
	private SlotsRepository slotRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public List<Slots> getAllSlots() { 
		Sort sort = new Sort(Direction.ASC, "cell");
        return slotRepository.findAll(sort);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Slots getSlotByCell(String slotCell) {
		return slotRepository.findByCell(slotCell);
	}

	@Override
	public void save(Slots slot) {
		slotRepository.save(slot);
	}

	@Override
	public void delete(Slots slot) {	
		slotRepository.delete(slot);
	}

	@Override
	public void deleteAllSlots() {
		slotRepository.deleteAll();	
	}
    
}