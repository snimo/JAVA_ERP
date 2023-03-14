package com.srn.erp.presupuesto.bm;

import com.srn.erp.presupuesto.da.DBValorEquivalenciaRepositorio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ValorEquivalenciaRepositorio extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ValorEquivalenciaRepositorio() { 
  }

  public static String NICKNAME = "pl.ValorEquivalenciaRepositorio";

  private ValorRealRepositorio valRealRepo;
  private RepositorioReal repositorio_real;
  private ValorCompoPresu valor_compo_presu1;
  private ValorCompoPresu valor_compo_presu2;
  private ValorCompoPresu valor_compo_presu3;
  private ValorCompoPresu valor_compo_presu4;
  private ValorCompoPresu valor_compo_presu5;
  private ValorCompoPresu valor_compo_presu6;
  private ValorCompoPresu valor_compo_presu7;
  private ValorCompoPresu valor_compo_presu8;
  private ValorCompoPresu valor_compo_presu9;
  private ValorCompoPresu valor_compo_presu10;
  private ValorCompoPresu valor_compo_presu11;
  private ValorCompoPresu valor_compo_presu12;
  private ValorCompoPresu valor_compo_presu13;
  private ValorCompoPresu valor_compo_presu14;
  private ValorCompoPresu valor_compo_presu15;
  private ValorCompoPresu valor_compo_presu16;
  private ValorCompoPresu valor_compo_presu17;
  private ValorCompoPresu valor_compo_presu18;
  private ValorCompoPresu valor_compo_presu19;
  private ValorCompoPresu valor_compo_presu20;
  private ValorCompoPresu valor_compo_presu21;
  private ValorCompoPresu valor_compo_presu22;
  private ValorCompoPresu valor_compo_presu23;
  private ValorCompoPresu valor_compo_presu24;
  private ValorCompoPresu valor_compo_presu25;
  private ValorCompoPresu valor_compo_presu26;
  private ValorCompoPresu valor_compo_presu27;
  private ValorCompoPresu valor_compo_presu28;
  private ValorCompoPresu valor_compo_presu29;
  private ValorCompoPresu valor_compo_presu30;
  private ValorCompoPresu valor_compo_presu31;
  private ValorCompoPresu valor_compo_presu32;
  private ValorCompoPresu valor_compo_presu33;
  private ValorCompoPresu valor_compo_presu34;
  private ValorCompoPresu valor_compo_presu35;
  private ValorCompoPresu valor_compo_presu36;
  private ValorCompoPresu valor_compo_presu37;
  private ValorCompoPresu valor_compo_presu38;
  private ValorCompoPresu valor_compo_presu39;
  private ValorCompoPresu valor_compo_presu40;
  private ValorCompoPresu valor_compo_presu41;
  private ValorCompoPresu valor_compo_presu42;
  private ValorCompoPresu valor_compo_presu43;
  private ValorCompoPresu valor_compo_presu44;
  private ValorCompoPresu valor_compo_presu45;
  private ValorCompoPresu valor_compo_presu46;
  private ValorCompoPresu valor_compo_presu47;
  private ValorCompoPresu valor_compo_presu48;
  private ValorCompoPresu valor_compo_presu49;
  private ValorCompoPresu valor_compo_presu50;
  private ValorCompoPresu valor_compo_presu51;
  private ValorCompoPresu valor_compo_presu52;
  private ValorCompoPresu valor_compo_presu53;
  private ValorCompoPresu valor_compo_presu54;
  private ValorCompoPresu valor_compo_presu55;
  private ValorCompoPresu valor_compo_presu56;
  private ValorCompoPresu valor_compo_presu57;
  private ValorCompoPresu valor_compo_presu58;
  private ValorCompoPresu valor_compo_presu59;
  private ValorCompoPresu valor_compo_presu60;
  private ValorCompoPresu valor_compo_presu61;
  private ValorCompoPresu valor_compo_presu62;
  private ValorCompoPresu valor_compo_presu63;
  private ValorCompoPresu valor_compo_presu64;
  private ValorCompoPresu valor_compo_presu65;
  private ValorCompoPresu valor_compo_presu66;
  private ValorCompoPresu valor_compo_presu67;
  private ValorCompoPresu valor_compo_presu68;
  private ValorCompoPresu valor_compo_presu69;
  private ValorCompoPresu valor_compo_presu70;
  private ValorCompoPresu valor_compo_presu71;
  private ValorCompoPresu valor_compo_presu72;
  private ValorCompoPresu valor_compo_presu73;
  private ValorCompoPresu valor_compo_presu74;
  private ValorCompoPresu valor_compo_presu75;
  private ValorCompoPresu valor_compo_presu76;
  private ValorCompoPresu valor_compo_presu77;
  private ValorCompoPresu valor_compo_presu78;
  private ValorCompoPresu valor_compo_presu79;
  private ValorCompoPresu valor_compo_presu80;
  private ValorCompoPresu valor_compo_presu81;
  private ValorCompoPresu valor_compo_presu82;
  private ValorCompoPresu valor_compo_presu83;
  private ValorCompoPresu valor_compo_presu84;
  private ValorCompoPresu valor_compo_presu85;
  private ValorCompoPresu valor_compo_presu86;
  private ValorCompoPresu valor_compo_presu87;
  private ValorCompoPresu valor_compo_presu88;
  private ValorCompoPresu valor_compo_presu89;
  private ValorCompoPresu valor_compo_presu90;
  private ValorCompoPresu valor_compo_presu91;
  private ValorCompoPresu valor_compo_presu92;
  private ValorCompoPresu valor_compo_presu93;
  private ValorCompoPresu valor_compo_presu94;
  private ValorCompoPresu valor_compo_presu95;
  private ValorCompoPresu valor_compo_presu96;
  private ValorCompoPresu valor_compo_presu97;
  private ValorCompoPresu valor_compo_presu98;
  private ValorCompoPresu valor_compo_presu99;
  private ValorCompoPresu valor_compo_presu100;
  private Double val_metrica_1;
  private Double val_metrica_2;
  private Double val_metrica_3;
  private Double val_metrica_4;
  private Double val_metrica_5;
  private Double val_metrica_6;
  private Double val_metrica_7;
  private Double val_metrica_8;
  private Double val_metrica_9;
  private Double val_metrica_10;
  private Double val_metrica_11;
  private Double val_metrica_12;
  private Double val_metrica_13;
  private Double val_metrica_14;
  private Double val_metrica_15;
  private Double val_metrica_16;
  private Double val_metrica_17;
  private Double val_metrica_18;
  private Double val_metrica_19;
  private Double val_metrica_20;
  private Double val_metrica_21;
  private Double val_metrica_22;
  private Double val_metrica_23;
  private Double val_metrica_24;
  private Double val_metrica_25;
  private Double val_metrica_26;
  private Double val_metrica_27;
  private Double val_metrica_28;
  private Double val_metrica_29;
  private Double val_metrica_30;
  private Double val_metrica_31;
  private Double val_metrica_32;
  private Double val_metrica_33;
  private Double val_metrica_34;
  private Double val_metrica_35;
  private Double val_metrica_36;
  private Double val_metrica_37;
  private Double val_metrica_38;
  private Double val_metrica_39;
  private Double val_metrica_40;
  private Double val_metrica_41;
  private Double val_metrica_42;
  private Double val_metrica_43;
  private Double val_metrica_44;
  private Double val_metrica_45;
  private Double val_metrica_46;
  private Double val_metrica_47;
  private Double val_metrica_48;
  private Double val_metrica_49;
  private Double val_metrica_50;
  private PeriodoPresupuestario periodo1;
  private PeriodoPresupuestario periodo2;
  private PeriodoPresupuestario periodo3;
  private PeriodoPresupuestario periodo4;
  private PeriodoPresupuestario periodo5;
  private PeriodoPresupuestario periodo6;
  private PeriodoPresupuestario periodo7;
  private PeriodoPresupuestario periodo8;
  private PeriodoPresupuestario periodo9;
  private PeriodoPresupuestario periodo10;
  private PeriodoPresupuestario periodo11;
  private PeriodoPresupuestario periodo12;
  private PeriodoPresupuestario periodo13;
  private PeriodoPresupuestario periodo14;
  private PeriodoPresupuestario periodo15;
  private PeriodoPresupuestario periodo16;
  private PeriodoPresupuestario periodo17;
  private PeriodoPresupuestario periodo18;
  private PeriodoPresupuestario periodo19;
  private PeriodoPresupuestario periodo20;
  private Boolean activo;

  public RepositorioReal getRepositorio_real() throws BaseException { 
    supportRefresh();
    return repositorio_real;
  }

  public void setRepositorio_real(RepositorioReal aRepositorio_real) { 
    this.repositorio_real =  aRepositorio_real;
  }
  
  public ValorRealRepositorio getValorRealRepositorio() throws BaseException { 
    supportRefresh();
    return this.valRealRepo;
  }

  public void setValorRealRepositorio(ValorRealRepositorio aValorRealRepositorio) { 
    this.valRealRepo =  aValorRealRepositorio;
  }
  

  public ValorCompoPresu getValor_compo_presu1() throws BaseException { 
    supportRefresh();
    return valor_compo_presu1;
  }

  public void setValor_compo_presu1(ValorCompoPresu aValor_compo_presu1) { 
    this.valor_compo_presu1 =  aValor_compo_presu1;
  }

  public ValorCompoPresu getValor_compo_presu2() throws BaseException { 
    supportRefresh();
    return valor_compo_presu2;
  }

  public void setValor_compo_presu2(ValorCompoPresu aValor_compo_presu2) { 
    this.valor_compo_presu2 =  aValor_compo_presu2;
  }

  public ValorCompoPresu getValor_compo_presu3() throws BaseException { 
    supportRefresh();
    return valor_compo_presu3;
  }

  public void setValor_compo_presu3(ValorCompoPresu aValor_compo_presu3) { 
    this.valor_compo_presu3 =  aValor_compo_presu3;
  }

  public ValorCompoPresu getValor_compo_presu4() throws BaseException { 
    supportRefresh();
    return valor_compo_presu4;
  }

  public void setValor_compo_presu4(ValorCompoPresu aValor_compo_presu4) { 
    this.valor_compo_presu4 =  aValor_compo_presu4;
  }

  public ValorCompoPresu getValor_compo_presu5() throws BaseException { 
    supportRefresh();
    return valor_compo_presu5;
  }

  public void setValor_compo_presu5(ValorCompoPresu aValor_compo_presu5) { 
    this.valor_compo_presu5 =  aValor_compo_presu5;
  }

  public ValorCompoPresu getValor_compo_presu6() throws BaseException { 
    supportRefresh();
    return valor_compo_presu6;
  }

  public void setValor_compo_presu6(ValorCompoPresu aValor_compo_presu6) { 
    this.valor_compo_presu6 =  aValor_compo_presu6;
  }

  public ValorCompoPresu getValor_compo_presu7() throws BaseException { 
    supportRefresh();
    return valor_compo_presu7;
  }

  public void setValor_compo_presu7(ValorCompoPresu aValor_compo_presu7) { 
    this.valor_compo_presu7 =  aValor_compo_presu7;
  }

  public ValorCompoPresu getValor_compo_presu8() throws BaseException { 
    supportRefresh();
    return valor_compo_presu8;
  }

  public void setValor_compo_presu8(ValorCompoPresu aValor_compo_presu8) { 
    this.valor_compo_presu8 =  aValor_compo_presu8;
  }

  public ValorCompoPresu getValor_compo_presu9() throws BaseException { 
    supportRefresh();
    return valor_compo_presu9;
  }

  public void setValor_compo_presu9(ValorCompoPresu aValor_compo_presu9) { 
    this.valor_compo_presu9 =  aValor_compo_presu9;
  }

  public ValorCompoPresu getValor_compo_presu10() throws BaseException { 
    supportRefresh();
    return valor_compo_presu10;
  }

  public void setValor_compo_presu10(ValorCompoPresu aValor_compo_presu10) { 
    this.valor_compo_presu10 =  aValor_compo_presu10;
  }

  public ValorCompoPresu getValor_compo_presu11() throws BaseException { 
    supportRefresh();
    return valor_compo_presu11;
  }

  public void setValor_compo_presu11(ValorCompoPresu aValor_compo_presu11) { 
    this.valor_compo_presu11 =  aValor_compo_presu11;
  }

  public ValorCompoPresu getValor_compo_presu12() throws BaseException { 
    supportRefresh();
    return valor_compo_presu12;
  }

  public void setValor_compo_presu12(ValorCompoPresu aValor_compo_presu12) { 
    this.valor_compo_presu12 =  aValor_compo_presu12;
  }

  public ValorCompoPresu getValor_compo_presu13() throws BaseException { 
    supportRefresh();
    return valor_compo_presu13;
  }

  public void setValor_compo_presu13(ValorCompoPresu aValor_compo_presu13) { 
    this.valor_compo_presu13 =  aValor_compo_presu13;
  }

  public ValorCompoPresu getValor_compo_presu14() throws BaseException { 
    supportRefresh();
    return valor_compo_presu14;
  }

  public void setValor_compo_presu14(ValorCompoPresu aValor_compo_presu14) { 
    this.valor_compo_presu14 =  aValor_compo_presu14;
  }

  public ValorCompoPresu getValor_compo_presu15() throws BaseException { 
    supportRefresh();
    return valor_compo_presu15;
  }

  public void setValor_compo_presu15(ValorCompoPresu aValor_compo_presu15) { 
    this.valor_compo_presu15 =  aValor_compo_presu15;
  }

  public ValorCompoPresu getValor_compo_presu16() throws BaseException { 
    supportRefresh();
    return valor_compo_presu16;
  }

  public void setValor_compo_presu16(ValorCompoPresu aValor_compo_presu16) { 
    this.valor_compo_presu16 =  aValor_compo_presu16;
  }

  public ValorCompoPresu getValor_compo_presu17() throws BaseException { 
    supportRefresh();
    return valor_compo_presu17;
  }

  public void setValor_compo_presu17(ValorCompoPresu aValor_compo_presu17) { 
    this.valor_compo_presu17 =  aValor_compo_presu17;
  }

  public ValorCompoPresu getValor_compo_presu18() throws BaseException { 
    supportRefresh();
    return valor_compo_presu18;
  }

  public void setValor_compo_presu18(ValorCompoPresu aValor_compo_presu18) { 
    this.valor_compo_presu18 =  aValor_compo_presu18;
  }

  public ValorCompoPresu getValor_compo_presu19() throws BaseException { 
    supportRefresh();
    return valor_compo_presu19;
  }

  public void setValor_compo_presu19(ValorCompoPresu aValor_compo_presu19) { 
    this.valor_compo_presu19 =  aValor_compo_presu19;
  }

  public ValorCompoPresu getValor_compo_presu20() throws BaseException { 
    supportRefresh();
    return valor_compo_presu20;
  }

  public void setValor_compo_presu20(ValorCompoPresu aValor_compo_presu20) { 
    this.valor_compo_presu20 =  aValor_compo_presu20;
  }

  public ValorCompoPresu getValor_compo_presu21() throws BaseException { 
    supportRefresh();
    return valor_compo_presu21;
  }

  public void setValor_compo_presu21(ValorCompoPresu aValor_compo_presu21) { 
    this.valor_compo_presu21 =  aValor_compo_presu21;
  }

  public ValorCompoPresu getValor_compo_presu22() throws BaseException { 
    supportRefresh();
    return valor_compo_presu22;
  }

  public void setValor_compo_presu22(ValorCompoPresu aValor_compo_presu22) { 
    this.valor_compo_presu22 =  aValor_compo_presu22;
  }

  public ValorCompoPresu getValor_compo_presu23() throws BaseException { 
    supportRefresh();
    return valor_compo_presu23;
  }

  public void setValor_compo_presu23(ValorCompoPresu aValor_compo_presu23) { 
    this.valor_compo_presu23 =  aValor_compo_presu23;
  }

  public ValorCompoPresu getValor_compo_presu24() throws BaseException { 
    supportRefresh();
    return valor_compo_presu24;
  }

  public void setValor_compo_presu24(ValorCompoPresu aValor_compo_presu24) { 
    this.valor_compo_presu24 =  aValor_compo_presu24;
  }

  public ValorCompoPresu getValor_compo_presu25() throws BaseException { 
    supportRefresh();
    return valor_compo_presu25;
  }

  public void setValor_compo_presu25(ValorCompoPresu aValor_compo_presu25) { 
    this.valor_compo_presu25 =  aValor_compo_presu25;
  }

  public ValorCompoPresu getValor_compo_presu26() throws BaseException { 
    supportRefresh();
    return valor_compo_presu26;
  }

  public void setValor_compo_presu26(ValorCompoPresu aValor_compo_presu26) { 
    this.valor_compo_presu26 =  aValor_compo_presu26;
  }

  public ValorCompoPresu getValor_compo_presu27() throws BaseException { 
    supportRefresh();
    return valor_compo_presu27;
  }

  public void setValor_compo_presu27(ValorCompoPresu aValor_compo_presu27) { 
    this.valor_compo_presu27 =  aValor_compo_presu27;
  }

  public ValorCompoPresu getValor_compo_presu28() throws BaseException { 
    supportRefresh();
    return valor_compo_presu28;
  }

  public void setValor_compo_presu28(ValorCompoPresu aValor_compo_presu28) { 
    this.valor_compo_presu28 =  aValor_compo_presu28;
  }

  public ValorCompoPresu getValor_compo_presu29() throws BaseException { 
    supportRefresh();
    return valor_compo_presu29;
  }

  public void setValor_compo_presu29(ValorCompoPresu aValor_compo_presu29) { 
    this.valor_compo_presu29 =  aValor_compo_presu29;
  }

  public ValorCompoPresu getValor_compo_presu30() throws BaseException { 
    supportRefresh();
    return valor_compo_presu30;
  }

  public void setValor_compo_presu30(ValorCompoPresu aValor_compo_presu30) { 
    this.valor_compo_presu30 =  aValor_compo_presu30;
  }

  public ValorCompoPresu getValor_compo_presu31() throws BaseException { 
    supportRefresh();
    return valor_compo_presu31;
  }

  public void setValor_compo_presu31(ValorCompoPresu aValor_compo_presu31) { 
    this.valor_compo_presu31 =  aValor_compo_presu31;
  }

  public ValorCompoPresu getValor_compo_presu32() throws BaseException { 
    supportRefresh();
    return valor_compo_presu32;
  }

  public void setValor_compo_presu32(ValorCompoPresu aValor_compo_presu32) { 
    this.valor_compo_presu32 =  aValor_compo_presu32;
  }

  public ValorCompoPresu getValor_compo_presu33() throws BaseException { 
    supportRefresh();
    return valor_compo_presu33;
  }

  public void setValor_compo_presu33(ValorCompoPresu aValor_compo_presu33) { 
    this.valor_compo_presu33 =  aValor_compo_presu33;
  }

  public ValorCompoPresu getValor_compo_presu34() throws BaseException { 
    supportRefresh();
    return valor_compo_presu34;
  }

  public void setValor_compo_presu34(ValorCompoPresu aValor_compo_presu34) { 
    this.valor_compo_presu34 =  aValor_compo_presu34;
  }

  public ValorCompoPresu getValor_compo_presu35() throws BaseException { 
    supportRefresh();
    return valor_compo_presu35;
  }

  public void setValor_compo_presu35(ValorCompoPresu aValor_compo_presu35) { 
    this.valor_compo_presu35 =  aValor_compo_presu35;
  }

  public ValorCompoPresu getValor_compo_presu36() throws BaseException { 
    supportRefresh();
    return valor_compo_presu36;
  }

  public void setValor_compo_presu36(ValorCompoPresu aValor_compo_presu36) { 
    this.valor_compo_presu36 =  aValor_compo_presu36;
  }

  public ValorCompoPresu getValor_compo_presu37() throws BaseException { 
    supportRefresh();
    return valor_compo_presu37;
  }

  public void setValor_compo_presu37(ValorCompoPresu aValor_compo_presu37) { 
    this.valor_compo_presu37 =  aValor_compo_presu37;
  }

  public ValorCompoPresu getValor_compo_presu38() throws BaseException { 
    supportRefresh();
    return valor_compo_presu38;
  }

  public void setValor_compo_presu38(ValorCompoPresu aValor_compo_presu38) { 
    this.valor_compo_presu38 =  aValor_compo_presu38;
  }

  public ValorCompoPresu getValor_compo_presu39() throws BaseException { 
    supportRefresh();
    return valor_compo_presu39;
  }

  public void setValor_compo_presu39(ValorCompoPresu aValor_compo_presu39) { 
    this.valor_compo_presu39 =  aValor_compo_presu39;
  }

  public ValorCompoPresu getValor_compo_presu40() throws BaseException { 
    supportRefresh();
    return valor_compo_presu40;
  }

  public void setValor_compo_presu40(ValorCompoPresu aValor_compo_presu40) { 
    this.valor_compo_presu40 =  aValor_compo_presu40;
  }

  public ValorCompoPresu getValor_compo_presu41() throws BaseException { 
    supportRefresh();
    return valor_compo_presu41;
  }

  public void setValor_compo_presu41(ValorCompoPresu aValor_compo_presu41) { 
    this.valor_compo_presu41 =  aValor_compo_presu41;
  }

  public ValorCompoPresu getValor_compo_presu42() throws BaseException { 
    supportRefresh();
    return valor_compo_presu42;
  }

  public void setValor_compo_presu42(ValorCompoPresu aValor_compo_presu42) { 
    this.valor_compo_presu42 =  aValor_compo_presu42;
  }

  public ValorCompoPresu getValor_compo_presu43() throws BaseException { 
    supportRefresh();
    return valor_compo_presu43;
  }

  public void setValor_compo_presu43(ValorCompoPresu aValor_compo_presu43) { 
    this.valor_compo_presu43 =  aValor_compo_presu43;
  }

  public ValorCompoPresu getValor_compo_presu44() throws BaseException { 
    supportRefresh();
    return valor_compo_presu44;
  }

  public void setValor_compo_presu44(ValorCompoPresu aValor_compo_presu44) { 
    this.valor_compo_presu44 =  aValor_compo_presu44;
  }

  public ValorCompoPresu getValor_compo_presu45() throws BaseException { 
    supportRefresh();
    return valor_compo_presu45;
  }

  public void setValor_compo_presu45(ValorCompoPresu aValor_compo_presu45) { 
    this.valor_compo_presu45 =  aValor_compo_presu45;
  }

  public ValorCompoPresu getValor_compo_presu46() throws BaseException { 
    supportRefresh();
    return valor_compo_presu46;
  }

  public void setValor_compo_presu46(ValorCompoPresu aValor_compo_presu46) { 
    this.valor_compo_presu46 =  aValor_compo_presu46;
  }

  public ValorCompoPresu getValor_compo_presu47() throws BaseException { 
    supportRefresh();
    return valor_compo_presu47;
  }

  public void setValor_compo_presu47(ValorCompoPresu aValor_compo_presu47) { 
    this.valor_compo_presu47 =  aValor_compo_presu47;
  }

  public ValorCompoPresu getValor_compo_presu48() throws BaseException { 
    supportRefresh();
    return valor_compo_presu48;
  }

  public void setValor_compo_presu48(ValorCompoPresu aValor_compo_presu48) { 
    this.valor_compo_presu48 =  aValor_compo_presu48;
  }

  public ValorCompoPresu getValor_compo_presu49() throws BaseException { 
    supportRefresh();
    return valor_compo_presu49;
  }

  public void setValor_compo_presu49(ValorCompoPresu aValor_compo_presu49) { 
    this.valor_compo_presu49 =  aValor_compo_presu49;
  }

  public ValorCompoPresu getValor_compo_presu50() throws BaseException { 
    supportRefresh();
    return valor_compo_presu50;
  }

  public void setValor_compo_presu50(ValorCompoPresu aValor_compo_presu50) { 
    this.valor_compo_presu50 =  aValor_compo_presu50;
  }

  public ValorCompoPresu getValor_compo_presu51() throws BaseException { 
    supportRefresh();
    return valor_compo_presu51;
  }

  public void setValor_compo_presu51(ValorCompoPresu aValor_compo_presu51) { 
    this.valor_compo_presu51 =  aValor_compo_presu51;
  }

  public ValorCompoPresu getValor_compo_presu52() throws BaseException { 
    supportRefresh();
    return valor_compo_presu52;
  }

  public void setValor_compo_presu52(ValorCompoPresu aValor_compo_presu52) { 
    this.valor_compo_presu52 =  aValor_compo_presu52;
  }

  public ValorCompoPresu getValor_compo_presu53() throws BaseException { 
    supportRefresh();
    return valor_compo_presu53;
  }

  public void setValor_compo_presu53(ValorCompoPresu aValor_compo_presu53) { 
    this.valor_compo_presu53 =  aValor_compo_presu53;
  }

  public ValorCompoPresu getValor_compo_presu54() throws BaseException { 
    supportRefresh();
    return valor_compo_presu54;
  }

  public void setValor_compo_presu54(ValorCompoPresu aValor_compo_presu54) { 
    this.valor_compo_presu54 =  aValor_compo_presu54;
  }

  public ValorCompoPresu getValor_compo_presu55() throws BaseException { 
    supportRefresh();
    return valor_compo_presu55;
  }

  public void setValor_compo_presu55(ValorCompoPresu aValor_compo_presu55) { 
    this.valor_compo_presu55 =  aValor_compo_presu55;
  }

  public ValorCompoPresu getValor_compo_presu56() throws BaseException { 
    supportRefresh();
    return valor_compo_presu56;
  }

  public void setValor_compo_presu56(ValorCompoPresu aValor_compo_presu56) { 
    this.valor_compo_presu56 =  aValor_compo_presu56;
  }

  public ValorCompoPresu getValor_compo_presu57() throws BaseException { 
    supportRefresh();
    return valor_compo_presu57;
  }

  public void setValor_compo_presu57(ValorCompoPresu aValor_compo_presu57) { 
    this.valor_compo_presu57 =  aValor_compo_presu57;
  }

  public ValorCompoPresu getValor_compo_presu58() throws BaseException { 
    supportRefresh();
    return valor_compo_presu58;
  }

  public void setValor_compo_presu58(ValorCompoPresu aValor_compo_presu58) { 
    this.valor_compo_presu58 =  aValor_compo_presu58;
  }

  public ValorCompoPresu getValor_compo_presu59() throws BaseException { 
    supportRefresh();
    return valor_compo_presu59;
  }

  public void setValor_compo_presu59(ValorCompoPresu aValor_compo_presu59) { 
    this.valor_compo_presu59 =  aValor_compo_presu59;
  }

  public ValorCompoPresu getValor_compo_presu60() throws BaseException { 
    supportRefresh();
    return valor_compo_presu60;
  }

  public void setValor_compo_presu60(ValorCompoPresu aValor_compo_presu60) { 
    this.valor_compo_presu60 =  aValor_compo_presu60;
  }

  public ValorCompoPresu getValor_compo_presu61() throws BaseException { 
    supportRefresh();
    return valor_compo_presu61;
  }

  public void setValor_compo_presu61(ValorCompoPresu aValor_compo_presu61) { 
    this.valor_compo_presu61 =  aValor_compo_presu61;
  }

  public ValorCompoPresu getValor_compo_presu62() throws BaseException { 
    supportRefresh();
    return valor_compo_presu62;
  }

  public void setValor_compo_presu62(ValorCompoPresu aValor_compo_presu62) { 
    this.valor_compo_presu62 =  aValor_compo_presu62;
  }

  public ValorCompoPresu getValor_compo_presu63() throws BaseException { 
    supportRefresh();
    return valor_compo_presu63;
  }

  public void setValor_compo_presu63(ValorCompoPresu aValor_compo_presu63) { 
    this.valor_compo_presu63 =  aValor_compo_presu63;
  }

  public ValorCompoPresu getValor_compo_presu64() throws BaseException { 
    supportRefresh();
    return valor_compo_presu64;
  }

  public void setValor_compo_presu64(ValorCompoPresu aValor_compo_presu64) { 
    this.valor_compo_presu64 =  aValor_compo_presu64;
  }

  public ValorCompoPresu getValor_compo_presu65() throws BaseException { 
    supportRefresh();
    return valor_compo_presu65;
  }

  public void setValor_compo_presu65(ValorCompoPresu aValor_compo_presu65) { 
    this.valor_compo_presu65 =  aValor_compo_presu65;
  }

  public ValorCompoPresu getValor_compo_presu66() throws BaseException { 
    supportRefresh();
    return valor_compo_presu66;
  }

  public void setValor_compo_presu66(ValorCompoPresu aValor_compo_presu66) { 
    this.valor_compo_presu66 =  aValor_compo_presu66;
  }

  public ValorCompoPresu getValor_compo_presu67() throws BaseException { 
    supportRefresh();
    return valor_compo_presu67;
  }

  public void setValor_compo_presu67(ValorCompoPresu aValor_compo_presu67) { 
    this.valor_compo_presu67 =  aValor_compo_presu67;
  }

  public ValorCompoPresu getValor_compo_presu68() throws BaseException { 
    supportRefresh();
    return valor_compo_presu68;
  }

  public void setValor_compo_presu68(ValorCompoPresu aValor_compo_presu68) { 
    this.valor_compo_presu68 =  aValor_compo_presu68;
  }

  public ValorCompoPresu getValor_compo_presu69() throws BaseException { 
    supportRefresh();
    return valor_compo_presu69;
  }

  public void setValor_compo_presu69(ValorCompoPresu aValor_compo_presu69) { 
    this.valor_compo_presu69 =  aValor_compo_presu69;
  }

  public ValorCompoPresu getValor_compo_presu70() throws BaseException { 
    supportRefresh();
    return valor_compo_presu70;
  }

  public void setValor_compo_presu70(ValorCompoPresu aValor_compo_presu70) { 
    this.valor_compo_presu70 =  aValor_compo_presu70;
  }

  public ValorCompoPresu getValor_compo_presu71() throws BaseException { 
    supportRefresh();
    return valor_compo_presu71;
  }

  public void setValor_compo_presu71(ValorCompoPresu aValor_compo_presu71) { 
    this.valor_compo_presu71 =  aValor_compo_presu71;
  }

  public ValorCompoPresu getValor_compo_presu72() throws BaseException { 
    supportRefresh();
    return valor_compo_presu72;
  }

  public void setValor_compo_presu72(ValorCompoPresu aValor_compo_presu72) { 
    this.valor_compo_presu72 =  aValor_compo_presu72;
  }

  public ValorCompoPresu getValor_compo_presu73() throws BaseException { 
    supportRefresh();
    return valor_compo_presu73;
  }

  public void setValor_compo_presu73(ValorCompoPresu aValor_compo_presu73) { 
    this.valor_compo_presu73 =  aValor_compo_presu73;
  }

  public ValorCompoPresu getValor_compo_presu74() throws BaseException { 
    supportRefresh();
    return valor_compo_presu74;
  }

  public void setValor_compo_presu74(ValorCompoPresu aValor_compo_presu74) { 
    this.valor_compo_presu74 =  aValor_compo_presu74;
  }

  public ValorCompoPresu getValor_compo_presu75() throws BaseException { 
    supportRefresh();
    return valor_compo_presu75;
  }

  public void setValor_compo_presu75(ValorCompoPresu aValor_compo_presu75) { 
    this.valor_compo_presu75 =  aValor_compo_presu75;
  }

  public ValorCompoPresu getValor_compo_presu76() throws BaseException { 
    supportRefresh();
    return valor_compo_presu76;
  }

  public void setValor_compo_presu76(ValorCompoPresu aValor_compo_presu76) { 
    this.valor_compo_presu76 =  aValor_compo_presu76;
  }

  public ValorCompoPresu getValor_compo_presu77() throws BaseException { 
    supportRefresh();
    return valor_compo_presu77;
  }

  public void setValor_compo_presu77(ValorCompoPresu aValor_compo_presu77) { 
    this.valor_compo_presu77 =  aValor_compo_presu77;
  }

  public ValorCompoPresu getValor_compo_presu78() throws BaseException { 
    supportRefresh();
    return valor_compo_presu78;
  }

  public void setValor_compo_presu78(ValorCompoPresu aValor_compo_presu78) { 
    this.valor_compo_presu78 =  aValor_compo_presu78;
  }

  public ValorCompoPresu getValor_compo_presu79() throws BaseException { 
    supportRefresh();
    return valor_compo_presu79;
  }

  public void setValor_compo_presu79(ValorCompoPresu aValor_compo_presu79) { 
    this.valor_compo_presu79 =  aValor_compo_presu79;
  }

  public ValorCompoPresu getValor_compo_presu80() throws BaseException { 
    supportRefresh();
    return valor_compo_presu80;
  }

  public void setValor_compo_presu80(ValorCompoPresu aValor_compo_presu80) { 
    this.valor_compo_presu80 =  aValor_compo_presu80;
  }

  public ValorCompoPresu getValor_compo_presu81() throws BaseException { 
    supportRefresh();
    return valor_compo_presu81;
  }

  public void setValor_compo_presu81(ValorCompoPresu aValor_compo_presu81) { 
    this.valor_compo_presu81 =  aValor_compo_presu81;
  }

  public ValorCompoPresu getValor_compo_presu82() throws BaseException { 
    supportRefresh();
    return valor_compo_presu82;
  }

  public void setValor_compo_presu82(ValorCompoPresu aValor_compo_presu82) { 
    this.valor_compo_presu82 =  aValor_compo_presu82;
  }

  public ValorCompoPresu getValor_compo_presu83() throws BaseException { 
    supportRefresh();
    return valor_compo_presu83;
  }

  public void setValor_compo_presu83(ValorCompoPresu aValor_compo_presu83) { 
    this.valor_compo_presu83 =  aValor_compo_presu83;
  }

  public ValorCompoPresu getValor_compo_presu84() throws BaseException { 
    supportRefresh();
    return valor_compo_presu84;
  }

  public void setValor_compo_presu84(ValorCompoPresu aValor_compo_presu84) { 
    this.valor_compo_presu84 =  aValor_compo_presu84;
  }

  public ValorCompoPresu getValor_compo_presu85() throws BaseException { 
    supportRefresh();
    return valor_compo_presu85;
  }

  public void setValor_compo_presu85(ValorCompoPresu aValor_compo_presu85) { 
    this.valor_compo_presu85 =  aValor_compo_presu85;
  }

  public ValorCompoPresu getValor_compo_presu86() throws BaseException { 
    supportRefresh();
    return valor_compo_presu86;
  }

  public void setValor_compo_presu86(ValorCompoPresu aValor_compo_presu86) { 
    this.valor_compo_presu86 =  aValor_compo_presu86;
  }

  public ValorCompoPresu getValor_compo_presu87() throws BaseException { 
    supportRefresh();
    return valor_compo_presu87;
  }

  public void setValor_compo_presu87(ValorCompoPresu aValor_compo_presu87) { 
    this.valor_compo_presu87 =  aValor_compo_presu87;
  }

  public ValorCompoPresu getValor_compo_presu88() throws BaseException { 
    supportRefresh();
    return valor_compo_presu88;
  }

  public void setValor_compo_presu88(ValorCompoPresu aValor_compo_presu88) { 
    this.valor_compo_presu88 =  aValor_compo_presu88;
  }

  public ValorCompoPresu getValor_compo_presu89() throws BaseException { 
    supportRefresh();
    return valor_compo_presu89;
  }

  public void setValor_compo_presu89(ValorCompoPresu aValor_compo_presu89) { 
    this.valor_compo_presu89 =  aValor_compo_presu89;
  }

  public ValorCompoPresu getValor_compo_presu90() throws BaseException { 
    supportRefresh();
    return valor_compo_presu90;
  }

  public void setValor_compo_presu90(ValorCompoPresu aValor_compo_presu90) { 
    this.valor_compo_presu90 =  aValor_compo_presu90;
  }

  public ValorCompoPresu getValor_compo_presu91() throws BaseException { 
    supportRefresh();
    return valor_compo_presu91;
  }

  public void setValor_compo_presu91(ValorCompoPresu aValor_compo_presu91) { 
    this.valor_compo_presu91 =  aValor_compo_presu91;
  }

  public ValorCompoPresu getValor_compo_presu92() throws BaseException { 
    supportRefresh();
    return valor_compo_presu92;
  }

  public void setValor_compo_presu92(ValorCompoPresu aValor_compo_presu92) { 
    this.valor_compo_presu92 =  aValor_compo_presu92;
  }

  public ValorCompoPresu getValor_compo_presu93() throws BaseException { 
    supportRefresh();
    return valor_compo_presu93;
  }

  public void setValor_compo_presu93(ValorCompoPresu aValor_compo_presu93) { 
    this.valor_compo_presu93 =  aValor_compo_presu93;
  }

  public ValorCompoPresu getValor_compo_presu94() throws BaseException { 
    supportRefresh();
    return valor_compo_presu94;
  }

  public void setValor_compo_presu94(ValorCompoPresu aValor_compo_presu94) { 
    this.valor_compo_presu94 =  aValor_compo_presu94;
  }

  public ValorCompoPresu getValor_compo_presu95() throws BaseException { 
    supportRefresh();
    return valor_compo_presu95;
  }

  public void setValor_compo_presu95(ValorCompoPresu aValor_compo_presu95) { 
    this.valor_compo_presu95 =  aValor_compo_presu95;
  }

  public ValorCompoPresu getValor_compo_presu96() throws BaseException { 
    supportRefresh();
    return valor_compo_presu96;
  }

  public void setValor_compo_presu96(ValorCompoPresu aValor_compo_presu96) { 
    this.valor_compo_presu96 =  aValor_compo_presu96;
  }

  public ValorCompoPresu getValor_compo_presu97() throws BaseException { 
    supportRefresh();
    return valor_compo_presu97;
  }

  public void setValor_compo_presu97(ValorCompoPresu aValor_compo_presu97) { 
    this.valor_compo_presu97 =  aValor_compo_presu97;
  }

  public ValorCompoPresu getValor_compo_presu98() throws BaseException { 
    supportRefresh();
    return valor_compo_presu98;
  }

  public void setValor_compo_presu98(ValorCompoPresu aValor_compo_presu98) { 
    this.valor_compo_presu98 =  aValor_compo_presu98;
  }

  public ValorCompoPresu getValor_compo_presu99() throws BaseException { 
    supportRefresh();
    return valor_compo_presu99;
  }

  public void setValor_compo_presu99(ValorCompoPresu aValor_compo_presu99) { 
    this.valor_compo_presu99 =  aValor_compo_presu99;
  }

  public ValorCompoPresu getValor_compo_presu100() throws BaseException { 
    supportRefresh();
    return valor_compo_presu100;
  }

  public void setValor_compo_presu100(ValorCompoPresu aValor_compo_presu100) { 
    this.valor_compo_presu100 =  aValor_compo_presu100;
  }

  public Double getVal_metrica_1() throws BaseException { 
    supportRefresh();
    return val_metrica_1;
  }

  public void setVal_metrica_1(Double aVal_metrica_1) { 
    this.val_metrica_1 =  aVal_metrica_1;
  }

  public Double getVal_metrica_2() throws BaseException { 
    supportRefresh();
    return val_metrica_2;
  }

  public void setVal_metrica_2(Double aVal_metrica_2) { 
    this.val_metrica_2 =  aVal_metrica_2;
  }

  public Double getVal_metrica_3() throws BaseException { 
    supportRefresh();
    return val_metrica_3;
  }

  public void setVal_metrica_3(Double aVal_metrica_3) { 
    this.val_metrica_3 =  aVal_metrica_3;
  }

  public Double getVal_metrica_4() throws BaseException { 
    supportRefresh();
    return val_metrica_4;
  }

  public void setVal_metrica_4(Double aVal_metrica_4) { 
    this.val_metrica_4 =  aVal_metrica_4;
  }

  public Double getVal_metrica_5() throws BaseException { 
    supportRefresh();
    return val_metrica_5;
  }

  public void setVal_metrica_5(Double aVal_metrica_5) { 
    this.val_metrica_5 =  aVal_metrica_5;
  }

  public Double getVal_metrica_6() throws BaseException { 
    supportRefresh();
    return val_metrica_6;
  }

  public void setVal_metrica_6(Double aVal_metrica_6) { 
    this.val_metrica_6 =  aVal_metrica_6;
  }

  public Double getVal_metrica_7() throws BaseException { 
    supportRefresh();
    return val_metrica_7;
  }

  public void setVal_metrica_7(Double aVal_metrica_7) { 
    this.val_metrica_7 =  aVal_metrica_7;
  }

  public Double getVal_metrica_8() throws BaseException { 
    supportRefresh();
    return val_metrica_8;
  }

  public void setVal_metrica_8(Double aVal_metrica_8) { 
    this.val_metrica_8 =  aVal_metrica_8;
  }

  public Double getVal_metrica_9() throws BaseException { 
    supportRefresh();
    return val_metrica_9;
  }

  public void setVal_metrica_9(Double aVal_metrica_9) { 
    this.val_metrica_9 =  aVal_metrica_9;
  }

  public Double getVal_metrica_10() throws BaseException { 
    supportRefresh();
    return val_metrica_10;
  }

  public void setVal_metrica_10(Double aVal_metrica_10) { 
    this.val_metrica_10 =  aVal_metrica_10;
  }

  public Double getVal_metrica_11() throws BaseException { 
    supportRefresh();
    return val_metrica_11;
  }

  public void setVal_metrica_11(Double aVal_metrica_11) { 
    this.val_metrica_11 =  aVal_metrica_11;
  }

  public Double getVal_metrica_12() throws BaseException { 
    supportRefresh();
    return val_metrica_12;
  }

  public void setVal_metrica_12(Double aVal_metrica_12) { 
    this.val_metrica_12 =  aVal_metrica_12;
  }

  public Double getVal_metrica_13() throws BaseException { 
    supportRefresh();
    return val_metrica_13;
  }

  public void setVal_metrica_13(Double aVal_metrica_13) { 
    this.val_metrica_13 =  aVal_metrica_13;
  }

  public Double getVal_metrica_14() throws BaseException { 
    supportRefresh();
    return val_metrica_14;
  }

  public void setVal_metrica_14(Double aVal_metrica_14) { 
    this.val_metrica_14 =  aVal_metrica_14;
  }

  public Double getVal_metrica_15() throws BaseException { 
    supportRefresh();
    return val_metrica_15;
  }

  public void setVal_metrica_15(Double aVal_metrica_15) { 
    this.val_metrica_15 =  aVal_metrica_15;
  }

  public Double getVal_metrica_16() throws BaseException { 
    supportRefresh();
    return val_metrica_16;
  }

  public void setVal_metrica_16(Double aVal_metrica_16) { 
    this.val_metrica_16 =  aVal_metrica_16;
  }

  public Double getVal_metrica_17() throws BaseException { 
    supportRefresh();
    return val_metrica_17;
  }

  public void setVal_metrica_17(Double aVal_metrica_17) { 
    this.val_metrica_17 =  aVal_metrica_17;
  }

  public Double getVal_metrica_18() throws BaseException { 
    supportRefresh();
    return val_metrica_18;
  }

  public void setVal_metrica_18(Double aVal_metrica_18) { 
    this.val_metrica_18 =  aVal_metrica_18;
  }

  public Double getVal_metrica_19() throws BaseException { 
    supportRefresh();
    return val_metrica_19;
  }

  public void setVal_metrica_19(Double aVal_metrica_19) { 
    this.val_metrica_19 =  aVal_metrica_19;
  }

  public Double getVal_metrica_20() throws BaseException { 
    supportRefresh();
    return val_metrica_20;
  }

  public void setVal_metrica_20(Double aVal_metrica_20) { 
    this.val_metrica_20 =  aVal_metrica_20;
  }

  public Double getVal_metrica_21() throws BaseException { 
    supportRefresh();
    return val_metrica_21;
  }

  public void setVal_metrica_21(Double aVal_metrica_21) { 
    this.val_metrica_21 =  aVal_metrica_21;
  }

  public Double getVal_metrica_22() throws BaseException { 
    supportRefresh();
    return val_metrica_22;
  }

  public void setVal_metrica_22(Double aVal_metrica_22) { 
    this.val_metrica_22 =  aVal_metrica_22;
  }

  public Double getVal_metrica_23() throws BaseException { 
    supportRefresh();
    return val_metrica_23;
  }

  public void setVal_metrica_23(Double aVal_metrica_23) { 
    this.val_metrica_23 =  aVal_metrica_23;
  }

  public Double getVal_metrica_24() throws BaseException { 
    supportRefresh();
    return val_metrica_24;
  }

  public void setVal_metrica_24(Double aVal_metrica_24) { 
    this.val_metrica_24 =  aVal_metrica_24;
  }

  public Double getVal_metrica_25() throws BaseException { 
    supportRefresh();
    return val_metrica_25;
  }

  public void setVal_metrica_25(Double aVal_metrica_25) { 
    this.val_metrica_25 =  aVal_metrica_25;
  }

  public Double getVal_metrica_26() throws BaseException { 
    supportRefresh();
    return val_metrica_26;
  }

  public void setVal_metrica_26(Double aVal_metrica_26) { 
    this.val_metrica_26 =  aVal_metrica_26;
  }

  public Double getVal_metrica_27() throws BaseException { 
    supportRefresh();
    return val_metrica_27;
  }

  public void setVal_metrica_27(Double aVal_metrica_27) { 
    this.val_metrica_27 =  aVal_metrica_27;
  }

  public Double getVal_metrica_28() throws BaseException { 
    supportRefresh();
    return val_metrica_28;
  }

  public void setVal_metrica_28(Double aVal_metrica_28) { 
    this.val_metrica_28 =  aVal_metrica_28;
  }

  public Double getVal_metrica_29() throws BaseException { 
    supportRefresh();
    return val_metrica_29;
  }

  public void setVal_metrica_29(Double aVal_metrica_29) { 
    this.val_metrica_29 =  aVal_metrica_29;
  }

  public Double getVal_metrica_30() throws BaseException { 
    supportRefresh();
    return val_metrica_30;
  }

  public void setVal_metrica_30(Double aVal_metrica_30) { 
    this.val_metrica_30 =  aVal_metrica_30;
  }

  public Double getVal_metrica_31() throws BaseException { 
    supportRefresh();
    return val_metrica_31;
  }

  public void setVal_metrica_31(Double aVal_metrica_31) { 
    this.val_metrica_31 =  aVal_metrica_31;
  }

  public Double getVal_metrica_32() throws BaseException { 
    supportRefresh();
    return val_metrica_32;
  }

  public void setVal_metrica_32(Double aVal_metrica_32) { 
    this.val_metrica_32 =  aVal_metrica_32;
  }

  public Double getVal_metrica_33() throws BaseException { 
    supportRefresh();
    return val_metrica_33;
  }

  public void setVal_metrica_33(Double aVal_metrica_33) { 
    this.val_metrica_33 =  aVal_metrica_33;
  }

  public Double getVal_metrica_34() throws BaseException { 
    supportRefresh();
    return val_metrica_34;
  }

  public void setVal_metrica_34(Double aVal_metrica_34) { 
    this.val_metrica_34 =  aVal_metrica_34;
  }

  public Double getVal_metrica_35() throws BaseException { 
    supportRefresh();
    return val_metrica_35;
  }

  public void setVal_metrica_35(Double aVal_metrica_35) { 
    this.val_metrica_35 =  aVal_metrica_35;
  }

  public Double getVal_metrica_36() throws BaseException { 
    supportRefresh();
    return val_metrica_36;
  }

  public void setVal_metrica_36(Double aVal_metrica_36) { 
    this.val_metrica_36 =  aVal_metrica_36;
  }

  public Double getVal_metrica_37() throws BaseException { 
    supportRefresh();
    return val_metrica_37;
  }

  public void setVal_metrica_37(Double aVal_metrica_37) { 
    this.val_metrica_37 =  aVal_metrica_37;
  }

  public Double getVal_metrica_38() throws BaseException { 
    supportRefresh();
    return val_metrica_38;
  }

  public void setVal_metrica_38(Double aVal_metrica_38) { 
    this.val_metrica_38 =  aVal_metrica_38;
  }

  public Double getVal_metrica_39() throws BaseException { 
    supportRefresh();
    return val_metrica_39;
  }

  public void setVal_metrica_39(Double aVal_metrica_39) { 
    this.val_metrica_39 =  aVal_metrica_39;
  }

  public Double getVal_metrica_40() throws BaseException { 
    supportRefresh();
    return val_metrica_40;
  }

  public void setVal_metrica_40(Double aVal_metrica_40) { 
    this.val_metrica_40 =  aVal_metrica_40;
  }

  public Double getVal_metrica_41() throws BaseException { 
    supportRefresh();
    return val_metrica_41;
  }

  public void setVal_metrica_41(Double aVal_metrica_41) { 
    this.val_metrica_41 =  aVal_metrica_41;
  }

  public Double getVal_metrica_42() throws BaseException { 
    supportRefresh();
    return val_metrica_42;
  }

  public void setVal_metrica_42(Double aVal_metrica_42) { 
    this.val_metrica_42 =  aVal_metrica_42;
  }

  public Double getVal_metrica_43() throws BaseException { 
    supportRefresh();
    return val_metrica_43;
  }

  public void setVal_metrica_43(Double aVal_metrica_43) { 
    this.val_metrica_43 =  aVal_metrica_43;
  }

  public Double getVal_metrica_44() throws BaseException { 
    supportRefresh();
    return val_metrica_44;
  }

  public void setVal_metrica_44(Double aVal_metrica_44) { 
    this.val_metrica_44 =  aVal_metrica_44;
  }

  public Double getVal_metrica_45() throws BaseException { 
    supportRefresh();
    return val_metrica_45;
  }

  public void setVal_metrica_45(Double aVal_metrica_45) { 
    this.val_metrica_45 =  aVal_metrica_45;
  }

  public Double getVal_metrica_46() throws BaseException { 
    supportRefresh();
    return val_metrica_46;
  }

  public void setVal_metrica_46(Double aVal_metrica_46) { 
    this.val_metrica_46 =  aVal_metrica_46;
  }

  public Double getVal_metrica_47() throws BaseException { 
    supportRefresh();
    return val_metrica_47;
  }

  public void setVal_metrica_47(Double aVal_metrica_47) { 
    this.val_metrica_47 =  aVal_metrica_47;
  }

  public Double getVal_metrica_48() throws BaseException { 
    supportRefresh();
    return val_metrica_48;
  }

  public void setVal_metrica_48(Double aVal_metrica_48) { 
    this.val_metrica_48 =  aVal_metrica_48;
  }

  public Double getVal_metrica_49() throws BaseException { 
    supportRefresh();
    return val_metrica_49;
  }

  public void setVal_metrica_49(Double aVal_metrica_49) { 
    this.val_metrica_49 =  aVal_metrica_49;
  }

  public Double getVal_metrica_50() throws BaseException { 
    supportRefresh();
    return val_metrica_50;
  }

  public void setVal_metrica_50(Double aVal_metrica_50) { 
    this.val_metrica_50 =  aVal_metrica_50;
  }

  public PeriodoPresupuestario getPeriodo1() throws BaseException { 
    supportRefresh();
    return periodo1;
  }

  public void setPeriodo1(PeriodoPresupuestario aPeriodo1) { 
    this.periodo1 =  aPeriodo1;
  }

  public PeriodoPresupuestario getPeriodo2() throws BaseException { 
    supportRefresh();
    return periodo2;
  }

  public void setPeriodo2(PeriodoPresupuestario aPeriodo2) { 
    this.periodo2 =  aPeriodo2;
  }

  public PeriodoPresupuestario getPeriodo3() throws BaseException { 
    supportRefresh();
    return periodo3;
  }

  public void setPeriodo3(PeriodoPresupuestario aPeriodo3) { 
    this.periodo3 =  aPeriodo3;
  }

  public PeriodoPresupuestario getPeriodo4() throws BaseException { 
    supportRefresh();
    return periodo4;
  }

  public void setPeriodo4(PeriodoPresupuestario aPeriodo4) { 
    this.periodo4 =  aPeriodo4;
  }

  public PeriodoPresupuestario getPeriodo5() throws BaseException { 
    supportRefresh();
    return periodo5;
  }

  public void setPeriodo5(PeriodoPresupuestario aPeriodo5) { 
    this.periodo5 =  aPeriodo5;
  }

  public PeriodoPresupuestario getPeriodo6() throws BaseException { 
    supportRefresh();
    return periodo6;
  }

  public void setPeriodo6(PeriodoPresupuestario aPeriodo6) { 
    this.periodo6 =  aPeriodo6;
  }

  public PeriodoPresupuestario getPeriodo7() throws BaseException { 
    supportRefresh();
    return periodo7;
  }

  public void setPeriodo7(PeriodoPresupuestario aPeriodo7) { 
    this.periodo7 =  aPeriodo7;
  }

  public PeriodoPresupuestario getPeriodo8() throws BaseException { 
    supportRefresh();
    return periodo8;
  }

  public void setPeriodo8(PeriodoPresupuestario aPeriodo8) { 
    this.periodo8 =  aPeriodo8;
  }

  public PeriodoPresupuestario getPeriodo9() throws BaseException { 
    supportRefresh();
    return periodo9;
  }

  public void setPeriodo9(PeriodoPresupuestario aPeriodo9) { 
    this.periodo9 =  aPeriodo9;
  }

  public PeriodoPresupuestario getPeriodo10() throws BaseException { 
    supportRefresh();
    return periodo10;
  }

  public void setPeriodo10(PeriodoPresupuestario aPeriodo10) { 
    this.periodo10 =  aPeriodo10;
  }

  public PeriodoPresupuestario getPeriodo11() throws BaseException { 
    supportRefresh();
    return periodo11;
  }

  public void setPeriodo11(PeriodoPresupuestario aPeriodo11) { 
    this.periodo11 =  aPeriodo11;
  }

  public PeriodoPresupuestario getPeriodo12() throws BaseException { 
    supportRefresh();
    return periodo12;
  }

  public void setPeriodo12(PeriodoPresupuestario aPeriodo12) { 
    this.periodo12 =  aPeriodo12;
  }

  public PeriodoPresupuestario getPeriodo13() throws BaseException { 
    supportRefresh();
    return periodo13;
  }

  public void setPeriodo13(PeriodoPresupuestario aPeriodo13) { 
    this.periodo13 =  aPeriodo13;
  }

  public PeriodoPresupuestario getPeriodo14() throws BaseException { 
    supportRefresh();
    return periodo14;
  }

  public void setPeriodo14(PeriodoPresupuestario aPeriodo14) { 
    this.periodo14 =  aPeriodo14;
  }

  public PeriodoPresupuestario getPeriodo15() throws BaseException { 
    supportRefresh();
    return periodo15;
  }

  public void setPeriodo15(PeriodoPresupuestario aPeriodo15) { 
    this.periodo15 =  aPeriodo15;
  }

  public PeriodoPresupuestario getPeriodo16() throws BaseException { 
    supportRefresh();
    return periodo16;
  }

  public void setPeriodo16(PeriodoPresupuestario aPeriodo16) { 
    this.periodo16 =  aPeriodo16;
  }

  public PeriodoPresupuestario getPeriodo17() throws BaseException { 
    supportRefresh();
    return periodo17;
  }

  public void setPeriodo17(PeriodoPresupuestario aPeriodo17) { 
    this.periodo17 =  aPeriodo17;
  }

  public PeriodoPresupuestario getPeriodo18() throws BaseException { 
    supportRefresh();
    return periodo18;
  }

  public void setPeriodo18(PeriodoPresupuestario aPeriodo18) { 
    this.periodo18 =  aPeriodo18;
  }

  public PeriodoPresupuestario getPeriodo19() throws BaseException { 
    supportRefresh();
    return periodo19;
  }

  public void setPeriodo19(PeriodoPresupuestario aPeriodo19) { 
    this.periodo19 =  aPeriodo19;
  }

  public PeriodoPresupuestario getPeriodo20() throws BaseException { 
    supportRefresh();
    return periodo20;
  }

  public void setPeriodo20(PeriodoPresupuestario aPeriodo20) { 
    this.periodo20 =  aPeriodo20;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ValorEquivalenciaRepositorio findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorEquivalenciaRepositorio) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ValorEquivalenciaRepositorio findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValorEquivalenciaRepositorio) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(repositorio_real, "Debe ingresar el Repositorio");
 }
 
 public static ValorEquivalenciaRepositorio getValorEquiRepo(ValorRealRepositorio valorRealRepositorio,
     ISesion aSesion)
     throws BaseException {
 	return DBValorEquivalenciaRepositorio.getValorEquiRepo(valorRealRepositorio,aSesion);
 }
 

}
