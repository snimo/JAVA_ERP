package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArcImpErrorPOSNET;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerErrorImpArchTarj extends Operation {

	public TraerErrorImpArchTarj() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		String tipoArchivo = null;
		EmpresaConciTar empresa = null;

		if (mapaDatos.containsKey("fec_desde"))
			fecDesde = mapaDatos.getDate("fec_desde");

		if (mapaDatos.containsKey("fec_hasta"))
			fecHasta = mapaDatos.getDate("fec_hasta");

		if (mapaDatos.containsKey("tipo_archivo"))
			tipoArchivo = mapaDatos.getString("tipo_archivo");

		if (mapaDatos.containsKey("oid_empresa"))
			empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());

		IDataSet ds = this.getDSArchConErrores();
		Iterator iterRengArchErrores = 
			ArcImpErrorPOSNET.getArchImpoConErrores(fecDesde, fecHasta, empresa, tipoArchivo, this.getSesion()).iterator();
		while (iterRengArchErrores.hasNext()) {
			ArcImpErrorPOSNET archImpConError = (ArcImpErrorPOSNET) iterRengArchErrores.next();
			cargarReg(ds, archImpConError);
		}
		writeCliente(ds);

	}

	private void cargarReg(IDataSet dsCupon, ArcImpErrorPOSNET archConErrores) throws BaseException {
		dsCupon.append();
		dsCupon.fieldValue("oid_error_imp", archConErrores.getOIDInteger());
		dsCupon.fieldValue("tipo_arch", archConErrores.getTipo_arch());
		dsCupon.fieldValue("fecha", archConErrores.getFecha());
		dsCupon.fieldValue("hora", archConErrores.getHora());
		dsCupon.fieldValue("carpeta", archConErrores.getCarpeta());
		dsCupon.fieldValue("nombre_archivo", archConErrores.getNombre_archivo());
		if (archConErrores.getTerminal() != null) {
			dsCupon.fieldValue("oid_terminal", archConErrores.getTerminal().getOIDInteger());
			dsCupon.fieldValue("terminal", archConErrores.getTerminal().getNro_terminal());
		} else {
			dsCupon.fieldValue("oid_terminal", "");
			dsCupon.fieldValue("terminal", "");
		}
		if (archConErrores.getEmpresa() != null) {
			dsCupon.fieldValue("oid_empresa", archConErrores.getEmpresa().getOIDInteger());
			dsCupon.fieldValue("empresa", archConErrores.getEmpresa().getRazon_social());
		} else {
			dsCupon.fieldValue("oid_empresa", "");
			dsCupon.fieldValue("empresa", "");
		}
		dsCupon.fieldValue("problema", archConErrores.getProblema());
		dsCupon.fieldValue("activo", archConErrores.isActivo());
	}

	private IDataSet getDSArchConErrores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TErrorArch");
		dataset.fieldDef(new Field("oid_error_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_arch", Field.STRING, 20));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora", Field.STRING, 5));
		dataset.fieldDef(new Field("carpeta", Field.STRING, 255));
		dataset.fieldDef(new Field("nombre_archivo", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_terminal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("terminal", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("problema", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

}
