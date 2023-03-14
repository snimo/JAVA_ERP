package com.srn.erp.tesoreria.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresEnCajaChequeTercero extends Operation {

  public TraerValoresEnCajaChequeTercero() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	Integer oidCaja = mapaDatos.getInteger("oid_caja");
  	Caja caja = Caja.findByOidProxy(oidCaja,getSesion());
    traerValoresEnCajaChequeCliente(caja);  
  }

  private IDataSet getDataSetValoresEnCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresEnCaja");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor",Field.STRING, 50));
    dataset.fieldDef(new Field("nro_tarjeta",Field.STRING, 50));
    dataset.fieldDef(new Field("nro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_entidad",Field.STRING, 50));
    dataset.fieldDef(new Field("razon_social",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vto",Field.DATE, 0));
    dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cupon",Field.INTEGER, 0));
    dataset.fieldDef(new Field("lote",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuotas",Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante",Field.STRING, 100));
    dataset.fieldDef(new Field("fecha",Field.DATE, 0));
    return dataset;
  }
  
  private void cargarRegistroValoresEnCaja(IDataSet dataset,
                         Integer secu,
                         Integer orden,
                         Integer oidTipoValor,
                         Integer oidValor,
                         String descTipoValor,
                         String nroTarjeta,
                         Integer nro,
                         String descEntidad,
                         String razonSocial,
                         Integer oidMoneda,
                         String codMoneda,
                         java.util.Date fecEmision,
                         java.util.Date fecVto,
                         Money importe,
                         Integer cupon,
                         Integer lote,
                         Integer cuotas,
                         String comprobante,
                         Date fecha) throws BaseException { 
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("oid_tipo_valor",oidTipoValor);
    dataset.fieldValue("oid_valor",oidValor);
    dataset.fieldValue("desc_tipo_valor",descTipoValor);
    if (nroTarjeta!=null)
    	dataset.fieldValue("nro_tarjeta",nroTarjeta);
    else
    	dataset.fieldValue("nro_tarjeta","");
    if (nro!=null)
    	dataset.fieldValue("nro",nro);
    else
    	dataset.fieldValue("nro",new Integer(0));
    if (descEntidad!=null)
    	dataset.fieldValue("desc_entidad",descEntidad);
    else
    	dataset.fieldValue("desc_entidad","");
    if (razonSocial!=null)
    	dataset.fieldValue("razon_social",razonSocial);
    else
    	dataset.fieldValue("razon_social","");
    dataset.fieldValue("oid_moneda",oidMoneda);
    dataset.fieldValue("cod_moneda",codMoneda);
    if (fecEmision!=null)
    	dataset.fieldValue("fec_emision",fecEmision);
    else
    	dataset.fieldValue("fec_emision",Fecha.FECHA_NULA());
    if (fecVto!=null)
    	dataset.fieldValue("fec_vto",fecVto);
    else
    	dataset.fieldValue("fec_vto",Fecha.FECHA_NULA());
    if (importe!=null)
    	dataset.fieldValue("importe",importe);
    else
    	dataset.fieldValue("importe",new Integer(0));
    if (cupon!=null)
    	dataset.fieldValue("cupon",cupon);
    else
    	dataset.fieldValue("cupon",new Integer(0));
    if (lote!=null)
    	dataset.fieldValue("lote",lote);
    else
    	dataset.fieldValue("lote",new Integer(0));
    if (cuotas!=null)
    	dataset.fieldValue("cuotas",cuotas);
    else
    	dataset.fieldValue("cuotas",new Integer(0));
    dataset.fieldValue("comprobante", comprobante);
    if (fecha!=null)
    	dataset.fieldValue("fecha",fecha);
    else
    	dataset.fieldValue("fecha",Fecha.FECHA_NULA());    
  }
  
  private void traerValoresEnCajaChequeCliente(Caja caja) throws BaseException {
  	
	  IDataSet ds = getDataSetValoresEnCaja();
	  int secu = 0;
	  		  
	  // Traer los cheques de clientes
	  Iterator iterValores = Valor.getChequesTercerosEnCartera(caja,getSesion()).iterator();
	  while (iterValores.hasNext()) {
		  Valor valor = (Valor) iterValores.next();
		  cargarRegistroValoresEnCaja(ds,new Integer(++secu),new Integer(1),
                  valor.getTipovalor().getOIDInteger(),
                  valor.getOIDInteger(),
                  valor.getTipovalor().getDescripcion(),
                  new String(""),
                  valor.getNrocheque(),valor.getBanco().getDescripcion(),
                  valor.getSujeto().getRazon_social(),
                  valor.getTipovalor().getMoneda().getOIDInteger(),
                  valor.getTipovalor().getMoneda().getCodigo(),
                  valor.getFechaemision(),valor.getFechavto(),valor.getImporte(),
                  new Integer(0), new Integer(0), new Integer(0) , "", null);		  
	  }
	 	  
	  writeCliente(ds);
  }
  
}
