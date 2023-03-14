package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.ValorCompoReal;
import com.srn.erp.presupuesto.bm.ValorRealRepositorio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveValorRealRepositorio extends Operation { 

  public SaveValorRealRepositorio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TValorRealRepositorio"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ValorRealRepositorio valorrealrepositorio = ValorRealRepositorio.findByOid(dataset.getInteger("oid_val_repo_real"),getSesion());
        valorrealrepositorio.setOID(dataset.getInteger("oid_val_repo_real"));
        
        valorrealrepositorio.setRepositorio_real(RepositorioReal.findByOidProxy(dataset.getInteger("oid_repo_real"),this.getSesion()));
        valorrealrepositorio.setValor_real_1(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_1"),this.getSesion()));
        valorrealrepositorio.setValor_real_2(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_2"),this.getSesion()));
        valorrealrepositorio.setValor_real_3(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_3"),this.getSesion()));
        valorrealrepositorio.setValor_real_4(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_4"),this.getSesion()));
        valorrealrepositorio.setValor_real_5(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_5"),this.getSesion()));
        valorrealrepositorio.setValor_real_6(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_6"),this.getSesion()));
        valorrealrepositorio.setValor_real_7(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_7"),this.getSesion()));
        valorrealrepositorio.setValor_real_8(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_8"),this.getSesion()));
        valorrealrepositorio.setValor_real_9(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_9"),this.getSesion()));
        valorrealrepositorio.setValor_real_10(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_10"),this.getSesion()));
        valorrealrepositorio.setValor_real_11(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_11"),this.getSesion()));
        valorrealrepositorio.setValor_real_12(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_12"),this.getSesion()));
        valorrealrepositorio.setValor_real_13(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_13"),this.getSesion()));
        valorrealrepositorio.setValor_real_14(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_14"),this.getSesion()));
        valorrealrepositorio.setValor_real_15(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_15"),this.getSesion()));
        valorrealrepositorio.setValor_real_16(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_16"),this.getSesion()));
        valorrealrepositorio.setValor_real_17(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_17"),this.getSesion()));
        valorrealrepositorio.setValor_real_18(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_18"),this.getSesion()));
        valorrealrepositorio.setValor_real_19(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_19"),this.getSesion()));
        valorrealrepositorio.setValor_real_20(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_20"),this.getSesion()));
        valorrealrepositorio.setValor_real_21(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_21"),this.getSesion()));
        valorrealrepositorio.setValor_real_22(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_22"),this.getSesion()));
        valorrealrepositorio.setValor_real_23(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_23"),this.getSesion()));
        valorrealrepositorio.setValor_real_24(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_24"),this.getSesion()));
        valorrealrepositorio.setValor_real_25(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_25"),this.getSesion()));
        valorrealrepositorio.setValor_real_26(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_26"),this.getSesion()));
        valorrealrepositorio.setValor_real_27(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_27"),this.getSesion()));
        valorrealrepositorio.setValor_real_28(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_28"),this.getSesion()));
        valorrealrepositorio.setValor_real_29(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_29"),this.getSesion()));
        valorrealrepositorio.setValor_real_30(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_30"),this.getSesion()));
        valorrealrepositorio.setValor_real_31(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_31"),this.getSesion()));
        valorrealrepositorio.setValor_real_32(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_32"),this.getSesion()));
        valorrealrepositorio.setValor_real_33(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_33"),this.getSesion()));
        valorrealrepositorio.setValor_real_34(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_34"),this.getSesion()));
        valorrealrepositorio.setValor_real_35(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_35"),this.getSesion()));
        valorrealrepositorio.setValor_real_36(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_36"),this.getSesion()));
        valorrealrepositorio.setValor_real_37(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_37"),this.getSesion()));
        valorrealrepositorio.setValor_real_38(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_38"),this.getSesion()));
        valorrealrepositorio.setValor_real_39(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_39"),this.getSesion()));
        valorrealrepositorio.setValor_real_40(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_40"),this.getSesion()));
        valorrealrepositorio.setValor_real_41(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_41"),this.getSesion()));
        valorrealrepositorio.setValor_real_42(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_42"),this.getSesion()));
        valorrealrepositorio.setValor_real_43(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_43"),this.getSesion()));
        valorrealrepositorio.setValor_real_44(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_44"),this.getSesion()));
        valorrealrepositorio.setValor_real_45(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_45"),this.getSesion()));
        valorrealrepositorio.setValor_real_46(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_46"),this.getSesion()));
        valorrealrepositorio.setValor_real_47(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_47"),this.getSesion()));
        valorrealrepositorio.setValor_real_48(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_48"),this.getSesion()));
        valorrealrepositorio.setValor_real_49(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_49"),this.getSesion()));
        valorrealrepositorio.setValor_real_50(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_50"),this.getSesion()));
        valorrealrepositorio.setValor_real_51(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_51"),this.getSesion()));
        valorrealrepositorio.setValor_real_52(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_52"),this.getSesion()));
        valorrealrepositorio.setValor_real_53(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_53"),this.getSesion()));
        valorrealrepositorio.setValor_real_54(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_54"),this.getSesion()));
        valorrealrepositorio.setValor_real_55(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_55"),this.getSesion()));
        valorrealrepositorio.setValor_real_56(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_56"),this.getSesion()));
        valorrealrepositorio.setValor_real_57(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_57"),this.getSesion()));
        valorrealrepositorio.setValor_real_58(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_58"),this.getSesion()));
        valorrealrepositorio.setValor_real_59(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_59"),this.getSesion()));
        valorrealrepositorio.setValor_real_60(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_60"),this.getSesion()));
        valorrealrepositorio.setValor_real_61(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_61"),this.getSesion()));
        valorrealrepositorio.setValor_real_62(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_62"),this.getSesion()));
        valorrealrepositorio.setValor_real_63(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_63"),this.getSesion()));
        valorrealrepositorio.setValor_real_64(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_64"),this.getSesion()));
        valorrealrepositorio.setValor_real_65(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_65"),this.getSesion()));
        valorrealrepositorio.setValor_real_66(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_66"),this.getSesion()));
        valorrealrepositorio.setValor_real_67(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_67"),this.getSesion()));
        valorrealrepositorio.setValor_real_68(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_68"),this.getSesion()));
        valorrealrepositorio.setValor_real_69(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_69"),this.getSesion()));
        valorrealrepositorio.setValor_real_70(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_70"),this.getSesion()));
        valorrealrepositorio.setValor_real_71(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_71"),this.getSesion()));
        valorrealrepositorio.setValor_real_72(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_72"),this.getSesion()));
        valorrealrepositorio.setValor_real_73(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_73"),this.getSesion()));
        valorrealrepositorio.setValor_real_74(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_74"),this.getSesion()));
        valorrealrepositorio.setValor_real_75(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_75"),this.getSesion()));
        valorrealrepositorio.setValor_real_76(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_76"),this.getSesion()));
        valorrealrepositorio.setValor_real_77(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_77"),this.getSesion()));
        valorrealrepositorio.setValor_real_78(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_78"),this.getSesion()));
        valorrealrepositorio.setValor_real_79(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_79"),this.getSesion()));
        valorrealrepositorio.setValor_real_80(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_80"),this.getSesion()));
        valorrealrepositorio.setValor_real_81(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_81"),this.getSesion()));
        valorrealrepositorio.setValor_real_82(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_82"),this.getSesion()));
        valorrealrepositorio.setValor_real_83(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_83"),this.getSesion()));
        valorrealrepositorio.setValor_real_84(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_84"),this.getSesion()));
        valorrealrepositorio.setValor_real_85(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_85"),this.getSesion()));
        valorrealrepositorio.setValor_real_86(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_86"),this.getSesion()));
        valorrealrepositorio.setValor_real_87(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_87"),this.getSesion()));
        valorrealrepositorio.setValor_real_88(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_88"),this.getSesion()));
        valorrealrepositorio.setValor_real_89(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_89"),this.getSesion()));
        valorrealrepositorio.setValor_real_90(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_90"),this.getSesion()));
        valorrealrepositorio.setValor_real_91(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_91"),this.getSesion()));
        valorrealrepositorio.setValor_real_92(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_92"),this.getSesion()));
        valorrealrepositorio.setValor_real_93(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_93"),this.getSesion()));
        valorrealrepositorio.setValor_real_94(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_94"),this.getSesion()));
        valorrealrepositorio.setValor_real_95(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_95"),this.getSesion()));
        valorrealrepositorio.setValor_real_96(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_96"),this.getSesion()));
        valorrealrepositorio.setValor_real_97(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_97"),this.getSesion()));
        valorrealrepositorio.setValor_real_98(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_98"),this.getSesion()));
        valorrealrepositorio.setValor_real_99(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_99"),this.getSesion()));
        valorrealrepositorio.setValor_real_100(ValorCompoReal.findByOidProxy(dataset.getInteger("oid_val_real_100"),this.getSesion()));
        valorrealrepositorio.setVal_metrica_1(dataset.getDouble("val_metrica_1"));
        valorrealrepositorio.setVal_metrica_2(dataset.getDouble("val_metrica_2"));
        valorrealrepositorio.setVal_metrica_3(dataset.getDouble("val_metrica_3"));
        valorrealrepositorio.setVal_metrica_4(dataset.getDouble("val_metrica_4"));
        valorrealrepositorio.setVal_metrica_5(dataset.getDouble("val_metrica_5"));
        valorrealrepositorio.setVal_metrica_6(dataset.getDouble("val_metrica_6"));
        valorrealrepositorio.setVal_metrica_7(dataset.getDouble("val_metrica_7"));
        valorrealrepositorio.setVal_metrica_8(dataset.getDouble("val_metrica_8"));
        valorrealrepositorio.setVal_metrica_9(dataset.getDouble("val_metrica_9"));
        valorrealrepositorio.setVal_metrica_10(dataset.getDouble("val_metrica_10"));
        valorrealrepositorio.setVal_metrica_11(dataset.getDouble("val_metrica_11"));
        valorrealrepositorio.setVal_metrica_12(dataset.getDouble("val_metrica_12"));
        valorrealrepositorio.setVal_metrica_13(dataset.getDouble("val_metrica_13"));
        valorrealrepositorio.setVal_metrica_14(dataset.getDouble("val_metrica_14"));
        valorrealrepositorio.setVal_metrica_15(dataset.getDouble("val_metrica_15"));
        valorrealrepositorio.setVal_metrica_16(dataset.getDouble("val_metrica_16"));
        valorrealrepositorio.setVal_metrica_17(dataset.getDouble("val_metrica_17"));
        valorrealrepositorio.setVal_metrica_18(dataset.getDouble("val_metrica_18"));
        valorrealrepositorio.setVal_metrica_19(dataset.getDouble("val_metrica_19"));
        valorrealrepositorio.setVal_metrica_20(dataset.getDouble("val_metrica_20"));
        valorrealrepositorio.setVal_metrica_21(dataset.getDouble("val_metrica_21"));
        valorrealrepositorio.setVal_metrica_22(dataset.getDouble("val_metrica_22"));
        valorrealrepositorio.setVal_metrica_23(dataset.getDouble("val_metrica_23"));
        valorrealrepositorio.setVal_metrica_24(dataset.getDouble("val_metrica_24"));
        valorrealrepositorio.setVal_metrica_25(dataset.getDouble("val_metrica_25"));
        valorrealrepositorio.setVal_metrica_26(dataset.getDouble("val_metrica_26"));
        valorrealrepositorio.setVal_metrica_27(dataset.getDouble("val_metrica_27"));
        valorrealrepositorio.setVal_metrica_28(dataset.getDouble("val_metrica_28"));
        valorrealrepositorio.setVal_metrica_29(dataset.getDouble("val_metrica_29"));
        valorrealrepositorio.setVal_metrica_30(dataset.getDouble("val_metrica_30"));
        valorrealrepositorio.setVal_metrica_31(dataset.getDouble("val_metrica_31"));
        valorrealrepositorio.setVal_metrica_32(dataset.getDouble("val_metrica_32"));
        valorrealrepositorio.setVal_metrica_33(dataset.getDouble("val_metrica_33"));
        valorrealrepositorio.setVal_metrica_34(dataset.getDouble("val_metrica_34"));
        valorrealrepositorio.setVal_metrica_35(dataset.getDouble("val_metrica_35"));
        valorrealrepositorio.setVal_metrica_36(dataset.getDouble("val_metrica_36"));
        valorrealrepositorio.setVal_metrica_37(dataset.getDouble("val_metrica_37"));
        valorrealrepositorio.setVal_metrica_38(dataset.getDouble("val_metrica_38"));
        valorrealrepositorio.setVal_metrica_39(dataset.getDouble("val_metrica_39"));
        valorrealrepositorio.setVal_metrica_40(dataset.getDouble("val_metrica_40"));
        valorrealrepositorio.setVal_metrica_41(dataset.getDouble("val_metrica_41"));
        valorrealrepositorio.setVal_metrica_42(dataset.getDouble("val_metrica_42"));
        valorrealrepositorio.setVal_metrica_43(dataset.getDouble("val_metrica_43"));
        valorrealrepositorio.setVal_metrica_44(dataset.getDouble("val_metrica_44"));
        valorrealrepositorio.setVal_metrica_45(dataset.getDouble("val_metrica_45"));
        valorrealrepositorio.setVal_metrica_46(dataset.getDouble("val_metrica_46"));
        valorrealrepositorio.setVal_metrica_47(dataset.getDouble("val_metrica_47"));
        valorrealrepositorio.setVal_metrica_48(dataset.getDouble("val_metrica_48"));
        valorrealrepositorio.setVal_metrica_49(dataset.getDouble("val_metrica_49"));
        valorrealrepositorio.setVal_metrica_50(dataset.getDouble("val_metrica_50"));
        valorrealrepositorio.setFec_tipo_peri_1(dataset.getDate("fec_tipo_peri_1"));
        valorrealrepositorio.setFec_tipo_peri_2(dataset.getDate("fec_tipo_peri_2"));
        valorrealrepositorio.setFec_tipo_peri_3(dataset.getDate("fec_tipo_peri_3"));
        valorrealrepositorio.setFec_tipo_peri_4(dataset.getDate("fec_tipo_peri_4"));
        valorrealrepositorio.setFec_tipo_peri_5(dataset.getDate("fec_tipo_peri_5"));
        valorrealrepositorio.setFec_tipo_peri_6(dataset.getDate("fec_tipo_peri_6"));
        valorrealrepositorio.setFec_tipo_peri_7(dataset.getDate("fec_tipo_peri_7"));
        valorrealrepositorio.setFec_tipo_peri_8(dataset.getDate("fec_tipo_peri_8"));
        valorrealrepositorio.setFec_tipo_peri_9(dataset.getDate("fec_tipo_peri_9"));
        valorrealrepositorio.setFec_tipo_peri_10(dataset.getDate("fec_tipo_peri_10"));
        valorrealrepositorio.setFec_tipo_peri_11(dataset.getDate("fec_tipo_peri_11"));
        valorrealrepositorio.setFec_tipo_peri_12(dataset.getDate("fec_tipo_peri_12"));
        valorrealrepositorio.setFec_tipo_peri_13(dataset.getDate("fec_tipo_peri_13"));
        valorrealrepositorio.setFec_tipo_peri_14(dataset.getDate("fec_tipo_peri_14"));
        valorrealrepositorio.setFec_tipo_peri_15(dataset.getDate("fec_tipo_peri_15"));
        valorrealrepositorio.setFec_tipo_peri_16(dataset.getDate("fec_tipo_peri_16"));
        valorrealrepositorio.setFec_tipo_peri_17(dataset.getDate("fec_tipo_peri_17"));
        valorrealrepositorio.setFec_tipo_peri_18(dataset.getDate("fec_tipo_peri_18"));
        valorrealrepositorio.setFec_tipo_peri_19(dataset.getDate("fec_tipo_peri_19"));
        valorrealrepositorio.setFec_tipo_peri_20(dataset.getDate("fec_tipo_peri_20"));
        valorrealrepositorio.setActivo(dataset.getBoolean("activo"));
        addTransaccion(valorrealrepositorio);
        dataset.next();
    }
  }
  
}