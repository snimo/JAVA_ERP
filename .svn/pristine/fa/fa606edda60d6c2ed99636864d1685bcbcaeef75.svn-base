package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ComproContaConsulta;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ValorCompo;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;

public class DBComproContaConsulta extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String EMISION = "emision";
  public static final String IMPUTAC = "imputac";
  public static final String COMENTARIO = "comentario";
  public static final String ANULADO = "anulado";
  public static final String TC      = "tc_ext";
  public static final String LETRA   = "letra";
  public static final String LUG_EMI = "lug_emi";
  public static final String NRO_EXT = "nro_ext";

  public static final int SELECT_BY_FILTROS_VARIOS = 100;

  public DBComproContaConsulta() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    ComproContaConsulta pers = (ComproContaConsulta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update ComproConta "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    ComproContaConsulta pers = (ComproContaConsulta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update ComproConta "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
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
      case SELECT_BY_FILTROS_VARIOS: {
        ps = this.selectByFiltrosVarios(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  ComproConta ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  ComproConta ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByFiltrosVarios(Object aCondiciones) throws BaseException, SQLException {

    java.util.Date fecImputacDesde  = null;
    java.util.Date fecImputacHasta  = null;
    Cuenta         cuenta           = null;
    Componente     componente       = null;
    ValorCompo     valorCompo       = null;
    ComproCab      comproCab        = null;
    TipoComprobante tipoComprobante = null;

    int cantParams = 0;

    MapDatos cond = (HashTableDatos) aCondiciones;

    if (cond.containsKey(ComproCab.NICKNAME))
      comproCab = (ComproCab) cond.get(ComproCab.NICKNAME) ;

    if (cond.containsKey(TipoComprobante.NICKNAME))
      tipoComprobante = (TipoComprobante) cond.get(TipoComprobante.NICKNAME) ;

    if ((cond.containsKey("fec_imputac_desde")) &&
       (cond.containsKey("fec_imputac_hasta"))) {
     fecImputacDesde = (java.util.Date) cond.get("fec_imputac_desde");
     fecImputacHasta = (java.util.Date) cond.get("fec_imputac_hasta");
    }

    if (cond.containsKey(Cuenta.NICKNAME))
      cuenta = (Cuenta) cond.get(Cuenta.NICKNAME) ;

    if (cond.containsKey(Componente.NICKNAME) &&
        cond.containsKey(ValorCompo.NICKNAME)) {
      componente = (Componente) cond.get(Componente.NICKNAME);
      valorCompo = (ValorCompo) cond.get(ValorCompo.NICKNAME);
    }

    StringBuffer textSQL = new StringBuffer();
    textSQL.append(" SELECT "+
                   "   a.oid_cco, "+
                   "   b.emision, "+
                   "   a.imputac,"+
                   "   b.comentario,"+
                   "   a.anulado,"+
                   "   b.tc_ext,"+
                   "   b.letra,"+
                   "   b.lug_emi,"+
                   "   b.nro_ext "+
                   " FROM  "+
                   "   cgComproConta a, geComproCab b ");

    textSQL.append(" WHERE  "+
                   "   a.oid_cco=b.oid_cco ");

    // Filtro: FECHA DESDE / FECHA HASTA
    if ((fecImputacDesde!=null) && (fecImputacHasta!=null)) {
      textSQL.append(" and a.imputac>=? and a.imputac<=? ");
      ++cantParams;
    }

    // Filtrar por CUENTA
    if (cuenta!=null) {
      textSQL.append(" and a.oid_cco in ( " +
                     "   select d.oid_cco from geComproCab d,cgComproConta e,cgComprocontaDet f, cgAnaImpCon g " +
                     "     where d.oid_cco = e.oid_cco and e.oid_cco = f.oid_cco and f.oid_ai = g.oid_ai " +
                     "     and g.oid_ana_con = " +
                     cuenta.getOIDInteger().toString() );

      if ((fecImputacDesde!=null) && (fecImputacHasta!=null)) {
        textSQL.append(" and e.imputac>=? and e.imputac<=? ");
        ++cantParams;
      }

      if (comproCab!=null)
         textSQL.append(" and e.oid_cco = "+comproCab.getOIDInteger().toString());

      textSQL.append(" ) ");
    }

    // FILTRAR POR COMPONENTE
    if ((componente!=null) && (valorCompo!=null)) {
      textSQL.append(" and a.oid_cco in ( " +
                     "   select d.oid_cco from geComproCab d,cgComproConta e,cgComprocontaDet f, cgAnaImpCon g " +
                     "     where d.oid_cco = e.oid_cco and e.oid_cco = f.oid_cco and f.oid_ai = g.oid_ai ");
      if (cuenta!=null)
          textSQL.append(" and g.oid_ana_con = " +
                        cuenta.getOIDInteger().toString());

      if ((fecImputacDesde!=null) && (fecImputacHasta!=null)) {
        textSQL.append(" and e.imputac>=? and e.imputac<=? ");
        ++cantParams;
      }

      if (comproCab!=null)
         textSQL.append(" and e.oid_cco = "+comproCab.getOIDInteger().toString());

      textSQL.append(" and "+
                     "g."+componente.getCampoFisicoAnaImp()+
                     "="+
                     valorCompo.getOIDInteger().toString());
      textSQL.append(" ) ");
    }


    // Filtro por Comprobante
    if (comproCab!=null)
      textSQL.append(" and a.oid_cco = "+comproCab.getOIDInteger().toString()+" ");

    // Filtro por Tipo Comprobante
  if (tipoComprobante!=null)
      textSQL.append(" and b.oid_tc = "+tipoComprobante.getOIDInteger().toString()+" ");


    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int nroParam = 0;
    for (int i=1;i<=cantParams;++i) {
      ++nroParam;
      querySelect.setDate(nroParam,new java.sql.Date(fecImputacDesde.getTime()));
      ++nroParam;
      querySelect.setDate(nroParam,new java.sql.Date(fecImputacHasta.getTime()));
    }
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from ComproConta");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getComprobantes(Cuenta cuenta,
                                     Componente componente,
                                     ValorCompo valorCompo,
                                     java.util.Date fecImputacDesde,
                                     java.util.Date fecImputacHasta,
                                     ComproCab comproCab,
                                     TipoComprobante tipoComprobante,
                                     ISesion aSesion)
                                     throws BaseException {
    Map mapaDatos = new HashTableDatos();
    if (cuenta!=null)
       mapaDatos.put(Cuenta.NICKNAME, cuenta);
    if ((componente!=null) && (valorCompo!=null)) {
      mapaDatos.put(Componente.NICKNAME, componente);
      mapaDatos.put(ValorCompo.NICKNAME, valorCompo);
    }
    if ((fecImputacDesde!=null) && (fecImputacHasta!=null)) {
      mapaDatos.put("fec_imputac_desde", fecImputacDesde);
      mapaDatos.put("fec_imputac_hasta", fecImputacHasta);
    }
    if (comproCab!=null)
      mapaDatos.put(ComproCab.NICKNAME,comproCab);
    if (tipoComprobante!=null)
      mapaDatos.put(TipoComprobante.NICKNAME,tipoComprobante);
    return (List)ObjetoLogico.getObjects(ComproContaConsulta.NICKNAME,
                                         DBComproContaConsulta.SELECT_BY_FILTROS_VARIOS,
                                         mapaDatos,
                                         new ListObserver(),
                                         aSesion);

  }


}
