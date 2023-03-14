package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockPorItemDepoEst;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoStockPorItemDepoEst extends DBObjetoPersistente {

  public static final String OID_SAL_EST_ITEM = "oid_sal_est_item";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String OID_CCO_DEST = "oid_cco_dest";
  public static final String OID_CCO_DET_DEST = "oid_cco_det_dest";
  public static final String SALDO = "saldo";
  public static final String TIENE_SALDO = "tiene_saldo";
  
  public static final int SELECT_BY_DEPO_PROD_EST_COMPRO_Y_DET = 100;

  public DBSaldoStockPorItemDepoEst() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SAL_EST_ITEM = 1;
    final int OID_DEPOSITO = 2;
    final int OID_PRODUCTO = 3;
    final int OID_UM_STK = 4;
    final int OID_ESTADO_STOCK = 5;
    final int OID_CCO_DEST = 6;
    final int OID_CCO_DET_DEST = 7;
    final int SALDO = 8;
    final int TIENE_SALDO = 9;

    SaldoStockPorItemDepoEst pers = (SaldoStockPorItemDepoEst) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockSalEstItem "+
                     " ( "+
                      "OID_SAL_EST_ITEM,"+
                      "OID_DEPOSITO,"+
                      "OID_PRODUCTO,"+
                      "OID_UM_STK,"+
                      "OID_ESTADO_STOCK,"+
                      "OID_CCO_DEST,"+
                      "OID_CCO_DET_DEST,"+
                      "SALDO,"+
                      "TIENE_SALDO)"+ 
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
    qInsert.setInt(OID_SAL_EST_ITEM,pers.getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_UM_STK,pers.getUnidad_medida().getOID());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setInt(OID_CCO_DEST,pers.getComprobante().getOID());
    qInsert.setInt(OID_CCO_DET_DEST,pers.getOid_cco_det().intValue());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setBoolean(TIENE_SALDO,pers.isTiene_saldo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int SALDO = 1;
    final int TIENE_SALDO = 2;
    final int OID_SAL_EST_ITEM = 3;

    SaldoStockPorItemDepoEst pers = (SaldoStockPorItemDepoEst) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockSalEstItem set "+
              " saldo=?,"+ 
              " tiene_saldo=?"+ 
                 " where " +
                 " oid_sal_est_item=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SAL_EST_ITEM,pers.getOID());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setBoolean(TIENE_SALDO,pers.isTiene_saldo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SAL_EST_ITEM = 1; 
    SaldoStockPorItemDepoEst pers = (SaldoStockPorItemDepoEst) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skStockSalEstItem "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_sal_est_item=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SAL_EST_ITEM, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SAL_EST_ITEM = 1; 
    SaldoStockPorItemDepoEst pers = (SaldoStockPorItemDepoEst) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skStockSalEstItem "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sal_est_item=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SAL_EST_ITEM, pers.getOID()); 
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
      case SELECT_BY_DEPO_PROD_EST_COMPRO_Y_DET: {
          ps = this.selectByDepoProdEstComproYDet(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SAL_EST_ITEM = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skStockSalEstItem "); 
    textSQL.append(" WHERE oid_sal_est_item = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SAL_EST_ITEM, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skStockSalEstItem "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByDepoProdEstComproYDet(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
	  	Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	  	EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
	  	ComproCab comprobante = (ComproCab) condiciones.get(ComproCab.NICKNAME);
	  	Integer oidDetCompro = (Integer) condiciones.get(DBSaldoStockPorItemDepoEst.OID_CCO_DET_DEST);
	  
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  skStockSalEstItem "); 
	    textSQL.append(" WHERE ");
	    textSQL.append(" oid_deposito = ? and oid_producto = ? and oid_estado_stock = ? ");
	    textSQL.append(" and oid_cco_dest = ? and oid_cco_det_dest = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, deposito.getOID());
	    querySelect.setInt(2, producto.getOID());
	    querySelect.setInt(3, estadoStock.getOID());
	    querySelect.setInt(4, comprobante.getOID());
	    querySelect.setInt(5, oidDetCompro);
	    return querySelect; 
	  }
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sal_est_item oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockSalEstItem");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static SaldoStockPorItemDepoEst getSaldoStockPorItemDepoEst(
		  Deposito deposito,
		  Producto producto,
		  EstadoStock estado,
		  ComproCab comproCab,
		  Integer oidCCODet,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Deposito.NICKNAME, deposito);
	  condiciones.put(Producto.NICKNAME, producto);
	  condiciones.put(EstadoStock.NICKNAME, estado);
	  condiciones.put(ComproCab.NICKNAME, comproCab);
	  condiciones.put(DBSaldoStockPorItemDepoEst.OID_CCO_DET_DEST, oidCCODet);
	  
	  return (SaldoStockPorItemDepoEst) ObjetoLogico.getObjects(SaldoStockPorItemDepoEst.NICKNAME,
			  				DBSaldoStockPorItemDepoEst.SELECT_BY_DEPO_PROD_EST_COMPRO_Y_DET,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
