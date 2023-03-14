package com.srn.erp.ctasAPagar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaAplicCtaCteProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaAplicCtaCteProv extends DBObjetoPersistente {

  public static final String OID_APL_PROV = "oid_apl_prov";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String OID_CCO_APL = "oid_cco_apl";
  public static final String TC_EXT_APL = "tc_ext_apl";
  public static final String LETRA_APL = "letra_apl";
  public static final String LUG_EMI_APL = "lug_emi_apl";
  public static final String NRO_EXT_APL = "nro_ext_apl";
  public static final String EMISION = "emision";
  public static final String IMPUTAC = "imputac";
  public static final String OID_CCO_APL_AUX = "oid_cco_apl_aux";
  public static final String TC_EXT_APL_AUX = "tc_ext_apl_aux";
  public static final String LETRA_APL_AUX = "letra_apl_aux";
  public static final String LUG_EMI_APL_AUX = "lug_emi_apl_aux";
  public static final String NRO_EXT_APL_AUX = "nro_ext_apl_aux";
  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
  public static final String IMPORTE = "importe";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String ALLOW_DESAPLICAR = "allow_desaplicar";
  
  public static final int SELECT_BY_PROV_TIPOCTA_FECHAS = 100;

  public DBConsultaAplicCtaCteProv() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APL_PROV = 1;
    final int OID_PROVEEDOR = 2;
    final int OID_CCO_APL = 3;
    final int TC_EXT_APL = 4;
    final int LETRA_APL = 5;
    final int LUG_EMI_APL = 6;
    final int NRO_EXT_APL = 7;
    final int EMISION = 8;
    final int IMPUTAC = 9;
    final int OID_CCO_APL_AUX = 10;
    final int TC_EXT_APL_AUX = 11;
    final int LETRA_APL_AUX = 12;
    final int LUG_EMI_APL_AUX = 13;
    final int NRO_EXT_APL_AUX = 14;
    final int OID_TRAN_VTO = 15;
    final int OID_TIPO_CTA_PROV = 16;
    final int IMPORTE = 17;

    ConsultaAplicCtaCteProv pers = (ConsultaAplicCtaCteProv) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into aaaa "+
                     " ( "+
                      "OID_APL_PROV,"+
                      "OID_PROVEEDOR,"+
                      "OID_CCO_APL,"+
                      "TC_EXT_APL,"+
                      "LETRA_APL,"+
                      "LUG_EMI_APL,"+
                      "NRO_EXT_APL,"+
                      "EMISION,"+
                      "IMPUTAC,"+
                      "OID_CCO_APL_AUX,"+
                      "TC_EXT_APL_AUX,"+
                      "LETRA_APL_AUX,"+
                      "LUG_EMI_APL_AUX,"+
                      "NRO_EXT_APL_AUX,"+
                      "OID_TRAN_VTO,"+
                      "OID_TIPO_CTA_PROV,"+
                      "IMPORTE)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_APL_PROV,pers.getOID());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setInt(OID_CCO_APL,pers.getOid_cco_apl().intValue());
    qInsert.setString(TC_EXT_APL,pers.getTc_ext_apl());
    qInsert.setString(LETRA_APL,pers.getLetra_apl());
    qInsert.setInt(LUG_EMI_APL,pers.getLug_emi_apl().intValue());
    qInsert.setInt(NRO_EXT_APL,pers.getNro_ext_apl().intValue());
    qInsert.setDate(EMISION,new java.sql.Date(pers.getEmision().getTime()));
    qInsert.setDate(IMPUTAC,new Date(pers.getImputac().getTime()));
    qInsert.setInt(OID_CCO_APL_AUX,pers.getOid_cco_apl_aux().intValue());
    qInsert.setString(TC_EXT_APL_AUX,pers.getTc_ext_apl_aux());
    qInsert.setString(LETRA_APL_AUX,pers.getLetra_apl_aux());
    qInsert.setInt(LUG_EMI_APL_AUX,pers.getLug_emi_apl_aux().intValue());
    qInsert.setInt(NRO_EXT_APL_AUX,pers.getNro_ext_apl_aux().intValue());
    qInsert.setInt(OID_TRAN_VTO,pers.getTran_vto().getOID());
    qInsert.setInt(OID_TIPO_CTA_PROV,pers.getTipo_cta_prov().getOID());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROVEEDOR = 1;
    final int OID_CCO_APL = 2;
    final int TC_EXT_APL = 3;
    final int LETRA_APL = 4;
    final int LUG_EMI_APL = 5;
    final int NRO_EXT_APL = 6;
    final int EMISION = 7;
    final int IMPUTAC = 8;
    final int OID_CCO_APL_AUX = 9;
    final int TC_EXT_APL_AUX = 10;
    final int LETRA_APL_AUX = 11;
    final int LUG_EMI_APL_AUX = 12;
    final int NRO_EXT_APL_AUX = 13;
    final int OID_TRAN_VTO = 14;
    final int OID_TIPO_CTA_PROV = 15;
    final int IMPORTE = 16;
    final int OID_APL_PROV = 17;

    ConsultaAplicCtaCteProv pers = (ConsultaAplicCtaCteProv) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update aaaa set "+
              "oid_proveedor=?"+ 
              ",oid_cco_apl=?"+ 
              ",tc_ext_apl=?"+ 
              ",letra_apl=?"+ 
              ",lug_emi_apl=?"+ 
              ",nro_ext_apl=?"+ 
              ",emision=?"+ 
              ",imputac=?"+ 
              ",oid_cco_apl_aux=?"+ 
              ",tc_ext_apl_aux=?"+ 
              ",letra_apl_aux=?"+ 
              ",lug_emi_apl_aux=?"+ 
              ",nro_ext_apl_aux=?"+ 
              ",oid_tran_vto=?"+ 
              ",oid_tipo_cta_prov=?"+ 
              ",importe=?"+ 
                 " where " +
                 " oid_apl_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APL_PROV,pers.getOID());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setInt(OID_CCO_APL,pers.getOid_cco_apl().intValue());
    qUpdate.setString(TC_EXT_APL,pers.getTc_ext_apl());
    qUpdate.setString(LETRA_APL,pers.getLetra_apl());
    qUpdate.setInt(LUG_EMI_APL,pers.getLug_emi_apl().intValue());
    qUpdate.setInt(NRO_EXT_APL,pers.getNro_ext_apl().intValue());
    qUpdate.setDate(EMISION,new java.sql.Date(pers.getEmision().getTime()));
    qUpdate.setDate(IMPUTAC,new Date(pers.getImputac().getTime()));
    qUpdate.setInt(OID_CCO_APL_AUX,pers.getOid_cco_apl_aux().intValue());
    qUpdate.setString(TC_EXT_APL_AUX,pers.getTc_ext_apl_aux());
    qUpdate.setString(LETRA_APL_AUX,pers.getLetra_apl_aux());
    qUpdate.setInt(LUG_EMI_APL_AUX,pers.getLug_emi_apl_aux().intValue());
    qUpdate.setInt(NRO_EXT_APL_AUX,pers.getNro_ext_apl_aux().intValue());
    qUpdate.setInt(OID_TRAN_VTO,pers.getTran_vto().getOID());
    qUpdate.setInt(OID_TIPO_CTA_PROV,pers.getTipo_cta_prov().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APL_PROV = 1; 
    ConsultaAplicCtaCteProv pers = (ConsultaAplicCtaCteProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update aaaa "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_apl_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APL_PROV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APL_PROV = 1; 
    ConsultaAplicCtaCteProv pers = (ConsultaAplicCtaCteProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update aaaa "+
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
      case SELECT_BY_PROV_TIPOCTA_FECHAS: {
          ps = this.selectByProvTipoCtaFechas(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_APL_PROV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  aaaa "); 
    textSQL.append(" WHERE oid_apl_prov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_APL_PROV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  aaaa "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByProvTipoCtaFechas(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" select ");
	    textSQL.append(" a.oid_apl_prov, ");
	    textSQL.append(" a.oid_proveedor, ");
	    textSQL.append(" c.oid_cco oid_cco_apl,");
	    textSQL.append(" c.tc_ext tc_ext_apl,");
	    textSQL.append(" c.letra letra_apl,");
	    textSQL.append(" c.lug_emi lug_emi_apl,");
	    textSQL.append(" c.nro_ext nro_ext_apl,");
	    textSQL.append(" c.emision,");
	    textSQL.append(" c.imputac,");
	    textSQL.append(" b.oid_cco oid_cco_apl_aux,");
	    textSQL.append(" b.tc_ext tc_ext_apl_aux,");
	    textSQL.append(" b.letra letra_apl_aux,");
	    textSQL.append(" b.lug_emi lug_emi_apl_aux,");
	    textSQL.append(" b.nro_ext nro_ext_apl_aux,");
	    textSQL.append(" a.oid_tran_vto,");
	    textSQL.append(" a.oid_tipo_cta_prov,");
	    textSQL.append(" a.importe,a.oid_moneda, ");
	    textSQL.append(" e.allow_desaplicar ");
	    textSQL.append(" from ");
	    textSQL.append(" cpAplProv a, ");
	    textSQL.append(" geComproCab b, ");
	    textSQL.append(" geComproCab c, ");
	    textSQL.append(" cpTranProvVto d, ");
	    textSQL.append(" cpComproProvApl e ");
	    textSQL.append(" where ");
	    textSQL.append(" a.oid_cco = b.oid_cco and ");
	    textSQL.append(" c.oid_cco = a.oid_cco_ori and ");
	    textSQL.append(" d.oid_tran_vto = a.oid_tran_vto and ");
	    textSQL.append(" e.oid_cco = a.oid_cco and ");
	    textSQL.append(" a.imputac>=? and a.imputac<=? ");
	    
	    if (condiciones.get(Proveedor.NICKNAME)!=null) {
	    	Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
	    	textSQL.append(" and a.oid_proveedor="+proveedor.getOIDInteger().toString());   
	    }
	    
	    if (condiciones.get(TipoCtaCteProv.NICKNAME)!=null) {
	    	TipoCtaCteProv tipoCtaCteProv = (TipoCtaCteProv) condiciones.get(TipoCtaCteProv.NICKNAME);
	    	textSQL.append(" and a.oid_tipo_cta_prov ="+tipoCtaCteProv.getOIDInteger().toString());   
	    }
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
	    java.sql.Date fechaDesde = new java.sql.Date(fecDesde.getTime());

	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
	    java.sql.Date fechaHasta = new java.sql.Date(fecHasta.getTime());
 
	    querySelect.setDate(1, fechaDesde);
	    querySelect.setDate(2, fechaHasta);
	    
	    return querySelect; 
	  
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_apl_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from aaaa");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConsAplic(Proveedor proveedor,
		  						  TipoCtaCteProv tipoCtaCteProv,
		  						  java.util.Date fechaDesde,
		  						  java.util.Date fechaHasta,ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (proveedor!=null)
	    condiciones.put(Proveedor.NICKNAME,proveedor);
	  if (tipoCtaCteProv!=null)
		  condiciones.put(TipoCtaCteProv.NICKNAME,tipoCtaCteProv);
	  condiciones.put("FECHA_DESDE",fechaDesde);
	  condiciones.put("FECHA_HASTA",fechaHasta);
	  return (List) ObjetoLogico.getObjects(ConsultaAplicCtaCteProv.NICKNAME,
             DBConsultaAplicCtaCteProv.SELECT_BY_PROV_TIPOCTA_FECHAS,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
