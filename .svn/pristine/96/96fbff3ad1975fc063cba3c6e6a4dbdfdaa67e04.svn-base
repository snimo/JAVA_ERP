package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.CotizacionProveedorDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCotizacionProveedorDet extends DBObjetoPersistente {

  public static final String OID_COTIZ_PROV_DET = "oid_cotiz_prov_det";
  public static final String OID_COTIZ_PROV_CAB = "oid_cotiz_prov_cab";
  public static final String OID_COTIZ_DET_PROV = "oid_cotiz_det_prov";
  public static final String OID_UM = "oid_um";
  public static final String CANT_PRESU = "cant_presu";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String PRECIO = "precio";
  public static final String FEC_ENT = "fec_ent";
  public static final String COMENTARIO = "comentario";
  public static final String OID_COND_PAGO_1 = "oid_cond_pago_1";
  public static final String DTO_COND_PAGO_1 = "dto_cond_pago_1";
  public static final String OID_COND_PAGO_2 = "oid_cond_pago_2";
  public static final String DTO_COND_PAGO_2 = "dto_cond_pago_2";
  public static final String ANULADO = "anulado";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String NRO_ITEM = "nro_item";
  
  public static final int SELECT_BY_COTIZ_PROV_CAB = 100;

  public DBCotizacionProveedorDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COTIZ_PROV_DET = 1;
    final int OID_COTIZ_PROV_CAB = 2;
    final int OID_COTIZ_DET_PROV = 3;
    final int OID_UM = 4;
    final int CANT_PRESU = 5;
    final int OID_MONEDA = 6;
    final int PRECIO = 7;
    final int FEC_ENT = 8;
    final int COMENTARIO = 9;
    final int OID_COND_PAGO_1 = 10;
    final int DTO_COND_PAGO_1 = 11;
    final int OID_COND_PAGO_2 = 12;
    final int DTO_COND_PAGO_2 = 13;
    final int ANULADO = 14;
    final int OID_PRODUCTO = 15;
    final int NRO_ITEM = 16;

    CotizacionProveedorDet pers = (CotizacionProveedorDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpCotizProvDet "+
                     " ( "+
                      "OID_COTIZ_PROV_DET,"+
                      "OID_COTIZ_PROV_CAB,"+
                      "OID_COTIZ_DET_PROV,"+
                      "OID_UM,"+
                      "CANT_PRESU,"+
                      "OID_MONEDA,"+
                      "PRECIO,"+
                      "FEC_ENT,"+
                      "COMENTARIO,"+
                      "OID_COND_PAGO_1,"+
                      "DTO_COND_PAGO_1,"+
                      "OID_COND_PAGO_2,"+
                      "DTO_COND_PAGO_2,"+
                      "ANULADO,"+
                      "OID_PRODUCTO,"+
                      "NRO_ITEM)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COTIZ_PROV_DET,pers.getOID());
    if (pers.getCotizacion_proveedor()!=null) 
      qInsert.setInt(OID_COTIZ_PROV_CAB,pers.getCotizacion_proveedor().getOID());
    else
      qInsert.setNull(OID_COTIZ_PROV_CAB,java.sql.Types.INTEGER);
    if (pers.getCotizacion_det_prov()!=null)
      qInsert.setInt(OID_COTIZ_DET_PROV,pers.getCotizacion_det_prov().getOID());
    else
      qInsert.setNull(OID_COTIZ_DET_PROV,java.sql.Types.INTEGER);
    	
    qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qInsert.setDouble(CANT_PRESU,pers.getCant_presu().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(PRECIO,pers.getPrecio().doubleValue());
    qInsert.setDate(FEC_ENT,new java.sql.Date(pers.getFec_ent().getTime()));
    qInsert.setString(COMENTARIO,pers.getComentario());
    if (pers.getCond_pago_1()!=null) 
      qInsert.setInt(OID_COND_PAGO_1,pers.getCond_pago_1().getOID());
    else
      qInsert.setNull(OID_COND_PAGO_1,java.sql.Types.INTEGER);
    
    if (pers.getDto_cond_pago_1()!=null)
      qInsert.setDouble(DTO_COND_PAGO_1,pers.getDto_cond_pago_1().doubleValue());
    else
      qInsert.setNull(DTO_COND_PAGO_1,java.sql.Types.DOUBLE);
    if (pers.getCond_pago_2()!=null) 
      qInsert.setInt(OID_COND_PAGO_2,pers.getCond_pago_2().getOID());
    else
      qInsert.setNull(OID_COND_PAGO_2,java.sql.Types.INTEGER);
    
    if (pers.getDto_cond_pago_2()!=null)
      qInsert.setDouble(DTO_COND_PAGO_2,pers.getDto_cond_pago_2().doubleValue());
    else
      qInsert.setNull(DTO_COND_PAGO_2,java.sql.Types.DOUBLE);
    	
    qInsert.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(NRO_ITEM,pers.getNroItem().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COTIZ_PROV_CAB = 1;
    final int OID_COTIZ_DET_PROV = 2;
    final int OID_UM = 3;
    final int CANT_PRESU = 4;
    final int OID_MONEDA = 5;
    final int PRECIO = 6;
    final int FEC_ENT = 7;
    final int COMENTARIO = 8;
    final int OID_COND_PAGO_1 = 9;
    final int DTO_COND_PAGO_1 = 10;
    final int OID_COND_PAGO_2 = 11;
    final int DTO_COND_PAGO_2 = 12;
    final int ANULADO = 13;
    final int OID_PRODUCTO = 14;
    final int NRO_ITEM = 15;
    final int OID_COTIZ_PROV_DET = 16;

    CotizacionProveedorDet pers = (CotizacionProveedorDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpCotizProvDet set "+
              "oid_cotiz_prov_cab=?"+ 
              ",oid_cotiz_det_prov=?"+ 
              ",oid_um=?"+ 
              ",cant_presu=?"+ 
              ",oid_moneda=?"+ 
              ",precio=?"+ 
              ",fec_ent=?"+ 
              ",comentario=?"+ 
              ",oid_cond_pago_1=?"+ 
              ",dto_cond_pago_1=?"+ 
              ",oid_cond_pago_2=?"+ 
              ",dto_cond_pago_2=?"+ 
              ",anulado=?"+
              ",oid_producto=?"+
              ",nro_item=?"+
                 " where " +
                 " oid_cotiz_prov_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COTIZ_PROV_DET,pers.getOID());
    if (pers.getCotizacion_proveedor()!=null) 
      qUpdate.setInt(OID_COTIZ_PROV_CAB,pers.getCotizacion_proveedor().getOID());
    else
      qUpdate.setNull(OID_COTIZ_PROV_CAB,java.sql.Types.INTEGER);
    
    if (pers.getCotizacion_det_prov()!=null)
    	qUpdate.setInt(OID_COTIZ_DET_PROV,pers.getCotizacion_det_prov().getOID());
      else
    	qUpdate.setNull(OID_COTIZ_DET_PROV,java.sql.Types.INTEGER);
    
    qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qUpdate.setDouble(CANT_PRESU,pers.getCant_presu().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(PRECIO,pers.getPrecio().doubleValue());
    qUpdate.setDate(FEC_ENT,new java.sql.Date(pers.getFec_ent().getTime()));
    qUpdate.setString(COMENTARIO,pers.getComentario());
    if (pers.getCond_pago_1()!=null) 
      qUpdate.setInt(OID_COND_PAGO_1,pers.getCond_pago_1().getOID());
    else
      qUpdate.setNull(OID_COND_PAGO_1,java.sql.Types.INTEGER);
    
    if (pers.getDto_cond_pago_1()!=null)
      qUpdate.setDouble(DTO_COND_PAGO_1,pers.getDto_cond_pago_1().doubleValue());
    else
      qUpdate.setNull(DTO_COND_PAGO_1,java.sql.Types.DOUBLE);    	
    
    if (pers.getCond_pago_2()!=null) 
      qUpdate.setInt(OID_COND_PAGO_2,pers.getCond_pago_2().getOID());
    else
      qUpdate.setNull(OID_COND_PAGO_2,java.sql.Types.INTEGER);
    
    if (pers.getDto_cond_pago_2()!=null)
      qUpdate.setDouble(DTO_COND_PAGO_2,pers.getDto_cond_pago_2().doubleValue());
    else
      qUpdate.setNull(DTO_COND_PAGO_2,java.sql.Types.DOUBLE);    	
    	
    qUpdate.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    qUpdate.setInt(NRO_ITEM,pers.getNroItem().intValue());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COTIZ_PROV_DET = 1; 
    CotizacionProveedorDet pers = (CotizacionProveedorDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpCotizProvDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cotiz_prov_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COTIZ_PROV_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COTIZ_PROV_DET = 1; 
    CotizacionProveedorDet pers = (CotizacionProveedorDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpCotizProvDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cotiz_prov_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COTIZ_PROV_DET, pers.getOID()); 
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
      case SELECT_BY_COTIZ_PROV_CAB: {
        ps = this.selectByCotizProvCab(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COTIZ_PROV_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpCotizProvDet "); 
    textSQL.append(" WHERE oid_cotiz_prov_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COTIZ_PROV_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCotizProvCab(Object aCondiciones) throws BaseException, SQLException {

	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cpCotizProvDet "); 
	textSQL.append(" WHERE oid_cotiz_prov_cab = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	CotizacionProveedorCab cotizacionProveedorCab = (CotizacionProveedorCab) aCondiciones; 
	querySelect.setInt(1, cotizacionProveedorCab.getOID()); 
	return querySelect; 
	  
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpCotizProvDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cotiz_prov_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpCotizProvDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getCotizacionesProveedoresDet(CotizacionProveedorCab cotizProvCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CotizacionProveedorDet.NICKNAME,
             DBCotizacionProveedorDet.SELECT_BY_COTIZ_PROV_CAB,
             cotizProvCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
