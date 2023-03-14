package com.srn.erp.presupuesto.bm;

import java.lang.reflect.Method;
import java.util.List;

import com.srn.erp.presupuesto.da.DBValorCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ValorCompoPresu extends ObjetoLogico { 

  public ValorCompoPresu() { 
  }

  public static String NICKNAME = "pl.ValorCompoPresu";

  private String codigo;
  private String descripcion;
  private Integer nro_rel;
  private Integer nro_rel_padre;
  private Boolean activo;
  private CompoPresupuestario compoPresupuestario;
  private ValorCompoPresu val_com_1;
  private ValorCompoPresu val_com_2;
  private ValorCompoPresu val_com_3;
  private ValorCompoPresu val_com_4;
  private ValorCompoPresu val_com_5;
  private ValorCompoPresu val_com_6;
  private ValorCompoPresu val_com_7;
  private ValorCompoPresu val_com_8;
  private ValorCompoPresu val_com_9;
  private ValorCompoPresu val_com_10;
  private ValorCompoPresu val_com_11;
  private ValorCompoPresu val_com_12;
  private ValorCompoPresu val_com_13;
  private ValorCompoPresu val_com_14;
  private ValorCompoPresu val_com_15;
  private ValorCompoPresu val_com_16;
  private ValorCompoPresu val_com_17;
  private ValorCompoPresu val_com_18;
  private ValorCompoPresu val_com_19;
  private ValorCompoPresu val_com_20;
  private ValorCompoPresu val_com_21;
  private ValorCompoPresu val_com_22;
  private ValorCompoPresu val_com_23;
  private ValorCompoPresu val_com_24;
  private ValorCompoPresu val_com_25;
  private ValorCompoPresu val_com_26;
  private ValorCompoPresu val_com_27;
  private ValorCompoPresu val_com_28;
  private ValorCompoPresu val_com_29;
  private ValorCompoPresu val_com_30;
  private ValorCompoPresu val_com_31;
  private ValorCompoPresu val_com_32;
  private ValorCompoPresu val_com_33;
  private ValorCompoPresu val_com_34;
  private ValorCompoPresu val_com_35;
  private ValorCompoPresu val_com_36;
  private ValorCompoPresu val_com_37;
  private ValorCompoPresu val_com_38;
  private ValorCompoPresu val_com_39;
  private ValorCompoPresu val_com_40;
  private ValorCompoPresu val_com_41;
  private ValorCompoPresu val_com_42;
  private ValorCompoPresu val_com_43;
  private ValorCompoPresu val_com_44;
  private ValorCompoPresu val_com_45;
  private ValorCompoPresu val_com_46;
  private ValorCompoPresu val_com_47;
  private ValorCompoPresu val_com_48;
  private ValorCompoPresu val_com_49;
  private ValorCompoPresu val_com_50;
  private ValorCompoPresu val_com_51;
  private ValorCompoPresu val_com_52;
  private ValorCompoPresu val_com_53;
  private ValorCompoPresu val_com_54;
  private ValorCompoPresu val_com_55;
  private ValorCompoPresu val_com_56;
  private ValorCompoPresu val_com_57;
  private ValorCompoPresu val_com_58;
  private ValorCompoPresu val_com_59;
  private ValorCompoPresu val_com_60;
  private ValorCompoPresu val_com_61;
  private ValorCompoPresu val_com_62;
  private ValorCompoPresu val_com_63;
  private ValorCompoPresu val_com_64;
  private ValorCompoPresu val_com_65;
  private ValorCompoPresu val_com_66;
  private ValorCompoPresu val_com_67;
  private ValorCompoPresu val_com_68;
  private ValorCompoPresu val_com_69;
  private ValorCompoPresu val_com_70;
  private ValorCompoPresu val_com_71;
  private ValorCompoPresu val_com_72;
  private ValorCompoPresu val_com_73;
  private ValorCompoPresu val_com_74;
  private ValorCompoPresu val_com_75;
  private ValorCompoPresu val_com_76;
  private ValorCompoPresu val_com_77;
  private ValorCompoPresu val_com_78;
  private ValorCompoPresu val_com_79;
  private ValorCompoPresu val_com_80;
  private Double val_num_1;
  private Double val_num_2;
  private Double val_num_3;
  private Double val_num_4;
  private Double val_num_5;
  private Double val_num_6;
  private Double val_num_7;
  private Double val_num_8;
  private Double val_num_9;
  private Double val_num_10;
  private Double val_num_11;
  private Double val_num_12;
  private Double val_num_13;
  private Double val_num_14;
  private Double val_num_15;
  private Double val_num_16;
  private Double val_num_17;
  private Double val_num_18;
  private Double val_num_19;
  private Double val_num_20;
  private Double val_num_21;
  private Double val_num_22;
  private Double val_num_23;
  private Double val_num_24;
  private Double val_num_25;
  private Double val_num_26;
  private Double val_num_27;
  private Double val_num_28;
  private Double val_num_29;
  private Double val_num_30;
  private String val_tex_1;
  private String val_tex_2;
  private String val_tex_3;
  private String val_tex_4;
  private String val_tex_5;
  private String val_tex_6;
  private String val_tex_7;
  private String val_tex_8;
  private String val_tex_9;
  private String val_tex_10;
  private String val_tex_11;
  private String val_tex_12;
  private String val_tex_13;
  private String val_tex_14;
  private String val_tex_15;
  private String val_tex_16;
  private String val_tex_17;
  private String val_tex_18;
  private String val_tex_19;
  private String val_tex_20;
  private java.util.Date val_fec_1;
  private java.util.Date val_fec_2;
  private java.util.Date val_fec_3;
  private java.util.Date val_fec_4;
  private java.util.Date val_fec_5;
  private java.util.Date val_fec_6;
  private java.util.Date val_fec_7;
  private java.util.Date val_fec_8;
  private java.util.Date val_fec_9;
  private java.util.Date val_fec_10;
  private java.util.Date val_fec_11;
  private java.util.Date val_fec_12;
  private java.util.Date val_fec_13;
  private java.util.Date val_fec_14;
  private java.util.Date val_fec_15;
  private java.util.Date val_fec_16;
  private java.util.Date val_fec_17;
  private java.util.Date val_fec_18;
  private java.util.Date val_fec_19;
  private java.util.Date val_fec_20;

  public CompoPresupuestario getCompoPresupuestario() throws BaseException { 
    supportRefresh();
    return this.compoPresupuestario;
  }

  public void setCompoPresupuestario(CompoPresupuestario aCompoPresupuestario) { 
    this.compoPresupuestario =  aCompoPresupuestario;
  }  
  
  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Integer getNro_rel() throws BaseException { 
    supportRefresh();
    return nro_rel;
  }

  public void setNro_rel(Integer aNro_rel) { 
    this.nro_rel =  aNro_rel;
  }

  public Integer getNro_rel_padre() throws BaseException { 
    supportRefresh();
    return nro_rel_padre;
  }

  public void setNro_rel_padre(Integer aNro_rel_padre) { 
    this.nro_rel_padre =  aNro_rel_padre;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public ValorCompoPresu getValorCompoAtri(int nroCompo) throws BaseException {
	  try {
	  // Obtener la clase
	  Class claseValorCompoPresu = Class.forName(this.getClass().getName());
	  // Obtener el Metodo
	  Class paramTypes[] = null;
	  Method metodo = claseValorCompoPresu.getMethod("getVal_com_"+nroCompo,paramTypes);
	  Object params[] = null;
	  return (ValorCompoPresu) metodo.invoke(this,params);
	  }
	  catch (Exception e) {}
	  return null;
  }
  
  public ValorCompoPresu getVal_com_1() throws BaseException { 
    supportRefresh();
    return val_com_1;
  }

  public void setVal_com_1(ValorCompoPresu aVal_com_1) { 
    this.val_com_1 =  aVal_com_1;
  }

  public ValorCompoPresu getVal_com_2() throws BaseException { 
    supportRefresh();
    return val_com_2;
  }

  public void setVal_com_2(ValorCompoPresu aVal_com_2) { 
    this.val_com_2 =  aVal_com_2;
  }

  public ValorCompoPresu getVal_com_3() throws BaseException { 
    supportRefresh();
    return val_com_3;
  }

  public void setVal_com_3(ValorCompoPresu aVal_com_3) { 
    this.val_com_3 =  aVal_com_3;
  }

  public ValorCompoPresu getVal_com_4() throws BaseException { 
    supportRefresh();
    return val_com_4;
  }

  public void setVal_com_4(ValorCompoPresu aVal_com_4) { 
    this.val_com_4 =  aVal_com_4;
  }

  public ValorCompoPresu getVal_com_5() throws BaseException { 
    supportRefresh();
    return val_com_5;
  }

  public void setVal_com_5(ValorCompoPresu aVal_com_5) { 
    this.val_com_5 =  aVal_com_5;
  }

  public ValorCompoPresu getVal_com_6() throws BaseException { 
    supportRefresh();
    return val_com_6;
  }

  public void setVal_com_6(ValorCompoPresu aVal_com_6) { 
    this.val_com_6 =  aVal_com_6;
  }

  public ValorCompoPresu getVal_com_7() throws BaseException { 
    supportRefresh();
    return val_com_7;
  }

  public void setVal_com_7(ValorCompoPresu aVal_com_7) { 
    this.val_com_7 =  aVal_com_7;
  }

  public ValorCompoPresu getVal_com_8() throws BaseException { 
    supportRefresh();
    return val_com_8;
  }

  public void setVal_com_8(ValorCompoPresu aVal_com_8) { 
    this.val_com_8 =  aVal_com_8;
  }

  public ValorCompoPresu getVal_com_9() throws BaseException { 
    supportRefresh();
    return val_com_9;
  }

  public void setVal_com_9(ValorCompoPresu aVal_com_9) { 
    this.val_com_9 =  aVal_com_9;
  }

  public ValorCompoPresu getVal_com_10() throws BaseException { 
    supportRefresh();
    return val_com_10;
  }

  public void setVal_com_10(ValorCompoPresu aVal_com_10) { 
    this.val_com_10 =  aVal_com_10;
  }

  public ValorCompoPresu getVal_com_11() throws BaseException { 
    supportRefresh();
    return val_com_11;
  }

  public void setVal_com_11(ValorCompoPresu aVal_com_11) { 
    this.val_com_11 =  aVal_com_11;
  }

  public ValorCompoPresu getVal_com_12() throws BaseException { 
    supportRefresh();
    return val_com_12;
  }

  public void setVal_com_12(ValorCompoPresu aVal_com_12) { 
    this.val_com_12 =  aVal_com_12;
  }

  public ValorCompoPresu getVal_com_13() throws BaseException { 
    supportRefresh();
    return val_com_13;
  }

  public void setVal_com_13(ValorCompoPresu aVal_com_13) { 
    this.val_com_13 =  aVal_com_13;
  }

  public ValorCompoPresu getVal_com_14() throws BaseException { 
    supportRefresh();
    return val_com_14;
  }

  public void setVal_com_14(ValorCompoPresu aVal_com_14) { 
    this.val_com_14 =  aVal_com_14;
  }

  public ValorCompoPresu getVal_com_15() throws BaseException { 
    supportRefresh();
    return val_com_15;
  }

  public void setVal_com_15(ValorCompoPresu aVal_com_15) { 
    this.val_com_15 =  aVal_com_15;
  }

  public ValorCompoPresu getVal_com_16() throws BaseException { 
    supportRefresh();
    return val_com_16;
  }

  public void setVal_com_16(ValorCompoPresu aVal_com_16) { 
    this.val_com_16 =  aVal_com_16;
  }

  public ValorCompoPresu getVal_com_17() throws BaseException { 
    supportRefresh();
    return val_com_17;
  }

  public void setVal_com_17(ValorCompoPresu aVal_com_17) { 
    this.val_com_17 =  aVal_com_17;
  }

  public ValorCompoPresu getVal_com_18() throws BaseException { 
    supportRefresh();
    return val_com_18;
  }

  public void setVal_com_18(ValorCompoPresu aVal_com_18) { 
    this.val_com_18 =  aVal_com_18;
  }

  public ValorCompoPresu getVal_com_19() throws BaseException { 
    supportRefresh();
    return val_com_19;
  }

  public void setVal_com_19(ValorCompoPresu aVal_com_19) { 
    this.val_com_19 =  aVal_com_19;
  }

  public ValorCompoPresu getVal_com_20() throws BaseException { 
    supportRefresh();
    return val_com_20;
  }

  public void setVal_com_20(ValorCompoPresu aVal_com_20) { 
    this.val_com_20 =  aVal_com_20;
  }

  public ValorCompoPresu getVal_com_21() throws BaseException { 
    supportRefresh();
    return val_com_21;
  }

  public void setVal_com_21(ValorCompoPresu aVal_com_21) { 
    this.val_com_21 =  aVal_com_21;
  }

  public ValorCompoPresu getVal_com_22() throws BaseException { 
    supportRefresh();
    return val_com_22;
  }

  public void setVal_com_22(ValorCompoPresu aVal_com_22) { 
    this.val_com_22 =  aVal_com_22;
  }

  public ValorCompoPresu getVal_com_23() throws BaseException { 
    supportRefresh();
    return val_com_23;
  }

  public void setVal_com_23(ValorCompoPresu aVal_com_23) { 
    this.val_com_23 =  aVal_com_23;
  }

  public ValorCompoPresu getVal_com_24() throws BaseException { 
    supportRefresh();
    return val_com_24;
  }

  public void setVal_com_24(ValorCompoPresu aVal_com_24) { 
    this.val_com_24 =  aVal_com_24;
  }

  public ValorCompoPresu getVal_com_25() throws BaseException { 
    supportRefresh();
    return val_com_25;
  }

  public void setVal_com_25(ValorCompoPresu aVal_com_25) { 
    this.val_com_25 =  aVal_com_25;
  }

  public ValorCompoPresu getVal_com_26() throws BaseException { 
    supportRefresh();
    return val_com_26;
  }

  public void setVal_com_26(ValorCompoPresu aVal_com_26) { 
    this.val_com_26 =  aVal_com_26;
  }

  public ValorCompoPresu getVal_com_27() throws BaseException { 
    supportRefresh();
    return val_com_27;
  }

  public void setVal_com_27(ValorCompoPresu aVal_com_27) { 
    this.val_com_27 =  aVal_com_27;
  }

  public ValorCompoPresu getVal_com_28() throws BaseException { 
    supportRefresh();
    return val_com_28;
  }

  public void setVal_com_28(ValorCompoPresu aVal_com_28) { 
    this.val_com_28 =  aVal_com_28;
  }

  public ValorCompoPresu getVal_com_29() throws BaseException { 
    supportRefresh();
    return val_com_29;
  }

  public void setVal_com_29(ValorCompoPresu aVal_com_29) { 
    this.val_com_29 =  aVal_com_29;
  }

  public ValorCompoPresu getVal_com_30() throws BaseException { 
    supportRefresh();
    return val_com_30;
  }

  public void setVal_com_30(ValorCompoPresu aVal_com_30) { 
    this.val_com_30 =  aVal_com_30;
  }

  public ValorCompoPresu getVal_com_31() throws BaseException { 
    supportRefresh();
    return val_com_31;
  }

  public void setVal_com_31(ValorCompoPresu aVal_com_31) { 
    this.val_com_31 =  aVal_com_31;
  }

  public ValorCompoPresu getVal_com_32() throws BaseException { 
    supportRefresh();
    return val_com_32;
  }

  public void setVal_com_32(ValorCompoPresu aVal_com_32) { 
    this.val_com_32 =  aVal_com_32;
  }

  public ValorCompoPresu getVal_com_33() throws BaseException { 
    supportRefresh();
    return val_com_33;
  }

  public void setVal_com_33(ValorCompoPresu aVal_com_33) { 
    this.val_com_33 =  aVal_com_33;
  }

  public ValorCompoPresu getVal_com_34() throws BaseException { 
    supportRefresh();
    return val_com_34;
  }

  public void setVal_com_34(ValorCompoPresu aVal_com_34) { 
    this.val_com_34 =  aVal_com_34;
  }

  public ValorCompoPresu getVal_com_35() throws BaseException { 
    supportRefresh();
    return val_com_35;
  }

  public void setVal_com_35(ValorCompoPresu aVal_com_35) { 
    this.val_com_35 =  aVal_com_35;
  }

  public ValorCompoPresu getVal_com_36() throws BaseException { 
    supportRefresh();
    return val_com_36;
  }

  public void setVal_com_36(ValorCompoPresu aVal_com_36) { 
    this.val_com_36 =  aVal_com_36;
  }

  public ValorCompoPresu getVal_com_37() throws BaseException { 
    supportRefresh();
    return val_com_37;
  }

  public void setVal_com_37(ValorCompoPresu aVal_com_37) { 
    this.val_com_37 =  aVal_com_37;
  }

  public ValorCompoPresu getVal_com_38() throws BaseException { 
    supportRefresh();
    return val_com_38;
  }

  public void setVal_com_38(ValorCompoPresu aVal_com_38) { 
    this.val_com_38 =  aVal_com_38;
  }

  public ValorCompoPresu getVal_com_39() throws BaseException { 
    supportRefresh();
    return val_com_39;
  }

  public void setVal_com_39(ValorCompoPresu aVal_com_39) { 
    this.val_com_39 =  aVal_com_39;
  }

  public ValorCompoPresu getVal_com_40() throws BaseException { 
    supportRefresh();
    return val_com_40;
  }

  public void setVal_com_40(ValorCompoPresu aVal_com_40) { 
    this.val_com_40 =  aVal_com_40;
  }

  public ValorCompoPresu getVal_com_41() throws BaseException { 
    supportRefresh();
    return val_com_41;
  }

  public void setVal_com_41(ValorCompoPresu aVal_com_41) { 
    this.val_com_41 =  aVal_com_41;
  }

  public ValorCompoPresu getVal_com_42() throws BaseException { 
    supportRefresh();
    return val_com_42;
  }

  public void setVal_com_42(ValorCompoPresu aVal_com_42) { 
    this.val_com_42 =  aVal_com_42;
  }

  public ValorCompoPresu getVal_com_43() throws BaseException { 
    supportRefresh();
    return val_com_43;
  }

  public void setVal_com_43(ValorCompoPresu aVal_com_43) { 
    this.val_com_43 =  aVal_com_43;
  }

  public ValorCompoPresu getVal_com_44() throws BaseException { 
    supportRefresh();
    return val_com_44;
  }

  public void setVal_com_44(ValorCompoPresu aVal_com_44) { 
    this.val_com_44 =  aVal_com_44;
  }

  public ValorCompoPresu getVal_com_45() throws BaseException { 
    supportRefresh();
    return val_com_45;
  }

  public void setVal_com_45(ValorCompoPresu aVal_com_45) { 
    this.val_com_45 =  aVal_com_45;
  }

  public ValorCompoPresu getVal_com_46() throws BaseException { 
    supportRefresh();
    return val_com_46;
  }

  public void setVal_com_46(ValorCompoPresu aVal_com_46) { 
    this.val_com_46 =  aVal_com_46;
  }

  public ValorCompoPresu getVal_com_47() throws BaseException { 
    supportRefresh();
    return val_com_47;
  }

  public void setVal_com_47(ValorCompoPresu aVal_com_47) { 
    this.val_com_47 =  aVal_com_47;
  }

  public ValorCompoPresu getVal_com_48() throws BaseException { 
    supportRefresh();
    return val_com_48;
  }

  public void setVal_com_48(ValorCompoPresu aVal_com_48) { 
    this.val_com_48 =  aVal_com_48;
  }

  public ValorCompoPresu getVal_com_49() throws BaseException { 
    supportRefresh();
    return val_com_49;
  }

  public void setVal_com_49(ValorCompoPresu aVal_com_49) { 
    this.val_com_49 =  aVal_com_49;
  }

  public ValorCompoPresu getVal_com_50() throws BaseException { 
    supportRefresh();
    return val_com_50;
  }

  public void setVal_com_50(ValorCompoPresu aVal_com_50) { 
    this.val_com_50 =  aVal_com_50;
  }

  public ValorCompoPresu getVal_com_51() throws BaseException { 
    supportRefresh();
    return val_com_51;
  }

  public void setVal_com_51(ValorCompoPresu aVal_com_51) { 
    this.val_com_51 =  aVal_com_51;
  }

  public ValorCompoPresu getVal_com_52() throws BaseException { 
    supportRefresh();
    return val_com_52;
  }

  public void setVal_com_52(ValorCompoPresu aVal_com_52) { 
    this.val_com_52 =  aVal_com_52;
  }

  public ValorCompoPresu getVal_com_53() throws BaseException { 
    supportRefresh();
    return val_com_53;
  }

  public void setVal_com_53(ValorCompoPresu aVal_com_53) { 
    this.val_com_53 =  aVal_com_53;
  }

  public ValorCompoPresu getVal_com_54() throws BaseException { 
    supportRefresh();
    return val_com_54;
  }

  public void setVal_com_54(ValorCompoPresu aVal_com_54) { 
    this.val_com_54 =  aVal_com_54;
  }

  public ValorCompoPresu getVal_com_55() throws BaseException { 
    supportRefresh();
    return val_com_55;
  }

  public void setVal_com_55(ValorCompoPresu aVal_com_55) { 
    this.val_com_55 =  aVal_com_55;
  }

  public ValorCompoPresu getVal_com_56() throws BaseException { 
    supportRefresh();
    return val_com_56;
  }

  public void setVal_com_56(ValorCompoPresu aVal_com_56) { 
    this.val_com_56 =  aVal_com_56;
  }

  public ValorCompoPresu getVal_com_57() throws BaseException { 
    supportRefresh();
    return val_com_57;
  }

  public void setVal_com_57(ValorCompoPresu aVal_com_57) { 
    this.val_com_57 =  aVal_com_57;
  }

  public ValorCompoPresu getVal_com_58() throws BaseException { 
    supportRefresh();
    return val_com_58;
  }

  public void setVal_com_58(ValorCompoPresu aVal_com_58) { 
    this.val_com_58 =  aVal_com_58;
  }

  public ValorCompoPresu getVal_com_59() throws BaseException { 
    supportRefresh();
    return val_com_59;
  }

  public void setVal_com_59(ValorCompoPresu aVal_com_59) { 
    this.val_com_59 =  aVal_com_59;
  }

  public ValorCompoPresu getVal_com_60() throws BaseException { 
    supportRefresh();
    return val_com_60;
  }

  public void setVal_com_60(ValorCompoPresu aVal_com_60) { 
    this.val_com_60 =  aVal_com_60;
  }

  public ValorCompoPresu getVal_com_61() throws BaseException { 
    supportRefresh();
    return val_com_61;
  }

  public void setVal_com_61(ValorCompoPresu aVal_com_61) { 
    this.val_com_61 =  aVal_com_61;
  }

  public ValorCompoPresu getVal_com_62() throws BaseException { 
    supportRefresh();
    return val_com_62;
  }

  public void setVal_com_62(ValorCompoPresu aVal_com_62) { 
    this.val_com_62 =  aVal_com_62;
  }

  public ValorCompoPresu getVal_com_63() throws BaseException { 
    supportRefresh();
    return val_com_63;
  }

  public void setVal_com_63(ValorCompoPresu aVal_com_63) { 
    this.val_com_63 =  aVal_com_63;
  }

  public ValorCompoPresu getVal_com_64() throws BaseException { 
    supportRefresh();
    return val_com_64;
  }

  public void setVal_com_64(ValorCompoPresu aVal_com_64) { 
    this.val_com_64 =  aVal_com_64;
  }

  public ValorCompoPresu getVal_com_65() throws BaseException { 
    supportRefresh();
    return val_com_65;
  }

  public void setVal_com_65(ValorCompoPresu aVal_com_65) { 
    this.val_com_65 =  aVal_com_65;
  }

  public ValorCompoPresu getVal_com_66() throws BaseException { 
    supportRefresh();
    return val_com_66;
  }

  public void setVal_com_66(ValorCompoPresu aVal_com_66) { 
    this.val_com_66 =  aVal_com_66;
  }

  public ValorCompoPresu getVal_com_67() throws BaseException { 
    supportRefresh();
    return val_com_67;
  }

  public void setVal_com_67(ValorCompoPresu aVal_com_67) { 
    this.val_com_67 =  aVal_com_67;
  }

  public ValorCompoPresu getVal_com_68() throws BaseException { 
    supportRefresh();
    return val_com_68;
  }

  public void setVal_com_68(ValorCompoPresu aVal_com_68) { 
    this.val_com_68 =  aVal_com_68;
  }

  public ValorCompoPresu getVal_com_69() throws BaseException { 
    supportRefresh();
    return val_com_69;
  }

  public void setVal_com_69(ValorCompoPresu aVal_com_69) { 
    this.val_com_69 =  aVal_com_69;
  }

  public ValorCompoPresu getVal_com_70() throws BaseException { 
    supportRefresh();
    return val_com_70;
  }

  public void setVal_com_70(ValorCompoPresu aVal_com_70) { 
    this.val_com_70 =  aVal_com_70;
  }

  public ValorCompoPresu getVal_com_71() throws BaseException { 
    supportRefresh();
    return val_com_71;
  }

  public void setVal_com_71(ValorCompoPresu aVal_com_71) { 
    this.val_com_71 =  aVal_com_71;
  }

  public ValorCompoPresu getVal_com_72() throws BaseException { 
    supportRefresh();
    return val_com_72;
  }

  public void setVal_com_72(ValorCompoPresu aVal_com_72) { 
    this.val_com_72 =  aVal_com_72;
  }

  public ValorCompoPresu getVal_com_73() throws BaseException { 
    supportRefresh();
    return val_com_73;
  }

  public void setVal_com_73(ValorCompoPresu aVal_com_73) { 
    this.val_com_73 =  aVal_com_73;
  }

  public ValorCompoPresu getVal_com_74() throws BaseException { 
    supportRefresh();
    return val_com_74;
  }

  public void setVal_com_74(ValorCompoPresu aVal_com_74) { 
    this.val_com_74 =  aVal_com_74;
  }

  public ValorCompoPresu getVal_com_75() throws BaseException { 
    supportRefresh();
    return val_com_75;
  }

  public void setVal_com_75(ValorCompoPresu aVal_com_75) { 
    this.val_com_75 =  aVal_com_75;
  }

  public ValorCompoPresu getVal_com_76() throws BaseException { 
    supportRefresh();
    return val_com_76;
  }

  public void setVal_com_76(ValorCompoPresu aVal_com_76) { 
    this.val_com_76 =  aVal_com_76;
  }

  public ValorCompoPresu getVal_com_77() throws BaseException { 
    supportRefresh();
    return val_com_77;
  }

  public void setVal_com_77(ValorCompoPresu aVal_com_77) { 
    this.val_com_77 =  aVal_com_77;
  }

  public ValorCompoPresu getVal_com_78() throws BaseException { 
    supportRefresh();
    return val_com_78;
  }

  public void setVal_com_78(ValorCompoPresu aVal_com_78) { 
    this.val_com_78 =  aVal_com_78;
  }

  public ValorCompoPresu getVal_com_79() throws BaseException { 
    supportRefresh();
    return val_com_79;
  }

  public void setVal_com_79(ValorCompoPresu aVal_com_79) { 
    this.val_com_79 =  aVal_com_79;
  }

  public ValorCompoPresu getVal_com_80() throws BaseException { 
    supportRefresh();
    return val_com_80;
  }

  public void setVal_com_80(ValorCompoPresu aVal_com_80) { 
    this.val_com_80 =  aVal_com_80;
  }

  public Double getVal_num_1() throws BaseException { 
    supportRefresh();
    return val_num_1;
  }

  public void setVal_num_1(Double aVal_num_1) { 
    this.val_num_1 =  aVal_num_1;
  }

  public Double getVal_num_2() throws BaseException { 
    supportRefresh();
    return val_num_2;
  }

  public void setVal_num_2(Double aVal_num_2) { 
    this.val_num_2 =  aVal_num_2;
  }

  public Double getVal_num_3() throws BaseException { 
    supportRefresh();
    return val_num_3;
  }

  public void setVal_num_3(Double aVal_num_3) { 
    this.val_num_3 =  aVal_num_3;
  }

  public Double getVal_num_4() throws BaseException { 
    supportRefresh();
    return val_num_4;
  }

  public void setVal_num_4(Double aVal_num_4) { 
    this.val_num_4 =  aVal_num_4;
  }

  public Double getVal_num_5() throws BaseException { 
    supportRefresh();
    return val_num_5;
  }

  public void setVal_num_5(Double aVal_num_5) { 
    this.val_num_5 =  aVal_num_5;
  }

  public Double getVal_num_6() throws BaseException { 
    supportRefresh();
    return val_num_6;
  }

  public void setVal_num_6(Double aVal_num_6) { 
    this.val_num_6 =  aVal_num_6;
  }

  public Double getVal_num_7() throws BaseException { 
    supportRefresh();
    return val_num_7;
  }

  public void setVal_num_7(Double aVal_num_7) { 
    this.val_num_7 =  aVal_num_7;
  }

  public Double getVal_num_8() throws BaseException { 
    supportRefresh();
    return val_num_8;
  }

  public void setVal_num_8(Double aVal_num_8) { 
    this.val_num_8 =  aVal_num_8;
  }

  public Double getVal_num_9() throws BaseException { 
    supportRefresh();
    return val_num_9;
  }

  public void setVal_num_9(Double aVal_num_9) { 
    this.val_num_9 =  aVal_num_9;
  }

  public Double getVal_num_10() throws BaseException { 
    supportRefresh();
    return val_num_10;
  }

  public void setVal_num_10(Double aVal_num_10) { 
    this.val_num_10 =  aVal_num_10;
  }

  public Double getVal_num_11() throws BaseException { 
    supportRefresh();
    return val_num_11;
  }

  public void setVal_num_11(Double aVal_num_11) { 
    this.val_num_11 =  aVal_num_11;
  }

  public Double getVal_num_12() throws BaseException { 
    supportRefresh();
    return val_num_12;
  }

  public void setVal_num_12(Double aVal_num_12) { 
    this.val_num_12 =  aVal_num_12;
  }

  public Double getVal_num_13() throws BaseException { 
    supportRefresh();
    return val_num_13;
  }

  public void setVal_num_13(Double aVal_num_13) { 
    this.val_num_13 =  aVal_num_13;
  }

  public Double getVal_num_14() throws BaseException { 
    supportRefresh();
    return val_num_14;
  }

  public void setVal_num_14(Double aVal_num_14) { 
    this.val_num_14 =  aVal_num_14;
  }

  public Double getVal_num_15() throws BaseException { 
    supportRefresh();
    return val_num_15;
  }

  public void setVal_num_15(Double aVal_num_15) { 
    this.val_num_15 =  aVal_num_15;
  }

  public Double getVal_num_16() throws BaseException { 
    supportRefresh();
    return val_num_16;
  }

  public void setVal_num_16(Double aVal_num_16) { 
    this.val_num_16 =  aVal_num_16;
  }

  public Double getVal_num_17() throws BaseException { 
    supportRefresh();
    return val_num_17;
  }

  public void setVal_num_17(Double aVal_num_17) { 
    this.val_num_17 =  aVal_num_17;
  }

  public Double getVal_num_18() throws BaseException { 
    supportRefresh();
    return val_num_18;
  }

  public void setVal_num_18(Double aVal_num_18) { 
    this.val_num_18 =  aVal_num_18;
  }

  public Double getVal_num_19() throws BaseException { 
    supportRefresh();
    return val_num_19;
  }

  public void setVal_num_19(Double aVal_num_19) { 
    this.val_num_19 =  aVal_num_19;
  }

  public Double getVal_num_20() throws BaseException { 
    supportRefresh();
    return val_num_20;
  }

  public void setVal_num_20(Double aVal_num_20) { 
    this.val_num_20 =  aVal_num_20;
  }

  public Double getVal_num_21() throws BaseException { 
    supportRefresh();
    return val_num_21;
  }

  public void setVal_num_21(Double aVal_num_21) { 
    this.val_num_21 =  aVal_num_21;
  }

  public Double getVal_num_22() throws BaseException { 
    supportRefresh();
    return val_num_22;
  }

  public void setVal_num_22(Double aVal_num_22) { 
    this.val_num_22 =  aVal_num_22;
  }

  public Double getVal_num_23() throws BaseException { 
    supportRefresh();
    return val_num_23;
  }

  public void setVal_num_23(Double aVal_num_23) { 
    this.val_num_23 =  aVal_num_23;
  }

  public Double getVal_num_24() throws BaseException { 
    supportRefresh();
    return val_num_24;
  }

  public void setVal_num_24(Double aVal_num_24) { 
    this.val_num_24 =  aVal_num_24;
  }

  public Double getVal_num_25() throws BaseException { 
    supportRefresh();
    return val_num_25;
  }

  public void setVal_num_25(Double aVal_num_25) { 
    this.val_num_25 =  aVal_num_25;
  }

  public Double getVal_num_26() throws BaseException { 
    supportRefresh();
    return val_num_26;
  }

  public void setVal_num_26(Double aVal_num_26) { 
    this.val_num_26 =  aVal_num_26;
  }

  public Double getVal_num_27() throws BaseException { 
    supportRefresh();
    return val_num_27;
  }

  public void setVal_num_27(Double aVal_num_27) { 
    this.val_num_27 =  aVal_num_27;
  }

  public Double getVal_num_28() throws BaseException { 
    supportRefresh();
    return val_num_28;
  }

  public void setVal_num_28(Double aVal_num_28) { 
    this.val_num_28 =  aVal_num_28;
  }

  public Double getVal_num_29() throws BaseException { 
    supportRefresh();
    return val_num_29;
  }

  public void setVal_num_29(Double aVal_num_29) { 
    this.val_num_29 =  aVal_num_29;
  }

  public Double getVal_num_30() throws BaseException { 
    supportRefresh();
    return val_num_30;
  }

  public void setVal_num_30(Double aVal_num_30) { 
    this.val_num_30 =  aVal_num_30;
  }

  public String getVal_tex_1() throws BaseException { 
    supportRefresh();
    return val_tex_1;
  }

  public void setVal_tex_1(String aVal_tex_1) { 
    this.val_tex_1 =  aVal_tex_1;
  }

  public String getVal_tex_2() throws BaseException { 
    supportRefresh();
    return val_tex_2;
  }

  public void setVal_tex_2(String aVal_tex_2) { 
    this.val_tex_2 =  aVal_tex_2;
  }

  public String getVal_tex_3() throws BaseException { 
    supportRefresh();
    return val_tex_3;
  }

  public void setVal_tex_3(String aVal_tex_3) { 
    this.val_tex_3 =  aVal_tex_3;
  }

  public String getVal_tex_4() throws BaseException { 
    supportRefresh();
    return val_tex_4;
  }

  public void setVal_tex_4(String aVal_tex_4) { 
    this.val_tex_4 =  aVal_tex_4;
  }

  public String getVal_tex_5() throws BaseException { 
    supportRefresh();
    return val_tex_5;
  }

  public void setVal_tex_5(String aVal_tex_5) { 
    this.val_tex_5 =  aVal_tex_5;
  }

  public String getVal_tex_6() throws BaseException { 
    supportRefresh();
    return val_tex_6;
  }

  public void setVal_tex_6(String aVal_tex_6) { 
    this.val_tex_6 =  aVal_tex_6;
  }

  public String getVal_tex_7() throws BaseException { 
    supportRefresh();
    return val_tex_7;
  }

  public void setVal_tex_7(String aVal_tex_7) { 
    this.val_tex_7 =  aVal_tex_7;
  }

  public String getVal_tex_8() throws BaseException { 
    supportRefresh();
    return val_tex_8;
  }

  public void setVal_tex_8(String aVal_tex_8) { 
    this.val_tex_8 =  aVal_tex_8;
  }

  public String getVal_tex_9() throws BaseException { 
    supportRefresh();
    return val_tex_9;
  }

  public void setVal_tex_9(String aVal_tex_9) { 
    this.val_tex_9 =  aVal_tex_9;
  }

  public String getVal_tex_10() throws BaseException { 
    supportRefresh();
    return val_tex_10;
  }

  public void setVal_tex_10(String aVal_tex_10) { 
    this.val_tex_10 =  aVal_tex_10;
  }

  public String getVal_tex_11() throws BaseException { 
    supportRefresh();
    return val_tex_11;
  }

  public void setVal_tex_11(String aVal_tex_11) { 
    this.val_tex_11 =  aVal_tex_11;
  }

  public String getVal_tex_12() throws BaseException { 
    supportRefresh();
    return val_tex_12;
  }

  public void setVal_tex_12(String aVal_tex_12) { 
    this.val_tex_12 =  aVal_tex_12;
  }

  public String getVal_tex_13() throws BaseException { 
    supportRefresh();
    return val_tex_13;
  }

  public void setVal_tex_13(String aVal_tex_13) { 
    this.val_tex_13 =  aVal_tex_13;
  }

  public String getVal_tex_14() throws BaseException { 
    supportRefresh();
    return val_tex_14;
  }

  public void setVal_tex_14(String aVal_tex_14) { 
    this.val_tex_14 =  aVal_tex_14;
  }

  public String getVal_tex_15() throws BaseException { 
    supportRefresh();
    return val_tex_15;
  }

  public void setVal_tex_15(String aVal_tex_15) { 
    this.val_tex_15 =  aVal_tex_15;
  }

  public String getVal_tex_16() throws BaseException { 
    supportRefresh();
    return val_tex_16;
  }

  public void setVal_tex_16(String aVal_tex_16) { 
    this.val_tex_16 =  aVal_tex_16;
  }

  public String getVal_tex_17() throws BaseException { 
    supportRefresh();
    return val_tex_17;
  }

  public void setVal_tex_17(String aVal_tex_17) { 
    this.val_tex_17 =  aVal_tex_17;
  }

  public String getVal_tex_18() throws BaseException { 
    supportRefresh();
    return val_tex_18;
  }

  public void setVal_tex_18(String aVal_tex_18) { 
    this.val_tex_18 =  aVal_tex_18;
  }

  public String getVal_tex_19() throws BaseException { 
    supportRefresh();
    return val_tex_19;
  }

  public void setVal_tex_19(String aVal_tex_19) { 
    this.val_tex_19 =  aVal_tex_19;
  }

  public String getVal_tex_20() throws BaseException { 
    supportRefresh();
    return val_tex_20;
  }

  public void setVal_tex_20(String aVal_tex_20) { 
    this.val_tex_20 =  aVal_tex_20;
  }

  public java.util.Date getVal_fec_1() throws BaseException { 
    supportRefresh();
    return val_fec_1;
  }

  public void setVal_fec_1(java.util.Date aVal_fec_1) { 
    this.val_fec_1 =  aVal_fec_1;
  }

  public java.util.Date getVal_fec_2() throws BaseException { 
    supportRefresh();
    return val_fec_2;
  }

  public void setVal_fec_2(java.util.Date aVal_fec_2) { 
    this.val_fec_2 =  aVal_fec_2;
  }

  public java.util.Date getVal_fec_3() throws BaseException { 
    supportRefresh();
    return val_fec_3;
  }

  public void setVal_fec_3(java.util.Date aVal_fec_3) { 
    this.val_fec_3 =  aVal_fec_3;
  }

  public java.util.Date getVal_fec_4() throws BaseException { 
    supportRefresh();
    return val_fec_4;
  }

  public void setVal_fec_4(java.util.Date aVal_fec_4) { 
    this.val_fec_4 =  aVal_fec_4;
  }

  public java.util.Date getVal_fec_5() throws BaseException { 
    supportRefresh();
    return val_fec_5;
  }

  public void setVal_fec_5(java.util.Date aVal_fec_5) { 
    this.val_fec_5 =  aVal_fec_5;
  }

  public java.util.Date getVal_fec_6() throws BaseException { 
    supportRefresh();
    return val_fec_6;
  }

  public void setVal_fec_6(java.util.Date aVal_fec_6) { 
    this.val_fec_6 =  aVal_fec_6;
  }

  public java.util.Date getVal_fec_7() throws BaseException { 
    supportRefresh();
    return val_fec_7;
  }

  public void setVal_fec_7(java.util.Date aVal_fec_7) { 
    this.val_fec_7 =  aVal_fec_7;
  }

  public java.util.Date getVal_fec_8() throws BaseException { 
    supportRefresh();
    return val_fec_8;
  }

  public void setVal_fec_8(java.util.Date aVal_fec_8) { 
    this.val_fec_8 =  aVal_fec_8;
  }

  public java.util.Date getVal_fec_9() throws BaseException { 
    supportRefresh();
    return val_fec_9;
  }

  public void setVal_fec_9(java.util.Date aVal_fec_9) { 
    this.val_fec_9 =  aVal_fec_9;
  }

  public java.util.Date getVal_fec_10() throws BaseException { 
    supportRefresh();
    return val_fec_10;
  }

  public void setVal_fec_10(java.util.Date aVal_fec_10) { 
    this.val_fec_10 =  aVal_fec_10;
  }

  public java.util.Date getVal_fec_11() throws BaseException { 
    supportRefresh();
    return val_fec_11;
  }

  public void setVal_fec_11(java.util.Date aVal_fec_11) { 
    this.val_fec_11 =  aVal_fec_11;
  }

  public java.util.Date getVal_fec_12() throws BaseException { 
    supportRefresh();
    return val_fec_12;
  }

  public void setVal_fec_12(java.util.Date aVal_fec_12) { 
    this.val_fec_12 =  aVal_fec_12;
  }

  public java.util.Date getVal_fec_13() throws BaseException { 
    supportRefresh();
    return val_fec_13;
  }

  public void setVal_fec_13(java.util.Date aVal_fec_13) { 
    this.val_fec_13 =  aVal_fec_13;
  }

  public java.util.Date getVal_fec_14() throws BaseException { 
    supportRefresh();
    return val_fec_14;
  }

  public void setVal_fec_14(java.util.Date aVal_fec_14) { 
    this.val_fec_14 =  aVal_fec_14;
  }

  public java.util.Date getVal_fec_15() throws BaseException { 
    supportRefresh();
    return val_fec_15;
  }

  public void setVal_fec_15(java.util.Date aVal_fec_15) { 
    this.val_fec_15 =  aVal_fec_15;
  }

  public java.util.Date getVal_fec_16() throws BaseException { 
    supportRefresh();
    return val_fec_16;
  }

  public void setVal_fec_16(java.util.Date aVal_fec_16) { 
    this.val_fec_16 =  aVal_fec_16;
  }

  public java.util.Date getVal_fec_17() throws BaseException { 
    supportRefresh();
    return val_fec_17;
  }

  public void setVal_fec_17(java.util.Date aVal_fec_17) { 
    this.val_fec_17 =  aVal_fec_17;
  }

  public java.util.Date getVal_fec_18() throws BaseException { 
    supportRefresh();
    return val_fec_18;
  }

  public void setVal_fec_18(java.util.Date aVal_fec_18) { 
    this.val_fec_18 =  aVal_fec_18;
  }

  public java.util.Date getVal_fec_19() throws BaseException { 
    supportRefresh();
    return val_fec_19;
  }

  public void setVal_fec_19(java.util.Date aVal_fec_19) { 
    this.val_fec_19 =  aVal_fec_19;
  }

  public java.util.Date getVal_fec_20() throws BaseException { 
    supportRefresh();
    return val_fec_20;
  }

  public void setVal_fec_20(java.util.Date aVal_fec_20) { 
    this.val_fec_20 =  aVal_fec_20;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ValorCompoPresu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorCompoPresu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ValorCompoPresu findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorCompoPresu) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 public static ValorCompoPresu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValorCompoPresu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(nro_rel, "Debe ingresar el Nro. de relación");
    Validar.noNulo(nro_rel_padre, "Debe ingresar el Nro. de relación padre");
    Validar.noNulo(activo, "Debe ingresar si esta o no activo");
 }
 
 public static List getValoresCompoPresu(CompoPresupuestario compoPresu, ISesion aSesion) throws BaseException {
	 
		return DBValorCompoPresu.getValoresCompoPresu(compoPresu,aSesion);
 }
 
 public static List getValoresCompoPresu(CompoPresupuestario compoPresu,
		 																		 List listaValCompoPresu,
		                                     ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CompoPresupuestario.NICKNAME,compoPresu);
	  condiciones.put("LISTA_VAL_COMPO_PRESU",listaValCompoPresu);
	 
		return DBValorCompoPresu.getValoresCompoPresuByValCompoAnt(condiciones,aSesion);
 }
 
 
 
 
 public static ValorCompoPresu getValorBycodigo(CompoPresupuestario compoPresu,
		 String codigo,				
		 ISesion aSesion)
 throws BaseException {
	 return DBValorCompoPresu.getValorBycodigo(compoPresu,codigo,aSesion);
 }
 
 
 
 public static String getNombreTablaValorCompo() {
	 return "plValCompo";
 }
 
 public static String getNombreCampoOidValorCompo() {
	 return DBValorCompoPresu.OID_VALOR_COMPO;
 }
 
 public static String getNombreCampoOidCompoPresu() {
	 return DBValorCompoPresu.OID_COMPO_PRESU;
 }
 

}
