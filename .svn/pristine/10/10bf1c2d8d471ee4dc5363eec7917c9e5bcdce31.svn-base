package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBModeloEvalCompe extends DBObjetoPersistente {

  public static final String OID_MOD_EVAL_COMP = "oid_mod_eval_comp";
  public static final String OID_COND_MOD = "oid_cond_mod";
  public static final String OID_COMPETENCIA = "oid_competencia";
  public static final String ORDEN = "orden";
  public static final String CODIGO_COMPE = "codigo_compe";
  public static final String TITULO_COMPE = "titulo_compe";
  public static final String DEFINICION_COMPE = "definicion_compe";
  public static final String PESO_COMPETENCIA = "peso_competencia";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONDICION = 100;
  public static final int SELECT_BY_COND_COMPE = 101;

  public DBModeloEvalCompe() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOD_EVAL_COMP = 1;
    final int OID_COND_MOD = 2;
    final int OID_COMPETENCIA = 3;
    final int ORDEN = 4;
    final int CODIGO_COMPE = 5;
    final int TITULO_COMPE = 6;
    final int DEFINICION_COMPE = 7;
    final int PESO_COMPETENCIA = 8;
    final int ACTIVO = 9;

    ModeloEvalCompe pers = (ModeloEvalCompe) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhModEvalComp "+
                     " ( "+
                      "OID_MOD_EVAL_COMP,"+
                      "OID_COND_MOD,"+
                      "OID_COMPETENCIA,"+
                      "ORDEN,"+
                      "CODIGO_COMPE,"+
                      "TITULO_COMPE,"+
                      "DEFINICION_COMPE,"+
                      "PESO_COMPETENCIA,"+
                      "ACTIVO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOD_EVAL_COMP,pers.getOID());
    qInsert.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qInsert.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(CODIGO_COMPE,pers.getCodigo_compe());
    qInsert.setString(TITULO_COMPE,pers.getTitulo_compe());
    if (pers.getDefinicion_compe()!=null)
    	qInsert.setString(DEFINICION_COMPE,pers.getDefinicion_compe());
    else
    	qInsert.setString(DEFINICION_COMPE,"");
    if (pers.getPeso_competencia()!=null)
    	qInsert.setDouble(PESO_COMPETENCIA,pers.getPeso_competencia().doubleValue(2));
    else
    	qInsert.setDouble(PESO_COMPETENCIA,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COND_MOD = 1;
    final int OID_COMPETENCIA = 2;
    final int ORDEN = 3;
    final int CODIGO_COMPE = 4;
    final int TITULO_COMPE = 5;
    final int DEFINICION_COMPE = 6;
    final int PESO_COMPETENCIA = 7;
    final int ACTIVO = 8;
    final int OID_MOD_EVAL_COMP = 9;

    ModeloEvalCompe pers = (ModeloEvalCompe) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhModEvalComp set "+
              "oid_cond_mod=?"+ 
              ",oid_competencia=?"+ 
              ",orden=?"+ 
              ",codigo_compe=?"+ 
              ",titulo_compe=?"+ 
              ",definicion_compe=?"+ 
              ",peso_competencia=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mod_eval_comp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_EVAL_COMP,pers.getOID());
    qUpdate.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qUpdate.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setString(CODIGO_COMPE,pers.getCodigo_compe());
    qUpdate.setString(TITULO_COMPE,pers.getTitulo_compe());
    if (pers.getDefinicion_compe()!=null)
    	qUpdate.setString(DEFINICION_COMPE,pers.getDefinicion_compe());
    else
    	qUpdate.setString(DEFINICION_COMPE,"");
    if (pers.getPeso_competencia()!=null)
    	qUpdate.setDouble(PESO_COMPETENCIA,pers.getPeso_competencia().doubleValue(2));
    else
    	qUpdate.setDouble(PESO_COMPETENCIA,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOD_EVAL_COMP = 1; 
    ModeloEvalCompe pers = (ModeloEvalCompe) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModEvalComp "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mod_eval_comp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_EVAL_COMP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOD_EVAL_COMP = 1; 
    ModeloEvalCompe pers = (ModeloEvalCompe) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModEvalComp "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mod_eval_comp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_EVAL_COMP, pers.getOID()); 
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
      case SELECT_BY_CONDICION: {
          ps = this.selectByCondicion(aCondiciones); 
          break; 
      }
      case SELECT_BY_COND_COMPE: {
          ps = this.selectByCondCompetencia(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOD_EVAL_COMP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModEvalComp "); 
    textSQL.append(" WHERE oid_mod_eval_comp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOD_EVAL_COMP, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCondCompetencia(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	CondModEvalCab condModEvalCab = (CondModEvalCab) condiciones.get(CondModEvalCab.NICKNAME);
	  	Competencia competencia = (Competencia) condiciones.get(Competencia.NICKNAME);
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModEvalComp "); 
	    textSQL.append(" WHERE oid_cond_mod = ? and oid_competencia = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, condModEvalCab.getOID()); 
	    querySelect.setInt(2, competencia.getOID());
	    return querySelect; 
  }
  
  private PreparedStatement selectByCondicion(Object aCondiciones) throws BaseException, SQLException { 

	    final int CODIGO = 1; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModEvalComp "); 
	    textSQL.append(" WHERE oid_cond_mod = ? and activo=1 order by orden ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CondModEvalCab condicion  = (CondModEvalCab) aCondiciones; 
	    querySelect.setInt(1, condicion.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModEvalComp "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mod_eval_comp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhModEvalComp");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 

  public static List getModeloEvalCompeByCondicion(CondModEvalCab condicion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ModeloEvalCompe.NICKNAME,
             DBModeloEvalCompe.SELECT_BY_CONDICION,
             condicion,
             new ListObserver(),
             aSesion);
  }
  
  public static ModeloEvalCompe getModeloEvalCompe(
		  CondModEvalCab condModEvalCab,
		  Competencia competencia,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CondModEvalCab.NICKNAME, condModEvalCab);
	  condiciones.put(Competencia.NICKNAME, competencia);
	  return (ModeloEvalCompe) ObjetoLogico.getObjects(ModeloEvalCompe.NICKNAME,
			  				DBModeloEvalCompe.SELECT_BY_COND_COMPE,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
