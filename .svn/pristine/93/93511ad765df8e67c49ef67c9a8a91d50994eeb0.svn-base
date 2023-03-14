package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AutorizacionMontoCompra;
import com.srn.erp.compras.bm.AutorizadorCompra;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.bm.RolAutorizadorOC;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEsquemaAutorizCompras extends Operation {

	public TraerEsquemaAutorizCompras() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		EsquemaAutorizCompras esquemaAutorizCompras = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			esquemaAutorizCompras = EsquemaAutorizCompras.findByOid(oid,
					getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			esquemaAutorizCompras = EsquemaAutorizCompras.findByCodigo(codigo,
					getSesion());
		}

		IDataSet datasetEsquemaAutoriz = getDataSetEsquemaAutoriz();
		IDataSet datasetAutorizCpra = getDataSetAutorizacionCompra();
		IDataSet datasetAutorizMontos = getAutorizacionesPorMonto(); 
		IDataSet datasetRolesAutoriz = getRolesAutorizadores();
		IDataSet datasetClasifProd = getDataSetClasifProd();
		

		cargarEsquemaAutoriz(datasetEsquemaAutoriz,esquemaAutorizCompras);

		if (esquemaAutorizCompras.getClasificadorEntidad()!=null)
			cargarClasif(datasetClasifProd, esquemaAutorizCompras.getClasificadorEntidad());
		
		if (esquemaAutorizCompras.isUsarClasificador()==false) {
			IDataSet datasetValClasif = getDSValorClasifEnt();
			cargarValorClasificador(datasetValClasif);
			writeCliente(datasetValClasif);
		}
		
		Iterator iterAutorizCompras = esquemaAutorizCompras.getAutorizadoresCompras().iterator();
		while (iterAutorizCompras.hasNext()) {
			AutorizadorCompra autorizadorCompra = (AutorizadorCompra) iterAutorizCompras.next();
			cargarAutorizadorCompra(datasetAutorizCpra,autorizadorCompra);
			Iterator iterRangoMontosAutoriz = autorizadorCompra.getAutorizacionesPorMontos().iterator();
			while (iterRangoMontosAutoriz.hasNext()) {
				AutorizacionMontoCompra autorizacionMontoCompra = (AutorizacionMontoCompra) iterRangoMontosAutoriz.next();
				cargarAutorizacionesPorMonto(datasetAutorizMontos,autorizacionMontoCompra);
				Iterator iterRolesAutoriz = autorizacionMontoCompra.getRolesAutorizaciones().iterator();
				while (iterRolesAutoriz.hasNext()) {
					RolAutorizadorOC rolAutorizadorOC = (RolAutorizadorOC) iterRolesAutoriz.next();
					cargarRolesAutorizadores(datasetRolesAutoriz,autorizacionMontoCompra,rolAutorizadorOC);
				}
				
			}
		}
		writeCliente(datasetEsquemaAutoriz);
		writeCliente(datasetAutorizCpra);
		writeCliente(datasetAutorizMontos); 
		writeCliente(datasetRolesAutoriz);
		writeCliente(datasetClasifProd);
		

	}
	
	private void cargarValorClasificador(IDataSet ds) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_clasif_ent", new Integer(0));
		ds.fieldValue("oid_clasif_ent", new Integer(0));
		ds.fieldValue("oid_item", new Integer(0));
		ds.fieldValue("oid_item_padre", new Integer(-1));
		ds.fieldValue("codigo", "SC");
		ds.fieldValue("descripcion", "Si el monto de la O.C. se encuentra entre ....");
	}

	private IDataSet getDataSetEsquemaAutoriz() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEsquemaAutorizCompras");
		dataset.fieldDef(new Field("oid_esq_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("ambito_esquema", Field.BOOLEAN, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("usar_clasificador", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nickname", Field.STRING, 50));
		return dataset;
	}

	private void cargarEsquemaAutoriz(IDataSet dataset,
			EsquemaAutorizCompras esquemaAutoriz) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_esq_autoriz", esquemaAutoriz.getOIDInteger());
		dataset.fieldValue("codigo", esquemaAutoriz.getCodigo());
		dataset.fieldValue("descripcion", esquemaAutoriz.getDescripcion());
		dataset
				.fieldValue("ambito_esquema", esquemaAutoriz
						.getAmbito_esquema());
		dataset.fieldValue("activo", esquemaAutoriz.isActivo());
		if (esquemaAutoriz.getClasificadorEntidad()!=null)
			dataset.fieldValue("oid_clasif_ent", esquemaAutoriz.getClasificadorEntidad().getOIDInteger());
		else
			dataset.fieldValue("oid_clasif_ent", new Integer(0));
		dataset.fieldValue("usar_clasificador", new Boolean(esquemaAutoriz.isUsarClasificador())); 
		dataset.fieldValue("nickname", esquemaAutoriz.getNombreNickName());
		
	}

	private IDataSet getDataSetAutorizacionCompra() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAutorizacionCompra");
		dataset.fieldDef(new Field("oid_autoriz_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_esq_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetClasifProd() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasificadoresDeProducto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarClasif(IDataSet dsClasif,ClasificadorEntidad clasif) throws BaseException {
		dsClasif.append();
		dsClasif.fieldValue("oid", clasif.getOIDInteger());
		dsClasif.fieldValue("codigo", clasif.getCodigo());
		dsClasif.fieldValue("descripcion", clasif.getDescripcion());
	}
	
	

	private void cargarAutorizadorCompra(IDataSet dataset,
			AutorizadorCompra autorizadorCompra) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_autoriz_cpra", autorizadorCompra
				.getOIDInteger());
		dataset.fieldValue("oid_esq_autoriz", autorizadorCompra
				.getEsquema_autoriz().getOIDInteger());
		if (autorizadorCompra.getValor_clasificador()!=null)
			dataset.fieldValue("oid_val_clasif_ent", autorizadorCompra.getValor_clasificador().getOIDInteger());
		else
			dataset.fieldValue("oid_val_clasif_ent", new Integer(0));
		dataset.fieldValue("oid_moneda", autorizadorCompra.getMoneda()
				.getOIDInteger());
	}

	private IDataSet getAutorizacionesPorMonto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMontosAutorizaciones");
		dataset.fieldDef(new Field("oid_autoriz_monto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_autoriz_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto_desde", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_hasta", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cualquier_sector", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarAutorizacionesPorMonto(IDataSet dataset,
			AutorizacionMontoCompra autorizacionMontoCompra)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_autoriz_monto", autorizacionMontoCompra
				.getOIDInteger());
		dataset.fieldValue("oid_autoriz_cpra", autorizacionMontoCompra
				.getAutorizacion_compra().getOIDInteger());
		dataset.fieldValue("secu", autorizacionMontoCompra.getSecu());
		dataset.fieldValue("monto_desde", autorizacionMontoCompra
				.getMonto_desde());
		dataset.fieldValue("monto_hasta", autorizacionMontoCompra
				.getMonto_hasta());
		dataset.fieldValue("cualquier_sector", autorizacionMontoCompra
				.isCualquier_sector());
		dataset.fieldValue("activo", true);

	}

	private IDataSet getRolesAutorizadores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRolesAutorizadoresOC");
		dataset.fieldDef(new Field("oid_rol_aut_cpras", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_autoriz_monto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_autoriz", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_secor_emisor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDSValorClasifEnt() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValorClasificador");
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_item_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	
	

	private void cargarRolesAutorizadores(IDataSet dataset,
			AutorizacionMontoCompra autorizacionMontoCompra,
			RolAutorizadorOC rolAutorizadorOC) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rol_aut_cpras", rolAutorizadorOC
				.getOIDInteger());
		dataset.fieldValue("oid_autoriz_monto", autorizacionMontoCompra.getOIDInteger());
		dataset.fieldValue("oid_rol_autoriz", rolAutorizadorOC
				.getRol_autorizador().getOIDInteger());
		dataset.fieldValue("tipo_autoriz", rolAutorizadorOC.getTipo_autoriz());
		if (rolAutorizadorOC.getSector_emisor() != null)
			dataset.fieldValue("oid_secor_emisor", rolAutorizadorOC
					.getSector_emisor().getOIDInteger());
		else
			dataset.fieldValue("oid_secor_emisor", 0);
		dataset.fieldValue("activo", true);
	}

}
