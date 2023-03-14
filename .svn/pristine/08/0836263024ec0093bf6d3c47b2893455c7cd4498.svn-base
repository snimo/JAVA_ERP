package com.srn.erp.ctasAPagar.op;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactProv;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactSector;
import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEsquemaAutorizFactProv extends Operation {

	public SaveEsquemaAutorizFactProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TEsquemaAutorizFactProv");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			EsquemaAutorizFactProv esquemaautorizfactprov = EsquemaAutorizFactProv.findByOid(dataset
					.getInteger("oid_esq_aut_fact"), getSesion());
			esquemaautorizfactprov.setOID(dataset.getInteger("oid_esq_aut_fact"));
			esquemaautorizfactprov.setCodigo(dataset.getString("codigo"));
			esquemaautorizfactprov.setDescripcion(dataset.getString("descripcion"));
			esquemaautorizfactprov.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"), getSesion()));
			esquemaautorizfactprov.setActivo(dataset.getBoolean("activo"));
			
			IDataSet dsEsquemaMontos = dataset.getDataSet("TEsquemaAutorizFactMonto");
			dsEsquemaMontos.first();
			while (!dsEsquemaMontos.EOF()) {
				EsquemaAutorizFactMonto esqAutFactMonto = EsquemaAutorizFactMonto.findByOid(dsEsquemaMontos.getInteger("oid_esq_aut_mon"),getSesion());
				esqAutFactMonto.setEsquema_autoriz_factura(esquemaautorizfactprov);
				esqAutFactMonto.setOrden(dsEsquemaMontos.getInteger("orden"));
				esqAutFactMonto.setMonto_desde(dsEsquemaMontos.getMoney("monto_desde"));
				esqAutFactMonto.setMonto_hasta(dsEsquemaMontos.getMoney("monto_hasta"));
				if (dsEsquemaMontos.getBoolean("activo").booleanValue()==false)
					esqAutFactMonto.delete();
				esquemaautorizfactprov.addEsquemaAutorizFactMonto(esqAutFactMonto);
				
				IDataSet dsEsquemasSectores = dsEsquemaMontos.getDataSet("TEsquemaAutorizFactSector");
				dsEsquemasSectores.first();
				while (!dsEsquemasSectores.EOF()) {
					EsquemaAutorizFactSector esqAutFactSector = EsquemaAutorizFactSector.findByOid(dsEsquemasSectores.getInteger("oid_esq_aut_sec"),getSesion());
					esqAutFactSector.setEsquema_autoriz_factura_monto(esqAutFactMonto);
					esqAutFactSector.setSector_compra(SectorCompra.findByOidProxy(dsEsquemasSectores.getInteger("oid_sector_compra"),getSesion()));
					esqAutFactSector.setRol_autotizador(RolAutorizadorCompras.findByOidProxy(dsEsquemasSectores.getInteger("oid_rol_autoriz"),getSesion()));
					esqAutFactSector.setTipo_autoriz(dsEsquemasSectores.getString("tipo_autoriz"));
					if (dsEsquemasSectores.getBoolean("activo").booleanValue() == false) 
						esqAutFactSector.delete();
					esqAutFactMonto.addEsquemaAutorizFactSector(esqAutFactSector);
					dsEsquemasSectores.next();
					 
				}
				dsEsquemaMontos.next();
			}
			addTransaccion(esquemaautorizfactprov);
			dataset.next();
		}
	}

}
