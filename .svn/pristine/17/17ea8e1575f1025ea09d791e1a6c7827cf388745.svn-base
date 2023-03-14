package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTarjetaConciTar extends Operation { 

  public SaveTarjetaConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTarjetaConciTar"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TarjetaConciTar tarjetaconcitar = TarjetaConciTar.findByOid(dataset.getInteger("oid_tar_conci"),getSesion());
        tarjetaconcitar.setOID(dataset.getInteger("oid_tar_conci"));
        tarjetaconcitar.setCodigo(dataset.getString("codigo"));
        tarjetaconcitar.setDescripcion(dataset.getString("descripcion"));
        tarjetaconcitar.setIdentif_tarj(dataset.getString("identif_tarj"));
        tarjetaconcitar.setActivo(dataset.getBoolean("activo"));
        tarjetaconcitar.setCodigoPosNet(dataset.getString("codigo_posnet"));
        tarjetaconcitar.setAgrupador(AgrupadorTarjConci.findByOidProxy(dataset.getInteger("oid_agrupador"), this.getSesion()));
        tarjetaconcitar.setToleranciaDiasFecConci(dataset.getInteger("tol_dias_fec_conci"));
        tarjetaconcitar.setTolDiasConciOK(dataset.getInteger("tol_dias_conc_ok"));
        tarjetaconcitar.setCtaTarjetaACobrar(dataset.getString("acob_cta_tarj"));
        tarjetaconcitar.setCtaTarjetaACobrarC1(dataset.getString("acob_cta_tarj_c1"));
        tarjetaconcitar.setCtaTarjetaACobrarC2(dataset.getString("acob_cta_tarj_c2"));
        tarjetaconcitar.setIgnorarMovPOSNET(dataset.getBoolean("ignorar_mov_posnet"));
        tarjetaconcitar.setLiquidacion(dataset.getString("liquidacion"));
        tarjetaconcitar.setCabModeloLiq(CabModeloLiq.findByOidProxy(dataset.getInteger("oid_modelo_liq"), this.getSesion()));
        
        IDataSet dsTarjModeloLiq = dataset.getDataSet("TTarjModeloLiq");
        dsTarjModeloLiq.first();
        while (!dsTarjModeloLiq.EOF()) {
        	TarjModeloLiq tarjModeloLiq =
        		TarjModeloLiq.findByOid(dsTarjModeloLiq.getInteger("oid_tarj_mod_liq"), this.getSesion());
        	tarjModeloLiq.setTarjeta(tarjetaconcitar);
        	tarjModeloLiq.setEmpresa(EmpresaConciTar.findByOidProxy(dsTarjModeloLiq.getInteger("oid_empresa"), this.getSesion()));
        	tarjModeloLiq.setModelo_liquidacion(CabModeloLiq.findByOidProxy(dsTarjModeloLiq.getInteger("oid_modelo_liq"), this.getSesion()));
        	tarjModeloLiq.setActivo(dsTarjModeloLiq.getBoolean("activo"));
        	tarjetaconcitar.addModeloLiq(tarjModeloLiq);
        	
        	dsTarjModeloLiq.next();
        }
        
        
        addTransaccion(tarjetaconcitar);
        dataset.next();
    }
  }
  
}
