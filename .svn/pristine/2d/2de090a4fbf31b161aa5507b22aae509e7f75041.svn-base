package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBSolicitudCotizProvCab extends DBObjetoPersistente {

  public static final String OID_CCO_SOL_COTIZ = "oid_cco_sol_cotiz";
  public static final String FEC_TOPE_ENT_SOL = "fec_tope_ent_sol";
  public static final String OBS_DETALLADAS = "obs_detalladas";
  
  
  public static final int SELECT_BY_CONDICIONES = 100;
  public static final int SELECT_NRO_EXT_PROV = 101;

  public DBSolicitudCotizProvCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_SOL_COTIZ = 1;
    final int FEC_TOPE_ENT_SOL = 2;
    final int OBS_DETALLADAS = 3;

    SolicitudCotizProvCab pers = (SolicitudCotizProvCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpSolCotizCab "+
                     " ( "+
                      "OID_CCO_SOL_COTIZ,"+
                      "FEC_TOPE_ENT_SOL,"+
                      "OBS_DETALLADAS)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO_SOL_COTIZ,pers.getOID());
    qInsert.setDate(FEC_TOPE_ENT_SOL,new Date(pers.getFec_tope_ent_sol().getTime()));
    if (pers.getObs_detalladas()!=null)
      qInsert.setString(OBS_DETALLADAS,pers.getObs_detalladas());
    else
      qInsert.setNull(OBS_DETALLADAS,Types.VARCHAR);    	
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_TOPE_ENT_SOL = 1;
    final int OBS_DETALLADAS = 2;
    final int OID_CCO_SOL_COTIZ = 3;

    SolicitudCotizProvCab pers = (SolicitudCotizProvCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpSolCotizCab set "+
              "fec_tope_ent_sol=?"+ 
              ",obs_detalladas=?"+ 
                 " where " +
                 " oid_cco_sol_cotiz=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_SOL_COTIZ,pers.getOID());
    qUpdate.setDate(FEC_TOPE_ENT_SOL,new Date(pers.getFec_tope_ent_sol().getTime()));
    if (pers.getObs_detalladas()!=null)
    	qUpdate.setString(OBS_DETALLADAS,pers.getObs_detalladas());
      else
    	qUpdate.setNull(OBS_DETALLADAS,Types.VARCHAR);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_SOL_COTIZ = 1; 
    SolicitudCotizProvCab pers = (SolicitudCotizProvCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco = ? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_SOL_COTIZ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_SOL_COTIZ = 1; 
    SolicitudCotizProvCab pers = (SolicitudCotizProvCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_SOL_COTIZ, pers.getOID()); 
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
      case SELECT_BY_CONDICIONES: {
        ps = this.selectByCondiciones(aCondiciones); 
        break; 
      }
      case SELECT_NRO_EXT_PROV: {
        ps = this.selectByNroExtProveedor(aCondiciones); 
        break;     	  
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CCO_SOL_COTIZ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geComproCab a,cpSolCotizCab b  "); 
    textSQL.append(" WHERE a.oid_cco = b.oid_cco_sol_cotiz and b.oid_cco_sol_cotiz = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO_SOL_COTIZ, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
	 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	 
	 StringBuffer textSQL = new StringBuffer(); 
	 textSQL.append("SELECT * FROM  geComproCab a , cpSolCotizCab b "); 
	 textSQL.append(" WHERE  a.oid_cco = b.oid_cco_sol_cotiz ");
	 
	 if (condiciones.containsKey("NRO_DESDE")) 
		 textSQL.append(" and a.nro_ext>="+condiciones.getInteger("NRO_DESDE").toString());
	 if (condiciones.containsKey("NRO_HASTA")) 
		 textSQL.append(" and a.nro_ext<="+condiciones.getInteger("NRO_HASTA").toString());	 
	 if (condiciones.containsKey("FEC_EMI_DESDE")) 
		 textSQL.append(" and a.emision>=?");
	 if (condiciones.containsKey("FEC_EMI_HASTA")) 
		 textSQL.append(" and a.emision<=?");
	 if (condiciones.containsKey("FEC_ENT_DESDE")) 
		 textSQL.append(" and b.fec_tope_ent_sol>=?");
	 if (condiciones.containsKey("FEC_ENT_HASTA")) 
		 textSQL.append(" and b.fec_tope_ent_sol<=?");
	 if (condiciones.containsKey(Proveedor.NICKNAME)) {
		 Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		 textSQL.append(" and b.oid_cco_sol_cotiz in (select oid_cco_sol_cotiz from cpSolCotizProv where oid_proveedor="+proveedor.getOIDInteger().toString()+")");
	 } 
     PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	 
	 int nroParam = 0;
	 if (condiciones.containsKey("FEC_EMI_DESDE")) 
		 querySelect.setDate(++nroParam,new Date(condiciones.getDate("FEC_EMI_DESDE").getTime()));
	 if (condiciones.containsKey("FEC_EMI_HASTA")) 
		 querySelect.setDate(++nroParam,new Date(condiciones.getDate("FEC_EMI_HASTA").getTime()));
	 if (condiciones.containsKey("FEC_ENT_DESDE")) 
		 querySelect.setDate(++nroParam,new Date(condiciones.getDate("FEC_ENT_DESDE").getTime()));	 
	 if (condiciones.containsKey("FEC_ENT_HASTA")) 
		 querySelect.setDate(++nroParam,new Date(condiciones.getDate("FEC_ENT_HASTA").getTime()));	 
	 return querySelect;
		 
	 
  }		  
  private PreparedStatement selectByNroExtProveedor(Object aCondiciones) throws BaseException, SQLException {
	
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	Integer nroExt = (Integer) condiciones.get("NRO_EXT");
	Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
			 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  geComproCab a , cpSolCotizCab b "); 
	textSQL.append(" WHERE  a.oid_cco = b.oid_cco_sol_cotiz ");
			 
	textSQL.append(" and a.nro_ext="+nroExt.toString());
	if (proveedor!=null)
		textSQL.append(" and b.oid_cco_sol_cotiz in (select oid_cco_sol_cotiz from cpSolCotizProv where oid_proveedor="+proveedor.getOIDInteger().toString()+") ");
	
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	return querySelect; 	  
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpSolCotizCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_sol_cotiz oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpSolCotizCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getSolicitudesCotizProvCab(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SolicitudCotizProvCab.NICKNAME,
             DBSolicitudCotizProvCab.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getSolicitudesCotizProvCab(Proveedor proveedor, Integer nroExt,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (proveedor!=null)
		  condiciones.put(Proveedor.NICKNAME,proveedor);
	  condiciones.put("NRO_EXT",nroExt); 
  
	  return (List) ObjetoLogico.getObjects(SolicitudCotizProvCab.NICKNAME,
             DBSolicitudCotizProvCab.SELECT_NRO_EXT_PROV,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  
} 
