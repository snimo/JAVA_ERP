package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.EsqHabProdUsu;
import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEsqHabProdRequi extends Operation { 

  public SaveEsqHabProdRequi() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEsquemaHabProd"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EsquemaHabilitacionProducto esqHabProd = EsquemaHabilitacionProducto.findByOid(dataset.getInteger("oid_esq_hab_prod"),getSesion());
        esqHabProd.setCodigo(dataset.getString("codigo"));
        esqHabProd.setDescripcion(dataset.getString("descripcion"));
        esqHabProd.setAmbito_esquema(dataset.getString("ambito_esquema"));
        esqHabProd.setActivo(dataset.getBoolean("activo"));
        esqHabProd.setClasificador(ClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_ent"),getSesion()));
        
        IDataSet dsValClasif = dataset.getDataSet("TValorClasificador");
        dsValClasif.first();
        while (!dsValClasif.EOF()) {
        	IDataSet dsUsuariosHab = dsValClasif.getDataSet("TEsquemaHabProdUsu");
        	dsUsuariosHab.first();
        	while (!dsUsuariosHab.EOF()) {
        		EsqHabProdUsu esqHabProdUsu = EsqHabProdUsu.findByOid(dsUsuariosHab.getInteger("oid_esq_hab_usu"),getSesion());
        		esqHabProdUsu.setEsquema_habilitacion(esqHabProd);
        		esqHabProdUsu.setUsuario(Usuario.findByOid(dsUsuariosHab.getInteger("oid_usuario"),getSesion()));
        		esqHabProdUsu.setValor_clasificador(ValorClasificadorEntidad.findByOid(dsUsuariosHab.getInteger("oid_val_clasif_ent"),getSesion()));
        		if (!dsUsuariosHab.getBoolean("activo").booleanValue())
        			esqHabProdUsu.delete();
        		esqHabProd.addDetalle(esqHabProdUsu);
        		dsUsuariosHab.next();
        	}
        	dsValClasif.next();
        }
        
        
        addTransaccion(esqHabProd);
        dataset.next();
    }
  }
}
