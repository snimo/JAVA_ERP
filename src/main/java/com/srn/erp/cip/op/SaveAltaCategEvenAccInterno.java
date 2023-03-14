package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategEvenAccLegDet;
import com.srn.erp.cip.bm.CategEvenAccesoLeg;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAltaCategEvenAccInterno extends Operation {

	public SaveAltaCategEvenAccInterno() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Legajo legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		IDataSet dsCateg = mapaDatos.getDataSet("TCategPuedeHabilitar");
		
		/** CARGAR PERMISOS DE ACCESO EVENTUALES **/
		
		dsInput.first();
		while (!dsInput.EOF()) {
			
			CategEvenAccesoLeg categEvenAccesoLeg = 
				(CategEvenAccesoLeg) CategEvenAccesoLeg.getNew(CategEvenAccesoLeg.NICKNAME, this.getSesion());
			categEvenAccesoLeg.setLegajo(legajo);
			
			java.util.Date fecDesde = dsInput.getDate("fec_desde");
			java.util.Date fecHasta = dsInput.getDate("fec_hasta");
			
			String horaMinDesde = dsInput.getString("hora_desde");
			String horaMinHasta = dsInput.getString("hora_hasta");

			// Obtener la Fecha hora desde
			int diaDesde  = Fecha.getDia(fecDesde);
			int mesDesde  = Fecha.getMes(fecDesde);
			int anioDesde = Fecha.getAnio(fecDesde);
			int minDesde = UtilCIP.getParteMinutosEnMinutos(horaMinDesde);
			int horaDesde  = UtilCIP.getParteHoraEnHoras(horaMinDesde);
			java.util.Date fecDesdeConHora = Fecha.getFecha(diaDesde, mesDesde, anioDesde, horaDesde, minDesde, 0);
			
			// Obtener la Fecha hora hasta
			int diaHasta  = Fecha.getDia(fecHasta);
			int mesHasta  = Fecha.getMes(fecHasta);
			int anioHasta = Fecha.getAnio(fecHasta);
			int minHasta = UtilCIP.getParteMinutosEnMinutos(horaMinHasta);
			int horaHasta  = UtilCIP.getParteHoraEnHoras(horaMinHasta);
			java.util.Date fecHastaConHora = Fecha.getFecha(diaHasta, mesHasta, anioHasta, horaHasta, minHasta, 0);
			
			categEvenAccesoLeg.setFecha_desde(fecDesdeConHora);
			categEvenAccesoLeg.setFecha_hasta(fecHastaConHora);
			categEvenAccesoLeg.setTipo_acceso(dsInput.getString("tipo_acceso"));
			categEvenAccesoLeg.setActivo(true);
			
			dsCateg.first();
			while (!dsCateg.EOF()) {
				
				if (!dsCateg.getBoolean("habilitar")) {
					dsCateg.next();
					continue;
				}
				
				CategAccesoCIP categoria = 
					(CategAccesoCIP) CategAccesoCIP.findByOidProxy(dsCateg.getInteger("oid_categ_acceso"),this.getSesion());
				
				CategEvenAccLegDet categEvenAccLegDet = (CategEvenAccLegDet) CategEvenAccLegDet.getNew(CategEvenAccLegDet.NICKNAME, this.getSesion());
				categEvenAccLegDet.setCateg_eventual_leg(categEvenAccesoLeg);
				categEvenAccLegDet.setCategoria(categoria);
				categEvenAccLegDet.setActivo(true);
				categEvenAccesoLeg.addCategAccesoEvenDet(categEvenAccLegDet);
				
				dsCateg.next();
			}
			
			this.addTransaccion(categEvenAccesoLeg);
			
			dsInput.next();
		}
		
		
	}

}
