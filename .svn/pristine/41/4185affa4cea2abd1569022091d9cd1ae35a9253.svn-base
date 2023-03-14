package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBCriterioSelCuenta;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CriterioSelCuenta extends ObjetoLogico {

	public static final String TIPO_CRI_ATRIBUTOS = "POR_ATRIBUTOS";

	public static final String TIPO_CRI_NINGUNO = "NINGUNO";

	private List atributosEntSel = new ArrayList();
	private boolean readAtributosEntSel = true;
	
    private List valoresAtriCriteriosImpu = new ArrayList();
	private boolean readValoresAtriCriteriosImpu = true;
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CriterioSelCuenta() {
	}

	public static String NICKNAME = "cg.CriterioSelCuenta";

	private ConceptoCtaContable concepto_cuenta;

	private Integer orden;

	private String criterio;

	private Boolean activo;

	public ConceptoCtaContable getConcepto_cuenta() throws BaseException {
		supportRefresh();
		return concepto_cuenta;
	}

	public void setConcepto_cuenta(ConceptoCtaContable aConcepto_cuenta) {
		this.concepto_cuenta = aConcepto_cuenta;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getCriterio() throws BaseException {
		supportRefresh();
		return criterio;
	}

	public void setCriterio(String aCriterio) {
		this.criterio = aCriterio;
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

	public static CriterioSelCuenta findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CriterioSelCuenta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CriterioSelCuenta findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CriterioSelCuenta) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CriterioSelCuenta findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CriterioSelCuenta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(concepto_cuenta, "Debe ingresar el Concepto");
		Validar.noNulo(orden, "Debe ingresar el Orden");
		Validar.noNulo(criterio, "Debe ingresar el Criterio");
	}

	public static List getCriteriosByConcCta(
			ConceptoCtaContable conceptoCtaContable, ISesion aSesion)
			throws BaseException {
		return DBCriterioSelCuenta.getCriteriosByConcCta(conceptoCtaContable,
				aSesion);
	}

	public static Hashtable getTiposCriterios() throws BaseException {
		Hashtable listaCriterios = new Hashtable();
		listaCriterios.put(TIPO_CRI_ATRIBUTOS, "Por atributos");
		listaCriterios.put(TIPO_CRI_NINGUNO, "Ninguno");
		return listaCriterios;
	}

	public List getAtributosEntSel() throws BaseException {
		if (readAtributosEntSel) {
			List listaAriEntSel = AtributoEntidadSeleccionado
					.getAtributosSeleccionados(this, getSesion());
			atributosEntSel.addAll(listaAriEntSel);
			readAtributosEntSel = false;
		}
		return atributosEntSel;
	}
	
	public List getValoresAtriCriterioImpu() throws BaseException {
		if (readValoresAtriCriteriosImpu) {
			List listaValAriCriImpu = ValoresAtriCriterioImpu.getValoresAtriCriterioImpu(this, getSesion());
			valoresAtriCriteriosImpu.addAll(listaValAriCriImpu);
			readValoresAtriCriteriosImpu = false;
		}
		return valoresAtriCriteriosImpu;
	}	

	public void addAtributoEntSel(AtributoEntidadSeleccionado atriEntSel)
			throws BaseException {
		atriEntSel.setCriterio_seleccion_cta(this);
		atributosEntSel.add(atriEntSel);
	}
	
	public void addValAtriCriImpu(ValoresAtriCriterioImpu valoresAtriCriImpu) throws BaseException {
		valoresAtriCriImpu.setCriterio_sel_cta(this);
		valoresAtriCriteriosImpu.add(valoresAtriCriImpu);
	}

	public void afterSave() throws BaseException {
		
		Iterator iterAtriEntSel = atributosEntSel.iterator();
		while (iterAtriEntSel.hasNext()) {
			AtributoEntidadSeleccionado atriEntSel = (AtributoEntidadSeleccionado) iterAtriEntSel
					.next();
			atriEntSel.save();
			atriEntSel = null;
		}
		iterAtriEntSel = null;
		
		Iterator iterValoresAtriCriterioImpu = valoresAtriCriteriosImpu.iterator();
		while (iterValoresAtriCriterioImpu.hasNext()) {
			ValoresAtriCriterioImpu valAtriCriImpu = (ValoresAtriCriterioImpu) iterValoresAtriCriterioImpu.next();
			valAtriCriImpu.save();
			valAtriCriImpu = null;
		}
		iterValoresAtriCriterioImpu = null;
		
	}
	
	public CuentaImputable getCuentaImputable(IObjetoLogico objetoLogico) throws BaseException {
		if (getCriterio().equals(TIPO_CRI_ATRIBUTOS))
			return getCuentaImputableSegunAtri(objetoLogico);
		else if (getCriterio().equals(TIPO_CRI_NINGUNO)) {
			return getCuentaImputableSegunAtri(objetoLogico);
		}
		return null;
	}
	
	private CuentaImputable getCuentaImputableSegunAtri(IObjetoLogico objetoLogico) throws BaseException {
		
		ValoresAtriCriterioImpu valoresAtriCriImpu = getValorAtriCriImpu(objetoLogico);
		if (!valoresAtriCriImpu.isGenerarCuenta())
			return valoresAtriCriImpu.getCuenta_imputable();
		else {
			// Generer la cuenta en Base a los atributos configurados
			HashTableDatos valoresDeComponentes = new HashTableDatos();
			Cuenta cuenta = valoresAtriCriImpu.getCuenta_contable();
			if (cuenta==null)
				throw new ExceptionValidation(null,"Debe ingresar la cuenta contable para el criterio de Imputación");
			Iterator iterValoresCompo = valoresAtriCriImpu.getGenerarValoresCompo().iterator();
			while (iterValoresCompo.hasNext()) {
				GenerarValorCompoCriImpu generarValorCompo = (GenerarValorCompoCriImpu) iterValoresCompo.next();
				Componente componente    = generarValorCompo.getComponente();
				IObjetoLogico valorCompo = objetoLogico.getAtributoObjLog(generarValorCompo.getAtributo_entidad().getSignature());
				if (valorCompo == null)
					throw new ExceptionValidation(null,
							"Falta cargar el valor de "+
							componente.getDescripcion()+" para: "+
							objetoLogico.getDescripcion());
				valoresDeComponentes.put(componente,valorCompo);
			}
			return CuentaImputable.getImputableConEstructuraValCompo(cuenta,valoresDeComponentes,getSesion());
		}
	}
	
	public ValoresAtriCriterioImpu getValorAtriCriImpu(
			IObjetoLogico objetoLogico) throws BaseException {
		return ValoresAtriCriterioImpu.getValorAtriCriImpu(this,
				objetoLogico, getSesion());
	}
	

}
