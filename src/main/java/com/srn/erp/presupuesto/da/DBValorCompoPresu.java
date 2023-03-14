package com.srn.erp.presupuesto.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValorCompoPresu extends DBObjetoPersistente {

	public static final String	OID_VALOR_COMPO				= "oid_valor_compo";

	public static final String	CODIGO								= "codigo";

	public static final String	DESCRIPCION						= "descripcion";

	public static final String	NRO_REL								= "nro_rel";

	public static final String	NRO_REL_PADRE					= "nro_rel_padre";

	public static final String	ACTIVO								= "activo";

	public static final String	OID_COMPO_PRESU				= "oid_compo_presu";

	public static final String	OID_VAL_COM_1					= "oid_val_com_1";

	public static final String	OID_VAL_COM_2					= "oid_val_com_2";

	public static final String	OID_VAL_COM_3					= "oid_val_com_3";

	public static final String	OID_VAL_COM_4					= "oid_val_com_4";

	public static final String	OID_VAL_COM_5					= "oid_val_com_5";

	public static final String	OID_VAL_COM_6					= "oid_val_com_6";

	public static final String	OID_VAL_COM_7					= "oid_val_com_7";

	public static final String	OID_VAL_COM_8					= "oid_val_com_8";

	public static final String	OID_VAL_COM_9					= "oid_val_com_9";

	public static final String	OID_VAL_COM_10				= "oid_val_com_10";

	public static final String	OID_VAL_COM_11				= "oid_val_com_11";

	public static final String	OID_VAL_COM_12				= "oid_val_com_12";

	public static final String	OID_VAL_COM_13				= "oid_val_com_13";

	public static final String	OID_VAL_COM_14				= "oid_val_com_14";

	public static final String	OID_VAL_COM_15				= "oid_val_com_15";

	public static final String	OID_VAL_COM_16				= "oid_val_com_16";

	public static final String	OID_VAL_COM_17				= "oid_val_com_17";

	public static final String	OID_VAL_COM_18				= "oid_val_com_18";

	public static final String	OID_VAL_COM_19				= "oid_val_com_19";

	public static final String	OID_VAL_COM_20				= "oid_val_com_20";

	public static final String	OID_VAL_COM_21				= "oid_val_com_21";

	public static final String	OID_VAL_COM_22				= "oid_val_com_22";

	public static final String	OID_VAL_COM_23				= "oid_val_com_23";

	public static final String	OID_VAL_COM_24				= "oid_val_com_24";

	public static final String	OID_VAL_COM_25				= "oid_val_com_25";

	public static final String	OID_VAL_COM_26				= "oid_val_com_26";

	public static final String	OID_VAL_COM_27				= "oid_val_com_27";

	public static final String	OID_VAL_COM_28				= "oid_val_com_28";

	public static final String	OID_VAL_COM_29				= "oid_val_com_29";

	public static final String	OID_VAL_COM_30				= "oid_val_com_30";

	public static final String	OID_VAL_COM_31				= "oid_val_com_31";

	public static final String	OID_VAL_COM_32				= "oid_val_com_32";

	public static final String	OID_VAL_COM_33				= "oid_val_com_33";

	public static final String	OID_VAL_COM_34				= "oid_val_com_34";

	public static final String	OID_VAL_COM_35				= "oid_val_com_35";

	public static final String	OID_VAL_COM_36				= "oid_val_com_36";

	public static final String	OID_VAL_COM_37				= "oid_val_com_37";

	public static final String	OID_VAL_COM_38				= "oid_val_com_38";

	public static final String	OID_VAL_COM_39				= "oid_val_com_39";

	public static final String	OID_VAL_COM_40				= "oid_val_com_40";

	public static final String	OID_VAL_COM_41				= "oid_val_com_41";

	public static final String	OID_VAL_COM_42				= "oid_val_com_42";

	public static final String	OID_VAL_COM_43				= "oid_val_com_43";

	public static final String	OID_VAL_COM_44				= "oid_val_com_44";

	public static final String	OID_VAL_COM_45				= "oid_val_com_45";

	public static final String	OID_VAL_COM_46				= "oid_val_com_46";

	public static final String	OID_VAL_COM_47				= "oid_val_com_47";

	public static final String	OID_VAL_COM_48				= "oid_val_com_48";

	public static final String	OID_VAL_COM_49				= "oid_val_com_49";

	public static final String	OID_VAL_COM_50				= "oid_val_com_50";

	public static final String	OID_VAL_COM_51				= "oid_val_com_51";

	public static final String	OID_VAL_COM_52				= "oid_val_com_52";

	public static final String	OID_VAL_COM_53				= "oid_val_com_53";

	public static final String	OID_VAL_COM_54				= "oid_val_com_54";

	public static final String	OID_VAL_COM_55				= "oid_val_com_55";

	public static final String	OID_VAL_COM_56				= "oid_val_com_56";

	public static final String	OID_VAL_COM_57				= "oid_val_com_57";

	public static final String	OID_VAL_COM_58				= "oid_val_com_58";

	public static final String	OID_VAL_COM_59				= "oid_val_com_59";

	public static final String	OID_VAL_COM_60				= "oid_val_com_60";

	public static final String	OID_VAL_COM_61				= "oid_val_com_61";

	public static final String	OID_VAL_COM_62				= "oid_val_com_62";

	public static final String	OID_VAL_COM_63				= "oid_val_com_63";

	public static final String	OID_VAL_COM_64				= "oid_val_com_64";

	public static final String	OID_VAL_COM_65				= "oid_val_com_65";

	public static final String	OID_VAL_COM_66				= "oid_val_com_66";

	public static final String	OID_VAL_COM_67				= "oid_val_com_67";

	public static final String	OID_VAL_COM_68				= "oid_val_com_68";

	public static final String	OID_VAL_COM_69				= "oid_val_com_69";

	public static final String	OID_VAL_COM_70				= "oid_val_com_70";

	public static final String	OID_VAL_COM_71				= "oid_val_com_71";

	public static final String	OID_VAL_COM_72				= "oid_val_com_72";

	public static final String	OID_VAL_COM_73				= "oid_val_com_73";

	public static final String	OID_VAL_COM_74				= "oid_val_com_74";

	public static final String	OID_VAL_COM_75				= "oid_val_com_75";

	public static final String	OID_VAL_COM_76				= "oid_val_com_76";

	public static final String	OID_VAL_COM_77				= "oid_val_com_77";

	public static final String	OID_VAL_COM_78				= "oid_val_com_78";

	public static final String	OID_VAL_COM_79				= "oid_val_com_79";

	public static final String	OID_VAL_COM_80				= "oid_val_com_80";

	public static final String	VAL_NUM_1							= "val_num_1";

	public static final String	VAL_NUM_2							= "val_num_2";

	public static final String	VAL_NUM_3							= "val_num_3";

	public static final String	VAL_NUM_4							= "val_num_4";

	public static final String	VAL_NUM_5							= "val_num_5";

	public static final String	VAL_NUM_6							= "val_num_6";

	public static final String	VAL_NUM_7							= "val_num_7";

	public static final String	VAL_NUM_8							= "val_num_8";

	public static final String	VAL_NUM_9							= "val_num_9";

	public static final String	VAL_NUM_10						= "val_num_10";

	public static final String	VAL_NUM_11						= "val_num_11";

	public static final String	VAL_NUM_12						= "val_num_12";

	public static final String	VAL_NUM_13						= "val_num_13";

	public static final String	VAL_NUM_14						= "val_num_14";

	public static final String	VAL_NUM_15						= "val_num_15";

	public static final String	VAL_NUM_16						= "val_num_16";

	public static final String	VAL_NUM_17						= "val_num_17";

	public static final String	VAL_NUM_18						= "val_num_18";

	public static final String	VAL_NUM_19						= "val_num_19";

	public static final String	VAL_NUM_20						= "val_num_20";

	public static final String	VAL_NUM_21						= "val_num_21";

	public static final String	VAL_NUM_22						= "val_num_22";

	public static final String	VAL_NUM_23						= "val_num_23";

	public static final String	VAL_NUM_24						= "val_num_24";

	public static final String	VAL_NUM_25						= "val_num_25";

	public static final String	VAL_NUM_26						= "val_num_26";

	public static final String	VAL_NUM_27						= "val_num_27";

	public static final String	VAL_NUM_28						= "val_num_28";

	public static final String	VAL_NUM_29						= "val_num_29";

	public static final String	VAL_NUM_30						= "val_num_30";

	public static final String	VAL_TEX_1							= "val_tex_1";

	public static final String	VAL_TEX_2							= "val_tex_2";

	public static final String	VAL_TEX_3							= "val_tex_3";

	public static final String	VAL_TEX_4							= "val_tex_4";

	public static final String	VAL_TEX_5							= "val_tex_5";

	public static final String	VAL_TEX_6							= "val_tex_6";

	public static final String	VAL_TEX_7							= "val_tex_7";

	public static final String	VAL_TEX_8							= "val_tex_8";

	public static final String	VAL_TEX_9							= "val_tex_9";

	public static final String	VAL_TEX_10						= "val_tex_10";

	public static final String	VAL_TEX_11						= "val_tex_11";

	public static final String	VAL_TEX_12						= "val_tex_12";

	public static final String	VAL_TEX_13						= "val_tex_13";

	public static final String	VAL_TEX_14						= "val_tex_14";

	public static final String	VAL_TEX_15						= "val_tex_15";

	public static final String	VAL_TEX_16						= "val_tex_16";

	public static final String	VAL_TEX_17						= "val_tex_17";

	public static final String	VAL_TEX_18						= "val_tex_18";

	public static final String	VAL_TEX_19						= "val_tex_19";

	public static final String	VAL_TEX_20						= "val_tex_20";

	public static final String	VAL_FEC_1							= "val_fec_1";

	public static final String	VAL_FEC_2							= "val_fec_2";

	public static final String	VAL_FEC_3							= "val_fec_3";

	public static final String	VAL_FEC_4							= "val_fec_4";

	public static final String	VAL_FEC_5							= "val_fec_5";

	public static final String	VAL_FEC_6							= "val_fec_6";

	public static final String	VAL_FEC_7							= "val_fec_7";

	public static final String	VAL_FEC_8							= "val_fec_8";

	public static final String	VAL_FEC_9							= "val_fec_9";

	public static final String	VAL_FEC_10						= "val_fec_10";

	public static final String	VAL_FEC_11						= "val_fec_11";

	public static final String	VAL_FEC_12						= "val_fec_12";

	public static final String	VAL_FEC_13						= "val_fec_13";

	public static final String	VAL_FEC_14						= "val_fec_14";

	public static final String	VAL_FEC_15						= "val_fec_15";

	public static final String	VAL_FEC_16						= "val_fec_16";

	public static final String	VAL_FEC_17						= "val_fec_17";

	public static final String	VAL_FEC_18						= "val_fec_18";

	public static final String	VAL_FEC_19						= "val_fec_19";

	public static final String	VAL_FEC_20						= "val_fec_20";

	public static final int			SELECT_BY_COMPO_PRESU	= 100;
	public static final int			SELECT_BY_COMPO_PRESU_CODIGO	= 101;
	public static final int			SELECT_BY_COMPO_PRESU_VAL_COMPO_ANT	= 102;
	
	
	public DBValorCompoPresu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VALOR_COMPO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int NRO_REL = 4;
		final int NRO_REL_PADRE = 5;
		final int ACTIVO = 6;
		final int OID_VAL_COM_1 = 7;
		final int OID_VAL_COM_2 = 8;
		final int OID_VAL_COM_3 = 9;
		final int OID_VAL_COM_4 = 10;
		final int OID_VAL_COM_5 = 11;
		final int OID_VAL_COM_6 = 12;
		final int OID_VAL_COM_7 = 13;
		final int OID_VAL_COM_8 = 14;
		final int OID_VAL_COM_9 = 15;
		final int OID_VAL_COM_10 = 16;
		final int OID_VAL_COM_11 = 17;
		final int OID_VAL_COM_12 = 18;
		final int OID_VAL_COM_13 = 19;
		final int OID_VAL_COM_14 = 20;
		final int OID_VAL_COM_15 = 21;
		final int OID_VAL_COM_16 = 22;
		final int OID_VAL_COM_17 = 23;
		final int OID_VAL_COM_18 = 24;
		final int OID_VAL_COM_19 = 25;
		final int OID_VAL_COM_20 = 26;
		final int OID_VAL_COM_21 = 27;
		final int OID_VAL_COM_22 = 28;
		final int OID_VAL_COM_23 = 29;
		final int OID_VAL_COM_24 = 30;
		final int OID_VAL_COM_25 = 31;
		final int OID_VAL_COM_26 = 32;
		final int OID_VAL_COM_27 = 33;
		final int OID_VAL_COM_28 = 34;
		final int OID_VAL_COM_29 = 35;
		final int OID_VAL_COM_30 = 36;
		final int OID_VAL_COM_31 = 37;
		final int OID_VAL_COM_32 = 38;
		final int OID_VAL_COM_33 = 39;
		final int OID_VAL_COM_34 = 40;
		final int OID_VAL_COM_35 = 41;
		final int OID_VAL_COM_36 = 42;
		final int OID_VAL_COM_37 = 43;
		final int OID_VAL_COM_38 = 44;
		final int OID_VAL_COM_39 = 45;
		final int OID_VAL_COM_40 = 46;
		final int OID_VAL_COM_41 = 47;
		final int OID_VAL_COM_42 = 48;
		final int OID_VAL_COM_43 = 49;
		final int OID_VAL_COM_44 = 50;
		final int OID_VAL_COM_45 = 51;
		final int OID_VAL_COM_46 = 52;
		final int OID_VAL_COM_47 = 53;
		final int OID_VAL_COM_48 = 54;
		final int OID_VAL_COM_49 = 55;
		final int OID_VAL_COM_50 = 56;
		final int OID_VAL_COM_51 = 57;
		final int OID_VAL_COM_52 = 58;
		final int OID_VAL_COM_53 = 59;
		final int OID_VAL_COM_54 = 60;
		final int OID_VAL_COM_55 = 61;
		final int OID_VAL_COM_56 = 62;
		final int OID_VAL_COM_57 = 63;
		final int OID_VAL_COM_58 = 64;
		final int OID_VAL_COM_59 = 65;
		final int OID_VAL_COM_60 = 66;
		final int OID_VAL_COM_61 = 67;
		final int OID_VAL_COM_62 = 68;
		final int OID_VAL_COM_63 = 69;
		final int OID_VAL_COM_64 = 70;
		final int OID_VAL_COM_65 = 71;
		final int OID_VAL_COM_66 = 72;
		final int OID_VAL_COM_67 = 73;
		final int OID_VAL_COM_68 = 74;
		final int OID_VAL_COM_69 = 75;
		final int OID_VAL_COM_70 = 76;
		final int OID_VAL_COM_71 = 77;
		final int OID_VAL_COM_72 = 78;
		final int OID_VAL_COM_73 = 79;
		final int OID_VAL_COM_74 = 80;
		final int OID_VAL_COM_75 = 81;
		final int OID_VAL_COM_76 = 82;
		final int OID_VAL_COM_77 = 83;
		final int OID_VAL_COM_78 = 84;
		final int OID_VAL_COM_79 = 85;
		final int OID_VAL_COM_80 = 86;
		final int VAL_NUM_1 = 87;
		final int VAL_NUM_2 = 88;
		final int VAL_NUM_3 = 89;
		final int VAL_NUM_4 = 90;
		final int VAL_NUM_5 = 91;
		final int VAL_NUM_6 = 92;
		final int VAL_NUM_7 = 93;
		final int VAL_NUM_8 = 94;
		final int VAL_NUM_9 = 95;
		final int VAL_NUM_10 = 96;
		final int VAL_NUM_11 = 97;
		final int VAL_NUM_12 = 98;
		final int VAL_NUM_13 = 99;
		final int VAL_NUM_14 = 100;
		final int VAL_NUM_15 = 101;
		final int VAL_NUM_16 = 102;
		final int VAL_NUM_17 = 103;
		final int VAL_NUM_18 = 104;
		final int VAL_NUM_19 = 105;
		final int VAL_NUM_20 = 106;
		final int VAL_NUM_21 = 107;
		final int VAL_NUM_22 = 108;
		final int VAL_NUM_23 = 109;
		final int VAL_NUM_24 = 110;
		final int VAL_NUM_25 = 111;
		final int VAL_NUM_26 = 112;
		final int VAL_NUM_27 = 113;
		final int VAL_NUM_28 = 114;
		final int VAL_NUM_29 = 115;
		final int VAL_NUM_30 = 116;
		final int VAL_TEX_1 = 117;
		final int VAL_TEX_2 = 118;
		final int VAL_TEX_3 = 119;
		final int VAL_TEX_4 = 120;
		final int VAL_TEX_5 = 121;
		final int VAL_TEX_6 = 122;
		final int VAL_TEX_7 = 123;
		final int VAL_TEX_8 = 124;
		final int VAL_TEX_9 = 125;
		final int VAL_TEX_10 = 126;
		final int VAL_TEX_11 = 127;
		final int VAL_TEX_12 = 128;
		final int VAL_TEX_13 = 129;
		final int VAL_TEX_14 = 130;
		final int VAL_TEX_15 = 131;
		final int VAL_TEX_16 = 132;
		final int VAL_TEX_17 = 133;
		final int VAL_TEX_18 = 134;
		final int VAL_TEX_19 = 135;
		final int VAL_TEX_20 = 136;
		final int VAL_FEC_1 = 137;
		final int VAL_FEC_2 = 138;
		final int VAL_FEC_3 = 139;
		final int VAL_FEC_4 = 140;
		final int VAL_FEC_5 = 141;
		final int VAL_FEC_6 = 142;
		final int VAL_FEC_7 = 143;
		final int VAL_FEC_8 = 144;
		final int VAL_FEC_9 = 145;
		final int VAL_FEC_10 = 146;
		final int VAL_FEC_11 = 147;
		final int VAL_FEC_12 = 148;
		final int VAL_FEC_13 = 149;
		final int VAL_FEC_14 = 150;
		final int VAL_FEC_15 = 151;
		final int VAL_FEC_16 = 152;
		final int VAL_FEC_17 = 153;
		final int VAL_FEC_18 = 154;
		final int VAL_FEC_19 = 155;
		final int VAL_FEC_20 = 156;
		final int OID_COMPO_PRESU = 157;

		ValorCompoPresu pers = (ValorCompoPresu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into plValCompo " + " ( " + "OID_VALOR_COMPO," + "CODIGO," + "DESCRIPCION," + "NRO_REL,"
				+ "NRO_REL_PADRE," + "ACTIVO," + "OID_VAL_COM_1," + "OID_VAL_COM_2," + "OID_VAL_COM_3," + "OID_VAL_COM_4,"
				+ "OID_VAL_COM_5," + "OID_VAL_COM_6," + "OID_VAL_COM_7," + "OID_VAL_COM_8," + "OID_VAL_COM_9,"
				+ "OID_VAL_COM_10," + "OID_VAL_COM_11," + "OID_VAL_COM_12," + "OID_VAL_COM_13," + "OID_VAL_COM_14,"
				+ "OID_VAL_COM_15," + "OID_VAL_COM_16," + "OID_VAL_COM_17," + "OID_VAL_COM_18," + "OID_VAL_COM_19,"
				+ "OID_VAL_COM_20," + "OID_VAL_COM_21," + "OID_VAL_COM_22," + "OID_VAL_COM_23," + "OID_VAL_COM_24,"
				+ "OID_VAL_COM_25," + "OID_VAL_COM_26," + "OID_VAL_COM_27," + "OID_VAL_COM_28," + "OID_VAL_COM_29,"
				+ "OID_VAL_COM_30," + "OID_VAL_COM_31," + "OID_VAL_COM_32," + "OID_VAL_COM_33," + "OID_VAL_COM_34,"
				+ "OID_VAL_COM_35," + "OID_VAL_COM_36," + "OID_VAL_COM_37," + "OID_VAL_COM_38," + "OID_VAL_COM_39,"
				+ "OID_VAL_COM_40," + "OID_VAL_COM_41," + "OID_VAL_COM_42," + "OID_VAL_COM_43," + "OID_VAL_COM_44,"
				+ "OID_VAL_COM_45," + "OID_VAL_COM_46," + "OID_VAL_COM_47," + "OID_VAL_COM_48," + "OID_VAL_COM_49,"
				+ "OID_VAL_COM_50," + "OID_VAL_COM_51," + "OID_VAL_COM_52," + "OID_VAL_COM_53," + "OID_VAL_COM_54,"
				+ "OID_VAL_COM_55," + "OID_VAL_COM_56," + "OID_VAL_COM_57," + "OID_VAL_COM_58," + "OID_VAL_COM_59,"
				+ "OID_VAL_COM_60," + "OID_VAL_COM_61," + "OID_VAL_COM_62," + "OID_VAL_COM_63," + "OID_VAL_COM_64,"
				+ "OID_VAL_COM_65," + "OID_VAL_COM_66," + "OID_VAL_COM_67," + "OID_VAL_COM_68," + "OID_VAL_COM_69,"
				+ "OID_VAL_COM_70," + "OID_VAL_COM_71," + "OID_VAL_COM_72," + "OID_VAL_COM_73," + "OID_VAL_COM_74,"
				+ "OID_VAL_COM_75," + "OID_VAL_COM_76," + "OID_VAL_COM_77," + "OID_VAL_COM_78," + "OID_VAL_COM_79,"
				+ "OID_VAL_COM_80," + "VAL_NUM_1," + "VAL_NUM_2," + "VAL_NUM_3," + "VAL_NUM_4," + "VAL_NUM_5," + "VAL_NUM_6,"
				+ "VAL_NUM_7," + "VAL_NUM_8," + "VAL_NUM_9," + "VAL_NUM_10," + "VAL_NUM_11," + "VAL_NUM_12," + "VAL_NUM_13,"
				+ "VAL_NUM_14," + "VAL_NUM_15," + "VAL_NUM_16," + "VAL_NUM_17," + "VAL_NUM_18," + "VAL_NUM_19," + "VAL_NUM_20,"
				+ "VAL_NUM_21," + "VAL_NUM_22," + "VAL_NUM_23," + "VAL_NUM_24," + "VAL_NUM_25," + "VAL_NUM_26," + "VAL_NUM_27,"
				+ "VAL_NUM_28," + "VAL_NUM_29," + "VAL_NUM_30," + "VAL_TEX_1," + "VAL_TEX_2," + "VAL_TEX_3," + "VAL_TEX_4,"
				+ "VAL_TEX_5," + "VAL_TEX_6," + "VAL_TEX_7," + "VAL_TEX_8," + "VAL_TEX_9," + "VAL_TEX_10," + "VAL_TEX_11,"
				+ "VAL_TEX_12," + "VAL_TEX_13," + "VAL_TEX_14," + "VAL_TEX_15," + "VAL_TEX_16," + "VAL_TEX_17," + "VAL_TEX_18,"
				+ "VAL_TEX_19," + "VAL_TEX_20," + "VAL_FEC_1," + "VAL_FEC_2," + "VAL_FEC_3," + "VAL_FEC_4," + "VAL_FEC_5,"
				+ "VAL_FEC_6," + "VAL_FEC_7," + "VAL_FEC_8," + "VAL_FEC_9," + "VAL_FEC_10," + "VAL_FEC_11," + "VAL_FEC_12,"
				+ "VAL_FEC_13," + "VAL_FEC_14," + "VAL_FEC_15," + "VAL_FEC_16," + "VAL_FEC_17," + "VAL_FEC_18," + "VAL_FEC_19,"
				+ "VAL_FEC_20," + "OID_COMPO_PRESU)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VALOR_COMPO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(NRO_REL, pers.getNro_rel().intValue());
		qInsert.setInt(NRO_REL_PADRE, pers.getNro_rel_padre().intValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getVal_com_1() != null)
			qInsert.setInt(OID_VAL_COM_1, pers.getVal_com_1().getOID());
		else
			qInsert.setNull(OID_VAL_COM_1, java.sql.Types.INTEGER);
		if (pers.getVal_com_2() != null)
			qInsert.setInt(OID_VAL_COM_2, pers.getVal_com_2().getOID());
		else
			qInsert.setNull(OID_VAL_COM_2, java.sql.Types.INTEGER);
		if (pers.getVal_com_3() != null)
			qInsert.setInt(OID_VAL_COM_3, pers.getVal_com_3().getOID());
		else
			qInsert.setNull(OID_VAL_COM_3, java.sql.Types.INTEGER);
		if (pers.getVal_com_4() != null)
			qInsert.setInt(OID_VAL_COM_4, pers.getVal_com_4().getOID());
		else
			qInsert.setNull(OID_VAL_COM_4, java.sql.Types.INTEGER);
		if (pers.getVal_com_5() != null)
			qInsert.setInt(OID_VAL_COM_5, pers.getVal_com_5().getOID());
		else
			qInsert.setNull(OID_VAL_COM_5, java.sql.Types.INTEGER);
		if (pers.getVal_com_6() != null)
			qInsert.setInt(OID_VAL_COM_6, pers.getVal_com_6().getOID());
		else
			qInsert.setNull(OID_VAL_COM_6, java.sql.Types.INTEGER);
		if (pers.getVal_com_7() != null)
			qInsert.setInt(OID_VAL_COM_7, pers.getVal_com_7().getOID());
		else
			qInsert.setNull(OID_VAL_COM_7, java.sql.Types.INTEGER);
		if (pers.getVal_com_8() != null)
			qInsert.setInt(OID_VAL_COM_8, pers.getVal_com_8().getOID());
		else
			qInsert.setNull(OID_VAL_COM_8, java.sql.Types.INTEGER);
		if (pers.getVal_com_9() != null)
			qInsert.setInt(OID_VAL_COM_9, pers.getVal_com_9().getOID());
		else
			qInsert.setNull(OID_VAL_COM_9, java.sql.Types.INTEGER);
		if (pers.getVal_com_10() != null)
			qInsert.setInt(OID_VAL_COM_10, pers.getVal_com_10().getOID());
		else
			qInsert.setNull(OID_VAL_COM_10, java.sql.Types.INTEGER);
		if (pers.getVal_com_11() != null)
			qInsert.setInt(OID_VAL_COM_11, pers.getVal_com_11().getOID());
		else
			qInsert.setNull(OID_VAL_COM_11, java.sql.Types.INTEGER);
		if (pers.getVal_com_12() != null)
			qInsert.setInt(OID_VAL_COM_12, pers.getVal_com_12().getOID());
		else
			qInsert.setNull(OID_VAL_COM_12, java.sql.Types.INTEGER);
		if (pers.getVal_com_13() != null)
			qInsert.setInt(OID_VAL_COM_13, pers.getVal_com_13().getOID());
		else
			qInsert.setNull(OID_VAL_COM_13, java.sql.Types.INTEGER);
		if (pers.getVal_com_14() != null)
			qInsert.setInt(OID_VAL_COM_14, pers.getVal_com_14().getOID());
		else
			qInsert.setNull(OID_VAL_COM_14, java.sql.Types.INTEGER);
		if (pers.getVal_com_15() != null)
			qInsert.setInt(OID_VAL_COM_15, pers.getVal_com_15().getOID());
		else
			qInsert.setNull(OID_VAL_COM_15, java.sql.Types.INTEGER);
		if (pers.getVal_com_16() != null)
			qInsert.setInt(OID_VAL_COM_16, pers.getVal_com_16().getOID());
		else
			qInsert.setNull(OID_VAL_COM_16, java.sql.Types.INTEGER);
		if (pers.getVal_com_17() != null)
			qInsert.setInt(OID_VAL_COM_17, pers.getVal_com_17().getOID());
		else
			qInsert.setNull(OID_VAL_COM_17, java.sql.Types.INTEGER);
		if (pers.getVal_com_18() != null)
			qInsert.setInt(OID_VAL_COM_18, pers.getVal_com_18().getOID());
		else
			qInsert.setNull(OID_VAL_COM_18, java.sql.Types.INTEGER);
		if (pers.getVal_com_19() != null)
			qInsert.setInt(OID_VAL_COM_19, pers.getVal_com_19().getOID());
		else
			qInsert.setNull(OID_VAL_COM_19, java.sql.Types.INTEGER);
		if (pers.getVal_com_20() != null)
			qInsert.setInt(OID_VAL_COM_20, pers.getVal_com_20().getOID());
		else
			qInsert.setNull(OID_VAL_COM_20, java.sql.Types.INTEGER);
		if (pers.getVal_com_21() != null)
			qInsert.setInt(OID_VAL_COM_21, pers.getVal_com_21().getOID());
		else
			qInsert.setNull(OID_VAL_COM_21, java.sql.Types.INTEGER);
		if (pers.getVal_com_22() != null)
			qInsert.setInt(OID_VAL_COM_22, pers.getVal_com_22().getOID());
		else
			qInsert.setNull(OID_VAL_COM_22, java.sql.Types.INTEGER);
		if (pers.getVal_com_23() != null)
			qInsert.setInt(OID_VAL_COM_23, pers.getVal_com_23().getOID());
		else
			qInsert.setNull(OID_VAL_COM_23, java.sql.Types.INTEGER);
		if (pers.getVal_com_24() != null)
			qInsert.setInt(OID_VAL_COM_24, pers.getVal_com_24().getOID());
		else
			qInsert.setNull(OID_VAL_COM_24, java.sql.Types.INTEGER);
		if (pers.getVal_com_25() != null)
			qInsert.setInt(OID_VAL_COM_25, pers.getVal_com_25().getOID());
		else
			qInsert.setNull(OID_VAL_COM_25, java.sql.Types.INTEGER);
		if (pers.getVal_com_26() != null)
			qInsert.setInt(OID_VAL_COM_26, pers.getVal_com_26().getOID());
		else
			qInsert.setNull(OID_VAL_COM_26, java.sql.Types.INTEGER);
		if (pers.getVal_com_27() != null)
			qInsert.setInt(OID_VAL_COM_27, pers.getVal_com_27().getOID());
		else
			qInsert.setNull(OID_VAL_COM_27, java.sql.Types.INTEGER);
		if (pers.getVal_com_28() != null)
			qInsert.setInt(OID_VAL_COM_28, pers.getVal_com_28().getOID());
		else
			qInsert.setNull(OID_VAL_COM_28, java.sql.Types.INTEGER);
		if (pers.getVal_com_29() != null)
			qInsert.setInt(OID_VAL_COM_29, pers.getVal_com_29().getOID());
		else
			qInsert.setNull(OID_VAL_COM_29, java.sql.Types.INTEGER);
		if (pers.getVal_com_30() != null)
			qInsert.setInt(OID_VAL_COM_30, pers.getVal_com_30().getOID());
		else
			qInsert.setNull(OID_VAL_COM_30, java.sql.Types.INTEGER);
		if (pers.getVal_com_31() != null)
			qInsert.setInt(OID_VAL_COM_31, pers.getVal_com_31().getOID());
		else
			qInsert.setNull(OID_VAL_COM_31, java.sql.Types.INTEGER);
		if (pers.getVal_com_32() != null)
			qInsert.setInt(OID_VAL_COM_32, pers.getVal_com_32().getOID());
		else
			qInsert.setNull(OID_VAL_COM_32, java.sql.Types.INTEGER);
		if (pers.getVal_com_33() != null)
			qInsert.setInt(OID_VAL_COM_33, pers.getVal_com_33().getOID());
		else
			qInsert.setNull(OID_VAL_COM_33, java.sql.Types.INTEGER);
		if (pers.getVal_com_34() != null)
			qInsert.setInt(OID_VAL_COM_34, pers.getVal_com_34().getOID());
		else
			qInsert.setNull(OID_VAL_COM_34, java.sql.Types.INTEGER);
		if (pers.getVal_com_35() != null)
			qInsert.setInt(OID_VAL_COM_35, pers.getVal_com_35().getOID());
		else
			qInsert.setNull(OID_VAL_COM_35, java.sql.Types.INTEGER);
		if (pers.getVal_com_36() != null)
			qInsert.setInt(OID_VAL_COM_36, pers.getVal_com_36().getOID());
		else
			qInsert.setNull(OID_VAL_COM_36, java.sql.Types.INTEGER);
		if (pers.getVal_com_37() != null)
			qInsert.setInt(OID_VAL_COM_37, pers.getVal_com_37().getOID());
		else
			qInsert.setNull(OID_VAL_COM_37, java.sql.Types.INTEGER);
		if (pers.getVal_com_38() != null)
			qInsert.setInt(OID_VAL_COM_38, pers.getVal_com_38().getOID());
		else
			qInsert.setNull(OID_VAL_COM_38, java.sql.Types.INTEGER);
		if (pers.getVal_com_39() != null)
			qInsert.setInt(OID_VAL_COM_39, pers.getVal_com_39().getOID());
		else
			qInsert.setNull(OID_VAL_COM_39, java.sql.Types.INTEGER);
		if (pers.getVal_com_40() != null)
			qInsert.setInt(OID_VAL_COM_40, pers.getVal_com_40().getOID());
		else
			qInsert.setNull(OID_VAL_COM_40, java.sql.Types.INTEGER);
		if (pers.getVal_com_41() != null)
			qInsert.setInt(OID_VAL_COM_41, pers.getVal_com_41().getOID());
		else
			qInsert.setNull(OID_VAL_COM_41, java.sql.Types.INTEGER);
		if (pers.getVal_com_42() != null)
			qInsert.setInt(OID_VAL_COM_42, pers.getVal_com_42().getOID());
		else
			qInsert.setNull(OID_VAL_COM_42, java.sql.Types.INTEGER);
		if (pers.getVal_com_43() != null)
			qInsert.setInt(OID_VAL_COM_43, pers.getVal_com_43().getOID());
		else
			qInsert.setNull(OID_VAL_COM_43, java.sql.Types.INTEGER);
		if (pers.getVal_com_44() != null)
			qInsert.setInt(OID_VAL_COM_44, pers.getVal_com_44().getOID());
		else
			qInsert.setNull(OID_VAL_COM_44, java.sql.Types.INTEGER);
		if (pers.getVal_com_45() != null)
			qInsert.setInt(OID_VAL_COM_45, pers.getVal_com_45().getOID());
		else
			qInsert.setNull(OID_VAL_COM_45, java.sql.Types.INTEGER);
		if (pers.getVal_com_46() != null)
			qInsert.setInt(OID_VAL_COM_46, pers.getVal_com_46().getOID());
		else
			qInsert.setNull(OID_VAL_COM_46, java.sql.Types.INTEGER);
		if (pers.getVal_com_47() != null)
			qInsert.setInt(OID_VAL_COM_47, pers.getVal_com_47().getOID());
		else
			qInsert.setNull(OID_VAL_COM_47, java.sql.Types.INTEGER);
		if (pers.getVal_com_48() != null)
			qInsert.setInt(OID_VAL_COM_48, pers.getVal_com_48().getOID());
		else
			qInsert.setNull(OID_VAL_COM_48, java.sql.Types.INTEGER);
		if (pers.getVal_com_49() != null)
			qInsert.setInt(OID_VAL_COM_49, pers.getVal_com_49().getOID());
		else
			qInsert.setNull(OID_VAL_COM_49, java.sql.Types.INTEGER);
		if (pers.getVal_com_50() != null)
			qInsert.setInt(OID_VAL_COM_50, pers.getVal_com_50().getOID());
		else
			qInsert.setNull(OID_VAL_COM_50, java.sql.Types.INTEGER);
		if (pers.getVal_com_51() != null)
			qInsert.setInt(OID_VAL_COM_51, pers.getVal_com_51().getOID());
		else
			qInsert.setNull(OID_VAL_COM_51, java.sql.Types.INTEGER);
		if (pers.getVal_com_52() != null)
			qInsert.setInt(OID_VAL_COM_52, pers.getVal_com_52().getOID());
		else
			qInsert.setNull(OID_VAL_COM_52, java.sql.Types.INTEGER);
		if (pers.getVal_com_53() != null)
			qInsert.setInt(OID_VAL_COM_53, pers.getVal_com_53().getOID());
		else
			qInsert.setNull(OID_VAL_COM_53, java.sql.Types.INTEGER);
		if (pers.getVal_com_54() != null)
			qInsert.setInt(OID_VAL_COM_54, pers.getVal_com_54().getOID());
		else
			qInsert.setNull(OID_VAL_COM_54, java.sql.Types.INTEGER);
		if (pers.getVal_com_55() != null)
			qInsert.setInt(OID_VAL_COM_55, pers.getVal_com_55().getOID());
		else
			qInsert.setNull(OID_VAL_COM_55, java.sql.Types.INTEGER);
		if (pers.getVal_com_56() != null)
			qInsert.setInt(OID_VAL_COM_56, pers.getVal_com_56().getOID());
		else
			qInsert.setNull(OID_VAL_COM_56, java.sql.Types.INTEGER);
		if (pers.getVal_com_57() != null)
			qInsert.setInt(OID_VAL_COM_57, pers.getVal_com_57().getOID());
		else
			qInsert.setNull(OID_VAL_COM_57, java.sql.Types.INTEGER);
		if (pers.getVal_com_58() != null)
			qInsert.setInt(OID_VAL_COM_58, pers.getVal_com_58().getOID());
		else
			qInsert.setNull(OID_VAL_COM_58, java.sql.Types.INTEGER);
		if (pers.getVal_com_59() != null)
			qInsert.setInt(OID_VAL_COM_59, pers.getVal_com_59().getOID());
		else
			qInsert.setNull(OID_VAL_COM_59, java.sql.Types.INTEGER);
		if (pers.getVal_com_60() != null)
			qInsert.setInt(OID_VAL_COM_60, pers.getVal_com_60().getOID());
		else
			qInsert.setNull(OID_VAL_COM_60, java.sql.Types.INTEGER);
		if (pers.getVal_com_61() != null)
			qInsert.setInt(OID_VAL_COM_61, pers.getVal_com_61().getOID());
		else
			qInsert.setNull(OID_VAL_COM_61, java.sql.Types.INTEGER);
		if (pers.getVal_com_62() != null)
			qInsert.setInt(OID_VAL_COM_62, pers.getVal_com_62().getOID());
		else
			qInsert.setNull(OID_VAL_COM_62, java.sql.Types.INTEGER);
		if (pers.getVal_com_63() != null)
			qInsert.setInt(OID_VAL_COM_63, pers.getVal_com_63().getOID());
		else
			qInsert.setNull(OID_VAL_COM_63, java.sql.Types.INTEGER);
		if (pers.getVal_com_64() != null)
			qInsert.setInt(OID_VAL_COM_64, pers.getVal_com_64().getOID());
		else
			qInsert.setNull(OID_VAL_COM_64, java.sql.Types.INTEGER);
		if (pers.getVal_com_65() != null)
			qInsert.setInt(OID_VAL_COM_65, pers.getVal_com_65().getOID());
		else
			qInsert.setNull(OID_VAL_COM_65, java.sql.Types.INTEGER);
		if (pers.getVal_com_66() != null)
			qInsert.setInt(OID_VAL_COM_66, pers.getVal_com_66().getOID());
		else
			qInsert.setNull(OID_VAL_COM_66, java.sql.Types.INTEGER);
		if (pers.getVal_com_67() != null)
			qInsert.setInt(OID_VAL_COM_67, pers.getVal_com_67().getOID());
		else
			qInsert.setNull(OID_VAL_COM_67, java.sql.Types.INTEGER);
		if (pers.getVal_com_68() != null)
			qInsert.setInt(OID_VAL_COM_68, pers.getVal_com_68().getOID());
		else
			qInsert.setNull(OID_VAL_COM_68, java.sql.Types.INTEGER);
		if (pers.getVal_com_69() != null)
			qInsert.setInt(OID_VAL_COM_69, pers.getVal_com_69().getOID());
		else
			qInsert.setNull(OID_VAL_COM_69, java.sql.Types.INTEGER);
		if (pers.getVal_com_70() != null)
			qInsert.setInt(OID_VAL_COM_70, pers.getVal_com_70().getOID());
		else
			qInsert.setNull(OID_VAL_COM_70, java.sql.Types.INTEGER);
		if (pers.getVal_com_71() != null)
			qInsert.setInt(OID_VAL_COM_71, pers.getVal_com_71().getOID());
		else
			qInsert.setNull(OID_VAL_COM_71, java.sql.Types.INTEGER);
		if (pers.getVal_com_72() != null)
			qInsert.setInt(OID_VAL_COM_72, pers.getVal_com_72().getOID());
		else
			qInsert.setNull(OID_VAL_COM_72, java.sql.Types.INTEGER);
		if (pers.getVal_com_73() != null)
			qInsert.setInt(OID_VAL_COM_73, pers.getVal_com_73().getOID());
		else
			qInsert.setNull(OID_VAL_COM_73, java.sql.Types.INTEGER);
		if (pers.getVal_com_74() != null)
			qInsert.setInt(OID_VAL_COM_74, pers.getVal_com_74().getOID());
		else
			qInsert.setNull(OID_VAL_COM_74, java.sql.Types.INTEGER);
		if (pers.getVal_com_75() != null)
			qInsert.setInt(OID_VAL_COM_75, pers.getVal_com_75().getOID());
		else
			qInsert.setNull(OID_VAL_COM_75, java.sql.Types.INTEGER);
		if (pers.getVal_com_76() != null)
			qInsert.setInt(OID_VAL_COM_76, pers.getVal_com_76().getOID());
		else
			qInsert.setNull(OID_VAL_COM_76, java.sql.Types.INTEGER);
		if (pers.getVal_com_77() != null)
			qInsert.setInt(OID_VAL_COM_77, pers.getVal_com_77().getOID());
		else
			qInsert.setNull(OID_VAL_COM_77, java.sql.Types.INTEGER);
		if (pers.getVal_com_78() != null)
			qInsert.setInt(OID_VAL_COM_78, pers.getVal_com_78().getOID());
		else
			qInsert.setNull(OID_VAL_COM_78, java.sql.Types.INTEGER);
		if (pers.getVal_com_79() != null)
			qInsert.setInt(OID_VAL_COM_79, pers.getVal_com_79().getOID());
		else
			qInsert.setNull(OID_VAL_COM_79, java.sql.Types.INTEGER);
		if (pers.getVal_com_80() != null)
			qInsert.setInt(OID_VAL_COM_80, pers.getVal_com_80().getOID());
		else
			qInsert.setNull(OID_VAL_COM_80, java.sql.Types.INTEGER);
		if (pers.getVal_num_1() != null)
			qInsert.setDouble(VAL_NUM_1, pers.getVal_num_1().doubleValue());
		else
			qInsert.setNull(VAL_NUM_1, Types.DOUBLE);
		if (pers.getVal_num_2() != null)
			qInsert.setDouble(VAL_NUM_2, pers.getVal_num_2().doubleValue());
		else
			qInsert.setNull(VAL_NUM_2, Types.DOUBLE);
		if (pers.getVal_num_3() != null)
			qInsert.setDouble(VAL_NUM_3, pers.getVal_num_3().doubleValue());
		else
			qInsert.setNull(VAL_NUM_3, Types.DOUBLE);
		if (pers.getVal_num_4() != null)
			qInsert.setDouble(VAL_NUM_4, pers.getVal_num_4().doubleValue());
		else
			qInsert.setNull(VAL_NUM_4, Types.DOUBLE);
		if (pers.getVal_num_5() != null)
			qInsert.setDouble(VAL_NUM_5, pers.getVal_num_5().doubleValue());
		else
			qInsert.setNull(VAL_NUM_5, Types.DOUBLE);
		if (pers.getVal_num_6() != null)
			qInsert.setDouble(VAL_NUM_6, pers.getVal_num_6().doubleValue());
		else
			qInsert.setNull(VAL_NUM_6, Types.DOUBLE);
		if (pers.getVal_num_7() != null)
			qInsert.setDouble(VAL_NUM_7, pers.getVal_num_7().doubleValue());
		else
			qInsert.setNull(VAL_NUM_7, Types.DOUBLE);
		if (pers.getVal_num_8() != null)
			qInsert.setDouble(VAL_NUM_8, pers.getVal_num_8().doubleValue());
		else
			qInsert.setNull(VAL_NUM_8, Types.DOUBLE);
		if (pers.getVal_num_9() != null)
			qInsert.setDouble(VAL_NUM_9, pers.getVal_num_9().doubleValue());
		else
			qInsert.setNull(VAL_NUM_9, Types.DOUBLE);
		if (pers.getVal_num_10() != null)
			qInsert.setDouble(VAL_NUM_10, pers.getVal_num_10().doubleValue());
		else
			qInsert.setNull(VAL_NUM_10, Types.DOUBLE);
		if (pers.getVal_num_11() != null)
			qInsert.setDouble(VAL_NUM_11, pers.getVal_num_11().doubleValue());
		else
			qInsert.setNull(VAL_NUM_11, Types.DOUBLE);
		if (pers.getVal_num_12() != null)
			qInsert.setDouble(VAL_NUM_12, pers.getVal_num_12().doubleValue());
		else
			qInsert.setNull(VAL_NUM_12, Types.DOUBLE);
		if (pers.getVal_num_13() != null)
			qInsert.setDouble(VAL_NUM_13, pers.getVal_num_13().doubleValue());
		else
			qInsert.setNull(VAL_NUM_13, Types.DOUBLE);
		if (pers.getVal_num_14() != null)
			qInsert.setDouble(VAL_NUM_14, pers.getVal_num_14().doubleValue());
		else
			qInsert.setNull(VAL_NUM_14, Types.DOUBLE);
		if (pers.getVal_num_15() != null)
			qInsert.setDouble(VAL_NUM_15, pers.getVal_num_15().doubleValue());
		else
			qInsert.setNull(VAL_NUM_15, Types.DOUBLE);
		if (pers.getVal_num_16() != null)
			qInsert.setDouble(VAL_NUM_16, pers.getVal_num_16().doubleValue());
		else
			qInsert.setNull(VAL_NUM_16, Types.DOUBLE);
		if (pers.getVal_num_17() != null)
			qInsert.setDouble(VAL_NUM_17, pers.getVal_num_17().doubleValue());
		else
			qInsert.setNull(VAL_NUM_17, Types.DOUBLE);
		if (pers.getVal_num_18() != null)
			qInsert.setDouble(VAL_NUM_18, pers.getVal_num_18().doubleValue());
		else
			qInsert.setNull(VAL_NUM_18, Types.DOUBLE);
		if (pers.getVal_num_19() != null)
			qInsert.setDouble(VAL_NUM_19, pers.getVal_num_19().doubleValue());
		else
			qInsert.setNull(VAL_NUM_19, Types.DOUBLE);
		if (pers.getVal_num_20() != null)
			qInsert.setDouble(VAL_NUM_20, pers.getVal_num_20().doubleValue());
		else
			qInsert.setNull(VAL_NUM_20, Types.DOUBLE);
		if (pers.getVal_num_21() != null)
			qInsert.setDouble(VAL_NUM_21, pers.getVal_num_21().doubleValue());
		else
			qInsert.setNull(VAL_NUM_21, Types.DOUBLE);
		if (pers.getVal_num_22() != null)
			qInsert.setDouble(VAL_NUM_22, pers.getVal_num_22().doubleValue());
		else
			qInsert.setNull(VAL_NUM_22, Types.DOUBLE);
		if (pers.getVal_num_23() != null)
			qInsert.setDouble(VAL_NUM_23, pers.getVal_num_23().doubleValue());
		else
			qInsert.setNull(VAL_NUM_23, Types.DOUBLE);
		if (pers.getVal_num_24() != null)
			qInsert.setDouble(VAL_NUM_24, pers.getVal_num_24().doubleValue());
		else
			qInsert.setNull(VAL_NUM_24, Types.DOUBLE);
		if (pers.getVal_num_25() != null)
			qInsert.setDouble(VAL_NUM_25, pers.getVal_num_25().doubleValue());
		else
			qInsert.setNull(VAL_NUM_25, Types.DOUBLE);
		if (pers.getVal_num_26() != null)
			qInsert.setDouble(VAL_NUM_26, pers.getVal_num_26().doubleValue());
		else
			qInsert.setNull(VAL_NUM_26, Types.DOUBLE);
		if (pers.getVal_num_27() != null)
			qInsert.setDouble(VAL_NUM_27, pers.getVal_num_27().doubleValue());
		else
			qInsert.setNull(VAL_NUM_27, Types.DOUBLE);
		if (pers.getVal_num_28() != null)
			qInsert.setDouble(VAL_NUM_28, pers.getVal_num_28().doubleValue());
		else
			qInsert.setNull(VAL_NUM_28, Types.DOUBLE);
		if (pers.getVal_num_29() != null)
			qInsert.setDouble(VAL_NUM_29, pers.getVal_num_29().doubleValue());
		else
			qInsert.setNull(VAL_NUM_29, Types.DOUBLE);
		if (pers.getVal_num_30() != null)
			qInsert.setDouble(VAL_NUM_30, pers.getVal_num_30().doubleValue());
		else
			qInsert.setNull(VAL_NUM_30, Types.DOUBLE);
		if (pers.getVal_tex_1() != null)
			qInsert.setString(VAL_TEX_1, pers.getVal_tex_1());
		else
			qInsert.setNull(VAL_TEX_1, Types.VARCHAR);
		if (pers.getVal_tex_2() != null)
			qInsert.setString(VAL_TEX_2, pers.getVal_tex_2());
		else
			qInsert.setNull(VAL_TEX_2, Types.VARCHAR);
		if (pers.getVal_tex_3() != null)
			qInsert.setString(VAL_TEX_3, pers.getVal_tex_3());
		else
			qInsert.setNull(VAL_TEX_3, Types.VARCHAR);
		if (pers.getVal_tex_4() != null)
			qInsert.setString(VAL_TEX_4, pers.getVal_tex_4());
		else
			qInsert.setNull(VAL_TEX_4, Types.VARCHAR);
		if (pers.getVal_tex_5() != null)
			qInsert.setString(VAL_TEX_5, pers.getVal_tex_5());
		else
			qInsert.setNull(VAL_TEX_5, Types.VARCHAR);
		if (pers.getVal_tex_6() != null)
			qInsert.setString(VAL_TEX_6, pers.getVal_tex_6());
		else
			qInsert.setNull(VAL_TEX_6, Types.VARCHAR);
		if (pers.getVal_tex_7() != null)
			qInsert.setString(VAL_TEX_7, pers.getVal_tex_7());
		else
			qInsert.setNull(VAL_TEX_7, Types.VARCHAR);
		if (pers.getVal_tex_8() != null)
			qInsert.setString(VAL_TEX_8, pers.getVal_tex_8());
		else
			qInsert.setNull(VAL_TEX_8, Types.VARCHAR);
		if (pers.getVal_tex_9() != null)
			qInsert.setString(VAL_TEX_9, pers.getVal_tex_9());
		else
			qInsert.setNull(VAL_TEX_9, Types.VARCHAR);
		if (pers.getVal_tex_10() != null)
			qInsert.setString(VAL_TEX_10, pers.getVal_tex_10());
		else
			qInsert.setNull(VAL_TEX_10, Types.VARCHAR);
		if (pers.getVal_tex_11() != null)
			qInsert.setString(VAL_TEX_11, pers.getVal_tex_11());
		else
			qInsert.setNull(VAL_TEX_11, Types.VARCHAR);
		if (pers.getVal_tex_12() != null)
			qInsert.setString(VAL_TEX_12, pers.getVal_tex_12());
		else
			qInsert.setNull(VAL_TEX_12, Types.VARCHAR);
		if (pers.getVal_tex_13() != null)
			qInsert.setString(VAL_TEX_13, pers.getVal_tex_13());
		else
			qInsert.setNull(VAL_TEX_13, Types.VARCHAR);
		if (pers.getVal_tex_14() != null)
			qInsert.setString(VAL_TEX_14, pers.getVal_tex_14());
		else
			qInsert.setNull(VAL_TEX_14, Types.VARCHAR);
		if (pers.getVal_tex_15() != null)
			qInsert.setString(VAL_TEX_15, pers.getVal_tex_15());
		else
			qInsert.setNull(VAL_TEX_15, Types.VARCHAR);
		if (pers.getVal_tex_16() != null)
			qInsert.setString(VAL_TEX_16, pers.getVal_tex_16());
		else
			qInsert.setNull(VAL_TEX_16, Types.VARCHAR);
		if (pers.getVal_tex_17() != null)
			qInsert.setString(VAL_TEX_17, pers.getVal_tex_17());
		else
			qInsert.setNull(VAL_TEX_17, Types.VARCHAR);
		if (pers.getVal_tex_18() != null)
			qInsert.setString(VAL_TEX_18, pers.getVal_tex_18());
		else
			qInsert.setNull(VAL_TEX_18, Types.VARCHAR);
		if (pers.getVal_tex_19() != null)
			qInsert.setString(VAL_TEX_19, pers.getVal_tex_19());
		else
			qInsert.setNull(VAL_TEX_19, Types.VARCHAR);
		if (pers.getVal_tex_20() != null)
			qInsert.setString(VAL_TEX_20, pers.getVal_tex_20());
		else
			qInsert.setNull(VAL_TEX_20, Types.VARCHAR);
		if (pers.getVal_fec_1() != null)
			qInsert.setDate(VAL_FEC_1, new Date(pers.getVal_fec_1().getTime()));
		else
			qInsert.setNull(VAL_FEC_1, java.sql.Types.DATE);
		if (pers.getVal_fec_2() != null)
			qInsert.setDate(VAL_FEC_2, new Date(pers.getVal_fec_2().getTime()));
		else
			qInsert.setNull(VAL_FEC_2, java.sql.Types.DATE);
		if (pers.getVal_fec_3() != null)
			qInsert.setDate(VAL_FEC_3, new Date(pers.getVal_fec_3().getTime()));
		else
			qInsert.setNull(VAL_FEC_3, java.sql.Types.DATE);
		if (pers.getVal_fec_4() != null)
			qInsert.setDate(VAL_FEC_4, new Date(pers.getVal_fec_4().getTime()));
		else
			qInsert.setNull(VAL_FEC_4, java.sql.Types.DATE);
		if (pers.getVal_fec_5() != null)
			qInsert.setDate(VAL_FEC_5, new Date(pers.getVal_fec_5().getTime()));
		else
			qInsert.setNull(VAL_FEC_5, java.sql.Types.DATE);
		if (pers.getVal_fec_6() != null)
			qInsert.setDate(VAL_FEC_6, new Date(pers.getVal_fec_6().getTime()));
		else
			qInsert.setNull(VAL_FEC_6, java.sql.Types.DATE);
		if (pers.getVal_fec_7() != null)
			qInsert.setDate(VAL_FEC_7, new Date(pers.getVal_fec_7().getTime()));
		else
			qInsert.setNull(VAL_FEC_7, java.sql.Types.DATE);
		if (pers.getVal_fec_8() != null)
			qInsert.setDate(VAL_FEC_8, new Date(pers.getVal_fec_8().getTime()));
		else
			qInsert.setNull(VAL_FEC_8, java.sql.Types.DATE);
		if (pers.getVal_fec_9() != null)
			qInsert.setDate(VAL_FEC_9, new Date(pers.getVal_fec_9().getTime()));
		else
			qInsert.setNull(VAL_FEC_9, java.sql.Types.DATE);
		if (pers.getVal_fec_10() != null)
			qInsert.setDate(VAL_FEC_10, new Date(pers.getVal_fec_10().getTime()));
		else
			qInsert.setNull(VAL_FEC_10, java.sql.Types.DATE);
		if (pers.getVal_fec_11() != null)
			qInsert.setDate(VAL_FEC_11, new Date(pers.getVal_fec_11().getTime()));
		else
			qInsert.setNull(VAL_FEC_11, java.sql.Types.DATE);
		if (pers.getVal_fec_12() != null)
			qInsert.setDate(VAL_FEC_12, new Date(pers.getVal_fec_12().getTime()));
		else
			qInsert.setNull(VAL_FEC_12, java.sql.Types.DATE);
		if (pers.getVal_fec_13() != null)
			qInsert.setDate(VAL_FEC_13, new Date(pers.getVal_fec_13().getTime()));
		else
			qInsert.setNull(VAL_FEC_13, java.sql.Types.DATE);
		if (pers.getVal_fec_14() != null)
			qInsert.setDate(VAL_FEC_14, new Date(pers.getVal_fec_14().getTime()));
		else
			qInsert.setNull(VAL_FEC_14, java.sql.Types.DATE);
		if (pers.getVal_fec_15() != null)
			qInsert.setDate(VAL_FEC_15, new Date(pers.getVal_fec_15().getTime()));
		else
			qInsert.setNull(VAL_FEC_15, java.sql.Types.DATE);
		if (pers.getVal_fec_16() != null)
			qInsert.setDate(VAL_FEC_16, new Date(pers.getVal_fec_16().getTime()));
		else
			qInsert.setNull(VAL_FEC_16, java.sql.Types.DATE);
		if (pers.getVal_fec_17() != null)
			qInsert.setDate(VAL_FEC_17, new Date(pers.getVal_fec_17().getTime()));
		else
			qInsert.setNull(VAL_FEC_17, java.sql.Types.DATE);
		if (pers.getVal_fec_18() != null)
			qInsert.setDate(VAL_FEC_18, new Date(pers.getVal_fec_18().getTime()));
		else
			qInsert.setNull(VAL_FEC_18, java.sql.Types.DATE);
		if (pers.getVal_fec_19() != null)
			qInsert.setDate(VAL_FEC_19, new Date(pers.getVal_fec_19().getTime()));
		else
			qInsert.setNull(VAL_FEC_19, java.sql.Types.DATE);
		if (pers.getVal_fec_20() != null)
			qInsert.setDate(VAL_FEC_20, new Date(pers.getVal_fec_20().getTime()));
		else
			qInsert.setNull(VAL_FEC_20, java.sql.Types.DATE);
		if (pers.getCompoPresupuestario() != null)
			qInsert.setInt(OID_COMPO_PRESU, pers.getCompoPresupuestario().getOID());
		else
			qInsert.setNull(OID_COMPO_PRESU, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int NRO_REL = 3;
		final int NRO_REL_PADRE = 4;
		final int ACTIVO = 5;
		final int OID_VAL_COM_1 = 6;
		final int OID_VAL_COM_2 = 7;
		final int OID_VAL_COM_3 = 8;
		final int OID_VAL_COM_4 = 9;
		final int OID_VAL_COM_5 = 10;
		final int OID_VAL_COM_6 = 11;
		final int OID_VAL_COM_7 = 12;
		final int OID_VAL_COM_8 = 13;
		final int OID_VAL_COM_9 = 14;
		final int OID_VAL_COM_10 = 15;
		final int OID_VAL_COM_11 = 16;
		final int OID_VAL_COM_12 = 17;
		final int OID_VAL_COM_13 = 18;
		final int OID_VAL_COM_14 = 19;
		final int OID_VAL_COM_15 = 20;
		final int OID_VAL_COM_16 = 21;
		final int OID_VAL_COM_17 = 22;
		final int OID_VAL_COM_18 = 23;
		final int OID_VAL_COM_19 = 24;
		final int OID_VAL_COM_20 = 25;
		final int OID_VAL_COM_21 = 26;
		final int OID_VAL_COM_22 = 27;
		final int OID_VAL_COM_23 = 28;
		final int OID_VAL_COM_24 = 29;
		final int OID_VAL_COM_25 = 30;
		final int OID_VAL_COM_26 = 31;
		final int OID_VAL_COM_27 = 32;
		final int OID_VAL_COM_28 = 33;
		final int OID_VAL_COM_29 = 34;
		final int OID_VAL_COM_30 = 35;
		final int OID_VAL_COM_31 = 36;
		final int OID_VAL_COM_32 = 37;
		final int OID_VAL_COM_33 = 38;
		final int OID_VAL_COM_34 = 39;
		final int OID_VAL_COM_35 = 40;
		final int OID_VAL_COM_36 = 41;
		final int OID_VAL_COM_37 = 42;
		final int OID_VAL_COM_38 = 43;
		final int OID_VAL_COM_39 = 44;
		final int OID_VAL_COM_40 = 45;
		final int OID_VAL_COM_41 = 46;
		final int OID_VAL_COM_42 = 47;
		final int OID_VAL_COM_43 = 48;
		final int OID_VAL_COM_44 = 49;
		final int OID_VAL_COM_45 = 50;
		final int OID_VAL_COM_46 = 51;
		final int OID_VAL_COM_47 = 52;
		final int OID_VAL_COM_48 = 53;
		final int OID_VAL_COM_49 = 54;
		final int OID_VAL_COM_50 = 55;
		final int OID_VAL_COM_51 = 56;
		final int OID_VAL_COM_52 = 57;
		final int OID_VAL_COM_53 = 58;
		final int OID_VAL_COM_54 = 59;
		final int OID_VAL_COM_55 = 60;
		final int OID_VAL_COM_56 = 61;
		final int OID_VAL_COM_57 = 62;
		final int OID_VAL_COM_58 = 63;
		final int OID_VAL_COM_59 = 64;
		final int OID_VAL_COM_60 = 65;
		final int OID_VAL_COM_61 = 66;
		final int OID_VAL_COM_62 = 67;
		final int OID_VAL_COM_63 = 68;
		final int OID_VAL_COM_64 = 69;
		final int OID_VAL_COM_65 = 70;
		final int OID_VAL_COM_66 = 71;
		final int OID_VAL_COM_67 = 72;
		final int OID_VAL_COM_68 = 73;
		final int OID_VAL_COM_69 = 74;
		final int OID_VAL_COM_70 = 75;
		final int OID_VAL_COM_71 = 76;
		final int OID_VAL_COM_72 = 77;
		final int OID_VAL_COM_73 = 78;
		final int OID_VAL_COM_74 = 79;
		final int OID_VAL_COM_75 = 80;
		final int OID_VAL_COM_76 = 81;
		final int OID_VAL_COM_77 = 82;
		final int OID_VAL_COM_78 = 83;
		final int OID_VAL_COM_79 = 84;
		final int OID_VAL_COM_80 = 85;
		final int VAL_NUM_1 = 86;
		final int VAL_NUM_2 = 87;
		final int VAL_NUM_3 = 88;
		final int VAL_NUM_4 = 89;
		final int VAL_NUM_5 = 90;
		final int VAL_NUM_6 = 91;
		final int VAL_NUM_7 = 92;
		final int VAL_NUM_8 = 93;
		final int VAL_NUM_9 = 94;
		final int VAL_NUM_10 = 95;
		final int VAL_NUM_11 = 96;
		final int VAL_NUM_12 = 97;
		final int VAL_NUM_13 = 98;
		final int VAL_NUM_14 = 99;
		final int VAL_NUM_15 = 100;
		final int VAL_NUM_16 = 101;
		final int VAL_NUM_17 = 102;
		final int VAL_NUM_18 = 103;
		final int VAL_NUM_19 = 104;
		final int VAL_NUM_20 = 105;
		final int VAL_NUM_21 = 106;
		final int VAL_NUM_22 = 107;
		final int VAL_NUM_23 = 108;
		final int VAL_NUM_24 = 109;
		final int VAL_NUM_25 = 110;
		final int VAL_NUM_26 = 111;
		final int VAL_NUM_27 = 112;
		final int VAL_NUM_28 = 113;
		final int VAL_NUM_29 = 114;
		final int VAL_NUM_30 = 115;
		final int VAL_TEX_1 = 116;
		final int VAL_TEX_2 = 117;
		final int VAL_TEX_3 = 118;
		final int VAL_TEX_4 = 119;
		final int VAL_TEX_5 = 120;
		final int VAL_TEX_6 = 121;
		final int VAL_TEX_7 = 122;
		final int VAL_TEX_8 = 123;
		final int VAL_TEX_9 = 124;
		final int VAL_TEX_10 = 125;
		final int VAL_TEX_11 = 126;
		final int VAL_TEX_12 = 127;
		final int VAL_TEX_13 = 128;
		final int VAL_TEX_14 = 129;
		final int VAL_TEX_15 = 130;
		final int VAL_TEX_16 = 131;
		final int VAL_TEX_17 = 132;
		final int VAL_TEX_18 = 133;
		final int VAL_TEX_19 = 134;
		final int VAL_TEX_20 = 135;
		final int VAL_FEC_1 = 136;
		final int VAL_FEC_2 = 137;
		final int VAL_FEC_3 = 138;
		final int VAL_FEC_4 = 139;
		final int VAL_FEC_5 = 140;
		final int VAL_FEC_6 = 141;
		final int VAL_FEC_7 = 142;
		final int VAL_FEC_8 = 143;
		final int VAL_FEC_9 = 144;
		final int VAL_FEC_10 = 145;
		final int VAL_FEC_11 = 146;
		final int VAL_FEC_12 = 147;
		final int VAL_FEC_13 = 148;
		final int VAL_FEC_14 = 149;
		final int VAL_FEC_15 = 150;
		final int VAL_FEC_16 = 151;
		final int VAL_FEC_17 = 152;
		final int VAL_FEC_18 = 153;
		final int VAL_FEC_19 = 154;
		final int VAL_FEC_20 = 155;
		final int OID_VALOR_COMPO = 156;

		ValorCompoPresu pers = (ValorCompoPresu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update plValCompo set " + "codigo=?" + ",descripcion=?" + ",nro_rel=?" + ",nro_rel_padre=?"
				+ ",activo=?" + ",oid_val_com_1=?" + ",oid_val_com_2=?" + ",oid_val_com_3=?" + ",oid_val_com_4=?"
				+ ",oid_val_com_5=?" + ",oid_val_com_6=?" + ",oid_val_com_7=?" + ",oid_val_com_8=?" + ",oid_val_com_9=?"
				+ ",oid_val_com_10=?" + ",oid_val_com_11=?" + ",oid_val_com_12=?" + ",oid_val_com_13=?" + ",oid_val_com_14=?"
				+ ",oid_val_com_15=?" + ",oid_val_com_16=?" + ",oid_val_com_17=?" + ",oid_val_com_18=?" + ",oid_val_com_19=?"
				+ ",oid_val_com_20=?" + ",oid_val_com_21=?" + ",oid_val_com_22=?" + ",oid_val_com_23=?" + ",oid_val_com_24=?"
				+ ",oid_val_com_25=?" + ",oid_val_com_26=?" + ",oid_val_com_27=?" + ",oid_val_com_28=?" + ",oid_val_com_29=?"
				+ ",oid_val_com_30=?" + ",oid_val_com_31=?" + ",oid_val_com_32=?" + ",oid_val_com_33=?" + ",oid_val_com_34=?"
				+ ",oid_val_com_35=?" + ",oid_val_com_36=?" + ",oid_val_com_37=?" + ",oid_val_com_38=?" + ",oid_val_com_39=?"
				+ ",oid_val_com_40=?" + ",oid_val_com_41=?" + ",oid_val_com_42=?" + ",oid_val_com_43=?" + ",oid_val_com_44=?"
				+ ",oid_val_com_45=?" + ",oid_val_com_46=?" + ",oid_val_com_47=?" + ",oid_val_com_48=?" + ",oid_val_com_49=?"
				+ ",oid_val_com_50=?" + ",oid_val_com_51=?" + ",oid_val_com_52=?" + ",oid_val_com_53=?" + ",oid_val_com_54=?"
				+ ",oid_val_com_55=?" + ",oid_val_com_56=?" + ",oid_val_com_57=?" + ",oid_val_com_58=?" + ",oid_val_com_59=?"
				+ ",oid_val_com_60=?" + ",oid_val_com_61=?" + ",oid_val_com_62=?" + ",oid_val_com_63=?" + ",oid_val_com_64=?"
				+ ",oid_val_com_65=?" + ",oid_val_com_66=?" + ",oid_val_com_67=?" + ",oid_val_com_68=?" + ",oid_val_com_69=?"
				+ ",oid_val_com_70=?" + ",oid_val_com_71=?" + ",oid_val_com_72=?" + ",oid_val_com_73=?" + ",oid_val_com_74=?"
				+ ",oid_val_com_75=?" + ",oid_val_com_76=?" + ",oid_val_com_77=?" + ",oid_val_com_78=?" + ",oid_val_com_79=?"
				+ ",oid_val_com_80=?" + ",val_num_1=?" + ",val_num_2=?" + ",val_num_3=?" + ",val_num_4=?" + ",val_num_5=?"
				+ ",val_num_6=?" + ",val_num_7=?" + ",val_num_8=?" + ",val_num_9=?" + ",val_num_10=?" + ",val_num_11=?"
				+ ",val_num_12=?" + ",val_num_13=?" + ",val_num_14=?" + ",val_num_15=?" + ",val_num_16=?" + ",val_num_17=?"
				+ ",val_num_18=?" + ",val_num_19=?" + ",val_num_20=?" + ",val_num_21=?" + ",val_num_22=?" + ",val_num_23=?"
				+ ",val_num_24=?" + ",val_num_25=?" + ",val_num_26=?" + ",val_num_27=?" + ",val_num_28=?" + ",val_num_29=?"
				+ ",val_num_30=?" + ",val_tex_1=?" + ",val_tex_2=?" + ",val_tex_3=?" + ",val_tex_4=?" + ",val_tex_5=?"
				+ ",val_tex_6=?" + ",val_tex_7=?" + ",val_tex_8=?" + ",val_tex_9=?" + ",val_tex_10=?" + ",val_tex_11=?"
				+ ",val_tex_12=?" + ",val_tex_13=?" + ",val_tex_14=?" + ",val_tex_15=?" + ",val_tex_16=?" + ",val_tex_17=?"
				+ ",val_tex_18=?" + ",val_tex_19=?" + ",val_tex_20=?" + ",val_fec_1=?" + ",val_fec_2=?" + ",val_fec_3=?"
				+ ",val_fec_4=?" + ",val_fec_5=?" + ",val_fec_6=?" + ",val_fec_7=?" + ",val_fec_8=?" + ",val_fec_9=?"
				+ ",val_fec_10=?" + ",val_fec_11=?" + ",val_fec_12=?" + ",val_fec_13=?" + ",val_fec_14=?" + ",val_fec_15=?"
				+ ",val_fec_16=?" + ",val_fec_17=?" + ",val_fec_18=?" + ",val_fec_19=?" + ",val_fec_20=?" + " where "
				+ " oid_valor_compo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VALOR_COMPO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(NRO_REL, pers.getNro_rel().intValue());
		qUpdate.setInt(NRO_REL_PADRE, pers.getNro_rel_padre().intValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getVal_com_1() != null)
			qUpdate.setInt(OID_VAL_COM_1, pers.getVal_com_1().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_1, java.sql.Types.INTEGER);
		if (pers.getVal_com_2() != null)
			qUpdate.setInt(OID_VAL_COM_2, pers.getVal_com_2().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_2, java.sql.Types.INTEGER);
		if (pers.getVal_com_3() != null)
			qUpdate.setInt(OID_VAL_COM_3, pers.getVal_com_3().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_3, java.sql.Types.INTEGER);
		if (pers.getVal_com_4() != null)
			qUpdate.setInt(OID_VAL_COM_4, pers.getVal_com_4().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_4, java.sql.Types.INTEGER);
		if (pers.getVal_com_5() != null)
			qUpdate.setInt(OID_VAL_COM_5, pers.getVal_com_5().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_5, java.sql.Types.INTEGER);
		if (pers.getVal_com_6() != null)
			qUpdate.setInt(OID_VAL_COM_6, pers.getVal_com_6().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_6, java.sql.Types.INTEGER);
		if (pers.getVal_com_7() != null)
			qUpdate.setInt(OID_VAL_COM_7, pers.getVal_com_7().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_7, java.sql.Types.INTEGER);
		if (pers.getVal_com_8() != null)
			qUpdate.setInt(OID_VAL_COM_8, pers.getVal_com_8().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_8, java.sql.Types.INTEGER);
		if (pers.getVal_com_9() != null)
			qUpdate.setInt(OID_VAL_COM_9, pers.getVal_com_9().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_9, java.sql.Types.INTEGER);
		if (pers.getVal_com_10() != null)
			qUpdate.setInt(OID_VAL_COM_10, pers.getVal_com_10().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_10, java.sql.Types.INTEGER);
		if (pers.getVal_com_11() != null)
			qUpdate.setInt(OID_VAL_COM_11, pers.getVal_com_11().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_11, java.sql.Types.INTEGER);
		if (pers.getVal_com_12() != null)
			qUpdate.setInt(OID_VAL_COM_12, pers.getVal_com_12().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_12, java.sql.Types.INTEGER);
		if (pers.getVal_com_13() != null)
			qUpdate.setInt(OID_VAL_COM_13, pers.getVal_com_13().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_13, java.sql.Types.INTEGER);
		if (pers.getVal_com_14() != null)
			qUpdate.setInt(OID_VAL_COM_14, pers.getVal_com_14().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_14, java.sql.Types.INTEGER);
		if (pers.getVal_com_15() != null)
			qUpdate.setInt(OID_VAL_COM_15, pers.getVal_com_15().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_15, java.sql.Types.INTEGER);
		if (pers.getVal_com_16() != null)
			qUpdate.setInt(OID_VAL_COM_16, pers.getVal_com_16().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_16, java.sql.Types.INTEGER);
		if (pers.getVal_com_17() != null)
			qUpdate.setInt(OID_VAL_COM_17, pers.getVal_com_17().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_17, java.sql.Types.INTEGER);
		if (pers.getVal_com_18() != null)
			qUpdate.setInt(OID_VAL_COM_18, pers.getVal_com_18().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_18, java.sql.Types.INTEGER);
		if (pers.getVal_com_19() != null)
			qUpdate.setInt(OID_VAL_COM_19, pers.getVal_com_19().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_19, java.sql.Types.INTEGER);
		if (pers.getVal_com_20() != null)
			qUpdate.setInt(OID_VAL_COM_20, pers.getVal_com_20().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_20, java.sql.Types.INTEGER);
		if (pers.getVal_com_21() != null)
			qUpdate.setInt(OID_VAL_COM_21, pers.getVal_com_21().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_21, java.sql.Types.INTEGER);
		if (pers.getVal_com_22() != null)
			qUpdate.setInt(OID_VAL_COM_22, pers.getVal_com_22().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_22, java.sql.Types.INTEGER);
		if (pers.getVal_com_23() != null)
			qUpdate.setInt(OID_VAL_COM_23, pers.getVal_com_23().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_23, java.sql.Types.INTEGER);
		if (pers.getVal_com_24() != null)
			qUpdate.setInt(OID_VAL_COM_24, pers.getVal_com_24().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_24, java.sql.Types.INTEGER);
		if (pers.getVal_com_25() != null)
			qUpdate.setInt(OID_VAL_COM_25, pers.getVal_com_25().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_25, java.sql.Types.INTEGER);
		if (pers.getVal_com_26() != null)
			qUpdate.setInt(OID_VAL_COM_26, pers.getVal_com_26().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_26, java.sql.Types.INTEGER);
		if (pers.getVal_com_27() != null)
			qUpdate.setInt(OID_VAL_COM_27, pers.getVal_com_27().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_27, java.sql.Types.INTEGER);
		if (pers.getVal_com_28() != null)
			qUpdate.setInt(OID_VAL_COM_28, pers.getVal_com_28().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_28, java.sql.Types.INTEGER);
		if (pers.getVal_com_29() != null)
			qUpdate.setInt(OID_VAL_COM_29, pers.getVal_com_29().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_29, java.sql.Types.INTEGER);
		if (pers.getVal_com_30() != null)
			qUpdate.setInt(OID_VAL_COM_30, pers.getVal_com_30().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_30, java.sql.Types.INTEGER);
		if (pers.getVal_com_31() != null)
			qUpdate.setInt(OID_VAL_COM_31, pers.getVal_com_31().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_31, java.sql.Types.INTEGER);
		if (pers.getVal_com_32() != null)
			qUpdate.setInt(OID_VAL_COM_32, pers.getVal_com_32().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_32, java.sql.Types.INTEGER);
		if (pers.getVal_com_33() != null)
			qUpdate.setInt(OID_VAL_COM_33, pers.getVal_com_33().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_33, java.sql.Types.INTEGER);
		if (pers.getVal_com_34() != null)
			qUpdate.setInt(OID_VAL_COM_34, pers.getVal_com_34().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_34, java.sql.Types.INTEGER);
		if (pers.getVal_com_35() != null)
			qUpdate.setInt(OID_VAL_COM_35, pers.getVal_com_35().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_35, java.sql.Types.INTEGER);
		if (pers.getVal_com_36() != null)
			qUpdate.setInt(OID_VAL_COM_36, pers.getVal_com_36().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_36, java.sql.Types.INTEGER);
		if (pers.getVal_com_37() != null)
			qUpdate.setInt(OID_VAL_COM_37, pers.getVal_com_37().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_37, java.sql.Types.INTEGER);
		if (pers.getVal_com_38() != null)
			qUpdate.setInt(OID_VAL_COM_38, pers.getVal_com_38().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_38, java.sql.Types.INTEGER);
		if (pers.getVal_com_39() != null)
			qUpdate.setInt(OID_VAL_COM_39, pers.getVal_com_39().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_39, java.sql.Types.INTEGER);
		if (pers.getVal_com_40() != null)
			qUpdate.setInt(OID_VAL_COM_40, pers.getVal_com_40().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_40, java.sql.Types.INTEGER);
		if (pers.getVal_com_41() != null)
			qUpdate.setInt(OID_VAL_COM_41, pers.getVal_com_41().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_41, java.sql.Types.INTEGER);
		if (pers.getVal_com_42() != null)
			qUpdate.setInt(OID_VAL_COM_42, pers.getVal_com_42().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_42, java.sql.Types.INTEGER);
		if (pers.getVal_com_43() != null)
			qUpdate.setInt(OID_VAL_COM_43, pers.getVal_com_43().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_43, java.sql.Types.INTEGER);
		if (pers.getVal_com_44() != null)
			qUpdate.setInt(OID_VAL_COM_44, pers.getVal_com_44().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_44, java.sql.Types.INTEGER);
		if (pers.getVal_com_45() != null)
			qUpdate.setInt(OID_VAL_COM_45, pers.getVal_com_45().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_45, java.sql.Types.INTEGER);
		if (pers.getVal_com_46() != null)
			qUpdate.setInt(OID_VAL_COM_46, pers.getVal_com_46().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_46, java.sql.Types.INTEGER);
		if (pers.getVal_com_47() != null)
			qUpdate.setInt(OID_VAL_COM_47, pers.getVal_com_47().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_47, java.sql.Types.INTEGER);
		if (pers.getVal_com_48() != null)
			qUpdate.setInt(OID_VAL_COM_48, pers.getVal_com_48().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_48, java.sql.Types.INTEGER);
		if (pers.getVal_com_49() != null)
			qUpdate.setInt(OID_VAL_COM_49, pers.getVal_com_49().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_49, java.sql.Types.INTEGER);
		if (pers.getVal_com_50() != null)
			qUpdate.setInt(OID_VAL_COM_50, pers.getVal_com_50().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_50, java.sql.Types.INTEGER);
		if (pers.getVal_com_51() != null)
			qUpdate.setInt(OID_VAL_COM_51, pers.getVal_com_51().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_51, java.sql.Types.INTEGER);
		if (pers.getVal_com_52() != null)
			qUpdate.setInt(OID_VAL_COM_52, pers.getVal_com_52().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_52, java.sql.Types.INTEGER);
		if (pers.getVal_com_53() != null)
			qUpdate.setInt(OID_VAL_COM_53, pers.getVal_com_53().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_53, java.sql.Types.INTEGER);
		if (pers.getVal_com_54() != null)
			qUpdate.setInt(OID_VAL_COM_54, pers.getVal_com_54().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_54, java.sql.Types.INTEGER);
		if (pers.getVal_com_55() != null)
			qUpdate.setInt(OID_VAL_COM_55, pers.getVal_com_55().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_55, java.sql.Types.INTEGER);
		if (pers.getVal_com_56() != null)
			qUpdate.setInt(OID_VAL_COM_56, pers.getVal_com_56().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_56, java.sql.Types.INTEGER);
		if (pers.getVal_com_57() != null)
			qUpdate.setInt(OID_VAL_COM_57, pers.getVal_com_57().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_57, java.sql.Types.INTEGER);
		if (pers.getVal_com_58() != null)
			qUpdate.setInt(OID_VAL_COM_58, pers.getVal_com_58().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_58, java.sql.Types.INTEGER);
		if (pers.getVal_com_59() != null)
			qUpdate.setInt(OID_VAL_COM_59, pers.getVal_com_59().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_59, java.sql.Types.INTEGER);
		if (pers.getVal_com_60() != null)
			qUpdate.setInt(OID_VAL_COM_60, pers.getVal_com_60().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_60, java.sql.Types.INTEGER);
		if (pers.getVal_com_61() != null)
			qUpdate.setInt(OID_VAL_COM_61, pers.getVal_com_61().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_61, java.sql.Types.INTEGER);
		if (pers.getVal_com_62() != null)
			qUpdate.setInt(OID_VAL_COM_62, pers.getVal_com_62().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_62, java.sql.Types.INTEGER);
		if (pers.getVal_com_63() != null)
			qUpdate.setInt(OID_VAL_COM_63, pers.getVal_com_63().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_63, java.sql.Types.INTEGER);
		if (pers.getVal_com_64() != null)
			qUpdate.setInt(OID_VAL_COM_64, pers.getVal_com_64().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_64, java.sql.Types.INTEGER);
		if (pers.getVal_com_65() != null)
			qUpdate.setInt(OID_VAL_COM_65, pers.getVal_com_65().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_65, java.sql.Types.INTEGER);
		if (pers.getVal_com_66() != null)
			qUpdate.setInt(OID_VAL_COM_66, pers.getVal_com_66().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_66, java.sql.Types.INTEGER);
		if (pers.getVal_com_67() != null)
			qUpdate.setInt(OID_VAL_COM_67, pers.getVal_com_67().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_67, java.sql.Types.INTEGER);
		if (pers.getVal_com_68() != null)
			qUpdate.setInt(OID_VAL_COM_68, pers.getVal_com_68().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_68, java.sql.Types.INTEGER);
		if (pers.getVal_com_69() != null)
			qUpdate.setInt(OID_VAL_COM_69, pers.getVal_com_69().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_69, java.sql.Types.INTEGER);
		if (pers.getVal_com_70() != null)
			qUpdate.setInt(OID_VAL_COM_70, pers.getVal_com_70().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_70, java.sql.Types.INTEGER);
		if (pers.getVal_com_71() != null)
			qUpdate.setInt(OID_VAL_COM_71, pers.getVal_com_71().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_71, java.sql.Types.INTEGER);
		if (pers.getVal_com_72() != null)
			qUpdate.setInt(OID_VAL_COM_72, pers.getVal_com_72().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_72, java.sql.Types.INTEGER);
		if (pers.getVal_com_73() != null)
			qUpdate.setInt(OID_VAL_COM_73, pers.getVal_com_73().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_73, java.sql.Types.INTEGER);
		if (pers.getVal_com_74() != null)
			qUpdate.setInt(OID_VAL_COM_74, pers.getVal_com_74().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_74, java.sql.Types.INTEGER);
		if (pers.getVal_com_75() != null)
			qUpdate.setInt(OID_VAL_COM_75, pers.getVal_com_75().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_75, java.sql.Types.INTEGER);
		if (pers.getVal_com_76() != null)
			qUpdate.setInt(OID_VAL_COM_76, pers.getVal_com_76().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_76, java.sql.Types.INTEGER);
		if (pers.getVal_com_77() != null)
			qUpdate.setInt(OID_VAL_COM_77, pers.getVal_com_77().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_77, java.sql.Types.INTEGER);
		if (pers.getVal_com_78() != null)
			qUpdate.setInt(OID_VAL_COM_78, pers.getVal_com_78().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_78, java.sql.Types.INTEGER);
		if (pers.getVal_com_79() != null)
			qUpdate.setInt(OID_VAL_COM_79, pers.getVal_com_79().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_79, java.sql.Types.INTEGER);
		if (pers.getVal_com_80() != null)
			qUpdate.setInt(OID_VAL_COM_80, pers.getVal_com_80().getOID());
		else
			qUpdate.setNull(OID_VAL_COM_80, java.sql.Types.INTEGER);

		if (pers.getVal_num_1() != null)
			qUpdate.setDouble(VAL_NUM_1, pers.getVal_num_1().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_1, Types.DOUBLE);
		if (pers.getVal_num_2() != null)
			qUpdate.setDouble(VAL_NUM_2, pers.getVal_num_2().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_2, Types.DOUBLE);
		if (pers.getVal_num_3() != null)
			qUpdate.setDouble(VAL_NUM_3, pers.getVal_num_3().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_3, Types.DOUBLE);
		if (pers.getVal_num_4() != null)
			qUpdate.setDouble(VAL_NUM_4, pers.getVal_num_4().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_4, Types.DOUBLE);
		if (pers.getVal_num_5() != null)
			qUpdate.setDouble(VAL_NUM_5, pers.getVal_num_5().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_5, Types.DOUBLE);
		if (pers.getVal_num_6() != null)
			qUpdate.setDouble(VAL_NUM_6, pers.getVal_num_6().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_6, Types.DOUBLE);
		if (pers.getVal_num_7() != null)
			qUpdate.setDouble(VAL_NUM_7, pers.getVal_num_7().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_7, Types.DOUBLE);
		if (pers.getVal_num_8() != null)
			qUpdate.setDouble(VAL_NUM_8, pers.getVal_num_8().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_8, Types.DOUBLE);
		if (pers.getVal_num_9() != null)
			qUpdate.setDouble(VAL_NUM_9, pers.getVal_num_9().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_9, Types.DOUBLE);
		if (pers.getVal_num_10() != null)
			qUpdate.setDouble(VAL_NUM_10, pers.getVal_num_10().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_10, Types.DOUBLE);
		if (pers.getVal_num_11() != null)
			qUpdate.setDouble(VAL_NUM_11, pers.getVal_num_11().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_11, Types.DOUBLE);
		if (pers.getVal_num_12() != null)
			qUpdate.setDouble(VAL_NUM_12, pers.getVal_num_12().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_12, Types.DOUBLE);
		if (pers.getVal_num_13() != null)
			qUpdate.setDouble(VAL_NUM_13, pers.getVal_num_13().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_13, Types.DOUBLE);
		if (pers.getVal_num_14() != null)
			qUpdate.setDouble(VAL_NUM_14, pers.getVal_num_14().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_14, Types.DOUBLE);
		if (pers.getVal_num_15() != null)
			qUpdate.setDouble(VAL_NUM_15, pers.getVal_num_15().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_15, Types.DOUBLE);
		if (pers.getVal_num_16() != null)
			qUpdate.setDouble(VAL_NUM_16, pers.getVal_num_16().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_16, Types.DOUBLE);
		if (pers.getVal_num_17() != null)
			qUpdate.setDouble(VAL_NUM_17, pers.getVal_num_17().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_17, Types.DOUBLE);
		if (pers.getVal_num_18() != null)
			qUpdate.setDouble(VAL_NUM_18, pers.getVal_num_18().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_18, Types.DOUBLE);
		if (pers.getVal_num_19() != null)
			qUpdate.setDouble(VAL_NUM_19, pers.getVal_num_19().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_19, Types.DOUBLE);
		if (pers.getVal_num_20() != null)
			qUpdate.setDouble(VAL_NUM_20, pers.getVal_num_20().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_20, Types.DOUBLE);
		if (pers.getVal_num_21() != null)
			qUpdate.setDouble(VAL_NUM_21, pers.getVal_num_21().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_21, Types.DOUBLE);
		if (pers.getVal_num_22() != null)
			qUpdate.setDouble(VAL_NUM_22, pers.getVal_num_22().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_22, Types.DOUBLE);
		if (pers.getVal_num_23() != null)
			qUpdate.setDouble(VAL_NUM_23, pers.getVal_num_23().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_23, Types.DOUBLE);
		if (pers.getVal_num_24() != null)
			qUpdate.setDouble(VAL_NUM_24, pers.getVal_num_24().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_24, Types.DOUBLE);
		if (pers.getVal_num_25() != null)
			qUpdate.setDouble(VAL_NUM_25, pers.getVal_num_25().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_25, Types.DOUBLE);
		if (pers.getVal_num_26() != null)
			qUpdate.setDouble(VAL_NUM_26, pers.getVal_num_26().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_26, Types.DOUBLE);
		if (pers.getVal_num_27() != null)
			qUpdate.setDouble(VAL_NUM_27, pers.getVal_num_27().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_27, Types.DOUBLE);
		if (pers.getVal_num_28() != null)
			qUpdate.setDouble(VAL_NUM_28, pers.getVal_num_28().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_28, Types.DOUBLE);
		if (pers.getVal_num_29() != null)
			qUpdate.setDouble(VAL_NUM_29, pers.getVal_num_29().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_29, Types.DOUBLE);
		if (pers.getVal_num_30() != null)
			qUpdate.setDouble(VAL_NUM_30, pers.getVal_num_30().doubleValue());
		else
			qUpdate.setNull(VAL_NUM_30, Types.DOUBLE);
		if (pers.getVal_tex_1() != null)
			qUpdate.setString(VAL_TEX_1, pers.getVal_tex_1());
		else
			qUpdate.setNull(VAL_TEX_1, Types.VARCHAR);
		if (pers.getVal_tex_2() != null)
			qUpdate.setString(VAL_TEX_2, pers.getVal_tex_2());
		else
			qUpdate.setNull(VAL_TEX_2, Types.VARCHAR);
		if (pers.getVal_tex_3() != null)
			qUpdate.setString(VAL_TEX_3, pers.getVal_tex_3());
		else
			qUpdate.setNull(VAL_TEX_3, Types.VARCHAR);
		if (pers.getVal_tex_4() != null)
			qUpdate.setString(VAL_TEX_4, pers.getVal_tex_4());
		else
			qUpdate.setNull(VAL_TEX_4, Types.VARCHAR);
		if (pers.getVal_tex_5() != null)
			qUpdate.setString(VAL_TEX_5, pers.getVal_tex_5());
		else
			qUpdate.setNull(VAL_TEX_5, Types.VARCHAR);
		if (pers.getVal_tex_6() != null)
			qUpdate.setString(VAL_TEX_6, pers.getVal_tex_6());
		else
			qUpdate.setNull(VAL_TEX_6, Types.VARCHAR);
		if (pers.getVal_tex_7() != null)
			qUpdate.setString(VAL_TEX_7, pers.getVal_tex_7());
		else
			qUpdate.setNull(VAL_TEX_7, Types.VARCHAR);
		if (pers.getVal_tex_8() != null)
			qUpdate.setString(VAL_TEX_8, pers.getVal_tex_8());
		else
			qUpdate.setNull(VAL_TEX_8, Types.VARCHAR);
		if (pers.getVal_tex_9() != null)
			qUpdate.setString(VAL_TEX_9, pers.getVal_tex_9());
		else
			qUpdate.setNull(VAL_TEX_9, Types.VARCHAR);
		if (pers.getVal_tex_10() != null)
			qUpdate.setString(VAL_TEX_10, pers.getVal_tex_10());
		else
			qUpdate.setNull(VAL_TEX_10, Types.VARCHAR);
		if (pers.getVal_tex_11() != null)
			qUpdate.setString(VAL_TEX_11, pers.getVal_tex_11());
		else
			qUpdate.setNull(VAL_TEX_11, Types.VARCHAR);
		if (pers.getVal_tex_12() != null)
			qUpdate.setString(VAL_TEX_12, pers.getVal_tex_12());
		else
			qUpdate.setNull(VAL_TEX_12, Types.VARCHAR);
		if (pers.getVal_tex_13() != null)
			qUpdate.setString(VAL_TEX_13, pers.getVal_tex_13());
		else
			qUpdate.setNull(VAL_TEX_13, Types.VARCHAR);
		if (pers.getVal_tex_14() != null)
			qUpdate.setString(VAL_TEX_14, pers.getVal_tex_14());
		else
			qUpdate.setNull(VAL_TEX_14, Types.VARCHAR);
		if (pers.getVal_tex_15() != null)
			qUpdate.setString(VAL_TEX_15, pers.getVal_tex_15());
		else
			qUpdate.setNull(VAL_TEX_15, Types.VARCHAR);
		if (pers.getVal_tex_16() != null)
			qUpdate.setString(VAL_TEX_16, pers.getVal_tex_16());
		else
			qUpdate.setNull(VAL_TEX_16, Types.VARCHAR);
		if (pers.getVal_tex_17() != null)
			qUpdate.setString(VAL_TEX_17, pers.getVal_tex_17());
		else
			qUpdate.setNull(VAL_TEX_17, Types.VARCHAR);
		if (pers.getVal_tex_18() != null)
			qUpdate.setString(VAL_TEX_18, pers.getVal_tex_18());
		else
			qUpdate.setNull(VAL_TEX_18, Types.VARCHAR);
		if (pers.getVal_tex_19() != null)
			qUpdate.setString(VAL_TEX_19, pers.getVal_tex_19());
		else
			qUpdate.setNull(VAL_TEX_19, Types.VARCHAR);
		if (pers.getVal_tex_20() != null)
			qUpdate.setString(VAL_TEX_20, pers.getVal_tex_20());
		else
			qUpdate.setNull(VAL_TEX_20, Types.VARCHAR);
		if (pers.getVal_fec_1() != null)
			qUpdate.setDate(VAL_FEC_1, new Date(pers.getVal_fec_1().getTime()));
		else
			qUpdate.setNull(VAL_FEC_1, java.sql.Types.DATE);
		if (pers.getVal_fec_2() != null)
			qUpdate.setDate(VAL_FEC_2, new Date(pers.getVal_fec_2().getTime()));
		else
			qUpdate.setNull(VAL_FEC_2, java.sql.Types.DATE);
		if (pers.getVal_fec_3() != null)
			qUpdate.setDate(VAL_FEC_3, new Date(pers.getVal_fec_3().getTime()));
		else
			qUpdate.setNull(VAL_FEC_3, java.sql.Types.DATE);
		if (pers.getVal_fec_4() != null)
			qUpdate.setDate(VAL_FEC_4, new Date(pers.getVal_fec_4().getTime()));
		else
			qUpdate.setNull(VAL_FEC_4, java.sql.Types.DATE);
		if (pers.getVal_fec_5() != null)
			qUpdate.setDate(VAL_FEC_5, new Date(pers.getVal_fec_5().getTime()));
		else
			qUpdate.setNull(VAL_FEC_5, java.sql.Types.DATE);
		if (pers.getVal_fec_6() != null)
			qUpdate.setDate(VAL_FEC_6, new Date(pers.getVal_fec_6().getTime()));
		else
			qUpdate.setNull(VAL_FEC_6, java.sql.Types.DATE);
		if (pers.getVal_fec_7() != null)
			qUpdate.setDate(VAL_FEC_7, new Date(pers.getVal_fec_7().getTime()));
		else
			qUpdate.setNull(VAL_FEC_7, java.sql.Types.DATE);
		if (pers.getVal_fec_8() != null)
			qUpdate.setDate(VAL_FEC_8, new Date(pers.getVal_fec_8().getTime()));
		else
			qUpdate.setNull(VAL_FEC_8, java.sql.Types.DATE);
		if (pers.getVal_fec_9() != null)
			qUpdate.setDate(VAL_FEC_9, new Date(pers.getVal_fec_9().getTime()));
		else
			qUpdate.setNull(VAL_FEC_9, java.sql.Types.DATE);
		if (pers.getVal_fec_10() != null)
			qUpdate.setDate(VAL_FEC_10, new Date(pers.getVal_fec_10().getTime()));
		else
			qUpdate.setNull(VAL_FEC_10, java.sql.Types.DATE);
		if (pers.getVal_fec_11() != null)
			qUpdate.setDate(VAL_FEC_11, new Date(pers.getVal_fec_11().getTime()));
		else
			qUpdate.setNull(VAL_FEC_11, java.sql.Types.DATE);
		if (pers.getVal_fec_12() != null)
			qUpdate.setDate(VAL_FEC_12, new Date(pers.getVal_fec_12().getTime()));
		else
			qUpdate.setNull(VAL_FEC_12, java.sql.Types.DATE);
		if (pers.getVal_fec_13() != null)
			qUpdate.setDate(VAL_FEC_13, new Date(pers.getVal_fec_13().getTime()));
		else
			qUpdate.setNull(VAL_FEC_13, java.sql.Types.DATE);
		if (pers.getVal_fec_14() != null)
			qUpdate.setDate(VAL_FEC_14, new Date(pers.getVal_fec_14().getTime()));
		else
			qUpdate.setNull(VAL_FEC_14, java.sql.Types.DATE);
		if (pers.getVal_fec_15() != null)
			qUpdate.setDate(VAL_FEC_15, new Date(pers.getVal_fec_15().getTime()));
		else
			qUpdate.setNull(VAL_FEC_15, java.sql.Types.DATE);
		if (pers.getVal_fec_16() != null)
			qUpdate.setDate(VAL_FEC_16, new Date(pers.getVal_fec_16().getTime()));
		else
			qUpdate.setNull(VAL_FEC_16, java.sql.Types.DATE);
		if (pers.getVal_fec_17() != null)
			qUpdate.setDate(VAL_FEC_17, new Date(pers.getVal_fec_17().getTime()));
		else
			qUpdate.setNull(VAL_FEC_17, java.sql.Types.DATE);
		if (pers.getVal_fec_18() != null)
			qUpdate.setDate(VAL_FEC_18, new Date(pers.getVal_fec_18().getTime()));
		else
			qUpdate.setNull(VAL_FEC_18, java.sql.Types.DATE);
		if (pers.getVal_fec_19() != null)
			qUpdate.setDate(VAL_FEC_19, new Date(pers.getVal_fec_19().getTime()));
		else
			qUpdate.setNull(VAL_FEC_19, java.sql.Types.DATE);
		if (pers.getVal_fec_20() != null)
			qUpdate.setDate(VAL_FEC_20, new Date(pers.getVal_fec_20().getTime()));
		else
			qUpdate.setNull(VAL_FEC_20, java.sql.Types.DATE);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VALOR_COMPO = 1;
		ValorCompoPresu pers = (ValorCompoPresu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update plValCompo " + " set activo=0 " + " where " + " oid_valor_compo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VALOR_COMPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VALOR_COMPO = 1;
		ValorCompoPresu pers = (ValorCompoPresu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update plValCompo " + " set activo=1 " + " where " + " oid_valor_compo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VALOR_COMPO, pers.getOID());
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
		case SELECT_BY_COMPO_PRESU: {
			ps = this.selectByCompoPresu(aCondiciones);
			break;
		}
		case SELECT_BY_COMPO_PRESU_CODIGO: {
			ps = this.selectByCompoPresuCodigo(aCondiciones);
			break;
		}
		case SELECT_BY_COMPO_PRESU_VAL_COMPO_ANT: {
			ps = this.selectByCompoPresuValCompoAnt(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VALOR_COMPO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plValCompo ");
		textSQL.append(" WHERE oid_valor_compo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VALOR_COMPO, oid);
		return querySelect;
	}

	
	private PreparedStatement selectByCompoPresuCodigo(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos cond = (HashTableDatos) aCondiciones;
		CompoPresupuestario compoPresu = (CompoPresupuestario) cond.get(CompoPresupuestario.NICKNAME);
		String codigo = (String) cond.get("CODIGO");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plValCompo ");
		textSQL.append(" WHERE oid_compo_presu = ? and codigo=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, compoPresu.getOID());
		querySelect.setString(2, codigo);
		return querySelect;

	}
	
	private PreparedStatement selectByCompoPresuValCompoAnt(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos cond = (HashTableDatos) aCondiciones;
		CompoPresupuestario compoPresu = (CompoPresupuestario) cond.get(CompoPresupuestario.NICKNAME);
		List listaValCompoPresu = (List) cond.get("LISTA_VAL_COMPO_PRESU");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plValCompo ");
		textSQL.append(" WHERE oid_compo_presu = ? ");
		
		// Adicionar los valores de componentes Presupuestarios
		Iterator iterValCompoPresu = listaValCompoPresu.iterator();
		while (iterValCompoPresu.hasNext()) {
			ValorCompoPresu valCompoPresu = (ValorCompoPresu) iterValCompoPresu.next();
			// Agregar un condicion de filtro que esta relacionada con el valor del componente presupuestario
			CompoPresupuestario compoPresuPadre = valCompoPresu.getCompoPresupuestario();
			
			Iterator iterDefAtri = compoPresu.getDefAtributos().iterator();
			while (iterDefAtri.hasNext()) {
				AtriCompoPresu atriCompoPresu = (AtriCompoPresu) iterDefAtri.next();
				if (atriCompoPresu.isCompoCodigoDescripcion()) {
														
					if (atriCompoPresu.getCompo_presu_atri().getOID() == compoPresuPadre.getOID()) {
						 textSQL.append(" and "+atriCompoPresu.getCampoTabla());
						 textSQL.append(" = ");
						 textSQL.append(valCompoPresu.getOIDInteger().toString());
					}
					
				}
			}
			
		}
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, compoPresu.getOID());

		return querySelect;

	}
	
	private PreparedStatement selectByCompoPresu(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos cond = (HashTableDatos) aCondiciones;
		CompoPresupuestario compoPresu = (CompoPresupuestario) cond.get(CompoPresupuestario.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plValCompo ");
		textSQL.append(" WHERE oid_compo_presu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, compoPresu.getOID());
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plValCompo ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_valor_compo oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from plValCompo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getValoresCompoPresuByValCompoAnt(HashTableDatos condiciones, 
			                                                 ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ValorCompoPresu.NICKNAME, DBValorCompoPresu.SELECT_BY_COMPO_PRESU_VAL_COMPO_ANT,
				condiciones, new ListObserver(), aSesion);
	}
	

	public static List getValoresCompoPresu(CompoPresupuestario compoPresu, ISesion aSesion) throws BaseException {
		HashTableDatos cond = new HashTableDatos();
		cond.put(CompoPresupuestario.NICKNAME,compoPresu);
		return (List) ObjetoLogico.getObjects(ValorCompoPresu.NICKNAME, DBValorCompoPresu.SELECT_BY_COMPO_PRESU,
				cond, new ListObserver(), aSesion);
	}
	
  public static ValorCompoPresu getValorBycodigo(CompoPresupuestario compoPresu,
  																							 String codigo,				
  																							 ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(CompoPresupuestario.NICKNAME,compoPresu);
  	condiciones.put("CODIGO",codigo);
  	return (ValorCompoPresu) ObjetoLogico.getObjects(ValorCompoPresu.NICKNAME,
	  				DBValorCompoPresu.SELECT_BY_COMPO_PRESU_CODIGO,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
	

}
