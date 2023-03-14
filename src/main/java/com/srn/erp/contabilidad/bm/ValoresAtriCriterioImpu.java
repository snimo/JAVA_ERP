package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBValoresAtriCriterioImpu;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValoresAtriCriterioImpu extends ObjetoLogico {

	public ValoresAtriCriterioImpu() {
	}

	public static final String TC_CUENTA = "CTA";

	public static final String TC_IMPUTABLE = "IMPU";

	public static String NICKNAME = "cg.ValoresAtriCriterioImpu";

	private List generarValoresCompo = new ArrayList();

	private boolean readGenerarValoresCompo = true;

	private CriterioSelCuenta criterio_sel_cta;

	private DefinicionAtributoEntidad atri_ent_1;

	private DefinicionAtributoEntidad atri_ent_2;

	private DefinicionAtributoEntidad atri_ent_3;

	private DefinicionAtributoEntidad atri_ent_4;

	private DefinicionAtributoEntidad atri_ent_5;

	private ObjetoLogico val_atri_1;

	private ObjetoLogico val_atri_2;

	private ObjetoLogico val_atri_3;

	private ObjetoLogico val_atri_4;

	private ObjetoLogico val_atri_5;

	private String tomar_cuenta;

	private CuentaImputable cuenta_imputable;

	private Cuenta cuenta_contable;

	public CriterioSelCuenta getCriterio_sel_cta() throws BaseException {
		supportRefresh();
		return criterio_sel_cta;
	}

	public void setCriterio_sel_cta(CriterioSelCuenta aCriterio_sel_cta) {
		this.criterio_sel_cta = aCriterio_sel_cta;
	}

	public DefinicionAtributoEntidad getAtri_ent_1() throws BaseException {
		supportRefresh();
		return atri_ent_1;
	}

	public void setAtri_ent_1(DefinicionAtributoEntidad aAtri_ent_1) {
		this.atri_ent_1 = aAtri_ent_1;
	}

	public DefinicionAtributoEntidad getAtri_ent_2() throws BaseException {
		supportRefresh();
		return atri_ent_2;
	}

	public void setAtri_ent_2(DefinicionAtributoEntidad aAtri_ent_2) {
		this.atri_ent_2 = aAtri_ent_2;
	}

	public DefinicionAtributoEntidad getAtri_ent_3() throws BaseException {
		supportRefresh();
		return atri_ent_3;
	}

	public void setAtri_ent_3(DefinicionAtributoEntidad aAtri_ent_3) {
		this.atri_ent_3 = aAtri_ent_3;
	}

	public DefinicionAtributoEntidad getAtri_ent_4() throws BaseException {
		supportRefresh();
		return atri_ent_4;
	}

	public void setAtri_ent_4(DefinicionAtributoEntidad aAtri_ent_4) {
		this.atri_ent_4 = aAtri_ent_4;
	}

	public DefinicionAtributoEntidad getAtri_ent_5() throws BaseException {
		supportRefresh();
		return atri_ent_5;
	}

	public void setAtri_ent_5(DefinicionAtributoEntidad aAtri_ent_5) {
		this.atri_ent_5 = aAtri_ent_5;
	}

	public ObjetoLogico getVal_atri_1() throws BaseException {
		supportRefresh();
		return val_atri_1;
	}

	public void setVal_atri_1(ObjetoLogico aVal_atri_1) {
		this.val_atri_1 = aVal_atri_1;
	}

	public ObjetoLogico getVal_atri_2() throws BaseException {
		supportRefresh();
		return val_atri_2;
	}

	public void setVal_atri_2(ObjetoLogico aVal_atri_2) {
		this.val_atri_2 = aVal_atri_2;
	}

	public ObjetoLogico getVal_atri_3() throws BaseException {
		supportRefresh();
		return val_atri_3;
	}

	public void setVal_atri_3(ObjetoLogico aVal_atri_3) {
		this.val_atri_3 = aVal_atri_3;
	}

	public ObjetoLogico getVal_atri_4() throws BaseException {
		supportRefresh();
		return val_atri_4;
	}

	public void setVal_atri_4(ObjetoLogico aVal_atri_4) {
		this.val_atri_4 = aVal_atri_4;
	}

	public ObjetoLogico getVal_atri_5() throws BaseException {
		supportRefresh();
		return val_atri_5;
	}

	public void setVal_atri_5(ObjetoLogico aVal_atri_5) {
		this.val_atri_5 = aVal_atri_5;
	}

	public String getTomar_cuenta() throws BaseException {
		supportRefresh();
		return tomar_cuenta;
	}

	public void setTomar_cuenta(String aTomar_cuenta) {
		this.tomar_cuenta = aTomar_cuenta;
	}

	public CuentaImputable getCuenta_imputable() throws BaseException {
		supportRefresh();
		return cuenta_imputable;
	}

	public void setCuenta_imputable(CuentaImputable aCuenta_imputable) {
		this.cuenta_imputable = aCuenta_imputable;
	}

	public Cuenta getCuenta_contable() throws BaseException {
		supportRefresh();
		return cuenta_contable;
	}

	public void setCuenta_contable(Cuenta aCuenta_contable) {
		this.cuenta_contable = aCuenta_contable;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ValoresAtriCriterioImpu findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ValoresAtriCriterioImpu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ValoresAtriCriterioImpu findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ValoresAtriCriterioImpu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ValoresAtriCriterioImpu findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ValoresAtriCriterioImpu) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(criterio_sel_cta,
				"Debe ingresar el Criterio de Selección");
		Validar.noNulo(tomar_cuenta, "Debe indicar como obtener la cuenta");
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getValoresAtriCriterioImpu(
			CriterioSelCuenta criterioSelCuenta, ISesion aSesion)
			throws BaseException {
		return DBValoresAtriCriterioImpu.getValoresAtriCriterioImpu(
				criterioSelCuenta, aSesion);
	}

	public static Hashtable getTomarCuentas() throws BaseException {
		Hashtable tomarCuentas = new Hashtable();
		tomarCuentas.put(TC_CUENTA, "Cuenta");
		tomarCuentas.put(TC_IMPUTABLE, "Imputable");
		return tomarCuentas;
	}

	public List getGenerarValoresCompo() throws BaseException {
		if (readGenerarValoresCompo) {
			List listaGenerarValCompo = GenerarValorCompoCriImpu
					.getGenerarValoresCompo(this, getSesion());
			generarValoresCompo.addAll(listaGenerarValCompo);
			readGenerarValoresCompo = false;
		}
		return generarValoresCompo;
	}

	public void addGenerarValorCompo(GenerarValorCompoCriImpu generarValorCompo)
			throws BaseException {
		generarValorCompo.setValoresatricriterioimputacion(this);
		generarValoresCompo.add(generarValorCompo);
	}

	public void afterSave() throws BaseException {
		Iterator iterGenerarValoresCompo = generarValoresCompo.iterator();
		while (iterGenerarValoresCompo.hasNext()) {
			GenerarValorCompoCriImpu generarValorCompo = (GenerarValorCompoCriImpu) iterGenerarValoresCompo
					.next();
			generarValorCompo.save();
			generarValorCompo = null;
		}
		iterGenerarValoresCompo = null;
	}

	public boolean isGenerarCuenta() throws BaseException {
		return this.getTomar_cuenta().equals(TC_CUENTA);
	}

	public static ValoresAtriCriterioImpu getValorAtriCriImpu(
			CriterioSelCuenta criterioSelCta, IObjetoLogico objetoLogico,
			ISesion aSesion) throws BaseException {
		return DBValoresAtriCriterioImpu.getValorAtriCriImpu(criterioSelCta,
				objetoLogico, aSesion);
	}

}
