package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSectoresComprasUsuario extends Operation {

	public TraerSectoresComprasUsuario() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet datasetSectorCompra = getDataSetSectorCompra();
		Usuario usuario = Usuario.findByOid(getSesion().getLogin().getUsuario().getOIDInteger(),getSesion());
		
		Iterator iterSectoresCompras = SectorCompra.getSectoresCompras(usuario,getSesion()).iterator();
		while (iterSectoresCompras.hasNext()) {
			SectorCompra sectorCompra = (SectorCompra) iterSectoresCompras.next();
			cargarRegistroSectorCompra(datasetSectorCompra,sectorCompra.getOIDInteger(),
									   sectorCompra.getCodigo(),sectorCompra.getDescripcion(),
									   sectorCompra.getSucursal(),sectorCompra.isActivo());
			
		}
		writeCliente(datasetSectorCompra);
	}

	private IDataSet getDataSetSectorCompra() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSectoresCompras");
		dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSectorCompra(IDataSet dataset, Integer oid,
			String codigo, String descripcion, Sucursal sucursal, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_sector_compra", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("oid_sucursal", sucursal.getOIDInteger());
		dataset.fieldValue("activo", activo);
	}
}
