package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.da.DBValorCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorCompoPresu extends FactoryObjetoLogico { 

  public FactoryValorCompoPresu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorCompoPresu valorcompopresu = (ValorCompoPresu) objLog;
   valorcompopresu.setOID(db.getInteger(DBValorCompoPresu.OID_VALOR_COMPO));
    valorcompopresu.setCodigo(db.getString(DBValorCompoPresu.CODIGO));
    valorcompopresu.setDescripcion(db.getString(DBValorCompoPresu.DESCRIPCION));
    valorcompopresu.setNro_rel(db.getInteger(DBValorCompoPresu.NRO_REL));
    valorcompopresu.setNro_rel_padre(db.getInteger(DBValorCompoPresu.NRO_REL_PADRE));
    valorcompopresu.setActivo(db.getBoolean(DBValorCompoPresu.ACTIVO));
    valorcompopresu.setCompoPresupuestario(CompoPresupuestario.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_COMPO_PRESU),getSesion()));
    valorcompopresu.setVal_com_1(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_1),getSesion()));
    valorcompopresu.setVal_com_2(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_2),getSesion()));
    valorcompopresu.setVal_com_3(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_3),getSesion()));
    valorcompopresu.setVal_com_4(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_4),getSesion()));
    valorcompopresu.setVal_com_5(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_5),getSesion()));
    valorcompopresu.setVal_com_6(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_6),getSesion()));
    valorcompopresu.setVal_com_7(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_7),getSesion()));
    valorcompopresu.setVal_com_8(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_8),getSesion()));
    valorcompopresu.setVal_com_9(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_9),getSesion()));
    valorcompopresu.setVal_com_10(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_10),getSesion()));
    valorcompopresu.setVal_com_11(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_11),getSesion()));
    valorcompopresu.setVal_com_12(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_12),getSesion()));
    valorcompopresu.setVal_com_13(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_13),getSesion()));
    valorcompopresu.setVal_com_14(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_14),getSesion()));
    valorcompopresu.setVal_com_15(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_15),getSesion()));
    valorcompopresu.setVal_com_16(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_16),getSesion()));
    valorcompopresu.setVal_com_17(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_17),getSesion()));
    valorcompopresu.setVal_com_18(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_18),getSesion()));
    valorcompopresu.setVal_com_19(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_19),getSesion()));
    valorcompopresu.setVal_com_20(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_20),getSesion()));
    valorcompopresu.setVal_com_21(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_21),getSesion()));
    valorcompopresu.setVal_com_22(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_22),getSesion()));
    valorcompopresu.setVal_com_23(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_23),getSesion()));
    valorcompopresu.setVal_com_24(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_24),getSesion()));
    valorcompopresu.setVal_com_25(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_25),getSesion()));
    valorcompopresu.setVal_com_26(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_26),getSesion()));
    valorcompopresu.setVal_com_27(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_27),getSesion()));
    valorcompopresu.setVal_com_28(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_28),getSesion()));
    valorcompopresu.setVal_com_29(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_29),getSesion()));
    valorcompopresu.setVal_com_30(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_30),getSesion()));
    valorcompopresu.setVal_com_31(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_31),getSesion()));
    valorcompopresu.setVal_com_32(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_32),getSesion()));
    valorcompopresu.setVal_com_33(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_33),getSesion()));
    valorcompopresu.setVal_com_34(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_34),getSesion()));
    valorcompopresu.setVal_com_35(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_35),getSesion()));
    valorcompopresu.setVal_com_36(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_36),getSesion()));
    valorcompopresu.setVal_com_37(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_37),getSesion()));
    valorcompopresu.setVal_com_38(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_38),getSesion()));
    valorcompopresu.setVal_com_39(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_39),getSesion()));
    valorcompopresu.setVal_com_40(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_40),getSesion()));
    valorcompopresu.setVal_com_41(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_41),getSesion()));
    valorcompopresu.setVal_com_42(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_42),getSesion()));
    valorcompopresu.setVal_com_43(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_43),getSesion()));
    valorcompopresu.setVal_com_44(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_44),getSesion()));
    valorcompopresu.setVal_com_45(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_45),getSesion()));
    valorcompopresu.setVal_com_46(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_46),getSesion()));
    valorcompopresu.setVal_com_47(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_47),getSesion()));
    valorcompopresu.setVal_com_48(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_48),getSesion()));
    valorcompopresu.setVal_com_49(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_49),getSesion()));
    valorcompopresu.setVal_com_50(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_50),getSesion()));
    valorcompopresu.setVal_com_51(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_51),getSesion()));
    valorcompopresu.setVal_com_52(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_52),getSesion()));
    valorcompopresu.setVal_com_53(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_53),getSesion()));
    valorcompopresu.setVal_com_54(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_54),getSesion()));
    valorcompopresu.setVal_com_55(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_55),getSesion()));
    valorcompopresu.setVal_com_56(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_56),getSesion()));
    valorcompopresu.setVal_com_57(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_57),getSesion()));
    valorcompopresu.setVal_com_58(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_58),getSesion()));
    valorcompopresu.setVal_com_59(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_59),getSesion()));
    valorcompopresu.setVal_com_60(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_60),getSesion()));
    valorcompopresu.setVal_com_61(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_61),getSesion()));
    valorcompopresu.setVal_com_62(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_62),getSesion()));
    valorcompopresu.setVal_com_63(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_63),getSesion()));
    valorcompopresu.setVal_com_64(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_64),getSesion()));
    valorcompopresu.setVal_com_65(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_65),getSesion()));
    valorcompopresu.setVal_com_66(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_66),getSesion()));
    valorcompopresu.setVal_com_67(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_67),getSesion()));
    valorcompopresu.setVal_com_68(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_68),getSesion()));
    valorcompopresu.setVal_com_69(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_69),getSesion()));
    valorcompopresu.setVal_com_70(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_70),getSesion()));
    valorcompopresu.setVal_com_71(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_71),getSesion()));
    valorcompopresu.setVal_com_72(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_72),getSesion()));
    valorcompopresu.setVal_com_73(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_73),getSesion()));
    valorcompopresu.setVal_com_74(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_74),getSesion()));
    valorcompopresu.setVal_com_75(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_75),getSesion()));
    valorcompopresu.setVal_com_76(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_76),getSesion()));
    valorcompopresu.setVal_com_77(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_77),getSesion()));
    valorcompopresu.setVal_com_78(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_78),getSesion()));
    valorcompopresu.setVal_com_79(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_79),getSesion()));
    valorcompopresu.setVal_com_80(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoPresu.OID_VAL_COM_80),getSesion()));
    valorcompopresu.setVal_num_1(db.getDouble(DBValorCompoPresu.VAL_NUM_1));
    valorcompopresu.setVal_num_2(db.getDouble(DBValorCompoPresu.VAL_NUM_2));
    valorcompopresu.setVal_num_3(db.getDouble(DBValorCompoPresu.VAL_NUM_3));
    valorcompopresu.setVal_num_4(db.getDouble(DBValorCompoPresu.VAL_NUM_4));
    valorcompopresu.setVal_num_5(db.getDouble(DBValorCompoPresu.VAL_NUM_5));
    valorcompopresu.setVal_num_6(db.getDouble(DBValorCompoPresu.VAL_NUM_6));
    valorcompopresu.setVal_num_7(db.getDouble(DBValorCompoPresu.VAL_NUM_7));
    valorcompopresu.setVal_num_8(db.getDouble(DBValorCompoPresu.VAL_NUM_8));
    valorcompopresu.setVal_num_9(db.getDouble(DBValorCompoPresu.VAL_NUM_9));
    valorcompopresu.setVal_num_10(db.getDouble(DBValorCompoPresu.VAL_NUM_10));
    valorcompopresu.setVal_num_11(db.getDouble(DBValorCompoPresu.VAL_NUM_11));
    valorcompopresu.setVal_num_12(db.getDouble(DBValorCompoPresu.VAL_NUM_12));
    valorcompopresu.setVal_num_13(db.getDouble(DBValorCompoPresu.VAL_NUM_13));
    valorcompopresu.setVal_num_14(db.getDouble(DBValorCompoPresu.VAL_NUM_14));
    valorcompopresu.setVal_num_15(db.getDouble(DBValorCompoPresu.VAL_NUM_15));
    valorcompopresu.setVal_num_16(db.getDouble(DBValorCompoPresu.VAL_NUM_16));
    valorcompopresu.setVal_num_17(db.getDouble(DBValorCompoPresu.VAL_NUM_17));
    valorcompopresu.setVal_num_18(db.getDouble(DBValorCompoPresu.VAL_NUM_18));
    valorcompopresu.setVal_num_19(db.getDouble(DBValorCompoPresu.VAL_NUM_19));
    valorcompopresu.setVal_num_20(db.getDouble(DBValorCompoPresu.VAL_NUM_20));
    valorcompopresu.setVal_num_21(db.getDouble(DBValorCompoPresu.VAL_NUM_21));
    valorcompopresu.setVal_num_22(db.getDouble(DBValorCompoPresu.VAL_NUM_22));
    valorcompopresu.setVal_num_23(db.getDouble(DBValorCompoPresu.VAL_NUM_23));
    valorcompopresu.setVal_num_24(db.getDouble(DBValorCompoPresu.VAL_NUM_24));
    valorcompopresu.setVal_num_25(db.getDouble(DBValorCompoPresu.VAL_NUM_25));
    valorcompopresu.setVal_num_26(db.getDouble(DBValorCompoPresu.VAL_NUM_26));
    valorcompopresu.setVal_num_27(db.getDouble(DBValorCompoPresu.VAL_NUM_27));
    valorcompopresu.setVal_num_28(db.getDouble(DBValorCompoPresu.VAL_NUM_28));
    valorcompopresu.setVal_num_29(db.getDouble(DBValorCompoPresu.VAL_NUM_29));
    valorcompopresu.setVal_num_30(db.getDouble(DBValorCompoPresu.VAL_NUM_30));
    valorcompopresu.setVal_tex_1(db.getString(DBValorCompoPresu.VAL_TEX_1));
    valorcompopresu.setVal_tex_2(db.getString(DBValorCompoPresu.VAL_TEX_2));
    valorcompopresu.setVal_tex_3(db.getString(DBValorCompoPresu.VAL_TEX_3));
    valorcompopresu.setVal_tex_4(db.getString(DBValorCompoPresu.VAL_TEX_4));
    valorcompopresu.setVal_tex_5(db.getString(DBValorCompoPresu.VAL_TEX_5));
    valorcompopresu.setVal_tex_6(db.getString(DBValorCompoPresu.VAL_TEX_6));
    valorcompopresu.setVal_tex_7(db.getString(DBValorCompoPresu.VAL_TEX_7));
    valorcompopresu.setVal_tex_8(db.getString(DBValorCompoPresu.VAL_TEX_8));
    valorcompopresu.setVal_tex_9(db.getString(DBValorCompoPresu.VAL_TEX_9));
    valorcompopresu.setVal_tex_10(db.getString(DBValorCompoPresu.VAL_TEX_10));
    valorcompopresu.setVal_tex_11(db.getString(DBValorCompoPresu.VAL_TEX_11));
    valorcompopresu.setVal_tex_12(db.getString(DBValorCompoPresu.VAL_TEX_12));
    valorcompopresu.setVal_tex_13(db.getString(DBValorCompoPresu.VAL_TEX_13));
    valorcompopresu.setVal_tex_14(db.getString(DBValorCompoPresu.VAL_TEX_14));
    valorcompopresu.setVal_tex_15(db.getString(DBValorCompoPresu.VAL_TEX_15));
    valorcompopresu.setVal_tex_16(db.getString(DBValorCompoPresu.VAL_TEX_16));
    valorcompopresu.setVal_tex_17(db.getString(DBValorCompoPresu.VAL_TEX_17));
    valorcompopresu.setVal_tex_18(db.getString(DBValorCompoPresu.VAL_TEX_18));
    valorcompopresu.setVal_tex_19(db.getString(DBValorCompoPresu.VAL_TEX_19));
    valorcompopresu.setVal_tex_20(db.getString(DBValorCompoPresu.VAL_TEX_20));
    valorcompopresu.setVal_fec_1(db.getDate(DBValorCompoPresu.VAL_FEC_1));
    valorcompopresu.setVal_fec_2(db.getDate(DBValorCompoPresu.VAL_FEC_2));
    valorcompopresu.setVal_fec_3(db.getDate(DBValorCompoPresu.VAL_FEC_3));
    valorcompopresu.setVal_fec_4(db.getDate(DBValorCompoPresu.VAL_FEC_4));
    valorcompopresu.setVal_fec_5(db.getDate(DBValorCompoPresu.VAL_FEC_5));
    valorcompopresu.setVal_fec_6(db.getDate(DBValorCompoPresu.VAL_FEC_6));
    valorcompopresu.setVal_fec_7(db.getDate(DBValorCompoPresu.VAL_FEC_7));
    valorcompopresu.setVal_fec_8(db.getDate(DBValorCompoPresu.VAL_FEC_8));
    valorcompopresu.setVal_fec_9(db.getDate(DBValorCompoPresu.VAL_FEC_9));
    valorcompopresu.setVal_fec_10(db.getDate(DBValorCompoPresu.VAL_FEC_10));
    valorcompopresu.setVal_fec_11(db.getDate(DBValorCompoPresu.VAL_FEC_11));
    valorcompopresu.setVal_fec_12(db.getDate(DBValorCompoPresu.VAL_FEC_12));
    valorcompopresu.setVal_fec_13(db.getDate(DBValorCompoPresu.VAL_FEC_13));
    valorcompopresu.setVal_fec_14(db.getDate(DBValorCompoPresu.VAL_FEC_14));
    valorcompopresu.setVal_fec_15(db.getDate(DBValorCompoPresu.VAL_FEC_15));
    valorcompopresu.setVal_fec_16(db.getDate(DBValorCompoPresu.VAL_FEC_16));
    valorcompopresu.setVal_fec_17(db.getDate(DBValorCompoPresu.VAL_FEC_17));
    valorcompopresu.setVal_fec_18(db.getDate(DBValorCompoPresu.VAL_FEC_18));
    valorcompopresu.setVal_fec_19(db.getDate(DBValorCompoPresu.VAL_FEC_19));
    valorcompopresu.setVal_fec_20(db.getDate(DBValorCompoPresu.VAL_FEC_20));

  }
}
