package com.srn.erp.produccion.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.produccion.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBOperAlterFab extends DBObjetoPersistente {

  public static final String OID_OPER_FABRI = "oid_oper_fabri";
  public static final String OID_ALTER_FABRI = "oid_alter_fabri";
  public static final String OID_PROCESO = "oid_proceso";
  public static final String OID_OPERACION = "oid_operacion";
  public static final String OID_TIPO_ESTACION = "oid_tipo_estacion";
  public static final String TIEMPO_STD = "tiempo_std";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String OID_REL = "oid_rel";
  public static final String OID_REL_PADRE = "oid_rel_padre";
  public static final String ACTIVO = "activo";
  public static final String OBSERVACION = "observacion";
  public static final String OID_UM_TIEMPO = "oid_um_tiempo";
  
  public static final int SELECT_BY_ALTER_FAB = 100;

  public DBOperAlterFab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPER_FABRI = 1;
    final int OID_ALTER_FABRI = 2;
    final int OID_PROCESO = 3;
    final int OID_OPERACION = 4;
    final int OID_TIPO_ESTACION = 5;
    final int TIEMPO_STD = 6;
    final int COMPORTAMIENTO = 7;
    final int OID_REL = 8;
    final int OID_REL_PADRE = 9;
    final int ACTIVO = 10;
    final int OBSERVACION = 11;
    final int OID_UM_TIEMPO = 12;

    OperAlterFab pers = (OperAlterFab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into prOperAlterFabri "+
                     " ( "+
                      "OID_OPER_FABRI,"+
                      "OID_ALTER_FABRI,"+
                      "OID_PROCESO,"+
                      "OID_OPERACION,"+
                      "OID_TIPO_ESTACION,"+
                      "TIEMPO_STD,"+
                      "COMPORTAMIENTO,"+
                      "OID_REL,"+
                      "OID_REL_PADRE,"+
                      "ACTIVO,"+
                      "OBSERVACION,OID_UM_TIEMPO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_OPER_FABRI,pers.getOID());
    qInsert.setInt(OID_ALTER_FABRI,pers.getAlternativa_fabricacion().getOID());
    qInsert.setInt(OID_PROCESO,pers.getProceso().getOID());
    qInsert.setInt(OID_OPERACION,pers.getOperacion().getOID());
    qInsert.setInt(OID_TIPO_ESTACION,pers.getTipo_estacion().getOID());
    qInsert.setDouble(TIEMPO_STD,pers.getTiempo_std().doubleValue());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setString(OID_REL,pers.getOid_rel());
    qInsert.setString(OID_REL_PADRE,pers.getOid_rel_padre());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(OBSERVACION,pers.getObservacion());
    qInsert.setInt(OID_UM_TIEMPO, pers.getUMTiempoProduccion().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ALTER_FABRI = 1;
    final int OID_PROCESO = 2;
    final int OID_OPERACION = 3;
    final int OID_TIPO_ESTACION = 4;
    final int TIEMPO_STD = 5;
    final int COMPORTAMIENTO = 6;
    final int OID_REL = 7;
    final int OID_REL_PADRE = 8;
    final int ACTIVO = 9;
    final int OBSERVACION = 10;
    final int OID_UM_TIEMPO = 11;
    final int OID_OPER_FABRI = 12;

    OperAlterFab pers = (OperAlterFab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update prOperAlterFabri set "+
              "oid_alter_fabri=?"+ 
              ",oid_proceso=?"+ 
              ",oid_operacion=?"+ 
              ",oid_tipo_estacion=?"+ 
              ",tiempo_std=?"+ 
              ",comportamiento=?"+ 
              ",oid_rel=?"+ 
              ",oid_rel_padre=?"+ 
              ",activo=?"+ 
              ",observacion=? , oid_um_tiempo=? "+ 
                 " where " +
                 " oid_oper_fabri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_FABRI,pers.getOID());
    qUpdate.setInt(OID_ALTER_FABRI,pers.getAlternativa_fabricacion().getOID());
    qUpdate.setInt(OID_PROCESO,pers.getProceso().getOID());
    qUpdate.setInt(OID_OPERACION,pers.getOperacion().getOID());
    qUpdate.setInt(OID_TIPO_ESTACION,pers.getTipo_estacion().getOID());
    qUpdate.setDouble(TIEMPO_STD,pers.getTiempo_std().doubleValue());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setString(OID_REL,pers.getOid_rel());
    qUpdate.setString(OID_REL_PADRE,pers.getOid_rel_padre());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    qUpdate.setInt(OID_UM_TIEMPO, pers.getUMTiempoProduccion().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPER_FABRI = 1; 
    OperAlterFab pers = (OperAlterFab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prOperAlterFabri "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_oper_fabri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_FABRI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPER_FABRI = 1; 
    OperAlterFab pers = (OperAlterFab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prOperAlterFabri "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_oper_fabri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_FABRI, pers.getOID()); 
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
      case SELECT_BY_ALTER_FAB: {
          ps = this.selectByAlternativaFabricacion(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_OPER_FABRI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prOperAlterFabri "); 
    textSQL.append(" WHERE oid_oper_fabri = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OPER_FABRI, oid); 
    return querySelect; 
  }

  
  private PreparedStatement selectByAlternativaFabricacion(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  prOperAlterFabri "); 
	    textSQL.append(" WHERE oid_alter_fabri = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    AlternativaFabricacion alternativa = (AlternativaFabricacion) aCondiciones; 
	    querySelect.setInt(1, alternativa.getOID()); 
	    return querySelect; 
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prOperAlterFabri "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oper_fabri oid, codigo,  descripcion ,activo ");
    textSQL.append(" from prOperAlterFabri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getOperAltFab(AlternativaFabricacion alternativa,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(OperAlterFab.NICKNAME,
             DBOperAlterFab.SELECT_BY_ALTER_FAB,
             alternativa,
             new ListObserver(),
             aSesion);
  }
  
  
} 
