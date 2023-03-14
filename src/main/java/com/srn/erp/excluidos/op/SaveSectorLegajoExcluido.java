package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.SectorLegajoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSectorLegajoExcluido extends Operation {

	public SaveSectorLegajoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TSectorLegajoExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			SectorLegajoExcluido sectorlegajoexcluido = SectorLegajoExcluido.findByOid(dataset.getInteger("oid_sector"), getSesion());
			sectorlegajoexcluido.setOID(dataset.getInteger("oid_sector"));
			sectorlegajoexcluido.setCodigo(dataset.getString("codigo"));
			sectorlegajoexcluido.setDescripcion(dataset.getString("descripcion"));
			sectorlegajoexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(sectorlegajoexcluido);
			dataset.next();
		}
	}

}
