package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerValorRealRepositorio extends Operation { 

  public TraerValorRealRepositorio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ValorRealRepositorio valorrealrepositorio = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       valorrealrepositorio = ValorRealRepositorio.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       valorrealrepositorio = ValorRealRepositorio.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetValorRealRepositorio = getDataSetValorRealRepositorio();
    if (valorrealrepositorio != null) { 
        cargarRegistroValorRealRepositorio(datasetValorRealRepositorio, 
                         valorrealrepositorio.getOIDInteger(),
                         valorrealrepositorio.getRepositorio_real(),
                         valorrealrepositorio.getValor_real_1(),
                         valorrealrepositorio.getValor_real_2(),
                         valorrealrepositorio.getValor_real_3(),
                         valorrealrepositorio.getValor_real_4(),
                         valorrealrepositorio.getValor_real_5(),
                         valorrealrepositorio.getValor_real_6(),
                         valorrealrepositorio.getValor_real_7(),
                         valorrealrepositorio.getValor_real_8(),
                         valorrealrepositorio.getValor_real_9(),
                         valorrealrepositorio.getValor_real_10(),
                         valorrealrepositorio.getValor_real_11(),
                         valorrealrepositorio.getValor_real_12(),
                         valorrealrepositorio.getValor_real_13(),
                         valorrealrepositorio.getValor_real_14(),
                         valorrealrepositorio.getValor_real_15(),
                         valorrealrepositorio.getValor_real_16(),
                         valorrealrepositorio.getValor_real_17(),
                         valorrealrepositorio.getValor_real_18(),
                         valorrealrepositorio.getValor_real_19(),
                         valorrealrepositorio.getValor_real_20(),
                         valorrealrepositorio.getValor_real_21(),
                         valorrealrepositorio.getValor_real_22(),
                         valorrealrepositorio.getValor_real_23(),
                         valorrealrepositorio.getValor_real_24(),
                         valorrealrepositorio.getValor_real_25(),
                         valorrealrepositorio.getValor_real_26(),
                         valorrealrepositorio.getValor_real_27(),
                         valorrealrepositorio.getValor_real_28(),
                         valorrealrepositorio.getValor_real_29(),
                         valorrealrepositorio.getValor_real_30(),
                         valorrealrepositorio.getValor_real_31(),
                         valorrealrepositorio.getValor_real_32(),
                         valorrealrepositorio.getValor_real_33(),
                         valorrealrepositorio.getValor_real_34(),
                         valorrealrepositorio.getValor_real_35(),
                         valorrealrepositorio.getValor_real_36(),
                         valorrealrepositorio.getValor_real_37(),
                         valorrealrepositorio.getValor_real_38(),
                         valorrealrepositorio.getValor_real_39(),
                         valorrealrepositorio.getValor_real_40(),
                         valorrealrepositorio.getValor_real_41(),
                         valorrealrepositorio.getValor_real_42(),
                         valorrealrepositorio.getValor_real_43(),
                         valorrealrepositorio.getValor_real_44(),
                         valorrealrepositorio.getValor_real_45(),
                         valorrealrepositorio.getValor_real_46(),
                         valorrealrepositorio.getValor_real_47(),
                         valorrealrepositorio.getValor_real_48(),
                         valorrealrepositorio.getValor_real_49(),
                         valorrealrepositorio.getValor_real_50(),
                         valorrealrepositorio.getValor_real_51(),
                         valorrealrepositorio.getValor_real_52(),
                         valorrealrepositorio.getValor_real_53(),
                         valorrealrepositorio.getValor_real_54(),
                         valorrealrepositorio.getValor_real_55(),
                         valorrealrepositorio.getValor_real_56(),
                         valorrealrepositorio.getValor_real_57(),
                         valorrealrepositorio.getValor_real_58(),
                         valorrealrepositorio.getValor_real_59(),
                         valorrealrepositorio.getValor_real_60(),
                         valorrealrepositorio.getValor_real_61(),
                         valorrealrepositorio.getValor_real_62(),
                         valorrealrepositorio.getValor_real_63(),
                         valorrealrepositorio.getValor_real_64(),
                         valorrealrepositorio.getValor_real_65(),
                         valorrealrepositorio.getValor_real_66(),
                         valorrealrepositorio.getValor_real_67(),
                         valorrealrepositorio.getValor_real_68(),
                         valorrealrepositorio.getValor_real_69(),
                         valorrealrepositorio.getValor_real_70(),
                         valorrealrepositorio.getValor_real_71(),
                         valorrealrepositorio.getValor_real_72(),
                         valorrealrepositorio.getValor_real_73(),
                         valorrealrepositorio.getValor_real_74(),
                         valorrealrepositorio.getValor_real_75(),
                         valorrealrepositorio.getValor_real_76(),
                         valorrealrepositorio.getValor_real_77(),
                         valorrealrepositorio.getValor_real_78(),
                         valorrealrepositorio.getValor_real_79(),
                         valorrealrepositorio.getValor_real_80(),
                         valorrealrepositorio.getValor_real_81(),
                         valorrealrepositorio.getValor_real_82(),
                         valorrealrepositorio.getValor_real_83(),
                         valorrealrepositorio.getValor_real_84(),
                         valorrealrepositorio.getValor_real_85(),
                         valorrealrepositorio.getValor_real_86(),
                         valorrealrepositorio.getValor_real_87(),
                         valorrealrepositorio.getValor_real_88(),
                         valorrealrepositorio.getValor_real_89(),
                         valorrealrepositorio.getValor_real_90(),
                         valorrealrepositorio.getValor_real_91(),
                         valorrealrepositorio.getValor_real_92(),
                         valorrealrepositorio.getValor_real_93(),
                         valorrealrepositorio.getValor_real_94(),
                         valorrealrepositorio.getValor_real_95(),
                         valorrealrepositorio.getValor_real_96(),
                         valorrealrepositorio.getValor_real_97(),
                         valorrealrepositorio.getValor_real_98(),
                         valorrealrepositorio.getValor_real_99(),
                         valorrealrepositorio.getValor_real_100(),
                         valorrealrepositorio.getVal_metrica_1(),
                         valorrealrepositorio.getVal_metrica_2(),
                         valorrealrepositorio.getVal_metrica_3(),
                         valorrealrepositorio.getVal_metrica_4(),
                         valorrealrepositorio.getVal_metrica_5(),
                         valorrealrepositorio.getVal_metrica_6(),
                         valorrealrepositorio.getVal_metrica_7(),
                         valorrealrepositorio.getVal_metrica_8(),
                         valorrealrepositorio.getVal_metrica_9(),
                         valorrealrepositorio.getVal_metrica_10(),
                         valorrealrepositorio.getVal_metrica_11(),
                         valorrealrepositorio.getVal_metrica_12(),
                         valorrealrepositorio.getVal_metrica_13(),
                         valorrealrepositorio.getVal_metrica_14(),
                         valorrealrepositorio.getVal_metrica_15(),
                         valorrealrepositorio.getVal_metrica_16(),
                         valorrealrepositorio.getVal_metrica_17(),
                         valorrealrepositorio.getVal_metrica_18(),
                         valorrealrepositorio.getVal_metrica_19(),
                         valorrealrepositorio.getVal_metrica_20(),
                         valorrealrepositorio.getVal_metrica_21(),
                         valorrealrepositorio.getVal_metrica_22(),
                         valorrealrepositorio.getVal_metrica_23(),
                         valorrealrepositorio.getVal_metrica_24(),
                         valorrealrepositorio.getVal_metrica_25(),
                         valorrealrepositorio.getVal_metrica_26(),
                         valorrealrepositorio.getVal_metrica_27(),
                         valorrealrepositorio.getVal_metrica_28(),
                         valorrealrepositorio.getVal_metrica_29(),
                         valorrealrepositorio.getVal_metrica_30(),
                         valorrealrepositorio.getVal_metrica_31(),
                         valorrealrepositorio.getVal_metrica_32(),
                         valorrealrepositorio.getVal_metrica_33(),
                         valorrealrepositorio.getVal_metrica_34(),
                         valorrealrepositorio.getVal_metrica_35(),
                         valorrealrepositorio.getVal_metrica_36(),
                         valorrealrepositorio.getVal_metrica_37(),
                         valorrealrepositorio.getVal_metrica_38(),
                         valorrealrepositorio.getVal_metrica_39(),
                         valorrealrepositorio.getVal_metrica_40(),
                         valorrealrepositorio.getVal_metrica_41(),
                         valorrealrepositorio.getVal_metrica_42(),
                         valorrealrepositorio.getVal_metrica_43(),
                         valorrealrepositorio.getVal_metrica_44(),
                         valorrealrepositorio.getVal_metrica_45(),
                         valorrealrepositorio.getVal_metrica_46(),
                         valorrealrepositorio.getVal_metrica_47(),
                         valorrealrepositorio.getVal_metrica_48(),
                         valorrealrepositorio.getVal_metrica_49(),
                         valorrealrepositorio.getVal_metrica_50(),
                         valorrealrepositorio.getFec_tipo_peri_1(),
                         valorrealrepositorio.getFec_tipo_peri_2(),
                         valorrealrepositorio.getFec_tipo_peri_3(),
                         valorrealrepositorio.getFec_tipo_peri_4(),
                         valorrealrepositorio.getFec_tipo_peri_5(),
                         valorrealrepositorio.getFec_tipo_peri_6(),
                         valorrealrepositorio.getFec_tipo_peri_7(),
                         valorrealrepositorio.getFec_tipo_peri_8(),
                         valorrealrepositorio.getFec_tipo_peri_9(),
                         valorrealrepositorio.getFec_tipo_peri_10(),
                         valorrealrepositorio.getFec_tipo_peri_11(),
                         valorrealrepositorio.getFec_tipo_peri_12(),
                         valorrealrepositorio.getFec_tipo_peri_13(),
                         valorrealrepositorio.getFec_tipo_peri_14(),
                         valorrealrepositorio.getFec_tipo_peri_15(),
                         valorrealrepositorio.getFec_tipo_peri_16(),
                         valorrealrepositorio.getFec_tipo_peri_17(),
                         valorrealrepositorio.getFec_tipo_peri_18(),
                         valorrealrepositorio.getFec_tipo_peri_19(),
                         valorrealrepositorio.getFec_tipo_peri_20(),
                         valorrealrepositorio.isActivo());
    }
    writeCliente(datasetValorRealRepositorio);
  }

  private IDataSet getDataSetValorRealRepositorio() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValorRealRepositorio");
    dataset.fieldDef(new Field("oid_val_repo_real", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_repo_real", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_1", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_2", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_3", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_4", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_5", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_6", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_7", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_8", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_9", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_10", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_11", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_12", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_13", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_14", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_15", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_16", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_17", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_18", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_19", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_20", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_21", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_22", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_23", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_24", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_25", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_26", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_27", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_28", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_29", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_30", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_31", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_32", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_33", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_34", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_35", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_36", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_37", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_38", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_39", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_40", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_41", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_42", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_43", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_44", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_45", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_46", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_47", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_48", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_49", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_50", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_51", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_52", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_53", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_54", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_55", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_56", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_57", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_58", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_59", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_60", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_61", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_62", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_63", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_64", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_65", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_66", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_67", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_68", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_69", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_70", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_71", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_72", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_73", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_74", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_75", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_76", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_77", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_78", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_79", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_80", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_81", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_82", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_83", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_84", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_85", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_86", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_87", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_88", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_89", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_90", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_91", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_92", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_93", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_94", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_95", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_96", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_97", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_98", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_99", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_val_real_100", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("val_metrica_1", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_2", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_3", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_4", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_5", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_6", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_7", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_8", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_9", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_10", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_11", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_12", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_13", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_14", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_15", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_16", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_17", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_18", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_19", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_20", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_21", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_22", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_23", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_24", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_25", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_26", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_27", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_28", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_29", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_30", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_31", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_32", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_33", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_34", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_35", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_36", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_37", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_38", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_39", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_40", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_41", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_42", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_43", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_44", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_45", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_46", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_47", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_48", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_49", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("val_metrica_50", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_1", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_2", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_3", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_4", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_5", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_6", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_7", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_8", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_9", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_10", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_11", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_12", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_13", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_14", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_15", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_16", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_17", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_18", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_19", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_tipo_peri_20", Field.DATE, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroValorRealRepositorio(IDataSet dataset, 
                         Integer oid_val_repo_real,
                         RepositorioReal oid_repo_real,
                         ValorCompoReal oid_val_real_1,
                         ValorCompoReal oid_val_real_2,
                         ValorCompoReal oid_val_real_3,
                         ValorCompoReal oid_val_real_4,
                         ValorCompoReal oid_val_real_5,
                         ValorCompoReal oid_val_real_6,
                         ValorCompoReal oid_val_real_7,
                         ValorCompoReal oid_val_real_8,
                         ValorCompoReal oid_val_real_9,
                         ValorCompoReal oid_val_real_10,
                         ValorCompoReal oid_val_real_11,
                         ValorCompoReal oid_val_real_12,
                         ValorCompoReal oid_val_real_13,
                         ValorCompoReal oid_val_real_14,
                         ValorCompoReal oid_val_real_15,
                         ValorCompoReal oid_val_real_16,
                         ValorCompoReal oid_val_real_17,
                         ValorCompoReal oid_val_real_18,
                         ValorCompoReal oid_val_real_19,
                         ValorCompoReal oid_val_real_20,
                         ValorCompoReal oid_val_real_21,
                         ValorCompoReal oid_val_real_22,
                         ValorCompoReal oid_val_real_23,
                         ValorCompoReal oid_val_real_24,
                         ValorCompoReal oid_val_real_25,
                         ValorCompoReal oid_val_real_26,
                         ValorCompoReal oid_val_real_27,
                         ValorCompoReal oid_val_real_28,
                         ValorCompoReal oid_val_real_29,
                         ValorCompoReal oid_val_real_30,
                         ValorCompoReal oid_val_real_31,
                         ValorCompoReal oid_val_real_32,
                         ValorCompoReal oid_val_real_33,
                         ValorCompoReal oid_val_real_34,
                         ValorCompoReal oid_val_real_35,
                         ValorCompoReal oid_val_real_36,
                         ValorCompoReal oid_val_real_37,
                         ValorCompoReal oid_val_real_38,
                         ValorCompoReal oid_val_real_39,
                         ValorCompoReal oid_val_real_40,
                         ValorCompoReal oid_val_real_41,
                         ValorCompoReal oid_val_real_42,
                         ValorCompoReal oid_val_real_43,
                         ValorCompoReal oid_val_real_44,
                         ValorCompoReal oid_val_real_45,
                         ValorCompoReal oid_val_real_46,
                         ValorCompoReal oid_val_real_47,
                         ValorCompoReal oid_val_real_48,
                         ValorCompoReal oid_val_real_49,
                         ValorCompoReal oid_val_real_50,
                         ValorCompoReal oid_val_real_51,
                         ValorCompoReal oid_val_real_52,
                         ValorCompoReal oid_val_real_53,
                         ValorCompoReal oid_val_real_54,
                         ValorCompoReal oid_val_real_55,
                         ValorCompoReal oid_val_real_56,
                         ValorCompoReal oid_val_real_57,
                         ValorCompoReal oid_val_real_58,
                         ValorCompoReal oid_val_real_59,
                         ValorCompoReal oid_val_real_60,
                         ValorCompoReal oid_val_real_61,
                         ValorCompoReal oid_val_real_62,
                         ValorCompoReal oid_val_real_63,
                         ValorCompoReal oid_val_real_64,
                         ValorCompoReal oid_val_real_65,
                         ValorCompoReal oid_val_real_66,
                         ValorCompoReal oid_val_real_67,
                         ValorCompoReal oid_val_real_68,
                         ValorCompoReal oid_val_real_69,
                         ValorCompoReal oid_val_real_70,
                         ValorCompoReal oid_val_real_71,
                         ValorCompoReal oid_val_real_72,
                         ValorCompoReal oid_val_real_73,
                         ValorCompoReal oid_val_real_74,
                         ValorCompoReal oid_val_real_75,
                         ValorCompoReal oid_val_real_76,
                         ValorCompoReal oid_val_real_77,
                         ValorCompoReal oid_val_real_78,
                         ValorCompoReal oid_val_real_79,
                         ValorCompoReal oid_val_real_80,
                         ValorCompoReal oid_val_real_81,
                         ValorCompoReal oid_val_real_82,
                         ValorCompoReal oid_val_real_83,
                         ValorCompoReal oid_val_real_84,
                         ValorCompoReal oid_val_real_85,
                         ValorCompoReal oid_val_real_86,
                         ValorCompoReal oid_val_real_87,
                         ValorCompoReal oid_val_real_88,
                         ValorCompoReal oid_val_real_89,
                         ValorCompoReal oid_val_real_90,
                         ValorCompoReal oid_val_real_91,
                         ValorCompoReal oid_val_real_92,
                         ValorCompoReal oid_val_real_93,
                         ValorCompoReal oid_val_real_94,
                         ValorCompoReal oid_val_real_95,
                         ValorCompoReal oid_val_real_96,
                         ValorCompoReal oid_val_real_97,
                         ValorCompoReal oid_val_real_98,
                         ValorCompoReal oid_val_real_99,
                         ValorCompoReal oid_val_real_100,
                         Double val_metrica_1,
                         Double val_metrica_2,
                         Double val_metrica_3,
                         Double val_metrica_4,
                         Double val_metrica_5,
                         Double val_metrica_6,
                         Double val_metrica_7,
                         Double val_metrica_8,
                         Double val_metrica_9,
                         Double val_metrica_10,
                         Double val_metrica_11,
                         Double val_metrica_12,
                         Double val_metrica_13,
                         Double val_metrica_14,
                         Double val_metrica_15,
                         Double val_metrica_16,
                         Double val_metrica_17,
                         Double val_metrica_18,
                         Double val_metrica_19,
                         Double val_metrica_20,
                         Double val_metrica_21,
                         Double val_metrica_22,
                         Double val_metrica_23,
                         Double val_metrica_24,
                         Double val_metrica_25,
                         Double val_metrica_26,
                         Double val_metrica_27,
                         Double val_metrica_28,
                         Double val_metrica_29,
                         Double val_metrica_30,
                         Double val_metrica_31,
                         Double val_metrica_32,
                         Double val_metrica_33,
                         Double val_metrica_34,
                         Double val_metrica_35,
                         Double val_metrica_36,
                         Double val_metrica_37,
                         Double val_metrica_38,
                         Double val_metrica_39,
                         Double val_metrica_40,
                         Double val_metrica_41,
                         Double val_metrica_42,
                         Double val_metrica_43,
                         Double val_metrica_44,
                         Double val_metrica_45,
                         Double val_metrica_46,
                         Double val_metrica_47,
                         Double val_metrica_48,
                         Double val_metrica_49,
                         Double val_metrica_50,
                         java.util.Date fec_tipo_peri_1,
                         java.util.Date fec_tipo_peri_2,
                         java.util.Date fec_tipo_peri_3,
                         java.util.Date fec_tipo_peri_4,
                         java.util.Date fec_tipo_peri_5,
                         java.util.Date fec_tipo_peri_6,
                         java.util.Date fec_tipo_peri_7,
                         java.util.Date fec_tipo_peri_8,
                         java.util.Date fec_tipo_peri_9,
                         java.util.Date fec_tipo_peri_10,
                         java.util.Date fec_tipo_peri_11,
                         java.util.Date fec_tipo_peri_12,
                         java.util.Date fec_tipo_peri_13,
                         java.util.Date fec_tipo_peri_14,
                         java.util.Date fec_tipo_peri_15,
                         java.util.Date fec_tipo_peri_16,
                         java.util.Date fec_tipo_peri_17,
                         java.util.Date fec_tipo_peri_18,
                         java.util.Date fec_tipo_peri_19,
                         java.util.Date fec_tipo_peri_20,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_val_repo_real", oid_val_repo_real);
    dataset.fieldValue("oid_repo_real", oid_repo_real);
    dataset.fieldValue("oid_val_real_1", oid_val_real_1);
    dataset.fieldValue("oid_val_real_2", oid_val_real_2);
    dataset.fieldValue("oid_val_real_3", oid_val_real_3);
    dataset.fieldValue("oid_val_real_4", oid_val_real_4);
    dataset.fieldValue("oid_val_real_5", oid_val_real_5);
    dataset.fieldValue("oid_val_real_6", oid_val_real_6);
    dataset.fieldValue("oid_val_real_7", oid_val_real_7);
    dataset.fieldValue("oid_val_real_8", oid_val_real_8);
    dataset.fieldValue("oid_val_real_9", oid_val_real_9);
    dataset.fieldValue("oid_val_real_10", oid_val_real_10);
    dataset.fieldValue("oid_val_real_11", oid_val_real_11);
    dataset.fieldValue("oid_val_real_12", oid_val_real_12);
    dataset.fieldValue("oid_val_real_13", oid_val_real_13);
    dataset.fieldValue("oid_val_real_14", oid_val_real_14);
    dataset.fieldValue("oid_val_real_15", oid_val_real_15);
    dataset.fieldValue("oid_val_real_16", oid_val_real_16);
    dataset.fieldValue("oid_val_real_17", oid_val_real_17);
    dataset.fieldValue("oid_val_real_18", oid_val_real_18);
    dataset.fieldValue("oid_val_real_19", oid_val_real_19);
    dataset.fieldValue("oid_val_real_20", oid_val_real_20);
    dataset.fieldValue("oid_val_real_21", oid_val_real_21);
    dataset.fieldValue("oid_val_real_22", oid_val_real_22);
    dataset.fieldValue("oid_val_real_23", oid_val_real_23);
    dataset.fieldValue("oid_val_real_24", oid_val_real_24);
    dataset.fieldValue("oid_val_real_25", oid_val_real_25);
    dataset.fieldValue("oid_val_real_26", oid_val_real_26);
    dataset.fieldValue("oid_val_real_27", oid_val_real_27);
    dataset.fieldValue("oid_val_real_28", oid_val_real_28);
    dataset.fieldValue("oid_val_real_29", oid_val_real_29);
    dataset.fieldValue("oid_val_real_30", oid_val_real_30);
    dataset.fieldValue("oid_val_real_31", oid_val_real_31);
    dataset.fieldValue("oid_val_real_32", oid_val_real_32);
    dataset.fieldValue("oid_val_real_33", oid_val_real_33);
    dataset.fieldValue("oid_val_real_34", oid_val_real_34);
    dataset.fieldValue("oid_val_real_35", oid_val_real_35);
    dataset.fieldValue("oid_val_real_36", oid_val_real_36);
    dataset.fieldValue("oid_val_real_37", oid_val_real_37);
    dataset.fieldValue("oid_val_real_38", oid_val_real_38);
    dataset.fieldValue("oid_val_real_39", oid_val_real_39);
    dataset.fieldValue("oid_val_real_40", oid_val_real_40);
    dataset.fieldValue("oid_val_real_41", oid_val_real_41);
    dataset.fieldValue("oid_val_real_42", oid_val_real_42);
    dataset.fieldValue("oid_val_real_43", oid_val_real_43);
    dataset.fieldValue("oid_val_real_44", oid_val_real_44);
    dataset.fieldValue("oid_val_real_45", oid_val_real_45);
    dataset.fieldValue("oid_val_real_46", oid_val_real_46);
    dataset.fieldValue("oid_val_real_47", oid_val_real_47);
    dataset.fieldValue("oid_val_real_48", oid_val_real_48);
    dataset.fieldValue("oid_val_real_49", oid_val_real_49);
    dataset.fieldValue("oid_val_real_50", oid_val_real_50);
    dataset.fieldValue("oid_val_real_51", oid_val_real_51);
    dataset.fieldValue("oid_val_real_52", oid_val_real_52);
    dataset.fieldValue("oid_val_real_53", oid_val_real_53);
    dataset.fieldValue("oid_val_real_54", oid_val_real_54);
    dataset.fieldValue("oid_val_real_55", oid_val_real_55);
    dataset.fieldValue("oid_val_real_56", oid_val_real_56);
    dataset.fieldValue("oid_val_real_57", oid_val_real_57);
    dataset.fieldValue("oid_val_real_58", oid_val_real_58);
    dataset.fieldValue("oid_val_real_59", oid_val_real_59);
    dataset.fieldValue("oid_val_real_60", oid_val_real_60);
    dataset.fieldValue("oid_val_real_61", oid_val_real_61);
    dataset.fieldValue("oid_val_real_62", oid_val_real_62);
    dataset.fieldValue("oid_val_real_63", oid_val_real_63);
    dataset.fieldValue("oid_val_real_64", oid_val_real_64);
    dataset.fieldValue("oid_val_real_65", oid_val_real_65);
    dataset.fieldValue("oid_val_real_66", oid_val_real_66);
    dataset.fieldValue("oid_val_real_67", oid_val_real_67);
    dataset.fieldValue("oid_val_real_68", oid_val_real_68);
    dataset.fieldValue("oid_val_real_69", oid_val_real_69);
    dataset.fieldValue("oid_val_real_70", oid_val_real_70);
    dataset.fieldValue("oid_val_real_71", oid_val_real_71);
    dataset.fieldValue("oid_val_real_72", oid_val_real_72);
    dataset.fieldValue("oid_val_real_73", oid_val_real_73);
    dataset.fieldValue("oid_val_real_74", oid_val_real_74);
    dataset.fieldValue("oid_val_real_75", oid_val_real_75);
    dataset.fieldValue("oid_val_real_76", oid_val_real_76);
    dataset.fieldValue("oid_val_real_77", oid_val_real_77);
    dataset.fieldValue("oid_val_real_78", oid_val_real_78);
    dataset.fieldValue("oid_val_real_79", oid_val_real_79);
    dataset.fieldValue("oid_val_real_80", oid_val_real_80);
    dataset.fieldValue("oid_val_real_81", oid_val_real_81);
    dataset.fieldValue("oid_val_real_82", oid_val_real_82);
    dataset.fieldValue("oid_val_real_83", oid_val_real_83);
    dataset.fieldValue("oid_val_real_84", oid_val_real_84);
    dataset.fieldValue("oid_val_real_85", oid_val_real_85);
    dataset.fieldValue("oid_val_real_86", oid_val_real_86);
    dataset.fieldValue("oid_val_real_87", oid_val_real_87);
    dataset.fieldValue("oid_val_real_88", oid_val_real_88);
    dataset.fieldValue("oid_val_real_89", oid_val_real_89);
    dataset.fieldValue("oid_val_real_90", oid_val_real_90);
    dataset.fieldValue("oid_val_real_91", oid_val_real_91);
    dataset.fieldValue("oid_val_real_92", oid_val_real_92);
    dataset.fieldValue("oid_val_real_93", oid_val_real_93);
    dataset.fieldValue("oid_val_real_94", oid_val_real_94);
    dataset.fieldValue("oid_val_real_95", oid_val_real_95);
    dataset.fieldValue("oid_val_real_96", oid_val_real_96);
    dataset.fieldValue("oid_val_real_97", oid_val_real_97);
    dataset.fieldValue("oid_val_real_98", oid_val_real_98);
    dataset.fieldValue("oid_val_real_99", oid_val_real_99);
    dataset.fieldValue("oid_val_real_100", oid_val_real_100);
    dataset.fieldValue("val_metrica_1", val_metrica_1);
    dataset.fieldValue("val_metrica_2", val_metrica_2);
    dataset.fieldValue("val_metrica_3", val_metrica_3);
    dataset.fieldValue("val_metrica_4", val_metrica_4);
    dataset.fieldValue("val_metrica_5", val_metrica_5);
    dataset.fieldValue("val_metrica_6", val_metrica_6);
    dataset.fieldValue("val_metrica_7", val_metrica_7);
    dataset.fieldValue("val_metrica_8", val_metrica_8);
    dataset.fieldValue("val_metrica_9", val_metrica_9);
    dataset.fieldValue("val_metrica_10", val_metrica_10);
    dataset.fieldValue("val_metrica_11", val_metrica_11);
    dataset.fieldValue("val_metrica_12", val_metrica_12);
    dataset.fieldValue("val_metrica_13", val_metrica_13);
    dataset.fieldValue("val_metrica_14", val_metrica_14);
    dataset.fieldValue("val_metrica_15", val_metrica_15);
    dataset.fieldValue("val_metrica_16", val_metrica_16);
    dataset.fieldValue("val_metrica_17", val_metrica_17);
    dataset.fieldValue("val_metrica_18", val_metrica_18);
    dataset.fieldValue("val_metrica_19", val_metrica_19);
    dataset.fieldValue("val_metrica_20", val_metrica_20);
    dataset.fieldValue("val_metrica_21", val_metrica_21);
    dataset.fieldValue("val_metrica_22", val_metrica_22);
    dataset.fieldValue("val_metrica_23", val_metrica_23);
    dataset.fieldValue("val_metrica_24", val_metrica_24);
    dataset.fieldValue("val_metrica_25", val_metrica_25);
    dataset.fieldValue("val_metrica_26", val_metrica_26);
    dataset.fieldValue("val_metrica_27", val_metrica_27);
    dataset.fieldValue("val_metrica_28", val_metrica_28);
    dataset.fieldValue("val_metrica_29", val_metrica_29);
    dataset.fieldValue("val_metrica_30", val_metrica_30);
    dataset.fieldValue("val_metrica_31", val_metrica_31);
    dataset.fieldValue("val_metrica_32", val_metrica_32);
    dataset.fieldValue("val_metrica_33", val_metrica_33);
    dataset.fieldValue("val_metrica_34", val_metrica_34);
    dataset.fieldValue("val_metrica_35", val_metrica_35);
    dataset.fieldValue("val_metrica_36", val_metrica_36);
    dataset.fieldValue("val_metrica_37", val_metrica_37);
    dataset.fieldValue("val_metrica_38", val_metrica_38);
    dataset.fieldValue("val_metrica_39", val_metrica_39);
    dataset.fieldValue("val_metrica_40", val_metrica_40);
    dataset.fieldValue("val_metrica_41", val_metrica_41);
    dataset.fieldValue("val_metrica_42", val_metrica_42);
    dataset.fieldValue("val_metrica_43", val_metrica_43);
    dataset.fieldValue("val_metrica_44", val_metrica_44);
    dataset.fieldValue("val_metrica_45", val_metrica_45);
    dataset.fieldValue("val_metrica_46", val_metrica_46);
    dataset.fieldValue("val_metrica_47", val_metrica_47);
    dataset.fieldValue("val_metrica_48", val_metrica_48);
    dataset.fieldValue("val_metrica_49", val_metrica_49);
    dataset.fieldValue("val_metrica_50", val_metrica_50);
    dataset.fieldValue("fec_tipo_peri_1", fec_tipo_peri_1);
    dataset.fieldValue("fec_tipo_peri_2", fec_tipo_peri_2);
    dataset.fieldValue("fec_tipo_peri_3", fec_tipo_peri_3);
    dataset.fieldValue("fec_tipo_peri_4", fec_tipo_peri_4);
    dataset.fieldValue("fec_tipo_peri_5", fec_tipo_peri_5);
    dataset.fieldValue("fec_tipo_peri_6", fec_tipo_peri_6);
    dataset.fieldValue("fec_tipo_peri_7", fec_tipo_peri_7);
    dataset.fieldValue("fec_tipo_peri_8", fec_tipo_peri_8);
    dataset.fieldValue("fec_tipo_peri_9", fec_tipo_peri_9);
    dataset.fieldValue("fec_tipo_peri_10", fec_tipo_peri_10);
    dataset.fieldValue("fec_tipo_peri_11", fec_tipo_peri_11);
    dataset.fieldValue("fec_tipo_peri_12", fec_tipo_peri_12);
    dataset.fieldValue("fec_tipo_peri_13", fec_tipo_peri_13);
    dataset.fieldValue("fec_tipo_peri_14", fec_tipo_peri_14);
    dataset.fieldValue("fec_tipo_peri_15", fec_tipo_peri_15);
    dataset.fieldValue("fec_tipo_peri_16", fec_tipo_peri_16);
    dataset.fieldValue("fec_tipo_peri_17", fec_tipo_peri_17);
    dataset.fieldValue("fec_tipo_peri_18", fec_tipo_peri_18);
    dataset.fieldValue("fec_tipo_peri_19", fec_tipo_peri_19);
    dataset.fieldValue("fec_tipo_peri_20", fec_tipo_peri_20);
    dataset.fieldValue("activo", activo);
  }
}
