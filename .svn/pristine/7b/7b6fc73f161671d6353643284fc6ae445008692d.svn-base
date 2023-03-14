package com.srn.erp.payroll.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.payroll.bm.PayConsultaAusentismo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class DBPayConsultaAusentismo extends DBObjetoPersistente {

	public static final String LEGAJO = "legajo";
	public static final String NOMBRE = "nombre";
	public static final String SECTOR = "sector";
	public static final String PUESTO = "puesto";
	public static final String FECHA_INI_LIC = "fec_ini_lic";
	public static final String FECHA_AUSENSIA = "fec_ausensia";
	public static final String TAUSENCIA = "tausencia";
	public static final String OBSERVACION = "observacion";
	public static final String TRAMO = "tramo";

	private static final int SELECT_BY_FILTROS = 100;

	public DBPayConsultaAusentismo() {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
			case DBPayConsultaAusentismo.SELECT_BY_FILTROS: {
				ps = this.selectByFiltros(aCondiciones);
				break;
			}
		}
		return ps;
	}

	@SuppressWarnings("unchecked")
	private PreparedStatement selectByFiltros(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("USU_PAYROLL_PROD", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DATABASE_LINK_PAYROLL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		Hashtable<String, Object> hashTable = (Hashtable<String, Object>) aCondiciones;
		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT distinct b.nmolegajo legajo, e.nombre nombre, g.descrip sector, h.descrip puesto, ");
		textSQL.append(" b.nmofecha fec_ini_lic, b.nmofecha fec_ausensia, d.DESCRIP tausencia, a.novobs observacion, f.etrtramo tramo ");
		textSQL.append(" FROM " + esquema + "tbcasnov" + dbLlink + " a, " + esquema + "tbcasnmo" + dbLlink + " b,  " + esquema + "tbcastnn" + dbLlink + " c, ");
		textSQL.append(" " + esquema + "rtablas" + dbLlink + " d,  " + esquema + "remples" + dbLlink + " e, " + esquema + "tbcasetr" + dbLlink + " f, ");
		textSQL.append("  (select * from " + esquema + "rtablas" + dbLlink + " where cotab = 1) g, ");
		textSQL.append("  (select * from " + esquema + "rtablas" + dbLlink + " where cotab = 3) h ");
		textSQL.append(" WHERE a.novcodigo = b.nmonovedad and ");
		textSQL.append(" a.novtipo = c.tnncodigo and ");
		textSQL.append(" c.tnn_cotab = d.cotab and ");
		textSQL.append(" a.novmotivo = d.codigo and ");
		textSQL.append(" e.codigo = b.nmolegajo and ");
		textSQL.append(" f.etrlegajo = b.nmolegajo and ");
		textSQL.append(" g.codigo = e.cencos and ");
		textSQL.append(" h.codigo = e.cargo and ");
		textSQL.append(" d.codigo <> 0 and");

		crearFiltros(textSQL, hashTable);
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(((java.util.Date) hashTable.get("fec_desde")).getTime()));
		querySelect.setDate(2, new java.sql.Date(((java.util.Date) hashTable.get("fec_hasta")).getTime()));
		querySelect.setDate(3, new java.sql.Date(((java.util.Date) hashTable.get("fec_desde")).getTime()));
		querySelect.setDate(4, new java.sql.Date(((java.util.Date) hashTable.get("fec_hasta")).getTime()));
		return querySelect;
	}

	@SuppressWarnings("unchecked")
	private void crearFiltros(StringBuffer textSQL, Hashtable<String, Object> hashTable) throws BaseException {
		Boolean noHayTurnos = false;

		if ((hashTable.containsKey("fec_desde")) && (hashTable.containsKey("fec_hasta"))) {
			textSQL.append(" b.nmofecha BETWEEN ? AND ? AND");
		}

		if (hashTable.containsKey("empresa")) {
			textSQL.append(" e.empresa LIKE '" + hashTable.get("empresa") + "' AND ");
		}

		if (hashTable.containsKey("sectores")) {
			List<Integer> sectores = (List<Integer>) hashTable.get("sectores");
			if (!sectores.isEmpty()) {
				String filtroSectores = " e.cencos IN ( ";
				Boolean fisrt = true;
				for (Integer integer : sectores) {
					if (fisrt) {
						filtroSectores = filtroSectores + integer;
						fisrt = false;
					} else {
						filtroSectores = filtroSectores + ", " + integer;
					}
				}
				textSQL.append(filtroSectores + ") AND");
			}
		}

		if (hashTable.containsKey("ausenciasCodigos") && hashTable.containsKey("ausenciasCotabs")) {
			List<Integer> ausenciasCodigos = (List<Integer>) hashTable.get("ausenciasCodigos");
			List<Integer> ausenciasCotabs = (List<Integer>) hashTable.get("ausenciasCotabs");
			if (!ausenciasCodigos.isEmpty() && !ausenciasCotabs.isEmpty()) {
				Boolean firstCodigo = true;
				String filtroCodigo = " d.codigo IN ( ";
				for (Integer codigo : ausenciasCodigos) {
					if (firstCodigo) {
						filtroCodigo = filtroCodigo + codigo;
						firstCodigo = false;
					} else {
						filtroCodigo = filtroCodigo + ", " + codigo;
					}
				}
				textSQL.append(filtroCodigo + ") AND");

				Boolean firstCotab = true;
				String filtroCotab = " d.cotab IN ( ";
				for (Integer cotab : ausenciasCotabs) {
					if (firstCotab) {
						filtroCotab = filtroCotab + cotab;
						firstCotab = false;
					} else {
						filtroCotab = filtroCotab + ", " + cotab;
					}
				}
				textSQL.append(filtroCotab + ") AND");
			}
		}
		if (hashTable.containsKey("turnos")) {
			List<GrupoRRHHDetalle> turnos = (List<GrupoRRHHDetalle>) hashTable.get("turnos");
			if (!turnos.isEmpty()) {
				Boolean firstTurno = true;
				String filtroTurnos = " f.etrtramo IN ( ";
				for (GrupoRRHHDetalle grupoRRHHDetalle : turnos) {
					if (firstTurno) {
						filtroTurnos = filtroTurnos + "'" + grupoRRHHDetalle.getCod_ext_1() + "'";
						firstTurno = false;
					} else {
						filtroTurnos = filtroTurnos + ", " + "'" + grupoRRHHDetalle.getCod_ext_1() + "'";
					}
				}
				textSQL.append(filtroTurnos + ") AND");
				
				
			}
		}
		
		if ((hashTable.containsKey("fec_desde")) && (hashTable.containsKey("fec_hasta"))) {
			textSQL.append(" f.etrfecha BETWEEN ? AND ? AND");
		}

		textSQL.append(" 1 = 1 ");
		textSQL.append(" ORDER BY b.nmolegajo");

	}

	@Override
	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub
	}

	public static List<PayConsultaAusentismo> findByFiltros(Hashtable<String, Object> hashTable, ISesion aSesion) throws BaseException {
		return (List<PayConsultaAusentismo>) ObjetoLogico.getObjects(PayConsultaAusentismo.NICKNAME, DBPayConsultaAusentismo.SELECT_BY_FILTROS, hashTable, new ListObserver(), aSesion);
	}

}