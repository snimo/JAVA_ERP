package com.srn.erp.ventas.bm;

import java.util.Hashtable;

import framework.request.bl.Utils.BaseException;

public class TipoOperFacturacion {

  public static final String FACT_MOST = "FACT_MOST";
  public static final String NC_MOST = "NC_MOST";
  public static final String FACT_REM = "FACT_REM";
  public static final String FACT_PED = "FACT_PED";
  public static final String FACT_ANT = "FACT_ANT";
  public static final String ND_INTERNA = "ND_INT";
  public static final String NC_INTERNA = "NC_INT";
  public static final String NOTA_DEBITO = "NOTA_DEB";
  public static final String FACT_SS = "FACT_SS";

  public TipoOperFacturacion() {
  }

  public static Hashtable getTipos() throws BaseException {
    Hashtable tipos = new Hashtable();
    tipos.put(FACT_MOST,"1-Fact. Mostrador");
    tipos.put(FACT_REM, "2-Fact. Remitos ");
    tipos.put(FACT_PED,"3-Fact. Pedido");
    tipos.put(FACT_ANT ,"4-Fact. Ant./Seña");
    tipos.put(FACT_SS ,"5-Fact. Saldo Ant/Seña");
    tipos.put(NC_MOST,"6-Nota de Crédito");
    tipos.put(NOTA_DEBITO,"7-Nota de Débito");
    tipos.put(ND_INTERNA, "8-N.D. Interna");
    tipos.put(NC_INTERNA, "9-N.C. Interna");
    return tipos;
  }

}
