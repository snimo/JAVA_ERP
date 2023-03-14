package com.srn.erp.legales.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.CartasDocRemLega;
import com.srn.erp.legales.bm.TipoCausaLegales;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCartasRemitidas extends Operation {

	public TraerCartasRemitidas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		
		IDataSet dsCartas = this.getDataSetCartasRemititas();
		
		java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
		java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
		TipoCausaLegales tipoCausa = null; 
		String nroCarta = null;
		String causa = null;
		String observaciones = null;
		Legajo legajo = null;
		
		if (mapaDatos.containsKey("oid_tipo_causa"))
			tipoCausa = TipoCausaLegales.findByOidProxy(mapaDatos.getInteger("oid_tipo_causa"), this.getSesion());
		
		if (mapaDatos.containsKey("oid_legajo"))
			legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		
		if (mapaDatos.containsKey("nro_carta_documento"))
			nroCarta = mapaDatos.getString("nro_carta_documento");
			
		if (mapaDatos.containsKey("causa"))
			causa = mapaDatos.getString("causa");
		
		if (mapaDatos.containsKey("observaciones"))
			observaciones = mapaDatos.getString("observaciones");		
		
		
		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		if (tipoCausa!=null)
			condiciones.put(TipoCausaLegales.NICKNAME, tipoCausa);
		if (nroCarta!=null)
			condiciones.put("NRO_CARTA", nroCarta);		
		if (causa!=null)
			condiciones.put("CAUSA", causa);		
		if (observaciones!=null)
			condiciones.put("OBSERVACIONES", observaciones);		
		if (legajo!=null)
			condiciones.put(Legajo.NICKNAME, legajo);		
		
		Iterator iterCartasDocRemLeg = 
			CartasDocRemLega.getCartasDocRem(condiciones, this.getSesion()).iterator();
		while (iterCartasDocRemLeg.hasNext()) {
			CartasDocRemLega cartaDocRemLega = (CartasDocRemLega) iterCartasDocRemLeg.next();
			cargarCartasRemitidas(dsCartas, cartaDocRemLega, clasifEmpresa, clasifSector, clasifPuesto, clasifEstado);
		}
		
		writeCliente(dsCartas);
		
	}

	private IDataSet getDataSetCartasRemititas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsultaCartas");
		dataset.fieldDef(new Field("oid_carta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa", Field.STRING, 250));
		dataset.fieldDef(new Field("sector", Field.STRING, 250));
		dataset.fieldDef(new Field("puesto", Field.STRING, 250));
		dataset.fieldDef(new Field("estado", Field.STRING, 250));
		dataset.fieldDef(new Field("nro_carta", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_tipo_causa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_tipo_causa", Field.STRING, 100));
		dataset.fieldDef(new Field("causa", Field.STRING, 5000));
		dataset.fieldDef(new Field("recibida", Field.DATE, 0));
		dataset.fieldDef(new Field("observaciones", Field.STRING, 5000));
		return dataset;
	}

	private void cargarCartasRemitidas(
			IDataSet dataset, 
			CartasDocRemLega carta,
			ClasificadorEntidad clasifEmpresa,
			ClasificadorEntidad clasifSector,
			ClasificadorEntidad clasifPuesto,
			ClasificadorEntidad clasifEstado) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_carta", carta.getOID());
		dataset.fieldValue("oid_legajo", carta.getLegajo().getOIDInteger());
		dataset.fieldValue("nro_legajo", carta.getLegajo().getNro_legajo());
		dataset.fieldValue("ape_y_nom", carta.getLegajo().getApellidoyNombre());
		
		ValorClasificadorEntidad valorClasifEmp = carta.getLegajo().getValorClasifEnt(clasifEmpresa);
		if (valorClasifEmp!=null)
			dataset.fieldValue("empresa", valorClasifEmp.getDescripcion());
		else
			dataset.fieldValue("empresa", "");
		
		ValorClasificadorEntidad valorClasifSec = carta.getLegajo().getValorClasifEnt(clasifSector);
		if (valorClasifSec!=null)
			dataset.fieldValue("sector", valorClasifSec.getDescripcion());
		else
			dataset.fieldValue("sector", "");		
		
		ValorClasificadorEntidad valorClasifPue = carta.getLegajo().getValorClasifEnt(clasifPuesto);
		if (valorClasifPue!=null)
			dataset.fieldValue("puesto", valorClasifPue.getDescripcion());
		else
			dataset.fieldValue("puesto", "");		
		
		ValorClasificadorEntidad valorClasifEst = carta.getLegajo().getValorClasifEnt(clasifEstado);
		if (valorClasifEst!=null)
			dataset.fieldValue("estado", valorClasifEst.getDescripcion());
		else
			dataset.fieldValue("estado", "");		
		
		dataset.fieldValue("nro_carta", carta.getNro_carta_doc());
		dataset.fieldValue("fecha", carta.getFecha());
		if (carta.getTipocausa()!=null) {
			dataset.fieldValue("oid_tipo_causa", carta.getTipocausa().getOIDInteger());
			dataset.fieldValue("desc_tipo_causa", carta.getTipocausa().getDescripcion()); 
		}
		else {
			dataset.fieldValue("oid_tipo_causa", "");
			dataset.fieldValue("desc_tipo_causa", "");
		}
		dataset.fieldValue("causa", carta.getCausa());
		dataset.fieldValue("recibida", carta.getRecibido());
		dataset.fieldValue("observaciones", carta.getObservaciones());
		
	}
}
