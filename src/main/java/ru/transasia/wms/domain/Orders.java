package ru.transasia.wms.domain;

import java.util.Date;

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

	@Column(name="OrderDate", unique=false, nullable=true)
    private Date orderDate;

	@Id
	@Column(name="OrderNumber", unique=false, nullable=false)
    private String orderNumber;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="BranchName", nullable=false)
	@Column(name="BranchName", unique=false, nullable=false)
//	private Branches ordersBranch;
	private String ordersBranch;
	
	@Column(name="CustomerCode", unique=false, nullable=false)
    private String customerCode;
	
	@Column(name="CustomerName", unique=false, nullable=false)
    private String customerName;
	
	@Column(name="WarehouseName", unique=false, nullable=false)
    private String warehouseName;
	
	@Column(name="RowsCount", unique=false, nullable=true)
    private Integer rowsCount;
	
	@Column(name="BoxQuantity", unique=false, nullable=true)
    private Float boxQuantity;

    public Orders() {
    }

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrdersBranch() {
		return ordersBranch;
	}

	public void setOrdersBranch(String ordersBranch) {
		this.ordersBranch = ordersBranch;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}

	public Float getBoxQuantity() {
		return boxQuantity;
	}

	public void setBoxQuantity(Float boxQuantity) {
		this.boxQuantity = boxQuantity;
	}

	@Override
	public String toString() {
		String result = "Order info - Date: " + this.getOrderDate() + "; Number: " + this.getOrderNumber();
		return result;
	}

}