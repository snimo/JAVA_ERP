package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaValorClasif extends Operation {

	private ValorClasificadorEntidad	valorClasif	= null;
	private boolean esAlta = false;
	private boolean esModif = false;

	public SaveAltaValorClasif() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ClasificadorEntidad clasificador = ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasif"), this
				.getSesion());

		String codigo = mapaDatos.getString("codigo");
		String descripcion = mapaDatos.getString("descripcion");

		if (mapaDatos.containsKey("oid_val_clasif")) {
			// Se trata de una modificación
			esModif = true;
			valorClasif = ValorClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_val_clasif"), this.getSesion());
		}
		else {
			// Se trata de un Alta
			esAlta = true;
			valorClasif = clasificador.getValorClasifEnt(codigo);

			if (valorClasif != null)
				throw new ExceptionValidation(null, "Código ya existente:" + codigo);

			valorClasif = (ValorClasificadorEntidad) ValorClasificadorEntidad.getNew(ValorClasificadorEntidad.NICKNAME, this
					.getSesion());
		}

		
		if (this.esAlta || this.esModif) {		
		  valorClasif.setClasificador_entidad(clasificador);
		  valorClasif.setCodigo(codigo);
		  valorClasif.setDescripcion(descripcion);
		}
		
		if (this.esAlta) {
		  valorClasif.setActivo(new Boolean(true));
		  valorClasif.setTipo(ValorClasificadorEntidad.TIPO_TITULO);
		  valorClasif.setActivo(new Boolean(true));
		  valorClasif.setOid_item_padre(new Integer(ValorClasificadorEntidad.SIN_PADRE));
		  valorClasif.setOid_item(new Integer(clasificador.getUltNroItem() + 1));
		}
		
		this.addTransaccion(valorClasif);

	}

	private IDataSet getDataNuevoValClasif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNuevoValClasif");
		dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	protected void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();

		IDataSet ds = getDataNuevoValClasif();
		ds.append();
		ds.fieldValue("oid_clasif", valorClasif.getClasificador_entidad().getOIDInteger());
		ds.fieldValue("oid_val_clasif", this.valorClasif.getOIDInteger());
		ds.fieldValue("codigo", this.valorClasif.getCodigo());
		ds.fieldValue("descripcion", this.valorClasif.getDescripcion());
		writeCliente(ds);
	}

}
