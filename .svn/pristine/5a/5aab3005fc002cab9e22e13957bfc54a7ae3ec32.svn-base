package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cip.bm.PermisoSemanalCIP;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBPermisoSemanalCIP extends DBObjetoPersistente {

	public static final String OID_PERM_SEMANAL = "oid_perm_semanal";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";
	public static final String ENT_HORA_LUN = "ent_hora_lun";
	public static final String MIN_ENT_ANT_LUN = "min_ent_ant_lun";
	public static final String MIN_ENT_DES_LUN = "min_ent_des_lun";
	public static final String TIPO_PER_ENT_LUN = "tipo_per_ent_lun";
	public static final String SAL_HORA_LUN = "sal_hora_lun";
	public static final String MIN_SAL_ANT_LUN = "min_sal_ant_lun";
	public static final String MIN_SAL_DES_LUN = "min_sal_des_lun";
	public static final String TIPO_PER_SAL_LUN = "tipo_per_sal_lun";
	public static final String ENT_HORA_MAR = "ent_hora_mar";
	public static final String MIN_ENT_ANT_MAR = "min_ent_ant_mar";
	public static final String MIN_ENT_DES_MAR = "min_ent_des_mar";
	public static final String TIPO_PER_ENT_MAR = "tipo_per_ent_mar";
	public static final String SAL_HORA_MAR = "sal_hora_mar";
	public static final String MIN_SAL_ANT_MAR = "min_sal_ant_mar";
	public static final String MIN_SAL_DES_MAR = "min_sal_des_mar";
	public static final String TIPO_PER_SAL_MAR = "tipo_per_sal_mar";
	public static final String ENT_HORA_MIE = "ent_hora_mie";
	public static final String MIN_ENT_ANT_MIE = "min_ent_ant_mie";
	public static final String MIN_ENT_DES_MIE = "min_ent_des_mie";
	public static final String TIPO_PER_ENT_MIE = "tipo_per_ent_mie";
	public static final String SAL_HORA_MIE = "sal_hora_mie";
	public static final String MIN_SAL_ANT_MIE = "min_sal_ant_mie";
	public static final String MIN_SAL_DES_MIE = "min_sal_des_mie";
	public static final String TIPO_PER_SAL_MIE = "tipo_per_sal_mie";
	public static final String ENT_HORA_JUV = "ent_hora_jue";
	public static final String MIN_ENT_ANT_JUE = "min_ent_ant_jue";
	public static final String MIN_ENT_DES_JUE = "min_ent_des_jue";
	public static final String TIPO_PER_ENT_JUE = "tipo_per_ent_jue";
	public static final String SAL_HORA_JUE = "sal_hora_jue";
	public static final String MIN_SAL_ANT_JUE = "min_sal_ant_jue";
	public static final String MIN_SAL_DES_JUE = "min_sal_des_jue";
	public static final String TIPO_PER_SAL_JUE = "tipo_per_sal_jue";
	public static final String ENT_HORA_VIE = "ent_hora_vie";
	public static final String MIN_ENT_ANT_VIE = "min_ent_ant_vie";
	public static final String MIN_ENT_DES_VIE = "min_ent_des_vie";
	public static final String TIPO_PER_ENT_VIE = "tipo_per_ent_vie";
	public static final String SAL_HORA_VIE = "sal_hora_vie";
	public static final String MIN_SAL_ANT_VIE = "min_sal_ant_vie";
	public static final String MIN_SAL_DES_VIE = "min_sal_des_vie";
	public static final String TIPO_PER_SAL_VIE = "tipo_per_sal_vie";
	public static final String ENT_HORA_SAB = "ent_hora_sab";
	public static final String MIN_ENT_ANT_SAB = "min_ent_ant_sab";
	public static final String MIN_ENT_DES_SAB = "min_ent_des_sab";
	public static final String TIPO_PER_ENT_SAB = "tipo_per_ent_sab";
	public static final String SAL_HORA_SAB = "sal_hora_sab";
	public static final String MIN_SAL_ANT_SAB = "min_sal_ant_sab";
	public static final String MIN_SAL_DES_SAB = "min_sal_des_sab";
	public static final String TIPO_PER_SAL_SAB = "tipo_per_sal_sab";
	public static final String ENT_HOR_DOM = "ent_hora_dom";
	public static final String MIN_ENT_ANT_DOM = "min_ent_ant_dom";
	public static final String MIN_ENT_DES_DOM = "min_ent_des_dom";
	public static final String TIPO_PER_ENT_DOM = "tipo_per_ent_dom";
	public static final String SAL_HOR_DOM = "sal_hora_dom";
	public static final String MIN_SAL_ANT_DOM = "min_sal_ant_dom";
	public static final String MIN_SAL_DES_DOM = "min_sal_des_dom";
	public static final String TIPO_PER_SAL_DOM = "tipo_per_sal_dom";
	
	public static final String LUN_LEY_NO_ING = "lun_ley_no_ing";
	public static final String MAR_LEY_NO_ING = "mar_ley_no_ing";
	public static final String MIE_LEY_NO_ING = "mie_ley_no_ing";
	public static final String JUE_LEY_NO_ING = "jue_ley_no_ing";
	public static final String VIE_LEY_NO_ING = "vie_ley_no_ing";
	public static final String SAB_LEY_NO_ING = "sab_ley_no_ing";
	public static final String DOM_LEY_NO_ING = "dom_ley_no_ing";
	
	public static final String LUN_LEY_NO_EGR = "lun_ley_no_egr";
	public static final String MAR_LEY_NO_EGR = "mar_ley_no_egr";
	public static final String MIE_LEY_NO_EGR = "mie_ley_no_egr";
	public static final String JUE_LEY_NO_EGR = "jue_ley_no_egr";
	public static final String VIE_LEY_NO_EGR = "vie_ley_no_egr";
	public static final String SAB_LEY_NO_EGR = "sab_ley_no_egr";
	public static final String DOM_LEY_NO_EGR = "dom_ley_no_egr";
	

	public DBPermisoSemanalCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PERM_SEMANAL = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int ENT_HORA_LUN = 5;
		final int MIN_ENT_ANT_LUN = 6;
		final int MIN_ENT_DES_LUN = 7;
		final int TIPO_PER_ENT_LUN = 8;
		final int SAL_HORA_LUN = 9;
		final int MIN_SAL_ANT_LUN = 10;
		final int MIN_SAL_DES_LUN = 11;
		final int TIPO_PER_SAL_LUN = 12;
		final int ENT_HORA_MAR = 13;
		final int MIN_ENT_ANT_MAR = 14;
		final int MIN_ENT_DES_MAR = 15;
		final int TIPO_PER_ENT_MAR = 16;
		final int SAL_HORA_MAR = 17;
		final int MIN_SAL_ANT_MAR = 18;
		final int MIN_SAL_DES_MAR = 19;
		final int TIPO_PER_SAL_MAR = 20;
		final int ENT_HORA_MIE = 21;
		final int MIN_ENT_ANT_MIE = 22;
		final int MIN_ENT_DES_MIE = 23;
		final int TIPO_PER_ENT_MIE = 24;
		final int SAL_HORA_MIE = 25;
		final int MIN_SAL_ANT_MIE = 26;
		final int MIN_SAL_DES_MIE = 27;
		final int TIPO_PER_SAL_MIE = 28;
		final int ENT_HORA_JUV = 29;
		final int MIN_ENT_ANT_JUE = 30;
		final int MIN_ENT_DES_JUE = 31;
		final int TIPO_PER_ENT_JUE = 32;
		final int SAL_HORA_JUE = 33;
		final int MIN_SAL_ANT_JUE = 34;
		final int MIN_SAL_DES_JUE = 35;
		final int TIPO_PER_SAL_JUE = 36;
		final int ENT_HORA_VIE = 37;
		final int MIN_ENT_ANT_VIE = 38;
		final int MIN_ENT_DES_VIE = 39;
		final int TIPO_PER_ENT_VIE = 40;
		final int SAL_HORA_VIE = 41;
		final int MIN_SAL_ANT_VIE = 42;
		final int MIN_SAL_DES_VIE = 43;
		final int TIPO_PER_SAL_VIE = 44;
		final int ENT_HORA_SAB = 45;
		final int MIN_ENT_ANT_SAB = 46;
		final int MIN_ENT_DES_SAB = 47;
		final int TIPO_PER_ENT_SAB = 48;
		final int SAL_HORA_SAB = 49;
		final int MIN_SAL_ANT_SAB = 50;
		final int MIN_SAL_DES_SAB = 51;
		final int TIPO_PER_SAL_SAB = 52;
		final int ENT_HOR_DOM = 53;
		final int MIN_ENT_ANT_DOM = 54;
		final int MIN_ENT_DES_DOM = 55;
		final int TIPO_PER_ENT_DOM = 56;
		final int SAL_HOR_DOM = 57;
		final int MIN_SAL_ANT_DOM = 58;
		final int MIN_SAL_DES_DOM = 59;
		final int TIPO_PER_SAL_DOM = 60;
		
		final int LUN_LEY_NO_ING = 61;
		final int MAR_LEY_NO_ING = 62;
		final int MIE_LEY_NO_ING = 63;
		final int JUE_LEY_NO_ING = 64;
		final int VIE_LEY_NO_ING = 65;
		final int SAB_LEY_NO_ING = 66;
		final int DOM_LEY_NO_ING = 67;
		
		final int LUN_LEY_NO_EGR = 68;
		final int MAR_LEY_NO_EGR = 69;
		final int MIE_LEY_NO_EGR = 70;
		final int JUE_LEY_NO_EGR = 71;
		final int VIE_LEY_NO_EGR = 72;
		final int SAB_LEY_NO_EGR = 73;
		final int DOM_LEY_NO_EGR = 74;
		

		PermisoSemanalCIP pers = (PermisoSemanalCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPermisoSemanal " + " ( " + "OID_PERM_SEMANAL," + "CODIGO," + "DESCRIPCION," + "ACTIVO,"
				+ "ENT_HORA_LUN," + "MIN_ENT_ANT_LUN," + "MIN_ENT_DES_LUN," + "TIPO_PER_ENT_LUN," + "SAL_HORA_LUN," + "MIN_SAL_ANT_LUN,"
				+ "MIN_SAL_DES_LUN," + "TIPO_PER_SAL_LUN," + "ENT_HORA_MAR," + "MIN_ENT_ANT_MAR," + "MIN_ENT_DES_MAR,"
				+ "TIPO_PER_ENT_MAR," + "SAL_HORA_MAR," + "MIN_SAL_ANT_MAR," + "MIN_SAL_DES_MAR," + "TIPO_PER_SAL_MAR," + "ENT_HORA_MIE,"
				+ "MIN_ENT_ANT_MIE," + "MIN_ENT_DES_MIE," + "TIPO_PER_ENT_MIE," + "SAL_HORA_MIE," + "MIN_SAL_ANT_MIE," + "MIN_SAL_DES_MIE,"
				+ "TIPO_PER_SAL_MIE," + "ENT_HORA_JUE," + "MIN_ENT_ANT_JUE," + "MIN_ENT_DES_JUE," + "TIPO_PER_ENT_JUE," + "SAL_HORA_JUE,"
				+ "MIN_SAL_ANT_JUE," + "MIN_SAL_DES_JUE," + "TIPO_PER_SAL_JUE," + "ENT_HORA_VIE," + "MIN_ENT_ANT_VIE," + "MIN_ENT_DES_VIE,"
				+ "TIPO_PER_ENT_VIE," + "SAL_HORA_VIE," + "MIN_SAL_ANT_VIE," + "MIN_SAL_DES_VIE," + "TIPO_PER_SAL_VIE," + "ENT_HORA_SAB,"
				+ "MIN_ENT_ANT_SAB," + "MIN_ENT_DES_SAB," + "TIPO_PER_ENT_SAB," + "SAL_HORA_SAB," + "MIN_SAL_ANT_SAB," + "MIN_SAL_DES_SAB,"
				+ "TIPO_PER_SAL_SAB," + "ENT_HORA_DOM," + "MIN_ENT_ANT_DOM," + "MIN_ENT_DES_DOM," + "TIPO_PER_ENT_DOM," + "SAL_HORA_DOM,"
				+ "MIN_SAL_ANT_DOM," + "MIN_SAL_DES_DOM," + "TIPO_PER_SAL_DOM,"+
				"lun_ley_no_ing,mar_ley_no_ing,mie_ley_no_ing,jue_ley_no_ing,vie_ley_no_ing,sab_ley_no_ing,dom_ley_no_ing,"
				+"lun_ley_no_egr,mar_ley_no_egr,mie_ley_no_egr,jue_ley_no_egr,vie_ley_no_egr,sab_ley_no_egr,dom_ley_no_egr) "
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PERM_SEMANAL, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getEnt_hora_lun()!=null)
			qInsert.setString(ENT_HORA_LUN, pers.getEnt_hora_lun());
		else
			qInsert.setString(ENT_HORA_LUN, "");
		if (pers.getMin_ent_ant_lun()!=null)
			qInsert.setInt(MIN_ENT_ANT_LUN, pers.getMin_ent_ant_lun().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_LUN, 0);
		if (pers.getMin_ent_des_lun()!=null)
			qInsert.setInt(MIN_ENT_DES_LUN, pers.getMin_ent_des_lun().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_LUN, 0);
		if (pers.getTipo_per_ent_lun()!=null)
			qInsert.setString(TIPO_PER_ENT_LUN, pers.getTipo_per_ent_lun());
		else
			qInsert.setString(TIPO_PER_ENT_LUN, "");
		if (pers.getSal_hora_lun()!=null)
			qInsert.setString(SAL_HORA_LUN, pers.getSal_hora_lun());
		else
			qInsert.setString(SAL_HORA_LUN, "");
		if (pers.getMin_sal_ant_lun()!=null)
			qInsert.setInt(MIN_SAL_ANT_LUN, pers.getMin_sal_ant_lun().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_LUN, 0);
		if (pers.getMin_sal_des_lun()!=null)
			qInsert.setInt(MIN_SAL_DES_LUN, pers.getMin_sal_des_lun().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_LUN, 0);
		if (pers.getTipo_per_sal_lun()!=null)
			qInsert.setString(TIPO_PER_SAL_LUN, pers.getTipo_per_sal_lun());
		else
			qInsert.setString(TIPO_PER_SAL_LUN, "");
		if (pers.getEnt_hora_mar()!=null)
			qInsert.setString(ENT_HORA_MAR, pers.getEnt_hora_mar());
		else
			qInsert.setString(ENT_HORA_MAR, "");
		if (pers.getMin_ent_ant_mar()!=null)
			qInsert.setInt(MIN_ENT_ANT_MAR, pers.getMin_ent_ant_mar().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_MAR, 0);
		if (pers.getMin_ent_des_mar()!=null)
			qInsert.setInt(MIN_ENT_DES_MAR, pers.getMin_ent_des_mar().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_MAR, 0);
		if (pers.getTipo_per_ent_mar()!=null)
			qInsert.setString(TIPO_PER_ENT_MAR, pers.getTipo_per_ent_mar());
		else
			qInsert.setString(TIPO_PER_ENT_MAR, "");
		if (pers.getSal_hora_mar()!=null)
			qInsert.setString(SAL_HORA_MAR, pers.getSal_hora_mar());
		else
			qInsert.setString(SAL_HORA_MAR, "");
		if (pers.getMin_sal_ant_mar()!=null)
			qInsert.setInt(MIN_SAL_ANT_MAR, pers.getMin_sal_ant_mar().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_MAR, 0);
		if (pers.getMin_sal_des_mar()!=null)
			qInsert.setInt(MIN_SAL_DES_MAR, pers.getMin_sal_des_mar().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_MAR, 0);
		if (pers.getTipo_per_sal_mar()!=null)
			qInsert.setString(TIPO_PER_SAL_MAR, pers.getTipo_per_sal_mar());
		else
			qInsert.setString(TIPO_PER_SAL_MAR, "");
		if (pers.getEnt_hora_mie()!=null)
			qInsert.setString(ENT_HORA_MIE, pers.getEnt_hora_mie());
		else
			qInsert.setString(ENT_HORA_MIE, "");
		if (pers.getMin_ent_ant_mie()!=null)
			qInsert.setInt(MIN_ENT_ANT_MIE, pers.getMin_ent_ant_mie().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_MIE, 0);
		if (pers.getMin_ent_des_mie()!=null)
			qInsert.setInt(MIN_ENT_DES_MIE, pers.getMin_ent_des_mie().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_MIE, 0);
		if (pers.getTipo_per_ent_mie()!=null)
			qInsert.setString(TIPO_PER_ENT_MIE, pers.getTipo_per_ent_mie());
		else
			qInsert.setString(TIPO_PER_ENT_MIE, "");
		if (pers.getSal_hora_mie()!=null)
			qInsert.setString(SAL_HORA_MIE, pers.getSal_hora_mie());
		else
			qInsert.setString(SAL_HORA_MIE, "");
		if (pers.getMin_sal_ant_mie()!=null)
			qInsert.setInt(MIN_SAL_ANT_MIE, pers.getMin_sal_ant_mie().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_MIE, 0);
		if (pers.getMin_sal_des_mie()!=null)
			qInsert.setInt(MIN_SAL_DES_MIE, pers.getMin_sal_des_mie().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_MIE, 0);
		if (pers.getTipo_per_sal_mie()!=null)
			qInsert.setString(TIPO_PER_SAL_MIE, pers.getTipo_per_sal_mie());
		else
			qInsert.setString(TIPO_PER_SAL_MIE, "");
		if (pers.getEnt_hora_juv()!=null)
			qInsert.setString(ENT_HORA_JUV, pers.getEnt_hora_juv());
		else
			qInsert.setString(ENT_HORA_JUV, "");
		if (pers.getMin_ent_ant_jue()!=null)
			qInsert.setInt(MIN_ENT_ANT_JUE, pers.getMin_ent_ant_jue().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_JUE, 0);
		if (pers.getMin_ent_des_jue()!=null)
			qInsert.setInt(MIN_ENT_DES_JUE, pers.getMin_ent_des_jue().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_JUE, 0);
		if (pers.getTipo_per_ent_jue()!=null)
			qInsert.setString(TIPO_PER_ENT_JUE, pers.getTipo_per_ent_jue());
		else
			qInsert.setString(TIPO_PER_ENT_JUE, "");
		if (pers.getSal_hora_jue()!=null)
			qInsert.setString(SAL_HORA_JUE, pers.getSal_hora_jue());
		else
			qInsert.setString(SAL_HORA_JUE, "");
		if (pers.getMin_sal_ant_jue()!=null)
			qInsert.setInt(MIN_SAL_ANT_JUE, pers.getMin_sal_ant_jue().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_JUE, 0);
		if (pers.getMin_sal_des_jue()!=null)
			qInsert.setInt(MIN_SAL_DES_JUE, pers.getMin_sal_des_jue().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_JUE, 0);
		if (pers.getTipo_per_sal_jue()!=null)
			qInsert.setString(TIPO_PER_SAL_JUE, pers.getTipo_per_sal_jue());
		else
			qInsert.setString(TIPO_PER_SAL_JUE, "");
		if (pers.getEnt_hora_vie()!=null)
			qInsert.setString(ENT_HORA_VIE, pers.getEnt_hora_vie());
		else
			qInsert.setString(ENT_HORA_VIE, "");
		if (pers.getMin_ent_ant_vie()!=null)
			qInsert.setInt(MIN_ENT_ANT_VIE, pers.getMin_ent_ant_vie().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_VIE, 0);
		if (pers.getMin_ent_des_vie()!=null)
			qInsert.setInt(MIN_ENT_DES_VIE, pers.getMin_ent_des_vie().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_VIE, 0);
		if (pers.getTipo_per_ent_vie()!=null)
			qInsert.setString(TIPO_PER_ENT_VIE, pers.getTipo_per_ent_vie());
		else
			qInsert.setString(TIPO_PER_ENT_VIE, "");
		if (pers.getSal_hora_vie()!=null)
			qInsert.setString(SAL_HORA_VIE, pers.getSal_hora_vie());
		else
			qInsert.setString(SAL_HORA_VIE, "");
		if (pers.getMin_sal_ant_vie()!=null)
			qInsert.setInt(MIN_SAL_ANT_VIE, pers.getMin_sal_ant_vie().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_VIE, 0);
		if (pers.getMin_sal_des_vie()!=null)
			qInsert.setInt(MIN_SAL_DES_VIE, pers.getMin_sal_des_vie().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_VIE, 0);
		if (pers.getTipo_per_sal_vie()!=null)
			qInsert.setString(TIPO_PER_SAL_VIE, pers.getTipo_per_sal_vie());
		else
			qInsert.setString(TIPO_PER_SAL_VIE, "");
		if (pers.getEnt_hora_sab()!=null)
			qInsert.setString(ENT_HORA_SAB, pers.getEnt_hora_sab());
		else
			qInsert.setString(ENT_HORA_SAB, "");
		if (pers.getMin_ent_ant_sab()!=null)
			qInsert.setInt(MIN_ENT_ANT_SAB, pers.getMin_ent_ant_sab().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_SAB, 0);
		if (pers.getMin_ent_des_sab()!=null)
			qInsert.setInt(MIN_ENT_DES_SAB, pers.getMin_ent_des_sab().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_SAB, 0);
		if (pers.getTipo_per_ent_sab()!=null)
			qInsert.setString(TIPO_PER_ENT_SAB, pers.getTipo_per_ent_sab());
		else
			qInsert.setString(TIPO_PER_ENT_SAB, "");
		if (pers.getSal_hora_sab()!=null)
			qInsert.setString(SAL_HORA_SAB, pers.getSal_hora_sab());
		else
			qInsert.setString(SAL_HORA_SAB, "");
		if (pers.getMin_sal_ant_sab()!=null)
			qInsert.setInt(MIN_SAL_ANT_SAB, pers.getMin_sal_ant_sab().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_SAB, 0);
		if (pers.getMin_sal_des_sab()!=null)
			qInsert.setInt(MIN_SAL_DES_SAB, pers.getMin_sal_des_sab().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_SAB, 0);
		if (pers.getTipo_per_sal_sab()!=null)
			qInsert.setString(TIPO_PER_SAL_SAB, pers.getTipo_per_sal_sab());
		else
			qInsert.setString(TIPO_PER_SAL_SAB, "");
		if (pers.getEnt_hor_dom()!=null)
			qInsert.setString(ENT_HOR_DOM, pers.getEnt_hor_dom());
		else
			qInsert.setString(ENT_HOR_DOM, "");
		if (pers.getMin_ent_ant_dom()!=null)
			qInsert.setInt(MIN_ENT_ANT_DOM, pers.getMin_ent_ant_dom().intValue());
		else
			qInsert.setInt(MIN_ENT_ANT_DOM, 0);
		if (pers.getMin_ent_des_dom()!=null)
			qInsert.setInt(MIN_ENT_DES_DOM, pers.getMin_ent_des_dom().intValue());
		else
			qInsert.setInt(MIN_ENT_DES_DOM, 0);
		if (pers.getTipo_per_ent_dom()!=null)
			qInsert.setString(TIPO_PER_ENT_DOM, pers.getTipo_per_ent_dom());
		else
			qInsert.setString(TIPO_PER_ENT_DOM, "");
		if (pers.getSal_hor_dom()!=null)
			qInsert.setString(SAL_HOR_DOM, pers.getSal_hor_dom());
		else
			qInsert.setString(SAL_HOR_DOM, "");
		if (pers.getMin_sal_ant_dom()!=null)
			qInsert.setInt(MIN_SAL_ANT_DOM, pers.getMin_sal_ant_dom().intValue());
		else
			qInsert.setInt(MIN_SAL_ANT_DOM, 0);
		if (pers.getMin_sal_des_dom()!=null)
			qInsert.setInt(MIN_SAL_DES_DOM, pers.getMin_sal_des_dom().intValue());
		else
			qInsert.setInt(MIN_SAL_DES_DOM, 0);
		if (pers.getTipo_per_sal_dom()!=null)
			qInsert.setString(TIPO_PER_SAL_DOM, pers.getTipo_per_sal_dom());
		else
			qInsert.setString(TIPO_PER_SAL_DOM, "");
		if (pers.getLunLeyNoIngresa()!=null)
			qInsert.setString(LUN_LEY_NO_ING,pers.getLunLeyNoIngresa());
		else
			qInsert.setString(LUN_LEY_NO_ING,"");
		if (pers.getMarLeyNoIngresa()!=null)
			qInsert.setString(MAR_LEY_NO_ING,pers.getMarLeyNoIngresa());
		else
			qInsert.setString(MAR_LEY_NO_ING,"");
		if (pers.getMieLeyNoIngresa()!=null)
			qInsert.setString(MIE_LEY_NO_ING,pers.getMieLeyNoIngresa());
		else
			qInsert.setString(MIE_LEY_NO_ING,"");
		if (pers.getJueLeyNoIngresa()!=null)
			qInsert.setString(JUE_LEY_NO_ING,pers.getJueLeyNoIngresa());
		else
			qInsert.setString(JUE_LEY_NO_ING,"");
		if (pers.getVieLeyNoIngresa()!=null)
			qInsert.setString(VIE_LEY_NO_ING,pers.getVieLeyNoIngresa());
		else
			qInsert.setString(VIE_LEY_NO_ING,"");
		if (pers.getSabLeyNoIngresa()!=null)
			qInsert.setString(SAB_LEY_NO_ING,pers.getSabLeyNoIngresa());
		else
			qInsert.setString(SAB_LEY_NO_ING,"");
		if (pers.getDomLeyNoIngresa()!=null)
			qInsert.setString(DOM_LEY_NO_ING,pers.getDomLeyNoIngresa());
		else
			qInsert.setString(DOM_LEY_NO_ING,"");
		
        if (pers.getLunLeyNoEgresa()!=null)
			qInsert.setString(LUN_LEY_NO_EGR,pers.getLunLeyNoEgresa());
		else
			qInsert.setString(LUN_LEY_NO_EGR,"");
		if (pers.getMarLeyNoEgresa()!=null)
			qInsert.setString(MAR_LEY_NO_EGR,pers.getMarLeyNoEgresa());
		else
			qInsert.setString(MAR_LEY_NO_EGR,"");
		if (pers.getMieLeyNoEgresa()!=null)
			qInsert.setString(MIE_LEY_NO_EGR,pers.getMieLeyNoEgresa());
		else
			qInsert.setString(MIE_LEY_NO_EGR,"");
		if (pers.getJueLeyNoEgresa()!=null)
			qInsert.setString(JUE_LEY_NO_EGR,pers.getJueLeyNoEgresa());
		else
			qInsert.setString(JUE_LEY_NO_EGR,"");
		if (pers.getVieLeyNoEgresa()!=null)
			qInsert.setString(VIE_LEY_NO_EGR,pers.getVieLeyNoEgresa());
		else
			qInsert.setString(VIE_LEY_NO_EGR,"");
		if (pers.getSabLeyNoEgresa()!=null)
			qInsert.setString(SAB_LEY_NO_EGR,pers.getSabLeyNoEgresa());
		else
			qInsert.setString(SAB_LEY_NO_EGR,"");
		if (pers.getDomLeyNoEgresa()!=null)
			qInsert.setString(DOM_LEY_NO_EGR,pers.getDomLeyNoEgresa());
		else
			qInsert.setString(DOM_LEY_NO_EGR,"");
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int ENT_HORA_LUN = 4;
		final int MIN_ENT_ANT_LUN = 5;
		final int MIN_ENT_DES_LUN = 6;
		final int TIPO_PER_ENT_LUN = 7;
		final int SAL_HORA_LUN = 8;
		final int MIN_SAL_ANT_LUN = 9;
		final int MIN_SAL_DES_LUN = 10;
		final int TIPO_PER_SAL_LUN = 11;
		final int ENT_HORA_MAR = 12;
		final int MIN_ENT_ANT_MAR = 13;
		final int MIN_ENT_DES_MAR = 14;
		final int TIPO_PER_ENT_MAR = 15;
		final int SAL_HORA_MAR = 16;
		final int MIN_SAL_ANT_MAR = 17;
		final int MIN_SAL_DES_MAR = 18;
		final int TIPO_PER_SAL_MAR = 19;
		final int ENT_HORA_MIE = 20;
		final int MIN_ENT_ANT_MIE = 21;
		final int MIN_ENT_DES_MIE = 22;
		final int TIPO_PER_ENT_MIE = 23;
		final int SAL_HORA_MIE = 24;
		final int MIN_SAL_ANT_MIE = 25;
		final int MIN_SAL_DES_MIE = 26;
		final int TIPO_PER_SAL_MIE = 27;
		final int ENT_HORA_JUV = 28;
		final int MIN_ENT_ANT_JUE = 29;
		final int MIN_ENT_DES_JUE = 30;
		final int TIPO_PER_ENT_JUE = 31;
		final int SAL_HORA_JUE = 32;
		final int MIN_SAL_ANT_JUE = 33;
		final int MIN_SAL_DES_JUE = 34;
		final int TIPO_PER_SAL_JUE = 35;
		final int ENT_HORA_VIE = 36;
		final int MIN_ENT_ANT_VIE = 37;
		final int MIN_ENT_DES_VIE = 38;
		final int TIPO_PER_ENT_VIE = 39;
		final int SAL_HORA_VIE = 40;
		final int MIN_SAL_ANT_VIE = 41;
		final int MIN_SAL_DES_VIE = 42;
		final int TIPO_PER_SAL_VIE = 43;
		final int ENT_HORA_SAB = 44;
		final int MIN_ENT_ANT_SAB = 45;
		final int MIN_ENT_DES_SAB = 46;
		final int TIPO_PER_ENT_SAB = 47;
		final int SAL_HORA_SAB = 48;
		final int MIN_SAL_ANT_SAB = 49;
		final int MIN_SAL_DES_SAB = 50;
		final int TIPO_PER_SAL_SAB = 51;
		final int ENT_HOR_DOM = 52;
		final int MIN_ENT_ANT_DOM = 53;
		final int MIN_ENT_DES_DOM = 54;
		final int TIPO_PER_ENT_DOM = 55;
		final int SAL_HOR_DOM = 56;
		final int MIN_SAL_ANT_DOM = 57;
		final int MIN_SAL_DES_DOM = 58;
		final int TIPO_PER_SAL_DOM = 59;
		
		final int LUN_LEY_NO_ING = 60;
		final int MAR_LEY_NO_ING = 61;
		final int MIE_LEY_NO_ING = 62;
		final int JUE_LEY_NO_ING = 63;
		final int VIE_LEY_NO_ING = 64;
		final int SAB_LEY_NO_ING = 65;
		final int DOM_LEY_NO_ING = 66;
		
		final int LUN_LEY_NO_EGR = 67;
		final int MAR_LEY_NO_EGR = 68;
		final int MIE_LEY_NO_EGR = 69;
		final int JUE_LEY_NO_EGR = 70;
		final int VIE_LEY_NO_EGR = 71;
		final int SAB_LEY_NO_EGR = 72;
		final int DOM_LEY_NO_EGR = 73;
		
		final int OID_PERM_SEMANAL = 74;

		PermisoSemanalCIP pers = (PermisoSemanalCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPermisoSemanal set " + "codigo=?" + ",descripcion=?" + ",activo=?" + ",ent_hora_lun=?"
				+ ",min_ent_ant_lun=?" + ",min_ent_des_lun=?" + ",tipo_per_ent_lun=?" + ",sal_hora_lun=?" + ",min_sal_ant_lun=?"
				+ ",min_sal_des_lun=?" + ",tipo_per_sal_lun=?" + ",ent_hora_mar=?" + ",min_ent_ant_mar=?" + ",min_ent_des_mar=?"
				+ ",tipo_per_ent_mar=?" + ",sal_hora_mar=?" + ",min_sal_ant_mar=?" + ",min_sal_des_mar=?" + ",tipo_per_sal_mar=?"
				+ ",ent_hora_mie=?" + ",min_ent_ant_mie=?" + ",min_ent_des_mie=?" + ",tipo_per_ent_mie=?" + ",sal_hora_mie=?"
				+ ",min_sal_ant_mie=?" + ",min_sal_des_mie=?" + ",tipo_per_sal_mie=?" + ",ent_hora_jue=?" + ",min_ent_ant_jue=?"
				+ ",min_ent_des_jue=?" + ",tipo_per_ent_jue=?" + ",sal_hora_jue=?" + ",min_sal_ant_jue=?" + ",min_sal_des_jue=?"
				+ ",tipo_per_sal_jue=?" + ",ent_hora_vie=?" + ",min_ent_ant_vie=?" + ",min_ent_des_vie=?" + ",tipo_per_ent_vie=?"
				+ ",sal_hora_vie=?" + ",min_sal_ant_vie=?" + ",min_sal_des_vie=?" + ",tipo_per_sal_vie=?" + ",ent_hora_sab=?"
				+ ",min_ent_ant_sab=?" + ",min_ent_des_sab=?" + ",tipo_per_ent_sab=?" + ",sal_hora_sab=?" + ",min_sal_ant_sab=?"
				+ ",min_sal_des_sab=?" + ",tipo_per_sal_sab=?" + ",ent_hora_dom=?" + ",min_ent_ant_dom=?" + ",min_ent_des_dom=?"
				+ ",tipo_per_ent_dom=?" + ",sal_hora_dom=?" + ",min_sal_ant_dom=?" + ",min_sal_des_dom=?" + ",tipo_per_sal_dom=?"
				+",lun_ley_no_ing=?,mar_ley_no_ing=?,mie_ley_no_ing=?,jue_ley_no_ing=?,vie_ley_no_ing=?,sab_ley_no_ing=?,dom_ley_no_ing=?,"
				+"lun_ley_no_egr=?,mar_ley_no_egr=?,mie_ley_no_egr=?,jue_ley_no_egr=?,vie_ley_no_egr=?,sab_ley_no_egr=?,dom_ley_no_egr=? "				
				+ " where " + " oid_perm_semanal=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_SEMANAL, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getEnt_hora_lun()!=null)
			qUpdate.setString(ENT_HORA_LUN, pers.getEnt_hora_lun());
		else
			qUpdate.setString(ENT_HORA_LUN, "");
		if (pers.getMin_ent_ant_lun()!=null)
			qUpdate.setInt(MIN_ENT_ANT_LUN, pers.getMin_ent_ant_lun().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_LUN, 0);
		if (pers.getMin_ent_des_lun()!=null)
			qUpdate.setInt(MIN_ENT_DES_LUN, pers.getMin_ent_des_lun().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_LUN, 0);
		
		if (pers.getTipo_per_ent_lun()!=null)
			qUpdate.setString(TIPO_PER_ENT_LUN, pers.getTipo_per_ent_lun());
		else
			qUpdate.setString(TIPO_PER_ENT_LUN, "");
		
		if (pers.getSal_hora_lun()!=null)
			qUpdate.setString(SAL_HORA_LUN, pers.getSal_hora_lun());
		else
			qUpdate.setString(SAL_HORA_LUN, "");
		if (pers.getMin_sal_ant_lun()!=null)
			qUpdate.setInt(MIN_SAL_ANT_LUN, pers.getMin_sal_ant_lun().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_LUN, 0);
		if (pers.getMin_sal_des_lun()!=null)
			qUpdate.setInt(MIN_SAL_DES_LUN, pers.getMin_sal_des_lun().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_LUN, 0);
		if (pers.getTipo_per_sal_lun()!=null)
			qUpdate.setString(TIPO_PER_SAL_LUN, pers.getTipo_per_sal_lun());
		else
			qUpdate.setString(TIPO_PER_SAL_LUN, "");
		if (pers.getEnt_hora_mar()!=null)
			qUpdate.setString(ENT_HORA_MAR, pers.getEnt_hora_mar());
		else
			qUpdate.setString(ENT_HORA_MAR, "");
		if (pers.getMin_ent_ant_mar()!=null)
			qUpdate.setInt(MIN_ENT_ANT_MAR, pers.getMin_ent_ant_mar().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_MAR, 0);
		if (pers.getMin_ent_des_mar()!=null)
			qUpdate.setInt(MIN_ENT_DES_MAR, pers.getMin_ent_des_mar().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_MAR, 0);
		if (pers.getTipo_per_ent_mar()!=null)
			qUpdate.setString(TIPO_PER_ENT_MAR, pers.getTipo_per_ent_mar());
		else
			qUpdate.setString(TIPO_PER_ENT_MAR, "");
		if (pers.getSal_hora_mar()!=null)
			qUpdate.setString(SAL_HORA_MAR, pers.getSal_hora_mar());
		else
			qUpdate.setString(SAL_HORA_MAR, "");
		if (pers.getMin_sal_ant_mar()!=null)
			qUpdate.setInt(MIN_SAL_ANT_MAR, pers.getMin_sal_ant_mar().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_MAR, 0);
		if (pers.getMin_sal_des_mar()!=null)
			qUpdate.setInt(MIN_SAL_DES_MAR, pers.getMin_sal_des_mar().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_MAR, 0);
		if (pers.getTipo_per_sal_mar()!=null)
			qUpdate.setString(TIPO_PER_SAL_MAR, pers.getTipo_per_sal_mar());
		else
			qUpdate.setString(TIPO_PER_SAL_MAR, "");
		if (pers.getEnt_hora_mie()!=null)
			qUpdate.setString(ENT_HORA_MIE, pers.getEnt_hora_mie());
		else
			qUpdate.setString(ENT_HORA_MIE, "");
		if (pers.getMin_ent_ant_mie()!=null)
			qUpdate.setInt(MIN_ENT_ANT_MIE, pers.getMin_ent_ant_mie().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_MIE, 0);
		if (pers.getMin_ent_des_mie()!=null)
			qUpdate.setInt(MIN_ENT_DES_MIE, pers.getMin_ent_des_mie().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_MIE, 0);
		if (pers.getTipo_per_ent_mie()!=null)
			qUpdate.setString(TIPO_PER_ENT_MIE, pers.getTipo_per_ent_mie());
		else
			qUpdate.setString(TIPO_PER_ENT_MIE, "");
		if (pers.getSal_hora_mie()!=null)
			qUpdate.setString(SAL_HORA_MIE, pers.getSal_hora_mie());
		else
			qUpdate.setString(SAL_HORA_MIE, "");
		if (pers.getMin_sal_ant_mie()!=null)
			qUpdate.setInt(MIN_SAL_ANT_MIE, pers.getMin_sal_ant_mie().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_MIE, 0);
		if (pers.getMin_sal_des_mie()!=null)
			qUpdate.setInt(MIN_SAL_DES_MIE, pers.getMin_sal_des_mie().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_MIE, 0);
		if (pers.getTipo_per_sal_mie()!=null)
			qUpdate.setString(TIPO_PER_SAL_MIE, pers.getTipo_per_sal_mie());
		else
			qUpdate.setString(TIPO_PER_SAL_MIE, "");
		if (pers.getEnt_hora_juv()!=null)
			qUpdate.setString(ENT_HORA_JUV, pers.getEnt_hora_juv());
		else
			qUpdate.setString(ENT_HORA_JUV, "");
		if (pers.getMin_ent_ant_jue()!=null)
			qUpdate.setInt(MIN_ENT_ANT_JUE, pers.getMin_ent_ant_jue().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_JUE, 0);
		if (pers.getMin_ent_des_jue()!=null)
			qUpdate.setInt(MIN_ENT_DES_JUE, pers.getMin_ent_des_jue().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_JUE, 0);
		if (pers.getTipo_per_ent_jue()!=null)
			qUpdate.setString(TIPO_PER_ENT_JUE, pers.getTipo_per_ent_jue());
		else
			qUpdate.setString(TIPO_PER_ENT_JUE, "");
		if (pers.getSal_hora_jue()!=null)
			qUpdate.setString(SAL_HORA_JUE, pers.getSal_hora_jue());
		else
			qUpdate.setString(SAL_HORA_JUE, "");
		if (pers.getMin_sal_ant_jue()!=null)
			qUpdate.setInt(MIN_SAL_ANT_JUE, pers.getMin_sal_ant_jue().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_JUE, 0);
		if (pers.getMin_sal_des_jue()!=null)
			qUpdate.setInt(MIN_SAL_DES_JUE, pers.getMin_sal_des_jue().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_JUE, 0);
		if (pers.getTipo_per_sal_jue()!=null)
			qUpdate.setString(TIPO_PER_SAL_JUE, pers.getTipo_per_sal_jue());
		else
			qUpdate.setString(TIPO_PER_SAL_JUE, "");
		if (pers.getEnt_hora_vie()!=null)
			qUpdate.setString(ENT_HORA_VIE, pers.getEnt_hora_vie());
		else
			qUpdate.setString(ENT_HORA_VIE, "");
		if (pers.getMin_ent_ant_vie()!=null)
			qUpdate.setInt(MIN_ENT_ANT_VIE, pers.getMin_ent_ant_vie().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_VIE, 0);
		if (pers.getMin_ent_des_vie()!=null)
			qUpdate.setInt(MIN_ENT_DES_VIE, pers.getMin_ent_des_vie().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_VIE, 0);
		if (pers.getTipo_per_ent_vie()!=null)
			qUpdate.setString(TIPO_PER_ENT_VIE, pers.getTipo_per_ent_vie());
		else
			qUpdate.setString(TIPO_PER_ENT_VIE, "");
		if (pers.getSal_hora_vie()!=null)
			qUpdate.setString(SAL_HORA_VIE, pers.getSal_hora_vie());
		else
			qUpdate.setString(SAL_HORA_VIE, "");
		if (pers.getMin_sal_ant_vie()!=null)
			qUpdate.setInt(MIN_SAL_ANT_VIE, pers.getMin_sal_ant_vie().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_VIE, 0);
		if (pers.getMin_sal_des_vie()!=null)
			qUpdate.setInt(MIN_SAL_DES_VIE, pers.getMin_sal_des_vie().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_VIE, 0);
		if (pers.getTipo_per_sal_vie()!=null)
			qUpdate.setString(TIPO_PER_SAL_VIE, pers.getTipo_per_sal_vie());
		else
			qUpdate.setString(TIPO_PER_SAL_VIE, "");
		if (pers.getEnt_hora_sab()!=null)
			qUpdate.setString(ENT_HORA_SAB, pers.getEnt_hora_sab());
		else
			qUpdate.setString(ENT_HORA_SAB, "");
		if (pers.getMin_ent_ant_sab()!=null)
			qUpdate.setInt(MIN_ENT_ANT_SAB, pers.getMin_ent_ant_sab().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_SAB, 0);
		if (pers.getMin_ent_des_sab()!=null)
			qUpdate.setInt(MIN_ENT_DES_SAB, pers.getMin_ent_des_sab().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_SAB, 0);
		if (pers.getTipo_per_ent_sab()!=null)
			qUpdate.setString(TIPO_PER_ENT_SAB, pers.getTipo_per_ent_sab());
		else
			qUpdate.setString(TIPO_PER_ENT_SAB, "");
		if (pers.getSal_hora_sab()!=null)
			qUpdate.setString(SAL_HORA_SAB, pers.getSal_hora_sab());
		else
			qUpdate.setString(SAL_HORA_SAB, "");
		if (pers.getMin_sal_ant_sab()!=null)
			qUpdate.setInt(MIN_SAL_ANT_SAB, pers.getMin_sal_ant_sab().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_SAB, 0);
		if (pers.getMin_sal_des_sab()!=null)
			qUpdate.setInt(MIN_SAL_DES_SAB, pers.getMin_sal_des_sab().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_SAB, 0);
		if (pers.getTipo_per_sal_sab()!=null)
			qUpdate.setString(TIPO_PER_SAL_SAB, pers.getTipo_per_sal_sab());
		else
			qUpdate.setString(TIPO_PER_SAL_SAB, "");
		if (pers.getEnt_hor_dom()!=null)
			qUpdate.setString(ENT_HOR_DOM, pers.getEnt_hor_dom());
		else
			qUpdate.setString(ENT_HOR_DOM, "");
		if (pers.getMin_ent_ant_dom()!=null)
			qUpdate.setInt(MIN_ENT_ANT_DOM, pers.getMin_ent_ant_dom().intValue());
		else
			qUpdate.setInt(MIN_ENT_ANT_DOM, 0);
		if (pers.getMin_ent_des_dom()!=null)
			qUpdate.setInt(MIN_ENT_DES_DOM, pers.getMin_ent_des_dom().intValue());
		else
			qUpdate.setInt(MIN_ENT_DES_DOM, 0);
		if (pers.getTipo_per_ent_dom()!=null)
			qUpdate.setString(TIPO_PER_ENT_DOM, pers.getTipo_per_ent_dom());
		else
			qUpdate.setString(TIPO_PER_ENT_DOM, "");
		if (pers.getSal_hor_dom()!=null)
			qUpdate.setString(SAL_HOR_DOM, pers.getSal_hor_dom());
		else
			qUpdate.setString(SAL_HOR_DOM, "");
		if (pers.getMin_sal_ant_dom()!=null)
			qUpdate.setInt(MIN_SAL_ANT_DOM, pers.getMin_sal_ant_dom().intValue());
		else
			qUpdate.setInt(MIN_SAL_ANT_DOM, 0);
		if (pers.getMin_sal_des_dom()!=null)
			qUpdate.setInt(MIN_SAL_DES_DOM, pers.getMin_sal_des_dom().intValue());
		else
			qUpdate.setInt(MIN_SAL_DES_DOM, 0);
		if (pers.getTipo_per_sal_dom()!=null)
			qUpdate.setString(TIPO_PER_SAL_DOM, pers.getTipo_per_sal_dom());
		else
			qUpdate.setString(TIPO_PER_SAL_DOM, "");
		
		if (pers.getLunLeyNoIngresa()!=null)
			qUpdate.setString(LUN_LEY_NO_ING,pers.getLunLeyNoIngresa());
		else
			qUpdate.setString(LUN_LEY_NO_ING,"");
		if (pers.getMarLeyNoIngresa()!=null)
			qUpdate.setString(MAR_LEY_NO_ING,pers.getMarLeyNoIngresa());
		else
			qUpdate.setString(MAR_LEY_NO_ING,"");
		if (pers.getMieLeyNoIngresa()!=null)
			qUpdate.setString(MIE_LEY_NO_ING,pers.getMieLeyNoIngresa());
		else
			qUpdate.setString(MIE_LEY_NO_ING,"");
		if (pers.getJueLeyNoIngresa()!=null)
			qUpdate.setString(JUE_LEY_NO_ING,pers.getJueLeyNoIngresa());
		else
			qUpdate.setString(JUE_LEY_NO_ING,"");
		if (pers.getVieLeyNoIngresa()!=null)
			qUpdate.setString(VIE_LEY_NO_ING,pers.getVieLeyNoIngresa());
		else
			qUpdate.setString(VIE_LEY_NO_ING,"");
		if (pers.getSabLeyNoIngresa()!=null)
			qUpdate.setString(SAB_LEY_NO_ING,pers.getSabLeyNoIngresa());
		else
			qUpdate.setString(SAB_LEY_NO_ING,"");
		if (pers.getDomLeyNoIngresa()!=null)
			qUpdate.setString(DOM_LEY_NO_ING,pers.getDomLeyNoIngresa());
		else
			qUpdate.setString(DOM_LEY_NO_ING,"");
		
        if (pers.getLunLeyNoEgresa()!=null)
        	qUpdate.setString(LUN_LEY_NO_EGR,pers.getLunLeyNoEgresa());
		else
			qUpdate.setString(LUN_LEY_NO_EGR,"");
		if (pers.getMarLeyNoEgresa()!=null)
			qUpdate.setString(MAR_LEY_NO_EGR,pers.getMarLeyNoEgresa());
		else
			qUpdate.setString(MAR_LEY_NO_EGR,"");
		if (pers.getMieLeyNoEgresa()!=null)
			qUpdate.setString(MIE_LEY_NO_EGR,pers.getMieLeyNoEgresa());
		else
			qUpdate.setString(MIE_LEY_NO_EGR,"");
		if (pers.getJueLeyNoEgresa()!=null)
			qUpdate.setString(JUE_LEY_NO_EGR,pers.getJueLeyNoEgresa());
		else
			qUpdate.setString(JUE_LEY_NO_EGR,"");
		if (pers.getVieLeyNoEgresa()!=null)
			qUpdate.setString(VIE_LEY_NO_EGR,pers.getVieLeyNoEgresa());
		else
			qUpdate.setString(VIE_LEY_NO_EGR,"");
		if (pers.getSabLeyNoEgresa()!=null)
			qUpdate.setString(SAB_LEY_NO_EGR,pers.getSabLeyNoEgresa());
		else
			qUpdate.setString(SAB_LEY_NO_EGR,"");
		if (pers.getDomLeyNoEgresa()!=null)
			qUpdate.setString(DOM_LEY_NO_EGR,pers.getDomLeyNoEgresa());
		else
			qUpdate.setString(DOM_LEY_NO_EGR,"");
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERM_SEMANAL = 1;
		PermisoSemanalCIP pers = (PermisoSemanalCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermisoSemanal " + " set activo=0 " + " where " + " oid_perm_semanal=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_SEMANAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERM_SEMANAL = 1;
		PermisoSemanalCIP pers = (PermisoSemanalCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermisoSemanal " + " set activo=1 " + " where " + " oid_perm_semanal=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_SEMANAL, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PERM_SEMANAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermisoSemanal ");
		textSQL.append(" WHERE oid_perm_semanal = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PERM_SEMANAL, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermisoSemanal ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_perm_semanal oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipPermisoSemanal");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
