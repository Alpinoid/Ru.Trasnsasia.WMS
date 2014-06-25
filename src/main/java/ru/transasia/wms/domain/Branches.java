package ru.transasia.wms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Transasia_GetBranchesByOrdersFromAccountingBase",
       uniqueConstraints = @UniqueConstraint(columnNames="BranchName") 
)
public class Branches {
	
	@Id
	@Column(name="BranchName", unique=true, nullable=false)
	private String branchName;
	
    public Branches() {
    }

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return getBranchName();
	}

}
