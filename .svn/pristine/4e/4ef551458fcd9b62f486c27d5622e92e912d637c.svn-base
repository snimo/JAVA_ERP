package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.AccesoInternoPuerta;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
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

public class DBAccesoInternoPuerta extends DBObjetoPersistente {

	public static final String OID_ACC_INT_PUE = "oid_acc_int_pue";
	public static final String SECU = "secu";
	public static final String OID_REGLA_PERMISO = "oid_regla_permiso";
	public static final String OID_PUERTA = "oid_puerta";
	public static final String PRECOND_ENTRADA = "precond_entrada";
	public static final String TIPO_COMPO_ENTRA = "tipo_compo_entra";
	public static final String PRECOND_SALIDA = "precond_salida";
	public static final String TIPO_COMPO_SALI = "tipo_compo_sali";
	public static final String ACTIVO = "activo";
	public static final String MENSAJE_ENTRADA = "mensaje_entrada";
	public static final String MENSAJE_SALIDA = "mensaje_salida";
	public static final String TIPO_CTRL_FH_ENT = "tipo_ctrl_fh_ent";
	public static final String TIPO_CTRL_FH_SAL = "tipo_ctrl_fh_sal";
	public static final String MIN_ENT_ANT_FH_ENT = "min_ent_ant_fh_ent";
	public static final String MIN_ENT_DES_FH_ENT = "min_ent_des_fh_ent";
	public static final String MIN_ENT_ANT_FH_SAL = "min_ent_ant_fh_sal";
	public static final String MIN_ENT_DES_FH_SAL = "min_ent_des_fh_sal";
	public static final String SAL_SEXO = "sal_sexo";
	public static final String ENT_SEXO = "ent_sexo";
	
	
	public static final int SELECT_BY_REGLAS = 100;
	public static final int SELECT_BY_PUERTA_LEGAJO_REGLA = 101;
	

	public DBAccesoInternoPuerta() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ACC_INT_PUE = 1;
		final int SECU = 2;
		final int OID_REGLA_PERMISO = 3;
		final int OID_PUERTA = 4;
		final int PRECOND_ENTRADA = 5;
		final int TIPO_COMPO_ENTRA = 6;
		final int PRECOND_SALIDA = 7;
		final int TIPO_COMPO_SALI = 8;
		final int ACTIVO = 9;
		final int MENSAJE_ENTRADA = 10;
		final int MENSAJE_SALIDA = 11;
		final int TIPO_CTRL_FH_ENT = 12;
		final int TIPO_CTRL_FH_SAL = 13;
		final int MIN_ENT_ANT_FH_ENT = 14;
		final int MIN_ENT_DES_FH_ENT = 15;
		final int MIN_ENT_ANT_FH_SAL = 16;
		final int MIN_ENT_DES_FH_SAL = 17;
		final int SAL_SEXO = 18;
		final int ENT_SEXO = 19;

