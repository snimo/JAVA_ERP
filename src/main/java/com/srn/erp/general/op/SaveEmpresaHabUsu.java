package com.srn.erp.general.op;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EmpresaHabUsu;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UniOrgHabUsu;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEmpresaHabUsu extends Operation {

  public SaveEmpresaHabUsu() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEmpresaHabUsu");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        EmpresaHabUsu empresahabusu = EmpresaHabUsu.findByOid(dataset.getInteger("oid_emp_hab_usu"),getSesion());
        empresahabusu.setOID(dataset.getInteger("oid_emp_hab_usu"));
        empresahabusu.setUsuario(Usuario.findByOidProxy(dataset.getInteger("oid_usuario"),getSesion()));
        empresahabusu.setEmpresa(Empresa.findByOidProxy(dataset.getInteger("oid_empresa"),getSesion()));
        empresahabusu.setSucursal(Sucursal.findByOidProxy(dataset.getInteger("oid_sucursal"),getSesion()));
        empresahabusu.setUsarPorDefecto(dataset.getBoolean("usar_por_defecto"));
        if (dataset.getBoolean("habilitado").booleanValue()==false)
          empresahabusu.delete();
        setRefreshObjNeg(dataset.getInteger("oid_usuario"));

        IDataSet dsUniOrgHab = dataset.getDataSet("TUniOrgHab");
        dsUniOrgHab.first();
        while (!dsUniOrgHab.EOF()) {
          UniOrgHabUsu uniOrgHabUsu = UniOrgHabUsu.findByOid(dsUniOrgHab.getInteger("oid_uni_org_hab"),getSesion());
          uniOrgHabUsu.setEmpresa(Empresa.findByOidProxy(dsUniOrgHab.getInteger("oid_empresa"),getSesion()));
          uniOrgHabUsu.setSucursal(Sucursal.findByOidProxy(dsUniOrgHab.getInteger("oid_sucursal"),getSesion()));
          uniOrgHabUsu.setUsuario(Usuario.findByOidProxy(dsUniOrgHab.getInteger("oid_usuario"),getSesion()));
          uniOrgHabUsu.setUnidad_organizacion(UnidadOrganizativa.findByOidProxy(dsUniOrgHab.getInteger("oid_uni_org"),getSesion()));
          if (dsUniOrgHab.getBoolean("acceso").booleanValue()==false)
            uniOrgHabUsu.delete();
          empresahabusu.addUniOrgHab(uniOrgHabUsu);

          dsUniOrgHab.next();
        }

        addTransaccion(empresahabusu);
        dataset.next();
    }
  }

}
