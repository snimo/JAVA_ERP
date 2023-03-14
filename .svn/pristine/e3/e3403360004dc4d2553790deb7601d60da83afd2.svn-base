package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBNodoEstructuraPlanificacion extends DBObjetoPersistente {

  public static final String OID_NODO_ESTRUC = "oid_nodo_estruc";
  public static final String OID_ESTRUC_PLANIF = "oid_estruc_planif";
  public static final String NRO_REL = "nro_rel";
  public static final String NRO_REL_PADRE = "nro_rel_padre";
  public static final String NOMBRE = "nombre";
  public static final String ANCHO = "ancho";
  public static final String ALTO = "alto";
  public static final String COLOR = "color";
  public static final String ORDEN = "orden";
  public static final String ALINEACION = "alineacion";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESTRUC_PLANIF = 100;

  public DBNodoEstructuraPlanificacion() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_NODO_ESTRUC = 1;
    final int OID_ESTRUC_PLANIF = 2;
    final int NRO_REL = 3;
    final int NRO_REL_PADRE = 4;
    final int NOMBRE = 5;
    final int ANCHO = 6;
    final int ALTO = 7;
    final int COLOR = 8;
    final int ORDEN = 9;
    final int ALINEACION = 10;
    final int ACTIVO = 11;

    NodoEstructuraPlanificacion pers = (NodoEstructuraPlanificacion) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plNodoEstrucPlanif "+
                     " ( "+
                      "OID_NODO_ESTRUC,"+
                      "OID_ESTRUC_PLANIF,"+
                      "NRO_REL,"+
                      "NRO_REL_PADRE,"+
                      "NOMBRE,"+
                      "ANCHO,"+
                      "ALTO,"+
                      "COLOR,"+
                      "ORDEN,"+
                      "ALINEACION,"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_NODO_ESTRUC,pers.getOID());
    qInsert.setInt(OID_ESTRUC_PLANIF,pers.getEstructura_planificacion().getOID());
    qInsert.setInt(NRO_REL,pers.getNro_relacion().intValue());
    if (pers.getNro_relacion_padre()!=null)
    	qInsert.setInt(NRO_REL_PADRE,pers.getNro_relacion_padre().intValue());
    else
    	qInsert.setNull(NRO_REL_PADRE,Types.INTEGER);
    if (pers.getNombre()!=null)
    	qInsert.setString(NOMBRE,pers.getNombre());
    else
    	qInsert.setNull(NOMBRE,Types.VARCHAR);
    if (pers.getAncho()!=null)
    	qInsert.setInt(ANCHO,pers.getAncho().intValue());
    else
    	qInsert.setInt(ANCHO,Types.INTEGER);
    if (pers.getAlto()!=null)
    	qInsert.setInt(ALTO,pers.getAlto().intValue());
    else
    	qInsert.setNull(ALTO,Types.INTEGER);
    if (pers.getColor()!=null)
    	qInsert.setInt(COLOR,pers.getColor().intValue());
    else
    	qInsert.setNull(COLOR,Types.INTEGER);
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    if (pers.getAlineacion()!=null)
    	qInsert.setString(ALINEACION,pers.getAlineacion());
    else
    	qInsert.setNull(ALINEACION,Types.VARCHAR);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_PLANIF = 1;
    final int NRO_REL = 2;
    final int NRO_REL_PADRE = 3;
    final int NOMBRE = 4;
    final int ANCHO = 5;
    final int ALTO = 6;
    final int COLOR = 7;
    final int ORDEN = 8;
    final int ALINEACION = 9;
    final int ACTIVO = 10;
    final int OID_NODO_ESTRUC = 11;

    NodoEstructuraPlanificacion pers = (NodoEstructuraPlanificacion) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plNodoEstrucPlanif set "+
              "oid_estruc_planif=?"+ 
              ",nro_rel=?"+ 
              ",nro_rel_padre=?"+ 
              ",nombre=?"+ 
              ",ancho=?"+ 
              ",alto=?"+ 
              ",color=?"+ 
              ",orden=?"+ 
              ",alineacion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_nodo_estruc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NODO_ESTRUC,pers.getOID());
    qUpdate.setInt(OID_ESTRUC_PLANIF,pers.getEstructura_planificacion().getOID());
    qUpdate.setInt(NRO_REL,pers.getNro_relacion().intValue());
    if (pers.getNro_relacion_padre()!=null)
    	qUpdate.setInt(NRO_REL_PADRE,pers.getNro_relacion_padre().intValue());
    else
    	qUpdate.setNull(NRO_REL_PADRE,Types.INTEGER);
    if (pers.getNombre()!=null)
    	qUpdate.setString(NOMBRE,pers.getNombre());
    else
    	qUpdate.setNull(NOMBRE,Types.VARCHAR);
    if (pers.getAncho()!=null)
    	qUpdate.setInt(ANCHO,pers.getAncho().intValue());
    else
    	qUpdate.setNull(ANCHO,Types.INTEGER);
    if (pers.getAlto()!=null)
    	qUpdate.setInt(ALTO,pers.getAlto().intValue());
    else
    	qUpdate.setNull(ALTO,Types.INTEGER);
    if (pers.getColor()!=null)
    	qUpdate.setInt(COLOR,pers.getColor().intValue());
    else
    	qUpdate.setNull(COLOR,Types.INTEGER);
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    if (pers.getAlineacion()!=null)
    	qUpdate.setString(ALINEACION,pers.getAlineacion());
    else
    	qUpdate.setNull(ALINEACION,Types.VARCHAR);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NODO_ESTRUC = 1; 
    NodoEstructuraPlanificacion pers = (NodoEstructuraPlanificacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plNodoEstrucPlanif "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_nodo_estruc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NODO_ESTRUC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NODO_ESTRUC = 1; 
    NodoEstructuraPlanificacion pers = (NodoEstructuraPlanificacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plNodoEstrucPlanif "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_nodo_estruc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NODO_ESTRUC, pers.getOID()); 
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
      case SELECT_BY_ESTRUC_PLANIF: {
        ps = this.selectByEstrucPlanif(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_NODO_ESTRUC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plNodoEstrucPlanif "); 
    textSQL.append(" WHERE oid_nodo_estruc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_NODO_ESTRUC, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plNodoEstrucPlanif "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_nodo_estruc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plNodoEstrucPlanif");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEstrucPlanif(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();
    EstructuraPlanificacion estruc = (EstructuraPlanificacion) aCondiciones;
    textSQL.append("SELECT * ");
    textSQL.append(" from plNodoEstrucPlanif where oid_estruc_planif = ? ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,estruc.getOID());
    return querySelect; 
  } 
  
  public static List getNodosEstructura(EstructuraPlanificacion estructura,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(NodoEstructuraPlanificacion.NICKNAME,
         DBNodoEstructuraPlanificacion.SELECT_BY_ESTRUC_PLANIF,
         estructura,
         new ListObserver(),
         aSesion);
  }
  
  
  
} 
