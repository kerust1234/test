package com.gnete.merchant.api.V60.test;


import com.gnetpg.HttpUtils;
import com.gnetpg.Md5;
import it.sauronsoftware.base64.Base64;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能说明
 * <ul>
 * <li>创建文件描述：银联-海关支付凭证更新接口-测试DEMO</li>
 * 
 * <li>修改文件描述：</li>
 * </ul>
 * 
 * @author <ul>
 *         <li>创建者： </a></li>
 *         <li>修改者： </li>
 *         </ul>
 * @version <ul>
 *          <li>创建版本：</li>
 *          <li>修改版本：</li>
 *          </ul>
 */
public class TestTran122
{

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		Test_API122();
	}
	
	
	private static void Test_API122() throws Exception
	{
		//上送参数
		String MD5Key = "12hi60ohgmp16nbev0gr8au69bodzguz";
		String MerId = "00S";
		
		String OrderNo =  "2017011300303";
		String ShoppingDate = "20180706";
		String UserID = "00S";
		String Pwd = Md5.md5("123!@#QAZ");
		String OrganType = "2";
		String CustomsCode = "100012";
		String UpdateData = "OrderAmount:68|RealName:通过接口    |GoodsAmount:11|TaxAmount:7.23|Freight:0.00|CredentialsType:|CredentialsNo:|ECommerceCode:|ECommerceName:" +
				"|MerCode:|MerName:|CbepComCode:|CbepComName:|CbepMerName:|CustomsCode:100012|PortCode:0000|CIQOrgCode:000069|InternetDomainName:www|" +
				"BusinessType:";

		//对上送报文进行MD5签名
		Map<String, Object> ParamSignMsgMap = new HashMap<String, Object>(9);
		ParamSignMsgMap.put("ShoppingDate",ShoppingDate);
		ParamSignMsgMap.put("MerId",MerId);
		ParamSignMsgMap.put("OrderNo",OrderNo);
		ParamSignMsgMap.put("UserID",UserID);
		ParamSignMsgMap.put("Pwd",Pwd);
		ParamSignMsgMap.put("OrganType",OrganType);
		ParamSignMsgMap.put("CustomsCode",CustomsCode);
		ParamSignMsgMap.put("UpdateData",Base64.encode(UpdateData,"utf-8"));//对Voucher进行Base64编码
		
		//MD5签名前对key值作升序排列
		String SignMsg = InnerInterfaceBuilderSignMsg(ParamSignMsgMap,MD5Key);
		System.out.println("请求报文MD5签名：" + SignMsg); 
		
		//拼接上送报文
		StringBuilder ParamsBuf = new StringBuilder();
		ParamsBuf.append("Version=V60&TranType=122&JavaCharset=UTF-8");
		ParamsBuf.append("&ShoppingDate=").append(ShoppingDate);
		ParamsBuf.append("&MerId=").append(MerId);
		ParamsBuf.append("&OrderNo=").append(OrderNo);
		ParamsBuf.append("&UserID=").append(UserID);
		ParamsBuf.append("&Pwd=").append(Pwd);
		ParamsBuf.append("&OrganType=").append(OrganType);
		ParamsBuf.append("&CustomsCode=").append(CustomsCode);
		ParamsBuf.append("&UpdateData=").append(UpdateData);
		ParamsBuf.append("&SignMsg=").append(SignMsg);
		System.out.println("请求报文：" + ParamsBuf.toString()); 
		
		//此处http请求调用商户post实现方法
		HttpUtils http = new HttpUtils();
		String postUrl = "http://test.gnetpg.com:8089/GneteMerchantAPI/Trans.action";
		String respMsg = http.doHttpPost(postUrl, ParamsBuf.toString(), "utf-8", "test.gnetpg.com");
		System.out.println("返回信息：" + respMsg);
	}
	

	public static String InnerInterfaceBuilderSignMsg(Map<String, Object> ParamSignMsgMap, String PKey) throws Exception
	{
		List<String> Keys = new ArrayList<String>(ParamSignMsgMap.keySet());
		Collections.sort(Keys);
		
		StringBuffer SignMsg = new StringBuffer();
		for (int i = 0; i < Keys.size(); i++)
		{
			String Key = Keys.get(i);
			String Value = (String) ParamSignMsgMap.get(Key);
			SignMsg.append(Key).append("=").append(Value).append("&"); 
		}
		String Md5Key = Md5.md5(PKey,"UTF-8");
		String PlainText = SignMsg.toString() + Md5Key;
		System.out.println("【验名原文 + Md5Key】" + PlainText);
		String ResultSign = Md5.md5(PlainText,"UTF-8");
		System.out.println(PKey + "【签名数据】" + ResultSign);
		
		return ResultSign;
	}	
}