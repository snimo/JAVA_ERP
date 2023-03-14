package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.Campania;
import com.srn.erp.crm.bm.EstadoCampania;
import com.srn.erp.crm.bm.TipoCampania;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCampania extends Operation { 

  public SaveCampania() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCampania"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) {
    	Campania campania = Campania.findByOid(dataset.getInteger("oid_campania"),getSesion());
        campania.setOID(dataset.getInteger("oid_campania"));
        campania.setCodigo(dataset.getString("codigo"));
        campania.setNombre(dataset.getString("nombre"));
        campania.setEstado(EstadoCampania.findByOidProxy(dataset.getInteger("oid_est_camp"),getSesion()));
        campania.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_precio_cab"),getSesion()));
        campania.setCant_resp_esp(dataset.getInteger("cant_resp_esp"));
        campania.setFecha_desde(dataset.getDate("fec_desde"));
        campania.setFecha_hasta(dataset.getDate("fec_hasta"));
        campania.setDescripcion(dataset.getString("descripcion"));
        campania.setComentario(dataset.getString("comentario"));
        campania.setUsuario_alta(Usuario.findByOidProxy(dataset.getInteger("oid_usu_alta"),getSesion()));
        campania.setTipoCampania(TipoCampania.findByOidProxy(dataset.getInteger("oid_tipo_camp"),getSesion()));
        campania.setFec_usu_alta(dataset.getDate("fec_alta"));
        campania.setActivo(dataset.getBoolean("activo"));
        addTransaccion(campania);
        dataset.next();
    }
  }
  
}
