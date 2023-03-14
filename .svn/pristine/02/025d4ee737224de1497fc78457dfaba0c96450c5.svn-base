package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotEntInterLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
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

public class DBMotEntInterLeg extends DBObjetoPersistente {

  public static final String OID_MOT_ENT_LEG = "oid_mot_ent_leg";
  public static final String OID_MOTIVO = "oid_motivo";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_LEGAJO  = 100;
  public static final int SELECT_BY_MOT_LEG = 101;

  public DBMotEntInterLeg() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_ENT_LEG = 1;
    final int OID_MOTIVO = 2;
    final int OID_LEGAJO = 3;
    final int ACTIVO = 4;

    MotEntInterLeg pers = (MotEntInterLeg) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotEntIntLeg "+
                     " ( "+
                      "OID_MOT_ENT_LEG,"+
                      "OID_MOTIVO,"+
                      "OID_LEGAJO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_ENT_LEG,pers.getOID());
    qInsert.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO = 1;
    final int OID_LEGAJO = 2;
    final int ACTIVO = 3;
    final int OID_MOT_ENT_LEG = 4;

    MotEntInterLeg pers = (MotEntInterLeg) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotEntIntLeg set "+
              "oid_motivo=?"+ 
              ",oid_legajo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mot_ent_leg=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ENT_LEG,pers.getOID());
    qUpdate.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_ENT_LEG = 1; 
    MotEntInterLeg pers = (MotEntInterLeg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntIntLeg "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_ent_leg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ENT_LEG, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_ENT_LEG = 1; 
    MotEntInterLeg pers = (MotEntInterLeg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntIntLeg "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_ent_leg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ENT_LEG, pers.getOID()); 
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
      case SELECT_BY_LEGAJO: {
          ps = this.selectByLegajo(aCondiciones); 
          break; 
      }
      case SELECT_BY_MOT_LEG: {
          ps = this.selectByMotivoLegajo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOT_ENT_LEG = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntIntLeg "); 
    textSQL.append(" WHERE oid_mot_ent_leg = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_ENT_LEG, oid); 
    return querySelect; 
  }


  private PreparedStatement selectByMotivoLegajo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntLeg "); 
	    textSQL.append(" WHERE oid_legajo = ? and oid_motivo = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    MotivoEntIntermedias motivo = (MotivoEntIntermedias) condiciones.get(MotivoEntIntermedias.NICKNAME);
	    querySelect.setInt(1, legajo.getOID());
	    querySelect.setInt(2, motivo.getOID());
	    return querySelect;
  }

  private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntLeg "); 
	    textSQL.append(" WHERE oid_legajo = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Legajo legajo = (Legajo) aCondiciones; 
	    querySelect.setInt(1, legajo.getOID()); 
	    return querySelect;
}
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntIntLeg "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_ent_leg oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipMotEntIntLeg");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getMotivosLegajo(Legajo aLegajo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotEntInterLeg.NICKNAME,
             DBMotEntInterLeg.SELECT_BY_LEGAJO,
             aLegajo,
             new ListObserver(),
             aSesion);
  }
  
  public static MotEntInterLeg getMotEntInterLeg(
		  Legajo legajo,
		  MotivoEntIntermedias motivoEntradasIntermedias,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Legajo.NICKNAME, legajo);
	  condiciones.put(MotivoEntIntermedias.NICKNAME, motivoEntradasIntermedias);
	  return (MotEntInterLeg) ObjetoLogico.getObjects(MotEntInterLeg.NICKNAME,
			  				DBMotEntInterLeg.SELECT_BY_MOT_LEG,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
  
} 
