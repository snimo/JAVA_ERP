package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.contabilidad.bm.ReporteContaCompo;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuenta extends Operation {

	public TraerCuenta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Cuenta cuenta = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			cuenta = Cuenta.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			cuenta = Cuenta.findByCodigo(codigo, getSesion());
		}

		Integer oidEstructura = new Integer(0);
		String codigoEstructura = "";
		String descEstructua = "";

		Integer oidIndice = new Integer(0);
		String codigoIndice = "";
		String descIndice = "";

		Integer oidTipoCambio = new Integer(0);
		String codigoTipoCambio = "";
		String descTipoCambio = "";

		if (cuenta.getEstructura() != null) {
			oidEstructura = cuenta.getEstructura().getOIDInteger();
			codigoEstructura = cuenta.getEstructura().getCodigo();
			descEstructua = cuenta.getEstructura().getDescripcion();
		}

		if (cuenta.getIndice() != null) {
			oidIndice = cuenta.getIndice().getOIDInteger();
			codigoIndice = cuenta.getIndice().getCodigo();
			descIndice = cuenta.getIndice().getDescripcion();
		}

		if (cuenta.getTipocambio() != null) {
			oidTipoCambio = cuenta.getTipocambio().getOIDInteger();
			codigoTipoCambio = cuenta.getTipocambio().getCodigo();
			descTipoCambio = cuenta.getTipocambio().getDescripcion();
		}

		IDataSet datasetCuenta = getDataSetCuenta();
		IDataSet dsReportes = getDataSetReportesContables();
		IDataSet dsRepContaDet = getDataSetRepContaDet();
		IDataSet dsValRepContaDet = getDataSetValRepDet();

		if (cuenta != null) {
			cargarRegistroCuenta(datasetCuenta, cuenta.getOIDInteger(), cuenta.getCodigo(), cuenta.getDescripcion(), cuenta
					.isEspatrimonial(), cuenta.isEsctainterna(), oidEstructura, codigoEstructura, descEstructua, oidTipoCambio,
					codigoTipoCambio, descTipoCambio, oidIndice, codigoIndice, descIndice, cuenta.isActivo(), cuenta.getSubsistema(),
					cuenta.esImpuesto());

			Iterator iterReportesContables = ReporteContable.getReportesActivosABMCtas(this.getSesion()).iterator();
			while (iterReportesContables.hasNext()) {
				ReporteContable reporteContable = (ReporteContable) iterReportesContables.next();
				cargarRegReporte(dsReportes, reporteContable, cuenta);

				// Traer los titulos correspondientes
				Iterator iterRepDetCtaActiva = reporteContable.getSoloReporteDetCtaActiva(cuenta).iterator();
				while (iterRepDetCtaActiva.hasNext()) {
					ReporteContableDet reporteContableDet = (ReporteContableDet) iterRepDetCtaActiva.next();
					cargarRegRepContaDet(dsRepContaDet, reporteContable, reporteContableDet);
					
					// Obtener los Valores de Componentes
					cargarRegValoresRepDet(dsValRepContaDet,reporteContableDet,cuenta.getEstructura());
					
					
				}

			}
		}

		writeCliente(datasetCuenta);
		writeCliente(dsReportes);
		writeCliente(dsRepContaDet);
		writeCliente(dsValRepContaDet);

	}

	private IDataSet getDataSetCuenta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCuenta");
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 15));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("es_patrimonial", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_cta_interna", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_estruc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_estruc", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_estruc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_cambio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_tipo_cambio", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_tipo_cambio", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_indice", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_indice", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_indice", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("subsistema", Field.STRING, 100));
		dataset.fieldDef(new Field("es_impuesto", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetReportesContables() {
		IDataSet dataset = new TDataSet();
		dataset.create("TReportesContables");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ana_con", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_reporte", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getDataSetValRepDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresReporteDet");
		dataset.fieldDef(new Field("oid_val_rep_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rep_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_componente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_compo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_compo", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_val_compo", Field.STRING, 1000));
		dataset.fieldDef(new Field("desc_componente", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("secu_rep_conta_det", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegValoresRepDet(
			IDataSet ds, 
			ReporteContableDet repContaDet,
			Estructura estructura) throws BaseException {

		HashTableDatos valoresPorCompo = new HashTableDatos();
		Iterator iterRepContaCompo = 
			repContaDet.getItemsReporteCompo().iterator();
		while (iterRepContaCompo.hasNext()) {
			ReporteContaCompo reporteContaCompo = (ReporteContaCompo) iterRepContaCompo.next();
			valoresPorCompo.put(reporteContaCompo.getComponente().getOIDInteger(), reporteContaCompo);
		}
		
		if (estructura==null) return;
		
		Iterator iterEstrucCompo =
			estructura.getEstrucComponenentes().iterator();
		while (iterEstrucCompo.hasNext()) {
			EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();

			ds.append();
			ds.fieldValue("oid_val_rep_det", estrucCompo.getComponente().getOIDInteger());
			ds.fieldValue("oid_rep_det", repContaDet.getOIDInteger());
			ds.fieldValue("oid_componente", estrucCompo.getComponente().getOIDInteger());
			
			// Buscar el Valor del Componente
			ReporteContaCompo repContaCompoEnc = (ReporteContaCompo)
				valoresPorCompo.get(estrucCompo.getComponente().getOIDInteger());
			
			if (repContaCompoEnc!=null) {
				ds.fieldValue("oid_val_compo", repContaCompoEnc.getValorcomponente().getOIDInteger());
				ds.fieldValue("cod_val_compo", repContaCompoEnc.getValorcomponente().getCodigo());
				ds.fieldValue("desc_val_compo", repContaCompoEnc.getValorcomponente().getDescripcion());
			} else {
				ds.fieldValue("oid_val_compo", "");
				ds.fieldValue("cod_val_compo", "");
				ds.fieldValue("desc_val_compo", "");
			}
			
			ds.fieldValue("desc_componente", estrucCompo.getComponente().getDescripcion());
			ds.fieldValue("activo", true);
			ds.fieldValue("secu_rep_conta_det", repContaDet.getOIDInteger());
			
			
		}
		
		
	}
	
	private IDataSet getDataSetRepContaDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TReporteContaDet");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_reporte", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_rep_conta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_titu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_titu_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_rep_conta_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_valor_compo", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegRepContaDet(IDataSet ds, ReporteContable reporte, ReporteContableDet repContaDet) throws BaseException {

		ReporteContableDet reporteContaDetPadre = repContaDet.getReporteContableDetPadre();
		Cuenta cuenta = repContaDet.getCuenta();
		if (reporteContaDetPadre == null)
			return;

		ds.append();
		ds.fieldValue("secu", repContaDet.getOIDInteger());
		ds.fieldValue("oid_ana_con", cuenta.getOIDInteger());
		ds.fieldValue("desc_reporte", reporteContaDetPadre.getReporteContable().getDescripcion());
		ds.fieldValue("tipo", repContaDet.getTipo());
		ds.fieldValue("oid_rep_conta", reporteContaDetPadre.getReporteContable().getOIDInteger());
		ds.fieldValue("oid_titu", reporteContaDetPadre.getOidtitulo());
		ds.fieldValue("oid_titu_padre", reporteContaDetPadre.getOidtitulopadre());
		ds.fieldValue("descripcion", reporteContaDetPadre.getDescripcionJerarquia());
		ds.fieldValue("oid_rep_conta_det", reporteContaDetPadre.getOIDInteger());
		ds.fieldValue("orden", reporteContaDetPadre.getOrden());
		if (repContaDet.isCuentaConComponentes())
			ds.fieldValue("tipo_valor_compo", "INCLUIR");
		else if (repContaDet.isCuentaSinComponentes())
			ds.fieldValue("tipo_valor_compo", "EXCLUIR");
		else
			ds.fieldValue("tipo_valor_compo", "NO_APLICA");
		ds.fieldValue("activo", true);
	}

	private void cargarRegReporte(IDataSet ds, ReporteContable reporte, Cuenta cuenta) throws BaseException {
		ds.append();
		ds.fieldValue("oid", reporte.getOIDInteger());
		ds.fieldValue("oid_ana_con", cuenta.getOIDInteger());
		ds.fieldValue("desc_reporte", reporte.getDescripcion());
	}

	private void cargarRegistroCuenta(IDataSet dataset, Integer oid_ana_con, String codigo, String descripcion, Boolean es_patrimonial,
			Boolean es_cta_interna, Integer oid_estruc, String codigo_estruc, String desc_estruc, Integer oid_tipo_cambio,
			String codigo_tipo_cambio, String desc_tipo_cambio, Integer oid_indice, String codigo_indice, String desc_indice,
			Boolean activo, String subsistema, Boolean esImpuesto) {
		dataset.append();
		dataset.fieldValue("oid_ana_con", oid_ana_con);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("es_patrimonial", es_patrimonial);
		dataset.fieldValue("es_cta_interna", es_cta_interna);
		dataset.fieldValue("oid_estruc", oid_estruc);
		dataset.fieldValue("codigo_estruc", codigo_estruc);
		dataset.fieldValue("desc_estruc", desc_estruc);
		dataset.fieldValue("oid_tipo_cambio", oid_tipo_cambio);
		dataset.fieldValue("codigo_tipo_cambio", codigo_tipo_cambio);
		dataset.fieldValue("desc_tipo_cambio", desc_tipo_cambio);
		dataset.fieldValue("oid_indice", oid_indice);
		dataset.fieldValue("codigo_indice", codigo_indice);
		dataset.fieldValue("desc_indice", desc_indice);
		dataset.fieldValue("activo", activo);
		if (subsistema != null)
			dataset.fieldValue("subsistema", subsistema);
		else
			dataset.fieldValue("subsistema", "");
		dataset.fieldValue("es_impuesto", esImpuesto);

	}
}
