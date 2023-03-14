package com.srn.erp.conciTarjeta.op;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.AsiLiqCPMOracle;
import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.CtaBancoLiqTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class GenerarAsiLiqTarj extends Operation {

	String ref = null;
	
	public GenerarAsiLiqTarj() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet datasetImput = mapaDatos.getDataSet("TInput");
		IDataSet datasetDetAsiento = mapaDatos.getDataSet("TDetalleAsiento");
		IDataSet datasetDetCupones = mapaDatos.getDataSet("TDetCupones");
		generarAsiento(datasetImput, datasetDetAsiento, datasetDetCupones);
	}

	private void generarAsiento(IDataSet dsCabAsiento, IDataSet dsDetAsiento, IDataSet dsDetCupones) throws BaseException {

		CalculadorMoney totDebe = new CalculadorMoney(new Money(0));
		CalculadorMoney totHaber = new CalculadorMoney(new Money(0));
		double totGastos = 0;
		EmpresaConciTar empresa = null;
		
		CabAsiLiquiTarj cabAsiLiquiTarj = (CabAsiLiquiTarj) CabAsiLiquiTarj.getNew(CabAsiLiquiTarj.NICKNAME, this.getSesion());
		dsCabAsiento.first();
		while (!dsCabAsiento.EOF()) {

			cabAsiLiquiTarj.setFec_asiento(dsCabAsiento.getDate("fecha"));
			empresa = EmpresaConciTar.findByOidProxy(dsCabAsiento.getInteger("oid_empresa"), this.getSesion());
			
			if (dsCabAsiento.getMoney("tot_gastos")!=null)
				totGastos = dsCabAsiento.getMoney("tot_gastos").doubleValue();
			
			Integer oidLiquidacion = dsCabAsiento.getInteger("oid_liquidacion");
			CabModeloLiq cabModeloLiq =
				CabModeloLiq.findByOidProxy(oidLiquidacion, this.getSesion());
			
			if (dsCabAsiento.getDate("fecha")==null)
				throw new ExceptionValidation(null,"Debe ingresar la fecha");
			
			if (Fecha.getAnio(dsCabAsiento.getDate("fecha"))<2011)
				throw new ExceptionValidation(null,"El año de la fecha ingresada es menor al 2011");
			
			
			
			cabAsiLiquiTarj.setComentario("");
			
			
			
			java.util.Date fecActual = UtilCIP.getTruncDate(UtilCIP.getFechaHoraActual(this.getSesion()));
			if (dsCabAsiento.getDate("fecha").after(Fecha.getFechaMasDias(fecActual, 60))) 
				throw new ExceptionValidation(null,"La fecha no puede superar en 60 días la fecha actual");	
			
			
			
			java.util.Date fecDiasAnt = Fecha.getFechaMasDias(fecActual, getMaxDiasAntAsiTarj(this.getSesion())*-1);
			if (dsCabAsiento.getDate("fecha").before(fecDiasAnt))
				throw new ExceptionValidation(null,"La fecha del asiento no puede ser anterior a "+getMaxDiasAntAsiTarj(this.getSesion())+" dias con respecto de la fecha actual");
			
			
			cabAsiLiquiTarj.setNro_liquidacion(dsCabAsiento.getInteger("nro_liquidacion"));
			cabAsiLiquiTarj.setArch_interfaz_gen(false);
			cabAsiLiquiTarj.setFec_arch_interfaz(null);
			cabAsiLiquiTarj.setHora_arch_interfaz("");
			cabAsiLiquiTarj.setConta_sist_ext(false);
			cabAsiLiquiTarj.setFec_conta_sist_ext(null);
			cabAsiLiquiTarj.setHor_conta_sist_ext("");
			cabAsiLiquiTarj.setTipo_archivo(null);
			cabAsiLiquiTarj.setCtaBancoLiqTarj(CtaBancoLiqTarj.findByOidProxy(dsCabAsiento.getInteger("oid_cta_banco"), this.getSesion()));
			cabAsiLiquiTarj.setActivo(true);
			cabAsiLiquiTarj.setEmpresa(empresa);
			cabAsiLiquiTarj.setCabModeloLiq(cabModeloLiq);
			
			dsCabAsiento.next();
		}

		int orden = 0;
		dsDetAsiento.first();
		while (!dsDetAsiento.EOF()) {
			DetAsiLiquiTarj detAsiLiquiTarj = (DetAsiLiquiTarj) DetAsiLiquiTarj.getNew(DetAsiLiquiTarj.NICKNAME, this.getSesion());

			boolean tieneInfo = false;

			if ((dsDetAsiento.getMoney("debe") != null) && (dsDetAsiento.getMoney("debe").doubleValue() != 0))
				tieneInfo = true;

			if ((dsDetAsiento.getMoney("haber") != null) && (dsDetAsiento.getMoney("haber").doubleValue() != 0))
				tieneInfo = true;

			if (tieneInfo == false) {
				dsDetAsiento.next();
				continue;
			}

			++orden;
			detAsiLiquiTarj.setCabasiliqtarj(cabAsiLiquiTarj);
			detAsiLiquiTarj.setOrden(orden);
			detAsiLiquiTarj.setCuenta(dsDetAsiento.getString("cuenta"));
			detAsiLiquiTarj.setDesc_cuenta(dsDetAsiento.getString("desc_cuenta"));
			detAsiLiquiTarj.setCompo1(dsDetAsiento.getString("compo1"));
			detAsiLiquiTarj.setCompo2(dsDetAsiento.getString("compo2"));
			detAsiLiquiTarj.setDebe(dsDetAsiento.getMoney("debe").doubleValue());
			detAsiLiquiTarj.setHaber(dsDetAsiento.getMoney("haber").doubleValue());
			detAsiLiquiTarj.setComentario(dsDetAsiento.getString("comentario"));
			detAsiLiquiTarj.setCodImpuesto(dsDetAsiento.getString("cod_impuesto"));
			detAsiLiquiTarj.setPorcImpuesto(dsDetAsiento.getDouble("porc_imp"));
			detAsiLiquiTarj.setBaseImpuesto(dsDetAsiento.getDouble("base"));
			
			detAsiLiquiTarj.setActivo(true);
			cabAsiLiquiTarj.addDetalle(detAsiLiquiTarj);
			
			
			if (detAsiLiquiTarj.getDebe()!=null)
				totDebe.sumar(new Money(detAsiLiquiTarj.getDebe()));
			
			if (detAsiLiquiTarj.getHaber()!=null)
				totHaber.sumar(new Money(detAsiLiquiTarj.getHaber()));
			
			dsDetAsiento.next();
		}
		
		// Validar control de gatos
		if (isControGastos()) {
			if (totGastos != totDebe.getResultMoney().doubleValue())
				throw new ExceptionValidation(null,"El total de gastos debe coincidir con el total de la columna DEBE");
		}

		if (cabAsiLiquiTarj != null) {
			if (orden > 0) { 
				
				if (totDebe.getResult() != totHaber.getResult())
					throw new ExceptionValidation(null,"El asiento no balancea.");

				dsDetCupones.first();
				if (dsDetCupones.EOF())
					throw new ExceptionValidation(null,"No se encuentra movimiento de POSNET pendiente de liquidar.");
				
				cabAsiLiquiTarj.save();
				
				dsDetCupones.first();
				while (!dsDetCupones.EOF()) {
					ArchLoteConciDet archLoteConciDet = ArchLoteConciDet.findByOid(dsDetCupones.getInteger("oid_arch_lote_det"), this.getSesion());
					archLoteConciDet.setContaAsiLiq(true);
					archLoteConciDet.setCabAsiLiquiTarj(cabAsiLiquiTarj);
					archLoteConciDet.setNroLiquidacion(cabAsiLiquiTarj.getNro_liquidacion());
					archLoteConciDet.save();
					dsDetCupones.next();
				}				
				
				
				// Si esta todo OK hacer la grabacion del Asiento en el sistema externo
				if (isGenerarAsientoLiquidacion()) {
					if (getTipoAsiLiqTarj().equals("CPM")) {
						// CPM
						AsiLiqCPMOracle asiLiqCPMOracle = new AsiLiqCPMOracle();
						asiLiqCPMOracle.setSesion(this.getSesion());
						asiLiqCPMOracle.setCadenaConexionBD(getCadenaConexionAsiCobTarj());
						asiLiqCPMOracle.setCabAsiLiquiTarj(cabAsiLiquiTarj);
						asiLiqCPMOracle.setUsuario(this.getUsuarioConexionAsiCobTarj());
						asiLiqCPMOracle.setClave(this.getClaveConexionAsiCobTarj());
						ref = asiLiqCPMOracle.generarAsiento();
						
						IDataSet ds = getDataSetAsiGen();
						cargarAsiLiqGen(ds, ref);
						writeCliente(ds);
						
						// Marcar la cabecera del asiento como contabilizado
						CabAsiLiquiTarj cabAsiLiquiTarjExt =
							CabAsiLiquiTarj.findByOid(cabAsiLiquiTarj.getOIDInteger(), this.getSesion());
						cabAsiLiquiTarjExt.setConta_sist_ext(true);
						cabAsiLiquiTarjExt.setFec_conta_sist_ext(UtilCIP.getFechaHoraActual(this.getSesion()));
						cabAsiLiquiTarjExt.setHor_conta_sist_ext(UtilCIP.getHHMM(UtilCIP.getFechaHoraActual(this.getSesion())));
						cabAsiLiquiTarjExt.save();
						
					}
				}
								
				
			    IDataSet ds = getDataSet();
			    cargarRegistro(ds, cabAsiLiquiTarj.getOIDInteger());
			    writeCliente(ds);
			    
			} else
				throw new ExceptionValidation(null,"No se ingresaron datos para contabilizar asiento de liquidaciones.");
		} else {
			throw new ExceptionValidation(null,"No se ingresaron datos para contabilizar asiento de liquidaciones.");
		}

		

		


	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGenAsiLiq");
		dataset.fieldDef(new Field("nro_liquidacion", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer nroLiquidacion) throws BaseException {
		dataset.append();
		dataset.fieldValue("nro_liquidacion", nroLiquidacion);
	}
	
	public boolean isGenerarAsientoLiquidacion()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CONTA_ASI_LIQ_TARJ_SE", this.getSesion()).getBoolean();
	}	
	
	public String getTipoAsiLiqTarj()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"TIPO_ASI_LIQ_TARJ", this.getSesion()).getValorCadena();
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
		dataset.create("TAsiLiqGenerado");
		dataset.fieldDef(new Field("referencia", Field.STRING, 200));
		return dataset;
	}	
	
	private void cargarAsiLiqGen(IDataSet ds,String referencia) throws BaseException {
		ds.append();
		ds.fieldValue("referencia", referencia);
	}
	
	public boolean isControGastos()
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"ACT_CGASTOS_LIQTARJ", this.getSesion()).getBoolean();
	}
	
	public int getMaxDiasAntAsiTarj(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"MAX_DIAS_ANT_ASI_TARJ", aSesion).getValorEntero();
	}	

}
