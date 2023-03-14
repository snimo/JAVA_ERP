package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.AgrupadorDepositoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAgrupadorDeposito extends Operation { 

  public TraerAgrupadorDeposito() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    AgrupadorDeposito agrupadordeposito = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       agrupadordeposito = AgrupadorDeposito.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       agrupadordeposito = AgrupadorDeposito.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetAgrupadorDeposito = getDataSetAgrupadorDeposito();
    IDataSet datasetAgrupadorDepositoDet = getDataSetAgrupadorDepositoDet();
    
    if (agrupadordeposito != null) { 
        cargarRegistroAgrupadorDeposito(datasetAgrupadorDeposito, 
                         agrupadordeposito.getOIDInteger(),
                         agrupadordeposito.getCodigo(),
                         agrupadordeposito.getDescripcion(),
                         agrupadordeposito.isActivo());
        
        Iterator iterAgrupadoresDepoDet = agrupadordeposito.getAgrupadoresDepositoDet().iterator();
        while (iterAgrupadoresDepoDet.hasNext()) {
        	AgrupadorDepositoDet agrupadorDepoDet = (AgrupadorDepositoDet) iterAgrupadoresDepoDet.next();
        	cargarRegistroAgrupadorDepositoDet(datasetAgrupadorDepositoDet,agrupadorDepoDet);
        }
    }
    
    writeCliente(datasetAgrupadorDeposito);
    writeCliente(datasetAgrupadorDepositoDet);
  }

  private IDataSet getDataSetAgrupadorDeposito() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAgrupadorDeposito");
    dataset.fieldDef(new Field("oid_agrupador_depo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAgrupadorDeposito(IDataSet dataset, 
                         Integer oid_agrupador_depo,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_agrupador_depo", oid_agrupador_depo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetAgrupadorDepositoDet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAgrupadorDepositoDet");
    dataset.fieldDef(new Field("oid_agrupador_det", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_agrupador_depo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_deposito", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_deposito", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAgrupadorDepositoDet(IDataSet dataset, 
                         AgrupadorDepositoDet aAgrupadorDepositoDet) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_agrupador_det", aAgrupadorDepositoDet.getOIDInteger());
    dataset.fieldValue("oid_agrupador_depo", aAgrupadorDepositoDet.getAgrupador_deposito().getOIDInteger());
    dataset.fieldValue("oid_deposito", aAgrupadorDepositoDet.getDeposito().getOIDInteger());
    dataset.fieldValue("cod_deposito", aAgrupadorDepositoDet.getDeposito().getCodigo());
    dataset.fieldValue("desc_deposito", aAgrupadorDepositoDet.getDeposito().getDescripcion());
    dataset.fieldValue("activo", aAgrupadorDepositoDet.isActivo());
  }  
  
}
