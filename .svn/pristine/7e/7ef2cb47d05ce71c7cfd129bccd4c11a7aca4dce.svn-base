package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.RotaVisita;
import com.srn.erp.cip.bm.Visita;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRotaVisita extends DBObjetoPersistente {

  public static final String OID_ROTA_VISITA = "oid_rota_visita";
  public static final String FECHA = "fecha";
  public static final String OID_VISITA = "oid_visita";
  public static final String OID_ROTA = "oid_rota";
  public static final String ACTIVO = "activo";
  public static final String OID_GRUPO_VISITA = "oid_grupo_visita";
  
  public static final int SELECT_FEC_VIS_ROT = 100;
  public static final int SELECT_BY_VISITA = 101;
  public static final int SELECT_BY_VIS_FEC = 102;
  public static final int SELECT_FEC_GRU_ROT = 103;
  public static final int SELECT_BY_GRU_FEC = 104;
  public static final int SELECT_BY_FEC_VISITA = 105;
  public static final int SELECT_BY_FEC_GRUPO = 106;

  public DBRotaVisita() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROTA_VISITA = 1;
    final int FECHA = 2;
    final int OID_VISITA = 3;
    final int OID_ROTA = 4;
    final int ACTIVO = 5;
    final int OID_GRUPO_VISITA = 6;

    RotaVisita pers = (RotaVisita) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipRotaVisita "+
                     " ( "+
                      "OID_ROTA_VISITA,"+
                      "FECHA,"+
                      "OID_VISITA,"+
                      "OID_ROTA,"+
                      "ACTIVO,OID_GRUPO_VISITA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ROTA_VISITA,pers.getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    if (pers.getVisita()!=null)
    	qInsert.setInt(OID_VISITA,pers.getVisita().getOID());
    else
    	qInsert.setNull(OID_VISITA,Types.INTEGER);
    qInsert.setInt(OID_ROTA,pers.getRota().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getGrupoVisita()!=null)
    	qInsert.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qInsert.setNull(OID_GRUPO_VISITA, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FECHA = 1;
    final int OID_VISITA = 2;
    final int OID_ROTA = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_VISITA = 5;
    final int OID_ROTA_VISITA = 6;

    RotaVisita pers = (RotaVisita) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipRotaVisita set "+
              "fecha=?"+ 
              ",oid_visita=?"+ 
              ",oid_rota=?"+ 
              ",activo=?"+ 
              ",oid_grupo_visita=?"+
                 " where " +
                 " oid_rota_visita=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA_VISITA,pers.getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    if (pers.getVisita()!=null)
    	qUpdate.setInt(OID_VISITA,pers.getVisita().getOID());
    else
    	qUpdate.setNull(OID_VISITA,Types.INTEGER);
    qUpdate.setInt(OID_ROTA,pers.getRota().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getGrupoVisita()!=null)
    	qUpdate.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qUpdate.setNull(OID_GRUPO_VISITA, Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA_VISITA = 1; 
    RotaVisita pers = (RotaVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipRotaVisita "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rota_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA_VISITA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA_VISITA = 1; 
    RotaVisita pers = (RotaVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipRotaVisita "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rota_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA_VISITA, pers.getOID()); 
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
      case SELECT_FEC_VIS_ROT: {
          ps = this.selectByFechaRotaVisita(aCondiciones); 
          break; 
      }
      case SELECT_FEC_GRU_ROT: {
          ps = this.selectByFechaRotaGrupo(aCondiciones); 
          break; 
      }
      case SELECT_BY_VISITA: {
          ps = this.selectByVisita(aCondiciones); 
          break; 
      }
      case SELECT_BY_FEC_VISITA: {
          ps = this.selectByVisFec(aCondiciones); 
          break; 
      }
      case SELECT_BY_FEC_GRUPO: {
          ps = this.selectByGruFec(aCondiciones); 
          break; 
      }
      case SELECT_BY_VIS_FEC: {
          ps = this.selectByVisitaFecha(aCondiciones); 
          break; 
      }
      case SELECT_BY_GRU_FEC: {
          ps = this.selectByGrupoFecha(aCondiciones); 
          break; 
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ROTA_VISITA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipRotaVisita "); 
    textSQL.append(" WHERE oid_rota_visita = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ROTA_VISITA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFechaRotaGrupo(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_grupo_visita = ? and oid_rota = ? and fecha = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    GrupoVisita grupo = (GrupoVisita) condiciones.get(GrupoVisita.NICKNAME);
	    Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, grupo.getOID());
	    querySelect.setInt(2, rota.getOID());
	    querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement selectByFechaRotaVisita(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_visita = ? and oid_rota = ? and fecha = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID());
	    querySelect.setInt(2, rota.getOID());
	    querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoFecha(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_grupo_visita  = ? and fecha >= ? AND activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    GrupoVisita grupo = (GrupoVisita) condiciones.get(GrupoVisita.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, grupo.getOID()); 
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }

  private PreparedStatement selectByGruFec(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_grupo_visita  = ? and fecha = ? AND activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    GrupoVisita grupo = (GrupoVisita) condiciones.get(GrupoVisita.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, grupo.getOID()); 
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByVisFec(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and fecha = ? AND activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID()); 
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement selectByVisitaFecha(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and fecha >= ? AND activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID()); 
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement selectByVisita(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipRotaVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Visita visita = (Visita) aCondiciones; 
	    querySelect.setInt(1, visita.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipRotaVisita "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rota_visita oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipRotaVisita");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static RotaVisita getRotaVisita(
		  Visita visita,
		  Rota rota,
		  java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Visita.NICKNAME, visita);
	  condiciones.put(Rota.NICKNAME, rota);
	  condiciones.put("FECHA", fecha);
	  return (RotaVisita) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
			  				DBRotaVisita.SELECT_FEC_VIS_ROT,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static RotaVisita getRotaVisita(
		  GrupoVisita grupo,
		  Rota rota,
		  java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(GrupoVisita.NICKNAME, grupo);
	  condiciones.put(Rota.NICKNAME, rota);
	  condiciones.put("FECHA", fecha);
	  return (RotaVisita) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
			  				DBRotaVisita.SELECT_FEC_GRU_ROT,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static RotaVisita getBuscarRotaVisita(
		  Visita visita,
		  java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Visita.NICKNAME, visita);
	  condiciones.put("FECHA", fecha);
	  return (RotaVisita) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
			  				DBRotaVisita.SELECT_BY_FEC_VISITA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static RotaVisita geBuscartRotaVisita(
		  GrupoVisita grupoVisita,
		  java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(GrupoVisita.NICKNAME, grupoVisita);
	  condiciones.put("FECHA", fecha);
	  return (RotaVisita) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
			  				DBRotaVisita.SELECT_BY_FEC_GRUPO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  

  public static List getRotasVisita(Visita visita,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
             DBRotaVisita.SELECT_BY_VISITA,
             visita,
             new ListObserver(),
             aSesion);
  }

  public static List getRotasVisita(Visita visita,
		  java.util.Date fecha,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Visita.NICKNAME, visita);
	  condiciones.put("FECHA", fecha);
	  return (List) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
             DBRotaVisita.SELECT_BY_VIS_FEC,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  
  public static List getRotasVisita(GrupoVisita grupo,
		  java.util.Date fecha,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(GrupoVisita.NICKNAME, grupo);
	  condiciones.put("FECHA", fecha);
	  return (List) ObjetoLogico.getObjects(RotaVisita.NICKNAME,
             DBRotaVisita.SELECT_BY_GRU_FEC,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
