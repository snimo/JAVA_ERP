package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class MotivosNoAprob {

	List listaKeysMotNoAprov = new ArrayList();
	List listaKeyPendRealizar = new ArrayList();
	List listaKeyMotInfo = new ArrayList();

	public static final int MOTIVO = 1;

	private boolean noAprobado;
	private HashTableDatos evitarMotDup = new HashTableDatos();
	private HashTableDatos evitarMotDupPend = new HashTableDatos();
	private HashTableDatos evitarMotDupInf = new HashTableDatos();
	
	
	private boolean pendAprob = false;

	private StringBuffer motivosNoAprob;
	private StringBuffer pendientes;
	private StringBuffer motivosInformativos; 

	public void addMotivoDesaprobacion(String motivo, Integer keyMotivo) throws BaseException {

		if (evitarMotDup.containsKey(motivo))
			return;

		if (motivosNoAprob.length() > 0)
			motivosNoAprob.append(Util.ENTER());
		evitarMotDup.put(motivo, "");
		motivosNoAprob.append(motivo);

		listaKeysMotNoAprov.add(keyMotivo);
	}

	public void addMotivoPendiente(String motivo, Integer keyMotivo) {

		if (evitarMotDupPend.containsKey(motivo))
			return;

		if (pendientes.length() > 0)
			pendientes.append(Util.ENTER());
		evitarMotDupPend.put(motivo, "");
		pendientes.append(motivo);

		listaKeyPendRealizar.add(keyMotivo);

	}
	
	public void addMotivoInformativo(String motivo, Integer keyMotivo) {

		if (evitarMotDupInf.containsKey(motivo))
			return;

		if (motivosInformativos.length() > 0)
			motivosInformativos.append(Util.ENTER());
		evitarMotDupInf.put(motivo, "");
		motivosInformativos.append(motivo);

		listaKeyMotInfo.add(keyMotivo);

	}	
	
	

	public MotivosNoAprob() {
		motivosNoAprob = new StringBuffer("");
		pendientes = new StringBuffer("");
		motivosInformativos = new StringBuffer("");
		noAprobado = false;
	}

	public void setNoAprobado(boolean noAprobado) throws BaseException {
		this.noAprobado = noAprobado;
	}

	public boolean isNoAprobado() throws BaseException {
		return this.noAprobado;
	}

	public String getMotivos() throws BaseException {
		
		StringBuffer resp = new StringBuffer("");
		if (motivosNoAprob.toString().length()!=0)
			resp.append(motivosNoAprob.toString()+Util.ENTER());
		
		if (pendientes.toString().length()!=0)
			resp.append(pendientes.toString()+Util.ENTER());
		
		if (motivosInformativos.toString().length()!=0)
			resp.append(motivosInformativos.toString()+Util.ENTER());
			
		return resp.toString();
	}
	
	public String aprobado() throws BaseException {

		boolean noAprob = false;  
		
		if ((listaKeysMotNoAprov.size() == 0) && (listaKeyPendRealizar.size() == 0))
			return "Si";
		else if ((listaKeysMotNoAprov.size() == 0) && (listaKeyPendRealizar.size() > 0))
			return "Pend";
		else if ((listaKeysMotNoAprov.size() > 0) && (listaKeyPendRealizar.size() == 0))
			return "No";
		else {
			// Analizar si es pendiente o no
			// Recorro todos los no aprobados si
			Iterator iterNoAprobados = listaKeysMotNoAprov.iterator();
			while (iterNoAprobados.hasNext()) {
				Integer keyNoAprob = (Integer) iterNoAprobados.next();
				int encontroClaveEnPend = (Integer)listaKeyPendRealizar.indexOf(keyNoAprob);
				if (encontroClaveEnPend == -1)
					noAprob = true;
			}
			if (noAprob)
				return "No";
			else
				return "Pend";
		}

	}

	public void setPendAprob(boolean aPendAproba) {
		this.pendAprob = aPendAproba;
	}

	public Integer getKEY_MOT_Estado_No_Promocionable() {
		return new Integer(1);
	}

	public Integer getKEY_MOT_Clasif_Gral_Min() {
		return new Integer(2);
	}

	public Integer getKEY_MOT_Cant_Max_Sanciones() {
		return new Integer(3);
	}

	public Integer getKEY_MOT_Cant_Max_Novedades() {
		return new Integer(4);
	}

	public Integer getKEY_MOT_Ant_Min_Empresa() {
		return new Integer(5);
	}

	public Integer getKEY_MOT_Ant_Min_Puesto() {
		return new Integer(6);
	}

	public Integer getKEY_MOT_Cant_Min_JuegosA() {
		return new Integer(7);
	}

	public Integer getKEY_MOT_Punt_Min_Evaluacion() {
		return new Integer(8);
	}

	public Integer getKEY_MOT_Falta_Eval_Desemp() {
		return new Integer(9);
	}

	public Integer getKEY_MOT_Falta_Eval_Potencial() {
		return new Integer(10);
	}

	public Integer getKEY_MOT_Falta_Inf_RelLab() {
		return new Integer(10);
	}
	
	public Integer getKEY_MOT_No_Cumple_Hor_Carrera() {
		return new Integer(11);
	}	
	
	public Integer getKEY_MOT_Excede_Ptos_Max_Sanciones() {
		return new Integer(12);
	}	
	
	public Integer getKEY_MOT_Excede_Ptos_Max_Novedades() {
		return new Integer(13);
	}	
	
	public boolean isPendCargaEvalPotencia() {
		int indice = this.listaKeyPendRealizar.indexOf(this.getKEY_MOT_Falta_Eval_Potencial());
		if (indice==-1)
			return false;
		else
			return true;
	}
	
	public boolean isPendCargaEvalDesempenio() {
		int indice = this.listaKeyPendRealizar.indexOf(this.getKEY_MOT_Clasif_Gral_Min());
		if (indice==-1)
			return false;
		else
			return true;
	}	
	
	public boolean isPendCargaCantJuegosA() {
		int indice = this.listaKeyPendRealizar.indexOf(this.getKEY_MOT_Cant_Min_JuegosA());
		if (indice==-1)
			return false;
		else
			return true;
	}	
	
	public boolean isPendCargaInfRelLab() {
		int indice = this.listaKeyPendRealizar.indexOf(this.getKEY_MOT_Falta_Inf_RelLab());
		if (indice==-1)
			return false;
		else
			return true;
	}	
	
	
	
	
	

}
