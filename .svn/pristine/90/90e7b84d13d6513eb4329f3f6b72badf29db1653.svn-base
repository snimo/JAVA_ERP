package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EmpresaHabUsu;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UniOrgHabUsu;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpresaHabUsu extends Operation {

  private int oid = 0;

  public TraerEmpresaHabUsu() {
  }

  private int procesarAcceso(IDataSet ds,
                              Usuario usuario,
                              Empresa empresa,
                              Sucursal sucursal) throws BaseException {
    --oid;
    EmpresaHabUsu empreHabSuc = EmpresaHabUsu.getEmpresaHabUsu(usuario,empresa,sucursal,getSesion());
    if (empreHabSuc!=null) {
      cargarRegistroEmpresaHabUsu(ds,
                                  empreHabSuc.getOIDInteger(),
                                  usuario,
                                  empresa,
                                  sucursal,
                                  new Boolean(true),
                                  empreHabSuc.isUsarPorDefecto());
      return empreHabSuc.getOIDInteger().intValue();
    }
    else {
      cargarRegistroEmpresaHabUsu(ds,
                                  new Integer(oid),
                                  usuario,
                                  empresa,
                                  sucursal,
                                  new Boolean(false),
                                  new Boolean(false)
                                  );
      return oid;
    }

      // Procesar Acceso Unidades Organizacionales


  }

  private void procAccesoUniOrg(IDataSet ds,
                                Integer oidEmpHabUsu,
                                Usuario usuario,
                                Empresa empresa,
                                Sucursal sucursal) throws BaseException {
    Iterator iterUniOrg =
        sucursal.getUnidadesOrganizacionales().iterator();
    while (iterUniOrg.hasNext()) {
      UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
      UniOrgHabUsu uniOrgHabUsu = UniOrgHabUsu.getUniOrgHabUsu(uniOrg,
                                                               empresa,
                                                               sucursal,
                                                               usuario,
                                                               getSesion());
      if (uniOrgHabUsu!=null)
        cargarRegUniOrgHab(ds,uniOrgHabUsu.getOIDInteger(),oidEmpHabUsu,empresa,sucursal,uniOrg,new Boolean(true),usuario);
      else {
        --oid;
        cargarRegUniOrgHab(ds, new Integer(oid), oidEmpHabUsu,
                           empresa, sucursal, uniOrg, new Boolean(false),usuario);
      }
    }
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    EmpresaHabUsu empresahabusu = null;
    Integer oidUsuario = mapaDatos.getInteger("oid");
    Usuario usuario = Usuario.findByOid(oidUsuario, getSesion());
    IDataSet ds = getDataSetEmpresaHabUsu();
    IDataSet dsUniOrg = getDataSetUniOrgHab();

    Iterator iterEmpresas = Empresa.getEmpresas(getSesion()).iterator();
    while (iterEmpresas.hasNext()) {
      Empresa empresa = (Empresa) iterEmpresas.next();

      Iterator iterSucursales = Sucursal.getSucursales(getSesion()).iterator();
      while (iterSucursales.hasNext()) {
        Sucursal sucursal = (Sucursal) iterSucursales.next();
        int oidEmpSucHab = procesarAcceso(ds,usuario,empresa,sucursal);
        procAccesoUniOrg(dsUniOrg,
                         new Integer(oidEmpSucHab),
                         usuario,
                         empresa,
                         sucursal);
      }
    }
    writeCliente(ds);
    writeCliente(dsUniOrg);
  }

  private IDataSet getDataSetEmpresaHabUsu() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEmpresaHabUsu");
    dataset.fieldDef(new Field("oid_emp_hab_usu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_usuario", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_usuario", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_empresa", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_sucursal", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetUniOrgHab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUniOrgHab");
    dataset.fieldDef(new Field("oid_uni_org_hab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_emp_hab_usu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 0));
    dataset.fieldDef(new Field("acceso", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegUniOrgHab(IDataSet dataset,
                                  Integer oidUniOrgHab,
                                  Integer oidEmpHabSuc,
                                  Empresa empresa,
                                  Sucursal sucursal,
                                  UnidadOrganizativa unidadOrganizativa,
                                  Boolean acceso,
                                  Usuario usuario) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_uni_org_hab", oidUniOrgHab);
    dataset.fieldValue("oid_emp_hab_usu", oidEmpHabSuc);
    dataset.fieldValue("oid_empresa", empresa.getOIDInteger());
    dataset.fieldValue("oid_sucursal", sucursal.getOIDInteger());
    dataset.fieldValue("oid_uni_org", unidadOrganizativa.getOIDInteger());
    dataset.fieldValue("desc_uni_org", unidadOrganizativa.getDescripcion());
    dataset.fieldValue("acceso", acceso);
    dataset.fieldValue("oid_usuario", usuario.getOID());


  }


  private void cargarRegistroEmpresaHabUsu(IDataSet dataset,
                         Integer oid_emp_hab_usu,
                         Usuario usuario,
                         Empresa empresa,
                         Sucursal sucursal,
                         Boolean acceso,
                         Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_emp_hab_usu", oid_emp_hab_usu);
    dataset.fieldValue("oid_usuario", usuario.getOID());
    dataset.fieldValue("cod_usuario", usuario.getLogin());
    dataset.fieldValue("desc_usuario", usuario.getApellido()+" "+usuario.getNombre());
    dataset.fieldValue("oid_empresa", empresa.getOID());
    dataset.fieldValue("desc_empresa", empresa.getRazon_social());
    dataset.fieldValue("oid_sucursal", sucursal.getOID());
    dataset.fieldValue("desc_sucursal", sucursal.getDescripcion());
    dataset.fieldValue("habilitado", acceso);
    dataset.fieldValue("activo", new Boolean(true));
    dataset.fieldValue("oid_usuario", usuario.getOID());
    dataset.fieldValue("usar_por_defecto", usarPorDefecto);
  }
}
