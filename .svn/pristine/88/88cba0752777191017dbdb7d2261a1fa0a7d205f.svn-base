package com.srn.erp.turnos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBTurnoPlantillaHorDet extends DBObjetoPersistente {

  public static final String OID_PLANT_HOR_DET = "oid_plant_hor_det";
  public static final String OID_PLANT_HOR = "oid_plant_hor";
  public static final String HORARIO = "horario";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PLANT_HOR_CAB = 100;

  public DBTurnoPlantillaHorDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PLANT_HOR_DET = 1;
    final int OID_PLANT_HOR = 2;
    final int HORARIO = 3;
    final int ACTIVO = 4;

    TurnoPlantillaHorDet pers = (TurnoPlantillaHorDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuPlanHorDet "+
                     " ( "+
                      "OID_PLANT_HOR_DET,"+
                      "OID_PLANT_HOR,"+
                      "HORARIO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PLANT_HOR_DET,pers.getOID());
    qInsert.setInt(OID_PLANT_HOR,pers.getPlantilla_horario().getOID());
    qInsert.setString(HORARIO,pers.getHorario());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PLANT_HOR = 1;
    final int HORARIO = 2;
    final int ACTIVO = 3;
    final int OID_PLANT_HOR_DET = 4;

    TurnoPlantillaHorDet pers = (TurnoPlantillaHorDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuPlanHorDet set "+
              "oid_plant_hor=?"+ 
              ",horario=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_plant_hor_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PLANT_HOR_DET,pers.getOID());
    qUpdate.setInt(OID_PLANT_HOR,pers.getPlantilla_horario().getOID());
    qUpdate.setString(HORARIO,pers.getHorario());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PLANT_HOR_DET = 1; 
    TurnoPlantillaHorDet pers = (TurnoPlantillaHorDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from tuPlanHorDet "+
                     " where " + 
                     " oid_plant_hor_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PLANT_HOR_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PLANT_HOR_DET = 1; 
    TurnoPlantillaHorDet pers = (TurnoPlantillaHorDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuPlanHorDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_plant_hor_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PLANT_HOR_DET, pers.getOID()); 
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
      case SELECT_BY_PLANT_HOR_CAB: {
          ps = this.selectByPlantHorCab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PLANT_HOR_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuPlanHorDet "); 
    textSQL.append(" WHERE oid_plant_hor_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PLANT_HOR_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPlantHorCab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuPlanHorDet "); 
	    textSQL.append(" WHERE oid_plant_hor = ? order by horario");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    TurnoPlantillaHorCab plantillaCab = (TurnoPlantillaHorCab) aCondiciones; 
	    querySelect.setInt(1, plantillaCab.getOID()); 
	    return querySelect;
	    
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuPlanHorDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_plant_hor_det oid, codigo, oid_plant_hor descripcion ,activo ");
    textSQL.append(" from tuPlanHorDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getPlantillasHorDet(TurnoPlantillaHorCab plantillaCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(TurnoPlantillaHorDet.NICKNAME,
             DBTurnoPlantillaHorDet.SELECT_BY_PLANT_HOR_CAB,
             plantillaCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
