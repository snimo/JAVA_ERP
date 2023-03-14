package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.PerfilFiltroLegajo;

import framework.applicarionServer.bm.Seguridad.PerfilFuncionalUsuario;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFiltrosLegConsPlanifRotas extends Operation {

	public TraerFiltrosLegConsPlanifRotas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetFiltros();
		
		Usuario usuario = Usuario.findByOid(this.getSesion().getLogin().getUsuario().getOID(),this.getSesion());
		
		Iterator iterFiltrosLegCab = 
			FiltroLegCab.getFiltrosLegajosCabConsRotasPlanif(this.getSesion()).iterator();
		while (iterFiltrosLegCab.hasNext()) {
			
			FiltroLegCab filtroLegCab = (FiltroLegCab) iterFiltrosLegCab.next();
			
			boolean perfilHabilitado = false;
			Iterator iterPerfilesFiltro = 
				filtroLegCab.getPerfilesFiltro().iterator();
			while (iterPerfilesFiltro.hasNext()) {
				PerfilFiltroLegajo perfilFiltroLeg = (PerfilFiltroLegajo) iterPerfilesFiltro.next();
				
				Iterator iterPerfilesUsuario = 
					usuario.getPerfilesFuncionales().iterator();
				while (iterPerfilesUsuario.hasNext()) {
					PerfilFuncionalUsuario perfilFuncionalUsu = (PerfilFuncionalUsuario) iterPerfilesUsuario.next();
					if (perfilFiltroLeg.getPerfil().getOID()==perfilFuncionalUsu.getPerfilFuncion().getOID())
						perfilHabilitado = true;
				}
				
				
			}
			
			if (perfilHabilitado)
				cargarRegistroFiltro(ds, filtroLegCab);
		}
		
		writeCliente(ds);
		
	}

	private IDataSet getDataSetFiltros() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltros");
		dataset.fieldDef(new Field("oid_filtro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 2500));
		return dataset;
	}

	private void cargarRegistroFiltro(
			IDataSet dataset, FiltroLegCab filtro) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_filtro", filtro.getOID());
		dataset.fieldValue("descripcion", filtro.getDescripcion());
	}

}
