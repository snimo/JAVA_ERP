package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CategoriaSujetoTurno extends ObjetoLogico {

	public CategoriaSujetoTurno() {
	}

	private List conceptosHabilitados = new ArrayList();
	private boolean readConceptosHabilitados = true;

	public static String NICKNAME = "tu.CategoriaSujetoTurno";

	public static String CATEG_ACTIVO = "ACTIVO";
	public static String CATEG_CADETE = "CADETE";
	public static String CATEG_MENOR = "MENOR";
	public static String CATEG_SEMIPLETO = "SEMIPLETO";
	public static String CATEG_ADSCRIPTO = "ADSCRIPTO";
	public static String CATEG_HONORARIO = "HONORARIO";
	public static String CATEG_DEPORTIVO = "DEPORTIVO";
	public static String CATEG_VITALICIO = "VITALICIO";
	public static String CATEG_NINIO = "NINIO";
	public static String CATEG_PREACTIVO = "PREACTIVO";

	private String codigo;
	private String descripcion;
	private String comportamiento;
	private Boolean activo;
	private Boolean noPermitirTurno;
	private Money montoMaxDeuda;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public Money getMontoMaxDeuda() throws BaseException {
		supportRefresh();
		return this.montoMaxDeuda;
	}

	public void setMontoMaxDeuda(Money aMontoMaxDeuda) {
		this.montoMaxDeuda = aMontoMaxDeuda;
	}

	public Boolean isNoPermitirTurno() throws BaseException {
		supportRefresh();
		return this.noPermitirTurno;
	}

	public void setNoPermitirTurno(Boolean aNoPermitirTurno) {
		this.noPermitirTurno = aNoPermitirTurno;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CategoriaSujetoTurno findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategoriaSujetoTurno) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategoriaSujetoTurno findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (CategoriaSujetoTurno) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static CategoriaSujetoTurno findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (CategoriaSujetoTurno) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
	}

	public static HashTableDatos getCategorias() throws BaseException {
		HashTableDatos categorias = new HashTableDatos();
		categorias.put(CATEG_ACTIVO, "ACTIVO");
		categorias.put(CATEG_CADETE, "CADETE");
		categorias.put(CATEG_MENOR, "MENOR");
		categorias.put(CATEG_SEMIPLETO, "SEMIPLETO");
		categorias.put(CATEG_ADSCRIPTO, "ADSCRIPTO");
		categorias.put(CATEG_HONORARIO, "HONORARIO");
		categorias.put(CATEG_DEPORTIVO, "DEPORTIVO");
		categorias.put(CATEG_VITALICIO, "VITALICIO");
		categorias.put(CATEG_NINIO, "NIÑO");
		categorias.put(CATEG_PREACTIVO, "PREACTIVO");
		return categorias;
	}

	public static CategoriaSujetoTurno getCategSujTurnoInvitado(ISesion aSesion)
			throws BaseException {
		Integer oidCateg = ValorParametro.findByCodigoParametro(
				"CATEG_DEF_INVITADO_TURNOS", aSesion).getOidObjNeg();
		CategoriaSujetoTurno categ = CategoriaSujetoTurno.findByOid(oidCateg,
				aSesion);
		return categ;
	}

	public List getConceptosHabilitados() throws BaseException {
		if (readConceptosHabilitados) {
			List listaConceptos = ConcHabCateg.getConceptosHabCateg(this,
					getSesion());
			conceptosHabilitados.addAll(listaConceptos);
			readConceptosHabilitados = false;
		}
		return conceptosHabilitados;
	}

	public void addConceptoHab(ConcHabCateg aConcHab) throws BaseException {
		aConcHab.setOid_categoria(this);
		conceptosHabilitados.add(aConcHab);
	}

	public void afterSave() throws BaseException {
		Iterator iterConc = conceptosHabilitados.iterator();
		while (iterConc.hasNext()) {
			ConcHabCateg conc = (ConcHabCateg) iterConc.next();
			conc.save();
			conc = null;
		}
		iterConc = null;
	}
	
	public boolean isTieneConcHabilitados() throws BaseException {
		return !this.getConceptosHabilitados().isEmpty();
	}

}
