package com.srn.erp.tesoreria.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.tesoreria.da.DBConceptoLiqTarjeta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ConceptoLiqTarjeta extends ObjetoLogico {

	public ConceptoLiqTarjeta() {
	}

	public static String COMPOR_TAR_CREDITO = "TAR_CRE";
	public static String COMPOR_TAR_DEBITO = "TAR_DEB";

	public static String NICKNAME = "va.ConceptoLiqTarjeta";

	private String codigo;
	private String descripcion;
	private Cuenta cuenta;
	private String comportamiento;
	private Boolean activo;
	private TipoValor tipoValor;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public TipoValor getTipoValor() throws BaseException {
		supportRefresh();
		return this.tipoValor;
	}

	public void setTipoValor(TipoValor aTipoValor) {
		this.tipoValor = aTipoValor;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
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

	public static ConceptoLiqTarjeta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConceptoLiqTarjeta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConceptoLiqTarjeta findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ConceptoLiqTarjeta) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ConceptoLiqTarjeta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConceptoLiqTarjeta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el comportamiento");
	}

	public static HashTableDatos getComportamientos() throws BaseException {
		HashTableDatos compo = new HashTableDatos();
		compo.put(COMPOR_TAR_CREDITO, "Tarjeta de Crédito");
		compo.put(COMPOR_TAR_DEBITO, "Tarjeta de Débito");
		return compo;
	}

	public static List getConceptosTarjetasCredito(ISesion aSesion) throws BaseException {
		return DBConceptoLiqTarjeta.getConceptosTarjetasCredito(aSesion);
	}

	public static List getConceptosTarjetasDebito(ISesion aSesion) throws BaseException {
		return DBConceptoLiqTarjeta.getConceptosTarjetasDebito(aSesion);
	}

	public static List getAllConceptosActivos(ISesion aSesion) throws BaseException {
		return DBConceptoLiqTarjeta.getAllConceptosActivos(aSesion);
	}

	public CuentaImputable getCuentaImputable(TarjetaCredito tarjetaCredito, Banco banco) throws BaseException {

		Cuenta cuenta = null;
		
		if (this.getCuenta() != null) 
			cuenta = this.getCuenta();
		else if (this.getTipoValor()!=null) {
			
					if (this.getTipoValor().getCuentaImputable()!=null)
						return this.getTipoValor().getCuentaImputable();
					if (this.getTipoValor().getCuenta()!=null)
						cuenta = this.getTipoValor().getCuenta();
				}
		
		if (cuenta == null)
			return null;

		HashTableDatos valoresCompo = new HashTableDatos();
		Iterator iterEstrucCompo = cuenta.getEstructura().getEstrucComponenentes().iterator();
		while (iterEstrucCompo.hasNext()) {
				EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
				if (tarjetaCredito != null)
					if (estrucCompo.getComponente().getNombreNickName().equals(TarjetaCredito.NICKNAME))
						valoresCompo.put(estrucCompo.getComponente(), tarjetaCredito);

				if (banco != null)
					if (estrucCompo.getComponente().getNombreNickName().equals(Banco.NICKNAME))
						valoresCompo.put(estrucCompo.getComponente(), banco);

		}

		return CuentaImputable.getImputable(cuenta, valoresCompo, this.getSesion());
	}


}
