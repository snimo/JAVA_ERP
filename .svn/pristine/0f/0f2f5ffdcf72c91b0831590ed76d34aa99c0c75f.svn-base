package com.srn.erp.conciTarjeta.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.ArmadoAsiCob;
import com.srn.erp.conciTarjeta.bm.AsiCobCPMOracle;
import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.DetAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.RenglonAsiCobTarj;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class GenerarAsientoCobTarj extends Operation {

	public GenerarAsientoCobTarj() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		java.util.Date fecha = mapaDatos.getDate("fecha");
		
		if (fecha==null)
			throw new ExceptionValidation(null,"Debe ingresar la fecha");
		
		if (Fecha.getAnio(fecha)<2011)
			throw new ExceptionValidation(null,"El año de la fecha ingresada es menor al 2011");		
		
		String comentario = mapaDatos.getString("comentario"); 
		
		List listaDetCupones = new ArrayList();
		
		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa =
			EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		
		ArmadoAsiCob armadoAsiCob = new ArmadoAsiCob();
		armadoAsiCob.setEmpresa(empresa);
		armadoAsiCob.setSesion(this.getSesion());
		
		IDataSet dsDetAsiCobAGen = mapaDatos.getDataSet("TDetAsiCobAGenerar");
		dsDetAsiCobAGen.first();
		while (!dsDetAsiCobAGen.EOF()) {			
			
			ArchLoteConciDet archLoteConciDet = 
				ArchLoteConciDet.findByOidProxy(
						dsDetAsiCobAGen.getInteger("oid_arch_lote_det"), 
						this.getSesion());
			
			// Si se cumplen las siguientes condiciones se puede contabilizar el asiento
			
			if (!archLoteConciDet.isActivo())
				throw new ExceptionValidation(null,"El cupon "+archLoteConciDet.getDescripcion()+" se encuentra anulado.");
			
			if (!archLoteConciDet.isPresentado())
				throw new ExceptionValidation(null,"El cupon "+archLoteConciDet.getDescripcion()+" NO se encuentra PRESENTADO.");
				
			if (!archLoteConciDet.isMarcaAsiACobrar())
				throw new ExceptionValidation(null,"El cupon "+archLoteConciDet.getDescripcion()+" NO se encuentra marcado para contabilizar.");			
			
			if (archLoteConciDet.isContaAsientoACobrar())
				throw new ExceptionValidation(null,"El cupon "+archLoteConciDet.getDescripcion()+" ya se encuentra contabilizado.");			
			
			
			listaDetCupones.add(archLoteConciDet);
			
			
			armadoAsiCob.addDetalle(archLoteConciDet);
			dsDetAsiCobAGen.next();
		}
		
		if (armadoAsiCob.getCantRenglones()<=0) 
			throw new ExceptionValidation(null,"No se generó el asiento de Cobranza.");
		
		if (fecha == null)
			throw new ExceptionValidation(null,"Debe ingresar la fecha del asiento");
		
		// Generar el Asiento de Cobranza
		CabAsiTarjACobrar cabAsiento = (CabAsiTarjACobrar)
			CabAsiTarjACobrar.getNew(CabAsiTarjACobrar.NICKNAME, this.getSesion());
		cabAsiento.setFec_asiento(fecha);
		
		java.util.Date fecActual = UtilCIP.getTruncDate(UtilCIP.getFechaHoraActual(this.getSesion()));
		if (fecha.after(fecActual)) 
			throw new ExceptionValidation(null,"La fecha no puede superar a la fecha actual");
		
		java.util.Date fecDiasAnt = Fecha.getFechaMasDias(fecActual, getMaxDiasAntAsiTarj(this.getSesion())*-1);
		if (fecha.before(fecDiasAnt))
			throw new ExceptionValidation(null,"La fecha del asiento no puede ser anterior a "+getMaxDiasAntAsiTarj(this.getSesion())+" dias con respecto de la fecha actual");
		
		
		cabAsiento.setComentario(comentario);
		cabAsiento.setNro_liquidacion(new Integer(0));
		cabAsiento.setArch_interfaz_gen(false);
		cabAsiento.setFec_arch_interfaz(null);
		cabAsiento.setHora_arch_interfaz("");
		cabAsiento.setConta_sist_ext(false);
		cabAsiento.setEmpresa(empresa);
		cabAsiento.setActivo(true);
		
		Iterator iterRenglones = 
			armadoAsiCob.getRenglonesResu();
		while (iterRenglones.hasNext()) {
			RenglonAsiCobTarj renglonAsiCobTarj = (RenglonAsiCobTarj) iterRenglones.next();
			
			DetAsiTarjACobrar detAsiTarjACobrar = 
				(DetAsiTarjACobrar) DetAsiTarjACobrar.getNew(DetAsiTarjACobrar.NICKNAME, this.getSesion()); 
			detAsiTarjACobrar.setCab_asi_acob(cabAsiento);
			detAsiTarjACobrar.setCuenta(renglonAsiCobTarj.getCuenta());
			detAsiTarjACobrar.setCompo1(renglonAsiCobTarj.getCompo1());
			detAsiTarjACobrar.setCompo2(renglonAsiCobTarj.getCompo2());
			
			if (renglonAsiCobTarj.getImporte().doubleValue()>=0)
				detAsiTarjACobrar.setDebe(renglonAsiCobTarj.getImporte().doubleValue());
			else
				detAsiTarjACobrar.setHaber(Math.abs(renglonAsiCobTarj.getImporte().doubleValue()));
			detAsiTarjACobrar.setActivo(true);
			cabAsiento.addDetalle(detAsiTarjACobrar);
		}
		
		cabAsiento.save();
		
		// Actualizar los Detalles de los Cupones Contabilizados
		Iterator iterDetCupones = 
			listaDetCupones.iterator();
		while (iterDetCupones.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterDetCupones.next();
			archLoteConciDet.setAsientoACobrar(cabAsiento);
			archLoteConciDet.setContaAsiACobrar(true);
			archLoteConciDet.save();
		}
		
		// Contabilizar el Asiento Externo
		if (isGenerarAsientoCobranzaTarj()) {
			if (getTipoAsientoExterno().equals("CPM")) {
				AsiCobCPMOracle asiCobCPMOracle = new AsiCobCPMOracle();
				asiCobCPMOracle.setSesion(this.getSesion());
				asiCobCPMOracle.setCadenaConexionBD(getCadenaConexionAsiCobTarj());
				asiCobCPMOracle.setCabAsiTarjACobrar(cabAsiento);
				asiCobCPMOracle.setUsuario(this.getUsuarioConexionAsiCobTarj());
				asiCobCPMOracle.setClave(this.getClaveConexionAsiCobTarj());
				String ref = asiCobCPMOracle.generarAsiento();
				IDataSet ds = this.getDataSetAsiGen();
				cargarAsiCobGen(ds, ref);
				writeCliente(ds);
				
				// Marcar la cabecera del Asiento de cobranza como contabilizada
				CabAsiTarjACobrar cabAsientoGrabada =
					CabAsiTarjACobrar.findByOid(cabAsiento.getOIDInteger(), this.getSesion());
				cabAsientoGrabada.setConta_sist_ext(true);
				cabAsientoGrabada.setFec_conta_sist_ext(UtilCIP.getFechaHoraActual(this.getSesion()));
				cabAsientoGrabada.setHor_conta_sist_ext(UtilCIP.getHHMM(UtilCIP.getFechaHoraActual(this.getSesion())));
				cabAsientoGrabada.save();
				
			}
		}

	}
	
	public boolean isGenerarAsientoCobranzaTarj()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CONT_ASI_COB_TARJ", this.getSesion()).getBoolean();
	}	
	
	public String getTipoAsientoExterno()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"ASI_COB_TARJ", this.getSesion()).getValorCadena();
	}	
	
	public String getCadenaConexionAsiCobTarj()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CAD_CONEX_ASI_COB_TARJ", this.getSesion()).getValorCadena();
	}	
	
	public String getUsuarioConexionAsiCobTarj()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"USU_BD_ASI_COB_TARJ", this.getSesion()).getValorCadena();
	}	
	
	public String getClaveConexionAsiCobTarj()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"PAS_BD_ASI_COB_TARJ", this.getSesion()).getValorCadena();
	}
	
	private IDataSet getDataSetAsiGen() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAsiCobGenerado");
		dataset.fieldDef(new Field("referencia", Field.STRING, 200));
		return dataset;
	}	
	
	private void cargarAsiCobGen(IDataSet ds,String referencia) throws BaseException {
		ds.append();
		ds.fieldValue("referencia", referencia);
	}
	
	public int getMaxDiasAntAsiTarj(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"MAX_DIAS_ANT_ASI_TARJ", aSesion).getValorEntero();
	}	
	
}
