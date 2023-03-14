package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.AnuladorAsientoCab;
import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.InformarComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.Validar;
import framework.request.bl.XML.IDataSet;

public class AnularAsientoIngManual extends Operation {

  private AnuladorAsientoCab anuladorAsientoCab = null;

  public AnularAsientoIngManual() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TAnularAsientoManual");
    validarAsientoOK(dataset);
    anularAsientoManual(dataset);
  }

  private void validarAsientoOK(IDataSet dataset) throws BaseException {
    dataset.first();
    while (!dataset.EOF()) {
      ComproCab comproCab = ComproCab.findByOidCompro(dataset.getInteger("oid_cco"), getSesion());
      if (comproCab == null) throw new ExceptionValidation(null,"Comprobante Inexistente");
      if (!comproCab.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_ASIENTO_MANUAL))
         throw new ExceptionValidation(null,"El asiento no corresponde a un ingreso manual de asientos");
      dataset.next();
    }

  }
  
  

  private void anularAsientoManual(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        AsientoManual asientoManual = AsientoManual.findByOid(dataset.getInteger("oid_cco"),getSesion());
        if (asientoManual.getComproConta().isAnulado().booleanValue())
          throw new ExceptionValidation(null,"El comprobante ya se encuentra anulado");
        asientoManual.setImputacionAnulacion(dataset.getDate("fec_imputacion"));
        asientoManual.setComentarioAnulacion(dataset.getString("comentario"));
        asientoManual.setEstado(ComproCab.ESTADO_ALTA);
        asientoManual.setContabiliza(true);
        anuladorAsientoCab = asientoManual.anularAsiento();
        dataset.next();
    }
  }

  protected void afterSave() throws BaseException {

    InformarComprobante infoCompro = new InformarComprobante(
      anuladorAsientoCab.getOIDInteger(),
      anuladorAsientoCab.getDescripcion());

    writeCliente(infoCompro.getDataSetInfoCompro());

  }


}
