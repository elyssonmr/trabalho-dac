package fai.controller.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Utils {

	public static void addErrorMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg));
	}

}
