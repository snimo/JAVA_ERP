package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Abogado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAbogado extends Operation {

	public TraerAbogado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Abogado abogado = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			abogado = Abogado.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			abogado = Abogado.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetAbogado = getDataSetAbogado();
		if (abogado != null) {
			cargarRegistroAbogado(datasetAbogado, abogado.getOIDInteger(), abogado.getApellido(), abogado.getNombre(), abogado.getTelefonos(), abogado.getMail(), abogado.getDireccion(), abogado
					.getEstudio(), abogado.isActivo() , abogado.getCUIT());
		}
		writeCliente(datasetAbogado);
	}

	private IDataSet getDataSetAbogado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAbogado");
		dataset.fieldDef(new Field("oid_abogado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("apellido", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("telefonos", Field.STRING, 50));
		dataset.fieldDef(new Field("mail", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion", Field.STRING, 100));
		dataset.fieldDef(new Field("estudio", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cuit", Field.STRING, 20));
		return dataset;
	}

	private void cargarRegistroAbogado(IDataSet dataset, Integer oid_abogado, String apellido, String nombre, String telefonos, String mail, String direccion, String estudio, Boolean activo , String cuit) {
		dataset.append();
		dataset.fieldValue("oid_abogado", oid_abogado);
		dataset.fieldValue("apellido", apellido);
		dataset.fieldValue("nombre", nombre);
		dataset.fieldValue("telefonos", telefonos);
		dataset.fieldValue("mail", mail);
		dataset.fieldValue("direccion", direccion);
		dataset.fieldValue("estudio", estudio);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("cuit", cuit);
	}
}
