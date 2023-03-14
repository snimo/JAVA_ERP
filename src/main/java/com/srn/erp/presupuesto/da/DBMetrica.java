package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.srn.erp.presupuesto.bm.Metrica;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class DBMetrica extends DBObjetoPersistente {

  public static final String OID_METRICA = "oid_metrica";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO = "tipo";
  public static final String CANT_DECIMALES = "cant_decimales";
  public static final String MASCARA_DISPLAY = "mascara_display";
  public static final String ACTIVO = "activo";
  public static final String NRO_INTERNO = "nro_interno";
  
  public DBMetrica() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_METRICA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO = 4;
    final int CANT_DECIMALES = 5;
    final int MASCARA_DISPLAY = 6;
    final int ACTIVO = 7;
    final int NRO_INTERNO = 8;

    Metrica pers = (Metrica) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plMetrica "+
                     " ( "+
                      "OID_METRICA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO,"+
                      "CANT_DECIMALES,"+
                      "MASCARA_DISPLAY,"+
                      "ACTIVO , NRO_INTERNO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_METRICA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setInt(CANT_DECIMALES,pers.getCant_decimales().intValue());    
    qInsert.setString(MASCARA_DISPLAY,pers.getMascara_display());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    int proxNroInterno = getUltimoNroInterno(this.getSesion())+1;
    qInsert.setInt(NRO_INTERNO,proxNroInterno);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO = 3;
    final int CANT_DECIMALES = 4;
    final int MASCARA_DISPLAY = 5;
    final int ACTIVO = 6;
    final int OID_METRICA = 7;

    Metrica pers = (Metrica) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plMetrica set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo=?"+ 
              ",cant_decimales=?"+ 
              ",mascara_display=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_metrica=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_METRICA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setInt(CANT_DECIMALES,pers.getCant_decimales().intValue());
    qUpdate.setString(MASCARA_DISPLAY,pers.getMascara_display());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_METRICA = 1; 
    Metrica pers = (Metrica) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plMetrica "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_metrica=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_METRICA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_METRICA = 1; 
    Metrica pers = (Metrica) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plMetrica "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_metrica=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_METRICA, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_METRICA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plMetrica "); 
    textSQL.append(" WHERE oid_metrica = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_METRICA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plMetrica "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_metrica oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plMetrica");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static int getUltimoNroInterno(ISesion aSesion) throws BaseException {

		 try { 
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_interno) nro_interno ");
		    textSQL.append(" from plMetrica ");

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
