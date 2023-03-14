package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.ConfigTalonarioAjuStk;
import com.srn.erp.stock.bm.OperHabiTalonarioAjuStk;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfigTalonarioAjuStk extends Operation {

  public TraerConfigTalonarioAjuStk() {
  }

  private void traerCompoTalAjuStkByTalonario(Talonario talonario) throws BaseException {
  	
    ConfigTalonarioAjuStk configTalonarioAjuStk =
      ConfigTalonarioAjuStk.getConfigTalonarioAjuStk(talonario,getSesion());

    IDataSet datasetConfigTalonario    = getDataSetConfigTalonario();
    IDataSet datasetOperHabilitadas    = getDataSetOperHabilitadas();
    IDataSet datasetCompoStock         = getDataSetComportamientosStock();

    if (configTalonarioAjuStk != null) {
      cargarRegistroConfigTalonario(datasetConfigTalonario,
                       configTalonarioAjuStk.getOIDInteger(),
                       configTalonarioAjuStk.getTalonario(),
                       configTalonarioAjuStk.isActivo());
      cargarOperaciones(datasetOperHabilitadas,configTalonarioAjuStk,datasetCompoStock,talonario);
    }
    else {
    	cargarRegistroConfigTalonario(datasetConfigTalonario,
                                  new Integer( -1),
                                  talonario,
                                  new Boolean(true));
    	cargarOperaciones(datasetOperHabilitadas,datasetCompoStock,talonario);
    }
    
    writeCliente(datasetConfigTalonario);
    writeCliente(datasetOperHabilitadas);
    writeCliente(datasetCompoStock);
  	
  }
  
  public void execute(MapDatos mapaDatos) throws BaseException {

  	
  	if (mapaDatos.containsKey("oid")) {
			Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid"),
          getSesion());
			traerCompoTalAjuStkByTalonario(talonario);
  		
  	} else
  	
  		if (mapaDatos.containsKey("oid_talonario")) {
  			Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid_talonario"),
                                                getSesion());
  			traerCompoTalAjuStkByTalonario(talonario);
      
  		} else {
  			if (mapaDatos.containsKey("tipo_ajuste")) {
  				TraerCompoTalAjuStkByTipoAjuste(mapaDatos.getString("tipo_ajuste"));
  			}
  		}
  }
  
  private void TraerCompoTalAjuStkByTipoAjuste(String aTipoAjuste) throws BaseException {
  	
  	IDataSet datasetCompoStock         = getDataSetComportamientosStock();
  	
  	Iterator iterCompoStkTalAjuStk =
  		CompoStkTalonarioAjuStk.getCompoStkTalonarioAjuStkByTipoAjuste(aTipoAjuste,this.getSesion()).iterator();
  	while (iterCompoStkTalAjuStk.hasNext()) {
  		CompoStkTalonarioAjuStk compoStkTalAjuStk = (CompoStkTalonarioAjuStk) iterCompoStkTalAjuStk.next();
  		cargarRegistroCompoStock(datasetCompoStock,
  														compoStkTalAjuStk.getOIDInteger(),
  														compoStkTalAjuStk.getOper_habi_tal_ajustk().getOIDInteger(),
  														compoStkTalAjuStk.getTipo_conf_mov_tal(),
  														new Boolean(true),
  														compoStkTalAjuStk.isUsar_por_defecto());
  	}
  	
  	writeCliente(datasetCompoStock);
  	
  }

  private void cargarComportamientosStock(IDataSet datasetComportamientosoperHabiTalAjuStkStock,
                                          OperHabiTalonarioAjuStk operHabiTalAjuStk,
                                          Talonario talonario) throws BaseException {
    int oid = 0;
    ConfMovStkTalonario confMovStkTalonario =
        ConfMovStkTalonario.getConfMovStkByTalonario(talonario,getSesion());
    if (confMovStkTalonario == null) return;
    Iterator iterConfMovStkTalonario = confMovStkTalonario.getTiposConfMov().iterator();
    while (iterConfMovStkTalonario.hasNext()) {
      TipoConfMovStkTalonario tipoConfMovStk =  (TipoConfMovStkTalonario) iterConfMovStkTalonario.next();
      CompoStkTalonarioAjuStk compoStk =
          CompoStkTalonarioAjuStk.getCompoStkTalonarioAjuStk(operHabiTalAjuStk,tipoConfMovStk,getSesion());
      if (compoStk == null)
         cargarRegistroCompoStock(datasetComportamientosoperHabiTalAjuStkStock,
                                  new Integer(--oid),
                                  operHabiTalAjuStk.getOIDInteger(),
                                  tipoConfMovStk,
                                  new Boolean(false),
                                  new Boolean(false));
      else
        cargarRegistroCompoStock(datasetComportamientosoperHabiTalAjuStkStock,
                                 compoStk.getOIDInteger(),
                                 operHabiTalAjuStk.getOIDInteger(),
                                 tipoConfMovStk,
                                 new Boolean(true),
                                 compoStk.isUsar_por_defecto());

    }
  }

  private void cargarOperaciones(IDataSet datasetOperHabilitadas,
                                 IDataSet datasetCompoStock,
                                 Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposAjuStk = ComproAjusteStk.getAllTipos().keySet().iterator();
    while (iterTiposAjuStk.hasNext()) {
      String codigo      = (String) iterTiposAjuStk.next();
      String descripcion = (String) ComproAjusteStk.getTipos().get(codigo);
      cargarRegistroOperaciones(datasetOperHabilitadas,
                                new Integer(--oid),
                                new Integer(-1),
                                codigo,
                                descripcion,
                                new Boolean(false),
                                new Boolean(false));
      OperHabiTalonarioAjuStk operHabiTalAjuStk =
            (OperHabiTalonarioAjuStk) OperHabiTalonarioAjuStk.getNew(OperHabiTalonarioAjuStk.NICKNAME,getSesion());
      operHabiTalAjuStk.setOID(new Integer(oid));
      cargarComportamientosStock(datasetCompoStock,operHabiTalAjuStk,talonario);
    }
  }



  private void cargarOperaciones(IDataSet datasetOperHabilitadas,
                                 ConfigTalonarioAjuStk configTalonarioAjuStk,
                                 IDataSet dsCompoStk,
                                 Talonario talonario) throws BaseException {
    int oid = 0;
    
    
    
    Iterator iterOperHab = configTalonarioAjuStk.getOperacionesHabilitadas().iterator();
    while (iterOperHab.hasNext()) {
    	OperHabiTalonarioAjuStk operHabilitada =
            (OperHabiTalonarioAjuStk) iterOperHab.next();
    	
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                        operHabilitada.getOIDInteger(),
                                        configTalonarioAjuStk.getOIDInteger(),
                                        operHabilitada.getTipo_aju_stk(),
                                        "",
                                        new Boolean(true),
                                        operHabilitada.isUsar_por_defecto());
        cargarComportamientosStock(dsCompoStk,operHabilitada,talonario);
    }
    
  }


  private IDataSet getDataSetComportamientosStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientosStock");
    dataset.fieldDef(new Field("oid_compo_stk_aju", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oper_aju_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_conf_mov", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_conf_mov", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCompoStock(IDataSet dataset,
                                        Integer oidCompoStkRto,
                                        Integer oidOperTalRto,
                                        TipoConfMovStkTalonario tipoConfMovStkTal,
                                        Boolean habilitado,
                                        Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_stk_aju", oidCompoStkRto);
    dataset.fieldValue("oid_oper_aju_stk", oidOperTalRto);
    dataset.fieldValue("oid_tipo_conf_mov", tipoConfMovStkTal.getOIDInteger());
    dataset.fieldValue("cod_tipo_conf_mov", tipoConfMovStkTal.getCodigo());
    dataset.fieldValue("desc_tipo_conf_mov", tipoConfMovStkTal.getDescripcion());
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);

  }

  private IDataSet getDataSetOperHabilitadas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TOperHabilitadas");
    dataset.fieldDef(new Field("oid_oper_aju_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conf_tal_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_aju_stk", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_aju_stk", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroOperaciones(IDataSet dataset,
                                         Integer oidOperTalRto,
                                         Integer oidConfTalRto,
                                         String tipoRto,
                                         String descTipoRto,
                                         Boolean habilitado,
                                         Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_oper_aju_stk", oidOperTalRto);
    dataset.fieldValue("oid_conf_tal_stk", oidConfTalRto);
    dataset.fieldValue("tipo_aju_stk", tipoRto);
    dataset.fieldValue("desc_aju_stk", descTipoRto);
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);
  }

  private IDataSet getDataSetConfigTalonario() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConfigTalonarioAjuStk");
    dataset.fieldDef(new Field("oid_conf_tal_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_talonario", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_talonario", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroConfigTalonario(IDataSet dataset,
                         Integer oid_conf_tal_aju,
                         Talonario talonario,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conf_tal_stk", oid_conf_tal_aju);
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("cod_talonario", talonario.getCodigo());
    dataset.fieldValue("desc_talonario", talonario.getDescripcion());
    dataset.fieldValue("activo", activo);
  }

}
