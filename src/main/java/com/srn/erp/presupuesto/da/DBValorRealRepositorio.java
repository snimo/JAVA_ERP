package com.srn.erp.presupuesto.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorCompoReal;
import com.srn.erp.presupuesto.bm.ValorEquivalenciaRepositorio;
import com.srn.erp.presupuesto.bm.ValorRealRepositorio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.XML.IDataSet;

public class DBValorRealRepositorio extends DBObjetoPersistente {

  public static final String OID_VAL_REPO_REAL = "oid_val_repo_real";
  public static final String OID_REPO_REAL = "oid_repo_real";
  public static final String OID_VAL_REAL_1 = "oid_val_real_1";
  public static final String OID_VAL_REAL_2 = "oid_val_real_2";
  public static final String OID_VAL_REAL_3 = "oid_val_real_3";
  public static final String OID_VAL_REAL_4 = "oid_val_real_4";
  public static final String OID_VAL_REAL_5 = "oid_val_real_5";
  public static final String OID_VAL_REAL_6 = "oid_val_real_6";
  public static final String OID_VAL_REAL_7 = "oid_val_real_7";
  public static final String OID_VAL_REAL_8 = "oid_val_real_8";
  public static final String OID_VAL_REAL_9 = "oid_val_real_9";
  public static final String OID_VAL_REAL_10 = "oid_val_real_10";
  public static final String OID_VAL_REAL_11 = "oid_val_real_11";
  public static final String OID_VAL_REAL_12 = "oid_val_real_12";
  public static final String OID_VAL_REAL_13 = "oid_val_real_13";
  public static final String OID_VAL_REAL_14 = "oid_val_real_14";
  public static final String OID_VAL_REAL_15 = "oid_val_real_15";
  public static final String OID_VAL_REAL_16 = "oid_val_real_16";
  public static final String OID_VAL_REAL_17 = "oid_val_real_17";
  public static final String OID_VAL_REAL_18 = "oid_val_real_18";
  public static final String OID_VAL_REAL_19 = "oid_val_real_19";
  public static final String OID_VAL_REAL_20 = "oid_val_real_20";
  public static final String OID_VAL_REAL_21 = "oid_val_real_21";
  public static final String OID_VAL_REAL_22 = "oid_val_real_22";
  public static final String OID_VAL_REAL_23 = "oid_val_real_23";
  public static final String OID_VAL_REAL_24 = "oid_val_real_24";
  public static final String OID_VAL_REAL_25 = "oid_val_real_25";
  public static final String OID_VAL_REAL_26 = "oid_val_real_26";
  public static final String OID_VAL_REAL_27 = "oid_val_real_27";
  public static final String OID_VAL_REAL_28 = "oid_val_real_28";
  public static final String OID_VAL_REAL_29 = "oid_val_real_29";
  public static final String OID_VAL_REAL_30 = "oid_val_real_30";
  public static final String OID_VAL_REAL_31 = "oid_val_real_31";
  public static final String OID_VAL_REAL_32 = "oid_val_real_32";
  public static final String OID_VAL_REAL_33 = "oid_val_real_33";
  public static final String OID_VAL_REAL_34 = "oid_val_real_34";
  public static final String OID_VAL_REAL_35 = "oid_val_real_35";
  public static final String OID_VAL_REAL_36 = "oid_val_real_36";
  public static final String OID_VAL_REAL_37 = "oid_val_real_37";
  public static final String OID_VAL_REAL_38 = "oid_val_real_38";
  public static final String OID_VAL_REAL_39 = "oid_val_real_39";
  public static final String OID_VAL_REAL_40 = "oid_val_real_40";
  public static final String OID_VAL_REAL_41 = "oid_val_real_41";
  public static final String OID_VAL_REAL_42 = "oid_val_real_42";
  public static final String OID_VAL_REAL_43 = "oid_val_real_43";
  public static final String OID_VAL_REAL_44 = "oid_val_real_44";
  public static final String OID_VAL_REAL_45 = "oid_val_real_45";
  public static final String OID_VAL_REAL_46 = "oid_val_real_46";
  public static final String OID_VAL_REAL_47 = "oid_val_real_47";
  public static final String OID_VAL_REAL_48 = "oid_val_real_48";
  public static final String OID_VAL_REAL_49 = "oid_val_real_49";
  public static final String OID_VAL_REAL_50 = "oid_val_real_50";
  public static final String OID_VAL_REAL_51 = "oid_val_real_51";
  public static final String OID_VAL_REAL_52 = "oid_val_real_52";
  public static final String OID_VAL_REAL_53 = "oid_val_real_53";
  public static final String OID_VAL_REAL_54 = "oid_val_real_54";
  public static final String OID_VAL_REAL_55 = "oid_val_real_55";
  public static final String OID_VAL_REAL_56 = "oid_val_real_56";
  public static final String OID_VAL_REAL_57 = "oid_val_real_57";
  public static final String OID_VAL_REAL_58 = "oid_val_real_58";
  public static final String OID_VAL_REAL_59 = "oid_val_real_59";
  public static final String OID_VAL_REAL_60 = "oid_val_real_60";
  public static final String OID_VAL_REAL_61 = "oid_val_real_61";
  public static final String OID_VAL_REAL_62 = "oid_val_real_62";
  public static final String OID_VAL_REAL_63 = "oid_val_real_63";
  public static final String OID_VAL_REAL_64 = "oid_val_real_64";
  public static final String OID_VAL_REAL_65 = "oid_val_real_65";
  public static final String OID_VAL_REAL_66 = "oid_val_real_66";
  public static final String OID_VAL_REAL_67 = "oid_val_real_67";
  public static final String OID_VAL_REAL_68 = "oid_val_real_68";
  public static final String OID_VAL_REAL_69 = "oid_val_real_69";
  public static final String OID_VAL_REAL_70 = "oid_val_real_70";
  public static final String OID_VAL_REAL_71 = "oid_val_real_71";
  public static final String OID_VAL_REAL_72 = "oid_val_real_72";
  public static final String OID_VAL_REAL_73 = "oid_val_real_73";
  public static final String OID_VAL_REAL_74 = "oid_val_real_74";
  public static final String OID_VAL_REAL_75 = "oid_val_real_75";
  public static final String OID_VAL_REAL_76 = "oid_val_real_76";
  public static final String OID_VAL_REAL_77 = "oid_val_real_77";
  public static final String OID_VAL_REAL_78 = "oid_val_real_78";
  public static final String OID_VAL_REAL_79 = "oid_val_real_79";
  public static final String OID_VAL_REAL_80 = "oid_val_real_80";
  public static final String OID_VAL_REAL_81 = "oid_val_real_81";
  public static final String OID_VAL_REAL_82 = "oid_val_real_82";
  public static final String OID_VAL_REAL_83 = "oid_val_real_83";
  public static final String OID_VAL_REAL_84 = "oid_val_real_84";
  public static final String OID_VAL_REAL_85 = "oid_val_real_85";
  public static final String OID_VAL_REAL_86 = "oid_val_real_86";
  public static final String OID_VAL_REAL_87 = "oid_val_real_87";
  public static final String OID_VAL_REAL_88 = "oid_val_real_88";
  public static final String OID_VAL_REAL_89 = "oid_val_real_89";
  public static final String OID_VAL_REAL_90 = "oid_val_real_90";
  public static final String OID_VAL_REAL_91 = "oid_val_real_91";
  public static final String OID_VAL_REAL_92 = "oid_val_real_92";
  public static final String OID_VAL_REAL_93 = "oid_val_real_93";
  public static final String OID_VAL_REAL_94 = "oid_val_real_94";
  public static final String OID_VAL_REAL_95 = "oid_val_real_95";
  public static final String OID_VAL_REAL_96 = "oid_val_real_96";
  public static final String OID_VAL_REAL_97 = "oid_val_real_97";
  public static final String OID_VAL_REAL_98 = "oid_val_real_98";
  public static final String OID_VAL_REAL_99 = "oid_val_real_99";
  public static final String OID_VAL_REAL_100 = "oid_val_real_100";
  public static final String VAL_METRICA_1 = "val_metrica_1";
  public static final String VAL_METRICA_2 = "val_metrica_2";
  public static final String VAL_METRICA_3 = "val_metrica_3";
  public static final String VAL_METRICA_4 = "val_metrica_4";
  public static final String VAL_METRICA_5 = "val_metrica_5";
  public static final String VAL_METRICA_6 = "val_metrica_6";
  public static final String VAL_METRICA_7 = "val_metrica_7";
  public static final String VAL_METRICA_8 = "val_metrica_8";
  public static final String VAL_METRICA_9 = "val_metrica_9";
  public static final String VAL_METRICA_10 = "val_metrica_10";
  public static final String VAL_METRICA_11 = "val_metrica_11";
  public static final String VAL_METRICA_12 = "val_metrica_12";
  public static final String VAL_METRICA_13 = "val_metrica_13";
  public static final String VAL_METRICA_14 = "val_metrica_14";
  public static final String VAL_METRICA_15 = "val_metrica_15";
  public static final String VAL_METRICA_16 = "val_metrica_16";
  public static final String VAL_METRICA_17 = "val_metrica_17";
  public static final String VAL_METRICA_18 = "val_metrica_18";
  public static final String VAL_METRICA_19 = "val_metrica_19";
  public static final String VAL_METRICA_20 = "val_metrica_20";
  public static final String VAL_METRICA_21 = "val_metrica_21";
  public static final String VAL_METRICA_22 = "val_metrica_22";
  public static final String VAL_METRICA_23 = "val_metrica_23";
  public static final String VAL_METRICA_24 = "val_metrica_24";
  public static final String VAL_METRICA_25 = "val_metrica_25";
  public static final String VAL_METRICA_26 = "val_metrica_26";
  public static final String VAL_METRICA_27 = "val_metrica_27";
  public static final String VAL_METRICA_28 = "val_metrica_28";
  public static final String VAL_METRICA_29 = "val_metrica_29";
  public static final String VAL_METRICA_30 = "val_metrica_30";
  public static final String VAL_METRICA_31 = "val_metrica_31";
  public static final String VAL_METRICA_32 = "val_metrica_32";
  public static final String VAL_METRICA_33 = "val_metrica_33";
  public static final String VAL_METRICA_34 = "val_metrica_34";
  public static final String VAL_METRICA_35 = "val_metrica_35";
  public static final String VAL_METRICA_36 = "val_metrica_36";
  public static final String VAL_METRICA_37 = "val_metrica_37";
  public static final String VAL_METRICA_38 = "val_metrica_38";
  public static final String VAL_METRICA_39 = "val_metrica_39";
  public static final String VAL_METRICA_40 = "val_metrica_40";
  public static final String VAL_METRICA_41 = "val_metrica_41";
  public static final String VAL_METRICA_42 = "val_metrica_42";
  public static final String VAL_METRICA_43 = "val_metrica_43";
  public static final String VAL_METRICA_44 = "val_metrica_44";
  public static final String VAL_METRICA_45 = "val_metrica_45";
  public static final String VAL_METRICA_46 = "val_metrica_46";
  public static final String VAL_METRICA_47 = "val_metrica_47";
  public static final String VAL_METRICA_48 = "val_metrica_48";
  public static final String VAL_METRICA_49 = "val_metrica_49";
  public static final String VAL_METRICA_50 = "val_metrica_50";
  public static final String FEC_TIPO_PERI_1 = "fec_tipo_peri_1";
  public static final String FEC_TIPO_PERI_2 = "fec_tipo_peri_2";
  public static final String FEC_TIPO_PERI_3 = "fec_tipo_peri_3";
  public static final String FEC_TIPO_PERI_4 = "fec_tipo_peri_4";
  public static final String FEC_TIPO_PERI_5 = "fec_tipo_peri_5";
  public static final String FEC_TIPO_PERI_6 = "fec_tipo_peri_6";
  public static final String FEC_TIPO_PERI_7 = "fec_tipo_peri_7";
  public static final String FEC_TIPO_PERI_8 = "fec_tipo_peri_8";
  public static final String FEC_TIPO_PERI_9 = "fec_tipo_peri_9";
  public static final String FEC_TIPO_PERI_10 = "fec_tipo_peri_10";
  public static final String FEC_TIPO_PERI_11 = "fec_tipo_peri_11";
  public static final String FEC_TIPO_PERI_12 = "fec_tipo_peri_12";
  public static final String FEC_TIPO_PERI_13 = "fec_tipo_peri_13";
  public static final String FEC_TIPO_PERI_14 = "fec_tipo_peri_14";
  public static final String FEC_TIPO_PERI_15 = "fec_tipo_peri_15";
  public static final String FEC_TIPO_PERI_16 = "fec_tipo_peri_16";
  public static final String FEC_TIPO_PERI_17 = "fec_tipo_peri_17";
  public static final String FEC_TIPO_PERI_18 = "fec_tipo_peri_18";
  public static final String FEC_TIPO_PERI_19 = "fec_tipo_peri_19";
  public static final String FEC_TIPO_PERI_20 = "fec_tipo_peri_20";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_REPOSITORIO_REAL = 100;
  public static final int SELECT_BY_FILTROS_VARIOS = 101;

  public DBValorRealRepositorio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_REPO_REAL = 1;
    final int OID_REPO_REAL = 2;
    final int OID_VAL_REAL_1 = 3;
    final int OID_VAL_REAL_2 = 4;
    final int OID_VAL_REAL_3 = 5;
    final int OID_VAL_REAL_4 = 6;
    final int OID_VAL_REAL_5 = 7;
    final int OID_VAL_REAL_6 = 8;
    final int OID_VAL_REAL_7 = 9;
    final int OID_VAL_REAL_8 = 10;
    final int OID_VAL_REAL_9 = 11;
    final int OID_VAL_REAL_10 = 12;
    final int OID_VAL_REAL_11 = 13;
    final int OID_VAL_REAL_12 = 14;
    final int OID_VAL_REAL_13 = 15;
    final int OID_VAL_REAL_14 = 16;
    final int OID_VAL_REAL_15 = 17;
    final int OID_VAL_REAL_16 = 18;
    final int OID_VAL_REAL_17 = 19;
    final int OID_VAL_REAL_18 = 20;
    final int OID_VAL_REAL_19 = 21;
    final int OID_VAL_REAL_20 = 22;
    final int OID_VAL_REAL_21 = 23;
    final int OID_VAL_REAL_22 = 24;
    final int OID_VAL_REAL_23 = 25;
    final int OID_VAL_REAL_24 = 26;
    final int OID_VAL_REAL_25 = 27;
    final int OID_VAL_REAL_26 = 28;
    final int OID_VAL_REAL_27 = 29;
    final int OID_VAL_REAL_28 = 30;
    final int OID_VAL_REAL_29 = 31;
    final int OID_VAL_REAL_30 = 32;
    final int OID_VAL_REAL_31 = 33;
    final int OID_VAL_REAL_32 = 34;
    final int OID_VAL_REAL_33 = 35;
    final int OID_VAL_REAL_34 = 36;
    final int OID_VAL_REAL_35 = 37;
    final int OID_VAL_REAL_36 = 38;
    final int OID_VAL_REAL_37 = 39;
    final int OID_VAL_REAL_38 = 40;
    final int OID_VAL_REAL_39 = 41;
    final int OID_VAL_REAL_40 = 42;
    final int OID_VAL_REAL_41 = 43;
    final int OID_VAL_REAL_42 = 44;
    final int OID_VAL_REAL_43 = 45;
    final int OID_VAL_REAL_44 = 46;
    final int OID_VAL_REAL_45 = 47;
    final int OID_VAL_REAL_46 = 48;
    final int OID_VAL_REAL_47 = 49;
    final int OID_VAL_REAL_48 = 50;
    final int OID_VAL_REAL_49 = 51;
    final int OID_VAL_REAL_50 = 52;
    final int OID_VAL_REAL_51 = 53;
    final int OID_VAL_REAL_52 = 54;
    final int OID_VAL_REAL_53 = 55;
    final int OID_VAL_REAL_54 = 56;
    final int OID_VAL_REAL_55 = 57;
    final int OID_VAL_REAL_56 = 58;
    final int OID_VAL_REAL_57 = 59;
    final int OID_VAL_REAL_58 = 60;
    final int OID_VAL_REAL_59 = 61;
    final int OID_VAL_REAL_60 = 62;
    final int OID_VAL_REAL_61 = 63;
    final int OID_VAL_REAL_62 = 64;
    final int OID_VAL_REAL_63 = 65;
    final int OID_VAL_REAL_64 = 66;
    final int OID_VAL_REAL_65 = 67;
    final int OID_VAL_REAL_66 = 68;
    final int OID_VAL_REAL_67 = 69;
    final int OID_VAL_REAL_68 = 70;
    final int OID_VAL_REAL_69 = 71;
    final int OID_VAL_REAL_70 = 72;
    final int OID_VAL_REAL_71 = 73;
    final int OID_VAL_REAL_72 = 74;
    final int OID_VAL_REAL_73 = 75;
    final int OID_VAL_REAL_74 = 76;
    final int OID_VAL_REAL_75 = 77;
    final int OID_VAL_REAL_76 = 78;
    final int OID_VAL_REAL_77 = 79;
    final int OID_VAL_REAL_78 = 80;
    final int OID_VAL_REAL_79 = 81;
    final int OID_VAL_REAL_80 = 82;
    final int OID_VAL_REAL_81 = 83;
    final int OID_VAL_REAL_82 = 84;
    final int OID_VAL_REAL_83 = 85;
    final int OID_VAL_REAL_84 = 86;
    final int OID_VAL_REAL_85 = 87;
    final int OID_VAL_REAL_86 = 88;
    final int OID_VAL_REAL_87 = 89;
    final int OID_VAL_REAL_88 = 90;
    final int OID_VAL_REAL_89 = 91;
    final int OID_VAL_REAL_90 = 92;
    final int OID_VAL_REAL_91 = 93;
    final int OID_VAL_REAL_92 = 94;
    final int OID_VAL_REAL_93 = 95;
    final int OID_VAL_REAL_94 = 96;
    final int OID_VAL_REAL_95 = 97;
    final int OID_VAL_REAL_96 = 98;
    final int OID_VAL_REAL_97 = 99;
    final int OID_VAL_REAL_98 = 100;
    final int OID_VAL_REAL_99 = 101;
    final int OID_VAL_REAL_100 = 102;
    final int VAL_METRICA_1 = 103;
    final int VAL_METRICA_2 = 104;
    final int VAL_METRICA_3 = 105;
    final int VAL_METRICA_4 = 106;
    final int VAL_METRICA_5 = 107;
    final int VAL_METRICA_6 = 108;
    final int VAL_METRICA_7 = 109;
    final int VAL_METRICA_8 = 110;
    final int VAL_METRICA_9 = 111;
    final int VAL_METRICA_10 = 112;
    final int VAL_METRICA_11 = 113;
    final int VAL_METRICA_12 = 114;
    final int VAL_METRICA_13 = 115;
    final int VAL_METRICA_14 = 116;
    final int VAL_METRICA_15 = 117;
    final int VAL_METRICA_16 = 118;
    final int VAL_METRICA_17 = 119;
    final int VAL_METRICA_18 = 120;
    final int VAL_METRICA_19 = 121;
    final int VAL_METRICA_20 = 122;
    final int VAL_METRICA_21 = 123;
    final int VAL_METRICA_22 = 124;
    final int VAL_METRICA_23 = 125;
    final int VAL_METRICA_24 = 126;
    final int VAL_METRICA_25 = 127;
    final int VAL_METRICA_26 = 128;
    final int VAL_METRICA_27 = 129;
    final int VAL_METRICA_28 = 130;
    final int VAL_METRICA_29 = 131;
    final int VAL_METRICA_30 = 132;
    final int VAL_METRICA_31 = 133;
    final int VAL_METRICA_32 = 134;
    final int VAL_METRICA_33 = 135;
    final int VAL_METRICA_34 = 136;
    final int VAL_METRICA_35 = 137;
    final int VAL_METRICA_36 = 138;
    final int VAL_METRICA_37 = 139;
    final int VAL_METRICA_38 = 140;
    final int VAL_METRICA_39 = 141;
    final int VAL_METRICA_40 = 142;
    final int VAL_METRICA_41 = 143;
    final int VAL_METRICA_42 = 144;
    final int VAL_METRICA_43 = 145;
    final int VAL_METRICA_44 = 146;
    final int VAL_METRICA_45 = 147;
    final int VAL_METRICA_46 = 148;
    final int VAL_METRICA_47 = 149;
    final int VAL_METRICA_48 = 150;
    final int VAL_METRICA_49 = 151;
    final int VAL_METRICA_50 = 152;
    final int FEC_TIPO_PERI_1 = 153;
    final int FEC_TIPO_PERI_2 = 154;
    final int FEC_TIPO_PERI_3 = 155;
    final int FEC_TIPO_PERI_4 = 156;
    final int FEC_TIPO_PERI_5 = 157;
    final int FEC_TIPO_PERI_6 = 158;
    final int FEC_TIPO_PERI_7 = 159;
    final int FEC_TIPO_PERI_8 = 160;
    final int FEC_TIPO_PERI_9 = 161;
    final int FEC_TIPO_PERI_10 = 162;
    final int FEC_TIPO_PERI_11 = 163;
    final int FEC_TIPO_PERI_12 = 164;
    final int FEC_TIPO_PERI_13 = 165;
    final int FEC_TIPO_PERI_14 = 166;
    final int FEC_TIPO_PERI_15 = 167;
    final int FEC_TIPO_PERI_16 = 168;
    final int FEC_TIPO_PERI_17 = 169;
    final int FEC_TIPO_PERI_18 = 170;
    final int FEC_TIPO_PERI_19 = 171;
    final int FEC_TIPO_PERI_20 = 172;
    final int ACTIVO = 173;

