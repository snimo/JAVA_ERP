package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSolicitudCotizDetPorProv extends DBObjetoPersistente {

  public static final String OID_COTIZ_DET_PROV = "oid_cotiz_det_prov";
  public static final String OID_SOL_COTIZ_PROV = "oid_sol_cotiz_prov";
  public static final String OID_SOL_COTIZ_DET = "oid_sol_cotiz_det";
  public static final String CANT_A_COTIZAR = "cant_a_cotizar";
  public static final String OID_UM_CPRA = "oid_um_cpra";
  public static final String COTIZAR = "cotizar";
  public static final String OBS_ART_PROV = "obs_art_prov";
  public static final String OID_CCO_SOL_COTIZ = "oid_cco_sol_cotiz";
  
  public static final int SELECT_BY_OID_CCO_SOL_COTIZ = 100;
  public static final int SELECT_BY_OID_SOL_COTIZ_PROV = 101;

  public DBSolicitudCotizDetPorProv() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COTIZ_DET_PROV = 1;
    final int OID_SOL_COTIZ_PROV = 2;
    final int OID_SOL_COTIZ_DET = 3;
    final int CANT_A_COTIZAR = 4;
    final int OID_UM_CPRA = 5;
    final int COTIZAR = 6;
    final int OBS_ART_PROV = 7;
    final int OID_CCO_SOL_COTIZ = 8;

    SolicitudCotizDetPorProv pers = (SolicitudCotizDetPorProv) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpSolCotizDetProv "+
                     " ( "+
                      "OID_COTIZ_DET_PROV,"+
                      "OID_SOL_COTIZ_PROV,"+
                      "OID_SOL_COTIZ_DET,"+
                      "CANT_A_COTIZAR,"+
                      "OID_UM_CPRA,"+
                      "COTIZAR,"+
                      "OBS_ART_PROV,"+
                      "OID_CCO_SOL_COTIZ)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COTIZ_DET_PROV,pers.getOID());
    qInsert.setInt(OID_SOL_COTIZ_PROV,pers.getSolicitud_cotiz_prov().getOID());
    qInsert.setInt(OID_SOL_COTIZ_DET,pers.getSolicitud_cotiz_det().getOID());
    qInsert.setDouble(CANT_A_COTIZAR,pers.getCant_a_cotizar().doubleValue());
    if (pers.getOid_um_cpra()!=null) 
      qInsert.setInt(OID_UM_CPRA,pers.getOid_um_cpra().getOID());
    else
      qInsert.setNull(OID_UM_CPRA,java.sql.Types.INTEGER);
    qInsert.setBoolean(COTIZAR,pers.isCotizar().booleanValue());
    if (pers.getObs_art_prov()!=null)
      qInsert.setString(OBS_ART_PROV,pers.getObs_art_prov());
    else
      qInsert.setNull(OBS_ART_PROV,Types.VARCHAR);    	
    qInsert.setInt(OID_CCO_SOL_COTIZ,pers.getSolicitudCotizacion().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SOL_COTIZ_PROV = 1;
    final int OID_SOL_COTIZ_DET = 2;
    final int CANT_A_COTIZAR = 3;
    final int OID_UM_CPRA = 4;
    final int COTIZAR = 5;
    final int OBS_ART_PROV = 6;
    final int OID_CCO_SOL_COTIZ = 7;
    final int OID_COTIZ_DET_PROV = 8;

    SolicitudCotizDetPorProv pers = (SolicitudCotizDetPorProv) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpSolCotizDetProv set "+
              "oid_sol_cotiz_prov=?"+ 
              ",oid_sol_cotiz_det=?"+ 
              ",cant_a_cotizar=?"+ 
              ",oid_um_cpra=?"+ 
              ",cotizar=?"+ 
              ",obs_art_prov=?"+ 
              ",oid_cco_sol_cotiz=?"+
                 " where " +
                 " oid_cotiz_det_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COTIZ_DET_PROV,pers.getOID());
    qUpdate.setInt(OID_SOL_COTIZ_PROV,pers.getSolicitud_cotiz_prov().getOID());
    qUpdate.setInt(OID_SOL_COTIZ_DET,pers.getSolicitud_cotiz_det().getOID());
    qUpdate.setDouble(CANT_A_COTIZAR,pers.getCant_a_cotizar().doubleValue());
    if (pers.getOid_um_cpra()!=null) 
      qUpdate.setInt(OID_UM_CPRA,pers.getOid_um_cpra().getOID());
    else
      qUpdate.setNull(OID_UM_CPRA,java.sql.Types.INTEGER);
    qUpdate.setBoolean(COTIZAR,pers.isCotizar().booleanValue());
    if (pers.getObs_art_prov()!=null)
    	qUpdate.setString(OBS_ART_PROV,pers.getObs_art_prov());
      else
    	qUpdate.setNull(OBS_ART_PROV,Types.VARCHAR);    
    qUpdate.setInt(OID_CCO_SOL_COTIZ,pers.getSolicitudCotizacion().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COTIZ_DET_PROV = 1; 
    SolicitudCotizDetPorProv pers = (SolicitudCotizDetPorProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpSolCotizDetProv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cotiz_det_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COTIZ_DET_PROV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COTIZ_DET_PROV = 1; 
    SolicitudCotizDetPorProv pers = (SolicitudCotizDetPorProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpSolCotizDetProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cotiz_det_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COTIZ_DET_PROV, pers.getOID()); 
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
      case SELECT_BY_OID_CCO_SOL_COTIZ: {
        ps = this.selecBySolicitudCotiz(aCondiciones); 
        break; 
      }
      case SELECT_BY_OID_SOL_COTIZ_PROV: {
          ps = this.selecByOidSolCotizProv(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COTIZ_DET_PROV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizDetProv "); 
    textSQL.append(" WHERE oid_cotiz_det_prov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COTIZ_DET_PROV, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizDetProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private  PreparedStatement selecBySolicitudCotiz(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cpSolCotizDetProv "); 
	textSQL.append(" WHERE oid_cco_sol_cotiz = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	SolicitudCotizProvCab solicitudCotizProvCab = (SolicitudCotizProvCab) aCondiciones; 
	querySelect.setInt(1, solicitudCotizProvCab.getOID()); 
	return querySelect; 	  
  }
  
  

  private  PreparedStatement selecByOidSolCotizProv(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  cpSolCotizDetProv "); 
		textSQL.append(" WHERE oid_sol_cotiz_prov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		SolicitudCotizProveedor solCotizProv = (SolicitudCotizProveedor) aCondiciones; 
		querySelect.setInt(1, solCotizProv.getOID()); 
		return querySelect; 	  
	  }
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cotiz_det_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpSolCotizDetProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getSolicitudesCotizDetPorProveedores(SolicitudCotizProvCab solicitudCotizacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SolicitudCotizDetPorProv.NICKNAME,
             DBSolicitudCotizDetPorProv.SELECT_BY_OID_CCO_SOL_COTIZ,
             solicitudCotizacion,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getSolicitudesCotizDetPorProveedores(SolicitudCotizProveedor solCotizProv,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SolicitudCotizDetPorProv.NICKNAME,
             DBSolicitudCotizDetPorProv.SELECT_BY_OID_SOL_COTIZ_PROV,
             solCotizProv,
             new ListObserver(),
             aSesion);
  }  
  
  
} 
