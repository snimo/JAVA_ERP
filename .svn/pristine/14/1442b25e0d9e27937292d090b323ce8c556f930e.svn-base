package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluidoSinc;



import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBIndividuoExcluidoSinc extends DBObjetoPersistente {
	
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
	public static final String FEC_ESTADO = "fec_estado";
	public static final String FOTO_PRINCIPAL = "foto_principal";
	public static final String OID_PELIGROSIDAD = "oid_peligrosidad";
	public static final String OID_PREDIO = "oid_predio";
	public static final String OID_PREDIO_FOTO_1 = "oid_predio_foto_1";
	public static final String OID_LOTE_SINC = "oid_lote_sinc";

	public static final int SELECT_LOTE_BY_NRO_LOTE = 100;

	public DBIndividuoExcluidoSinc() {
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
		final int OID_ESTADO = 25;
		final int OID_ESTADO_ANT = 26;
		final int FEC_ESTADO = 27;
		final int OID_LEGAJO = 28;
		final int ACTIVO = 29;
		final int OID_NOVEDAD = 30;
		final int ACTU_AUTO_EST_IND = 31;
		final int OBS_PRINCIPAL = 32;
		final int OID_CARACTER = 33;
		final int OID_MARCA = 34;
		final int OID_RASGO = 35;
		final int OID_ANTEOJO = 36;
		final int FEC_ALTA = 37;
		final int FOTO_PRINCIPAL = 38;
		final int OID_PELIGROSIDAD = 39;
		final int OID_PREDIO = 40;
		final int OID_PREDIO_FOTO_1 = 41;
		final int OID_LOTE_SINC = 42;
		

		IndividuoExcluidoSinc pers = (IndividuoExcluidoSinc) objetoPersistente;
		
		
		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into EXCLOTESINC "
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
						+ "OID_ESTADO,"
						+ "OID_ESTADO_ANT,"
						+ "FEC_ESTADO,"
						+ "OID_LEGAJO , ACTIVO , OID_NOVEDAD, ACT_AUT_EST_IND , OBS_PRINCIPAL , OID_CARACTER , OID_MARCA , OID_RASGO , OID_ANTEOJO , FEC_ALTA , FOTO_PRINCIPAL , OID_PELIGROSIDAD , OID_PREDIO , OID_PREDIO_FOTO_1, OID_LOTE_SINC)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

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
		
		if (pers.getEstado() != null)
			qInsert.setInt(OID_ESTADO, pers.getEstado().getOID());
		else
			qInsert.setNull(OID_ESTADO, java.sql.Types.INTEGER);
		
		if (pers.getEstado_anterior() != null)
			qInsert.setInt(OID_ESTADO_ANT, pers.getEstado_anterior().getOID());
		else
			qInsert.setNull(OID_ESTADO_ANT, java.sql.Types.INTEGER);
		
		
		if (pers.getLegajo() != null)
			qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qInsert.setNull(OID_LEGAJO, java.sql.Types.INTEGER);
		if (pers.isActivo() != null)
			qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		else
			qInsert.setBoolean(ACTIVO, false);
		
		
		if (pers.getNovedadExcluido() != null)
			qInsert.setInt(OID_NOVEDAD, pers.getNovedadExcluido().getOID());
		else
			qInsert.setNull(OID_NOVEDAD, java.sql.Types.INTEGER);
		
		
		

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
		
		if (pers.getFechaAlta() != null)
			qInsert.setDate(FEC_ALTA, new java.sql.Date(pers.getFechaAlta().getTime()));
		else
			qInsert.setNull(FEC_ALTA, java.sql.Types.DATE);
		
		if (pers.getFec_estado() != null)
			qInsert.setDate(FEC_ESTADO, new java.sql.Date(pers.getFec_estado().getTime()));
		else
			qInsert.setNull(FEC_ESTADO, java.sql.Types.DATE);

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
		
		//qInsert.setInt(OID_LOTE_SINC, pers.getNroLote());

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
		final int OID_INDIVIDUO = 36;
		final int OID_LOTE_SINC = 37;

		IndividuoExcluidoSinc pers = (IndividuoExcluidoSinc) objetoPersistente;
		
		
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate
				.append(" update EXCLOTESINC set "
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
						+ ",oid_legajo=? , activo=? , act_aut_est_ind = ? , obs_principal=? , oid_caracter=? , oid_marca=? , oid_rasgo=? , oid_anteojo = ? , foto_principal = ? , oid_peligrosidad = ? , oid_predio = ? , oid_predio_foto_1 = ? "
						+ " where " + " oid_individuo=? AND oid_lote_sinc = ?");

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
		//qUpdate.setInt(OID_LOTE_SINC, pers.getNroLote());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_INDIVIDUO = 1;
		final int OID_LOTE_SINC = 2;
		IndividuoExcluidoSinc pers = (IndividuoExcluidoSinc) objetoPersistente;

		
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update EXCLOTESINC " + " set activo=0 " + " where " + " oid_individuo=? AND oid_lote_sinc = ?");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		
		qUpdate.setInt(OID_INDIVIDUO, pers.getOID());
		//qUpdate.setInt(OID_LOTE_SINC, pers.getNroLote());
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
		
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_LOTE_BY_NRO_LOTE: {
			ps = this.getExcluidosByNroLote(aCondiciones);
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

	private PreparedStatement getExcluidosByNroLote(Object aCondiciones) throws BaseException, SQLException {
		final int OID_LOTE_SINC = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  EXCLOTESINC where oid_lote_sinc = ? ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer nroLote = condiciones.getInteger("NRO_LOTE");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(OID_LOTE_SINC, nroLote);
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

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from excIndividuo ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getExcluidosByNroLote(ISesion aSesion, Integer nroLote) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_LOTE", nroLote);
		return (List) ObjetoLogico.getObjects(IndividuoExcluidoSinc.NICKNAME, DBIndividuoExcluidoSinc.SELECT_LOTE_BY_NRO_LOTE, condiciones, new ListObserver(), aSesion);
	}

	@Override
	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
