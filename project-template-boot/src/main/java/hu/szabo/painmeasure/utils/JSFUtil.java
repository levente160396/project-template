package hu.szabo.painmeasure.utils;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JSFUtil implements Serializable {

	private static final long serialVersionUID = 1576540425630062371L;

	public static void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			throw new IllegalStateException(url, e);
		}
	}
	
	public static void redirectRelative(String relativeUrl) {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getApplicationContextPath() + relativeUrl);
		} catch (IOException e) {
			throw new IllegalStateException(relativeUrl, e);
		}
	}
}
