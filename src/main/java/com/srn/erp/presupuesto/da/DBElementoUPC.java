package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.srn.erp.presupuesto.bm.ElementoUPC;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class DBElementoUPC extends DBObjetoPersistente {

  public static final String OID_ELEMENTO_UPC = "oid_elemento_upc";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO = "tipo";
  public static final String NRO_INTERNO = "nro_interno";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_ALL_HELP_PLANILLA = 100;

  public DBElementoUPC() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ELEMENTO_UPC = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO = 4;
    final int NRO_INTERNO = 5;
    final int ACTIVO = 6;

    ElementoUPC pers = (ElementoUPC) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plElementoUPC "+
                     " ( "+
                      "OID_ELEMENTO_UPC,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO,"+
                      "NRO_INTERNO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ELEMENTO_UPC,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO,pers.getTipo());
    int nroInt = getUltimoNroInterno(this.getSesion())+1;
    qInsert.setInt(NRO_INTERNO,nroInt);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO = 3;
    final int ACTIVO = 4;
    final int OID_ELEMENTO_UPC = 5;

    ElementoUPC pers = (ElementoUPC) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plElementoUPC set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_elemento_upc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ELEMENTO_UPC,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ELEMENTO_UPC = 1; 
    ElementoUPC pers = (ElementoUPC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plElementoUPC "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_elemento_upc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ELEMENTO_UPC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ELEMENTO_UPC = 1; 
    ElementoUPC pers = (ElementoUPC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plElementoUPC "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_elemento_upc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ELEMENTO_UPC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null; 
    switch (aSelect) { 
      case IDBObjetoPersistente.SELECT_BY_OID: { 
        ps = this.selectByOID(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_BY_CODIGO: { 
        ps = this.selectByCodigo(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_ALL_HELP: { 
        ps = this.selectAllHelp(aCondiciones); 
        break; 
      } 
      case SELECT_ALL_HELP_PLANILLA: {
        ps = this.selectAllHelpPlanilla(aCondiciones); 
        break; 
      	
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ELEMENTO_UPC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plElementoUPC "); 
    textSQL.append(" WHERE oid_elemento_upc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ELEMENTO_UPC, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plElementoUPC "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_elemento_upc oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plElementoUPC");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllHelpPlanilla(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_elemento_upc oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plElementoUPC where tipo='"+ElementoUPC.TIPO_PLANILLA+"' ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static int getUltimoNroInterno(ISesion aSesion) throws BaseException {

		 try { 
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_interno) nro_interno ");
		    textSQL.append(" from plElementoUPC ");

		    PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
		    
		    ResultSet rs = querySelect.executeQuery();
		    int ultimoNro = 0;
		    if (rs.next())
		    	ultimoNro = rs.getInt(1);
		    rs.close();
		    querySelect.close();	    
		    
		    return ultimoNro;
		 }
		 catch(Exception e) {
			 throw new BaseException(null,e.getMessage());
		 }
		 
	}
  
  
  
} 
