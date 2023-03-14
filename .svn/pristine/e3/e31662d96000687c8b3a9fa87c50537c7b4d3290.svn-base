package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;
import com.srn.erp.rrhh.bm.ServicioMedicoRRHH;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBServicioMedicoRRHH extends DBObjetoPersistente {

	public static final String OID_SERV_MEDICO = "oid_serv_medico";
	public static final String TIPO_SERV_MED = "tipo_serv_med";
	public static final String NRO_NOV_SIST_EXT = "nro_nov_sist_ext";
	public static final String FEC_INICIO = "fec_inicio";
	public static final String FEC_FINAL = "fec_final";
	public static final String DIAS = "dias";
	public static final String OID_MOT_VIS_FALL = "oid_mot_vis_fall";
	public static final String OID_APARATO = "oid_aparato";
	public static final String OID_ENFERMEDAD = "oid_enfermedad";
	public static final String OID_PREST_MED = "oid_prest_med";
	public static final String SINTOMA = "sintoma";
	public static final String OBSERVACION = "observacion";
	public static final String JUSTIFICA = "justifica";
	public static final String ACTIVO = "activo";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String FEC_ATE_MED = "fec_ate_med";
	public static final String OID_MEDICO = "oid_medico";
	public static final String OID_FAMILIAR = "oid_familiar";
	public static final String FEC_ACCIDENTE = "fec_accidente";
	public static final String DESC_ACCIDENTE = "desc_accidente";
	public static final String FEC_CONTROL = "fec_control";
	
	
	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_LEG_PEDMED = 101;
	public static final int SELECT_BY_LEG_ATEMED = 102;
	public static final int SELECT_BY_LEG_ENFFAM = 103;
	public static final int SELECT_BY_LEG_ACCLAB = 104;
	public static final int SELECT_BY_FILTRO_FECDESDE_FECHASTA = 105;
	
	

	public DBServicioMedicoRRHH() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SERV_MEDICO = 1;
		final int TIPO_SERV_MED = 2;
		final int NRO_NOV_SIST_EXT = 3;
		final int FEC_INICIO = 4;
		final int FEC_FINAL = 5;
		final int DIAS = 6;
		final int OID_MOT_VIS_FALL = 7;
		final int OID_APARATO = 8;
		final int OID_ENFERMEDAD = 9;
		final int OID_PREST_MED = 10;
		final int SINTOMA = 11;
		final int OBSERVACION = 12;
		final int JUSTIFICA = 13;
		final int ACTIVO = 14;
		final int OID_LEGAJO = 15;
		final int FEC_ATE_MED = 16;
		final int OID_MEDIDO = 17;
		final int OID_FAMILIAR = 18;
		final int FEC_ACCIDENTE = 19;
		final int DESC_ACCIDENTE = 20;
		final int FEC_CONTROL = 21;

		ServicioMedicoRRHH pers = (ServicioMedicoRRHH) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhServMedico " + " ( " + "OID_SERV_MEDICO," + "TIPO_SERV_MED," + "NRO_NOV_SIST_EXT," + "FEC_INICIO," + "FEC_FINAL," + "DIAS," + "OID_MOT_VIS_FALL,"
				+ "OID_APARATO," + "OID_ENFERMEDAD," + "OID_PREST_MED," + "SINTOMA," + "OBSERVACION," + "JUSTIFICA," + "ACTIVO , OID_LEGAJO , FEC_ATE_MED , OID_MEDICO , OID_FAMILIAR , FEC_ACCIDENTE , DESC_ACCIDENTE , FEC_CONTROL)" + " values " + "(" + "?," + "?,"+ "?,"+ "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_SERV_MEDICO, pers.getOID());
		qInsert.setString(TIPO_SERV_MED, pers.getTipo_serv_med());
		if (pers.getNro_nov_sist_ext() != null)
			qInsert.setInt(NRO_NOV_SIST_EXT, pers.getNro_nov_sist_ext().intValue());
		else
			qInsert.setNull(NRO_NOV_SIST_EXT, Types.INTEGER);
		if (pers.getFec_inicio() != null)
			qInsert.setDate(FEC_INICIO, new java.sql.Date(pers.getFec_inicio().getTime()));
		else
			qInsert.setNull(FEC_INICIO, java.sql.Types.DATE);
		if (pers.getFec_final() != null)
			qInsert.setDate(FEC_FINAL, new java.sql.Date(pers.getFec_final().getTime()));
		else
			qInsert.setNull(FEC_FINAL, java.sql.Types.DATE);
		if (pers.getDias()!=null)
			qInsert.setInt(DIAS, pers.getDias().intValue());
		else
			qInsert.setNull(DIAS, Types.INTEGER);
		if (pers.getMotivo_visita_fallo() != null)
			qInsert.setInt(OID_MOT_VIS_FALL, pers.getMotivo_visita_fallo().getOID());
		else
			qInsert.setNull(OID_MOT_VIS_FALL, java.sql.Types.INTEGER);
		if (pers.getAparato() != null)
			qInsert.setInt(OID_APARATO, pers.getAparato().getOID());
		else
			qInsert.setNull(OID_APARATO, java.sql.Types.INTEGER);
		if (pers.getEnfermedad() != null)
			qInsert.setInt(OID_ENFERMEDAD, pers.getEnfermedad().getOID());
		else
			qInsert.setNull(OID_ENFERMEDAD, java.sql.Types.INTEGER);
		if (pers.getPrestador_medico() != null)
			qInsert.setInt(OID_PREST_MED, pers.getPrestador_medico().getOID());
		else
			qInsert.setNull(OID_PREST_MED, java.sql.Types.INTEGER);
		if (pers.getSintoma() != null)
			qInsert.setString(SINTOMA, pers.getSintoma());
		else
			qInsert.setNull(SINTOMA, Types.VARCHAR);
		if (pers.getObservacion() != null)
			qInsert.setString(OBSERVACION, pers.getObservacion());
		else
			qInsert.setNull(OBSERVACION, Types.VARCHAR);
		if (pers.isJustifica() != null)
			qInsert.setBoolean(JUSTIFICA, pers.isJustifica().booleanValue());
		else
			qInsert.setNull(JUSTIFICA, Types.INTEGER);
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getFecAteMed()!=null)
			qInsert.setDate(FEC_ATE_MED,new java.sql.Date(pers.getFecAteMed().getTime()));
		else
			qInsert.setNull(FEC_ATE_MED,Types.DATE);
		if (pers.getMedico()!=null)
			qInsert.setInt(OID_MEDIDO, pers.getMedico().getOID());
		else
			qInsert.setNull(OID_MEDIDO, Types.INTEGER);
		if (pers.getFamiliar()!=null)
			qInsert.setInt(OID_FAMILIAR , pers.getFamiliar().getOID());
		else
			qInsert.setNull(OID_FAMILIAR , Types.INTEGER);
		
		if (pers.getFecAccidente()!=null)
			qInsert.setDate(FEC_ACCIDENTE , new java.sql.Date(pers.getFecAccidente().getTime()));
		else
			qInsert.setNull(FEC_ACCIDENTE, Types.DATE);
		
		if (pers.getDescAccidente()!=null)
			qInsert.setString(DESC_ACCIDENTE , pers.getDescAccidente());
		else
			qInsert.setNull(DESC_ACCIDENTE, Types.VARCHAR);
		
		if (pers.getFecControl()!=null)
			qInsert.setDate(FEC_CONTROL , new java.sql.Date(pers.getFecControl().getTime()));
		else
			qInsert.setNull(FEC_CONTROL, Types.DATE);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int TIPO_SERV_MED = 1;
		final int NRO_NOV_SIST_EXT = 2;
		final int FEC_INICIO = 3;
		final int FEC_FINAL = 4;
		final int DIAS = 5;
		final int OID_MOT_VIS_FALL = 6;
		final int OID_APARATO = 7;
		final int OID_ENFERMEDAD = 8;
		final int OID_PREST_MED = 9;
		final int SINTOMA = 10;
		final int OBSERVACION = 11;
		final int JUSTIFICA = 12;
		final int ACTIVO = 13;
		final int OID_LEGAJO = 14;
		final int FEC_ATE_MED = 15;
		final int OID_MEDICO = 16;
		final int OID_FAMILIAR = 17;
		final int FEC_ACCIDENTE = 18;
		final int DESC_ACCIDENTE = 19;
		final int FEC_CONTROL = 20;
		final int OID_SERV_MEDICO = 21;

		ServicioMedicoRRHH pers = (ServicioMedicoRRHH) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhServMedico set " + "tipo_serv_med=?" + ",nro_nov_sist_ext=?" + ",fec_inicio=?" + ",fec_final=?" + ",dias=?" + ",oid_mot_vis_fall=?" + ",oid_aparato=?"
				+ ",oid_enfermedad=?" + ",oid_prest_med=?" + ",sintoma=?" + ",observacion=?" + ",justifica=?" + ",activo=? , oid_legajo = ? , fec_ate_med = ? , oid_medico = ? , oid_familiar = ? , fec_accidente = ? , desc_accidente = ? , fec_control = ? " + " where " + " oid_serv_medico=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SERV_MEDICO, pers.getOID());
		qUpdate.setString(TIPO_SERV_MED, pers.getTipo_serv_med());
		if (pers.getNro_nov_sist_ext() != null)
			qUpdate.setInt(NRO_NOV_SIST_EXT, pers.getNro_nov_sist_ext().intValue());
		else
			qUpdate.setNull(NRO_NOV_SIST_EXT, Types.INTEGER);
		if (pers.getFec_inicio() != null)
			qUpdate.setDate(FEC_INICIO, new java.sql.Date(pers.getFec_inicio().getTime()));
		else
			qUpdate.setNull(FEC_INICIO, Types.DATE);
		if (pers.getFec_final() != null)
			qUpdate.setDate(FEC_FINAL, new java.sql.Date(pers.getFec_final().getTime()));
		else
			qUpdate.setNull(FEC_FINAL, Types.DATE);
		if (pers.getDias()!=null)
			qUpdate.setInt(DIAS, pers.getDias().intValue());
		else
			qUpdate.setNull(DIAS, Types.INTEGER);
		if (pers.getMotivo_visita_fallo() != null)
			qUpdate.setInt(OID_MOT_VIS_FALL, pers.getMotivo_visita_fallo().getOID());
		else
			qUpdate.setNull(OID_MOT_VIS_FALL, java.sql.Types.INTEGER);
		if (pers.getAparato() != null)
			qUpdate.setInt(OID_APARATO, pers.getAparato().getOID());
		else
			qUpdate.setNull(OID_APARATO, java.sql.Types.INTEGER);
		if (pers.getEnfermedad() != null)
			qUpdate.setInt(OID_ENFERMEDAD, pers.getEnfermedad().getOID());
		else
			qUpdate.setNull(OID_ENFERMEDAD, java.sql.Types.INTEGER);
		if (pers.getPrestador_medico() != null)
			qUpdate.setInt(OID_PREST_MED, pers.getPrestador_medico().getOID());
		else
			qUpdate.setNull(OID_PREST_MED, java.sql.Types.INTEGER);
		if (pers.getSintoma() != null)
			qUpdate.setString(SINTOMA, pers.getSintoma());
		else
			qUpdate.setNull(SINTOMA, Types.VARCHAR);
		if (pers.getObservacion() != null)
			qUpdate.setString(OBSERVACION, pers.getObservacion());
		else
			qUpdate.setNull(OBSERVACION, Types.VARCHAR);
		if (pers.isJustifica() != null)
			qUpdate.setBoolean(JUSTIFICA, pers.isJustifica().booleanValue());
		else
			qUpdate.setNull(JUSTIFICA, Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		if (pers.getFecAteMed()!=null)
			qUpdate.setDate(FEC_ATE_MED,new java.sql.Date(pers.getFecAteMed().getTime()));
		else
			qUpdate.setNull(FEC_ATE_MED,Types.DATE);
		if (pers.getMedico()!=null)
			qUpdate.setInt(OID_MEDICO, pers.getMedico().getOID());
		else
			qUpdate.setNull(OID_MEDICO, Types.INTEGER);		
		if (pers.getFamiliar()!=null)
			qUpdate.setInt(OID_FAMILIAR , pers.getFamiliar().getOID());
		else
			qUpdate.setNull(OID_FAMILIAR , Types.INTEGER);
		
		if (pers.getFecAccidente()!=null)
			qUpdate.setDate(FEC_ACCIDENTE , new java.sql.Date(pers.getFecAccidente().getTime()));
		else
			qUpdate.setNull(FEC_ACCIDENTE, Types.DATE);
		
		if (pers.getDescAccidente()!=null)
			qUpdate.setString(DESC_ACCIDENTE , pers.getDescAccidente());
		else
			qUpdate.setNull(DESC_ACCIDENTE, Types.VARCHAR);
		
		if (pers.getFecControl()!=null)
			qUpdate.setDate(FEC_CONTROL , new java.sql.Date(pers.getFecControl().getTime()));
		else
			qUpdate.setNull(FEC_CONTROL, Types.DATE);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SERV_MEDICO = 1;
		ServicioMedicoRRHH pers = (ServicioMedicoRRHH) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhServMedico " + " set activo=0 " + " where " + " oid_serv_medico=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SERV_MEDICO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SERV_MEDICO = 1;
		ServicioMedicoRRHH pers = (ServicioMedicoRRHH) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhServMedico " + " set activo=1 " + " where " + " oid_serv_medico=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SERV_MEDICO, pers.getOID());
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
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajo(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_PEDMED: {
			ps = this.selectByLegajoPedMed(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_ATEMED: {
			ps = this.selectByLegajoAteMed(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_ENFFAM: {
			ps = this.selectByLegajoEnfFam(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_ACCLAB: {
			ps = this.selectByLegajoAccLab(aCondiciones);
			break;
		}
		case SELECT_BY_FILTRO_FECDESDE_FECHASTA: {
			ps = this.selectByFiltroFecDesdeHasta(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_SERV_MEDICO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE oid_serv_medico = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_SERV_MEDICO, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByLegajoAccLab(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 and  tipo_serv_med = 'ACC_LAB' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}
	
	
	
	
	private PreparedStatement selectByLegajoEnfFam(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 and  tipo_serv_med = 'ENF_FAM' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByLegajoAteMed(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 and  tipo_serv_med = 'ATE_MED' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByFiltroFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		FiltroLegCab filtro = (FiltroLegCab) condiciones.get(FiltroLegCab.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM rhServMedico ");
		textSQL.append(" WHERE FEC_CONTROL>=? AND FEC_CONTROL<=? AND ACTIVO=1 ");
		
		
		List listaValEmp = filtro.getValoresFiltroEmpresa();
		if (listaValEmp.size()>0) {
			String armarCondIN = "";
			Iterator iterValEmp = listaValEmp.iterator();
			while (iterValEmp.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEmp.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEmpresa.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}
		
		List listaTareas = filtro.getValoresFiltroTareas();
		if (listaTareas.size()>0) {
			String armarCondIN = "";
			Iterator iterValTarea = listaTareas.iterator();
			while (iterValTarea.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValTarea.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_tarea_desemp IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		
		List listaSindicatos = filtro.getValoresFiltroSindicatos();
		if (listaSindicatos.size()>0) {
			String armarCondIN = "";
			Iterator iterValSindicatos = listaSindicatos.iterator();
			while (iterValSindicatos.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSindicatos.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_clase_sind IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		List listaValSec = filtro.getValoresFiltroSector();
		if (listaValSec.size()>0) {
			String armarCondIN = "";
			Iterator iterValSec = listaValSec.iterator();
			while (iterValSec.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSec.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifSector.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		List listaValPue = filtro.getValoresFiltroPuesto();
		if (listaValPue.size()>0) {
			String armarCondIN = "";
			Iterator iterValPue = listaValPue.iterator();
			while (iterValPue.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValPue.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifPuesto.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}
		
		List listaValEst = filtro.getValoresFiltroEstado();
		if (listaValEst.size()>0) {
			String armarCondIN = "";
			Iterator iterValEst = listaValEst.iterator();
			while (iterValEst.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEst.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEstado.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));		
		
		
		return querySelect;
	}	
	
	
	private PreparedStatement selectByLegajoPedMed(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 and  tipo_serv_med = 'PED_MED' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhServMedico ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_serv_medico oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhServMedico");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getServMedByLegajo(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ServicioMedicoRRHH.NICKNAME, DBServicioMedicoRRHH.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}

	public static List getServMedByLegajoPedMed(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ServicioMedicoRRHH.NICKNAME, DBServicioMedicoRRHH.SELECT_BY_LEG_PEDMED, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getServMedByLegajoAteMed(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ServicioMedicoRRHH.NICKNAME, DBServicioMedicoRRHH.SELECT_BY_LEG_ATEMED, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getServMedByLegajoEnfFam(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ServicioMedicoRRHH.NICKNAME, DBServicioMedicoRRHH.SELECT_BY_LEG_ENFFAM, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getServMedByLegajoAccLab(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ServicioMedicoRRHH.NICKNAME, DBServicioMedicoRRHH.SELECT_BY_LEG_ACCLAB, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getServMedByFiltroFecDesdeFecHasta(
				FiltroLegCab filtro,
				java.util.Date fecDesde,
				java.util.Date fecHasta,
				ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(FiltroLegCab.NICKNAME, filtro);
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		
		return (List) ObjetoLogico.getObjects(
				ServicioMedicoRRHH.NICKNAME, 
				DBServicioMedicoRRHH.SELECT_BY_FILTRO_FECDESDE_FECHASTA, 
				condiciones, 
				new ListObserver(), aSesion);
	}			

}
