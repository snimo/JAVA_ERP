package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoValorIngresoRecibo extends Operation {

  public TraerTipoValorIngresoRecibo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetTipoValor = getDataSetTipoValor();
    
    Iterator iterValores = TipoValor.getValoresIngresoRecibo(getSesion()).iterator();
    while (iterValores.hasNext()) {
    	TipoValor tipovalor = (TipoValor) iterValores.next();
    	
    	Integer oidCtaImpu = new Integer(0);
    	String codCtaImpu = "";
    	String descCtaImpu = "";
    	
    	if (tipovalor.getCuentaImputable()!=null) {
        	oidCtaImpu = tipovalor.getCuentaImputable().getOIDInteger();
        	codCtaImpu = tipovalor.getCuentaImputable().getCodigoCuentaMasCodigosValCompo();
        	descCtaImpu = tipovalor.getCuentaImputable().getDescCuentaMasDescValCompo();
    	}
    	
    	cargarRegistroTipoValor(datasetTipoValor,
                tipovalor.getOIDInteger(),
                tipovalor.getCodigo(),
                tipovalor.getDescripcion(),
                tipovalor.getCompo(),
                tipovalor.getMoneda(),
                tipovalor.isActivo(),
                oidCtaImpu,
                codCtaImpu,
                descCtaImpu);    	
    }
    
    writeCliente(datasetTipoValor);
  }

  private IDataSet getDataSetTipoValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValores");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_moneda", Field.STRING, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ana_imp", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ana_imp", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTipoValor(IDataSet dataset,
                         Integer oid_tipo_valor,
                         String codigo,
                         String descripcion,
                         String compo,
                         Moneda moneda,
                         Boolean activo,
                         Integer oidAnaImp,
                         String codigoAnaImp,
                         String descAnaImp) {
    dataset.append();
    dataset.fieldValue("oid_tipo_valor", oid_tipo_valor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("oid_moneda", moneda.getOID());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("oid_ai", oidAnaImp);
    dataset.fieldValue("codigo_ana_imp", codigoAnaImp);
    dataset.fieldValue("desc_ana_imp", descAnaImp);

  }
}
