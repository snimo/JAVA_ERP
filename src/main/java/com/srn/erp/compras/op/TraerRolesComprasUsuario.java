package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.RolAutorizadorCompras;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRolesComprasUsuario extends Operation {

	public TraerRolesComprasUsuario() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidUsuario = mapaDatos.getInteger("oid_usuario");
		Usuario usuario = Usuario.findByOidProxy(oidUsuario,getSesion());
		
		IDataSet dsRoles = getDataSetRolAutorizadorCompras();
				
		Iterator iterRolAutorizCompras = RolAutorizadorCompras.getRolesComprasByUsuario(usuario,getSesion()).iterator();
		while (iterRolAutorizCompras.hasNext()) {
			RolAutorizadorCompras rolAutorizCompras = (RolAutorizadorCompras) iterRolAutorizCompras.next();
			cargarRegistroRolAutorizadorCompras(dsRoles,rolAutorizCompras);
		}
		
		writeCliente(dsRoles);
	}
	

	private IDataSet getDataSetRolAutorizadorCompras() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRolAutorizadorCompras");
		dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRolAutorizadorCompras(IDataSet dataset,
			RolAutorizadorCompras rolAutorizador) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rol_autoriz", rolAutorizador.getOIDInteger());
		dataset.fieldValue("codigo", rolAutorizador.getCodigo());
		dataset.fieldValue("descripcion", rolAutorizador.getDescripcion());
		dataset.fieldValue("activo", rolAutorizador.isActivo());
	}

	
}
