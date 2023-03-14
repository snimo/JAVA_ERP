package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBRTablasPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class RTablasPayroll extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RTablasPayroll() {
	}

	public static String NICKNAME = "cip.RTablasPayroll";

	private Integer cotab;
	private Integer codigoRTabla;
	private String descrip;
	private Boolean activo;

	public Integer getCotab() throws BaseException {
		supportRefresh();
		return cotab;
	}

	public void setCotab(Integer aCotab) {
		this.cotab = aCotab;
	}

	public Integer getCodigortabla() throws BaseException {
		supportRefresh();
		return codigoRTabla;
	}

	public void setCodigortabla(Integer aCodigortabla) {
		this.codigoRTabla = aCodigortabla;
	}

	public String getDescrip() throws BaseException {
		supportRefresh();
		return descrip;
	}

	public void setDescrip(String aDescrip) {
		this.descrip = aDescrip;
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

	public static RTablasPayroll findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RTablasPayroll) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RTablasPayroll findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RTablasPayroll) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static void truncarTablaRTablaPayroll(ISesion aSesion)
	  throws BaseException {
		 DBRTablasPayroll.truncarTablaRTablaPayroll(aSesion);
	}
	
	 public static List getRTablasByCotab(Integer contab,
	         ISesion aSesion) throws BaseException {
		 return DBRTablasPayroll.getRTablasByCotab(contab,aSesion);
	 }
	

}
