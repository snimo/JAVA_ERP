package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.bm.SubBienVidaUtil;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSubBienVidaUtil extends DBObjetoPersistente {

  public static final String OID_BIEN_VU = "oid_bien_vu";
  public static final String OID_BIEN_ALTA = "oid_bien_alta";
  public static final String OID_SIST_VAL = "oid_sist_val";
  public static final String VIDAL_UTIL = "vidal_util";
  public static final String MESES_AMORT = "meses_amort";
  public static final String OID_ULT_PERI_AMORT = "oid_ult_peri_amort";
  public static final String FEC_ULT_AMORT = "fec_ult_amort";
  public static final String TASA_ACU = "tasa_acu";
  public static final String TASA_ACU_EJER_ANT = "tasa_acu_ejer_ant";
  public static final String ANT_MESES_AMORT = "ant_meses_amort";
  public static final String ANT_OID_ULT_PERI_A = "ant_oid_ult_peri_a";
  public static final String ANT_TASA_ACU = "ant_tasa_acu";
  public static final String ANT_TASA_ACU_EJE_A = "ant_tasa_acu_eje_a";
  public static final String ULT_TASA_APLIC = "ult_tasa_aplic";
  public static final String TASA_ACUM_EJER_ACT = "tasa_acum_ejer_act"; 
  
  public static final int SELECT_BY_BIEN_ALTA = 100;
  public static final int SELECT_BY_SIST_VAL_SUBBIEN = 101;

  public DBSubBienVidaUtil() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_VU = 1;
    final int OID_BIEN_ALTA = 2;
    final int OID_SIST_VAL = 3;
    final int VIDAL_UTIL = 4;
    final int MESES_AMORT = 5;
    final int OID_ULT_PERI_AMORT = 6;
    final int FEC_ULT_AMORT = 7;
    final int TASA_ACU = 8;
    final int TASA_ACU_EJER_ANT = 9;
    final int ANT_MESES_AMORT = 10;
    final int ANT_OID_ULT_PERI_A = 11;
    final int ANT_TASA_ACU = 12;
    final int ANT_TASA_ACU_EJE_A = 13;
    final int ULT_TASA_APLIC = 14;
    final int TASA_ACUM_EJER_ACT = 15;

    SubBienVidaUtil pers = (SubBienVidaUtil) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buBienVU "+
                     " ( "+
                      "OID_BIEN_VU,"+
                      "OID_BIEN_ALTA,"+
                      "OID_SIST_VAL,"+
                      "VIDAL_UTIL,"+
                      "MESES_AMORT,"+
                      "OID_ULT_PERI_AMORT,"+
                      "FEC_ULT_AMORT,"+
                      "TASA_ACU,"+
                      "TASA_ACU_EJER_ANT,"+
                      "ANT_MESES_AMORT,"+
                      "ANT_OID_ULT_PERI_A,"+
                      "ANT_TASA_ACU,"+
                      "ANT_TASA_ACU_EJE_A,"+
                      "ULT_TASA_APLIC,"+
                      "TASA_ACUM_EJER_ACT)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_BIEN_VU,pers.getOID());
    qInsert.setInt(OID_BIEN_ALTA,pers.getSubbien().getOID());
    qInsert.setInt(OID_SIST_VAL,pers.getSistema_valuacion().getOID());
    qInsert.setInt(VIDAL_UTIL,pers.getVidal_util().intValue());
    qInsert.setInt(MESES_AMORT,pers.getMeses_amort().intValue());
    if (pers.getUlt_peri_amort()!=null)
      qInsert.setInt(OID_ULT_PERI_AMORT,pers.getUlt_peri_amort().getOID());
    else
      qInsert.setNull(OID_ULT_PERI_AMORT,Types.INTEGER);    	
    if (pers.getFec_ult_amort()!=null) 
      qInsert.setDate(FEC_ULT_AMORT,new java.sql.Date(pers.getFec_ult_amort().getTime()));
    else
      qInsert.setNull(FEC_ULT_AMORT,java.sql.Types.DATE);
    qInsert.setDouble(TASA_ACU,pers.getTasa_acu().doubleValue());
    qInsert.setDouble(TASA_ACU_EJER_ANT,pers.getTasa_acu_ejer_ant().doubleValue());
    qInsert.setInt(ANT_MESES_AMORT,pers.getAnt_meses_amort().intValue());
    if (pers.getAnt_ult_peri()!=null) 
      qInsert.setInt(ANT_OID_ULT_PERI_A,pers.getAnt_ult_peri().getOID());
    else
      qInsert.setNull(ANT_OID_ULT_PERI_A,java.sql.Types.INTEGER);
    qInsert.setDouble(ANT_TASA_ACU,pers.getAnt_tasa_acu().doubleValue());
    qInsert.setDouble(ANT_TASA_ACU_EJE_A,pers.getAnt_tasa_acu_eje_a().doubleValue());
    qInsert.setDouble(ULT_TASA_APLIC,pers.getUltTasaAplic().doubleValue());
    if (pers.getTasaAcuEjerActual()!=null)
    	qInsert.setDouble(TASA_ACUM_EJER_ACT,pers.getTasaAcuEjerActual().doubleValue());
    else
    	qInsert.setNull(TASA_ACUM_EJER_ACT,Types.DOUBLE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_ALTA = 1;
    final int OID_SIST_VAL = 2;
    final int VIDAL_UTIL = 3;
    final int MESES_AMORT = 4;
    final int OID_ULT_PERI_AMORT = 5;
    final int FEC_ULT_AMORT = 6;
    final int TASA_ACU = 7;
    final int TASA_ACU_EJER_ANT = 8;
    final int ANT_MESES_AMORT = 9;
    final int ANT_OID_ULT_PERI_A = 10;
    final int ANT_TASA_ACU = 11;
    final int ANT_TASA_ACU_EJE_A = 12;
    final int ULT_TASA_APLIC = 13;
    final int TASA_ACUM_EJER_ACT = 14;
    final int OID_BIEN_VU = 15;

    SubBienVidaUtil pers = (SubBienVidaUtil) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buBienVU set "+
              "oid_bien_alta=?"+ 
              ",oid_sist_val=?"+ 
              ",vidal_util=?"+ 
              ",meses_amort=?"+ 
              ",oid_ult_peri_amort=?"+ 
              ",fec_ult_amort=?"+ 
              ",tasa_acu=?"+ 
              ",tasa_acu_ejer_ant=?"+ 
              ",ant_meses_amort=?"+ 
              ",ant_oid_ult_peri_a=?"+ 
              ",ant_tasa_acu=?"+ 
              ",ant_tasa_acu_eje_a=?"+ 
              ",ult_tasa_aplic=?"+
              ",tasa_acum_ejer_act=?"+
                 " where " +
                 " oid_bien_vu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_VU,pers.getOID());
    qUpdate.setInt(OID_BIEN_ALTA,pers.getSubbien().getOID());
    qUpdate.setInt(OID_SIST_VAL,pers.getSistema_valuacion().getOID());
    qUpdate.setInt(VIDAL_UTIL,pers.getVidal_util().intValue());
    qUpdate.setInt(MESES_AMORT,pers.getMeses_amort().intValue());
    if (pers.getUlt_peri_amort()!=null)
    	qUpdate.setInt(OID_ULT_PERI_AMORT,pers.getUlt_peri_amort().getOID());
      else
    	  qUpdate.setNull(OID_ULT_PERI_AMORT,Types.INTEGER);
    if (pers.getFec_ult_amort()!=null) 
      qUpdate.setDate(FEC_ULT_AMORT,new java.sql.Date(pers.getFec_ult_amort().getTime()));
    else
      qUpdate.setNull(FEC_ULT_AMORT,java.sql.Types.INTEGER);
    qUpdate.setDouble(TASA_ACU,pers.getTasa_acu().doubleValue());
    qUpdate.setDouble(TASA_ACU_EJER_ANT,pers.getTasa_acu_ejer_ant().doubleValue());
    qUpdate.setInt(ANT_MESES_AMORT,pers.getAnt_meses_amort().intValue());
    if (pers.getAnt_ult_peri()!=null) 
      qUpdate.setInt(ANT_OID_ULT_PERI_A,pers.getAnt_ult_peri().getOID());
    else
      qUpdate.setNull(ANT_OID_ULT_PERI_A,java.sql.Types.INTEGER);
    qUpdate.setDouble(ANT_TASA_ACU,pers.getAnt_tasa_acu().doubleValue());
    qUpdate.setDouble(ANT_TASA_ACU_EJE_A,pers.getAnt_tasa_acu_eje_a().doubleValue());
    qUpdate.setDouble(TASA_ACUM_EJER_ACT,pers.getTasaAcuEjerActual().doubleValue());
    qUpdate.setDouble(ULT_TASA_APLIC,pers.getUltTasaAplic().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_VU = 1; 
    SubBienVidaUtil pers = (SubBienVidaUtil) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBienVU "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_bien_vu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_VU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_VU = 1; 
    SubBienVidaUtil pers = (SubBienVidaUtil) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBienVU "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_bien_vu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_VU, pers.getOID()); 
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
      case SELECT_BY_BIEN_ALTA : {
          ps = this.selectByBienAlta(aCondiciones); 
          break; 
      }
      case SELECT_BY_SIST_VAL_SUBBIEN: {
          ps = this.selectBySistValSubBien(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_BIEN_VU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBienVU "); 
    textSQL.append(" WHERE oid_bien_vu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_BIEN_VU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByBienAlta(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienVU "); 
	textSQL.append(" WHERE oid_bien_alta  = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	SubBien subBien = (SubBien) aCondiciones; 
	querySelect.setInt(1, subBien.getOID()); 
	return querySelect; 
  }
  
  private PreparedStatement selectBySistValSubBien(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienVU "); 
	textSQL.append(" WHERE oid_sist_val = ? and oid_bien_alta = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	SistemaValuacion sistVal = (SistemaValuacion)condiciones.get(SistemaValuacion.NICKNAME);
	SubBien subBien = (SubBien)condiciones.get(SubBien.NICKNAME);
	querySelect.setInt(1, sistVal.getOID());
	querySelect.setInt(2,subBien.getOID());
	return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBienVU "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_bien_vu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buBienVU");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSubBienesVidalUtil(SubBien aSubBien,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(SubBienVidaUtil.NICKNAME,
             DBSubBienVidaUtil.SELECT_BY_BIEN_ALTA,
             aSubBien,
             new ListObserver(),
             aSesion);
  }
  
  public static SubBienVidaUtil getSubBienVidaUtil(SubBien subBien,SistemaValuacion sistVal,ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(SubBien.NICKNAME,subBien);
	  condiciones.put(SistemaValuacion.NICKNAME,sistVal);
	  return (SubBienVidaUtil) ObjetoLogico.getObjects(SubBienVidaUtil.NICKNAME,
			  DBSubBienVidaUtil.SELECT_BY_SIST_VAL_SUBBIEN,
			  condiciones,
			  new ObjetoObservado(),
			  aSesion);
  }
  
  
  
} 
