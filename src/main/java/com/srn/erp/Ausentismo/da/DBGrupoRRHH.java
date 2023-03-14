package com.srn.erp.Ausentismo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoRRHH extends DBObjetoPersistente {

  public static final String OID_GRUPO = "oid_grupo";
  public static final String TIPO = "tipo";
  public static final String NOMBRE = "nombre";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_TIPO = 100;
  private static final int SELECT_BY_TIPO_ROTAS = 101;
  private static final int SELECT_BY_TIPO_AUSENCIAS = 102;

  public DBGrupoRRHH() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO = 1;
    final int TIPO = 2;
    final int NOMBRE = 3;
    final int ACTIVO = 4;

    GrupoRRHH pers = (GrupoRRHH) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhoGrupo "+
                     " ( "+
                      "OID_GRUPO,"+
                      "TIPO,"+
                      "NOMBRE,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO,pers.getOID());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TIPO = 1;
    final int NOMBRE = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO = 4;

    GrupoRRHH pers = (GrupoRRHH) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhoGrupo set "+
              "tipo=?"+ 
              ",nombre=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO,pers.getOID());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO = 1; 
    GrupoRRHH pers = (GrupoRRHH) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhoGrupo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO = 1; 
    GrupoRRHH pers = (GrupoRRHH) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhoGrupo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO, pers.getOID()); 
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
      case DBGrupoRRHH.SELECT_BY_TIPO: { 
          ps = this.selectByTipo(aCondiciones); 
          break; 
      } 
      case DBGrupoRRHH.SELECT_BY_TIPO_ROTAS: { 
          ps = this.selectByTipoRotas(aCondiciones); 
          break; 
      } 
      case DBGrupoRRHH.SELECT_BY_TIPO_AUSENCIAS: { 
          ps = this.selectByTipoAusencias(aCondiciones); 
          break; 
      } 
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhoGrupo "); 
    textSQL.append(" WHERE oid_grupo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhoGrupo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo oid, nombre codigo, tipo descripcion , activo ");
    textSQL.append(" from rhoGrupo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
	private PreparedStatement selectByTipoRotas(Object aCondiciones) throws BaseException, SQLException {
		Hashtable<String,Object> hashTable = (Hashtable<String,Object>) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append("SELECT oid_grupo oid, nombre codigo, tipo descripcion , activo ");
		textSQL.append("FROM rhoGrupo WHERE tipo like 'Rota'");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByTipoAusencias(Object aCondiciones) throws BaseException, SQLException {
		Hashtable<String,Object> hashTable = (Hashtable<String,Object>) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append("SELECT oid_grupo oid, nombre codigo, tipo descripcion , activo ");
		textSQL.append("FROM  rhoGrupo WHERE tipo like 'Ausencia'");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByTipo(Object aCondiciones) throws BaseException, SQLException {
		String tipo = (String) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append("SELECT * FROM  rhoGrupo ");
		textSQL.append(" WHERE tipo like '" + tipo + "'");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
  
  public static List<GrupoRRHH> getSelectByTipo(ISesion aSesion, String tipo) throws BaseException {
	  return (List<GrupoRRHH>) ObjetoLogico.getObjects(GrupoRRHH.NICKNAME,
             DBGrupoRRHH.SELECT_BY_TIPO,
             tipo,
             new ListObserver(),
             aSesion);
  }
  
} 
