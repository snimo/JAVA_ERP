package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBAccCronoDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AccCronoDesa extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccCronoDesa() {
	}

	private List estados = new ArrayList();
	private boolean readEstados = true;

	private List mesesAEvaluar = new ArrayList();
	private boolean readMesesAEvaluar = true;
	
	private List jerarquiasDesa = new ArrayList();
	private boolean readJerarquiasDesa = true;
	

	public static String NICKNAME = "rh.AccCronoDesa";

	private CronogramaDesa cronograma;
	private Integer orden;
	private String accion;
	private String revision;
	private String Observaciones;
	private Boolean activo;
	private ValorClasificadorEntidad categoriaPosible;
	private RankearCab rankear;
	private String sector;
	private String parametros;

	public CronogramaDesa getCronograma() throws BaseException {
		supportRefresh();
		return cronograma;
	}
	
	public String getSector() throws BaseException {
		supportRefresh();
		return sector;
	}
	
	public void setSector(String aSector) throws BaseException {
		this.sector = aSector;
	}
	
	public String getParametros() throws BaseException {
		supportRefresh();
		return parametros;
	}
	
	public void setParametros(String aParametros) throws BaseException {
		this.parametros = aParametros;
	}
	
	
	
	public RankearCab getRankear() throws BaseException {
		supportRefresh();
		return this.rankear;
	}
	
	
	public ValorClasificadorEntidad getCategoriaPosible() throws BaseException {
		supportRefresh();
		return this.categoriaPosible;
	}
	

	public void setCronograma(CronogramaDesa aCronograma) {
		this.cronograma = aCronograma;
	}
	
	public void setRankear(RankearCab aRankearCab) {
		this.rankear = aRankearCab;
	}
	
	
	public void setCategoriaPosible(ValorClasificadorEntidad aCategoriaPosible) {
		this.categoriaPosible = aCategoriaPosible;
	}
	

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getAccion() throws BaseException {
		supportRefresh();
		return accion;
	}

	public void setAccion(String aAccion) {
		this.accion = aAccion;
	}

	public String getRevision() throws BaseException {
		supportRefresh();
		return revision;
	}

	public void setRevision(String aRevision) {
		this.revision = aRevision;
	}

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return Observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.Observaciones = aObservaciones;
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

	public static AccCronoDesa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AccCronoDesa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AccCronoDesa findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AccCronoDesa) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AccCronoDesa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AccCronoDesa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cronograma, "Debe ingresar el Cronograma");
		Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
		Validar.noNulo(accion, "Debe ingresar la Acción");
	}

	public static List getAccionesCrono(CronogramaDesa cronograma, ISesion aSesion) throws BaseException {
		return DBAccCronoDesa.getAccionesCrono(cronograma, aSesion);
	}

	public List getEstados() throws BaseException {
		if (this.readEstados) {
			List listaEstados = EstadoAccCroDesa.getEstados(this, getSesion());
			estados.addAll(listaEstados);
			this.readEstados = false;
		}
		return estados;
	}

	public List getMesesAEvaluar() throws BaseException {
		if (this.readMesesAEvaluar) {
			List listaMesesAEvaluar = MesCronoDesa.getMesesCronoDesa(this, getSesion());
			mesesAEvaluar.addAll(listaMesesAEvaluar);
			this.readMesesAEvaluar = false;
		}
		return mesesAEvaluar;
	}
	
	public List getJerarquiasDesa() throws BaseException {
		if (this.readJerarquiasDesa) {
			List listaJerarquiasDesa = JerarquiaDesa.getJerarquiasDesa(this, getSesion());
			jerarquiasDesa.addAll(listaJerarquiasDesa);
			this.readJerarquiasDesa = false;
		}
		return jerarquiasDesa;
	}
	

	public void afterSave() throws BaseException {

		Iterator iterEstados = estados.iterator();
		while (iterEstados.hasNext()) {
			EstadoAccCroDesa estadoAccCroDesa = (EstadoAccCroDesa) iterEstados.next();
			estadoAccCroDesa.save();
			estadoAccCroDesa = null;
		}
		iterEstados = null;

		Iterator iterMesesAEval = mesesAEvaluar.iterator();
		while (iterMesesAEval.hasNext()) {
			MesCronoDesa mesCronoDesa = (MesCronoDesa) iterMesesAEval.next();
			mesCronoDesa.save();
			mesCronoDesa = null;
		}
		iterMesesAEval = null;
		
		Iterator iterJerarquiasDesa = jerarquiasDesa.iterator();
		while (iterJerarquiasDesa.hasNext()) {
			JerarquiaDesa jerarquiaDesa = (JerarquiaDesa) iterJerarquiasDesa.next();
			jerarquiaDesa.save();
			jerarquiaDesa = null;
		}
		iterJerarquiasDesa = null;
		

	}

	public void addEstado(EstadoAccCroDesa aEstadoAccCroDesa) throws BaseException {
		aEstadoAccCroDesa.setAccion(this);
		estados.add(aEstadoAccCroDesa);
	}

	public void addMesAEvaluar(MesCronoDesa aMesCronoDesa) throws BaseException {
		aMesCronoDesa.setAccion(this);
		mesesAEvaluar.add(aMesCronoDesa);
	}
	
	public void addJerarquiaDesa(JerarquiaDesa aJerarquiaDesa) throws BaseException {
		aJerarquiaDesa.setAccion(this);
		jerarquiasDesa.add(aJerarquiaDesa);
	}
	

}
