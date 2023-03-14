package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.EstadoPredioExc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoExcluido extends Operation {

	public TraerEstadoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EstadoExcluido estadoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			estadoexcluido = EstadoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			estadoexcluido = EstadoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEstadoExcluido = getDataSetEstadoExcluido();
		IDataSet datasetPredio = this.getDataSetEstadoPredioExc();
		
		if (estadoexcluido != null) {
			cargarRegistroEstadoExcluido(datasetEstadoExcluido, estadoexcluido);
			Iterator iterEstadosPredio = 
				estadoexcluido.getEstadosPredio().iterator();
			while (iterEstadosPredio.hasNext()) {
				EstadoPredioExc estadoPredio = (EstadoPredioExc) iterEstadosPredio.next();
				cargarRegistroEstadoPredioExc(datasetPredio, estadoPredio);
			}
		}
		
		writeCliente(datasetEstadoExcluido);
		writeCliente(datasetPredio);
	}

	private IDataSet getDataSetEstadoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoExcluido");
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("peso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("color", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("proponer_nro", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ult_nro_propu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_acta_obli", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("permite_modif_nro", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("conserva_nro", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("publicar_en_filtro", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("restriccion_acceso", Field.BOOLEAN, 0));
		
		return dataset;
	}

	private void cargarRegistroEstadoExcluido(
			IDataSet dataset, EstadoExcluido estado) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_estado", estado.getOIDInteger());
		dataset.fieldValue("codigo", estado.getCodigo());
		dataset.fieldValue("descripcion", estado.getDescripcion());
		dataset.fieldValue("peso", estado.getPeso());
		dataset.fieldValue("color", estado.getColor());
		dataset.fieldValue("activo", estado.isActivo());
		dataset.fieldValue("proponer_nro", estado.isProponerNro());
		dataset.fieldValue("ult_nro_propu", estado.getUltNroPropuesto());
		dataset.fieldValue("nro_acta_obli", estado.isNroActaObligatorio());
		dataset.fieldValue("permite_modif_nro", estado.isPermiteModifNro());
		dataset.fieldValue("conserva_nro", estado.isConservaNro());
		dataset.fieldValue("publicar_en_filtro", estado.isPublicarEnFiltro());
		dataset.fieldValue("restriccion_acceso", estado.isRestriccionAcceso());
	}
	
	  private IDataSet getDataSetEstadoPredioExc() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TEstadoPredioExc");
		    dataset.fieldDef(new Field("oid_estado_predio", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("proponer_nro", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("ult_nro_propu", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("nro_acta_obli", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("permite_modif_nro", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    dataset.fieldDef(new Field("conserva_nro", Field.INTEGER, 0)); 
		    return dataset;
		  }

		  private void cargarRegistroEstadoPredioExc(IDataSet dataset, 
		                         EstadoPredioExc estadoPredio) throws BaseException {
		    dataset.append(); 
		    dataset.fieldValue("oid_estado_predio", estadoPredio.getOID());
		    dataset.fieldValue("oid_estado", estadoPredio.getEstado().getOIDInteger());
		    dataset.fieldValue("oid_predio", estadoPredio.getPredio().getOID());
		    dataset.fieldValue("proponer_nro", estadoPredio.getProponer_nro());
		    dataset.fieldValue("ult_nro_propu", estadoPredio.getUlt_nro_propu());
		    dataset.fieldValue("nro_acta_obli", estadoPredio.getNro_acta_obli());
		    dataset.fieldValue("permite_modif_nro", estadoPredio.getPermite_modif_nro());
		    dataset.fieldValue("activo", estadoPredio.isActivo());
		    dataset.fieldValue("conserva_nro", estadoPredio.getConserva_nro());
		  }	
}
