package com.srn.erp.bancos.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.BoletaDepositoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBBoletaDepositoDet extends DBObjetoPersistente {

  public static final String OID_BOL_DEP_DET = "oid_bol_dep_det";
  public static final String OID_BOLETA_DEP = "oid_boleta_dep";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String OID_VALOR = "oid_valor";
  public static final String IMPORTE = "importe";
  public static final String OID_CAJA = "oid_caja";
  public static final String IMPO_MON_VALOR = "impo_mon_valor";
  public static final String COTIZACION = "cotizacion";
  
  public static final int SELECT_BY_BOLETA_DEPOSITO = 100;

  public DBBoletaDepositoDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BOL_DEP_DET = 1;
    final int OID_BOLETA_DEP = 2;
    final int OID_TIPO_VALOR = 3;
    final int OID_VALOR = 4;
    final int IMPORTE = 5; 
    final int OID_CAJA = 6;
    final int IMPO_MON_VALOR = 7; 
    final int COTIZACION = 8;

    BoletaDepositoDet pers = (BoletaDepositoDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaBolDepDet "+
                     " ( "+
                      "OID_BOL_DEP_DET,"+
                      "OID_BOLETA_DEP,"+
                      "OID_TIPO_VALOR,"+
                      "OID_VALOR,"+
                      "IMPORTE,"+
                      "OID_CAJA,IMPO_MON_VALOR,COTIZACION)"+ 
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
    qInsert.setInt(OID_BOL_DEP_DET,pers.getOID());
    qInsert.setInt(OID_BOLETA_DEP,pers.getBoleta_deposito().getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    if (pers.getValor()!=null) 
      qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    else
      qInsert.setNull(OID_VALOR,java.sql.Types.INTEGER);
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    qInsert.setDouble(IMPO_MON_VALOR,pers.getImpoMonValor().doubleValue());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BOLETA_DEP = 1;
    final int OID_TIPO_VALOR = 2;
    final int OID_VALOR = 3;
    final int IMPORTE = 4;
    final int OID_CAJA = 5;
    final int IMPO_MON_VALOR = 6;
    final int COTIZACION = 7;
    final int OID_BOL_DEP_DET = 8;
    

    BoletaDepositoDet pers = (BoletaDepositoDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaBolDepDet set "+
              "oid_boleta_dep=?"+ 
              ",oid_tipo_valor=?"+ 
              ",oid_valor=?"+ 
              ",importe=?"+ 
              ",oid_caja=?"+
              ",impo_mon_valor=?"+
              ",cotizacion=?"+
                 " where " +
                 " oid_bol_dep_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BOL_DEP_DET,pers.getOID());
    qUpdate.setInt(OID_BOLETA_DEP,pers.getBoleta_deposito().getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    if (pers.getValor()!=null) 
      qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    else
      qUpdate.setNull(OID_VALOR,java.sql.Types.INTEGER);
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    qUpdate.setDouble(IMPO_MON_VALOR,pers.getImpoMonValor().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BOL_DEP_DET = 1; 
    BoletaDepositoDet pers = (BoletaDepositoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaBolDepDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_bol_dep_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BOL_DEP_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BOL_DEP_DET = 1; 
    BoletaDepositoDet pers = (BoletaDepositoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaBolDepDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_bol_dep_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BOL_DEP_DET, pers.getOID()); 
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
      case SELECT_BY_BOLETA_DEPOSITO: {
        ps = this.selectByBoletaDeposito(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_BOL_DEP_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaBolDepDet "); 
    textSQL.append(" WHERE oid_bol_dep_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_BOL_DEP_DET, oid); 
    return querySelect; 
  }


  private PreparedStatement selectByBoletaDeposito(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaBolDepDet "); 
    textSQL.append(" WHERE oid_boleta_dep = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    BoletaDeposito boletaDeposito = (BoletaDeposito) aCondiciones; 
    querySelect.setInt(1, boletaDeposito.getOID()); 
    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaBolDepDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_bol_dep_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaBolDepDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetallesBolDep(BoletaDeposito boletaDeposito,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(BoletaDepositoDet.NICKNAME,
         DBBoletaDepositoDet.SELECT_BY_BOLETA_DEPOSITO,
         boletaDeposito,
         new ListObserver(),
         aSesion);
  }
  
  
} 
