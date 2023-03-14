package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.AplicNCFact;
import com.srn.erp.ventas.bm.FacturaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAplicNCFact extends DBObjetoPersistente {

  public static final String OID_NC_FACT = "oid_nc_fact";
  public static final String OID_DET_NC = "oid_det_nc";
  public static final String CANT_NC = "cant_nc";
  public static final String OID_CCO_FACT = "oid_cco_fact";
  public static final String OID_CCO_FACT_DET = "oid_cco_fact_det";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FACT_DET_ACTIVOS = 100;

  public DBAplicNCFact() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_NC_FACT = 1;
    final int OID_DET_NC = 2;
    final int CANT_NC = 3;
    final int OID_CCO_FACT = 4;
    final int OID_CCO_FACT_DET = 5;
    final int ACTIVO = 6;

    AplicNCFact pers = (AplicNCFact) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veNCSobreFact "+
                     " ( "+
                      "OID_NC_FACT,"+
                      "OID_DET_NC,"+
                      "CANT_NC,"+
                      "OID_CCO_FACT,"+
                      "OID_CCO_FACT_DET,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_NC_FACT,pers.getOID());
    qInsert.setInt(OID_DET_NC,pers.getDetalle_nc().getOID());
    qInsert.setDouble(CANT_NC,pers.getCant_nc().doubleValue());
    qInsert.setInt(OID_CCO_FACT,pers.getFactura().getOID());
    qInsert.setInt(OID_CCO_FACT_DET,pers.getFactura_det().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DET_NC = 1;
    final int CANT_NC = 2;
    final int OID_CCO_FACT = 3;
    final int OID_CCO_FACT_DET = 4;
    final int ACTIVO = 5;
    final int OID_NC_FACT = 6;

    AplicNCFact pers = (AplicNCFact) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veNCSobreFact set "+
              "oid_det_nc=?"+ 
              ",cant_nc=?"+ 
              ",oid_cco_fact=?"+ 
              ",oid_cco_fact_det=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_nc_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NC_FACT,pers.getOID());
    qUpdate.setInt(OID_DET_NC,pers.getDetalle_nc().getOID());
    qUpdate.setDouble(CANT_NC,pers.getCant_nc().doubleValue());
    qUpdate.setInt(OID_CCO_FACT,pers.getFactura().getOID());
    qUpdate.setInt(OID_CCO_FACT_DET,pers.getFactura_det().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NC_FACT = 1; 
    AplicNCFact pers = (AplicNCFact) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veNCSobreFact "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_nc_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NC_FACT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NC_FACT = 1; 
    AplicNCFact pers = (AplicNCFact) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veNCSobreFact "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_nc_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NC_FACT, pers.getOID()); 
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
      case SELECT_BY_FACT_DET_ACTIVOS: {
          ps = this.selectByFactDetActivos(aCondiciones); 
          break; 
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_NC_FACT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veNCSobreFact "); 
    textSQL.append(" WHERE oid_nc_fact = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_NC_FACT, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFactDetActivos(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veNCSobreFact "); 
	textSQL.append(" WHERE oid_cco_fact_det  = ? and activo=1 ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	FacturaDet facturaDet = (FacturaDet) aCondiciones; 
	querySelect.setInt(1, facturaDet.getOID()); 
	return querySelect; 
  }
		  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veNCSobreFact "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_nc_fact oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veNCSobreFact");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAplicacionesNC_Fact(FacturaDet facturaDet,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplicNCFact.NICKNAME,
             DBAplicNCFact.SELECT_BY_FACT_DET_ACTIVOS,
             facturaDet,
             new ListObserver(),
             aSesion);
  }
  
  
} 
