package com.srn.erp.produccion.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.produccion.da.DBOperAlterFab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class OperAlterFab extends ObjetoLogico {

	public static final String OPER_ALT_FAB_OPER = "OPER";
	public static final String OPER_ALT_FAB_TITU = "TITU";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private List necesidadMateriales = new ArrayList();
	private boolean readNecesidadMateriales = true;

	public OperAlterFab() {
	}

	public static String NICKNAME = "pr.OperAlterFab";

	private AlternativaFabricacion alternativa_fabricacion;
	private ProcesoProductivo proceso;
	private OperacionProductiva operacion;
	private TipoEstacionTrabajo tipo_estacion;
	private Double tiempo_std;
	private String comportamiento;
	private String oid_rel;
	private String oid_rel_padre;
	private Boolean activo;
	private String observacion;
	private UMTiempoProduccion umTiempoProduccion;

	public AlternativaFabricacion getAlternativa_fabricacion() throws BaseException {
		supportRefresh();
		return alternativa_fabricacion;
	}

	public void setAlternativa_fabricacion(AlternativaFabricacion aAlternativa_fabricacion) {
		this.alternativa_fabricacion = aAlternativa_fabricacion;
	}

	public UMTiempoProduccion getUMTiempoProduccion() throws BaseException {
		supportRefresh();
		return this.umTiempoProduccion;
	}

	public void setUMTiempoProduccion(UMTiempoProduccion aUMTiempoProduccion) {
		this.umTiempoProduccion = aUMTiempoProduccion;
	}

	public ProcesoProductivo getProceso() throws BaseException {
		supportRefresh();
		return proceso;
	}

	public void setProceso(ProcesoProductivo aProceso) {
		this.proceso = aProceso;
	}

	public OperacionProductiva getOperacion() throws BaseException {
		supportRefresh();
		return operacion;
	}

	public void setOperacion(OperacionProductiva aOperacion) {
		this.operacion = aOperacion;
	}

	public TipoEstacionTrabajo getTipo_estacion() throws BaseException {
		supportRefresh();
		return tipo_estacion;
	}

	public void setTipo_estacion(TipoEstacionTrabajo aTipo_estacion) {
		this.tipo_estacion = aTipo_estacion;
	}

	public Double getTiempo_std() throws BaseException {
		supportRefresh();
		return tiempo_std;
	}

	public void setTiempo_std(Double aTiempo_std) {
		this.tiempo_std = aTiempo_std;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public String getOid_rel() throws BaseException {
		supportRefresh();
		return oid_rel;
	}

	public void setOid_rel(String aOid_rel) {
		this.oid_rel = aOid_rel;
	}

	public String getOid_rel_padre() throws BaseException {
		supportRefresh();
		return oid_rel_padre;
	}

	public void setOid_rel_padre(String aOid_rel_padre) {
		this.oid_rel_padre = aOid_rel_padre;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static OperAlterFab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (OperAlterFab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static OperAlterFab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (OperAlterFab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static OperAlterFab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (OperAlterFab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
		if (this.getComportamiento().equals(OperAlterFab.OPER_ALT_FAB_OPER)) {
			Validar.noNulo(alternativa_fabricacion, "Debe ingresar la Alternativa de Fabricación");
			Validar.noNulo(proceso, "Debe ingresar el Proceso Productivo");
			Validar.noNulo(operacion, "Debe ingresar la Operación Productiva");
			Validar.noNulo(tipo_estacion, "Debe ingresar el Tipo de Estación de Trabajo");
			Validar.noNulo(tiempo_std, "Debe ingresar el Tiempo Estandar");
			Validar.noNulo(oid_rel, "Debe ingresar el Tipo de Relación");
			Validar.noNulo(oid_rel_padre, "Debe ingresar el Tipo de Relación Padre");
			Validar.noNulo(umTiempoProduccion, "Debe ingresar la Unidad de Medida de Tiempo");
		}
		if (this.getComportamiento().equals(OperAlterFab.OPER_ALT_FAB_TITU)) {
			Validar.noNulo(observacion, "Debe ingresar la Observación");
		}
	}

	public static HashTableDatos getTiposOperAlterFab() throws BaseException {
		HashTableDatos comportamientos = new HashTableDatos();
		comportamientos.put(OPER_ALT_FAB_OPER, "Operación");
		comportamientos.put(OPER_ALT_FAB_TITU, "Título");
		return comportamientos;
	}

	public static List getOperAltFab(AlternativaFabricacion alternativa, ISesion aSesion) throws BaseException {
		return DBOperAlterFab.getOperAltFab(alternativa, aSesion);
	}

	public List getNecesidadMateriales() throws BaseException {
		if (this.readNecesidadMateriales) {
			List listaNecesidadMateriales = NecMatOperAltFab.getNecMatOperAlt(this, getSesion());
			necesidadMateriales.addAll(listaNecesidadMateriales);
			readNecesidadMateriales = false;
		}
		return necesidadMateriales;
	}

	public void addNecesidadMaterial(NecMatOperAltFab aNecMatOperAltFab) throws BaseException {
		aNecMatOperAltFab.setOper_alt_fab(this);
		necesidadMateriales.add(aNecMatOperAltFab);
	}

	public void afterSave() throws BaseException {
		Iterator iterNecMat = necesidadMateriales.iterator();
		while (iterNecMat.hasNext()) {
			NecMatOperAltFab necMat = (NecMatOperAltFab) iterNecMat.next();
			necMat.save();
			necMat = null;
		}
		iterNecMat = null;
	}

}
