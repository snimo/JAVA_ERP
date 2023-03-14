package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.Puerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTableroTecnicoCIP extends Operation { 

  public TraerTableroTecnicoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	IDataSet dsTableroTecnico = this.getDataSetTabTecCIP();
	Iterator iterPuertas = 
		Puerta.getPuertasActivas(this.getSesion()).iterator();
	while (iterPuertas.hasNext()) {
		Puerta puerta = (Puerta) iterPuertas.next();
		cargarRegistro(dsTableroTecnico, puerta);
	}
    writeCliente(dsTableroTecnico);
  }

  private IDataSet getDataSetTabTecCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTableroTecnico");
    dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_puerta", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_puerta", Field.STRING, 100));
    dataset.fieldDef(new Field("ip", Field.STRING, 50));
    dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("ping", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_hor_inicio_ol", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_hor_ult_status", Field.STRING, 50));
    dataset.fieldDef(new Field("reiniciar", Field.STRING, 50));
    dataset.fieldDef(new Field("hab_entrada", Field.STRING, 50));
    dataset.fieldDef(new Field("hab_salida", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_hot_act_lb", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_hot_car_lb", Field.STRING, 50));
    dataset.fieldDef(new Field("cant_elementos_lb", Field.INTEGER, 0));
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                              Puerta puerta) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_puerta", puerta.getOIDInteger());
    dataset.fieldValue("cod_puerta", puerta.getCodigo());
    dataset.fieldValue("desc_puerta", puerta.getDescripcion());
    dataset.fieldValue("ip", puerta.getIP());
    dataset.fieldValue("puerto", puerta.getPuerto());
    if (puerta.isTienePing())
    	dataset.fieldValue("ping", "Si");
    else
    	dataset.fieldValue("ping", "No");
    dataset.fieldValue("fec_hor_inicio_ol", puerta.getFecHorONLINE());
    dataset.fieldValue("fec_hor_ult_status", puerta.getFecHorUltStatus());
    dataset.fieldValue("reiniciar", "Reiniciar");
    dataset.fieldValue("hab_entrada", "Habilitar");
    dataset.fieldValue("hab_salida", "Habilitar");
    dataset.fieldValue("fec_hot_act_lb", puerta.getFecHorUltActuLB());
    dataset.fieldValue("fec_hot_car_lb", puerta.getFecHorUltCargaLB());
    dataset.fieldValue("cant_elementos_lb", puerta.getCantRegLB());
    
  }
}
