package com.srn.erp.proveedoresMaterials.bm;

import com.srn.erp.proveedoresMaterials.da.DBNumeradorMaterial;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class NumeradorMaterial extends ObjetoLogico {

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public NumeradorMaterial() {
	}

	public static String NICKNAME = "ma.NumeradorMaterial";

	private String stb_name;
	private Integer stb_identnr;
	private String owner;
	private String dbLink;

	public String getStb_name() throws BaseException {
		supportRefresh();
		return stb_name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDbLink() {
		return dbLink;
	}

	public void setDbLink(String dbLink) {
		this.dbLink = dbLink;
	}

	public void setStb_name(String aStb_name) {
		this.stb_name = aStb_name;
	}

	public Integer getStb_identnr() throws BaseException {
		supportRefresh();
		return stb_identnr;
	}

	public void setStb_identnr(Integer aStb_identnr) {
		this.stb_identnr = aStb_identnr;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static NumeradorMaterial findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NumeradorMaterial) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NumeradorMaterial findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NumeradorMaterial) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static int getUltNroProveedor(ISesion sesion, String owner, String dblink) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CODIGO", "LIEFER");
		condiciones.put("OWNER", owner);
		condiciones.put("DBLINK", dblink);

		NumeradorMaterial numeradorMaterial = NumeradorMaterial.getNumeradorMaterial(condiciones, sesion);
		return numeradorMaterial.getStb_identnr();
	}

	public static void generarProxNroProveedor(ISesion sesion, String owner, String dblink) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CODIGO", "LIEFER");
		condiciones.put("OWNER", owner);
		condiciones.put("DBLINK", dblink);

		NumeradorMaterial numeradorMaterial = NumeradorMaterial.getNumeradorMaterial(condiciones, sesion);
		numeradorMaterial.setOwner(owner);
		numeradorMaterial.setDbLink(dblink);
		numeradorMaterial.setStb_identnr(numeradorMaterial.getStb_identnr().intValue() + 1);
		numeradorMaterial.setForUpdate();
		numeradorMaterial.save();
	}

	public static NumeradorMaterial getNumeradorMaterial(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBNumeradorMaterial.getNumeradorMaterial(condiciones, aSesion);
	}

}
