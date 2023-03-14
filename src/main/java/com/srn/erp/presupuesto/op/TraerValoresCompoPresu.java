package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresCompoPresu extends Operation { 

  public TraerValoresCompoPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet datasetValorCompoPresu = getDataSetValorCompoPresu();
    
    CompoPresupuestario compoPresu = 
    	CompoPresupuestario.findByOid(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
    
    Iterator iterCompoPresu = ValorCompoPresu.getValoresCompoPresu(compoPresu,this.getSesion()).iterator();
    while (iterCompoPresu.hasNext()) {
    	ValorCompoPresu valCompoPresu = (ValorCompoPresu) iterCompoPresu.next();
    	cargarRegistroValorCompoPresu(datasetValorCompoPresu,valCompoPresu);
    }
    
    writeCliente(datasetValorCompoPresu);
  }

  private IDataSet getDataSetValorCompoPresu() {
  	
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresCompoPresu");
    dataset.fieldDef(new Field("oid_val_compo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("nro_rel", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_rel_padre", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    
    for (int i=1;i<=80;++i) {
    	dataset.fieldDef(new Field("oid_val_com_"+i, Field.INTEGER, 0));
    	dataset.fieldDef(new Field("cod_val_com_"+i, Field.STRING, 50));
    	dataset.fieldDef(new Field("desc_val_com_"+i, Field.STRING, 100));
    }
      
    dataset.fieldDef(new Field("val_num_1", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_2", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_3", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_4", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_5", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_6", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_7", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_8", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_9", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_10", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_11", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_12", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_13", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_14", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_15", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_16", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_17", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_18", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_19", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_20", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_21", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_22", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_23", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_24", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_25", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_26", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_27", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_28", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_29", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_num_30", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_tex_1", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_2", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_3", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_4", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_5", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_6", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_7", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_8", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_9", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_10", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_11", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_12", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_13", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_14", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_15", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_16", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_17", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_18", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_19", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_tex_20", Field.STRING, 255)); 
    dataset.fieldDef(new Field("val_fec_1", Field.STRING, 0)); 
    dataset.fieldDef(new Field("val_fec_2", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_3", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_4", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_5", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_6", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_7", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_8", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_9", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_10", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_11", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_12", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_13", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_14", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_15", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_16", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_17", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_18", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_19", Field.DATE, 10)); 
    dataset.fieldDef(new Field("val_fec_20", Field.DATE, 10)); 
    return dataset;
  }

  private void cargarRegistroValorCompoPresu(IDataSet dataset, 
                         ValorCompoPresu valorCompoPresu) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_val_compo", valorCompoPresu.getOIDInteger());
    dataset.fieldValue("codigo", valorCompoPresu.getCodigo());
    dataset.fieldValue("descripcion", valorCompoPresu.getDescripcion());
    dataset.fieldValue("nro_rel", valorCompoPresu.getNro_rel());
    dataset.fieldValue("nro_rel_padre", valorCompoPresu.getNro_rel_padre());
    dataset.fieldValue("activo", valorCompoPresu.isActivo());
    dataset.fieldValue("oid_compo_presu", valorCompoPresu.getCompoPresupuestario().getOIDInteger());
    
    for (int i=1;i<=80;++i) {
    	
    		ValorCompoPresu valorCompoPresuAtri = (ValorCompoPresu) valorCompoPresu.getValorCompoAtri(i);
    		if (valorCompoPresuAtri!=null) {
        	dataset.fieldValue("oid_val_com_"+i, valorCompoPresuAtri.getOIDInteger());
        	dataset.fieldValue("cod_val_com_"+i, valorCompoPresuAtri.getCodigo());
        	dataset.fieldValue("desc_val_com_"+i, valorCompoPresuAtri.getDescripcion());
    		}
    		else {
        	dataset.fieldValue("oid_val_com_"+i, 0);
        	dataset.fieldValue("cod_val_com_"+i, "");
        	dataset.fieldValue("desc_val_com_"+i, "");
    		}
    		
    }
   
    dataset.fieldValue("val_num_1", valorCompoPresu.getVal_num_1());
    dataset.fieldValue("val_num_2", valorCompoPresu.getVal_num_2());
    dataset.fieldValue("val_num_3", valorCompoPresu.getVal_num_3());
    dataset.fieldValue("val_num_4", valorCompoPresu.getVal_num_4());
    dataset.fieldValue("val_num_5", valorCompoPresu.getVal_num_5());
    dataset.fieldValue("val_num_6", valorCompoPresu.getVal_num_6());
    dataset.fieldValue("val_num_7", valorCompoPresu.getVal_num_7());
    dataset.fieldValue("val_num_8", valorCompoPresu.getVal_num_8());
    dataset.fieldValue("val_num_9", valorCompoPresu.getVal_num_9());
    dataset.fieldValue("val_num_10", valorCompoPresu.getVal_num_10());
    dataset.fieldValue("val_num_11", valorCompoPresu.getVal_num_11());
    dataset.fieldValue("val_num_12", valorCompoPresu.getVal_num_12());
    dataset.fieldValue("val_num_13", valorCompoPresu.getVal_num_13());
    dataset.fieldValue("val_num_14", valorCompoPresu.getVal_num_14());
    dataset.fieldValue("val_num_15", valorCompoPresu.getVal_num_15());
    dataset.fieldValue("val_num_16", valorCompoPresu.getVal_num_16());
    dataset.fieldValue("val_num_17", valorCompoPresu.getVal_num_17());
    dataset.fieldValue("val_num_18", valorCompoPresu.getVal_num_18());
    dataset.fieldValue("val_num_19", valorCompoPresu.getVal_num_19());
    dataset.fieldValue("val_num_20", valorCompoPresu.getVal_num_20());
    dataset.fieldValue("val_num_21", valorCompoPresu.getVal_num_21());
    dataset.fieldValue("val_num_22", valorCompoPresu.getVal_num_22());
    dataset.fieldValue("val_num_23", valorCompoPresu.getVal_num_23());
    dataset.fieldValue("val_num_24", valorCompoPresu.getVal_num_24());
    dataset.fieldValue("val_num_25", valorCompoPresu.getVal_num_25());
    dataset.fieldValue("val_num_26", valorCompoPresu.getVal_num_26());
    dataset.fieldValue("val_num_27", valorCompoPresu.getVal_num_27());
    dataset.fieldValue("val_num_28", valorCompoPresu.getVal_num_28());
    dataset.fieldValue("val_num_29", valorCompoPresu.getVal_num_29());
    dataset.fieldValue("val_num_30", valorCompoPresu.getVal_num_30());
    dataset.fieldValue("val_tex_1", valorCompoPresu.getVal_tex_1());
    dataset.fieldValue("val_tex_2", valorCompoPresu.getVal_tex_2());
    dataset.fieldValue("val_tex_3", valorCompoPresu.getVal_tex_3());
    dataset.fieldValue("val_tex_4", valorCompoPresu.getVal_tex_4());
    dataset.fieldValue("val_tex_5", valorCompoPresu.getVal_tex_5());
    dataset.fieldValue("val_tex_6", valorCompoPresu.getVal_tex_6());
    dataset.fieldValue("val_tex_7", valorCompoPresu.getVal_tex_7());
    dataset.fieldValue("val_tex_8", valorCompoPresu.getVal_tex_8());
    dataset.fieldValue("val_tex_9", valorCompoPresu.getVal_tex_9());
    dataset.fieldValue("val_tex_10", valorCompoPresu.getVal_tex_10());
    dataset.fieldValue("val_tex_11", valorCompoPresu.getVal_tex_11());
    dataset.fieldValue("val_tex_12", valorCompoPresu.getVal_tex_12());
    dataset.fieldValue("val_tex_13", valorCompoPresu.getVal_tex_13());
    dataset.fieldValue("val_tex_14", valorCompoPresu.getVal_tex_14());
    dataset.fieldValue("val_tex_15", valorCompoPresu.getVal_tex_15());
    dataset.fieldValue("val_tex_16", valorCompoPresu.getVal_tex_16());
    dataset.fieldValue("val_tex_17", valorCompoPresu.getVal_tex_17());
    dataset.fieldValue("val_tex_18", valorCompoPresu.getVal_tex_18());
    dataset.fieldValue("val_tex_19", valorCompoPresu.getVal_tex_19());
    dataset.fieldValue("val_tex_20", valorCompoPresu.getVal_tex_20());
    dataset.fieldValue("val_fec_1", valorCompoPresu.getVal_fec_1());
    dataset.fieldValue("val_fec_2", valorCompoPresu.getVal_fec_2());
    dataset.fieldValue("val_fec_3", valorCompoPresu.getVal_fec_3());
    dataset.fieldValue("val_fec_4", valorCompoPresu.getVal_fec_4());
    dataset.fieldValue("val_fec_5", valorCompoPresu.getVal_fec_5());
    dataset.fieldValue("val_fec_6", valorCompoPresu.getVal_fec_6());
    dataset.fieldValue("val_fec_7", valorCompoPresu.getVal_fec_7());
    dataset.fieldValue("val_fec_8", valorCompoPresu.getVal_fec_8());
    dataset.fieldValue("val_fec_9", valorCompoPresu.getVal_fec_9());
    dataset.fieldValue("val_fec_10", valorCompoPresu.getVal_fec_10());
    dataset.fieldValue("val_fec_11", valorCompoPresu.getVal_fec_11());
    dataset.fieldValue("val_fec_12", valorCompoPresu.getVal_fec_12());
    dataset.fieldValue("val_fec_13", valorCompoPresu.getVal_fec_13());
    dataset.fieldValue("val_fec_14", valorCompoPresu.getVal_fec_14());
    dataset.fieldValue("val_fec_15", valorCompoPresu.getVal_fec_15());
    dataset.fieldValue("val_fec_16", valorCompoPresu.getVal_fec_16());
    dataset.fieldValue("val_fec_17", valorCompoPresu.getVal_fec_17());
    dataset.fieldValue("val_fec_18", valorCompoPresu.getVal_fec_18());
    dataset.fieldValue("val_fec_19", valorCompoPresu.getVal_fec_19());
    dataset.fieldValue("val_fec_20", valorCompoPresu.getVal_fec_20());
  }
}
