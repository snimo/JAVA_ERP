package com.srn.erp.pagos.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.pagos.bm.CtaHabMotivoPagosVarios;
import com.srn.erp.pagos.bm.MotivoPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoPago extends Operation {

  public SaveMotivoPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TMotivoPago");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        MotivoPago motivopago = MotivoPago.findByOid(dataset.getInteger("oid_motivo_pago"),getSesion());
        motivopago.setOID(dataset.getInteger("oid_motivo_pago"));
        motivopago.setCodigo(dataset.getString("codigo"));
        motivopago.setDescripcion(dataset.getString("descripcion"));
        motivopago.setCompo(dataset.getString("compo"));
        motivopago.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsCtasHab = dataset.getDataSet("TCtaHabMotivoPagosVarios");
        dsCtasHab.first();
        while (!dsCtasHab.EOF()) {
        	CtaHabMotivoPagosVarios ctaHab = CtaHabMotivoPagosVarios.findByOid(dsCtasHab.getInteger("oid_cta_hab"), this.getSesion());
        	ctaHab.setMotivo_pago(MotivoPago.findByOidProxy(dsCtasHab.getInteger("oid_motivo_pago"), this.getSesion()));
        	ctaHab.setCuenta(Cuenta.findByOidProxy(dsCtasHab.getInteger("oid_ana_con"), this.getSesion()));
        	ctaHab.setActivo(dsCtasHab.getBoolean("activo"));
        	if (!ctaHab.isActivo())
        		ctaHab.delete();
        	motivopago.addCtaHabPagosVarios(ctaHab);
        	dsCtasHab.next();
        }
        
        
        addTransaccion(motivopago);
        dataset.next();
    }
  }

}
