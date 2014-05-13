package ru.transasia.wms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="tmp_slot",
       uniqueConstraints = @UniqueConstraint(columnNames="Art") 
)
public class Slots {

	@Id
	@Length(min=3, max=255, message="{validation_name_size}")
	@Column(name="Art", unique=true, nullable=true)
    private String articul;

	@Length(min=3, max=255, message="{validation_name_size}")
	@Column(name="Nm", unique=false, nullable=true)
    private String name;
	
	@Length(min=3, max=255, message="{validation_name_size}")
	@Column(name="Cell", unique=false, nullable=true)
    private String cell;

    public Slots() {
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

	public String getCell() {
		return cell;
	}

	public void setCell(String cellString) {
		cell = cellString;
	}

	@Override
	public String toString() {
		String result = "Slot - Articul: " + this.getArticul() + "; Name: " + this.getName() + "; Cell: " + this.getCell();
		return result;
	}

}