package com.srn.erp.rrhh.op;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.bm.EstrucNivPuesto;
import com.srn.erp.rrhh.bm.EstrucNivSector;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveJerarDesaLeg extends Operation {

	public SaveJerarDesaLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsEmpresas = mapaDatos.getDataSet("TEmpresas");
		dsEmpresas.first();
		while (!dsEmpresas.EOF()) {
			EstrucNivEmpresa estrucNivEmpresa = (EstrucNivEmpresa) EstrucNivEmpresa.findByOid(dsEmpresas.getInteger("OID_ESTRUC_EMP"), this.getSesion());
			ValorClasificadorEntidad valorClasifEmp = ValorClasificadorEntidad.findByOidProxy(dsEmpresas.getInteger("OID_VAL_CLASIF_EMP"), this.getSesion());
			estrucNivEmpresa.setValor_clasif_empresa(valorClasifEmp);
			estrucNivEmpresa.setActivo(dsEmpresas.getBoolean("ACTIVO"));
			if (!dsEmpresas.getBoolean("ACTIVO"))
				estrucNivEmpresa.delete();
			
			
			this.addTransaccion(estrucNivEmpresa);
			
			
			IDataSet dsSectores = dsEmpresas.getDataSet("TSectores");
			dsSectores.first();
			while (!dsSectores.EOF()) {
				EstrucNivSector estrucNivSector = (EstrucNivSector) EstrucNivSector.findByOid(dsSectores.getInteger("OID_ESTRUC_SEC"), this.getSesion());
				ValorClasificadorEntidad valorClasifSec = ValorClasificadorEntidad.findByOidProxy(dsSectores.getInteger("OID_VAL_CLASIF_SEC"), this.getSesion());
				estrucNivSector.setValor_clasif_sector(valorClasifSec);
				estrucNivSector.setActivo(dsSectores.getBoolean("ACTIVO"));
				estrucNivSector.setOid_estruc_emp(estrucNivEmpresa);
				if (!dsSectores.getBoolean("ACTIVO"))
					estrucNivSector.delete();
				this.addTransaccion(estrucNivSector);
				
				IDataSet dsPuestos = dsSectores.getDataSet("TPuestos");
				dsPuestos.first();
				while (!dsPuestos.EOF()) {
					EstrucNivPuesto estrucNivPuesto = (EstrucNivPuesto) EstrucNivPuesto.findByOid(dsPuestos.getInteger("OID_ESTRUC_PUE"), this.getSesion());
					ValorClasificadorEntidad valorClasifPue = ValorClasificadorEntidad.findByOidProxy(dsPuestos.getInteger("OID_VAL_CLASIF_PUE"), this.getSesion());
					estrucNivPuesto.setValor_clasif_puesto(valorClasifPue);
					estrucNivPuesto.setActivo(dsPuestos.getBoolean("ACTIVO"));
					estrucNivPuesto.setOid_estruc_sector(estrucNivSector);
					if (!dsPuestos.getBoolean("ACTIVO"))
						estrucNivPuesto.delete();
					this.addTransaccion(estrucNivPuesto);					
					dsPuestos.next();
				}
				
				
				
				dsSectores.next();
				
			}
			
			
			

			dsEmpresas.next();
		}

	}

}
