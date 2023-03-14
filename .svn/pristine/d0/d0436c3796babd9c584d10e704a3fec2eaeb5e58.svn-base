package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAcuerdoLPCondPago extends DBObjetoPersistente {

  public static final String OID_ACU_LP_DTOS = "oid_acu_lp_dtos";
  public static final String OID_ACUERDO_LP = "oid_acuerdo_lp";
  public static final String OID_COND_COMPRA = "oid_cond_compra";
  public static final String DTO_1 = "dto_1";
  public static final String DTO_2 = "dto_2";
  public static final String DTO_3 = "dto_3";
  public static final String DTO_4 = "dto_4";
  public static final String DTO_5 = "dto_5";
  public static final String EN_CASCADA = "en_cascada";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ACUERDO_LP = 100;

  public DBAcuerdoLPCondPago() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ACU_LP_DTOS = 1;
    final int OID_ACUERDO_LP = 2;
    final int OID_COND_COMPRA = 3;
    final int DTO_1 = 4;
    final int DTO_2 = 5;
    final int DTO_3 = 6;
    final int DTO_4 = 7;
    final int DTO_5 = 8;
    final int EN_CASCADA = 9;
    final int ACTIVO = 10;

    AcuerdoLPCondPago pers = (AcuerdoLPCondPago) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAcuLPDtos "+
                     " ( "+
                      "OID_ACU_LP_DTOS,"+
                      "OID_ACUERDO_LP,"+
                      "OID_COND_COMPRA,"+
                      "DTO_1,"+
                      "DTO_2,"+
                      "DTO_3,"+
                      "DTO_4,"+
                      "DTO_5,"+
                      "EN_CASCADA,"+
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ACU_LP_DTOS,pers.getOID());
    qInsert.setInt(OID_ACUERDO_LP,pers.getAcuerdolp().getOID());
    qInsert.setInt(OID_COND_COMPRA,pers.getCondicion_pago().getOID());
    qInsert.setDouble(DTO_1,pers.getDto_1().doubleValue());
    qInsert.setDouble(DTO_2,pers.getDto_2().doubleValue());
    qInsert.setDouble(DTO_3,pers.getDto_3().doubleValue());
    qInsert.setDouble(DTO_4,pers.getDto_4().doubleValue());
    qInsert.setDouble(DTO_5,pers.getDto_5().doubleValue());
    qInsert.setBoolean(EN_CASCADA,pers.isEn_cascada().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ACUERDO_LP = 1;
    final int OID_COND_COMPRA = 2;
    final int DTO_1 = 3;
    final int DTO_2 = 4;
    final int DTO_3 = 5;
    final int DTO_4 = 6;
    final int DTO_5 = 7;
    final int EN_CASCADA = 8;
    final int ACTIVO = 9;
    final int OID_ACU_LP_DTOS = 10;

    AcuerdoLPCondPago pers = (AcuerdoLPCondPago) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAcuLPDtos set "+
              "oid_acuerdo_lp=?"+ 
              ",oid_cond_compra=?"+ 
              ",dto_1=?"+ 
              ",dto_2=?"+ 
              ",dto_3=?"+ 
              ",dto_4=?"+ 
              ",dto_5=?"+ 
              ",en_cascada=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_acu_lp_dtos=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACU_LP_DTOS,pers.getOID());
    qUpdate.setInt(OID_ACUERDO_LP,pers.getAcuerdolp().getOID());
    qUpdate.setInt(OID_COND_COMPRA,pers.getCondicion_pago().getOID());
    qUpdate.setDouble(DTO_1,pers.getDto_1().doubleValue());
    qUpdate.setDouble(DTO_2,pers.getDto_2().doubleValue());
    qUpdate.setDouble(DTO_3,pers.getDto_3().doubleValue());
    qUpdate.setDouble(DTO_4,pers.getDto_4().doubleValue());
    qUpdate.setDouble(DTO_5,pers.getDto_5().doubleValue());
    qUpdate.setBoolean(EN_CASCADA,pers.isEn_cascada().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ACU_LP_DTOS = 1; 
    AcuerdoLPCondPago pers = (AcuerdoLPCondPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cpAcuLPDtos "+
                     " where " + 
                     " oid_acu_lp_dtos=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACU_LP_DTOS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ACU_LP_DTOS = 1; 
    AcuerdoLPCondPago pers = (AcuerdoLPCondPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAcuLPDtos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_acu_lp_dtos=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACU_LP_DTOS, pers.getOID()); 
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
      case SELECT_BY_ACUERDO_LP: {
        ps = this.selectByAcuerdoLP(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ACU_LP_DTOS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAcuLPDtos "); 
    textSQL.append(" WHERE oid_acu_lp_dtos = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ACU_LP_DTOS, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAcuerdoLP(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cpAcuLPDtos "); 
	    textSQL.append(" WHERE oid_acuerdo_lp = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    AcuerdoLP acuerdoLP = (AcuerdoLP) aCondiciones; 
	    querySelect.setInt(1, acuerdoLP.getOID()); 
	    return querySelect; 	  
  }
  
  public static List getAcuerdosLPCondPago(AcuerdoLP acuerdoLP,
          								   ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AcuerdoLPCondPago.NICKNAME,
             DBAcuerdoLPCondPago.SELECT_BY_ACUERDO_LP,
             acuerdoLP,
             new ListObserver(),
             aSesion);
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAcuLPDtos "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_acu_lp_dtos oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAcuLPDtos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
