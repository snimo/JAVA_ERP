package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAnalizarCodCtaParaHelp extends Operation {

  public TraerAnalizarCodCtaParaHelp() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetAnalizarCodCta();
	  
	  String codigoImputacion = mapaDatos.getString("codigo");
	  String valCompoConcat   = CuentaImputable.parseValoresCompoConcat(codigoImputacion);
	  
	  Cuenta cuenta = CuentaImputable.getCuenta(codigoImputacion, this.getSesion());
	  
	  if (cuenta!=null) {
		  
		  Componente compo = cuenta.getUltCompoSegunValConcat(valCompoConcat);
		  
		  if (compo!=null) { 
			  cargarRegistro(ds, cuenta, compo, getFormatCodImpu(codigoImputacion));
		  }
		  
	  }
	  
	  writeCliente(ds);
  }

  private IDataSet getDataSetAnalizarCodCta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAnalizarCodCtaHelp");
    dataset.fieldDef(new Field("oid_cuenta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cuenta", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_cuenta", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_componente", Field.STRING, 50));
    dataset.fieldDef(new Field("nickname", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cta_sin_valor_compo", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_compo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_compo", Field.STRING, 100));
    dataset.fieldDef(new Field("es_ultimo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistro(IDataSet dataset,
                         Cuenta cuenta,
                         Componente componente,
                         String codCtaSinValorCompo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cuenta", cuenta.getOIDInteger());
    dataset.fieldValue("cod_cuenta", cuenta.getCodigo());
    dataset.fieldValue("desc_cuenta", cuenta.getDescripcion());
    dataset.fieldValue("tipo_componente", componente.getTipo());
    dataset.fieldValue("nickname", componente.getNombreNickName());
    dataset.fieldValue("nro_clasificador", componente.getNroClasificador());
    dataset.fieldValue("cod_cta_sin_valor_compo", codCtaSinValorCompo);
    dataset.fieldValue("oid_compo", componente.getOIDInteger());
    dataset.fieldValue("cod_compo", componente.getCodigo());
    dataset.fieldValue("desc_compo", componente.getDescripcion());
    
    if ((cuenta.getUltimoComponente()!=null) && (cuenta.getUltimoComponente().getOID() == componente.getOID()))
    	dataset.fieldValue("es_ultimo", true);
    else
    	dataset.fieldValue("es_ultimo", false);
    
  }
  
  private String getFormatCodImpu(String codigoImputacion) {
	  if (!codigoImputacion.contains("."))
		  return codigoImputacion+".";
	  else
	  if (codigoImputacion.endsWith("."))
		  return codigoImputacion;
	  else {
		    StringBuffer nuevoCodImp = new StringBuffer("");
			String[] listaCodigos = codigoImputacion.split("\\.");
			for (int i = 0; i < listaCodigos.length-1; ++i) {
				String codigo = listaCodigos[i];
				if (nuevoCodImp.length()>0)
					nuevoCodImp.append(".");
				nuevoCodImp.append(codigo);
			}
			return nuevoCodImp.toString()+".";
	  }
  }


}
