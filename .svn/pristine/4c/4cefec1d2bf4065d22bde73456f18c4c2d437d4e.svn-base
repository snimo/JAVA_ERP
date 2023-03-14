package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.EstructuraCompo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComponentesEstructura extends Operation {
	
  public TraerComponentesEstructura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	  
	Estructura estructura = null;
	
	  
	if (mapaDatos.containsKey("oid_ana_con")) {
		Integer oidAnaCon = mapaDatos.getInteger("oid_ana_con");
		Cuenta cuenta = Cuenta.findByOid(oidAnaCon,getSesion());
		estructura = cuenta.getEstructura();
	} else if (mapaDatos.containsKey("oid_estructura")) {
		estructura = Estructura.findByOid(mapaDatos.getInteger("oid_estructura"),getSesion());
	}

    IDataSet datasetComponentes = getDataSetComponentes();

    if ((estructura!= null) && (!estructura.isNew())) {
      Iterator iterEstrucCompo =
    	  estructura.getEstrucComponenentes().iterator();
      while (iterEstrucCompo.hasNext()) {
        EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
        
        boolean esUltimo = false;
        
        if (iterEstrucCompo.hasNext() == false)
        	esUltimo = true;
        
        
        cargarRegistroComponente(datasetComponentes,
                                 estrucCompo.getComponente().getOIDInteger(),
                                 estrucCompo.getComponente().getCodigo(),
                                 estrucCompo.getComponente().getDescripcion(),
                                 estrucCompo.getComponente().getTipo(),
                                 estrucCompo.getComponente().getNombreNickName(),
                                 estrucCompo.getComponente().getNroClasificador(),
                                 esUltimo);
      }
    }

    writeCliente(datasetComponentes);
  }

  private IDataSet getDataSetComponentes() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComponentes");
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 6));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo", Field.STRING, 10));
    dataset.fieldDef(new Field("nombre_nickname", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("es_ultimo", Field.BOOLEAN, 0));
    
    return dataset;
  }

  private void cargarRegistroComponente(IDataSet dataset,
                                        Integer oid_compo,
                                        String codigo,
                                        String descripcion,
                                        String tipo,
                                        String nickname,
                                        Integer nroClasificador,
                                        Boolean esUltimo) {
    dataset.append();
    dataset.fieldValue("oid_compo", oid_compo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("nombre_nickname", nickname);
    dataset.fieldValue("nro_clasificador", nroClasificador);
    dataset.fieldValue("es_ultimo", esUltimo);
    
  }


}
