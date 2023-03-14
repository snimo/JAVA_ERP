package com.srn.erp.general.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.GrupoClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveClasificadorEntidad extends Operation {

  public SaveClasificadorEntidad() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TClasificadorEntidad");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ClasificadorEntidad clasificadorentidad = ClasificadorEntidad.findByOid(dataset.getInteger("oid_clasif_ent"),getSesion());
        clasificadorentidad.setOID(dataset.getInteger("oid_clasif_ent"));
        clasificadorentidad.setCodigo(dataset.getString("codigo"));
        clasificadorentidad.setDescripcion(dataset.getString("descripcion"));
        clasificadorentidad.setNickname(dataset.getString("nickname"));
        clasificadorentidad.setObligatorio(dataset.getBoolean("obligatorio"));
        clasificadorentidad.setValor_default(dataset.getInteger("oid_val_default"));
        clasificadorentidad.setActivo(dataset.getBoolean("activo"));
        if (clasificadorentidad.isNew())
        	clasificadorentidad.setNroClasif(new Integer(clasificadorentidad.getUltNroClasifCreado()+1));
        clasificadorentidad.setGrupoClasificadorEntidad(GrupoClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_grupo_clasif"),getSesion()));
        
        IDataSet dsValorClasif = dataset.getDataSet("TValorClasificador");
        dsValorClasif.first();
        while (!dsValorClasif.EOF()) {

          ValorClasificadorEntidad valorClasifEntidad =
              ValorClasificadorEntidad.findByOid(dsValorClasif.getInteger("oid_val_clasif_ent"),getSesion());
          valorClasifEntidad.setClasificador_entidad(clasificadorentidad);
          valorClasifEntidad.setOid_item(dsValorClasif.getInteger("oid_item"));
          valorClasifEntidad.setCodigo(dsValorClasif.getString("codigo"));
          valorClasifEntidad.setDescripcion(dsValorClasif.getString("descripcion"));
          valorClasifEntidad.setOid_item_padre(dsValorClasif.getInteger("oid_item_padre"));
          valorClasifEntidad.setActivo(dsValorClasif.getBoolean("activo"));
          valorClasifEntidad.setOrden(dsValorClasif.getInteger("orden"));
          valorClasifEntidad.setTipo(dsValorClasif.getString("tipo"));
          valorClasifEntidad.setCodigoDesde(dsValorClasif.getString("codigo_desde"));
          valorClasifEntidad.setCodigoHasta(dsValorClasif.getString("codigo_hasta"));

          if (valorClasifEntidad.isActivo().booleanValue()==false)
            valorClasifEntidad.delete();

          clasificadorentidad.addValorClasificador(valorClasifEntidad);

          dsValorClasif.next();
        }

        addTransaccion(clasificadorentidad);
        dataset.next();
    }
  }

}
