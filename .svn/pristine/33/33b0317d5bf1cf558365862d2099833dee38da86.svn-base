package com.srn.erp.pagos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.pagos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBRendicionFFUniOrgCta extends DBObjetoPersistente {

  public static final String OID_FF_CTA = "oid_ff_cta";
  public static final String OID_UNI_ORG_FF = "oid_uni_org_ff";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_UNI_ORG_FF = 100;

  public DBRendicionFFUniOrgCta() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FF_CTA = 1;
    final int OID_UNI_ORG_FF = 2;
    final int OID_ANA_CON = 3;
    final int ACTIVO = 4;

    RendicionFFUniOrgCta pers = (RendicionFFUniOrgCta) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opUniOrgFFCta "+
                     " ( "+
                      "OID_FF_CTA,"+
                      "OID_UNI_ORG_FF,"+
                      "OID_ANA_CON,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FF_CTA,pers.getOID());
    qInsert.setInt(OID_UNI_ORG_FF,pers.getUnidad_organizativa_ff().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UNI_ORG_FF = 1;
    final int OID_ANA_CON = 2;
    final int ACTIVO = 3;
    final int OID_FF_CTA = 4;

    RendicionFFUniOrgCta pers = (RendicionFFUniOrgCta) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opUniOrgFFCta set "+
              "oid_uni_org_ff=?"+ 
              ",oid_ana_con=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_ff_cta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FF_CTA,pers.getOID());
    qUpdate.setInt(OID_UNI_ORG_FF,pers.getUnidad_organizativa_ff().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FF_CTA = 1; 
    RendicionFFUniOrgCta pers = (RendicionFFUniOrgCta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from opUniOrgFFCta "+
                     " where " + 
                     " oid_ff_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FF_CTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FF_CTA = 1; 
    RendicionFFUniOrgCta pers = (RendicionFFUniOrgCta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opUniOrgFFCta "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_ff_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FF_CTA, pers.getOID()); 
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
      case SELECT_BY_UNI_ORG_FF: {
        ps = this.selectByUniOrgFF(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FF_CTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opUniOrgFFCta "); 
    textSQL.append(" WHERE oid_ff_cta = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FF_CTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByUniOrgFF(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opUniOrgFFCta "); 
    textSQL.append(" WHERE oid_uni_org_ff = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    RendicionFFUniOrg rendFFUniOrg = (RendicionFFUniOrg) aCondiciones; 
    querySelect.setInt(1, rendFFUniOrg.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opUniOrgFFCta "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ff_cta oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opUniOrgFFCta");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getRendicionFFUniOrgCta(RendicionFFUniOrg rendFFUniOrg,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(RendicionFFUniOrgCta.NICKNAME,
         DBRendicionFFUniOrgCta.SELECT_BY_UNI_ORG_FF,
         rendFFUniOrg,
         new ListObserver(),
         aSesion);
  }
  
  
  
  
} 
