package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.EstructuraTipoCiclo;
import com.srn.erp.presupuesto.bm.TipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBEstructuraTipoCiclo extends DBObjetoPersistente {

  public static final String OID_ESTRUC_TIPO = "oid_estruc_tipo";
  public static final String OID_TIPO_CICLO = "oid_tipo_ciclo";
  public static final String OID_ESTRUC_PLANIF = "oid_estruc_planif";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TIPO_CICLO = 100;
  public static final int SELECT_BY_TIPO_CICLO_ESTRUCTURA = 101; 

  public DBEstructuraTipoCiclo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_TIPO = 1;
    final int OID_TIPO_CICLO = 2;
    final int OID_ESTRUC_PLANIF = 3;
    final int ACTIVO = 4;

    EstructuraTipoCiclo pers = (EstructuraTipoCiclo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plEstrucTipoCiclo "+
                     " ( "+
                      "OID_ESTRUC_TIPO,"+
                      "OID_TIPO_CICLO,"+
                      "OID_ESTRUC_PLANIF,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTRUC_TIPO,pers.getOID());
    qInsert.setInt(OID_TIPO_CICLO,pers.getTipo_ciclo().getOID());
    qInsert.setInt(OID_ESTRUC_PLANIF,pers.getEstructura_planificacion().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_CICLO = 1;
    final int OID_ESTRUC_PLANIF = 2;
    final int ACTIVO = 3;
    final int OID_ESTRUC_TIPO = 4;

    EstructuraTipoCiclo pers = (EstructuraTipoCiclo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plEstrucTipoCiclo set "+
              "oid_tipo_ciclo=?"+ 
              ",oid_estruc_planif=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_estruc_tipo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_TIPO,pers.getOID());
    qUpdate.setInt(OID_TIPO_CICLO,pers.getTipo_ciclo().getOID());
    qUpdate.setInt(OID_ESTRUC_PLANIF,pers.getEstructura_planificacion().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_TIPO = 1; 
    EstructuraTipoCiclo pers = (EstructuraTipoCiclo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plEstrucTipoCiclo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estruc_tipo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_TIPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_TIPO = 1; 
    EstructuraTipoCiclo pers = (EstructuraTipoCiclo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plEstrucTipoCiclo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estruc_tipo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_TIPO, pers.getOID()); 
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
      case SELECT_BY_TIPO_CICLO: {
        ps = this.selectByTipoCiclo(aCondiciones); 
        break; 
      }
      case SELECT_BY_TIPO_CICLO_ESTRUCTURA: {
        ps = this.selectByTipoCicloEstructura(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESTRUC_TIPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plEstrucTipoCiclo "); 
    textSQL.append(" WHERE oid_estruc_tipo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTRUC_TIPO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByTipoCiclo(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plEstrucTipoCiclo "); 
    textSQL.append(" WHERE oid_tipo_ciclo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    TipoCiclo tipoCiclo = (TipoCiclo) aCondiciones; 
    querySelect.setInt(1, tipoCiclo.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTipoCicloEstructura(Object aCondiciones) throws BaseException, SQLException { 

  	StringBuffer textSQL = new StringBuffer(); 
  	textSQL.append("SELECT * FROM  plEstrucTipoCiclo "); 
  	textSQL.append(" WHERE oid_tipo_ciclo = ? and oid_estruc_planif = ?  ");
  	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	TipoCiclo tipoCiclo = (TipoCiclo) condiciones.get(TipoCiclo.NICKNAME);
  	EstructuraPlanificacion estruc = (EstructuraPlanificacion) condiciones.get(EstructuraPlanificacion.NICKNAME);
  	querySelect.setInt(1, tipoCiclo.getOID());
  	querySelect.setInt(2, estruc.getOID());
  	return querySelect; 
  }

  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plEstrucTipoCiclo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estruc_tipo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plEstrucTipoCiclo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getEstructurasTipoCiclo(TipoCiclo tipoCiclo,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(EstructuraTipoCiclo.NICKNAME,
         DBEstructuraTipoCiclo.SELECT_BY_TIPO_CICLO,
         tipoCiclo,
         new ListObserver(),
         aSesion);
  }
  
  
} 
