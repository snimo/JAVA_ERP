package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.da.DBUnidadEdilicia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class UnidadEdilicia extends ObjetoLogico {

	public UnidadEdilicia() {
	}

	public static String NICKNAME = "ve.UnidadEdilicia";

	private String codigo;
	private String calle_y_mro;
	private String localidad;
	private String codigo_postal;
	private TipoUnidadEdilicia tipo_unidad;
	private String telefonos;
	private Provincia provincia;
	private Boolean dom_ent;
	private String contacto;
	private Sujeto sujeto_alta;
	private Pais pais;
	private Zona zona;
	private Boolean activo;
	private String dirCompleta;
	private Boolean esDomicilioCobranza;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public Boolean isDomicilioCobranza() throws BaseException {
		supportRefresh();
		return this.esDomicilioCobranza;
	}

	public void setIsDomicilioCobranza(Boolean aIsDomicilioEntrega) {
		this.esDomicilioCobranza = aIsDomicilioEntrega;
	}
	

	public String getDirCompleta() throws BaseException {
		supportRefresh();
		return this.dirCompleta;
	}

	public void setDirCompleta(String aDirCompleta) {
		this.dirCompleta = aDirCompleta;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return this.getDireccionCompleta();
	}

	public void setDescripcion(String aDescripcion) {
	}

	public String getCalle_y_mro() throws BaseException {
		supportRefresh();
		return calle_y_mro;
	}

	public void setCalle_y_mro(String aCalle_y_mro) {
		this.calle_y_mro = aCalle_y_mro;
	}

	public String getDireccionCompleta() throws BaseException {

		StringBuffer dir = new StringBuffer();
		if (this.getCalle_y_mro() != null) {
			if (!this.getCalle_y_mro().equals("."))
				dir.append(this.getCalle_y_mro());
		}

		if ((this.getLocalidad() != null) && !(this.getLocalidad().equals("."))) {

			if ((this.getLocalidad() != null)
					&& (this.getLocalidad().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(", ");
			}

			dir.append(this.getLocalidad());

		}

		if ((this.getCodigo_postal() != null)
				&& (!this.getCodigo_postal().equals("."))) {

			if ((this.getCodigo_postal() != null)
					&& (this.getCodigo_postal().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(" ");
			}

			if ((this.getCodigo_postal() != null)
					&& (this.getCodigo_postal().length() > 0))
				dir.append("(" + this.getCodigo_postal() + ")");

		}
		if (this.getProvincia() != null) {
			if ((dir.toString().trim().length() != 0))
				dir.append(", ");
			dir.append(this.getProvincia().getDescripcion());
		}
		if (this.getPais() != null) {
			if ((dir.toString().trim().length() != 0))
				dir.append(", ");

			dir.append(this.getPais().getDescripcion());
		}

		return dir.toString();
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public void setLocalidad(String aLocalidad) {
		this.localidad = aLocalidad;
	}

	public String getCodigo_postal() throws BaseException {
		supportRefresh();
		return codigo_postal;
	}

	public void setCodigo_postal(String aCodigo_postal) {
		this.codigo_postal = aCodigo_postal;
	}

	public TipoUnidadEdilicia getTipo_unidad() throws BaseException {
		supportRefresh();
		return tipo_unidad;
	}

	public void setTipo_unidad(TipoUnidadEdilicia aTipo_unidad) {
		this.tipo_unidad = aTipo_unidad;
	}

	public String getTelefonos() throws BaseException {
		supportRefresh();
		return telefonos;
	}

	public void setTelefonos(String aTelefonos) {
		this.telefonos = aTelefonos;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return provincia;
	}

	public void setProvincia(Provincia aProvincia) {
		this.provincia = aProvincia;
	}

	public Boolean isDom_ent() throws BaseException {
		supportRefresh();
		return dom_ent;
	}

	public void setDom_ent(Boolean aDom_ent) {
		this.dom_ent = aDom_ent;
	}

	public String getContacto() throws BaseException {
		supportRefresh();
		return contacto;
	}

	public void setContacto(String aContacto) {
		this.contacto = aContacto;
	}

	public Sujeto getSujeto_alta() throws BaseException {
		supportRefresh();
		return sujeto_alta;
	}

	public void setSujeto_alta(Sujeto aSujeto_alta) {
		this.sujeto_alta = aSujeto_alta;
	}

	public Pais getPais() throws BaseException {
		supportRefresh();
		return pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
	}

	public Zona getZona() throws BaseException {
		supportRefresh();
		return zona;
	}

	public void setZona(Zona aZona) {
		this.zona = aZona;
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

	public static UnidadEdilicia findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (UnidadEdilicia) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static UnidadEdilicia findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (UnidadEdilicia) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static UnidadEdilicia findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (UnidadEdilicia) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(codigo, "Debe ingresar el código del Domicilio");
		Validar.noNulo(calle_y_mro, "Debe ingresar la Dirección");
		Validar.noNulo(localidad, "Debe ingresar la Localidad");
		Validar.noNulo(provincia, "Debe ingresar la provincia");

		this.setDirCompleta(this.getArmarDirCompleta());

	}

	private String getArmarDirCompleta() throws BaseException {

		StringBuffer dirComp = new StringBuffer();

		if (this.getCalle_y_mro() != null) {
			if (dirComp.length() > 0)
				dirComp.append(" ");
			dirComp.append(this.getCalle_y_mro());
		}

		if (this.getLocalidad() != null) {
			if (dirComp.length() > 0)
				dirComp.append(" ");
			dirComp.append(this.getLocalidad());
		}

		if (this.getCodigo_postal() != null) {
			if (dirComp.length() > 0)
				dirComp.append(" ");
			dirComp.append(this.getCodigo_postal());
		}

		if (this.getProvincia() != null) {
			if (dirComp.length() > 0)
				dirComp.append(" ");
			dirComp.append(this.getProvincia().getDescripcion());
		}

		if (this.getPais() != null) {
			if (dirComp.length() > 0)
				dirComp.append(" ");
			dirComp.append(this.getPais().getDescripcion());
		}

		return dirComp.toString();

	}

	public static List getUnidadesEdilicias(Sujeto sujeto, ISesion aSesion)
			throws BaseException {
		return DBUnidadEdilicia.getUnidadesEdilicias(sujeto, aSesion);
	}

	public static String getCodigoDomEntAltaRapidaCliente(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro("COD_DOM_ENT_ALT_RAP_CLI",
				aSesion).getValorCadena();
	}

	public static UnidadEdilicia getUnidadEdilicia(String codigo,
			Sujeto sujeto, ISesion aSesion) throws BaseException {
		return DBUnidadEdilicia.getUnidadEdilicia(codigo, sujeto, aSesion);
	}

}
