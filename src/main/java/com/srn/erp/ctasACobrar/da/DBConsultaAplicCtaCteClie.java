package com.srn.erp.ctasACobrar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaAplicCtaCteClie;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaAplicCtaCteClie extends DBObjetoPersistente {

  public static final String OID_APL_CLIE = "oid_apl_clie";
  public static final String OID_SUJETO = "oid_sujeto";
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
  public static final String OID_TIPO_CTA_CLIE = "oid_tipo_cta_clie";
  public static final String IMPORTE = "importe";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String ALLOW_DESAPLICAR = "allow_desaplicar";
  
  public static final int SELECT_BY_CLIE_TIPOCTA_FECHAS = 100;

  public DBConsultaAplicCtaCteClie() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
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
      case SELECT_BY_CLIE_TIPOCTA_FECHAS: {
          ps = this.selectByClieTipoCtaFechas(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    return null; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
    return null; 
  }
  
  private PreparedStatement selectByClieTipoCtaFechas(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" select ");
	    textSQL.append(" a.oid_apl_clie, ");
	    textSQL.append(" a.oid_sujeto, ");
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
	    textSQL.append(" a.oid_tipo_cta_clie,");
	    textSQL.append(" a.importe,a.oid_moneda, ");
	    textSQL.append(" e.allow_desaplicar ");
	    textSQL.append(" from ");
	    textSQL.append(" veAplClie a, ");
	    textSQL.append(" geComproCab b, ");
	    textSQL.append(" geComproCab c, ");
	    textSQL.append(" veTranClieVto d, ");
	    textSQL.append(" veComproClieApl e ");	
	    textSQL.append(" where ");
	    textSQL.append(" a.oid_cco = b.oid_cco and ");
	    textSQL.append(" c.oid_cco = a.oid_cco_ori and ");
	    textSQL.append(" d.oid_tran_vto = a.oid_tran_vto and ");
	    textSQL.append(" e.oid_cco = a.oid_cco and ");
	    textSQL.append(" a.imputac>=? and a.imputac<=? ");
	    
	    if (condiciones.get(Sujeto.NICKNAME)!=null) {
	    	Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
	    	textSQL.append(" and a.oid_sujeto="+sujeto.getOIDInteger().toString());   
	    }
	    
	    if (condiciones.get(TipoCtaCteClie.NICKNAME)!=null) {
	    	TipoCtaCteClie tipoCtaCteClie = (TipoCtaCteClie) condiciones.get(TipoCtaCteClie.NICKNAME);
	    	textSQL.append(" and a.oid_tipo_cta_clie ="+tipoCtaCteClie.getOIDInteger().toString());   
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
    return null; 
  }
  
  public static List getConsAplic(Sujeto sujeto,
		  						  TipoCtaCteClie tipoCtaCteClie,
		  						  java.util.Date fechaDesde,
		  						  java.util.Date fechaHasta,ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (sujeto!=null)
	    condiciones.put(Sujeto.NICKNAME,sujeto);
	  if (tipoCtaCteClie!=null)
		  condiciones.put(TipoCtaCteClie.NICKNAME,tipoCtaCteClie);
	  condiciones.put("FECHA_DESDE",fechaDesde);
	  condiciones.put("FECHA_HASTA",fechaHasta);
	  return (List) ObjetoLogico.getObjects(ConsultaAplicCtaCteClie.NICKNAME,
             DBConsultaAplicCtaCteClie.SELECT_BY_CLIE_TIPOCTA_FECHAS,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
