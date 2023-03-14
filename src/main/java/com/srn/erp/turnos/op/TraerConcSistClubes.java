package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.GrupoConceptoTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConcSistClubes extends Operation {

	public TraerConcSistClubes() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDSConceptos();

		int oidDeudaConcepto = mapaDatos.getInteger("oid_deuda_concepto");
		int i = 0;
		HashTableDatos conceptos = GrupoConceptoTurno.getConceptosSisteClubes(this.getSesion());
		Iterator iterCodConc = conceptos.keySet().iterator();
		while (iterCodConc.hasNext()) {
			String codigo = (String) iterCodConc.next();
			String descripcion = (String) conceptos.get(codigo.trim());
			cargarConcepto(ds, ++i, oidDeudaConcepto, codigo,
					descripcion, false);
		}

		writeCliente(ds);
	}

	private void cargarConcepto(IDataSet ds, Integer oidGrupoConc,
			Integer oidDeudaConc, String concepto, String descConcepto,
			Boolean activo) throws BaseException {
		ds.append();
		ds.fieldValue("oid_grupo_conc", oidGrupoConc);
		ds.fieldValue("oid_deuda_conc", oidDeudaConc);
		ds.fieldValue("concepto", concepto);
		ds.fieldValue("desc_concepto", descConcepto.trim());
		ds.fieldValue("activo", activo);
	}

	private IDataSet getDSConceptos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptos");
		dataset.fieldDef(new Field("oid_grupo_conc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_deuda_conc", Field.INTEGER, 50));
		dataset.fieldDef(new Field("concepto", Field.STRING, 20));
		dataset.fieldDef(new Field("desc_concepto", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

}
