package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ComproProvAAutorizar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproProvAAutorizar extends DBObjetoPersistente {

  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String OID_CCO = "oid_cco";
  public static final String TC_EXT = "tc_ext";
  public static final String LETRA = "letra";
  public static final String LUG_EMI = "lug_emi";
  public static final String NRO_EXT = "nro_ext";
  public static final String OID_TRAN_PROV = "oid_tran_prov";
  public static final String IMPORTE = "importe";
  public static final String SALDO = "saldo";
  public static final String IMPUTAC = "imputac";
  public static final String EMISION = "emision";
  public static final String VTO = "vto";
  public static final String IMPORTECUOTA = "importeCuota";
  public static final String SALDOCUOTA = "saldoCuota";
  public static final String OID_AUTORIZ_FACT = "oid_autoriz_fact";
  public static final String PORC_AUTORIZ = "porc_autoriz";
  public static final String MONTO_AUTORIZ = "monto_autoriz";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String APELLIDO = "apellido";
  public static final String NOMBRE = "nombre";
  public static final String FEC_AUTORIZ = "fec_autoriz";
  public static final String MONEDA = "moneda";
  public static final String RS_PROVEEDOR = "rs_proveedor";
  public static final String COD_PROVEEDOR = "cod_proveedor";
  public static final String ESTADO = "estado";

  public static final int SELECT_COMPRO_PROV_A_AUTORIZAR = 100;

  public DBComproProvAAutorizar() {
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
      case SELECT_COMPRO_PROV_A_AUTORIZAR: {
        ps = this.selectByComproProvPendAprov(aCondiciones);
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

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {
    return null;
  }

  private PreparedStatement selectByComproProvPendAprov(Object aCondiciones) throws BaseException, SQLException {

    Hashtable condiciones = (Hashtable) aCondiciones;
    Proveedor proveedor = (Proveedor)condiciones.get(Proveedor.NICKNAME);
    TipoCtaCteProv tipoCtaCteProv = (TipoCtaCteProv)condiciones.get(TipoCtaCteProv.NICKNAME);
    java.util.Date fecha = (java.util.Date)condiciones.get("fecha");
    java.util.Date fechaDesde = (java.util.Date)condiciones.get("FECHA_DESDE");
    java.util.Date fechaHasta = (java.util.Date)condiciones.get("FECHA_HASTA");
    String tipoConsulta = (String)condiciones.get("TIPO_CONSULTA");
    int nroParam = 0;

    StringBuffer textSQL = new StringBuffer();

    textSQL.append(" select ");
    textSQL.append("   tranProvVto.oid_tran_vto, ");
    textSQL.append("   comproCab.oid_cco, ");
    textSQL.append("   comproCab.tc_ext, ");
    textSQL.append("   comproCab.letra, ");
    textSQL.append("   comproCab.lug_emi, ");
    textSQL.append("   comproCab.nro_ext, ");
    textSQL.append("   tranProv.emision, ");
    textSQL.append("   tranProv.imputac, ");
    textSQL.append("   monedas.codigo moneda,   ");
    textSQL.append("   tranProvVto.vto, ");
    textSQL.append("   tranProvVto.importe importeCuota, ");
    textSQL.append("   tranProvVto.saldo saldoCuota, ");
    textSQL.append("   tranProv.oid_tran_prov, ");
    textSQL.append("   tranProv.importe, ");
    textSQL.append("   tranProv.saldo,   ");
    textSQL.append("   autorizFactProv.oid_autoriz_fact, ");
    textSQL.append("   autorizFactProv.porc_autoriz, ");
    textSQL.append("   autorizFactProv.monto_autoriz, ");
    textSQL.append("   autorizFactProv.fec_autoriz, ");
    textSQL.append("   autorizFactProv.oid_usuario, ");
    textSQL.append("   usuario.apellido, ");
    textSQL.append("   usuario.nombre, ");
    textSQL.append("   proveedores.codigo cod_proveedor,");
    textSQL.append("   proveedores.razon_social rs_proveedor,");
    textSQL.append("   autorizFactProv.estado ");
    textSQL.append("  from ");
    textSQL.append("   geComproCab comproCab, ");
    textSQL.append("   cpComproProv comproProv, ");
    textSQL.append("   cpTranProv tranProv,  ");
    textSQL.append("   cpTranProvVto tranProvVto, ");
    textSQL.append("   geMonedas monedas, ");
    textSQL.append("   cpAutorizFactProv autorizFactProv, ");
    textSQL.append("   seUsuarios usuario, ");
    textSQL.append("   geTipoCompro tipoCompro, ");
    textSQL.append("   cpProveedores proveedores ");
    textSQL.append(" where ");
    textSQL.append("   comproCab.oid_cco = comproProv.oid_cco and ");
    textSQL.append("   tranProv.oid_cco = comproProv.oid_cco and ");
    textSQL.append("   proveedores.oid_proveedor = comproProv.oid_proveedor and ");
    textSQL.append("   tranProvVto.oid_tran_prov = tranProv.oid_tran_prov and ");
    textSQL.append("   comproProv.oid_moneda = monedas.oid_moneda and ");
    textSQL.append("   autorizFactProv.oid_tran_vto = tranProvVto.oid_tran_vto and ");
    textSQL.append("   autorizFactProv.oid_usuario = usuario.oid_usuario and ");
    textSQL.append("   tipoCompro.oid_tc = comproCab.oid_tc and ");
    textSQL.append("   tipoCompro.identificacion in ('NDPROV','FAPRO') ");
    textSQL.append("   and comproCab.activo = 1 ");
     
    
    if (tipoConsulta!=null) {
    	
    	// MIS PENDIENTES DE AUTORIZACION
    	if (tipoConsulta.equals("MIS_PEND_AUT")) {
    		textSQL.append("   and tranProvVto.pendiente = 1  ");
    		textSQL.append("   and (tranProvVto.oid_tran_vto in ( ");
    	    textSQL.append("   select "); 
    	    textSQL.append("     oid_tran_vto "); 
        	textSQL.append("   from ");
    	    textSQL.append("    cpAutorizFactProv where ");
    	    textSQL.append("    	(estado=0 and oid_autoriz_fact in ( ");
    	    textSQL.append("    	select oid_autoriz_fact from cpAutorizFPRoles where estado=0 and oid_rol_autoriz in ( ");
    	    textSQL.append("        select oid_rol_autoriz from cpUsuRolAutoriz where oid_usuario="+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+")))) ");

    		textSQL.append("   or tranProvVto.oid_tran_vto in ( ");
    	    textSQL.append("   select "); 
    	    textSQL.append("     oid_tran_vto "); 
        	textSQL.append("   from ");
    	    textSQL.append("    cpAutorizFactProv where ");
    	    textSQL.append("    	(porc_autoriz<>100 and oid_autoriz_fact in ( ");
    	    textSQL.append("    	select oid_autoriz_fact from cpAutorizFPRoles where oid_rol_autoriz in ( ");
    	    textSQL.append("        select oid_rol_autoriz from cpUsuRolAutoriz where oid_usuario="+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+"))))) ");

    	    
    	}
    	
    	// TODOS LOS PENDIENTES DE AUTORIZACION
    	if (tipoConsulta.equals("TODOS_PEND_AUT")) {
    		textSQL.append("   and tranProvVto.pendiente = 1  ");
    		
    	  textSQL.append("   and (porc_autoriz<>100 or tranProvVto.oid_tran_vto in ( ");
    	  textSQL.append("   select "); 
    	  textSQL.append("     oid_tran_vto "); 
    	  textSQL.append("   from "); 
    	  textSQL.append("    cpAutorizFactProv where estado=0 )) ");
    	  
    	  
    	}    	
    	
    	// AUTORIZADOS ENTRE DOS FECHAS
    	if (tipoConsulta.equals("AUTORIZADOS")) {
    		textSQL.append("   and tranProvVto.oid_tran_vto in ( ");
    	  textSQL.append("   select "); 
    	  textSQL.append("     oid_tran_vto "); 
    	  textSQL.append("   from "); 
    	  textSQL.append("    cpAutorizFactProv where estado=1 and fec_autoriz>=? and fec_autoriz<=? ) ");     	
    	}    	
    	
    	// RECHAZADOS ENTRE DOS FECHAS
    	if (tipoConsulta.equals("RECHAZADOS")) {
    		textSQL.append("   and tranProvVto.oid_tran_vto in ( ");
    	  textSQL.append("   select "); 
    	  textSQL.append("     oid_tran_vto "); 
    	  textSQL.append("   from "); 
    	  textSQL.append("    cpAutorizFactProv where estado=2 and fec_autoriz>=? and fec_autoriz<=? ) ");     	
    	}    	
    	
    	
    }

    if (proveedor!=null)
      textSQL.append(" and comproProv.oid_proveedor="+proveedor.getOIDInteger().toString());

    if (tipoCtaCteProv!=null)
      textSQL.append(" and tranProv.oid_tipo_cta_prov="+tipoCtaCteProv.getOIDInteger().toString());

    if (fecha!=null) {
      textSQL.append("   and comproProv.oid_cco in ( ");
      textSQL.append("   select  ");
      textSQL.append("     a.oid_cco ");
      textSQL.append("   from ");
      textSQL.append("     geComproCab c, ");
      textSQL.append("     cpTranProv a, ");
      textSQL.append("     cpTranProvVto b ");
      textSQL.append("   where ");
      textSQL.append("     c.oid_cco = a.oid_cco and ");
      textSQL.append("     a.oid_tran_prov = b.oid_tran_prov and ");
      textSQL.append("     b.pendiente = 1 and vto<=? ) ");
    }
    
    
    // UNIR UN QUERY PARA TRAER TAMBIEN LOS ANTICIPOS
    textSQL.append("     UNION ALL ");
    textSQL.append("     select ");  
    textSQL.append("       0 oid_tran_vto, ");  
    textSQL.append("       comproCab.oid_cco, ");  
    textSQL.append("       comproCab.tc_ext, ");  
    textSQL.append("       comproCab.letra, ");  
    textSQL.append("       comproCab.lug_emi, ");  
    textSQL.append("       comproCab.nro_ext, ");  
    textSQL.append("       comproCab.emision, ");  
    textSQL.append("       comproCab.imputac, ");  
    textSQL.append("       monedas.codigo moneda, ");    
    textSQL.append("       comproCab.emision vto, ");  
    textSQL.append("       comproProv.tot_mon_ori*-1 importeCuota, ");  
    textSQL.append("       comproProv.tot_mon_ori*-1 saldoCuota, ");  
    textSQL.append("       0 oid_tran_prov, ");  
    textSQL.append("       comproProv.tot_mon_ori*-1 importe, ");  
    textSQL.append("       comproProv.tot_mon_ori*-1 saldo, ");    
    textSQL.append("       autorizFactProv.oid_autoriz_fact, ");  
    textSQL.append("       autorizFactProv.porc_autoriz, ");  
    textSQL.append("       autorizFactProv.monto_autoriz, ");  
    textSQL.append("       autorizFactProv.fec_autoriz, ");  
    textSQL.append("       autorizFactProv.oid_usuario, ");  
    textSQL.append("       usuario.apellido, ");  
    textSQL.append("       usuario.nombre, ");  
    textSQL.append("       proveedores.codigo cod_proveedor, "); 
    textSQL.append("       proveedores.razon_social rs_proveedor, "); 
    textSQL.append("       autorizFactProv.estado ");  
    textSQL.append("     from ");  
    textSQL.append("       geComproCab comproCab, ");  
    textSQL.append("       cpComproProv comproProv, ");  
    textSQL.append("       geMonedas monedas, ");  
    textSQL.append("       cpAutorizFactProv autorizFactProv, ");  
    textSQL.append("       seUsuarios usuario, ");  
    textSQL.append("       geTipoCompro tipoCompro, ");  
    textSQL.append("       cpProveedores proveedores ");  
    textSQL.append("     where ");  
    textSQL.append("       comproCab.oid_cco = comproProv.oid_cco and ");  
    textSQL.append("       proveedores.oid_proveedor = comproProv.oid_proveedor and ");  
    textSQL.append("       comproProv.oid_moneda = monedas.oid_moneda and ");  
    textSQL.append("       autorizFactProv.oid_cco = cpComproProv.oid_cco and ");  
    textSQL.append("       autorizFactProv.oid_usuario = usuario.oid_usuario and ");  
    textSQL.append("       tipoCompro.oid_tc = comproCab.oid_tc and ");  
    textSQL.append("       tipoCompro.identificacion in ('ANTPR') ");  
    textSQL.append("       and comproCab.activo = 1 ");
    
    if (tipoConsulta!=null) {
    	
    	// MIS PENDIENTES DE AUTORIZACION
    	if (tipoConsulta.equals("MIS_PEND_AUT")) {
    		textSQL.append("   and comproProv.anticipo_pagado = 0  ");
    		textSQL.append("   and autorizFactProv.estado = 0 ");
    		textSQL.append("   and autorizFactProv.oid_autoriz_fact in (");
    	  textSQL.append("    select oid_autoriz_fact from cpAutorizFPRoles where estado=0 and oid_rol_autoriz in ( ");
    	  textSQL.append("          select oid_rol_autoriz from cpUsuRolAutoriz where oid_usuario="+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+")) ");     	
    	}
    	
    	// TODOS LOS PENDIENTES DE AUTORIZACION
    	if (tipoConsulta.equals("TODOS_PEND_AUT")) {
    		textSQL.append("   and comproProv.anticipo_pagado = 0  ");
    		textSQL.append("   and autorizFactProv.estado = 0 ");
    	}    	
    	
    	// AUTORIZADOS ENTRE DOS FECHAS
    	if (tipoConsulta.equals("AUTORIZADOS")) {
    		textSQL.append("   and autorizFactProv.estado = 1 and fec_autoriz>=? and fec_autoriz<=? ");
    	}    	
    	
    	// RECHAZADOS ENTRE DOS FECHAS
    	if (tipoConsulta.equals("RECHAZADOS")) {
    		textSQL.append("   and autorizFactProv.estado = 2 and fec_autoriz>=? and fec_autoriz<=? ");
    	}    	
    	
    	
    }    
    

    PreparedStatement querySelect = getSesion().getConexionBD().
        prepareStatement(textSQL.toString());
    
    if (fecha!=null) {
    	++nroParam;
      querySelect.setDate(nroParam,new java.sql.Date(fecha.getTime()));
    }
    
    if (tipoConsulta.equals("AUTORIZADOS") || tipoConsulta.equals("RECHAZADOS")) {
    	if (fechaDesde!=null) {
    		++nroParam;
    		querySelect.setDate(nroParam,new java.sql.Date(fechaDesde.getTime()));
    	}
    
    	if (fechaHasta!=null) {
    		++nroParam;
    		querySelect.setDate(nroParam,new java.sql.Date(fechaHasta.getTime()));
    	}
    	if (fechaDesde!=null) {
    		++nroParam;
    		querySelect.setDate(nroParam,new java.sql.Date(fechaDesde.getTime()));
    	}
    
    	if (fechaHasta!=null) {
    		++nroParam;
    		querySelect.setDate(nroParam,new java.sql.Date(fechaHasta.getTime()));
    	}
    	
    	
    }
    
    return querySelect;

  }

  public static List getComproProvPendAutoriz(String tipoConsulta,
  																						java.util.Date fechaDesde,
  																						java.util.Date fechaHasta,
  																					  Proveedor proveedor,
                                              TipoCtaCteProv tipoCtaCteProv,
                                              java.util.Date fecha,
                                              ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    if (proveedor != null)
      condiciones.put(Proveedor.NICKNAME,proveedor);
    if (tipoCtaCteProv != null)
      condiciones.put(TipoCtaCteProv.NICKNAME,tipoCtaCteProv);
    if (fecha != null)
      condiciones.put("fecha",fecha);
    if (tipoConsulta!=null)
    	condiciones.put("TIPO_CONSULTA",tipoConsulta);
    if (fechaDesde!=null)
    	condiciones.put("FECHA_DESDE",fechaDesde);
    if (fechaHasta!=null)
    	condiciones.put("FECHA_HASTA",fechaHasta);
    

    return (List) ObjetoLogico.getObjects(ComproProvAAutorizar.NICKNAME,
                                          DBComproProvAAutorizar.SELECT_COMPRO_PROV_A_AUTORIZAR,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }





}
