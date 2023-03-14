package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SavePermisosInternos extends Operation { 

  public SavePermisosInternos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPermisosInternos"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PermisosInternos permisosinternos = PermisosInternos.findByOid(dataset.getInteger("oid_permiso_int"),getSesion());
        permisosinternos.setOID(dataset.getInteger("oid_permiso_int"));
        permisosinternos.setCodigo(dataset.getString("codigo"));
        permisosinternos.setDescripcion(dataset.getString("descripcion"));
        permisosinternos.setActivo(dataset.getBoolean("activo"));
        permisosinternos.setPrioridad(dataset.getInteger("prioridad"));
        
        IDataSet dsReglasPermInt = dataset.getDataSet("TReglasPermisosInt");
        dsReglasPermInt.first();
        while (!dsReglasPermInt.EOF()) {
        	
        	ReglasPermisosInt reglaPermisosInt = ReglasPermisosInt.findByOid(dsReglasPermInt.getInteger("oid_regla_permiso"), this.getSesion());
        	reglaPermisosInt.setPermisosinternos(permisosinternos);
        	reglaPermisosInt.setPrioridad(dsReglasPermInt.getInteger("prioridad"));
        	reglaPermisosInt.setDescripcion(dsReglasPermInt.getString("descripcion"));
        	reglaPermisosInt.setEs_una_vista(dsReglasPermInt.getBoolean("es_una_vista"));
        	reglaPermisosInt.setActivo(dsReglasPermInt.getBoolean("activo"));
        	
        	IDataSet dsAccesoIntPuerta = dsReglasPermInt.getDataSet("TAccesoInternoPuerta");
        	dsAccesoIntPuerta.first();
        	while (!dsAccesoIntPuerta.EOF()) {
        		AccesoInternoPuerta accesoInternoPuerta = AccesoInternoPuerta.findByOid(dsAccesoIntPuerta.getInteger("oid_acc_int_pue"), this.getSesion());
        		accesoInternoPuerta.setSecu(dsAccesoIntPuerta.getInteger("secu"));
        		accesoInternoPuerta.setRegla(ReglasPermisosInt.findByOidProxy(dsAccesoIntPuerta.getInteger("oid_regla_permiso"), this.getSesion()));
        		accesoInternoPuerta.setPuerta(Puerta.findByOidProxy(dsAccesoIntPuerta.getInteger("oid_puerta"), this.getSesion()));
        		accesoInternoPuerta.setPrecond_entrada(dsAccesoIntPuerta.getString("precond_entrada"));
        		accesoInternoPuerta.setTipo_compo_entra(dsAccesoIntPuerta.getString("tipo_compo_entra"));
        		accesoInternoPuerta.setPrecond_salida(dsAccesoIntPuerta.getString("precond_salida"));
        		accesoInternoPuerta.setTipo_compo_sali(dsAccesoIntPuerta.getString("tipo_compo_sali"));
        		accesoInternoPuerta.setActivo(dsAccesoIntPuerta.getBoolean("activo"));
        		accesoInternoPuerta.setMensajeEntrada(dsAccesoIntPuerta.getString("mensaje_entrada"));
        		accesoInternoPuerta.setMensajeSalida(dsAccesoIntPuerta.getString("mensaje_salida"));
        		accesoInternoPuerta.setTipoCtrlFhEnt(dsAccesoIntPuerta.getString("tipo_ctrl_fh_ent"));
        		accesoInternoPuerta.setTipoCtrlFhSal(dsAccesoIntPuerta.getString("tipo_ctrl_fh_sal"));
        		accesoInternoPuerta.setMinEntAntFhEnt(dsAccesoIntPuerta.getInteger("min_ent_ant_fh_ent"));
        		accesoInternoPuerta.setMinEntDesFhEnt(dsAccesoIntPuerta.getInteger("min_ent_des_fh_ent"));
        		accesoInternoPuerta.setMinEntAntFhSal(dsAccesoIntPuerta.getInteger("min_ent_ant_fh_sal"));
        		accesoInternoPuerta.setMinEntDesFhSal(dsAccesoIntPuerta.getInteger("min_ent_des_fh_sal"));
        		accesoInternoPuerta.setMinEntDesFhSal(dsAccesoIntPuerta.getInteger("min_ent_des_fh_sal"));
        		accesoInternoPuerta.setSalSexo(dsAccesoIntPuerta.getString("SAL_SEXO"));
        		accesoInternoPuerta.setEntSexo(dsAccesoIntPuerta.getString("ENT_SEXO"));
        		reglaPermisosInt.addAccesoInternoPuerta(accesoInternoPuerta);
        		
        		dsAccesoIntPuerta.next();
        	}
        	
        	
        	IDataSet dsPermisoIntLeg = dsReglasPermInt.getDataSet("TPermisoIntLeg");
        	dsPermisoIntLeg.first();
        	while (!dsPermisoIntLeg.EOF()) {
        		
        		PermisoInternoLegajo permisoInternoLegajo = PermisoInternoLegajo.findByOid(dsPermisoIntLeg.getInteger("oid_perm_int_leg"), this.getSesion());
        		permisoInternoLegajo.setRegla_permiso(reglaPermisosInt);
        		permisoInternoLegajo.setLegajo(Legajo.findByOidProxy(dsPermisoIntLeg.getInteger("oid_legajo"), this.getSesion()));
        		permisoInternoLegajo.setActivo(dsPermisoIntLeg.getBoolean("activo"));
        	
        		reglaPermisosInt.addAccesoInternoLegajo(permisoInternoLegajo);
        		
        		dsPermisoIntLeg.next();
        	}        	
        	
        	IDataSet dsPermisoIntSec = dsReglasPermInt.getDataSet("TPermisoIntSec");
        	dsPermisoIntSec.first();
        	while (!dsPermisoIntSec.EOF()) {
        		
        		ValorClasificadorEntidad valClasifPermIntSec = 
        			ValorClasificadorEntidad.findByOidProxy(dsPermisoIntSec.getInteger("oid_val_clasif_sec"), this.getSesion());
        		
        		PermisoInternoSector permisoInternoSector = 
        			PermisoInternoSector.getPermisoInternoSector(reglaPermisosInt, valClasifPermIntSec, this.getSesion());
        		
        		if (permisoInternoSector==null) {
        			permisoInternoSector = (PermisoInternoSector) PermisoInternoSector.getNew(PermisoInternoSector.NICKNAME, this.getSesion());
        		}
        		
        		permisoInternoSector.setRegla_permiso(reglaPermisosInt);
        		permisoInternoSector.setVal_clasif_sector(valClasifPermIntSec);
        		permisoInternoSector.setActivo(dsPermisoIntSec.getBoolean("activo"));
        		
        		reglaPermisosInt.addAccesoInternoSector(permisoInternoSector);
        		
        		dsPermisoIntSec.next();
        	}
        	
        	IDataSet dsPermisoIntEmp = dsReglasPermInt.getDataSet("TPermisoIntEmp");
        	dsPermisoIntEmp.first();
        	while (!dsPermisoIntEmp.EOF()) {
        		
        		ValorClasificadorEntidad valClasifPermIntEmp = 
        			ValorClasificadorEntidad.findByOidProxy(dsPermisoIntEmp.getInteger("oid_val_clasif_emp"), this.getSesion());
        		
        		PermisoInternoEmpresa permisoInternoEmpresa = 
        			PermisoInternoEmpresa.getPermisoInternoEmpresa(reglaPermisosInt, valClasifPermIntEmp, this.getSesion());
        		
        		if (permisoInternoEmpresa==null) {
        			permisoInternoEmpresa = (PermisoInternoEmpresa) PermisoInternoEmpresa.getNew(PermisoInternoEmpresa.NICKNAME, this.getSesion());
        		}
        		
        		permisoInternoEmpresa.setRegla_permiso(reglaPermisosInt);
        		permisoInternoEmpresa.setVal_clasif_empresa(valClasifPermIntEmp);
        		permisoInternoEmpresa.setActivo(dsPermisoIntEmp.getBoolean("activo"));
        		
        		reglaPermisosInt.addAccesoInternoEmpresa(permisoInternoEmpresa);
        		
        		dsPermisoIntEmp.next();
        	}        	
        	
        	IDataSet dsPermisoIntPue = dsReglasPermInt.getDataSet("TPermisoIntPue");
        	dsPermisoIntPue.first();
        	while (!dsPermisoIntPue.EOF()) {
        		
        		ValorClasificadorEntidad valClasifPermIntPue = 
        			ValorClasificadorEntidad.findByOidProxy(dsPermisoIntPue.getInteger("oid_val_clasif_pue"), this.getSesion());
        		
        		PermisoInternoPuesto permisoInternoPuesto = 
        			PermisoInternoPuesto.getPermisoInternoPuesto(reglaPermisosInt, valClasifPermIntPue, this.getSesion());
        		
        		if (permisoInternoPuesto==null) {
        			permisoInternoPuesto = (PermisoInternoPuesto) PermisoInternoPuesto.getNew(PermisoInternoPuesto.NICKNAME, this.getSesion());
        		}
        		
        		permisoInternoPuesto.setRegla_permiso(reglaPermisosInt);
        		permisoInternoPuesto.setVal_clasif_puesto(valClasifPermIntPue);
        		permisoInternoPuesto.setActivo(dsPermisoIntPue.getBoolean("activo"));
        		
        		reglaPermisosInt.addAccesoInternoPuesto(permisoInternoPuesto);
        		
        		dsPermisoIntPue.next();
        	}        	
        	
        	
        	IDataSet dsPermisoIntEst = dsReglasPermInt.getDataSet("TPermisoIntEst");
        	dsPermisoIntEst.first();
        	while (!dsPermisoIntEst.EOF()) {
        		
        		EstadoCIP estadoCIP = 
        			EstadoCIP.findByOidProxy(dsPermisoIntEst.getInteger("oid_estado"), this.getSesion());
        		
        		PermisoInternoEstado permisoInternoEstado = 
        			PermisoInternoEstado.getPermisoInternoEstado(reglaPermisosInt, estadoCIP, this.getSesion());
        		
        		if (permisoInternoEstado==null) {
        			permisoInternoEstado = (PermisoInternoEstado) PermisoInternoEstado.getNew(PermisoInternoEstado.NICKNAME, this.getSesion());
        		}
        		
        		permisoInternoEstado.setRegla_permiso(reglaPermisosInt);
        		permisoInternoEstado.setEstado_cip(estadoCIP);
        		permisoInternoEstado.setActivo(dsPermisoIntEst.getBoolean("activo"));
        		
        		reglaPermisosInt.addAccesoInternoEstado(permisoInternoEstado);
        		
        		dsPermisoIntEst.next();
        	}        	
        	
        	
        	
        	
        	
        	
        	permisosinternos.addRegla(reglaPermisosInt);
        	
        	dsReglasPermInt.next();
        }
        
        addTransaccion(permisosinternos);
        dataset.next();
        
    }
  }
  
}
