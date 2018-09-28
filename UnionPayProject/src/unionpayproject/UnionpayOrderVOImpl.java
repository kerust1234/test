package unionpayproject;

public class UnionpayOrderVOImpl extends UnionpayOrderVO {
	

	/**
	 * 
	 */
	public UnionpayOrderVOImpl() {
		//super("unionpayconstruct","unionpayconstruct");
		// TODO Auto-generated constructor stub
		this.orderNo = "unionpayOrderVOImpl01";
	}

	/**
	 * @return finally return value
	 */
	@SuppressWarnings("finally")
	public boolean getUnionpayOrderVOImpl() {
		// TODO Auto-generated constructor stub
		this.respCode = "unionpayOrderVOImplRespCode";
		this.list01 = super.getArrayList();
		try {
			return true;
		} catch (Exception e) {
			
		} finally {
			return false;
		}
	}

}
