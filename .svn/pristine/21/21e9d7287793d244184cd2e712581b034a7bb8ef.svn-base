package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.bm.EstrucNivPuesto;
import com.srn.erp.rrhh.bm.EstrucNivSector;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerJerarDesaLeg extends Operation {

	public TraerJerarDesaLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsEmpresa = getDataSetEmpresas();
		IDataSet dsSectores = getDataSetSectores();
		IDataSet dsPuestos = getDataSetPuestos();
		IDataSet dsClasif = getDataSetClasificadores();
		
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		
		cargarCargarClasif(dsClasif,clasifEmpresa.getNroClasif(),
				           clasifSector.getNroClasif(),
				           clasifPuesto.getNroClasif(), 
						   clasifEmpresa.getOIDInteger(),
						   clasifSector.getOIDInteger(),
						   clasifPuesto.getOIDInteger());
		
		Iterator iterEmpresas = EstrucNivEmpresa.getEmpresas(this.getSesion()).iterator();
		while (iterEmpresas.hasNext()) {
			EstrucNivEmpresa estrucNivEmpresa = (EstrucNivEmpresa) iterEmpresas.next();
			cargarRegistroEmp(dsEmpresa,estrucNivEmpresa);
			
			Iterator iterSectores = estrucNivEmpresa.getSectoresConInactivos().iterator();
			while (iterSectores.hasNext()) {
				EstrucNivSector estrucNivSector = (EstrucNivSector) iterSectores.next();
				cargarRegistroSec(dsSectores, estrucNivSector);
				
				Iterator iterPuestos = estrucNivSector.getPuestosConInactivos().iterator();
				while (iterPuestos.hasNext()) {
					EstrucNivPuesto estrucNivPuesto = (EstrucNivPuesto) iterPuestos.next();
					cargarRegistroPue(dsPuestos,estrucNivPuesto);
				}
				
			}
			
		}
		
		writeCliente(dsEmpresa);
		writeCliente(dsSectores);
		writeCliente(dsPuestos);
		writeCliente(dsClasif);
		
	}

	
	private void cargarRegistroEmp(IDataSet ds , EstrucNivEmpresa estrucNivEmpresa ) throws BaseException {
		ds.append();
		ds.fieldValue("OID_ESTRUC_EMP", estrucNivEmpresa.getOIDInteger());
		ds.fieldValue("OID_VAL_CLASIF_EMP", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
		ds.fieldValue("CODIGO", estrucNivEmpresa.getValor_clasif_empresa().getCodigo());
		ds.fieldValue("DESCRIPCION", estrucNivEmpresa.getValor_clasif_empresa().getDescripcion());
		ds.fieldValue("ACTIVO", estrucNivEmpresa.isActivo());
		
	}
	
	private void cargarRegistroSec(IDataSet ds , EstrucNivSector estrucNivSector) throws BaseException {
		ds.append();
		ds.fieldValue("OID_ESTRUC_SEC", estrucNivSector.getOIDInteger());
		ds.fieldValue("OID_ESTRUC_EMP", estrucNivSector.getOid_estruc_emp().getOID());
		ds.fieldValue("OID_VAL_CLASIF_SEC", estrucNivSector.getValor_clasif_sector().getOIDInteger());
		ds.fieldValue("CODIGO", estrucNivSector.getValor_clasif_sector().getCodigo());
		ds.fieldValue("DESCRIPCION", estrucNivSector.getValor_clasif_sector().getDescripcion());
		ds.fieldValue("ACTIVO", estrucNivSector.isActivo());
	}	
	
	private IDataSet getDataSetClasificadores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasificadores");
		dataset.fieldDef(new Field("nro_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_pue", Field.INTEGER, 0));
		return dataset;
	}	
	
	private IDataSet getDataSetEmpresas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEmpresas");
		dataset.fieldDef(new Field("OID_ESTRUC_EMP", Field.INTEGER, 0));
		dataset.fieldDef(new Field("OID_VAL_CLASIF_EMP", Field.INTEGER, 0));
		dataset.fieldDef(new Field("CODIGO", Field.STRING, 50));
		dataset.fieldDef(new Field("DESCRIPCION", Field.STRING, 255));
		dataset.fieldDef(new Field("ACTIVO", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetSectores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSectores");
		dataset.fieldDef(new Field("OID_ESTRUC_SEC", Field.INTEGER, 0));
		dataset.fieldDef(new Field("OID_ESTRUC_EMP", Field.INTEGER, 0));
		dataset.fieldDef(new Field("OID_VAL_CLASIF_SEC", Field.INTEGER, 0));
		dataset.fieldDef(new Field("CODIGO", Field.STRING, 50));
		dataset.fieldDef(new Field("DESCRIPCION", Field.STRING, 255));
		dataset.fieldDef(new Field("ACTIVO", Field.BOOLEAN, 0));		
		return dataset;
	}
	
	private IDataSet getDataSetPuestos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuestos");
		dataset.fieldDef(new Field("OID_ESTRUC_PUE", Field.INTEGER, 0));
		dataset.fieldDef(new Field("OID_ESTRUC_SEC", Field.INTEGER, 0));
		dataset.fieldDef(new Field("OID_VAL_CLASIF_PUE", Field.INTEGER, 0));
		dataset.fieldDef(new Field("CODIGO", Field.STRING, 50));
		dataset.fieldDef(new Field("DESCRIPCION", Field.STRING, 255));
		dataset.fieldDef(new Field("ACTIVO", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarRegistroPue(IDataSet ds , EstrucNivPuesto estrucNivPuesto) throws BaseException {
		ds.append();
		ds.fieldValue("OID_ESTRUC_PUE", estrucNivPuesto.getOIDInteger());
		ds.fieldValue("OID_ESTRUC_SEC", estrucNivPuesto.getOid_estruc_sector().getOID());
		ds.fieldValue("OID_VAL_CLASIF_PUE", estrucNivPuesto.getValor_clasif_puesto().getOID());
		ds.fieldValue("CODIGO", estrucNivPuesto.getValor_clasif_puesto().getCodigo());
		ds.fieldValue("DESCRIPCION", estrucNivPuesto.getValor_clasif_puesto().getDescripcion());
		ds.fieldValue("ACTIVO", estrucNivPuesto.isActivo());
	}
	
	private void cargarCargarClasif(IDataSet ds,Integer nroClasifEmp,Integer nroClasifSec,Integer nroClasifPue,
			Integer oidClasifEmp, Integer oidClasifSec , Integer oidClasifPue) throws BaseException {
		
		ds.append();
		ds.fieldValue("nro_clasif_emp", nroClasifEmp);
		ds.fieldValue("nro_clasif_sec", nroClasifSec);
		ds.fieldValue("nro_clasif_pue", nroClasifPue);
		ds.fieldValue("oid_clasif_emp", oidClasifEmp);
		ds.fieldValue("oid_clasif_sec", oidClasifSec);
		ds.fieldValue("oid_clasif_pue", oidClasifPue);
		
	}
	
	
	

}
