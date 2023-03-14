package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaCabImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBFacturaCabImpu extends DBObjetoPersistente {

  public static final String OID_FACT_CAB_IMPU = "oid_fact_cab_impu";
  public static final String OID_CCO_FACT = "oid_cco_fact";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String IMPU_MON_ORI = "impu_mon_ori";
  public static final String IMPO_MON_LOCAL = "impu_mon_local";
  
  public static final int SELECT_BY_COMPRO_VTA = 100;  

  public DBFacturaCabImpu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FACT_CAB_IMPU = 1;
    final int OID_CCO_FACT = 2;
    final int OID_CONC_IMPU = 3;
    final int IMPU_MON_ORI = 4;
    final int IMPO_MON_LOCAL = 5;

    FacturaCabImpu pers = (FacturaCabImpu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veFactCabImpu "+
                     " ( "+
                      "OID_FACT_CAB_IMPU,"+
                      "OID_CCO_FACT,"+
                      "OID_CONC_IMPU,"+
                      "IMPU_MON_ORI,"+
                      "IMPU_MON_LOCAL)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FACT_CAB_IMPU,pers.getOID());
    qInsert.setInt(OID_CCO_FACT,pers.getFacturacab().getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConcepto_impuesto().getOID());
    qInsert.setDouble(IMPU_MON_ORI,pers.getImporte_mon_ori().doubleValue());
    qInsert.setDouble(IMPO_MON_LOCAL,pers.getImporte_mon_local().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_FACT = 1;
    final int OID_CONC_IMPU = 2;
    final int IMPU_MON_ORI = 3;
    final int IMPO_MON_LOCAL = 4;
    final int OID_FACT_CAB_IMPU = 5;

    FacturaCabImpu pers = (FacturaCabImpu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veFactCabImpu set "+
              "oid_cco_fact=?"+ 
              ",oid_conc_impu=?"+ 
              ",impu_mon_ori=?"+ 
              ",impu_mon_local=?"+ 
                 " where " +
                 " oid_fact_cab_impu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_CAB_IMPU,pers.getOID());
    qUpdate.setInt(OID_CCO_FACT,pers.getFacturacab().getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConcepto_impuesto().getOID());
    qUpdate.setDouble(IMPU_MON_ORI,pers.getImporte_mon_ori().doubleValue());
    qUpdate.setDouble(IMPO_MON_LOCAL,pers.getImporte_mon_local().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_CAB_IMPU = 1; 
    FacturaCabImpu pers = (FacturaCabImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFactCabImpu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_fact_cab_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_CAB_IMPU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_CAB_IMPU = 1; 
    FacturaCabImpu pers = (FacturaCabImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFactCabImpu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fact_cab_impu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_CAB_IMPU, pers.getOID()); 
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
      case SELECT_BY_COMPRO_VTA: {
        ps = this.selectByComproVta(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FACT_CAB_IMPU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFactCabImpu "); 
    textSQL.append(" WHERE oid_fact_cab_impu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FACT_CAB_IMPU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByComproVta(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veFactCabImpu "); 
	textSQL.append(" WHERE oid_cco_fact = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	FacturaCab factura = (FacturaCab) aCondiciones; 
	querySelect.setInt(1, factura.getOID()); 
	return querySelect; 
  }
		  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFactCabImpu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fact_cab_impu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veFactCabImpu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getFacturaCabImpu(FacturaCab facturaCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FacturaCabImpu.NICKNAME,
			  DBFacturaCabImpu.SELECT_BY_COMPRO_VTA,
              facturaCab,
              new ListObserver(),
              aSesion);  
  }
  
  
} 
