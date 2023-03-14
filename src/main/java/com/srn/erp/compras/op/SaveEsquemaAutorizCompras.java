package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.AutorizacionMontoCompra;
import com.srn.erp.compras.bm.AutorizadorCompra;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.RolAutorizadorOC;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEsquemaAutorizCompras extends Operation { 

  public SaveEsquemaAutorizCompras() { 
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
        esquemaautorizcompras.setUsarClasificador(dataset.getBoolean("usar_clasificador").booleanValue());
        esquemaautorizcompras.setNombreNickName(dataset.getString("nickname"));
        
        
        IDataSet dsValoresClasif = dataset.getDataSet("TValorClasificador");
        dsValoresClasif.first();
        while (!dsValoresClasif.EOF()) {
        	IDataSet dsAutorizacionCompra = dsValoresClasif.getDataSet("TAutorizacionCompra");
        	dsAutorizacionCompra.first();
        	while (!dsAutorizacionCompra.EOF()) {
        		AutorizadorCompra autorizadorCompra = AutorizadorCompra.findByOid(dsAutorizacionCompra.getInteger("oid_autoriz_cpra"),getSesion());
        		autorizadorCompra.setEsquema_autoriz(esquemaautorizcompras);
        		if ((dsAutorizacionCompra.getInteger("oid_val_clasif_ent")!=null) &&
        				(dsAutorizacionCompra.getInteger("oid_val_clasif_ent").intValue()>0))
        			autorizadorCompra.setValor_clasificador(ValorClasificadorEntidad.findByOidProxy(dsAutorizacionCompra.getInteger("oid_val_clasif_ent"),getSesion()));
        		autorizadorCompra.setMoneda(Moneda.findByOidProxy(dsAutorizacionCompra.getInteger("oid_moneda"),getSesion()));
        		esquemaautorizcompras.addAutorizadorCompra(autorizadorCompra);
        	
        		IDataSet dsRangosMontos = dsAutorizacionCompra.getDataSet("TMontosAutorizaciones");
        		dsRangosMontos.first();
        		while (!dsRangosMontos.EOF()) {
        			AutorizacionMontoCompra autorizMontoCompra = AutorizacionMontoCompra.findByOid(dsRangosMontos.getInteger("oid_autoriz_monto"),getSesion());
        			autorizMontoCompra.setAutorizacion_compra(autorizadorCompra);
        			autorizMontoCompra.setSecu(dsRangosMontos.getInteger("secu"));
        			autorizMontoCompra.setMonto_desde(dsRangosMontos.getDouble("monto_desde"));
        			autorizMontoCompra.setMonto_hasta(dsRangosMontos.getDouble("monto_hasta"));
        			autorizMontoCompra.setCualquier_sector(dsRangosMontos.getBoolean("cualquier_sector"));
        			autorizadorCompra.addAutorizacionPorMonto(autorizMontoCompra);
        			if (dsRangosMontos.getBoolean("activo")==false)
        				autorizadorCompra.delete();
        		
        			IDataSet dsRolesAutorizadores = dsRangosMontos.getDataSet("TRolesAutorizadoresOC");
        			dsRolesAutorizadores.first();
        			while (!dsRolesAutorizadores.EOF()) {
        				RolAutorizadorOC rolAutorizadorOC = RolAutorizadorOC.findByOid(dsRolesAutorizadores.getInteger("oid_rol_aut_cpras"),getSesion());
        				rolAutorizadorOC.setRol_autorizador(RolAutorizadorCompras.findByOidProxy(dsRolesAutorizadores.getInteger("oid_rol_autoriz"),getSesion()));
        				rolAutorizadorOC.setTipo_autoriz(dsRolesAutorizadores.getString("tipo_autoriz"));
        				rolAutorizadorOC.setSector_emisor(SectorCompra.findByOidProxy(dsRolesAutorizadores.getInteger("oid_secor_emisor"),getSesion()));
        				if (dsRolesAutorizadores.getBoolean("activo")==false)
        					rolAutorizadorOC.delete();
        				
        				autorizMontoCompra.addRolAutorizacion(rolAutorizadorOC);
        				dsRolesAutorizadores.next();
        			} // FIN ROLES AUTORIZADORES
        			dsRangosMontos.next();
        		} // FIN RANGOS
        		dsAutorizacionCompra.next();
        	} // FIN AUTORIZACION COMPRA
        	dsValoresClasif.next();
        } // FIN VALORES CLASIFICADOR
        addTransaccion(esquemaautorizcompras);
        dataset.next();
     } // ESQUEMAS
  }
}
