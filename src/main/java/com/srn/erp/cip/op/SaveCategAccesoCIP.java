package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoPuertaCIP;
import com.srn.erp.cip.bm.HabilitadorCategAcc;
import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.SubGrupoCategAcceso;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCategAccesoCIP extends Operation { 

  public SaveCategAccesoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCategAccesoCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
        CategAccesoCIP categaccesocip = CategAccesoCIP.findByOid(dataset.getInteger("oid_categ_acceso"),getSesion());
        categaccesocip.setOID(dataset.getInteger("oid_categ_acceso"));
        categaccesocip.setCodigo(dataset.getString("codigo"));
        categaccesocip.setDescripcion(dataset.getString("descripcion"));
        categaccesocip.setActivo(dataset.getBoolean("activo"));
        categaccesocip.setSubGrupoCategAcceso(SubGrupoCategAcceso.findByOidProxy(dataset.getInteger("oid_sub_grupo_categ"), this.getSesion()));
        
        IDataSet dsHabilitadores = dataset.getDataSet("THabilitadorCategAcc");
        dsHabilitadores.first();
        while (!dsHabilitadores.EOF()) {
        	PerfilFuncional perfil =
        		(PerfilFuncional) PerfilFuncional.findByOidProxy(dsHabilitadores.getInteger("oid_perfil_func"), this.getSesion());
        	
        	if (dsHabilitadores.getBoolean("activo")==true) {

            	HabilitadorCategAcc habilitadorCategAcc = 
            		HabilitadorCategAcc.getHabilitadorCategAcc(categaccesocip, perfil, this.getSesion());
            	
            	if (habilitadorCategAcc == null) {
            		HabilitadorCategAcc buscarHabilitadorCategAcc = 
            			(HabilitadorCategAcc) HabilitadorCategAcc.getNew(HabilitadorCategAcc.NICKNAME, this.getSesion());
            		buscarHabilitadorCategAcc.setCategoria_acceso(categaccesocip);
            		buscarHabilitadorCategAcc.setPerfil_funcional(perfil);
            		buscarHabilitadorCategAcc.setActivo(true);
            		categaccesocip.addPerfilHabilitador(buscarHabilitadorCategAcc);
            	}
        		
        	} else {

            	HabilitadorCategAcc habilitadorCategAcc = 
            		HabilitadorCategAcc.getHabilitadorCategAcc(categaccesocip, perfil, this.getSesion());
            	if (habilitadorCategAcc!=null) {
            		habilitadorCategAcc.delete();
            		categaccesocip.addPerfilHabilitador(habilitadorCategAcc);
            	}
        		
        		
        	}
        	
        	dsHabilitadores.next();
        	
        }
        
        
        IDataSet dsPuertasZona = dataset.getDataSet("TPuertasEnZonas");
        dsPuertasZona.first();
        while (!dsPuertasZona.EOF()) {
        	
        	PlanoCIP plano            = PlanoCIP.findByOidProxy(dsPuertasZona.getInteger("oid_plano"), this.getSesion());
        	Puerta   puerta           = Puerta.findByOidProxy(dsPuertasZona.getInteger("oid_puerta"), this.getSesion());
        	boolean  habilitarEntrada = dsPuertasZona.getBoolean("hab_entrada");
        	boolean  habilitarSalida  = dsPuertasZona.getBoolean("hab_salida");
        	
        	CategAccesoPuertaCIP categAccesoPuertaCIP = 
        		CategAccesoPuertaCIP.getCategAccesoPuerta(categaccesocip, puerta, this.getSesion());
        	
        	if ((habilitarEntrada == false) && (habilitarSalida == false)) {
        		
        		if (categAccesoPuertaCIP!=null) {
        			categAccesoPuertaCIP.delete();
        			categaccesocip.addCategAccesoPuerta(categAccesoPuertaCIP);
        		}
        		
        	} else {
        		
        		if (categAccesoPuertaCIP==null) {
        			categAccesoPuertaCIP = (CategAccesoPuertaCIP) CategAccesoPuertaCIP.getNew(CategAccesoPuertaCIP.NICKNAME, this.getSesion());
        			categAccesoPuertaCIP.setCategoria(categaccesocip);
        			categAccesoPuertaCIP.setPuerta(puerta);
        			categAccesoPuertaCIP.setHab_entrada(habilitarEntrada);
        			categAccesoPuertaCIP.setHab_salida(habilitarSalida);
        			categAccesoPuertaCIP.setActivo(true);
        			categaccesocip.addCategAccesoPuerta(categAccesoPuertaCIP);
        		} else {

        			categAccesoPuertaCIP.setHab_entrada(habilitarEntrada);
        			categAccesoPuertaCIP.setHab_salida(habilitarSalida);
        			categAccesoPuertaCIP.setActivo(true);
        			categaccesocip.addCategAccesoPuerta(categAccesoPuertaCIP);
        			
        		}
        	}
        	
        	dsPuertasZona.next();	
        }
        
        
        
        addTransaccion(categaccesocip);
        dataset.next();
    }
  }
  
}
