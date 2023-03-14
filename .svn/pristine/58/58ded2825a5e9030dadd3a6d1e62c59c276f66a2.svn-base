package com.srn.erp.presupuesto.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.presupuesto.bm.CicloPresupuestal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCicloPresupuestal extends DBObjetoPersistente {

  public static final String OID_CICLO = "oid_ciclo";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OBSERVACION = "observacion";
  public static final String NRO_ORDEN_VISUAL = "nro_orden_visual";
  public static final String ACTIVO = "activo";
  public static final String OID_TIPO_CICLO = "oid_tipo_ciclo";
  public static final String FECHA_INICIO_PLANIF = "fec_ini_planif";
  
  public static final int SELECT_CICLOS_ACT_ORD_BY_ORDEN_Y_OID = 100;

  public DBCicloPresupuestal() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CICLO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OBSERVACION = 4;
    final int NRO_ORDEN_VISUAL = 5;
    final int ACTIVO = 6;
    final int OID_TIPO_CICLO = 7;
    final int FECHA_INICIO_PLANIF = 8;

    CicloPresupuestal pers = (CicloPresupuestal) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plCiclo "+
                     " ( "+
                      "OID_CICLO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OBSERVACION,"+
                      "NRO_ORDEN_VISUAL,"+
                      "ACTIVO,"+
                      "OID_TIPO_CICLO,FEC_INI_PLANIF)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CICLO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(OBSERVACION,pers.getObservacion());
    if (pers.getNro_orden_visual()!=null)
    	qInsert.setInt(NRO_ORDEN_VISUAL,pers.getNro_orden_visual().intValue());
    else
    	qInsert.setNull(NRO_ORDEN_VISUAL,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_TIPO_CICLO,pers.getTipo_ciclo().getOID());
    qInsert.setDate(FECHA_INICIO_PLANIF, new Date(pers.getFechaInicioPlanif().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OBSERVACION = 3;
    final int NRO_ORDEN_VISUAL = 4;
    final int ACTIVO = 5;
    final int OID_TIPO_CICLO = 6;
    final int FECHA_INICIO_PLANIF = 7;
    final int OID_CICLO = 8;

    CicloPresupuestal pers = (CicloPresupuestal) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plCiclo set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",observacion=?"+ 
              ",nro_orden_visual=?"+ 
              ",activo=?"+ 
              ",oid_tipo_ciclo=?"+
              ",fec_ini_planif=?"+
                 " where " +
                 " oid_ciclo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CICLO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    if (pers.getNro_orden_visual()!=null)
    	qUpdate.setInt(NRO_ORDEN_VISUAL,pers.getNro_orden_visual().intValue());
    else
    	qUpdate.setNull(NRO_ORDEN_VISUAL,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_TIPO_CICLO,pers.getTipo_ciclo().getOID());
    qUpdate.setDate(FECHA_INICIO_PLANIF, new Date(pers.getFechaInicioPlanif().getTime()));
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CICLO = 1; 
    CicloPresupuestal pers = (CicloPresupuestal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plCiclo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_ciclo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CICLO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CICLO = 1; 
    CicloPresupuestal pers = (CicloPresupuestal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plCiclo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_ciclo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CICLO, pers.getOID()); 
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
      case SELECT_CICLOS_ACT_ORD_BY_ORDEN_Y_OID: {
        ps = this.selectByCiclosActivos(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CICLO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCiclo "); 
    textSQL.append(" WHERE oid_ciclo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CICLO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCiclosActivos(Object aCondiciones) throws BaseException, SQLException { 

  	 final int CODIGO = 1; 

  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  plCiclo "); 
  	 textSQL.append(" WHERE activo = 1 order by nro_orden_visual, oid_ciclo desc ");
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 return querySelect;
  	 
  }

  		
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCiclo "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ciclo oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plCiclo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCiclosActivosOrdenadasParaPresentar(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CicloPresupuestal.NICKNAME,
        DBCicloPresupuestal.SELECT_CICLOS_ACT_ORD_BY_ORDEN_Y_OID,
        null,
        new ListObserver(),
        aSesion);
  	
  }
  
  
} 
