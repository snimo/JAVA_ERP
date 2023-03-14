package com.srn.erp.excelReport.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excelReport.da.DBExcelReport;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ExcelReport extends ObjetoLogico {

	public ExcelReport() {
	}

	public static String NICKNAME = "ex.ExcelReport";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private GrupoReporteExcel grupoReporte;
	private Integer orden;
	
	private List funciones = new ArrayList();
	private boolean readFunciones = true;
	
	private List usuariosRep = new ArrayList();
	private boolean readUsuariosRep = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}
	
	public Integer getOrden() throws BaseException {
		supportRefresh();
		return this.orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}
	
	
	public GrupoReporteExcel getGrupoReporteExcel() throws BaseException {
		supportRefresh();
		return this.grupoReporte;
	}

	public void setGrupoReporteExcel(GrupoReporteExcel aGrupoReporteExcel) {
		this.grupoReporte = aGrupoReporteExcel;
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

	public static ExcelReport findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ExcelReport) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ExcelReport findByOidProxy(Integer oid, ISesion aSesion)
	throws BaseException {
		return (ExcelReport) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static ExcelReport findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ExcelReport) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(grupoReporte, "Debe ingresar el Agrupador");
		Validar.noNulo(orden, "Debe ingresar el Orden");
	}

	public static String getPathAlmacenamientoServidor(ISesion aSesion)
			throws BaseException {
		ValorParametro valorPath = ValorParametro
				.findByCodigoParametro("PATH_EXCEL_REPORT", aSesion);
		return valorPath.getValorCadena();
	}
	
	public List getFunciones() throws BaseException {
		if (this.readFunciones) {
		      List listaFunciones = FuncionReporteExcel.getFuncionesReporte(this,getSesion());
		      funciones.addAll(listaFunciones);
		      this.readFunciones = false;
		}
		return this.funciones;
	}
	
	public List getUsuariosReporte() throws BaseException {
		if (this.readUsuariosRep) {
		      List listaUsuariosRep = UsuarioReporteExcel.getUsuariosReporte(this,getSesion());
		      usuariosRep.addAll(listaUsuariosRep);
		      this.readUsuariosRep = false;
		}
		return this.usuariosRep;
	}
	

	public void addFuncion(FuncionReporteExcel aFuncionReporteExcel) throws BaseException {
		aFuncionReporteExcel.setReporte(this);
		funciones.add(aFuncionReporteExcel);
	}
	
	public void addUsuarioReporteExcel(UsuarioReporteExcel aUsuarioReporteExcel) throws BaseException {
		aUsuarioReporteExcel.setReporte(this);
		usuariosRep.add(aUsuarioReporteExcel);
	}
	

	public void afterSave() throws BaseException {
		Iterator iterFunciones = funciones.iterator();
		while (iterFunciones.hasNext()) {
		      FuncionReporteExcel funcionReporteExcel = (FuncionReporteExcel) iterFunciones.next();
		      funcionReporteExcel.save();
		      funcionReporteExcel = null;
		}
		iterFunciones = null;
		
		Iterator iterUsuariosRep = usuariosRep.iterator();
		while (iterUsuariosRep.hasNext()) {
		      UsuarioReporteExcel usuRepExc = (UsuarioReporteExcel) iterUsuariosRep.next();
		      usuRepExc.save();
		      usuRepExc = null;
		}
		iterUsuariosRep = null;
		
	}
	
	public static ResultFuncExcel execFunc(String funcion,ISesion aSesion) throws BaseException {
		DefFunExcel defFunExcel = null;
		try {
			String tokenFuncion = DefFunExcel.getTokenFuncion(funcion);
			String paramsFuncion = DefFunExcel.getParamsFuncion(funcion);
			defFunExcel = DefFunExcel.create(tokenFuncion);
			if (defFunExcel == null) {
				ResultFuncExcel result = new ResultFuncExcel();
				result.setTipo(Field.STRING);
				result.setResult("Func. Desconocida");
				return result;
			}
			defFunExcel.setSesion(aSesion);
			return defFunExcel.execFunc(paramsFuncion,aSesion);
			
			} catch(Exception e) {
				return defFunExcel.getResultError(e.getMessage());
			}
	}
	
	 public UsuarioReporteExcel getUsuarioReporteExcel(Usuario usuario)
	          throws BaseException {
		  
		  return UsuarioReporteExcel.getUsuarioReporteExcel(this,usuario,this.getSesion());
		  
	 }
	 
	  public static List getReportesUsuario(ISesion aSesion) throws BaseException {
		  return DBExcelReport.getReportesUsuario(aSesion);
	  }
	 
	

	

}
