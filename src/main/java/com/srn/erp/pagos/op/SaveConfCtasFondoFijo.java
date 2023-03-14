package com.srn.erp.pagos.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.pagos.bm.RendicionFFUniOrg;
import com.srn.erp.pagos.bm.RendicionFFUniOrgCta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfCtasFondoFijo extends Operation {

  public SaveConfCtasFondoFijo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TUniOrgFF");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        RendicionFFUniOrg rendFFUniOrg = RendicionFFUniOrg.findByOid(dataset.getInteger("oid_uni_org_ff"),getSesion());
        rendFFUniOrg.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_uni_org"),this.getSesion()));
        rendFFUniOrg.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsCtas = dataset.getDataSet("TUniOrgFFCta");
        dsCtas.first();
        while (!dsCtas.EOF()) {
        	RendicionFFUniOrgCta rendFFUniOrgCtas = (RendicionFFUniOrgCta) RendicionFFUniOrgCta.findByOid(dsCtas.getInteger("oid_ff_cta"),this.getSesion());
        	rendFFUniOrgCtas.setUnidad_organizativa_ff(rendFFUniOrg);
        	rendFFUniOrgCtas.setCuenta(Cuenta.findByOidProxy(dsCtas.getInteger("oid_ana_con"),this.getSesion()));
        	rendFFUniOrgCtas.setActivo(dsCtas.getBoolean("activo"));
        	
        	if (!rendFFUniOrgCtas.isActivo())
        		rendFFUniOrgCtas.delete();
        	
        	rendFFUniOrg.addCtaRendFondoFijo(rendFFUniOrgCtas);
        	
        	dsCtas.next();
        }
        
        
        addTransaccion(rendFFUniOrg);
        dataset.next();
    }
  }

}
