package com.srn.erp.pagos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.pagos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBImputacionPagosVarios extends DBObjetoPersistente {

  public static final String OID_IMPU_OP_VARIAS = "oid_impu_op_varias";
  public static final String OID_ANA_IMP = "oid_ana_imp";
  public static final String OID_CCO = "oid_cco";
  public static final String DEBE_MON_PAGO = "debe_mon_pago";
  public static final String HABER_MON_PAGO = "haber_mon_pago";
  public static final String DEBE_MON_LOC = "debe_mon_loc";
  public static final String HABER_MON_LOC = "haber_mon_loc";
  public static final String COMENTARIO = "comentario";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_OP = 100;

  public DBImputacionPagosVarios() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_IMPU_OP_VARIAS = 1;
    final int OID_ANA_IMP = 2;
    final int OID_CCO = 3;
    final int DEBE_MON_PAGO = 4;
    final int HABER_MON_PAGO = 5;
    final int DEBE_MON_LOC = 6;
    final int HABER_MON_LOC = 7;
    final int COMENTARIO = 8;
    final int ACTIVO = 9;

    ImputacionPagosVarios pers = (ImputacionPagosVarios) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opImpuOPVarios "+
                     " ( "+
                      "OID_IMPU_OP_VARIAS,"+
                      "OID_ANA_IMP,"+
                      "OID_CCO,"+
                      "DEBE_MON_PAGO,"+
                      "HABER_MON_PAGO,"+
                      "DEBE_MON_LOC,"+
                      "HABER_MON_LOC,"+
                      "COMENTARIO,"+
                      "ACTIVO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_IMPU_OP_VARIAS,pers.getOID());
    qInsert.setInt(OID_ANA_IMP,pers.getCuenta_imputable().getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    if (pers.getDebe_mon_pago()!=null) 
      qInsert.setDouble(DEBE_MON_PAGO,pers.getDebe_mon_pago().doubleValue());
    else
      qInsert.setNull(DEBE_MON_PAGO,java.sql.Types.DOUBLE);
    if (pers.getHaber_mon_pago()!=null) 
      qInsert.setDouble(HABER_MON_PAGO,pers.getHaber_mon_pago().doubleValue());
    else
      qInsert.setNull(HABER_MON_PAGO,java.sql.Types.DOUBLE);
    if (pers.getDebe_mon_loc()!=null) 
      qInsert.setDouble(DEBE_MON_LOC,pers.getDebe_mon_loc().doubleValue());
    else
      qInsert.setNull(DEBE_MON_LOC,java.sql.Types.DOUBLE);
    if (pers.getHaber_mon_loc()!=null) 
      qInsert.setDouble(HABER_MON_LOC,pers.getHaber_mon_loc().doubleValue());
    else
      qInsert.setNull(HABER_MON_LOC,java.sql.Types.DOUBLE);
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANA_IMP = 1;
    final int OID_CCO = 2;
    final int DEBE_MON_PAGO = 3;
    final int HABER_MON_PAGO = 4;
    final int DEBE_MON_LOC = 5;
    final int HABER_MON_LOC = 6;
    final int COMENTARIO = 7;
    final int ACTIVO = 8;
    final int OID_IMPU_OP_VARIAS = 9;

    ImputacionPagosVarios pers = (ImputacionPagosVarios) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opImpuOPVarios set "+
              "oid_ana_imp=?"+ 
              ",oid_cco=?"+ 
              ",debe_mon_pago=?"+ 
              ",haber_mon_pago=?"+ 
              ",debe_mon_loc=?"+ 
              ",haber_mon_loc=?"+ 
              ",comentario=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_impu_op_varias=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_IMPU_OP_VARIAS,pers.getOID());
    qUpdate.setInt(OID_ANA_IMP,pers.getCuenta_imputable().getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    if (pers.getDebe_mon_pago()!=null) 
      qUpdate.setDouble(DEBE_MON_PAGO,pers.getDebe_mon_pago().doubleValue());
    else
      qUpdate.setNull(DEBE_MON_PAGO,java.sql.Types.DOUBLE);
    if (pers.getHaber_mon_pago()!=null) 
      qUpdate.setDouble(HABER_MON_PAGO,pers.getHaber_mon_pago().doubleValue());
    else
      qUpdate.setNull(HABER_MON_PAGO,java.sql.Types.DOUBLE);
    if (pers.getDebe_mon_loc()!=null) 
      qUpdate.setDouble(DEBE_MON_LOC,pers.getDebe_mon_loc().doubleValue());
    else
      qUpdate.setNull(DEBE_MON_LOC,java.sql.Types.DOUBLE);
    if (pers.getHaber_mon_loc()!=null) 
      qUpdate.setDouble(HABER_MON_LOC,pers.getHaber_mon_loc().doubleValue());
    else
      qUpdate.setNull(HABER_MON_LOC,java.sql.Types.DOUBLE);
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_IMPU_OP_VARIAS = 1; 
    ImputacionPagosVarios pers = (ImputacionPagosVarios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opImpuOPVarios "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_impu_op_varias=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_IMPU_OP_VARIAS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_IMPU_OP_VARIAS = 1; 
    ImputacionPagosVarios pers = (ImputacionPagosVarios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opImpuOPVarios "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_impu_op_varias=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_IMPU_OP_VARIAS, pers.getOID()); 
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
      case SELECT_BY_OP: {
          ps = this.selectByOP(aCondiciones); 
          break; 
      }
    } 
    return ps;
  }
  
  private PreparedStatement selectByOP(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  opImpuOPVarios "); 
	    textSQL.append(" WHERE oid_cco = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ComproOrdenPagoCab comproOP = (ComproOrdenPagoCab) aCondiciones;
	    querySelect.setInt(1, comproOP.getOID()); 
	    return querySelect; 
  }
  

  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_IMPU_OP_VARIAS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opImpuOPVarios "); 
    textSQL.append(" WHERE oid_impu_op_varias = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_IMPU_OP_VARIAS, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opImpuOPVarios "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_impu_op_varias oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opImpuOPVarios");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getImputacionesOPVarias(ComproOrdenPagoCab comproOP,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ImputacionPagosVarios.NICKNAME,
             DBImputacionPagosVarios.SELECT_BY_OP,
             comproOP,
             new ListObserver(),
             aSesion);
  }
  
  
} 
