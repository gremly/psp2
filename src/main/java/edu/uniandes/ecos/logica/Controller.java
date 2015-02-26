package edu.uniandes.ecos.logica;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.HandlerBase;

import edu.uniandes.ecos.presentacion.WebView;

public class Controller {

	private Operator operator;
	private WebView webview;
	
	public Controller(WebView webview, Operator operator) {
		this.operator = operator;
		this.webview = webview;
	}

	public void showHome(HttpServletRequest req, HttpServletResponse resp) {
		try {
			webview.showHome(req, resp);	
		} catch (Exception e) {
			 Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void showNotFound(HttpServletRequest req, HttpServletResponse resp) {
		try {
			webview.showNotFound(req, resp);	
		} catch (Exception e) {
			 Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void calculate(HttpServletRequest req, HttpServletResponse resp) {
		HashMap<String, Double> results;
		
		double varX = Double.parseDouble(req.getParameter("varx"));
		int dof = Integer.parseInt(req.getParameter("dof"));
		int segments = Integer.parseInt(req.getParameter("segments"));
		operator.setData(varX, dof, segments);
		results = operator.calcIntegral();
		
		try {
			webview.showResults(req, resp, results);
		} catch (Exception e) {
			 Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}