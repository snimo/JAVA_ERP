package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.List;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class DescomponerIdentifComproCab {

  private String identificador;
  private ISesion sesion;
  private List comprobantes;

  private String TC;
  private String letra;
  private Integer lugEmi;
  private Integer nroExt;


  public DescomponerIdentifComproCab(String identificador,ISesion aSesion) throws
      ExceptionValidation {
    this.identificador = identificador;
    this.sesion = aSesion;

    try {
      descomponerIdentificador();
    }
    catch (BaseException ex) {
      throw new ExceptionValidation(null,"Formato de comprobante desconocido");
    }
  }
  
  public DescomponerIdentifComproCab(String tc,String letra,Integer lugEmi,String identificador,ISesion aSesion) throws
  ExceptionValidation {
  	this.identificador = identificador;
  	this.sesion = aSesion;

  	try {
  		setComprobantes(this.getComprobantes(tc,letra,lugEmi));
  	}
  	catch (BaseException ex) {
  		throw new ExceptionValidation(null,"Formato de comprobante desconocido");
  	}
  }
  
  

  public String getTC() {
    return TC;
  }

  public Integer getLugEmi() {
    return lugEmi;
  }

  public String getLetra() {
    return letra;
  }

  public void setNroExt(Integer nroExt) {
    this.nroExt = nroExt;
  }

  public void setTC(String TC) {
    this.TC = TC;
  }

  public void setLugEmi(Integer lugEmi) {
    this.lugEmi = lugEmi;
  }

  public void setLetra(String letra) {
    this.letra = letra;
  }

  public Integer getNroExt() {
    return nroExt;
  }

  private void descomponerTCyNroExt(String[] compoIdentif) throws BaseException {
    setTC(compoIdentif[0]);
    setLetra(ComproCab.getLetraDefault(sesion));
    setLugEmi(ComproCab.getLugEmiDafault(sesion).getOIDInteger());
    setNroExt(new Integer(compoIdentif[1]));
  }
  
  private void descomponerTCyNroExt(String letra,Integer lugEmi,String[] compoIdentif) throws BaseException {
    setTC(compoIdentif[0]);
    setLetra(letra);
    setLugEmi(lugEmi);
    setNroExt(new Integer(compoIdentif[1]));
  }
  
  
  private void descomponerTCyNroExt(String letra,
  		LugarEmision lugEmi,
  		String[] compoIdentif) throws BaseException {
    setTC(compoIdentif[0]);
    setLetra(letra);
    setLugEmi(lugEmi.getLugemi());
    setNroExt(new Integer(compoIdentif[1]));
  }

  private void descomponerTCLetraLugEmiNroExt(String[] compoIdentif) throws BaseException {
    setTC(compoIdentif[0]);
    setLetra(compoIdentif[1]);
    setLugEmi(new Integer(compoIdentif[2]));
    setNroExt(new Integer(compoIdentif[3]));
  }


  private void descomponerIdentificador() throws BaseException {
    String[] compoIdentif = identificador.split("-");
    if (compoIdentif.length==2)
      descomponerTCyNroExt(compoIdentif);
    else
      if (compoIdentif.length==4)
        descomponerTCLetraLugEmiNroExt(compoIdentif);
    else
      throw new ExceptionValidation(null,"Formato de Comprobante desconocido");
  }
  
  private void descomponerNroExt(
  		String tcDefault,
  		String letraDefault,
  		Integer lugEmiDefault,
  		String descomponerIdentif) throws BaseException {
  	this.setTC(tcDefault);
  	this.setLetra(letraDefault);
  	this.setLugEmi(lugEmiDefault);
  	
  	try {
  		this.setNroExt(new Integer(descomponerIdentif));
  	}
  	catch(Exception e) {
  		throw new ExceptionValidation(null,"El valor"+descomponerIdentif+" no corresponde a un número de comprobante válido");
  	}
  	
  }
  
  
  public List getComprobantes() {
  	return this.comprobantes;
  }
  
  public void setComprobantes(List aComprobantes) throws BaseException {
  	this.comprobantes = aComprobantes;
  }
  
  private List getComprobantes(String tcDefault,String letraDefault,Integer lugEmiDefault) throws BaseException {
  	comprobantes = new ArrayList();
  	String[] listaCompro = identificador.split(",");
  	for (int i=0; i<=listaCompro.length-1;++i) {
  		String identificador = listaCompro[i];
  		String[] descomponerIdentif = identificador.split("-");
      if (descomponerIdentif.length==1) {
      	descomponerNroExt(tcDefault,letraDefault,lugEmiDefault,descomponerIdentif[0]);
        comprobantes.add(new IdentificadorCompro(this.getTC(),this.getLetra(),this.getLugEmi(),this.getNroExt()));
      }
      else
      if (descomponerIdentif.length==2) {
      	descomponerTCyNroExt(letraDefault,lugEmiDefault,descomponerIdentif);
        comprobantes.add(new IdentificadorCompro(this.getTC(),this.getLetra(),this.getLugEmi(),this.getNroExt()));
      }
      else
        if (descomponerIdentif.length==4) {
          descomponerTCLetraLugEmiNroExt(descomponerIdentif);
          comprobantes.add(new IdentificadorCompro(this.getTC(),this.getLetra(),this.getLugEmi(),this.getNroExt()));
        }
      else
        throw new ExceptionValidation(null,"Formato de Comprobante desconocido:"+descomponerIdentif);
  	}
  	return comprobantes;
  }
  
  

}
