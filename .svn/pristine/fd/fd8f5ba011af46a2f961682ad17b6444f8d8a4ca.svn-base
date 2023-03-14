package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EstadoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPropuestaNroPorEstExc extends Operation {

	public TraerPropuestaNroPorEstExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		int oidNovedad = 0;
		int maxOidNov = -1000;
		
		EstadoExcluido estadoExcluido =
			EstadoExcluido.findByOid(mapaDatos.getInteger("oid_estado"), this.getSesion());

		int nroPro = 0;
		
		if (estadoExcluido.isConservaNro()) {
		
			// Determinar el punto 
			IDataSet dsNov = 
				mapaDatos.getDataSet("TempNovedadExcluido");
			dsNov.first();
			while (!dsNov.EOF()) {
				
				// 	Novedades
				EstadoExcluido estadoRegNov =
					EstadoExcluido.findByOidProxy(dsNov.getInteger("oid_estado"),this.getSesion());
				
				if ((estadoRegNov!=null) && (estadoRegNov.getOID() == estadoExcluido.getOID())) {
					if ((dsNov.getInteger("nro_acta")!=null) && (dsNov.getInteger("nro_acta").intValue()>0)) {
						oidNovedad = dsNov.getInteger("oid_novedad");
						if (oidNovedad>maxOidNov) {
							maxOidNov = oidNovedad;
							nroPro = dsNov.getInteger("nro_acta").intValue();
						}
					}
				}
				
				dsNov.next();
			}
		
			if (maxOidNov != -1000) {
				IDataSet dsPropuesta = this.getDataSetPropNroEstado();
				cargarRegistro(dsPropuesta, nroPro);
				writeCliente(dsPropuesta);
				return;
			}
			
		}
		
		
		
		
		if (estadoExcluido.isProponerNro()) {
			
			if (estadoExcluido.getUltNroPropuesto()!=null)
				nroPro = estadoExcluido.getUltNroPropuesto().intValue()+1;
			else
				nroPro = 1;
			
			while (estadoExcluido.getNovedadesEstadoyNroActa(nroPro).size()!=0) 
				++nroPro;
			
			estadoExcluido.setUltNroPropuesto(nroPro);
			estadoExcluido.save();
		}
		IDataSet dsPropuesta = this.getDataSetPropNroEstado();
		if (estadoExcluido.isProponerNro()) 
			cargarRegistro(dsPropuesta, nroPro);
		writeCliente(dsPropuesta);
	}

	private IDataSet getDataSetPropNroEstado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPropuestaNroEstado");
		dataset.fieldDef(new Field("nro_propuesta", Field.INTEGER, 20));
		return dataset;
	}

	private void cargarRegistro(
			IDataSet dataset, Integer nroPropuesta) throws BaseException {
		dataset.append();
		dataset.fieldValue("nro_propuesta", nroPropuesta);
	}
}
