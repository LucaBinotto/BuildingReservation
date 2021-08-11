package it.epicode.be.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.epicode.be.controller.model.Regole;
import it.epicode.be.exception.BusinessLogicException;
import it.epicode.be.serviceinterface.AbstractInfo;

@Service
public class InfoRegole implements AbstractInfo {
	
	@Value("${lang.italiano}")
	String regole;
	@Value("${lang.inglese}")
	String rules;
	@Value("${lang.notsupported}")
	String error;
	
	@Override
	public Regole langRegola(String lang) throws BusinessLogicException {
		Regole reg = new Regole();
		if(lang.equals("eng")) {
			reg.setTesto(rules);
			return reg;
		}else if(lang.equals("ita")) {
			reg.setTesto(regole);
			return reg;
		}else {
			throw new BusinessLogicException(error);
		}
		
	}
	
}