		AccesoInternoPuerta pers = (AccesoInternoPuerta) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into CIPAccIntPuertas " + " ( " + "OID_ACC_INT_PUE," + "SECU," + "OID_REGLA_PERMISO," + "OID_PUERTA," + "PRECOND_ENTRADA," + "TIPO_COMPO_ENTRA," + "PRECOND_SALIDA,"
				+ "TIPO_COMPO_SALI," + "ACTIVO , MENSAJE_ENTRADA , MENSAJE_SALIDA, TIPO_CTRL_FH_ENT, TIPO_CTRL_FH_SAL, MIN_ENT_ANT_FH_ENT, MIN_ENT_DES_FH_ENT, MIN_ENT_ANT_FH_SAL, MIN_ENT_DES_FH_SAL, SAL_SEXO, ENT_SEXO)" 
				+ " values " + "(" + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ACC_INT_PUE, pers.getOID());
		qInsert.setInt(SECU, pers.getSecu().intValue());
		qInsert.setInt(OID_REGLA_PERMISO, pers.getRegla().getOID());
		qInsert.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qInsert.setString(PRECOND_ENTRADA, pers.getPrecond_entrada());
		qInsert.setString(TIPO_COMPO_ENTRA, pers.getTipo_compo_entra());
		qInsert.setString(PRECOND_SALIDA, pers.getPrecond_salida());
		qInsert.setString(TIPO_COMPO_SALI, pers.getTipo_compo_sali());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMensajeEntrada()!=null)
			qInsert.setString(MENSAJE_ENTRADA, pers.getMensajeEntrada());
		else
			qInsert.setNull(MENSAJE_ENTRADA, Types.VARCHAR);
		if (pers.getMensajeSalida()!=null)
			qInsert.setString(MENSAJE_SALIDA, pers.getMensajeSalida());
		else
			qInsert.setNull(MENSAJE_SALIDA, Types.VARCHAR);
		
		if (pers.getMensajeEntrada()!=null)
			qInsert.setString(MENSAJE_ENTRADA, pers.getMensajeEntrada());
		else
			qInsert.setNull(MENSAJE_ENTRADA, Types.VARCHAR);
		if (pers.getMensajeSalida()!=null)
			qInsert.setString(MENSAJE_SALIDA, pers.getMensajeSalida());
		else
			qInsert.setNull(MENSAJE_SALIDA, Types.VARCHAR);
		if (pers.getTipoCtrlFhEnt()!=null)
			qInsert.setString(TIPO_CTRL_FH_ENT, pers.getTipoCtrlFhEnt());
		else
			qInsert.setString(TIPO_CTRL_FH_ENT, "");
		if (pers.getTipoCtrlFhSal()!=null)
			qInsert.setString(TIPO_CTRL_FH_SAL, pers.getTipoCtrlFhSal());
		else
			qInsert.setString(TIPO_CTRL_FH_SAL, "");
		if (pers.getMinEntAntFhEnt()!=null)
			qInsert.setInt(MIN_ENT_ANT_FH_ENT, pers.getMinEntAntFhEnt());
		else
			qInsert.setNull(MIN_ENT_ANT_FH_ENT, Types.INTEGER);
		if (pers.getMinEntDesFhEnt()!=null)
			qInsert.setInt(MIN_ENT_DES_FH_ENT, pers.getMinEntDesFhEnt());
		else
			qInsert.setNull(MIN_ENT_DES_FH_ENT, Types.INTEGER);
		if (pers.getMinEntAntFhSal()!=null)
			qInsert.setInt(MIN_ENT_ANT_FH_SAL, pers.getMinEntAntFhSal());
		else
			qInsert.setNull(MIN_ENT_ANT_FH_SAL, Types.INTEGER);
		if (pers.getMinEntDesFhSal()!=null)
			qInsert.setInt(MIN_ENT_DES_FH_SAL, pers.getMinEntDesFhSal());
		else
			qInsert.setNull(MIN_ENT_DES_FH_SAL, Types.INTEGER);		
		
		qInsert.setString(SAL_SEXO, pers.getSalSexo());
		qInsert.setString(ENT_SEXO, pers.getEntSexo());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int SECU = 1;
		final int OID_REGLA_PERMISO = 2;
		final int OID_PUERTA = 3;
		final int PRECOND_ENTRADA = 4;
		final int TIPO_COMPO_ENTRA = 5;
		final int PRECOND_SALIDA = 6;
		final int TIPO_COMPO_SALI = 7;
		final int ACTIVO = 8;
		final int MENSAJE_ENTRADA = 9;
		final int MENSAJE_SALIDA = 10;
		final int TIPO_CTRL_FH_ENT = 11;
		final int TIPO_CTRL_FH_SAL = 12;
		final int MIN_ENT_ANT_FH_ENT = 13;
		final int MIN_ENT_DES_FH_ENT = 14;
		final int MIN_ENT_ANT_FH_SAL = 15;
		final int MIN_ENT_DES_FH_SAL = 16;
		final int SAL_SEXO = 17;
		final int ENT_SEXO = 18;
		final int OID_ACC_INT_PUE = 19;

		AccesoInternoPuerta pers = (AccesoInternoPuerta) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update CIPAccIntPuertas set " + "secu=?" + ",oid_regla_permiso=?" + ",oid_puerta=?" + ",precond_entrada=?" + ",tipo_compo_entra=?" + ",precond_salida=?"
				+ ",tipo_compo_sali=?" + ",activo=? , mensaje_entrada = ? , mensaje_salida = ? ," 
				+ "TIPO_CTRL_FH_ENT = ?, TIPO_CTRL_FH_SAL = ?, MIN_ENT_ANT_FH_ENT = ?, MIN_ENT_DES_FH_ENT = ?, MIN_ENT_ANT_FH_SAL = ?, MIN_ENT_DES_FH_SAL = ?, SAL_SEXO = ?, ENT_SEXO = ?"
				+ " where " + " oid_acc_int_pue=?  ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACC_INT_PUE, pers.getOID());
		qUpdate.setInt(SECU, pers.getSecu().intValue());
		qUpdate.setInt(OID_REGLA_PERMISO, pers.getRegla().getOID());
		qUpdate.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qUpdate.setString(PRECOND_ENTRADA, pers.getPrecond_entrada());
		qUpdate.setString(TIPO_COMPO_ENTRA, pers.getTipo_compo_entra());
		qUpdate.setString(PRECOND_SALIDA, pers.getPrecond_salida());
		qUpdate.setString(TIPO_COMPO_SALI, pers.getTipo_compo_sali());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMensajeEntrada()!=null)
			qUpdate.setString(MENSAJE_ENTRADA, pers.getMensajeEntrada());
		else
			qUpdate.setNull(MENSAJE_ENTRADA, Types.VARCHAR);
		if (pers.getMensajeSalida()!=null)
			qUpdate.setString(MENSAJE_SALIDA, pers.getMensajeSalida());
		else
			qUpdate.setNull(MENSAJE_SALIDA, Types.VARCHAR);
		if (pers.getTipoCtrlFhEnt()!=null)
			qUpdate.setString(TIPO_CTRL_FH_ENT, pers.getTipoCtrlFhEnt());
		else
			qUpdate.setString(TIPO_CTRL_FH_ENT, "");
		if (pers.getTipoCtrlFhSal()!=null)
			qUpdate.setString(TIPO_CTRL_FH_SAL, pers.getTipoCtrlFhSal());
		else
			qUpdate.setString(TIPO_CTRL_FH_SAL, "");
		if (pers.getMinEntAntFhEnt()!=null)
			qUpdate.setInt(MIN_ENT_ANT_FH_ENT, pers.getMinEntAntFhEnt());
		else
			qUpdate.setNull(MIN_ENT_ANT_FH_ENT, Types.INTEGER);
		if (pers.getMinEntDesFhEnt()!=null)
			qUpdate.setInt(MIN_ENT_DES_FH_ENT, pers.getMinEntDesFhEnt());
		else
			qUpdate.setNull(MIN_ENT_DES_FH_ENT, Types.INTEGER);
		if (pers.getMinEntAntFhSal()!=null)
			qUpdate.setInt(MIN_ENT_ANT_FH_SAL, pers.getMinEntAntFhSal());
		else
			qUpdate.setNull(MIN_ENT_ANT_FH_SAL, Types.INTEGER);
		if (pers.getMinEntDesFhSal()!=null)
			qUpdate.setInt(MIN_ENT_DES_FH_SAL, pers.getMinEntDesFhSal());
		else
			qUpdate.setNull(MIN_ENT_DES_FH_SAL, Types.INTEGER);
		
		qUpdate.setString(SAL_SEXO, pers.getSalSexo());
		qUpdate.setString(ENT_SEXO, pers.getEntSexo());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ACC_INT_PUE = 1;
		AccesoInternoPuerta pers = (AccesoInternoPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update CIPAccIntPuertas " + " set activo=0 " + " where " + " oid_acc_int_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACC_INT_PUE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ACC_INT_PUE = 1;
		AccesoInternoPuerta pers = (AccesoInternoPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update CIPAccIntPuertas " + " set activo=1 " + " where " + " oid_acc_int_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACC_INT_PUE, pers.getOID());
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
		case SELECT_BY_REGLAS: {
			ps = this.selectByReglas(aCondiciones);
			break;			
		}
		case SELECT_BY_PUERTA_LEGAJO_REGLA: {
			ps = this.selectByPuertaLegajoRegla(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ACC_INT_PUE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CIPAccIntPuertas ");
		textSQL.append(" WHERE oid_acc_int_pue = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ACC_INT_PUE, oid);
		return querySelect;
	}

	
	private PreparedStatement selectByReglas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CIPAccIntPuertas ");
		textSQL.append(" WHERE oid_regla_permiso = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ReglasPermisosInt regla = (ReglasPermisosInt) aCondiciones;
		querySelect.setInt(1, regla.getOID());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByPuertaLegajoRegla(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ValorClasificadorEntidad valClasifEmp = legajo.getValorClasifEnt(clasifEmpresa);
		
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ValorClasificadorEntidad valClasifSec = legajo.getValorClasifEnt(clasifSector);
		
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ValorClasificadorEntidad valClasifPue = legajo.getValorClasifEnt(clasifPuesto);
		
					
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT "); 
		textSQL.append(" 		   c.* "); 
		textSQL.append(" 		FROM ");
		textSQL.append(" 		   cipPermisosInt a, ");
		textSQL.append(" 		   cipReglasPermisos b, ");
		textSQL.append(" 		   cipAccIntPuertas c ");
		textSQL.append(" 		where ");
		textSQL.append(" 		  a.oid_permiso_int = b.oid_permiso_int and "); 
		textSQL.append("          b.oid_regla_permiso = c.oid_regla_permiso and ");
		textSQL.append(" 		  a.activo=1 and "); 
		textSQL.append(" 		  b.activo=1 and ");
		textSQL.append(" 		  c.activo = 1 and ");
		textSQL.append(" 		  b.oid_regla_permiso = c.oid_regla_permiso and ");
		textSQL.append(" 		  c.oid_puerta = ? and exists ");
		textSQL.append(" 		    ( ");
		textSQL.append(" 		    select 1 from sys.dual where exists( ");  
		textSQL.append(" 		                              select ");
		textSQL.append(" 		                                oid_regla_permiso ");
		textSQL.append(" 		                              from ");
		textSQL.append(" 		                                cipPermIntLeg ");
		textSQL.append(" 		                              where ");
		textSQL.append(" 		                                activo=1 and oid_legajo=? and oid_regla_permiso=b.oid_regla_permiso ");
		textSQL.append(" 		                              ) ");
		textSQL.append(" 		                              OR ");
		textSQL.append(" 		                              ( ");
		textSQL.append(" 		                              exists (select 1 from sys.dual where 1=1) ");
		
		
		if (valClasifEmp!=null) {
			textSQL.append(" 		                              AND ");
			textSQL.append(" 		                              ( ");
			textSQL.append(" 		                              exists( ");
			textSQL.append(" 		                                select ");
			textSQL.append(" 		                                  oid_regla_permiso ");
			textSQL.append(" 		                                from ");
			textSQL.append(" 		                                  cipPermIntEmp ");
			textSQL.append(" 		                                where "); 
			textSQL.append(" 		                                  oid_regla_permiso=b.oid_regla_permiso and activo = 1 and oid_val_clasif_emp="+valClasifEmp.getOID()+" ");                                
			textSQL.append(" 		                              ) ");
			textSQL.append("                                     OR ");
			textSQL.append("                                       ((select count(*) from cipPermIntEmp where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append(" 		                              ) ");
		} else {
			textSQL.append(" 		                              AND ");
			textSQL.append("                                        ( "); 
			textSQL.append("                                        ((select count(*) from cipPermIntEmp where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append("                                        ) ");
		}
		
		
		if (valClasifSec!=null) {
			textSQL.append(" 		                              AND ");
			textSQL.append(" 		                              ( ");
			textSQL.append(" 		                              exists( ");
			textSQL.append(" 		                                select ");
			textSQL.append(" 		                                  oid_regla_permiso ");
			textSQL.append(" 		                                from ");
			textSQL.append(" 		                                  cipPermIntSec ");
			textSQL.append(" 		                                where "); 
			textSQL.append(" 		                                  oid_regla_permiso=b.oid_regla_permiso and activo = 1 and oid_val_clasif_sec="+valClasifSec.getOID()+" ");                                
			textSQL.append(" 		                              ) ");
			textSQL.append("                                     OR ");
			textSQL.append("                                       ((select count(*) from cipPermIntSec where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append(" 		                              ) ");
		} else {
			textSQL.append(" 		                              AND ");
			textSQL.append("                                        ( "); 
			textSQL.append("                                        ((select count(*) from cipPermIntSec where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append("                                        ) ");
		}		
		
		
		if (valClasifPue!=null) {
			textSQL.append(" 		                              AND ");
			textSQL.append(" 		                              ( ");
			textSQL.append(" 		                              exists( ");
			textSQL.append(" 		                                select ");
			textSQL.append(" 		                                  oid_regla_permiso ");
			textSQL.append(" 		                                from ");
			textSQL.append(" 		                                  cipPermIntPue ");
			textSQL.append(" 		                                where "); 
			textSQL.append(" 		                                  oid_regla_permiso=b.oid_regla_permiso and activo = 1 and oid_val_clasif_pue="+valClasifPue.getOID()+" ");                                
			textSQL.append(" 		                              ) ");
			textSQL.append("                                     OR ");
			textSQL.append("                                       ((select count(*) from cipPermIntPue where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append(" 		                              ) ");
		} else {
			textSQL.append(" 		                              AND ");
			textSQL.append("                                        ( "); 
			textSQL.append("                                        ((select count(*) from cipPermIntPue where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append("                                        ) ");
		}		
		
		/*
		if (valClasifSec!=null) {
			textSQL.append(" 		                              AND ");
			textSQL.append(" 		                              exists( ");
			textSQL.append(" 		                                select ");
			textSQL.append(" 		                                  oid_regla_permiso ");
			textSQL.append(" 		                                from ");
			textSQL.append(" 		                                  cipPermIntSec ");
			textSQL.append(" 		                                where "); 
			textSQL.append(" 		                                  oid_regla_permiso=b.oid_regla_permiso and activo = 1 and oid_val_clasif_sec="+valClasifSec.getOIDInteger()+" ");
			textSQL.append(" 		                              ) ");
		} else {
			textSQL.append(" 		                              AND exists (select 1 from sysdual where 1=2) ");
		}
		*/

		/*
		if (valClasifPue!=null) {
			textSQL.append(" 		                              AND ");
			textSQL.append(" 		                              exists( ");
			textSQL.append(" 		                                select ");
			textSQL.append(" 		                                  oid_regla_permiso ");
			textSQL.append(" 		                                from ");
			textSQL.append(" 		                                  cipPermIntPue ");
			textSQL.append(" 		                                where "); 
			textSQL.append(" 		                                    oid_regla_permiso=b.oid_regla_permiso and activo = 1 and oid_val_clasif_pue ="+valClasifPue.getOIDInteger()+" ");    
			textSQL.append(" 		                              ) ");
		} else {
			textSQL.append(" 		                              AND exists (select 1 from sysdual where 1=2) ");
		}*/
		
		
		if (legajo.getEstadoCIP()!=null) {
		
			textSQL.append(" 		                              AND ");
			textSQL.append(" 		                              exists( ");
			textSQL.append(" 		                                select ");
			textSQL.append(" 		                                  oid_regla_permiso ");
			textSQL.append(" 		                                from ");
			textSQL.append(" 		                                  cippermintest ");
			textSQL.append(" 		                                where ");
			textSQL.append(" 		                                  oid_regla_permiso=b.oid_regla_permiso and activo=1 and oid_estado_cip ="+legajo.getEstadoCIP().getOIDInteger()+" ");                              
			textSQL.append(" 		                              ) ");
		} else {
			textSQL.append(" 		                              AND ");
			textSQL.append("                                        ( "); 
			textSQL.append("                                        ((select count(*) from cipPermIntEst where activo=1 and oid_regla_permiso=b.oid_regla_permiso)=0) ");
			textSQL.append("                                        ) ");
		}
			
			
		textSQL.append(" 		                              ) ");    
		textSQL.append(" 		    ) ");
		textSQL.append(" 		order by ");
		textSQL.append(" 		  a.prioridad , b.prioridad , c.secu ");
			
				
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, puerta.getOID());
		querySelect.setInt(2, legajo.getOID());
		
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CIPAccIntPuertas ");
		textSQL.append(" WHERE secu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_acc_int_pue oid,secu codigo,  descripcion ,activo ");
		textSQL.append(" from CIPAccIntPuertas");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getAccesosInternosPuertas(
				ReglasPermisosInt regla,
				ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AccesoInternoPuerta.NICKNAME,
                 DBAccesoInternoPuerta.SELECT_BY_REGLAS,
                 regla,
                 new ListObserver(),
                 aSesion);
	}	
	
	public static List getAccesosInternosPuertasByLegajoPuerta(
			Puerta puerta,
			Legajo legajo,
			ISesion aSesion) throws BaseException {
	HashTableDatos condiciones = new HashTableDatos();
	condiciones.put(Legajo.NICKNAME, legajo);
	condiciones.put(Puerta.NICKNAME, puerta);
	return (List) ObjetoLogico.getObjects(AccesoInternoPuerta.NICKNAME,
             DBAccesoInternoPuerta.SELECT_BY_PUERTA_LEGAJO_REGLA,
             condiciones,
             new ListObserver(),
             aSesion);
	}	

}
