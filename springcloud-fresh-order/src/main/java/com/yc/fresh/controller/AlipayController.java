package com.yc.fresh.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.yc.fresh.service.IOrderItemBiz;
import com.yc.fresh.util.AlipayConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/apli")
public class AlipayController{
	@Autowired
	private IOrderItemBiz orderItem;
	
	@RequestMapping("/pay/{ono}/{price}")		//踩坑记录->这里不可直接return result; 必须要response.getWriter().print(result);或者以map键值对方法返回
	public void toPay(@PathVariable String ono,@PathVariable double price,HttpServletRequest request,HttpServletResponse resp,HttpSession session){
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
 
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        
        String subject = "源辰零食网";
        //商品描述
        String body ="美食在手,快乐我有";
        
        try {
        	alipayRequest.setBizContent("{\"out_trade_no\":\""+ono +"\"," 
    				+ "\"total_amount\":\""+ price +"\"," 
    				+ "\"subject\":\""+ subject +"\"," 
    				+ "\"body\":\""+ body +"\"," 
    				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
 
            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            resp.setContentType("text/html; charset=utf-8");
    		resp.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


 
	@RequestMapping("/return")
    public void toIndex(HttpServletResponse resp,HttpSession session,HttpServletRequest request) throws IOException{
		//获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		} //调用SDK验证签名
		//商户订单号
		String ono = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		
		orderItem.update(ono);
		orderItem.updateItem(ono);
		PrintWriter out = resp.getWriter();
		out.print("<script>location.href='/order/order.html'</script>");
    }
}
