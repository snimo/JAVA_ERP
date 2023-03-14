package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerSectorLegajoExcluido extends Operation {

	public TraerSectorLegajoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		SectorLegajoExcluido sectorlegajoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			sectorlegajoexcluido = SectorLegajoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			sectorlegajoexcluido = SectorLegajoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetSectorLegajoExcluido = getDataSetSectorLegajoExcluido();
		if (sectorlegajoexcluido != null) {
			cargarRegistroSectorLegajoExcluido(datasetSectorLegajoExcluido, sectorlegajoexcluido.getOIDInteger(), sectorlegajoexcluido
					.getCodigo(), sectorlegajoexcluido.getDescripcion(), sectorlegajoexcluido.isActivo());
		}
		writeCliente(datasetSectorLegajoExcluido);
	}

	private IDataSet getDataSetSectorLegajoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSectorLegajoExcluido");
		dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSectorLegajoExcluido(IDataSet dataset, Integer oid_sector, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_sector", oid_sector);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
