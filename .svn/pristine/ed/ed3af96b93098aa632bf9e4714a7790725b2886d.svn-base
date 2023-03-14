package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.bm.DetConsPlanDesa;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBDetConsPlanDesa extends DBObjetoPersistente {

	public static final String OID_CRONOGRAMA = "oid_cronograma";
	public static final String DESC_CRONOGRAMA = "desc_cronograma";
	public static final String OID_ACCION = "oid_accion";
	public static final String DESC_ACCION = "desc_accion";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String LEGAJO = "legajo";
	public static final String APELLIDO = "apellido";
	public static final String NOMBRE = "nombre";
	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String OID_VAL_CLASIF_SEC = "oid_val_clasif_sec";
	public static final String OID_VAL_CLASIF_PUE = "oid_val_clasif_pue";
	public static final String FEC_INGRESO = "fec_ingreso";
	public static final String FEC_RECATEG = "fec_recateg";
	public static final String ORDEN = "orden";
	public static final String OID_GRADO_LEGAJO = "oid_grado_leg";
	public static final String OID_EST_DESA = "oid_est_desa";
	public static final String OID_CATEG_POSIBLE = "oid_categ_posible";
	public static final String FEC_ANT_RECO = "fec_ant_reco";
	public static final String CANT_MIN_JUEGOS_A = "cant_min_juegos_a";
	public static final String CANT_ANIOS_HC = "cant_anios_hc";
	public static final String CANT_MESES_HC = "cant_meses_hc";
	public static final String ULT_MESES_EVAL_POT = "ult_meses_eval_pot";
	public static final String EVAL_PEND_SIN_EVAL = "eval_pend_sin_eval";
	public static final String EVAL_PEND_SIN_JUE = "eval_pend_sin_jue";
	public static final String EVAL_PEND_SIN_IRL = "eval_pend_sin_irl";
	public static final String ULT_MESES_IRL = "ult_meses_irl";
	public static final String DESA_SI_IRL_NEG = "desa_si_irl_neg";
	public static final String EVAL_PEND_SIN_POT = "eval_pend_sin_pot";

	public static final int SELECT_BY_CRONO_MES_ACCIONES = 100;

	public DBDetConsPlanDesa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
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
		case SELECT_BY_CRONO_MES_ACCIONES: {
			ps = this.selectByCronoMesAcciones(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		return null;

	}

	private PreparedStatement selectByCronoMesAcciones(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CronogramaDesa cronograma = (CronogramaDesa) condiciones.get(CronogramaDesa.NICKNAME);
		String mes = (String) condiciones.get("MES");

		StringBuffer inAcciones = new StringBuffer("-1");
		List listaAcciones = (List) condiciones.get("LISTA_ACCIONES");
		Iterator iterAcciones = listaAcciones.iterator();
		while (iterAcciones.hasNext()) {
			AccCronoDesa accCronoDesa = (AccCronoDesa) iterAcciones.next();
			inAcciones.append("," + accCronoDesa.getOIDInteger());
		}

		textSQL.append(" SELECT ");
		textSQL.append("   c.oid_crono_desa oid_cronograma, ");
		textSQL.append("   c.descripcion desc_cronograma, ");
		textSQL.append("   a.oid_accion_cro oid_accion, ");
		textSQL.append("   b.accion desc_accion, ");
		textSQL.append("   e.oid_legajo oid_legajo, ");
		textSQL.append("   e.nro_legajo legajo, ");
		textSQL.append("   e.apellido, ");
		textSQL.append("   e.nombre, ");
		textSQL.append("   a.oid_val_clasif_emp, ");
		textSQL.append("   a.oid_val_clasif_sec, ");
		textSQL.append("   a.oid_val_clasif_pue, ");
		textSQL.append("   a.orden, ");
		textSQL.append("   e.fec_ingreso , e.fec_ant_reco, e.oid_grado_leg , e.oid_est_desa , a.oid_categ_posible , a.cant_min_juegos_a, ");
		textSQL.append("   a.cant_anios_hc,");
		textSQL.append("   a.cant_meses_hc, a.ULT_MESES_EVAL_POT , a.EVAL_PEND_SIN_EVAL, a.EVAL_PEND_SIN_JUE , a.EVAL_PEND_SIN_IRL , a.ULT_MESES_IRL , 0 desa_si_irl_neg , a.eval_pend_sin_pot ");
		textSQL.append(" FROM  ");
		textSQL.append("    rhJerarquiaDesa a , ");
		textSQL.append("    rhaccionescro b ,  ");
		textSQL.append("    rhCronoDesa c , ");
		textSQL.append("    rhmesesaevaldes d, ");
		textSQL.append("    suLegajo e ");
		textSQL.append(" where  ");
		textSQL.append("   a.oid_accion_cro = b.oid_accion_cro and  ");
		textSQL.append("   b.oid_cronograma = c.oid_crono_desa and ");
		textSQL.append("   c.oid_crono_desa = ? and ");
		textSQL.append("   b.oid_accion_cro in (" + inAcciones.toString() + ") and ");
		textSQL.append("   d.oid_accion_cro = b.oid_accion_cro and ");
		textSQL.append("   d.mes = ? and d.activo = 1 and ");
		textSQL.append("   a.activo = 1 and b.activo = 1 and ");
		textSQL.append("   e." + clasifEmpresa.getCampoFisico() + " = a.oid_val_clasif_emp and ");
		textSQL.append("   e." + clasifSector.getCampoFisico() + " = a.oid_val_clasif_sec and ");
		textSQL.append("   e." + clasifPuesto.getCampoFisico() + "= a.oid_val_clasif_pue and ");
		textSQL.append("   e." + clasifEstado.getCampoFisico() + " in (select oid_val_clasif_est from rhEstAccCro where oid_accion_cro=b.oid_accion_cro)");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, cronograma.getOID());
		querySelect.setString(2, mes);

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		return null;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		return null;
	}

	public static List getListaDetConsPlanDesa(CronogramaDesa cronograma, String mes, List acciones, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CronogramaDesa.NICKNAME, cronograma);
		condiciones.put("MES", mes);
		condiciones.put("LISTA_ACCIONES", acciones);

		return (List) ObjetoLogico.getObjects(DetConsPlanDesa.NICKNAME, DBDetConsPlanDesa.SELECT_BY_CRONO_MES_ACCIONES, condiciones, new ListObserver(), aSesion);
	}

}
