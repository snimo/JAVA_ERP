package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.bm.CaracterExcluido;
import com.srn.erp.excluidos.bm.CargoLegajoExcluido;
import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.bm.ColorExcluido;
import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionSoloEst;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.MarcaExcluido;
import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.bm.PerfExcluidoPerfFunc;
import com.srn.erp.excluidos.bm.RasgoExcluido;
import com.srn.erp.excluidos.bm.RazaExcluido;
import com.srn.erp.excluidos.bm.SectorLegajoExcluido;
import com.srn.erp.excluidos.bm.SeguExcEstAlgunaVez;
import com.srn.erp.excluidos.bm.SeguExcEstadoActual;
import com.srn.erp.excluidos.bm.SeguExcPeligrosidad;
import com.srn.erp.excluidos.bm.SeguExcPredio;
import com.srn.erp.excluidos.bm.SeguExcTipoIndi;
import com.srn.erp.excluidos.bm.TipoBarba;
import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
import com.srn.erp.excluidos.bm.TipoNariz;
import com.srn.erp.general.bm.FuncEspSegERP;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Servicios.ServicioPoolBD;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.AltaFuncEspSeg;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.applicarionServer.bm.Seguridad.PerfilFuncionalUsuario;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.PoolBD.IPoolBD;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBIndividuoExcluido extends DBObjetoPersistente {

	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String TIPO = "tipo";
	public static final String APELLIDO = "apellido";
	public static final String NOMBRE = "nombre";
	public static final String OID_TIPO_DOCUMENTO = "oid_tipo_documento";
	public static final String NRO_DOCUMENTO = "nro_documento";
	public static final String APODO = "apodo";
	public static final String OID_NACIONALIDAD = "oid_nacionalidad";
	public static final String LEGAJO = "legajo";
	public static final String OID_SECTOR = "oid_sector";
	public static final String OID_CARGO = "oid_cargo";
	public static final String TIPO_CONDICION = "tipo_condicion";
	public static final String SEXO = "sexo";
	public static final String OID_RAZA = "oid_raza";
	public static final String OID_ALTURA = "oid_altura";
	public static final String OID_COMPLEXION = "oid_complexion";
	public static final String OID_EDAD = "oid_edad";
	public static final String OID_COLOR = "oid_color";
	public static final String OID_TIPO_BARBA = "oid_tipo_barba";
	public static final String OID_TIPO_CABELLO = "oid_tipo_cabello";
	public static final String OID_TIPO_NARIZ = "oid_tipo_nariz";
	public static final String ANTEOJOS = "anteojos";
	public static final String MARCAS = "marcas";
	public static final String RASGOS = "rasgos";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String ACTIVO = "activo";
	public static final String ACTU_AUTO_EST_IND = "act_aut_est_ind";
	public static final String OID_ESTADO = "oid_estado";
	public static final String OID_ESTADO_ANT = "oid_estado_ant";
	public static final String OID_NOVEDAD = "oid_novedad";
	public static final String OBS_PRINCIPAL = "obs_principal";
	public static final String OID_CARACTER = "oid_caracter";
	public static final String OID_MARCA = "oid_marca";
	public static final String OID_RASGO = "oid_rasgo";
	public static final String OID_ANTEOJO = "oid_anteojo";
	public static final String FEC_ALTA = "fec_alta";
	public static final String FOTO_PRINCIPAL = "foto_principal";
	public static final String OID_PELIGROSIDAD = "oid_peligrosidad";
	public static final String OID_PREDIO = "oid_predio";
	public static final String OID_PREDIO_FOTO_1 = "oid_predio_foto_1";
	public static final String FEC_ESTADO = "fec_estado";
	public static final String NRO_VER_FOTO_1 = "nro_ver_foto_1";
	public static final String NRO_VER_FOTO_2 = "nro_ver_foto_2";
	public static final String NRO_VER_FOTO_3 = "nro_ver_foto_3";
	

	public static final int SELECT_BY_CONS_MAS = 100;
	public static final int SELECT_NRO_DOCU = 101;
	public static final int SELECT_BY_GRUPO_IMP = 102;
	public static final int SELECT_LOTE_BY_GRUPO_IMP = 103;
	public static final int SELECT_LOTE_ALTA_BY_GRUPO_IMP_NRO_LOTE = 104;
	public static final int SELECT_LOTE_BAJA_BY_GRUPO_IMP_NRO_LOTE = 105;
	public static final int UPDATE_NRO_LOTE_SINC = 106;

	public DBIndividuoExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int TIPO = 2;
		final int APELLIDO = 3;
		final int NOMBRE = 4;
		final int OID_TIPO_DOCUMENTO = 5;
		final int NRO_DOCUMENTO = 6;
		final int APODO = 7;
		final int OID_NACIONALIDAD = 8;
		final int LEGAJO = 9;
		final int OID_SECTOR = 10;
		final int OID_CARGO = 11;
		final int TIPO_CONDICION = 12;
		final int SEXO = 13;
		final int OID_RAZA = 14;
		final int OID_ALTURA = 15;
		final int OID_COMPLEXION = 16;
		final int OID_EDAD = 17;
		final int OID_COLOR = 18;
		final int OID_TIPO_BARBA = 19;
		final int OID_TIPO_CABELLO = 20;
		final int OID_TIPO_NARIZ = 21;
		final int ANTEOJOS = 22;
		final int MARCAS = 23;
		final int RASGOS = 24;
		final int OID_LEGAJO = 25;
		final int ACTIVO = 26;
		final int ACTU_AUTO_EST_IND = 27;
		final int OBS_PRINCIPAL = 28;
		final int OID_CARACTER = 29;
		final int OID_MARCA = 30;
		final int OID_RASGO = 31;
		final int OID_ANTEOJO = 32;
		final int FEC_ALTA = 33;
		final int FOTO_PRINCIPAL = 34;
		final int OID_PELIGROSIDAD = 35;
		final int OID_PREDIO = 36;
		final int OID_PREDIO_FOTO_1 = 37;
		final int NRO_VER_FOTO_1 = 38;
		final int NRO_VER_FOTO_2 = 39;
		final int NRO_VER_FOTO_3 = 40;
		
		IndividuoExcluido pers = (IndividuoExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into excIndividuo "
						+ " ( "
						+ "OID_INDIVIDUO,"
						+ "TIPO,"
						+ "APELLIDO,"
						+ "NOMBRE,"
						+ "OID_TIPO_DOCUMENTO,"
						+ "NRO_DOCUMENTO,"
						+ "APODO,"
						+ "OID_NACIONALIDAD,"
						+ "LEGAJO,"
						+ "OID_SECTOR,"
						+ "OID_CARGO,"
						+ "TIPO_CONDICION,"
						+ "SEXO,"
						+ "OID_RAZA,"
						+ "OID_ALTURA,"
						+ "OID_COMPLEXION,"
						+ "OID_EDAD,"
						+ "OID_COLOR,"
						+ "OID_TIPO_BARBA,"
						+ "OID_TIPO_CABELLO,"
						+ "OID_TIPO_NARIZ,"
						+ "ANTEOJOS,"
						+ "MARCAS,"
						+ "RASGOS,"
						+ "OID_LEGAJO , ACTIVO , ACT_AUT_EST_IND , OBS_PRINCIPAL , OID_CARACTER , OID_MARCA , OID_RASGO , OID_ANTEOJO , FEC_ALTA , FOTO_PRINCIPAL , OID_PELIGROSIDAD , OID_PREDIO , OID_PREDIO_FOTO_1,NRO_VER_FOTO_1,NRO_VER_FOTO_2,NRO_VER_FOTO_3)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "? ) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_INDIVIDUO, pers.getOID());
		qInsert.setString(TIPO, pers.getTipo());
		if (pers.getApellido() != null)
			qInsert.setString(APELLIDO, pers.getApellido());
		else
			qInsert.setString(APELLIDO, "");
		if (pers.getNombre() != null)
			qInsert.setString(NOMBRE, pers.getNombre());
		else
			qInsert.setString(NOMBRE, "");
		if (pers.getTipo_documento() != null)
			qInsert.setInt(OID_TIPO_DOCUMENTO, pers.getTipo_documento().getOID());
		else
			qInsert.setNull(OID_TIPO_DOCUMENTO, java.sql.Types.INTEGER);
		if (pers.getNro_documento() != null)
			qInsert.setString(NRO_DOCUMENTO, pers.getNro_documento());
		else
			qInsert.setString(NRO_DOCUMENTO, "");
		if (pers.getApodo() != null)
			qInsert.setString(APODO, pers.getApodo());
		else
			qInsert.setString(APODO, "");
		if (pers.getNacionalidad() != null)
			qInsert.setInt(OID_NACIONALIDAD, pers.getNacionalidad().getOID());
		else
			qInsert.setNull(OID_NACIONALIDAD, java.sql.Types.INTEGER);
		if (pers.getNro_legajo() != null)
			qInsert.setString(LEGAJO, pers.getNro_legajo());
		else
			qInsert.setString(LEGAJO, "");
		if (pers.getSector() != null)
			qInsert.setInt(OID_SECTOR, pers.getSector().getOID());
		else
			qInsert.setNull(OID_SECTOR, java.sql.Types.INTEGER);
		if (pers.getCargo() != null)
			qInsert.setInt(OID_CARGO, pers.getCargo().getOID());
		else
			qInsert.setNull(OID_CARGO, java.sql.Types.INTEGER);
		if (pers.getTipo_condicion() != null)
			qInsert.setString(TIPO_CONDICION, pers.getTipo_condicion());
		else
			qInsert.setString(TIPO_CONDICION, "");
		if (pers.getSexo() != null)
			qInsert.setString(SEXO, pers.getSexo());
		else
			qInsert.setString(SEXO, "");
		if (pers.getRaza() != null)
			qInsert.setInt(OID_RAZA, pers.getRaza().getOID());
		else
			qInsert.setNull(OID_RAZA, java.sql.Types.INTEGER);
		if (pers.getAltura() != null)
			qInsert.setInt(OID_ALTURA, pers.getAltura().getOID());
		else
			qInsert.setNull(OID_ALTURA, java.sql.Types.INTEGER);
		if (pers.getComplexion() != null)
			qInsert.setInt(OID_COMPLEXION, pers.getComplexion().getOID());
		else
			qInsert.setNull(OID_COMPLEXION, java.sql.Types.INTEGER);
		if (pers.getEdad() != null)
			qInsert.setInt(OID_EDAD, pers.getEdad().getOID());
		else
			qInsert.setNull(OID_EDAD, java.sql.Types.INTEGER);
		if (pers.getColor() != null)
			qInsert.setInt(OID_COLOR, pers.getColor().getOID());
		else
			qInsert.setNull(OID_COLOR, java.sql.Types.INTEGER);
		if (pers.getTipo_barba() != null)
			qInsert.setInt(OID_TIPO_BARBA, pers.getTipo_barba().getOID());
		else
			qInsert.setNull(OID_TIPO_BARBA, java.sql.Types.INTEGER);
		if (pers.getTipo_cabello() != null)
			qInsert.setInt(OID_TIPO_CABELLO, pers.getTipo_cabello().getOID());
		else
			qInsert.setNull(OID_TIPO_CABELLO, java.sql.Types.INTEGER);
		if (pers.getTipo_nariz() != null)
			qInsert.setInt(OID_TIPO_NARIZ, pers.getTipo_nariz().getOID());
		else
			qInsert.setNull(OID_TIPO_NARIZ, java.sql.Types.INTEGER);
		if (pers.isAnteojos() != null)
			qInsert.setBoolean(ANTEOJOS, pers.isAnteojos().booleanValue());
		else
			qInsert.setBoolean(ANTEOJOS, false);
		if (pers.getMarcas() != null)
			qInsert.setString(MARCAS, pers.getMarcas());
		else
			qInsert.setString(MARCAS, "");
		if (pers.getRasgos() != null)
			qInsert.setString(RASGOS, pers.getRasgos());
		else
			qInsert.setString(RASGOS, "");
		if (pers.getLegajo() != null)
			qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qInsert.setNull(OID_LEGAJO, java.sql.Types.INTEGER);
		if (pers.isActivo() != null)
			qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		else
			qInsert.setBoolean(ACTIVO, false);

		if (pers.isActuAutoEstInd() != null)
			qInsert.setBoolean(ACTU_AUTO_EST_IND, pers.isActuAutoEstInd().booleanValue());
		else
			qInsert.setNull(ACTU_AUTO_EST_IND, java.sql.Types.BOOLEAN);
		if (pers.getObsPrincipal() != null)
			qInsert.setString(OBS_PRINCIPAL, pers.getObsPrincipal());
		else
			qInsert.setNull(OBS_PRINCIPAL, java.sql.Types.VARCHAR);
		if (pers.getCaracter() != null)
			qInsert.setInt(OID_CARACTER, pers.getCaracter().getOID());
		else
			qInsert.setNull(OID_CARACTER, java.sql.Types.INTEGER);

		if (pers.getMarca() != null)
			qInsert.setInt(OID_MARCA, pers.getMarca().getOID());
		else
			qInsert.setNull(OID_MARCA, java.sql.Types.INTEGER);

		if (pers.getRasgo() != null)
			qInsert.setInt(OID_RASGO, pers.getRasgo().getOID());
		else
			qInsert.setNull(OID_RASGO, java.sql.Types.INTEGER);

		if (pers.getAnteojo() != null)
			qInsert.setInt(OID_ANTEOJO, pers.getAnteojo().getOID());
		else
			qInsert.setNull(OID_ANTEOJO, java.sql.Types.INTEGER);

		qInsert.setDate(FEC_ALTA, new java.sql.Date(Fecha.getFechaActual().getTime()));

		if (pers.getFotoPrincipal() != null)
			qInsert.setInt(FOTO_PRINCIPAL, pers.getFotoPrincipal().intValue());
		else
			qInsert.setNull(FOTO_PRINCIPAL, java.sql.Types.INTEGER);

		if (pers.getPeligrosidad() != null)
			qInsert.setInt(OID_PELIGROSIDAD, pers.getPeligrosidad().getOID());
		else
			qInsert.setNull(OID_PELIGROSIDAD, java.sql.Types.INTEGER);

		if (pers.getPredioExcluido() != null)
			qInsert.setInt(OID_PREDIO, pers.getPredioExcluido().getOID());
		else
			qInsert.setNull(OID_PREDIO, java.sql.Types.INTEGER);

		if (pers.getPredioFoto1() != null)
			qInsert.setInt(OID_PREDIO_FOTO_1, pers.getPredioFoto1().getOID());
		else
			qInsert.setNull(OID_PREDIO_FOTO_1, java.sql.Types.INTEGER);
		
		if (pers.getNroVersionFoto1() != null)
			qInsert.setInt(NRO_VER_FOTO_1, pers.getNroVersionFoto1());
		else
			qInsert.setNull(NRO_VER_FOTO_1, 0);
		
		if (pers.getNroVersionFoto2() != null)
			qInsert.setInt(NRO_VER_FOTO_2, pers.getNroVersionFoto2());
		else
			qInsert.setNull(NRO_VER_FOTO_2, 0);

		if (pers.getNroVersionFoto3() != null)
			qInsert.setInt(NRO_VER_FOTO_3, pers.getNroVersionFoto3());
		else
			qInsert.setNull(NRO_VER_FOTO_3, 0);
		

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int TIPO = 1;
		final int APELLIDO = 2;
		final int NOMBRE = 3;
		final int OID_TIPO_DOCUMENTO = 4;
		final int NRO_DOCUMENTO = 5;
		final int APODO = 6;
		final int OID_NACIONALIDAD = 7;
		final int LEGAJO = 8;
		final int OID_SECTOR = 9;
		final int OID_CARGO = 10;
		final int TIPO_CONDICION = 11;
		final int SEXO = 12;
		final int OID_RAZA = 13;
		final int OID_ALTURA = 14;
		final int OID_COMPLEXION = 15;
		final int OID_EDAD = 16;
		final int OID_COLOR = 17;
		final int OID_TIPO_BARBA = 18;
		final int OID_TIPO_CABELLO = 19;
		final int OID_TIPO_NARIZ = 20;
		final int ANTEOJOS = 21;
		final int MARCAS = 22;
		final int RASGOS = 23;
		final int OID_LEGAJO = 24;
		final int ACTIVO = 25;
		final int ACTU_AUTO_EST_IND = 26;
		final int OBS_PRINCIPAL = 27;
		final int OID_CARACTER = 28;
		final int OID_MARCA = 29;
		final int OID_RASGO = 30;
		final int OID_ANTEOJO = 31;
		final int FOTO_PRINCIPAL = 32;
		final int OID_PELIGROSIDAD = 33;
		final int OID_PREDIO = 34;
		final int OID_PREDIO_FOTO_1 = 35;
		final int NRO_VER_FOTO_1 = 36;
		final int NRO_VER_FOTO_2 = 37;
		final int NRO_VER_FOTO_3 = 38;
		
		final int OID_INDIVIDUO = 39;

		IndividuoExcluido pers = (IndividuoExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate
				.append(" update excIndividuo set "
						+ "tipo=?"
						+ ",apellido=?"
						+ ",nombre=?"
						+ ",oid_tipo_documento=?"
						+ ",nro_documento=?"
						+ ",apodo=?"
						+ ",oid_nacionalidad=?"
						+ ",legajo=?"
						+ ",oid_sector=?"
						+ ",oid_cargo=?"
						+ ",tipo_condicion=?"
						+ ",sexo=?"
						+ ",oid_raza=?"
						+ ",oid_altura=?"
						+ ",oid_complexion=?"
						+ ",oid_edad=?"
						+ ",oid_color=?"
						+ ",oid_tipo_barba=?"
						+ ",oid_tipo_cabello=?"
						+ ",oid_tipo_nariz=?"
						+ ",anteojos=?"
						+ ",marcas=?"
						+ ",rasgos=? "
						+ ",oid_legajo=? , activo=? , act_aut_est_ind = ? , obs_principal=? , oid_caracter=? , oid_marca=? , oid_rasgo=? , oid_anteojo = ? , foto_principal = ? , oid_peligrosidad = ? , oid_predio = ? , oid_predio_foto_1 = ? , nro_ver_foto_1 = ? , nro_ver_foto_2 = ? , nro_ver_foto_3 = ?  "
						+ " where " + " oid_individuo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INDIVIDUO, pers.getOID());
		if (pers.getTipo() != null)
			qUpdate.setString(TIPO, pers.getTipo());
		else
			qUpdate.setString(TIPO, "");
		if (pers.getApellido() != null)
			qUpdate.setString(APELLIDO, pers.getApellido());
		else
			qUpdate.setString(APELLIDO, "");
		if (pers.getNombre() != null)
			qUpdate.setString(NOMBRE, pers.getNombre());
		else
			qUpdate.setString(NOMBRE, "");
		if (pers.getTipo_documento() != null)
			qUpdate.setInt(OID_TIPO_DOCUMENTO, pers.getTipo_documento().getOID());
		else
			qUpdate.setNull(OID_TIPO_DOCUMENTO, java.sql.Types.INTEGER);
		if (pers.getNro_documento() != null)
			qUpdate.setString(NRO_DOCUMENTO, pers.getNro_documento());
		else
			qUpdate.setString(NRO_DOCUMENTO, "");
		if (pers.getApodo() != null)
			qUpdate.setString(APODO, pers.getApodo());
		else
			qUpdate.setString(APODO, "");
		if (pers.getNacionalidad() != null)
			qUpdate.setInt(OID_NACIONALIDAD, pers.getNacionalidad().getOID());
		else
			qUpdate.setNull(OID_NACIONALIDAD, java.sql.Types.INTEGER);
		if (pers.getNro_legajo() != null)
			qUpdate.setString(LEGAJO, pers.getNro_legajo());
		else
			qUpdate.setString(LEGAJO, "");
		if (pers.getSector() != null)
			qUpdate.setInt(OID_SECTOR, pers.getSector().getOID());
		else
			qUpdate.setNull(OID_SECTOR, java.sql.Types.INTEGER);
		if (pers.getCargo() != null)
			qUpdate.setInt(OID_CARGO, pers.getCargo().getOID());
		else
			qUpdate.setNull(OID_CARGO, java.sql.Types.INTEGER);
		if (pers.getTipo_condicion() != null)
			qUpdate.setString(TIPO_CONDICION, pers.getTipo_condicion());
		else
			qUpdate.setString(TIPO_CONDICION, "");
		if (pers.getSexo() != null)
			qUpdate.setString(SEXO, pers.getSexo());
		else
			qUpdate.setString(SEXO, "");
		if (pers.getRaza() != null)
			qUpdate.setInt(OID_RAZA, pers.getRaza().getOID());
		else
			qUpdate.setNull(OID_RAZA, java.sql.Types.INTEGER);
		if (pers.getAltura() != null)
			qUpdate.setInt(OID_ALTURA, pers.getAltura().getOID());
		else
			qUpdate.setNull(OID_ALTURA, java.sql.Types.INTEGER);
		if (pers.getComplexion() != null)
			qUpdate.setInt(OID_COMPLEXION, pers.getComplexion().getOID());
		else
			qUpdate.setNull(OID_COMPLEXION, java.sql.Types.INTEGER);
		if (pers.getEdad() != null)
			qUpdate.setInt(OID_EDAD, pers.getEdad().getOID());
		else
			qUpdate.setNull(OID_EDAD, java.sql.Types.INTEGER);
		if (pers.getColor() != null)
			qUpdate.setInt(OID_COLOR, pers.getColor().getOID());
		else
			qUpdate.setNull(OID_COLOR, java.sql.Types.INTEGER);
		if (pers.getTipo_barba() != null)
			qUpdate.setInt(OID_TIPO_BARBA, pers.getTipo_barba().getOID());
		else
			qUpdate.setNull(OID_TIPO_BARBA, java.sql.Types.INTEGER);
		if (pers.getTipo_cabello() != null)
			qUpdate.setInt(OID_TIPO_CABELLO, pers.getTipo_cabello().getOID());
		else
			qUpdate.setNull(OID_TIPO_CABELLO, java.sql.Types.INTEGER);
		if (pers.getTipo_nariz() != null)
			qUpdate.setInt(OID_TIPO_NARIZ, pers.getTipo_nariz().getOID());
		else
			qUpdate.setNull(OID_TIPO_NARIZ, java.sql.Types.INTEGER);
		if (pers.isAnteojos() != null)
			qUpdate.setBoolean(ANTEOJOS, pers.isAnteojos().booleanValue());
		else
			qUpdate.setBoolean(ANTEOJOS, false);
		if (pers.getMarcas() != null)
			qUpdate.setString(MARCAS, pers.getMarcas());
		else
			qUpdate.setString(MARCAS, "");
		if (pers.getRasgos() != null)
			qUpdate.setString(RASGOS, pers.getRasgos());
		else
			qUpdate.setString(RASGOS, "");
		if (pers.getLegajo() != null)
			qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qUpdate.setNull(OID_LEGAJO, java.sql.Types.INTEGER);
		if (pers.isActivo() != null)
			qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		else
			qUpdate.setBoolean(ACTIVO, false);
		if (pers.isActuAutoEstInd() != null)
			qUpdate.setBoolean(ACTU_AUTO_EST_IND, pers.isActuAutoEstInd().booleanValue());
		else
			qUpdate.setNull(ACTU_AUTO_EST_IND, java.sql.Types.BOOLEAN);
		if (pers.getObsPrincipal() != null)
			qUpdate.setString(OBS_PRINCIPAL, pers.getObsPrincipal());
		else
			qUpdate.setNull(OBS_PRINCIPAL, java.sql.Types.VARCHAR);

		if (pers.getCaracter() != null)
			qUpdate.setInt(OID_CARACTER, pers.getCaracter().getOID());
		else
			qUpdate.setNull(OID_CARACTER, java.sql.Types.INTEGER);

		if (pers.getMarca() != null)
			qUpdate.setInt(OID_MARCA, pers.getMarca().getOID());
		else
			qUpdate.setNull(OID_MARCA, java.sql.Types.INTEGER);

		if (pers.getRasgo() != null)
			qUpdate.setInt(OID_RASGO, pers.getRasgo().getOID());
		else
			qUpdate.setNull(OID_RASGO, java.sql.Types.INTEGER);

		if (pers.getAnteojo() != null)
			qUpdate.setInt(OID_ANTEOJO, pers.getAnteojo().getOID());
		else
			qUpdate.setNull(OID_ANTEOJO, java.sql.Types.INTEGER);

		if (pers.getFotoPrincipal() != null)
			qUpdate.setInt(FOTO_PRINCIPAL, pers.getFotoPrincipal().intValue());
		else
			qUpdate.setNull(FOTO_PRINCIPAL, java.sql.Types.INTEGER);

		if (pers.getPeligrosidad() != null)
			qUpdate.setInt(OID_PELIGROSIDAD, pers.getPeligrosidad().getOID());
		else
			qUpdate.setNull(OID_PELIGROSIDAD, java.sql.Types.INTEGER);

		if (pers.getPredioExcluido() != null)
			qUpdate.setInt(OID_PREDIO, pers.getPredioExcluido().getOID());
		else
			qUpdate.setNull(OID_PREDIO, java.sql.Types.INTEGER);

		if (pers.getPredioFoto1() != null)
			qUpdate.setInt(OID_PREDIO_FOTO_1, pers.getPredioFoto1().getOID());
		else
			qUpdate.setNull(OID_PREDIO_FOTO_1, java.sql.Types.INTEGER);
		
		if (pers.getNroVersionFoto1() != null)
			qUpdate.setInt(NRO_VER_FOTO_1, pers.getNroVersionFoto1());
		else
			qUpdate.setNull(NRO_VER_FOTO_1, 0);
		
		if (pers.getNroVersionFoto2() != null)
			qUpdate.setInt(NRO_VER_FOTO_2, pers.getNroVersionFoto2());
		else
			qUpdate.setNull(NRO_VER_FOTO_2, 0);

		if (pers.getNroVersionFoto3() != null)
			qUpdate.setInt(NRO_VER_FOTO_3, pers.getNroVersionFoto3());
		else
			qUpdate.setNull(NRO_VER_FOTO_3, 0);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_INDIVIDUO = 1;
		IndividuoExcluido pers = (IndividuoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excIndividuo " + " set activo=0 " + " where " + " oid_individuo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INDIVIDUO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_INDIVIDUO = 1;
		IndividuoExcluido pers = (IndividuoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excIndividuo " + " set activo=1 " + " where " + " oid_individuo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INDIVIDUO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_CONS_MAS: {
			ps = this.selectByConsMasiva(aCondiciones);
			break;
		}
		case SELECT_NRO_DOCU: {
			ps = this.selectByNroDocu(aCondiciones);
			break;
		}
		case SELECT_BY_GRUPO_IMP: {
			ps = this.selectByGrupoImportacion(aCondiciones);
			break;
		}
		case SELECT_LOTE_BY_GRUPO_IMP: {
			ps = this.selectLoteByGrupoImportacion(aCondiciones);
			break;
		}
		case SELECT_LOTE_ALTA_BY_GRUPO_IMP_NRO_LOTE: {
			ps = this.selectLoteAltaByGrupoImportacion(aCondiciones);
			break;
		}
		case SELECT_LOTE_BAJA_BY_GRUPO_IMP_NRO_LOTE: {
			ps = this.selectLoteBajaByGrupoImportacion(aCondiciones);
			break;
		}
	      case UPDATE_NRO_LOTE_SINC: {
	    	  ps = this.updateNroLoteSinc(aCondiciones); 
	          break;    	  
	      }
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excIndividuo ");
		textSQL.append(" WHERE oid_individuo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_INDIVIDUO, oid);
		return querySelect;
	}

	private PreparedStatement selectByGrupoImportacion(Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		GrupoImportacionExcluido grupoImportacion = (GrupoImportacionExcluido) condiciones.get(GrupoImportacionExcluido.NICKNAME);
		Integer nroLote = (Integer) condiciones.get("NRO_LOTE");
		String tipoConsulta = (String) condiciones.get("TIPO_CONSULTA");
		
		StringBuffer textSQL = new StringBuffer();
		
		
		// Traer las novedades pero acotadas a las consultas correspondientes
		
		if (IndividuoExcluido.CON_NOV_EN_CONSULTA.equals(tipoConsulta)) {

			textSQL.append("SELECT * FROM  excIndividuo where 1=1 ");
			
			if (grupoImportacion!=null) {
				
				if (grupoImportacion.getTipo_individuo()!=null) {
					
					if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EMPLEADO))
						textSQL.append(" and tipo='"+IndividuoExcluido.TI_EMPLEADO+"' ");
					else if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EXTERNO))
						textSQL.append(" and tipo='"+IndividuoExcluido.TI_EXTERNO+"' "); 
				}
				
				if (grupoImportacion.getImportacionSoloEstados().size()>0) {
					
					String condEstados = " and oid_estado in (-1";
					Iterator iterImpSoloEst = 
						grupoImportacion.getImportacionSoloEstados().iterator();
					String condIN = "";
					while (iterImpSoloEst.hasNext()) {
						GrupoImportacionSoloEst grupoImportacionSoloEst = (GrupoImportacionSoloEst) iterImpSoloEst.next();
						condIN = condIN + ","+  grupoImportacionSoloEst.getEstado().getOIDInteger().toString();  
					}
					condEstados = condEstados+condIN+")";
					
					textSQL.append(condEstados); 
				}
				
			}
			
			Integer nuevoNroLote = nroLote.intValue()+1;
			textSQL.append(" and nro_lote_sinc>="+(nuevoNroLote.toString()));
			
			
		}
		
		
		if (IndividuoExcluido.CON_NOV_FUERA_CONSULTA.equals(tipoConsulta)) {
			
			Integer nuevoNroLote = nroLote.intValue()+1;
			
			textSQL.append("SELECT * FROM  excIndividuo where 1=1 ");
			textSQL.append(" and nro_lote_sinc>="+(nuevoNroLote.toString()));
			textSQL.append(" and oid_individuo not in ( SELECT oid_individuo FROM  excIndividuo where 1=1 ");
			
			if (grupoImportacion!=null) {
				
				if (grupoImportacion.getTipo_individuo()!=null) {
					
					if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EMPLEADO))
						textSQL.append(" and tipo='"+IndividuoExcluido.TI_EMPLEADO+"' ");
					else if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EXTERNO))
						textSQL.append(" and tipo='"+IndividuoExcluido.TI_EXTERNO+"' "); 
				}
				
				if (grupoImportacion.getImportacionSoloEstados().size()>0) {
					
					String condEstados = " and oid_estado in (-1";
					Iterator iterImpSoloEst = 
						grupoImportacion.getImportacionSoloEstados().iterator();
					String condIN = "";
					while (iterImpSoloEst.hasNext()) {
						GrupoImportacionSoloEst grupoImportacionSoloEst = (GrupoImportacionSoloEst) iterImpSoloEst.next();
						condIN = condIN + ","+  grupoImportacionSoloEst.getEstado().getOIDInteger().toString();  
					}
					condEstados = condEstados+condIN+")";
					
					textSQL.append(condEstados); 
				}
				
			}
			
			textSQL.append(" )");
			
		}		
		
		
		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		return querySelect;
	}	
	
	private PreparedStatement selectLoteByGrupoImportacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excIndividuo where activo=1 and 1=1");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		GrupoImportacionExcluido grupoImportacion = (GrupoImportacionExcluido) condiciones.get("GRUPO_IMPORTACION_EXC");
		String fechaUltAct = (String) condiciones.get("FECHA_ULT_ACT");
		
		if (grupoImportacion!=null) {
			
			if (grupoImportacion.getTipo_individuo()!=null) {
				
				if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EMPLEADO))
					textSQL.append(" and tipo='"+IndividuoExcluido.TI_EMPLEADO+"' ");
				else if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EXTERNO))
					textSQL.append(" and tipo='"+IndividuoExcluido.TI_EXTERNO+"' "); 
			}
			
			if (grupoImportacion.getImportacionSoloEstados().size()>0) {
				
				String condEstados = " and oid_estado in (-1";
				Iterator iterImpSoloEst = 
					grupoImportacion.getImportacionSoloEstados().iterator();
				String condIN = "";
				while (iterImpSoloEst.hasNext()) {
					GrupoImportacionSoloEst grupoImportacionSoloEst = (GrupoImportacionSoloEst) iterImpSoloEst.next();
					condIN = condIN + ","+  grupoImportacionSoloEst.getEstado().getOIDInteger().toString();  
				}
				condEstados = condEstados+condIN+")";
				
				textSQL.append(condEstados); 
			}
			
		}
		/*if (fechaUltAct!=null && fechaUltAct.length()>0)
		{
			textSQL.append(" AND FEC_ULT_MOD > TO_DATE('" + fechaUltAct+ " " + (horaUltAct==null?"":horaUltAct) + "','dd/mm/yyyy HH24:mi:ss' )");
		}*/
		
		if (fechaUltAct!=null)
		{
			textSQL.append(" AND ( ");
			textSQL.append(" 	( FEC_ULT_MOD >= TO_DATE('" + fechaUltAct + "','dd/mm/yyyy' ) )");//modificados
			textSQL.append(" 	OR ");
			textSQL.append(" 	(FEC_ALTA>= TO_DATE('" + fechaUltAct + "','dd/mm/yyyy' ))");//insertados
			textSQL.append(" )");
		}
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		return querySelect;
	}
	
	private PreparedStatement selectLoteAltaByGrupoImportacion(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		GrupoImportacionExcluido grupoImportacion = (GrupoImportacionExcluido) condiciones.get("GRUPO_IMPORTACION_EXC");
		Integer nroLote = (Integer) condiciones.get("NRO_LOTE");
		
		String campos = 
			" OID_INDIVIDUO,"
			+ "TIPO,"
			+ "APELLIDO,"
			+ "NOMBRE,"
			+ "OID_TIPO_DOCUMENTO,"
			+ "NRO_DOCUMENTO,"
			+ "SEXO,"
			+ "OID_RAZA,"
			+ "OID_ALTURA,"
			+ "OID_COMPLEXION,"
			+ "OID_EDAD,"
			+ "OID_COLOR,"
			+ "OID_TIPO_BARBA,"
			+ "OID_TIPO_CABELLO,"
			+ "OID_TIPO_NARIZ,"
			+ "ANTEOJOS,"
			+ "MARCAS,"
			+ "RASGOS,"
			+ "OID_ESTADO,"
			+ "OID_ESTADO_ANT,"
			+ "FEC_ESTADO,"
			+ "FEC_ESTADO_ANT,"
			+ "ACTIVO,"
			+ "OID_NOVEDAD,"
			+ "ACT_AUT_EST_IND,"
			+ "OBS_PRINCIPAL,"
			+ "OID_CARACTER,"
			+ "OID_MARCA,"
			+ "OID_RASGO,"
			+ "OID_ANTEOJO,"
			+ "OID_PELIGROSIDAD,"
			+ "OID_PREDIO,"
			+ "OID_PREDIO_FOTO_1";
		
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT " + campos + " FROM  excIndividuo ei where activo=1 and 1=1 ");
		
		if (grupoImportacion!=null) {
			
			if (grupoImportacion.getTipo_individuo()!=null) {
				
				if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EMPLEADO))
					textSQL.append(" and tipo='"+IndividuoExcluido.TI_EMPLEADO+"' ");
				else if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EXTERNO))
					textSQL.append(" and tipo='"+IndividuoExcluido.TI_EXTERNO+"' "); 
			}
			
			if (grupoImportacion.getImportacionSoloEstados().size()>0) {
				
				String condEstados = " and oid_estado in (-1";
				Iterator iterImpSoloEst = 
					grupoImportacion.getImportacionSoloEstados().iterator();
				String condIN = "";
				while (iterImpSoloEst.hasNext()) {
					GrupoImportacionSoloEst grupoImportacionSoloEst = (GrupoImportacionSoloEst) iterImpSoloEst.next();
					condIN = condIN + ","+  grupoImportacionSoloEst.getEstado().getOIDInteger().toString();  
				}
				condEstados = condEstados+condIN+")";
				
				textSQL.append(condEstados); 
			}
			
		}
		
		if (nroLote!=null)
		{
			textSQL.append(" MINUS SELECT " + campos + " from EXCLOTESINC es WHERE es.OID_LOTE_SINC = " + nroLote);
		}
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		return querySelect;
	}
	
	
	
	private PreparedStatement selectLoteBajaByGrupoImportacion(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		GrupoImportacionExcluido grupoImportacion = (GrupoImportacionExcluido) condiciones.get("GRUPO_IMPORTACION_EXC");
		Integer nroLote = (Integer) condiciones.get("NRO_LOTE");
		
		
		
		
		
		StringBuffer textSQL = new StringBuffer();
		
		if (nroLote!=null)
		{
			textSQL.append(" SELECT DISTINCT OID_INDIVIDUO from EXCLOTESINC es WHERE es.OID_LOTE_SINC = " + nroLote + " MINUS ");
		}
		
		textSQL.append("SELECT DISTINCT OID_INDIVIDUO FROM  excIndividuo ei where activo=1 and 1=1 ");
		
		if (grupoImportacion!=null) {
			
			if (grupoImportacion.getTipo_individuo()!=null) {
				
				if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EMPLEADO))
					textSQL.append(" and tipo='"+IndividuoExcluido.TI_EMPLEADO+"' ");
				else if (grupoImportacion.getTipo_individuo().equals(IndividuoExcluido.TI_EXTERNO))
					textSQL.append(" and tipo='"+IndividuoExcluido.TI_EXTERNO+"' "); 
			}
			
			if (grupoImportacion.getImportacionSoloEstados().size()>0) {
				
				String condEstados = " and oid_estado in (-1";
				Iterator iterImpSoloEst = 
					grupoImportacion.getImportacionSoloEstados().iterator();
				String condIN = "";
				while (iterImpSoloEst.hasNext()) {
					GrupoImportacionSoloEst grupoImportacionSoloEst = (GrupoImportacionSoloEst) iterImpSoloEst.next();
					condIN = condIN + ","+  grupoImportacionSoloEst.getEstado().getOIDInteger().toString();  
				}
				condEstados = condEstados+condIN+")";
				
				textSQL.append(condEstados); 
			}
			
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		return querySelect;
	}
	
	
	private PreparedStatement selectByNroDocu(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excIndividuo ");
		textSQL.append(" WHERE nro_documento = ? and oid_individuo<>? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String nroDocumento = (String) condiciones.get("NRO_DOCUMENTO");
		Integer oidIndividuo = (Integer) condiciones.get("OID_INDIVIDUO");
		querySelect.setString(1, nroDocumento);
		querySelect.setInt(2, oidIndividuo);
		return querySelect;
	}
	
	private void aplicarSeguridadEspecificaSegunPerfil(StringBuffer sql) throws BaseException {
		
		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		HashTableDatos perfiles = new HashTableDatos();
		
		// Guardar una lista de los perfiles funcionales del usuario Actual
		Iterator iterPerfilesFunc = usuario.getPerfilesFuncionales().iterator();
		while (iterPerfilesFunc.hasNext()) {
			PerfilFuncionalUsuario perfFunc = (PerfilFuncionalUsuario) iterPerfilesFunc.next();
			perfiles.put(perfFunc.getPerfilFuncion().getOIDInteger(), perfFunc);
		}
		
		String condGlobalPerfiles = "";
		
		// Recorrer todas las configuraciones de perfiles habilitadas
		Iterator iterPerfExcluidoPerfFunc = 
				PerfExcluidoPerfFunc.getAllActivos(this.getSesion()).iterator();
		while (iterPerfExcluidoPerfFunc.hasNext()) {
			PerfExcluidoPerfFunc perfExcluidoPerfFunc = (PerfExcluidoPerfFunc) iterPerfExcluidoPerfFunc.next();
			if ((perfiles.get(perfExcluidoPerfFunc.getPerfilfuncional().getOIDInteger())==null)) continue;
			
			String condFiltroPerfil = "";
			
			// Aplicar condiciones por Tipo
			String condPorTipo = "";
			if (!perfExcluidoPerfFunc.getSeguridadperfil().getTiposIndividuos().isEmpty()) {
				// Aplicar filtro por Tipos de Individuos
				Iterator iterTiposIndividuos = perfExcluidoPerfFunc.getSeguridadperfil().getTiposIndividuos().iterator();
				while (iterTiposIndividuos.hasNext()) {
					SeguExcTipoIndi seguExcTipoIndi = (SeguExcTipoIndi) iterTiposIndividuos.next();
					if (seguExcTipoIndi.isVisualiza()) {
						if (condPorTipo.length()>0)
							condPorTipo = condPorTipo + " or ";
						condPorTipo = condPorTipo + " a.tipo='"+seguExcTipoIndi.getTipo_individuo()+"' "; 
					}
				}
			}
			
			// Aplicar condiciones por Estado Actual
			String condPorEstado = "";
			if (!perfExcluidoPerfFunc.getSeguridadperfil().getEstadosActuales().isEmpty()) {
				// Aplicar filtro por Estados Actuales
				Iterator iterEstadosActuales = perfExcluidoPerfFunc.getSeguridadperfil().getEstadosActuales().iterator();
				while (iterEstadosActuales.hasNext()) {
					SeguExcEstadoActual seguExcEstadoActual = (SeguExcEstadoActual) iterEstadosActuales.next();
					if (seguExcEstadoActual.isVisualiza()) {
						if (condPorEstado.length()>0)
							condPorEstado = condPorEstado + " or ";
						condPorEstado = condPorEstado + " a.oid_estado="+seguExcEstadoActual.getEstado().getOIDInteger().toString()+" "; 
					}
				}
			}			
			
			
			// Aplicar condiciones de peligrosidad
			String condPorPeligrosidad = "";
			if (!perfExcluidoPerfFunc.getSeguridadperfil().getPeligrosidades().isEmpty()) {
				// Aplicar filtro por Peligrosidades
				Iterator iterPeligrosidades = perfExcluidoPerfFunc.getSeguridadperfil().getPeligrosidades().iterator();
				while (iterPeligrosidades.hasNext()) {
					SeguExcPeligrosidad seguExcPeligrosidad = (SeguExcPeligrosidad) iterPeligrosidades.next();
					if (seguExcPeligrosidad.isVisualiza()) {
						if (condPorPeligrosidad.length()>0)
							condPorPeligrosidad = condPorPeligrosidad + " or ";
						condPorPeligrosidad = condPorPeligrosidad + " a.oid_peligrosidad="+seguExcPeligrosidad.getPeligrosidad().getOIDInteger().toString()+" "; 
					}
				}
			}			
			
			
			// Aplicar condiciones en el Predio
			String condPorPredio = "";
			if (!perfExcluidoPerfFunc.getSeguridadperfil().getPredios().isEmpty()) {
				// Aplicar filtro por Predios
				Iterator iterPredios = perfExcluidoPerfFunc.getSeguridadperfil().getPredios().iterator();
				while (iterPredios.hasNext()) {
					SeguExcPredio seguExcPredio = (SeguExcPredio) iterPredios.next();
					if (seguExcPredio.isVisualiza()) {
						if (condPorPredio.length()>0)
							condPorPredio = condPorPredio + " or ";
						condPorPredio = condPorPredio + " a.predio="+seguExcPredio.getPredio().getOIDInteger().toString()+" "; 
					}
				}
			}		
			
			
			// Excluir si alguna vez tuvo esa novedad
			String condExcAlunaVezNov = "";
			if (!perfExcluidoPerfFunc.getSeguridadperfil().getEstadosAlgunaVez().isEmpty()) {
				// Aplicar filtro por Estados alguna Vez
				Iterator iterEstadosAlgunaVez = perfExcluidoPerfFunc.getSeguridadperfil().getEstadosAlgunaVez().iterator();
				while (iterEstadosAlgunaVez.hasNext()) {
					SeguExcEstAlgunaVez seguExcEstAlgunaVez = (SeguExcEstAlgunaVez) iterEstadosAlgunaVez.next();
					if (seguExcEstAlgunaVez.isVisualiza()) {
						if (condExcAlunaVezNov.length()==0) 
							condExcAlunaVezNov = condExcAlunaVezNov + " a.oid_individuo not in "+
										"(select zz1.oid_individuo from excIndividuo zz1 , excNovedades zz2 "+
										" where zz1.oid_individuo=zz2.oid_individuo and zz1.activo=1 and zz2.activo=1 and zz2.oid_estado in (-1";
						
						condExcAlunaVezNov = condExcAlunaVezNov + ","+seguExcEstAlgunaVez.getEstado().getOIDInteger().toString(); 
					}
				}
				if (condExcAlunaVezNov.length()>0) condExcAlunaVezNov = condExcAlunaVezNov + ")) ";
			}			
			
			
			// Armar filtro por Cada Perfil
			if (condPorTipo.length()!=0) {
				if (condFiltroPerfil.length()>0)
					condFiltroPerfil = condFiltroPerfil + " and ";
				condFiltroPerfil = condFiltroPerfil + " ("+condPorTipo+") ";
			}
			
			// 	Armar filtro por Estado
			if (condPorEstado.length()!=0) {
				if (condFiltroPerfil.length()>0)
					condFiltroPerfil = condFiltroPerfil + " and ";
				condFiltroPerfil = condFiltroPerfil + " ("+condPorEstado+") ";
			}		
		
			// 	Armar filtro por Peligrosidad
			if (condPorPeligrosidad.length()!=0) {
				if (condFiltroPerfil.length()>0)
					condFiltroPerfil = condFiltroPerfil + " and ";
				condFiltroPerfil = condFiltroPerfil + " ("+condPorPeligrosidad+") ";
			}		
		
			// 	Armar filtro por Predio
			if (condPorPredio.length()!=0) {
				if (condFiltroPerfil.length()>0)
					condFiltroPerfil = condFiltroPerfil + " and ";
				condFiltroPerfil = condFiltroPerfil + " ("+condPorPredio+") ";
			}		
		
			// 	Armar filtro Motivo Alguna Vez
			if (condExcAlunaVezNov.length()!=0) {
				if (condFiltroPerfil.length()>0)
					condFiltroPerfil = condFiltroPerfil + " and ";
				condFiltroPerfil = condFiltroPerfil + " ("+condExcAlunaVezNov+") ";
			}		
		
			if (condFiltroPerfil.length()>0) {
				if (condGlobalPerfiles.length()>0)
					condGlobalPerfiles = condGlobalPerfiles + " or ";
				condGlobalPerfiles = condGlobalPerfiles + " ("+condFiltroPerfil+") "; 
			}
			
		}
		
		// Ver si agregaron condiciones por Perfiles
		if (condGlobalPerfiles.length()>0) 
			sql.append(" and ("+condGlobalPerfiles+") ");
		
		
		
	}

	private PreparedStatement selectByConsMasiva(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer nroLote = (Integer) condiciones.get("NRO_LOTE");

		Boolean conActaRev = (Boolean) condiciones.get("con_acta_revocacion");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT a.*, (select nro_acta from excNovedades j where j.oid_novedad = a.oid_novedad) campo1 FROM  excIndividuo a ");
		if (nroLote != null)
			textSQL.append(" , excConsMasInd b ");

		if (condiciones.get("SIN_VIGENCIA_HASTA") != null)
			textSQL.append(" , excNovedades c ");

		if ((conActaRev != null) && (conActaRev.booleanValue()))
			textSQL.append(" , excNovedades d ");

		textSQL.append(" WHERE a.activo=1 ");

		if (condiciones.get("SIN_VIGENCIA_HASTA") != null) {
			textSQL.append(" and a.oid_novedad = c.oid_novedad and c.activo=1 and vig_hasta is null ");
		}

		if ((conActaRev != null) && (conActaRev.booleanValue()))
			textSQL.append(" and a.oid_novedad = d.oid_novedad and d.activo=1 and  ((d.nro_revocamiento is not null) or (d.nro_revocamiento<>'')) ");

		if ((AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1126, "", false, this.getSesion()) == true)
				&& (AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1127, "", false, this.getSesion()) == true)) {
			// NO HACER NINGUN FILTRO
		} else if ((AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1126, "", false, this.getSesion()) == false)
				&& (AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1127, "", false, this.getSesion()) == false)) {
			// textSQL.append(" and 1=-1 ");
		} else if (AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1126, "", false, this.getSesion()) == true) {
			textSQL.append(" and a.tipo='EMPLEADO' ");
		} else if (AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1127, "", false, this.getSesion()) == true) {
			textSQL.append(" and a.tipo='EXTERNO' ");
		}
		
		// Ver si hay que aplicar seguridad especifica segun perfil del usuario
		aplicarSeguridadEspecificaSegunPerfil(textSQL);
		
		
		

		if (nroLote != null)
			textSQL.append(" AND a.oid_individuo = b.oid_individuo  ");

		if (nroLote != null)
			textSQL.append("  AND b.nro_lote =" + nroLote.intValue());

		Integer nroOrdenDesde = (Integer) condiciones.get("NRO_ORDEN_DESDE");
		if (nroOrdenDesde != null)
			textSQL.append(" and b.nro_orden>=" + nroOrdenDesde.intValue());

		Integer nroOrdenHasta = (Integer) condiciones.get("NRO_ORDEN_HASTA");
		if (nroOrdenHasta != null)
			textSQL.append(" and b.nro_orden<=" + nroOrdenHasta.intValue());

		if (condiciones.containsKey(TipoDocumento.NICKNAME))
			textSQL.append(" and a.oid_tipo_documento=" + ((TipoDocumento) condiciones.get(TipoDocumento.NICKNAME)).getOID());

		if (condiciones.containsKey("NRO_DOCU"))
			textSQL.append(" and a.nro_documento like '%" + (String) condiciones.get("NRO_DOCU") + "%' ");

		if (condiciones.containsKey("TIPO"))
			textSQL.append(" and a.tipo ='" + (String) condiciones.get("TIPO") + "' ");

		if (condiciones.containsKey(IndividuoExcluido.NICKNAME)) {
			IndividuoExcluido indExc = (IndividuoExcluido) condiciones.get(IndividuoExcluido.NICKNAME);
			if (indExc != null)
				textSQL.append(" and a.oid_individuo =" + indExc.getOIDInteger().toString());
		}

		if (condiciones.containsKey("APELLIDO"))
			textSQL.append(" and a.apellido like '%" + (String) condiciones.get("APELLIDO") + "%' ");

		if (condiciones.containsKey("NOMBRE"))
			textSQL.append(" and a.nombre like '%" + (String) condiciones.get("NOMBRE") + "%' ");

		if (condiciones.containsKey("APODO"))
			textSQL.append(" and a.apodo like '%" + (String) condiciones.get("APODO") + "%' ");

		if (condiciones.containsKey(Nacionalidad.NICKNAME))
			textSQL.append(" and a.oid_nacionalidad=" + ((Nacionalidad) condiciones.get(Nacionalidad.NICKNAME)).getOID());

		if (condiciones.containsKey("LEGAJO"))
			textSQL.append(" and a.legajo like '%" + (String) condiciones.get("LEGAJO") + "%' ");

		if (condiciones.containsKey(SectorLegajoExcluido.NICKNAME))
			textSQL.append(" and a.oid_sector=" + ((SectorLegajoExcluido) condiciones.get(SectorLegajoExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(CargoLegajoExcluido.NICKNAME))
			textSQL.append(" and a.oid_cargo=" + ((CargoLegajoExcluido) condiciones.get(CargoLegajoExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey("TIPO_CONDICION"))
			textSQL.append(" and a.tipo_condicion = '" + (String) condiciones.get("TIPO_CONDICION") + "'");

		if (condiciones.containsKey("SEXO"))
			textSQL.append(" and a.sexo = '" + (String) condiciones.get("SEXO") + "'");

		if (condiciones.containsKey(RazaExcluido.NICKNAME))
			textSQL.append(" and a.oid_raza=" + ((RazaExcluido) condiciones.get(RazaExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(AlturaExcluido.NICKNAME))
			textSQL.append(" and a.oid_altura=" + ((AlturaExcluido) condiciones.get(AlturaExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(ComplexionExcluido.NICKNAME))
			textSQL.append(" and a.oid_complexion=" + ((ComplexionExcluido) condiciones.get(ComplexionExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(EdadExcluido.NICKNAME))
			textSQL.append(" and a.oid_edad=" + ((EdadExcluido) condiciones.get(EdadExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(ColorCabelloExcluido.NICKNAME))
			textSQL.append(" and a.oid_color=" + ((ColorCabelloExcluido) condiciones.get(ColorCabelloExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(CaracterExcluido.NICKNAME))
			textSQL.append(" and a.oid_caracter=" + ((CaracterExcluido) condiciones.get(CaracterExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(TipoBarba.NICKNAME))
			textSQL.append(" and a.oid_tipo_barba=" + ((TipoBarba) condiciones.get(TipoBarba.NICKNAME)).getOID());

		if (condiciones.containsKey(TipoCabelloExcluido.NICKNAME))
			textSQL.append(" and a.oid_tipo_cabello=" + ((TipoCabelloExcluido) condiciones.get(TipoCabelloExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(RasgoExcluido.NICKNAME))
			textSQL.append(" and a.oid_rasgo=" + ((RasgoExcluido) condiciones.get(RasgoExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(MarcaExcluido.NICKNAME))
			textSQL.append(" and a.oid_marca=" + ((MarcaExcluido) condiciones.get(MarcaExcluido.NICKNAME)).getOID());

		if (condiciones.containsKey(TipoNariz.NICKNAME))
			textSQL.append(" and a.oid_tipo_nariz=" + ((TipoNariz) condiciones.get(TipoNariz.NICKNAME)).getOID());

		if (condiciones.containsKey("ANTEOJOS"))
			textSQL.append(" and a.anteojos=" + ((Integer) condiciones.get("ANTEOJOS")).intValue());

		if (condiciones.containsKey("MARCAS"))
			textSQL.append(" and a.marcas like '%" + (String) condiciones.get("MARCAS") + "%' ");

		if (condiciones.containsKey("RASGOS"))
			textSQL.append(" and a.rasgos like '%" + (String) condiciones.get("RASGOS") + "%' ");

		if (condiciones.containsKey("OID_INDI_RELACIONADO")) {
			IndividuoExcluido indiExcRela = (IndividuoExcluido) condiciones.get("OID_INDI_RELACIONADO");
			textSQL.append(" and a.oid_individuo in (select oid_individuo from excRelIndi where activo=1 and oid_ind_rela=" + indiExcRela.getOIDInteger() + " ) ");
		}

		if (((condiciones.containsKey("DOMINIO")) || (condiciones.containsKey("MARCA_AUTO")) || (condiciones.containsKey("MODELO_AUTO")))) {
			textSQL.append(" and a.oid_individuo in (select oid_individuo from excVehiIndividuo a1, excVehiculos a2 where a1.oid_vehiculo = a2.oid_vehiculo and a1.activo=1 and a2.activo=1 ");
			String dominio = (String) condiciones.get("DOMINIO");
			if (dominio != null)
				textSQL.append(" and a2.dominio like '%" + dominio + "%'  ");

			String marcaAuto = (String) condiciones.get("MARCA_AUTO");
			if (marcaAuto != null)
				textSQL.append(" and a2.marca like '%" + marcaAuto + "%'  ");

			String modeloAuto = (String) condiciones.get("MODELO_AUTO");
			if (modeloAuto != null)
				textSQL.append(" and a2.modelo like '%" + modeloAuto + "%'  ");

			if (condiciones.containsKey(ColorExcluido.NICKNAME)) {
				ColorExcluido color = (ColorExcluido) condiciones.get(ColorExcluido.NICKNAME);
				textSQL.append(" and a2.oid_color =" + color.getOIDInteger() + "  ");
			}

			textSQL.append(" ) ");
		}

		String observacion = (String) condiciones.get("OBSERVACION");
		if (observacion != null) {

			// Observacion Principal
			StringBuffer obsPrincipal = new StringBuffer("");
			int i = 1;
			StringTokenizer st = new StringTokenizer(observacion, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken();
				if (i > 1)
					obsPrincipal.append(" and ");

				if (this.getSesion().getServicios().getValueParameter("tipoBD").equals(IPoolBD.ORACLE))
					obsPrincipal.append(" upper(a.obs_principal) like '%" + next.toUpperCase() + "%' ");
				else
					obsPrincipal.append(" a.obs_principal like '%" + next + "%' ");
				++i;
			}

			// Observacion Generales
			StringBuffer obsGeneral = new StringBuffer("");
			obsGeneral.append(" a.oid_individuo in ( select oid_individuo from excObsGenerales where activo=1 ");
			st = new StringTokenizer(observacion, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken();
				obsGeneral.append(" and ");
				if (this.getSesion().getServicios().getValueParameter("tipoBD").equals(IPoolBD.ORACLE))
					obsGeneral.append(" upper(observacion) like '%" + next.toUpperCase() + "%' ");
				else
					obsGeneral.append(" observacion like '%" + next + "%' ");
				++i;
			}
			obsGeneral.append(" ) ");

			// Observacion Novedades
			StringBuffer obsNovedades = new StringBuffer("");
			obsNovedades.append(" a.oid_individuo in ( select oid_individuo from excNovedades where activo=1 ");
			st = new StringTokenizer(observacion, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken();
				obsNovedades.append(" and ");
				if (this.getSesion().getServicios().getValueParameter("tipoBD").equals(IPoolBD.ORACLE))
					obsNovedades.append(" upper(observacion) like '%" + next.toUpperCase() + "%' ");
				else
					obsNovedades.append(" observacion like '%" + next + "%' ");
				++i;
			}
			obsNovedades.append(" ) ");

			// Armar query
			textSQL.append(" and ((" + obsPrincipal.toString() + ") or (" + obsGeneral.toString() + ") or (" + obsNovedades.toString() + "))");

		}

		if ((condiciones.containsKey("NRO_ACTA")) || (condiciones.containsKey("NRO_ACTA_REVO"))) {
			StringBuffer condNroActa = new StringBuffer("");
			Integer nroActa = null;
			if (condiciones.containsKey("NRO_ACTA"))
				nroActa = (Integer) condiciones.getInteger("NRO_ACTA");
			if (nroActa != null)
				condNroActa.append(" a.oid_individuo in (select oid_individuo from excNovedades where nro_acta=" + nroActa.toString() + " and activo=1) ");
			else
				condNroActa.append(" 1=2 ");

			StringBuffer condNroActaRevo = new StringBuffer("");
			Integer nroActaRevo = null;
			if (condiciones.containsKey("NRO_ACTA_REVO"))
				nroActaRevo = (Integer) condiciones.get("NRO_ACTA_REVO");
			if (nroActaRevo != null)
				condNroActaRevo.append(" a.oid_individuo in (select oid_individuo from excNovedades where nro_revocamiento=" + nroActaRevo.toString() + " and activo=1) ");
			else
				condNroActaRevo.append(" 1=2 ");

			textSQL.append(" and ((((" + condNroActa.toString() + ") or (" + condNroActaRevo.toString() + "))))");
		}

		if (condiciones.containsKey("LISTA_MOTIVOS")) {
			StringBuffer condMotivosIN = new StringBuffer("");
			List listaMotivos = (List) condiciones.get("LISTA_MOTIVOS");
			if (listaMotivos.size() > 0) {
				condMotivosIN.append("-1");
				Iterator iterMotivos = listaMotivos.iterator();
				while (iterMotivos.hasNext()) {
					MotivoNovedadExcluido motivo = (MotivoNovedadExcluido) iterMotivos.next();
					if (condMotivosIN.length() > 0)
						condMotivosIN.append(",");
					condMotivosIN.append(motivo.getOIDInteger());
				}
				//
				textSQL.append(" and a.oid_individuo in (select oid_individuo from excNovedades where activo=1 and oid_motivo in (" + condMotivosIN.toString() + ") ) ");
			}
		}

		if (condiciones.containsKey("COMPOR_ESTADO")) {
			StringBuffer condEstadosIN = new StringBuffer("");
			String comportamiento = (String) condiciones.get("COMPOR_ESTADO");
			if (comportamiento.equals("VIG")) {
				List listaEstados = (List) condiciones.get("LISTA_ESTADOS");
				if ((listaEstados != null) && (listaEstados.size() > 0)) {
					condEstadosIN.append("-1");
					Iterator iterEstados = listaEstados.iterator();
					while (iterEstados.hasNext()) {
						EstadoExcluido estado = (EstadoExcluido) iterEstados.next();
						if (condEstadosIN.length() > 0)
							condEstadosIN.append(",");
						condEstadosIN.append(estado.getOIDInteger());

					}
					textSQL.append(" and a.oid_estado in (" + condEstadosIN.toString() + ")  ");
				}
			}

			if (comportamiento.equals("EAO")) {
				List listaEstados = (List) condiciones.get("LISTA_ESTADOS");
				if ((listaEstados != null) && (listaEstados.size() > 0)) {
					condEstadosIN.append("-1");
					Iterator iterEstados = listaEstados.iterator();
					while (iterEstados.hasNext()) {
						EstadoExcluido estado = (EstadoExcluido) iterEstados.next();
						if (condEstadosIN.length() > 0)
							condEstadosIN.append(",");
						condEstadosIN.append(estado.getOIDInteger());

					}
					textSQL.append(" and a.oid_individuo in (select oid_individuo from excNovedades where activo=1 and oid_estado in (" + condEstadosIN.toString() + "))  ");
				}
			}

		}

		int nroParams = 0;
		java.util.Date fecAltaDesde = (java.util.Date) condiciones.get("FEC_ALTA_DESDE");
		if (fecAltaDesde != null)
			textSQL.append(" and a.fec_alta>=? ");

		java.util.Date fecAltaHasta = (java.util.Date) condiciones.get("FEC_ALTA_HASTA");
		if (fecAltaHasta != null)
			textSQL.append(" and a.fec_alta<=? ");

		/*
		 * Boolean conActaRev = (Boolean)
		 * condiciones.get("con_acta_revocacion"); if (conActaRev!=null) if
		 * (conActaRev.booleanValue())textSQL.append(
		 * " and ((a.nro_revocamiento is not null) or (a.nro_revocamiento<>'')) "
		 * );
		 */

		String filtroEstado = IndividuoExcluido.getFiltroEstadoExcluido(this.getSesion());
		if (!filtroEstado.equals(""))
			textSQL.append(" and a.oid_estado in (select oid_estado from excEstados where codigo in (" + filtroEstado + ")) ");

		String ordenarPor = (String) condiciones.get("ordenar_por");
		if (ordenarPor != null) {
			if (ordenarPor.equals("ACTA_DES"))
				textSQL.append(" order by campo1 ");
			else if (ordenarPor.equals("ACTA_ASC"))
				textSQL.append(" order by campo1 DESC ");
		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (fecAltaDesde != null) {
			++nroParams;
			querySelect.setDate(nroParams, new java.sql.Date(fecAltaDesde.getTime()));
		}

		if (fecAltaHasta != null) {
			++nroParams;
			querySelect.setDate(nroParams, new java.sql.Date(fecAltaHasta.getTime()));
		}

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excIndividuo ");
		textSQL.append(" WHERE tipo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		String caracter = "||";
		if (this.getSesion().getServicios().getServPoolBD(ServicioPoolBD.FILE_POOL_BD).getPoolBD().getTipoBD().equals(IPoolBD.MSSQLServer))
			caracter = "+";

		textSQL.append("SELECT oid_individuo oid,oid_individuo codigo, apellido" + caracter + "' '" + caracter + "nombre  descripcion ,activo ");
		textSQL.append(" from excIndividuo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from excIndividuo ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getConsultaMasiva(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_BY_CONS_MAS, condiciones, new ListObserver(), aSesion);
	}

	public static List getAllIndividuosExcluidos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_ALL, null, new ListObserver(), aSesion);
	}

	public static List getAllByTipoDocu(ISesion aSesion, Integer oidIndividuo, String nroDocumento) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_DOCUMENTO", nroDocumento);
		condiciones.put("OID_INDIVIDUO", oidIndividuo);
		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_NRO_DOCU, condiciones, new ListObserver(), aSesion);
	}

	public static List getAllByGrupoImportacion(ISesion aSesion, HashTableDatos condiciones) throws BaseException {
		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_BY_GRUPO_IMP, condiciones, new ListObserver(), aSesion);
	}
	
	/*public static List getNuevoLoteByGrupoImportacion(ISesion aSesion, GrupoImportacionExcluido grupoImportacion, String fechaUltAct) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("GRUPO_IMPORTACION_EXC", grupoImportacion);
		condiciones.put("FECHA_ULT_ACT", fechaUltAct);

		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_LOTE_BY_GRUPO_IMP, condiciones, new ListObserver(), aSesion);
	}*/
	
	public static List getLoteAltaByGrupoImportacion(ISesion aSesion, GrupoImportacionExcluido grupoImportacion, Integer nroLote) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("GRUPO_IMPORTACION_EXC", grupoImportacion);
		condiciones.put("NRO_LOTE", nroLote);

		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_LOTE_ALTA_BY_GRUPO_IMP_NRO_LOTE, condiciones, new ListObserver(), aSesion);
	}
	
	public static List getLoteBajaByGrupoImportacion(ISesion aSesion, GrupoImportacionExcluido grupoImportacion, Integer nroLote) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("GRUPO_IMPORTACION_EXC", grupoImportacion);
		condiciones.put("NRO_LOTE", nroLote);

		return (List) ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME, DBIndividuoExcluido.SELECT_LOTE_BAJA_BY_GRUPO_IMP_NRO_LOTE, condiciones, new ListObserver(), aSesion);
	}
	
	private PreparedStatement updateNroLoteSinc(Object aCondiciones) throws BaseException, SQLException {

		
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excIndividuo " + " set nro_lote_sinc=? " + " where " + " oid_individuo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer nroLote = (Integer) condiciones.get("NRO_LOTE");
		Integer oidIndividuo = (Integer) condiciones.get("OID_INDIVIDUO");
		
		qUpdate.setInt(1, nroLote.intValue());
		qUpdate.setInt(2, oidIndividuo.intValue());
		
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
	}
	
	  public static void actuNroLoteSinc(
			  Integer oidIndividuo,
			  Integer nroLote,
		      ISesion aSesion)
		  throws BaseException {
		    HashTableDatos condiciones = new HashTableDatos();
		    condiciones.put("NRO_LOTE", nroLote);
		    condiciones.put("OID_INDIVIDUO", oidIndividuo);
		  	ObjetoLogico.getObjects(IndividuoExcluido.NICKNAME,
			  				DBIndividuoExcluido.UPDATE_NRO_LOTE_SINC,
			  				condiciones,
			  				null,
			  				aSesion);
	  }
	  
		public static int getMaxNroLoteSinc(ISesion aSesion) throws BaseException {

			try {
				StringBuffer textSQL = new StringBuffer();

				textSQL.append("SELECT MAX(NRO_LOTE_SINC) NRO_LOTE FROM  excIndividuo ");

				PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

				ResultSet rs = querySelect.executeQuery();
				int nroLote = 0;
				if (rs.next())
					nroLote = rs.getInt(1);
				rs.close();
				querySelect.close();

				return nroLote;
			} catch (Exception e) {
				throw new BaseException(null, e.getMessage());
			}
		}
	  
	

}
