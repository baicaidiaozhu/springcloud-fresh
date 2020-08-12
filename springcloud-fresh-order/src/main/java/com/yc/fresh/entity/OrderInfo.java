package com.yc.fresh.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 订单表
 *源辰信息
 * @author LiuJie
 * @date 2020年3月30日
 */
public class OrderInfo implements Serializable{
	private String ono;
	private String odate;//下单日期
	private Integer ano;//收货地址
	private String sdate; //发货日期
	private String rdate; //收货日期
	private Integer status;// 订单状态
	private Double priceAll ;// 订单总额
	private Integer invoice ;//是否已开发票
	
	private List<OrderItemInfo> orderItem;
	
	

	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", ano=" + ano + ", sdate=" + sdate + ", rdate=" + rdate
				+ ", status=" + status + ", priceAll=" + priceAll + ", invoice=" + invoice + ", orderItem=" + orderItem
				+ "]";
	}

	
	public List<OrderItemInfo> getOrderItem() {
		return orderItem;
	}


	public void setOrderItem(List<OrderItemInfo> orderItem) {
		this.orderItem = orderItem;
	}


	public String getOno() {
		return ono;
	}

	public void setOno(String ono) {
		this.ono = ono;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getPriceAll() {
		return priceAll;
	}

	public void setPriceAll(Double priceAll) {
		this.priceAll = priceAll;
	}

	public Integer getInvoice() {
		return invoice;
	}

	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		result = prime * result + ((priceAll == null) ? 0 : priceAll.hashCode());
		result = prime * result + ((rdate == null) ? 0 : rdate.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (priceAll == null) {
			if (other.priceAll != null)
				return false;
		} else if (!priceAll.equals(other.priceAll))
			return false;
		if (rdate == null) {
			if (other.rdate != null)
				return false;
		} else if (!rdate.equals(other.rdate))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public OrderInfo(String ono, String odate, Integer ano, String sdate, String rdate, Integer status, Double priceAll,
			Integer invoice) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.sdate = sdate;
		this.rdate = rdate;
		this.status = status;
		this.priceAll = priceAll;
		this.invoice = invoice;
	}

	public OrderInfo() {
		super();
	}
	
	
}
