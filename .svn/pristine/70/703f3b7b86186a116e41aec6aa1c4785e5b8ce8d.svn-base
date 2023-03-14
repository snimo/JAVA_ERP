package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.ConcHabCateg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConcHabCateg extends DBObjetoPersistente {

  public static final String OID_CONC_HAB_CATEG = "oid_conc_hab_categ";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String CONCEPTO = "concepto";
  public static final String CATEGORIA = "oid_categoria";
  
  public static final int SELECT_BY_CATEGORIA = 100;

  public DBConcHabCateg() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_HAB_CATEG = 1;
    final int COMPORTAMIENTO = 2;
    final int CONCEPTO = 3;
    final int CATEGORIA = 4;

    ConcHabCateg pers = (ConcHabCateg) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuConcHabCateg "+
                     " ( "+
                      "OID_CONC_HAB_CATEG,"+
                      "COMPORTAMIENTO,"+
                      "CONCEPTO,"+
                      "OID_CATEGORIA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONC_HAB_CATEG,pers.getOID());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setString(CONCEPTO,pers.getConcepto());
    qInsert.setInt(CATEGORIA,pers.getOid_categoria().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int COMPORTAMIENTO = 1;
    final int CONCEPTO = 2;
    final int CATEGORIA = 3;
    final int OID_CONC_HAB_CATEG = 4;

    ConcHabCateg pers = (ConcHabCateg) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuConcHabCateg set "+
              "comportamiento=?"+ 
              ",concepto=?"+ 
              ",oid_categoria=?"+ 
                 " where " +
                 " oid_conc_hab_categ=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_HAB_CATEG,pers.getOID());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setString(CONCEPTO,pers.getConcepto());
    qUpdate.setInt(CATEGORIA,pers.getOid_categoria().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_HAB_CATEG = 1; 
    ConcHabCateg pers = (ConcHabCateg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from tuConcHabCateg "+
                     " where " + 
                     " oid_conc_hab_categ=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_HAB_CATEG, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_HAB_CATEG = 1; 
    ConcHabCateg pers = (ConcHabCateg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuConcHabCateg "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conc_hab_categ=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_HAB_CATEG, pers.getOID()); 
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
      case SELECT_BY_CATEGORIA: {
          ps = this.selectByCategoria(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONC_HAB_CATEG = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuConcHabCateg "); 
    textSQL.append(" WHERE oid_conc_hab_categ = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONC_HAB_CATEG, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCategoria(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuConcHabCateg "); 
	    textSQL.append(" WHERE oid_categoria = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CategoriaSujetoTurno categ = (CategoriaSujetoTurno) aCondiciones;  
	    querySelect.setInt(1, categ.getOID()); 
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuConcHabCateg "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_hab_categ oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuConcHabCateg");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConceptosHabCateg(CategoriaSujetoTurno categoria,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConcHabCateg.NICKNAME,
             DBConcHabCateg.SELECT_BY_CATEGORIA,
             categoria,
             new ListObserver(),
             aSesion);
  }
  
  
} 
