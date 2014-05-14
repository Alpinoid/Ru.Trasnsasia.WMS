package ru.transasia.wms.service;

import ru.transasia.wms.domain.Slots;

import java.util.List;

public interface SlotsService {
    
	public List<Slots> getAllSlots();
    
    public Slots findSlotByCell(String slotCell);
    
    public void save(Slots slot);
    
    public void delete(Slots slot);
    
    public void deleteAllSlots();

}