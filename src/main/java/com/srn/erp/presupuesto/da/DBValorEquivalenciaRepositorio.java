package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.presupuesto.bm.ValorEquivalenciaRepositorio;
import com.srn.erp.presupuesto.bm.ValorRealRepositorio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValorEquivalenciaRepositorio extends DBObjetoPersistente {

  public static final String OID_EQUIV = "oid_equiv";
  public static final String OID_REPO_REAL = "oid_repo_real";
  public static final String OID_VAL_REPO_REAL = "oid_val_repo_real";
  public static final String OID_VAL_1 = "oid_val_1";
  public static final String OID_VAL_2 = "oid_val_2";
  public static final String OID_VAL_3 = "oid_val_3";
  public static final String OID_VAL_4 = "oid_val_4";
  public static final String OID_VAL_5 = "oid_val_5";
  public static final String OID_VAL_6 = "oid_val_6";
  public static final String OID_VAL_7 = "oid_val_7";
  public static final String OID_VAL_8 = "oid_val_8";
  public static final String OID_VAL_9 = "oid_val_9";
  public static final String OID_VAL_10 = "oid_val_10";
  public static final String OID_VAL_11 = "oid_val_11";
  public static final String OID_VAL_12 = "oid_val_12";
  public static final String OID_VAL_13 = "oid_val_13";
  public static final String OID_VAL_14 = "oid_val_14";
  public static final String OID_VAL_15 = "oid_val_15";
  public static final String OID_VAL_16 = "oid_val_16";
  public static final String OID_VAL_17 = "oid_val_17";
  public static final String OID_VAL_18 = "oid_val_18";
  public static final String OID_VAL_19 = "oid_val_19";
  public static final String OID_VAL_20 = "oid_val_20";
  public static final String OID_VAL_21 = "oid_val_21";
  public static final String OID_VAL_22 = "oid_val_22";
  public static final String OID_VAL_23 = "oid_val_23";
  public static final String OID_VAL_24 = "oid_val_24";
  public static final String OID_VAL_25 = "oid_val_25";
  public static final String OID_VAL_26 = "oid_val_26";
  public static final String OID_VAL_27 = "oid_val_27";
  public static final String OID_VAL_28 = "oid_val_28";
  public static final String OID_VAL_29 = "oid_val_29";
  public static final String OID_VAL_30 = "oid_val_30";
  public static final String OID_VAL_31 = "oid_val_31";
  public static final String OID_VAL_32 = "oid_val_32";
  public static final String OID_VAL_33 = "oid_val_33";
  public static final String OID_VAL_34 = "oid_val_34";
  public static final String OID_VAL_35 = "oid_val_35";
  public static final String OID_VAL_36 = "oid_val_36";
  public static final String OID_VAL_37 = "oid_val_37";
  public static final String OID_VAL_38 = "oid_val_38";
  public static final String OID_VAL_39 = "oid_val_39";
  public static final String OID_VAL_40 = "oid_val_40";
  public static final String OID_VAL_41 = "oid_val_41";
  public static final String OID_VAL_42 = "oid_val_42";
  public static final String OID_VAL_43 = "oid_val_43";
  public static final String OID_VAL_44 = "oid_val_44";
  public static final String OID_VAL_45 = "oid_val_45";
  public static final String OID_VAL_46 = "oid_val_46";
  public static final String OID_VAL_47 = "oid_val_47";
  public static final String OID_VAL_48 = "oid_val_48";
  public static final String OID_VAL_49 = "oid_val_49";
  public static final String OID_VAL_50 = "oid_val_50";
  public static final String OID_VAL_51 = "oid_val_51";
  public static final String OID_VAL_52 = "oid_val_52";
  public static final String OID_VAL_53 = "oid_val_53";
  public static final String OID_VAL_54 = "oid_val_54";
  public static final String OID_VAL_55 = "oid_val_55";
  public static final String OID_VAL_56 = "oid_val_56";
  public static final String OID_VAL_57 = "oid_val_57";
  public static final String OID_VAL_58 = "oid_val_58";
  public static final String OID_VAL_59 = "oid_val_59";
  public static final String OID_VAL_60 = "oid_val_60";
  public static final String OID_VAL_61 = "oid_val_61";
  public static final String OID_VAL_62 = "oid_val_62";
  public static final String OID_VAL_63 = "oid_val_63";
  public static final String OID_VAL_64 = "oid_val_64";
  public static final String OID_VAL_65 = "oid_val_65";
  public static final String OID_VAL_66 = "oid_val_66";
  public static final String OID_VAL_67 = "oid_val_67";
  public static final String OID_VAL_68 = "oid_val_68";
  public static final String OID_VAL_69 = "oid_val_69";
  public static final String OID_VAL_70 = "oid_val_70";
  public static final String OID_VAL_71 = "oid_val_71";
  public static final String OID_VAL_72 = "oid_val_72";
  public static final String OID_VAL_73 = "oid_val_73";
  public static final String OID_VAL_74 = "oid_val_74";
  public static final String OID_VAL_75 = "oid_val_75";
  public static final String OID_VAL_76 = "oid_val_76";
  public static final String OID_VAL_77 = "oid_val_77";
  public static final String OID_VAL_78 = "oid_val_78";
  public static final String OID_VAL_79 = "oid_val_79";
  public static final String OID_VAL_80 = "oid_val_80";
  public static final String OID_VAL_81 = "oid_val_81";
  public static final String OID_VAL_82 = "oid_val_82";
  public static final String OID_VAL_83 = "oid_val_83";
  public static final String OID_VAL_84 = "oid_val_84";
  public static final String OID_VAL_85 = "oid_val_85";
  public static final String OID_VAL_86 = "oid_val_86";
  public static final String OID_VAL_87 = "oid_val_87";
  public static final String OID_VAL_88 = "oid_val_88";
  public static final String OID_VAL_89 = "oid_val_89";
  public static final String OID_VAL_90 = "oid_val_90";
  public static final String OID_VAL_91 = "oid_val_91";
  public static final String OID_VAL_92 = "oid_val_92";
  public static final String OID_VAL_93 = "oid_val_93";
  public static final String OID_VAL_94 = "oid_val_94";
  public static final String OID_VAL_95 = "oid_val_95";
  public static final String OID_VAL_96 = "oid_val_96";
  public static final String OID_VAL_97 = "oid_val_97";
  public static final String OID_VAL_98 = "oid_val_98";
  public static final String OID_VAL_99 = "oid_val_99";
  public static final String OID_VAL_100 = "oid_val_100";
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
  public static final String OID_PERI_1 = "oid_peri_1";
  public static final String OID_PERI_2 = "oid_peri_2";
  public static final String OID_PERI_3 = "oid_peri_3";
  public static final String OID_PERI_4 = "oid_peri_4";
  public static final String OID_PERI_5 = "oid_peri_5";
  public static final String OID_PERI_6 = "oid_peri_6";
  public static final String OID_PERI_7 = "oid_peri_7";
  public static final String OID_PERI_8 = "oid_peri_8";
  public static final String OID_PERI_9 = "oid_peri_9";
  public static final String OID_PERI_10 = "oid_peri_10";
  public static final String OID_PERI_11 = "oid_peri_11";
  public static final String OID_PERI_12 = "oid_peri_12";
  public static final String OID_PERI_13 = "oid_peri_13";
  public static final String OID_PERI_14 = "oid_peri_14";
  public static final String OID_PERI_15 = "oid_peri_15";
  public static final String OID_PERI_16 = "oid_peri_16";
  public static final String OID_PERI_17 = "oid_peri_17";
  public static final String OID_PERI_18 = "oid_peri_18";
  public static final String OID_PERI_19 = "oid_peri_19";
  public static final String OID_PERI_20 = "oid_peri_20";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_VAL_REPO_REAL = 100;
  

  public DBValorEquivalenciaRepositorio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EQUIV = 1;
    final int OID_REPO_REAL = 2;
    final int OID_VAL_1 = 3;
    final int OID_VAL_2 = 4;
    final int OID_VAL_3 = 5;
    final int OID_VAL_4 = 6;
    final int OID_VAL_5 = 7;
    final int OID_VAL_6 = 8;
    final int OID_VAL_7 = 9;
    final int OID_VAL_8 = 10;
    final int OID_VAL_9 = 11;
    final int OID_VAL_10 = 12;
    final int OID_VAL_11 = 13;
    final int OID_VAL_12 = 14;
    final int OID_VAL_13 = 15;
    final int OID_VAL_14 = 16;
    final int OID_VAL_15 = 17;
    final int OID_VAL_16 = 18;
    final int OID_VAL_17 = 19;
    final int OID_VAL_18 = 20;
    final int OID_VAL_19 = 21;
    final int OID_VAL_20 = 22;
    final int OID_VAL_21 = 23;
    final int OID_VAL_22 = 24;
    final int OID_VAL_23 = 25;
    final int OID_VAL_24 = 26;
    final int OID_VAL_25 = 27;
    final int OID_VAL_26 = 28;
    final int OID_VAL_27 = 29;
    final int OID_VAL_28 = 30;
    final int OID_VAL_29 = 31;
    final int OID_VAL_30 = 32;
    final int OID_VAL_31 = 33;
    final int OID_VAL_32 = 34;
    final int OID_VAL_33 = 35;
    final int OID_VAL_34 = 36;
    final int OID_VAL_35 = 37;
    final int OID_VAL_36 = 38;
    final int OID_VAL_37 = 39;
    final int OID_VAL_38 = 40;
    final int OID_VAL_39 = 41;
    final int OID_VAL_40 = 42;
    final int OID_VAL_41 = 43;
    final int OID_VAL_42 = 44;
    final int OID_VAL_43 = 45;
    final int OID_VAL_44 = 46;
    final int OID_VAL_45 = 47;
    final int OID_VAL_46 = 48;
    final int OID_VAL_47 = 49;
    final int OID_VAL_48 = 50;
    final int OID_VAL_49 = 51;
    final int OID_VAL_50 = 52;
    final int OID_VAL_51 = 53;
    final int OID_VAL_52 = 54;
    final int OID_VAL_53 = 55;
    final int OID_VAL_54 = 56;
    final int OID_VAL_55 = 57;
    final int OID_VAL_56 = 58;
    final int OID_VAL_57 = 59;
    final int OID_VAL_58 = 60;
    final int OID_VAL_59 = 61;
    final int OID_VAL_60 = 62;
    final int OID_VAL_61 = 63;
    final int OID_VAL_62 = 64;
    final int OID_VAL_63 = 65;
    final int OID_VAL_64 = 66;
    final int OID_VAL_65 = 67;
    final int OID_VAL_66 = 68;
    final int OID_VAL_67 = 69;
    final int OID_VAL_68 = 70;
    final int OID_VAL_69 = 71;
    final int OID_VAL_70 = 72;
    final int OID_VAL_71 = 73;
    final int OID_VAL_72 = 74;
    final int OID_VAL_73 = 75;
    final int OID_VAL_74 = 76;
    final int OID_VAL_75 = 77;
    final int OID_VAL_76 = 78;
    final int OID_VAL_77 = 79;
    final int OID_VAL_78 = 80;
    final int OID_VAL_79 = 81;
    final int OID_VAL_80 = 82;
    final int OID_VAL_81 = 83;
    final int OID_VAL_82 = 84;
    final int OID_VAL_83 = 85;
    final int OID_VAL_84 = 86;
    final int OID_VAL_85 = 87;
    final int OID_VAL_86 = 88;
    final int OID_VAL_87 = 89;
    final int OID_VAL_88 = 90;
    final int OID_VAL_89 = 91;
    final int OID_VAL_90 = 92;
    final int OID_VAL_91 = 93;
    final int OID_VAL_92 = 94;
    final int OID_VAL_93 = 95;
    final int OID_VAL_94 = 96;
    final int OID_VAL_95 = 97;
    final int OID_VAL_96 = 98;
    final int OID_VAL_97 = 99;
    final int OID_VAL_98 = 100;
    final int OID_VAL_99 = 101;
    final int OID_VAL_100 = 102;
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
    final int OID_PERI_1 = 153;
    final int OID_PERI_2 = 154;
    final int OID_PERI_3 = 155;
    final int OID_PERI_4 = 156;
    final int OID_PERI_5 = 157;
    final int OID_PERI_6 = 158;
    final int OID_PERI_7 = 159;
    final int OID_PERI_8 = 160;
    final int OID_PERI_9 = 161;
    final int OID_PERI_10 = 162;
    final int OID_PERI_11 = 163;
    final int OID_PERI_12 = 164;
    final int OID_PERI_13 = 165;
    final int OID_PERI_14 = 166;
    final int OID_PERI_15 = 167;
    final int OID_PERI_16 = 168;
    final int OID_PERI_17 = 169;
    final int OID_PERI_18 = 170;
    final int OID_PERI_19 = 171;
    final int OID_PERI_20 = 172;
    final int ACTIVO = 173;
    final int OID_VAL_REPO_REAL = 174;

    ValorEquivalenciaRepositorio pers = (ValorEquivalenciaRepositorio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plValEquivRepoReal "+
                     " ( "+
                      "OID_EQUIV,"+
                      "OID_REPO_REAL,"+
                      "OID_VAL_1,"+
                      "OID_VAL_2,"+
                      "OID_VAL_3,"+
                      "OID_VAL_4,"+
                      "OID_VAL_5,"+
                      "OID_VAL_6,"+
                      "OID_VAL_7,"+
                      "OID_VAL_8,"+
                      "OID_VAL_9,"+
                      "OID_VAL_10,"+
                      "OID_VAL_11,"+
                      "OID_VAL_12,"+
                      "OID_VAL_13,"+
                      "OID_VAL_14,"+
                      "OID_VAL_15,"+
                      "OID_VAL_16,"+
                      "OID_VAL_17,"+
                      "OID_VAL_18,"+
                      "OID_VAL_19,"+
                      "OID_VAL_20,"+
                      "OID_VAL_21,"+
                      "OID_VAL_22,"+
                      "OID_VAL_23,"+
                      "OID_VAL_24,"+
                      "OID_VAL_25,"+
                      "OID_VAL_26,"+
                      "OID_VAL_27,"+
                      "OID_VAL_28,"+
                      "OID_VAL_29,"+
                      "OID_VAL_30,"+
                      "OID_VAL_31,"+
                      "OID_VAL_32,"+
                      "OID_VAL_33,"+
                      "OID_VAL_34,"+
                      "OID_VAL_35,"+
                      "OID_VAL_36,"+
                      "OID_VAL_37,"+
                      "OID_VAL_38,"+
                      "OID_VAL_39,"+
                      "OID_VAL_40,"+
                      "OID_VAL_41,"+
                      "OID_VAL_42,"+
                      "OID_VAL_43,"+
                      "OID_VAL_44,"+
                      "OID_VAL_45,"+
                      "OID_VAL_46,"+
                      "OID_VAL_47,"+
                      "OID_VAL_48,"+
                      "OID_VAL_49,"+
                      "OID_VAL_50,"+
                      "OID_VAL_51,"+
                      "OID_VAL_52,"+
                      "OID_VAL_53,"+
                      "OID_VAL_54,"+
                      "OID_VAL_55,"+
                      "OID_VAL_56,"+
                      "OID_VAL_57,"+
                      "OID_VAL_58,"+
                      "OID_VAL_59,"+
                      "OID_VAL_60,"+
                      "OID_VAL_61,"+
                      "OID_VAL_62,"+
                      "OID_VAL_63,"+
                      "OID_VAL_64,"+
                      "OID_VAL_65,"+
                      "OID_VAL_66,"+
                      "OID_VAL_67,"+
                      "OID_VAL_68,"+
                      "OID_VAL_69,"+
                      "OID_VAL_70,"+
                      "OID_VAL_71,"+
                      "OID_VAL_72,"+
                      "OID_VAL_73,"+
                      "OID_VAL_74,"+
                      "OID_VAL_75,"+
                      "OID_VAL_76,"+
                      "OID_VAL_77,"+
                      "OID_VAL_78,"+
                      "OID_VAL_79,"+
                      "OID_VAL_80,"+
                      "OID_VAL_81,"+
                      "OID_VAL_82,"+
                      "OID_VAL_83,"+
                      "OID_VAL_84,"+
                      "OID_VAL_85,"+
                      "OID_VAL_86,"+
                      "OID_VAL_87,"+
                      "OID_VAL_88,"+
                      "OID_VAL_89,"+
                      "OID_VAL_90,"+
                      "OID_VAL_91,"+
                      "OID_VAL_92,"+
                      "OID_VAL_93,"+
                      "OID_VAL_94,"+
                      "OID_VAL_95,"+
                      "OID_VAL_96,"+
                      "OID_VAL_97,"+
                      "OID_VAL_98,"+
                      "OID_VAL_99,"+
                      "OID_VAL_100,"+
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
                      "OID_PERI_1,"+
                      "OID_PERI_2,"+
                      "OID_PERI_3,"+
                      "OID_PERI_4,"+
                      "OID_PERI_5,"+
                      "OID_PERI_6,"+
                      "OID_PERI_7,"+
                      "OID_PERI_8,"+
                      "OID_PERI_9,"+
                      "OID_PERI_10,"+
                      "OID_PERI_11,"+
                      "OID_PERI_12,"+
                      "OID_PERI_13,"+
                      "OID_PERI_14,"+
                      "OID_PERI_15,"+
                      "OID_PERI_16,"+
                      "OID_PERI_17,"+
                      "OID_PERI_18,"+
                      "OID_PERI_19,"+
                      "OID_PERI_20,"+
                      "ACTIVO, OID_VAL_REPO_REAL)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EQUIV,pers.getOID());
    qInsert.setInt(OID_REPO_REAL,pers.getRepositorio_real().getOID());
    if (pers.getValor_compo_presu1()!=null) 
      qInsert.setInt(OID_VAL_1,pers.getValor_compo_presu1().getOID());
    else
      qInsert.setNull(OID_VAL_1,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu2()!=null) 
      qInsert.setInt(OID_VAL_2,pers.getValor_compo_presu2().getOID());
    else
      qInsert.setNull(OID_VAL_2,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu3()!=null) 
      qInsert.setInt(OID_VAL_3,pers.getValor_compo_presu3().getOID());
    else
      qInsert.setNull(OID_VAL_3,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu4()!=null) 
      qInsert.setInt(OID_VAL_4,pers.getValor_compo_presu4().getOID());
    else
      qInsert.setNull(OID_VAL_4,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu5()!=null) 
      qInsert.setInt(OID_VAL_5,pers.getValor_compo_presu5().getOID());
    else
      qInsert.setNull(OID_VAL_5,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu6()!=null) 
      qInsert.setInt(OID_VAL_6,pers.getValor_compo_presu6().getOID());
    else
      qInsert.setNull(OID_VAL_6,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu7()!=null) 
      qInsert.setInt(OID_VAL_7,pers.getValor_compo_presu7().getOID());
    else
      qInsert.setNull(OID_VAL_7,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu8()!=null) 
      qInsert.setInt(OID_VAL_8,pers.getValor_compo_presu8().getOID());
    else
      qInsert.setNull(OID_VAL_8,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu9()!=null) 
      qInsert.setInt(OID_VAL_9,pers.getValor_compo_presu9().getOID());
    else
      qInsert.setNull(OID_VAL_9,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu10()!=null) 
      qInsert.setInt(OID_VAL_10,pers.getValor_compo_presu10().getOID());
    else
      qInsert.setNull(OID_VAL_10,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu11()!=null) 
      qInsert.setInt(OID_VAL_11,pers.getValor_compo_presu11().getOID());
    else
      qInsert.setNull(OID_VAL_11,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu12()!=null) 
      qInsert.setInt(OID_VAL_12,pers.getValor_compo_presu12().getOID());
    else
      qInsert.setNull(OID_VAL_12,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu13()!=null) 
      qInsert.setInt(OID_VAL_13,pers.getValor_compo_presu13().getOID());
    else
      qInsert.setNull(OID_VAL_13,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu14()!=null) 
      qInsert.setInt(OID_VAL_14,pers.getValor_compo_presu14().getOID());
    else
      qInsert.setNull(OID_VAL_14,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu15()!=null) 
      qInsert.setInt(OID_VAL_15,pers.getValor_compo_presu15().getOID());
    else
      qInsert.setNull(OID_VAL_15,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu16()!=null) 
      qInsert.setInt(OID_VAL_16,pers.getValor_compo_presu16().getOID());
    else
      qInsert.setNull(OID_VAL_16,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu17()!=null) 
      qInsert.setInt(OID_VAL_17,pers.getValor_compo_presu17().getOID());
    else
      qInsert.setNull(OID_VAL_17,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu18()!=null) 
      qInsert.setInt(OID_VAL_18,pers.getValor_compo_presu18().getOID());
    else
      qInsert.setNull(OID_VAL_18,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu19()!=null) 
      qInsert.setInt(OID_VAL_19,pers.getValor_compo_presu19().getOID());
    else
      qInsert.setNull(OID_VAL_19,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu20()!=null) 
      qInsert.setInt(OID_VAL_20,pers.getValor_compo_presu20().getOID());
    else
      qInsert.setNull(OID_VAL_20,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu21()!=null) 
      qInsert.setInt(OID_VAL_21,pers.getValor_compo_presu21().getOID());
    else
      qInsert.setNull(OID_VAL_21,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu22()!=null) 
      qInsert.setInt(OID_VAL_22,pers.getValor_compo_presu22().getOID());
    else
      qInsert.setNull(OID_VAL_22,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu23()!=null) 
      qInsert.setInt(OID_VAL_23,pers.getValor_compo_presu23().getOID());
    else
      qInsert.setNull(OID_VAL_23,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu24()!=null) 
      qInsert.setInt(OID_VAL_24,pers.getValor_compo_presu24().getOID());
    else
      qInsert.setNull(OID_VAL_24,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu25()!=null) 
      qInsert.setInt(OID_VAL_25,pers.getValor_compo_presu25().getOID());
    else
      qInsert.setNull(OID_VAL_25,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu26()!=null) 
      qInsert.setInt(OID_VAL_26,pers.getValor_compo_presu26().getOID());
    else
      qInsert.setNull(OID_VAL_26,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu27()!=null) 
      qInsert.setInt(OID_VAL_27,pers.getValor_compo_presu27().getOID());
    else
      qInsert.setNull(OID_VAL_27,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu28()!=null) 
      qInsert.setInt(OID_VAL_28,pers.getValor_compo_presu28().getOID());
    else
      qInsert.setNull(OID_VAL_28,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu29()!=null) 
      qInsert.setInt(OID_VAL_29,pers.getValor_compo_presu29().getOID());
    else
      qInsert.setNull(OID_VAL_29,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu30()!=null) 
      qInsert.setInt(OID_VAL_30,pers.getValor_compo_presu30().getOID());
    else
      qInsert.setNull(OID_VAL_30,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu31()!=null) 
      qInsert.setInt(OID_VAL_31,pers.getValor_compo_presu31().getOID());
    else
      qInsert.setNull(OID_VAL_31,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu32()!=null) 
      qInsert.setInt(OID_VAL_32,pers.getValor_compo_presu32().getOID());
    else
      qInsert.setNull(OID_VAL_32,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu33()!=null) 
      qInsert.setInt(OID_VAL_33,pers.getValor_compo_presu33().getOID());
    else
      qInsert.setNull(OID_VAL_33,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu34()!=null) 
      qInsert.setInt(OID_VAL_34,pers.getValor_compo_presu34().getOID());
    else
      qInsert.setNull(OID_VAL_34,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu35()!=null) 
      qInsert.setInt(OID_VAL_35,pers.getValor_compo_presu35().getOID());
    else
      qInsert.setNull(OID_VAL_35,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu36()!=null) 
      qInsert.setInt(OID_VAL_36,pers.getValor_compo_presu36().getOID());
    else
      qInsert.setNull(OID_VAL_36,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu37()!=null) 
      qInsert.setInt(OID_VAL_37,pers.getValor_compo_presu37().getOID());
    else
      qInsert.setNull(OID_VAL_37,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu38()!=null) 
      qInsert.setInt(OID_VAL_38,pers.getValor_compo_presu38().getOID());
    else
      qInsert.setNull(OID_VAL_38,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu39()!=null) 
      qInsert.setInt(OID_VAL_39,pers.getValor_compo_presu39().getOID());
    else
      qInsert.setNull(OID_VAL_39,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu40()!=null) 
      qInsert.setInt(OID_VAL_40,pers.getValor_compo_presu40().getOID());
    else
      qInsert.setNull(OID_VAL_40,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu41()!=null) 
      qInsert.setInt(OID_VAL_41,pers.getValor_compo_presu41().getOID());
    else
      qInsert.setNull(OID_VAL_41,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu42()!=null) 
      qInsert.setInt(OID_VAL_42,pers.getValor_compo_presu42().getOID());
    else
      qInsert.setNull(OID_VAL_42,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu43()!=null) 
      qInsert.setInt(OID_VAL_43,pers.getValor_compo_presu43().getOID());
    else
      qInsert.setNull(OID_VAL_43,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu44()!=null) 
      qInsert.setInt(OID_VAL_44,pers.getValor_compo_presu44().getOID());
    else
      qInsert.setNull(OID_VAL_44,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu45()!=null) 
      qInsert.setInt(OID_VAL_45,pers.getValor_compo_presu45().getOID());
    else
      qInsert.setNull(OID_VAL_45,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu46()!=null) 
      qInsert.setInt(OID_VAL_46,pers.getValor_compo_presu46().getOID());
    else
      qInsert.setNull(OID_VAL_46,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu47()!=null) 
      qInsert.setInt(OID_VAL_47,pers.getValor_compo_presu47().getOID());
    else
      qInsert.setNull(OID_VAL_47,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu48()!=null) 
      qInsert.setInt(OID_VAL_48,pers.getValor_compo_presu48().getOID());
    else
      qInsert.setNull(OID_VAL_48,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu49()!=null) 
      qInsert.setInt(OID_VAL_49,pers.getValor_compo_presu49().getOID());
    else
      qInsert.setNull(OID_VAL_49,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu50()!=null) 
      qInsert.setInt(OID_VAL_50,pers.getValor_compo_presu50().getOID());
    else
      qInsert.setNull(OID_VAL_50,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu51()!=null) 
      qInsert.setInt(OID_VAL_51,pers.getValor_compo_presu51().getOID());
    else
      qInsert.setNull(OID_VAL_51,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu52()!=null) 
      qInsert.setInt(OID_VAL_52,pers.getValor_compo_presu52().getOID());
    else
      qInsert.setNull(OID_VAL_52,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu53()!=null) 
      qInsert.setInt(OID_VAL_53,pers.getValor_compo_presu53().getOID());
    else
      qInsert.setNull(OID_VAL_53,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu54()!=null) 
      qInsert.setInt(OID_VAL_54,pers.getValor_compo_presu54().getOID());
    else
      qInsert.setNull(OID_VAL_54,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu55()!=null) 
      qInsert.setInt(OID_VAL_55,pers.getValor_compo_presu55().getOID());
    else
      qInsert.setNull(OID_VAL_55,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu56()!=null) 
      qInsert.setInt(OID_VAL_56,pers.getValor_compo_presu56().getOID());
    else
      qInsert.setNull(OID_VAL_56,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu57()!=null) 
      qInsert.setInt(OID_VAL_57,pers.getValor_compo_presu57().getOID());
    else
      qInsert.setNull(OID_VAL_57,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu58()!=null) 
      qInsert.setInt(OID_VAL_58,pers.getValor_compo_presu58().getOID());
    else
      qInsert.setNull(OID_VAL_58,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu59()!=null) 
      qInsert.setInt(OID_VAL_59,pers.getValor_compo_presu59().getOID());
    else
      qInsert.setNull(OID_VAL_59,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu60()!=null) 
      qInsert.setInt(OID_VAL_60,pers.getValor_compo_presu60().getOID());
    else
      qInsert.setNull(OID_VAL_60,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu61()!=null) 
      qInsert.setInt(OID_VAL_61,pers.getValor_compo_presu61().getOID());
    else
      qInsert.setNull(OID_VAL_61,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu62()!=null) 
      qInsert.setInt(OID_VAL_62,pers.getValor_compo_presu62().getOID());
    else
      qInsert.setNull(OID_VAL_62,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu63()!=null) 
      qInsert.setInt(OID_VAL_63,pers.getValor_compo_presu63().getOID());
    else
      qInsert.setNull(OID_VAL_63,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu64()!=null) 
      qInsert.setInt(OID_VAL_64,pers.getValor_compo_presu64().getOID());
    else
      qInsert.setNull(OID_VAL_64,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu65()!=null) 
      qInsert.setInt(OID_VAL_65,pers.getValor_compo_presu65().getOID());
    else
      qInsert.setNull(OID_VAL_65,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu66()!=null) 
      qInsert.setInt(OID_VAL_66,pers.getValor_compo_presu66().getOID());
    else
      qInsert.setNull(OID_VAL_66,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu67()!=null) 
      qInsert.setInt(OID_VAL_67,pers.getValor_compo_presu67().getOID());
    else
      qInsert.setNull(OID_VAL_67,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu68()!=null) 
      qInsert.setInt(OID_VAL_68,pers.getValor_compo_presu68().getOID());
    else
      qInsert.setNull(OID_VAL_68,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu69()!=null) 
      qInsert.setInt(OID_VAL_69,pers.getValor_compo_presu69().getOID());
    else
      qInsert.setNull(OID_VAL_69,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu70()!=null) 
      qInsert.setInt(OID_VAL_70,pers.getValor_compo_presu70().getOID());
    else
      qInsert.setNull(OID_VAL_70,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu71()!=null) 
      qInsert.setInt(OID_VAL_71,pers.getValor_compo_presu71().getOID());
    else
      qInsert.setNull(OID_VAL_71,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu72()!=null) 
      qInsert.setInt(OID_VAL_72,pers.getValor_compo_presu72().getOID());
    else
      qInsert.setNull(OID_VAL_72,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu73()!=null) 
      qInsert.setInt(OID_VAL_73,pers.getValor_compo_presu73().getOID());
    else
      qInsert.setNull(OID_VAL_73,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu74()!=null) 
      qInsert.setInt(OID_VAL_74,pers.getValor_compo_presu74().getOID());
    else
      qInsert.setNull(OID_VAL_74,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu75()!=null) 
      qInsert.setInt(OID_VAL_75,pers.getValor_compo_presu75().getOID());
    else
      qInsert.setNull(OID_VAL_75,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu76()!=null) 
      qInsert.setInt(OID_VAL_76,pers.getValor_compo_presu76().getOID());
    else
      qInsert.setNull(OID_VAL_76,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu77()!=null) 
      qInsert.setInt(OID_VAL_77,pers.getValor_compo_presu77().getOID());
    else
      qInsert.setNull(OID_VAL_77,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu78()!=null) 
      qInsert.setInt(OID_VAL_78,pers.getValor_compo_presu78().getOID());
    else
      qInsert.setNull(OID_VAL_78,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu79()!=null) 
      qInsert.setInt(OID_VAL_79,pers.getValor_compo_presu79().getOID());
    else
      qInsert.setNull(OID_VAL_79,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu80()!=null) 
      qInsert.setInt(OID_VAL_80,pers.getValor_compo_presu80().getOID());
    else
      qInsert.setNull(OID_VAL_80,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu81()!=null) 
      qInsert.setInt(OID_VAL_81,pers.getValor_compo_presu81().getOID());
    else
      qInsert.setNull(OID_VAL_81,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu82()!=null) 
      qInsert.setInt(OID_VAL_82,pers.getValor_compo_presu82().getOID());
    else
      qInsert.setNull(OID_VAL_82,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu83()!=null) 
      qInsert.setInt(OID_VAL_83,pers.getValor_compo_presu83().getOID());
    else
      qInsert.setNull(OID_VAL_83,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu84()!=null) 
      qInsert.setInt(OID_VAL_84,pers.getValor_compo_presu84().getOID());
    else
      qInsert.setNull(OID_VAL_84,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu85()!=null) 
      qInsert.setInt(OID_VAL_85,pers.getValor_compo_presu85().getOID());
    else
      qInsert.setNull(OID_VAL_85,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu86()!=null) 
      qInsert.setInt(OID_VAL_86,pers.getValor_compo_presu86().getOID());
    else
      qInsert.setNull(OID_VAL_86,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu87()!=null) 
      qInsert.setInt(OID_VAL_87,pers.getValor_compo_presu87().getOID());
    else
      qInsert.setNull(OID_VAL_87,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu88()!=null) 
      qInsert.setInt(OID_VAL_88,pers.getValor_compo_presu88().getOID());
    else
      qInsert.setNull(OID_VAL_88,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu89()!=null) 
      qInsert.setInt(OID_VAL_89,pers.getValor_compo_presu89().getOID());
    else
      qInsert.setNull(OID_VAL_89,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu90()!=null) 
      qInsert.setInt(OID_VAL_90,pers.getValor_compo_presu90().getOID());
    else
      qInsert.setNull(OID_VAL_90,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu91()!=null) 
      qInsert.setInt(OID_VAL_91,pers.getValor_compo_presu91().getOID());
    else
      qInsert.setNull(OID_VAL_91,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu92()!=null) 
      qInsert.setInt(OID_VAL_92,pers.getValor_compo_presu92().getOID());
    else
      qInsert.setNull(OID_VAL_92,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu93()!=null) 
      qInsert.setInt(OID_VAL_93,pers.getValor_compo_presu93().getOID());
    else
      qInsert.setNull(OID_VAL_93,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu94()!=null) 
      qInsert.setInt(OID_VAL_94,pers.getValor_compo_presu94().getOID());
    else
      qInsert.setNull(OID_VAL_94,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu95()!=null) 
      qInsert.setInt(OID_VAL_95,pers.getValor_compo_presu95().getOID());
    else
      qInsert.setNull(OID_VAL_95,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu96()!=null) 
      qInsert.setInt(OID_VAL_96,pers.getValor_compo_presu96().getOID());
    else
      qInsert.setNull(OID_VAL_96,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu97()!=null) 
      qInsert.setInt(OID_VAL_97,pers.getValor_compo_presu97().getOID());
    else
      qInsert.setNull(OID_VAL_97,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu98()!=null) 
      qInsert.setInt(OID_VAL_98,pers.getValor_compo_presu98().getOID());
    else
      qInsert.setNull(OID_VAL_98,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu99()!=null) 
      qInsert.setInt(OID_VAL_99,pers.getValor_compo_presu99().getOID());
    else
      qInsert.setNull(OID_VAL_99,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu100()!=null) 
      qInsert.setInt(OID_VAL_100,pers.getValor_compo_presu100().getOID());
    else
      qInsert.setNull(OID_VAL_100,java.sql.Types.INTEGER);
    
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
    
    if (pers.getPeriodo1()!=null) 
      qInsert.setInt(OID_PERI_1,pers.getPeriodo1().getOID());
    else
      qInsert.setNull(OID_PERI_1,java.sql.Types.INTEGER);
    if (pers.getPeriodo2()!=null) 
      qInsert.setInt(OID_PERI_2,pers.getPeriodo2().getOID());
    else
      qInsert.setNull(OID_PERI_2,java.sql.Types.INTEGER);
    if (pers.getPeriodo3()!=null) 
      qInsert.setInt(OID_PERI_3,pers.getPeriodo3().getOID());
    else
      qInsert.setNull(OID_PERI_3,java.sql.Types.INTEGER);
    if (pers.getPeriodo4()!=null) 
      qInsert.setInt(OID_PERI_4,pers.getPeriodo4().getOID());
    else
      qInsert.setNull(OID_PERI_4,java.sql.Types.INTEGER);
    if (pers.getPeriodo5()!=null) 
      qInsert.setInt(OID_PERI_5,pers.getPeriodo5().getOID());
    else
      qInsert.setNull(OID_PERI_5,java.sql.Types.INTEGER);
    if (pers.getPeriodo6()!=null) 
      qInsert.setInt(OID_PERI_6,pers.getPeriodo6().getOID());
    else
      qInsert.setNull(OID_PERI_6,java.sql.Types.INTEGER);
    if (pers.getPeriodo7()!=null) 
      qInsert.setInt(OID_PERI_7,pers.getPeriodo7().getOID());
    else
      qInsert.setNull(OID_PERI_7,java.sql.Types.INTEGER);
    if (pers.getPeriodo8()!=null) 
      qInsert.setInt(OID_PERI_8,pers.getPeriodo8().getOID());
    else
      qInsert.setNull(OID_PERI_8,java.sql.Types.INTEGER);
    if (pers.getPeriodo9()!=null) 
      qInsert.setInt(OID_PERI_9,pers.getPeriodo9().getOID());
    else
      qInsert.setNull(OID_PERI_9,java.sql.Types.INTEGER);
    if (pers.getPeriodo10()!=null) 
      qInsert.setInt(OID_PERI_10,pers.getPeriodo10().getOID());
    else
      qInsert.setNull(OID_PERI_10,java.sql.Types.INTEGER);
    if (pers.getPeriodo11()!=null) 
      qInsert.setInt(OID_PERI_11,pers.getPeriodo11().getOID());
    else
      qInsert.setNull(OID_PERI_11,java.sql.Types.INTEGER);
    if (pers.getPeriodo12()!=null) 
      qInsert.setInt(OID_PERI_12,pers.getPeriodo12().getOID());
    else
      qInsert.setNull(OID_PERI_12,java.sql.Types.INTEGER);
    if (pers.getPeriodo13()!=null) 
      qInsert.setInt(OID_PERI_13,pers.getPeriodo13().getOID());
    else
      qInsert.setNull(OID_PERI_13,java.sql.Types.INTEGER);
    if (pers.getPeriodo14()!=null) 
      qInsert.setInt(OID_PERI_14,pers.getPeriodo14().getOID());
    else
      qInsert.setNull(OID_PERI_14,java.sql.Types.INTEGER);
    if (pers.getPeriodo15()!=null) 
      qInsert.setInt(OID_PERI_15,pers.getPeriodo15().getOID());
    else
      qInsert.setNull(OID_PERI_15,java.sql.Types.INTEGER);
    if (pers.getPeriodo16()!=null) 
      qInsert.setInt(OID_PERI_16,pers.getPeriodo16().getOID());
    else
      qInsert.setNull(OID_PERI_16,java.sql.Types.INTEGER);
    if (pers.getPeriodo17()!=null) 
      qInsert.setInt(OID_PERI_17,pers.getPeriodo17().getOID());
    else
      qInsert.setNull(OID_PERI_17,java.sql.Types.INTEGER);
    if (pers.getPeriodo18()!=null) 
      qInsert.setInt(OID_PERI_18,pers.getPeriodo18().getOID());
    else
      qInsert.setNull(OID_PERI_18,java.sql.Types.INTEGER);
    if (pers.getPeriodo19()!=null) 
      qInsert.setInt(OID_PERI_19,pers.getPeriodo19().getOID());
    else
      qInsert.setNull(OID_PERI_19,java.sql.Types.INTEGER);
    if (pers.getPeriodo20()!=null) 
      qInsert.setInt(OID_PERI_20,pers.getPeriodo20().getOID());
    else
      qInsert.setNull(OID_PERI_20,java.sql.Types.INTEGER);
    
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getValorRealRepositorio()!=null) 
      qInsert.setInt(OID_VAL_REPO_REAL,pers.getValorRealRepositorio().getOID());
    else
      qInsert.setNull(OID_VAL_REPO_REAL,java.sql.Types.INTEGER);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REPO_REAL = 1;
    final int OID_VAL_1 = 2;
    final int OID_VAL_2 = 3;
    final int OID_VAL_3 = 4;
    final int OID_VAL_4 = 5;
    final int OID_VAL_5 = 6;
    final int OID_VAL_6 = 7;
    final int OID_VAL_7 = 8;
    final int OID_VAL_8 = 9;
    final int OID_VAL_9 = 10;
    final int OID_VAL_10 = 11;
    final int OID_VAL_11 = 12;
    final int OID_VAL_12 = 13;
    final int OID_VAL_13 = 14;
    final int OID_VAL_14 = 15;
    final int OID_VAL_15 = 16;
    final int OID_VAL_16 = 17;
    final int OID_VAL_17 = 18;
    final int OID_VAL_18 = 19;
    final int OID_VAL_19 = 20;
    final int OID_VAL_20 = 21;
    final int OID_VAL_21 = 22;
    final int OID_VAL_22 = 23;
    final int OID_VAL_23 = 24;
    final int OID_VAL_24 = 25;
    final int OID_VAL_25 = 26;
    final int OID_VAL_26 = 27;
    final int OID_VAL_27 = 28;
    final int OID_VAL_28 = 29;
    final int OID_VAL_29 = 30;
    final int OID_VAL_30 = 31;
    final int OID_VAL_31 = 32;
    final int OID_VAL_32 = 33;
    final int OID_VAL_33 = 34;
    final int OID_VAL_34 = 35;
    final int OID_VAL_35 = 36;
    final int OID_VAL_36 = 37;
    final int OID_VAL_37 = 38;
    final int OID_VAL_38 = 39;
    final int OID_VAL_39 = 40;
    final int OID_VAL_40 = 41;
    final int OID_VAL_41 = 42;
    final int OID_VAL_42 = 43;
    final int OID_VAL_43 = 44;
    final int OID_VAL_44 = 45;
    final int OID_VAL_45 = 46;
    final int OID_VAL_46 = 47;
    final int OID_VAL_47 = 48;
    final int OID_VAL_48 = 49;
    final int OID_VAL_49 = 50;
    final int OID_VAL_50 = 51;
    final int OID_VAL_51 = 52;
    final int OID_VAL_52 = 53;
    final int OID_VAL_53 = 54;
    final int OID_VAL_54 = 55;
    final int OID_VAL_55 = 56;
    final int OID_VAL_56 = 57;
    final int OID_VAL_57 = 58;
    final int OID_VAL_58 = 59;
    final int OID_VAL_59 = 60;
    final int OID_VAL_60 = 61;
    final int OID_VAL_61 = 62;
    final int OID_VAL_62 = 63;
    final int OID_VAL_63 = 64;
    final int OID_VAL_64 = 65;
    final int OID_VAL_65 = 66;
    final int OID_VAL_66 = 67;
    final int OID_VAL_67 = 68;
    final int OID_VAL_68 = 69;
    final int OID_VAL_69 = 70;
    final int OID_VAL_70 = 71;
    final int OID_VAL_71 = 72;
    final int OID_VAL_72 = 73;
    final int OID_VAL_73 = 74;
    final int OID_VAL_74 = 75;
    final int OID_VAL_75 = 76;
    final int OID_VAL_76 = 77;
    final int OID_VAL_77 = 78;
    final int OID_VAL_78 = 79;
    final int OID_VAL_79 = 80;
    final int OID_VAL_80 = 81;
    final int OID_VAL_81 = 82;
    final int OID_VAL_82 = 83;
    final int OID_VAL_83 = 84;
    final int OID_VAL_84 = 85;
    final int OID_VAL_85 = 86;
    final int OID_VAL_86 = 87;
    final int OID_VAL_87 = 88;
    final int OID_VAL_88 = 89;
    final int OID_VAL_89 = 90;
    final int OID_VAL_90 = 91;
    final int OID_VAL_91 = 92;
    final int OID_VAL_92 = 93;
    final int OID_VAL_93 = 94;
    final int OID_VAL_94 = 95;
    final int OID_VAL_95 = 96;
    final int OID_VAL_96 = 97;
    final int OID_VAL_97 = 98;
    final int OID_VAL_98 = 99;
    final int OID_VAL_99 = 100;
    final int OID_VAL_100 = 101;
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
    final int OID_PERI_1 = 152;
    final int OID_PERI_2 = 153;
    final int OID_PERI_3 = 154;
    final int OID_PERI_4 = 155;
    final int OID_PERI_5 = 156;
    final int OID_PERI_6 = 157;
    final int OID_PERI_7 = 158;
    final int OID_PERI_8 = 159;
    final int OID_PERI_9 = 160;
    final int OID_PERI_10 = 161;
    final int OID_PERI_11 = 162;
    final int OID_PERI_12 = 163;
    final int OID_PERI_13 = 164;
    final int OID_PERI_14 = 165;
    final int OID_PERI_15 = 166;
    final int OID_PERI_16 = 167;
    final int OID_PERI_17 = 168;
    final int OID_PERI_18 = 169;
    final int OID_PERI_19 = 170;
    final int OID_PERI_20 = 171;
    final int ACTIVO = 172;
    final int OID_VAL_REAL_REPO = 173;
    final int OID_EQUIV = 174;

    ValorEquivalenciaRepositorio pers = (ValorEquivalenciaRepositorio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plValEquivRepoReal set "+
              "oid_repo_real=?"+ 
              ",oid_val_1=?"+ 
              ",oid_val_2=?"+ 
              ",oid_val_3=?"+ 
              ",oid_val_4=?"+ 
              ",oid_val_5=?"+ 
              ",oid_val_6=?"+ 
              ",oid_val_7=?"+ 
              ",oid_val_8=?"+ 
              ",oid_val_9=?"+ 
              ",oid_val_10=?"+ 
              ",oid_val_11=?"+ 
              ",oid_val_12=?"+ 
              ",oid_val_13=?"+ 
              ",oid_val_14=?"+ 
              ",oid_val_15=?"+ 
              ",oid_val_16=?"+ 
              ",oid_val_17=?"+ 
              ",oid_val_18=?"+ 
              ",oid_val_19=?"+ 
              ",oid_val_20=?"+ 
              ",oid_val_21=?"+ 
              ",oid_val_22=?"+ 
              ",oid_val_23=?"+ 
              ",oid_val_24=?"+ 
              ",oid_val_25=?"+ 
              ",oid_val_26=?"+ 
              ",oid_val_27=?"+ 
              ",oid_val_28=?"+ 
              ",oid_val_29=?"+ 
              ",oid_val_30=?"+ 
              ",oid_val_31=?"+ 
              ",oid_val_32=?"+ 
              ",oid_val_33=?"+ 
              ",oid_val_34=?"+ 
              ",oid_val_35=?"+ 
              ",oid_val_36=?"+ 
              ",oid_val_37=?"+ 
              ",oid_val_38=?"+ 
              ",oid_val_39=?"+ 
              ",oid_val_40=?"+ 
              ",oid_val_41=?"+ 
              ",oid_val_42=?"+ 
              ",oid_val_43=?"+ 
              ",oid_val_44=?"+ 
              ",oid_val_45=?"+ 
              ",oid_val_46=?"+ 
              ",oid_val_47=?"+ 
              ",oid_val_48=?"+ 
              ",oid_val_49=?"+ 
              ",oid_val_50=?"+ 
              ",oid_val_51=?"+ 
              ",oid_val_52=?"+ 
              ",oid_val_53=?"+ 
              ",oid_val_54=?"+ 
              ",oid_val_55=?"+ 
              ",oid_val_56=?"+ 
              ",oid_val_57=?"+ 
              ",oid_val_58=?"+ 
              ",oid_val_59=?"+ 
              ",oid_val_60=?"+ 
              ",oid_val_61=?"+ 
              ",oid_val_62=?"+ 
              ",oid_val_63=?"+ 
              ",oid_val_64=?"+ 
              ",oid_val_65=?"+ 
              ",oid_val_66=?"+ 
              ",oid_val_67=?"+ 
              ",oid_val_68=?"+ 
              ",oid_val_69=?"+ 
              ",oid_val_70=?"+ 
              ",oid_val_71=?"+ 
              ",oid_val_72=?"+ 
              ",oid_val_73=?"+ 
              ",oid_val_74=?"+ 
              ",oid_val_75=?"+ 
              ",oid_val_76=?"+ 
              ",oid_val_77=?"+ 
              ",oid_val_78=?"+ 
              ",oid_val_79=?"+ 
              ",oid_val_80=?"+ 
              ",oid_val_81=?"+ 
              ",oid_val_82=?"+ 
              ",oid_val_83=?"+ 
              ",oid_val_84=?"+ 
              ",oid_val_85=?"+ 
              ",oid_val_86=?"+ 
              ",oid_val_87=?"+ 
              ",oid_val_88=?"+ 
              ",oid_val_89=?"+ 
              ",oid_val_90=?"+ 
              ",oid_val_91=?"+ 
              ",oid_val_92=?"+ 
              ",oid_val_93=?"+ 
              ",oid_val_94=?"+ 
              ",oid_val_95=?"+ 
              ",oid_val_96=?"+ 
              ",oid_val_97=?"+ 
              ",oid_val_98=?"+ 
              ",oid_val_99=?"+ 
              ",oid_val_100=?"+ 
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
              ",oid_peri_1=?"+ 
              ",oid_peri_2=?"+ 
              ",oid_peri_3=?"+ 
              ",oid_peri_4=?"+ 
              ",oid_peri_5=?"+ 
              ",oid_peri_6=?"+ 
              ",oid_peri_7=?"+ 
              ",oid_peri_8=?"+ 
              ",oid_peri_9=?"+ 
              ",oid_peri_10=?"+ 
              ",oid_peri_11=?"+ 
              ",oid_peri_12=?"+ 
              ",oid_peri_13=?"+ 
              ",oid_peri_14=?"+ 
              ",oid_peri_15=?"+ 
              ",oid_peri_16=?"+ 
              ",oid_peri_17=?"+ 
              ",oid_peri_18=?"+ 
              ",oid_peri_19=?"+ 
              ",oid_peri_20=?"+ 
              ",oid_val_repo_real=?"+
              ",activo=?"+ 
                 " where " +
                 " oid_equiv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV,pers.getOID());
    qUpdate.setInt(OID_REPO_REAL,pers.getRepositorio_real().getOID());
    if (pers.getValor_compo_presu1()!=null) 
      qUpdate.setInt(OID_VAL_1,pers.getValor_compo_presu1().getOID());
    else
      qUpdate.setNull(OID_VAL_1,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu2()!=null) 
      qUpdate.setInt(OID_VAL_2,pers.getValor_compo_presu2().getOID());
    else
      qUpdate.setNull(OID_VAL_2,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu3()!=null) 
      qUpdate.setInt(OID_VAL_3,pers.getValor_compo_presu3().getOID());
    else
      qUpdate.setNull(OID_VAL_3,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu4()!=null) 
      qUpdate.setInt(OID_VAL_4,pers.getValor_compo_presu4().getOID());
    else
      qUpdate.setNull(OID_VAL_4,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu5()!=null) 
      qUpdate.setInt(OID_VAL_5,pers.getValor_compo_presu5().getOID());
    else
      qUpdate.setNull(OID_VAL_5,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu6()!=null) 
      qUpdate.setInt(OID_VAL_6,pers.getValor_compo_presu6().getOID());
    else
      qUpdate.setNull(OID_VAL_6,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu7()!=null) 
      qUpdate.setInt(OID_VAL_7,pers.getValor_compo_presu7().getOID());
    else
      qUpdate.setNull(OID_VAL_7,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu8()!=null) 
      qUpdate.setInt(OID_VAL_8,pers.getValor_compo_presu8().getOID());
    else
      qUpdate.setNull(OID_VAL_8,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu9()!=null) 
      qUpdate.setInt(OID_VAL_9,pers.getValor_compo_presu9().getOID());
    else
      qUpdate.setNull(OID_VAL_9,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu10()!=null) 
      qUpdate.setInt(OID_VAL_10,pers.getValor_compo_presu10().getOID());
    else
      qUpdate.setNull(OID_VAL_10,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu11()!=null) 
      qUpdate.setInt(OID_VAL_11,pers.getValor_compo_presu11().getOID());
    else
      qUpdate.setNull(OID_VAL_11,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu12()!=null) 
      qUpdate.setInt(OID_VAL_12,pers.getValor_compo_presu12().getOID());
    else
      qUpdate.setNull(OID_VAL_12,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu13()!=null) 
      qUpdate.setInt(OID_VAL_13,pers.getValor_compo_presu13().getOID());
    else
      qUpdate.setNull(OID_VAL_13,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu14()!=null) 
      qUpdate.setInt(OID_VAL_14,pers.getValor_compo_presu14().getOID());
    else
      qUpdate.setNull(OID_VAL_14,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu15()!=null) 
      qUpdate.setInt(OID_VAL_15,pers.getValor_compo_presu15().getOID());
    else
      qUpdate.setNull(OID_VAL_15,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu16()!=null) 
      qUpdate.setInt(OID_VAL_16,pers.getValor_compo_presu16().getOID());
    else
      qUpdate.setNull(OID_VAL_16,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu17()!=null) 
      qUpdate.setInt(OID_VAL_17,pers.getValor_compo_presu17().getOID());
    else
      qUpdate.setNull(OID_VAL_17,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu18()!=null) 
      qUpdate.setInt(OID_VAL_18,pers.getValor_compo_presu18().getOID());
    else
      qUpdate.setNull(OID_VAL_18,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu19()!=null) 
      qUpdate.setInt(OID_VAL_19,pers.getValor_compo_presu19().getOID());
    else
      qUpdate.setNull(OID_VAL_19,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu20()!=null) 
      qUpdate.setInt(OID_VAL_20,pers.getValor_compo_presu20().getOID());
    else
      qUpdate.setNull(OID_VAL_20,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu21()!=null) 
      qUpdate.setInt(OID_VAL_21,pers.getValor_compo_presu21().getOID());
    else
      qUpdate.setNull(OID_VAL_21,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu22()!=null) 
      qUpdate.setInt(OID_VAL_22,pers.getValor_compo_presu22().getOID());
    else
      qUpdate.setNull(OID_VAL_22,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu23()!=null) 
      qUpdate.setInt(OID_VAL_23,pers.getValor_compo_presu23().getOID());
    else
      qUpdate.setNull(OID_VAL_23,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu24()!=null) 
      qUpdate.setInt(OID_VAL_24,pers.getValor_compo_presu24().getOID());
    else
      qUpdate.setNull(OID_VAL_24,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu25()!=null) 
      qUpdate.setInt(OID_VAL_25,pers.getValor_compo_presu25().getOID());
    else
      qUpdate.setNull(OID_VAL_25,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu26()!=null) 
      qUpdate.setInt(OID_VAL_26,pers.getValor_compo_presu26().getOID());
    else
      qUpdate.setNull(OID_VAL_26,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu27()!=null) 
      qUpdate.setInt(OID_VAL_27,pers.getValor_compo_presu27().getOID());
    else
      qUpdate.setNull(OID_VAL_27,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu28()!=null) 
      qUpdate.setInt(OID_VAL_28,pers.getValor_compo_presu28().getOID());
    else
      qUpdate.setNull(OID_VAL_28,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu29()!=null) 
      qUpdate.setInt(OID_VAL_29,pers.getValor_compo_presu29().getOID());
    else
      qUpdate.setNull(OID_VAL_29,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu30()!=null) 
      qUpdate.setInt(OID_VAL_30,pers.getValor_compo_presu30().getOID());
    else
      qUpdate.setNull(OID_VAL_30,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu31()!=null) 
      qUpdate.setInt(OID_VAL_31,pers.getValor_compo_presu31().getOID());
    else
      qUpdate.setNull(OID_VAL_31,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu32()!=null) 
      qUpdate.setInt(OID_VAL_32,pers.getValor_compo_presu32().getOID());
    else
      qUpdate.setNull(OID_VAL_32,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu33()!=null) 
      qUpdate.setInt(OID_VAL_33,pers.getValor_compo_presu33().getOID());
    else
      qUpdate.setNull(OID_VAL_33,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu34()!=null) 
      qUpdate.setInt(OID_VAL_34,pers.getValor_compo_presu34().getOID());
    else
      qUpdate.setNull(OID_VAL_34,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu35()!=null) 
      qUpdate.setInt(OID_VAL_35,pers.getValor_compo_presu35().getOID());
    else
      qUpdate.setNull(OID_VAL_35,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu36()!=null) 
      qUpdate.setInt(OID_VAL_36,pers.getValor_compo_presu36().getOID());
    else
      qUpdate.setNull(OID_VAL_36,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu37()!=null) 
      qUpdate.setInt(OID_VAL_37,pers.getValor_compo_presu37().getOID());
    else
      qUpdate.setNull(OID_VAL_37,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu38()!=null) 
      qUpdate.setInt(OID_VAL_38,pers.getValor_compo_presu38().getOID());
    else
      qUpdate.setNull(OID_VAL_38,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu39()!=null) 
      qUpdate.setInt(OID_VAL_39,pers.getValor_compo_presu39().getOID());
    else
      qUpdate.setNull(OID_VAL_39,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu40()!=null) 
      qUpdate.setInt(OID_VAL_40,pers.getValor_compo_presu40().getOID());
    else
      qUpdate.setNull(OID_VAL_40,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu41()!=null) 
      qUpdate.setInt(OID_VAL_41,pers.getValor_compo_presu41().getOID());
    else
      qUpdate.setNull(OID_VAL_41,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu42()!=null) 
      qUpdate.setInt(OID_VAL_42,pers.getValor_compo_presu42().getOID());
    else
      qUpdate.setNull(OID_VAL_42,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu43()!=null) 
      qUpdate.setInt(OID_VAL_43,pers.getValor_compo_presu43().getOID());
    else
      qUpdate.setNull(OID_VAL_43,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu44()!=null) 
      qUpdate.setInt(OID_VAL_44,pers.getValor_compo_presu44().getOID());
    else
      qUpdate.setNull(OID_VAL_44,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu45()!=null) 
      qUpdate.setInt(OID_VAL_45,pers.getValor_compo_presu45().getOID());
    else
      qUpdate.setNull(OID_VAL_45,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu46()!=null) 
      qUpdate.setInt(OID_VAL_46,pers.getValor_compo_presu46().getOID());
    else
      qUpdate.setNull(OID_VAL_46,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu47()!=null) 
      qUpdate.setInt(OID_VAL_47,pers.getValor_compo_presu47().getOID());
    else
      qUpdate.setNull(OID_VAL_47,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu48()!=null) 
      qUpdate.setInt(OID_VAL_48,pers.getValor_compo_presu48().getOID());
    else
      qUpdate.setNull(OID_VAL_48,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu49()!=null) 
      qUpdate.setInt(OID_VAL_49,pers.getValor_compo_presu49().getOID());
    else
      qUpdate.setNull(OID_VAL_49,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu50()!=null) 
      qUpdate.setInt(OID_VAL_50,pers.getValor_compo_presu50().getOID());
    else
      qUpdate.setNull(OID_VAL_50,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu51()!=null) 
      qUpdate.setInt(OID_VAL_51,pers.getValor_compo_presu51().getOID());
    else
      qUpdate.setNull(OID_VAL_51,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu52()!=null) 
      qUpdate.setInt(OID_VAL_52,pers.getValor_compo_presu52().getOID());
    else
      qUpdate.setNull(OID_VAL_52,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu53()!=null) 
      qUpdate.setInt(OID_VAL_53,pers.getValor_compo_presu53().getOID());
    else
      qUpdate.setNull(OID_VAL_53,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu54()!=null) 
      qUpdate.setInt(OID_VAL_54,pers.getValor_compo_presu54().getOID());
    else
      qUpdate.setNull(OID_VAL_54,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu55()!=null) 
      qUpdate.setInt(OID_VAL_55,pers.getValor_compo_presu55().getOID());
    else
      qUpdate.setNull(OID_VAL_55,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu56()!=null) 
      qUpdate.setInt(OID_VAL_56,pers.getValor_compo_presu56().getOID());
    else
      qUpdate.setNull(OID_VAL_56,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu57()!=null) 
      qUpdate.setInt(OID_VAL_57,pers.getValor_compo_presu57().getOID());
    else
      qUpdate.setNull(OID_VAL_57,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu58()!=null) 
      qUpdate.setInt(OID_VAL_58,pers.getValor_compo_presu58().getOID());
    else
      qUpdate.setNull(OID_VAL_58,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu59()!=null) 
      qUpdate.setInt(OID_VAL_59,pers.getValor_compo_presu59().getOID());
    else
      qUpdate.setNull(OID_VAL_59,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu60()!=null) 
      qUpdate.setInt(OID_VAL_60,pers.getValor_compo_presu60().getOID());
    else
      qUpdate.setNull(OID_VAL_60,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu61()!=null) 
      qUpdate.setInt(OID_VAL_61,pers.getValor_compo_presu61().getOID());
    else
      qUpdate.setNull(OID_VAL_61,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu62()!=null) 
      qUpdate.setInt(OID_VAL_62,pers.getValor_compo_presu62().getOID());
    else
      qUpdate.setNull(OID_VAL_62,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu63()!=null) 
      qUpdate.setInt(OID_VAL_63,pers.getValor_compo_presu63().getOID());
    else
      qUpdate.setNull(OID_VAL_63,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu64()!=null) 
      qUpdate.setInt(OID_VAL_64,pers.getValor_compo_presu64().getOID());
    else
      qUpdate.setNull(OID_VAL_64,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu65()!=null) 
      qUpdate.setInt(OID_VAL_65,pers.getValor_compo_presu65().getOID());
    else
      qUpdate.setNull(OID_VAL_65,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu66()!=null) 
      qUpdate.setInt(OID_VAL_66,pers.getValor_compo_presu66().getOID());
    else
      qUpdate.setNull(OID_VAL_66,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu67()!=null) 
      qUpdate.setInt(OID_VAL_67,pers.getValor_compo_presu67().getOID());
    else
      qUpdate.setNull(OID_VAL_67,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu68()!=null) 
      qUpdate.setInt(OID_VAL_68,pers.getValor_compo_presu68().getOID());
    else
      qUpdate.setNull(OID_VAL_68,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu69()!=null) 
      qUpdate.setInt(OID_VAL_69,pers.getValor_compo_presu69().getOID());
    else
      qUpdate.setNull(OID_VAL_69,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu70()!=null) 
      qUpdate.setInt(OID_VAL_70,pers.getValor_compo_presu70().getOID());
    else
      qUpdate.setNull(OID_VAL_70,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu71()!=null) 
      qUpdate.setInt(OID_VAL_71,pers.getValor_compo_presu71().getOID());
    else
      qUpdate.setNull(OID_VAL_71,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu72()!=null) 
      qUpdate.setInt(OID_VAL_72,pers.getValor_compo_presu72().getOID());
    else
      qUpdate.setNull(OID_VAL_72,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu73()!=null) 
      qUpdate.setInt(OID_VAL_73,pers.getValor_compo_presu73().getOID());
    else
      qUpdate.setNull(OID_VAL_73,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu74()!=null) 
      qUpdate.setInt(OID_VAL_74,pers.getValor_compo_presu74().getOID());
    else
      qUpdate.setNull(OID_VAL_74,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu75()!=null) 
      qUpdate.setInt(OID_VAL_75,pers.getValor_compo_presu75().getOID());
    else
      qUpdate.setNull(OID_VAL_75,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu76()!=null) 
      qUpdate.setInt(OID_VAL_76,pers.getValor_compo_presu76().getOID());
    else
      qUpdate.setNull(OID_VAL_76,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu77()!=null) 
      qUpdate.setInt(OID_VAL_77,pers.getValor_compo_presu77().getOID());
    else
      qUpdate.setNull(OID_VAL_77,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu78()!=null) 
      qUpdate.setInt(OID_VAL_78,pers.getValor_compo_presu78().getOID());
    else
      qUpdate.setNull(OID_VAL_78,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu79()!=null) 
      qUpdate.setInt(OID_VAL_79,pers.getValor_compo_presu79().getOID());
    else
      qUpdate.setNull(OID_VAL_79,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu80()!=null) 
      qUpdate.setInt(OID_VAL_80,pers.getValor_compo_presu80().getOID());
    else
      qUpdate.setNull(OID_VAL_80,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu81()!=null) 
      qUpdate.setInt(OID_VAL_81,pers.getValor_compo_presu81().getOID());
    else
      qUpdate.setNull(OID_VAL_81,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu82()!=null) 
      qUpdate.setInt(OID_VAL_82,pers.getValor_compo_presu82().getOID());
    else
      qUpdate.setNull(OID_VAL_82,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu83()!=null) 
      qUpdate.setInt(OID_VAL_83,pers.getValor_compo_presu83().getOID());
    else
      qUpdate.setNull(OID_VAL_83,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu84()!=null) 
      qUpdate.setInt(OID_VAL_84,pers.getValor_compo_presu84().getOID());
    else
      qUpdate.setNull(OID_VAL_84,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu85()!=null) 
      qUpdate.setInt(OID_VAL_85,pers.getValor_compo_presu85().getOID());
    else
      qUpdate.setNull(OID_VAL_85,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu86()!=null) 
      qUpdate.setInt(OID_VAL_86,pers.getValor_compo_presu86().getOID());
    else
      qUpdate.setNull(OID_VAL_86,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu87()!=null) 
      qUpdate.setInt(OID_VAL_87,pers.getValor_compo_presu87().getOID());
    else
      qUpdate.setNull(OID_VAL_87,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu88()!=null) 
      qUpdate.setInt(OID_VAL_88,pers.getValor_compo_presu88().getOID());
    else
      qUpdate.setNull(OID_VAL_88,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu89()!=null) 
      qUpdate.setInt(OID_VAL_89,pers.getValor_compo_presu89().getOID());
    else
      qUpdate.setNull(OID_VAL_89,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu90()!=null) 
      qUpdate.setInt(OID_VAL_90,pers.getValor_compo_presu90().getOID());
    else
      qUpdate.setNull(OID_VAL_90,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu91()!=null) 
      qUpdate.setInt(OID_VAL_91,pers.getValor_compo_presu91().getOID());
    else
      qUpdate.setNull(OID_VAL_91,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu92()!=null) 
      qUpdate.setInt(OID_VAL_92,pers.getValor_compo_presu92().getOID());
    else
      qUpdate.setNull(OID_VAL_92,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu93()!=null) 
      qUpdate.setInt(OID_VAL_93,pers.getValor_compo_presu93().getOID());
    else
      qUpdate.setNull(OID_VAL_93,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu94()!=null) 
      qUpdate.setInt(OID_VAL_94,pers.getValor_compo_presu94().getOID());
    else
      qUpdate.setNull(OID_VAL_94,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu95()!=null) 
      qUpdate.setInt(OID_VAL_95,pers.getValor_compo_presu95().getOID());
    else
      qUpdate.setNull(OID_VAL_95,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu96()!=null) 
      qUpdate.setInt(OID_VAL_96,pers.getValor_compo_presu96().getOID());
    else
      qUpdate.setNull(OID_VAL_96,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu97()!=null) 
      qUpdate.setInt(OID_VAL_97,pers.getValor_compo_presu97().getOID());
    else
      qUpdate.setNull(OID_VAL_97,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu98()!=null) 
      qUpdate.setInt(OID_VAL_98,pers.getValor_compo_presu98().getOID());
    else
      qUpdate.setNull(OID_VAL_98,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu99()!=null) 
      qUpdate.setInt(OID_VAL_99,pers.getValor_compo_presu99().getOID());
    else
      qUpdate.setNull(OID_VAL_99,java.sql.Types.INTEGER);
    if (pers.getValor_compo_presu100()!=null) 
      qUpdate.setInt(OID_VAL_100,pers.getValor_compo_presu100().getOID());
    else
      qUpdate.setNull(OID_VAL_100,java.sql.Types.INTEGER);
    
    
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
    
    
    if (pers.getPeriodo1()!=null) 
      qUpdate.setInt(OID_PERI_1,pers.getPeriodo1().getOID());
    else
      qUpdate.setNull(OID_PERI_1,java.sql.Types.INTEGER);
    if (pers.getPeriodo2()!=null) 
      qUpdate.setInt(OID_PERI_2,pers.getPeriodo2().getOID());
    else
      qUpdate.setNull(OID_PERI_2,java.sql.Types.INTEGER);
    if (pers.getPeriodo3()!=null) 
      qUpdate.setInt(OID_PERI_3,pers.getPeriodo3().getOID());
    else
      qUpdate.setNull(OID_PERI_3,java.sql.Types.INTEGER);
    if (pers.getPeriodo4()!=null) 
      qUpdate.setInt(OID_PERI_4,pers.getPeriodo4().getOID());
    else
      qUpdate.setNull(OID_PERI_4,java.sql.Types.INTEGER);
    if (pers.getPeriodo5()!=null) 
      qUpdate.setInt(OID_PERI_5,pers.getPeriodo5().getOID());
    else
      qUpdate.setNull(OID_PERI_5,java.sql.Types.INTEGER);
    if (pers.getPeriodo6()!=null) 
      qUpdate.setInt(OID_PERI_6,pers.getPeriodo6().getOID());
    else
      qUpdate.setNull(OID_PERI_6,java.sql.Types.INTEGER);
    if (pers.getPeriodo7()!=null) 
      qUpdate.setInt(OID_PERI_7,pers.getPeriodo7().getOID());
    else
      qUpdate.setNull(OID_PERI_7,java.sql.Types.INTEGER);
    if (pers.getPeriodo8()!=null) 
      qUpdate.setInt(OID_PERI_8,pers.getPeriodo8().getOID());
    else
      qUpdate.setNull(OID_PERI_8,java.sql.Types.INTEGER);
    if (pers.getPeriodo9()!=null) 
      qUpdate.setInt(OID_PERI_9,pers.getPeriodo9().getOID());
    else
      qUpdate.setNull(OID_PERI_9,java.sql.Types.INTEGER);
    if (pers.getPeriodo10()!=null) 
      qUpdate.setInt(OID_PERI_10,pers.getPeriodo10().getOID());
    else
      qUpdate.setNull(OID_PERI_10,java.sql.Types.INTEGER);
    if (pers.getPeriodo11()!=null) 
      qUpdate.setInt(OID_PERI_11,pers.getPeriodo11().getOID());
    else
      qUpdate.setNull(OID_PERI_11,java.sql.Types.INTEGER);
    if (pers.getPeriodo12()!=null) 
      qUpdate.setInt(OID_PERI_12,pers.getPeriodo12().getOID());
    else
      qUpdate.setNull(OID_PERI_12,java.sql.Types.INTEGER);
    if (pers.getPeriodo13()!=null) 
      qUpdate.setInt(OID_PERI_13,pers.getPeriodo13().getOID());
    else
      qUpdate.setNull(OID_PERI_13,java.sql.Types.INTEGER);
    if (pers.getPeriodo14()!=null) 
      qUpdate.setInt(OID_PERI_14,pers.getPeriodo14().getOID());
    else
      qUpdate.setNull(OID_PERI_14,java.sql.Types.INTEGER);
    if (pers.getPeriodo15()!=null) 
      qUpdate.setInt(OID_PERI_15,pers.getPeriodo15().getOID());
    else
      qUpdate.setNull(OID_PERI_15,java.sql.Types.INTEGER);
    if (pers.getPeriodo16()!=null) 
      qUpdate.setInt(OID_PERI_16,pers.getPeriodo16().getOID());
    else
      qUpdate.setNull(OID_PERI_16,java.sql.Types.INTEGER);
    if (pers.getPeriodo17()!=null) 
      qUpdate.setInt(OID_PERI_17,pers.getPeriodo17().getOID());
    else
      qUpdate.setNull(OID_PERI_17,java.sql.Types.INTEGER);
    if (pers.getPeriodo18()!=null) 
      qUpdate.setInt(OID_PERI_18,pers.getPeriodo18().getOID());
    else
      qUpdate.setNull(OID_PERI_18,java.sql.Types.INTEGER);
    if (pers.getPeriodo19()!=null) 
      qUpdate.setInt(OID_PERI_19,pers.getPeriodo19().getOID());
    else
      qUpdate.setNull(OID_PERI_19,java.sql.Types.INTEGER);
    if (pers.getPeriodo20()!=null) 
      qUpdate.setInt(OID_PERI_20,pers.getPeriodo20().getOID());
    else
      qUpdate.setNull(OID_PERI_20,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getValorRealRepositorio()!=null) 
    	qUpdate.setInt(OID_VAL_REAL_REPO,pers.getValorRealRepositorio().getOID());
    else
    	qUpdate.setNull(OID_VAL_REAL_REPO,Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
    
  }
  

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EQUIV = 1; 
    ValorEquivalenciaRepositorio pers = (ValorEquivalenciaRepositorio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from plValEquivRepoReal "+
                     " where " + 
                     " oid_equiv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EQUIV = 1; 
    ValorEquivalenciaRepositorio pers = (ValorEquivalenciaRepositorio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValEquivRepoReal "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_equiv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV, pers.getOID()); 
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
      case SELECT_BY_VAL_REPO_REAL: {
        ps = this.selectByValRepoReal(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectByValRepoReal(Object aCondiciones) throws BaseException, SQLException { 

  	 ValorRealRepositorio valorRealRepositorio = (ValorRealRepositorio) aCondiciones;
  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  plValEquivRepoReal "); 
  	 textSQL.append(" WHERE oid_val_repo_real = ? "); 
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 querySelect.setInt(1, valorRealRepositorio.getOID()); 
  	 return querySelect; 
  }
  		

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EQUIV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValEquivRepoReal "); 
    textSQL.append(" WHERE oid_equiv = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EQUIV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValEquivRepoReal "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_equiv oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plValEquivRepoReal");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ValorEquivalenciaRepositorio getValorEquiRepo(ValorRealRepositorio valorRealRepositorio,
      ISesion aSesion)
      throws BaseException {
  	return (ValorEquivalenciaRepositorio) ObjetoLogico.getObjects(ValorEquivalenciaRepositorio.NICKNAME,
	  				DBValorEquivalenciaRepositorio.SELECT_BY_VAL_REPO_REAL,
	  				valorRealRepositorio,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
} 
