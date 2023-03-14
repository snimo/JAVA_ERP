package com.srn.erp.contabilidad.bm;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBGrupoAtributoEntidadVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class GrupoAtributoEntidadVar extends ObjetoLogico {

	private List		gruposAtributosHab			= new ArrayList();

	private boolean	readGruposAtributosHab	= true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GrupoAtributoEntidadVar() {
	}

	public static String	NICKNAME	= "cg.GrupoAtributoEntidadVar";

	private String				nickname;

	private String				nombre;

	private Boolean				activo;

	public String getNickname() throws BaseException {
		supportRefresh();
		return nickname;
	}

	public void setNickname(String aNickname) {
		this.nickname = aNickname;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
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

	public static GrupoAtributoEntidadVar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoAtributoEntidadVar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoAtributoEntidadVar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoAtributoEntidadVar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoAtributoEntidadVar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoAtributoEntidadVar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nickname, "Debe ingresar el Objeto de Negocio");
		Validar.noNulo(nombre, "Debe ingresar un Nombre");
	}

	public List getGruposAtributosHabilitados() throws BaseException {
		if (this.readGruposAtributosHab) {
			List listaGruposHabilitados = GrupoHabilitadoEntidad.getGruposHabilitadosVarEntidad(this, getSesion());
			gruposAtributosHab.addAll(listaGruposHabilitados);
			readGruposAtributosHab = false;
		}
		return gruposAtributosHab;
	}

	public void addGrupoHabilitadoEntidad(GrupoHabilitadoEntidad aGrupoHabilitadoEntidad) throws BaseException {
		aGrupoHabilitadoEntidad.setGrupo_atributo_entidad_var(this);
		gruposAtributosHab.add(aGrupoHabilitadoEntidad);
	}

	public void afterSave() throws BaseException {
		Iterator iterGruposHab = gruposAtributosHab.iterator();
		while (iterGruposHab.hasNext()) {
			GrupoHabilitadoEntidad grupoHabilitadoEntidad = (GrupoHabilitadoEntidad) iterGruposHab.next();
			grupoHabilitadoEntidad.save();
			grupoHabilitadoEntidad = null;
		}
		iterGruposHab = null;
	}

	public static List getGruposAtriEntVar(String nickname, ISesion aSesion) throws BaseException {
		return DBGrupoAtributoEntidadVar.getGruposAtriEntVar(nickname, aSesion);
	}

	public void agregarGrupoAtri(String tableName) throws BaseException {

		try {

			// Ejecutar query de tabla para verificar si ya existe el atributo
			Statement st = getSesion().getConexionBD().createStatement();
			ResultSet rs = st.executeQuery("select * from " + tableName + " where 1=2 ");

			boolean encontro = false;
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i) {
				String columnName = rs.getMetaData().getColumnName(i);
				if (columnName.toUpperCase().equals(this.getCampoFisico().toUpperCase())) {
					encontro = true;
					break;
				}
			}

			rs.close();
			st.close();

			// Si no lo encontro dar de alta el campo
			if (!encontro) {
				Statement st1 = getSesion().getConexionBD().createStatement();
				st1.execute("alter table " + tableName + " add " + this.getCampoFisico()+" integer");
				st1.close();
			}

		}
		catch (Exception e) {
			throw new ExceptionValidation(null, e.getMessage());
		}

	}
	
	public String getCampoFisico() throws BaseException {
		return "oid_g_a_"+this.getOIDInteger();
	}

}
