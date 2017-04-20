package client;

import cn.com.WebXml.IpAddressSearchWebServiceSoapProxy;
import cn.com.WebXml.MobileCodeWSSoapProxy;
import cn.com.WebXml.WeatherWSSoapProxy;

import java.rmi.RemoteException;

public class SwingServer {
	public	static String GetPhoneInfo(String phoneNum){
		String result = "";
		MobileCodeWSSoapProxy mobileCodeWSSoapProxy = new MobileCodeWSSoapProxy();
		try {
			result =  mobileCodeWSSoapProxy.getMobileCodeInfo(phoneNum," ");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static String[] GetWeather(String code){
		WeatherWSSoapProxy weatherWSSoapProxy = new WeatherWSSoapProxy();
		String[] strings = null;
		try {
			strings = weatherWSSoapProxy.getWeather(code," ");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return strings;
	}

	public static String[] GetIpInfo(String ipAddress){
		IpAddressSearchWebServiceSoapProxy ipAddressSearchWebServiceSoapProxy = new IpAddressSearchWebServiceSoapProxy();
		String[] result=null;
		try {
			result = ipAddressSearchWebServiceSoapProxy.getCountryCityByIp(ipAddress);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
