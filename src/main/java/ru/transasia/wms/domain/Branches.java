package ru.transasia.wms.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="t_Transasia_Branches",
       uniqueConstraints = @UniqueConstraint(columnNames="BranchID") 
)
public class Branches {
	
	@Id
	@Column(name="BranchID", unique=true, nullable=false)
	private Integer branchID;
	
	@Column(name="BranchName", unique=true, nullable=false)
	private String branchName;
	
    public Branches() {
    }
    
	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(Integer branchID) {
		this.branchID = branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public static Branches getBranchByID(Collection<Branches> listBranches, Integer branchID) {
	    for(Branches branch : listBranches) {
	        if(branch != null && branch.getBranchID() == branchID) {
	            return branch;
	        }
	    }
	    return null;
	}

	@Override
	public String toString() {
		return getBranchName();
	}

}
