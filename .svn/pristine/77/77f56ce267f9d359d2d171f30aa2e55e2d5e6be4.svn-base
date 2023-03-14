package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.FaseCompoOriginal;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFaseCompoOriginal extends DBObjetoPersistente {

  public static final String OID_FASE_COMPO_ORI = "oid_fase_compo_ori";
  public static final String OID_FASE = "oid_fase";
  public static final String OID_COMPO = "oid_compo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FASE = 100;
  public static final int SELECT_BY_FASE_COMPO = 101;
  

  public DBFaseCompoOriginal() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE_COMPO_ORI = 1;
    final int OID_FASE = 2;
    final int OID_COMPO = 3;
    final int ACTIVO = 4;

    FaseCompoOriginal pers = (FaseCompoOriginal) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgFaseCompoOri "+
                     " ( "+
                      "OID_FASE_COMPO_ORI,"+
                      "OID_FASE,"+
                      "OID_COMPO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FASE_COMPO_ORI,pers.getOID());
    qInsert.setInt(OID_FASE,pers.getFase().getOID());
    qInsert.setInt(OID_COMPO,pers.getComponente().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE = 1;
    final int OID_COMPO = 2;
    final int ACTIVO = 3;
    final int OID_FASE_COMPO_ORI = 4;

    FaseCompoOriginal pers = (FaseCompoOriginal) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgFaseCompoOri set "+
              "oid_fase=?"+ 
              ",oid_compo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_fase_compo_ori=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_COMPO_ORI,pers.getOID());
    qUpdate.setInt(OID_FASE,pers.getFase().getOID());
    qUpdate.setInt(OID_COMPO,pers.getComponente().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	
    final int OID_FASE_COMPO_ORI = 1; 
    FaseCompoOriginal pers = (FaseCompoOriginal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgFaseCompoOri "+
                     " where " + 
                     " oid_fase_compo_ori=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_COMPO_ORI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_COMPO_ORI = 1; 
    FaseCompoOriginal pers = (FaseCompoOriginal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgFaseCompoOri "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fase_compo_ori=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_COMPO_ORI, pers.getOID()); 
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
      case SELECT_BY_FASE: {
          ps = this.selectByFase(aCondiciones); 
          break; 
      }
      case SELECT_BY_FASE_COMPO: {
          ps = this.selectByFaseCompo(aCondiciones); 
          break; 
      }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FASE_COMPO_ORI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseCompoOri "); 
    textSQL.append(" WHERE oid_fase_compo_ori = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FASE_COMPO_ORI, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFase(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgFaseCompoOri "); 
	    textSQL.append(" WHERE oid_fase = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    FaseSubReparto fase =  (FaseSubReparto) aCondiciones; 
	    querySelect.setInt(1, fase.getOID()); 
	    return querySelect; 
	  }
  
  private PreparedStatement selectByFaseCompo(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    FaseSubReparto fase = (FaseSubReparto) condiciones.get(FaseSubReparto.NICKNAME);
	    Componente compo = (Componente) condiciones.get(Componente.NICKNAME);
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgFaseCompoOri "); 
	    textSQL.append(" WHERE oid_fase = ? and oid_compo = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, fase.getOID()); 
	    querySelect.setInt(2, compo.getOID());
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseCompoOri "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fase_compo_ori oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgFaseCompoOri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getComponentesOrigen(FaseSubReparto fase,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FaseCompoOriginal.NICKNAME,
             DBFaseCompoOriginal.SELECT_BY_FASE,
             fase,
             new ListObserver(),
             aSesion);
  }
  
  public static FaseCompoOriginal getFaseCompoOriginal(
		  FaseSubReparto faseSubReparto,
		  Componente componente,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(FaseSubReparto.NICKNAME, faseSubReparto);
	  condiciones.put(Componente.NICKNAME, componente);
	  return (FaseCompoOriginal) ObjetoLogico.getObjects(FaseCompoOriginal.NICKNAME,
			  				DBFaseCompoOriginal.SELECT_BY_FASE_COMPO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
