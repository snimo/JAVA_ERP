package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.InterpretarNroValCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TelecomandoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class HabilitarPaseLegajo extends Operation {

	public HabilitarPaseLegajo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String entradaSalida = mapaDatos.getString("entrada_salida");
		Integer oidPuerta = mapaDatos.getInteger("oid_puerta");
		Integer oidLegajo = mapaDatos.getInteger("oid_legajo"); 
		
		Puerta puerta = Puerta.findByOid(oidPuerta, this.getSesion());
		if (puerta == null)
			throw new ExceptionValidation(null,"Debe ingresar la Puerta");
		Legajo legajo = Legajo.findByOid(oidLegajo, this.getSesion());
		if (legajo == null)
			throw new ExceptionValidation(null,"Debe ingresar el Legajo");
		
		if (entradaSalida == null)
			throw new ExceptionValidation(null,"Debe indicar si se trata de una entrada o salida");
		if ((!entradaSalida.equals("E")) && (!entradaSalida.equals("S")))
			throw new ExceptionValidation(null,"Debe indicar si se trata de una entrada o salida");
		
		String media = "";
		Integer ptoAcceso = new Integer(0);
		if (entradaSalida.equals("E")) {
			media = legajo.getMediaEntrada(puerta).toString();
			ptoAcceso = new Integer(puerta.getIdentifEntrada());
			if (puerta.getInterpretarNroEnt().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) {
				if (media!=null)
					media = InterpretarNroValCIP.getB1FCYU2BNROInverso(media.toString()).toString();
			}
			if (puerta.getInterpretarNroEnt().equals(InterpretarNroValCIP.HID37BITS)) {
				if (media!=null) {
					media = InterpretarNroValCIP.getHid37BitsInverso(media.toString());
					//media = "0"+media.toString();
				}
			}			
		}
		else if (entradaSalida.equals("S")) {
			media = legajo.getMediaSalida(puerta).toString();
			ptoAcceso = new Integer(puerta.getIdentifSal());
			if (puerta.getInterpretarNroSal().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) {
				if (media!=null)
					media = InterpretarNroValCIP.getB1FCYU2BNROInverso(media.toString()).toString();
			}
			if (puerta.getInterpretarNroSal().equals(InterpretarNroValCIP.HID37BITS)) {
				if (media!=null) {
					media = InterpretarNroValCIP.getHid37BitsInverso(media.toString()).toString();
					//media = "0"+media.toString();
				}
			}			
		}
		
		if (media == null)
			throw new ExceptionValidation(null,"No se encontro medio de identificación para el legajo "+legajo.getApellidoyNombre());
		
		//TelecomandoCIP.getTelecomandoCIP().abrirPuerta(puerta.getIP(), puerta.getTelePuerto(), new Integer(puerta.getIdentifPuerta()), media.toLowerCase(), ptoAcceso);
		//TelecomandoCIP.getTelecomandoCIP().abrirPuerta(puerta.getIP(), puerta.getTelePuerto(), new Integer(puerta.getIdentifPuerta()), "27139775", ptoAcceso);
		TelecomandoCIP.getTelecomandoCIP().abrirPuerta(puerta.getIP(), puerta.getTelePuerto(), new Integer(puerta.getIdentifPuerta()), media.toLowerCase(), ptoAcceso);
		//Integer oidPuerta = mapaDatos.getInteger("oid_puerta");
		//Puerta puerta = Puerta.findByOid(oidPuerta, this.getSesion());
		//puerta.resetPlaca();
	}

}
