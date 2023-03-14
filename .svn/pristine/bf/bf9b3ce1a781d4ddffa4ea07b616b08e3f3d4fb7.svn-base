package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEmpresaConciTar extends Operation { 

  public SaveEmpresaConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEmpresaConciTar"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EmpresaConciTar empresaconcitar = EmpresaConciTar.findByOid(dataset.getInteger("oid_empresa"),getSesion());
        empresaconcitar.setOID(dataset.getInteger("oid_empresa"));
        empresaconcitar.setRazon_social(dataset.getString("razon_social"));
        empresaconcitar.setCuit(dataset.getString("cuit"));
        empresaconcitar.setActivo(dataset.getBoolean("activo"));
        empresaconcitar.setCodComercio(dataset.getString("cod_comercio"));
        empresaconcitar.setUltNroconci(dataset.getInteger("ult_nro_conci"));
        empresaconcitar.setCodEmpArchImpTarj(dataset.getString("cod_emp_arch_tarj"));
        empresaconcitar.setTipoAsiCob(dataset.getString("tipo_asi_cob"));
        empresaconcitar.setTipoAsiLiq(dataset.getString("tipo_asi_liqui"));
        empresaconcitar.setCodEmpInterfaz(dataset.getString("cod_emp_interfaz"));
        empresaconcitar.setTipoDocuAsiCobranza(dataset.getString("tipo_docu_asi_cob"));
        empresaconcitar.setUniContaAsiCobranza(dataset.getString("uni_conta_asi_cob"));
        empresaconcitar.setTipoDocuAsiLiquidacion(dataset.getString("tipo_docu_asi_liq"));
        empresaconcitar.setUnidadContaAsiLiq(dataset.getString("uni_conta_asi_liq"));
        
        addTransaccion(empresaconcitar);
        dataset.next();
    }
  }
  
}
