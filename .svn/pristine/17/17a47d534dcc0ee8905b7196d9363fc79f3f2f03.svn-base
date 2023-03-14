package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.RemplesPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRemplesPayroll extends DBObjetoPersistente {

  public static final String OID_REMPLES = "oid_remples";
  public static final String EMPRESA = "empresa";
  public static final String CODIGO = "codigo";
  public static final String NOMBRE = "nombre";
  public static final String ESTADO = "estado";
  public static final String FECHA_ING = "fecha_ing";
  public static final String FECHA_RET = "fecha_ret";
  public static final String CENCOS = "cencos";
  public static final String ACTIVO = "activo";
  public static final String CREDENC = "credenc";
  public static final String CARGO = "cargo";
  
  public static final String RUT = "rut";
  public static final String SEXO = "sexo";
  public static final String DIRECCION = "direccion";
  public static final String EST_CIVIL = "est_civil";
  public static final String FECHA_NAC = "fecha_nac";
  public static final String TIPO_DOC = "tipo_doc";
  public static final String NUMDOC = "numdoc";
  public static final String FONO = "fono";
  public static final String CELULAR = "celular";
  public static final String CLASE = "clase";
  public static final String MOTI_RET = "moti_ret";
  public static final String FECHA_GRA = "fecha_gra";
  public static final String FECHA_ISA = "fecha_isa";
  public static final String FECHA_XTR = "fecha_xtr";
  public static final String GRADO = "grado";
  public static final String UBICA = "ubica";
  public static final String CLASIF = "clasif";
  public static final String CATEGO = "catego";
  public static final String CARGO_UNIFICADO = "cargo_unificado";
  public static final String SECCION = "seccion";
  
  
  
  
  
  public static final int TRUNCAR_TABLA_REMPLES = 100;

  public DBRemplesPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REMPLES = 1;
    final int EMPRESA = 2;
    final int CODIGO = 3;
    final int NOMBRE = 4;
    final int ESTADO = 5;
    final int FECHA_ING = 6;
    final int FECHA_RET = 7;
    final int CENCOS = 8;
    final int ACTIVO = 9;
    final int CREDENC = 10;
    final int CARGO = 11;
    
    final int RUT = 12;
    final int SEXO = 13;
    final int DIRECCION = 14;
    final int EST_CIVIL = 15;
    final int FECHA_NAC = 16;
    final int TIPO_DOC = 17;
    final int NUMDOC = 18;
    final int FONO = 19;
    final int CELULAR = 20;
    final int CLASE = 21;
    final int MOTI_RET = 22;
    final int FECHA_ARE = 23;
    final int FECHA_ISA = 24;
    final int FECHA_XTR = 25;
    final int GRADO = 26;
    final int UBICA = 27;
    final int CLASIF = 28;
    final int CATEGO = 29;
    final int CARGO_UNIFICADO = 30;
    final int SECCION = 31;
    

    RemplesPayroll pers = (RemplesPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into payRemples "+
                     " ( "+
                      "OID_REMPLES,"+
                      "EMPRESA,"+
                      "CODIGO,"+
                      "NOMBRE,"+
                      "ESTADO,"+
                      "FECHA_ING,"+
                      "FECHA_RET,"+
                      "CENCOS,"+
                      "ACTIVO,CREDENC,CARGO"+
                      ",RUT"+
                      ",SEXO"+
                      ",DIRECCION"+
                      ",EST_CIVIL"+
                      ",FECHA_NAC"+
                      ",TIPO_DOC"+
                      ",NUMDOC"+
                      ",FONO"+
                      ",CELULAR"+
                      ",CLASE"+
                      ",MOTI_RET"+
                      ",FECHA_ARE"+
                      ",FECHA_ISA"+
                      ",FECHA_XTR , GRADO , UBICA , CLASIF , CATEGO , CARGO_UNIFICADO , SECCION "+                     
                      ")"+
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
    qInsert.setInt(OID_REMPLES,pers.getOID());
    if (pers.getEmpresa()!=null)
    	qInsert.setString(EMPRESA,pers.getEmpresa());
    else
    	qInsert.setNull(EMPRESA,Types.VARCHAR);
    if (pers.getCodigo()!=null)
    	qInsert.setString(CODIGO,pers.getCodigo());
    else
    	qInsert.setNull(CODIGO,Types.VARCHAR);
    if (pers.getNombre()!=null)
    	qInsert.setString(NOMBRE,pers.getNombre());
    else
    	qInsert.setNull(NOMBRE,Types.VARCHAR);
    if (pers.getEstado()!=null)
    	qInsert.setString(ESTADO,pers.getEstado());
    else
    	qInsert.setNull(ESTADO,Types.VARCHAR);
    if (pers.getFecha_ing()!=null) 
      qInsert.setDate(FECHA_ING,new java.sql.Date(pers.getFecha_ing().getTime()));
    else
      qInsert.setNull(FECHA_ING,java.sql.Types.DATE);
    if (pers.getFecha_ret()!=null) 
      qInsert.setDate(FECHA_RET, new java.sql.Date(pers.getFecha_ret().getTime()));
    else
      qInsert.setNull(FECHA_RET,java.sql.Types.DATE);
    if (pers.getCencos()!=null)
    	qInsert.setInt(CENCOS,pers.getCencos().intValue());
    else
    	qInsert.setNull(CENCOS,Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCredenc()!=null)
    	qInsert.setString(CREDENC, pers.getCredenc());
    else
    	qInsert.setNull(CREDENC, Types.CHAR);
    qInsert.setInt(CARGO, pers.getCargo());
    
    if (pers.getRUT()!=null)
    	qInsert.setString(RUT, pers.getRUT());
    else
    	qInsert.setNull(RUT, Types.VARCHAR);
    
    if (pers.getSexo()!=null)
    	qInsert.setString(SEXO, pers.getSexo());
    else
    	qInsert.setNull(SEXO, Types.VARCHAR);
    
    if (pers.getDireccion()!=null)
    	qInsert.setString(DIRECCION, pers.getDireccion());
    else
    	qInsert.setNull(DIRECCION, Types.VARCHAR);

    if (pers.getEstadoCivil()!=null)
    	qInsert.setString(EST_CIVIL, pers.getEstadoCivil());
    else
    	qInsert.setNull(EST_CIVIL, Types.VARCHAR);
    
    if (pers.getFecNacimiento()!=null)
    	qInsert.setDate(FECHA_NAC, new java.sql.Date(pers.getFecNacimiento().getTime()));
    else
    	qInsert.setNull(FECHA_NAC, Types.DATE);
    
    if (pers.getTipoDocumento()!=null)
    	qInsert.setInt(TIPO_DOC, pers.getTipoDocumento().intValue());
    else
    	qInsert.setNull(TIPO_DOC, Types.INTEGER);
    
    if (pers.getNroDocumento()!=null)
    	qInsert.setString(NUMDOC, pers.getNroDocumento());
    else
    	qInsert.setNull(NUMDOC, Types.VARCHAR);
    
    if (pers.getTelParticular()!=null)
    	qInsert.setString(FONO, pers.getTelParticular());
    else
    	qInsert.setNull(FONO, Types.VARCHAR);

    if (pers.getCelParticular()!=null)
    	qInsert.setString(CELULAR, pers.getCelParticular());
    else
    	qInsert.setNull(CELULAR, Types.VARCHAR);
    
    if (pers.getClaseSindicato()!=null)
    	qInsert.setInt(CLASE, pers.getClaseSindicato());
    else
    	qInsert.setNull(CLASE, Types.INTEGER);
    
    if (pers.getMotivoEgresoEmp()!=null)
    	qInsert.setInt(MOTI_RET, pers.getMotivoEgresoEmp());
    else
    	qInsert.setNull(MOTI_RET, Types.INTEGER);

    if (pers.getFecAntReconocida()!=null)
    	qInsert.setDate(FECHA_ARE, new java.sql.Date(pers.getFecAntReconocida().getTime()));
    else
    	qInsert.setNull(FECHA_ARE, Types.DATE);
    
    if (pers.getFecVencProt()!=null)
    	qInsert.setDate(FECHA_ISA, new java.sql.Date(pers.getFecVencProt().getTime()));
    else
    	qInsert.setNull(FECHA_ISA, Types.DATE);
    
    if (pers.getFecIngUTE()!=null)
    	qInsert.setDate(FECHA_XTR, new java.sql.Date(pers.getFecIngUTE().getTime()));
    else
    	qInsert.setNull(FECHA_XTR, Types.DATE);
    
    if (pers.getGrado()!=null)
    	qInsert.setInt(GRADO, pers.getGrado());
    else
    	qInsert.setNull(GRADO, Types.INTEGER);
    
    if (pers.getUbica()!=null)
    	qInsert.setInt(UBICA, pers.getUbica().intValue());
    else
    	qInsert.setNull(UBICA, Types.INTEGER);    
    
    if (pers.getClasif()!=null)
    	qInsert.setInt(CLASIF, pers.getClasif().intValue());
    else
    	qInsert.setNull(CLASIF, Types.INTEGER);    
    
    if (pers.getCatego()!=null)
    	qInsert.setInt(CATEGO, pers.getCatego().intValue());
    else
    	qInsert.setNull(CATEGO, Types.INTEGER);    
    
    if (pers.getCargoUnificado()!=null)
    	qInsert.setInt(CARGO_UNIFICADO, pers.getCargoUnificado().intValue());
    else
    	qInsert.setNull(CARGO_UNIFICADO, Types.INTEGER);    
    
    if (pers.getSeccion()!=null)
    	qInsert.setInt(SECCION, pers.getSeccion().intValue());
    else
    	qInsert.setNull(SECCION, Types.INTEGER);    
    
        
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int EMPRESA = 1;
    final int CODIGO = 2;
    final int NOMBRE = 3;
    final int ESTADO = 4;
    final int FECHA_ING = 5;
    final int FECHA_RET = 6;
    final int CENCOS = 7;
    final int ACTIVO = 8;
    final int CREDENC = 9;
    final int CARGO = 10;    
    final int RUT = 11;
    final int SEXO = 12;
    final int DIRECCION = 13;
    final int EST_CIVIL = 14;
    final int FECHA_NAC = 15;
    final int TIPO_DOC = 16;
    final int NUMDOC = 17;
    final int FONO = 18;
    final int CELULAR = 19;
    final int CLASE = 20;
    final int MOTI_RET = 21;
    final int FECHA_ARE = 22;
    final int FECHA_ISA = 23;
    final int FECHA_XTR = 24;    
    final int GRADO = 25;
    final int UBICA = 26;
    final int CLASIF = 27;
    final int CATEGO = 28;
    final int CARGO_UNIFICADO = 29;
    final int SECCION = 30;
    final int OID_REMPLES = 31;

    RemplesPayroll pers = (RemplesPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update payRemples set "+
              "empresa=?"+ 
              ",codigo=?"+ 
              ",nombre=?"+ 
              ",estado=?"+ 
              ",fecha_ing=?"+ 
              ",fecha_ret=?"+ 
              ",cencos=?"+ 
              ",activo=?"+ 
              ",credenc=?"+
              ",cargo=?"+
              ",RUT=?"+
              ",SEXO=?"+
              ",DIRECCION=?"+
              ",EST_CIVIL=?"+
              ",FECHA_NAC=?"+
              ",TIPO_DOC=?"+
              ",NUMDOC=?"+
              ",FONO=?"+
              ",CELULAR=?"+
              ",CLASE=?"+
              ",MOTI_RET=?"+
              ",FECHA_ARE=?"+
              ",FECHA_ISA=?"+
              ",FECHA_XTR=? "+                     
              ",GRADO=? "+
              ",UBICA=? "+
              ",CLASIF=? "+
              ",CATEGO=? "+
              ",cargo_unificado=? "+
              ",seccion=? "+
                 " where " +
                 " oid_remples=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REMPLES,pers.getOID());
    if (pers.getEmpresa()!=null)
    	qUpdate.setString(EMPRESA,pers.getEmpresa());
    else
    	qUpdate.setNull(EMPRESA,Types.VARCHAR);
    if (pers.getCodigo()!=null)
    	qUpdate.setString(CODIGO,pers.getCodigo());
    else
    	qUpdate.setNull(CODIGO,Types.VARCHAR);
    if (pers.getNombre()!=null)
    	qUpdate.setString(NOMBRE,pers.getNombre());
    else
    	qUpdate.setNull(NOMBRE,Types.VARCHAR);
    if (pers.getEstado()!=null)
    	qUpdate.setString(ESTADO,pers.getEstado());
    else
    	qUpdate.setNull(ESTADO,Types.NULL);
    if (pers.getFecha_ing()!=null) 
      qUpdate.setDate(FECHA_ING,new java.sql.Date(pers.getFecha_ing().getTime()));
    else
      qUpdate.setNull(FECHA_ING,java.sql.Types.DATE);
    if (pers.getFecha_ret()!=null) 
      qUpdate.setDate(FECHA_RET,new java.sql.Date(pers.getFecha_ret().getTime()));
    else
      qUpdate.setNull(FECHA_RET,java.sql.Types.DATE);
    if (pers.getCencos()!=null)
    	qUpdate.setInt(CENCOS,pers.getCencos().intValue());
    else
    	qUpdate.setNull(CENCOS,Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCredenc()!=null)
    	qUpdate.setString(CREDENC, pers.getCredenc());
    else
    	qUpdate.setNull(CREDENC, Types.CHAR);
    qUpdate.setInt(CARGO, pers.getCargo());
    
    if (pers.getRUT()!=null)
    	qUpdate.setString(RUT, pers.getRUT());
    else
    	qUpdate.setNull(RUT, Types.VARCHAR);
    
    if (pers.getSexo()!=null)
    	qUpdate.setString(SEXO, pers.getSexo());
    else
    	qUpdate.setNull(SEXO, Types.VARCHAR);
    
    if (pers.getDireccion()!=null)
    	qUpdate.setString(DIRECCION, pers.getDireccion());
    else
    	qUpdate.setNull(DIRECCION, Types.VARCHAR);

    if (pers.getEstadoCivil()!=null)
    	qUpdate.setString(EST_CIVIL, pers.getEstadoCivil());
    else
    	qUpdate.setNull(EST_CIVIL, Types.VARCHAR);
    
    if (pers.getFecNacimiento()!=null)
    	qUpdate.setDate(FECHA_NAC, new java.sql.Date(pers.getFecNacimiento().getTime()));
    else
    	qUpdate.setNull(FECHA_NAC, Types.DATE);
    
    if (pers.getTipoDocumento()!=null)
    	qUpdate.setInt(TIPO_DOC, pers.getTipoDocumento().intValue());
    else
    	qUpdate.setNull(TIPO_DOC, Types.INTEGER);
    
    if (pers.getNroDocumento()!=null)
    	qUpdate.setString(NUMDOC, pers.getNroDocumento());
    else
    	qUpdate.setNull(NUMDOC, Types.VARCHAR);
    
    if (pers.getTelParticular()!=null)
    	qUpdate.setString(FONO, pers.getTelParticular());
    else
    	qUpdate.setNull(FONO, Types.VARCHAR);

    if (pers.getCelParticular()!=null)
    	qUpdate.setString(CELULAR, pers.getCelParticular());
    else
    	qUpdate.setNull(CELULAR, Types.VARCHAR);
    
    if (pers.getClaseSindicato()!=null)
    	qUpdate.setInt(CLASE, pers.getClaseSindicato());
    else
    	qUpdate.setNull(CLASE, Types.INTEGER);
    
    if (pers.getMotivoEgresoEmp()!=null)
    	qUpdate.setInt(MOTI_RET, pers.getMotivoEgresoEmp());
    else
    	qUpdate.setNull(MOTI_RET, Types.INTEGER);

    if (pers.getFecAntReconocida()!=null)
    	qUpdate.setDate(FECHA_ARE, new java.sql.Date(pers.getFecAntReconocida().getTime()));
    else
    	qUpdate.setNull(FECHA_ARE, Types.DATE);
    
    if (pers.getFecVencProt()!=null)
    	qUpdate.setDate(FECHA_ISA, new java.sql.Date(pers.getFecVencProt().getTime()));
    else
    	qUpdate.setNull(FECHA_ISA, Types.DATE);
    
    if (pers.getFecIngUTE()!=null)
    	qUpdate.setDate(FECHA_XTR, new java.sql.Date(pers.getFecIngUTE().getTime()));
    else
    	qUpdate.setNull(FECHA_XTR, Types.DATE);
    
    if (pers.getGrado()!=null)
    	qUpdate.setInt(GRADO, pers.getGrado());
    else
    	qUpdate.setNull(GRADO, Types.INTEGER);
    
    if (pers.getUbica()!=null)
    	qUpdate.setInt(UBICA, pers.getUbica().intValue());
    else
    	qUpdate.setNull(UBICA, Types.INTEGER); 
    
    if (pers.getClasif()!=null)
    	qUpdate.setInt(CLASIF, pers.getClasif().intValue());
    else
    	qUpdate.setNull(CLASIF, Types.INTEGER);    
    
    if (pers.getCatego()!=null)
    	qUpdate.setInt(CATEGO, pers.getCatego().intValue());
    else
    	qUpdate.setNull(CATEGO, Types.INTEGER);    
    
    if (pers.getCargoUnificado()!=null)
    	qUpdate.setInt(CARGO_UNIFICADO, pers.getCargoUnificado().intValue());
    else
    	qUpdate.setNull(CARGO_UNIFICADO, Types.INTEGER);
    
    if (pers.getSeccion()!=null)
    	qUpdate.setInt(SECCION, pers.getSeccion().intValue());
    else
    	qUpdate.setNull(SECCION, Types.INTEGER);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REMPLES = 1; 
    RemplesPayroll pers = (RemplesPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payRemples "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_remples=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REMPLES, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REMPLES = 1; 
    RemplesPayroll pers = (RemplesPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payRemples "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_remples=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REMPLES, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
      } 
      case TRUNCAR_TABLA_REMPLES: {
          ps = this.truncarTablaPayRemples(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REMPLES = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payRemples "); 
    textSQL.append(" WHERE oid_remples = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REMPLES, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  payRemples "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payRemples "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_remples oid,codigo codigo,  descripcion ,activo ");
    textSQL.append(" from payRemples");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement truncarTablaPayRemples(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payRemples ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
  }
  
  public static void truncarTablaRemplesPayroll(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(RemplesPayroll.NICKNAME,
		  				DBRemplesPayroll.TRUNCAR_TABLA_REMPLES,
		  				null,
		  				null,
		  				aSesion);
  }
  
  public static List getAll(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RemplesPayroll.NICKNAME,
             DBRemplesPayroll.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
