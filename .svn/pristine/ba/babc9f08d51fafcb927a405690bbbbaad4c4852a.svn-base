package com.srn.erp.bancos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bancos.da.DBConciliacionCab;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;
import com.srn.erp.tesoreria.bm.OperacionCuentaBancaria;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ConciliacionCab extends ComproCab implements IContabilizable {

	public ConciliacionCab() {
	}
	
	RenglonesAsiento renglones = new RenglonesAsiento();

	private List conciliacionesDet = new ArrayList();
	private boolean readConciliacionesDet = true;
	
	private List conciliacionesBcoDia = new ArrayList();
	private boolean readConciliacionesBcoDia = true;
	
	HashTableDatos asientosAGenerar = new HashTableDatos();
	
	public static String NICKNAME = "ba.ConciliacionCab";

	private ComproCab comprobante;
	private String codigo;
	private java.util.Date conciliado_al;
	private java.util.Date fec_desde;
	private String descripcion;
	private CuentaBancaria cuenta_bancaria;
	private String obs_generales;
	private Double saldo_ini_extrac;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public java.util.Date getConciliado_al() throws BaseException {
		supportRefresh();
		return conciliado_al;
	}

	public void setConciliado_al(java.util.Date aConciliado_al) {
		this.conciliado_al = aConciliado_al;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	
	public java.util.Date getImputacion() throws BaseException {
		return this.getImputac();
	}
	
	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public CuentaBancaria getCuenta_bancaria() throws BaseException {
		supportRefresh();
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(CuentaBancaria aCuenta_bancaria) {
		this.cuenta_bancaria = aCuenta_bancaria;
	}

	public String getObs_generales() throws BaseException {
		supportRefresh();
		return obs_generales;
	}

	public void setObs_generales(String aObs_generales) {
		this.obs_generales = aObs_generales;
	}

	public Double getSaldo_ini_extrac() throws BaseException {
		supportRefresh();
		return saldo_ini_extrac;
	}

	public void setSaldo_ini_extrac(Double aSaldo_ini_extrac) {
		this.saldo_ini_extrac = aSaldo_ini_extrac;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConciliacionCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ConciliacionCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConciliacionCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ConciliacionCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ConciliacionCab findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ConciliacionCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	private void conciliacionMoviExistentes(
			RelaComproConciRenglones relacionComproConciRenglones,
			ConciliacionDet conciliacionDet) throws BaseException {
		
		if ((conciliacionDet.isConciliado()) 
				&& (!conciliacionDet.isNuevo_mov())
				&& (conciliacionDet.getMovimiento_cuenta()!=null)
				) {
				Integer signoContrario = new Integer(0);
				if (conciliacionDet.getA_conciliar().doubleValue()>0)
					signoContrario = new Integer(-1);
				else
					signoContrario = new Integer(1);
				
				addRenglonConciliacion(
						relacionComproConciRenglones.getRenglonesAsiento(),
						conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getCuentaimputableAConciliar(),
						signoContrario,
						conciliacionDet.getMovimiento_cuenta().getImportehist(),
						conciliacionDet.getMovimiento_cuenta().getImporteaju(),
						conciliacionDet.getMovimiento_cuenta().getImporteext1(),
						conciliacionDet.getMovimiento_cuenta().getImporteext2(),
						conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getMoneda(),
						conciliacionDet.getMovimiento_cuenta().getImporte(),
						conciliacionDet.getMovimiento_cuenta().getCotizMonOri(),
						conciliacionDet.getMovimiento_cuenta().getCotizMonExt1(),
						conciliacionDet.getMovimiento_cuenta().getCotizMonExt2());
				
				addRenglonConciliacion(
						relacionComproConciRenglones.getRenglonesAsiento(),
						conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getCuentaMovRealesBco(),
						new Integer(signoContrario.intValue()*-1),
						conciliacionDet.getMovimiento_cuenta().getImportehist(),
						conciliacionDet.getMovimiento_cuenta().getImporteaju(),
						conciliacionDet.getMovimiento_cuenta().getImporteext1(),
						conciliacionDet.getMovimiento_cuenta().getImporteext2(),
						conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getMoneda(),
						conciliacionDet.getMovimiento_cuenta().getImporte(),
						conciliacionDet.getMovimiento_cuenta().getCotizMonOri(),
						conciliacionDet.getMovimiento_cuenta().getCotizMonExt1(),
						conciliacionDet.getMovimiento_cuenta().getCotizMonExt2());
				
				// Marcar el Movimiento como conciliado
				if (conciliacionDet.getMovimiento_cuenta()!=null) {
					conciliacionDet.getMovimiento_cuenta().supportRefresh();
					conciliacionDet.getMovimiento_cuenta().setConciliado(new Boolean(true));
					conciliacionDet.getMovimiento_cuenta().setConciliacionCab(this);
					conciliacionDet.getMovimiento_cuenta().setFechaOperativa(conciliacionDet.getFecha());
					conciliacionDet.getMovimiento_cuenta().save();
				}
					

			}
		
	}
	
	private void conciliacionNuevoMovimiento(
			RelaComproConciRenglones relacionComproConciRenglones,
			ConciliacionDet conciliacionDet) throws BaseException {
		
		// Actualizar el Movimiento en el Banco
		ImportesContables importeContable =
			grabarMovimientoConciliacion(conciliacionDet);
				
		CuentaImputable cuentaDebe = null;
		CuentaImputable cuentaHaber = null;
		
		// Hacer el asiento contable
		if (conciliacionDet.getA_conciliar().doubleValue()>0) {
			cuentaHaber = conciliacionDet.getCuenta_contable();
			if (conciliacionDet.isConciliado())
				cuentaDebe = this.getCuenta_bancaria().getCuentaMovRealesBco();
			else
				cuentaDebe = this.getCuenta_bancaria().getCuentaimputableAConciliar();
		} else {
			cuentaDebe = conciliacionDet.getCuenta_contable();
			if (conciliacionDet.isConciliado())
				cuentaHaber = this.getCuenta_bancaria().getCuentaMovRealesBco();
			else
				cuentaHaber = this.getCuenta_bancaria().getCuentaimputableAConciliar();
		}
			
		if (conciliacionDet.isNuevo_mov()) {
							
				addRenglonConciliacion(
						relacionComproConciRenglones.getRenglonesAsiento(),
						cuentaDebe,
						new Integer(1),
						importeContable.getImpoMonLoc(),
						importeContable.getImpoMonLocAju(),
						importeContable.getImpoMonExt1(),
						importeContable.getImpoMonExt2(),
						conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getMoneda(),
						new Money(conciliacionDet.getA_conciliar_Positivo()),
						getCotizacionMoneda(conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getMoneda()),
						getCotizMonExt1(),
						getCotizMonExt2());
				
				addRenglonConciliacion(
						relacionComproConciRenglones.getRenglonesAsiento(),
						cuentaHaber,
						new Integer(-1),
						importeContable.getImpoMonLoc(),
						importeContable.getImpoMonLocAju(),
						importeContable.getImpoMonExt1(),
						importeContable.getImpoMonExt2(),
						conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getMoneda(),
						new Money(conciliacionDet.getA_conciliar_Positivo()),
						getCotizacionMoneda(conciliacionDet.getConciliacion_cab().getCuenta_bancaria().getMoneda()),
						getCotizMonExt1(),
						getCotizMonExt2());
				
			}
		
	}
	
	private void generarAsientosConciliacion() throws BaseException {
		
		asientosAGenerar = new HashTableDatos();
		
		Iterator iterConcDet =
			this.conciliacionesDet.iterator();
		while (iterConcDet.hasNext()) {
			ConciliacionDet conciliacionDet = (ConciliacionDet) iterConcDet.next();
			if (conciliacionDet.getEsSaldoInicial()) continue;
			if ((!conciliacionDet.isConciliado()) && (!conciliacionDet.isNuevo_mov())) continue;

			RelaComproConciRenglones relacionComproConciRenglones = 
				(RelaComproConciRenglones)
					   asientosAGenerar.get(conciliacionDet.getFecha());
			
			if (relacionComproConciRenglones == null) {
				
				ComproConciliacionBcoDia comproConciBcoDia = (ComproConciliacionBcoDia)
					ComproConciliacionBcoDia.getNew(ComproConciliacionBcoDia.NICKNAME, this.getSesion());
				
				relacionComproConciRenglones = new RelaComproConciRenglones();
				
				Talonario talonario = ComproConciliacionBcoDia.getTalonarioAsientoConciliacion(this.getSesion());
				comproConciBcoDia.setTalonario(talonario);
				comproConciBcoDia.setContabiliza(true);
				comproConciBcoDia.setEmision(Fecha.getFechaActual());
				comproConciBcoDia.setImputac(conciliacionDet.getFecha());
				comproConciBcoDia.setTipoCompro(talonario.getTipo_comprobante());
				comproConciBcoDia.setLetra(talonario.getLetra());
				comproConciBcoDia.setLugarEmision(talonario.getLugar_emision());
				comproConciBcoDia.setNrolugemision(talonario.getLugar_emision().getLugemi());
				comproConciBcoDia.setComentario("");
				comproConciBcoDia.setActivo(true);
				
				RenglonesAsiento renglones = new RenglonesAsiento();
				comproConciBcoDia.setRenglonesAsiento(renglones);
				
				relacionComproConciRenglones.setComproConciBcoDia(comproConciBcoDia);
				relacionComproConciRenglones.setRenglonesAsiento(renglones);
				
				asientosAGenerar.put(conciliacionDet.getFecha(),relacionComproConciRenglones);
				
			}
			
			if (conciliacionDet.isNuevo_mov())
				conciliacionNuevoMovimiento(relacionComproConciRenglones,conciliacionDet);
			else
				conciliacionMoviExistentes(relacionComproConciRenglones,conciliacionDet);
						
		}
		
		// Grabar los Asientos
		Iterator iterAsientosAGenerar =
			asientosAGenerar.values().iterator();
		while (iterAsientosAGenerar.hasNext()) {
			RelaComproConciRenglones relaComproConciRen = 
				(RelaComproConciRenglones) iterAsientosAGenerar.next();
			
			relaComproConciRen.getComproConciBcoDia().save();
			
			ConciliacionBancoDia conciliacionBcoDia =
				(ConciliacionBancoDia)
					ConciliacionBancoDia.getNew(ConciliacionBancoDia.NICKNAME, this.getSesion());
			conciliacionBcoDia.setConciliacion(this);
			conciliacionBcoDia.setCompro_conciliacion_dia(relaComproConciRen.getComproConciBcoDia());
			conciliacionBcoDia.setActivo(new Boolean(true));
			conciliacionBcoDia.save();
			
		}
		
		
		
	}
	
	private void addRenglonConciliacion(RenglonesAsiento renglones,
			CuentaImputable cuenta,
			Integer signo,
			Money impoMonLocHist,
			Money impoMonLocAju,
			Money impoMonExt1,
			Money impoMonExt2,
			Moneda monedaOri,
			Money importeOri,
			ValorCotizacion cotizMonOri,
			ValorCotizacion monExt1,
			ValorCotizacion monExt2
			) throws BaseException {
		
		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(cuenta);
		renglon.setD_H(signo);
		renglon.setMonedaOri(monedaOri);
		renglon.setImporteOri(importeOri);
		renglon.setCotizOri(cotizMonOri);
		renglon.setCotizMonExt1(monExt1);
		renglon.setCotizMonExt2(monExt2);
		renglon.setComentario("");

		renglon.setImpoLocHist(impoMonLocHist);
		renglon.setImpoLocAju(impoMonLocAju);
		renglon.setImpoMonExt1(impoMonExt1);
		renglon.setImpoMonExt2(impoMonExt2);
		
	}
	

	public void beforeSave() throws BaseException {

		if (this.isNew()) {

			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));

		}

		beforeSaveComprobante(this);
		
		if (isNew()) {
    		generarAsientosConciliacion();
    		renglones = null;
    		setCodigo(this.getNroExt().toString());
    		setDescripcion(Fecha.getddmmyyyy(this.getFec_desde())+" al "+
    				Fecha.getddmmyyyy(this.getConciliado_al())+" "+this.getCuenta_bancaria().getCodigo()+" - "+
    						this.getCuenta_bancaria().getDescripcion()
    						);
    	}		

		Validar.noNulo(conciliado_al,
				"Debe ingresar la fecha hasta de la Conciliación");
		Validar.noNulo(fec_desde,
				"Debe ingresar la fecha desde de la Conciliación");
		Validar.noNulo(cuenta_bancaria, "Debe ingresar la Cuenta Bancarias");

	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		return renglones;
	}

	public List getConciliacionesDet() throws BaseException {
		if (readConciliacionesDet) {
			List listaConciliacionesDet = ConciliacionDet.getConciliacionesDet(
					this, getSesion());
			conciliacionesDet.addAll(listaConciliacionesDet);
			readConciliacionesDet = false;
		}
		return conciliacionesDet;
	}
	
	public List getConciliacionesBcoDia() throws BaseException {
		if (readConciliacionesDet) {
			List listaConciliacionesBcoDia = ConciliacionBancoDia.getConciliacionesBcoDia(
					this, getSesion());
			conciliacionesBcoDia.addAll(listaConciliacionesBcoDia);
			readConciliacionesBcoDia = false;
		}
		return conciliacionesBcoDia;
	}
	

	public void addConciliacionDet(ConciliacionDet aConciliacionDet)
			throws BaseException {
		aConciliacionDet.setConciliacion_cab(this);
		conciliacionesDet.add(aConciliacionDet);
	}
	
	public void addConciliacionBancoDia(ConciliacionBancoDia aConciliacionBancoDia)
		throws BaseException {
		aConciliacionBancoDia.setConciliacion(this);
		conciliacionesBcoDia.add(aConciliacionBancoDia);
	}

	public void afterSave() throws BaseException {
		
		Iterator iterConciliacionesDet = conciliacionesDet.iterator();
		while (iterConciliacionesDet.hasNext()) {
			ConciliacionDet conciliacionDet = (ConciliacionDet) iterConciliacionesDet
					.next();
			conciliacionDet.save();
			conciliacionDet = null;
			
			
		}
		iterConciliacionesDet = null;
		
		
		Iterator iterConciliacionesBcoDia = conciliacionesBcoDia.iterator();
		while (iterConciliacionesBcoDia.hasNext()) {
			ConciliacionBancoDia conciliacionBcoDia = (ConciliacionBancoDia) iterConciliacionesBcoDia
					.next();
			conciliacionBcoDia.save();
			conciliacionBcoDia = null;
		}
		iterConciliacionesBcoDia = null;
	}
	
	public ComproCab getComprobante() throws BaseException {
		return this.comprobante;
	}
	
	public static Talonario getTalonatioConciliacionBanco(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioConciliacionBanco(aSesion);
	}

	public static List getConciliacionesBancarias(
			  CuentaBancaria cuentaBancaria,
			  java.util.Date fechaDesde,
			  java.util.Date fechaHasta,
			  Integer nroDesde,
			  Integer nroHasta,
	          ISesion aSesion) throws BaseException {
		  return DBConciliacionCab.getConciliacionesBancarias(
				  cuentaBancaria,
				  fechaDesde,
				  fechaHasta,
				  nroDesde,
				  nroHasta,
				  aSesion);
	}
	
	private ImportesContables grabarMovimientoConciliacion(ConciliacionDet conciliacionDet) throws BaseException {

		int signo = 0;
		if (conciliacionDet.getA_conciliar().doubleValue()>=0) 
			signo = MovimientoCtaBancaria.ENTRADA;
		else 
			signo = MovimientoCtaBancaria.SALIDA;
		
		OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
		operacionCuentaBancaria.setSesion(getSesion());
		operacionCuentaBancaria.setCtaBancaria(this.getCuenta_bancaria());
		operacionCuentaBancaria.setFechaContable(conciliacionDet.getFecha());
		operacionCuentaBancaria.setFechaEmision(conciliacionDet.getFecha());
		operacionCuentaBancaria.setFechaVto(null);
		operacionCuentaBancaria.setSigno(new Integer(signo));
		operacionCuentaBancaria.setImporte(new Money(conciliacionDet.getA_conciliar_Positivo()));
		operacionCuentaBancaria.setComprobante(this);
		ImportesContables importesContables = this.getImportesContables(
				new Money(conciliacionDet.getA_conciliar_Positivo()), 
				this.getCuenta_bancaria().getMoneda(), 
				conciliacionDet.getFecha());
		operacionCuentaBancaria.setTipoMov(conciliacionDet.getTipo_mov());
		operacionCuentaBancaria.setImporteHist(importesContables.getImpoMonLoc());
		operacionCuentaBancaria.setImporteAju(importesContables.getImpoMonLocAju());
		operacionCuentaBancaria.setImporteExt1(importesContables.getImpoMonExt1());
		operacionCuentaBancaria.setImporteExt2(importesContables.getImpoMonExt2());
		operacionCuentaBancaria.setActivo(new Boolean(true));
		operacionCuentaBancaria.setCotizMonOri(getCotizacionMoneda(this.getCuenta_bancaria().getMoneda()));
		operacionCuentaBancaria.setCotizMonExt1(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2(this.getCotizMonExt2());
		operacionCuentaBancaria.setCotizMonOriCon(getCotizacionMoneda(this.getCuenta_bancaria().getMoneda()));
		operacionCuentaBancaria.setCotizMonExt1Con(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2Con(this.getCotizMonExt2());
		operacionCuentaBancaria.setValor(null);
		operacionCuentaBancaria.setNroValor(conciliacionDet.getNro_valor());
		operacionCuentaBancaria.setTipoValor(null);
		operacionCuentaBancaria.setCuenta(conciliacionDet.getCuenta_contable());
		if (conciliacionDet.isConciliado()) {
			operacionCuentaBancaria.setConciliado(true);
			operacionCuentaBancaria.setFechaOperativa(conciliacionDet.getFecha());
			operacionCuentaBancaria.setConciliacionCab(this);
		}
		
		operacionCuentaBancaria.save();
		return importesContables;
	}
	
	

}
