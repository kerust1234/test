package com.gnete.merchant.api.V60.test;

import com.gnetpg.HttpUtils;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能说明
 * <ul>
 * <li>创建文件描述：银联-海关支付凭证查询接口-测试DEMO</li>
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
public class TestTran110
{

	private static final String QSTRING_SPLIT = "&";
	public static final String QSTRING_EQUAL = "=";

	/**
	 * @param args
	 * @throws Exception
	 * 提供商户查询海关数据接口，查询入参MerId
	 */
	public static void main(String[] args) throws Exception
	{
		Test_API110();
	}
	
	
	
	private static void Test_API110() throws Exception
	{
		Map<String, String> Req = new HashMap<String, String> ();
		Req.put("MerId", "00H");
		Req.put("UserId", "00H");
		Req.put("Pwd", md5("123!@#QAZ"));
		
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
		String DateTime = Format.format(new Date());
		Req.put("BeginTime", DateTime + " 00:00:00");
		Req.put("EndTime", DateTime + " 22:00:00");
		//Req.put("OrderNo", "2016112810158189");
		Req.put("ExtFields", "");
		Req.put("OrderStatus", "0");
		Req.put("TranType", "110");
		Req.put("JavaCharset", "UTF-8"); 
		Req.put("Version", "V60");
		
		//MD5加密
		String Params = TestTran110.CreateLinkString(Req, false);
		System.out.println("上送信息: " + Params + "<br>");
		String postUrl = "http://test.gnetpg.com:8089/GneteMerchantAPI/Trans.action";
		
		//此处http请求调用商户post实现方法
		HttpUtils http = new HttpUtils();
		String respMsg = http.doHttpPost(postUrl, Params, "UTF-8", "test.gnetpg.com");
		System.out.println("返回信息：" + respMsg);
	}
	

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
	
	/**
	 * 把请求要素按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * @return 拼接成的字符串
	 */
	private static String CreateLinkString(Map<String, String> para, boolean sort)
	{
//		final String QSTRING_SPLIT = "&";
//		final String QSTRING_EQUAL = "=";
		List<String> keys = new ArrayList<String>(para.keySet());
		if (sort) Collections.sort(keys);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keys.size(); i++)
		{
			String key = keys.get(i);
			String value = para.get(key);

			if (i == keys.size() - 1)
			{
				sb.append(key).append(QSTRING_EQUAL).append(value);
			}
			else
			{
				sb.append(key).append(QSTRING_EQUAL).append(value).append(QSTRING_SPLIT);
			}
		}
		return sb.toString();
	}
}

