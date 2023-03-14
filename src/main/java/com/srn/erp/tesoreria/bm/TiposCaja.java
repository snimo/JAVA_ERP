package com.srn.erp.tesoreria.bm;

import java.util.Hashtable;

public class TiposCaja  {

  public static final String OPERATIVA = "OPER";
  public static final String TRANSFERENCIA = "TRANS";
  public static final String TARJETASADEPOSITAR = "TAD";


  private Hashtable tipos = new Hashtable();

  public TiposCaja() {
    tipos.put(OPERATIVA,"Operativa");
    tipos.put(TRANSFERENCIA,"Transferencia");
    tipos.put(TARJETASADEPOSITAR,"Tarjetas a Depositar");    
  }

  public Hashtable getTipos() {
    return tipos;
  }


}
