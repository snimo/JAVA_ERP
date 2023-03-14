package com.srn.erp.cip.bm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBCategEvenAccesoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CategEvenAccesoLeg extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CategEvenAccesoLeg() {
	}
	
	public static final String TIPO_ACCESO_LIMITAR = "LIMITAR_A";
	public static final String TIPO_ACCESO_SUMAR_A = "SUMAR_A";

	public static String NICKNAME = "cip.CategEvenAccesoLeg";

	private List categAccDet = new ArrayList();
	private boolean readCatAccDet = true;

	private Legajo legajo;
	private java.util.Date fecha_desde;
	private java.util.Date fecha_hasta;
	private String tipo_acceso;
	private Boolean activo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public java.util.Date getFecha_desde() throws BaseException {
		supportRefresh();
		return fecha_desde;
	}

	public void setFecha_desde(java.util.Date aFecha_desde) {
		this.fecha_desde = aFecha_desde;
	}

	public java.util.Date getFecha_hasta() throws BaseException {
		supportRefresh();
		return fecha_hasta;
	}

	public void setFecha_hasta(java.util.Date aFecha_hasta) {
		this.fecha_hasta = aFecha_hasta;
	}

	public String getTipo_acceso() throws BaseException {
		supportRefresh();
		return tipo_acceso;
	}

	public void setTipo_acceso(String aTipo_acceso) {
		this.tipo_acceso = aTipo_acceso;
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

	public static CategEvenAccesoLeg findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategEvenAccesoLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategEvenAccesoLeg findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategEvenAccesoLeg) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CategEvenAccesoLeg findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CategEvenAccesoLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(fecha_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fecha_hasta, "Debe ingresar la Fecha Hasta");
		Validar.noNulo(tipo_acceso, "Debe ingresar el Tipo de Acceso");
	}

	public static List getCategAccEventuales(Legajo legajo,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBCategEvenAccesoLeg.getCategAccEventuales(legajo, fecha,
				aSesion);
	}

	public List getCategAccesosEventuales() throws BaseException {
		if (this.readCatAccDet) {
			List listaCategAcceso = CategEvenAccLegDet.getCategEventualesDet(this,getSesion());
			this.categAccDet.addAll(listaCategAcceso);
			this.readCatAccDet = false;
		}
		return this.categAccDet;
	}

	public void addCategAccesoEvenDet(CategEvenAccLegDet aCategEvenAccLegDet)
			throws BaseException {
		aCategEvenAccLegDet.setCateg_eventual_leg(this);
		this.categAccDet.add(aCategEvenAccLegDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterCategEvenAccLegDet = this.categAccDet.iterator();
		while (iterCategEvenAccLegDet.hasNext()) {
			CategEvenAccLegDet categEvenAccLegDet = (CategEvenAccLegDet) iterCategEvenAccLegDet.next();
			categEvenAccLegDet.save();
			categEvenAccLegDet = null;
		}
		iterCategEvenAccLegDet = null;
	}
	
	public static HashTableDatos getTiposAccesos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TIPO_ACCESO_LIMITAR,"Limitar Accesos a");
		condiciones.put(TIPO_ACCESO_SUMAR_A,"Permitir Acceder a");
		return condiciones;
	}
	
	public boolean isLimitarA() throws BaseException {
		if (this.getTipo_acceso().equals(TIPO_ACCESO_LIMITAR))
			return true;
		else
			return false;
	}
	
	public boolean isSumarAcceso() throws BaseException {
		if (this.getTipo_acceso().equals(TIPO_ACCESO_SUMAR_A))
			return true;
		else
			return false;
	}
	
	public String getFecDesdeyHasta() throws BaseException {
		
		String fecDesde = Fecha.getddmmyyyy(this.getFecha_desde());
		String fecHasta = Fecha.getddmmyyyy(this.getFecha_hasta());
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String horaDesde = sdf.format(this.getFecha_desde());
		String horaHasta = sdf.format(this.getFecha_hasta());
		
		if (fecDesde.equals(fecHasta)) 
			return fecDesde+ " de "+horaDesde+" a "+ horaHasta;
		else
			return fecDesde+ " "+horaDesde+" a "+fecHasta+" "+horaHasta;
		
	}
	
	public String getHorDesdeyHasta() throws BaseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String horaDesde = sdf.format(this.getFecha_desde());
		String horaHasta = sdf.format(this.getFecha_hasta());
		
		return " de "+horaDesde+" a "+ horaHasta;
		
	}
	
	
	public String getDescCategorias() throws BaseException {
		StringBuffer descripciones = new StringBuffer("");
		Iterator iterCategEven = 
			this.getCategAccesosEventuales().iterator();
		while (iterCategEven.hasNext()) {
			CategEvenAccLegDet categEvenAccLegDet = (CategEvenAccLegDet) iterCategEven.next();
			if (descripciones.length()>0) {
				descripciones.append(", "+categEvenAccLegDet.getCategoria().getDescripcion());
			} else {
				descripciones.append(categEvenAccLegDet.getCategoria().getDescripcion());
			}
		}
		return descripciones.toString();
	}
	

}
