package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotivoEntradasInterRota;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;


public class MotivoEntradasInterRota extends ObjetoLogico {

	public static final String ASIG_FIJA = "FIJA";
	public static final String ASIG_SEG_MOT = "SEG_MOT";
	
	public MotivoEntradasInterRota() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.MotivoEntradasInterRota";

	private Rota rota;
	private MotivoEntIntermedias motivo;
	private String horario_desde;
	private String horario_hasta;
	private Boolean activo;
	private String asignacion;

	public Rota getRota() throws BaseException {
		supportRefresh();
		return rota;
	}
	
	public String getAsignacion() throws BaseException {
		supportRefresh();
		if (this.asignacion!=null)
			return this.asignacion;
		else
			return "";
	}
	

	public void setRota(Rota aRota) {
		this.rota = aRota;
	}
	
	public void setAsignacion(String aAsignacion) {
		this.asignacion = aAsignacion;
	}
	

	public MotivoEntIntermedias getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoEntIntermedias aMotivo) {
		this.motivo = aMotivo;
	}

	public String getHorario_desde() throws BaseException {
		supportRefresh();
		return horario_desde;
	}

	public void setHorario_desde(String aHorario_desde) {
		this.horario_desde = aHorario_desde;
	}

	public String getHorario_hasta() throws BaseException {
		supportRefresh();
		return horario_hasta;
	}

	public void setHorario_hasta(String aHorario_hasta) {
		this.horario_hasta = aHorario_hasta;
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

	public static MotivoEntradasInterRota findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoEntradasInterRota) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivoEntradasInterRota findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoEntradasInterRota) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	public static MotivoEntradasInterRota findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoEntradasInterRota) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rota, "Debe ingresar la Rota");
		Validar.noNulo(motivo, "Debe ingresar el Motivo");
		Validar.noNulo(horario_desde, "Debe ingresar el Horario Desde");
		Validar.noNulo(horario_hasta, "Debe ingresar el Horario Hasta");
		Validar.noNulo(this.asignacion, "Debe ingresar el comportamiento del Motivo");
		
	}

	public static List getMotEntInterRotas(Rota rota, ISesion aSesion) throws BaseException {
		return DBMotivoEntradasInterRota.getMotEntInterRotas(rota, aSesion);
	}
	
    public static HashTableDatos getAsignaciones() throws BaseException {
    	HashTableDatos condiciones = new HashTableDatos();
    	condiciones.put(ASIG_FIJA, "Permitir Siempre");
    	condiciones.put(ASIG_SEG_MOT , "Según Motivos Asignados");
    	return condiciones;
    }
    
    public static List getMotEntInterRotasAsigFij(
  		  Rota rota,
            ISesion aSesion) throws BaseException {
  	  return DBMotivoEntradasInterRota.getMotEntInterRotasAsigFij(rota,aSesion);
    }
    
    public static List getMotEntInterSegunLegajo(
  		  Rota rota,
  		  Legajo  legajo,
  		  ISesion aSesion) throws BaseException {
  	  return DBMotivoEntradasInterRota.getMotEntInterSegunLegajo(rota,legajo,aSesion);
    }
    
    public static List getMotEntInterSegunVisita(
    		  Rota rota,
    		  Visita  visita,
    		  ISesion aSesion) throws BaseException {
    	  return DBMotivoEntradasInterRota.getMotEntInterSegunVisita(rota,visita,aSesion);
      }
    
    
}
