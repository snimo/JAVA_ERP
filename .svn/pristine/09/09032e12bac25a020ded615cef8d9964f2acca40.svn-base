package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.TarjModeloLiq;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTarjetaConciTar extends Operation { 

  public TraerTarjetaConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TarjetaConciTar tarjetaconcitar = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tarjetaconcitar = TarjetaConciTar.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tarjetaconcitar = TarjetaConciTar.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTarjetaConciTar = getDataSetTarjetaConciTar();
    IDataSet dsModTarjLiq = getDataSetTarjetaModLiq();
    
    if (tarjetaconcitar != null) { 
        cargarRegistroTarjetaConciTar(
        		datasetTarjetaConciTar, 
                tarjetaconcitar.getOIDInteger(),
                tarjetaconcitar.getCodigo(),
                tarjetaconcitar.getDescripcion(),
                tarjetaconcitar.getIdentif_tarj(),
                tarjetaconcitar.getCodigoPosnet(),
                tarjetaconcitar.isActivo(),
                tarjetaconcitar.getAgrupador().getOIDInteger(),
                tarjetaconcitar.getToleranciaDiasFecConci(),
                tarjetaconcitar.getTolDiasConciOK(),
                tarjetaconcitar.getCtaTarjetaACobrar(),
                tarjetaconcitar.getCtaTarjetaACobrarC1(),
                tarjetaconcitar.getCtaTarjetaACobrarC2(),
                tarjetaconcitar.isIgnorarMovPOSNET(),
                tarjetaconcitar.getLiquidacion(),
                tarjetaconcitar.getCabModeloLiq()
                );
        
        Iterator iterModLiq = 
        	tarjetaconcitar.getModelosLiq().iterator();
        while (iterModLiq.hasNext()) {
        	TarjModeloLiq tarjModeloLiq = (TarjModeloLiq) iterModLiq.next();
        	cargarRegistroTarjetaConciTar(dsModTarjLiq, tarjModeloLiq);
        }
        
    }
    
    writeCliente(datasetTarjetaConciTar);
    writeCliente(dsModTarjLiq);
  }

  private IDataSet getDataSetTarjetaConciTar() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTarjetaConciTar");
    dataset.fieldDef(new Field("oid_tar_conci", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("identif_tarj", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("codigo_posnet", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_agrupador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tol_dias_fec_conci", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tol_dias_conc_ok", Field.INTEGER, 0));
    dataset.fieldDef(new Field("acob_cta_tarj", Field.STRING, 50));
    dataset.fieldDef(new Field("acob_cta_tarj_c1", Field.STRING, 50));
    dataset.fieldDef(new Field("acob_cta_tarj_c2", Field.STRING, 50));
    dataset.fieldDef(new Field("ignorar_mov_posnet", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("liquidacion", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_modelo_liq", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataSetTarjetaModLiq() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TTarjModeloLiq");
	    dataset.fieldDef(new Field("oid_tarj_mod_liq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_tar_conci", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_modelo_liq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
	  }  
  
  private void cargarRegistroTarjetaConciTar(IDataSet datasetTarjModLiq,
		  									 TarjModeloLiq tarjModLiq) throws BaseException {
	  
	  datasetTarjModLiq.append();
	  datasetTarjModLiq.fieldValue("oid_tarj_mod_liq", tarjModLiq.getOIDInteger());
	  datasetTarjModLiq.fieldValue("oid_tar_conci", tarjModLiq.getTarjeta().getOIDInteger());
	  datasetTarjModLiq.fieldValue("oid_empresa", tarjModLiq.getEmpresa().getOIDInteger());
	  datasetTarjModLiq.fieldValue("oid_modelo_liq", tarjModLiq.getModelo_liquidacion().getOIDInteger());
	  datasetTarjModLiq.fieldValue("activo", tarjModLiq.isActivo());	  
	  
	  
  }

  private void cargarRegistroTarjetaConciTar(IDataSet dataset, 
                         Integer oid_tar_conci,
                         String codigo,
                         String descripcion,
                         String identif_tarj,
                         String codigoPosnet,
                         Boolean activo,
                         Integer oidAgrupador,
                         Integer tolDiasFecConci,
                         Integer totDiasConciOK,
                         String aCobCtaTarj,
                         String aCobCtaTarjC1,
                         String aCobCtaTarjC2,
                         Boolean ignorarMovPOSNET,
                         String liquidacion,
                         CabModeloLiq modeloLiq
                         ) {
    dataset.append(); 
    dataset.fieldValue("oid_tar_conci", oid_tar_conci);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("identif_tarj", identif_tarj);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("codigo_posnet", codigoPosnet);
    dataset.fieldValue("oid_agrupador", oidAgrupador);
    dataset.fieldValue("tol_dias_fec_conci", tolDiasFecConci);
    dataset.fieldValue("tol_dias_conc_ok", totDiasConciOK);
    dataset.fieldValue("acob_cta_tarj", aCobCtaTarj);
    dataset.fieldValue("acob_cta_tarj_c1", aCobCtaTarjC1);
    dataset.fieldValue("acob_cta_tarj_c2", aCobCtaTarjC2);
    dataset.fieldValue("ignorar_mov_posnet", ignorarMovPOSNET);
    dataset.fieldValue("liquidacion", liquidacion);
    if (modeloLiq!=null)
    	dataset.fieldValue("oid_modelo_liq", modeloLiq.getOID());
    else
    	dataset.fieldValue("oid_modelo_liq", "");
    
  }
}
