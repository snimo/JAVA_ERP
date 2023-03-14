package com.srn.erp.payroll.op;

import java.util.List;

import com.srn.erp.payroll.bm.PaySectores;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPaySectores extends Operation {

	public TraerPaySectores() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TInput"); 
		dataset.first();
		
		String oid_string = dataset.getString("empresa");
		List<PaySectores> paysectores = null;
		paysectores = PaySectores.findByEmpresa(oid_string, getSesion());

		IDataSet datasetPaySectores = getDataSetPaySectores();
		if (paysectores != null && !paysectores.isEmpty()) {
			cargarRegistroPaySectores(datasetPaySectores, paysectores);
		}
		writeCliente(datasetPaySectores);
	}

	private IDataSet getDataSetPaySectores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSectores");
		dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroPaySectores(IDataSet dataset, List<PaySectores> sectores) throws BaseException {
		for (PaySectores sector : sectores) {
			dataset.append();
			dataset.fieldValue("codigo", sector.getCodigoActual());
			dataset.fieldValue("sector", sector.getDescripcion());
			dataset.fieldValue("seleccionado", false);
		}
	}
}
