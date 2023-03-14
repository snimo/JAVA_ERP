package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.NovedadExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerActasLevantamiento extends Operation {

	public TraerActasLevantamiento() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSet();
		
		HashTableDatos condiciones = new HashTableDatos();
		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		dsInput.first();
		while (!dsInput.EOF()) {
			
			Integer oidEstado = dsInput.getInteger("oid_estado");
			if (oidEstado!=null)
				condiciones.put("OID_ESTADO", oidEstado);
			
			Integer nroActaDesde = dsInput.getInteger("nro_acta_desde");
			if (nroActaDesde!=null)
				condiciones.put("NRO_ACTA_DESDE", nroActaDesde);
			
			Integer nroActaHasta = dsInput.getInteger("nro_acta_hasta");
			if (nroActaHasta!=null)
				condiciones.put("NRO_ACTA_HASTA", nroActaHasta);
			
			java.util.Date fecDesdeEstado = dsInput.getDate("fec_desde_est");
			if (fecDesdeEstado!=null)
				condiciones.put("FEC_DESDE_ESTADO", fecDesdeEstado);
			
			java.util.Date fecHastaEstado = dsInput.getDate("fec_hasta_est");
			if (fecHastaEstado!=null)
				condiciones.put("FEC_HASTA_ESTADO", fecHastaEstado);			
			
			Integer nroActaDesdeLev = dsInput.getInteger("nro_acta_lev_desde");
			if (nroActaDesdeLev!=null)
				condiciones.put("NRO_ACTA_LEV_DESDE", nroActaDesdeLev);
			
			Integer nroActaHastaLev = dsInput.getInteger("nro_acta_lev_hasta");
			if (nroActaHastaLev!=null)
				condiciones.put("NRO_ACTA_LEV_HASTA", nroActaHastaLev);
			
			java.util.Date fecDesdelev = dsInput.getDate("fec_desde_lev");
			if (fecDesdelev!=null)
				condiciones.put("FEC_LEV_DESDE", fecDesdelev);
			
			java.util.Date fecHastalev = dsInput.getDate("fec_hasta_lev");
			if (fecHastalev!=null)
				condiciones.put("FEC_LEV_HASTA", fecHastalev);
			
			
			dsInput.next();
		}
		
		Iterator iterNovExc = 
			NovedadExcluido.getNovedadesByCondiciones(condiciones, this.getSesion()).iterator();
		while (iterNovExc.hasNext()) {
			NovedadExcluido novExc = (NovedadExcluido) iterNovExc.next();
			cargarRegistro(ds, novExc);
		}

		
		writeCliente(ds);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TActasLevantamiento");
		dataset.fieldDef(new Field("oid_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado", Field.STRING, 100));
		dataset.fieldDef(new Field("dejar_sin_efecto", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_acta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_revocamiento", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_revocacion", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_docu", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_docu", Field.STRING, 100));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("id_interno", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tiempo", Field.STRING, 100));
		dataset.fieldDef(new Field("gerente", Field.STRING, 100));
		
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, NovedadExcluido novedad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_novedad", novedad.getOIDInteger());
		dataset.fieldValue("fecha", novedad.getFecha());
		dataset.fieldValue("oid_estado", novedad.getEstado().getOIDInteger());
		dataset.fieldValue("desc_estado", novedad.getEstado().getDescripcion());
		dataset.fieldValue("dejar_sin_efecto", novedad.isDejar_sin_efecto());
		dataset.fieldValue("nro_acta", novedad.getnroActa());
		dataset.fieldValue("nro_revocamiento", novedad.getnroRevocamiento());
		dataset.fieldValue("fec_revocacion", novedad.getFecRevocamiento());
		
		if (novedad.getIndividuoExcluido()!=null) {
			dataset.fieldValue("oid_individuo", novedad.getIndividuoExcluido().getOID());
			if (novedad.getIndividuoExcluido().getTipo_documento()!=null)
				dataset.fieldValue("tipo_docu", novedad.getIndividuoExcluido().getTipo_documento().getDescripcion());
			else
				dataset.fieldValue("tipo_docu", "");
			dataset.fieldValue("nro_docu", novedad.getIndividuoExcluido().getNro_documento());
			dataset.fieldValue("ape_y_nom", novedad.getIndividuoExcluido().getApeyNom());
			dataset.fieldValue("id_interno", novedad.getIndividuoExcluido().getOID());
		} else {
			dataset.fieldValue("oid_individuo", "");
			dataset.fieldValue("tipo_docu", "");
			dataset.fieldValue("nro_docu", "");
			dataset.fieldValue("ape_y_nom", "");
			dataset.fieldValue("id_interno", "");
		}
		
		dataset.fieldValue("tiempo", novedad.getTiempo());
		if (novedad.getGerenteExcluido()!=null)
			dataset.fieldValue("gerente", novedad.getGerenteExcluido().getDescripcion());
		else
			dataset.fieldValue("gerente", "");
		
		
	}
}
