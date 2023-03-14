package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.AplicFacturadoPedido;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAplicFacturadoPedido extends DBObjetoPersistente {

  public static final String OID_PED_FACT = "oid_ped_fact";
  public static final String OID_PED_DET = "oid_ped_det";
  public static final String CANT_FACT = "cant_fact";
  public static final String COMPO_COMPRO = "compo_compro";
  public static final String OID_CCO_FACT = "oid_cco_fact";
  public static final String OID_CCO_FACT_DET = "oid_cco_fact_det";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FACT_Y_DET = 100;
  public static final int SELECT_BY_PEDIDO_DET_ACTIVOS = 101;

  public DBAplicFacturadoPedido() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PED_FACT = 1;
    final int OID_PED_DET = 2;
    final int CANT_FACT = 3;
    final int COMPO_COMPRO = 4;
    final int OID_CCO_FACT = 5;
    final int OID_CCO_FACT_DET = 6;
    final int ACTIVO = 7;

    AplicFacturadoPedido pers = (AplicFacturadoPedido) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vePedidoFacturado "+
                     " ( "+
                      "OID_PED_FACT,"+
                      "OID_PED_DET,"+
                      "CANT_FACT,"+
                      "COMPO_COMPRO,"+
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PED_FACT,pers.getOID());
    qInsert.setInt(OID_PED_DET,pers.getPedido_det().getOID());
    qInsert.setDouble(CANT_FACT,pers.getCant_fact().doubleValue());
    qInsert.setString(COMPO_COMPRO,pers.getCompo_compro());
    qInsert.setInt(OID_CCO_FACT,pers.getFactura().getOID());
    qInsert.setInt(OID_CCO_FACT_DET,pers.getFactura_det().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PED_DET = 1;
    final int CANT_FACT = 2;
    final int COMPO_COMPRO = 3;
    final int OID_CCO_FACT = 4;
    final int OID_CCO_FACT_DET = 5;
    final int ACTIVO = 6;
    final int OID_PED_FACT = 7;

    AplicFacturadoPedido pers = (AplicFacturadoPedido) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vePedidoFacturado set "+
              "oid_ped_det=?"+ 
              ",cant_fact=?"+ 
              ",compo_compro=?"+ 
              ",oid_cco_fact=?"+ 
              ",oid_cco_fact_det=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_ped_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PED_FACT,pers.getOID());
    qUpdate.setInt(OID_PED_DET,pers.getPedido_det().getOID());
    qUpdate.setDouble(CANT_FACT,pers.getCant_fact().doubleValue());
    qUpdate.setString(COMPO_COMPRO,pers.getCompo_compro());
    qUpdate.setInt(OID_CCO_FACT,pers.getFactura().getOID());
    qUpdate.setInt(OID_CCO_FACT_DET,pers.getFactura_det().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PED_FACT = 1; 
    AplicFacturadoPedido pers = (AplicFacturadoPedido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vePedidoFacturado "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_ped_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PED_FACT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PED_FACT = 1; 
    AplicFacturadoPedido pers = (AplicFacturadoPedido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vePedidoFacturado "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_ped_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PED_FACT, pers.getOID()); 
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
      case SELECT_BY_FACT_Y_DET: {
          ps = this.selectByFacturayDetalle(aCondiciones); 
          break; 
      }
      case SELECT_BY_PEDIDO_DET_ACTIVOS: {
          ps = this.selectByPedidoDetActivos(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PED_FACT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vePedidoFacturado "); 
    textSQL.append(" WHERE oid_ped_fact = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PED_FACT, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPedidoDetActivos(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vePedidoFacturado "); 
	    textSQL.append(" WHERE oid_ped_det = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    PedidoDet pedidoDet = (PedidoDet) aCondiciones;
	    
	    querySelect.setInt(1, pedidoDet.getOID()); 
	    
	    return querySelect; 
}
  
  
  private PreparedStatement selectByFacturayDetalle(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vePedidoFacturado "); 
	    textSQL.append(" WHERE oid_cco_fact = ? and oid_cco_fact_det = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    FacturaCab facturaCab = (FacturaCab) condiciones.get(FacturaCab.NICKNAME);
	    FacturaDet facturaDet = (FacturaDet) condiciones.get(FacturaDet.NICKNAME);
	    
	    querySelect.setInt(1, facturaCab.getOID()); 
	    querySelect.setInt(2, facturaDet.getOID());
	    
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vePedidoFacturado "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ped_fact oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vePedidoFacturado");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAplicFacturadoPedido(
		  FacturaCab facturaCab,
		  FacturaDet facturaDet,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(FacturaCab.NICKNAME, facturaCab);
	  condiciones.put(FacturaDet.NICKNAME, facturaDet);
	  return (List) ObjetoLogico.getObjects(AplicFacturadoPedido.NICKNAME,
             DBAplicFacturadoPedido.SELECT_BY_FACT_Y_DET,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getAplicFacturadoPedido(
		  PedidoDet pedidoDet,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplicFacturadoPedido.NICKNAME,
             DBAplicFacturadoPedido.SELECT_BY_PEDIDO_DET_ACTIVOS,
             pedidoDet,
             new ListObserver(),
             aSesion);
  }  
  
  
} 
