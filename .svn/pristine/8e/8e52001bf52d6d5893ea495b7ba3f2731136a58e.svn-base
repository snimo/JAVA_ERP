package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EmpresaHabUsu;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpSucHabUsu extends Operation {

  private HashTableDatos empresasHab = new HashTableDatos();
  private HashTableDatos sucursalesHab = new HashTableDatos();
  private int oid = 0;

  public TraerEmpSucHabUsu() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsEmpHab = getDataSetEmpresa();
    IDataSet dsSucHab = getDataSetSucursal();

    Usuario usuario = Usuario.findByOid(mapaDatos.getInteger("oid_usuario"),getSesion());
    Iterator iterEmpSucHab =
        EmpresaHabUsu.getEmpHabUsu(usuario,getSesion()).iterator();
    while (iterEmpSucHab.hasNext()) {
      EmpresaHabUsu empSucHab = (EmpresaHabUsu) iterEmpSucHab.next();
      cargarEmpSucHab(empSucHab);
    }

    enviarRegistros(dsEmpHab,dsSucHab);

    writeCliente(dsEmpHab);
    writeCliente(dsSucHab);
  }

  private void enviarRegistros(IDataSet dsEmpHab,IDataSet dsSucHab) throws BaseException {
    Iterator iterOidEmpresa = empresasHab.keySet().iterator();
    while (iterOidEmpresa.hasNext()) {
      Integer oidEmpresa = (Integer) iterOidEmpresa.next();
      Empresa empresa = Empresa.findByOid(oidEmpresa,getSesion());
      cargarRegistroEmpresa(dsEmpHab,empresa);
      HashTableDatos listaSucursalesHab = (HashTableDatos) empresasHab.get(oidEmpresa);
      Iterator iterEmpSucHab = listaSucursalesHab.values().iterator();
      while (iterEmpSucHab.hasNext()) {
        EmpresaHabUsu empHabSuc = (EmpresaHabUsu)iterEmpSucHab.next();
        cargarRegistroSucursal(dsSucHab,
                               new Integer(++oid),
                               empHabSuc.getEmpresa(),
                               empHabSuc.getSucursal(),
                               empHabSuc.isUsarPorDefecto());
      }
    }
  }

  private void cargarEmpSucHab(EmpresaHabUsu empHabUsu) throws BaseException {
    HashTableDatos listaSucursales =
        (HashTableDatos) empresasHab.get(empHabUsu.getEmpresa().getOIDInteger());
    if (listaSucursales == null) {
      listaSucursales = new HashTableDatos();
      empresasHab.put(empHabUsu.getEmpresa().getOIDInteger(),
                      listaSucursales);
    }

    // Lista de Sucursales Habilitadas
    EmpresaHabUsu empHabSuc =
        (EmpresaHabUsu) listaSucursales.get(empHabUsu.getSucursal().getOIDInteger());
    if (empHabSuc == null)
      listaSucursales.put(empHabUsu.getSucursal().getOIDInteger(),
                          empHabUsu);
  }

  private IDataSet getDataSetEmpresa() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEmpresasHabilitadas");
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroEmpresa(IDataSet dataset,
                                     Empresa empresa) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_empresa", empresa.getOIDInteger());
    dataset.fieldValue("codigo", empresa.getCodigo());
    dataset.fieldValue("razon_social", empresa.getRazon_social());
  }

  private IDataSet getDataSetSucursal() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSucursalesHabilitadas");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroSucursal(IDataSet dataset,
                                     Integer oid,
                                     Empresa empresa,
                                     Sucursal sucursal,
                                     Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("oid_empresa", empresa.getOIDInteger());
    dataset.fieldValue("oid_sucursal", sucursal.getOIDInteger());
    dataset.fieldValue("codigo", sucursal.getCodigo());
    dataset.fieldValue("descripcion", sucursal.getDescripcion());
    dataset.fieldValue("usar_por_defecto", usarPorDefecto);
  }


}
