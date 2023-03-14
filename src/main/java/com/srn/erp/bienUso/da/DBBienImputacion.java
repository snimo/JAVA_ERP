package com.srn.erp.bienUso.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.BienImputacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBBienImputacion extends DBObjetoPersistente {

  public static final String OID_BIEN_IMPU = "oid_bien_impu";
  public static final String OID_BIEN_USO = "oid_bien_uso";
  public static final String VIGENCIA_DESDE = "vigencia_desde";
  public static final String OID_AI = "oid_ai";
  public static final String PORC = "porc";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_BIEN_USO = 100;
  public static final int SELECT_BY_BIEN_USO_FEC_MAS_VIG = 101;
  public static final int SELECT_BY_BIEN_USO_FEC_VIG = 102;

  public DBBienImputacion() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_IMPU = 1;
    final int OID_BIEN_USO = 2;
    final int VIGENCIA_DESDE = 3;
    final int OID_AI = 4;
    final int PORC = 5;
    final int ACTIVO = 6;

    BienImputacion pers = (BienImputacion) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buBienImpu "+
                     " ( "+
                      "OID_BIEN_IMPU,"+
                      "OID_BIEN_USO,"+
                      "VIGENCIA_DESDE,"+
                      "OID_AI,"+
                      "PORC,"+
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
    qInsert.setInt(OID_BIEN_IMPU,pers.getOID());
    qInsert.setInt(OID_BIEN_USO,pers.getBien_uso().getOID());
    qInsert.setDate(VIGENCIA_DESDE,new Date(pers.getVigencia_desde().getTime()));
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_USO = 1;
    final int VIGENCIA_DESDE = 2;
    final int OID_AI = 3;
    final int PORC = 4;
    final int ACTIVO = 5;
    final int OID_BIEN_IMPU = 6;

    BienImputacion pers = (BienImputacion) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buBienImpu set "+
              "oid_bien_uso=?"+ 
              ",vigencia_desde=?"+ 
              ",oid_ai=?"+ 
              ",porc=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_bien_impu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_IMPU,pers.getOID());
    qUpdate.setInt(OID_BIEN_USO,pers.getBien_uso().getOID());
    qUpdate.setDate(VIGENCIA_DESDE,new Date(pers.getVigencia_desde().getTime()));
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_IMPU = 1; 
    BienImputacion pers = (BienImputacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBienImpu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_bien_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_IMPU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_IMPU = 1; 
    BienImputacion pers = (BienImputacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBienImpu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_bien_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_IMPU, pers.getOID()); 
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
      case SELECT_BY_BIEN_USO: {
    	ps = selectByBienUso(aCondiciones); 
    	break;
      }
      case SELECT_BY_BIEN_USO_FEC_MAS_VIG: {
      	ps = selectByBienUsoFecMasVig(aCondiciones);
    	break;
      }
      case SELECT_BY_BIEN_USO_FEC_VIG: {
        ps = selectByBienUsoFecVig(aCondiciones);
        break;    	
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByBienUsoFecVig(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienImpu "); 
	textSQL.append(" WHERE oid_bien_uso = ? and vigencia_desde = ? and activo = 1 order by vigencia_desde desc "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	Bien bienUso = (Bien) condiciones.get(Bien.NICKNAME);
	java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	querySelect.setInt(1,bienUso.getOID());
	querySelect.setDate(2,new Date(fecha.getTime()));
	return querySelect; 
  }  

  
  private PreparedStatement selectByBienUsoFecMasVig(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienImpu "); 
	textSQL.append(" WHERE oid_bien_uso = ? and vigencia_desde <= ? and activo = 1 order by vigencia_desde desc "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	Bien bienUso = (Bien) condiciones.get(Bien.NICKNAME);
	java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	querySelect.setInt(1,bienUso.getOID());
	querySelect.setDate(2,new Date(fecha.getTime()));
	return querySelect; 
  }  
		  
		  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_BIEN_IMPU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBienImpu "); 
    textSQL.append(" WHERE oid_bien_impu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_BIEN_IMPU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByBienUso(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienImpu "); 
	textSQL.append(" WHERE oid_bien_uso = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	Bien bien = (Bien) aCondiciones; 
	querySelect.setInt(1, bien.getOID()); 
	return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBienImpu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_bien_impu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buBienImpu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getImputaciones(Bien aBien,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(BienImputacion.NICKNAME,
             DBBienImputacion.SELECT_BY_BIEN_USO,
             aBien,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getImputacionesVigentes(Bien aBien,
		  java.util.Date fecha,
          ISesion aSesion) throws BaseException {
	HashTableDatos condiciones = new HashTableDatos();
	condiciones.put(Bien.NICKNAME,aBien);
	condiciones.put("FECHA",fecha);
    return (List) ObjetoLogico.getObjects(BienImputacion.NICKNAME,
             DBBienImputacion.SELECT_BY_BIEN_USO_FEC_MAS_VIG,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getImputacionesVigentesAFecha(Bien aBien,
		  java.util.Date fecha,
          ISesion aSesion) throws BaseException {
	HashTableDatos condiciones = new HashTableDatos();
	condiciones.put(Bien.NICKNAME,aBien);
	condiciones.put("FECHA",fecha);
    return (List) ObjetoLogico.getObjects(BienImputacion.NICKNAME,
             DBBienImputacion.SELECT_BY_BIEN_USO_FEC_VIG,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
