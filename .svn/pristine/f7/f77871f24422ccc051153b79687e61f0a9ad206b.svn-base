package com.srn.erp.general.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTalonarioRemito extends Operation {

  public TraerTalonarioRemito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    String tableName = mapaDatos.getString("nombreTabla");
    IDataSet dsTalonario = getDataSetTalonario(tableName);
    List talonarios = Talonario.getTalonariosRemito(getSesion());
    Iterator iterTalonarios = talonarios.iterator();
    while (iterTalonarios.hasNext()) {
      Talonario talonario = (Talonario) iterTalonarios.next();
      cargarRegistroTalonario(dsTalonario,talonario);
    }
    writeCliente(dsTalonario);
  }

  private IDataSet getDataSetTalonario(String nombreTabla) {
    IDataSet dataset = new TDataSet();
    dataset.create(nombreTabla);
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo_imp_asoc",Field.STRING, 15));
    dataset.fieldDef(new Field("oid_imp_fiscal",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_imp_comun",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc",Field.STRING, 39));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nom_arch_imp",Field.STRING, 100));
    dataset.fieldDef(new Field("primer_nro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_actual",Field.INTEGER, 0));
    dataset.fieldDef(new Field("ultimo_nro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_automatica",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fec_vto",Field.STRING, 10));
    dataset.fieldDef(new Field("cai",Field.STRING, 100));
    dataset.fieldDef(new Field("oid_uni_org",Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTalonario(IDataSet dataset,
                                       Talonario talonario) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("codigo", talonario.getCodigo());
    dataset.fieldValue("descripcion", talonario.getDescripcion());
    if (talonario.getImpo_imp_asoc()!=null)
      dataset.fieldValue("tipo_imp_asoc",talonario.getImpo_imp_asoc());
    else
      dataset.fieldValue("tipo_imp_asoc","");
    if (talonario.getImpresora_fiscal()!=null)
      dataset.fieldValue("oid_imp_fiscal",talonario.getImpresora_fiscal().getOID());
    else
      dataset.fieldValue("oid_imp_fiscal",0);
    if (talonario.getImpresora_comun()!=null)
      dataset.fieldValue("oid_imp_comun",talonario.getImpresora_comun().getOIDInteger());
    else
      dataset.fieldValue("oid_imp_comun",0);
    dataset.fieldValue("oid_tc",talonario.getTipo_comprobante().getOIDInteger());
    dataset.fieldValue("cod_tc",talonario.getTipo_comprobante().getCodigo());
    dataset.fieldValue("letra",talonario.getLetra());
    dataset.fieldValue("oid_lug_emi",talonario.getLugar_emision().getOIDInteger());
    dataset.fieldValue("nro_lug_emi",talonario.getLugar_emision().getLugemi());
    if (talonario.getNombre_archivo_impresion()!=null)
      dataset.fieldValue("nom_arch_imp",talonario.getNombre_archivo_impresion());
    else
      dataset.fieldValue("nom_arch_imp","");
    dataset.fieldValue("primer_nro",talonario.getPrimer_nro());
    dataset.fieldValue("nro_actual",talonario.getNro_actual());
    dataset.fieldValue("ultimo_nro",talonario.getUltimo_nro());
    dataset.fieldValue("nro_automatica",talonario.isNro_automatica());
    if (talonario.getFec_vto()!=null)
      dataset.fieldValue("fec_vto",Fecha.getddmmyyyy(talonario.getFec_vto()));
    else
      dataset.fieldValue("fec_vto","");
    if (talonario.getCai()!=null)
      dataset.fieldValue("cai",talonario.getCai());
    else
      dataset.fieldValue("cai","");
    if (talonario.getUnidad_organizativa()!=null)
      dataset.fieldValue("oid_uni_org",talonario.getUnidad_organizativa().getOIDInteger());
    else
      dataset.fieldValue("oid_uni_org",Fecha.FECHA_NULA());
    dataset.fieldValue("activo",talonario.isActivo());
  }
}
