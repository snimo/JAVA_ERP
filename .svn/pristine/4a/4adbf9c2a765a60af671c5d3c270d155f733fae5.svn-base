package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.produccion.bm.OperAlterFab;
import com.srn.erp.produccion.bm.OperacionProductiva;
import com.srn.erp.produccion.bm.ProcesoProductivo;
import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.bm.TipoEstacionTrabajo;
import com.srn.erp.produccion.bm.UMTiempoProduccion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAlternativaFabricacion extends Operation {

	public SaveAlternativaFabricacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TProducto");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {

		dataset.first();
		while (!dataset.EOF()) {

			IDataSet dsAltFab = dataset.getDataSet("TAlternativaFabricacion");
			dsAltFab.first();
			while (!dsAltFab.EOF()) {

				AlternativaFabricacion alternativafabricacion = AlternativaFabricacion.findByOid(dsAltFab.getInteger("oid_alter_fabri"),
						getSesion());
				alternativafabricacion.setOID(dsAltFab.getInteger("oid_alter_fabri"));
				alternativafabricacion.setReceta(RecetaCab.findByOidProxy(dsAltFab.getInteger("oid_rec_cab"), this.getSesion()));
				
				if (alternativafabricacion.getReceta() == null)
					throw new ExceptionValidation(null,"Debe seleccionar una receta");
				
				setRefreshObjNeg(alternativafabricacion.getReceta().getProduco().getOIDInteger());
				
				alternativafabricacion.setAlternativa(dsAltFab.getString("alternativa"));
				alternativafabricacion.setActivo(dsAltFab.getBoolean("activo"));
				addTransaccion(alternativafabricacion);
				
				IDataSet dsOperAltFab = dsAltFab.getDataSet("TOperAlterFab");
				dsOperAltFab.first();
				while (!dsOperAltFab.EOF()) {
					OperAlterFab operAltFab =
						OperAlterFab.findByOid(dsOperAltFab.getInteger("oid_oper_fabri"), this.getSesion());
					operAltFab.setAlternativa_fabricacion(alternativafabricacion);
					operAltFab.setProceso(ProcesoProductivo.findByOidProxy(dsOperAltFab.getInteger("oid_proceso"), this.getSesion()));
					operAltFab.setOperacion(OperacionProductiva.findByOidProxy(dsOperAltFab.getInteger("oid_operacion"), this.getSesion()));
					operAltFab.setTipo_estacion(TipoEstacionTrabajo.findByOidProxy(dsOperAltFab.getInteger("oid_tipo_estacion"), this.getSesion()));
					operAltFab.setTiempo_std(dsOperAltFab.getDouble("tiempo_std"));
					operAltFab.setUMTiempoProduccion(UMTiempoProduccion.findByOidProxy(dsOperAltFab.getInteger("oid_um_tiempo"), this.getSesion()));
					operAltFab.setComportamiento(dsOperAltFab.getString("comportamiento"));
					operAltFab.setOid_rel(dsOperAltFab.getString("oid_rel"));
					operAltFab.setOid_rel_padre(dsOperAltFab.getString("oid_rel_padre"));
					operAltFab.setObservacion(dsOperAltFab.getString("observacion"));
					operAltFab.setActivo(dsOperAltFab.getBoolean("activo"));
					
					if (!operAltFab.isActivo())
						operAltFab.delete();
					
					alternativafabricacion.addOperAltFab(operAltFab);
					
					dsOperAltFab.next();
				}
				
				
				
				dsAltFab.next();
			}
			dataset.next();
		}
	}

}
