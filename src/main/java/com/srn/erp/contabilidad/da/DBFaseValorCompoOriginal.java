package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.FaseValorCompoOriginal;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

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

public class DBFaseValorCompoOriginal extends DBObjetoPersistente {

  public static final String OID_FASE_VALOR_COMPO = "oid_fase_valor_compo";
  public static final String OID_FASE = "oid_fase";
  public static final String OID_COMPO = "oid_compo";
  public static final String OID_VAL_COMPO = "oid_val_compo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FASE_COMPO = 100;
  public static final int SELECT_BY_FASE_COMPO_VALOR = 101;
  

  public DBFaseValorCompoOriginal() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE_VALOR_COMPO = 1;
    final int OID_FASE = 2;
    final int OID_COMPO = 3;
    final int OID_VAL_COMPO = 4;
    final int ACTIVO = 5;

    FaseValorCompoOriginal pers = (FaseValorCompoOriginal) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgFaseValCompoOri "+
                     " ( "+
                      "OID_FASE_VALOR_COMPO,"+
                      "OID_FASE,"+
                      "OID_COMPO,"+
                      "OID_VAL_COMPO,"+
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
    qInsert.setInt(OID_COMPO,pers.getComponente().getOID());
    qInsert.setInt(OID_VAL_COMPO,pers.getValor_componente().getOIDInteger().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FASE = 1;
    final int OID_COMPO = 2;
    final int OID_VAL_COMPO = 3;
    final int ACTIVO = 4;
    final int OID_FASE_VALOR_COMPO = 5;

    FaseValorCompoOriginal pers = (FaseValorCompoOriginal) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgFaseValCompoOri set "+
              "oid_fase=?"+ 
              ",oid_compo=?"+ 
              ",oid_val_compo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " OID_FASE_VALOR_COMPO=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_VALOR_COMPO,pers.getOID());
    qUpdate.setInt(OID_FASE,pers.getFase().getOID());
    qUpdate.setInt(OID_COMPO,pers.getComponente().getOID());
    qUpdate.setInt(OID_VAL_COMPO,pers.getValor_componente().getOIDInteger().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_VALOR_COMPO = 1; 
    FaseValorCompoOriginal pers = (FaseValorCompoOriginal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgFaseValCompoOri "+
                     " where " + 
                     " OID_FASE_VALOR_COMPO=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FASE_VALOR_COMPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FASE_VALOR_COMPO = 1; 
    FaseValorCompoOriginal pers = (FaseValorCompoOriginal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgFaseValCompoOri "+
                     " set activo=1 " + 
                     " where " + 
                     " OID_FASE_VALOR_COMPO=? ");
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
      case SELECT_BY_FASE_COMPO: {
          ps = this.selectByFaseCompo(aCondiciones); 
          break; 
      }
      case SELECT_BY_FASE_COMPO_VALOR: {
          ps = this.selectByFaseCompoValor(aCondiciones); 
          break; 
      }
      
    } 
    return ps;
  } 

  
  private PreparedStatement selectByFaseCompo(Object aCondiciones) throws BaseException, SQLException { 

	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	FaseSubReparto faseSubreparto = (FaseSubReparto) condiciones.get(FaseSubReparto.NICKNAME);
	Componente componente = (Componente) condiciones.get(Componente.NICKNAME);
	
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cgFaseValCompoOri "); 
	textSQL.append(" WHERE oid_fase = ? and oid_compo = ? "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	querySelect.setInt(1, faseSubreparto.getOID());
	querySelect.setInt(2, componente.getOID());
	return querySelect; 
	
  }
  
  private PreparedStatement selectByFaseCompoValor(Object aCondiciones) throws BaseException, SQLException { 

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		FaseSubReparto faseSubreparto = (FaseSubReparto) condiciones.get(FaseSubReparto.NICKNAME);
		Componente componente = (Componente) condiciones.get(Componente.NICKNAME);
		IObjetoLogico objLog = (IObjetoLogico) condiciones.get("OBJETO_LOGICO");
		
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  cgFaseValCompoOri "); 
		textSQL.append(" WHERE oid_fase = ? and oid_compo = ? and oid_val_compo = ? "); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, faseSubreparto.getOID());
		querySelect.setInt(2, componente.getOID());
		querySelect.setInt(3, objLog.getOIDInteger().intValue());
		return querySelect; 
		
  }
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FASE_VALOR_COMPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseValCompoOri "); 
    textSQL.append(" WHERE OID_FASE_VALOR_COMPO = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FASE_VALOR_COMPO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgFaseValCompoOri "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT OID_FASE_VALOR_COMPO oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgFaseValCompoOri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getValoresCompo(FaseSubReparto fase,
		  Componente componente,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(FaseSubReparto.NICKNAME, fase);
	  condiciones.put(Componente.NICKNAME, componente);
	  return (List) ObjetoLogico.getObjects(FaseValorCompoOriginal.NICKNAME,
             DBFaseValorCompoOriginal.SELECT_BY_FASE_COMPO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static FaseValorCompoOriginal getFaseValorCompoOri(
		  FaseSubReparto fase,
		  Componente componente,
		  IObjetoLogico valorCompo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(FaseSubReparto.NICKNAME, fase);
	  condiciones.put(Componente.NICKNAME, componente);
	  condiciones.put("OBJETO_LOGICO", valorCompo);
	  
	  return (FaseValorCompoOriginal) ObjetoLogico.getObjects(FaseValorCompoOriginal.NICKNAME,
			  				DBFaseValorCompoOriginal.SELECT_BY_FASE_COMPO_VALOR,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
