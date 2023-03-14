package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCompetencia extends DBObjetoPersistente {

  public static final String OID_COMPETENCIA = "oid_competencia";
  public static final String CODIGO = "codigo";
  public static final String TITULO = "titulo";
  public static final String DEFINICION = "definicion";
  public static final String ACTIVO = "activo";
  public static final String DESC_ABREV = "desc_abrev";
  
  public static final int SELECT_BY_MODELO_EVA = 100;

  public DBCompetencia() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPETENCIA = 1;
    final int CODIGO = 2;
    final int TITULO = 3;
    final int DEFINICION = 4;
    final int ACTIVO = 5;
    final int DESC_ABREV = 6;
    
    Competencia pers = (Competencia) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhCompetencias "+
                     " ( "+
                      "OID_COMPETENCIA,"+
                      "CODIGO,"+
                      "TITULO,"+
                      "DEFINICION,"+
                      "ACTIVO,DESC_ABREV)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPETENCIA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(TITULO,pers.getTitulo());
    qInsert.setString(DEFINICION,pers.getDefinicion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(DESC_ABREV, pers.getDescAbrev());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int TITULO = 2;
    final int DEFINICION = 3;
    final int ACTIVO = 4;
    final int DESC_ABREV = 5;
    final int OID_COMPETENCIA = 6;

    Competencia pers = (Competencia) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhCompetencias set "+
              "codigo=?"+ 
              ",titulo=?"+ 
              ",definicion=?"+ 
              ",activo=?"+ 
              ",desc_abrev=?"+
                 " where " +
                 " oid_competencia=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPETENCIA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(TITULO,pers.getTitulo());
    qUpdate.setString(DEFINICION,pers.getDefinicion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(DESC_ABREV, pers.getDescAbrev());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPETENCIA = 1; 
    Competencia pers = (Competencia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhCompetencias "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_competencia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPETENCIA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPETENCIA = 1; 
    Competencia pers = (Competencia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhCompetencias "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_competencia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPETENCIA, pers.getOID()); 
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
      case SELECT_BY_MODELO_EVA: {
        ps = this.selectModeloEval(aCondiciones); 
        break; 
    }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COMPETENCIA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhCompetencias "); 
    textSQL.append(" WHERE oid_competencia = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPETENCIA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectModeloEval(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" "); 
	    textSQL.append("SELECT * FROM  rhCompetencias WHERE oid_competencia IN ( ");
	    textSQL.append(" select c.oid_competencia from rhModEvalComp a,rhCondModEval b , rhCompetencias c where a.oid_cond_mod = b.oid_cond_mod and a.activo = 1 and b.activo = 1 and b.oid_mod_eval_cab = ? and c.oid_competencia = a.oid_competencia and c.activo=1 ) ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ModeloEvalCab modelo = (ModeloEvalCab) aCondiciones; 
	    querySelect.setInt(1, modelo.getOID()); 
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhCompetencias "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_competencia oid,codigo codigo, titulo descripcion ,activo ");
    textSQL.append(" from rhCompetencias");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCompetencias(ModeloEvalCab aModeloEvalCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Competencia.NICKNAME,
             DBCompetencia.SELECT_BY_MODELO_EVA,
             aModeloEvalCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
