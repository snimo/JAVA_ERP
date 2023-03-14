package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoValor extends Operation {

  public TraerTipoValor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoValor tipovalor = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipovalor = TipoValor.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipovalor = TipoValor.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoValor = getDataSetTipoValor();
    if (tipovalor != null) {
        cargarRegistroTipoValor(datasetTipoValor,
                         tipovalor.getOIDInteger(),
                         tipovalor.getCodigo(),
                         tipovalor.getDescripcion(),
                         tipovalor.getCompo(),
                         tipovalor.getMoneda(),
                         tipovalor.isActivo(),
                         tipovalor.getCuentaImputable(),
                         tipovalor.isSeguimientoCaja(),
                         tipovalor.isDepositable(),
                         tipovalor.isDiscValBolDep(),
                         tipovalor.isUsarTipoValorEnOP(),
                         tipovalor.isDeudaFinanciera(),
                         tipovalor.isDeudaFinancieraProveedor(),
                         tipovalor.getCuenta(),
                         tipovalor.getCajaFija()
                         );
    }
    writeCliente(datasetTipoValor);
  }

  private IDataSet getDataSetTipoValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValor");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_moneda", Field.STRING, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ana_imp", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ana_imp", Field.STRING, 100));
    dataset.fieldDef(new Field("segui_caja", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("depositable", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("disc_val_bol_dep", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_tv_en_op", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_deuda_finan", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_deuda_finan_prov", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_caja_fija", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_caja_fija", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_caja_fija", Field.STRING, 100));
    
    return dataset;
  }

  private void cargarRegistroTipoValor(IDataSet dataset,
                         Integer oid_tipo_valor,
                         String codigo,
                         String descripcion,
                         String compo,
                         Moneda moneda,
                         Boolean activo,
                         CuentaImputable cuentaImputable,
                         Boolean seguimientoCaja,
                         Boolean depositable,
                         Boolean discValBolDep,
                         Boolean usarTipoValEnCaja,
                         Boolean esDeudaFinan,
                         Boolean esDeudaFinanProv,
                         Cuenta cuenta,
                         Caja cajaFija) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tipo_valor", oid_tipo_valor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("oid_moneda", moneda.getOID());
    dataset.fieldValue("activo", activo);
    if (cuentaImputable!=null) {
      dataset.fieldValue("oid_ai", cuentaImputable.getOIDInteger());
      dataset.fieldValue("codigo_ana_imp", cuentaImputable.getCodigo());
      dataset.fieldValue("desc_ana_imp", cuentaImputable.getDescripcion());
    } else {
      dataset.fieldValue("oid_ai", new Integer(0));
      dataset.fieldValue("codigo_ana_imp", "");
      dataset.fieldValue("desc_ana_imp", "");
    }
    dataset.fieldValue("segui_caja", seguimientoCaja);
    dataset.fieldValue("depositable", depositable);
    dataset.fieldValue("disc_val_bol_dep", discValBolDep);
    dataset.fieldValue("usar_tv_en_op", usarTipoValEnCaja);
    dataset.fieldValue("es_deuda_finan", esDeudaFinan);
    dataset.fieldValue("es_deuda_finan_prov", esDeudaFinanProv);
    
    if (cuenta!=null) {
    	dataset.fieldValue("oid_ana_con", cuenta.getOIDInteger());
    	dataset.fieldValue("cod_ana_con", cuenta.getCodigo());
    	dataset.fieldValue("desc_ana_con", cuenta.getDescripcion());
    } else {
    	dataset.fieldValue("oid_ana_con", "");
    	dataset.fieldValue("cod_ana_con", "");
    	dataset.fieldValue("desc_ana_con", "");
    }
    
    if (cajaFija!=null) {
    	dataset.fieldValue("oid_caja_fija", cajaFija.getOIDInteger());
    	dataset.fieldValue("cod_caja_fija", cajaFija.getCodigo());
    	dataset.fieldValue("desc_caja_fija", cajaFija.getDescripcion());
    } else {
    	dataset.fieldValue("oid_caja_fija", "");
    	dataset.fieldValue("cod_caja_fija", "");
    	dataset.fieldValue("desc_caja_fija", "");
    }
    
    

  }
}
