package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ComproSubReparto extends ComproCab implements IContabilizable {

	private ComproCab comprobante;
	RenglonesAsiento renglones = new RenglonesAsiento();
	private AnuladorComproSubReparto anuladorComproSubReparto = null;
	
	private List detalles = new ArrayList();
	private boolean readDetalles = true;
	
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	

	public java.util.Date getImputacion() throws BaseException {
		return this.getImputac();
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public ComproSubReparto() {
	}

	public static String NICKNAME = "cg.ComproSubReparto";

	private String cod_ejecucion;
	private String desc_ejecucion;
	private java.util.Date fec_desde;
	private java.util.Date fec_hasta;
	private SubReparto subReparto;

	public String getCod_ejecucion() throws BaseException {
		supportRefresh();
		return cod_ejecucion;
	}

	public void setCod_ejecucion(String aCod_ejecucion) {
		this.cod_ejecucion = aCod_ejecucion;
	}

	public String getDesc_ejecucion() throws BaseException {
		supportRefresh();
		return desc_ejecucion;
	}

	public void setDesc_ejecucion(String aDesc_ejecucion) {
		this.desc_ejecucion = aDesc_ejecucion;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public java.util.Date getFec_hasta() throws BaseException {
		supportRefresh();
		return fec_hasta;
	}

	public void setFec_hasta(java.util.Date aFec_hasta) {
		this.fec_hasta = aFec_hasta;
	}

	public SubReparto getSubReparto() throws BaseException {
		supportRefresh();
		return this.subReparto;
	}

	public void setSubReparto(SubReparto aSubReparto) {
		this.subReparto = aSubReparto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproSubReparto findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproSubReparto) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ComproSubReparto findByOidProxy(Integer oid, ISesion aSesion)
	throws BaseException {
		return (ComproSubReparto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static ComproSubReparto findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ComproSubReparto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		
		if (this.isNew()) {

			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
			
		}

		beforeSaveComprobante(this);
		
    	if (isNew()) {
    		subRepartir();
    		renglones = null;
    		setCod_ejecucion(this.getCodigo());
    	}
		
    	

    	
		Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
		Validar.noNulo(subReparto, "Debe ingresar el SubReparto");
	}
	
	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		return renglones;
	}
	
	public static Talonario getTalonarioDefaultSubRep(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioSubreparto(aSesion);
	}
	
	public List getDetalles() throws BaseException {
	  if (readDetalles) {
		 List listaDetalles = ComproSubRepartoDet.getDetalles(this,getSesion());
		 detalles.addAll(listaDetalles);
		 readDetalles = false;
	  }
	  return detalles;
	}
	
	public void addDetalle(ComproSubRepartoDet aComproSubRepDet) throws BaseException {
		aComproSubRepDet.setCompro_subreparto(this);
		detalles.add(aComproSubRepDet);
	}
	
	public void afterSave() throws BaseException {
		    Iterator iterDetalles = detalles.iterator();
		    while (iterDetalles.hasNext()) {
		      ComproSubRepartoDet comproDet = (ComproSubRepartoDet) iterDetalles.next();
		      comproDet.save();
		      comproDet = null;
		    }
		    iterDetalles = null;
	}
	
	public void subRepartir() throws BaseException {
		// Obtener las cuentas fuentes
		Iterator iterSubRepartosDet = 
			this.getSubReparto().getSubRepartosDet().iterator();
		while (iterSubRepartosDet.hasNext()) {
			SubRepartoDet subRepartoDet = (SubRepartoDet) iterSubRepartosDet.next();
			subRepartirFase(subRepartoDet.getFase());
		}
		
	}
	
	private void addRenglonSubreparto(RenglonesAsiento renglones,
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
	
	private void subRepartirFase(FaseSubReparto fase) throws BaseException {
	
		renglones = new RenglonesAsiento();
		
		
		List listaComproContaDet =
			ComproContaDet.getImputacionesByCuentasValoresCompo(
				this.getFec_desde(), 
				this.getFec_hasta(),
				fase.getListaCuentasOrigenes(),
				fase.getListaValoresDeComponentes(),
				this.getSesion());
		
		// Obtener las Cuentas Fuentes a Repartir
		Iterator iterComproContaDet = 
			listaComproContaDet.iterator();
		while (iterComproContaDet.hasNext()) {
			ComproContaDet comproContaDet = (ComproContaDet) iterComproContaDet.next();
			
			// Invertir el Movimiento
			ComproSubRepartoDet comproSubRepDet = (ComproSubRepartoDet)
				ComproSubRepartoDet.getNew(ComproSubRepartoDet.NICKNAME, this.getSesion());
			comproSubRepDet.setCompro_subreparto(this);
			
			comproSubRepDet.setCuenta_imputable(comproContaDet.getCuentaImputable());
			comproSubRepDet.setSigno(comproContaDet.getSigno().intValue()*-1);
			comproSubRepDet.setImporteLocHist(comproContaDet.getImpoLocHist().doubleValue());
			comproSubRepDet.setImporteLocAju(comproContaDet.getImpoLocAju().doubleValue());
			comproSubRepDet.setImpoMonExt1(comproContaDet.getImpoMonExt1().doubleValue());
			comproSubRepDet.setImpoMonExt2(comproContaDet.getImpoMonExt2().doubleValue());
			comproSubRepDet.setFaseSubReparto(fase);
			comproSubRepDet.setActivo(new Boolean(true));
			comproSubRepDet.setImporteOri(comproContaDet.getImporteOriginal().doubleValue());
			comproSubRepDet.setMonedaOri(comproContaDet.getMoneda());
			comproSubRepDet.setValorCotizMonExt1(comproContaDet.getCotizMonOri());
			comproSubRepDet.setValorCotizMonExt1(comproContaDet.getCotizMonExt1());
			comproSubRepDet.setValorCotizMonExt2(comproContaDet.getCotizMonExt2());
			comproSubRepDet.setComproContaDet(comproContaDet);
			comproSubRepDet.setProporcion(new Double(1));
			comproSubRepDet.setComponente(fase.getCompo_destino());
			comproContaDet.getCuentaImputable().getValorCompo(fase.getCompo_destino());
			comproSubRepDet.setValorCompo(comproContaDet.getCuentaImputable().getValorCompo(fase.getCompo_destino()));
			
			
			
			this.addDetalle(comproSubRepDet);
			
			addRenglonSubreparto(renglones,
					comproSubRepDet.getCuenta_imputable(),
					comproSubRepDet.getSigno(),
					new Money(comproSubRepDet.getImpoLocHist()),
					new Money(comproSubRepDet.getImpoLocAju()),
					new Money(comproSubRepDet.getImpoMonExt1()),
					new Money(comproSubRepDet.getImpoMonExt2()),
					comproContaDet.getMoneda(),
					comproContaDet.getImporteOriginal(),
					comproContaDet.getCotizMonOri(),
					comproContaDet.getCotizMonExt1(),
					comproContaDet.getCotizMonExt2()
					);
					
			// SubRepartir la Cuenta entre los Componentes Destinos segun proporcion indicada
			HashTableDatos proporcionesPorValCompoDest =
				fase.getProporcionesPorCompoDestino(this.getFec_desde(), this.getFec_hasta());
			
			CalculadorMoney totAcumImpoMonHist = new CalculadorMoney(new Money(0));
			CalculadorMoney totAcumImpoMonAju = new CalculadorMoney(new Money(0));
			CalculadorMoney totAcumImpoMonExt1 = new CalculadorMoney(new Money(0));
			CalculadorMoney totAcumImpoMonExt2 = new CalculadorMoney(new Money(0));
			
			Iterator iterValorObjNeg = 
				proporcionesPorValCompoDest.keySet().iterator();
			while (iterValorObjNeg.hasNext()) {
				IObjetoLogico objLog = (IObjetoLogico) iterValorObjNeg.next();
				CuentaImputable nuevaCtaImpu =
					comproSubRepDet.getCuenta_imputable().getCtaImpuReemplandoValorCompo(
							fase.getCompo_destino(), 
							objLog);
				
				ComproSubRepartoDet comproSubRepDetNuevo = (ComproSubRepartoDet)
					ComproSubRepartoDet.getNew(ComproSubRepartoDet.NICKNAME, this.getSesion());
				comproSubRepDetNuevo.setCompro_subreparto(this);
				comproSubRepDetNuevo.setCuenta_imputable(nuevaCtaImpu);
				comproSubRepDetNuevo.setSigno(comproContaDet.getSigno().intValue());
				comproSubRepDetNuevo.setFaseSubReparto(fase);
				comproSubRepDetNuevo.setActivo(new Boolean(true));
				comproSubRepDetNuevo.setMonedaOri(comproContaDet.getMoneda());
				comproSubRepDetNuevo.setValorCotizMonExt1(comproContaDet.getCotizMonOri());
				comproSubRepDetNuevo.setValorCotizMonExt1(comproContaDet.getCotizMonExt1());
				comproSubRepDetNuevo.setValorCotizMonExt2(comproContaDet.getCotizMonExt2());
				comproSubRepDetNuevo.setComproContaDet(comproContaDet);
				
				Money proporcion = (Money) proporcionesPorValCompoDest.get(objLog);
				if (proporcion == null)
					proporcion = new Money(0);
				
				comproSubRepDetNuevo.setProporcion(proporcion.doubleValue());
				comproSubRepDetNuevo.setComponente(fase.getCompo_destino());
				comproSubRepDetNuevo.setValorCompo(objLog);
				
				
				// Importe Proporcion Origen
				CalculadorMoney calcImpoPropOrigen = 
					new CalculadorMoney(comproContaDet.getImporteOriginal());
				calcImpoPropOrigen.multiplicarPor(proporcion);
				comproSubRepDetNuevo.setImporteOri(calcImpoPropOrigen.getResult(2));
				
				
				// Importe Mon Loc Hist
				CalculadorMoney calcImpoPropLocHist = 
					new CalculadorMoney(comproContaDet.getImpoLocHist());
				calcImpoPropLocHist.multiplicarPor(proporcion);
				comproSubRepDetNuevo.setImporteLocHist(calcImpoPropLocHist.getResult(2));
				totAcumImpoMonHist.sumar(new Money(comproSubRepDetNuevo.getImpoLocHist()));
				
				
				// Importe Mon Loc Aju
				CalculadorMoney calcImpoPropLocAju = 
					new CalculadorMoney(comproContaDet.getImpoLocAju());
				calcImpoPropLocAju.multiplicarPor(proporcion);
				comproSubRepDetNuevo.setImporteLocAju(calcImpoPropLocAju.getResult(2));
				totAcumImpoMonAju.sumar(new Money(comproSubRepDetNuevo.getImpoLocAju()));
				
				// Importe Mon Ext1
				CalculadorMoney calcImpoPropMonExt1 = 
					new CalculadorMoney(comproContaDet.getImpoMonExt1());
				calcImpoPropMonExt1.multiplicarPor(proporcion);
				comproSubRepDetNuevo.setImpoMonExt1(calcImpoPropMonExt1.getResult(2));	
				totAcumImpoMonExt1.sumar(new Money(comproSubRepDetNuevo.getImpoMonExt1()));
				
				// Importe Mon Ext2
				CalculadorMoney calcImpoPropMonExt2 = 
					new CalculadorMoney(comproContaDet.getImpoMonExt2());
				calcImpoPropMonExt2.multiplicarPor(proporcion);
				comproSubRepDetNuevo.setImpoMonExt2(calcImpoPropMonExt2.getResult(2));		
				totAcumImpoMonExt2.sumar(new Money(comproSubRepDetNuevo.getImpoMonExt2()));
				
				this.addDetalle(comproSubRepDetNuevo);
				
				// Si hay diferencias al realizar la propocion ajustar sobre el ultimo componente
				if (iterValorObjNeg.hasNext()==false) {
					
					// Ajustar Impo Mon Loc Historico
					CalculadorMoney calcDifMonHist = new CalculadorMoney(comproContaDet.getImpoLocHist());
					calcDifMonHist.restar(totAcumImpoMonHist.getResultMoney());
					calcDifMonHist.sumar(new Money(comproSubRepDetNuevo.getImpoLocHist()));
					comproSubRepDetNuevo.setImporteLocHist(calcDifMonHist.getResult(2));
					
					// Ajustar Impo Mon Loc Ajustado
					CalculadorMoney calcDifMonAju = new CalculadorMoney(comproContaDet.getImpoLocAju());
					calcDifMonAju.restar(totAcumImpoMonAju.getResultMoney());
					calcDifMonAju.sumar(new Money(comproSubRepDetNuevo.getImpoLocAju()));
					comproSubRepDetNuevo.setImporteLocAju(calcDifMonAju.getResult(2));
					
					// Ajustar Impo Mon Ext 1
					CalculadorMoney calcDifMonExt1 = new CalculadorMoney(comproContaDet.getImpoMonExt1());
					calcDifMonExt1.restar(totAcumImpoMonExt1.getResultMoney());
					calcDifMonExt1.sumar(new Money(comproSubRepDetNuevo.getImpoMonExt1()));
					comproSubRepDetNuevo.setImpoMonExt1(calcDifMonExt1.getResult(2));
					
					// Ajustar Impo Mon Ext 2
					CalculadorMoney calcDifMonExt2 = new CalculadorMoney(comproContaDet.getImpoMonExt2());
					calcDifMonExt2.restar(totAcumImpoMonExt2.getResultMoney());
					calcDifMonExt2.sumar(new Money(comproSubRepDetNuevo.getImpoMonExt2()));
					comproSubRepDetNuevo.setImpoMonExt2(calcDifMonExt2.getResult(2));
					
				}
				
				addRenglonSubreparto(renglones,
						comproSubRepDetNuevo.getCuenta_imputable(),
						comproSubRepDetNuevo.getSigno(),
						new Money(comproSubRepDetNuevo.getImpoLocHist()),
						new Money(comproSubRepDetNuevo.getImpoLocAju()),
						new Money(comproSubRepDetNuevo.getImpoMonExt1()),
						new Money(comproSubRepDetNuevo.getImpoMonExt2()),
						comproContaDet.getMoneda(),
						comproContaDet.getImporteOriginal(),
						comproContaDet.getCotizMonOri(),
						comproContaDet.getCotizMonExt1(),
						comproContaDet.getCotizMonExt2()
						);
						
				
			}
			
		}
		
		
		// Grabar la Informacion en la Contabilidad, para que la misma sea tomada por la siguiente fase
		contabilizarComprobante(this);
		
		
	}
	
	public void anular() throws BaseException {

		anuladorComproSubReparto = (AnuladorComproSubReparto) AnuladorComproSubReparto.getNew(AnuladorComproSubReparto.NICKNAME, getSesion());
		anuladorComproSubReparto.setComproSubReparto(this);
		anuladorComproSubReparto.generarComproAnulacion();
		anuladorComproSubReparto.save();		
		
	}
	
	
	

}
