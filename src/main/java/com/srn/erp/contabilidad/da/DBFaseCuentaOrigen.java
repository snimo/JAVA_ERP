package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBFaseCuentaOrigen extends DBObjetoPersistente {

  public static final String OID_FASE_CTA_ORI = "oid_fase_cta_ori";
  public static final String OID_FASE = "oid_fase";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FASE = 100;
  public static final int SELECT_BY_FASE_CUENTA = 101;

  public DBFaseCuentaOrigen() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE_CTA_ORI = 1;
    final int OID_FASE = 2;
    final int OID_ANA_CON = 3;
    final int ACTIVO = 4;

    FaseCuentaOrigen pers = (FaseCuentaOrigen) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgFaseCtaOri "+
                     " ( "+
                      "OID_FASE_CTA_ORI,"+
                      "OID_FASE,"+
                      "OID_ANA_CON,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FASE_CTA_ORI,pers.getOID());
    qInsert.setInt(OID_FASE,pers.getFase().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE = 1;
    final int OID_ANA_CON = 2;
    final int ACTIVO = 3;
    final int OID_FASE_CTA_ORI = 4;

    FaseCuentaOrigen pers = (FaseCuentaOrigen) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgFaseCtaOri set "+
              "oid_fase=?"+ 
              ",oid_ana_con=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_fase_cta_ori=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_CTA_ORI,pers.getOID());
    qUpdate.setInt(OID_FASE,pers.getFase().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_CTA_ORI = 1; 
    FaseCuentaOrigen pers = (FaseCuentaOrigen) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgFaseCtaOri "+
                     " where " + 
                     " oid_fase_cta_ori=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_CTA_ORI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_CTA_ORI = 1; 
    FaseCuentaOrigen pers = (FaseCuentaOrigen) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgFaseCtaOri "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fase_cta_ori=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_CTA_ORI, pers.getOID()); 
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
      case SELECT_BY_FASE: { 
          ps = this.selectByFase(aCondiciones); 
          break; 
      }
      case SELECT_BY_FASE_CUENTA: { 
          ps = this.selectByFaseCuenta(aCondiciones); 
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

    final int OID_FASE_CTA_ORI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseCtaOri "); 
    textSQL.append(" WHERE oid_fase_cta_ori = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FASE_CTA_ORI, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFase(Object aCondiciones) throws BaseException, SQLException { 
	  	FaseSubReparto fase = (FaseSubReparto) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgFaseCtaOri "); 
	    textSQL.append(" WHERE oid_fase = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, fase.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByFaseCuenta(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	FaseSubReparto fase = (FaseSubReparto) condiciones.get(FaseSubReparto.NICKNAME);
	  	Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgFaseCtaOri "); 
	    textSQL.append(" WHERE oid_fase = ? and oid_ana_con = ?  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, fase.getOID()); 
	    querySelect.setInt(2, cuenta.getOID());
	    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseCtaOri "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fase_cta_ori oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgFaseCtaOri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCuentasOrigen(FaseSubReparto fase,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FaseCuentaOrigen.NICKNAME,
             DBFaseCuentaOrigen.SELECT_BY_FASE,
             fase,
             new ListObserver(),
             aSesion);
  }
  
  public static FaseCuentaOrigen getFaseCuentaOrigen(
		  FaseSubReparto fase,
		  Cuenta cuenta,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(FaseSubReparto.NICKNAME, fase);
	  condiciones.put(Cuenta.NICKNAME, cuenta);
	  
	  return (FaseCuentaOrigen) ObjetoLogico.getObjects(FaseCuentaOrigen.NICKNAME,
			  				DBFaseCuentaOrigen.SELECT_BY_FASE_CUENTA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
