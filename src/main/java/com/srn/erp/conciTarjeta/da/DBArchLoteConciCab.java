package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBArchLoteConciCab extends DBObjetoPersistente {

  public static final String OID_ARCH_LOT_CAB = "oid_arch_lot_cab";
  public static final String ESTADO = "estado";
  public static final String PROVEEDOR_HOST = "proveedor_host";
  public static final String NRO_HOST = "nro_host";
  public static final String NOM_HOST = "nom_host";
  public static final String NRO_LOTE = "nro_lote";
  public static final String CANT_TRANSAC = "cant_transac";
  public static final String NRO_TERMINAL = "nro_terminal";
  public static final String ANIO = "anio";
  public static final String ACTIVO = "activo";
  public static final String MES = "mes";
  public static final String ARCHIVO = "archivo";
  public static final String FEC_CREACION = "fec_creacion";
  public static final String DIA = "dia";
  public static final String FEC_IMPORTACION = "fec_importacion";
  public static final String HORA_IMPORTACION = "hora_importacion";
  public static final String FEC_CIERRE = "fec_cierre";
  public static final String OID_EMPRESA = "oid_empresa";
  
  public static final int SELECT_BY_EXISTE_CABECERA = 100;
  public static final int SELECT_ULT_ARCH_IMPORTADOS = 101;
  public static final int SELECT_BY_EMPRESA_FEC_DESDE_HASTA = 102;

  public DBArchLoteConciCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ARCH_LOT_CAB = 1;
    final int ESTADO = 2;
    final int PROVEEDOR_HOST = 3;
    final int NRO_HOST = 4;
    final int NOM_HOST = 5;
    final int NRO_LOTE = 6;
    final int CANT_TRANSAC = 7;
    final int NRO_TERMINAL = 8;
    final int ANIO = 9;
    final int ACTIVO = 10;
    final int MES = 11;
    final int ARCHIVO = 12;
    final int FEC_CREACION = 13;
    final int DIA = 14;
    final int FEC_IMPORTACION = 15;
    final int HORA_IMPORTACION = 16;
    final int FEC_CIERRE = 17;
    final int OID_EMPRESA = 18;

    ArchLoteConciCab pers = (ArchLoteConciCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarArchLotCab "+
                     " ( "+
                      "OID_ARCH_LOT_CAB,"+
                      "ESTADO,"+
                      "PROVEEDOR_HOST,"+
                      "NRO_HOST,"+
                      "NOM_HOST,"+
                      "NRO_LOTE,"+
                      "CANT_TRANSAC,"+
                      "NRO_TERMINAL,"+
                      "ANIO,"+
                      "ACTIVO,"+
                      "MES,"+
                      "ARCHIVO,"+
                      "FEC_CREACION,"+
                      "DIA,"+
                      "FEC_IMPORTACION,"+
                      "HORA_IMPORTACION,FEC_CIERRE,OID_EMPRESA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ARCH_LOT_CAB,pers.getOID());
    qInsert.setInt(ESTADO,pers.getEstado().intValue());
    qInsert.setString(PROVEEDOR_HOST,pers.getProveedor_host());
    qInsert.setString(NRO_HOST,pers.getNro_host());
    qInsert.setString(NOM_HOST,pers.getNom_host());
    qInsert.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qInsert.setInt(CANT_TRANSAC,pers.getCant_transac().intValue());
    qInsert.setString(NRO_TERMINAL,pers.getNro_terminal());
    qInsert.setInt(ANIO,pers.getAnio().intValue());
    qInsert.setInt(ACTIVO,pers.getActivo().intValue());
    qInsert.setInt(MES,pers.getMes().intValue());
    qInsert.setString(ARCHIVO,pers.getArchivo());
    qInsert.setDate(FEC_CREACION,new java.sql.Date(pers.getFec_creacion().getTime()));
    qInsert.setInt(DIA,pers.getDia().intValue());
    qInsert.setDate(FEC_IMPORTACION,new java.sql.Date(pers.getFec_importacion().getTime()));
    qInsert.setString(HORA_IMPORTACION,pers.getHora_importacion());
    qInsert.setDate(FEC_CIERRE,new java.sql.Date(pers.getFec_cierre().getTime()));
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ESTADO = 1;
    final int PROVEEDOR_HOST = 2;
    final int NRO_HOST = 3;
    final int NOM_HOST = 4;
    final int NRO_LOTE = 5;
    final int CANT_TRANSAC = 6;
    final int NRO_TERMINAL = 7;
    final int ANIO = 8;
    final int ACTIVO = 9;
    final int MES = 10;
    final int ARCHIVO = 11;
    final int FEC_CREACION = 12;
    final int DIA = 13;
    final int FEC_IMPORTACION = 14;
    final int HORA_IMPORTACION = 15;
    final int FEC_CIERRE = 16;
    final int OID_EMPRESA = 17;
    final int OID_ARCH_LOT_CAB = 18;

    ArchLoteConciCab pers = (ArchLoteConciCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarArchLotCab set "+
              "estado=?"+ 
              ",proveedor_host=?"+ 
              ",nro_host=?"+ 
              ",nom_host=?"+ 
              ",nro_lote=?"+ 
              ",cant_transac=?"+ 
              ",nro_terminal=?"+ 
              ",anio=?"+ 
              ",activo=?"+ 
              ",mes=?"+ 
              ",archivo=?"+ 
              ",fec_creacion=?"+ 
              ",dia=?"+ 
              ",fec_importacion=?"+ 
              ",hora_importacion=?"+ 
              ",fec_cierre=?"+
              ",oid_empresa=?"+
                 " where " +
                 " oid_arch_lot_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ARCH_LOT_CAB,pers.getOID());
    qUpdate.setInt(ESTADO,pers.getEstado().intValue());
    qUpdate.setString(PROVEEDOR_HOST,pers.getProveedor_host());
    qUpdate.setString(NRO_HOST,pers.getNro_host());
    qUpdate.setString(NOM_HOST,pers.getNom_host());
    qUpdate.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qUpdate.setInt(CANT_TRANSAC,pers.getCant_transac().intValue());
    qUpdate.setString(NRO_TERMINAL,pers.getNro_terminal());
    qUpdate.setInt(ANIO,pers.getAnio().intValue());
    qUpdate.setInt(ACTIVO,pers.getActivo().intValue());
    qUpdate.setInt(MES,pers.getMes().intValue());
    qUpdate.setString(ARCHIVO,pers.getArchivo());
    qUpdate.setDate(FEC_CREACION,new java.sql.Date(pers.getFec_creacion().getTime()));
    qUpdate.setInt(DIA,pers.getDia().intValue());
    qUpdate.setDate(FEC_IMPORTACION,new java.sql.Date(pers.getFec_importacion().getTime()));
    qUpdate.setString(HORA_IMPORTACION,pers.getHora_importacion());
    qUpdate.setDate(FEC_CIERRE,new java.sql.Date(pers.getFec_cierre().getTime()));
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ARCH_LOT_CAB = 1; 
    ArchLoteConciCab pers = (ArchLoteConciCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarArchLotCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_arch_lot_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ARCH_LOT_CAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ARCH_LOT_CAB = 1; 
    ArchLoteConciCab pers = (ArchLoteConciCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarArchLotCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_arch_lot_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ARCH_LOT_CAB, pers.getOID()); 
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
      case SELECT_BY_EXISTE_CABECERA : {
          ps = this.selectByExisteCabecera(aCondiciones); 
          break;    	  
      }
      case SELECT_ULT_ARCH_IMPORTADOS: {
          ps = this.selectUltArchImportados(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_EMPRESA_FEC_DESDE_HASTA: {
          ps = this.selectByEmpresaFecDesdeHasta(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectByEmpresaFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM cTarArchLotCab "); 
	    textSQL.append(" WHERE fec_importacion>=? and fec_importacion<=? and oid_empresa=? and activo=1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    java.util.Date fecDesdeImp = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fecHastaImp = (java.util.Date) condiciones.get("FEC_HASTA");
	    querySelect.setDate(1, new java.sql.Date(fecDesdeImp.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHastaImp.getTime()));
	    querySelect.setInt(3, empresa.getOID());
	    return querySelect;
  }  
  
  
  private PreparedStatement selectUltArchImportados(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarArchLotCab "); 
	    textSQL.append(" WHERE fec_cierre>=? and oid_empresa=? and activo=1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Integer dias = (Integer) condiciones.get("DIAS");
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    java.util.Date fecDesdeImp =
	    	Fecha.getFechaMasDias(UtilCIP.getFechaHoraActual(this.getSesion()), dias.intValue()*-1);
	    querySelect.setDate(1, new java.sql.Date(fecDesdeImp.getTime()));
	    querySelect.setInt(2, empresa.getOID());
	    return querySelect;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ARCH_LOT_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarArchLotCab "); 
    textSQL.append(" WHERE oid_arch_lot_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ARCH_LOT_CAB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarArchLotCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByExisteCabecera(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarArchLotCab "); 
	    textSQL.append(" WHERE "); 
	    textSQL.append("  nro_lote=? ");
	    textSQL.append("  and nro_terminal=? ");
	    textSQL.append("  and anio=? ");
	    textSQL.append("  and mes=? ");
	    textSQL.append("  and activo=1 ");
	    textSQL.append("  and archivo=? ");
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Integer nroLote = (Integer) condiciones.get("NRO_LOTE");
	    String nroTerminal = (String) condiciones.get("NRO_TERMINAL");
	    Integer anio = (Integer) condiciones.get("ANIO");
	    Integer mes = (Integer) condiciones.get("MES");
	    querySelect.setInt(1, nroLote.intValue());
	    querySelect.setString(2, nroTerminal);
	    querySelect.setInt(3, anio);
	    querySelect.setInt(4, mes);
	    querySelect.setString(5, (String) condiciones.get("ARCHIVO"));
	    return querySelect;
	    
	  }  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_arch_lot_cab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarArchLotCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static ArchLoteConciCab getArchivoCabecera(
		  Integer nroLote,
		  String nroTerminal,
		  Integer anio,
		  Integer mes,
		  String archivo,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("NRO_LOTE", nroLote);
	  condiciones.put("NRO_TERMINAL", nroTerminal);
	  condiciones.put("ANIO", anio);
	  condiciones.put("MES", mes);
	  condiciones.put("ARCHIVO", archivo);
	  
	  return (ArchLoteConciCab) ObjetoLogico.getObjects(ArchLoteConciCab.NICKNAME,
			  				DBArchLoteConciCab.SELECT_BY_EXISTE_CABECERA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getUltimosArchImportados(EmpresaConciTar empresa,Integer dias,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("DIAS", dias);
	  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
	  
	  return (List) ObjetoLogico.getObjects(ArchLoteConciCab.NICKNAME,
             DBArchLoteConciCab.SELECT_ULT_ARCH_IMPORTADOS,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getArchLoteDet(EmpresaConciTar empresa,java.util.Date fecDesde, java.util.Date fecHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);
	  
	  return (List) ObjetoLogico.getObjects(ArchLoteConciCab.NICKNAME,
             DBArchLoteConciCab.SELECT_BY_EMPRESA_FEC_DESDE_HASTA,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
