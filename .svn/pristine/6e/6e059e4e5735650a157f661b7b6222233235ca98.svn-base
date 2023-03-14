package com.srn.erp.rrhh.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBSancionesRRHH extends DBObjetoPersistente {

  public static final String OID_MOT_SANCION = "oid_mot_sancion";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String EXC_PLANIF_ROTAS = "exc_planif_rotas";

  public DBSancionesRRHH() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_SANCION = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int EXC_PLANIF_ROTAS = 5;

    SancionesRRHH pers = (SancionesRRHH) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhMotivoSancion "+
                     " ( "+
                      "OID_MOT_SANCION,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,exc_planif_rotas)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_SANCION,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isExcluirEnPlanifRotas()!=null)
    	qInsert.setBoolean(EXC_PLANIF_ROTAS,pers.isExcluirEnPlanifRotas().booleanValue());
    else
    	qInsert.setBoolean(EXC_PLANIF_ROTAS,false);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int EXC_PLANIF_ROTAS = 4;
    final int OID_MOT_SANCION = 5;

    SancionesRRHH pers = (SancionesRRHH) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhMotivoSancion set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",exc_planif_rotas=?"+
                 " where " +
                 " oid_mot_sancion=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_SANCION,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isExcluirEnPlanifRotas()!=null)
    	qUpdate.setBoolean(EXC_PLANIF_ROTAS,pers.isExcluirEnPlanifRotas().booleanValue());
    else
    	qUpdate.setBoolean(EXC_PLANIF_ROTAS,false);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_SANCION = 1; 
    SancionesRRHH pers = (SancionesRRHH) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhMotivoSancion "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_sancion=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_SANCION, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_SANCION = 1; 
    SancionesRRHH pers = (SancionesRRHH) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhMotivoSancion "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_sancion=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_SANCION, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
          ps = this.selectAllHelpActivos(aCondiciones); 
          break; 
      }
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
      } 
      
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOT_SANCION = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhMotivoSancion "); 
    textSQL.append(" WHERE oid_mot_sancion = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_SANCION, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhMotivoSancion "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhMotivoSancion "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_sancion oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from rhMotivoSancion");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_mot_sancion oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from rhMotivoSancion where activo = 1");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  } 
  
  public static List getAllSanciones(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SancionesRRHH.NICKNAME,
             DBSancionesRRHH.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
