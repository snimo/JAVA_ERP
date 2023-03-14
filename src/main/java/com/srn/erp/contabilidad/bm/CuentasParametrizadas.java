package com.srn.erp.contabilidad.bm;

import com.srn.erp.ventas.bm.FacturaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CuentasParametrizadas {

	public CuentasParametrizadas() {
	}

	public static ConceptoCtaContable getConcProveedores(ISesion aSesion) throws BaseException {
		Integer oidConceptoCtaContable = ValorParametro.findByCodigoParametro("CONC_CTA_PROVEEDORES", aSesion)
				.getOidObjNeg();
		ConceptoCtaContable concCtaContable = ConceptoCtaContable.findByOid(oidConceptoCtaContable, aSesion);
		return concCtaContable;
	}

	public static ConceptoCtaContable getConcVta(ISesion aSesion) throws BaseException {
		Integer oidConceptoVta = ValorParametro.findByCodigoParametro("CONC_CTA_VENTAS", aSesion).getOidObjNeg();
		ConceptoCtaContable concCtaContable = ConceptoCtaContable.findByOid(oidConceptoVta, aSesion);
		return concCtaContable;
	}

	public static ConceptoCtaContable getConcBonificacion(ISesion aSesion) throws BaseException {
		Integer oidConceptoBonificacion = ValorParametro.findByCodigoParametro("CONC_BONIF_VTAS", aSesion).getOidObjNeg();
		ConceptoCtaContable concCtaContable = ConceptoCtaContable.findByOid(oidConceptoBonificacion, aSesion);
		return concCtaContable;
	}

	public static ConceptoCtaContable getConcBonificacionExtraordinaria(ISesion aSesion) throws BaseException {
		Integer oidConceptoBonificacion = ValorParametro.findByCodigoParametro("CONC_BONIF_EXTRA_VTAS", aSesion)
				.getOidObjNeg();
		ConceptoCtaContable concCtaContable = ConceptoCtaContable.findByOid(oidConceptoBonificacion, aSesion);
		return concCtaContable;
	}

	public static ConceptoCtaContable getConcRecargo(ISesion aSesion) throws BaseException {
		Integer oidConceptoRecargo = ValorParametro.findByCodigoParametro("CONC_RECAR_VTAS", aSesion).getOidObjNeg();
		ConceptoCtaContable concCtaContable = ConceptoCtaContable.findByOid(oidConceptoRecargo, aSesion);
		return concCtaContable;
	}

	public static CuentaImputable getProveedores(IObjetoLogico objLog, ISesion aSesion) throws BaseException {
		ConceptoCtaContable concProveedores = getConcProveedores(aSesion);
		CuentaImputable ctaImputable = CuentaImputable.getCuentaImputable(concProveedores, objLog, aSesion);
		if (ctaImputable == null)
			throw new ExceptionValidation(null, "No se pudo obtener la cuenta imputable del concepto contable "
					+ concProveedores.getDescripcion());
		return ctaImputable;
	}

	public static CuentaImputable getImputableVenta(IObjetoLogico objLog, ISesion aSesion) throws BaseException {
		
		if (objLog instanceof FacturaDet) {
			if (((FacturaDet)objLog).getProducto().getCuentaVenta()!=null)
				return ((FacturaDet)objLog).getProducto().getCuentaVenta();
		}
			
		
		ConceptoCtaContable concVenta = getConcVta(aSesion);
		CuentaImputable ctaImputable = CuentaImputable.getCuentaImputable(concVenta, objLog, aSesion);
		if (ctaImputable == null)
			throw new ExceptionValidation(null, "No se pudo obtener la cuenta imputable del concepto contable "
					+ concVenta.getDescripcion());
		return ctaImputable;
	}

	public static CuentaImputable getImputableBonificacion(IObjetoLogico objLog, ISesion aSesion) throws BaseException {
		ConceptoCtaContable concBonif = getConcBonificacion(aSesion);
		CuentaImputable ctaImputable = CuentaImputable.getCuentaImputable(concBonif, objLog, aSesion);
		if (ctaImputable == null)
			throw new ExceptionValidation(null, "No se pudo obtener la cuenta imputable del concepto contable "
					+ concBonif.getDescripcion());
		return ctaImputable;
	}

	public static CuentaImputable getImputableBonificacionExtraordinaria(IObjetoLogico objLog, ISesion aSesion)
			throws BaseException {
		ConceptoCtaContable concBonif = getConcBonificacionExtraordinaria(aSesion);
		CuentaImputable ctaImputable = CuentaImputable.getCuentaImputable(concBonif, objLog, aSesion);
		if (ctaImputable == null)
			throw new ExceptionValidation(null, "No se pudo obtener la cuenta imputable del concepto contable "
					+ concBonif.getDescripcion());
		return ctaImputable;
	}

	public static CuentaImputable getImputableRecargo(IObjetoLogico objLog, ISesion aSesion) throws BaseException {
		ConceptoCtaContable concRecar = getConcRecargo(aSesion);
		CuentaImputable ctaImputable = CuentaImputable.getCuentaImputable(concRecar, objLog, aSesion);
		if (ctaImputable == null)
			throw new ExceptionValidation(null, "No se pudo obtener la cuenta imputable del concepto contable "
					+ concRecar.getDescripcion());
		return ctaImputable;
	}

	public static CuentaImputable getProveedores(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_PROVEEDORES", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getEfectivoML(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_EFE_ML", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getEfectivoME(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_EFE_ME", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getDiferenciaCambio(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_DIF_CAMBIO", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getDescuentoOP(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_DTO_OP", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getDeudoresPorVentas(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_DEUDORES_VTAS", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getDtoOtorgadoRecibo(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_DTO_RECIBO", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}
	
	public static CuentaImputable getPagoACuentaRecibo(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPU_PAGO_A_CTA_REC", aSesion).getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}
	

	public static CuentaImputable getIVACredito(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPUTABLE_IVA_CREDITO", aSesion)
				.getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}
	
	public static CuentaImputable getIVADebito(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPUTABLE_IVA_DEBITO", aSesion)
				.getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}
	

	public static CuentaImputable getPercIVACredito(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPUTABLE_PERC_IVA_CREDITO", aSesion)
				.getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

	public static CuentaImputable getImpIntVtas(ISesion aSesion) throws BaseException {
		Integer oidCuentaImputable = ValorParametro.findByCodigoParametro("CTA_IMPUTABLE_IMP_INT_VTAS", aSesion)
				.getOidObjNeg();
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(oidCuentaImputable, aSesion);
		return cuentaImputable;
	}

}
