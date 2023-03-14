package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.bm.ValorOrigenSubBien;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValorOrigenSubBien extends DBObjetoPersistente {

	public static final String OID_BIEN_ALTA = "oid_bien_alta";

	public static final String OID_SIST_VAL = "oid_sist_val";

	public static final String VALOR_ORIGEN = "valor_origen";

	public static final int SELECT_BY_SUBBIEN_SISTEMAVALUACION = 100;

	public DBValorOrigenSubBien() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case SELECT_BY_SUBBIEN_SISTEMAVALUACION: {
			ps = this.selectBySubBienSistemaValuacion(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectBySubBienSistemaValuacion(
			Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		SubBien subBien = (SubBien) condiciones.get(SubBien.NICKNAME);
		SistemaValuacion sistemaValuacion = (SistemaValuacion) condiciones
				.get(SistemaValuacion.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val, ");
		textSQL.append("   sum(b.importe) valor_origen ");
		textSQL.append(" from ");
		textSQL.append("   buComproCab a, ");
		textSQL.append("   buComproDet b, ");
		textSQL.append("   geComproCab c  ");
		textSQL.append(" where ");
		textSQL.append("   a.oid_cco_bu = b.oid_cco_bu and ");
		textSQL.append("   a.oid_cco_bu = c.oid_cco and ");
		textSQL.append("   c.activo = 1 and ");
		textSQL.append("   a.oid_bien_alta = ? and ");
		textSQL.append("   a.oid_sist_val = ? and ");
		textSQL.append("   tipo_mov = 'VO' ");
		textSQL.append("   group by ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, subBien.getOID());
		querySelect.setInt(2, sistemaValuacion.getOID());
		return querySelect;

	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_BIEN_ALTA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  aaaaaa ");
		textSQL.append(" WHERE oid_bien_alta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_BIEN_ALTA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  aaaaaa ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_bien_alta oid, codigo,  descripcion ,activo ");
		textSQL.append(" from aaaaaa");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static ValorOrigenSubBien getValorOrigenSubBien(SubBien subBien,
			SistemaValuacion sistemaValuacion,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(SubBien.NICKNAME,subBien);
		condiciones.put(SistemaValuacion.NICKNAME,sistemaValuacion);
		return (ValorOrigenSubBien) ObjetoLogico.getObjects(ValorOrigenSubBien.NICKNAME,
				DBValorOrigenSubBien.SELECT_BY_SUBBIEN_SISTEMAVALUACION, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
