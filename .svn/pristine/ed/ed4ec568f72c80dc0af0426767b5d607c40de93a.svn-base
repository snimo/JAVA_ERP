package com.srn.erp.ventas.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBDevolucionVtasDet extends DBObjetoPersistente {

  public static final String OID_DEV_DET = "oid_dev_det";
  public static final String OID_DEV_CAB = "oid_dev_cab";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OBSERVACIONES = "observaciones";
  public static final String PEND_EMITIR_NC = "pend_emitir_nc";
  public static final String MODIF_PRECIO = "modif_precio";
  public static final String CANT_DEV = "cant_dev";
  public static final String OID_UM = "oid_um";
  public static final String OID_PED_DET = "oid_ped_det";
  public static final String OID_RTO_DET = "oid_rto_det";
  public static final String OID_FACT_DET = "oid_fact_det";
  public static final String ACTIVO = "activo";
  public static final String OID_MOTIVO_DEV = "oid_motivo_dev";
  public static final String CANT_ING_STK = "cant_ing_stk";
  public static final String PEND_ING_STK = "pend_ing_stk";
  
  public static final int SELECT_BY_DEV_CAB = 100;
  public static final int SELECT_BY_PEND_ING_STOCK = 101;
  public static final int APLICAR_CANT_ING_STK = 102;

  public DBDevolucionVtasDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEV_DET = 1;
    final int OID_DEV_CAB = 2;
    final int OID_PRODUCTO = 3;
    final int OBSERVACIONES = 4;
    final int PEND_EMITIR_NC = 5;
    final int MODIF_PRECIO = 6;
    final int CANT_DEV = 7;
    final int OID_UM = 8;
    final int OID_PED_DET = 9;
    final int OID_RTO_DET = 10;
    final int OID_FACT_DET = 11;
    final int ACTIVO = 12;
    final int OID_MOTIVO_DEV = 13;
    final int CANT_ING_STK = 14;
    final int PEND_ING_STK = 15;

    DevolucionVtasDet pers = (DevolucionVtasDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veDevolucionDet "+
                     " ( "+
                      "OID_DEV_DET,"+
                      "OID_DEV_CAB,"+
                      "OID_PRODUCTO,"+
                      "OBSERVACIONES,"+
                      "PEND_EMITIR_NC,"+
                      "MODIF_PRECIO,"+
                      "CANT_DEV,"+
                      "OID_UM,"+
                      "OID_PED_DET,"+
                      "OID_RTO_DET,"+
                      "OID_FACT_DET,"+
                      "ACTIVO,"+
                      "OID_MOTIVO_DEV,CANT_ING_STK,PEND_ING_STK)"+ 
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DEV_DET,pers.getOID());
    qInsert.setInt(OID_DEV_CAB,pers.getDevolucion_cab().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setString(OBSERVACIONES,pers.getObservaciones());
    qInsert.setBoolean(PEND_EMITIR_NC,pers.isPend_emitir_nc().booleanValue());
    qInsert.setBoolean(MODIF_PRECIO,pers.isModif_precio().booleanValue());
    qInsert.setDouble(CANT_DEV,pers.getCantidad_devuelta().doubleValue());
    qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    if (pers.getPedido_det()!=null) 
      qInsert.setInt(OID_PED_DET,pers.getPedido_det().getOID());
    else
      qInsert.setNull(OID_PED_DET,java.sql.Types.INTEGER);
    if (pers.getRemito_det()!=null) 
      qInsert.setInt(OID_RTO_DET,pers.getRemito_det().getOID());
    else
      qInsert.setNull(OID_RTO_DET,java.sql.Types.INTEGER);
    if (pers.getFactura_det()!=null) 
      qInsert.setInt(OID_FACT_DET,pers.getFactura_det().getOID());
    else
      qInsert.setNull(OID_FACT_DET,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_MOTIVO_DEV,pers.getMotivo_devolucion().getOID());
    if (pers.getCantIngStk()!=null)
    	qInsert.setDouble(CANT_ING_STK, pers.getCantIngStk().doubleValue());
    else
    	qInsert.setDouble(CANT_ING_STK, 0);
    qInsert.setBoolean(PEND_ING_STK, pers.isPendIngStk());
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEV_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int OBSERVACIONES = 3;
    final int PEND_EMITIR_NC = 4;
    final int MODIF_PRECIO = 5;
    final int CANT_DEV = 6;
    final int OID_UM = 7;
    final int OID_PED_DET = 8;
    final int OID_RTO_DET = 9;
    final int OID_FACT_DET = 10;
    final int ACTIVO = 11;
    final int OID_MOTIVO_DEV = 12;
    final int CANT_ING_STK = 13;
    final int PEND_ING_STK = 14;    
    final int OID_DEV_DET = 15;

    DevolucionVtasDet pers = (DevolucionVtasDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veDevolucionDet set "+
              "oid_dev_cab=?"+ 
              ",oid_producto=?"+ 
              ",observaciones=?"+ 
              ",pend_emitir_nc=?"+ 
              ",modif_precio=?"+ 
              ",cant_dev=?"+ 
              ",oid_um=?"+ 
              ",oid_ped_det=?"+ 
              ",oid_rto_det=?"+ 
              ",oid_fact_det=?"+ 
              ",activo=?"+ 
              ",oid_motivo_dev=?"+
              ",cant_ing_stk=?"+
              ",pend_ing_stk=?"+
                 " where " +
                 " oid_dev_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEV_DET,pers.getOID());
    qUpdate.setInt(OID_DEV_CAB,pers.getDevolucion_cab().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setString(OBSERVACIONES,pers.getObservaciones());
    qUpdate.setBoolean(PEND_EMITIR_NC,pers.isPend_emitir_nc().booleanValue());
    qUpdate.setBoolean(MODIF_PRECIO,pers.isModif_precio().booleanValue());
    qUpdate.setDouble(CANT_DEV,pers.getCantidad_devuelta().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    if (pers.getPedido_det()!=null) 
      qUpdate.setInt(OID_PED_DET,pers.getPedido_det().getOID());
    else
      qUpdate.setNull(OID_PED_DET,java.sql.Types.INTEGER);
    if (pers.getRemito_det()!=null) 
      qUpdate.setInt(OID_RTO_DET,pers.getRemito_det().getOID());
    else
      qUpdate.setNull(OID_RTO_DET,java.sql.Types.INTEGER);
    if (pers.getFactura_det()!=null) 
      qUpdate.setInt(OID_FACT_DET,pers.getFactura_det().getOID());
    else
      qUpdate.setNull(OID_FACT_DET,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_MOTIVO_DEV,pers.getMotivo_devolucion().getOID());
    if (pers.getCantIngStk()!=null)
    	qUpdate.setDouble(CANT_ING_STK, pers.getCantIngStk().doubleValue());
    else
    	qUpdate.setDouble(CANT_ING_STK, 0);
    qUpdate.setBoolean(PEND_ING_STK, pers.isPendIngStk());
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEV_DET = 1; 
    DevolucionVtasDet pers = (DevolucionVtasDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veDevolucionDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_dev_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEV_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 
  
  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEV_DET = 1; 
    DevolucionVtasDet pers = (DevolucionVtasDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veDevolucionDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_dev_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEV_DET, pers.getOID()); 
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
      case SELECT_BY_DEV_CAB: {
          ps = this.selectByDevVtasCab(aCondiciones); 
          break; 
      }
      case SELECT_BY_PEND_ING_STOCK: {
          ps = this.selectByPendIngStock(aCondiciones); 
          break; 
      }
      case APLICAR_CANT_ING_STK: {
          ps = this.aplicarCantIngStk(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DEV_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veDevolucionDet "); 
    textSQL.append(" WHERE oid_dev_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DEV_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement aplicarCantIngStk(Object aCondiciones) throws BaseException, SQLException {
	  
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	DevolucionVtasDet devVtasDet = (DevolucionVtasDet) condiciones.get((DevolucionVtasDet.NICKNAME));
	  	Double cantIng = (Double) condiciones.get("CANT_ING");
	  	Boolean pendIngStk = (Boolean) condiciones.get("PEND_ING_STK");
	  	
	  	StringBuffer sqlUpdate= new StringBuffer();
	    sqlUpdate.append("update veDevolucionDet "+
	                     " set pend_ing_stk=? , cant_ing_stk = ? " + 
	                     " where " + 
	                     " oid_dev_det=? ");
	    
	    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
	    qUpdate.setBoolean(1, pendIngStk.booleanValue());
	    qUpdate.setDouble(2, cantIng.doubleValue());
	    qUpdate.setInt(3, devVtasDet.getOID());
	    
	    qUpdate.executeUpdate();
	    qUpdate.close();
	  
	    return null;
	  
  }


  
  
  private PreparedStatement selectByDevVtasCab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veDevolucionDet "); 
	    textSQL.append(" WHERE oid_dev_cab = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    DevolucionVtasCab devolucion = (DevolucionVtasCab) aCondiciones; 
	    querySelect.setInt(1, devolucion.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByPendIngStock(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veDevolucionDet a , veDevolucionCab b , geComproCab c "); 
	    textSQL.append(" WHERE c.oid_cco = b.oid_dev_cab and a.oid_dev_cab = b.oid_dev_cab and a.pend_ing_stk = 1 and a.activo = 1 ");
	    
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    
	    if (condiciones.containsKey(Talonario.NICKNAME)) {
	    	Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
	    	textSQL.append(" and c.oid_talonario = "+talonario.getOIDInteger());
	    }
	    
	    if (condiciones.containsKey(Sujeto.NICKNAME)) {
	    	Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
	    	textSQL.append(" and b.oid_sujeto = "+sujeto.getOIDInteger());
	    }
	    
	    if (condiciones.containsKey(FacturaCab.NICKNAME)) {
	    	FacturaCab factura = (FacturaCab) condiciones.get(FacturaCab.NICKNAME);
	    	textSQL.append(" and b.oid_cco_fact = "+factura.getOIDInteger());
	    }
	    
	    if (condiciones.containsKey(PedidoCab.NICKNAME)) {
	    	PedidoCab pedido = (PedidoCab) condiciones.get(PedidoCab.NICKNAME);
	    	textSQL.append(" and b.oid_cco_ped = "+pedido.getOIDInteger());
	    }
	    
	    if (condiciones.containsKey(RemitoCab.NICKNAME)) {
	    	RemitoCab remito = (RemitoCab) condiciones.get(RemitoCab.NICKNAME);
	    	textSQL.append(" and b.oid_cco_rto = "+remito.getOIDInteger());
	    }
	    
	    if (condiciones.containsKey("NRO_EXT")) {
	    	Integer nroExt = (Integer) condiciones.get("NRO_EXT");
	    	textSQL.append(" and c.nro_ext = "+nroExt.toString());
	    }
	    
	    if (condiciones.containsKey("NRO_EXT")) {
	    	Integer nroExt = (Integer) condiciones.get("NRO_EXT");
	    	textSQL.append(" and c.nro_ext = "+nroExt.toString());
	    }
	    
	    int nroParam = 0;
	    
	    if (condiciones.containsKey("FEC_DESDE")) {
	    	textSQL.append(" and c.emision >= ?");
	    }
	    
	    if (condiciones.containsKey("FEC_HASTA")) {
	    	textSQL.append(" and c.emision <= ?");
	    }
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    if (condiciones.containsKey("FEC_DESDE")) {
	    	++nroParam;
	    	java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    	querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
	    }
	    
	    if (condiciones.containsKey("FEC_HASTA")) {
	    	++nroParam;
	    	java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    	querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
	    }
	    	
	     
	    return querySelect; 
	  }
  
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veDevolucionDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_dev_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veDevolucionDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getDevolucionesVtasDet(DevolucionVtasCab devolucion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DevolucionVtasDet.NICKNAME,
			  DBDevolucionVtasDet.SELECT_BY_DEV_CAB,
			  devolucion,
			  new ListObserver(),
			  aSesion);
  }
  
  
  public static List getPendIngStock(
		  Talonario talonario,
		  Sujeto sujeto,
		  FacturaCab factura,
		  RemitoCab remito,
		  PedidoCab pedido,
		  Integer nroExt,
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (talonario!=null)
		  condiciones.put(Talonario.NICKNAME, talonario);
	  if (sujeto!=null)
		  condiciones.put(Sujeto.NICKNAME, sujeto);
	  if (factura!=null)
		  condiciones.put(FacturaCab.NICKNAME, factura);
	  if (remito!=null)
		  condiciones.put(RemitoCab.NICKNAME, remito);
	  if (pedido!=null)
		  condiciones.put(PedidoCab.NICKNAME, pedido);
	  if (nroExt!=null)
		  condiciones.put("NRO_EXT", nroExt);
	  if (fecDesde!=null)
		  condiciones.put("FEC_DESDE", fecDesde);
	  if (fecHasta!=null)
		  condiciones.put("FEC_HASTA", fecHasta);
	  
	  return (List) ObjetoLogico.getObjects(DevolucionVtasDet.NICKNAME,
             DBDevolucionVtasDet.SELECT_BY_PEND_ING_STOCK,
             condiciones,
             new ListObserver(),
             aSesion);
	  
  }
  
  public static void AplicarCantIngStk(
		  DevolucionVtasDet devVtasDet,
		  Double cantIngStk,
		  boolean pendIngStk,
		  ISesion aSesion) throws BaseException {
	  
	  
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(DevolucionVtasDet.NICKNAME, devVtasDet);
	  condiciones.put("CANT_ING",cantIngStk);
	  condiciones.put("PEND_ING_STK",new Boolean(pendIngStk));
	  
	  ObjetoLogico.getObjects(DevolucionVtasDet.NICKNAME,
             DBDevolucionVtasDet.APLICAR_CANT_ING_STK,
             condiciones,
             new ListObserver(),
             aSesion);
	  
  }
  

  
  
  
  
  
  
  
} 
