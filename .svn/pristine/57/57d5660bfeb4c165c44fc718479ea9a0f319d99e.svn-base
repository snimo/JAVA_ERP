package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.UsuarioRolAutorizadorCompras;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRolAutorizadorCompras extends Operation {

	public TraerRolAutorizadorCompras() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RolAutorizadorCompras rolautorizadorcompras = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			rolautorizadorcompras = RolAutorizadorCompras.findByOid(oid,
					getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			rolautorizadorcompras = RolAutorizadorCompras.findByCodigo(codigo,
					getSesion());
		}

		IDataSet datasetRolAutorizadorCompras = getDataSetRolAutorizadorCompras();
		IDataSet datasetUsuRol = getDataSetUsuarioRolAutorizadorCompras();
		
		if (rolautorizadorcompras != null) {
			cargarRegistroRolAutorizadorCompras(datasetRolAutorizadorCompras,
					rolautorizadorcompras.getOIDInteger(),
					rolautorizadorcompras.getCodigo(), rolautorizadorcompras
							.getDescripcion(), rolautorizadorcompras.isActivo());
			traerUsuariosRol(rolautorizadorcompras,datasetUsuRol);
			
		}
		writeCliente(datasetRolAutorizadorCompras);
		writeCliente(datasetUsuRol);
	}
	
    private void traerUsuariosRol(RolAutorizadorCompras rolAutoriz,IDataSet dataSetUsuRol) throws BaseException {
    	Iterator iterUsuariosRol = rolAutoriz.getUsuariosRol().iterator();
    	while (iterUsuariosRol.hasNext()) {
    		UsuarioRolAutorizadorCompras usuRol = (UsuarioRolAutorizadorCompras) iterUsuariosRol.next();
    		cargarRegistroUsuarioRolAutorizadorCompras(dataSetUsuRol,usuRol.getOIDInteger(),usuRol.getRol_autorizador(),usuRol.getUsuario());
    		
    	}
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
			Integer oid_rol_autoriz, String codigo, String descripcion,
			Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_rol_autoriz", oid_rol_autoriz);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetUsuarioRolAutorizadorCompras() {
		IDataSet dataset = new TDataSet();
		dataset.create("TUsuarioRolAutorizadorCompras");
		dataset.fieldDef(new Field("oid_usu_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_usuario", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_usuario", Field.STRING, 100));		
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroUsuarioRolAutorizadorCompras(IDataSet dataset,
			Integer oid_usu_autoriz, RolAutorizadorCompras rolAutorizador,
			Usuario usuario) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_usu_autoriz", oid_usu_autoriz);
		dataset.fieldValue("oid_rol_autoriz", rolAutorizador.getOIDInteger());
		dataset.fieldValue("oid_usuario", usuario.getOIDInteger());
		dataset.fieldValue("cod_usuario", usuario.getLogin());
		dataset.fieldValue("nombre_usuario", usuario.getApellido()+" - "+usuario.getNombre());
		dataset.fieldValue("activo", new Boolean(true));
	}

}
