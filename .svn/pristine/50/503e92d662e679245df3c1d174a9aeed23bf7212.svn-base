package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.AplicDespachoPedido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAplicDespachoPedido extends DBObjetoPersistente {

  public static final String OID_PED_ENT = "oid_ped_ent";
  public static final String OID_PED_DET = "oid_ped_det";
  public static final String CANT_DESP = "cant_desp";
  public static final String COMPO_COMPRO = "compo_compro";
  public static final String OID_CCO_ENT = "oid_cco_ent";
  public static final String OID_CCO_DET_ENT = "oid_cco_det_ent";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PEDIDO_REMITO = 100;

  public DBAplicDespachoPedido() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PED_ENT = 1;
    final int OID_PED_DET = 2;
    final int CANT_DESP = 3;
    final int COMPO_COMPRO = 4;
    final int OID_CCO_ENT = 5;
    final int OID_CCO_DET_ENT = 6;
    final int ACTIVO = 7;

    AplicDespachoPedido pers = (AplicDespachoPedido) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vePedidoDespachos "+
                     " ( "+
                      "OID_PED_ENT,"+
                      "OID_PED_DET,"+
                      "CANT_DESP,"+
                      "COMPO_COMPRO,"+
                      "OID_CCO_ENT,"+
                      "OID_CCO_DET_ENT,"+
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
    qInsert.setInt(OID_PED_ENT,pers.getOID());
    qInsert.setInt(OID_PED_DET,pers.getPedido_detalle().getOID());
    qInsert.setDouble(CANT_DESP,pers.getCant_desp().doubleValue());
    qInsert.setString(COMPO_COMPRO,pers.getComportamiento_compro());
    qInsert.setInt(OID_CCO_ENT,pers.getComprobante_entrega().getOID());
    qInsert.setInt(OID_CCO_DET_ENT,pers.getOid_detalle_compro().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PED_DET = 1;
    final int CANT_DESP = 2;
    final int COMPO_COMPRO = 3;
    final int OID_CCO_ENT = 4;
    final int OID_CCO_DET_ENT = 5;
    final int ACTIVO = 6;
    final int OID_PED_ENT = 7;

    AplicDespachoPedido pers = (AplicDespachoPedido) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vePedidoDespachos set "+
              "oid_ped_det=?"+ 
              ",cant_desp=?"+ 
              ",compo_compro=?"+ 
              ",oid_cco_ent=?"+ 
              ",oid_cco_det_ent=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_ped_ent=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PED_ENT,pers.getOID());
    qUpdate.setInt(OID_PED_DET,pers.getPedido_detalle().getOID());
    qUpdate.setDouble(CANT_DESP,pers.getCant_desp().doubleValue());
    qUpdate.setString(COMPO_COMPRO,pers.getComportamiento_compro());
    qUpdate.setInt(OID_CCO_ENT,pers.getComprobante_entrega().getOID());
    qUpdate.setInt(OID_CCO_DET_ENT,pers.getOid_detalle_compro().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PED_ENT = 1; 
    AplicDespachoPedido pers = (AplicDespachoPedido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vePedidoDespachos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_ped_ent=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PED_ENT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PED_ENT = 1; 
    AplicDespachoPedido pers = (AplicDespachoPedido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vePedidoDespachos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_ped_ent=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PED_ENT, pers.getOID()); 
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
      case SELECT_BY_PEDIDO_REMITO : {
        ps = this.selectByPedidoRemito(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PED_ENT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vePedidoDespachos "); 
    textSQL.append(" WHERE oid_ped_ent = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PED_ENT, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByPedidoRemito(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vePedidoDespachos "); 
    textSQL.append(" WHERE oid_cco_ent = ? and oid_cco_det_ent = ? and activo = 1 ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    ComproCab comproCab = (ComproCab) condiciones.get(ComproCab.NICKNAME);
    Integer oidComproDet = (Integer)condiciones.get("OID_DETALLE");
    querySelect.setInt(1,comproCab.getOID());
    querySelect.setInt(2,oidComproDet.intValue());
    return querySelect;
    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vePedidoDespachos "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ped_ent oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vePedidoDespachos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAplicacionesPedido(ComproCab comproCab, Integer oidPedDet, ISesion aSesion)
			throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ComproCab.NICKNAME, comproCab);
		condiciones.put("OID_DETALLE", oidPedDet);

		return (List) ObjetoLogico.getObjects(AplicDespachoPedido.NICKNAME, DBAplicDespachoPedido.SELECT_BY_PEDIDO_REMITO,
				condiciones, new ListObserver(), aSesion);

	}
  
  
} 
