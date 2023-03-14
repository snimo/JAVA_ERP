package com.srn.erp.impuestos.op;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TalonarioCategoriaIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCategoriaIVA extends Operation {

  public SaveCategoriaIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCategoriaIVA");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CategoriaIVA categoriaiva = CategoriaIVA.findByOid(dataset.getInteger("oid_cat_iva"),getSesion());
        categoriaiva.setOID(dataset.getInteger("oid_cat_iva"));
        categoriaiva.setCodigo(dataset.getString("codigo"));
        categoriaiva.setDescripcion(dataset.getString("descripcion"));
        categoriaiva.setComportamiento(dataset.getString("compo_cat_iva"));
        categoriaiva.setActivo(dataset.getBoolean("activo"));
        categoriaiva.setDiscriminaIVA(dataset.getBoolean("disc_iva"));
        categoriaiva.setCalculaIVA(dataset.getBoolean("calc_iva"));
        categoriaiva.setCalculaPercIVA(dataset.getBoolean("calc_perc_iva"));
        categoriaiva.setConcImpuestoIVA(ConceptoImpuesto.findByOid(dataset.getInteger("oid_conc_imp_piva"),getSesion()));
        categoriaiva.setAgentePercIBBsAs(dataset.getBoolean("es_age_perc_ib_ba").booleanValue());
        categoriaiva.setAgentePercIBCapFed(dataset.getBoolean("es_age_perc_ib_cf").booleanValue());
        

        IDataSet dsTalonarios = dataset.getDataSet("TTalonarioCategoriaIVA");
        dsTalonarios.first();
        while (!dsTalonarios.EOF()) {
          TalonarioCategoriaIVA talCatIVA = TalonarioCategoriaIVA.findByOid(dsTalonarios.getInteger("oid_tal_cat_iva"),getSesion());
          talCatIVA.setCategoria_iva(categoriaiva);
          talCatIVA.setTalonario(Talonario.findByOidProxy(dsTalonarios.getInteger("oid_talonario"),getSesion()));
          if (dsTalonarios.getBoolean("activo").booleanValue()==false) talCatIVA.delete();
          categoriaiva.addTalonarioCategoriaIVA(talCatIVA);
          dsTalonarios.next();
        }

        addTransaccion(categoriaiva);
        dataset.next();
    }
  }

}
