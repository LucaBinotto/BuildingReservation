package it.epicode.be.serviceinterface;

import it.epicode.be.controller.model.Regole;
import it.epicode.be.exception.BusinessLogicException;

public interface AbstractInfo {

	Regole langRegola(String lang) throws BusinessLogicException;

}