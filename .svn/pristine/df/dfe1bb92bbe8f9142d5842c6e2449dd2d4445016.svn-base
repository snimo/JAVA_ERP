package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Cuenta;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetallesComproConta extends Operation {

  public TraerDetallesComproConta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	HashTableDatos condiciones = new HashTableDatos();  
	
	if (mapaDatos.containsKey("oid_ana")) {
		Cuenta cuenta = Cuenta.findByOidProxy(mapaDatos.getInteger("oid_ana"),getSesion());
		condiciones.put(Cuenta.NICKNAME,cuenta);
	}	
	if (mapaDatos.containsKey("fec_desde")) 
		condiciones.put("FEC_DESDE",mapaDatos.getDate("fec_desde"));
	if (mapaDatos.containsKey("fec_hasta")) 
		condiciones.put("FEC_HASTA",mapaDatos.getDate("fec_hasta"));
	if (mapaDatos.containsKey("tipo")) {
		if (mapaDatos.getString("tipo").equals("DEBITO"))
			condiciones.put("DEBITO","");
		if (mapaDatos.getString("tipo").equals("CREDITO"))
			condiciones.put("CREDITO","");
	}
	
    IDataSet datasetDetComproConta = getDataSetDetComproConta();
    Iterator listaDetComproConta = ComproContaDet.getDetallesByComproConta(condiciones,getSesion()).iterator();
    while (listaDetComproConta.hasNext()) {
    	ComproContaDet comproContaDet = (ComproContaDet) listaDetComproConta.next();
    	cargarRegistroComproContaDet(datasetDetComproConta,comproContaDet);
    }
    
    writeCliente(datasetDetComproConta);
  }

  private IDataSet getDataSetDetComproConta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDetallesComproConta");
    dataset.fieldDef(new Field("oid_dco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_imputac", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ai", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 100));
    dataset.fieldDef(new Field("comentario_ai", Field.STRING, 255));
    dataset.fieldDef(new Field("impo_mon_loc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impo_mon_ext_1", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impo_mon_ext_2", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistroComproContaDet(IDataSet dataset,
                         ComproContaDet aComproContaDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_dco", aComproContaDet.getOIDInteger());
    dataset.fieldValue("comprobante", aComproContaDet.getComprobante().getComprobante().getCodigo());
    dataset.fieldValue("fec_imputac", Fecha.getddmmyyyy(aComproContaDet.getComprobante().getImputac()));
    dataset.fieldValue("oid_ai", aComproContaDet.getCuentaImputable().getOIDInteger());
    dataset.fieldValue("codigo_ai", aComproContaDet.getCuentaImputable().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai", aComproContaDet.getCuentaImputable().getDescCuentaMasDescValCompo());
    if (aComproContaDet.getComentario()!=null)
      dataset.fieldValue("comentario_ai", aComproContaDet.getComentario());
    else
      dataset.fieldValue("comentario_ai", "");
    
    dataset.fieldValue("impo_mon_loc", aComproContaDet.getImpoLocAju().doubleValue()*aComproContaDet.getSigno().intValue());
    dataset.fieldValue("impo_mon_ext_1", aComproContaDet.getImpoMonExt1().doubleValue()*aComproContaDet.getSigno().intValue());
    dataset.fieldValue("impo_mon_ext_2", aComproContaDet.getImpoMonExt2().doubleValue()*aComproContaDet.getSigno().intValue());
  }


}
