package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLPDetalleDto;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDtoCant;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAcuerdoLPDetalleDtoCant extends DBObjetoPersistente {

	public static final String OID_DTO_CANT = "oid_dto_cant";

	public static final String OID_ACU_LP_DET_DTO = "oid_acu_lp_det_dto";

	public static final String CANT_DESDE = "cant_desde";

	public static final String CANT_HASTA = "cant_hasta";

	public static final String DTO_1 = "dto_1";

	public static final String DTO_2 = "dto_2";

	public static final String DTO_3 = "dto_3";

	public static final String DTO_4 = "dto_4";

	public static final String DTO_5 = "dto_5";

	public static final String EN_CASCADA = "en_cascada";

	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ACU_LP_DET_DTO = 100;

	public DBAcuerdoLPDetalleDtoCant() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_DTO_CANT = 1;
		final int OID_ACU_LP_DET_DTO = 2;
		final int CANT_DESDE = 3;
		final int CANT_HASTA = 4;
		final int DTO_1 = 5;
		final int DTO_2 = 6;
		final int DTO_3 = 7;
		final int DTO_4 = 8;
		final int DTO_5 = 9;
		final int EN_CASCADA = 10;
		final int ACTIVO = 11;

		AcuerdoLPDetalleDtoCant pers = (AcuerdoLPDetalleDtoCant) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAcuLPDtoCant " + " ( "
				+ "OID_DTO_CANT," + "OID_ACU_LP_DET_DTO," + "CANT_DESDE,"
				+ "CANT_HASTA," + "DTO_1," + "DTO_2," + "DTO_3," + "DTO_4,"
				+ "DTO_5," + "EN_CASCADA," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DTO_CANT, pers.getOID());
		qInsert.setInt(OID_ACU_LP_DET_DTO, pers.getAcu_lp_det_dto().getOID());
		qInsert.setDouble(CANT_DESDE, pers.getCant_desde().doubleValue());
		qInsert.setDouble(CANT_HASTA, pers.getCant_hasta().doubleValue());
		qInsert.setDouble(DTO_1, pers.getDto_1().doubleValue());
		qInsert.setDouble(DTO_2, pers.getDto_2().doubleValue());
		qInsert.setDouble(DTO_3, pers.getDto_3().doubleValue());
		qInsert.setDouble(DTO_4, pers.getDto_4().doubleValue());
		qInsert.setDouble(DTO_5, pers.getDto_5().doubleValue());
		qInsert.setBoolean(EN_CASCADA, pers.isEn_cascada().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ACU_LP_DET_DTO = 1;
		final int CANT_DESDE = 2;
		final int CANT_HASTA = 3;
		final int DTO_1 = 4;
		final int DTO_2 = 5;
		final int DTO_3 = 6;
		final int DTO_4 = 7;
		final int DTO_5 = 8;
		final int EN_CASCADA = 9;
		final int ACTIVO = 10;
		final int OID_DTO_CANT = 11;

		AcuerdoLPDetalleDtoCant pers = (AcuerdoLPDetalleDtoCant) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAcuLPDtoCant set " + "oid_acu_lp_det_dto=?"
				+ ",cant_desde=?" + ",cant_hasta=?" + ",dto_1=?" + ",dto_2=?"
				+ ",dto_3=?" + ",dto_4=?" + ",dto_5=?" + ",en_cascada=?"
				+ ",activo=?" + " where " + " oid_dto_cant=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DTO_CANT, pers.getOID());
		qUpdate.setInt(OID_ACU_LP_DET_DTO, pers.getAcu_lp_det_dto().getOID());
		qUpdate.setDouble(CANT_DESDE, pers.getCant_desde().doubleValue());
		qUpdate.setDouble(CANT_HASTA, pers.getCant_hasta().doubleValue());
		qUpdate.setDouble(DTO_1, pers.getDto_1().doubleValue());
		qUpdate.setDouble(DTO_2, pers.getDto_2().doubleValue());
		qUpdate.setDouble(DTO_3, pers.getDto_3().doubleValue());
		qUpdate.setDouble(DTO_4, pers.getDto_4().doubleValue());
		qUpdate.setDouble(DTO_5, pers.getDto_5().doubleValue());
		qUpdate.setBoolean(EN_CASCADA, pers.isEn_cascada().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DTO_CANT = 1;
		AcuerdoLPDetalleDtoCant pers = (AcuerdoLPDetalleDtoCant) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpAcuLPDtoCant " + " where "
				+ " oid_dto_cant=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DTO_CANT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DTO_CANT = 1;
		AcuerdoLPDetalleDtoCant pers = (AcuerdoLPDetalleDtoCant) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAcuLPDtoCant " + " set activo=1 "
				+ " where " + " oid_dto_cant=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DTO_CANT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
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
		case SELECT_BY_ACU_LP_DET_DTO: {
			ps = this.selectByAcuLPDetDto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_DTO_CANT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuLPDtoCant ");
		textSQL.append(" WHERE oid_dto_cant = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DTO_CANT, oid);
		return querySelect;
	}

	private PreparedStatement selectByAcuLPDetDto(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuLPDtoCant ");
		textSQL.append(" WHERE  oid_acu_lp_det_dto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		AcuerdoLPDetalleDto acuLPDetDto = (AcuerdoLPDetalleDto) aCondiciones;
		querySelect.setInt(1, acuLPDetDto.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuLPDtoCant ");
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
				.append("SELECT oid_dto_cant oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAcuLPDtoCant");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAcuerdosLPDetallesDtoCant(
			AcuerdoLPDetalleDto acuerdoLPDetDto, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(AcuerdoLPDetalleDtoCant.NICKNAME,
				DBAcuerdoLPDetalleDtoCant.SELECT_BY_ACU_LP_DET_DTO,
				acuerdoLPDetDto, new ListObserver(), aSesion);
	}

}
