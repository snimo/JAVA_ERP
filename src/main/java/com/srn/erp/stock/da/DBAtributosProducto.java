package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.stock.bm.AtributosProducto;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAtributosProducto extends DBObjetoPersistente {

	public static final String	OID_PRODUCTO_ATRI		= "oid_producto_atri";

	public static final String	OID_PRODUCTO				= "oid_producto";

	public static final int			SELECT_BY_PRODUCTO	= 100;

	public DBAtributosProducto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRODUCTO_ATRI = 1;
		final int OID_PRODUCTO = 2;

		AtributosProducto pers = (AtributosProducto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		StringBuffer paramsAtri = new StringBuffer();
		sqlInsert.append(" insert into stProductoAtri ( OID_PRODUCTO_ATRI, OID_PRODUCTO");

		// Agregar atributos
		Iterator iterAtributos = pers.getProducto().getAtributos().iterator();
		while (iterAtributos.hasNext()) {
			Atributo atributo = (Atributo) iterAtributos.next();
			sqlInsert.append(" ," + atributo.getCampoFisico());
			paramsAtri.append(",?");
		}

		// Agregar Grupos de Atributos Variables
		Iterator iterGruposAtriVar = pers.getProducto().getGruposAtributosVariables().iterator();
		while (iterGruposAtriVar.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGruposAtriVar.next();
			sqlInsert.append(" ," + grupoAtriEntVar.getCampoFisico());
			paramsAtri.append(",?");
		}

		sqlInsert.append(" ) values (?,?" + paramsAtri.toString() + ")");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PRODUCTO_ATRI, pers.getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());

		// Realizar un set de los atributos
		int nroParamAtri = 3;
		Iterator iterAtri = pers.getProducto().getAtributos().iterator();
		while (iterAtri.hasNext()) {
			Atributo atributo = (Atributo) iterAtri.next();
			Object valorAtri = pers.getValor(atributo);

			// Si es un Atributo Compo
			if (atributo.isValorCompo()) {
				if ((valorAtri != null) && (((IObjetoLogico) valorAtri).getOIDInteger()!=null))
					qInsert.setInt(nroParamAtri, ((IObjetoLogico) valorAtri).getOIDInteger().intValue());
				else
					qInsert.setNull(nroParamAtri, java.sql.Types.INTEGER);
			}

			// Si es un atributo String
			if (atributo.isString()) {
				if (valorAtri != null)
					qInsert.setString(nroParamAtri, ((String) valorAtri));
				else
					qInsert.setNull(nroParamAtri, java.sql.Types.VARCHAR);
			}

			// Si es un atributo Entero
			if (atributo.isEntero()) {
				if (valorAtri != null)
					qInsert.setInt(nroParamAtri, ((Integer) valorAtri).intValue());
				else
					qInsert.setNull(nroParamAtri, java.sql.Types.INTEGER);
			}

			// Si es un atributo Decimal
			if (atributo.isDecimal()) {
				if (valorAtri != null)
					qInsert.setDouble(nroParamAtri, ((Double) valorAtri).doubleValue());
				else
					qInsert.setNull(nroParamAtri, java.sql.Types.DOUBLE);
			}

			// Si es un atributo Fecha
			if (atributo.isFecha()) {
				if (valorAtri != null)
					qInsert.setDate(nroParamAtri, new java.sql.Date(((Date) valorAtri).getTime()));
				else
					qInsert.setNull(nroParamAtri, java.sql.Types.DATE);
			}

			++nroParamAtri;
		}

		// Agregar Grupos de Atributos Variables
		Iterator iterGruposAtriVarVal = pers.getProducto().getGruposAtributosVariables().iterator();
		while (iterGruposAtriVarVal.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGruposAtriVarVal.next();
			GrupoDeAtributos grupoDeAtri = pers.getGrupoDeAtributos(grupoAtriEntVar);

			if (grupoDeAtri != null)
				qInsert.setInt(nroParamAtri, grupoDeAtri.getOID());
			else
				qInsert.setNull(nroParamAtri, java.sql.Types.INTEGER);
			++nroParamAtri;
		}

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;

		AtributosProducto pers = (AtributosProducto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update stProductoAtri set oid_producto=? ");

		// Agregar el Resto de los Atributos para Update
		Iterator iterAtributos = pers.getProducto().getAtributos().iterator();
		while (iterAtributos.hasNext()) {
			Atributo atributo = (Atributo) iterAtributos.next();
			sqlUpdate.append(" , " + atributo.getCampoFisico() + "=? ");
		}

		// Agregar Grupos de Atributos Variables
		Iterator iterGruposAtriVar = pers.getProducto().getGruposAtributosVariables().iterator();
		while (iterGruposAtriVar.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGruposAtriVar.next();
			sqlUpdate.append(" , " + grupoAtriEntVar.getCampoFisico() + "=? ");
		}

		sqlUpdate.append(" where ");
		sqlUpdate.append(" oid_producto_atri= " + pers.getOIDInteger().toString());

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());

		// Realizar el set de los atributos correspondientes
		int nroParamAtri = 2;

		// pers.getValoresAtributos();

		Iterator iterAtri = pers.getProducto().getAtributos().iterator();
		while (iterAtri.hasNext()) {
			Atributo atributo = (Atributo) iterAtri.next();
			Object valorAtri = pers.getValor(atributo);

			// Si es un Atributo Compo
			if (atributo.isValorCompo()) {
				if ((valorAtri != null) && (((IObjetoLogico) valorAtri).getOIDInteger()!=null))
					qUpdate.setInt(nroParamAtri, ((IObjetoLogico) valorAtri).getOIDInteger().intValue());
				else
					qUpdate.setNull(nroParamAtri, java.sql.Types.INTEGER);
			}

			// Si es un atributo String
			if (atributo.isString()) {
				if (valorAtri != null)
					qUpdate.setString(nroParamAtri, ((String) valorAtri));
				else
					qUpdate.setNull(nroParamAtri, java.sql.Types.VARCHAR);
			}

			// Si es un atributo Entero
			if (atributo.isEntero()) {
				if (valorAtri != null)
					qUpdate.setInt(nroParamAtri, ((Integer) valorAtri).intValue());
				else
					qUpdate.setNull(nroParamAtri, java.sql.Types.INTEGER);
			}

			// Si es un atributo Decimal
			if (atributo.isDecimal()) {
				if (valorAtri != null)
					qUpdate.setDouble(nroParamAtri, ((Double) valorAtri).doubleValue());
				else
					qUpdate.setNull(nroParamAtri, java.sql.Types.DOUBLE);
			}

			// Si es un atributo Fecha
			if (atributo.isFecha()) {
				if (valorAtri != null)
					qUpdate.setDate(nroParamAtri, new java.sql.Date(((Date) valorAtri).getTime()));
				else
					qUpdate.setNull(nroParamAtri, java.sql.Types.DATE);
			}

			++nroParamAtri;
		}

		// Agregar Grupos de Atributos Variables
		Iterator iterGruposAtriVarVal = pers.getProducto().getGruposAtributosVariables().iterator();
		while (iterGruposAtriVarVal.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGruposAtriVarVal.next();
			GrupoDeAtributos grupoDeAtri = pers.getGrupoDeAtributos(grupoAtriEntVar);
			if (grupoDeAtri != null)
				qUpdate.setInt(nroParamAtri, grupoDeAtri.getOID());
			else
				qUpdate.setNull(nroParamAtri, java.sql.Types.INTEGER);
			++nroParamAtri;
		}

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PRODUCTO_ATRI = 1;
		AtributosProducto pers = (AtributosProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stProductoAtri " + " set activo=0 " + " where " + " oid_producto_atri=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRODUCTO_ATRI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PRODUCTO_ATRI = 1;
		AtributosProducto pers = (AtributosProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stProductoAtri " + " set activo=1 " + " where " + " oid_producto_atri=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRODUCTO_ATRI, pers.getOID());
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
		case SELECT_BY_PRODUCTO: {
			ps = this.selectByProducto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PRODUCTO_ATRI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProductoAtri ");
		textSQL.append(" WHERE oid_producto_atri = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PRODUCTO_ATRI, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProductoAtri ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_producto_atri oid, codigo,  descripcion ,activo ");
		textSQL.append(" from stProductoAtri");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByProducto(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProductoAtri ");
		textSQL.append(" WHERE oid_producto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Producto producto = (Producto) aCondiciones;
		querySelect.setInt(1, producto.getOID());
		return querySelect;
	}

	public static AtributosProducto getAtributosProducto(Producto producto, ISesion aSesion) throws BaseException {
		return (AtributosProducto) ObjetoLogico.getObjects(AtributosProducto.NICKNAME,
				DBAtributosProducto.SELECT_BY_PRODUCTO, producto, new ObjetoObservado(), aSesion);
	}

}
