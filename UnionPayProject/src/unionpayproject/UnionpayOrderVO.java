/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionpayproject;

import java.util.ArrayList;

/**
 *
 * @author CN085258
 */
public class UnionpayOrderVO {

	protected String orderNo;
    protected String respCode;
    @SuppressWarnings("rawtypes")
	protected ArrayList list01;

	/**
     * @return the orderNo
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return the respCode
     */
    public String getRespCode() {
        return respCode;
    }

    /**
     * @param respCode the respCode to set
     */
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnionpayOrderVO [orderNo=" + orderNo + ", respCode=" + respCode + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((respCode == null) ? 0 : respCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnionpayOrderVO other = (UnionpayOrderVO) obj;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (respCode == null) {
			if (other.respCode != null)
				return false;
		} else if (!respCode.equals(other.respCode))
			return false;
		return true;
	}
	
	


	public UnionpayOrderVO() {
		super();
	}

	@SuppressWarnings("unused")
	private UnionpayOrderVO(String orderNo, String respCode) {
		super();
		this.orderNo = orderNo;
		this.respCode = respCode;
	}
	
	public ArrayList getArrayList() {
		return new ArrayList();
	}
	
        
	
    
}
