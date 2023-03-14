package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDefinicionRepositorioReal extends DBObjetoPersistente {

  public static final String OID_REPO_DET = "oid_repo_det";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_REPO_REAL = "oid_repo_real";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String OID_TIPO_PERI = "oid_tipo_peri";
  public static final String OID_METRICA = "oid_metrica";
  public static final String ORDEN = "orden";
  public static final String TIPO = "tipo";
  public static final String ACTIVO = "activo";
  public static final String OBLIGATORIO = "obligatorio";
  
  public static final int SELECT_BY_REPO_REAL = 100;

  public DBDefinicionRepositorioReal() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REPO_DET = 1;
    final int DESCRIPCION = 2;
    final int OID_REPO_REAL = 3;
    final int OID_COMPO_PRESU = 4;
    final int OID_TIPO_PERI = 5;
    final int OID_METRICA = 6;
    final int ORDEN = 7;
    final int TIPO = 8;
    final int ACTIVO = 9;
    final int OBLIGATORIO = 10;

    DefinicionRepositorioReal pers = (DefinicionRepositorioReal) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plRepoRealDet "+
                     " ( "+
                      "OID_REPO_DET,"+
                      "DESCRIPCION,"+
                      "OID_REPO_REAL,"+
                      "OID_COMPO_PRESU,"+
                      "OID_TIPO_PERI,"+
                      "OID_METRICA,"+
                      "ORDEN,"+
                      "TIPO,"+
                      "ACTIVO,"+
                      "OBLIGATORIO)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_REPO_DET,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_REPO_REAL,pers.getRepositorio_real().getOID());
    if (pers.getCompo_presupuestario()!=null) 
      qInsert.setInt(OID_COMPO_PRESU,pers.getCompo_presupuestario().getOID());
    else
      qInsert.setNull(OID_COMPO_PRESU,java.sql.Types.INTEGER);
    if (pers.getTipo_periodo()!=null) 
      qInsert.setInt(OID_TIPO_PERI,pers.getTipo_periodo().getOID());
    else
      qInsert.setNull(OID_TIPO_PERI,java.sql.Types.INTEGER);
    if (pers.getMetrica()!=null) 
      qInsert.setInt(OID_METRICA,pers.getMetrica().getOID());
    else
      qInsert.setNull(OID_METRICA,java.sql.Types.INTEGER);
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(OBLIGATORIO,pers.isObligatorio());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int OID_REPO_REAL = 2;
    final int OID_COMPO_PRESU = 3;
    final int OID_TIPO_PERI = 4;
    final int OID_METRICA = 5;
    final int ORDEN = 6;
    final int TIPO = 7;
    final int ACTIVO = 8;
    final int OBLIGATORIO = 9;
    final int OID_REPO_DET = 10;

    DefinicionRepositorioReal pers = (DefinicionRepositorioReal) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plRepoRealDet set "+
              "descripcion=?"+ 
              ",oid_repo_real=?"+ 
              ",oid_compo_presu=?"+ 
              ",oid_tipo_peri=?"+ 
              ",oid_metrica=?"+ 
              ",orden=?"+ 
              ",tipo=?"+ 
              ",activo=?"+
              ",obligatorio=?"+ 
                 " where " +
                 " oid_repo_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REPO_DET,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_REPO_REAL,pers.getRepositorio_real().getOID());
    if (pers.getCompo_presupuestario()!=null) 
      qUpdate.setInt(OID_COMPO_PRESU,pers.getCompo_presupuestario().getOID());
    else
      qUpdate.setNull(OID_COMPO_PRESU,java.sql.Types.INTEGER);
    if (pers.getTipo_periodo()!=null) 
      qUpdate.setInt(OID_TIPO_PERI,pers.getTipo_periodo().getOID());
    else
      qUpdate.setNull(OID_TIPO_PERI,java.sql.Types.INTEGER);
    if (pers.getMetrica()!=null) 
      qUpdate.setInt(OID_METRICA,pers.getMetrica().getOID());
    else
      qUpdate.setNull(OID_METRICA,java.sql.Types.INTEGER);
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(OBLIGATORIO,pers.isObligatorio());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REPO_DET = 1; 
    DefinicionRepositorioReal pers = (DefinicionRepositorioReal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from plRepoRealDet "+
                     " where " + 
                     " oid_repo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REPO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REPO_DET = 1; 
    DefinicionRepositorioReal pers = (DefinicionRepositorioReal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plRepoRealDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_repo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REPO_DET, pers.getOID()); 
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
      case SELECT_BY_REPO_REAL: {
        ps = this.selectByRepoReal(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REPO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plRepoRealDet "); 
    textSQL.append(" WHERE oid_repo_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REPO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRepoReal(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    // El ordenamiento es para generar un mismo orden de lectura
    textSQL.append("SELECT * FROM  plRepoRealDet "); 
    textSQL.append(" WHERE oid_repo_real = ? order by oid_repo_det ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    RepositorioReal repositorioReal = (RepositorioReal) aCondiciones; 
    querySelect.setInt(1, repositorioReal.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plRepoRealDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_repo_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plRepoRealDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getDefinicionesRepoReal(RepositorioReal repoReal,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(DefinicionRepositorioReal.NICKNAME,
         DBDefinicionRepositorioReal.SELECT_BY_REPO_REAL,
         repoReal,
         new ListObserver(),
         aSesion);
 }
  
  
} 
