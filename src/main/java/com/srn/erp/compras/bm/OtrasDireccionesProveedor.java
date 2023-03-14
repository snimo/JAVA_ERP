package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBOtrasDireccionesProveedor;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class OtrasDireccionesProveedor extends ObjetoLogico {

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getDireccionCompleta();
	}

	public OtrasDireccionesProveedor() {
	}

	public static String NICKNAME = "cp.OtrasDireccionesProveedor";

	private Proveedor proveedor;
	private String codigo;
	private String calle_y_nro;
	private String localidad;
	private String codigo_postal;
	private TipoUnidadEdilicia tipo_unidad;
	private String telefonos;
	private Provincia provincia;
	private String contacto;
	private Pais pais;
	private Boolean activo;
	private Boolean dom_dev_mercaderia;

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getCalle_y_nro() throws BaseException {
		supportRefresh();
		return calle_y_nro;
	}

	public void setCalle_y_nro(String aCalle_y_nro) {
		this.calle_y_nro = aCalle_y_nro;
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

	public String getContacto() throws BaseException {
		supportRefresh();
		return contacto;
	}

	public void setContacto(String aContacto) {
		this.contacto = aContacto;
	}

	public Pais getPais() throws BaseException {
		supportRefresh();
		return pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Boolean isDom_dev_mercaderia() throws BaseException {
		supportRefresh();
		return dom_dev_mercaderia;
	}

	public void setDom_dev_mercaderia(Boolean aDom_dev_mercaderia) {
		this.dom_dev_mercaderia = aDom_dev_mercaderia;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static OtrasDireccionesProveedor findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (OtrasDireccionesProveedor) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static OtrasDireccionesProveedor findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (OtrasDireccionesProveedor) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(proveedor, "Debe ingresar el Proveedor");
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(calle_y_nro, "Debe ingresar la callle y el Nro.");
		Validar.noNulo(tipo_unidad, "Debe Ingresar el Tipo de Unidad");
	}

	public static List getOtrasDireccionesProveedor(Proveedor proveedor,
			ISesion aSesion) throws BaseException {
		return DBOtrasDireccionesProveedor.getOtrasDireccionesProveedor(
				proveedor, aSesion);
	}

	public String getDireccionCompleta() throws BaseException {

		StringBuffer dir = new StringBuffer();
		if (this.getCalle_y_nro() != null) {
			if (!this.getCalle_y_nro().equals("."))
				dir.append(this.getCalle_y_nro());
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
	
	public static OtrasDireccionesProveedor getOtrasDireccionesProveedor(
			String codigo, Proveedor proveedor, ISesion aSesion)
			throws BaseException {
		return DBOtrasDireccionesProveedor.getOtrasDireccionesProveedor(codigo,proveedor,aSesion);
	}
	

}
