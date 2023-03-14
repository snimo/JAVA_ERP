package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TarjetaRotaVisita;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTarjetaRotaVisita extends DBObjetoPersistente {

  public static final String OID_TARJ_ROT = "oid_tarj_rot";
  public static final String OID_TARJETA = "oid_tarjeta";
  public static final String FECHA = "fecha";
  public static final String OID_ROTA = "oid_rota";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TARJ_MAYOIGUAL_A_FEC = 100;
  public static final int SELECT_BY_TARJETA_FECHA = 101;

  public DBTarjetaRotaVisita() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TARJ_ROT = 1;
    final int OID_TARJETA = 2;
    final int FECHA = 3;
    final int OID_ROTA = 4;
    final int ACTIVO = 5;

    TarjetaRotaVisita pers = (TarjetaRotaVisita) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipTarjRotFec "+
                     " ( "+
                      "OID_TARJ_ROT,"+
                      "OID_TARJETA,"+
                      "FECHA,"+
                      "OID_ROTA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TARJ_ROT,pers.getOID());
    qInsert.setInt(OID_TARJETA,pers.getTarjeta().getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setInt(OID_ROTA,pers.getRota().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TARJETA = 1;
    final int FECHA = 2;
    final int OID_ROTA = 3;
    final int ACTIVO = 4;
    final int OID_TARJ_ROT = 5;

    TarjetaRotaVisita pers = (TarjetaRotaVisita) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipTarjRotFec set "+
              "oid_tarjeta=?"+ 
              ",fecha=?"+ 
              ",oid_rota=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tarj_rot=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TARJ_ROT,pers.getOID());
    qUpdate.setInt(OID_TARJETA,pers.getTarjeta().getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setInt(OID_ROTA,pers.getRota().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TARJ_ROT = 1; 
    TarjetaRotaVisita pers = (TarjetaRotaVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipTarjRotFec "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tarj_rot=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TARJ_ROT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TARJ_ROT = 1; 
    TarjetaRotaVisita pers = (TarjetaRotaVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipTarjRotFec "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tarj_rot=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TARJ_ROT, pers.getOID()); 
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
      case SELECT_BY_TARJ_MAYOIGUAL_A_FEC: {
          ps = this.selectByTarjMayoIgualFec(aCondiciones); 
          break; 
      }
      case SELECT_BY_TARJETA_FECHA: {
          ps = this.selectByTarjetaFecha(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TARJ_ROT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipTarjRotFec "); 
    textSQL.append(" WHERE oid_tarj_rot = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TARJ_ROT, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTarjetaFecha(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipTarjRotFec "); 
	    textSQL.append(" WHERE oid_tarjeta = ? and activo = 1 and fecha=?");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    TarjetaCIP tarjeta = (TarjetaCIP) condiciones.get(TarjetaCIP.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, tarjeta.getOID());
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement selectByTarjMayoIgualFec(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipTarjRotFec "); 
	    textSQL.append(" WHERE oid_tarjeta = ? and activo = 1 and fecha>=?");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    TarjetaCIP tarjeta = (TarjetaCIP) condiciones.get(TarjetaCIP.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, tarjeta.getOID());
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipTarjRotFec "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tarj_rot oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipTarjRotFec");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getTarjetasRotaVisita(
		  TarjetaCIP tarjeta,
		  java.util.Date fecha,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(TarjetaCIP.NICKNAME, tarjeta);
	  condiciones.put("FECHA", fecha);
	  return (List) ObjetoLogico.getObjects(TarjetaRotaVisita.NICKNAME,
             DBTarjetaRotaVisita.SELECT_BY_TARJ_MAYOIGUAL_A_FEC,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static TarjetaRotaVisita getTarjetaRotaVisita(
		  TarjetaCIP tarjeta,
		  java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(TarjetaCIP.NICKNAME, tarjeta);
	  condiciones.put("FECHA", fecha);
	  return (TarjetaRotaVisita) ObjetoLogico.getObjects(TarjetaRotaVisita.NICKNAME,
			  				DBTarjetaRotaVisita.SELECT_BY_TARJETA_FECHA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
  
} 
