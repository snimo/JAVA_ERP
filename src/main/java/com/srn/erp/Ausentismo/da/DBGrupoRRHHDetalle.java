package com.srn.erp.Ausentismo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoRRHHDetalle extends DBObjetoPersistente {

  public static final String OID_GRUPO_DET = "oid_grupo_det";
  public static final String OID_GRUPO = "oid_grupo";
  public static final String COD_EXT_1 = "cod_ext_1";
  public static final String COD_EXT_2 = "cod_ext_2";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_OID_GRUPO = 100;

  public DBGrupoRRHHDetalle() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_DET = 1;
    final int OID_GRUPO = 2;
    final int COD_EXT_1 = 3;
    final int COD_EXT_2 = 4;
    final int DESCRIPCION = 5;
    final int ACTIVO = 6;

    GrupoRRHHDetalle pers = (GrupoRRHHDetalle) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhoGrupoDet "+
                     " ( "+
                      "OID_GRUPO_DET,"+
                      "OID_GRUPO,"+
                      "COD_EXT_1,"+
                      "COD_EXT_2,"+
                      "DESCRIPCION,"+
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
    qInsert.setInt(OID_GRUPO_DET,pers.getOID());
    qInsert.setInt(OID_GRUPO,pers.getOid_grupo().intValue());
    qInsert.setString(COD_EXT_1,pers.getCod_ext_1());
    qInsert.setString(COD_EXT_2,pers.getCod_ext_2());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO = 1;
    final int COD_EXT_1 = 2;
    final int COD_EXT_2 = 3;
    final int DESCRIPCION = 4;
    final int ACTIVO = 5;
    final int OID_GRUPO_DET = 6;

    GrupoRRHHDetalle pers = (GrupoRRHHDetalle) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhoGrupoDet set "+
              "oid_grupo=?"+ 
              ",cod_ext_1=?"+ 
              ",cod_ext_2=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_DET,pers.getOID());
    qUpdate.setInt(OID_GRUPO,pers.getOid_grupo().intValue());
    qUpdate.setString(COD_EXT_1,pers.getCod_ext_1());
    qUpdate.setString(COD_EXT_2,pers.getCod_ext_2());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_DET = 1; 
    GrupoRRHHDetalle pers = (GrupoRRHHDetalle) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhoGrupoDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_DET = 1; 
    GrupoRRHHDetalle pers = (GrupoRRHHDetalle) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhoGrupoDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_DET, pers.getOID()); 
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
      case DBGrupoRRHHDetalle.SELECT_BY_OID_GRUPO: { 
          ps = this.selectByOIDGrupo(aCondiciones); 
          break; 
        } 
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhoGrupoDet "); 
    textSQL.append(" WHERE oid_grupo_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByOIDGrupo(Object aCondiciones) throws BaseException, SQLException { 

	    final int OID_GRUPO_DET = 1; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhoGrupoDet "); 
	    textSQL.append(" WHERE oid_grupo = ? and activo = 1"); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    int oid = ( (Integer) aCondiciones).intValue(); 
	    querySelect.setInt(OID_GRUPO_DET, oid); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhoGrupoDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhoGrupoDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List<GrupoRRHHDetalle> getSelectByOidGrupo(ISesion aSesion, Integer oid_grupo) throws BaseException {
	  return (List<GrupoRRHHDetalle>) ObjetoLogico.getObjects(GrupoRRHHDetalle.NICKNAME,
             DBGrupoRRHHDetalle.SELECT_BY_OID_GRUPO,
             oid_grupo,
             new ListObserver(),
             aSesion);
  }
  
} 
