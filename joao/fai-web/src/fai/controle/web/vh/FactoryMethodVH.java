
package fai.controle.web.vh;

import java.util.HashMap;
import java.util.Map;



public class FactoryMethodVH {
	private static Map<String, IViewHelperWeb> vhs;
	
	public static IViewHelperWeb create(String url){
		return vhs.get(url);
	}

	public static void setVhs(Map<String, IViewHelperWeb> vhs) {
		FactoryMethodVH.vhs = vhs;
	}
	

}
