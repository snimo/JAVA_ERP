package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.bm.CuentaImputableIngVar;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;
import com.srn.erp.tesoreria.bm.UniOrgCtasIngVar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotHabIngVar extends Operation {

	public TraerMotHabIngVar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsMotHabIngVar = this.getDSMotHabIngVar();
		IDataSet dsCtasIngVar = getDSCtasIngVar();
		IDataSet dsUniOrgCta = this.getDSUniOrgCtaIngVar();

		int secu = 0;
		Iterator iterMotIngVar = MotivoTC.getMotivosRecibos(this.getSesion()).iterator();
		while (iterMotIngVar.hasNext()) {
			MotivoTC motivoTC = (MotivoTC) iterMotIngVar.next();
			MotivoHabIngVar motHabIngVar = MotivoHabIngVar.getMotivoHabIngVar(motivoTC, this.getSesion());
			boolean habilitado = false;
			if (motHabIngVar != null) {
				habilitado = motHabIngVar.isHabilitado().booleanValue();
				secu = motHabIngVar.getOID(); 
			} else --secu;
			cargarRegistroMotHabIngVar(dsMotHabIngVar, secu, motivoTC, new Boolean(habilitado));
			
			if (motHabIngVar!=null) {
				Iterator iterCtasHabIngVar = motHabIngVar.getCuentasHabIngVar().iterator();
				while (iterCtasHabIngVar.hasNext()) {
					
					CuentaImputableIngVar ctaImpIngVar = 
						(CuentaImputableIngVar) iterCtasHabIngVar.next();
					
					cargarRegistroCtasIngVar(dsCtasIngVar,
							ctaImpIngVar.getOID(),
							motHabIngVar,
							ctaImpIngVar.getCuenta_imputable(),
							ctaImpIngVar.isActivo());
					
					Iterator iterUniOrg = ctaImpIngVar.getUniOrgCtaIngVar().iterator();
					while (iterUniOrg.hasNext()) {
						UniOrgCtasIngVar uniOrgCtasingVar = (UniOrgCtasIngVar) iterUniOrg.next();
						cargarRegistroIngVarUniOrg(dsUniOrgCta,uniOrgCtasingVar);
					}
							
							
				}
			}
			
		}

		writeCliente(dsMotHabIngVar);
		writeCliente(dsCtasIngVar);
		writeCliente(dsUniOrgCta);
		
	}

	private IDataSet getDSCtasIngVar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCtasIngVar");
		dataset.fieldDef(new Field("oid_cta_int_iv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_hab_iv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ai", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDSUniOrgCtaIngVar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TIngVarUniOrg");
		dataset.fieldDef(new Field("oid_uni_org_iv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cta_int_iv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		return dataset;
	}
	

	private IDataSet getDSMotHabIngVar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotHabIngVar");
		dataset.fieldDef(new Field("oid_mot_hab_iv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_motivo_tc", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroMotHabIngVar(IDataSet dataset, int secu, MotivoTC motivoTC, Boolean habilitado)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_hab_iv", new Integer(secu));
		dataset.fieldValue("oid_motivo_tc", motivoTC.getOIDInteger());
		dataset.fieldValue("desc_motivo_tc", motivoTC.getMotivo_comprobante().getDescripcion());
		dataset.fieldValue("habilitado", habilitado);
	}

	private void cargarRegistroCtasIngVar(
			IDataSet dataset, 
			int oidCtaIngVar, 
			MotivoHabIngVar motHabIngVar,
			CuentaImputable cuentaImputable, 
			Boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cta_int_iv", new Integer(oidCtaIngVar));
		dataset.fieldValue("oid_mot_hab_iv", motHabIngVar.getOIDInteger());
		dataset.fieldValue("oid_ai" , cuentaImputable.getOIDInteger());
		dataset.fieldValue("cod_ai" , cuentaImputable.getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai", cuentaImputable.getDescCuentaMasDescValCompo());
		dataset.fieldValue("activo", activo);
	}
	
	private void cargarRegistroIngVarUniOrg(IDataSet dataset, 
																					UniOrgCtasIngVar uniOrgCtaIngVar)
																					throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_uni_org_iv", uniOrgCtaIngVar.getOIDInteger());
		dataset.fieldValue("oid_cta_int_iv", uniOrgCtaIngVar.getCuenta_iv().getOIDInteger());
		dataset.fieldValue("oid_uni_org", uniOrgCtaIngVar.getUnidad_organizativa().getOIDInteger());
		dataset.fieldValue("cod_uni_org", uniOrgCtaIngVar.getUnidad_organizativa().getCodigo());
		dataset.fieldValue("desc_uni_org", uniOrgCtaIngVar.getUnidad_organizativa().getDescripcion());
		dataset.fieldValue("habilitado", uniOrgCtaIngVar.isActivo());
}
	

}
