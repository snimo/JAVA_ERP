package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.GradoCompetencia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGradoCompetencia extends DBObjetoPersistente {

  public static final String OID_GRADO_COMPE = "oid_grado_compe";
  public static final String OID_COMPETENCIA = "oid_competencia";
  public static final String NRO_GRADO = "nro_grado";
  public static final String DESC_GRADOS = "desc_grados";
  public static final String PESO_TENTATIVO = "peso_tentativo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_COMPETENCIA = 100;

  public DBGradoCompetencia() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRADO_COMPE = 1;
    final int OID_COMPETENCIA = 2;
    final int NRO_GRADO = 3;
    final int DESC_GRADOS = 4;
    final int PESO_TENTATIVO = 5;
    final int ACTIVO = 6;

    GradoCompetencia pers = (GradoCompetencia) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhGradoCompetencia "+
                     " ( "+
                      "OID_GRADO_COMPE,"+
                      "OID_COMPETENCIA,"+
                      "NRO_GRADO,"+
                      "DESC_GRADOS,"+
                      "PESO_TENTATIVO,"+
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
    qInsert.setInt(OID_GRADO_COMPE,pers.getOID());
    qInsert.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qInsert.setInt(NRO_GRADO,pers.getNro_grado().intValue());
    qInsert.setString(DESC_GRADOS,pers.getDesc_grados());
    qInsert.setDouble(PESO_TENTATIVO,pers.getPeso_tentativo().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPETENCIA = 1;
    final int NRO_GRADO = 2;
    final int DESC_GRADOS = 3;
    final int PESO_TENTATIVO = 4;
    final int ACTIVO = 5;
    final int OID_GRADO_COMPE = 6;

    GradoCompetencia pers = (GradoCompetencia) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhGradoCompetencia set "+
              "oid_competencia=?"+ 
              ",nro_grado=?"+ 
              ",desc_grados=?"+ 
              ",peso_tentativo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grado_compe=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRADO_COMPE,pers.getOID());
    qUpdate.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qUpdate.setInt(NRO_GRADO,pers.getNro_grado().intValue());
    qUpdate.setString(DESC_GRADOS,pers.getDesc_grados());
    qUpdate.setDouble(PESO_TENTATIVO,pers.getPeso_tentativo().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRADO_COMPE = 1; 
    GradoCompetencia pers = (GradoCompetencia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhGradoCompetencia "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grado_compe=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRADO_COMPE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRADO_COMPE = 1; 
    GradoCompetencia pers = (GradoCompetencia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhGradoCompetencia "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grado_compe=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRADO_COMPE, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRADO_COMPE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhGradoCompetencia "); 
    textSQL.append(" WHERE oid_grado_compe = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRADO_COMPE, oid); 
    return querySelect; 
  }

  
  private PreparedStatement selectByCompetencia(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhGradoCompetencia "); 
	    textSQL.append(" WHERE oid_competencia = ? and activo = 1 order by nro_grado ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Competencia competencia = (Competencia) aCondiciones; 
	    querySelect.setInt(1, competencia.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhGradoCompetencia "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grado_compe oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhGradoCompetencia");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGradosCompetencias(Competencia competencia,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GradoCompetencia.NICKNAME,
             DBGradoCompetencia.SELECT_BY_COMPETENCIA,
             competencia,
             new ListObserver(),
             aSesion);
  }
  
  
} 
