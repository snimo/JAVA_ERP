package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AutorizadorRequisicion;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEsquemaAutorizRequi extends Operation {

  public TraerEsquemaAutorizRequi() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    EsquemaAutorizCompras esquemaAutorizCompras = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       esquemaAutorizCompras = EsquemaAutorizCompras.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       esquemaAutorizCompras = EsquemaAutorizCompras.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEsquemaAutoriz = getDataSetEsquemaAutoriz();
    IDataSet datasetAutorizRequi   = getDataSetAutorizadorRequisicion();
    IDataSet dsValorClasif = getDataSetValorClasif();
    
    if (esquemaAutorizCompras != null) {
        cargarEsquemaAutoriz(datasetEsquemaAutoriz,
        		esquemaAutorizCompras);
        Iterator iterAutorizReq = esquemaAutorizCompras.getAutorizadoresRequiciones().iterator();
        while (iterAutorizReq.hasNext()) {
        	AutorizadorRequisicion autorizReq = (AutorizadorRequisicion) iterAutorizReq.next();
        	cargarRegistroAutorizadorRequisicion(datasetAutorizRequi,
        			autorizReq.getOIDInteger(),
        			esquemaAutorizCompras,
        			autorizReq.getSector_emisor(),
        			autorizReq.getRol_autorizador(),
        			autorizReq.getValor_clasificador(),
        			autorizReq.getTipoAutoriz()
        			);
        }
        
        Iterator iterValoresClasif = null;
        if (esquemaAutorizCompras.getClasificadorEntidad()!=null) {
        	iterValoresClasif = esquemaAutorizCompras.getClasificadorEntidad().getValoresClasificador(null,null).iterator();
        	while (iterValoresClasif.hasNext()) {
        		ValorClasificadorEntidad valorClasificadorEntidad =
        			(ValorClasificadorEntidad) iterValoresClasif.next();
        		cargarValorClasif(dsValorClasif,valorClasificadorEntidad);
        	}
        }
        
        
    }    
    
    writeCliente(datasetEsquemaAutoriz);
    writeCliente(datasetAutorizRequi);
    writeCliente(dsValorClasif);
    
    
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
    return dataset;
  }

  private void cargarEsquemaAutoriz(IDataSet dataset,
		  EsquemaAutorizCompras esquemaAutoriz)  throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_esq_autoriz", esquemaAutoriz.getOIDInteger());
    dataset.fieldValue("codigo", esquemaAutoriz.getCodigo());
    dataset.fieldValue("descripcion", esquemaAutoriz.getDescripcion());
    dataset.fieldValue("ambito_esquema", esquemaAutoriz.getAmbito_esquema());
    dataset.fieldValue("activo", esquemaAutoriz.isActivo());
    dataset.fieldValue("oid_clasif_ent", esquemaAutoriz.getClasificadorEntidad().getOIDInteger());
  }
  
  private IDataSet getDataSetAutorizadorRequisicion() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAutorizadorRequisicion");
	    dataset.fieldDef(new Field("oid_autoriz_req", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_esq_autoriz", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_sector_emisor", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("tipo_autoriz", Field.STRING, 20));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
	  }

	  private void cargarRegistroAutorizadorRequisicion(IDataSet dataset, 
	                         Integer oid_autoriz_req,
	                         EsquemaAutorizCompras esquemaAutoriz,
	                         SectorCompra sector,
	                         RolAutorizadorCompras rol,
	                         ValorClasificadorEntidad valorClasif,
	                         String tipoAutoriz) {
	    dataset.append(); 
	    dataset.fieldValue("oid_autoriz_req", oid_autoriz_req);
	    dataset.fieldValue("oid_esq_autoriz", esquemaAutoriz.getOIDInteger());
	    dataset.fieldValue("oid_sector_emisor", sector.getOIDInteger());
	    dataset.fieldValue("oid_rol_autoriz", rol.getOIDInteger());
	    dataset.fieldValue("oid_val_clasif_ent", valorClasif.getOIDInteger());
	    dataset.fieldValue("tipo_autoriz", tipoAutoriz);
	    dataset.fieldValue("activo", new Boolean(true));
	    
	  }
	  
		private IDataSet getDataSetValorClasif() {
			IDataSet dataset = new TDataSet();
			dataset.create("TValorClasificador");
			dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_item", Field.INTEGER, 0));
			dataset.fieldDef(new Field("codigo", Field.STRING, 30));
			dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
			dataset.fieldDef(new Field("oid_item_padre", Field.INTEGER, 0));
			dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
			dataset.fieldDef(new Field("tipo", Field.STRING, 30));
			dataset.fieldDef(new Field("codigo_desde", Field.STRING, 50));
			dataset.fieldDef(new Field("codigo_hasta", Field.STRING, 50));
			return dataset;
		}

		private void cargarValorClasif(IDataSet dataset,
				ValorClasificadorEntidad valorClasifEnt) throws BaseException {
			dataset.append();
			dataset.fieldValue("oid_val_clasif_ent", valorClasifEnt.getOIDInteger());
			dataset.fieldValue("oid_clasif_ent", valorClasifEnt.getClasificador_entidad().getOIDInteger());
			dataset.fieldValue("oid_item", valorClasifEnt.getOid_item());
			dataset.fieldValue("codigo", valorClasifEnt.getCodigo());
			dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
			dataset.fieldValue("oid_item_padre", valorClasifEnt.getOid_item_padre());
			dataset.fieldValue("activo", valorClasifEnt.isActivo());
			dataset.fieldValue("orden", valorClasifEnt.getOrden());
			dataset.fieldValue("tipo", valorClasifEnt.getTipo());
			dataset.fieldValue("codigo_desde", valorClasifEnt.getCodigoDesde());
			dataset.fieldValue("codigo_hasta", valorClasifEnt.getCodigoHasta());
		}
	  
  
}
