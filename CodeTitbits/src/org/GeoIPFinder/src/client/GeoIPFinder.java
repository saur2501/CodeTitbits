
package client;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class GeoIPFinder {

	public static void main(String[] args) {
		/*String ipAddress = "172.217.160.142";
		GeoIPService geoIPService = new GeoIPService();
		GeoIPServiceSoap geoIPServiceSoap = geoIPService.getGeoIPServiceSoap();
		GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
		System.out.println(geoIP.getCountryName());*/
		GlobalWeather globalWeather = new GlobalWeather();
		GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();
		String cities = globalWeatherSoap.getCitiesByCountry("India");
		System.out.println(cities);
		System.out.println(globalWeatherSoap.getWeather("Bombay", "India"));
	}

}
