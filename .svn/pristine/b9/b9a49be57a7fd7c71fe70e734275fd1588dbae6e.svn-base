package com.srn.erp.cip.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TienePermisoCIP;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class PuedeIngresar extends Operation {

	private List puertasHabilitadas = new ArrayList();
	private List motivos = new ArrayList();
	
	public PuedeIngresar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Legajo legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());

		
		IDataSet ds = this.getDataSetPuedeIngresar();
		Iterator iterPuertasActivas = Puerta.getPuertasActivas(this.getSesion()).iterator();
		while (iterPuertasActivas.hasNext()) {
			Puerta puerta = (Puerta) iterPuertasActivas.next();
			if (!puerta.isIngresoAlPredio()) continue;
				
			TienePermisoCIP tienePermisoCIP = new TienePermisoCIP(this.getSesion());
			tienePermisoCIP.setIdentifEquipo(new Integer(puerta.getIdentifPuerta()));
			if (!puerta.getIdentifEntrada().equals(""))
				tienePermisoCIP.setIdentifPtoAcceso(new Integer(puerta.getIdentifEntrada()));
			tienePermisoCIP.setIdentifDir(puerta.getDirPtoEnt());
			tienePermisoCIP.setNoInterpretarB1FC_U2DBNRO(true);
			tienePermisoCIP.setNoInterpretarHID37bits(true);
			tienePermisoCIP.setNoEnviarMensajes(true);
			Integer media = legajo.getMediaEntrada(puerta);
			if (media != null)
				tienePermisoCIP.setIdentifLegajo(media.toString());
			else
				continue;

			tienePermisoCIP.setFecha(UtilCIP.getFechaHoraActual(this.getSesion()));
			tienePermisoCIP.validar();

			if (tienePermisoCIP.isPuedePasar()) 
				puertasHabilitadas.add(puerta);
			 else
				motivos.add(tienePermisoCIP.getMotivoPermiso()); 

		}
		
		if (puertasHabilitadas.size() == 0) 
			cargarRegistro(ds, false, "NO PUEDE INGRESAR:"+Util.ENTER()+getMotivos());
		 else
			cargarRegistro(ds, true, "PUEDE INGRESAR POR PUERTAS:"+Util.ENTER()+getPuertas());
		writeCliente(ds);

	}
	
	private String getPuertas() throws BaseException {
		StringBuffer puertasHab = new StringBuffer("");
		Iterator iterPuertasHabilitadas = 
			this.puertasHabilitadas.iterator();
		while (iterPuertasHabilitadas.hasNext()) {
			Puerta puerta = (Puerta) iterPuertasHabilitadas.next();
			if (puertasHab.length()==0)
				puertasHab.append(puerta.getCodigo());
			else
				puertasHab.append(", "+puerta.getCodigo());
		}
		return puertasHab.toString();
	}
	
	private String getMotivos() throws BaseException {
		List motivosInformados = new ArrayList();
		StringBuffer motivosRechazos = new StringBuffer("");
		Iterator iterMotivos = 
			this.motivos.iterator();
		while (iterMotivos.hasNext()) {
			String motivo = (String) iterMotivos.next();
			if (motivosRechazos.length()==0)
				motivosRechazos.append(motivo);
			else {
				if (motivosInformados.indexOf(motivo)==0) {
					motivosRechazos.append(", "+motivo);
					motivosInformados.add(motivo);
				}
			}
		}
		return motivosRechazos.toString();
	}

	private IDataSet getDataSetPuedeIngresar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuedePasar");
		dataset.fieldDef(new Field("puede", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 255));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Boolean puede, String motivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("puede", puede);
		dataset.fieldValue("motivo", motivo);
	}

}
