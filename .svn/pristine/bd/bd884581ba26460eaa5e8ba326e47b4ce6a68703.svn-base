package com.srn.erp.general.op;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEmpresa extends Operation {

  public SaveEmpresa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEmpresa");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Empresa empresa = Empresa.findByOid(dataset.getInteger("oid_empresa"),getSesion());
        empresa.setOID(dataset.getInteger("oid_empresa"));
        empresa.setCodigo(dataset.getString("codigo"));
        empresa.setRazon_social(dataset.getString("razon_social"));
        empresa.setNombre_fantasia(dataset.getString("nombre_fantasia"));
        empresa.setCalle_y_nro(dataset.getString("calle_y_nro"));
        empresa.setLocalidad(dataset.getString("localidad"));
        empresa.setCodigo_postal(dataset.getString("codigo_postal"));
        empresa.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
        empresa.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"),getSesion()));
        empresa.setCategoria_iva(CategoriaIVA.findByOidProxy(dataset.getInteger("oid_cat_iva"),getSesion()));
        empresa.setCategoria_ib(CategoriaIB.findByOidProxy(dataset.getInteger("oid_cat_ib"),getSesion()));
        empresa.setCuit(dataset.getString("CUIT"));
        empresa.setNro_ing_brutos(dataset.getString("nro_ing_brutos"));
        empresa.setAgen_ret_iva(dataset.getBoolean("agen_ret_iva"));
        empresa.setAgen_ret_gan(dataset.getBoolean("agen_ret_gan"));
        empresa.setAgen_ret_ib(dataset.getBoolean("agen_ret_ib"));
        empresa.setArchivo_logo(dataset.getString("archivo_logo"));
        empresa.setActivo(dataset.getBoolean("activo"));
        empresa.setArchXMLPoolBD(dataset.getString("arch_xml_pool_bd"));
        empresa.setInicioActividad(dataset.getDate("inicio_actividad"));
        empresa.setAgentePercIBBsAs(dataset.getBoolean("es_age_perc_ib_ba").booleanValue());
        empresa.setAgentePercIBCapFed(dataset.getBoolean("es_age_perc_ib_cf").booleanValue());
        empresa.setAgentePercIVA(dataset.getBoolean("es_age_perc_iva").booleanValue());
        
        addTransaccion(empresa);
        dataset.next();
    }
  }

}
