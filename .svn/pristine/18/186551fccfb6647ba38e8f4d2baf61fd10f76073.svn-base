package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluidoSincro;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.da.DBPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBIndividuoExcluidoSincro extends DBObjetoPersistente {

  public static final String OID_SINCRO_EXC = "oid_sincro_exc";
  public static final String NRO_LOTE = "nro_lote";
  public static final String ID_CLIENTE = "id_cliente";
  public static final String ESTADO_NRO = "estado_nro";
  public static final String MOTIVO = "motivo";
  public static final String COLOR_ESTADO = "color_estado";
  public static final String OBS_PRINCIPAL = "obs_principal";
  public static final String PERIODO = "periodo";
  public static final String NRO_DOCUMENTO = "nro_documento";
  public static final String TIPO_DOCUMENTO = "tipo_documento";
  public static final String APE_Y_NOM = "ape_y_nom";
  public static final String FOTO1 = "foto1";
  public static final String FOTO2 = "foto2";
  public static final String FOTO3 = "foto3";
  public static final String ID_ESTADO = "id_estado";
  public static final String ID_PELIGROSIDAD = "id_peligrosidad";
  public static final String COLOR_PELIGROSIDAD = "color_peligrosidad";
  public static final String ID_RAZA = "id_raza";
  public static final String ID_ALTURA = "id_altura";
  public static final String ID_COMPLEXION = "id_complexion";
  public static final String ID_EDAD = "id_edad";
  public static final String ID_COLOR_CABELLO = "id_color_cabello";
  public static final String ID_SEXO = "id_sexo";
  public static final String NRO_ORDEN_1 = "nro_orden_1";
  public static final String NRO_ORDEN_2 = "nro_orden_2";
  public static final String NRO_VERSION_FOTO_1 = "nro_version_foto_1";
  public static final String NRO_VERSION_FOTO_2 = "nro_version_foto_2";
  public static final String NRO_VERSION_FOTO_3 = "nro_version_foto_3";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_NRO_LOTE   = 100;
  
  public DBIndividuoExcluidoSincro() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SINCRO_EXC = 1;
    final int NRO_LOTE = 2;
    final int ID_CLIENTE = 3;
    final int ESTADO_NRO = 4;
    final int MOTIVO = 5;
    final int COLOR_ESTADO = 6;
    final int OBS_PRINCIPAL = 7;
    final int PERIODO = 8;
    final int NRO_DOCUMENTO = 9;
    final int TIPO_DOCUMENTO = 10;
    final int APE_Y_NOM = 11;
    final int FOTO1 = 12;
    final int FOTO2 = 13;
    final int FOTO3 = 14;
    final int ID_ESTADO = 15;
    final int ID_PELIGROSIDAD = 16;
    final int COLOR_PELIGROSIDAD = 17;
    final int ID_RAZA = 18;
    final int ID_ALTURA = 19;
    final int ID_COMPLEXION = 20;
    final int ID_EDAD = 21;
    final int ID_COLOR_CABELLO = 22;
    final int ID_SEXO = 23;
    final int NRO_ORDEN_1 = 24;
    final int NRO_ORDEN_2 = 25;
    final int NRO_VERSION_FOTO_1 = 26;
    final int NRO_VERSION_FOTO_2 = 27;
    final int NRO_VERSION_FOTO_3 = 28;
    final int ACTIVO = 29;

    IndividuoExcluidoSincro pers = (IndividuoExcluidoSincro) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excIndiExcSincro "+
                     " ( "+
                      "OID_SINCRO_EXC,"+
                      "NRO_LOTE,"+
                      "ID_CLIENTE,"+
                      "ESTADO_NRO,"+
                      "MOTIVO,"+
                      "COLOR_ESTADO,"+
                      "OBS_PRINCIPAL,"+
                      "PERIODO,"+
                      "NRO_DOCUMENTO,"+
                      "TIPO_DOCUMENTO,"+
                      "APE_Y_NOM,"+
                      "FOTO1,"+
                      "FOTO2,"+
                      "FOTO3,"+
                      "ID_ESTADO,"+
                      "ID_PELIGROSIDAD,"+
                      "COLOR_PELIGROSIDAD,"+
                      "ID_RAZA,"+
                      "ID_ALTURA,"+
                      "ID_COMPLEXION,"+
                      "ID_EDAD,"+
                      "ID_COLOR_CABELLO,"+
                      "ID_SEXO,"+
                      "NRO_ORDEN_1,"+
                      "NRO_ORDEN_2,"+
                      "NRO_VERSION_FOTO_1,"+
                      "NRO_VERSION_FOTO_2,"+
                      "NRO_VERSION_FOTO_3,"+
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
    qInsert.setInt(OID_SINCRO_EXC,pers.getOID());
    qInsert.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qInsert.setString(ID_CLIENTE,pers.getId_cliente());
    qInsert.setString(ESTADO_NRO,pers.getEstado_nro());
    qInsert.setString(MOTIVO,pers.getMotivo());
    qInsert.setString(COLOR_ESTADO,pers.getColor_estado());
    qInsert.setString(OBS_PRINCIPAL,pers.getObs_principal());
    qInsert.setString(PERIODO,pers.getPeriodo());
    qInsert.setString(NRO_DOCUMENTO,pers.getNro_documento());
    qInsert.setString(TIPO_DOCUMENTO,pers.getTipo_documento());
    qInsert.setString(APE_Y_NOM,pers.getApe_y_nom());
    qInsert.setString(FOTO1,pers.getFoto1());
    qInsert.setString(FOTO2,pers.getFoto2());
    qInsert.setString(FOTO3,pers.getFoto3());
    qInsert.setString(ID_ESTADO,pers.getId_estado());
    qInsert.setString(ID_PELIGROSIDAD,pers.getId_peligrosidad());
    qInsert.setString(COLOR_PELIGROSIDAD,pers.getColor_peligrosidad());
    qInsert.setString(ID_RAZA,pers.getId_raza());
    qInsert.setString(ID_ALTURA,pers.getId_altura());
    qInsert.setString(ID_COMPLEXION,pers.getId_complexion());
    qInsert.setString(ID_EDAD,pers.getId_edad());
    qInsert.setString(ID_COLOR_CABELLO,pers.getId_color_cabello());
    qInsert.setString(ID_SEXO,pers.getId_sexo());
    qInsert.setString(NRO_ORDEN_1,pers.getNro_orden_1());
    qInsert.setString(NRO_ORDEN_2,pers.getNro_orden_2());
    qInsert.setString(NRO_VERSION_FOTO_1,pers.getNro_version_foto_1());
    qInsert.setString(NRO_VERSION_FOTO_2,pers.getNro_version_foto_2());
    qInsert.setString(NRO_VERSION_FOTO_3,pers.getNro_version_foto_3());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NRO_LOTE = 1;
    final int ID_CLIENTE = 2;
    final int ESTADO_NRO = 3;
    final int MOTIVO = 4;
    final int COLOR_ESTADO = 5;
    final int OBS_PRINCIPAL = 6;
    final int PERIODO = 7;
    final int NRO_DOCUMENTO = 8;
    final int TIPO_DOCUMENTO = 9;
    final int APE_Y_NOM = 10;
    final int FOTO1 = 11;
    final int FOTO2 = 12;
    final int FOTO3 = 13;
    final int ID_ESTADO = 14;
    final int ID_PELIGROSIDAD = 15;
    final int COLOR_PELIGROSIDAD = 16;
    final int ID_RAZA = 17;
    final int ID_ALTURA = 18;
    final int ID_COMPLEXION = 19;
    final int ID_EDAD = 20;
    final int ID_COLOR_CABELLO = 21;
    final int ID_SEXO = 22;
    final int NRO_ORDEN_1 = 23;
    final int NRO_ORDEN_2 = 24;
    final int NRO_VERSION_FOTO_1 = 25;
    final int NRO_VERSION_FOTO_2 = 26;
    final int NRO_VERSION_FOTO_3 = 27;
    final int ACTIVO = 28;
    final int OID_SINCRO_EXC = 29;

    IndividuoExcluidoSincro pers = (IndividuoExcluidoSincro) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excIndiExcSincro set "+
              "nro_lote=?"+ 
              ",id_cliente=?"+ 
              ",estado_nro=?"+ 
              ",motivo=?"+ 
              ",color_estado=?"+ 
              ",obs_principal=?"+ 
              ",periodo=?"+ 
              ",nro_documento=?"+ 
              ",tipo_documento=?"+ 
              ",ape_y_nom=?"+ 
              ",foto1=?"+ 
              ",foto2=?"+ 
              ",foto3=?"+ 
              ",id_estado=?"+ 
              ",id_peligrosidad=?"+ 
              ",color_peligrosidad=?"+ 
              ",id_raza=?"+ 
              ",id_altura=?"+ 
              ",id_complexion=?"+ 
              ",id_edad=?"+ 
              ",id_color_cabello=?"+ 
              ",id_sexo=?"+ 
              ",nro_orden_1=?"+ 
              ",nro_orden_2=?"+ 
              ",nro_version_foto_1=?"+ 
              ",nro_version_foto_2=?"+ 
              ",nro_version_foto_3=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_sincro_exc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SINCRO_EXC,pers.getOID());
    qUpdate.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qUpdate.setString(ID_CLIENTE,pers.getId_cliente());
    qUpdate.setString(ESTADO_NRO,pers.getEstado_nro());
    qUpdate.setString(MOTIVO,pers.getMotivo());
    qUpdate.setString(COLOR_ESTADO,pers.getColor_estado());
    qUpdate.setString(OBS_PRINCIPAL,pers.getObs_principal());
    qUpdate.setString(PERIODO,pers.getPeriodo());
    qUpdate.setString(NRO_DOCUMENTO,pers.getNro_documento());
    qUpdate.setString(TIPO_DOCUMENTO,pers.getTipo_documento());
    qUpdate.setString(APE_Y_NOM,pers.getApe_y_nom());
    qUpdate.setString(FOTO1,pers.getFoto1());
    qUpdate.setString(FOTO2,pers.getFoto2());
    qUpdate.setString(FOTO3,pers.getFoto3());
    qUpdate.setString(ID_ESTADO,pers.getId_estado());
    qUpdate.setString(ID_PELIGROSIDAD,pers.getId_peligrosidad());
    qUpdate.setString(COLOR_PELIGROSIDAD,pers.getColor_peligrosidad());
    qUpdate.setString(ID_RAZA,pers.getId_raza());
    qUpdate.setString(ID_ALTURA,pers.getId_altura());
    qUpdate.setString(ID_COMPLEXION,pers.getId_complexion());
    qUpdate.setString(ID_EDAD,pers.getId_edad());
    qUpdate.setString(ID_COLOR_CABELLO,pers.getId_color_cabello());
    qUpdate.setString(ID_SEXO,pers.getId_sexo());
    qUpdate.setString(NRO_ORDEN_1,pers.getNro_orden_1());
    qUpdate.setString(NRO_ORDEN_2,pers.getNro_orden_2());
    qUpdate.setString(NRO_VERSION_FOTO_1,pers.getNro_version_foto_1());
    qUpdate.setString(NRO_VERSION_FOTO_2,pers.getNro_version_foto_2());
    qUpdate.setString(NRO_VERSION_FOTO_3,pers.getNro_version_foto_3());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SINCRO_EXC = 1; 
    IndividuoExcluidoSincro pers = (IndividuoExcluidoSincro) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excIndiExcSincro "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_sincro_exc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SINCRO_EXC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SINCRO_EXC = 1; 
    IndividuoExcluidoSincro pers = (IndividuoExcluidoSincro) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excIndiExcSincro "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sincro_exc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SINCRO_EXC, pers.getOID()); 
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
      case SELECT_BY_NRO_LOTE: {
          ps = this.selectByNroLote(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SINCRO_EXC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excIndiExcSincro "); 
    textSQL.append(" WHERE oid_sincro_exc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SINCRO_EXC, oid); 
    return querySelect; 
  }
  

  private PreparedStatement selectByNroLote(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excIndiExcSincro "); 
	    textSQL.append(" WHERE nro_lote = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    Integer nroLote = (Integer) aCondiciones;
	    querySelect.setInt(1, nroLote.intValue()); 
	    return querySelect; 
  }
  
  
	
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excIndiExcSincro "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sincro_exc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excIndiExcSincro");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getIndiSincroByNroLote(
		  Integer nroLote,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(IndividuoExcluidoSincro.NICKNAME,
             DBIndividuoExcluidoSincro.SELECT_BY_NRO_LOTE,
             nroLote,
             new ListObserver(),
             aSesion);
  }
  
  
} 
