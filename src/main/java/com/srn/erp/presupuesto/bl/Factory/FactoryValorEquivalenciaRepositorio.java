package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorEquivalenciaRepositorio;
import com.srn.erp.presupuesto.bm.ValorRealRepositorio;
import com.srn.erp.presupuesto.da.DBValorEquivalenciaRepositorio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorEquivalenciaRepositorio extends FactoryObjetoLogico { 

  public FactoryValorEquivalenciaRepositorio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorEquivalenciaRepositorio valorequivalenciarepositorio = (ValorEquivalenciaRepositorio) objLog;
    valorequivalenciarepositorio.setOID(db.getInteger(DBValorEquivalenciaRepositorio.OID_EQUIV));
    valorequivalenciarepositorio.setRepositorio_real(RepositorioReal.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_REPO_REAL),getSesion()));
    valorequivalenciarepositorio.setValorRealRepositorio(ValorRealRepositorio.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_REPO_REAL),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu1(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_1),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu2(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_2),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu3(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_3),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu4(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_4),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu5(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_5),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu6(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_6),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu7(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_7),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu8(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_8),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu9(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_9),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu10(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_10),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu11(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_11),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu12(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_12),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu13(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_13),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu14(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_14),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu15(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_15),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu16(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_16),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu17(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_17),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu18(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_18),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu19(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_19),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu20(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_20),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu21(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_21),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu22(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_22),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu23(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_23),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu24(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_24),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu25(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_25),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu26(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_26),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu27(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_27),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu28(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_28),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu29(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_29),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu30(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_30),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu31(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_31),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu32(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_32),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu33(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_33),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu34(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_34),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu35(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_35),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu36(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_36),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu37(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_37),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu38(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_38),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu39(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_39),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu40(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_40),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu41(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_41),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu42(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_42),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu43(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_43),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu44(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_44),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu45(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_45),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu46(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_46),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu47(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_47),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu48(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_48),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu49(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_49),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu50(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_50),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu51(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_51),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu52(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_52),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu53(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_53),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu54(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_54),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu55(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_55),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu56(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_56),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu57(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_57),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu58(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_58),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu59(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_59),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu60(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_60),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu61(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_61),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu62(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_62),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu63(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_63),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu64(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_64),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu65(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_65),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu66(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_66),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu67(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_67),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu68(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_68),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu69(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_69),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu70(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_70),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu71(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_71),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu72(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_72),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu73(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_73),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu74(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_74),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu75(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_75),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu76(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_76),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu77(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_77),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu78(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_78),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu79(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_79),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu80(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_80),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu81(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_81),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu82(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_82),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu83(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_83),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu84(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_84),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu85(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_85),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu86(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_86),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu87(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_87),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu88(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_88),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu89(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_89),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu90(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_90),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu91(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_91),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu92(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_92),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu93(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_93),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu94(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_94),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu95(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_95),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu96(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_96),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu97(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_97),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu98(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_98),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu99(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_99),getSesion()));
    valorequivalenciarepositorio.setValor_compo_presu100(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_VAL_100),getSesion()));
    valorequivalenciarepositorio.setVal_metrica_1(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_1));
    valorequivalenciarepositorio.setVal_metrica_2(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_2));
    valorequivalenciarepositorio.setVal_metrica_3(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_3));
    valorequivalenciarepositorio.setVal_metrica_4(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_4));
    valorequivalenciarepositorio.setVal_metrica_5(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_5));
    valorequivalenciarepositorio.setVal_metrica_6(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_6));
    valorequivalenciarepositorio.setVal_metrica_7(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_7));
    valorequivalenciarepositorio.setVal_metrica_8(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_8));
    valorequivalenciarepositorio.setVal_metrica_9(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_9));
    valorequivalenciarepositorio.setVal_metrica_10(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_10));
    valorequivalenciarepositorio.setVal_metrica_11(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_11));
    valorequivalenciarepositorio.setVal_metrica_12(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_12));
    valorequivalenciarepositorio.setVal_metrica_13(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_13));
    valorequivalenciarepositorio.setVal_metrica_14(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_14));
    valorequivalenciarepositorio.setVal_metrica_15(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_15));
    valorequivalenciarepositorio.setVal_metrica_16(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_16));
    valorequivalenciarepositorio.setVal_metrica_17(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_17));
    valorequivalenciarepositorio.setVal_metrica_18(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_18));
    valorequivalenciarepositorio.setVal_metrica_19(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_19));
    valorequivalenciarepositorio.setVal_metrica_20(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_20));
    valorequivalenciarepositorio.setVal_metrica_21(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_21));
    valorequivalenciarepositorio.setVal_metrica_22(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_22));
    valorequivalenciarepositorio.setVal_metrica_23(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_23));
    valorequivalenciarepositorio.setVal_metrica_24(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_24));
    valorequivalenciarepositorio.setVal_metrica_25(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_25));
    valorequivalenciarepositorio.setVal_metrica_26(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_26));
    valorequivalenciarepositorio.setVal_metrica_27(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_27));
    valorequivalenciarepositorio.setVal_metrica_28(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_28));
    valorequivalenciarepositorio.setVal_metrica_29(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_29));
    valorequivalenciarepositorio.setVal_metrica_30(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_30));
    valorequivalenciarepositorio.setVal_metrica_31(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_31));
    valorequivalenciarepositorio.setVal_metrica_32(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_32));
    valorequivalenciarepositorio.setVal_metrica_33(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_33));
    valorequivalenciarepositorio.setVal_metrica_34(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_34));
    valorequivalenciarepositorio.setVal_metrica_35(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_35));
    valorequivalenciarepositorio.setVal_metrica_36(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_36));
    valorequivalenciarepositorio.setVal_metrica_37(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_37));
    valorequivalenciarepositorio.setVal_metrica_38(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_38));
    valorequivalenciarepositorio.setVal_metrica_39(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_39));
    valorequivalenciarepositorio.setVal_metrica_40(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_40));
    valorequivalenciarepositorio.setVal_metrica_41(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_41));
    valorequivalenciarepositorio.setVal_metrica_42(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_42));
    valorequivalenciarepositorio.setVal_metrica_43(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_43));
    valorequivalenciarepositorio.setVal_metrica_44(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_44));
    valorequivalenciarepositorio.setVal_metrica_45(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_45));
    valorequivalenciarepositorio.setVal_metrica_46(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_46));
    valorequivalenciarepositorio.setVal_metrica_47(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_47));
    valorequivalenciarepositorio.setVal_metrica_48(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_48));
    valorequivalenciarepositorio.setVal_metrica_49(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_49));
    valorequivalenciarepositorio.setVal_metrica_50(db.getDouble(DBValorEquivalenciaRepositorio.VAL_METRICA_50));
    valorequivalenciarepositorio.setPeriodo1(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_1),getSesion()));
    valorequivalenciarepositorio.setPeriodo2(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_2),getSesion()));
    valorequivalenciarepositorio.setPeriodo3(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_3),getSesion()));
    valorequivalenciarepositorio.setPeriodo4(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_4),getSesion()));
    valorequivalenciarepositorio.setPeriodo5(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_5),getSesion()));
    valorequivalenciarepositorio.setPeriodo6(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_6),getSesion()));
    valorequivalenciarepositorio.setPeriodo7(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_7),getSesion()));
    valorequivalenciarepositorio.setPeriodo8(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_8),getSesion()));
    valorequivalenciarepositorio.setPeriodo9(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_9),getSesion()));
    valorequivalenciarepositorio.setPeriodo10(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_10),getSesion()));
    valorequivalenciarepositorio.setPeriodo11(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_11),getSesion()));
    valorequivalenciarepositorio.setPeriodo12(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_12),getSesion()));
    valorequivalenciarepositorio.setPeriodo13(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_13),getSesion()));
    valorequivalenciarepositorio.setPeriodo14(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_14),getSesion()));
    valorequivalenciarepositorio.setPeriodo15(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_15),getSesion()));
    valorequivalenciarepositorio.setPeriodo16(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_16),getSesion()));
    valorequivalenciarepositorio.setPeriodo17(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_17),getSesion()));
    valorequivalenciarepositorio.setPeriodo18(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_18),getSesion()));
    valorequivalenciarepositorio.setPeriodo19(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_19),getSesion()));
    valorequivalenciarepositorio.setPeriodo20(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorEquivalenciaRepositorio.OID_PERI_20),getSesion()));
    valorequivalenciarepositorio.setActivo(db.getBoolean(DBValorEquivalenciaRepositorio.ACTIVO));

  }
}