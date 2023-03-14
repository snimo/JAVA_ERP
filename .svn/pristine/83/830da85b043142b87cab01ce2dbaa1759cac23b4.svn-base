package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBComproSubRepartoDet extends DBObjetoPersistente {

  public static final String OID_SUB_REP_DET = "oid_sub_rep_det";
  public static final String OID_COMPRO_SUB = "oid_compro_sub";
  public static final String OID_AI = "oid_ai";
  public static final String SIGNO = "signo";
  public static final String IMPORTE_LOC_HIST = "impo_loc_his";
  public static final String IMPORTE_LOC_AJU = "impo_loc_aju";
  public static final String IMPORTE_MON_EXT_1 = "impo_mon_ext_1";
  public static final String IMPORTE_MON_EXT_2 = "impo_mon_ext_2";
  
  public static final String OID_MONEDA_ORI = "oid_mon_ori";
  public static final String IMPORTE_ORI = "importe_ori";
  public static final String COTIZ_MON_ORI = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT_1 = "cotiz_mon_ext_1";
  public static final String COTIZ_MON_EXT_2 = "cotiz_mon_ext_2";
  
  public static final String ACTIVO = "activo";
  public static final String OID_FASE = "oid_fase";
  
  public static final String OID_CONTA_DET = "oid_conta_det";
  public static final String PROPORCION = "proporcion";
  public static final String OID_COMPO = "oid_compo";
  public static final String OID_VAL_COMPO = "oid_val_compo";
  
  
  
  
  public static final int SELECT_BY_COMPRO_SUBREP = 100;

  public DBComproSubRepartoDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SUB_REP_DET = 1;
    final int OID_COMPRO_SUB = 2;
    final int OID_AI = 3;
    final int SIGNO = 4;
    final int IMPORTE_LOC_HIST = 5;
    final int IMPORTE_LOC_AJU = 6;
    final int IMPORTE_MON_EXT_1 = 7;
    final int IMPORTE_MON_EXT_2 = 8;
    final int ACTIVO = 9;
    final int OID_FASE = 10;
    final int OID_MONEDA_ORI = 11;
    final int IMPORTE_ORI = 12;
    final int COTIZ_MON_ORI = 13;
    final int COTIZ_MON_EXT_1 = 14;
    final int COTIZ_MON_EXT_2 = 15;
    final int OID_CONTA_DET = 16;
    final int PROPORCION = 17;
    final int OID_COMPO = 18;
    final int OID_VAL_COMPO = 19;
        
    

    ComproSubRepartoDet pers = (ComproSubRepartoDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproSubRepDet "+
                     " ( "+
                      "OID_SUB_REP_DET,"+
                      "OID_COMPRO_SUB,"+
                      "OID_AI,"+
                      "SIGNO,"+
                      "impo_loc_his,"+
                      "impo_loc_aju,"+
                      "impo_mon_ext_1,"+
                      "impo_mon_ext_2,"+
                      "ACTIVO,OID_FASE,oid_mon_ori,importe_ori,cotiz_mon_ori,cotiz_mon_ext_1,cotiz_mon_ext_2,"+
                      "oid_conta_det,proporcion,oid_compo,oid_val_compo)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SUB_REP_DET,pers.getOID());
    qInsert.setInt(OID_COMPRO_SUB,pers.getCompro_subreparto().getOID());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setDouble(IMPORTE_LOC_AJU,pers.getImpoLocAju().doubleValue());
    qInsert.setDouble(IMPORTE_LOC_HIST,pers.getImpoLocHist().doubleValue());
    qInsert.setDouble(IMPORTE_MON_EXT_1,pers.getImpoMonExt1().doubleValue());
    qInsert.setDouble(IMPORTE_MON_EXT_2,pers.getImpoMonExt2().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_FASE, pers.getFaseSubReparto().getOID());
    if (pers.getMonedaOri()!=null)
    	qInsert.setInt(OID_MONEDA_ORI, pers.getMonedaOri().getOID());
    else
    	qInsert.setNull(OID_MONEDA_ORI, java.sql.Types.INTEGER);
    qInsert.setDouble(IMPORTE_ORI, pers.getImporteOri().doubleValue());
    if (pers.getValorCotizMonOri()!=null)
    	qInsert.setDouble(COTIZ_MON_ORI,pers.getValorCotizMonOri().doubleValue());
    else
    	qInsert.setDouble(COTIZ_MON_ORI,0);
    if (pers.getValorCotizMonMonExt1()!=null)
    	qInsert.setDouble(COTIZ_MON_EXT_1,pers.getValorCotizMonMonExt1().doubleValue());
    else
    	qInsert.setDouble(COTIZ_MON_EXT_1,0);
    if (pers.getValorCotizMonMonExt2()!=null)
    	qInsert.setDouble(COTIZ_MON_EXT_2,pers.getValorCotizMonMonExt2().doubleValue());
    else
    	qInsert.setDouble(COTIZ_MON_EXT_2,0);
    qInsert.setInt(OID_CONTA_DET, pers.getComproContaDet().getOID());
    qInsert.setDouble(PROPORCION, pers.getProporcion().doubleValue());
    qInsert.setInt(OID_COMPO, pers.getComponente().getOID());
    if (pers.getValorComponente()!=null)
    	qInsert.setInt(OID_VAL_COMPO, pers.getValorComponente().getOIDInteger());
    else
    	qInsert.setNull(OID_VAL_COMPO, java.sql.Types.INTEGER);
    		
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPRO_SUB = 1;
    final int OID_AI = 2;
    final int SIGNO = 3;
    final int IMPORTE_LOC_HIST = 4;
    final int IMPORTE_LOC_AJU = 5;
    final int IMPORTE_MON_EXT_1 = 6;
    final int IMPORTE_MON_EXT_2 = 7;    
    final int ACTIVO = 8;
    final int OID_FASE = 9;
    final int OID_MONEDA_ORI = 10;
    final int IMPORTE_ORI = 11;
    final int COTIZ_MON_ORI = 12;
    final int COTIZ_MON_EXT_1 = 13;
    final int COTIZ_MON_EXT_2 = 14;
    final int OID_CONTA_DET = 15;
    final int PROPORCION = 16;
    final int OID_COMPO = 17;
    final int OID_VAL_COMPO = 18;
    final int OID_SUB_REP_DET = 18;

    ComproSubRepartoDet pers = (ComproSubRepartoDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproSubRepDet set "+
              "oid_compro_sub=?"+ 
              ",oid_ai=?"+ 
              ",signo=?"+ 
              ",impo_loc_his=?"+
              ",impo_loc_aju=?"+
              ",impo_mon_ext_1=?"+
              ",impo_mon_ext_2=?"+
              ",activo=?"+ 
              ",oid_fase=?"+
              ",oid_mon_ori=?,importe_ori=?,cotiz_mon_ori=?,cotiz_mon_ext_1=?,cotiz_mon_ext_2=?, "+
              "oid_conta_det=?,proporcion=?,oid_compo=?,oid_val_compo=? "+
                 " where " +
                 " oid_sub_rep_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUB_REP_DET,pers.getOID());
    qUpdate.setInt(OID_COMPRO_SUB,pers.getCompro_subreparto().getOID());
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qUpdate.setInt(SIGNO,pers.getSigno().intValue());
    qUpdate.setDouble(IMPORTE_LOC_AJU,pers.getImpoLocAju().doubleValue());
    qUpdate.setDouble(IMPORTE_LOC_HIST,pers.getImpoLocHist().doubleValue());
    qUpdate.setDouble(IMPORTE_MON_EXT_1,pers.getImpoMonExt1().doubleValue());
    qUpdate.setDouble(IMPORTE_MON_EXT_2,pers.getImpoMonExt2().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_FASE, pers.getFaseSubReparto().getOID());
    qUpdate.setInt(OID_MONEDA_ORI, pers.getMonedaOri().getOID());
    qUpdate.setDouble(IMPORTE_ORI, pers.getImporteOri().doubleValue());
    qUpdate.setDouble(COTIZ_MON_ORI,pers.getValorCotizMonOri().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT_1,pers.getValorCotizMonMonExt1().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT_2,pers.getValorCotizMonMonExt2().doubleValue());
    qUpdate.setInt(OID_CONTA_DET, pers.getComproContaDet().getOID());
    qUpdate.setDouble(PROPORCION, pers.getProporcion().doubleValue());
    qUpdate.setInt(OID_COMPO, pers.getComponente().getOID());
    qUpdate.setInt(OID_VAL_COMPO, pers.getValorComponente().getOIDInteger());
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SUB_REP_DET = 1; 
    ComproSubRepartoDet pers = (ComproSubRepartoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgComproSubRepDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_sub_rep_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUB_REP_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SUB_REP_DET = 1; 
    ComproSubRepartoDet pers = (ComproSubRepartoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgComproSubRepDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sub_rep_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUB_REP_DET, pers.getOID()); 
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
      case SELECT_BY_COMPRO_SUBREP: {
          ps = this.selectByComproSubRep(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SUB_REP_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgComproSubRepDet "); 
    textSQL.append(" WHERE oid_sub_rep_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SUB_REP_DET, oid); 
    return querySelect; 
  }
  

  private PreparedStatement selectByComproSubRep(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgComproSubRepDet "); 
	    textSQL.append(" WHERE oid_compro_sub = ? order by secu ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ComproSubReparto compro = (ComproSubReparto) aCondiciones; 
	    querySelect.setInt(1, compro.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgComproSubRepDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sub_rep_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproSubRepDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getDetalles(ComproSubReparto compro,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ComproSubRepartoDet.NICKNAME,
             DBComproSubRepartoDet.SELECT_BY_COMPRO_SUBREP,
             compro,
             new ListObserver(),
             aSesion);
  }
  
  
} 
