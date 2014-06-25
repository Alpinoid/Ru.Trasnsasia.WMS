package ru.transasia.wms.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Transasia_GetOrdersListFromAccountingBase",
       uniqueConstraints = @UniqueConstraint(columnNames="OrderNumber") 
)
public class Orders {

	@Column(name="BranchName", unique=false, nullable=false)
	private String ordersBranch;
	
	@Column(name="OrderDate", unique=false, nullable=true)
    private String orderDate;

	@Id
	@Column(name="OrderNumber", unique=false, nullable=false)
    private String orderNumber;

	@Column(name="CustomerCode", unique=false, nullable=false)
    private String customerCode;
	
	@Column(name="CustomerName", unique=false, nullable=false)
    private String customerName;
	
	@Column(name="RowsCount", unique=false, nullable=true)
    private Integer rowsCount;
	
	@Column(name="BoxQuantity", unique=false, nullable=true)
    private BigDecimal boxQuantity;
	
	@Column(name="SourceBase", unique=false, nullable=false)
    private String sourceBase;

    public Orders() {
    }

	public String getOrdersBranch() {
		return ordersBranch;
	}

	public void setOrdersBranch(String ordersBranch) {
		this.ordersBranch = ordersBranch;
	}
	
    public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}

	public BigDecimal getBoxQuantity() {
		return boxQuantity;
	}

	public void setBoxQuantity(BigDecimal boxQuantity) {
		this.boxQuantity = boxQuantity;
		
	}
	
	public String getSourceBase() {
		return sourceBase;
	}

	public void setSourceBase(String sourceBase) {
		this.sourceBase = sourceBase;
	}

	@Override
	public String toString() {
		String result = "Order info - Date: " + this.getOrderDate() + "; Number: " + this.getOrderNumber();
		return result;
	}

}