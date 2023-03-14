package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.VidaUtilGrupo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBVidaUtilGrupo extends DBObjetoPersistente {

  public static final String OID_VIDA_UTIL_G = "oid_vida_util_g";
  public static final String OID_GRUPO_BIEN_USO = "oid_grupo_bien_uso";
  public static final String OID_SIST_VAL = "oid_sist_val";
  public static final String VIDA_UTIL = "vida_util";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_SISTEMA = 100; 

  public DBVidaUtilGrupo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VIDA_UTIL_G = 1;
    final int OID_GRUPO_BIEN_USO = 2;
    final int OID_SIST_VAL = 3;
    final int VIDA_UTIL = 4;
    final int ACTIVO = 5;

    VidaUtilGrupo pers = (VidaUtilGrupo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buVidaUtilGrupo "+
                     " ( "+
                      "OID_VIDA_UTIL_G,"+
                      "OID_GRUPO_BIEN_USO,"+
                      "OID_SIST_VAL,"+
                      "VIDA_UTIL,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VIDA_UTIL_G,pers.getOID());
    qInsert.setInt(OID_GRUPO_BIEN_USO,pers.getGrupo_bien().getOID());
    qInsert.setInt(OID_SIST_VAL,pers.getSistema_valuacion().getOID());
    qInsert.setInt(VIDA_UTIL,pers.getVida_util().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_BIEN_USO = 1;
    final int OID_SIST_VAL = 2;
    final int VIDA_UTIL = 3;
    final int ACTIVO = 4;
    final int OID_VIDA_UTIL_G = 5;

    VidaUtilGrupo pers = (VidaUtilGrupo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buVidaUtilGrupo set "+
              "oid_grupo_bien_uso=?"+ 
              ",oid_sist_val=?"+ 
              ",vida_util=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_vida_util_g=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VIDA_UTIL_G,pers.getOID());
    qUpdate.setInt(OID_GRUPO_BIEN_USO,pers.getGrupo_bien().getOID());
    qUpdate.setInt(OID_SIST_VAL,pers.getSistema_valuacion().getOID());
    qUpdate.setInt(VIDA_UTIL,pers.getVida_util().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VIDA_UTIL_G = 1; 
    VidaUtilGrupo pers = (VidaUtilGrupo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buVidaUtilGrupo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_vida_util_g=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VIDA_UTIL_G, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VIDA_UTIL_G = 1; 
    VidaUtilGrupo pers = (VidaUtilGrupo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buVidaUtilGrupo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_vida_util_g=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VIDA_UTIL_G, pers.getOID()); 
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
      case SELECT_BY_GRUPO_SISTEMA: {
        ps = this.selectByGrupoSistema(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VIDA_UTIL_G = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buVidaUtilGrupo "); 
    textSQL.append(" WHERE oid_vida_util_g = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VIDA_UTIL_G, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoSistema(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buVidaUtilGrupo "); 
	textSQL.append(" WHERE oid_grupo_bien_uso = ? and oid_sist_val = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	GrupoBien grupoBien = (GrupoBien)condiciones.get(GrupoBien.NICKNAME);
	SistemaValuacion sistVal = (SistemaValuacion)condiciones.get(SistemaValuacion.NICKNAME);
	querySelect.setInt(1,grupoBien.getOID());
	querySelect.setInt(2,sistVal.getOID());
	return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buVidaUtilGrupo "); 
    textSQL.append(" WHERE oid_grupo_bien_uso = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_vida_util_g oid,oid_grupo_bien_uso codigo, oid_sist_val descripcion ,activo ");
    textSQL.append(" from buVidaUtilGrupo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static VidaUtilGrupo getVidaUtilGrupo(GrupoBien grupoBien,SistemaValuacion sistVal,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(GrupoBien.NICKNAME,grupoBien);
	  condiciones.put(SistemaValuacion.NICKNAME,sistVal);
	  return (VidaUtilGrupo) ObjetoLogico.getObjects(VidaUtilGrupo.NICKNAME,
			  DBVidaUtilGrupo.SELECT_BY_GRUPO_SISTEMA,
			  condiciones,
			  new ObjetoObservado(),
			  aSesion);
  }
  
  
} 
