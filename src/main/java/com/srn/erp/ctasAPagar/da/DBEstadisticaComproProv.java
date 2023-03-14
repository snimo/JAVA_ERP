package com.srn.erp.ctasAPagar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.EstadisticaComproProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBEstadisticaComproProv extends DBObjetoPersistente {

  public static final String EMISION = "emision";
  public static final String NRO_EXT = "nro_ext";
  public static final String OID_TC = "oid_tc";
  public static final String TC_EXT = "tc_ext";
  public static final String LETRA = "letra";
  public static final String LUG_EMI = "lug_emi";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String OID_COND_PAGO = "oid_cond_pago";
  public static final String OID_SECTOR_COMPRA = "oid_sector_compra";
  public static final String OID_CONCEPTO = "oid_concepto";
  public static final String DESC_CONCEPTO = "desc_concepto";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_UM = "oid_um";
  public static final String CANT = "cant";
  public static final String IMPORTE = "importe";
  public static final String TIPO_CTA_CTE = "oid_tipo_ctacte";
  public static final String DESC_TIPO_CTA_CTE = "desc_tipo_ctacte";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COD_PRODUCTO = "cod_producto";
  public static final String DESC_PRODUCTO = "desc_producto";
  public static final String COD_PROVEEDOR = "cod_proveedor";
  public static final String RAZON_SOCIAL = "razon_social";
  public static final String SIGNO = "signo";
  public static final String OID_CTA = "oid_cta";
  public static final String DESC_CTA = "desc_cuenta";
  public static final String CODIGO_CTA = "cod_cuenta";
  public static final String COTIZACION = "cotizacion";
  public static final String NOMBRE_PROVEEDOR = "NOMBRE_PROVEEDOR";
  public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
  
  
  
  // Mas todos los componentes de las cuentas
  
  public static final int SELECT_BY_ESTAD_COMPRO_PROV = 100;

  public DBEstadisticaComproProv() { 
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
      case SELECT_BY_ESTAD_COMPRO_PROV: {
        ps = this.selectByEstadComproProv(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    return null; 
  }
  
  private PreparedStatement selectByEstadComproProv(Object aCondiciones) throws BaseException, SQLException {

  	
  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
  	java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
  	
    StringBuffer textSQL = new StringBuffer();
    
    
    textSQL.append(" select ");
    textSQL.append(" 	b.emision, ");
    textSQL.append(" 	b.nro_ext, ");
    textSQL.append(" 	b.oid_tc, ");
    textSQL.append(" 	b.tc_ext, ");
    textSQL.append(" 	b.letra, ");
    textSQL.append(" 	b.lug_emi, ");
    textSQL.append(" 	a.oid_proveedor, ");
    textSQL.append(" 	a.oid_cond_pago_cc oid_cond_pago, ");
    textSQL.append(" 	a.oid_sector_compra, ");
    textSQL.append(" 	a.oid_tipo_cta_prov, ");
    textSQL.append(" 	c.oid_conc_fact_prov oid_concepto, ");
    textSQL.append(" 	d.descripcion desc_concepto, ");
    textSQL.append(" 	f.impo_moneda_ori importe, ");
    textSQL.append(" 	a.oid_cco, ");
    textSQL.append(" 	a.cotizacion, ");
    textSQL.append(" 	a.oid_moneda, ");
    textSQL.append(" 	e.codigo cod_proveedor, ");
    textSQL.append(" 	e.razon_social nombre_proveedor, ");
    textSQL.append(" 	f.oid_ai, ");
    textSQL.append(" 	h.codigo cod_cuenta, ");
    textSQL.append(" 	h.descripcion desc_cuenta, ");
    textSQL.append(" 	a.signo, ");
    textSQL.append(" 	g.* ");
    textSQL.append(" from ");
    textSQL.append(" 	cpComproProv a, ");
    textSQL.append(" 	geComproCab b, ");
    textSQL.append("    cpComproProvDet c, ");
    textSQL.append("    cpConcFactProv d, ");
    textSQL.append("    cpProveedores e, ");
    textSQL.append("    cpComproProvCtaImp f, ");
    textSQL.append("    cgAnaImpCon g, ");
    textSQL.append("    cgAnaCon h ");
    textSQL.append("  where ");
    textSQL.append("    a.oid_cco = b.oid_cco and ");
    textSQL.append("    c.oid_cco = a.oid_cco and ");
    textSQL.append("    d.oid_conc_fact_prov = c.oid_conc_fact_prov and ");
    textSQL.append("    a.oid_proveedor = e.oid_proveedor and ");
    textSQL.append("    f.oid_cco_prov_det = c.oid_cco_prov_det and f.activo=1 and ");
    textSQL.append("    f.oid_ai = g.oid_ai and ");
    textSQL.append("    g.oid_ana_con = h.oid_ana_con  ");
    textSQL.append("   and b.emision>=? and ");
    textSQL.append("   b.emision<=? and a.es_estadistica=1 ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setDate(1, new Date(fechaDesde.getTime()));
    querySelect.setDate(2, new Date(fechaHasta.getTime()));
    
    
    return querySelect; 
  	
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    return null; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    return null; 
  }
  
  public static List getEstadisticaComproProv(java.util.Date fechaDesde,
  																				 java.util.Date fechaHasta,
  																				 ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put("FECHA_DESDE",fechaDesde);
  	condiciones.put("FECHA_HASTA",fechaHasta);
  	return (List) ObjetoLogico.getObjects(EstadisticaComproProv.NICKNAME,
  		 DBEstadisticaComproProv.SELECT_BY_ESTAD_COMPRO_PROV,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  
} 
