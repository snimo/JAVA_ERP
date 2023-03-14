package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBVistaCashFlow;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class VistaCashFlow extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		return descripcion;
	}
	
	

	public VistaCashFlow() {
	}

	public static String NICKNAME = "cf.VistaCashFlow";

	private ProgFechasCF prog_cf;
	private ConceptoCashFlow concepto_cf;
	private java.util.Date fecha;
	private java.util.Date fecha_original;
	private Double importe;
	private Moneda moneda;
	private GrupoConceptoCF grupo_concepto;
	private EscenarioCashFlow escenario_cf;
	private Boolean activo;
	private String descripcion;

	public ProgFechasCF getProg_cf() throws BaseException {
		supportRefresh();
		return prog_cf;
	}

	public void setProg_cf(ProgFechasCF aProg_cf) {
		this.prog_cf = aProg_cf;
	}
	

	public ConceptoCashFlow getConcepto_cf() throws BaseException {
		supportRefresh();
		return concepto_cf;
	}

	public void setConcepto_cf(ConceptoCashFlow aConcepto_cf) {
		this.concepto_cf = aConcepto_cf;
	}
	
	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}
	

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public java.util.Date getFecha_original() throws BaseException {
		supportRefresh();
		return fecha_original;
	}

	public void setFecha_original(java.util.Date aFecha_original) {
		this.fecha_original = aFecha_original;
	}

	public Double getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Double aImporte) {
		this.importe = aImporte;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public GrupoConceptoCF getGrupo_concepto() throws BaseException {
		supportRefresh();
		return grupo_concepto;
	}

	public void setGrupo_concepto(GrupoConceptoCF aGrupo_concepto) {
		this.grupo_concepto = aGrupo_concepto;
	}

	public EscenarioCashFlow getEscenario_cf() throws BaseException {
		supportRefresh();
		return escenario_cf;
	}

	public void setEscenario_cf(EscenarioCashFlow aEscenario_cf) {
		this.escenario_cf = aEscenario_cf;
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

	public static VistaCashFlow findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (VistaCashFlow) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static VistaCashFlow findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (VistaCashFlow) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(fecha_original, "Debe ingresar la Fecha Origen");
		Validar.noNulo(importe, "Debe ingresar el Importe");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(grupo_concepto, "Debe ingresar el Grupo Concepto");
		Validar.noNulo(escenario_cf, "Debe ingresar el Escenario");
	}

	public static List getConceptosPlanificados(EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		return DBVistaCashFlow.getConceptosPlanificados(escenario, aSesion);
	}

}
