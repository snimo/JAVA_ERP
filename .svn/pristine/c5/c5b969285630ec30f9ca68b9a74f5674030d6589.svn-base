package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.EstrucTableroTurnosCab;
import com.srn.erp.turnos.bm.EstrucTableroTurnosDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEstrucTableroTurnosDet extends DBObjetoPersistente {

  public static final String OID_ESTRUC_DET = "oid_estruc_det";
  public static final String OID_ESTRUC_TAB_TUR = "oid_estruc_tab_tur";
  public static final String OID_PARTE_TABLERO = "oid_parte_tablero";
  public static final String ACTIVO = "activo";
  public static final String SECU = "secu";
  
  public static final int SELECT_BY_ESTRUC_TAB_CAB = 100;

  public DBEstrucTableroTurnosDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_DET = 1;
    final int OID_ESTRUC_TAB_TUR = 2;
    final int OID_PARTE_TABLERO = 3;
    final int ACTIVO = 4;
    final int SECU = 5;

    EstrucTableroTurnosDet pers = (EstrucTableroTurnosDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuEstrucTabTurDet "+
                     " ( "+
                      "OID_ESTRUC_DET,"+
                      "OID_ESTRUC_TAB_TUR,"+
                      "OID_PARTE_TABLERO,"+
                      "ACTIVO,SECU)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTRUC_DET,pers.getOID());
    qInsert.setInt(OID_ESTRUC_TAB_TUR,pers.getEstruc_tab_cab().getOID());
    qInsert.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_TAB_TUR = 1;
    final int OID_PARTE_TABLERO = 2;
    final int ACTIVO = 3;
    final int SECU = 4;
    final int OID_ESTRUC_DET = 5;
    

    EstrucTableroTurnosDet pers = (EstrucTableroTurnosDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuEstrucTabTurDet set "+
              "oid_estruc_tab_tur=?"+ 
              ",oid_parte_tablero=?"+ 
              ",activo=?"+ 
              ",secu=?"+
                 " where " +
                 " oid_estruc_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_DET,pers.getOID());
    qUpdate.setInt(OID_ESTRUC_TAB_TUR,pers.getEstruc_tab_cab().getOID());
    qUpdate.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_DET = 1; 
    EstrucTableroTurnosDet pers = (EstrucTableroTurnosDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from tuEstrucTabTurDet "+
                     " where " + 
                     " oid_estruc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_DET = 1; 
    EstrucTableroTurnosDet pers = (EstrucTableroTurnosDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuEstrucTabTurDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estruc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_DET, pers.getOID()); 
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
      case SELECT_BY_ESTRUC_TAB_CAB : {
        ps = this.selectByParteTablero(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESTRUC_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuEstrucTabTurDet "); 
    textSQL.append(" WHERE oid_estruc_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTRUC_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByParteTablero(Object aCondiciones) throws BaseException, SQLException { 

	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  tuEstrucTabTurDet "); 
	textSQL.append(" WHERE oid_estruc_tab_tur = ? order by secu  "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	EstrucTableroTurnosCab estrucTab = (EstrucTableroTurnosCab) aCondiciones; 
	querySelect.setInt(1, estrucTab.getOIDInteger()); 
	return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuEstrucTabTurDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estruc_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuEstrucTabTurDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetalles(EstrucTableroTurnosCab estrucTab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EstrucTableroTurnosDet.NICKNAME,
             DBEstrucTableroTurnosDet.SELECT_BY_ESTRUC_TAB_CAB,
             estrucTab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
