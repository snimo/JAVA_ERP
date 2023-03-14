package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotEntIntVis;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
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

public class DBMotEntIntVis extends DBObjetoPersistente {

  public static final String OID_MOT_ENT_INT = "oid_mot_ent_int";
  public static final String OID_VISITA = "oid_visita";
  public static final String OID_MOTIVO = "oid_motivo";
  public static final String ACTIVO = "activo";
  public static final String OID_GRUPO_VISITA = "oid_grupo_visita";
  
  public static final int SELECT_BY_VISITA = 100;
  public static final int SELECT_BY_VISITA_MOTIVO = 101;
  public static final int SELECT_BY_GRUPO_MOTIVO = 102;

  public DBMotEntIntVis() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_ENT_INT = 1;
    final int OID_VISITA = 2;
    final int OID_MOTIVO = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_VISITA = 5;

    MotEntIntVis pers = (MotEntIntVis) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotEntIntVis "+
                     " ( "+
                      "OID_MOT_ENT_INT,"+
                      "OID_VISITA,"+
                      "OID_MOTIVO,"+
                      "ACTIVO,OID_GRUPO_VISITA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_ENT_INT,pers.getOID());
    if (pers.getVisita()!=null)
    	qInsert.setInt(OID_VISITA,pers.getVisita().getOID());
    else
    	qInsert.setNull(OID_VISITA,Types.INTEGER);
    qInsert.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getGrupoVisita()!=null)
    	qInsert.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qInsert.setNull(OID_GRUPO_VISITA, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VISITA = 1;
    final int OID_MOTIVO = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_VISITA = 4;
    final int OID_MOT_ENT_INT = 5;

    MotEntIntVis pers = (MotEntIntVis) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotEntIntVis set "+
              "oid_visita=?"+ 
              ",oid_motivo=?"+ 
              ",activo=?"+ 
              ",oid_grupo_visita=?"+
                 " where " +
                 " oid_mot_ent_int=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ENT_INT,pers.getOID());
    if (pers.getVisita()!=null)
    	qUpdate.setInt(OID_VISITA,pers.getVisita().getOID());
    else
    	qUpdate.setNull(OID_VISITA,Types.INTEGER);
    qUpdate.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getGrupoVisita()!=null)
    	qUpdate.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qUpdate.setNull(OID_GRUPO_VISITA, Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_ENT_INT = 1; 
    MotEntIntVis pers = (MotEntIntVis) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntIntVis "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_ent_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ENT_INT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_ENT_INT = 1; 
    MotEntIntVis pers = (MotEntIntVis) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntIntVis "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_ent_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ENT_INT, pers.getOID()); 
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
      case SELECT_BY_VISITA: {
          ps = this.selectByVisita(aCondiciones); 
          break; 
      }
      case SELECT_BY_VISITA_MOTIVO: {
          ps = this.selectByVisitaMotivo(aCondiciones); 
          break; 
      }
      case SELECT_BY_GRUPO_MOTIVO: {
          ps = this.selectByGrupoMotivo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOT_ENT_INT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntIntVis "); 
    textSQL.append(" WHERE oid_mot_ent_int = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_ENT_INT, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByGrupoMotivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntVis "); 
	    textSQL.append(" WHERE oid_grupo_visita = ? and oid_motivo = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    GrupoVisita grupo = (GrupoVisita) condiciones.get(GrupoVisita.NICKNAME);
	    MotivoEntIntermedias motEntInt = (MotivoEntIntermedias) condiciones.get(MotivoEntIntermedias.NICKNAME);
	    querySelect.setInt(1, grupo.getOID()); 
	    querySelect.setInt(2, motEntInt.getOID());
	    return querySelect; 
  }

  private PreparedStatement selectByVisitaMotivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntVis "); 
	    textSQL.append(" WHERE oid_visita = ? and oid_motivo = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    MotivoEntIntermedias motEntInt = (MotivoEntIntermedias) condiciones.get(MotivoEntIntermedias.NICKNAME);
	    querySelect.setInt(1, visita.getOID()); 
	    querySelect.setInt(2, motEntInt.getOID());
	    return querySelect; 
  }
  
  private PreparedStatement selectByVisita(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntVis "); 
	    textSQL.append(" WHERE oid_visita = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Visita visita = (Visita) aCondiciones; 
	    querySelect.setInt(1, visita.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntIntVis "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_ent_int oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipMotEntIntVis");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getMotEntIntermedias(
		  Visita visita,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Visita.NICKNAME,
             DBMotEntIntVis.SELECT_BY_VISITA,
             visita,
             new ListObserver(),
             aSesion);
  }
  
  public static MotEntIntVis getMotEntIntVis(
		  Visita visita,
		  MotivoEntIntermedias motivo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Visita.NICKNAME, visita);
	  condiciones.put(MotivoEntIntermedias.NICKNAME, motivo);
	  return (MotEntIntVis) ObjetoLogico.getObjects(MotEntIntVis.NICKNAME,
			  				DBMotEntIntVis.SELECT_BY_VISITA_MOTIVO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static MotEntIntVis getMotEntIntVis(
		  GrupoVisita grupo,
		  MotivoEntIntermedias motivo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(GrupoVisita.NICKNAME, grupo);
	  condiciones.put(MotivoEntIntermedias.NICKNAME, motivo);
	  return (MotEntIntVis) ObjetoLogico.getObjects(MotEntIntVis.NICKNAME,
			  				DBMotEntIntVis.SELECT_BY_GRUPO_MOTIVO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
