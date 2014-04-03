package com.kanchutech.eden.util;

import java.util.Map;

import javax.faces.context.FacesContext;

public class FacesUtil {
	public static Map<String, String> getRequestParamMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params;
	}
}
