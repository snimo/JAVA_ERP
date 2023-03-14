package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.bienUso.bm.ComproBienUsoCab;
import com.srn.erp.bienUso.bm.ComproBienUsoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproBienUsoDet extends DBObjetoPersistente {

  public static final String OID_CCO_DET_BU = "oid_cco_det_bu";
  public static final String OID_CCO_BU = "oid_cco_bu";
  public static final String PORC = "porc";
  public static final String MESES_AMORT = "meses_amort";
  public static final String TASA_AMORT = "tasa_amort";
  public static final String OID_DCO = "oid_dco";
  public static final String IMPORTE = "importe";
  
  public static final int SELECT_BY_COMPRO_BU = 100;

  public DBComproBienUsoDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_DET_BU = 1;
    final int OID_CCO_BU = 2;
    final int PORC = 3;
    final int MESES_AMORT = 4;
    final int TASA_AMORT = 5;
    final int OID_DCO = 6;
    final int IMPORTE = 7;

    ComproBienUsoDet pers = (ComproBienUsoDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buComproDet "+
                     " ( "+
                      "OID_CCO_DET_BU,"+
                      "OID_CCO_BU,"+
                      "PORC,"+
                      "MESES_AMORT,"+
                      "TASA_AMORT,"+
                      "OID_DCO,"+
                      "IMPORTE)"+ 
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
    qInsert.setInt(OID_CCO_DET_BU,pers.getOID());
    qInsert.setInt(OID_CCO_BU,pers.getCompro_bien_uso_cab().getOID());
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setInt(MESES_AMORT,pers.getMeses_amort().intValue());
    qInsert.setDouble(TASA_AMORT,pers.getTasa_amort().doubleValue());
    if (pers.getCompro_conta_det()!=null)
    	qInsert.setInt(OID_DCO,pers.getCompro_conta_det().getOID());
    else
    	qInsert.setNull(OID_DCO,Types.INTEGER);
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_BU = 1;
    final int PORC = 2;
    final int MESES_AMORT = 3;
    final int TASA_AMORT = 4;
    final int OID_DCO = 5;
    final int IMPORTE = 6;
    final int OID_CCO_DET_BU = 7;

    ComproBienUsoDet pers = (ComproBienUsoDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buComproDet set "+
              "oid_cco_bu=?"+ 
              ",porc=?"+ 
              ",meses_amort=?"+ 
              ",tasa_amort=?"+ 
              ",oid_dco=?"+ 
              ",importe=?"+ 
                 " where " +
                 " oid_cco_det_bu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_DET_BU,pers.getOID());
    qUpdate.setInt(OID_CCO_BU,pers.getCompro_bien_uso_cab().getOID());
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setInt(MESES_AMORT,pers.getMeses_amort().intValue());
    qUpdate.setDouble(TASA_AMORT,pers.getTasa_amort().doubleValue());
    qUpdate.setInt(OID_DCO,pers.getCompro_conta_det().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_DET_BU = 1; 
    ComproBienUsoDet pers = (ComproBienUsoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buComproDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco_det_bu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_DET_BU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_DET_BU = 1; 
    ComproBienUsoDet pers = (ComproBienUsoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buComproDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco_det_bu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_DET_BU, pers.getOID()); 
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
      case SELECT_BY_COMPRO_BU: {
        ps = this.selectDetalles(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CCO_DET_BU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buComproDet "); 
    textSQL.append(" WHERE oid_cco_det_bu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO_DET_BU, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectDetalles(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buComproDet "); 
	textSQL.append(" WHERE oid_cco_bu = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	ComproBienUsoCab comprobanteBienUsoCab = (ComproBienUsoCab) aCondiciones; 
	querySelect.setInt(1,comprobanteBienUsoCab.getOID()); 
	return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buComproDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_det_bu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buComproDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetalles(ComproBienUsoCab comproBienUsoCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ComproBienUsoDet.NICKNAME,
            DBComproBienUsoDet.SELECT_BY_COMPRO_BU,
            comproBienUsoCab,
            new ListObserver(),
            aSesion);
  }
  
  
} 
