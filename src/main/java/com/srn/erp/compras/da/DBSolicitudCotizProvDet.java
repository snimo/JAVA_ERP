package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProvDet;
import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSolicitudCotizProvDet extends DBObjetoPersistente {

  public static final String OID_SOL_COTIZ_DET = "oid_sol_cotiz_det";
  public static final String OID_CCO_SOL_COTIZ = "oid_cco_sol_cotiz";
  public static final String NRO_ITEM = "nro_item";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String DESC_ADIC_SKU = "desc_adic_sku";
  public static final String FEC_ENT = "fec_ent";
  public static final String CANT_REQUERIDA = "cant_requerida";
  public static final String OID_UM = "oid_um";
  public static final String OBS_SOL_COTIZ = "obs_sol_cotiz";
  public static final String ANULADO = "anulado";
  
  public static final int SELECT_BY_SOL_COTIZ_PROV = 100;

  public DBSolicitudCotizProvDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SOL_COTIZ_DET = 1;
    final int OID_CCO_SOL_COTIZ = 2;
    final int NRO_ITEM = 3;
    final int OID_PRODUCTO = 4;
    final int DESC_ADIC_SKU = 5;
    final int FEC_ENT = 6;
    final int CANT_REQUERIDA = 7;
    final int OID_UM = 8;
    final int OBS_SOL_COTIZ = 9;
    final int ANULADO = 10;

    SolicitudCotizProvDet pers = (SolicitudCotizProvDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpSolCotizDet "+
                     " ( "+
                      "OID_SOL_COTIZ_DET,"+
                      "OID_CCO_SOL_COTIZ,"+
                      "NRO_ITEM,"+
                      "OID_PRODUCTO,"+
                      "DESC_ADIC_SKU,"+
                      "FEC_ENT,"+
                      "CANT_REQUERIDA,"+
                      "OID_UM,"+
                      "OBS_SOL_COTIZ,"+
                      "ANULADO)"+ 
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
    qInsert.setInt(OID_SOL_COTIZ_DET,pers.getOID());
    qInsert.setInt(OID_CCO_SOL_COTIZ,pers.getSolicitud_cotiz_proveedor().getOID());
    qInsert.setInt(NRO_ITEM,pers.getNro_item().intValue());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setString(DESC_ADIC_SKU,pers.getDesc_adic_sku());
    qInsert.setDate(FEC_ENT,new Date(pers.getFec_entrega().getTime()));
    qInsert.setDouble(CANT_REQUERIDA,pers.getCant_requerida().doubleValue());
    qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qInsert.setString(OBS_SOL_COTIZ,pers.getObs_sol_cotiz());
    qInsert.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_SOL_COTIZ = 1;
    final int NRO_ITEM = 2;
    final int OID_PRODUCTO = 3;
    final int DESC_ADIC_SKU = 4;
    final int FEC_ENT = 5;
    final int CANT_REQUERIDA = 6;
    final int OID_UM = 7;
    final int OBS_SOL_COTIZ = 8;
    final int ANULADO = 9;
    final int OID_SOL_COTIZ_DET = 10;

    SolicitudCotizProvDet pers = (SolicitudCotizProvDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpSolCotizDet set "+
              "oid_cco_sol_cotiz=?"+ 
              ",nro_item=?"+ 
              ",oid_producto=?"+ 
              ",desc_adic_sku=?"+ 
              ",fec_ent=?"+ 
              ",cant_requerida=?"+ 
              ",oid_um=?"+ 
              ",obs_sol_cotiz=?"+ 
              ",anulado=?"+ 
                 " where " +
                 " oid_sol_cotiz_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SOL_COTIZ_DET,pers.getOID());
    qUpdate.setInt(OID_CCO_SOL_COTIZ,pers.getSolicitud_cotiz_proveedor().getOID());
    qUpdate.setInt(NRO_ITEM,pers.getNro_item().intValue());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setString(DESC_ADIC_SKU,pers.getDesc_adic_sku());
    qUpdate.setDate(FEC_ENT,new Date(pers.getFec_entrega().getTime()));
    qUpdate.setDouble(CANT_REQUERIDA,pers.getCant_requerida().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qUpdate.setString(OBS_SOL_COTIZ,pers.getObs_sol_cotiz());
    qUpdate.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SOL_COTIZ_DET = 1; 
    SolicitudCotizProvDet pers = (SolicitudCotizProvDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpSolCotizDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_sol_cotiz_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SOL_COTIZ_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SOL_COTIZ_DET = 1; 
    SolicitudCotizProvDet pers = (SolicitudCotizProvDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpSolCotizDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sol_cotiz_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SOL_COTIZ_DET, pers.getOID()); 
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
      case SELECT_BY_SOL_COTIZ_PROV: {
        ps = this.selectBySolicitudCotizProv(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SOL_COTIZ_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizDet "); 
    textSQL.append(" WHERE oid_sol_cotiz_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SOL_COTIZ_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectBySolicitudCotizProv(Object aCondiciones) throws BaseException, SQLException { 
	 StringBuffer textSQL = new StringBuffer(); 
	 textSQL.append("SELECT * FROM  cpSolCotizDet "); 
	 textSQL.append(" WHERE oid_cco_sol_cotiz = ? ");
	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	 SolicitudCotizProvCab solicitudCotizProv = (SolicitudCotizProvCab) aCondiciones; 
	 querySelect.setInt(1, solicitudCotizProv.getOID()); 
	 return querySelect; 
  }  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sol_cotiz_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpSolCotizDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSolicitudesCotizProvDet(SolicitudCotizProvCab solicitudCotizProvCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SolicitudCotizProvDet.NICKNAME,
             DBSolicitudCotizProvDet.SELECT_BY_SOL_COTIZ_PROV,
             solicitudCotizProvCab,
             new ListObserver(),
             aSesion);
  }
  
  public static int getUltimoNroItem(ISesion aSesion , SolicitudCotizProvCab solCotizProvCab) throws BaseException {

		 try {
			 
			int oid = 0; 
			if (solCotizProvCab!=null)
				if (!solCotizProvCab.isNew())
					oid =  solCotizProvCab.getOID();
			 
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_item) nro_item ");
		    textSQL.append(" from cpCotizProvDet where oid_cotiz_prov_cab = "+oid);

		    PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
		    
		    ResultSet rs = querySelect.executeQuery();
		    int ultimoNro = 0;
		    if (rs.next())
		    	ultimoNro = rs.getInt(1);
		    rs.close();
		    querySelect.close();	    
		    
		    return ultimoNro;
		 }
		 catch(Exception e) {
			 throw new BaseException(null,e.getMessage());
		 }
	  }
	
  
  
} 
