package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.GruDetUsuMens;
import com.srn.erp.mensajero.bm.GrupoUsuMens;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoUsuMens extends Operation {

	public SaveGrupoUsuMens() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TGrupoUsuMens");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			GrupoUsuMens grupousumens = GrupoUsuMens.findByOid(dataset.getInteger("oid_grupo_dest_cab"), getSesion());
			grupousumens.setOID(dataset.getInteger("oid_grupo_dest_cab"));
			grupousumens.setNombre(dataset.getString("nombre"));
			grupousumens.setScope(dataset.getString("scope"));
			grupousumens.setUsuario_priveado(Usuario.findByOidProxy(dataset.getInteger("oid_usu_priv"), this.getSesion()));
			grupousumens.setActivo(dataset.getBoolean("activo"));
			
			IDataSet dsGrupoDet = dataset.getDataSet("TDetGrupoUsuMens");
			dsGrupoDet.first();
			while (!dsGrupoDet.EOF()) {
				GruDetUsuMens grupoDetUsuMens =
					GruDetUsuMens.findByOid(dsGrupoDet.getInteger("oid_grupo_dest_det"), this.getSesion());
				grupoDetUsuMens.setGrupo_dest_cab(grupousumens);
				grupoDetUsuMens.setUsuario(Usuario.findByOidProxy(dsGrupoDet.getInteger("oid_usuario"), this.getSesion()));
				grupoDetUsuMens.setActivo(dsGrupoDet.getBoolean("activo"));
				if (!grupoDetUsuMens.isActivo())
					grupoDetUsuMens.delete();
					
				grupousumens.addDetUsuGrupo(grupoDetUsuMens);
				dsGrupoDet.next();
			}
			
			
			addTransaccion(grupousumens);
			dataset.next();
		}
	}

}
