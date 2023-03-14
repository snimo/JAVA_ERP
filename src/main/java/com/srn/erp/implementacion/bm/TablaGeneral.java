package com.srn.erp.implementacion.bm;

import java.sql.PreparedStatement;
import java.util.List;

import com.srn.erp.implementacion.da.DBTablaGeneral;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class TablaGeneral extends ObjetoLogico {

	public TablaGeneral() {
	}

	public static String NICKNAME = "ge.TablaGeneral";

	private String nombre;

	public String getNombre() throws BaseException {
		supportRefresh();
		return this.nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNickName() {
		return NICKNAME;
	}
	
	public static void borrarTabla(String aBorrarTabla,
								   ISesion aSesion)
		throws BaseException {
			DBTablaGeneral.borrarTabla(aBorrarTabla,aSesion);
		
	}
	
	public static void dropTabla(String aBorrarTabla,
			   ISesion aSesion)
	throws BaseException {
		DBTablaGeneral.dropTabla(aBorrarTabla,aSesion);

	}	
	
	public static void ejecutarSQL(String aSQL,
								   ISesion aSesion) throws BaseException {
		
	   if (aSQL == null) return;
	   if (aSQL.trim().equals("")) return;
	   
	   try {
		   DBTablaGeneral.ejecutarSQL(aSQL,aSesion);
	   }
	   catch(Exception e) {
		   throw new ExceptionValidation(null,"Error al procesar sentencia:"+aSQL+" "+e.getMessage());
	   }
	   
	}
	
	public static List getMetaData(String aSQL, ISesion aSesion
			)
		throws BaseException {
		   try {
			   return DBTablaGeneral.getMetaData(aSQL,aSesion);
		   }
		   catch(Exception e) {
			   throw new ExceptionValidation(null,"Error al procesar sentencia:"+aSQL+" "+e.getMessage());
		   }		
		
		
	}
	
	public static PreparedStatement getPreparedStatementTablaGral(String aSQL, ISesion aSesion) throws BaseException {
		
		   try {
			   return DBTablaGeneral.getPreparedStatement(aSQL,aSesion);
		   }
		   catch(Exception e) {
			   throw new ExceptionValidation(null,"Error al procesar sentencia:"+aSQL+" "+e.getMessage());
		   }		
		
		
	}	
	
	
	

}
