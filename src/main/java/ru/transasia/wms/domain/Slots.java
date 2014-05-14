package ru.transasia.wms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tmp_slot",
       uniqueConstraints = @UniqueConstraint(columnNames="Cell") 
)
public class Slots {

	@Id
	@Column(name="Cell", unique=true, nullable=true)
    private String cell;
	
	@Column(name="Art", unique=false, nullable=true)
    private String articul;

	@Column(name="Nm", unique=false, nullable=true)
    private String name;

    public Slots() {
    }
    
	public String getCell() {
		return cell;
	}

	public void setCell(String cellString) {
		cell = cellString;
	}
   
	public String getArticul() {
		return articul;
	}

	public void setArticul(String articulString) {
		articul = articulString;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameString) {
		name = nameString;
	}

	@Override
	public String toString() {
		String result = "Slot info - Cell: " + this.getCell() + "; Articul: " + this.getArticul() + "; Name: " + this.getName();
		return result;
	}

}