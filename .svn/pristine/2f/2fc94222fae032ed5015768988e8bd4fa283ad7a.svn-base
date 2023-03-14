package com.srn.erp.conciTarjeta.bm;

import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ConciliarCupon {
	
	private ISesion session;
	
	public void setSesion(ISesion aSesion) {
		this.session = aSesion;
	}
	
	public ISesion getSesion() {
		return this.session;
	}
	
	public boolean confirmarPreConci(
			EmpresaConciTar empresa,
			Usuario usuario,
			List listaCuponesPosnet,
			List listaCuponesEntTarj) throws BaseException {
		
		Iterator iterPreconciPorEmpSuc = 
			empresa.getPreconciliadosPorEmpresaUsu(usuario).iterator();
		while (iterPreconciPorEmpSuc.hasNext()) {
			
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterPreconciPorEmpSuc.next();
			archLoteConciDet.marcarComoConciliado();
			
			if (listaCuponesPosnet!=null)
				listaCuponesPosnet.add(archLoteConciDet);
			
			// Por cada uno que esta preconciliado marcarlo como conciliado
			Iterator iterPreconciByNro = 
				empresa.getPreconciliadosByNro(archLoteConciDet.getNroConciliacion()).iterator();
			while (iterPreconciByNro.hasNext()) {
				DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterPreconciByNro.next();
				detTarConciEnt.marcarComoConciliado();
				
				if (listaCuponesEntTarj!=null)
					listaCuponesEntTarj.add(detTarConciEnt);
				
			}			
			
		}
		
		return true;
	}
			
	
	public boolean preConcililiar(
			EmpresaConciTar empresa,
			Usuario usuario,
			List listaCuponesPosnet,
			List listaCuponesEntTarj,
			StringBuffer motivosNoConcilio) throws BaseException {
		
		// Controlar que sea la Misma Tarjeta
		String tarjeta = null;
		
		// Obteger los registros a preconciliar del POSNET
		CalculadorMoney totPOSNET = new CalculadorMoney(new Money(0));
		Iterator iterMarcadosPOSNET = 
			empresa.getMarcadosPOSNETPreConciPorEmpresaUsu(usuario).iterator();
		while (iterMarcadosPOSNET.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterMarcadosPOSNET.next();
			
			if (tarjeta == null)
				tarjeta = archLoteConciDet.getTarjeta();
			
			if (!tarjeta.equals(archLoteConciDet.getTarjeta()))
				throw new ExceptionValidation(null,"No puede conciliar cupones de Tarjetas Diferentes "+tarjeta+" - "+archLoteConciDet.getTarjeta());
			
			if (listaCuponesPosnet!=null) {
				listaCuponesPosnet.add(archLoteConciDet);
			}
			totPOSNET.sumar(new Money(archLoteConciDet.getMonto()));
		}
		
		// Obtener los registros a preconciliar de las Entidades de Tarjetas
		CalculadorMoney totEntTarj = new CalculadorMoney(new Money(0));
		Iterator iterMarcadosEntTarj = 
			empresa.getMarcadosEntiTarjPorEmpresaUsu(usuario,this.getSesion()).iterator();
		while (iterMarcadosEntTarj.hasNext()) {
			DetTarConciEnt detTarjConciEnt = (DetTarConciEnt) iterMarcadosEntTarj.next();
			
			if (tarjeta == null)
				tarjeta = detTarjConciEnt.getTarjeta();
			
			if (!tarjeta.equals(detTarjConciEnt.getTarjeta()))
				throw new ExceptionValidation(null,"No puede conciliar cupones de Tarjetas Diferentes "+tarjeta+" - "+detTarjConciEnt.getTarjeta());			
			
			
			if (listaCuponesEntTarj!=null) {
				listaCuponesEntTarj.add(detTarjConciEnt);
			}
			totEntTarj.sumar(detTarjConciEnt.getImporte());
		}		
		
		if (totPOSNET.getResultMoney().doubleValue() == 0)
			throw new ExceptionValidation(null,"El total de movimientos de POSNET no puede ser cero.");
		
		if (totEntTarj.getResultMoney().doubleValue() == 0)
			throw new ExceptionValidation(null,"El total de movimientos de TARJETAS no puede ser cero.");		
		
		if (totPOSNET.getResultMoney().doubleValue() != totEntTarj.getResultMoney().doubleValue()) {
			motivosNoConcilio.append("El total del POSNET="+totPOSNET.getResultMoney().doubleValue()+" no coincide con el total de las TARJETAS="+totEntTarj.getResultMoney().doubleValue());
			return false;
		}
			
		// Si son igual obtener el proximo Nro. de conciliacion
		int proxNroConciliacion = empresa.getProxNroConci();
		
		Iterator iterCupPosnet = 
			listaCuponesPosnet.iterator();
		while (iterCupPosnet.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterCupPosnet.next();
			archLoteConciDet.generarPreconciliacion(proxNroConciliacion,null,false);
		}
		
		Iterator iterTarjEnt = 
			listaCuponesEntTarj.iterator();
		while (iterTarjEnt.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjEnt.next();
			detTarConciEnt.generarPreconciliacion(proxNroConciliacion,null,false);
		}		
		
		return true;
	}
	
}
