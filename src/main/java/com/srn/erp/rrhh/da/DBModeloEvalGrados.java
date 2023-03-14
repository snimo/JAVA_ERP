package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.rrhh.bm.ModeloEvalGrados;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBModeloEvalGrados extends DBObjetoPersistente {

  public static final String OID_MOV_EVA_GRADOS = "oid_mov_eva_grados";
  public static final String OID_MOD_EVAL_COMP = "oid_mod_eval_comp";
  public static final String NRO_GRADO = "nro_grado";
  public static final String DESC_GRADOS = "desc_grados";
  public static final String PESO = "peso";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_COMPETENCIA = 100;
  public static final int SELECT_BY_MODEVALCOMP_NROGRADO = 101;
  public static final int SELECY_BY_CONDMODELO_COMPE_NROGRADO = 102;

  public DBModeloEvalGrados() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOV_EVA_GRADOS = 1;
    final int OID_MOD_EVAL_COMP = 2;
    final int NRO_GRADO = 3;
    final int DESC_GRADOS = 4;
    final int PESO = 5;
    final int ACTIVO = 6;

    ModeloEvalGrados pers = (ModeloEvalGrados) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhModEvalGrados "+
                     " ( "+
                      "OID_MOV_EVA_GRADOS,"+
                      "OID_MOD_EVAL_COMP,"+
                      "NRO_GRADO,"+
                      "DESC_GRADOS,"+
                      "PESO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOV_EVA_GRADOS,pers.getOID());
    qInsert.setInt(OID_MOD_EVAL_COMP,pers.getModelo_evaluacion().getOID());
    qInsert.setInt(NRO_GRADO,pers.getNro_grado().intValue());
    qInsert.setString(DESC_GRADOS,pers.getDesc_grados());
    if (pers.getPeso()!=null)
    	qInsert.setDouble(PESO,pers.getPeso().doubleValue());
    else
    	qInsert.setDouble(PESO,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOD_EVAL_COMP = 1;
    final int NRO_GRADO = 2;
    final int DESC_GRADOS = 3;
    final int PESO = 4;
    final int ACTIVO = 5;
    final int OID_MOV_EVA_GRADOS = 6;

    ModeloEvalGrados pers = (ModeloEvalGrados) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhModEvalGrados set "+
              "oid_mod_eval_comp=?"+ 
              ",nro_grado=?"+ 
              ",desc_grados=?"+ 
              ",peso=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mov_eva_grados=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOV_EVA_GRADOS,pers.getOID());
    qUpdate.setInt(OID_MOD_EVAL_COMP,pers.getModelo_evaluacion().getOID());
    qUpdate.setInt(NRO_GRADO,pers.getNro_grado().intValue());
    qUpdate.setString(DESC_GRADOS,pers.getDesc_grados());
    if (pers.getPeso()!=null)
    	qUpdate.setDouble(PESO,pers.getPeso().doubleValue());
    else
    	qUpdate.setDouble(PESO,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOV_EVA_GRADOS = 1; 
    ModeloEvalGrados pers = (ModeloEvalGrados) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModEvalGrados "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mov_eva_grados=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOV_EVA_GRADOS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOV_EVA_GRADOS = 1; 
    ModeloEvalGrados pers = (ModeloEvalGrados) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModEvalGrados "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mov_eva_grados=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOV_EVA_GRADOS, pers.getOID()); 
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
      case SELECT_BY_COMPETENCIA: {
          ps = this.selectByCompetencia(aCondiciones); 
          break; 
      }
      case SELECT_BY_MODEVALCOMP_NROGRADO: {
          ps = this.selectByModeloValCompNroGrado(aCondiciones); 
          break; 
      }
      case SELECY_BY_CONDMODELO_COMPE_NROGRADO: {
          ps = this.selectByCondModeloCompeNroGrado(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOV_EVA_GRADOS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModEvalGrados "); 
    textSQL.append(" WHERE oid_mov_eva_grados = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOV_EVA_GRADOS, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCompetencia(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModEvalGrados "); 
	    textSQL.append(" WHERE oid_mod_eval_comp = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) aCondiciones; 
	    querySelect.setInt(1, modeloEvalCompe.getOID()); 
	    return querySelect;
  }
  
  private PreparedStatement selectByCondModeloCompeNroGrado(Object aCondiciones) throws BaseException, SQLException {
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  CondModEvalCab condModEvalCab = (CondModEvalCab) condiciones.get(CondModEvalCab.NICKNAME);
	  Competencia competencia = (Competencia) condiciones.get(Competencia.NICKNAME);
	  Integer nroGrado = (Integer) condiciones.get("NRO_GRADO");
	  
	  StringBuffer textSQL = new StringBuffer(); 
	  textSQL.append("SELECT a.* FROM  rhModEvalGrados a, rhModEvalComp b , rhCondModEval c  "); 
	  textSQL.append(" WHERE a.oid_mod_eval_comp = b.oid_mod_eval_comp and b.oid_cond_mod = c.oid_cond_mod and ");
	  textSQL.append(" a.activo = 1 and b.activo = 1 and c.activo = 1 and b.oid_cond_mod = ? and b.oid_competencia = ? and a.nro_grado = ? ");
	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	  querySelect.setInt(1, condModEvalCab.getOID()); 
	  querySelect.setInt(2, competencia.getOID());
	  querySelect.setInt(3, nroGrado.intValue());
	  return querySelect; 
	  
	  
  }
  

  private PreparedStatement selectByModeloValCompNroGrado(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModEvalGrados "); 
	    textSQL.append(" WHERE oid_mod_eval_comp  = ? and nro_grado = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) condiciones.get(ModeloEvalCompe.NICKNAME);
	    Integer nroGrado = (Integer) condiciones.get("NRO_GRADO");
	    querySelect.setInt(1, modeloEvalCompe.getOID()); 
	    querySelect.setInt(2, nroGrado.intValue());
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModEvalGrados "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mov_eva_grados oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhModEvalGrados");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGradosByCompetencia(ModeloEvalCompe modeloEvalCompe,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ModeloEvalGrados.NICKNAME,
             DBModeloEvalGrados.SELECT_BY_COMPETENCIA,
             modeloEvalCompe,
             new ListObserver(),
             aSesion);
  }
  
  public static ModeloEvalGrados getModeloEvalGrados(
		  ModeloEvalCompe modeloEvalCompe,
		  Integer nroGrado,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ModeloEvalCompe.NICKNAME, modeloEvalCompe);
	  condiciones.put("NRO_GRADO", nroGrado);
	  return (ModeloEvalGrados) ObjetoLogico.getObjects(ModeloEvalGrados.NICKNAME,
			  				DBModeloEvalGrados.SELECT_BY_MODEVALCOMP_NROGRADO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static ModeloEvalGrados getModeloEvalGrados(
		  CondModEvalCab condModEvalCab,
		  Competencia competencia,
		  Integer nroGrado,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CondModEvalCab.NICKNAME, condModEvalCab);
	  condiciones.put(Competencia.NICKNAME, competencia);
	  condiciones.put("NRO_GRADO", nroGrado);
	  return (ModeloEvalGrados) ObjetoLogico.getObjects(ModeloEvalGrados.NICKNAME,
			  				DBModeloEvalGrados.SELECY_BY_CONDMODELO_COMPE_NROGRADO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
