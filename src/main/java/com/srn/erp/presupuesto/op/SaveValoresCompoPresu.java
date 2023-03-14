package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveValoresCompoPresu extends Operation { 

  public SaveValoresCompoPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TValoresCompoPresu"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ValorCompoPresu valorcompopresu = ValorCompoPresu.findByOid(dataset.getInteger("oid_val_compo"),getSesion());
        valorcompopresu.setCodigo(dataset.getString("codigo"));
        valorcompopresu.setDescripcion(dataset.getString("descripcion"));
        valorcompopresu.setNro_rel(dataset.getInteger("nro_rel"));
        valorcompopresu.setNro_rel_padre(dataset.getInteger("nro_rel_padre"));
        valorcompopresu.setActivo(dataset.getBoolean("activo"));
        valorcompopresu.setCompoPresupuestario(CompoPresupuestario.findByOidProxy(dataset.getInteger("oid_compo_presu"),this.getSesion()));
        
        if (dataset.containstAttribute("oid_val_com_1"))
        		valorcompopresu.setVal_com_1(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_1"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_2"))
        		valorcompopresu.setVal_com_2(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_2"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_3"))
        		valorcompopresu.setVal_com_3(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_3"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_4"))
        		valorcompopresu.setVal_com_4(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_4"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_5"))
        		valorcompopresu.setVal_com_5(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_5"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_6"))
        		valorcompopresu.setVal_com_6(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_6"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_7"))
        		valorcompopresu.setVal_com_7(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_7"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_8"))
        		valorcompopresu.setVal_com_8(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_8"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_9"))
        		valorcompopresu.setVal_com_9(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_9"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_10"))
        		valorcompopresu.setVal_com_10(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_10"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_11"))
        		valorcompopresu.setVal_com_11(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_11"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_12"))
        		valorcompopresu.setVal_com_12(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_12"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_13"))
        		valorcompopresu.setVal_com_13(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_13"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_14"))
        		valorcompopresu.setVal_com_14(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_14"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_15"))
        		valorcompopresu.setVal_com_15(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_15"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_16"))
        		valorcompopresu.setVal_com_16(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_16"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_17"))
        		valorcompopresu.setVal_com_17(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_17"),this.getSesion()));;
        if (dataset.containstAttribute("oid_val_com_18"))		
        		valorcompopresu.setVal_com_18(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_18"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_19"))
        		valorcompopresu.setVal_com_19(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_19"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_20"))
        		valorcompopresu.setVal_com_20(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_20"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_21"))
        		valorcompopresu.setVal_com_21(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_21"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_22"))
        		valorcompopresu.setVal_com_22(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_22"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_23"))
        		valorcompopresu.setVal_com_23(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_23"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_24"))
        		valorcompopresu.setVal_com_24(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_24"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_25"))
        		valorcompopresu.setVal_com_25(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_25"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_26"))
        		valorcompopresu.setVal_com_26(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_26"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_27"))
        		valorcompopresu.setVal_com_27(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_27"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_28"))
        		valorcompopresu.setVal_com_28(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_28"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_29"))
        		valorcompopresu.setVal_com_29(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_29"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_30"))
        		valorcompopresu.setVal_com_30(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_30"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_31"))
        		valorcompopresu.setVal_com_31(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_31"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_32"))
        		valorcompopresu.setVal_com_32(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_32"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_33"))
        		valorcompopresu.setVal_com_33(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_33"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_34"))
        		valorcompopresu.setVal_com_34(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_34"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_35"))
        		valorcompopresu.setVal_com_35(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_35"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_36"))
        		valorcompopresu.setVal_com_36(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_36"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_37"))
        		valorcompopresu.setVal_com_37(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_37"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_38"))
        		valorcompopresu.setVal_com_38(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_38"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_39"))
        		valorcompopresu.setVal_com_39(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_39"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_40"))
        		valorcompopresu.setVal_com_40(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_40"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_41"))
        		valorcompopresu.setVal_com_41(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_41"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_42"))
        		valorcompopresu.setVal_com_42(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_42"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_43"))
        		valorcompopresu.setVal_com_43(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_43"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_44"))
        		valorcompopresu.setVal_com_44(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_44"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_45"))
        		valorcompopresu.setVal_com_45(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_45"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_46"))
        		valorcompopresu.setVal_com_46(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_46"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_47"))
        		valorcompopresu.setVal_com_47(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_47"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_48"))
        		valorcompopresu.setVal_com_48(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_48"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_49"))
        		valorcompopresu.setVal_com_49(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_49"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_50"))
        		valorcompopresu.setVal_com_50(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_50"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_51"))
        		valorcompopresu.setVal_com_51(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_51"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_52"))
        		valorcompopresu.setVal_com_52(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_52"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_53"))
        		valorcompopresu.setVal_com_53(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_53"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_54"))
        		valorcompopresu.setVal_com_54(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_54"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_55"))
        		valorcompopresu.setVal_com_55(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_55"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_56"))
        		valorcompopresu.setVal_com_56(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_56"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_57"))
        		valorcompopresu.setVal_com_57(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_57"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_58"))
        		valorcompopresu.setVal_com_58(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_58"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_59"))
        		valorcompopresu.setVal_com_59(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_59"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_60"))
        		valorcompopresu.setVal_com_60(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_60"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_61"))
        		valorcompopresu.setVal_com_61(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_61"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_62"))
        		valorcompopresu.setVal_com_62(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_62"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_63"))
        		valorcompopresu.setVal_com_63(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_63"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_64"))
        		valorcompopresu.setVal_com_64(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_64"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_65"))
        		valorcompopresu.setVal_com_65(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_65"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_66"))
        		valorcompopresu.setVal_com_66(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_66"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_67"))
        		valorcompopresu.setVal_com_67(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_67"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_68"))
        		valorcompopresu.setVal_com_68(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_68"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_69"))
        		valorcompopresu.setVal_com_69(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_69"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_70"))
        		valorcompopresu.setVal_com_70(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_70"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_71"))
        		valorcompopresu.setVal_com_71(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_71"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_72"))
        		valorcompopresu.setVal_com_72(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_72"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_73"))
        		valorcompopresu.setVal_com_73(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_73"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_74"))
        		valorcompopresu.setVal_com_74(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_74"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_75"))
        		valorcompopresu.setVal_com_75(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_75"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_76"))
        		valorcompopresu.setVal_com_76(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_76"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_77"))
        		valorcompopresu.setVal_com_77(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_77"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_78"))
        		valorcompopresu.setVal_com_78(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_78"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_79"))
        		valorcompopresu.setVal_com_79(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_79"),this.getSesion()));
        if (dataset.containstAttribute("oid_val_com_80"))
        		valorcompopresu.setVal_com_80(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_val_com_80"),this.getSesion()));
        if (dataset.containstAttribute("val_num_1"))
        		valorcompopresu.setVal_num_1(dataset.getDouble("val_num_1"));
        if (dataset.containstAttribute("val_num_2"))
        		valorcompopresu.setVal_num_2(dataset.getDouble("val_num_2"));
        if (dataset.containstAttribute("val_num_3"))
        		valorcompopresu.setVal_num_3(dataset.getDouble("val_num_3"));
        if (dataset.containstAttribute("val_num_4"))
        		valorcompopresu.setVal_num_4(dataset.getDouble("val_num_4"));
        if (dataset.containstAttribute("val_num_5"))
        		valorcompopresu.setVal_num_5(dataset.getDouble("val_num_5"));
        if (dataset.containstAttribute("val_num_6"))
        		valorcompopresu.setVal_num_6(dataset.getDouble("val_num_6"));
        if (dataset.containstAttribute("val_num_7"))
        		valorcompopresu.setVal_num_7(dataset.getDouble("val_num_7"));
        if (dataset.containstAttribute("val_num_8"))
        		valorcompopresu.setVal_num_8(dataset.getDouble("val_num_8"));
        if (dataset.containstAttribute("val_num_9"))
        		valorcompopresu.setVal_num_9(dataset.getDouble("val_num_9"));
        if (dataset.containstAttribute("val_num_10"))
        		valorcompopresu.setVal_num_10(dataset.getDouble("val_num_10"));
        if (dataset.containstAttribute("val_num_11"))
        		valorcompopresu.setVal_num_11(dataset.getDouble("val_num_11"));
        if (dataset.containstAttribute("val_num_12"))
        		valorcompopresu.setVal_num_12(dataset.getDouble("val_num_12"));
        if (dataset.containstAttribute("val_num_13"))
        		valorcompopresu.setVal_num_13(dataset.getDouble("val_num_13"));
        if (dataset.containstAttribute("val_num_14"))
        		valorcompopresu.setVal_num_14(dataset.getDouble("val_num_14"));
        if (dataset.containstAttribute("val_num_15"))
        		valorcompopresu.setVal_num_15(dataset.getDouble("val_num_15"));
        if (dataset.containstAttribute("val_num_16"))
        		valorcompopresu.setVal_num_16(dataset.getDouble("val_num_16"));
        if (dataset.containstAttribute("val_num_17"))
        		valorcompopresu.setVal_num_17(dataset.getDouble("val_num_17"));
        if (dataset.containstAttribute("val_num_18"))
        		valorcompopresu.setVal_num_18(dataset.getDouble("val_num_18"));
        if (dataset.containstAttribute("val_num_19"))
        		valorcompopresu.setVal_num_19(dataset.getDouble("val_num_19"));
        if (dataset.containstAttribute("val_num_20"))
        		valorcompopresu.setVal_num_20(dataset.getDouble("val_num_20"));
        if (dataset.containstAttribute("val_num_21"))
        		valorcompopresu.setVal_num_21(dataset.getDouble("val_num_21"));
        if (dataset.containstAttribute("val_num_22"))
        		valorcompopresu.setVal_num_22(dataset.getDouble("val_num_22"));
        if (dataset.containstAttribute("val_num_23"))
        		valorcompopresu.setVal_num_23(dataset.getDouble("val_num_23"));
        if (dataset.containstAttribute("val_num_24"))
        		valorcompopresu.setVal_num_24(dataset.getDouble("val_num_24"));
        if (dataset.containstAttribute("val_num_25"))
        		valorcompopresu.setVal_num_25(dataset.getDouble("val_num_25"));
        if (dataset.containstAttribute("val_num_26"))
        		valorcompopresu.setVal_num_26(dataset.getDouble("val_num_26"));
        if (dataset.containstAttribute("val_num_27"))
        		valorcompopresu.setVal_num_27(dataset.getDouble("val_num_27"));
        if (dataset.containstAttribute("val_num_28"))
        		valorcompopresu.setVal_num_28(dataset.getDouble("val_num_28"));
        if (dataset.containstAttribute("val_num_29"))
        		valorcompopresu.setVal_num_29(dataset.getDouble("val_num_29"));
        if (dataset.containstAttribute("val_num_30"))
        		valorcompopresu.setVal_num_30(dataset.getDouble("val_num_30"));
        if (dataset.containstAttribute("val_tex_1"))
        		valorcompopresu.setVal_tex_1(dataset.getString("val_tex_1"));
        if (dataset.containstAttribute("val_tex_2"))
        		valorcompopresu.setVal_tex_2(dataset.getString("val_tex_2"));
        if (dataset.containstAttribute("val_tex_3"))
        		valorcompopresu.setVal_tex_3(dataset.getString("val_tex_3"));
        if (dataset.containstAttribute("val_tex_4"))
        		valorcompopresu.setVal_tex_4(dataset.getString("val_tex_4"));
        if (dataset.containstAttribute("val_tex_5"))
        		valorcompopresu.setVal_tex_5(dataset.getString("val_tex_5"));
        if (dataset.containstAttribute("val_tex_6"))
        		valorcompopresu.setVal_tex_6(dataset.getString("val_tex_6"));
        if (dataset.containstAttribute("val_tex_7"))
        		valorcompopresu.setVal_tex_7(dataset.getString("val_tex_7"));
        if (dataset.containstAttribute("val_tex_8"))
        		valorcompopresu.setVal_tex_8(dataset.getString("val_tex_8"));
        if (dataset.containstAttribute("val_tex_9")) 
        		valorcompopresu.setVal_tex_9(dataset.getString("val_tex_9"));
        if (dataset.containstAttribute("val_tex_10"))
        		valorcompopresu.setVal_tex_10(dataset.getString("val_tex_10"));
        if (dataset.containstAttribute("val_tex_11"))
        		valorcompopresu.setVal_tex_11(dataset.getString("val_tex_11"));
        if (dataset.containstAttribute("val_tex_12"))
        		valorcompopresu.setVal_tex_12(dataset.getString("val_tex_12"));
        if (dataset.containstAttribute("val_tex_13"))
        		valorcompopresu.setVal_tex_13(dataset.getString("val_tex_13"));
        if (dataset.containstAttribute("val_tex_14"))
        		valorcompopresu.setVal_tex_14(dataset.getString("val_tex_14"));
        if (dataset.containstAttribute("val_tex_15"))
        		valorcompopresu.setVal_tex_15(dataset.getString("val_tex_15"));
        if (dataset.containstAttribute("val_tex_16"))
        		valorcompopresu.setVal_tex_16(dataset.getString("val_tex_16"));
        if (dataset.containstAttribute("val_tex_17"))
        		valorcompopresu.setVal_tex_17(dataset.getString("val_tex_17"));
        if (dataset.containstAttribute("val_tex_18"))
        		valorcompopresu.setVal_tex_18(dataset.getString("val_tex_18"));
        if (dataset.containstAttribute("val_tex_19"))
        		valorcompopresu.setVal_tex_19(dataset.getString("val_tex_19"));
        if (dataset.containstAttribute("val_tex_20"))
        		valorcompopresu.setVal_tex_20(dataset.getString("val_tex_20"));
        if (dataset.containstAttribute("val_fec_1"))
        		valorcompopresu.setVal_fec_1(dataset.getDate("val_fec_1"));
        if (dataset.containstAttribute("val_fec_2"))
        		valorcompopresu.setVal_fec_2(dataset.getDate("val_fec_2"));
        if (dataset.containstAttribute("val_fec_3"))
        		valorcompopresu.setVal_fec_3(dataset.getDate("val_fec_3"));
        if (dataset.containstAttribute("val_fec_4"))
        		valorcompopresu.setVal_fec_4(dataset.getDate("val_fec_4"));
        if (dataset.containstAttribute("val_fec_5"))
        		valorcompopresu.setVal_fec_5(dataset.getDate("val_fec_5"));
        if (dataset.containstAttribute("val_fec_6"))
        		valorcompopresu.setVal_fec_6(dataset.getDate("val_fec_6"));
        if (dataset.containstAttribute("val_fec_7"))
        		valorcompopresu.setVal_fec_7(dataset.getDate("val_fec_7"));
        if (dataset.containstAttribute("val_fec_8"))
        		valorcompopresu.setVal_fec_8(dataset.getDate("val_fec_8"));
        if (dataset.containstAttribute("val_fec_9"))
        		valorcompopresu.setVal_fec_9(dataset.getDate("val_fec_9"));
        if (dataset.containstAttribute("val_fec_10"))
        		valorcompopresu.setVal_fec_10(dataset.getDate("val_fec_10"));
        if (dataset.containstAttribute("val_fec_11"))
        		valorcompopresu.setVal_fec_11(dataset.getDate("val_fec_11"));
        if (dataset.containstAttribute("val_fec_12"))
        		valorcompopresu.setVal_fec_12(dataset.getDate("val_fec_12"));
        if (dataset.containstAttribute("val_fec_13"))
        		valorcompopresu.setVal_fec_13(dataset.getDate("val_fec_13"));
        if (dataset.containstAttribute("val_fec_14"))
        		valorcompopresu.setVal_fec_14(dataset.getDate("val_fec_14"));
        if (dataset.containstAttribute("val_fec_15"))
        		valorcompopresu.setVal_fec_15(dataset.getDate("val_fec_15"));
        if (dataset.containstAttribute("val_fec_16"))
        		valorcompopresu.setVal_fec_16(dataset.getDate("val_fec_16"));
        if (dataset.containstAttribute("val_fec_17"))
        		valorcompopresu.setVal_fec_17(dataset.getDate("val_fec_17"));
        if (dataset.containstAttribute("val_fec_18"))
        		valorcompopresu.setVal_fec_18(dataset.getDate("val_fec_18"));
        if (dataset.containstAttribute("val_fec_19"))
        		valorcompopresu.setVal_fec_19(dataset.getDate("val_fec_19"));
        if (dataset.containstAttribute("val_fec_20"))
        		valorcompopresu.setVal_fec_20(dataset.getDate("val_fec_20"));
        addTransaccion(valorcompopresu);
        dataset.next();
    }
  }
  
}
