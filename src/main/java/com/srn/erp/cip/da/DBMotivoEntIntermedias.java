package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotivoEntIntermedias extends DBObjetoPersistente {

  public static final String OID_MOTIVO = "oid_motivo";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_ACTIVOS  = 100;
  public static final int SELECT_TIENE_MOT_HAB_LEG = 101;

  public DBMotivoEntIntermedias() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;

    MotivoEntIntermedias pers = (MotivoEntIntermedias) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotEntInt "+
                     " ( "+
                      "OID_MOTIVO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOTIVO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_MOTIVO = 4;

    MotivoEntIntermedias pers = (MotivoEntIntermedias) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotEntInt set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_motivo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOTIVO = 1; 
    MotivoEntIntermedias pers = (MotivoEntIntermedias) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntInt "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_motivo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOTIVO = 1; 
    MotivoEntIntermedias pers = (MotivoEntIntermedias) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntInt "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_motivo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
          ps = this.selectAllActivos(aCondiciones); 
          break; 
      }   
      case SELECT_ACTIVOS: {
          ps = this.selectLosActivos(aCondiciones); 
          break; 
      }
      case SELECT_TIENE_MOT_HAB_LEG: {
          ps = this.selectByTieneMotEntInterHabLeg(aCondiciones); 
          break; 
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOTIVO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntInt "); 
    textSQL.append(" WHERE oid_motivo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOTIVO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntInt "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectLosActivos(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * ");
	    textSQL.append(" from cipMotEntInt where activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }    
  
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_motivo oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cipMotEntInt where activo=1 ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_motivo oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipMotEntInt");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTieneMotEntInterHabLeg(Object aCondiciones) throws BaseException, SQLException { 
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntInt "); 
	    textSQL.append(" WHERE activo = 1 and ");
	    textSQL.append(" oid_motivo in ");
	    textSQL.append(" ( ");
	    textSQL.append("    select oid_motivo from cipMotEntIntLeg where oid_legajo=? and activo = 1 and oid_motivo = ? ");
	    textSQL.append("    union all ");
	    textSQL.append("    select b.oid_motivo from suLegajo a , cipMotEntIntEst b where a.oid_legajo = ? and a.oid_estado = b.oid_estado and a.activo = 1 and b.activo = 1 and b.oid_motivo = ? ");
	    textSQL.append("    union all ");
	    textSQL.append("    select a.oid_motivo from cipMotEntIntCLeg a , suLegajo b where b.activo = 1 and a.activo=1 and b.oid_legajo = ? and a.oid_motivo = ? ");
	    textSQL.append("                                                                   and (b.oid_clasif_01 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_02 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_03 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_04 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_05 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_06 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_07 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_08 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_09 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_10 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_11 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_12 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_13 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_14 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_15 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_16 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_17 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_18 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_19 = a.oid_val_clasif ");
	    textSQL.append("                                                                   or b.oid_clasif_20 = a.oid_val_clasif) ");
	    textSQL.append(" ) ");
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    MotivoEntIntermedias motivo = (MotivoEntIntermedias) condiciones.get(MotivoEntIntermedias.NICKNAME);
	    
	    querySelect.setInt(1, legajo.getOID());
	    querySelect.setInt(2, motivo.getOID());
	    querySelect.setInt(3, legajo.getOID());
	    querySelect.setInt(4, motivo.getOID());
	    querySelect.setInt(5, legajo.getOID());
	    querySelect.setInt(6, motivo.getOID());
	    return querySelect; 
}  
  
  
  public static List getMotivoEntIntermedias(ISesion aSesion) throws BaseException {
      return (List) ObjetoLogico.getObjects(MotivoEntIntermedias.NICKNAME,
             DBMotivoEntIntermedias.SELECT_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }
  
  public static MotivoEntIntermedias getMotivoEntIntermedia(
		  Legajo legajo,
		  MotivoEntIntermedias motivo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Legajo.NICKNAME, legajo);
	  condiciones.put(MotivoEntIntermedias.NICKNAME, motivo);
	  return (MotivoEntIntermedias) ObjetoLogico.getObjects(MotivoEntIntermedias.NICKNAME,
			  				DBMotivoEntIntermedias.SELECT_TIENE_MOT_HAB_LEG,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
