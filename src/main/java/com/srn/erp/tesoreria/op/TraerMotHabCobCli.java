package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.bm.MotivoHabCobCli;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotHabCobCli extends Operation {

	public TraerMotHabCobCli() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsMotHabCobCli = this.getDSMotHabCobCli();

		int secu = 0;
		Iterator iterMotCobCli = MotivoTC.getMotivosRecibos(this.getSesion()).iterator();
		while (iterMotCobCli.hasNext()) {
			MotivoTC motivoTC = (MotivoTC) iterMotCobCli.next();
			MotivoHabCobCli motHabCobCli = MotivoHabCobCli.getMotivoHabCobCli(motivoTC, this.getSesion());
			boolean habilitado = false;
			if (motHabCobCli != null) {
				habilitado = motHabCobCli.isHabilitado().booleanValue();
				secu = motHabCobCli.getOID(); 
			} else --secu;
			cargarRegistroMotHabCobCli(dsMotHabCobCli, secu, motivoTC, new Boolean(habilitado));
			
		}

		writeCliente(dsMotHabCobCli);
		
	}

	private IDataSet getDSMotHabCobCli() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotHabCobCli");
		dataset.fieldDef(new Field("oid_mot_hab_cobcli", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_motivo_tc", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroMotHabCobCli(IDataSet dataset, int secu, MotivoTC motivoTC, Boolean habilitado)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_hab_cobcli", new Integer(secu));
		dataset.fieldValue("oid_motivo_tc", motivoTC.getOIDInteger());
		dataset.fieldValue("desc_motivo_tc", motivoTC.getMotivo_comprobante().getDescripcion());
		dataset.fieldValue("habilitado", habilitado);
	}


}
