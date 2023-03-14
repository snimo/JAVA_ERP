package com.srn.erp.bienUso.op;

import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSistemaValuacion extends Operation { 

  public SaveSistemaValuacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSistemaValuacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SistemaValuacion sistemavaluacion = SistemaValuacion.findByOid(dataset.getInteger("oid_sist_val"),getSesion());
        sistemavaluacion.setOID(dataset.getInteger("oid_sist_val"));
        sistemavaluacion.setCodigo(dataset.getString("codigo"));
        sistemavaluacion.setDescripcion(dataset.getString("descripcion"));
        sistemavaluacion.setTipo_amort(dataset.getString("tipo_amort"));
        sistemavaluacion.setContable(dataset.getBoolean("contable"));
        sistemavaluacion.setAju_inf(dataset.getBoolean("aju_inf"));
        sistemavaluacion.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        sistemavaluacion.setIndice(Indice.findByOidProxy(dataset.getInteger("oid_indice"),getSesion()));
        sistemavaluacion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(sistemavaluacion);
        dataset.next();
    }
  }
  
}
