package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.EstructuraCompo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstructura extends Operation {

  public SaveEstructura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEstructura");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Estructura estructura = Estructura.findByOid(dataset.getInteger("oid_estruc"),getSesion());
        estructura.setOID(dataset.getInteger("oid_estruc"));
        estructura.setCodigo(dataset.getString("codigo"));
        estructura.setDescripcion(dataset.getString("descripcion"));
        estructura.setActivo(dataset.getBoolean("activo"));

        IDataSet datasetEstrucCompo = dataset.getDataSet(
          "TEstrucCompo");
        datasetEstrucCompo.first();
        while (!datasetEstrucCompo.EOF()) {

          EstructuraCompo estructuraCompo =
              EstructuraCompo.findByOid(datasetEstrucCompo.getInteger("oid_estruc_compo"),getSesion());
          estructuraCompo.setEstructura(estructura);
          estructuraCompo.setSecu(datasetEstrucCompo.getInteger("secu"));
          estructuraCompo.setComponente(Componente.findByOidProxy(datasetEstrucCompo.getInteger("oid_compo"),getSesion()));
          estructuraCompo.setActivo(datasetEstrucCompo.getBoolean("activo"));
          if (((datasetEstrucCompo.getInteger("oid_valor_default")!=null) &&
        		  datasetEstrucCompo.getInteger("oid_valor_default").intValue()>0))
        	  estructuraCompo.setValorDefault(estructuraCompo.getComponente().getValorCompo(datasetEstrucCompo.getInteger("oid_valor_default")));
          else
        	  estructuraCompo.setValorDefault(null);
          if (!estructuraCompo.isActivo())
        	  estructuraCompo.delete();
          
          estructura.addEstructuraCompo(estructuraCompo);
        	  
          
          
          datasetEstrucCompo.next();
        }

        addTransaccion(estructura);
        dataset.next();
    }
  }

}
