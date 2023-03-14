package com.srn.erp.general.op;

import framework.applicarionServer.bm.Seguridad.ConfiguracionBD;
import framework.applicarionServer.bm.Seguridad.EmpSucHabBD;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfigBD extends Operation {

  public SaveConfigBD() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConfigBD");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConfiguracionBD confBD = ConfiguracionBD.findByOid(dataset.getInteger("oid_bd_conf"),getSesion());
        confBD.setOid_nro_base(dataset.getInteger("oid_nro_base"));
        confBD.setAllow_prog_cc(dataset.getBoolean("allow_prog_cc"));

        IDataSet dsEmpSucHabBD = dataset.getDataSet("TEmpSucHabBD");
        dsEmpSucHabBD.first();
        while (!dsEmpSucHabBD.EOF()) {
          EmpSucHabBD empSucHabBD = EmpSucHabBD.findByOid(dsEmpSucHabBD.getInteger("oid_emp_suc"),getSesion());
          empSucHabBD.setOid_empresa(dsEmpSucHabBD.getInteger("oid_empresa"));
          empSucHabBD.setOid_sucursal(dsEmpSucHabBD.getInteger("oid_sucursal"));
          if (dsEmpSucHabBD.getBoolean("acceso").booleanValue()==false)
              empSucHabBD.delete();
          confBD.addEmpSucHabBD(empSucHabBD);
          dsEmpSucHabBD.next();
        }

        addTransaccion(confBD);
        dataset.next();
    }
  }

}
