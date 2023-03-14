package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TalonarioCategoriaIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoriaIVA extends Operation {

  public TraerCategoriaIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CategoriaIVA categoriaIVA = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       categoriaIVA = CategoriaIVA.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       categoriaIVA = CategoriaIVA.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCategoriaIVA = getDataSetCategoriaIVA();
    IDataSet datasetTalCatIVA = getDataSetTalonarioCategoriaIVA();

    if (categoriaIVA != null) {
        cargarRegistroCategoriaIVA(datasetCategoriaIVA,
                         categoriaIVA.getOIDInteger(),
                         categoriaIVA.getCodigo(),
                         categoriaIVA.getDescripcion(),
                         categoriaIVA.getComportamiento(),
                         categoriaIVA.isActivo(),
                         categoriaIVA.isCalculaIVA(),
                         categoriaIVA.isDiscriminaIVA(),
                         categoriaIVA.isCalcPercIVA(),
                         categoriaIVA.getConcImpuestoIVA(),
                         categoriaIVA.isAgentePercIBBsAs(),
                         categoriaIVA.isAgentePercIBCapFed()
                         );
       Iterator iteTalHabCatIVA = categoriaIVA.getTalonariosCatIVA().iterator();
       while (iteTalHabCatIVA.hasNext()) {
         TalonarioCategoriaIVA talonarioCatIVA =
             (TalonarioCategoriaIVA) iteTalHabCatIVA.next();
         cargarRegistroTalonarioCategoriaIVA(datasetTalCatIVA,
                                             talonarioCatIVA.getOIDInteger(),
                                             talonarioCatIVA.getCategoria_iva(),
                                             talonarioCatIVA.getTalonario());
       }

    }
    writeCliente(datasetCategoriaIVA);
    writeCliente(datasetTalCatIVA);

  }

  private IDataSet getDataSetCategoriaIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCategoriaIVA");
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo_cat_iva", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calc_iva", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("disc_iva", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calc_perc_iva",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_conc_imp_piva",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_conc_imp_piva",Field.STRING, 30));
    dataset.fieldDef(new Field("desc_conc_imp_piva",Field.STRING, 60));
    dataset.fieldDef(new Field("es_age_perc_ib_ba", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_age_perc_ib_cf", Field.BOOLEAN, 0));
    
    

    return dataset;
  }

  private void cargarRegistroCategoriaIVA(IDataSet dataset,
                         Integer oid_cat_iva,
                         String codigo,
                         String descripcion,
                         String compo_cat_iva,
                         Boolean activo,
                         Boolean calcIVA,
                         Boolean discIVA,
                         Boolean calcPercIVA,
                         ConceptoImpuesto conceptoImpuPercIVA,
                         boolean es_age_perc_ib_ba,
                         boolean es_age_perc_ib_cf) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cat_iva", oid_cat_iva);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo_cat_iva", compo_cat_iva);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("calc_iva", calcIVA);
    dataset.fieldValue("disc_iva", discIVA);
    dataset.fieldValue("calc_perc_iva",calcPercIVA);
    if (conceptoImpuPercIVA!=null) {
      dataset.fieldValue("oid_conc_imp_piva",conceptoImpuPercIVA.getOIDInteger());
      dataset.fieldValue("cod_conc_imp_piva",conceptoImpuPercIVA.getCodigo());
      dataset.fieldValue("desc_conc_imp_piva",conceptoImpuPercIVA.getDescripcion());
    } else {
      dataset.fieldValue("oid_conc_imp_piva",0);
      dataset.fieldValue("cod_conc_imp_piva","");
      dataset.fieldValue("desc_conc_imp_piva","");
    }
    dataset.fieldValue("es_age_perc_ib_ba", new Boolean(es_age_perc_ib_ba));
    dataset.fieldValue("es_age_perc_ib_cf", new Boolean(es_age_perc_ib_cf));
    

  }

  private IDataSet getDataSetTalonarioCategoriaIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonarioCategoriaIVA");
    dataset.fieldDef(new Field("oid_tal_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));

    return dataset;
  }

  private void cargarRegistroTalonarioCategoriaIVA(IDataSet dataset,
                         Integer oid_tal_cat_iva,
                         CategoriaIVA categoriaIVA,
                         Talonario talonario) {
    dataset.append();
    dataset.fieldValue("oid_tal_cat_iva", oid_tal_cat_iva);
    dataset.fieldValue("oid_cat_iva", categoriaIVA.getOIDInteger());
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("activo", new Boolean(true));
  }



}
