package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.EquivMotEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEquivMotEntIntermedias extends DBObjetoPersistente {

  public static final String OID_EQUIV_MOT = "oid_equiv_mot";
  public static final String CODIGO = "codigo";
  public static final String OID_MOTIVO = "oid_motivo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_MOTIVO = 100;

  public DBEquivMotEntIntermedias() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EQUIV_MOT = 1;
    final int CODIGO = 2;
    final int OID_MOTIVO = 3;
    final int ACTIVO = 4;

    EquivMotEntIntermedias pers = (EquivMotEntIntermedias) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipEMotEntInt "+
                     " ( "+
                      "OID_EQUIV_MOT,"+
                      "CODIGO,"+
                      "OID_MOTIVO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EQUIV_MOT,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int OID_MOTIVO = 2;
    final int ACTIVO = 3;
    final int OID_EQUIV_MOT = 4;

    EquivMotEntIntermedias pers = (EquivMotEntIntermedias) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipEMotEntInt set "+
              "codigo=?"+ 
              ",oid_motivo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_equiv_mot=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV_MOT,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EQUIV_MOT = 1; 
    EquivMotEntIntermedias pers = (EquivMotEntIntermedias) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipEMotEntInt "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_equiv_mot=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV_MOT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EQUIV_MOT = 1; 
    EquivMotEntIntermedias pers = (EquivMotEntIntermedias) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipEMotEntInt "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_equiv_mot=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV_MOT, pers.getOID()); 
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
      case SELECT_BY_MOTIVO: {
          ps = this.selectByMotivo(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EQUIV_MOT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipEMotEntInt "); 
    textSQL.append(" WHERE oid_equiv_mot = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EQUIV_MOT, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByMotivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipEMotEntInt "); 
	    textSQL.append(" WHERE oid_motivo = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    MotivoEntIntermedias motivo = (MotivoEntIntermedias) aCondiciones; 
	    querySelect.setInt(1, motivo.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipEMotEntInt "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_equiv_mot oid,codigo codigo, oid_motivo descripcion ,activo ");
    textSQL.append(" from cipEMotEntInt");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEquivMotEntIntermedias(MotivoEntIntermedias motivo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EquivMotEntIntermedias.NICKNAME,
             DBEquivMotEntIntermedias.SELECT_BY_MOTIVO,
             motivo,
             new ListObserver(),
             aSesion);
  }  
  
} 
