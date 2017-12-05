/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author MONTES
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    private FacesContext context = FacesContext.getCurrentInstance();

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        String view = "";
        if (username.equals("admin") && password.equals("123456")) {
            context.getExternalContext().getSessionMap().put("user", username);
            view = "backend/factura";
        }else{
            String messageType = "error";
            String messageTitle = "Error de Atutenticación";
            String messageContent = "Verificar su nombre de usuario y su password.";
            showMessage(messageType, messageTitle, messageContent);
        }
        return view;
    }

    private void showMessage(String type, String title, String content) {
        Severity severity = FacesMessage.SEVERITY_INFO;
        if (type.equals("error")) {
            severity = FacesMessage.SEVERITY_ERROR;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, content));
    }

    public void logout() {
        context.getExternalContext().invalidateSession();
        try {
            HttpServletRequest origRequest = (HttpServletRequest)context.getExternalContext().getRequest();
            String contextPath = origRequest.getContextPath();
            context.getExternalContext().redirect(contextPath+"/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
