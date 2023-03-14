package com.srn.erp.bancos.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.bancos.bm.ConciliacionDet;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConciliacionDet extends DBObjetoPersistente {

  public static final String OID_CONC_BCO_DET = "oid_conc_bco_det";
  public static final String OID_CONCI_BCO = "oid_conci_bco";
  public static final String OID_MOV_CTA_BCO = "oid_mov_cta_bco";
  public static final String CONCILIADO = "conciliado";
  public static final String FECHA = "fecha";
  public static final String A_CONCILIAR = "a_conciliar";
  public static final String TIPO_MOV = "tipo_mov";
  public static final String OID_AI = "oid_ai";
  public static final String NRO_VALOR = "nro_valor";
  public static final String NUEVO_MOV = "nuevo_mov";
  public static final String EXTRACTO = "extracto";
  public static final String OBSERVACION = "observacion";
  
  public static final int SELECT_BY_CONCILIACION_CAB = 100;

  public DBConciliacionDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_BCO_DET = 1;
    final int OID_CONCI_BCO = 2;
    final int OID_MOV_CTA_BCO = 3;
    final int CONCILIADO = 4;
    final int FECHA = 5;
    final int A_CONCILIAR = 6;
    final int TIPO_MOV = 7;
    final int OID_AI = 8;
    final int NRO_VALOR = 9;
    final int NUEVO_MOV = 10;
    final int EXTRACTO = 11;
    final int OBSERVACION = 12;

    ConciliacionDet pers = (ConciliacionDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaConciBcoDet "+
                     " ( "+
                      "OID_CONC_BCO_DET,"+
                      "OID_CONCI_BCO,"+
                      "OID_MOV_CTA_BCO,"+
                      "CONCILIADO,"+
                      "FECHA,"+
                      "A_CONCILIAR,"+
                      "TIPO_MOV,"+
                      "OID_AI,"+
                      "NRO_VALOR,"+
                      "NUEVO_MOV,"+
                      "EXTRACTO,"+
                      "OBSERVACION)"+ 
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
    qInsert.setInt(OID_CONC_BCO_DET,pers.getOID());
    qInsert.setInt(OID_CONCI_BCO,pers.getConciliacion_cab().getOID());
    if (pers.getMovimiento_cuenta()!=null)
    	qInsert.setInt(OID_MOV_CTA_BCO,pers.getMovimiento_cuenta().getOID());
    else
    	qInsert.setNull(OID_MOV_CTA_BCO,java.sql.Types.INTEGER);
    qInsert.setBoolean(CONCILIADO,pers.isConciliado().booleanValue());
    if (pers.getFecha()!=null)
    	qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    else
    	qInsert.setNull(FECHA,java.sql.Types.DATE);
    qInsert.setDouble(A_CONCILIAR,pers.getA_conciliar().doubleValue());
    qInsert.setString(TIPO_MOV,pers.getTipo_mov());
    if (pers.getCuenta_contable()!=null)
    	qInsert.setInt(OID_AI,pers.getCuenta_contable().getOID());
    else
    	qInsert.setNull(OID_AI,java.sql.Types.INTEGER);
    if (pers.getNro_valor()!=null)
    	qInsert.setDouble(NRO_VALOR,pers.getNro_valor().doubleValue());
    else
    	qInsert.setNull(NRO_VALOR,java.sql.Types.DOUBLE);
    qInsert.setBoolean(NUEVO_MOV,pers.isNuevo_mov().booleanValue());
    qInsert.setDouble(EXTRACTO,pers.getExtracto().doubleValue());
    qInsert.setString(OBSERVACION,pers.getObservacion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONCI_BCO = 1;
    final int OID_MOV_CTA_BCO = 2;
    final int CONCILIADO = 3;
    final int FECHA = 4;
    final int A_CONCILIAR = 5;
    final int TIPO_MOV = 6;
    final int OID_AI = 7;
    final int NRO_VALOR = 8;
    final int NUEVO_MOV = 9;
    final int EXTRACTO = 10;
    final int OBSERVACION = 11;
    final int OID_CONC_BCO_DET = 12;

    ConciliacionDet pers = (ConciliacionDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaConciBcoDet set "+
              "oid_conci_bco=?"+ 
              ",oid_mov_cta_bco=?"+ 
              ",conciliado=?"+ 
              ",fecha=?"+ 
              ",a_conciliar=?"+ 
              ",tipo_mov=?"+ 
              ",oid_ai=?"+ 
              ",nro_valor=?"+ 
              ",nuevo_mov=?"+ 
              ",extracto=?"+ 
              ",observacion=?"+ 
                 " where " +
                 " oid_conc_bco_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_BCO_DET,pers.getOID());
    qUpdate.setInt(OID_CONCI_BCO,pers.getConciliacion_cab().getOID());
    
    if (pers.getMovimiento_cuenta()!=null)
    	qUpdate.setInt(OID_MOV_CTA_BCO,pers.getMovimiento_cuenta().getOID());
    else
    	qUpdate.setNull(OID_MOV_CTA_BCO,java.sql.Types.INTEGER);    
    
    qUpdate.setBoolean(CONCILIADO,pers.isConciliado().booleanValue());
    
    if (pers.getFecha()!=null)
    	qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    else
    	qUpdate.setNull(FECHA,java.sql.Types.DATE);
    
    qUpdate.setDouble(A_CONCILIAR,pers.getA_conciliar().doubleValue());
    qUpdate.setString(TIPO_MOV,pers.getTipo_mov());
    
    if (pers.getCuenta_contable()!=null)
    	qUpdate.setInt(OID_AI,pers.getCuenta_contable().getOID());
    else
    	qUpdate.setNull(OID_AI,java.sql.Types.INTEGER);    
    
    if (pers.getNro_valor()!=null)
    	qUpdate.setDouble(NRO_VALOR,pers.getNro_valor().doubleValue());
    else
    	qUpdate.setNull(NRO_VALOR,java.sql.Types.DOUBLE);    
    qUpdate.setBoolean(NUEVO_MOV,pers.isNuevo_mov().booleanValue());
    qUpdate.setDouble(EXTRACTO,pers.getExtracto().doubleValue());
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_BCO_DET = 1; 
    ConciliacionDet pers = (ConciliacionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConciBcoDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conc_bco_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_BCO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_BCO_DET = 1; 
    ConciliacionDet pers = (ConciliacionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConciBcoDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conc_bco_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_BCO_DET, pers.getOID()); 
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
      case SELECT_BY_CONCILIACION_CAB: {
          ps = this.selectByConciliacionCab(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONC_BCO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConciBcoDet "); 
    textSQL.append(" WHERE oid_conc_bco_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONC_BCO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConciliacionCab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaConciBcoDet "); 
	    textSQL.append(" WHERE oid_conci_bco = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    ConciliacionCab conciliacion = (ConciliacionCab) aCondiciones;
	    querySelect.setInt(1, conciliacion.getOID()); 
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConciBcoDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_bco_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaConciBcoDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConciliacionesDet(ConciliacionCab conciliacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConciliacionDet.NICKNAME,
             DBConciliacionDet.SELECT_BY_CONCILIACION_CAB,
             conciliacion,
             new ListObserver(),
             aSesion);
  }
  
  
} 
