package com.gnete.merchant.api.V60.test;


import com.gnetpg.HttpUtils;
import it.sauronsoftware.base64.Base64;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能说明
 * <ul>
 * <li>创建文件描述：银联-海关支付凭证接入接口-测试DEMO</li>
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
public class TestTran121
{

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		Test_API121();
	}
	
	
	private static void Test_API121() throws Exception
	{
		//上送参数
		String MD5Key = "12hi60ohgmp16nbev0gr8au69bodzguz";
		String MerId = "00H";
		
		String PayPlainText = "accessType=0&bizType=000201&certId=69597475696&currencyCode=156&encoding=UTF-8&merId=898440148160603&orderId=OO160481021361&queryId=201604121458050994508&reqReserved=null&respCode=00&respMsg=Success!&settleAmt=71616&settleCurrencyCode=156&settleDate=0412&signMethod=01&traceNo=099450&traceTime=0412145805&txnAmt=71616&txnSubType=01&txnTime=20160412145805&txnType=01&version=5.0.0";
		String PaySignMsg = "iDLZM1PnkFQimSrUOzenofmcrsy1z74uZMMaXzHsbcr0o538pChXK/Y6suG6CFpN2TANgjfI8CUSwiqVa3xaRq4+siak0eTOHQmvhS2tuCU8P8OabFYQ6kLbKSqUvCub4oD8OxfPo3edPnRfHf/4xdPDI6NWhv4iSmRsaaGgYUO00K7MQh0GWJKdPAdttsjJV9FOL4t7NL5lMggqrbE8TXV08124s10Nog7lAhRCM3dRTTRvsgX044EpXLWoQkpu9ATCuVbK+rMZObko6gK2/VX66h1W8GZ5vQVvjl6Y2ryoMmX5J3NLE8tDASyGq6wixRUYX+Ig+F7KfqTobUJpIA==";

		
    
		
		String Voucher ="CustomsCode:100011|MerID:00H|OrderNo:2018080610158195|OrderAmount:68.00|MerNo:001073920000003|RealName:左飞" +
				"|CredentialsType:01|CredentialsNo:421182198908242137|InternetDomainName:www.hnqst.cn|ECommerceCode:3122431069|ECommerceName:上海驿初网络科技有限公司" +
				"|MerCode:3122431069|MerName:上海驿初网络科技有限公司|CbepComCode:3100670978|CbepComName:上海驿初网络科技有限公司|CbepMerCode:3100670978|CbepMerName:上海驿初网络科技有限公司" +
				"|GoodsAmount:60.77|TaxAmount:7.23|Freight:0.00|InsuredFee:0.00|Mobile:|Email:|BizTypeCode:2|OriOrderNo:16209748291" +
				"|PaymentType:0|IEType:I|OrganType:1|PortCode:5208|CIQOrgCode:442100|BusinessType:B2B2C|CreTime:20180806140733|GetResultTime:20180806140733";
  
		String OrderNo = "2018080610158195";
		String ShoppingDate = "20180806";
		String PayAmount = "716.16";
		String CurrCode = "CNY";
		String DataSource = "CUP";
		String ParamsType = "02";
		String PayEntryptText = "";
		String Reserved1 = "Reserved1";
		String Reserved2 = "Reserved2";
		 
		//对上送报文进行MD5签名
		Map<String, Object> ParamSignMsgMap = new HashMap<String, Object>(9);
		ParamSignMsgMap.put("MerId",MerId);
		ParamSignMsgMap.put("OrderNo",OrderNo);
		ParamSignMsgMap.put("ShoppingDate",ShoppingDate);
		ParamSignMsgMap.put("PayAmount",PayAmount);
		ParamSignMsgMap.put("CurrCode",CurrCode);
		ParamSignMsgMap.put("DataSource",DataSource);
		ParamSignMsgMap.put("ParamsType",ParamsType);
		ParamSignMsgMap.put("PayEntryptText",Base64.encode(PayEntryptText,"utf-8")); //对PayEntryptText进行Base64编码
		ParamSignMsgMap.put("Voucher",Base64.encode(Voucher,"utf-8"));//对Voucher进行Base64编码
		ParamSignMsgMap.put("PayPlainText",Base64.encode(PayPlainText,"utf-8"));//对PayPlainText进行Base64编码
		ParamSignMsgMap.put("PaySignMsg",Base64.encode(PaySignMsg,"utf-8"));//对PaySignMsg进行Base64编码
		ParamSignMsgMap.put("Reserved1",Reserved1);
		ParamSignMsgMap.put("Reserved2",Reserved2);
		//MD5签名前对key值作升序排列
		String SignMsg = InnerInterfaceBuilderSignMsg(ParamSignMsgMap,MD5Key);
		System.out.println("请求报文MD5签名：" + SignMsg); 
		
		//拼接上送报文（需对PayPlainText、PaySignMsg进行Base64编码）
		StringBuilder ParamsBuf = new StringBuilder();
		ParamsBuf.append("Version=V60&TranType=121&JavaCharset=UTF-8");
		ParamsBuf.append("&MerId=").append(MerId);
		ParamsBuf.append("&OrderNo=").append(OrderNo);
		ParamsBuf.append("&ShoppingDate=").append(ShoppingDate);
		ParamsBuf.append("&PayAmount=").append(PayAmount);
		ParamsBuf.append("&CurrCode=").append(CurrCode);
		ParamsBuf.append("&DataSource=").append(DataSource);
		ParamsBuf.append("&ParamsType=").append(ParamsType);
		ParamsBuf.append("&PayEntryptText=").append(Base64.encode(PayEntryptText,"utf-8"));
		ParamsBuf.append("&Voucher=").append(Voucher);
		ParamsBuf.append("&PayPlainText=").append(Base64.encode(PayPlainText,"utf-8"));
		ParamsBuf.append("&PaySignMsg=").append(Base64.encode(PaySignMsg,"utf-8"));
		ParamsBuf.append("&Reserved1=").append(Reserved1);
		ParamsBuf.append("&Reserved2=").append(Reserved2);
		ParamsBuf.append("&SignMsg=").append(SignMsg);
		System.out.println("请求报文：" + ParamsBuf.toString()); 
		
		//此处http请求调用商户post实现方法
		HttpUtils http = new HttpUtils();
		String postUrl = "http://test.gnetpg.com:8089/GneteMerchantAPI/OraTrans.action";
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
		String Md5Key = Md52.md5(PKey,"UTF-8");
		String PlainText = SignMsg.toString() + Md5Key;
		System.out.println("【验名原文 + Md5Key】" + PlainText);
		String ResultSign = Md52.md5(PlainText,"UTF-8");
		System.out.println(PKey + "【签名数据】" + ResultSign);
		
		return ResultSign;
	}
	
}

class Md52
{
	public static String md5(String encryString)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(encryString.getBytes());
			byte b[] = digest.digest();
			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++)
			{
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			digest = null;
			b = null;
			return buf.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static String md5(String encryString, String Charset)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(encryString.getBytes(Charset));
			byte b[] = digest.digest();
			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++)
			{
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			digest = null;
			b = null;
			return buf.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}