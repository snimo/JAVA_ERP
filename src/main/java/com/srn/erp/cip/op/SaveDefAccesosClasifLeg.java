package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AccesoValClasif;
import com.srn.erp.cip.bm.CategAccValClasif;
import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.MotAccInterClasifLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDefAccesosClasifLeg extends Operation {

	public SaveDefAccesosClasifLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsClasifLeg = mapaDatos.getDataSet("TClasifLegajo");
		dsClasifLeg.first();
		while (!dsClasifLeg.EOF()) {

			ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOidProxy(dsClasifLeg.getInteger("oid_clasificador"), this.getSesion());

			IDataSet dsValClasif = dsClasifLeg.getDataSet("TValClasifLegajo");
			dsValClasif.first();
			while (!dsValClasif.EOF()) {
				ValorClasificadorEntidad valClasifEnt = ValorClasificadorEntidad.findByOidProxy(dsValClasif.getInteger("oid_val_clasif_leg"), this.getSesion());

				
				IDataSet dsControlAcceso = dsValClasif.getDataSet("TAcceso");
				dsControlAcceso.first();
				while (!dsControlAcceso.EOF()) {
					
					AccesoValClasif acceso = AccesoValClasif.getAccesoValClasif(valClasifEnt, this.getSesion());
					
					if (acceso==null) 
						acceso = (AccesoValClasif) AccesoValClasif.getNew(AccesoValClasif.NICKNAME, this.getSesion());
					
					acceso.setTipo_ingreso(dsControlAcceso.getString("tipo_ingreso"));
					acceso.setLey_no_ingreso(dsControlAcceso.getString("ley_no_ingreso"));
					acceso.setMin_ent_antes(dsControlAcceso.getInteger("min_ent_antes"));
					acceso.setMin_ent_despues(dsControlAcceso.getInteger("min_ent_despues"));
					acceso.setTipo_egreso(dsControlAcceso.getString("tipo_egreso"));
					acceso.setLey_no_egreso(dsControlAcceso.getString("ley_no_egreso"));
					acceso.setAntipassback(dsControlAcceso.getBoolean("antipassback"));
					acceso.setCacheo(dsControlAcceso.getBoolean("cacheo"));
					acceso.setValorClasificador(valClasifEnt);
					acceso.setActivo(true);
					acceso.save();
					
					dsControlAcceso.next();
				}
				
				
				IDataSet dsCategAccesso = dsValClasif.getDataSet("TCategAccesos");
				dsCategAccesso.first();
				while (!dsCategAccesso.EOF()) {

					CategAccesoCIP categAccesoCIP = CategAccesoCIP.findByOidProxy(dsCategAccesso.getInteger("oid_categ_acceso"), this.getSesion());

					// Segun corresponde habilitar o no el Motivo
					if (dsCategAccesso.getBoolean("activo")) {

						// Buscar Motivo
						CategAccValClasif categAccValClasif = CategAccValClasif.getCategAccPorValClasif(valClasifEnt, categAccesoCIP, this.getSesion());

						if (categAccValClasif == null) {
							categAccValClasif = (CategAccValClasif) CategAccValClasif.getNew(CategAccValClasif.NICKNAME, this.getSesion());
							categAccValClasif.setVal_clasif_ent(valClasifEnt);
							categAccValClasif.setCategoria(categAccesoCIP);
							categAccValClasif.setActivo(true);
							categAccValClasif.save();
						}

					} else {

						CategAccValClasif categAccValClasif = CategAccValClasif.getCategAccPorValClasif(valClasifEnt, categAccesoCIP, this.getSesion());
						if (categAccValClasif != null) {
							categAccValClasif.delete();
							categAccValClasif.save();
						}
					}
					dsCategAccesso.next();
				}				
				
				
				
				IDataSet dsMotAccInter = dsValClasif.getDataSet("TMotAccInterValClasif");
				dsMotAccInter.first();
				while (!dsMotAccInter.EOF()) {

					MotivoEntIntermedias motivoEntIntermedias = MotivoEntIntermedias.findByOidProxy(dsMotAccInter.getInteger("oid_motivo"), this.getSesion());

					// Segun corresponde habilitar o no el Motivo
					if (dsMotAccInter.getBoolean("habilitado")) {

						// Buscar Motivo
						MotAccInterClasifLeg motAccInterClasifLeg = MotAccInterClasifLeg.getMotAccInterClasifLeg(valClasifEnt,motivoEntIntermedias, this.getSesion());

						if (motAccInterClasifLeg == null) {
							motAccInterClasifLeg = (MotAccInterClasifLeg) MotAccInterClasifLeg.getNew(MotAccInterClasifLeg.NICKNAME, this.getSesion());
							motAccInterClasifLeg.setValorclasificador(valClasifEnt);
							motAccInterClasifLeg.setMotivo(motivoEntIntermedias);
							motAccInterClasifLeg.setActivo(true);
							motAccInterClasifLeg.save();
						}

					} else {

						MotAccInterClasifLeg motAccInterClasifLeg = MotAccInterClasifLeg.getMotAccInterClasifLeg(valClasifEnt,motivoEntIntermedias, this.getSesion());
						if (motAccInterClasifLeg != null) {
							motAccInterClasifLeg.delete();
							motAccInterClasifLeg.save();
						}
					}
					dsMotAccInter.next();
				}
				dsValClasif.next();
			}

			dsClasifLeg.next();
		}

	}

}
