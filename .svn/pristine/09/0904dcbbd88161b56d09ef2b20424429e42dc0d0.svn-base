package com.srn.erp.impuestos.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class CategoriaIVA extends ObjetoLogico {

	public boolean isMonotributo() throws BaseException {
		if (this.getComportamiento().equals(COMPO_CODIGO_MONO))
			return true;
		else
			return false;
	}
	
	public boolean isConsumidorFinal() throws BaseException {
		if (this.getComportamiento().equals(COMPO_CODIGO_CF))
			return true;
		else
			return false;
	}
	
	public boolean isExcento() throws BaseException {
		if (this.getComportamiento().equals(COMPO_CODIGO_EX))
			return true;
		else
			return false;
	}
	
	public boolean isResponsableNoInscripto() throws BaseException {
		if (this.getComportamiento().equals(COMPO_CODIGO_RNI))
			return true;
		else
			return false;
	}
	
	public boolean isResponsableInscripto() throws BaseException {
		if (this.getComportamiento().equals(COMPO_CODIGO_RI))
			return true;
		else
			return false;
	}
	
	public boolean isRequiereCUIT() throws BaseException {
		if (isMonotributo() || 
				isExcento() || 
				isResponsableNoInscripto() || 
				isResponsableInscripto())
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
	
	public static final String	COMPO_CODIGO_MONO				= "MONO";

	public static final String	COMPO_DESC_MONO					= "Monotributo";

	public static final String	COMPO_CODIGO_CF					= "CF";

	public static final String	COMPO_DESC_CF						= "Consumidor Final";

	public static final String	COMPO_CODIGO_EX					= "EX";

	public static final String	COMPO_DESC_EX						= "Excento";

	public static final String	COMPO_CODIGO_RNI				= "RNI";

	public static final String	COMPO_DESC_RNI					= "Responsable No Inscripto";

	public static final String	COMPO_CODIGO_RI					= "RI";

	public static final String	COMPO_DESC_RI						= "Responsable Inscripto";

	private List								talonariosCategIVA			= new ArrayList();

	private boolean							readTalonariosCategIVA	= true;

	public CategoriaIVA() {
	}

	public static String			NICKNAME	= "im.CategoriaIVA";

	private String						codigo;

	private String						descripcion;

	private String						comportamiento;

	private Boolean						activo;

	private Boolean						isCalculaIVA;

	private Boolean						isDiscriminaIVA;

	private Boolean						calcPercIVA;

	private ConceptoImpuesto	concImpuIVA;
	
  private boolean esAgentePercIBBsAs;

  private boolean esAgentePercIBCapFed;
	

  public boolean isAgentePercIBBsAs() throws BaseException {
    supportRefresh();
    return this.esAgentePercIBBsAs;
  }
  
  public void setAgentePercIBBsAs(boolean aAgentePercIB) throws BaseException {
  	this.esAgentePercIBBsAs = aAgentePercIB;
  }
  
  public boolean isAgentePercIBCapFed() throws BaseException {
    supportRefresh();
    return this.esAgentePercIBCapFed;
  }
  
  public void setAgentePercIBCapFed(boolean aAgentePercIBCapFed) throws BaseException {
  	this.esAgentePercIBCapFed = aAgentePercIBCapFed;
  }
  
  
	public Boolean isCalcPercIVA() throws BaseException {
		supportRefresh();
		return this.calcPercIVA;
	}

	public void setCalculaPercIVA(Boolean aCalcPercIVA) throws BaseException {
		this.calcPercIVA = aCalcPercIVA;
	}

	public ConceptoImpuesto getConcImpuestoIVA() throws BaseException {
		supportRefresh();
		return this.concImpuIVA;
	}

	public void setConcImpuestoIVA(ConceptoImpuesto aConcImpuIVA) throws BaseException {
		this.concImpuIVA = aConcImpuIVA;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public void setCalculaIVA(Boolean aCalculaIVA) throws BaseException {
		this.isCalculaIVA = aCalculaIVA;
	}

	public void setDiscriminaIVA(Boolean aDiscriminaIVA) throws BaseException {
		this.isDiscriminaIVA = aDiscriminaIVA;
	}

	public Boolean isCalculaIVA() throws BaseException {
		supportRefresh();
		return isCalculaIVA;
	}

	public Boolean isDiscriminaIVA() throws BaseException {
		supportRefresh();
		return isDiscriminaIVA;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CategoriaIVA findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CategoriaIVA) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategoriaIVA findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CategoriaIVA) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CategoriaIVA findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CategoriaIVA) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
		Validar.noNulo(this.calcPercIVA, "Debe ingresar si se calcula o no la percepción de IVA");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("La Categoría de IVA debe ingresarse en modo activo");

	}

	public static Hashtable getListaComportamientos() throws BaseException {
		Hashtable lista = new Hashtable();
		lista.put(COMPO_CODIGO_MONO, COMPO_DESC_MONO);
		lista.put(COMPO_CODIGO_CF, COMPO_DESC_CF);
		lista.put(COMPO_CODIGO_EX, COMPO_DESC_EX);
		lista.put(COMPO_CODIGO_RNI, COMPO_DESC_RNI);
		lista.put(COMPO_CODIGO_RI, COMPO_DESC_RI);
		return lista;
	}

	public List getTalonariosCatIVA() throws BaseException {
		return TalonarioCategoriaIVA.getTalonariosCatIVA(this, getSesion());
	}

	public List getTalHabCatIVA() throws BaseException {
		if (readTalonariosCategIVA) {
			List listaTalHabCatIVA = TalonarioCategoriaIVA.getTalonariosCatIVA(this, getSesion());
			talonariosCategIVA.addAll(listaTalHabCatIVA);
			readTalonariosCategIVA = false;
		}
		return talonariosCategIVA;
	}

	public void addTalonarioCategoriaIVA(TalonarioCategoriaIVA talonarioCategIVA) throws BaseException {
		talonarioCategIVA.setCategoria_iva(this);
		talonariosCategIVA.add(talonarioCategIVA);
	}

	public void afterSave() throws BaseException {
		Iterator iterTalCatIVA = talonariosCategIVA.iterator();
		while (iterTalCatIVA.hasNext()) {
			TalonarioCategoriaIVA talonarioCatIVA = (TalonarioCategoriaIVA) iterTalCatIVA.next();
			talonarioCatIVA.save();
			talonarioCatIVA = null;
		}
		iterTalCatIVA = null;
	}

	private boolean perteneceTalonarioACategoria(Talonario talonario) throws BaseException {
		boolean pertenece = false;
		List talHabCatIVA = getTalHabCatIVA();
		Iterator iterTalHabCatIVA = talHabCatIVA.iterator();
		while (iterTalHabCatIVA.hasNext()) {
			TalonarioCategoriaIVA talCatIVA = (TalonarioCategoriaIVA) iterTalHabCatIVA.next();
			if (talCatIVA.getTalonario().getOID() == talonario.getOID()) {
				pertenece = true;
				break;
			}
		}
		return pertenece;
	}

	public List getTalonariosFactSegunUniOrg() throws BaseException {
		List listaTalHabUniOrgCateg = new ArrayList();
		List listaTalonarios = Talonario.getTalonariosFacturaHab(getSesion());
		Iterator iterTalonario = listaTalonarios.iterator();
		while (iterTalonario.hasNext()) {
			Talonario talonario = (Talonario) iterTalonario.next();
			if (perteneceTalonarioACategoria(talonario))
				listaTalHabUniOrgCateg.add(talonario);
		}
		return listaTalHabUniOrgCateg;
	}

	public List getTalonariosNDSegunUniOrg() throws BaseException {
		List listaTalHabUniOrgCateg = new ArrayList();
		List listaTalonarios = Talonario.getTalonariosNDHab(getSesion());
		Iterator iterTalonario = listaTalonarios.iterator();
		while (iterTalonario.hasNext()) {
			Talonario talonario = (Talonario) iterTalonario.next();
			if (perteneceTalonarioACategoria(talonario))
				listaTalHabUniOrgCateg.add(talonario);
		}
		return listaTalHabUniOrgCateg;
	}

	public List getTalonariosNCSegunUniOrg() throws BaseException {
		List listaTalHabUniOrgCateg = new ArrayList();
		List listaTalonarios = Talonario.getTalonariosNCHab(getSesion());
		Iterator iterTalonario = listaTalonarios.iterator();
		while (iterTalonario.hasNext()) {
			Talonario talonario = (Talonario) iterTalonario.next();
			if (perteneceTalonarioACategoria(talonario))
				listaTalHabUniOrgCateg.add(talonario);
		}
		return listaTalHabUniOrgCateg;
	}
	
	public List getTalonariosNDISegunUniOrg() throws BaseException {
		List listaTalHabUniOrgCateg = new ArrayList();
		List listaTalonarios = Talonario.getTalonariosNDIHab(getSesion());
		Iterator iterTalonario = listaTalonarios.iterator();
		while (iterTalonario.hasNext()) {
			Talonario talonario = (Talonario) iterTalonario.next();
			if (perteneceTalonarioACategoria(talonario))
				listaTalHabUniOrgCateg.add(talonario);
		}
		return listaTalHabUniOrgCateg;
	}
	
	public List getTalonariosNCISegunUniOrg() throws BaseException {
		List listaTalHabUniOrgCateg = new ArrayList();
		List listaTalonarios = Talonario.getTalonariosNCIHab(getSesion());
		Iterator iterTalonario = listaTalonarios.iterator();
		while (iterTalonario.hasNext()) {
			Talonario talonario = (Talonario) iterTalonario.next();
			if (perteneceTalonarioACategoria(talonario))
				listaTalHabUniOrgCateg.add(talonario);
		}
		return listaTalHabUniOrgCateg;
	}	
	
	
	public String getCategIVAImpFiscal() throws BaseException {
		
		if (this.getComportamiento().equals(COMPO_CODIGO_MONO))
			return "MONOTRIBUTO";
		else
		if (this.getComportamiento().equals(COMPO_CODIGO_CF))
			return "CONSUMIDOR_FINAL";
		else
		if (this.getComportamiento().equals(COMPO_CODIGO_EX))
			return "EXENTO";
		else
		if (this.getComportamiento().equals(COMPO_CODIGO_RNI))
			return "RESPONSABLE_NO_INSCRIPTO";
		else
		if (this.getComportamiento().equals(COMPO_CODIGO_RI))
			return "RESPONSABLE_INSCRIPTO";
		else
			throw new ExceptionValidation(null,"No se pudo encontrar Categ. de IVA para la impresora fiscal");
		
	}
	
	 public static CategoriaIVA getCategIVAConsFinal(ISesion aSesion) throws BaseException {
	   Integer oidCategIVAConsFinal =
	       ValorParametro.findByCodigoParametro("CATEG_IVA_CF",aSesion).getOidObjNeg();
	   CategoriaIVA categIVA = CategoriaIVA.findByOid(oidCategIVAConsFinal,aSesion);
	   return categIVA;
	 }
	
	

}
