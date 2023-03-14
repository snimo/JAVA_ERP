package com.srn.erp.cashflow.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cashflow.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBGrupoConceptoCF extends DBObjetoPersistente {

  public static final String OID_GRUPO_CONCEPTO = "oid_grupo_concepto";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String ORDEN = "orden";
  public static final String COMPOR_GRUPO = "compor_grupo";
  
  public static final int SELECT_BY_COMPO_GRUPO = 100;

  public DBGrupoConceptoCF() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_CONCEPTO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int ORDEN = 5;
    final int COMPOR_GRUPO = 6;

    GrupoConceptoCF pers = (GrupoConceptoCF) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfGrupoConc "+
                     " ( "+
                      "OID_GRUPO_CONCEPTO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,ORDEN,COMPOR_GRUPO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_CONCEPTO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(ORDEN, pers.getOrden().intValue());
    qInsert.setString(COMPOR_GRUPO, pers.getComporGrupo());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int ORDEN =  4;
    final int COMPOR_GRUPO = 5;
    final int OID_GRUPO_CONCEPTO = 6;

    GrupoConceptoCF pers = (GrupoConceptoCF) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfGrupoConc set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=? , orden = ? , compor_grupo = ? "+ 
                 " where " +
                 " oid_grupo_concepto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CONCEPTO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(ORDEN, pers.getOrden().intValue());
    qUpdate.setString(COMPOR_GRUPO, pers.getComporGrupo());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_CONCEPTO = 1; 
    GrupoConceptoCF pers = (GrupoConceptoCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfGrupoConc "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_concepto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CONCEPTO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_CONCEPTO = 1; 
    GrupoConceptoCF pers = (GrupoConceptoCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfGrupoConc "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_concepto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_CONCEPTO, pers.getOID()); 
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
      case SELECT_BY_COMPO_GRUPO: {
          ps = this.selectByCompoGrupo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_CONCEPTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfGrupoConc "); 
    textSQL.append(" WHERE oid_grupo_concepto = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_CONCEPTO, oid); 
    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCompoGrupo(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cfGrupoConc "); 
	    textSQL.append(" WHERE compor_grupo = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String comportamiento = (String) aCondiciones; 
	    querySelect.setString(1, comportamiento); 
	    return querySelect; 
	  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfGrupoConc "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_concepto oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cfGrupoConc");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGruposConcepto(String comportamiento,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GrupoConceptoCF.NICKNAME,
             DBGrupoConceptoCF.SELECT_BY_COMPO_GRUPO,
             comportamiento,
             new ListObserver(),
             aSesion);
  }
  
  
} 
