package com.srn.erp.general.op;

import java.util.Date;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpresa extends Operation {

  public TraerEmpresa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Empresa empresa = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       empresa = Empresa.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       empresa = Empresa.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEmpresa = getDataSetEmpresa();
    if (empresa != null) {
        cargarRegistroEmpresa(datasetEmpresa,
                         empresa.getOIDInteger(),
                         empresa.getCodigo(),
                         empresa.getRazon_social(),
                         empresa.getNombre_fantasia(),
                         empresa.getCalle_y_nro(),
                         empresa.getLocalidad(),
                         empresa.getCodigo_postal(),
                         empresa.getProvincia(),
                         empresa.getPais(),
                         empresa.getCategoria_iva(),
                         empresa.getCategoria_ib(),
                         empresa.getCuit(),
                         empresa.getNro_ing_brutos(),
                         empresa.isAgen_ret_iva(),
                         empresa.isAgen_ret_gan(),
                         empresa.isAgen_ret_ib(),
                         empresa.getArchivo_logo(),
                         empresa.isActivo(),
                         empresa.getArchXMLPoolBD(),
                         empresa.getInicioActividad(),
                         empresa.isAgentePercIBBsAs(),
                         empresa.isAgentePercIBCapFed(),
                         empresa.isAgentePercIVA()
                         );
    }
    writeCliente(datasetEmpresa);
  }

  private IDataSet getDataSetEmpresa() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEmpresa");
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_fantasia", Field.STRING, 50));
    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING,30));
    dataset.fieldDef(new Field("desc_pais", Field.INTEGER,100));
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cat_iva", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_cat_iva", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cat_ib", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_cat_ib", Field.STRING, 100));
    dataset.fieldDef(new Field("CUIT", Field.STRING, 30));
    dataset.fieldDef(new Field("nro_ing_brutos", Field.STRING, 30));
    dataset.fieldDef(new Field("agen_ret_iva", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("agen_ret_gan", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("agen_ret_ib", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("archivo_logo", Field.STRING, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("arch_xml_pool_bd", Field.STRING, 50));
    dataset.fieldDef(new Field("inicio_actividad", Field.DATE, 0));
    dataset.fieldDef(new Field("es_age_perc_ib_ba", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_age_perc_ib_cf", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_age_perc_iva", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEmpresa(IDataSet dataset,
                         Integer oid_empresa,
                         String codigo,
                         String razon_social,
                         String nombre_fantasia,
                         String calle_y_nro,
                         String localidad,
                         String codigo_postal,
                         Provincia provincia,
                         Pais pais,
                         CategoriaIVA cat_iva,
                         CategoriaIB cat_ib,
                         String CUIT,
                         String nro_ing_brutos,
                         Boolean agen_ret_iva,
                         Boolean agen_ret_gan,
                         Boolean agen_ret_ib,
                         String archivo_logo,
                         Boolean activo,
                         String arch_xml_pool_bd,
                         Date inicioActividad,
                         boolean esAgePercIBBsAs,
                         boolean esAgePercIBCapFed,
                         boolean esAgePercIVA) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_empresa", oid_empresa);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("razon_social", razon_social);
    dataset.fieldValue("nombre_fantasia", nombre_fantasia);
    dataset.fieldValue("calle_y_nro", calle_y_nro);
    dataset.fieldValue("localidad", localidad);
    dataset.fieldValue("codigo_postal", codigo_postal);
    if (provincia!=null) {
    	dataset.fieldValue("oid_provincia", provincia.getOID());
    	dataset.fieldValue("cod_provincia", provincia.getCodigo());
    	dataset.fieldValue("desc_provincia", provincia.getDescripcion());
    } else {
    	dataset.fieldValue("oid_provincia", "");
    	dataset.fieldValue("cod_provincia", "");
    	dataset.fieldValue("desc_provincia", "");
    }
    
    if (pais!=null) {
    	dataset.fieldValue("oid_pais", pais.getOID());
    	dataset.fieldValue("cod_pais", pais.getCodigo());
    	dataset.fieldValue("desc_pais", pais.getDescripcion());
    } else {
    	dataset.fieldValue("oid_pais", "");
    	dataset.fieldValue("cod_pais", "");
    	dataset.fieldValue("desc_pais", "");
    }
    
    if (cat_iva!=null) {
    	dataset.fieldValue("oid_cat_iva", cat_iva.getOID());
    	dataset.fieldValue("cod_cat_iva", cat_iva.getCodigo());
    	dataset.fieldValue("desc_cat_iva", cat_iva.getDescripcion());
    } else {
    	dataset.fieldValue("oid_cat_iva", "");
    	dataset.fieldValue("cod_cat_iva", "");
    	dataset.fieldValue("desc_cat_iva", "");
    }
    if (cat_ib!=null) {
    	dataset.fieldValue("oid_cat_ib", cat_ib.getOID());
    	dataset.fieldValue("cod_cat_ib", cat_ib.getCodigo());
    	dataset.fieldValue("desc_cat_ib", cat_ib.getDescripcion());
    } else {
    	dataset.fieldValue("oid_cat_ib", "");
    	dataset.fieldValue("cod_cat_ib", "");
    	dataset.fieldValue("desc_cat_ib", "");
    }
    
    dataset.fieldValue("CUIT", CUIT);
    dataset.fieldValue("nro_ing_brutos", nro_ing_brutos);
    dataset.fieldValue("agen_ret_iva", agen_ret_iva);
    dataset.fieldValue("agen_ret_gan", agen_ret_gan);
    dataset.fieldValue("agen_ret_ib", agen_ret_ib);
    dataset.fieldValue("archivo_logo", archivo_logo);
    dataset.fieldValue("activo", activo);
    if (arch_xml_pool_bd!=null)
      dataset.fieldValue("arch_xml_pool_bd", arch_xml_pool_bd);
    else
      dataset.fieldValue("arch_xml_pool_bd", "");
    dataset.fieldValue("inicio_actividad", inicioActividad);
    dataset.fieldValue("es_age_perc_ib_ba", new Boolean(esAgePercIBBsAs));
    dataset.fieldValue("es_age_perc_ib_cf", new Boolean(esAgePercIBCapFed));
    dataset.fieldValue("es_age_perc_iva", new Boolean(esAgePercIVA));

  }
}