    ValorRealRepositorio pers = (ValorRealRepositorio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plValRepoReal "+
                     " ( "+
                      "OID_VAL_REPO_REAL,"+
                      "OID_REPO_REAL,"+
                      "OID_VAL_REAL_1,"+
                      "OID_VAL_REAL_2,"+
                      "OID_VAL_REAL_3,"+
                      "OID_VAL_REAL_4,"+
                      "OID_VAL_REAL_5,"+
                      "OID_VAL_REAL_6,"+
                      "OID_VAL_REAL_7,"+
                      "OID_VAL_REAL_8,"+
                      "OID_VAL_REAL_9,"+
                      "OID_VAL_REAL_10,"+
                      "OID_VAL_REAL_11,"+
                      "OID_VAL_REAL_12,"+
                      "OID_VAL_REAL_13,"+
                      "OID_VAL_REAL_14,"+
                      "OID_VAL_REAL_15,"+
                      "OID_VAL_REAL_16,"+
                      "OID_VAL_REAL_17,"+
                      "OID_VAL_REAL_18,"+
                      "OID_VAL_REAL_19,"+
                      "OID_VAL_REAL_20,"+
                      "OID_VAL_REAL_21,"+
                      "OID_VAL_REAL_22,"+
                      "OID_VAL_REAL_23,"+
                      "OID_VAL_REAL_24,"+
                      "OID_VAL_REAL_25,"+
                      "OID_VAL_REAL_26,"+
                      "OID_VAL_REAL_27,"+
                      "OID_VAL_REAL_28,"+
                      "OID_VAL_REAL_29,"+
                      "OID_VAL_REAL_30,"+
                      "OID_VAL_REAL_31,"+
                      "OID_VAL_REAL_32,"+
                      "OID_VAL_REAL_33,"+
                      "OID_VAL_REAL_34,"+
                      "OID_VAL_REAL_35,"+
                      "OID_VAL_REAL_36,"+
                      "OID_VAL_REAL_37,"+
                      "OID_VAL_REAL_38,"+
                      "OID_VAL_REAL_39,"+
                      "OID_VAL_REAL_40,"+
                      "OID_VAL_REAL_41,"+
                      "OID_VAL_REAL_42,"+
                      "OID_VAL_REAL_43,"+
                      "OID_VAL_REAL_44,"+
                      "OID_VAL_REAL_45,"+
                      "OID_VAL_REAL_46,"+
                      "OID_VAL_REAL_47,"+
                      "OID_VAL_REAL_48,"+
                      "OID_VAL_REAL_49,"+
                      "OID_VAL_REAL_50,"+
                      "OID_VAL_REAL_51,"+
                      "OID_VAL_REAL_52,"+
                      "OID_VAL_REAL_53,"+
                      "OID_VAL_REAL_54,"+
                      "OID_VAL_REAL_55,"+
                      "OID_VAL_REAL_56,"+
                      "OID_VAL_REAL_57,"+
                      "OID_VAL_REAL_58,"+
                      "OID_VAL_REAL_59,"+
                      "OID_VAL_REAL_60,"+
                      "OID_VAL_REAL_61,"+
                      "OID_VAL_REAL_62,"+
                      "OID_VAL_REAL_63,"+
                      "OID_VAL_REAL_64,"+
                      "OID_VAL_REAL_65,"+
                      "OID_VAL_REAL_66,"+
                      "OID_VAL_REAL_67,"+
                      "OID_VAL_REAL_68,"+
                      "OID_VAL_REAL_69,"+
                      "OID_VAL_REAL_70,"+
                      "OID_VAL_REAL_71,"+
                      "OID_VAL_REAL_72,"+
                      "OID_VAL_REAL_73,"+
                      "OID_VAL_REAL_74,"+
                      "OID_VAL_REAL_75,"+
                      "OID_VAL_REAL_76,"+
                      "OID_VAL_REAL_77,"+
                      "OID_VAL_REAL_78,"+
                      "OID_VAL_REAL_79,"+
                      "OID_VAL_REAL_80,"+
                      "OID_VAL_REAL_81,"+
                      "OID_VAL_REAL_82,"+
                      "OID_VAL_REAL_83,"+
                      "OID_VAL_REAL_84,"+
                      "OID_VAL_REAL_85,"+
                      "OID_VAL_REAL_86,"+
                      "OID_VAL_REAL_87,"+
                      "OID_VAL_REAL_88,"+
                      "OID_VAL_REAL_89,"+
                      "OID_VAL_REAL_90,"+
                      "OID_VAL_REAL_91,"+
                      "OID_VAL_REAL_92,"+
                      "OID_VAL_REAL_93,"+
                      "OID_VAL_REAL_94,"+
                      "OID_VAL_REAL_95,"+
                      "OID_VAL_REAL_96,"+
                      "OID_VAL_REAL_97,"+
                      "OID_VAL_REAL_98,"+
                      "OID_VAL_REAL_99,"+
                      "OID_VAL_REAL_100,"+
                      "VAL_METRICA_1,"+
                      "VAL_METRICA_2,"+
                      "VAL_METRICA_3,"+
                      "VAL_METRICA_4,"+
                      "VAL_METRICA_5,"+
                      "VAL_METRICA_6,"+
                      "VAL_METRICA_7,"+
                      "VAL_METRICA_8,"+
                      "VAL_METRICA_9,"+
                      "VAL_METRICA_10,"+
                      "VAL_METRICA_11,"+
                      "VAL_METRICA_12,"+
                      "VAL_METRICA_13,"+
                      "VAL_METRICA_14,"+
                      "VAL_METRICA_15,"+
                      "VAL_METRICA_16,"+
                      "VAL_METRICA_17,"+
                      "VAL_METRICA_18,"+
                      "VAL_METRICA_19,"+
                      "VAL_METRICA_20,"+
                      "VAL_METRICA_21,"+
                      "VAL_METRICA_22,"+
                      "VAL_METRICA_23,"+
                      "VAL_METRICA_24,"+
                      "VAL_METRICA_25,"+
                      "VAL_METRICA_26,"+
                      "VAL_METRICA_27,"+
                      "VAL_METRICA_28,"+
                      "VAL_METRICA_29,"+
                      "VAL_METRICA_30,"+
                      "VAL_METRICA_31,"+
                      "VAL_METRICA_32,"+
                      "VAL_METRICA_33,"+
                      "VAL_METRICA_34,"+
                      "VAL_METRICA_35,"+
                      "VAL_METRICA_36,"+
                      "VAL_METRICA_37,"+
                      "VAL_METRICA_38,"+
                      "VAL_METRICA_39,"+
                      "VAL_METRICA_40,"+
                      "VAL_METRICA_41,"+
                      "VAL_METRICA_42,"+
                      "VAL_METRICA_43,"+
                      "VAL_METRICA_44,"+
                      "VAL_METRICA_45,"+
                      "VAL_METRICA_46,"+
                      "VAL_METRICA_47,"+
                      "VAL_METRICA_48,"+
                      "VAL_METRICA_49,"+
                      "VAL_METRICA_50,"+
                      "FEC_TIPO_PERI_1,"+
                      "FEC_TIPO_PERI_2,"+
                      "FEC_TIPO_PERI_3,"+
                      "FEC_TIPO_PERI_4,"+
                      "FEC_TIPO_PERI_5,"+
                      "FEC_TIPO_PERI_6,"+
                      "FEC_TIPO_PERI_7,"+
                      "FEC_TIPO_PERI_8,"+
                      "FEC_TIPO_PERI_9,"+
                      "FEC_TIPO_PERI_10,"+
                      "FEC_TIPO_PERI_11,"+
                      "FEC_TIPO_PERI_12,"+
                      "FEC_TIPO_PERI_13,"+
                      "FEC_TIPO_PERI_14,"+
                      "FEC_TIPO_PERI_15,"+
                      "FEC_TIPO_PERI_16,"+
                      "FEC_TIPO_PERI_17,"+
                      "FEC_TIPO_PERI_18,"+
                      "FEC_TIPO_PERI_19,"+
                      "FEC_TIPO_PERI_20,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAL_REPO_REAL,pers.getOID());
    qInsert.setInt(OID_REPO_REAL,pers.getRepositorio_real().getOID());
    if (pers.getValor_real_1()!=null) 
      qInsert.setInt(OID_VAL_REAL_1,pers.getValor_real_1().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_1,java.sql.Types.INTEGER);
    if (pers.getValor_real_2()!=null) 
      qInsert.setInt(OID_VAL_REAL_2,pers.getValor_real_2().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_2,java.sql.Types.INTEGER);
    if (pers.getValor_real_3()!=null) 
      qInsert.setInt(OID_VAL_REAL_3,pers.getValor_real_3().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_3,java.sql.Types.INTEGER);
    if (pers.getValor_real_4()!=null) 
      qInsert.setInt(OID_VAL_REAL_4,pers.getValor_real_4().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_4,java.sql.Types.INTEGER);
    if (pers.getValor_real_5()!=null) 
      qInsert.setInt(OID_VAL_REAL_5,pers.getValor_real_5().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_5,java.sql.Types.INTEGER);
    if (pers.getValor_real_6()!=null) 
      qInsert.setInt(OID_VAL_REAL_6,pers.getValor_real_6().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_6,java.sql.Types.INTEGER);
    if (pers.getValor_real_7()!=null) 
      qInsert.setInt(OID_VAL_REAL_7,pers.getValor_real_7().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_7,java.sql.Types.INTEGER);
    if (pers.getValor_real_8()!=null) 
      qInsert.setInt(OID_VAL_REAL_8,pers.getValor_real_8().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_8,java.sql.Types.INTEGER);
    if (pers.getValor_real_9()!=null) 
      qInsert.setInt(OID_VAL_REAL_9,pers.getValor_real_9().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_9,java.sql.Types.INTEGER);
    if (pers.getValor_real_10()!=null) 
      qInsert.setInt(OID_VAL_REAL_10,pers.getValor_real_10().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_10,java.sql.Types.INTEGER);
    if (pers.getValor_real_11()!=null) 
      qInsert.setInt(OID_VAL_REAL_11,pers.getValor_real_11().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_11,java.sql.Types.INTEGER);
    if (pers.getValor_real_12()!=null) 
      qInsert.setInt(OID_VAL_REAL_12,pers.getValor_real_12().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_12,java.sql.Types.INTEGER);
    if (pers.getValor_real_13()!=null) 
      qInsert.setInt(OID_VAL_REAL_13,pers.getValor_real_13().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_13,java.sql.Types.INTEGER);
    if (pers.getValor_real_14()!=null) 
      qInsert.setInt(OID_VAL_REAL_14,pers.getValor_real_14().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_14,java.sql.Types.INTEGER);
    if (pers.getValor_real_15()!=null) 
      qInsert.setInt(OID_VAL_REAL_15,pers.getValor_real_15().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_15,java.sql.Types.INTEGER);
    if (pers.getValor_real_16()!=null) 
      qInsert.setInt(OID_VAL_REAL_16,pers.getValor_real_16().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_16,java.sql.Types.INTEGER);
    if (pers.getValor_real_17()!=null) 
      qInsert.setInt(OID_VAL_REAL_17,pers.getValor_real_17().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_17,java.sql.Types.INTEGER);
    if (pers.getValor_real_18()!=null) 
      qInsert.setInt(OID_VAL_REAL_18,pers.getValor_real_18().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_18,java.sql.Types.INTEGER);
    if (pers.getValor_real_19()!=null) 
      qInsert.setInt(OID_VAL_REAL_19,pers.getValor_real_19().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_19,java.sql.Types.INTEGER);
    if (pers.getValor_real_20()!=null) 
      qInsert.setInt(OID_VAL_REAL_20,pers.getValor_real_20().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_20,java.sql.Types.INTEGER);
    if (pers.getValor_real_21()!=null) 
      qInsert.setInt(OID_VAL_REAL_21,pers.getValor_real_21().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_21,java.sql.Types.INTEGER);
    if (pers.getValor_real_22()!=null) 
      qInsert.setInt(OID_VAL_REAL_22,pers.getValor_real_22().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_22,java.sql.Types.INTEGER);
    if (pers.getValor_real_23()!=null) 
      qInsert.setInt(OID_VAL_REAL_23,pers.getValor_real_23().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_23,java.sql.Types.INTEGER);
    if (pers.getValor_real_24()!=null) 
      qInsert.setInt(OID_VAL_REAL_24,pers.getValor_real_24().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_24,java.sql.Types.INTEGER);
    if (pers.getValor_real_25()!=null) 
      qInsert.setInt(OID_VAL_REAL_25,pers.getValor_real_25().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_25,java.sql.Types.INTEGER);
    if (pers.getValor_real_26()!=null) 
      qInsert.setInt(OID_VAL_REAL_26,pers.getValor_real_26().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_26,java.sql.Types.INTEGER);
    if (pers.getValor_real_27()!=null) 
      qInsert.setInt(OID_VAL_REAL_27,pers.getValor_real_27().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_27,java.sql.Types.INTEGER);
    if (pers.getValor_real_28()!=null) 
      qInsert.setInt(OID_VAL_REAL_28,pers.getValor_real_28().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_28,java.sql.Types.INTEGER);
    if (pers.getValor_real_29()!=null) 
      qInsert.setInt(OID_VAL_REAL_29,pers.getValor_real_29().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_29,java.sql.Types.INTEGER);
    if (pers.getValor_real_30()!=null) 
      qInsert.setInt(OID_VAL_REAL_30,pers.getValor_real_30().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_30,java.sql.Types.INTEGER);
    if (pers.getValor_real_31()!=null) 
      qInsert.setInt(OID_VAL_REAL_31,pers.getValor_real_31().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_31,java.sql.Types.INTEGER);
    if (pers.getValor_real_32()!=null) 
      qInsert.setInt(OID_VAL_REAL_32,pers.getValor_real_32().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_32,java.sql.Types.INTEGER);
    if (pers.getValor_real_33()!=null) 
      qInsert.setInt(OID_VAL_REAL_33,pers.getValor_real_33().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_33,java.sql.Types.INTEGER);
    if (pers.getValor_real_34()!=null) 
      qInsert.setInt(OID_VAL_REAL_34,pers.getValor_real_34().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_34,java.sql.Types.INTEGER);
    if (pers.getValor_real_35()!=null) 
      qInsert.setInt(OID_VAL_REAL_35,pers.getValor_real_35().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_35,java.sql.Types.INTEGER);
    if (pers.getValor_real_36()!=null) 
      qInsert.setInt(OID_VAL_REAL_36,pers.getValor_real_36().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_36,java.sql.Types.INTEGER);
    if (pers.getValor_real_37()!=null) 
      qInsert.setInt(OID_VAL_REAL_37,pers.getValor_real_37().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_37,java.sql.Types.INTEGER);
    if (pers.getValor_real_38()!=null) 
      qInsert.setInt(OID_VAL_REAL_38,pers.getValor_real_38().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_38,java.sql.Types.INTEGER);
    if (pers.getValor_real_39()!=null) 
      qInsert.setInt(OID_VAL_REAL_39,pers.getValor_real_39().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_39,java.sql.Types.INTEGER);
    if (pers.getValor_real_40()!=null) 
      qInsert.setInt(OID_VAL_REAL_40,pers.getValor_real_40().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_40,java.sql.Types.INTEGER);
    if (pers.getValor_real_41()!=null) 
      qInsert.setInt(OID_VAL_REAL_41,pers.getValor_real_41().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_41,java.sql.Types.INTEGER);
    if (pers.getValor_real_42()!=null) 
      qInsert.setInt(OID_VAL_REAL_42,pers.getValor_real_42().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_42,java.sql.Types.INTEGER);
    if (pers.getValor_real_43()!=null) 
      qInsert.setInt(OID_VAL_REAL_43,pers.getValor_real_43().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_43,java.sql.Types.INTEGER);
    if (pers.getValor_real_44()!=null) 
      qInsert.setInt(OID_VAL_REAL_44,pers.getValor_real_44().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_44,java.sql.Types.INTEGER);
    if (pers.getValor_real_45()!=null) 
      qInsert.setInt(OID_VAL_REAL_45,pers.getValor_real_45().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_45,java.sql.Types.INTEGER);
    if (pers.getValor_real_46()!=null) 
      qInsert.setInt(OID_VAL_REAL_46,pers.getValor_real_46().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_46,java.sql.Types.INTEGER);
    if (pers.getValor_real_47()!=null) 
      qInsert.setInt(OID_VAL_REAL_47,pers.getValor_real_47().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_47,java.sql.Types.INTEGER);
    if (pers.getValor_real_48()!=null) 
      qInsert.setInt(OID_VAL_REAL_48,pers.getValor_real_48().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_48,java.sql.Types.INTEGER);
    if (pers.getValor_real_49()!=null) 
      qInsert.setInt(OID_VAL_REAL_49,pers.getValor_real_49().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_49,java.sql.Types.INTEGER);
    if (pers.getValor_real_50()!=null) 
      qInsert.setInt(OID_VAL_REAL_50,pers.getValor_real_50().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_50,java.sql.Types.INTEGER);
    if (pers.getValor_real_51()!=null) 
      qInsert.setInt(OID_VAL_REAL_51,pers.getValor_real_51().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_51,java.sql.Types.INTEGER);
    if (pers.getValor_real_52()!=null) 
      qInsert.setInt(OID_VAL_REAL_52,pers.getValor_real_52().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_52,java.sql.Types.INTEGER);
    if (pers.getValor_real_53()!=null) 
      qInsert.setInt(OID_VAL_REAL_53,pers.getValor_real_53().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_53,java.sql.Types.INTEGER);
    if (pers.getValor_real_54()!=null) 
      qInsert.setInt(OID_VAL_REAL_54,pers.getValor_real_54().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_54,java.sql.Types.INTEGER);
    if (pers.getValor_real_55()!=null) 
      qInsert.setInt(OID_VAL_REAL_55,pers.getValor_real_55().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_55,java.sql.Types.INTEGER);
    if (pers.getValor_real_56()!=null) 
      qInsert.setInt(OID_VAL_REAL_56,pers.getValor_real_56().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_56,java.sql.Types.INTEGER);
    if (pers.getValor_real_57()!=null) 
      qInsert.setInt(OID_VAL_REAL_57,pers.getValor_real_57().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_57,java.sql.Types.INTEGER);
    if (pers.getValor_real_58()!=null) 
      qInsert.setInt(OID_VAL_REAL_58,pers.getValor_real_58().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_58,java.sql.Types.INTEGER);
    if (pers.getValor_real_59()!=null) 
      qInsert.setInt(OID_VAL_REAL_59,pers.getValor_real_59().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_59,java.sql.Types.INTEGER);
    if (pers.getValor_real_60()!=null) 
      qInsert.setInt(OID_VAL_REAL_60,pers.getValor_real_60().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_60,java.sql.Types.INTEGER);
    if (pers.getValor_real_61()!=null) 
      qInsert.setInt(OID_VAL_REAL_61,pers.getValor_real_61().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_61,java.sql.Types.INTEGER);
    if (pers.getValor_real_62()!=null) 
      qInsert.setInt(OID_VAL_REAL_62,pers.getValor_real_62().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_62,java.sql.Types.INTEGER);
    if (pers.getValor_real_63()!=null) 
      qInsert.setInt(OID_VAL_REAL_63,pers.getValor_real_63().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_63,java.sql.Types.INTEGER);
    if (pers.getValor_real_64()!=null) 
      qInsert.setInt(OID_VAL_REAL_64,pers.getValor_real_64().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_64,java.sql.Types.INTEGER);
    if (pers.getValor_real_65()!=null) 
      qInsert.setInt(OID_VAL_REAL_65,pers.getValor_real_65().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_65,java.sql.Types.INTEGER);
    if (pers.getValor_real_66()!=null) 
      qInsert.setInt(OID_VAL_REAL_66,pers.getValor_real_66().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_66,java.sql.Types.INTEGER);
    if (pers.getValor_real_67()!=null) 
      qInsert.setInt(OID_VAL_REAL_67,pers.getValor_real_67().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_67,java.sql.Types.INTEGER);
    if (pers.getValor_real_68()!=null) 
      qInsert.setInt(OID_VAL_REAL_68,pers.getValor_real_68().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_68,java.sql.Types.INTEGER);
    if (pers.getValor_real_69()!=null) 
      qInsert.setInt(OID_VAL_REAL_69,pers.getValor_real_69().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_69,java.sql.Types.INTEGER);
    if (pers.getValor_real_70()!=null) 
      qInsert.setInt(OID_VAL_REAL_70,pers.getValor_real_70().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_70,java.sql.Types.INTEGER);
    if (pers.getValor_real_71()!=null) 
      qInsert.setInt(OID_VAL_REAL_71,pers.getValor_real_71().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_71,java.sql.Types.INTEGER);
    if (pers.getValor_real_72()!=null) 
      qInsert.setInt(OID_VAL_REAL_72,pers.getValor_real_72().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_72,java.sql.Types.INTEGER);
    if (pers.getValor_real_73()!=null) 
      qInsert.setInt(OID_VAL_REAL_73,pers.getValor_real_73().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_73,java.sql.Types.INTEGER);
    if (pers.getValor_real_74()!=null) 
      qInsert.setInt(OID_VAL_REAL_74,pers.getValor_real_74().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_74,java.sql.Types.INTEGER);
    if (pers.getValor_real_75()!=null) 
      qInsert.setInt(OID_VAL_REAL_75,pers.getValor_real_75().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_75,java.sql.Types.INTEGER);
    if (pers.getValor_real_76()!=null) 
      qInsert.setInt(OID_VAL_REAL_76,pers.getValor_real_76().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_76,java.sql.Types.INTEGER);
    if (pers.getValor_real_77()!=null) 
      qInsert.setInt(OID_VAL_REAL_77,pers.getValor_real_77().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_77,java.sql.Types.INTEGER);
    if (pers.getValor_real_78()!=null) 
      qInsert.setInt(OID_VAL_REAL_78,pers.getValor_real_78().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_78,java.sql.Types.INTEGER);
    if (pers.getValor_real_79()!=null) 
      qInsert.setInt(OID_VAL_REAL_79,pers.getValor_real_79().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_79,java.sql.Types.INTEGER);
    if (pers.getValor_real_80()!=null) 
      qInsert.setInt(OID_VAL_REAL_80,pers.getValor_real_80().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_80,java.sql.Types.INTEGER);
    if (pers.getValor_real_81()!=null) 
      qInsert.setInt(OID_VAL_REAL_81,pers.getValor_real_81().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_81,java.sql.Types.INTEGER);
    if (pers.getValor_real_82()!=null) 
      qInsert.setInt(OID_VAL_REAL_82,pers.getValor_real_82().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_82,java.sql.Types.INTEGER);
    if (pers.getValor_real_83()!=null) 
      qInsert.setInt(OID_VAL_REAL_83,pers.getValor_real_83().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_83,java.sql.Types.INTEGER);
    if (pers.getValor_real_84()!=null) 
      qInsert.setInt(OID_VAL_REAL_84,pers.getValor_real_84().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_84,java.sql.Types.INTEGER);
    if (pers.getValor_real_85()!=null) 
      qInsert.setInt(OID_VAL_REAL_85,pers.getValor_real_85().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_85,java.sql.Types.INTEGER);
    if (pers.getValor_real_86()!=null) 
      qInsert.setInt(OID_VAL_REAL_86,pers.getValor_real_86().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_86,java.sql.Types.INTEGER);
    if (pers.getValor_real_87()!=null) 
      qInsert.setInt(OID_VAL_REAL_87,pers.getValor_real_87().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_87,java.sql.Types.INTEGER);
    if (pers.getValor_real_88()!=null) 
      qInsert.setInt(OID_VAL_REAL_88,pers.getValor_real_88().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_88,java.sql.Types.INTEGER);
    if (pers.getValor_real_89()!=null) 
      qInsert.setInt(OID_VAL_REAL_89,pers.getValor_real_89().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_89,java.sql.Types.INTEGER);
    if (pers.getValor_real_90()!=null) 
      qInsert.setInt(OID_VAL_REAL_90,pers.getValor_real_90().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_90,java.sql.Types.INTEGER);
    if (pers.getValor_real_91()!=null) 
      qInsert.setInt(OID_VAL_REAL_91,pers.getValor_real_91().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_91,java.sql.Types.INTEGER);
    if (pers.getValor_real_92()!=null) 
      qInsert.setInt(OID_VAL_REAL_92,pers.getValor_real_92().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_92,java.sql.Types.INTEGER);
    if (pers.getValor_real_93()!=null) 
      qInsert.setInt(OID_VAL_REAL_93,pers.getValor_real_93().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_93,java.sql.Types.INTEGER);
    if (pers.getValor_real_94()!=null) 
      qInsert.setInt(OID_VAL_REAL_94,pers.getValor_real_94().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_94,java.sql.Types.INTEGER);
    if (pers.getValor_real_95()!=null) 
      qInsert.setInt(OID_VAL_REAL_95,pers.getValor_real_95().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_95,java.sql.Types.INTEGER);
    if (pers.getValor_real_96()!=null) 
      qInsert.setInt(OID_VAL_REAL_96,pers.getValor_real_96().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_96,java.sql.Types.INTEGER);
    if (pers.getValor_real_97()!=null) 
      qInsert.setInt(OID_VAL_REAL_97,pers.getValor_real_97().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_97,java.sql.Types.INTEGER);
    if (pers.getValor_real_98()!=null) 
      qInsert.setInt(OID_VAL_REAL_98,pers.getValor_real_98().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_98,java.sql.Types.INTEGER);
    if (pers.getValor_real_99()!=null) 
      qInsert.setInt(OID_VAL_REAL_99,pers.getValor_real_99().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_99,java.sql.Types.INTEGER);
    if (pers.getValor_real_100()!=null) 
      qInsert.setInt(OID_VAL_REAL_100,pers.getValor_real_100().getOID());
    else
      qInsert.setNull(OID_VAL_REAL_100,java.sql.Types.INTEGER);
    
    if (pers.getVal_metrica_1()!=null)
    	qInsert.setDouble(VAL_METRICA_1,pers.getVal_metrica_1().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_1,Types.DOUBLE);
    if (pers.getVal_metrica_2()!=null)
    	qInsert.setDouble(VAL_METRICA_2,pers.getVal_metrica_2().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_2,Types.DOUBLE);
    if (pers.getVal_metrica_3()!=null)
    	qInsert.setDouble(VAL_METRICA_3,pers.getVal_metrica_3().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_3,Types.DOUBLE);
    if (pers.getVal_metrica_4()!=null)
    	qInsert.setDouble(VAL_METRICA_4,pers.getVal_metrica_4().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_4,Types.DOUBLE);
    if (pers.getVal_metrica_5()!=null)
    	qInsert.setDouble(VAL_METRICA_5,pers.getVal_metrica_5().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_5,Types.DOUBLE);
    if (pers.getVal_metrica_6()!=null)
    	qInsert.setDouble(VAL_METRICA_6,pers.getVal_metrica_6().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_6,Types.DOUBLE);
    if (pers.getVal_metrica_7()!=null)
    	qInsert.setDouble(VAL_METRICA_7,pers.getVal_metrica_7().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_7,Types.DOUBLE);
    if (pers.getVal_metrica_8()!=null)
    	qInsert.setDouble(VAL_METRICA_8,pers.getVal_metrica_8().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_8,Types.DOUBLE);
    if (pers.getVal_metrica_9()!=null)
    	qInsert.setDouble(VAL_METRICA_9,pers.getVal_metrica_9().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_9,Types.DOUBLE);
    if (pers.getVal_metrica_10()!=null)
    	qInsert.setDouble(VAL_METRICA_10,pers.getVal_metrica_10().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_10,Types.DOUBLE);
    if (pers.getVal_metrica_11()!=null)
    	qInsert.setDouble(VAL_METRICA_11,pers.getVal_metrica_11().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_11,Types.DOUBLE);
    if (pers.getVal_metrica_12()!=null)
    	qInsert.setDouble(VAL_METRICA_12,pers.getVal_metrica_12().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_12,Types.DOUBLE);
    if (pers.getVal_metrica_13()!=null)
    	qInsert.setDouble(VAL_METRICA_13,pers.getVal_metrica_13().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_13,Types.DOUBLE);
    if (pers.getVal_metrica_14()!=null)
    	qInsert.setDouble(VAL_METRICA_14,pers.getVal_metrica_14().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_14,Types.DOUBLE);
    if (pers.getVal_metrica_15()!=null)
    	qInsert.setDouble(VAL_METRICA_15,pers.getVal_metrica_15().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_15,Types.DOUBLE);
    if (pers.getVal_metrica_16()!=null)
    	qInsert.setDouble(VAL_METRICA_16,pers.getVal_metrica_16().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_16,Types.DOUBLE);
    if (pers.getVal_metrica_17()!=null)
    	qInsert.setDouble(VAL_METRICA_17,pers.getVal_metrica_17().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_17,Types.DOUBLE);
    if (pers.getVal_metrica_18()!=null)
    	qInsert.setDouble(VAL_METRICA_18,pers.getVal_metrica_18().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_18,Types.DOUBLE);
    if (pers.getVal_metrica_19()!=null)
    	qInsert.setDouble(VAL_METRICA_19,pers.getVal_metrica_19().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_19,Types.DOUBLE);
    if (pers.getVal_metrica_20()!=null)
    	qInsert.setDouble(VAL_METRICA_20,pers.getVal_metrica_20().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_20,Types.DOUBLE);
    if (pers.getVal_metrica_21()!=null)
    	qInsert.setDouble(VAL_METRICA_21,pers.getVal_metrica_21().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_21,Types.DOUBLE);
    if (pers.getVal_metrica_22()!=null)
    	qInsert.setDouble(VAL_METRICA_22,pers.getVal_metrica_22().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_22,Types.DOUBLE);
    if (pers.getVal_metrica_23()!=null)
    	qInsert.setDouble(VAL_METRICA_23,pers.getVal_metrica_23().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_23,Types.DOUBLE);
    if (pers.getVal_metrica_24()!=null)
    	qInsert.setDouble(VAL_METRICA_24,pers.getVal_metrica_24().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_24,Types.DOUBLE);
    if (pers.getVal_metrica_25()!=null)
    	qInsert.setDouble(VAL_METRICA_25,pers.getVal_metrica_25().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_25,Types.DOUBLE);
    if (pers.getVal_metrica_26()!=null)
    	qInsert.setDouble(VAL_METRICA_26,pers.getVal_metrica_26().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_26,Types.DOUBLE);
    if (pers.getVal_metrica_27()!=null)
    	qInsert.setDouble(VAL_METRICA_27,pers.getVal_metrica_27().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_27,Types.DOUBLE);
    if (pers.getVal_metrica_28()!=null)
    	qInsert.setDouble(VAL_METRICA_28,pers.getVal_metrica_28().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_28,Types.DOUBLE);
    if (pers.getVal_metrica_29()!=null)
    	qInsert.setDouble(VAL_METRICA_29,pers.getVal_metrica_29().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_29,Types.DOUBLE);
    if (pers.getVal_metrica_30()!=null)
    	qInsert.setDouble(VAL_METRICA_30,pers.getVal_metrica_30().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_30,Types.DOUBLE);
    if (pers.getVal_metrica_31()!=null)
    	qInsert.setDouble(VAL_METRICA_31,pers.getVal_metrica_31().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_31,Types.DOUBLE);
    if (pers.getVal_metrica_32()!=null)
    	qInsert.setDouble(VAL_METRICA_32,pers.getVal_metrica_32().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_32,Types.DOUBLE);
    if (pers.getVal_metrica_33()!=null)
    	qInsert.setDouble(VAL_METRICA_33,pers.getVal_metrica_33().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_33,Types.DOUBLE);
    if (pers.getVal_metrica_34()!=null)
    	qInsert.setDouble(VAL_METRICA_34,pers.getVal_metrica_34().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_34,Types.DOUBLE);
    if (pers.getVal_metrica_35()!=null)
    	qInsert.setDouble(VAL_METRICA_35,pers.getVal_metrica_35().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_35,Types.DOUBLE);
    if (pers.getVal_metrica_36()!=null)
    	qInsert.setDouble(VAL_METRICA_36,pers.getVal_metrica_36().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_36,Types.DOUBLE);
    if (pers.getVal_metrica_37()!=null)
    	qInsert.setDouble(VAL_METRICA_37,pers.getVal_metrica_37().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_37,Types.DOUBLE);
    if (pers.getVal_metrica_38()!=null)
    	qInsert.setDouble(VAL_METRICA_38,pers.getVal_metrica_38().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_38,Types.DOUBLE);
    if (pers.getVal_metrica_39()!=null)
    	qInsert.setDouble(VAL_METRICA_39,pers.getVal_metrica_39().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_39,Types.DOUBLE);
    if (pers.getVal_metrica_40()!=null)
    	qInsert.setDouble(VAL_METRICA_40,pers.getVal_metrica_40().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_40,Types.DOUBLE);
    if (pers.getVal_metrica_41()!=null)
    	qInsert.setDouble(VAL_METRICA_41,pers.getVal_metrica_41().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_41,Types.DOUBLE);
    if (pers.getVal_metrica_42()!=null)
    	qInsert.setDouble(VAL_METRICA_42,pers.getVal_metrica_42().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_42,Types.DOUBLE);
    if (pers.getVal_metrica_43()!=null)
    	qInsert.setDouble(VAL_METRICA_43,pers.getVal_metrica_43().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_43,Types.DOUBLE);
    if (pers.getVal_metrica_44()!=null)
    	qInsert.setDouble(VAL_METRICA_44,pers.getVal_metrica_44().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_44,Types.DOUBLE);
    if (pers.getVal_metrica_45()!=null)
    	qInsert.setDouble(VAL_METRICA_45,pers.getVal_metrica_45().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_45,Types.DOUBLE);
    if (pers.getVal_metrica_46()!=null)
    	qInsert.setDouble(VAL_METRICA_46,pers.getVal_metrica_46().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_46,Types.DOUBLE);
    if (pers.getVal_metrica_47()!=null)
    	qInsert.setDouble(VAL_METRICA_47,pers.getVal_metrica_47().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_47,Types.DOUBLE);
    if (pers.getVal_metrica_48()!=null)
    	qInsert.setDouble(VAL_METRICA_48,pers.getVal_metrica_48().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_48,Types.DOUBLE);
    if (pers.getVal_metrica_49()!=null)
    	qInsert.setDouble(VAL_METRICA_49,pers.getVal_metrica_49().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_49,Types.DOUBLE);
    if (pers.getVal_metrica_50()!=null)
    	qInsert.setDouble(VAL_METRICA_50,pers.getVal_metrica_50().doubleValue());
    else
    	qInsert.setNull(VAL_METRICA_50,Types.DOUBLE);
    
    if (pers.getFec_tipo_peri_1()!=null) 
      qInsert.setDate(FEC_TIPO_PERI_1,new Date(pers.getFec_tipo_peri_1().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_1,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_2()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_2,new Date(pers.getFec_tipo_peri_2().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_2,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_3()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_3,new Date(pers.getFec_tipo_peri_3().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_3,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_4()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_4,new Date(pers.getFec_tipo_peri_4().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_4,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_5()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_5,new Date(pers.getFec_tipo_peri_5().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_5,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_6()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_6,new Date(pers.getFec_tipo_peri_6().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_6,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_7()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_7,new Date(pers.getFec_tipo_peri_7().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_7,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_8()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_8,new Date(pers.getFec_tipo_peri_8().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_8,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_9()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_9,new Date(pers.getFec_tipo_peri_9().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_9,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_10()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_10,new Date(pers.getFec_tipo_peri_10().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_10,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_11()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_11,new Date(pers.getFec_tipo_peri_11().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_11,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_12()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_12,new Date(pers.getFec_tipo_peri_12().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_12,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_13()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_13,new Date(pers.getFec_tipo_peri_13().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_13,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_14()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_14,new Date(pers.getFec_tipo_peri_14().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_14,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_15()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_15,new Date(pers.getFec_tipo_peri_15().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_15,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_16()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_16,new Date(pers.getFec_tipo_peri_16().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_16,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_17()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_17,new Date(pers.getFec_tipo_peri_17().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_17,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_18()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_18,new Date(pers.getFec_tipo_peri_18().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_18,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_19()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_19,new Date(pers.getFec_tipo_peri_19().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_19,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_20()!=null) 
    	qInsert.setDate(FEC_TIPO_PERI_20,new Date(pers.getFec_tipo_peri_20().getTime()));
    else
      qInsert.setNull(FEC_TIPO_PERI_20,java.sql.Types.DATE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
    
    insertTablaEquivalencia(pers);
  }
  
  private void insertTablaEquivalencia(ValorRealRepositorio valRealRepo) throws BaseException {
  	
  	ValorEquivalenciaRepositorio valorEquiRepo = 
  		(ValorEquivalenciaRepositorio)ValorEquivalenciaRepositorio.getNew(
  				ValorEquivalenciaRepositorio.NICKNAME,
  				this.getSesion()); 
  	
  	valorEquiRepo.setRepositorio_real(valRealRepo.getRepositorio_real());
  	valorEquiRepo.setValorRealRepositorio(valRealRepo);
  	valorEquiRepo.setActivo(new Boolean(true));
  	
  	valorEquiRepo.setValor_compo_presu1(getValorCompoPresu(valRealRepo.getValor_real_1()));
  	valorEquiRepo.setValor_compo_presu2(getValorCompoPresu(valRealRepo.getValor_real_2()));
  	valorEquiRepo.setValor_compo_presu3(getValorCompoPresu(valRealRepo.getValor_real_3()));
  	valorEquiRepo.setValor_compo_presu4(getValorCompoPresu(valRealRepo.getValor_real_4()));
  	valorEquiRepo.setValor_compo_presu5(getValorCompoPresu(valRealRepo.getValor_real_5()));
  	valorEquiRepo.setValor_compo_presu6(getValorCompoPresu(valRealRepo.getValor_real_6()));
  	valorEquiRepo.setValor_compo_presu7(getValorCompoPresu(valRealRepo.getValor_real_7()));
  	valorEquiRepo.setValor_compo_presu8(getValorCompoPresu(valRealRepo.getValor_real_8()));
  	valorEquiRepo.setValor_compo_presu9(getValorCompoPresu(valRealRepo.getValor_real_9()));
  	valorEquiRepo.setValor_compo_presu10(getValorCompoPresu(valRealRepo.getValor_real_10()));
  	valorEquiRepo.setValor_compo_presu11(getValorCompoPresu(valRealRepo.getValor_real_11()));
  	valorEquiRepo.setValor_compo_presu12(getValorCompoPresu(valRealRepo.getValor_real_12()));
  	valorEquiRepo.setValor_compo_presu13(getValorCompoPresu(valRealRepo.getValor_real_13()));
  	valorEquiRepo.setValor_compo_presu14(getValorCompoPresu(valRealRepo.getValor_real_14()));
  	valorEquiRepo.setValor_compo_presu15(getValorCompoPresu(valRealRepo.getValor_real_15()));
  	valorEquiRepo.setValor_compo_presu16(getValorCompoPresu(valRealRepo.getValor_real_16()));
  	valorEquiRepo.setValor_compo_presu17(getValorCompoPresu(valRealRepo.getValor_real_17()));
  	valorEquiRepo.setValor_compo_presu18(getValorCompoPresu(valRealRepo.getValor_real_18()));
  	valorEquiRepo.setValor_compo_presu19(getValorCompoPresu(valRealRepo.getValor_real_19()));
  	valorEquiRepo.setValor_compo_presu20(getValorCompoPresu(valRealRepo.getValor_real_20()));
  	valorEquiRepo.setValor_compo_presu21(getValorCompoPresu(valRealRepo.getValor_real_21()));
  	valorEquiRepo.setValor_compo_presu22(getValorCompoPresu(valRealRepo.getValor_real_22()));
  	valorEquiRepo.setValor_compo_presu23(getValorCompoPresu(valRealRepo.getValor_real_23()));
  	valorEquiRepo.setValor_compo_presu24(getValorCompoPresu(valRealRepo.getValor_real_24()));
  	valorEquiRepo.setValor_compo_presu25(getValorCompoPresu(valRealRepo.getValor_real_25()));
  	valorEquiRepo.setValor_compo_presu26(getValorCompoPresu(valRealRepo.getValor_real_26()));
  	valorEquiRepo.setValor_compo_presu27(getValorCompoPresu(valRealRepo.getValor_real_27()));
  	valorEquiRepo.setValor_compo_presu28(getValorCompoPresu(valRealRepo.getValor_real_28()));
  	valorEquiRepo.setValor_compo_presu29(getValorCompoPresu(valRealRepo.getValor_real_29()));
  	valorEquiRepo.setValor_compo_presu30(getValorCompoPresu(valRealRepo.getValor_real_30()));
  	valorEquiRepo.setValor_compo_presu31(getValorCompoPresu(valRealRepo.getValor_real_31()));
  	valorEquiRepo.setValor_compo_presu32(getValorCompoPresu(valRealRepo.getValor_real_32()));
  	valorEquiRepo.setValor_compo_presu33(getValorCompoPresu(valRealRepo.getValor_real_33()));
  	valorEquiRepo.setValor_compo_presu34(getValorCompoPresu(valRealRepo.getValor_real_34()));
  	valorEquiRepo.setValor_compo_presu35(getValorCompoPresu(valRealRepo.getValor_real_35()));
  	valorEquiRepo.setValor_compo_presu36(getValorCompoPresu(valRealRepo.getValor_real_36()));
  	valorEquiRepo.setValor_compo_presu37(getValorCompoPresu(valRealRepo.getValor_real_37()));
  	valorEquiRepo.setValor_compo_presu38(getValorCompoPresu(valRealRepo.getValor_real_38()));
  	valorEquiRepo.setValor_compo_presu39(getValorCompoPresu(valRealRepo.getValor_real_39()));
  	valorEquiRepo.setValor_compo_presu40(getValorCompoPresu(valRealRepo.getValor_real_40()));
  	valorEquiRepo.setValor_compo_presu41(getValorCompoPresu(valRealRepo.getValor_real_41()));
  	valorEquiRepo.setValor_compo_presu42(getValorCompoPresu(valRealRepo.getValor_real_42()));
  	valorEquiRepo.setValor_compo_presu43(getValorCompoPresu(valRealRepo.getValor_real_43()));
  	valorEquiRepo.setValor_compo_presu44(getValorCompoPresu(valRealRepo.getValor_real_44()));
  	valorEquiRepo.setValor_compo_presu45(getValorCompoPresu(valRealRepo.getValor_real_45()));
  	valorEquiRepo.setValor_compo_presu46(getValorCompoPresu(valRealRepo.getValor_real_46()));
  	valorEquiRepo.setValor_compo_presu47(getValorCompoPresu(valRealRepo.getValor_real_47()));
  	valorEquiRepo.setValor_compo_presu48(getValorCompoPresu(valRealRepo.getValor_real_48()));
  	valorEquiRepo.setValor_compo_presu49(getValorCompoPresu(valRealRepo.getValor_real_49()));
  	valorEquiRepo.setValor_compo_presu50(getValorCompoPresu(valRealRepo.getValor_real_50()));
  	valorEquiRepo.setValor_compo_presu51(getValorCompoPresu(valRealRepo.getValor_real_51()));
  	valorEquiRepo.setValor_compo_presu52(getValorCompoPresu(valRealRepo.getValor_real_52()));
  	valorEquiRepo.setValor_compo_presu53(getValorCompoPresu(valRealRepo.getValor_real_53()));
  	valorEquiRepo.setValor_compo_presu54(getValorCompoPresu(valRealRepo.getValor_real_54()));
  	valorEquiRepo.setValor_compo_presu55(getValorCompoPresu(valRealRepo.getValor_real_55()));
  	valorEquiRepo.setValor_compo_presu56(getValorCompoPresu(valRealRepo.getValor_real_56()));
  	valorEquiRepo.setValor_compo_presu57(getValorCompoPresu(valRealRepo.getValor_real_57()));
  	valorEquiRepo.setValor_compo_presu58(getValorCompoPresu(valRealRepo.getValor_real_58()));
  	valorEquiRepo.setValor_compo_presu59(getValorCompoPresu(valRealRepo.getValor_real_59()));
  	valorEquiRepo.setValor_compo_presu60(getValorCompoPresu(valRealRepo.getValor_real_60()));
  	valorEquiRepo.setValor_compo_presu61(getValorCompoPresu(valRealRepo.getValor_real_61()));
  	valorEquiRepo.setValor_compo_presu62(getValorCompoPresu(valRealRepo.getValor_real_62()));
  	valorEquiRepo.setValor_compo_presu63(getValorCompoPresu(valRealRepo.getValor_real_63()));
  	valorEquiRepo.setValor_compo_presu64(getValorCompoPresu(valRealRepo.getValor_real_64()));
  	valorEquiRepo.setValor_compo_presu65(getValorCompoPresu(valRealRepo.getValor_real_65()));
  	valorEquiRepo.setValor_compo_presu66(getValorCompoPresu(valRealRepo.getValor_real_66()));
  	valorEquiRepo.setValor_compo_presu67(getValorCompoPresu(valRealRepo.getValor_real_67()));
  	valorEquiRepo.setValor_compo_presu68(getValorCompoPresu(valRealRepo.getValor_real_68()));
  	valorEquiRepo.setValor_compo_presu69(getValorCompoPresu(valRealRepo.getValor_real_69()));
  	valorEquiRepo.setValor_compo_presu70(getValorCompoPresu(valRealRepo.getValor_real_70()));
  	valorEquiRepo.setValor_compo_presu71(getValorCompoPresu(valRealRepo.getValor_real_71()));
  	valorEquiRepo.setValor_compo_presu72(getValorCompoPresu(valRealRepo.getValor_real_72()));
  	valorEquiRepo.setValor_compo_presu73(getValorCompoPresu(valRealRepo.getValor_real_73()));
  	valorEquiRepo.setValor_compo_presu74(getValorCompoPresu(valRealRepo.getValor_real_74()));
  	valorEquiRepo.setValor_compo_presu75(getValorCompoPresu(valRealRepo.getValor_real_75()));
  	valorEquiRepo.setValor_compo_presu76(getValorCompoPresu(valRealRepo.getValor_real_76()));
  	valorEquiRepo.setValor_compo_presu77(getValorCompoPresu(valRealRepo.getValor_real_77()));
  	valorEquiRepo.setValor_compo_presu78(getValorCompoPresu(valRealRepo.getValor_real_78()));
  	valorEquiRepo.setValor_compo_presu79(getValorCompoPresu(valRealRepo.getValor_real_79()));
  	valorEquiRepo.setValor_compo_presu80(getValorCompoPresu(valRealRepo.getValor_real_80()));
  	valorEquiRepo.setValor_compo_presu81(getValorCompoPresu(valRealRepo.getValor_real_81()));
  	valorEquiRepo.setValor_compo_presu82(getValorCompoPresu(valRealRepo.getValor_real_82()));
  	valorEquiRepo.setValor_compo_presu83(getValorCompoPresu(valRealRepo.getValor_real_83()));
  	valorEquiRepo.setValor_compo_presu84(getValorCompoPresu(valRealRepo.getValor_real_84()));
  	valorEquiRepo.setValor_compo_presu85(getValorCompoPresu(valRealRepo.getValor_real_85()));
  	valorEquiRepo.setValor_compo_presu86(getValorCompoPresu(valRealRepo.getValor_real_86()));
  	valorEquiRepo.setValor_compo_presu87(getValorCompoPresu(valRealRepo.getValor_real_87()));
  	valorEquiRepo.setValor_compo_presu88(getValorCompoPresu(valRealRepo.getValor_real_88()));
  	valorEquiRepo.setValor_compo_presu89(getValorCompoPresu(valRealRepo.getValor_real_89()));
  	valorEquiRepo.setValor_compo_presu90(getValorCompoPresu(valRealRepo.getValor_real_90()));
  	valorEquiRepo.setValor_compo_presu91(getValorCompoPresu(valRealRepo.getValor_real_91()));
  	valorEquiRepo.setValor_compo_presu92(getValorCompoPresu(valRealRepo.getValor_real_92()));
  	valorEquiRepo.setValor_compo_presu93(getValorCompoPresu(valRealRepo.getValor_real_93()));
  	valorEquiRepo.setValor_compo_presu94(getValorCompoPresu(valRealRepo.getValor_real_94()));
  	valorEquiRepo.setValor_compo_presu95(getValorCompoPresu(valRealRepo.getValor_real_95()));
  	valorEquiRepo.setValor_compo_presu96(getValorCompoPresu(valRealRepo.getValor_real_96()));
  	valorEquiRepo.setValor_compo_presu97(getValorCompoPresu(valRealRepo.getValor_real_97()));
  	valorEquiRepo.setValor_compo_presu98(getValorCompoPresu(valRealRepo.getValor_real_98()));
  	valorEquiRepo.setValor_compo_presu99(getValorCompoPresu(valRealRepo.getValor_real_99()));
  	valorEquiRepo.setValor_compo_presu100(getValorCompoPresu(valRealRepo.getValor_real_100()));
  	
  	valorEquiRepo.setVal_metrica_1(valRealRepo.getVal_metrica_1());
  	valorEquiRepo.setVal_metrica_2(valRealRepo.getVal_metrica_2());
  	valorEquiRepo.setVal_metrica_3(valRealRepo.getVal_metrica_3());
  	valorEquiRepo.setVal_metrica_4(valRealRepo.getVal_metrica_4());
  	valorEquiRepo.setVal_metrica_5(valRealRepo.getVal_metrica_5());
  	valorEquiRepo.setVal_metrica_6(valRealRepo.getVal_metrica_6());
  	valorEquiRepo.setVal_metrica_7(valRealRepo.getVal_metrica_7());
  	valorEquiRepo.setVal_metrica_8(valRealRepo.getVal_metrica_8());
  	valorEquiRepo.setVal_metrica_9(valRealRepo.getVal_metrica_9());
  	valorEquiRepo.setVal_metrica_10(valRealRepo.getVal_metrica_10());
  	valorEquiRepo.setVal_metrica_11(valRealRepo.getVal_metrica_11());
  	valorEquiRepo.setVal_metrica_12(valRealRepo.getVal_metrica_12());
  	valorEquiRepo.setVal_metrica_13(valRealRepo.getVal_metrica_13());
  	valorEquiRepo.setVal_metrica_14(valRealRepo.getVal_metrica_14());
  	valorEquiRepo.setVal_metrica_15(valRealRepo.getVal_metrica_15());
  	valorEquiRepo.setVal_metrica_16(valRealRepo.getVal_metrica_16());
  	valorEquiRepo.setVal_metrica_17(valRealRepo.getVal_metrica_17());
  	valorEquiRepo.setVal_metrica_18(valRealRepo.getVal_metrica_18());
  	valorEquiRepo.setVal_metrica_19(valRealRepo.getVal_metrica_19());
  	valorEquiRepo.setVal_metrica_20(valRealRepo.getVal_metrica_20());
  	valorEquiRepo.setVal_metrica_21(valRealRepo.getVal_metrica_21());
  	valorEquiRepo.setVal_metrica_22(valRealRepo.getVal_metrica_22());
  	valorEquiRepo.setVal_metrica_23(valRealRepo.getVal_metrica_23());
  	valorEquiRepo.setVal_metrica_24(valRealRepo.getVal_metrica_24());
  	valorEquiRepo.setVal_metrica_25(valRealRepo.getVal_metrica_25());
  	valorEquiRepo.setVal_metrica_26(valRealRepo.getVal_metrica_26());
  	valorEquiRepo.setVal_metrica_27(valRealRepo.getVal_metrica_27());
  	valorEquiRepo.setVal_metrica_28(valRealRepo.getVal_metrica_28());
  	valorEquiRepo.setVal_metrica_29(valRealRepo.getVal_metrica_29());
  	valorEquiRepo.setVal_metrica_30(valRealRepo.getVal_metrica_30());
  	valorEquiRepo.setVal_metrica_31(valRealRepo.getVal_metrica_31());
  	valorEquiRepo.setVal_metrica_32(valRealRepo.getVal_metrica_32());
  	valorEquiRepo.setVal_metrica_33(valRealRepo.getVal_metrica_33());
  	valorEquiRepo.setVal_metrica_34(valRealRepo.getVal_metrica_34());
  	valorEquiRepo.setVal_metrica_35(valRealRepo.getVal_metrica_35());
  	valorEquiRepo.setVal_metrica_36(valRealRepo.getVal_metrica_36());
  	valorEquiRepo.setVal_metrica_37(valRealRepo.getVal_metrica_37());
  	valorEquiRepo.setVal_metrica_38(valRealRepo.getVal_metrica_38());
  	valorEquiRepo.setVal_metrica_39(valRealRepo.getVal_metrica_39());
  	valorEquiRepo.setVal_metrica_40(valRealRepo.getVal_metrica_40());
  	valorEquiRepo.setVal_metrica_41(valRealRepo.getVal_metrica_41());
  	valorEquiRepo.setVal_metrica_42(valRealRepo.getVal_metrica_42());
  	valorEquiRepo.setVal_metrica_43(valRealRepo.getVal_metrica_43());
  	valorEquiRepo.setVal_metrica_44(valRealRepo.getVal_metrica_44());
  	valorEquiRepo.setVal_metrica_45(valRealRepo.getVal_metrica_45());
  	valorEquiRepo.setVal_metrica_46(valRealRepo.getVal_metrica_46());
  	valorEquiRepo.setVal_metrica_47(valRealRepo.getVal_metrica_47());
  	valorEquiRepo.setVal_metrica_48(valRealRepo.getVal_metrica_48());
  	valorEquiRepo.setVal_metrica_49(valRealRepo.getVal_metrica_49());
  	valorEquiRepo.setVal_metrica_50(valRealRepo.getVal_metrica_50());
  	
  	valorEquiRepo.setPeriodo1(getPeriodo(valRealRepo.getFec_tipo_peri_1(),new Integer(1)));
  	valorEquiRepo.setPeriodo2(getPeriodo(valRealRepo.getFec_tipo_peri_2(),new Integer(2)));
  	valorEquiRepo.setPeriodo3(getPeriodo(valRealRepo.getFec_tipo_peri_3(),new Integer(3)));
  	valorEquiRepo.setPeriodo4(getPeriodo(valRealRepo.getFec_tipo_peri_4(),new Integer(4)));
  	valorEquiRepo.setPeriodo5(getPeriodo(valRealRepo.getFec_tipo_peri_5(),new Integer(5)));
  	valorEquiRepo.setPeriodo6(getPeriodo(valRealRepo.getFec_tipo_peri_6(),new Integer(6)));
  	valorEquiRepo.setPeriodo7(getPeriodo(valRealRepo.getFec_tipo_peri_7(),new Integer(7)));
  	valorEquiRepo.setPeriodo8(getPeriodo(valRealRepo.getFec_tipo_peri_8(),new Integer(8)));
  	valorEquiRepo.setPeriodo9(getPeriodo(valRealRepo.getFec_tipo_peri_9(),new Integer(9)));
  	valorEquiRepo.setPeriodo10(getPeriodo(valRealRepo.getFec_tipo_peri_10(),new Integer(10)));
  	valorEquiRepo.setPeriodo11(getPeriodo(valRealRepo.getFec_tipo_peri_11(),new Integer(11)));
  	valorEquiRepo.setPeriodo12(getPeriodo(valRealRepo.getFec_tipo_peri_12(),new Integer(12)));
  	valorEquiRepo.setPeriodo13(getPeriodo(valRealRepo.getFec_tipo_peri_13(),new Integer(13)));
  	valorEquiRepo.setPeriodo14(getPeriodo(valRealRepo.getFec_tipo_peri_14(),new Integer(14)));
  	valorEquiRepo.setPeriodo15(getPeriodo(valRealRepo.getFec_tipo_peri_15(),new Integer(15)));
  	valorEquiRepo.setPeriodo16(getPeriodo(valRealRepo.getFec_tipo_peri_16(),new Integer(16)));
  	valorEquiRepo.setPeriodo17(getPeriodo(valRealRepo.getFec_tipo_peri_17(),new Integer(17)));
  	valorEquiRepo.setPeriodo18(getPeriodo(valRealRepo.getFec_tipo_peri_18(),new Integer(18)));
  	valorEquiRepo.setPeriodo19(getPeriodo(valRealRepo.getFec_tipo_peri_19(),new Integer(19)));
  	valorEquiRepo.setPeriodo20(getPeriodo(valRealRepo.getFec_tipo_peri_20(),new Integer(20)));
  	
  	valorEquiRepo.save();
  	
  	
  }
  
  private void updateTablaEquivalencia(ValorRealRepositorio valRealRepo) throws BaseException {
  	
  	ValorEquivalenciaRepositorio valorEquiRepo = 
  		ValorEquivalenciaRepositorio.getValorEquiRepo(valRealRepo,this.getSesion());
  	
  	if (valorEquiRepo == null) return;
  	
  	valorEquiRepo.setRepositorio_real(valRealRepo.getRepositorio_real());
  	valorEquiRepo.setValorRealRepositorio(valRealRepo);
  	valorEquiRepo.setActivo(new Boolean(true));
  	
  	valorEquiRepo.setValor_compo_presu1(getValorCompoPresu(valRealRepo.getValor_real_1()));
  	valorEquiRepo.setValor_compo_presu2(getValorCompoPresu(valRealRepo.getValor_real_2()));
  	valorEquiRepo.setValor_compo_presu3(getValorCompoPresu(valRealRepo.getValor_real_3()));
  	valorEquiRepo.setValor_compo_presu4(getValorCompoPresu(valRealRepo.getValor_real_4()));
  	valorEquiRepo.setValor_compo_presu5(getValorCompoPresu(valRealRepo.getValor_real_5()));
  	valorEquiRepo.setValor_compo_presu6(getValorCompoPresu(valRealRepo.getValor_real_6()));
  	valorEquiRepo.setValor_compo_presu7(getValorCompoPresu(valRealRepo.getValor_real_7()));
  	valorEquiRepo.setValor_compo_presu8(getValorCompoPresu(valRealRepo.getValor_real_8()));
  	valorEquiRepo.setValor_compo_presu9(getValorCompoPresu(valRealRepo.getValor_real_9()));
  	valorEquiRepo.setValor_compo_presu10(getValorCompoPresu(valRealRepo.getValor_real_10()));
  	valorEquiRepo.setValor_compo_presu11(getValorCompoPresu(valRealRepo.getValor_real_11()));
  	valorEquiRepo.setValor_compo_presu12(getValorCompoPresu(valRealRepo.getValor_real_12()));
  	valorEquiRepo.setValor_compo_presu13(getValorCompoPresu(valRealRepo.getValor_real_13()));
  	valorEquiRepo.setValor_compo_presu14(getValorCompoPresu(valRealRepo.getValor_real_14()));
  	valorEquiRepo.setValor_compo_presu15(getValorCompoPresu(valRealRepo.getValor_real_15()));
  	valorEquiRepo.setValor_compo_presu16(getValorCompoPresu(valRealRepo.getValor_real_16()));
  	valorEquiRepo.setValor_compo_presu17(getValorCompoPresu(valRealRepo.getValor_real_17()));
  	valorEquiRepo.setValor_compo_presu18(getValorCompoPresu(valRealRepo.getValor_real_18()));
  	valorEquiRepo.setValor_compo_presu19(getValorCompoPresu(valRealRepo.getValor_real_19()));
  	valorEquiRepo.setValor_compo_presu20(getValorCompoPresu(valRealRepo.getValor_real_20()));
  	valorEquiRepo.setValor_compo_presu21(getValorCompoPresu(valRealRepo.getValor_real_21()));
  	valorEquiRepo.setValor_compo_presu22(getValorCompoPresu(valRealRepo.getValor_real_22()));
  	valorEquiRepo.setValor_compo_presu23(getValorCompoPresu(valRealRepo.getValor_real_23()));
  	valorEquiRepo.setValor_compo_presu24(getValorCompoPresu(valRealRepo.getValor_real_24()));
  	valorEquiRepo.setValor_compo_presu25(getValorCompoPresu(valRealRepo.getValor_real_25()));
  	valorEquiRepo.setValor_compo_presu26(getValorCompoPresu(valRealRepo.getValor_real_26()));
  	valorEquiRepo.setValor_compo_presu27(getValorCompoPresu(valRealRepo.getValor_real_27()));
  	valorEquiRepo.setValor_compo_presu28(getValorCompoPresu(valRealRepo.getValor_real_28()));
  	valorEquiRepo.setValor_compo_presu29(getValorCompoPresu(valRealRepo.getValor_real_29()));
  	valorEquiRepo.setValor_compo_presu30(getValorCompoPresu(valRealRepo.getValor_real_30()));
  	valorEquiRepo.setValor_compo_presu31(getValorCompoPresu(valRealRepo.getValor_real_31()));
  	valorEquiRepo.setValor_compo_presu32(getValorCompoPresu(valRealRepo.getValor_real_32()));
  	valorEquiRepo.setValor_compo_presu33(getValorCompoPresu(valRealRepo.getValor_real_33()));
  	valorEquiRepo.setValor_compo_presu34(getValorCompoPresu(valRealRepo.getValor_real_34()));
  	valorEquiRepo.setValor_compo_presu35(getValorCompoPresu(valRealRepo.getValor_real_35()));
  	valorEquiRepo.setValor_compo_presu36(getValorCompoPresu(valRealRepo.getValor_real_36()));
  	valorEquiRepo.setValor_compo_presu37(getValorCompoPresu(valRealRepo.getValor_real_37()));
  	valorEquiRepo.setValor_compo_presu38(getValorCompoPresu(valRealRepo.getValor_real_38()));
  	valorEquiRepo.setValor_compo_presu39(getValorCompoPresu(valRealRepo.getValor_real_39()));
  	valorEquiRepo.setValor_compo_presu40(getValorCompoPresu(valRealRepo.getValor_real_40()));
  	valorEquiRepo.setValor_compo_presu41(getValorCompoPresu(valRealRepo.getValor_real_41()));
  	valorEquiRepo.setValor_compo_presu42(getValorCompoPresu(valRealRepo.getValor_real_42()));
  	valorEquiRepo.setValor_compo_presu43(getValorCompoPresu(valRealRepo.getValor_real_43()));
  	valorEquiRepo.setValor_compo_presu44(getValorCompoPresu(valRealRepo.getValor_real_44()));
  	valorEquiRepo.setValor_compo_presu45(getValorCompoPresu(valRealRepo.getValor_real_45()));
  	valorEquiRepo.setValor_compo_presu46(getValorCompoPresu(valRealRepo.getValor_real_46()));
  	valorEquiRepo.setValor_compo_presu47(getValorCompoPresu(valRealRepo.getValor_real_47()));
  	valorEquiRepo.setValor_compo_presu48(getValorCompoPresu(valRealRepo.getValor_real_48()));
  	valorEquiRepo.setValor_compo_presu49(getValorCompoPresu(valRealRepo.getValor_real_49()));
  	valorEquiRepo.setValor_compo_presu50(getValorCompoPresu(valRealRepo.getValor_real_50()));
  	valorEquiRepo.setValor_compo_presu51(getValorCompoPresu(valRealRepo.getValor_real_51()));
  	valorEquiRepo.setValor_compo_presu52(getValorCompoPresu(valRealRepo.getValor_real_52()));
  	valorEquiRepo.setValor_compo_presu53(getValorCompoPresu(valRealRepo.getValor_real_53()));
  	valorEquiRepo.setValor_compo_presu54(getValorCompoPresu(valRealRepo.getValor_real_54()));
  	valorEquiRepo.setValor_compo_presu55(getValorCompoPresu(valRealRepo.getValor_real_55()));
  	valorEquiRepo.setValor_compo_presu56(getValorCompoPresu(valRealRepo.getValor_real_56()));
  	valorEquiRepo.setValor_compo_presu57(getValorCompoPresu(valRealRepo.getValor_real_57()));
  	valorEquiRepo.setValor_compo_presu58(getValorCompoPresu(valRealRepo.getValor_real_58()));
  	valorEquiRepo.setValor_compo_presu59(getValorCompoPresu(valRealRepo.getValor_real_59()));
  	valorEquiRepo.setValor_compo_presu60(getValorCompoPresu(valRealRepo.getValor_real_60()));
  	valorEquiRepo.setValor_compo_presu61(getValorCompoPresu(valRealRepo.getValor_real_61()));
  	valorEquiRepo.setValor_compo_presu62(getValorCompoPresu(valRealRepo.getValor_real_62()));
  	valorEquiRepo.setValor_compo_presu63(getValorCompoPresu(valRealRepo.getValor_real_63()));
  	valorEquiRepo.setValor_compo_presu64(getValorCompoPresu(valRealRepo.getValor_real_64()));
  	valorEquiRepo.setValor_compo_presu65(getValorCompoPresu(valRealRepo.getValor_real_65()));
  	valorEquiRepo.setValor_compo_presu66(getValorCompoPresu(valRealRepo.getValor_real_66()));
  	valorEquiRepo.setValor_compo_presu67(getValorCompoPresu(valRealRepo.getValor_real_67()));
  	valorEquiRepo.setValor_compo_presu68(getValorCompoPresu(valRealRepo.getValor_real_68()));
  	valorEquiRepo.setValor_compo_presu69(getValorCompoPresu(valRealRepo.getValor_real_69()));
  	valorEquiRepo.setValor_compo_presu70(getValorCompoPresu(valRealRepo.getValor_real_70()));
  	valorEquiRepo.setValor_compo_presu71(getValorCompoPresu(valRealRepo.getValor_real_71()));
  	valorEquiRepo.setValor_compo_presu72(getValorCompoPresu(valRealRepo.getValor_real_72()));
  	valorEquiRepo.setValor_compo_presu73(getValorCompoPresu(valRealRepo.getValor_real_73()));
  	valorEquiRepo.setValor_compo_presu74(getValorCompoPresu(valRealRepo.getValor_real_74()));
  	valorEquiRepo.setValor_compo_presu75(getValorCompoPresu(valRealRepo.getValor_real_75()));
  	valorEquiRepo.setValor_compo_presu76(getValorCompoPresu(valRealRepo.getValor_real_76()));
  	valorEquiRepo.setValor_compo_presu77(getValorCompoPresu(valRealRepo.getValor_real_77()));
  	valorEquiRepo.setValor_compo_presu78(getValorCompoPresu(valRealRepo.getValor_real_78()));
  	valorEquiRepo.setValor_compo_presu79(getValorCompoPresu(valRealRepo.getValor_real_79()));
  	valorEquiRepo.setValor_compo_presu80(getValorCompoPresu(valRealRepo.getValor_real_80()));
  	valorEquiRepo.setValor_compo_presu81(getValorCompoPresu(valRealRepo.getValor_real_81()));
  	valorEquiRepo.setValor_compo_presu82(getValorCompoPresu(valRealRepo.getValor_real_82()));
  	valorEquiRepo.setValor_compo_presu83(getValorCompoPresu(valRealRepo.getValor_real_83()));
  	valorEquiRepo.setValor_compo_presu84(getValorCompoPresu(valRealRepo.getValor_real_84()));
  	valorEquiRepo.setValor_compo_presu85(getValorCompoPresu(valRealRepo.getValor_real_85()));
  	valorEquiRepo.setValor_compo_presu86(getValorCompoPresu(valRealRepo.getValor_real_86()));
  	valorEquiRepo.setValor_compo_presu87(getValorCompoPresu(valRealRepo.getValor_real_87()));
  	valorEquiRepo.setValor_compo_presu88(getValorCompoPresu(valRealRepo.getValor_real_88()));
  	valorEquiRepo.setValor_compo_presu89(getValorCompoPresu(valRealRepo.getValor_real_89()));
  	valorEquiRepo.setValor_compo_presu90(getValorCompoPresu(valRealRepo.getValor_real_90()));
  	valorEquiRepo.setValor_compo_presu91(getValorCompoPresu(valRealRepo.getValor_real_91()));
  	valorEquiRepo.setValor_compo_presu92(getValorCompoPresu(valRealRepo.getValor_real_92()));
  	valorEquiRepo.setValor_compo_presu93(getValorCompoPresu(valRealRepo.getValor_real_93()));
  	valorEquiRepo.setValor_compo_presu94(getValorCompoPresu(valRealRepo.getValor_real_94()));
  	valorEquiRepo.setValor_compo_presu95(getValorCompoPresu(valRealRepo.getValor_real_95()));
  	valorEquiRepo.setValor_compo_presu96(getValorCompoPresu(valRealRepo.getValor_real_96()));
  	valorEquiRepo.setValor_compo_presu97(getValorCompoPresu(valRealRepo.getValor_real_97()));
  	valorEquiRepo.setValor_compo_presu98(getValorCompoPresu(valRealRepo.getValor_real_98()));
  	valorEquiRepo.setValor_compo_presu99(getValorCompoPresu(valRealRepo.getValor_real_99()));
  	valorEquiRepo.setValor_compo_presu100(getValorCompoPresu(valRealRepo.getValor_real_100()));
  	
  	valorEquiRepo.setVal_metrica_1(valRealRepo.getVal_metrica_1());
  	valorEquiRepo.setVal_metrica_2(valRealRepo.getVal_metrica_2());
  	valorEquiRepo.setVal_metrica_3(valRealRepo.getVal_metrica_3());
  	valorEquiRepo.setVal_metrica_4(valRealRepo.getVal_metrica_4());
  	valorEquiRepo.setVal_metrica_5(valRealRepo.getVal_metrica_5());
  	valorEquiRepo.setVal_metrica_6(valRealRepo.getVal_metrica_6());
  	valorEquiRepo.setVal_metrica_7(valRealRepo.getVal_metrica_7());
  	valorEquiRepo.setVal_metrica_8(valRealRepo.getVal_metrica_8());
  	valorEquiRepo.setVal_metrica_9(valRealRepo.getVal_metrica_9());
  	valorEquiRepo.setVal_metrica_10(valRealRepo.getVal_metrica_10());
  	valorEquiRepo.setVal_metrica_11(valRealRepo.getVal_metrica_11());
  	valorEquiRepo.setVal_metrica_12(valRealRepo.getVal_metrica_12());
  	valorEquiRepo.setVal_metrica_13(valRealRepo.getVal_metrica_13());
  	valorEquiRepo.setVal_metrica_14(valRealRepo.getVal_metrica_14());
  	valorEquiRepo.setVal_metrica_15(valRealRepo.getVal_metrica_15());
  	valorEquiRepo.setVal_metrica_16(valRealRepo.getVal_metrica_16());
  	valorEquiRepo.setVal_metrica_17(valRealRepo.getVal_metrica_17());
  	valorEquiRepo.setVal_metrica_18(valRealRepo.getVal_metrica_18());
  	valorEquiRepo.setVal_metrica_19(valRealRepo.getVal_metrica_19());
  	valorEquiRepo.setVal_metrica_20(valRealRepo.getVal_metrica_20());
  	valorEquiRepo.setVal_metrica_21(valRealRepo.getVal_metrica_21());
  	valorEquiRepo.setVal_metrica_22(valRealRepo.getVal_metrica_22());
  	valorEquiRepo.setVal_metrica_23(valRealRepo.getVal_metrica_23());
  	valorEquiRepo.setVal_metrica_24(valRealRepo.getVal_metrica_24());
  	valorEquiRepo.setVal_metrica_25(valRealRepo.getVal_metrica_25());
  	valorEquiRepo.setVal_metrica_26(valRealRepo.getVal_metrica_26());
  	valorEquiRepo.setVal_metrica_27(valRealRepo.getVal_metrica_27());
  	valorEquiRepo.setVal_metrica_28(valRealRepo.getVal_metrica_28());
  	valorEquiRepo.setVal_metrica_29(valRealRepo.getVal_metrica_29());
  	valorEquiRepo.setVal_metrica_30(valRealRepo.getVal_metrica_30());
  	valorEquiRepo.setVal_metrica_31(valRealRepo.getVal_metrica_31());
  	valorEquiRepo.setVal_metrica_32(valRealRepo.getVal_metrica_32());
  	valorEquiRepo.setVal_metrica_33(valRealRepo.getVal_metrica_33());
  	valorEquiRepo.setVal_metrica_34(valRealRepo.getVal_metrica_34());
  	valorEquiRepo.setVal_metrica_35(valRealRepo.getVal_metrica_35());
  	valorEquiRepo.setVal_metrica_36(valRealRepo.getVal_metrica_36());
  	valorEquiRepo.setVal_metrica_37(valRealRepo.getVal_metrica_37());
  	valorEquiRepo.setVal_metrica_38(valRealRepo.getVal_metrica_38());
  	valorEquiRepo.setVal_metrica_39(valRealRepo.getVal_metrica_39());
  	valorEquiRepo.setVal_metrica_40(valRealRepo.getVal_metrica_40());
  	valorEquiRepo.setVal_metrica_41(valRealRepo.getVal_metrica_41());
  	valorEquiRepo.setVal_metrica_42(valRealRepo.getVal_metrica_42());
  	valorEquiRepo.setVal_metrica_43(valRealRepo.getVal_metrica_43());
  	valorEquiRepo.setVal_metrica_44(valRealRepo.getVal_metrica_44());
  	valorEquiRepo.setVal_metrica_45(valRealRepo.getVal_metrica_45());
  	valorEquiRepo.setVal_metrica_46(valRealRepo.getVal_metrica_46());
  	valorEquiRepo.setVal_metrica_47(valRealRepo.getVal_metrica_47());
  	valorEquiRepo.setVal_metrica_48(valRealRepo.getVal_metrica_48());
  	valorEquiRepo.setVal_metrica_49(valRealRepo.getVal_metrica_49());
  	valorEquiRepo.setVal_metrica_50(valRealRepo.getVal_metrica_50());
  	
  	valorEquiRepo.setPeriodo1(getPeriodo(valRealRepo.getFec_tipo_peri_1(),new Integer(1)));
  	valorEquiRepo.setPeriodo2(getPeriodo(valRealRepo.getFec_tipo_peri_2(),new Integer(2)));
  	valorEquiRepo.setPeriodo3(getPeriodo(valRealRepo.getFec_tipo_peri_3(),new Integer(3)));
  	valorEquiRepo.setPeriodo4(getPeriodo(valRealRepo.getFec_tipo_peri_4(),new Integer(4)));
  	valorEquiRepo.setPeriodo5(getPeriodo(valRealRepo.getFec_tipo_peri_5(),new Integer(5)));
  	valorEquiRepo.setPeriodo6(getPeriodo(valRealRepo.getFec_tipo_peri_6(),new Integer(6)));
  	valorEquiRepo.setPeriodo7(getPeriodo(valRealRepo.getFec_tipo_peri_7(),new Integer(7)));
  	valorEquiRepo.setPeriodo8(getPeriodo(valRealRepo.getFec_tipo_peri_8(),new Integer(8)));
  	valorEquiRepo.setPeriodo9(getPeriodo(valRealRepo.getFec_tipo_peri_9(),new Integer(9)));
  	valorEquiRepo.setPeriodo10(getPeriodo(valRealRepo.getFec_tipo_peri_10(),new Integer(10)));
  	valorEquiRepo.setPeriodo11(getPeriodo(valRealRepo.getFec_tipo_peri_11(),new Integer(11)));
  	valorEquiRepo.setPeriodo12(getPeriodo(valRealRepo.getFec_tipo_peri_12(),new Integer(12)));
  	valorEquiRepo.setPeriodo13(getPeriodo(valRealRepo.getFec_tipo_peri_13(),new Integer(13)));
  	valorEquiRepo.setPeriodo14(getPeriodo(valRealRepo.getFec_tipo_peri_14(),new Integer(14)));
  	valorEquiRepo.setPeriodo15(getPeriodo(valRealRepo.getFec_tipo_peri_15(),new Integer(15)));
  	valorEquiRepo.setPeriodo16(getPeriodo(valRealRepo.getFec_tipo_peri_16(),new Integer(16)));
  	valorEquiRepo.setPeriodo17(getPeriodo(valRealRepo.getFec_tipo_peri_17(),new Integer(17)));
  	valorEquiRepo.setPeriodo18(getPeriodo(valRealRepo.getFec_tipo_peri_18(),new Integer(18)));
  	valorEquiRepo.setPeriodo19(getPeriodo(valRealRepo.getFec_tipo_peri_19(),new Integer(19)));
  	valorEquiRepo.setPeriodo20(getPeriodo(valRealRepo.getFec_tipo_peri_20(),new Integer(20)));
  	
  	valorEquiRepo.save();
  	
  	
  }
  
  
  private ValorCompoPresu getValorCompoPresu(ValorCompoReal valCompoReal) throws BaseException {
  	if (valCompoReal == null)
  		return null;
  	else {
  		if (valCompoReal.getValorCompoPresu()==null)
  			throw new ExceptionValidation(null,"No se pudo encontrar valor presupuestario para el valor real "+
  					                               valCompoReal.getCodigo()+"-"+
  					                               valCompoReal.getDescripcion()+" del componente "+
  					                               valCompoReal.getCompo_presu().getDescripcion());
  		else
  			return valCompoReal.getValorCompoPresu();
  					                               
  	}
  		
  }
  
  private PeriodoPresupuestario getPeriodo(java.util.Date fecha,
  		                                     Integer nroInterno) throws BaseException {
  	
  	if (fecha!=null) {
  		TipoPeriodo tipoPeriodo = TipoPeriodo.getTipoPeriodo(nroInterno,this.getSesion());
  		if (tipoPeriodo==null)
  			throw new ExceptionValidation(null,"No se pudo encontrar un Tipo de Período con Nro. Interno "+nroInterno);
  		PeriodoPresupuestario periodo = tipoPeriodo.getPeriodo(fecha);
  		if (periodo == null)
  			throw new ExceptionValidation(null,"No se pudo encontrar un período "+
  					                               tipoPeriodo.getDescripcion()+
  					                               " para la fecha "+
  					                               Fecha.getddmmyyyy(fecha));
  		return periodo;
  	} 
  	else
  		return null;
  	
  }
  
  
 


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REPO_REAL = 1;
    final int OID_VAL_REAL_1 = 2;
    final int OID_VAL_REAL_2 = 3;
    final int OID_VAL_REAL_3 = 4;
    final int OID_VAL_REAL_4 = 5;
    final int OID_VAL_REAL_5 = 6;
    final int OID_VAL_REAL_6 = 7;
    final int OID_VAL_REAL_7 = 8;
    final int OID_VAL_REAL_8 = 9;
    final int OID_VAL_REAL_9 = 10;
    final int OID_VAL_REAL_10 = 11;
    final int OID_VAL_REAL_11 = 12;
    final int OID_VAL_REAL_12 = 13;
    final int OID_VAL_REAL_13 = 14;
    final int OID_VAL_REAL_14 = 15;
    final int OID_VAL_REAL_15 = 16;
    final int OID_VAL_REAL_16 = 17;
    final int OID_VAL_REAL_17 = 18;
    final int OID_VAL_REAL_18 = 19;
    final int OID_VAL_REAL_19 = 20;
    final int OID_VAL_REAL_20 = 21;
    final int OID_VAL_REAL_21 = 22;
    final int OID_VAL_REAL_22 = 23;
    final int OID_VAL_REAL_23 = 24;
    final int OID_VAL_REAL_24 = 25;
    final int OID_VAL_REAL_25 = 26;
    final int OID_VAL_REAL_26 = 27;
    final int OID_VAL_REAL_27 = 28;
    final int OID_VAL_REAL_28 = 29;
    final int OID_VAL_REAL_29 = 30;
    final int OID_VAL_REAL_30 = 31;
    final int OID_VAL_REAL_31 = 32;
    final int OID_VAL_REAL_32 = 33;
    final int OID_VAL_REAL_33 = 34;
    final int OID_VAL_REAL_34 = 35;
    final int OID_VAL_REAL_35 = 36;
    final int OID_VAL_REAL_36 = 37;
    final int OID_VAL_REAL_37 = 38;
    final int OID_VAL_REAL_38 = 39;
    final int OID_VAL_REAL_39 = 40;
    final int OID_VAL_REAL_40 = 41;
    final int OID_VAL_REAL_41 = 42;
    final int OID_VAL_REAL_42 = 43;
    final int OID_VAL_REAL_43 = 44;
    final int OID_VAL_REAL_44 = 45;
    final int OID_VAL_REAL_45 = 46;
    final int OID_VAL_REAL_46 = 47;
    final int OID_VAL_REAL_47 = 48;
    final int OID_VAL_REAL_48 = 49;
    final int OID_VAL_REAL_49 = 50;
    final int OID_VAL_REAL_50 = 51;
    final int OID_VAL_REAL_51 = 52;
    final int OID_VAL_REAL_52 = 53;
    final int OID_VAL_REAL_53 = 54;
    final int OID_VAL_REAL_54 = 55;
    final int OID_VAL_REAL_55 = 56;
    final int OID_VAL_REAL_56 = 57;
    final int OID_VAL_REAL_57 = 58;
    final int OID_VAL_REAL_58 = 59;
    final int OID_VAL_REAL_59 = 60;
    final int OID_VAL_REAL_60 = 61;
    final int OID_VAL_REAL_61 = 62;
    final int OID_VAL_REAL_62 = 63;
    final int OID_VAL_REAL_63 = 64;
    final int OID_VAL_REAL_64 = 65;
    final int OID_VAL_REAL_65 = 66;
    final int OID_VAL_REAL_66 = 67;
    final int OID_VAL_REAL_67 = 68;
    final int OID_VAL_REAL_68 = 69;
    final int OID_VAL_REAL_69 = 70;
    final int OID_VAL_REAL_70 = 71;
    final int OID_VAL_REAL_71 = 72;
    final int OID_VAL_REAL_72 = 73;
    final int OID_VAL_REAL_73 = 74;
    final int OID_VAL_REAL_74 = 75;
    final int OID_VAL_REAL_75 = 76;
    final int OID_VAL_REAL_76 = 77;
    final int OID_VAL_REAL_77 = 78;
    final int OID_VAL_REAL_78 = 79;
    final int OID_VAL_REAL_79 = 80;
    final int OID_VAL_REAL_80 = 81;
    final int OID_VAL_REAL_81 = 82;
    final int OID_VAL_REAL_82 = 83;
    final int OID_VAL_REAL_83 = 84;
    final int OID_VAL_REAL_84 = 85;
    final int OID_VAL_REAL_85 = 86;
    final int OID_VAL_REAL_86 = 87;
    final int OID_VAL_REAL_87 = 88;
    final int OID_VAL_REAL_88 = 89;
    final int OID_VAL_REAL_89 = 90;
    final int OID_VAL_REAL_90 = 91;
    final int OID_VAL_REAL_91 = 92;
    final int OID_VAL_REAL_92 = 93;
    final int OID_VAL_REAL_93 = 94;
    final int OID_VAL_REAL_94 = 95;
    final int OID_VAL_REAL_95 = 96;
    final int OID_VAL_REAL_96 = 97;
    final int OID_VAL_REAL_97 = 98;
    final int OID_VAL_REAL_98 = 99;
    final int OID_VAL_REAL_99 = 100;
    final int OID_VAL_REAL_100 = 101;
    final int VAL_METRICA_1 = 102;
    final int VAL_METRICA_2 = 103;
    final int VAL_METRICA_3 = 104;
    final int VAL_METRICA_4 = 105;
    final int VAL_METRICA_5 = 106;
    final int VAL_METRICA_6 = 107;
    final int VAL_METRICA_7 = 108;
    final int VAL_METRICA_8 = 109;
    final int VAL_METRICA_9 = 110;
    final int VAL_METRICA_10 = 111;
    final int VAL_METRICA_11 = 112;
    final int VAL_METRICA_12 = 113;
    final int VAL_METRICA_13 = 114;
    final int VAL_METRICA_14 = 115;
    final int VAL_METRICA_15 = 116;
    final int VAL_METRICA_16 = 117;
    final int VAL_METRICA_17 = 118;
    final int VAL_METRICA_18 = 119;
    final int VAL_METRICA_19 = 120;
    final int VAL_METRICA_20 = 121;
    final int VAL_METRICA_21 = 122;
    final int VAL_METRICA_22 = 123;
    final int VAL_METRICA_23 = 124;
    final int VAL_METRICA_24 = 125;
    final int VAL_METRICA_25 = 126;
    final int VAL_METRICA_26 = 127;
    final int VAL_METRICA_27 = 128;
    final int VAL_METRICA_28 = 129;
    final int VAL_METRICA_29 = 130;
    final int VAL_METRICA_30 = 131;
    final int VAL_METRICA_31 = 132;
    final int VAL_METRICA_32 = 133;
    final int VAL_METRICA_33 = 134;
    final int VAL_METRICA_34 = 135;
    final int VAL_METRICA_35 = 136;
    final int VAL_METRICA_36 = 137;
    final int VAL_METRICA_37 = 138;
    final int VAL_METRICA_38 = 139;
    final int VAL_METRICA_39 = 140;
    final int VAL_METRICA_40 = 141;
    final int VAL_METRICA_41 = 142;
    final int VAL_METRICA_42 = 143;
    final int VAL_METRICA_43 = 144;
    final int VAL_METRICA_44 = 145;
    final int VAL_METRICA_45 = 146;
    final int VAL_METRICA_46 = 147;
    final int VAL_METRICA_47 = 148;
    final int VAL_METRICA_48 = 149;
    final int VAL_METRICA_49 = 150;
    final int VAL_METRICA_50 = 151;
    final int FEC_TIPO_PERI_1 = 152;
    final int FEC_TIPO_PERI_2 = 153;
    final int FEC_TIPO_PERI_3 = 154;
    final int FEC_TIPO_PERI_4 = 155;
    final int FEC_TIPO_PERI_5 = 156;
    final int FEC_TIPO_PERI_6 = 157;
    final int FEC_TIPO_PERI_7 = 158;
    final int FEC_TIPO_PERI_8 = 159;
    final int FEC_TIPO_PERI_9 = 160;
    final int FEC_TIPO_PERI_10 = 161;
    final int FEC_TIPO_PERI_11 = 162;
    final int FEC_TIPO_PERI_12 = 163;
    final int FEC_TIPO_PERI_13 = 164;
    final int FEC_TIPO_PERI_14 = 165;
    final int FEC_TIPO_PERI_15 = 166;
    final int FEC_TIPO_PERI_16 = 167;
    final int FEC_TIPO_PERI_17 = 168;
    final int FEC_TIPO_PERI_18 = 169;
    final int FEC_TIPO_PERI_19 = 170;
    final int FEC_TIPO_PERI_20 = 171;
    final int ACTIVO = 172;
    final int OID_VAL_REPO_REAL = 173;

    ValorRealRepositorio pers = (ValorRealRepositorio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plValRepoReal set "+
              "oid_repo_real=?"+ 
              ",oid_val_real_1=?"+ 
              ",oid_val_real_2=?"+ 
              ",oid_val_real_3=?"+ 
              ",oid_val_real_4=?"+ 
              ",oid_val_real_5=?"+ 
              ",oid_val_real_6=?"+ 
              ",oid_val_real_7=?"+ 
              ",oid_val_real_8=?"+ 
              ",oid_val_real_9=?"+ 
              ",oid_val_real_10=?"+ 
              ",oid_val_real_11=?"+ 
              ",oid_val_real_12=?"+ 
              ",oid_val_real_13=?"+ 
              ",oid_val_real_14=?"+ 
              ",oid_val_real_15=?"+ 
              ",oid_val_real_16=?"+ 
              ",oid_val_real_17=?"+ 
              ",oid_val_real_18=?"+ 
              ",oid_val_real_19=?"+ 
              ",oid_val_real_20=?"+ 
              ",oid_val_real_21=?"+ 
              ",oid_val_real_22=?"+ 
              ",oid_val_real_23=?"+ 
              ",oid_val_real_24=?"+ 
              ",oid_val_real_25=?"+ 
              ",oid_val_real_26=?"+ 
              ",oid_val_real_27=?"+ 
              ",oid_val_real_28=?"+ 
              ",oid_val_real_29=?"+ 
              ",oid_val_real_30=?"+ 
              ",oid_val_real_31=?"+ 
              ",oid_val_real_32=?"+ 
              ",oid_val_real_33=?"+ 
              ",oid_val_real_34=?"+ 
              ",oid_val_real_35=?"+ 
              ",oid_val_real_36=?"+ 
              ",oid_val_real_37=?"+ 
              ",oid_val_real_38=?"+ 
              ",oid_val_real_39=?"+ 
              ",oid_val_real_40=?"+ 
              ",oid_val_real_41=?"+ 
              ",oid_val_real_42=?"+ 
              ",oid_val_real_43=?"+ 
              ",oid_val_real_44=?"+ 
              ",oid_val_real_45=?"+ 
              ",oid_val_real_46=?"+ 
              ",oid_val_real_47=?"+ 
              ",oid_val_real_48=?"+ 
              ",oid_val_real_49=?"+ 
              ",oid_val_real_50=?"+ 
              ",oid_val_real_51=?"+ 
              ",oid_val_real_52=?"+ 
              ",oid_val_real_53=?"+ 
              ",oid_val_real_54=?"+ 
              ",oid_val_real_55=?"+ 
              ",oid_val_real_56=?"+ 
              ",oid_val_real_57=?"+ 
              ",oid_val_real_58=?"+ 
              ",oid_val_real_59=?"+ 
              ",oid_val_real_60=?"+ 
              ",oid_val_real_61=?"+ 
              ",oid_val_real_62=?"+ 
              ",oid_val_real_63=?"+ 
              ",oid_val_real_64=?"+ 
              ",oid_val_real_65=?"+ 
              ",oid_val_real_66=?"+ 
              ",oid_val_real_67=?"+ 
              ",oid_val_real_68=?"+ 
              ",oid_val_real_69=?"+ 
              ",oid_val_real_70=?"+ 
              ",oid_val_real_71=?"+ 
              ",oid_val_real_72=?"+ 
              ",oid_val_real_73=?"+ 
              ",oid_val_real_74=?"+ 
              ",oid_val_real_75=?"+ 
              ",oid_val_real_76=?"+ 
              ",oid_val_real_77=?"+ 
              ",oid_val_real_78=?"+ 
              ",oid_val_real_79=?"+ 
              ",oid_val_real_80=?"+ 
              ",oid_val_real_81=?"+ 
              ",oid_val_real_82=?"+ 
              ",oid_val_real_83=?"+ 
              ",oid_val_real_84=?"+ 
              ",oid_val_real_85=?"+ 
              ",oid_val_real_86=?"+ 
              ",oid_val_real_87=?"+ 
              ",oid_val_real_88=?"+ 
              ",oid_val_real_89=?"+ 
              ",oid_val_real_90=?"+ 
              ",oid_val_real_91=?"+ 
              ",oid_val_real_92=?"+ 
              ",oid_val_real_93=?"+ 
              ",oid_val_real_94=?"+ 
              ",oid_val_real_95=?"+ 
              ",oid_val_real_96=?"+ 
              ",oid_val_real_97=?"+ 
              ",oid_val_real_98=?"+ 
              ",oid_val_real_99=?"+ 
              ",oid_val_real_100=?"+ 
              ",val_metrica_1=?"+ 
              ",val_metrica_2=?"+ 
              ",val_metrica_3=?"+ 
              ",val_metrica_4=?"+ 
              ",val_metrica_5=?"+ 
              ",val_metrica_6=?"+ 
              ",val_metrica_7=?"+ 
              ",val_metrica_8=?"+ 
              ",val_metrica_9=?"+ 
              ",val_metrica_10=?"+ 
              ",val_metrica_11=?"+ 
              ",val_metrica_12=?"+ 
              ",val_metrica_13=?"+ 
              ",val_metrica_14=?"+ 
              ",val_metrica_15=?"+ 
              ",val_metrica_16=?"+ 
              ",val_metrica_17=?"+ 
              ",val_metrica_18=?"+ 
              ",val_metrica_19=?"+ 
              ",val_metrica_20=?"+ 
              ",val_metrica_21=?"+ 
              ",val_metrica_22=?"+ 
              ",val_metrica_23=?"+ 
              ",val_metrica_24=?"+ 
              ",val_metrica_25=?"+ 
              ",val_metrica_26=?"+ 
              ",val_metrica_27=?"+ 
              ",val_metrica_28=?"+ 
              ",val_metrica_29=?"+ 
              ",val_metrica_30=?"+ 
              ",val_metrica_31=?"+ 
              ",val_metrica_32=?"+ 
              ",val_metrica_33=?"+ 
              ",val_metrica_34=?"+ 
              ",val_metrica_35=?"+ 
              ",val_metrica_36=?"+ 
              ",val_metrica_37=?"+ 
              ",val_metrica_38=?"+ 
              ",val_metrica_39=?"+ 
              ",val_metrica_40=?"+ 
              ",val_metrica_41=?"+ 
              ",val_metrica_42=?"+ 
              ",val_metrica_43=?"+ 
              ",val_metrica_44=?"+ 
              ",val_metrica_45=?"+ 
              ",val_metrica_46=?"+ 
              ",val_metrica_47=?"+ 
              ",val_metrica_48=?"+ 
              ",val_metrica_49=?"+ 
              ",val_metrica_50=?"+ 
              ",fec_tipo_peri_1=?"+ 
              ",fec_tipo_peri_2=?"+ 
              ",fec_tipo_peri_3=?"+ 
              ",fec_tipo_peri_4=?"+ 
              ",fec_tipo_peri_5=?"+ 
              ",fec_tipo_peri_6=?"+ 
              ",fec_tipo_peri_7=?"+ 
              ",fec_tipo_peri_8=?"+ 
              ",fec_tipo_peri_9=?"+ 
              ",fec_tipo_peri_10=?"+ 
              ",fec_tipo_peri_11=?"+ 
              ",fec_tipo_peri_12=?"+ 
              ",fec_tipo_peri_13=?"+ 
              ",fec_tipo_peri_14=?"+ 
              ",fec_tipo_peri_15=?"+ 
              ",fec_tipo_peri_16=?"+ 
              ",fec_tipo_peri_17=?"+ 
              ",fec_tipo_peri_18=?"+ 
              ",fec_tipo_peri_19=?"+ 
              ",fec_tipo_peri_20=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_val_repo_real=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_REPO_REAL,pers.getOID());
    qUpdate.setInt(OID_REPO_REAL,pers.getRepositorio_real().getOID());
    if (pers.getValor_real_1()!=null) 
      qUpdate.setInt(OID_VAL_REAL_1,pers.getValor_real_1().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_1,java.sql.Types.INTEGER);
    if (pers.getValor_real_2()!=null) 
      qUpdate.setInt(OID_VAL_REAL_2,pers.getValor_real_2().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_2,java.sql.Types.INTEGER);
    if (pers.getValor_real_3()!=null) 
      qUpdate.setInt(OID_VAL_REAL_3,pers.getValor_real_3().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_3,java.sql.Types.INTEGER);
    if (pers.getValor_real_4()!=null) 
      qUpdate.setInt(OID_VAL_REAL_4,pers.getValor_real_4().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_4,java.sql.Types.INTEGER);
    if (pers.getValor_real_5()!=null) 
      qUpdate.setInt(OID_VAL_REAL_5,pers.getValor_real_5().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_5,java.sql.Types.INTEGER);
    if (pers.getValor_real_6()!=null) 
      qUpdate.setInt(OID_VAL_REAL_6,pers.getValor_real_6().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_6,java.sql.Types.INTEGER);
    if (pers.getValor_real_7()!=null) 
      qUpdate.setInt(OID_VAL_REAL_7,pers.getValor_real_7().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_7,java.sql.Types.INTEGER);
    if (pers.getValor_real_8()!=null) 
      qUpdate.setInt(OID_VAL_REAL_8,pers.getValor_real_8().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_8,java.sql.Types.INTEGER);
    if (pers.getValor_real_9()!=null) 
      qUpdate.setInt(OID_VAL_REAL_9,pers.getValor_real_9().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_9,java.sql.Types.INTEGER);
    if (pers.getValor_real_10()!=null) 
      qUpdate.setInt(OID_VAL_REAL_10,pers.getValor_real_10().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_10,java.sql.Types.INTEGER);
    if (pers.getValor_real_11()!=null) 
      qUpdate.setInt(OID_VAL_REAL_11,pers.getValor_real_11().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_11,java.sql.Types.INTEGER);
    if (pers.getValor_real_12()!=null) 
      qUpdate.setInt(OID_VAL_REAL_12,pers.getValor_real_12().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_12,java.sql.Types.INTEGER);
    if (pers.getValor_real_13()!=null) 
      qUpdate.setInt(OID_VAL_REAL_13,pers.getValor_real_13().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_13,java.sql.Types.INTEGER);
    if (pers.getValor_real_14()!=null) 
      qUpdate.setInt(OID_VAL_REAL_14,pers.getValor_real_14().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_14,java.sql.Types.INTEGER);
    if (pers.getValor_real_15()!=null) 
      qUpdate.setInt(OID_VAL_REAL_15,pers.getValor_real_15().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_15,java.sql.Types.INTEGER);
    if (pers.getValor_real_16()!=null) 
      qUpdate.setInt(OID_VAL_REAL_16,pers.getValor_real_16().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_16,java.sql.Types.INTEGER);
    if (pers.getValor_real_17()!=null) 
      qUpdate.setInt(OID_VAL_REAL_17,pers.getValor_real_17().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_17,java.sql.Types.INTEGER);
    if (pers.getValor_real_18()!=null) 
      qUpdate.setInt(OID_VAL_REAL_18,pers.getValor_real_18().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_18,java.sql.Types.INTEGER);
    if (pers.getValor_real_19()!=null) 
      qUpdate.setInt(OID_VAL_REAL_19,pers.getValor_real_19().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_19,java.sql.Types.INTEGER);
    if (pers.getValor_real_20()!=null) 
      qUpdate.setInt(OID_VAL_REAL_20,pers.getValor_real_20().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_20,java.sql.Types.INTEGER);
    if (pers.getValor_real_21()!=null) 
      qUpdate.setInt(OID_VAL_REAL_21,pers.getValor_real_21().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_21,java.sql.Types.INTEGER);
    if (pers.getValor_real_22()!=null) 
      qUpdate.setInt(OID_VAL_REAL_22,pers.getValor_real_22().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_22,java.sql.Types.INTEGER);
    if (pers.getValor_real_23()!=null) 
      qUpdate.setInt(OID_VAL_REAL_23,pers.getValor_real_23().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_23,java.sql.Types.INTEGER);
    if (pers.getValor_real_24()!=null) 
      qUpdate.setInt(OID_VAL_REAL_24,pers.getValor_real_24().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_24,java.sql.Types.INTEGER);
    if (pers.getValor_real_25()!=null) 
      qUpdate.setInt(OID_VAL_REAL_25,pers.getValor_real_25().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_25,java.sql.Types.INTEGER);
    if (pers.getValor_real_26()!=null) 
      qUpdate.setInt(OID_VAL_REAL_26,pers.getValor_real_26().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_26,java.sql.Types.INTEGER);
    if (pers.getValor_real_27()!=null) 
      qUpdate.setInt(OID_VAL_REAL_27,pers.getValor_real_27().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_27,java.sql.Types.INTEGER);
    if (pers.getValor_real_28()!=null) 
      qUpdate.setInt(OID_VAL_REAL_28,pers.getValor_real_28().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_28,java.sql.Types.INTEGER);
    if (pers.getValor_real_29()!=null) 
      qUpdate.setInt(OID_VAL_REAL_29,pers.getValor_real_29().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_29,java.sql.Types.INTEGER);
    if (pers.getValor_real_30()!=null) 
      qUpdate.setInt(OID_VAL_REAL_30,pers.getValor_real_30().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_30,java.sql.Types.INTEGER);
    if (pers.getValor_real_31()!=null) 
      qUpdate.setInt(OID_VAL_REAL_31,pers.getValor_real_31().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_31,java.sql.Types.INTEGER);
    if (pers.getValor_real_32()!=null) 
      qUpdate.setInt(OID_VAL_REAL_32,pers.getValor_real_32().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_32,java.sql.Types.INTEGER);
    if (pers.getValor_real_33()!=null) 
      qUpdate.setInt(OID_VAL_REAL_33,pers.getValor_real_33().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_33,java.sql.Types.INTEGER);
    if (pers.getValor_real_34()!=null) 
      qUpdate.setInt(OID_VAL_REAL_34,pers.getValor_real_34().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_34,java.sql.Types.INTEGER);
    if (pers.getValor_real_35()!=null) 
      qUpdate.setInt(OID_VAL_REAL_35,pers.getValor_real_35().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_35,java.sql.Types.INTEGER);
    if (pers.getValor_real_36()!=null) 
      qUpdate.setInt(OID_VAL_REAL_36,pers.getValor_real_36().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_36,java.sql.Types.INTEGER);
    if (pers.getValor_real_37()!=null) 
      qUpdate.setInt(OID_VAL_REAL_37,pers.getValor_real_37().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_37,java.sql.Types.INTEGER);
    if (pers.getValor_real_38()!=null) 
      qUpdate.setInt(OID_VAL_REAL_38,pers.getValor_real_38().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_38,java.sql.Types.INTEGER);
    if (pers.getValor_real_39()!=null) 
      qUpdate.setInt(OID_VAL_REAL_39,pers.getValor_real_39().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_39,java.sql.Types.INTEGER);
    if (pers.getValor_real_40()!=null) 
      qUpdate.setInt(OID_VAL_REAL_40,pers.getValor_real_40().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_40,java.sql.Types.INTEGER);
    if (pers.getValor_real_41()!=null) 
      qUpdate.setInt(OID_VAL_REAL_41,pers.getValor_real_41().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_41,java.sql.Types.INTEGER);
    if (pers.getValor_real_42()!=null) 
      qUpdate.setInt(OID_VAL_REAL_42,pers.getValor_real_42().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_42,java.sql.Types.INTEGER);
    if (pers.getValor_real_43()!=null) 
      qUpdate.setInt(OID_VAL_REAL_43,pers.getValor_real_43().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_43,java.sql.Types.INTEGER);
    if (pers.getValor_real_44()!=null) 
      qUpdate.setInt(OID_VAL_REAL_44,pers.getValor_real_44().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_44,java.sql.Types.INTEGER);
    if (pers.getValor_real_45()!=null) 
      qUpdate.setInt(OID_VAL_REAL_45,pers.getValor_real_45().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_45,java.sql.Types.INTEGER);
    if (pers.getValor_real_46()!=null) 
      qUpdate.setInt(OID_VAL_REAL_46,pers.getValor_real_46().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_46,java.sql.Types.INTEGER);
    if (pers.getValor_real_47()!=null) 
      qUpdate.setInt(OID_VAL_REAL_47,pers.getValor_real_47().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_47,java.sql.Types.INTEGER);
    if (pers.getValor_real_48()!=null) 
      qUpdate.setInt(OID_VAL_REAL_48,pers.getValor_real_48().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_48,java.sql.Types.INTEGER);
    if (pers.getValor_real_49()!=null) 
      qUpdate.setInt(OID_VAL_REAL_49,pers.getValor_real_49().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_49,java.sql.Types.INTEGER);
    if (pers.getValor_real_50()!=null) 
      qUpdate.setInt(OID_VAL_REAL_50,pers.getValor_real_50().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_50,java.sql.Types.INTEGER);
    if (pers.getValor_real_51()!=null) 
      qUpdate.setInt(OID_VAL_REAL_51,pers.getValor_real_51().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_51,java.sql.Types.INTEGER);
    if (pers.getValor_real_52()!=null) 
      qUpdate.setInt(OID_VAL_REAL_52,pers.getValor_real_52().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_52,java.sql.Types.INTEGER);
    if (pers.getValor_real_53()!=null) 
      qUpdate.setInt(OID_VAL_REAL_53,pers.getValor_real_53().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_53,java.sql.Types.INTEGER);
    if (pers.getValor_real_54()!=null) 
      qUpdate.setInt(OID_VAL_REAL_54,pers.getValor_real_54().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_54,java.sql.Types.INTEGER);
    if (pers.getValor_real_55()!=null) 
      qUpdate.setInt(OID_VAL_REAL_55,pers.getValor_real_55().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_55,java.sql.Types.INTEGER);
    if (pers.getValor_real_56()!=null) 
      qUpdate.setInt(OID_VAL_REAL_56,pers.getValor_real_56().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_56,java.sql.Types.INTEGER);
    if (pers.getValor_real_57()!=null) 
      qUpdate.setInt(OID_VAL_REAL_57,pers.getValor_real_57().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_57,java.sql.Types.INTEGER);
    if (pers.getValor_real_58()!=null) 
      qUpdate.setInt(OID_VAL_REAL_58,pers.getValor_real_58().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_58,java.sql.Types.INTEGER);
    if (pers.getValor_real_59()!=null) 
      qUpdate.setInt(OID_VAL_REAL_59,pers.getValor_real_59().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_59,java.sql.Types.INTEGER);
    if (pers.getValor_real_60()!=null) 
      qUpdate.setInt(OID_VAL_REAL_60,pers.getValor_real_60().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_60,java.sql.Types.INTEGER);
    if (pers.getValor_real_61()!=null) 
      qUpdate.setInt(OID_VAL_REAL_61,pers.getValor_real_61().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_61,java.sql.Types.INTEGER);
    if (pers.getValor_real_62()!=null) 
      qUpdate.setInt(OID_VAL_REAL_62,pers.getValor_real_62().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_62,java.sql.Types.INTEGER);
    if (pers.getValor_real_63()!=null) 
      qUpdate.setInt(OID_VAL_REAL_63,pers.getValor_real_63().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_63,java.sql.Types.INTEGER);
    if (pers.getValor_real_64()!=null) 
      qUpdate.setInt(OID_VAL_REAL_64,pers.getValor_real_64().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_64,java.sql.Types.INTEGER);
    if (pers.getValor_real_65()!=null) 
      qUpdate.setInt(OID_VAL_REAL_65,pers.getValor_real_65().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_65,java.sql.Types.INTEGER);
    if (pers.getValor_real_66()!=null) 
      qUpdate.setInt(OID_VAL_REAL_66,pers.getValor_real_66().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_66,java.sql.Types.INTEGER);
    if (pers.getValor_real_67()!=null) 
      qUpdate.setInt(OID_VAL_REAL_67,pers.getValor_real_67().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_67,java.sql.Types.INTEGER);
    if (pers.getValor_real_68()!=null) 
      qUpdate.setInt(OID_VAL_REAL_68,pers.getValor_real_68().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_68,java.sql.Types.INTEGER);
    if (pers.getValor_real_69()!=null) 
      qUpdate.setInt(OID_VAL_REAL_69,pers.getValor_real_69().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_69,java.sql.Types.INTEGER);
    if (pers.getValor_real_70()!=null) 
      qUpdate.setInt(OID_VAL_REAL_70,pers.getValor_real_70().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_70,java.sql.Types.INTEGER);
    if (pers.getValor_real_71()!=null) 
      qUpdate.setInt(OID_VAL_REAL_71,pers.getValor_real_71().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_71,java.sql.Types.INTEGER);
    if (pers.getValor_real_72()!=null) 
      qUpdate.setInt(OID_VAL_REAL_72,pers.getValor_real_72().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_72,java.sql.Types.INTEGER);
    if (pers.getValor_real_73()!=null) 
      qUpdate.setInt(OID_VAL_REAL_73,pers.getValor_real_73().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_73,java.sql.Types.INTEGER);
    if (pers.getValor_real_74()!=null) 
      qUpdate.setInt(OID_VAL_REAL_74,pers.getValor_real_74().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_74,java.sql.Types.INTEGER);
    if (pers.getValor_real_75()!=null) 
      qUpdate.setInt(OID_VAL_REAL_75,pers.getValor_real_75().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_75,java.sql.Types.INTEGER);
    if (pers.getValor_real_76()!=null) 
      qUpdate.setInt(OID_VAL_REAL_76,pers.getValor_real_76().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_76,java.sql.Types.INTEGER);
    if (pers.getValor_real_77()!=null) 
      qUpdate.setInt(OID_VAL_REAL_77,pers.getValor_real_77().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_77,java.sql.Types.INTEGER);
    if (pers.getValor_real_78()!=null) 
      qUpdate.setInt(OID_VAL_REAL_78,pers.getValor_real_78().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_78,java.sql.Types.INTEGER);
    if (pers.getValor_real_79()!=null) 
      qUpdate.setInt(OID_VAL_REAL_79,pers.getValor_real_79().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_79,java.sql.Types.INTEGER);
    if (pers.getValor_real_80()!=null) 
      qUpdate.setInt(OID_VAL_REAL_80,pers.getValor_real_80().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_80,java.sql.Types.INTEGER);
    if (pers.getValor_real_81()!=null) 
      qUpdate.setInt(OID_VAL_REAL_81,pers.getValor_real_81().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_81,java.sql.Types.INTEGER);
    if (pers.getValor_real_82()!=null) 
      qUpdate.setInt(OID_VAL_REAL_82,pers.getValor_real_82().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_82,java.sql.Types.INTEGER);
    if (pers.getValor_real_83()!=null) 
      qUpdate.setInt(OID_VAL_REAL_83,pers.getValor_real_83().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_83,java.sql.Types.INTEGER);
    if (pers.getValor_real_84()!=null) 
      qUpdate.setInt(OID_VAL_REAL_84,pers.getValor_real_84().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_84,java.sql.Types.INTEGER);
    if (pers.getValor_real_85()!=null) 
      qUpdate.setInt(OID_VAL_REAL_85,pers.getValor_real_85().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_85,java.sql.Types.INTEGER);
    if (pers.getValor_real_86()!=null) 
      qUpdate.setInt(OID_VAL_REAL_86,pers.getValor_real_86().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_86,java.sql.Types.INTEGER);
    if (pers.getValor_real_87()!=null) 
      qUpdate.setInt(OID_VAL_REAL_87,pers.getValor_real_87().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_87,java.sql.Types.INTEGER);
    if (pers.getValor_real_88()!=null) 
      qUpdate.setInt(OID_VAL_REAL_88,pers.getValor_real_88().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_88,java.sql.Types.INTEGER);
    if (pers.getValor_real_89()!=null) 
      qUpdate.setInt(OID_VAL_REAL_89,pers.getValor_real_89().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_89,java.sql.Types.INTEGER);
    if (pers.getValor_real_90()!=null) 
      qUpdate.setInt(OID_VAL_REAL_90,pers.getValor_real_90().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_90,java.sql.Types.INTEGER);
    if (pers.getValor_real_91()!=null) 
      qUpdate.setInt(OID_VAL_REAL_91,pers.getValor_real_91().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_91,java.sql.Types.INTEGER);
    if (pers.getValor_real_92()!=null) 
      qUpdate.setInt(OID_VAL_REAL_92,pers.getValor_real_92().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_92,java.sql.Types.INTEGER);
    if (pers.getValor_real_93()!=null) 
      qUpdate.setInt(OID_VAL_REAL_93,pers.getValor_real_93().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_93,java.sql.Types.INTEGER);
    if (pers.getValor_real_94()!=null) 
      qUpdate.setInt(OID_VAL_REAL_94,pers.getValor_real_94().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_94,java.sql.Types.INTEGER);
    if (pers.getValor_real_95()!=null) 
      qUpdate.setInt(OID_VAL_REAL_95,pers.getValor_real_95().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_95,java.sql.Types.INTEGER);
    if (pers.getValor_real_96()!=null) 
      qUpdate.setInt(OID_VAL_REAL_96,pers.getValor_real_96().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_96,java.sql.Types.INTEGER);
    if (pers.getValor_real_97()!=null) 
      qUpdate.setInt(OID_VAL_REAL_97,pers.getValor_real_97().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_97,java.sql.Types.INTEGER);
    if (pers.getValor_real_98()!=null) 
      qUpdate.setInt(OID_VAL_REAL_98,pers.getValor_real_98().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_98,java.sql.Types.INTEGER);
    if (pers.getValor_real_99()!=null) 
      qUpdate.setInt(OID_VAL_REAL_99,pers.getValor_real_99().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_99,java.sql.Types.INTEGER);
    if (pers.getValor_real_100()!=null) 
      qUpdate.setInt(OID_VAL_REAL_100,pers.getValor_real_100().getOID());
    else
      qUpdate.setNull(OID_VAL_REAL_100,java.sql.Types.INTEGER);

    if (pers.getVal_metrica_1()!=null)
    	qUpdate.setDouble(VAL_METRICA_1,pers.getVal_metrica_1().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_1,Types.DOUBLE);
    if (pers.getVal_metrica_2()!=null)
    	qUpdate.setDouble(VAL_METRICA_2,pers.getVal_metrica_2().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_2,Types.DOUBLE);
    if (pers.getVal_metrica_3()!=null)
    	qUpdate.setDouble(VAL_METRICA_3,pers.getVal_metrica_3().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_3,Types.DOUBLE);
    if (pers.getVal_metrica_4()!=null)
    	qUpdate.setDouble(VAL_METRICA_4,pers.getVal_metrica_4().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_4,Types.DOUBLE);
    if (pers.getVal_metrica_5()!=null)
    	qUpdate.setDouble(VAL_METRICA_5,pers.getVal_metrica_5().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_5,Types.DOUBLE);
    if (pers.getVal_metrica_6()!=null)
    	qUpdate.setDouble(VAL_METRICA_6,pers.getVal_metrica_6().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_6,Types.DOUBLE);
    if (pers.getVal_metrica_7()!=null)
    	qUpdate.setDouble(VAL_METRICA_7,pers.getVal_metrica_7().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_7,Types.DOUBLE);
    if (pers.getVal_metrica_8()!=null)
    	qUpdate.setDouble(VAL_METRICA_8,pers.getVal_metrica_8().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_8,Types.DOUBLE);
    if (pers.getVal_metrica_9()!=null)
    	qUpdate.setDouble(VAL_METRICA_9,pers.getVal_metrica_9().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_9,Types.DOUBLE);
    if (pers.getVal_metrica_10()!=null)
    	qUpdate.setDouble(VAL_METRICA_10,pers.getVal_metrica_10().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_10,Types.DOUBLE);
    if (pers.getVal_metrica_11()!=null)
    	qUpdate.setDouble(VAL_METRICA_11,pers.getVal_metrica_11().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_11,Types.DOUBLE);
    if (pers.getVal_metrica_12()!=null)
    	qUpdate.setDouble(VAL_METRICA_12,pers.getVal_metrica_12().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_12,Types.DOUBLE);
    if (pers.getVal_metrica_13()!=null)
    	qUpdate.setDouble(VAL_METRICA_13,pers.getVal_metrica_13().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_13,Types.DOUBLE);
    if (pers.getVal_metrica_14()!=null)
    	qUpdate.setDouble(VAL_METRICA_14,pers.getVal_metrica_14().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_14,Types.DOUBLE);
    if (pers.getVal_metrica_15()!=null)
    	qUpdate.setDouble(VAL_METRICA_15,pers.getVal_metrica_15().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_15,Types.DOUBLE);
    if (pers.getVal_metrica_16()!=null)
    	qUpdate.setDouble(VAL_METRICA_16,pers.getVal_metrica_16().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_16,Types.DOUBLE);
    if (pers.getVal_metrica_17()!=null)
    	qUpdate.setDouble(VAL_METRICA_17,pers.getVal_metrica_17().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_17,Types.DOUBLE);
    if (pers.getVal_metrica_18()!=null)
    	qUpdate.setDouble(VAL_METRICA_18,pers.getVal_metrica_18().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_18,Types.DOUBLE);
    if (pers.getVal_metrica_19()!=null)
    	qUpdate.setDouble(VAL_METRICA_19,pers.getVal_metrica_19().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_19,Types.DOUBLE);
    if (pers.getVal_metrica_20()!=null)
    	qUpdate.setDouble(VAL_METRICA_20,pers.getVal_metrica_20().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_20,Types.DOUBLE);
    if (pers.getVal_metrica_21()!=null)
    	qUpdate.setDouble(VAL_METRICA_21,pers.getVal_metrica_21().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_21,Types.DOUBLE);
    if (pers.getVal_metrica_22()!=null)
    	qUpdate.setDouble(VAL_METRICA_22,pers.getVal_metrica_22().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_22,Types.DOUBLE);
    if (pers.getVal_metrica_23()!=null)
    	qUpdate.setDouble(VAL_METRICA_23,pers.getVal_metrica_23().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_23,Types.DOUBLE);
    if (pers.getVal_metrica_24()!=null)
    	qUpdate.setDouble(VAL_METRICA_24,pers.getVal_metrica_24().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_24,Types.DOUBLE);
    if (pers.getVal_metrica_25()!=null)
    	qUpdate.setDouble(VAL_METRICA_25,pers.getVal_metrica_25().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_25,Types.DOUBLE);
    if (pers.getVal_metrica_26()!=null)
    	qUpdate.setDouble(VAL_METRICA_26,pers.getVal_metrica_26().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_26,Types.DOUBLE);
    if (pers.getVal_metrica_27()!=null)
    	qUpdate.setDouble(VAL_METRICA_27,pers.getVal_metrica_27().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_27,Types.DOUBLE);
    if (pers.getVal_metrica_28()!=null)
    	qUpdate.setDouble(VAL_METRICA_28,pers.getVal_metrica_28().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_28,Types.DOUBLE);
    if (pers.getVal_metrica_29()!=null)
    	qUpdate.setDouble(VAL_METRICA_29,pers.getVal_metrica_29().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_29,Types.DOUBLE);
    if (pers.getVal_metrica_30()!=null)
    	qUpdate.setDouble(VAL_METRICA_30,pers.getVal_metrica_30().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_30,Types.DOUBLE);
    if (pers.getVal_metrica_31()!=null)
    	qUpdate.setDouble(VAL_METRICA_31,pers.getVal_metrica_31().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_31,Types.DOUBLE);
    if (pers.getVal_metrica_32()!=null)
    	qUpdate.setDouble(VAL_METRICA_32,pers.getVal_metrica_32().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_32,Types.DOUBLE);
    if (pers.getVal_metrica_33()!=null)
    	qUpdate.setDouble(VAL_METRICA_33,pers.getVal_metrica_33().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_33,Types.DOUBLE);
    if (pers.getVal_metrica_34()!=null)
    	qUpdate.setDouble(VAL_METRICA_34,pers.getVal_metrica_34().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_34,Types.DOUBLE);
    if (pers.getVal_metrica_35()!=null)
    	qUpdate.setDouble(VAL_METRICA_35,pers.getVal_metrica_35().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_35,Types.DOUBLE);
    if (pers.getVal_metrica_36()!=null)
    	qUpdate.setDouble(VAL_METRICA_36,pers.getVal_metrica_36().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_36,Types.DOUBLE);
    if (pers.getVal_metrica_37()!=null)
    	qUpdate.setDouble(VAL_METRICA_37,pers.getVal_metrica_37().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_37,Types.DOUBLE);
    if (pers.getVal_metrica_38()!=null)
    	qUpdate.setDouble(VAL_METRICA_38,pers.getVal_metrica_38().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_38,Types.DOUBLE);
    if (pers.getVal_metrica_39()!=null)
    	qUpdate.setDouble(VAL_METRICA_39,pers.getVal_metrica_39().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_39,Types.DOUBLE);
    if (pers.getVal_metrica_40()!=null)
    	qUpdate.setDouble(VAL_METRICA_40,pers.getVal_metrica_40().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_40,Types.DOUBLE);
    if (pers.getVal_metrica_41()!=null)
    	qUpdate.setDouble(VAL_METRICA_41,pers.getVal_metrica_41().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_41,Types.DOUBLE);
    if (pers.getVal_metrica_42()!=null)
    	qUpdate.setDouble(VAL_METRICA_42,pers.getVal_metrica_42().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_42,Types.DOUBLE);
    if (pers.getVal_metrica_43()!=null)
    	qUpdate.setDouble(VAL_METRICA_43,pers.getVal_metrica_43().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_43,Types.DOUBLE);
    if (pers.getVal_metrica_44()!=null)
    	qUpdate.setDouble(VAL_METRICA_44,pers.getVal_metrica_44().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_44,Types.DOUBLE);
    if (pers.getVal_metrica_45()!=null)
    	qUpdate.setDouble(VAL_METRICA_45,pers.getVal_metrica_45().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_45,Types.DOUBLE);
    if (pers.getVal_metrica_46()!=null)
    	qUpdate.setDouble(VAL_METRICA_46,pers.getVal_metrica_46().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_46,Types.DOUBLE);
    if (pers.getVal_metrica_47()!=null)
    	qUpdate.setDouble(VAL_METRICA_47,pers.getVal_metrica_47().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_47,Types.DOUBLE);
    if (pers.getVal_metrica_48()!=null)
    	qUpdate.setDouble(VAL_METRICA_48,pers.getVal_metrica_48().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_48,Types.DOUBLE);
    if (pers.getVal_metrica_49()!=null)
    	qUpdate.setDouble(VAL_METRICA_49,pers.getVal_metrica_49().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_49,Types.DOUBLE);
    if (pers.getVal_metrica_50()!=null)
    	qUpdate.setDouble(VAL_METRICA_50,pers.getVal_metrica_50().doubleValue());
    else
    	qUpdate.setNull(VAL_METRICA_50,Types.DOUBLE);
    
    
    if (pers.getFec_tipo_peri_1()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_1,new Date(pers.getFec_tipo_peri_1().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_1,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_2()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_2,new Date(pers.getFec_tipo_peri_2().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_2,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_3()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_3,new Date(pers.getFec_tipo_peri_3().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_3,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_4()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_4,new Date(pers.getFec_tipo_peri_4().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_4,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_5()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_5,new Date(pers.getFec_tipo_peri_5().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_5,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_6()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_6,new Date(pers.getFec_tipo_peri_6().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_6,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_7()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_7,new Date(pers.getFec_tipo_peri_7().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_7,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_8()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_8,new Date(pers.getFec_tipo_peri_8().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_8,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_9()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_9,new Date(pers.getFec_tipo_peri_9().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_9,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_10()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_10,new Date(pers.getFec_tipo_peri_10().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_10,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_11()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_11,new Date(pers.getFec_tipo_peri_11().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_11,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_12()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_12,new Date(pers.getFec_tipo_peri_12().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_12,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_13()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_13,new Date(pers.getFec_tipo_peri_13().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_13,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_14()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_14,new Date(pers.getFec_tipo_peri_14().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_14,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_15()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_15,new Date(pers.getFec_tipo_peri_15().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_15,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_16()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_16,new Date(pers.getFec_tipo_peri_16().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_16,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_17()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_17,new Date(pers.getFec_tipo_peri_17().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_17,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_18()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_18,new Date(pers.getFec_tipo_peri_18().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_18,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_19()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_19,new Date(pers.getFec_tipo_peri_19().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_19,java.sql.Types.DATE);
    if (pers.getFec_tipo_peri_20()!=null) 
    	qUpdate.setDate(FEC_TIPO_PERI_20,new Date(pers.getFec_tipo_peri_20().getTime()));
    else
      qUpdate.setNull(FEC_TIPO_PERI_20,java.sql.Types.DATE);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
    
    updateTablaEquivalencia(pers);
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
  	
    final int OID_VAL_REPO_REAL = 1; 
    ValorRealRepositorio pers = (ValorRealRepositorio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from plValRepoReal "+
                     " where " + 
                     " oid_val_repo_real=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_REPO_REAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
    
    deleteTablaEquivalencia(pers);
    
  } 
  
  private void deleteTablaEquivalencia(ValorRealRepositorio valRealRepo) throws BaseException {
  	
  	ValorEquivalenciaRepositorio valEquiRepo = 
  		ValorEquivalenciaRepositorio.getValorEquiRepo(valRealRepo,this.getSesion());
  	if (valEquiRepo!=null) {
  			valEquiRepo.delete();
  			valEquiRepo.save();
  	}
  	
  }
  

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_REPO_REAL = 1; 
    ValorRealRepositorio pers = (ValorRealRepositorio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValRepoReal "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_val_repo_real=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_REPO_REAL, pers.getOID()); 
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
      case SELECT_BY_REPOSITORIO_REAL: {
        ps = this.selectByRepositorioReal(aCondiciones); 
        break; 
      }
      case SELECT_BY_FILTROS_VARIOS: {
        ps = this.selectByFiltrosVarios(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAL_REPO_REAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValRepoReal "); 
    textSQL.append(" WHERE oid_val_repo_real = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAL_REPO_REAL, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByRepositorioReal(Object aCondiciones) throws BaseException, SQLException { 
  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  plValRepoReal "); 
  	 textSQL.append(" WHERE oid_repo_real  = ? ");
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 RepositorioReal repoReal = (RepositorioReal) aCondiciones; 
  	 querySelect.setInt(1, repoReal.getOID()); 
  	 return querySelect; 
  }
  
  private PreparedStatement selectByFiltrosVarios(Object aCondiciones) throws BaseException, SQLException { 
  	
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValRepoReal "); 
    textSQL.append(" WHERE oid_repo_real = ? ");
    
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;    
    RepositorioReal repoReal   = (RepositorioReal) condiciones.get(RepositorioReal.NICKNAME);
    
    // Armar los filtros de fechas
    HashTableDatos filtrosFecha = new HashTableDatos();
    int nroParam=1;
    IDataSet dsTipoFiltros = (IDataSet) condiciones.get("TFiltrosTiposPeri");
    dsTipoFiltros.first();
    while (!dsTipoFiltros.EOF()) {
    	
    	TipoPeriodo tipoPeri = 
    		TipoPeriodo.findByOidProxy(dsTipoFiltros.getInteger("oid_tipo_peri"),this.getSesion());
    	
    	if (dsTipoFiltros.getDate("fecha_desde")!=null) { 
    		textSQL.append(" and fec_tipo_peri_"+tipoPeri.getNroInterno()+">=? ");
    		++nroParam;
    		filtrosFecha.put(new Integer(nroParam),dsTipoFiltros.getDate("fecha_desde"));
    		
    	}
    	
    	if (dsTipoFiltros.getDate("fecha_hasta")!=null) { 
    		textSQL.append(" and fec_tipo_peri_"+tipoPeri.getNroInterno()+"<=? ");
    		++nroParam;
    		filtrosFecha.put(new Integer(nroParam),dsTipoFiltros.getDate("fecha_hasta"));
    	}
    	
    	
    	dsTipoFiltros.next();
    }
    
    IDataSet dsFiltrosCompo = (IDataSet) condiciones.get("TFiltrosCompo");
    dsFiltrosCompo.first();
    while (!dsFiltrosCompo.EOF()) {
    	DefinicionRepositorioReal defRepoReal =
    		DefinicionRepositorioReal.findByOid(dsFiltrosCompo.getInteger("oid_repo_det"),this.getSesion());
    	if (defRepoReal!=null) {
    		
    		CompoPresupuestario compoPresu = defRepoReal.getCompo_presupuestario(); 
    		
    		// Recorrer la tabla de Valores Reales
    		List listaOidValReal = new ArrayList();
    		IDataSet dsValCompoReal = (IDataSet) condiciones.get("TValCompoReal"+dsFiltrosCompo.getInteger("nro_fila"));
    		dsValCompoReal.first();
    		while (!dsValCompoReal.EOF()) {
    			if (dsValCompoReal.getBoolean("sel").booleanValue()) 
    				listaOidValReal.add(dsValCompoReal.getInteger("oid"));
    			dsValCompoReal.next();
    		}
    		
    		//Si la lista contiene elementos aplicar filtro
    		if (listaOidValReal.size()!=0) {
    			textSQL.append(" and oid_val_real_"+compoPresu.getNro_interno_compo()+" in (");
    			Iterator iterOidValCompoReal = listaOidValReal.iterator();
    			boolean firstOid = true;
    			while (iterOidValCompoReal.hasNext()) {
    				Integer oidValCompoReal = (Integer) iterOidValCompoReal.next();
    				if (firstOid) {
    					textSQL.append(oidValCompoReal);
    					firstOid = false;
    				} else {
    					textSQL.append(","+oidValCompoReal);
    				}
    				
    			}
    			textSQL.append(") ");
    		}
    		
    	}
    	
    	
    	dsFiltrosCompo.next();
    }
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());    
    querySelect.setInt(1,repoReal.getOID());
    //Set los valores de fecha
    Iterator iterNrosParametros = filtrosFecha.keySet().iterator();
    while (iterNrosParametros.hasNext()) {
    	Integer nroParametro = (Integer) iterNrosParametros.next();
    	java.util.Date fecha = (java.util.Date) filtrosFecha.get(nroParametro);
    	querySelect.setDate(nroParametro.intValue(), new Date(fecha.getTime()));
    }
    
    return querySelect; 
  }
  
  		
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValRepoReal "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_val_repo_real oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plValRepoReal");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getValoresRealesRepositorio(RepositorioReal repoReal,
      																					 ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ValorRealRepositorio.NICKNAME,
         DBValorRealRepositorio.SELECT_BY_REPOSITORIO_REAL,
         repoReal,
         new ListObserver(),
         aSesion);
  }
  
  public static List getValoresRealesByFiltrosVarios(RepositorioReal repoReal,
  																									 IDataSet dsTipoPeriodo,
  																									 IDataSet dsFiltrosCompo,
  																									 IDataSet dsValCompoReal1,
  																									 IDataSet dsValCompoReal2,
  																									 IDataSet dsValCompoReal3,
  																									 IDataSet dsValCompoReal4,
  																									 IDataSet dsValCompoReal5,
  																									 ISesion aSesion) throws BaseException {
  	
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(RepositorioReal.NICKNAME,repoReal);
  	condiciones.put("TFiltrosTiposPeri",dsTipoPeriodo);
  	condiciones.put("TFiltrosCompo",dsFiltrosCompo);
  	condiciones.put("TValCompoReal1",dsValCompoReal1);
  	condiciones.put("TValCompoReal2",dsValCompoReal2);
  	condiciones.put("TValCompoReal3",dsValCompoReal3);
  	condiciones.put("TValCompoReal4",dsValCompoReal4);
  	condiciones.put("TValCompoReal5",dsValCompoReal5);
  	
  	return (List) ObjetoLogico.getObjects(ValorRealRepositorio.NICKNAME,
  			DBValorRealRepositorio.SELECT_BY_FILTROS_VARIOS,
  			condiciones,
  			new ListObserver(),
  			aSesion);
  	
  }
  
} 
