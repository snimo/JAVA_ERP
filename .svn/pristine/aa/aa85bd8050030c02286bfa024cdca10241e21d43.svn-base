package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.AutorizadorRequisicion;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEsquemaAutorizRequi extends Operation { 

  public SaveEsquemaAutorizRequi() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEsquemaAutorizCompras"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EsquemaAutorizCompras esquemaautorizcompras = EsquemaAutorizCompras.findByOid(dataset.getInteger("oid_esq_autoriz"),getSesion());
        esquemaautorizcompras.setOID(dataset.getInteger("oid_esq_autoriz"));
        esquemaautorizcompras.setCodigo(dataset.getString("codigo"));
        esquemaautorizcompras.setDescripcion(dataset.getString("descripcion"));
        esquemaautorizcompras.setAmbito_esquema(dataset.getString("ambito_esquema"));
        esquemaautorizcompras.setActivo(dataset.getBoolean("activo"));
        esquemaautorizcompras.setClasificadorEntidad(ClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_ent"),getSesion()));
        
        IDataSet dsValClasif = dataset.getDataSet("TValorClasificador");
        dsValClasif.first();
        while (!dsValClasif.EOF()) {
        	IDataSet dsAutorizadorReq = dsValClasif.getDataSet("TAutorizadorRequisicion");
        	dsAutorizadorReq.first();
        	while (!dsAutorizadorReq.EOF()) {
        		AutorizadorRequisicion autorizReq = AutorizadorRequisicion.findByOid(dsAutorizadorReq.getInteger("oid_autoriz_req"),getSesion());
        		autorizReq.setEsquema_autorizacion(esquemaautorizcompras);
        		autorizReq.setSector_emisor(SectorCompra.findByOid(dsAutorizadorReq.getInteger("oid_sector_emisor"),getSesion()));
        		autorizReq.setRol_autorizador(RolAutorizadorCompras.findByOid(dsAutorizadorReq.getInteger("oid_rol_autoriz"),getSesion()));
        		autorizReq.setValor_clasificador(ValorClasificadorEntidad.findByOid(dsAutorizadorReq.getInteger("oid_val_clasif_ent"),getSesion()));
        		autorizReq.setTipoAutoriz(dsAutorizadorReq.getString("tipo_autoriz"));
        		if (!dsAutorizadorReq.getBoolean("activo").booleanValue())
        			autorizReq.delete();
        		esquemaautorizcompras.addAutorizadorRequisicion(autorizReq);
        		dsAutorizadorReq.next();
        	}
        	dsValClasif.next();
        }
        
        
        addTransaccion(esquemaautorizcompras);
        dataset.next();
    }
  }
}
