package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bm.Seguridad.ConfiguracionBD;
import framework.applicarionServer.bm.Seguridad.EmpSucHabBD;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfigBD extends Operation {

  public TraerConfigBD() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dataset = getDataSetConfigBD();
    IDataSet dsEmpSuc = getDataSetEmpSucHabBD();

    ConfiguracionBD confBD = ConfiguracionBD.findByOid(mapaDatos.getInteger("oid"),getSesion());
    cargarRegistroConfigBD(dataset,confBD.getOIDInteger(),confBD.getOid_nro_base(),confBD.isAllow_prog_cc());
    mostrarEmpSucHab(dsEmpSuc);

    writeCliente(dataset);
    writeCliente(dsEmpSuc);
  }

  private void mostrarEmpSucHab(IDataSet ds) throws BaseException {
    int oid = 0;
    int oidRecord = 0;
    Iterator iterEmpresas = Empresa.getEmpresas(getSesion()).iterator();
    while (iterEmpresas.hasNext()) {
      Empresa empresa = (Empresa) iterEmpresas.next();
      Iterator iterSucursales = Sucursal.getSucursales(getSesion()).iterator();
      while (iterSucursales.hasNext()) {
        Sucursal sucursal = (Sucursal) iterSucursales.next();
        EmpSucHabBD empSucHabBD = EmpSucHabBD.getEmpSucHabBD(
                                     empresa.getOIDInteger(),
                                     sucursal.getOIDInteger(),
                                     getSesion());
       boolean acceso = false;
       if (empSucHabBD!=null){
         acceso = true;
         oidRecord = empSucHabBD.getOID();
       }
       else {
         acceso = false;
         --oid;
         oidRecord = oid;
       }

       cargarRegistroEmpSucBD(ds,new Integer(oidRecord),empresa,sucursal,new Boolean(acceso));

      }
    }

  }


  private IDataSet getDataSetConfigBD() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConfigBD");
    dataset.fieldDef(new Field("oid_bd_conf", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_nro_base", Field.STRING, 50));
    dataset.fieldDef(new Field("allow_prog_cc", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetEmpSucHabBD() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEmpSucHabBD");
    dataset.fieldDef(new Field("oid_emp_suc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_empresa", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_sucursal", Field.STRING, 50));
    dataset.fieldDef(new Field("acceso", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEmpSucBD(
                     IDataSet dataset,
                     Integer oid,
                     Empresa empresa,
                     Sucursal sucursal,
                     Boolean acceso) throws BaseException  {
                   dataset.append();
                   dataset.fieldValue("oid_emp_suc", oid);
                   dataset.fieldValue("oid_empresa", empresa.getOIDInteger());
                   dataset.fieldValue("desc_empresa", empresa.getRazon_social());
                   dataset.fieldValue("oid_sucursal", sucursal.getOIDInteger());
                   dataset.fieldValue("desc_sucursal", sucursal.getDescripcion());
                   dataset.fieldValue("acceso", acceso);
  }



  private void cargarRegistroConfigBD(
                     IDataSet dataset,
                     Integer oidBDConf,
                     Integer oidNroBase,
                     Boolean allowProCC) throws BaseException  {
                   dataset.append();
                   dataset.fieldValue("oid_bd_conf", oidBDConf);
                   dataset.fieldValue("oid_nro_base", oidNroBase);
                   dataset.fieldValue("allow_prog_cc", allowProCC);
  }



}
