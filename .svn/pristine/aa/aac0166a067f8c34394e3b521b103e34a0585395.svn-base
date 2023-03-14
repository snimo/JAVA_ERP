package com.srn.erp.contabilidad.bl;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;

import framework.request.bl.Utils.BaseException;

public class CrearTablaCompo {

  private Componente componente;

  public void setComponente(Componente componente) {
    this.componente = componente;
  }

  public Componente getComponente() {
    return componente;
  }

  public CrearTablaCompo() {
  }

  public String getScriptCrearTabla() throws BaseException {
    StringBuffer sb = new StringBuffer();
    sb.append(" CREATE TABLE cgCompo_"+getComponente().getCodigo()+" ( ");
    sb.append("   oid_compo INTEGER, ");
    sb.append("   codigo VARCHAR(15), ");
    sb.append("   descripcion  VARCHAR(50), ");
    sb.append("   activo SMALLINT) ");
    return sb.toString();
  }

  public String getScriptAddCampoCompoToTableAnaImp() throws BaseException {
    StringBuffer sb = new StringBuffer();
    sb.append(" alter table CGANAIMPCON add ");
    sb.append(getComponente().getCampoFisicoAnaImp()+" integer default 0 ");
    return sb.toString();
  }

  public String getScriptCrearIndice() throws BaseException {
    StringBuffer sb = new StringBuffer();
    sb.append(" CREATE UNIQUE INDEX XPKCompo_"+getComponente().getCodigo()+" ON cgCompo_"+getComponente().getCodigo());
    sb.append(" ( ");
    sb.append("  oid_compo ");
    sb.append(" ) ");
    return sb.toString();
  }

  public String getScriptAddCampoAtributo(CompoAtributo compoAtributo) throws BaseException {
    StringBuffer sb = new StringBuffer();
    if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_COMPONENTE))
        sb.append(" alter table cgCompo_"+getComponente().getCodigo()+" add oid_"+compoAtributo.getAtributo().getCodigo()+" integer");
    else
    if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_ENTERO))
        sb.append(" alter table cgCompo_"+getComponente().getCodigo()+" add ent_"+compoAtributo.getAtributo().getCodigo()+" integer");
    else
    if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_STRING))
        sb.append(" alter table cgCompo_"+
                  getComponente().getCodigo()+" add "+
                  "str_"+compoAtributo.getAtributo().getCodigo()+" varchar(50)");
    else
    if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_DECIMAL))
          sb.append(" alter table cgCompo_"+
                    getComponente().getCodigo()+" add "+
                    "dec_"+compoAtributo.getAtributo().getCodigo()+" DOUBLE PRECISION");
    else
    if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_FECHA))
          sb.append(" alter table cgCompo_"+
                    getComponente().getCodigo()+" add "+
                    "fec_"+compoAtributo.getAtributo().getCodigo()+" TIMESTAMP");

    return sb.toString();
  }

}
