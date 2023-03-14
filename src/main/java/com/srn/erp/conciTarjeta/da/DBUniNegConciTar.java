package com.srn.erp.conciTarjeta.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBUniNegConciTar extends DBObjetoPersistente {

  public static final String OID_UNI_NEG = "oid_uni_neg";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String ACTIVO = "activo";
  public static final String ACOB_CTA_TARJ = "acob_cta_tarj";
  public static final String ACOB_CTA_TARJ_C1 = "acob_cta_tarj_c1";
  public static final String ACOB_CTA_TARJ_C2 = "acob_cta_tarj_c2";  

  public DBUniNegConciTar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UNI_NEG = 1;
    final int DESCRIPCION = 2;
    final int OID_EMPRESA = 3;
    final int ACTIVO = 4;
    final int ACOB_CTA_TARJ = 5;
    final int ACOB_CTA_TARJ_C1 = 6;
    final int ACOB_CTA_TARJ_C2 = 7;    

    UniNegConciTar pers = (UniNegConciTar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarUniNeg "+
                     " ( "+
                      "OID_UNI_NEG,"+
                      "DESCRIPCION,"+
                      "OID_EMPRESA,"+
                      "ACTIVO,acob_cta_tarj,acob_cta_tarj_c1,acob_cta_tarj_c2)"+ 
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
    qInsert.setInt(OID_UNI_NEG,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCtaTarjetaACobrar()!=null)
    	qInsert.setString(ACOB_CTA_TARJ, pers.getCtaTarjetaACobrar());
    else
    	qInsert.setNull(ACOB_CTA_TARJ, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC1()!=null)
    	qInsert.setString(ACOB_CTA_TARJ_C1, pers.getCtaTarjetaACobrarC1());
    else
    	qInsert.setNull(ACOB_CTA_TARJ_C1, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC2()!=null)
    	qInsert.setString(ACOB_CTA_TARJ_C2, pers.getCtaTarjetaACobrarC2());
    else
    	qInsert.setNull(ACOB_CTA_TARJ_C2, Types.VARCHAR);    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int OID_EMPRESA = 2;
    final int ACTIVO = 3;
    final int ACOB_CTA_TARJ = 4;
    final int ACOB_CTA_TARJ_C1 = 5;
    final int ACOB_CTA_TARJ_C2 = 6;    
    final int OID_UNI_NEG = 7;

    UniNegConciTar pers = (UniNegConciTar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarUniNeg set "+
              "descripcion=?"+ 
              ",oid_empresa=?"+ 
              ",activo=?"+ 
              ",acob_cta_tarj=? "+
              ",acob_cta_tarj_c1=? "+
              ",acob_cta_tarj_c2=? "+              
                 " where " +
                 " oid_uni_neg=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_NEG,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCtaTarjetaACobrar()!=null)
    	qUpdate.setString(ACOB_CTA_TARJ, pers.getCtaTarjetaACobrar());
    else
    	qUpdate.setNull(ACOB_CTA_TARJ, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC1()!=null)
    	qUpdate.setString(ACOB_CTA_TARJ_C1, pers.getCtaTarjetaACobrarC1());
    else
    	qUpdate.setNull(ACOB_CTA_TARJ_C1, Types.VARCHAR);
    
    if (pers.getCtaTarjetaACobrarC2()!=null)
    	qUpdate.setString(ACOB_CTA_TARJ_C2, pers.getCtaTarjetaACobrarC2());
    else
    	qUpdate.setNull(ACOB_CTA_TARJ_C2, Types.VARCHAR);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UNI_NEG = 1; 
    UniNegConciTar pers = (UniNegConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarUniNeg "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_uni_neg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_NEG, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UNI_NEG = 1; 
    UniNegConciTar pers = (UniNegConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarUniNeg "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_uni_neg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_NEG, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
        ps = this.selectAllActivos(aCondiciones); 
        break; 
      }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_UNI_NEG = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarUniNeg "); 
    textSQL.append(" WHERE oid_uni_neg = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_UNI_NEG, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarUniNeg "); 
	    textSQL.append(" WHERE activo  = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarUniNeg "); 
    textSQL.append(" WHERE descripcion  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_uni_neg oid, descripcion codigo,  descripcion ,activo ");
    textSQL.append(" from cTarUniNeg");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(UniNegConciTar.NICKNAME,
             DBUniNegConciTar.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }  
  
} 
