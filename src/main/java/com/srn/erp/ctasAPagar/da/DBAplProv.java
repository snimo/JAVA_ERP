package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.AplProv;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAplProv extends DBObjetoPersistente {

  public static final String OID_APL_PROV = "oid_apl_prov";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String IMPORTE = "importe";
  public static final String IMPUTAC = "imputac";
  public static final String DIAS_BASE = "dias_base";
  public static final String DIAS_VTO = "dias_vto";
  public static final String OID_CCO_ORI = "oid_cco_ori";
  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String OID_TRAN_VTO_ORI = "oid_tran_vto_ori";
  public static final String EMISION = "emision";
  public static final String COTIZ_MON_ORI = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";
  public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";
  
  public static final int SELECT_BY_COMPRO_APLIC = 100;
  public static final int SELECT_APLIC_ACTIVAS_COMPRO = 101;
  public static final int SELECT_APLIC_ACTIVAS_COMPRO_ORI = 102;

  public DBAplProv() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_APL_PROV = 1;
    final int OID_CCO = 2;
    final int OID_TIPO_CTA_PROV = 3;
    final int OID_PROVEEDOR = 4;
    final int OID_MONEDA = 5;
    final int IMPORTE = 6;
    final int IMPUTAC = 7;
    final int EMISION = 8;
    final int DIAS_BASE = 9;
    final int DIAS_VTO = 10;
    final int OID_CCO_ORI = 11;
    final int OID_TRAN_VTO = 12;
    final int OID_TRAN_VTO_ORI = 13;
    final int COTIZ_MON_ORI = 14;
    final int COTIZ_MON_EXT1 = 15;
    final int COTIZ_MON_EXT2 = 16;


    AplProv pers = (AplProv) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAplProv "+
                     " ( "+
                      "OID_APL_PROV,"+
                      "OID_CCO,"+
                      "OID_TIPO_CTA_PROV,"+
                      "OID_PROVEEDOR,"+
                      "OID_MONEDA,"+
                      "IMPORTE,"+
                      "IMPUTAC,"+
                      "EMISION,"+
                      "DIAS_BASE,"+
                      "DIAS_VTO,"+
                      "OID_CCO_ORI,"+
                      "OID_TRAN_VTO,"+
                      "OID_TRAN_VTO_ORI,"+
                      "COTIZ_MON_ORI,"+
                      "COTIZ_MON_EXT1,"+
                      "COTIZ_MON_EXT2"+
                      ")"+
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
    qInsert.setInt(OID_APL_PROV,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobanteapl().getOID());
    qInsert.setInt(OID_TIPO_CTA_PROV,pers.getTipoctaprov().getOID());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDate(IMPUTAC,new java.sql.Date(pers.getFecimputac().getTime()));
    qInsert.setDate(EMISION,new java.sql.Date(pers.getEmision().getTime()));
    qInsert.setInt(DIAS_BASE,pers.getDiasbase().intValue());
    qInsert.setInt(DIAS_VTO,pers.getDiasvto().intValue());
    qInsert.setInt(OID_CCO_ORI,pers.getComprobanteori().getOID());
    qInsert.setInt(OID_TRAN_VTO,pers.getTranprovvto().getOID());
    if (pers.getTranprovvtoOri()!=null)
      qInsert.setInt(OID_TRAN_VTO_ORI,pers.getTranprovvtoOri().getOID());
    else
      qInsert.setNull(OID_TRAN_VTO_ORI,java.sql.Types.INTEGER);
    qInsert.setDouble(COTIZ_MON_ORI,pers.getCotizMonOri().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1,pers.getCotizMonExt1().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2,pers.getCotizMonExt2().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_TIPO_CTA_PROV = 2;
    final int OID_PROVEEDOR = 3;
    final int OID_MONEDA = 4;
    final int IMPORTE = 5;
    final int IMPUTAC = 6;
    final int EMISION = 7;
    final int DIAS_BASE = 8;
    final int DIAS_VTO = 9;
    final int OID_CCO_ORI = 10;
    final int OID_TRAN_VTO = 11;
    final int OID_TRAN_VTO_ORI = 12;
    final int COTIZ_MON_ORI = 13;
    final int COTIZ_MON_EXT1 = 14;
    final int COTIZ_MON_EXT2 = 15;
    final int OID_APL_PROV = 16;

    AplProv pers = (AplProv) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAplProv set "+
              "oid_cco=?"+
              ",oid_tipo_cta_prov=?"+
              ",oid_proveedor=?"+
              ",oid_moneda=?"+
              ",importe=?"+
              ",imputac=?"+
              ",emision=?"+
              ",dias_base=?"+
              ",dias_vto=?"+
              ",oid_cco_ori=?"+
              ",oid_tran_vto=?"+
              ",oid_tran_vto_ori=?"+
              ",COTIZ_MON_ORI=?"+
              ",COTIZ_MON_EXT1=?"+
              ",COTIZ_MON_EXT2=?"+
                 " where " +
                 " oid_apl_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_APL_PROV,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobanteapl().getOID());
    qUpdate.setInt(OID_TIPO_CTA_PROV,pers.getTipoctaprov().getOID());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDate(IMPUTAC,new java.sql.Date(pers.getFecimputac().getTime()));
    qUpdate.setDate(EMISION,new java.sql.Date(pers.getEmision().getTime()));
    qUpdate.setInt(DIAS_BASE,pers.getDiasbase().intValue());
    qUpdate.setInt(DIAS_VTO,pers.getDiasvto().intValue());
    qUpdate.setInt(OID_CCO_ORI,pers.getComprobanteori().getOID());
    qUpdate.setInt(OID_TRAN_VTO,pers.getTranprovvto().getOID());
    if (pers.getTranprovvtoOri()!=null)
      qUpdate.setInt(OID_TRAN_VTO_ORI,pers.getTranprovvtoOri().getOID());
    else
      qUpdate.setNull(OID_TRAN_VTO_ORI,java.sql.Types.INTEGER);
    qUpdate.setDouble(COTIZ_MON_ORI,pers.getCotizMonOri().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1,pers.getCotizMonExt1().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2,pers.getCotizMonExt2().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_APL_PROV = 1;
    AplProv pers = (AplProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from  cpAplProv "+
                     " where " +
                     " oid_apl_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_APL_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_APL_PROV = 1;
    AplProv pers = (AplProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpAplProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_apl_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_APL_PROV, pers.getOID());
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
      case SELECT_BY_COMPRO_APLIC: {
          ps = this.selectByComproAplic(aCondiciones);
          break;    	  
      }
      case SELECT_APLIC_ACTIVAS_COMPRO_ORI: {
          ps = this.selectByComproAplicOri(aCondiciones);
          break;    	  
      }
      case SELECT_APLIC_ACTIVAS_COMPRO: {
          ps = this.selectAplicActivasCompro(aCondiciones);
          break;    	  
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_APL_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpAplProv ");
    textSQL.append(" WHERE oid_apl_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_APL_PROV, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByComproAplicOri(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAplProv a , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.oid_cco_ori = ? and b.activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ComproCab compro = (ComproCab) aCondiciones;
		querySelect.setInt(1, compro.getOID());
		return querySelect;
	}
  
  
  private PreparedStatement selectByComproAplic(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cpAplProv ");
	    textSQL.append(" WHERE oid_cco = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    AplicacionComproProv aplicComproProv = (AplicacionComproProv) aCondiciones;
	    querySelect.setInt(1, aplicComproProv.getOID());
	    return querySelect;
  }
  
  private PreparedStatement selectAplicActivasCompro(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT a.* FROM  cpAplProv a, geComproCab b  ");
	    textSQL.append(" WHERE a.oid_cco = b.oid_cco and b.activo = 1 and a.oid_tran_vto in (select OID_TRAN_VTO from cpTranProv f , cpTranProvVto g where f.oid_tran_prov = g.oid_tran_prov and f.OID_CCO = ? ) ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    ComproCab comproCab = (ComproCab) aCondiciones;
	    querySelect.setInt(1, comproCab.getOID());
	    return querySelect;
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpAplProv ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_apl_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAplProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getAplicacionesProveedor(AplicacionComproProv aplicComproProv,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplProv.NICKNAME,
             DBAplProv.SELECT_BY_COMPRO_APLIC,
             aplicComproProv,
             new ListObserver(),
             aSesion);
  }
  
  public static List getAplicacionesActivasCompro(ComproCab aComproCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplProv.NICKNAME,
             DBAplProv.SELECT_APLIC_ACTIVAS_COMPRO,
             aComproCab,
             new ListObserver(),
             aSesion);
  }
  
  public static List getAplicacionesActivasDelCompro(ComproCab aComproCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplProv.NICKNAME,
             DBAplProv.SELECT_APLIC_ACTIVAS_COMPRO_ORI,
             aComproCab,
             new ListObserver(),
             aSesion);
  }
  
  
  

}
