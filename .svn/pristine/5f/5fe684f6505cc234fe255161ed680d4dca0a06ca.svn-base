package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBMotivoEntradasInterRota extends DBObjetoPersistente {

  public static final String OID_MOT_ROTA = "oid_mot_rota";
  public static final String OID_ROTA = "oid_rota";
  public static final String OID_MOTIVO = "oid_motivo";
  public static final String HORARIO_DESDE = "horario_desde";
  public static final String HORARIO_HASTA = "horario_hasta";
  public static final String ACTIVO = "activo";
  public static final String ASIGNACION = "asignacion";
  
  public static final int SELECT_BY_ROTA  = 100;
  public static final int SELECT_BY_ROTA_ASIGFIJA = 101;
  public static final int SELECT_BY_ROTA_LEGAJO = 102;
  public static final int SELECT_BY_ROTA_VISITA = 103;

  public DBMotivoEntradasInterRota() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_ROTA = 1;
    final int OID_ROTA = 2;
    final int OID_MOTIVO = 3;
    final int HORARIO_DESDE = 4;
    final int HORARIO_HASTA = 5;
    final int ACTIVO = 6;
    final int ASIGNACION = 7;

    MotivoEntradasInterRota pers = (MotivoEntradasInterRota) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotEntIntRota "+
                     " ( "+
                      "OID_MOT_ROTA,"+
                      "OID_ROTA,"+
                      "OID_MOTIVO,"+
                      "HORARIO_DESDE,"+
                      "HORARIO_HASTA,"+
                      "ACTIVO,ASIGNACION)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_ROTA,pers.getOID());
    qInsert.setInt(OID_ROTA,pers.getRota().getOID());
    qInsert.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qInsert.setString(HORARIO_DESDE,pers.getHorario_desde());
    qInsert.setString(HORARIO_HASTA,pers.getHorario_hasta());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(ASIGNACION, pers.getAsignacion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROTA = 1;
    final int OID_MOTIVO = 2;
    final int HORARIO_DESDE = 3;
    final int HORARIO_HASTA = 4;
    final int ACTIVO = 5;
    final int ASIGNACION = 6;
    final int OID_MOT_ROTA = 7;

    MotivoEntradasInterRota pers = (MotivoEntradasInterRota) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotEntIntRota set "+
              "oid_rota=?"+ 
              ",oid_motivo=?"+ 
              ",horario_desde=?"+ 
              ",horario_hasta=?"+ 
              ",activo=?"+
              ",asignacion=?"+
                 " where " +
                 " oid_mot_rota=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ROTA,pers.getOID());
    qUpdate.setInt(OID_ROTA,pers.getRota().getOID());
    qUpdate.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qUpdate.setString(HORARIO_DESDE,pers.getHorario_desde());
    qUpdate.setString(HORARIO_HASTA,pers.getHorario_hasta());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(ASIGNACION, pers.getAsignacion());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_ROTA = 1; 
    MotivoEntradasInterRota pers = (MotivoEntradasInterRota) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntIntRota "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ROTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_ROTA = 1; 
    MotivoEntradasInterRota pers = (MotivoEntradasInterRota) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntIntRota "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_ROTA, pers.getOID()); 
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
      case SELECT_BY_ROTA: {
          ps = this.selectByRota(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_ROTA_ASIGFIJA: {
          ps = this.selectByRotaAsigFija(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_ROTA_LEGAJO: {
          ps = this.selectByRotaLegajo(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_ROTA_VISITA: {
          ps = this.selectByRotaVisita(aCondiciones); 
          break;    	  
      }
      
      
    
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOT_ROTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntIntRota "); 
    textSQL.append(" WHERE oid_mot_rota = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_ROTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRotaVisita(Object aCondiciones) throws BaseException, SQLException {
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" SELECT * FROM  cipMotEntIntRota WHERE oid_rota = ? and activo=1 and asignacion = 'SEG_MOT' and ");
	    textSQL.append("  oid_motivo in ( ");
	    textSQL.append("	select oid_motivo from cipMotEntIntVis where activo=1 and oid_visita = ? ");
	    textSQL.append("	union all ");
	    textSQL.append("	select oid_motivo from cipMotEntIntVis where activo=1 and oid_grupo_visita = ? ");
	    textSQL.append(") "); 
	    textSQL.append(" union ");
	    textSQL.append(" SELECT * FROM  cipMotEntIntRota WHERE oid_rota = ? and activo=1 and asignacion = 'FIJA' ");	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    
	    querySelect.setInt(1, rota.getOID());
	    querySelect.setInt(2, visita.getOID());
	    int oidGrupoVisita = -1;
	    if (visita.getGrupoVisita()!=null)
	    	oidGrupoVisita = visita.getGrupoVisita().getOID(); 
	    querySelect.setInt(3, oidGrupoVisita);
	    querySelect.setInt(4, rota.getOID());
	    
	    return querySelect; 
    
  }

  private PreparedStatement selectByRotaLegajo(Object aCondiciones) throws BaseException, SQLException { 
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntRota "); 
	    textSQL.append(" WHERE oid_rota = ? and activo=1 and asignacion = '"+MotivoEntradasInterRota.ASIG_SEG_MOT+"' and ");
	    textSQL.append(" oid_motivo in ");
	    textSQL.append(" ( ");
	    textSQL.append("    select oid_motivo from cipMotEntIntLeg where oid_legajo=? and activo = 1 ");
	    textSQL.append("    union all ");
	    textSQL.append("    select b.oid_motivo from suLegajo a , cipMotEntIntEst b where a.oid_legajo = ? and a.oid_estado = b.oid_estado and a.activo = 1 and b.activo = 1 ");
	    textSQL.append("    union all ");
	    textSQL.append("    select a.oid_motivo from cipMotEntIntCLeg a , suLegajo b where b.activo = 1 and a.activo=1 and b.oid_legajo = ?  ");
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
	    textSQL.append(" union ");
	    textSQL.append("SELECT * FROM  cipMotEntIntRota "); 
	    textSQL.append(" WHERE oid_rota = ? and activo=1 and asignacion = '"+MotivoEntradasInterRota.ASIG_FIJA+"'");
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    
	    querySelect.setInt(1, rota.getOID());
	    querySelect.setInt(2, legajo.getOID()); 
	    querySelect.setInt(3, legajo.getOID());
	    querySelect.setInt(4, legajo.getOID());
	    querySelect.setInt(5, rota.getOID());
	    
	    return querySelect; 
  }  
  
  private PreparedStatement selectByRotaAsigFija(Object aCondiciones) throws BaseException, SQLException {
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntRota "); 
	    textSQL.append(" WHERE oid_rota = ? and activo=1 and asignacion = '"+MotivoEntradasInterRota.ASIG_FIJA+"'");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Rota rota = (Rota) aCondiciones; 
	    querySelect.setInt(1, rota.getOID()); 
	    return querySelect; 
	  
	  
  }  
  
    
  
  private PreparedStatement selectByRota(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntIntRota "); 
	    textSQL.append(" WHERE oid_rota = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Rota rota = (Rota) aCondiciones; 
	    querySelect.setInt(1, rota.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntIntRota "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_rota oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipMotEntIntRota");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getMotEntInterRotas(
		  Rota rota,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotivoEntradasInterRota.NICKNAME,
             DBMotivoEntradasInterRota.SELECT_BY_ROTA,
             rota,
             new ListObserver(),
             aSesion);
  }
  
  public static List getMotEntInterRotasAsigFij(
		  Rota rota,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotivoEntradasInterRota.NICKNAME,
             DBMotivoEntradasInterRota.SELECT_BY_ROTA_ASIGFIJA,
             rota,
             new ListObserver(),
             aSesion);
  }
  
  public static List getMotEntInterSegunLegajo(
		  Rota rota,
		  Legajo  legajo,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Legajo.NICKNAME, legajo);
	  condiciones.put(Rota.NICKNAME, rota);
	  return (List) ObjetoLogico.getObjects(MotivoEntradasInterRota.NICKNAME,
             DBMotivoEntradasInterRota.SELECT_BY_ROTA_LEGAJO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getMotEntInterSegunVisita(
		  Rota rota,
		  Visita  visita,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Visita.NICKNAME, visita);
	  condiciones.put(Rota.NICKNAME, rota);
	  return (List) ObjetoLogico.getObjects(MotivoEntradasInterRota.NICKNAME,
             DBMotivoEntradasInterRota.SELECT_BY_ROTA_VISITA,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  
  
} 
