package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSolicitudCotizProveedor extends DBObjetoPersistente {

  public static final String OID_SOL_COTIZ_PROV = "oid_sol_cotiz_prov";
  public static final String OID_CCO_SOL_COTIZ = "oid_cco_sol_cotiz";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String IMPRESA = "impresa";
  public static final String OID_USU_IMP = "oid_usu_imp";
  public static final String FEC_IMPRESION = "fec_impresion";
  public static final String FEC_ENVIO_SOL = "fec_envio_sol";
  public static final String ENVIADA = "enviada";
  public static final String CONF_RECEP_SOL = "conf_recep_sol";
  public static final String FEC_RECEP_CONF_SOL = "fec_recep_conf_sol";
  public static final String PROV_ENT_SOL = "prov_ent_sol";
  public static final String FEC_REC_SOL_COTIZ = "fec_rec_sol_cotiz";
  public static final String PRESU_RECIBIDO = "presu_recibido";
  public static final String FEC_PRESU_RECIBIDO = "fec_presu_recibido";
  
  public static final int SELECT_BY_SOLICITUD_COTIZ = 100;
  public static final int SELECT_BY_SOL_COTIZ_PROV = 101;

  public DBSolicitudCotizProveedor() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SOL_COTIZ_PROV = 1;
    final int OID_CCO_SOL_COTIZ = 2;
    final int OID_PROVEEDOR = 3;
    final int IMPRESA = 4;
    final int OID_USU_IMP = 5;
    final int FEC_IMPRESION = 6;
    final int FEC_ENVIO_SOL = 7;
    final int ENVIADA = 8;
    final int CONF_RECEP_SOL = 9;
    final int FEC_RECEP_CONF_SOL = 10;
    final int PROV_ENT_SOL = 11;
    final int FEC_REC_SOL_COTIZ = 12;
    final int PRESU_RECIBIDO = 13;
    final int FEC_PRESU_RECIBIDO = 14;

    SolicitudCotizProveedor pers = (SolicitudCotizProveedor) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpSolCotizProv "+
                     " ( "+
                      "OID_SOL_COTIZ_PROV,"+
                      "OID_CCO_SOL_COTIZ,"+
                      "OID_PROVEEDOR,"+
                      "IMPRESA,"+
                      "OID_USU_IMP,"+
                      "FEC_IMPRESION,"+
                      "FEC_ENVIO_SOL,"+
                      "ENVIADA,"+
                      "CONF_RECEP_SOL,"+
                      "FEC_RECEP_CONF_SOL,"+
                      "PROV_ENT_SOL,"+
                      "FEC_REC_SOL_COTIZ,"+
                      "PRESU_RECIBIDO,"+
                      "FEC_PRESU_RECIBIDO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SOL_COTIZ_PROV,pers.getOID());
    qInsert.setInt(OID_CCO_SOL_COTIZ,pers.getSolicitud_cotizacion().getOID());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setBoolean(IMPRESA,pers.isImpresa().booleanValue());
    if (pers.getUsuario_impresion()!=null) 
      qInsert.setInt(OID_USU_IMP,pers.getUsuario_impresion().getOID());
    else
      qInsert.setNull(OID_USU_IMP,java.sql.Types.INTEGER);
    if (pers.getFec_impresion()!=null) 
      qInsert.setDate(FEC_IMPRESION,new java.sql.Date(pers.getFec_impresion().getTime()));
    else
      qInsert.setNull(FEC_IMPRESION,java.sql.Types.DATE);
    if (pers.getFec_envio_sol()!=null) 
      qInsert.setDate(FEC_ENVIO_SOL,new Date(pers.getFec_envio_sol().getTime()));
    else
      qInsert.setNull(FEC_ENVIO_SOL,java.sql.Types.DATE);
    qInsert.setBoolean(ENVIADA,pers.isEnviada().booleanValue());
    qInsert.setBoolean(CONF_RECEP_SOL,pers.isConf_recep_sol().booleanValue());
    if (pers.getFec_recep_conf_sol()!=null) 
      qInsert.setDate(FEC_RECEP_CONF_SOL,new Date(pers.getFec_recep_conf_sol().getTime()));
    else
      qInsert.setNull(FEC_RECEP_CONF_SOL,java.sql.Types.DATE);
    qInsert.setBoolean(PROV_ENT_SOL,pers.isProv_ent_sol().booleanValue());
    if (pers.getFec_rec_sol_cotiz()!=null) 
      qInsert.setDate(FEC_REC_SOL_COTIZ,new Date(pers.getFec_rec_sol_cotiz().getTime()));
    else
      qInsert.setNull(FEC_REC_SOL_COTIZ,java.sql.Types.INTEGER);
    qInsert.setBoolean(PRESU_RECIBIDO,pers.isPresu_recibido().booleanValue());
    if (pers.getFec_presu_recibido()!=null) 
      qInsert.setDate(FEC_PRESU_RECIBIDO,new Date(pers.getFec_presu_recibido().getTime()));
    else
      qInsert.setNull(FEC_PRESU_RECIBIDO,java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_SOL_COTIZ = 1;
    final int OID_PROVEEDOR = 2;
    final int IMPRESA = 3;
    final int OID_USU_IMP = 4;
    final int FEC_IMPRESION = 5;
    final int FEC_ENVIO_SOL = 6;
    final int ENVIADA = 7;
    final int CONF_RECEP_SOL = 8;
    final int FEC_RECEP_CONF_SOL = 9;
    final int PROV_ENT_SOL = 10;
    final int FEC_REC_SOL_COTIZ = 11;
    final int PRESU_RECIBIDO = 12;
    final int FEC_PRESU_RECIBIDO = 13;
    final int OID_SOL_COTIZ_PROV = 14;

    SolicitudCotizProveedor pers = (SolicitudCotizProveedor) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpSolCotizProv set "+
              "oid_cco_sol_cotiz=?"+ 
              ",oid_proveedor=?"+ 
              ",impresa=?"+ 
              ",oid_usu_imp=?"+ 
              ",fec_impresion=?"+ 
              ",fec_envio_sol=?"+ 
              ",enviada=?"+ 
              ",conf_recep_sol=?"+ 
              ",fec_recep_conf_sol=?"+ 
              ",prov_ent_sol=?"+ 
              ",fec_rec_sol_cotiz=?"+ 
              ",presu_recibido=?"+ 
              ",fec_presu_recibido=?"+ 
                 " where " +
                 " oid_sol_cotiz_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SOL_COTIZ_PROV,pers.getOID());
    qUpdate.setInt(OID_CCO_SOL_COTIZ,pers.getSolicitud_cotizacion().getOID());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setBoolean(IMPRESA,pers.isImpresa().booleanValue());
    if (pers.getUsuario_impresion()!=null) 
      qUpdate.setInt(OID_USU_IMP,pers.getUsuario_impresion().getOID());
    else
      qUpdate.setNull(OID_USU_IMP,java.sql.Types.INTEGER);
    if (pers.getFec_impresion()!=null) 
      qUpdate.setDate(FEC_IMPRESION,new Date(pers.getFec_impresion().getTime()));
    else
      qUpdate.setNull(FEC_IMPRESION,java.sql.Types.DATE);
    if (pers.getFec_envio_sol()!=null) 
      qUpdate.setDate(FEC_ENVIO_SOL,new Date(pers.getFec_envio_sol().getTime()));
    else
      qUpdate.setNull(FEC_ENVIO_SOL,java.sql.Types.DATE);
    qUpdate.setBoolean(ENVIADA,pers.isEnviada().booleanValue());
    qUpdate.setBoolean(CONF_RECEP_SOL,pers.isConf_recep_sol().booleanValue());
    if (pers.getFec_recep_conf_sol()!=null) 
      qUpdate.setDate(FEC_RECEP_CONF_SOL,new Date(pers.getFec_recep_conf_sol().getTime()));
    else
      qUpdate.setNull(FEC_RECEP_CONF_SOL,java.sql.Types.DATE);
    qUpdate.setBoolean(PROV_ENT_SOL,pers.isProv_ent_sol().booleanValue());
    if (pers.getFec_rec_sol_cotiz()!=null) 
      qUpdate.setDate(FEC_REC_SOL_COTIZ,new Date(pers.getFec_rec_sol_cotiz().getTime()));
    else
      qUpdate.setNull(FEC_REC_SOL_COTIZ,java.sql.Types.DATE);
    qUpdate.setBoolean(PRESU_RECIBIDO,pers.isPresu_recibido().booleanValue());
    if (pers.getFec_presu_recibido()!=null) 
      qUpdate.setDate(FEC_PRESU_RECIBIDO,new Date(pers.getFec_presu_recibido().getTime()));
    else
      qUpdate.setNull(FEC_PRESU_RECIBIDO,java.sql.Types.DATE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SOL_COTIZ_PROV = 1; 
    SolicitudCotizProveedor pers = (SolicitudCotizProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpSolCotizProv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_sol_cotiz_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SOL_COTIZ_PROV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SOL_COTIZ_PROV = 1; 
    SolicitudCotizProveedor pers = (SolicitudCotizProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpSolCotizProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sol_cotiz_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SOL_COTIZ_PROV, pers.getOID()); 
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
      case SELECT_BY_SOLICITUD_COTIZ: {
        ps = this.selectBySolicitudCotizacion(aCondiciones); 
        break; 
      }
      case SELECT_BY_SOL_COTIZ_PROV: {
          ps = this.selectBySolCotProv(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SOL_COTIZ_PROV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizProv "); 
    textSQL.append(" WHERE oid_sol_cotiz_prov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SOL_COTIZ_PROV, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectBySolCotProv(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  cpSolCotizProv "); 
		textSQL.append(" WHERE oid_cco_sol_cotiz  = ? and oid_proveedor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		SolicitudCotizProvCab solCotizProvCab = (SolicitudCotizProvCab) condiciones.get(SolicitudCotizProvCab.NICKNAME);
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		
		if (solCotizProvCab.isNew())
			querySelect.setInt(1,0);
		else
			querySelect.setInt(1,solCotizProvCab.getOID()); 
		querySelect.setInt(2,proveedor.getOID());
		
		return querySelect;	  
	  }
  
  
  private PreparedStatement selectBySolicitudCotizacion(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cpSolCotizProv "); 
	textSQL.append(" WHERE oid_cco_sol_cotiz  = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	SolicitudCotizProvCab solCotizProv = (SolicitudCotizProvCab) aCondiciones; 
	querySelect.setInt(1,solCotizProv.getOID()); 
	return querySelect;	  
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sol_cotiz_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpSolCotizProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getSolicitudesCotizProveedor(SolicitudCotizProvCab solicitudCotizacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SolicitudCotizProveedor.NICKNAME,
             DBSolicitudCotizProveedor.SELECT_BY_SOLICITUD_COTIZ,
             solicitudCotizacion,
             new ListObserver(),
             aSesion);
  }
  
  public static SolicitudCotizProveedor getSolicitudCotizProveedor(
		  SolicitudCotizProvCab solCotizProvCab,
		  Proveedor proveedor,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(SolicitudCotizProvCab.NICKNAME, solCotizProvCab);
	  condiciones.put(Proveedor.NICKNAME, proveedor);
	  
	  return (SolicitudCotizProveedor) ObjetoLogico.getObjects(SolicitudCotizProveedor.NICKNAME,
			  				DBSolicitudCotizProveedor.SELECT_BY_SOL_COTIZ_PROV,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
