package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.bm.SubdiarioDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComponentesEstrucSubDiario extends Operation {

	public TraerComponentesEstrucSubDiario() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidSubdiario = mapaDatos.getInteger("oid_subdiario");
		Subdiario subdiario = Subdiario.findByOid(oidSubdiario, getSesion());

		IDataSet datasetComponentes = getDataSetComponentes();

		boolean tieneEstruc = false;
		Estructura lastEstruc = null;

		Iterator iterSubDiarioDet = subdiario.getSubdiariosDet().iterator();
		while (iterSubDiarioDet.hasNext()) {
			SubdiarioDet subdiarioDet = (SubdiarioDet) iterSubDiarioDet.next();
			if (!subdiarioDet.isActivo())
				continue;
			if (subdiarioDet.getCuenta().getEstructura() != null) {
				tieneEstruc = true;
				if (lastEstruc == null)
					lastEstruc = subdiarioDet.getCuenta().getEstructura();
				if (lastEstruc.getOID() != subdiarioDet.getCuenta().getEstructura().getOID()) {
					tieneEstruc = false;
					break;
				}
			} else {
				tieneEstruc = false;
				break;
			}
		}

		if ((tieneEstruc) && (lastEstruc != null)) {
			Iterator iterComponentesConAux = lastEstruc.getComponenentesConAux().iterator();
			while (iterComponentesConAux.hasNext()) {
				Componente componente = (Componente) iterComponentesConAux.next();
				cargarRegistroComponente(datasetComponentes, componente.getOIDInteger(), componente.getCodigo(), componente
						.getDescripcion(), componente.getTipo());
			}
		}

		writeCliente(datasetComponentes);
	}

	private IDataSet getDataSetComponentes() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComponentes");
		dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 6));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		return dataset;
	}

	private void cargarRegistroComponente(IDataSet dataset, Integer oid_compo, String codigo, String descripcion, String tipo) {
		dataset.append();
		dataset.fieldValue("oid_compo", oid_compo);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("tipo", tipo);
	}

}
