package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.FaseValCompoDest;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFaseValCompoDest extends DBObjetoPersistente {

  public static final String OID_FASE_VALOR_COMPO = "oid_fase_valor_compo";
  public static final String OID_FASE = "oid_fase";
  public static final String OID_VAL_COMPO = "oid_val_compo";
  public static final String OID_DRIVER = "oid_driver";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FASE = 100;
  public static final int SELECT_BY_FASE_COMPO = 101;

  public DBFaseValCompoDest() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE_VALOR_COMPO = 1;
    final int OID_FASE = 2;
    final int OID_VAL_COMPO = 3;
    final int OID_DRIVER = 4;
    final int ACTIVO = 5;

    FaseValCompoDest pers = (FaseValCompoDest) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgFaseValCompoDes "+
                     " ( "+
                      "OID_FASE_VALOR_COMPO,"+
                      "OID_FASE,"+
                      "OID_VAL_COMPO,"+
                      "OID_DRIVER,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FASE_VALOR_COMPO,pers.getOID());
    qInsert.setInt(OID_FASE,pers.getFase().getOID());
    qInsert.setInt(OID_VAL_COMPO,pers.getValor_compo().getOIDInteger().intValue());
    qInsert.setInt(OID_DRIVER,pers.getDriver().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE = 1;
    final int OID_VAL_COMPO = 2;
    final int OID_DRIVER = 3;
    final int ACTIVO = 4;
    final int OID_FASE_VALOR_COMPO = 5;

    FaseValCompoDest pers = (FaseValCompoDest) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgFaseValCompoDes set "+
              "oid_fase=?"+ 
              ",oid_val_compo=?"+ 
              ",oid_driver=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_fase_valor_compo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_VALOR_COMPO,pers.getOID());
    qUpdate.setInt(OID_FASE,pers.getFase().getOID());
    qUpdate.setInt(OID_VAL_COMPO,pers.getValor_compo().getOIDInteger().intValue());
    qUpdate.setInt(OID_DRIVER,pers.getDriver().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_VALOR_COMPO = 1; 
    FaseValCompoDest pers = (FaseValCompoDest) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgFaseValCompoDes "+
                     " where " + 
                     " oid_fase_valor_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_VALOR_COMPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_VALOR_COMPO = 1; 
    FaseValCompoDest pers = (FaseValCompoDest) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgFaseValCompoDes "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fase_valor_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_VALOR_COMPO, pers.getOID()); 
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

    final int OID_FASE_VALOR_COMPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseValCompoDes "); 
    textSQL.append(" WHERE oid_fase_valor_compo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FASE_VALOR_COMPO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseValCompoDes "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFase(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgFaseValCompoDes "); 
	    textSQL.append(" WHERE oid_fase = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    FaseSubReparto fase = (FaseSubReparto) aCondiciones; 
	    querySelect.setInt(1, fase.getOID()); 
	    return querySelect; 
	  }
  
   private PreparedStatement selectByFaseCompo(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	FaseSubReparto fase = (FaseSubReparto) condiciones.get(FaseSubReparto.NICKNAME);
	  	IObjetoLogico objLog = (IObjetoLogico) condiciones.get("OBJETO_LOGICO");
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgFaseValCompoDes "); 
	    textSQL.append(" WHERE oid_fase = ? and oid_val_compo = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, fase.getOID()); 
	    querySelect.setInt(2, objLog.getOIDInteger().intValue());
	    return querySelect; 
	    
	}

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fase_valor_compo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgFaseValCompoDes");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getValoresCompoDestino(FaseSubReparto fase,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FaseValCompoDest.NICKNAME,
             DBFaseValCompoDest.SELECT_BY_FASE,
             fase,
             new ListObserver(),
             aSesion);
  }
  
  public static FaseValCompoDest getFaseValCompoDest(
		  FaseSubReparto fase,
		  IObjetoLogico valorCompo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(FaseSubReparto.NICKNAME, fase);
	  condiciones.put("OBJETO_LOGICO", valorCompo);
	  return (FaseValCompoDest) ObjetoLogico.getObjects(FaseValCompoDest.NICKNAME,
			  				DBFaseValCompoDest.SELECT_BY_FASE_COMPO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
