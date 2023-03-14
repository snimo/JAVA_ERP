package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.bm.DefEstrucLPDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefEstrucLPDetParaPrecios extends Operation {

	public TraerDefEstrucLPDetParaPrecios() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		DefEstrucLPCab defestruclpcab = null;

		Integer oidAcuerdoLP = mapaDatos.getInteger("oid_acuerdo_lp");

		Integer oid = mapaDatos.getInteger("oid_def_estruc_lp");
		defestruclpcab = DefEstrucLPCab.findByOid(oid, getSesion());

		IDataSet datasetDefEstrucLPDet = getDataSetDefEstrucLPDet();

		int secu = 1;
		Iterator iterDefEstrucLPDet = defestruclpcab.getDefEstrucLPDet().iterator();
		while (iterDefEstrucLPDet.hasNext()) {
			DefEstrucLPDet defEstrucLPDet = (DefEstrucLPDet) iterDefEstrucLPDet.next();
			if (defEstrucLPDet.isActivo().booleanValue() == false) continue;
			
			cargarRegistroDefEstrucLPDet(
					datasetDefEstrucLPDet,
					new Integer(secu),
					oidAcuerdoLP,
					defEstrucLPDet);
			
			++secu;
		}

		writeCliente(datasetDefEstrucLPDet);
	}

	private IDataSet getDataSetDefEstrucLPDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDefEstrucLPDet");
		dataset.fieldDef(new Field("oid_precio_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_def_estruc_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_art_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_clasif_art_1", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_clasif_art_1", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_clasif_art_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_clasif_art_2", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_clasif_art_2", Field.STRING, 100));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_clasificador_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasificador_2", Field.INTEGER, 0));
		
		return dataset;
	}

	private void cargarRegistroDefEstrucLPDet(IDataSet dataset,
			Integer secu,
			Integer oidAcuerdoLP, DefEstrucLPDet defEstrucLPDet)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_precio_clasif", secu);
		dataset.fieldValue("oid_acuerdo_lp", oidAcuerdoLP);
		dataset.fieldValue("oid_def_estruc_lp", defEstrucLPDet
				.getDef_estruc_lp().getOIDInteger());
		dataset.fieldValue("oid_clasif_art_1", defEstrucLPDet
				.getValor_clasif_art_1().getOIDInteger());
		dataset.fieldValue("cod_clasif_art_1", defEstrucLPDet
				.getValor_clasif_art_1().getCodigo());
		dataset.fieldValue("desc_clasif_art_1", defEstrucLPDet
				.getValor_clasif_art_1().getDescripcion());
		dataset.fieldValue("oid_clasif_art_2", defEstrucLPDet
				.getValor_clasif_art_2().getOIDInteger());
		dataset.fieldValue("cod_clasif_art_2", defEstrucLPDet
				.getValor_clasif_art_2().getCodigo());
		dataset.fieldValue("desc_clasif_art_2", defEstrucLPDet
				.getValor_clasif_art_2().getDescripcion());
		dataset.fieldValue("orden", defEstrucLPDet.getOrden());
		dataset.fieldValue("activo", defEstrucLPDet.isActivo());
		dataset.fieldValue("oid_clasificador_1", defEstrucLPDet
				.getValor_clasif_art_1().getClasificador_entidad().getOIDInteger());
		dataset.fieldValue("oid_clasificador_2", defEstrucLPDet
				.getValor_clasif_art_2().getClasificador_entidad().getOIDInteger());
		
	}

}
