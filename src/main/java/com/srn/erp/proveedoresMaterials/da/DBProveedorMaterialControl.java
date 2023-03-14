package com.srn.erp.proveedoresMaterials.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import scala.collection.mutable.HashTable;

import com.srn.erp.proveedoresMaterials.bm.NumeradorMaterial;
import com.srn.erp.proveedoresMaterials.bm.ProveedorMaterialsControl;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBProveedorMaterialControl extends DBObjetoPersistente {

	public static final String OID_PROVEEDOR_UTE = "id";
	public static final String CUIT = "cuit";
	public static final String CUIT2 = "cuit2";
	public static final String RAZON_SOCIAL = "razon_social";
	public static final String RAZON_SOCIAL2 = "razon_social2";
	public static final String DIRECCION = "direccion";
	public static final String CONTACTO = "contacto";
	public static final String COMERCIAL = "comercial";
	public static final String TELEFONO = "telefono";
	public static final String EMAIL = "email";
	public static final String GRUPO_PROVEEDOR = "grupo_proveedor";
	public static final String CONDICION_PAGO = "condicion_pago";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_CUIT_UTE = 100;
	public static final int SELECT_BY_CUIT_BINBAIRES = 101;
	public static final int SELECT_BY_CUIT_ALAVERA = 102;
	public static final int SELECT_BY_CUIT_MAGIC = 103;
	public static final int SELECT_BY_RAZON_SOCIAL_UTE = 104;
	public static final int SELECT_BY_RAZON_SOCIAL_BINBAIRES = 105;
	public static final int SELECT_BY_RAZON_SOCIAL_ALAVERA = 106;
	public static final int SELECT_BY_RAZON_SOCIAL_MAGIC = 107;
	public static final int SELECT_BY_RAZON_SOCIAL_UTE_NO_CUIT = 108;
	public static final int SELECT_BY_RAZON_SOCIAL_BINBAIRES_NO_CUIT = 109;
	public static final int SELECT_BY_RAZON_SOCIAL_ALAVERA_NO_CUIT = 110;
	public static final int SELECT_BY_RAZON_SOCIAL_MAGIC_NO_CUIT = 111;
	
	public DBProveedorMaterialControl() {
	}

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROVEEDOR = 1;
    final int CUIT = 2;
    final int CUIT2 = 3;
    final int RAZON_SOCIAL = 4;
    final int RAZON_SOCIAL2 = 5;
    final int DIRECCION = 6;
    final int CONTACTO = 7;
    final int COMERCIAL = 8;
    final int TELEFONO = 9;
    final int EMAIL = 10;
    final int GRUPO_PROVEEDOR = 11;
    final int CONDICION_PAGO = 12;
    final int ACTIVO = 13;

    ProveedorMaterialsControl pers = (ProveedorMaterialsControl) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into " + pers.getOwner() + "liefer"+pers.getDbLink()+
                     " ( "+
                      "LF_ID,"+
                      "LF_KDNNR,"+
                      "LF_FKEY,"+
                      "LF_NAME,"+
                      "LF_NAMEID,"+
                      "LF_ADRESSE,"+
                      "LF_SACHB,"+
                      "LF_VERT,"+
                      "LF_TEL,"+
                      "LF_TELEX,"+
                      "SUG_NR,"+
                      "LF_ZBED,"+
                      "AKTIV,"+
                      "STE_ID,"+
                      "LF_EXISTFAX,"+
                      "LF_PROV,"+
                      "NEW_ZEIT,"+
                      "LF_ZWEITWAEHR,"+
                      "LF_GUTSCHRIFT,"+
                      "LF_PRICEORDERDATE,"+
                      "LF_CCACCOUNT)"+
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?)");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    
    // Obtener el Proveedor 
    int nuevoIDProveedor = NumeradorMaterial.getUltNroProveedor(this.getSesion(), pers.getOwner() , pers.getDbLink())+1;
    pers.setOID(nuevoIDProveedor);
    
    qInsert.setInt(OID_PROVEEDOR,pers.getOID());
    qInsert.setString(CUIT,pers.getCuit());
    qInsert.setString(CUIT2,pers.getCuit2());
    qInsert.setString(RAZON_SOCIAL,pers.getRazonsocial());
    qInsert.setString(RAZON_SOCIAL2,pers.getRazonSocial2());
    qInsert.setString(DIRECCION,pers.getDireccion());
    qInsert.setString(CONTACTO,pers.getContacto());
    qInsert.setString(COMERCIAL,pers.getComercail());
    qInsert.setString(TELEFONO,pers.getTelefono());
    qInsert.setString(EMAIL,pers.getEmail());
    if(pers.getGrupoproveedor() != null){
    	qInsert.setInt(GRUPO_PROVEEDOR,pers.getGrupoproveedor().intValue());
    }else{
    	qInsert.setNull(GRUPO_PROVEEDOR,java.sql.Types.INTEGER);
    }
    qInsert.setString(CONDICION_PAGO,pers.getCondicionpago());
    qInsert.setString(ACTIVO,pers.getActivo());
    qInsert.setInt(14,1);
    qInsert.setInt(15,0);
    qInsert.setString(16," ");
    qInsert.setDate(17,new java.sql.Date((new java.util.Date()).getTime()));
    qInsert.setInt(18,0);
    qInsert.setInt(19,0);
    qInsert.setInt(20,0);
    qInsert.setInt(21,0);
    qInsert.executeUpdate();
    qInsert.close();
    
    
    NumeradorMaterial.generarProxNroProveedor(this.getSesion(), pers.getOwner() , pers.getDbLink());
    
    
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

	final int CUIT = 1;
	final int CUIT2 = 2;
    final int RAZON_SOCIAL = 3;
    final int RAZON_SOCIAL2 = 4;
    final int DIRECCION = 5;
    final int CONTACTO = 6;
    final int COMERCIAL = 7;
    final int TELEFONO = 8;
    final int EMAIL = 9;
    final int GRUPO_PROVEEDOR = 10;
    final int CONDICION_PAGO = 11;
    final int ACTIVO = 12;
    final int OID_PROVEEDOR = 13;

    ProveedorMaterialsControl pers = (ProveedorMaterialsControl) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update " + pers.getOwner() + "liefer"+ pers.getDbLink() + " set "+
    		  "LF_KDNNR=?"+ 
    		  ",LF_FKEY=?"+ 
              ",LF_NAME=?"+ 
              ",LF_NAMEID=?"+
              ",LF_ADRESSE=?"+ 
              ",LF_SACHB=?"+ 
              ",LF_VERT=?"+ 
              ",LF_TEL=?"+ 
              ",LF_TELEX=?"+ 
              ",SUG_NR=?"+ 
              ",LF_ZBED=?"+ 
              ",AKTIV=?"+ 
                 " where " +
                 " LF_ID=? ");
    
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROVEEDOR,pers.getOID());
    qUpdate.setString(CUIT,pers.getCuit());
    qUpdate.setString(CUIT2,pers.getCuit2());
    qUpdate.setString(RAZON_SOCIAL,pers.getRazonsocial());
    qUpdate.setString(RAZON_SOCIAL2,pers.getRazonSocial2());
    qUpdate.setString(DIRECCION,pers.getDireccion());
    qUpdate.setString(CONTACTO,pers.getContacto());
    qUpdate.setString(COMERCIAL,pers.getComercail());
    qUpdate.setString(TELEFONO,pers.getTelefono());
    qUpdate.setString(EMAIL,pers.getEmail());
    qUpdate.setInt(GRUPO_PROVEEDOR,pers.getGrupoproveedor().intValue());
    qUpdate.setString(CONDICION_PAGO,pers.getCondicionpago());
    qUpdate.setString(ACTIVO,pers.getActivo());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PROVEEDOR_UTE = 1;
		ProveedorMaterialsControl pers = (ProveedorMaterialsControl) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update VWProveedoresUte " + " set activo=0 " + " where " + " oid_proveedor_ute=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PROVEEDOR_UTE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PROVEEDOR_UTE = 1;
		ProveedorMaterialsControl pers = (ProveedorMaterialsControl) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update VWProveedoresUte " + " set activo=1 " + " where " + " oid_proveedor_ute=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PROVEEDOR_UTE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
			case IDBObjetoPersistente.SELECT_BY_OID: {
				ps = this.selectByOID(aCondiciones);
				break;
			}
			case IDBObjetoPersistente.SELECT_BY_CODIGO: {
				ps = this.selectByCodigo(aCondiciones);
				break;
			}
			case IDBObjetoPersistente.SELECT_ALL_HELP: {
				ps = this.selectAllHelp(aCondiciones);
				break;
			}
			case SELECT_BY_CUIT_UTE: {
				ps = this.selectByCuitUte(aCondiciones);
				break;
			}
			case SELECT_BY_CUIT_BINBAIRES: {
				ps = this.selectByCuitBinbaires(aCondiciones);
				break;
			}
			case SELECT_BY_CUIT_ALAVERA: {
				ps = this.selectByCuitAlavera(aCondiciones);
				break;
			}
			case SELECT_BY_CUIT_MAGIC: {
				ps = this.selectByCuitMagic(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_UTE: {
				ps = this.selectByRazonSocialUte(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_BINBAIRES: {
				ps = this.selectByRazonSocialBinbaires(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_ALAVERA: {
				ps = this.selectByRazonSocialAlavera(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_MAGIC: {
				ps = this.selectByRazonSocialMagic(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_UTE_NO_CUIT: {
				ps = this.selectByRazonSocialNoCuitUte(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_BINBAIRES_NO_CUIT: {
				ps = this.selectByRazonSocialNoCuitBinbaires(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_ALAVERA_NO_CUIT: {
				ps = this.selectByRazonSocialNoCuitAlavera(aCondiciones);
				break;
			}
			case SELECT_BY_RAZON_SOCIAL_MAGIC_NO_CUIT: {
				ps = this.selectByRazonSocialNoCuitMagic(aCondiciones);
				break;
			}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PROVEEDOR_UTE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  v_liefer@utetrain ");
		textSQL.append(" WHERE id = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PROVEEDOR_UTE, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VWProveedoresUte ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_proveedor_ute oid, codigo,  descripcion ,activo ");
		textSQL.append(" from VWProveedoresUte");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCuitUte(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_UTE", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_UTE_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String cuit = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE TRIM(cuit) in ('" + cuit + "') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
//		querySelect.setString(1, cuit);
		return querySelect;
	}
	
	private PreparedStatement selectByCuitBinbaires(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_BINBAIRES", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_BINBAIRES_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String cuit = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE TRIM(cuit) in ('" + cuit + "') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
//		querySelect.setString(1, cuit);
		return querySelect;
	}
	
	private PreparedStatement selectByCuitAlavera(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_ALAVERA", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_ALAVERA_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String cuit = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE TRIM(cuit) in ('" + cuit + "') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
//		querySelect.setString(1, cuit);
		return querySelect;
	}
	
	private PreparedStatement selectByCuitMagic(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_MAGIC", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_MAGIC_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String cuit = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE TRIM(cuit) in ('" + cuit + "') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
//		querySelect.setString(1, cuit);
		return querySelect;
	}
	
	private PreparedStatement selectByRazonSocialUte(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_UTE", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_UTE_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String razonSocial = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, "%"+razonSocial+"%");
		return querySelect;
	}
	
	private PreparedStatement selectByRazonSocialBinbaires(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_BINBAIRES", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_BINBAIRES_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String razonSocial = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, "%"+razonSocial+"%");
		return querySelect;
	}
	
	private PreparedStatement selectByRazonSocialAlavera(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_ALAVERA", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_ALAVERA_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String razonSocial = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, "%"+razonSocial+"%");
		return querySelect;
	}
	
	private PreparedStatement selectByRazonSocialMagic(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_MAGIC", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_MAGIC_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String razonSocial = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, "%"+razonSocial+"%");
		return querySelect;
	}

	private PreparedStatement selectByRazonSocialNoCuitUte(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_UTE", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_UTE_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) AND TRIM(cuit) != TRIM(?)");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Hashtable<String, String> param = (Hashtable) aCondiciones;
		querySelect.setString(1, "%" + param.get("RAZON_SOCIAL") + "%");
		querySelect.setString(2, param.get("CUIT"));
		return querySelect;
	}

	private PreparedStatement selectByRazonSocialNoCuitBinbaires(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_BINBAIRES", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_BINBAIRES_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) AND TRIM(cuit) != TRIM(?)");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Hashtable<String, String> param = (Hashtable) aCondiciones;
		querySelect.setString(1, "%" + param.get("RAZON_SOCIAL") + "%");
		querySelect.setString(2, param.get("CUIT"));
		return querySelect;
	}

	private PreparedStatement selectByRazonSocialNoCuitAlavera(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_ALAVERA", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_ALAVERA_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) AND TRIM(cuit) != TRIM(?)");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Hashtable<String, String> param = (Hashtable) aCondiciones;
		querySelect.setString(1, "%" + param.get("RAZON_SOCIAL") + "%");
		querySelect.setString(2, param.get("CUIT"));
		return querySelect;
	}

	private PreparedStatement selectByRazonSocialNoCuitMagic(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_MAGIC", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_MAGIC_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  " + esquema + "v_liefer" + dbLlink);
		textSQL.append(" WHERE UPPER(razon_social) like UPPER(?) AND TRIM(cuit) != TRIM(?)");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Hashtable<String, String> param = (Hashtable) aCondiciones;
		querySelect.setString(1, "%" + param.get("RAZON_SOCIAL") + "%");
		querySelect.setString(2, param.get("CUIT"));
		return querySelect;
	}

	public static List getByCuitUte(String cuit, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_CUIT_UTE, 
				cuit, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByCuitBinbaires(String cuit, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_CUIT_BINBAIRES, 
				cuit, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByCuitAlavera(String cuit, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_CUIT_ALAVERA, 
				cuit, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByCuitMagic(String cuit, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_CUIT_MAGIC, 
				cuit, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialUte(String razonSocial, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_UTE, 
				razonSocial, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialBinbaires(String razonSocial, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_BINBAIRES, 
				razonSocial, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialAlavera(String razonSocial, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_ALAVERA, 
				razonSocial, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialMagic(String razonSocial, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_MAGIC, 
				razonSocial, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialNoCuitUte(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		Hashtable<String, String> param = new Hashtable();
		param.put("RAZON_SOCIAL", razonSocial);
		param.put("CUIT", cuit);
		
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_UTE_NO_CUIT, 
				param, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialNoCuitBinbaires(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		Hashtable<String, String> param = new Hashtable();
		param.put("RAZON_SOCIAL", razonSocial);
		param.put("CUIT", cuit);
		
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_BINBAIRES_NO_CUIT, 
				param, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialNoCuitAlavera(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		Hashtable<String, String> param = new Hashtable();
		param.put("RAZON_SOCIAL", razonSocial);
		param.put("CUIT", cuit);
		
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_ALAVERA_NO_CUIT, 
				param, 
				new ListObserver(), 
				aSesion);
	}
	
	public static List getByRazonSocialNoCuitMagic(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		Hashtable<String, String> param = new Hashtable();
		param.put("RAZON_SOCIAL", razonSocial);
		param.put("CUIT", cuit);
		
		return (List) ObjetoLogico.getObjects(ProveedorMaterialsControl.NICKNAME, 
				DBProveedorMaterialControl.SELECT_BY_RAZON_SOCIAL_MAGIC_NO_CUIT, 
				param, 
				new ListObserver(), 
				aSesion);
	}
}
