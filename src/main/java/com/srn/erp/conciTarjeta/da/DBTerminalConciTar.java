package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.TerminalConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTerminalConciTar extends DBObjetoPersistente {

  public static final String OID_TERMINAL = "oid_terminal";
  public static final String NRO_TERMINAL = "nro_terminal";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_UNI_NEG = "oid_uni_neg";
  public static final String FOLDER_IN_CIELOT = "Folder_IN_CieLot";
  public static final String ACTIVO = "activo";
  public static final String FOLDER_LOTE_PROC = "folder_lote_proc";
  public static final String FOLDER_LOTE_ERROR = "folder_Lote_Error";
  
  public static final int SELECT_BY_FOLDER_IN = 100;
  

  public DBTerminalConciTar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TERMINAL = 1;
    final int NRO_TERMINAL = 2;
    final int DESCRIPCION = 3;
    final int OID_UNI_NEG = 4;
    final int FOLDER_IN_CIELOT = 5;
    final int ACTIVO = 6;
    final int FOLDER_LOTE_PROC = 7;
    final int FOLDER_LOTE_ERROR = 8;

    TerminalConciTar pers = (TerminalConciTar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarTerminal "+
                     " ( "+
                      "OID_TERMINAL,"+
                      "NRO_TERMINAL,"+
                      "DESCRIPCION,"+
                      "OID_UNI_NEG,"+
                      "FOLDER_IN_CIELOT,"+
                      "ACTIVO,"+
                      "FOLDER_LOTE_PROC,folder_Lote_Error)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TERMINAL,pers.getOID());
    qInsert.setString(NRO_TERMINAL,pers.getNro_terminal());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_UNI_NEG,pers.getUni_neg().getOID());
    qInsert.setString(FOLDER_IN_CIELOT,pers.getFolder_in_cielot());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(FOLDER_LOTE_PROC,pers.getFolderLoteProcesado());
    qInsert.setString(FOLDER_LOTE_ERROR, pers.getFolderLoteError());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NRO_TERMINAL = 1;
    final int DESCRIPCION = 2;
    final int OID_UNI_NEG = 3;
    final int FOLDER_IN_CIELOT = 4;
    final int ACTIVO = 5;
    final int FOLDER_LOTE_PROC = 6;
    final int FOLDER_LOTE_ERROR = 7;
    final int OID_TERMINAL = 8;

    TerminalConciTar pers = (TerminalConciTar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarTerminal set "+
              		 "nro_terminal=?"+ 
              		 ",descripcion=?"+ 
              		 ",oid_uni_neg=?"+ 
              		 ",Folder_IN_CieLot=?"+ 
              		 ",activo=?,"+
              		 "folder_lote_proc=?, "+
              		 "folder_Lote_Error=? "+
              		 " where " +
                 	" oid_terminal=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TERMINAL,pers.getOID());
    qUpdate.setString(NRO_TERMINAL,pers.getNro_terminal());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_UNI_NEG,pers.getUni_neg().getOID());
    qUpdate.setString(FOLDER_IN_CIELOT,pers.getFolder_in_cielot());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(FOLDER_LOTE_PROC,pers.getFolderLoteProcesado());
    qUpdate.setString(FOLDER_LOTE_ERROR,pers.getFolderLoteError());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TERMINAL = 1; 
    TerminalConciTar pers = (TerminalConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTerminal "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_terminal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TERMINAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TERMINAL = 1; 
    TerminalConciTar pers = (TerminalConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTerminal "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_terminal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TERMINAL, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: { 
          ps = this.selectAllHelpActivos(aCondiciones); 
          break; 
        }      
      case SELECT_BY_FOLDER_IN: {
          ps = this.selectByFolderIN(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TERMINAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTerminal "); 
    textSQL.append(" WHERE oid_terminal = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TERMINAL, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByFolderIN(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarTerminal "); 
	    textSQL.append(" WHERE folder_in_cielot  = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String codigo = (String) aCondiciones; 
	    querySelect.setString(1, codigo); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTerminal "); 
    textSQL.append(" WHERE nro_terminal  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_terminal oid, nro_terminal codigo,  descripcion ,activo ");
	    textSQL.append(" from cTarTerminal where activo = 1 ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_terminal oid, nro_terminal codigo,  descripcion ,activo ");
    textSQL.append(" from cTarTerminal");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(TerminalConciTar.NICKNAME,
             DBTerminalConciTar.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }
  
  public static TerminalConciTar getTerminal(String folderIN,
          ISesion aSesion)
          throws BaseException {
	  return (TerminalConciTar) ObjetoLogico.getObjects(TerminalConciTar.NICKNAME,
			  				DBTerminalConciTar.SELECT_BY_FOLDER_IN,
			  				folderIN,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static TerminalConciTar getTerminalByNro(String nroTerminal,
          ISesion aSesion)
          throws BaseException {
	  return (TerminalConciTar) ObjetoLogico.getObjects(TerminalConciTar.NICKNAME,
			  				DBTerminalConciTar.SELECT_BY_CODIGO,
			  				nroTerminal,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
  
  
} 
