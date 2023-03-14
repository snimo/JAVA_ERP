package com.srn.erp.impuestos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.impuestos.da.DBSujetoImpositivo;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.bm.PorcLibRetGan;
import com.srn.erp.pagos.bm.PorcLibRetIB;
import com.srn.erp.pagos.bm.PorcLibRetIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class SujetoImpositivo extends ObjetoLogico {

  public SujetoImpositivo() {
  }

  public static String NICKNAME = "im.SujetoImpositivo";

  private String razon;
  private String cuit;
  private Boolean exentoRetIVA;
  private Boolean exentoRetGan;
  private Boolean exentoRetIB;
  private String ingBrutos;
  private String dnrp;
  private CategoriaIVA categIVA;
  private CategoriaIB categIB;
  private CategoriaGanancia categGan;
  private Boolean activo;
  private CatRetIVA catRetIVA;
  private CatRetGan catRetGan;
  private CatRetIB catRetIB;

  private List porcentajesLibRetIVA = new ArrayList();
  private boolean readPorcentajesLibRetIVA = true;

  private List porcentajesLibRetGan = new ArrayList();
  private boolean readPorcentajesLibRetGan = true;

  private List porcentajesLibRetIB = new ArrayList();
  private boolean readPorcentajesLibRetIB = true;

  public CatRetIVA getCatRetIVA() throws BaseException {
    supportRefresh();
    return catRetIVA;
  }

  public void setCatRetIVA(CatRetIVA aCatRetIVA) throws BaseException {
    this.catRetIVA = aCatRetIVA;
  }


  public CatRetIB getCatRetIB() throws BaseException {
    supportRefresh();
    return catRetIB;
  }

  public void setCatRetIB(CatRetIB aCatRetIB) throws BaseException {
    this.catRetIB = aCatRetIB;
  }

  public CatRetGan getCatRetGan() throws BaseException {
    supportRefresh();
    return catRetGan;
  }

  public void setCatRetGan(CatRetGan aCatRetGan) throws BaseException {
    this.catRetGan = aCatRetGan;
  }

  public String getRazon() throws BaseException {
    supportRefresh();
    return razon;
  }

  public void setRazon(String aRazon) {
    this.razon =  aRazon;
  }

  public String getCuit() throws BaseException {
    supportRefresh();
    return cuit;
  }
  
  
  public String getCUITFormateado() throws BaseException {
	  if (this.getCuit()==null) return "";
	  if (this.getCuit().trim().length()!=11) return this.getCuit().trim();
	  return this.getCuit().trim().substring(0,2)+"-"+
	  this.getCuit().trim().substring(2,10)+"-"+this.getCuit().trim().substring(10,11);
  }

  public void setCuit(String aCuit) {
  	this.cuit =  aCuit;
  }

  public Boolean isExentoretiva() throws BaseException {
    supportRefresh();
    return exentoRetIVA;
  }

  public void setExentoretiva(Boolean aExentoretiva) {
    this.exentoRetIVA =  aExentoretiva;
  }

  public Boolean isExentoretgan() throws BaseException {
    supportRefresh();
    return exentoRetGan;
  }

  public void setExentoretgan(Boolean aExentoretgan) {
    this.exentoRetGan =  aExentoretgan;
  }

  public Boolean isExentoretib() throws BaseException {
    supportRefresh();
    return exentoRetIB;
  }

  public void setExentoretib(Boolean aExentoretib) {
    this.exentoRetIB =  aExentoretib;
  }

  public String getIngbrutos() throws BaseException {
    supportRefresh();
    return ingBrutos;
  }

  public void setIngbrutos(String aIngbrutos) {
    this.ingBrutos =  aIngbrutos;
  }

  public String getDnrp() throws BaseException {
    supportRefresh();
    return dnrp;
  }

  public void setDnrp(String aDnrp) {
    this.dnrp =  aDnrp;
  }

  public CategoriaIVA getCategiva() throws BaseException {
    supportRefresh();
    return categIVA;
  }

  public void setCategiva(CategoriaIVA aCategiva) {
    this.categIVA =  aCategiva;
  }

  public CategoriaIB getCategib() throws BaseException {
    supportRefresh();
    return categIB;
  }

  public void setCategib(CategoriaIB aCategib) {
    this.categIB =  aCategib;
  }

  public CategoriaGanancia getCateggan() throws BaseException {
    supportRefresh();
    return categGan;
  }

  public void setCateggan(CategoriaGanancia aCateggan) {
    this.categGan =  aCateggan;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static SujetoImpositivo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (SujetoImpositivo) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static SujetoImpositivo findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (SujetoImpositivo) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static SujetoImpositivo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (SujetoImpositivo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
	 
   Validar.noNulo(razon, "Debe ingresar la Razón Social");
   Validar.noNulo(this.categIVA, "Debe ingresar la Categoría de IVA");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El sujero impositivo debe ingresarse en modo activo");
   
   if (this.cuit!=null) 
  	 if (this.cuit.trim().length()!=0)
  		 SujetoImpositivo.validarCUIT(this.cuit);
   
   
   if ((this.getCategiva()!=null) && (this.getCategiva().isRequiereCUIT())) 
  	 if ((this.cuit == null) || (this.cuit.equals("")))
  		 throw new ExceptionValidation(null,"Debe ingresar el CUIT");
   

 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() throws BaseException {
    return getCuit();
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() throws BaseException {
    return getRazon();
  }

  public static SujetoImpositivo getNew(ISesion aSesion) throws BaseException {
    return (SujetoImpositivo)SujetoImpositivo.getNew(SujetoImpositivo.NICKNAME,aSesion);
  }

  public List getPorcentajesLibRetIVA() throws BaseException {
    if (readPorcentajesLibRetIVA) {
      List lista = PorcLibRetIVA.getPorcentajesLibRetIVA(this,getSesion());
      porcentajesLibRetIVA.addAll(lista);
      readPorcentajesLibRetIVA = false;
    }
    return porcentajesLibRetIVA;
  }

  public void addPorcentajeLibRetIVA(PorcLibRetIVA porcLibRetIVA) throws BaseException {
    porcLibRetIVA.setSujetoimpositivo(this);
    porcentajesLibRetIVA.add(porcLibRetIVA);
  }

  public List getPorcentajesLibRetGan() throws BaseException {
    if (readPorcentajesLibRetGan) {
      List lista = PorcLibRetGan.getPorcentajesLibRetGan(this,getSesion());
      porcentajesLibRetGan.addAll(lista);
      readPorcentajesLibRetGan = false;
    }
    return porcentajesLibRetGan;
  }

  public void addPorcentajeLibRetGan(PorcLibRetGan porcLibRetGan) throws BaseException {
    porcLibRetGan.setSujetoimpositivo(this);
    porcentajesLibRetGan.add(porcLibRetGan);
  }

  public List getPorcentajesLibRetIB() throws BaseException {
    if (readPorcentajesLibRetIB) {
      List lista = PorcLibRetIB.getPorcentajesLibRetIB(this,getSesion());
      porcentajesLibRetIB.addAll(lista);
      readPorcentajesLibRetIB = false;
    }
    return porcentajesLibRetIB;
  }

  public void addPorcentajeLibRetIB(PorcLibRetIB porcLibRetIB) throws BaseException {
    porcLibRetIB.setSujetoimpositivo(this);
    porcentajesLibRetIB.add(porcLibRetIB);
  }

  public void afterSave() throws BaseException {

    Iterator iterPorcLibRetIVA = porcentajesLibRetIVA.iterator();
    while (iterPorcLibRetIVA.hasNext()) {
      PorcLibRetIVA porcLibRetIVA = (PorcLibRetIVA) iterPorcLibRetIVA.next();
      porcLibRetIVA.save();
      porcLibRetIVA = null;
    }
    iterPorcLibRetIVA = null;

    Iterator iterPorcLibRetGan = porcentajesLibRetGan.iterator();
    while (iterPorcLibRetGan.hasNext()) {
      PorcLibRetGan porcLibRetGan = (PorcLibRetGan) iterPorcLibRetGan.next();
      porcLibRetGan.save();
      porcLibRetGan = null;
    }
    iterPorcLibRetGan = null;

    Iterator iterPorcLibRetIB = porcentajesLibRetIB.iterator();
    while (iterPorcLibRetIB.hasNext()) {
      PorcLibRetIB porcLibRetIB = (PorcLibRetIB) iterPorcLibRetIB.next();
      porcLibRetIB.save();
      porcLibRetIB = null;
    }
    iterPorcLibRetIB = null;

  }

  public PorcLibRetGan getPorcLibRetGan(java.util.Date aFechaPago) throws BaseException {
    return PorcLibRetGan.getPorcentajesLibRetGan(this,aFechaPago,getSesion());
  }
  
	private static int getNroEntero(String aCuit, int aPos) throws BaseException{
		Integer nro = null;
		try{
			nro = new Integer("" + aCuit.charAt(aPos));
		}
		catch(Exception e){
			throw new ExceptionValidation("El numero '" + aCuit.charAt(aPos) + "' no es un número válido.");
		}
		
		return nro.intValue();
	}
  
  
  public static void validarCUIT(String aCuit) throws BaseException {
  	
		if(aCuit == null || (aCuit.trim().length() != 11))
			throw new ExceptionValidation("El cuit debe tener 11 dígitos");
				
		int nroVerificador = new Integer("" + aCuit.charAt(10)).intValue();
		
		int valor = 0;
		valor += (getNroEntero(aCuit, 0) * 5);
		valor += (getNroEntero(aCuit, 1) * 4);
		
		valor += (getNroEntero(aCuit, 2)  * 3);
		valor += (getNroEntero(aCuit, 3)  * 2);
		valor += (getNroEntero(aCuit, 4)  * 7);
		valor += (getNroEntero(aCuit, 5)  * 6);
		valor += (getNroEntero(aCuit, 6)  * 5);
		valor += (getNroEntero(aCuit, 7)  * 4);
		valor += (getNroEntero(aCuit, 8)  * 3);
		valor += (getNroEntero(aCuit, 9)* 2);
		
		int resto  = valor % 11;
		int digito = 0;
		
		switch (resto) {
		case 0:
			digito = 0;
			break;
		case 1:
			digito = 1;
			break;
		default:
			digito = 11 - resto;
		break;
		}
		
		if(digito != nroVerificador)
			throw new ExceptionValidation("C.U.I.T invalido: " + aCuit.trim() + ". Digito verificador propuesto: " + digito);  	
  	
  }
  
  public static List getAllSujetosImpositivos(java.util.Date fechaPublicado,
  		                                        ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(SujetoImpositivo.NICKNAME,
         DBSujetoImpositivo.SELECT_BY_PEND_REG_IB_BSAS,
         fechaPublicado,
         new ListObserver(),
         aSesion);
  }
  
  public static List getAllSujetos(ISesion aSesion) throws BaseException {
	  return DBSujetoImpositivo.getAllSujetos(aSesion);
  }
  
  


}
