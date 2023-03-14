package com.srn.erp.contabilidad.bm;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.srn.erp.contabilidad.da.DBConsultasContables;
import com.srn.erp.contabilidad.da.DBCuentaImputable;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.MotivoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.Validar;

public class CuentaImputable extends ObjetoLogico {

	public CuentaImputable() {
	}

	public static String	NICKNAME					= "cg.CuentaImputable";

	private Cuenta				cuenta;

	private Boolean				activo;

	private LinkedHashMap	listaValoresCompo	= new LinkedHashMap();

	public Map getValoresDeComponentes() throws BaseException {
		this.supportRefresh();
		return listaValoresCompo;
	}

	public void addValorCompo(Componente componente, IObjetoLogico aValorCompo) throws BaseException {
		listaValoresCompo.put(componente, aValorCompo);
	}

	public IObjetoLogico getValorCompo(Componente componente) throws BaseException {
		Iterator iterComponentes = listaValoresCompo.keySet().iterator();
		while (iterComponentes.hasNext()) {
			Componente compoLista = (Componente) iterComponentes.next();
			if (compoLista.getOID() == componente.getOID())
				return (IObjetoLogico) listaValoresCompo.get(compoLista);
		}
		return null;
	}

	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
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

	public static CuentaImputable findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CuentaImputable) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CuentaImputable findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CuentaImputable) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static String parseCodigoCuenta(String codigoImputacion) {
		StringBuffer codigoCuenta = new StringBuffer("");
		String caracter = null;
		for (int i = 0; i < codigoImputacion.length(); ++i) {
			caracter = codigoImputacion.substring(i, i + 1);
			if (caracter.equals("."))
				return codigoCuenta.toString();
			else
				codigoCuenta.append(caracter);

		}
		return codigoCuenta.toString();
	}

	public static String parseValoresCompoConcat(String codigoImputacion) {
		boolean terminoCuenta = false;
		StringBuffer valorCompoConcat = new StringBuffer("");
		for (int i = 0; i < codigoImputacion.length(); ++i) {
			if (terminoCuenta)
				valorCompoConcat.append(codigoImputacion.substring(i, i + 1));
			if (codigoImputacion.substring(i, i + 1).equals("."))
				terminoCuenta = true;
		}
		return valorCompoConcat.toString();
	}

	private static CuentaImputable getGenerarNuevaImputableSinEstructura(Cuenta cuenta, ISesion aSesion)
			throws BaseException {
		// Grabar la Nueva Imputable
		CuentaImputable cuentaImputable = (CuentaImputable) CuentaImputable.getNew(CuentaImputable.NICKNAME, aSesion);
		cuentaImputable.setCuenta(cuenta);
		cuentaImputable.setActivo(new Boolean(true));
		cuentaImputable.save();
		return cuentaImputable;
	}

	private static CuentaImputable getGenerarNuevaImputableConEstructura(Cuenta cuenta, HashTableDatos valoresCompo,
			ISesion aSesion) throws BaseException {
		// Grabar la Nueva Imputable
		CuentaImputable cuentaImputable = (CuentaImputable) CuentaImputable.getNew(CuentaImputable.NICKNAME, aSesion);
		cuentaImputable.setCuenta(cuenta);
		cuentaImputable.setActivo(new Boolean(true));

		Iterator iterComponentes = valoresCompo.keySet().iterator();
		while (iterComponentes.hasNext()) {
			Componente componente = (Componente) iterComponentes.next();
			IObjetoLogico valorCompo = (IObjetoLogico) valoresCompo.get(componente);
			cuentaImputable.addValorCompo(componente, valorCompo);
		}

		cuentaImputable.save();
		return cuentaImputable;
	}
	

	public static CuentaImputable findByCodigo(String codigo, ISesion aSesion) throws BaseException {

		// Parsear el codigo
		String codigoCuenta = parseCodigoCuenta(codigo);
		String valorCompoConcatenados = parseValoresCompoConcat(codigo);

		// Obtener la cuenta
		Cuenta cuenta = Cuenta.findByCodigo(codigoCuenta, aSesion);
		if (cuenta == null)
			throw new ExceptionValidation(null, "Código de cuenta " + codigoCuenta + " inexistente");

		return CuentaImputable.getImputable(cuenta, valorCompoConcatenados, aSesion);
	}
	
	public static Cuenta getCuenta(String codigoImputacion, ISesion aSesion) throws BaseException {
		String codigoCuenta = parseCodigoCuenta(codigoImputacion);
		return Cuenta.findByCodigo(codigoCuenta, aSesion);
	}

	public static CuentaImputable getImputable(String codigoImputacion, ISesion aSesion) throws BaseException {

		String codigoCuenta = parseCodigoCuenta(codigoImputacion);
		String valorCompoConcatenados = parseValoresCompoConcat(codigoImputacion);

		// Obtener la cuenta
		Cuenta cuenta = Cuenta.findByCodigo(codigoCuenta, aSesion);
		if (cuenta == null)
			throw new ExceptionValidation(null, "Código de cuenta " + codigoCuenta + " inexistente");

		return getImputable(cuenta, valorCompoConcatenados, aSesion);

	}

	public static CuentaImputable getImputable(Cuenta cuenta, String codigoValoresCompoConcat, ISesion aSesion)
			throws BaseException {
		if (cuenta.getEstructura() != null)
			return getImputableConEstructura(cuenta, codigoValoresCompoConcat, aSesion);
		else
			return getImputableSinEstructura(cuenta, aSesion);
	}

	
	public CuentaImputable getCtaImpuReemplandoValorCompo(Componente compo,IObjetoLogico valorCompo) throws BaseException {
		
		if (this.getCuenta().getEstructura() == null) return this;
		if (this.getCuenta().getEstructura().isPerteneceAEstructura(compo)==false) return this;
		
		HashTableDatos nuevaEstrucCompo = new HashTableDatos();
		
		Map mapValCompo = this.getValoresDeComponentes();
		Iterator iterCompoCta =
			mapValCompo.keySet().iterator();
		while (iterCompoCta.hasNext()) {
			Componente compoCta = (Componente) iterCompoCta.next();
			if (compoCta.getOID() == compo.getOID()) 
				nuevaEstrucCompo.put(compoCta, valorCompo);
			else
				nuevaEstrucCompo.put(compoCta, mapValCompo.get(compoCta));
		}
		
		return getImputable(this.getCuenta(),nuevaEstrucCompo,this.getSesion());
	}
	
	public static CuentaImputable getImputable(Cuenta cuenta, HashTableDatos valoresCompo, ISesion aSesion)
			throws BaseException {
		if (cuenta.getEstructura() != null)
			return getImputableConEstructuraValCompo(cuenta, valoresCompo, aSesion);
		else
			return getImputableSinEstructura(cuenta, aSesion);
	}

	public static CuentaImputable getImputableConEstructuraValCompo(Cuenta cuenta, HashTableDatos valoresComponentes,
			ISesion aSesion) throws BaseException {
		CuentaImputable cuentaImputable = DBCuentaImputable.getImputableByCuentayValCompo(cuenta, valoresComponentes,
				aSesion);
		if (cuentaImputable != null)
			return cuentaImputable;
		else
			return getGenerarNuevaImputableConEstructura(cuenta, valoresComponentes, aSesion);

	}

	private static CuentaImputable getImputableConEstructura(Cuenta cuenta, String codigoValoresCompoConcat,
			ISesion aSesion) throws BaseException {

		Vector listaCodigosValCompo = getCodigosValoresCompo(codigoValoresCompoConcat);
		HashTableDatos valoresDeComponentes = new HashTableDatos();

		Iterator iterEstrucCompo = cuenta.getEstructura().getEstrucComponenentes().iterator();
		int i = 0;
		while (iterEstrucCompo.hasNext()) {
			EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
			IObjetoLogico valorCompo = null;
			if (i > (listaCodigosValCompo.size() - 1)) {
				
				// Trarar de Deducir el Valor del componente
				valorCompo = Componente.getDeducirValorComponente(valoresDeComponentes, estrucCompo.getComponente(), aSesion);
				
				if (valorCompo == null)
					valorCompo = estrucCompo.getValorDefault();
				
				if (valorCompo == null)
					throw new ExceptionValidation(null, "No se ingresó un valor para el componente "
							+ estrucCompo.getComponente().getDescripcion());
				} 
			else { 
				String codigoValCompo = (String) listaCodigosValCompo.get(i);
				if (codigoValCompo.length()==0) {
					valorCompo = Componente.getDeducirValorComponente(valoresDeComponentes, estrucCompo.getComponente(), aSesion);
					if (valorCompo == null)
						valorCompo = estrucCompo.getValorDefault();
				}
				else
					valorCompo = estrucCompo.getComponente().getValorCompo(codigoValCompo);
			}
			
			
			if (valorCompo == null) {
				String codigoNoEnco = "";
				if (i<listaCodigosValCompo.size()) {
					codigoNoEnco = (String) listaCodigosValCompo.get(i);
				}
				
				throw new ExceptionValidation(null, "Valor (" +codigoNoEnco +") inexistente. Correspondiente a "+ estrucCompo.getComponente().getDescripcion()
						+ " (" + estrucCompo.getComponente().getCodigo() + ")");
			}
			valoresDeComponentes.put(estrucCompo.getComponente(), valorCompo);
			++i;
		}

		return getImputableConEstructuraValCompo(cuenta, valoresDeComponentes, aSesion);
	}

	private static CuentaImputable getImputableSinEstructura(Cuenta cuenta, ISesion aSesion) throws BaseException {
		List listaCuentas = DBCuentaImputable.getImputablesByCuenta(cuenta, aSesion);
		if (!listaCuentas.isEmpty())
			return (CuentaImputable) listaCuentas.get(0);
		else
			return getGenerarNuevaImputableSinEstructura(cuenta, aSesion);
	}

	public static Vector getCodigosValoresCompo(String valoresCompoConcat) throws BaseException {
		Vector returnListaCodigos = new Vector();
		String[] listaCodigos = valoresCompoConcat.split("\\.");
		for (int i = 0; i < listaCodigos.length; ++i) {
			String codigo = listaCodigos[i];
			returnListaCodigos.add(codigo);
		}
		return returnListaCodigos;
	}
	
	public static int getCantValoresSegunValConcat(String valoresCompoConcat) throws BaseException {
		int cantCompo = 1;
		for (int i = 0; i < valoresCompoConcat.length(); ++i) {
			String letra = valoresCompoConcat.substring(i,i+1);
			if (letra.equals("."))
				++cantCompo;
		}
		return cantCompo;
	}

	public void beforeSave() throws BaseException {

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("La cuenta imputable debe estar en modo activo");		
		
		// Validar que se encuentren cargados todos los componentes de la cuenta
		if (this.getCuenta()==null)
			throw new ExceptionValidation(null,"Debe ingresar la cuenta");
		
		if (this.getCuenta().getEstructura()!=null) {
			// Validar que se encuentren cargados todos los componentes
			
			HashTableDatos valoresDeComponentes = new HashTableDatos();
			
			Iterator iterEstrucCompo =
				this.getCuenta().getEstructura().getEstrucComponenentes().iterator();
			while (iterEstrucCompo.hasNext()) {
				
			  EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
			  IObjetoLogico valorCargado = this.getValorCompo(estrucCompo.getComponente());
			  
			  if (valorCargado!=null) 
				  valoresDeComponentes.put(estrucCompo.getComponente(), valorCargado);
			  else {
				  
				  // Tratar de deducir el valor de componente o el valor por defecto
				  if (valorCargado == null)
					  valorCargado = Componente.getDeducirValorComponente(valoresDeComponentes, estrucCompo.getComponente(), this.getSesion());
			  
				  if (valorCargado == null)
					  valorCargado = estrucCompo.getValorDefault();
				  
				  if (valorCargado == null) {
						String descEstruc = "";
						if (getCuenta().getEstructura()!=null)
							descEstruc = "Estructura Cuenta:"+getCuenta().getDescEstrucCta()+Util.ENTER();
					  
						throw new ExceptionValidation(null, "No se ha ingresado valor para el componente "
								+ estrucCompo.getComponente().getDescripcion()+"."+Util.ENTER()+
								descEstruc+
								"Cuenta ingresada:"+Util.ENTER()+this.getCodigoCuentaMasCodigosValCompo()+Util.ENTER()+
								this.getDescCuentaMasDescValCompo());
				  }
				  addValorCompo(estrucCompo.getComponente(),valorCargado);
				  
				  
			  }
			  
			}
			
			
		}
		
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		return getDescCuentaMasDescValCompo();
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() throws BaseException {
		return this.getCodigoCuentaMasCodigosValCompo();
	}

	public static List getImputablesByCuenta(Cuenta cuenta, ISesion aSesion) throws BaseException {
		return DBCuentaImputable.getImputablesByCuenta(cuenta, aSesion);
	}

	public static List getImputablesByCuentayValoresCompo(Cuenta cuenta, HashTableDatos valoresCompo, ISesion aSesion)
			throws BaseException {
		return DBCuentaImputable.getImputablesByCuentayValoresCompo(cuenta, valoresCompo, aSesion);
	}

	public static List getImputablesByCuentayNotInValoresCompo(Cuenta cuenta, HashTableDatos valoresCompo, ISesion aSesion)
			throws BaseException {
		return DBCuentaImputable.getImputablesByCuentayNotInValoresCompo(cuenta, valoresCompo, aSesion);
	}

	public String getDescValCompo() throws BaseException {
		StringBuffer descripcion = new StringBuffer("");
		Iterator iterCompo = getValoresDeComponentes().keySet().iterator();
		while (iterCompo.hasNext()) {
			Componente componente = (Componente) iterCompo.next();
			IObjetoLogico valorCompo = (IObjetoLogico) getValoresDeComponentes().get(componente);
			if (valorCompo instanceof ValorCompo)
				descripcion.append("." + ((ValorCompo) valorCompo).getDescValoresComponentes());
			else {
				if (valorCompo != null)
					descripcion.append("." + valorCompo.getDescripcion());
				else
					descripcion.append(".???");
			}
		}
		return descripcion.toString();
	}

	private void MensajeErrorValorCompoInex(Componente componente) throws BaseException {
		String mensajeError = "No se pudo leer un valor para el componente " + componente.getDescripcion()
				+ " correspondiente a la cuenta " + getCuenta().getDescripcion();
		throw new ExceptionValidation(null, mensajeError);
	}

	public String getDescCuentaMasDescValCompo() throws BaseException {
		StringBuffer descripcion = new StringBuffer("");
		descripcion.append(getCuenta().getDescripcion());
		return descripcion.append(getDescValCompo()).toString();
	}

	public String getCodigoCuentaMasCodigosValCompo() throws BaseException {
		StringBuffer codigo = new StringBuffer("");
		codigo.append(getCuenta().getCodigo());
		Iterator iterCompo = getValoresDeComponentes().keySet().iterator();
		while (iterCompo.hasNext()) {
			Componente componente = (Componente) iterCompo.next();
			// System.out.println(componente.getDescripcion());
			IObjetoLogico valorCompo = (IObjetoLogico) getValoresDeComponentes().get(componente);
			if (valorCompo != null)
				codigo.append("." + valorCompo.getCodigo());
			else
				codigo.append(".???");
		}
		return codigo.toString();
	}

	public static CuentaImputable getCuentaImputable(ConceptoCtaContable conceptoCtaContable, IObjetoLogico objetoLogico,
			ISesion aSesion) throws BaseException {
		CuentaImputable ctaImpu = null;
		Iterator iterCriSelCta = conceptoCtaContable.getCriteriosSelCuenta().iterator();
		while (iterCriSelCta.hasNext()) {
			CriterioSelCuenta criterioSelCta = (CriterioSelCuenta) iterCriSelCta.next();
			ctaImpu = criterioSelCta.getCuentaImputable(objetoLogico);
			if (ctaImpu != null)
				return ctaImpu;
		}
		return ctaImpu;
	}

	public boolean isValidaIngVarios(MotivoComprobante motivoComprobante) {
		return true;
	}

	public boolean isCuentaImputableHabIngVar(MotivoComprobante motivoComprobante, ISesion sesion) throws BaseException {
		CuentaImputable ctaImpu = DBCuentaImputable.getCuentaimputableHabIngVar(this, motivoComprobante, sesion);
		if (ctaImpu != null)
			return true;
		else
			return false;
	}

	public boolean isCuentaImputableHabRendFF(ISesion sesion) throws BaseException {
		CuentaImputable ctaImpu = DBCuentaImputable.getCuentaimputableHabRendFF(this, sesion);
		if (ctaImpu != null)
			return true;
		else
			return false;
	}
	
	public boolean isCuentaImputableHabModuloBancos(ISesion sesion) throws BaseException {
		CuentaImputable ctaImpu = DBCuentaImputable.getCuentaimputableHabModuloBancos(this, sesion);
		if (ctaImpu != null)
			return true;
		else
			return false;
	}
	
	
	public boolean isCuentaImputableHabConcFactProv(ISesion sesion,ConcFactProv concFactProv) throws BaseException {
		CuentaImputable ctaImpu = DBCuentaImputable.getCuentaimputableHabConcFactProv(this,concFactProv, sesion);
		if (ctaImpu != null)
			return true;
		else
			return false;
	}
	
	public ImportesContables getSaldo()
              throws BaseException {

		MapDatos condiciones = new HashTableDatos();
		condiciones.put("oid_ana_imp_con",this);
		ImportesContables importesContables = null;

		DBConsultasContables consultasContables = new DBConsultasContables();
		consultasContables.setSesion(getSesion());
		PreparedStatement psConsSaldo;
		try {
			psConsSaldo = consultasContables.prepararSelect(
					DBConsultasContables.SELECT_BY_SALDO_ANA_IMP, condiciones);
			// TODO Auto-generated catch block

		java.sql.ResultSet rsSaldo = null;
		rsSaldo = psConsSaldo.executeQuery();

		double saldoFechaImpoMonLoc   = 0;
		double saldoFechaImpoMonAju   = 0;
		double saldoFechasImpoMonExt1 = 0;
		double saldoFechasImpoMonExt2 = 0;

		if (rsSaldo.next()) {
			saldoFechaImpoMonLoc   = rsSaldo.getDouble("impo_loc_his");
			saldoFechaImpoMonAju   = rsSaldo.getDouble("impo_loc_aju");
			saldoFechasImpoMonExt1 = rsSaldo.getDouble("impo_mon_ext_1");
			saldoFechasImpoMonExt2 = rsSaldo.getDouble("impo_mon_ext_2");
		}

		rsSaldo.close();
		psConsSaldo.close();

		importesContables =
					new ImportesContables(new Money(saldoFechaImpoMonLoc),
										  new Money(saldoFechaImpoMonAju),
										  new Money(saldoFechasImpoMonExt1),
										  new Money(saldoFechasImpoMonExt2)
					);
		
		} catch (SQLException e) {
			throw new ExceptionValidation(null,"Error al obtener el saldo de la imputable ");
		}
		return importesContables;
		
	}
	
	

}
