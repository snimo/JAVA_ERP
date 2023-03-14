package com.srn.erp.ctasAPagar.op;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.AutorizRolesFactProv;
import com.srn.erp.ctasAPagar.bm.ComproProvAAutorizar;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComproProvPendAprob extends Operation {

	public TraerComproProvPendAprob() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsVista = this.getVistaAutorizaciones();
		
		String tipoConsulta = mapaDatos.getString("tipo_consulta");
		
		Date fechaDesde = null;
		Date fechaHasta = null; 
			
		if (mapaDatos.containsKey("fecha_desde"))
		    fechaDesde = mapaDatos.getDate("fecha_desde");
		if (mapaDatos.containsKey("fecha_hasta"))
		    fechaHasta = mapaDatos.getDate("fecha_hasta");
		
		// Proveedor		
		Proveedor proveedor = null;
		
		if (mapaDatos.containsKey("oid_proveedor")) {
		  Integer oidProveedor = mapaDatos.getInteger("oid_proveedor");
		  if (oidProveedor.intValue() != 0)
		  	proveedor = Proveedor.findByOidProxy(oidProveedor, getSesion());
		}

		// TipoCuentaProveedor
		TipoCtaCteProv tipoCtaCteProv = null;
		if (mapaDatos.containsKey("oid_tipo_cta_prov")) {
		  Integer oidTipoCtaProv = mapaDatos.getInteger("oid_tipo_cta_prov");		
		  if (oidTipoCtaProv.intValue() != 0)
		  	tipoCtaCteProv = TipoCtaCteProv.findByOidProxy(oidTipoCtaProv, getSesion());
		}

		// Fecha
		java.util.Date fecha = null;
		if (mapaDatos.containsKey("fecha")) {
		  if (!mapaDatos.getString("fecha").equals(""))
			  fecha = mapaDatos.getDate("fecha");
		}
		
		List listComproProvPendAutoriz = ComproProvAAutorizar.getComproProvPendAutoriz(tipoConsulta,fechaDesde,fechaHasta,proveedor, tipoCtaCteProv, fecha,
				getSesion());

		Iterator iterComproProvPendAutoriz = listComproProvPendAutoriz.iterator();
		while (iterComproProvPendAutoriz.hasNext()) {

			ComproProvAAutorizar comproProvAAutorizar = (ComproProvAAutorizar) iterComproProvPendAutoriz.next();

			Money montoAutorizado = comproProvAAutorizar.getMontoAutorizado();
			Money porcAutorizado  = comproProvAAutorizar.getPorcautoriz();
			
			if (comproProvAAutorizar.getEstado().intValue() == OrdenDeCompraCab.PEND_AUTORIZ) {
				if ((montoAutorizado == null) || (montoAutorizado.doubleValue() == 0)) {
					//montoAutorizado = comproProvAAutorizar.getImportecuota();
					//porcAutorizado = new Money(100);
				}
				
			}
			
			Integer oidTranProvVto = new Integer(0);
			if (comproProvAAutorizar.getTranprovVto()!=null) 
				oidTranProvVto = comproProvAAutorizar.getTranprovVto().getOIDInteger();
			
			Integer oidTranProv = new Integer(0);
			if (comproProvAAutorizar.getTranprov()!=null)
				oidTranProv = comproProvAAutorizar.getTranprov().getOIDInteger();
			
			cargarVistaAutorizaciones(
					dsVista, 
					oidTranProv, 
					oidTranProvVto, 
					comproProvAAutorizar.getComprobante().getOIDInteger(), 
					comproProvAAutorizar.getTcext(), 
					comproProvAAutorizar.getLetra(), 
					comproProvAAutorizar.getLugemi(), 
					comproProvAAutorizar.getNroext(), 
					comproProvAAutorizar.getImporte(),
					comproProvAAutorizar.getSaldo(),
					comproProvAAutorizar.getImputac(),
					comproProvAAutorizar.getEmision(),
					comproProvAAutorizar.getVto(),
					comproProvAAutorizar.getImportecuota(),
					comproProvAAutorizar.getSaldocuota(),
					comproProvAAutorizar.getAutorizfactprov().getOIDInteger(),
					comproProvAAutorizar.getPorcautoriz(),
					comproProvAAutorizar.getMontoAutorizado(),
					comproProvAAutorizar.getUsuario().getOIDInteger(),
					comproProvAAutorizar.getApellido(),
					comproProvAAutorizar.getNombre(),
					comproProvAAutorizar.getFecautoriz(),
					comproProvAAutorizar.getEstado(),
					comproProvAAutorizar.getMoneda(),
					new Boolean(false),
					comproProvAAutorizar.getComprobante().getCodigo(),
					new Money(0),
					comproProvAAutorizar.getRSProveedor());
					
		}
		
		// Traer Roles Autorizantes
		IDataSet dsRolAutoriz = getDataSetAutorizacionRoles(); 
		Iterator iterRolesAutorizFact = AutorizRolesFactProv.getAutorizRolesFactProv(proveedor,tipoCtaCteProv,fecha,getSesion()).iterator();
		while (iterRolesAutorizFact.hasNext()) {
			AutorizRolesFactProv autorizRolFactProv = (AutorizRolesFactProv) iterRolesAutorizFact.next();
			cargarRegistroAutorizRoles(dsRolAutoriz,autorizRolFactProv);
		}

		writeCliente(dsVista);
		writeCliente(dsRolAutoriz);
	}

	private IDataSet getDataSetAutorizacionRoles() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TAutorizacionRoles");
		dataset.fieldDef(new Field("oid_autoriz_fp_rol", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_autoriz_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_alta", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_autoriz", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_resp_aut", Field.DATE, 0));
		dataset.fieldDef(new Field("porc_aut_rec", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_aut_rec", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo_autorizacion", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom_usu", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_autoriz", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroAutorizRoles(IDataSet dataset, AutorizRolesFactProv autorizRoles) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_autoriz_fp_rol", autorizRoles.getOIDInteger());
		dataset.fieldValue("oid_autoriz_fact", autorizRoles.getAutorizacion_fact_prov().getOIDInteger());
		dataset.fieldValue("oid_rol_autoriz", autorizRoles.getRol_autorizador().getOIDInteger());
		dataset.fieldValue("fec_alta", autorizRoles.getFec_lta());
		dataset.fieldValue("tipo_autoriz", autorizRoles.getTipo_autoriz());
		dataset.fieldValue("fec_resp_aut", autorizRoles.getFecha_resp_aut());
		dataset.fieldValue("porc_aut_rec", autorizRoles.getPorc_aut_rec());
		dataset.fieldValue("monto_aut_rec", autorizRoles.getMonto_aut_rec());
		dataset.fieldValue("estado", autorizRoles.getEstado());
		dataset.fieldValue("motivo_autorizacion", autorizRoles.getMotivoAutorizacion());
		if (autorizRoles.getUsuario()!=null)
			dataset.fieldValue("ape_y_nom_usu",autorizRoles.getUsuario().getApellido()+", "+autorizRoles.getUsuario().getNombre());
		else
			dataset.fieldValue("ape_y_nom_usu","");
		if (autorizRoles.getFecha_resp_aut()!=null)
			dataset.fieldValue("fec_autoriz",autorizRoles.getFecha_resp_aut());
		else
			dataset.fieldValue("fec_autoriz",Fecha.FECHA_NULA());
		if (autorizRoles.getUsuario()!=null)
			dataset.fieldValue("oid_usuario", autorizRoles.getUsuario().getOIDInteger());
		else
			dataset.fieldValue("oid_usuario", new Integer(0));
	}
	
	private void cargarVistaAutorizaciones(IDataSet ds,
			                               Integer oidTranProv,
			                               Integer oidTranVto,
			                               Integer oidCCO,
			                               String tcExt,
			                               String letra,
			                               Integer lugEmi,
			                               Integer nroExt,
			                               Money importe,
			                               Money saldo,
			                               java.util.Date imputac,
			                               java.util.Date emision,
			                               java.util.Date vto,
			                               Money importeCuota,
			                               Money saldoCuota,
			                               Integer oidAutorizFact,
			                               Money porcAutoriz,
			                               Money montoAutoriz,
			                               Integer oidUsuario,
			                               String apellido,
			                               String nombre,
			                               java.util.Date fecAutoriz,
			                               Integer estado,
			                               String moneda,
			                               Boolean seleccionar,
			                               String comprobante,
			                               Money saldoAutorizado,
			                               String rsProveedor
			                               ) throws BaseException {
		ds.append();
		ds.fieldValue("oid_tran_prov", oidTranProv);
		ds.fieldValue("oid_tran_vto", oidTranVto);
		ds.fieldValue("oid_cco", oidCCO);
		ds.fieldValue("tc_ext", tcExt);
		ds.fieldValue("letra", letra);
		ds.fieldValue("lug_emi", lugEmi);
		ds.fieldValue("nro_ext", nroExt);
		ds.fieldValue("importe", importe.doubleValue()*-1);
		ds.fieldValue("saldo", saldo.doubleValue()*-1);
		ds.fieldValue("imputac", imputac);
		ds.fieldValue("emision", emision);
		ds.fieldValue("vto", vto);
		ds.fieldValue("importeCuota", importeCuota.doubleValue()*-1);
		ds.fieldValue("saldoCuota", saldoCuota.doubleValue()*-1);
		ds.fieldValue("oid_autoriz_fact",oidAutorizFact);
		ds.fieldValue("porc_autoriz", porcAutoriz);
		ds.fieldValue("monto_autoriz", montoAutoriz.doubleValue());
		ds.fieldValue("oid_usuario",oidUsuario);
		ds.fieldValue("apellido",apellido);
		ds.fieldValue("nombre",nombre);
		ds.fieldValue("fec_autoriz",fecAutoriz);
		ds.fieldValue("estado",estado);
		ds.fieldValue("moneda",moneda);
		ds.fieldValue("seleccionar",seleccionar);
		ds.fieldValue("comprobante",comprobante);
		ds.fieldValue("saldo_autorizado",saldoAutorizado.doubleValue()*-1);
		ds.fieldValue("rs_proveedor",rsProveedor);
		
	}
	
	private IDataSet getVistaAutorizaciones() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaComproProvPendAprob");
		
		dataset.fieldDef(new Field("oid_tran_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tran_vto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tc_ext", Field.STRING, 50));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("imputac", Field.DATE, 0));
		dataset.fieldDef(new Field("emision", Field.DATE, 0));
		dataset.fieldDef(new Field("vto", Field.DATE, 0));
		dataset.fieldDef(new Field("importeCuota", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldoCuota", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_autoriz_fact",Field.INTEGER, 0));
		dataset.fieldDef(new Field("porc_autoriz", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_autoriz", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_usuario",Field.INTEGER, 0));
		dataset.fieldDef(new Field("apellido",Field.STRING, 100));
		dataset.fieldDef(new Field("nombre",Field.STRING, 100));
		dataset.fieldDef(new Field("fec_autoriz",Field.DATE, 0));
		dataset.fieldDef(new Field("estado",Field.INTEGER, 0));
		dataset.fieldDef(new Field("moneda",Field.STRING, 50));
		dataset.fieldDef(new Field("seleccionar",Field.BOOLEAN, 50));
		dataset.fieldDef(new Field("comprobante",Field.STRING, 100));
		dataset.fieldDef(new Field("saldo_autorizado",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("rs_proveedor",Field.STRING, 100));
		return dataset;
	}

}
