package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.SubBien;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSubBien extends DBObjetoPersistente {

  public static final String OID_BIEN_ALTA = "oid_bien_alta";
  public static final String OID_BIEN_USO = "oid_bien_uso";
  public static final String NRO_ALTA = "nro_alta";
  public static final String DESCRIPCION = "descripcion";
  public static final String SIGUE_BIEN_PPAL = "sigue_bien_ppal";
  public static final String OID_PERI_INI_AMORT = "oid_peri_ini_amort";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_BIEN_USO = 100;
  
  public DBSubBien() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_ALTA = 1;
    final int OID_BIEN_USO = 2;
    final int NRO_ALTA = 3;
    final int DESCRIPCION = 4;
    final int SIGUE_BIEN_PPAL = 5;
    final int OID_PERI_INI_AMORT = 6;
    final int ACTIVO = 7;

    SubBien pers = (SubBien) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buBienAltas "+
                     " ( "+
                      "OID_BIEN_ALTA,"+
                      "OID_BIEN_USO,"+
                      "NRO_ALTA,"+
                      "DESCRIPCION,"+
                      "SIGUE_BIEN_PPAL,"+
                      "OID_PERI_INI_AMORT,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_BIEN_ALTA,pers.getOID());
    qInsert.setInt(OID_BIEN_USO,pers.getBien_uso().getOID());
    qInsert.setInt(NRO_ALTA,pers.getNro_alta().intValue());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(SIGUE_BIEN_PPAL,pers.isSigue_bien_ppal().booleanValue());
    qInsert.setInt(OID_PERI_INI_AMORT,pers.getPeri_ini_amort().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_USO = 1;
    final int NRO_ALTA = 2;
    final int DESCRIPCION = 3;
    final int SIGUE_BIEN_PPAL = 4;
    final int OID_PERI_INI_AMORT = 5;
    final int ACTIVO = 6;
    final int OID_BIEN_ALTA = 7;

    SubBien pers = (SubBien) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buBienAltas set "+
              "oid_bien_uso=?"+ 
              ",nro_alta=?"+ 
              ",descripcion=?"+ 
              ",sigue_bien_ppal=?"+ 
              ",oid_peri_ini_amort=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_bien_alta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_ALTA,pers.getOID());
    qUpdate.setInt(OID_BIEN_USO,pers.getBien_uso().getOID());
    qUpdate.setInt(NRO_ALTA,pers.getNro_alta().intValue());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(SIGUE_BIEN_PPAL,pers.isSigue_bien_ppal().booleanValue());
    qUpdate.setInt(OID_PERI_INI_AMORT,pers.getPeri_ini_amort().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_ALTA = 1; 
    SubBien pers = (SubBien) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBienAltas "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_bien_alta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_ALTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_ALTA = 1; 
    SubBien pers = (SubBien) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBienAltas "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_bien_alta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_ALTA, pers.getOID()); 
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
      case SELECT_BY_BIEN_USO: {
        ps = this.selectByBienUso(aCondiciones); 
        break; 
      }
      case SELECT_ALL: {
        ps = this.selectAll(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_BIEN_ALTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBienAltas "); 
    textSQL.append(" WHERE oid_bien_alta = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_BIEN_ALTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByBienUso(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienAltas "); 
	textSQL.append(" WHERE oid_bien_uso  = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	Bien bien = (Bien) aCondiciones; 
	querySelect.setInt(1, bien.getOID()); 
	return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  buBienAltas "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBienAltas "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_bien_alta oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buBienAltas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSubBienes(Bien aBien,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(SubBien.NICKNAME,
             DBSubBien.SELECT_BY_BIEN_USO,
             aBien,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getSubBienes(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(SubBien.NICKNAME,
             DBSubBien.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }  
  
} 
