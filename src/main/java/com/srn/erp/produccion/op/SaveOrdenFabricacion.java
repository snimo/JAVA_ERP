package com.srn.erp.produccion.op;

import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.produccion.bm.OrdenFabricacion;
import com.srn.erp.produccion.bm.Planta;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveOrdenFabricacion extends Operation {

	public SaveOrdenFabricacion() {
	}

	private OrdenFabricacion ordenfabricacion = null;

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TOrdenFabricacion");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			ordenfabricacion = OrdenFabricacion.findByOid(dataset.getInteger("oid_orden_fab"), getSesion());
			ordenfabricacion.setOID(dataset.getInteger("oid_orden_fab"));

			Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"), getSesion());
			if (talonario == null)
				throw new ExceptionValidation(null, "Debe ingresar el talonario");
			ordenfabricacion.setTalonario(talonario);
			ordenfabricacion.setContabiliza(false);
			ordenfabricacion.setEmision(dataset.getDate("fecha"));
			ordenfabricacion.setImputac(dataset.getDate("fecha"));
			ordenfabricacion.setTipoCompro(talonario.getTipo_comprobante());
			ordenfabricacion.setLetra(talonario.getLetra());
			ordenfabricacion.setLugarEmision(talonario.getLugar_emision());
			ordenfabricacion.setNrolugemision(talonario.getLugar_emision().getLugemi());
			ordenfabricacion.setComentario("");

			ordenfabricacion.setProducto(Producto.findByOidProxy(dataset.getInteger("oid_producto"), this.getSesion()));
			ordenfabricacion.setCantidad(dataset.getDouble("cantidad"));
			ordenfabricacion.setUnidad_medida(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um"), this.getSesion()));
			ordenfabricacion.setFec_ini_est(dataset.getDate("fec_ini_est"));
			ordenfabricacion.setFec_fin_est(dataset.getDate("fec_fin_est"));
			ordenfabricacion.setObs_ord_fab(dataset.getString("obs_ord_fab"));
			ordenfabricacion.setPlanta(Planta.findByOidProxy(dataset.getInteger("oid_planta"), this.getSesion()));
			ordenfabricacion.setAlternativa_fabricacion(AlternativaFabricacion.findByOidProxy(dataset.getInteger("oid_alter_fabri"), this
					.getSesion()));
			ordenfabricacion.setObs_ord_fab(dataset.getString("obs_ord_fab"));
			ordenfabricacion.setTipoOrden(dataset.getString("tipo_orden"));
			ordenfabricacion.setActivo(dataset.getBoolean("activo"));
			if (!ordenfabricacion.isActivo())
				ordenfabricacion.delete();

			addTransaccion(ordenfabricacion);
			dataset.next();
		}
	}

	protected void afterSave() throws BaseException {

		if (ordenfabricacion != null) {
			InformarComprobante infoCompro = new InformarComprobante(ordenfabricacion.getOIDInteger(), ordenfabricacion.getDescripcion());

			writeCliente(infoCompro.getDataSetInfoCompro());
		}

	}

}
