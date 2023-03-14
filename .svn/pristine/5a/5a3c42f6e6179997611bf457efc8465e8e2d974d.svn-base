package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.PeriRetGan;
import com.srn.erp.pagos.da.DBCertificadoRetGanCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificadoRetGanCab extends FactoryObjetoLogico {

  public FactoryCertificadoRetGanCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificadoRetGanCab certificadoretgancab = (CertificadoRetGanCab) objLog;
    
    // Por comproCab
    certificadoretgancab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    certificadoretgancab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    certificadoretgancab.setTcExt(db.getString(DBComproCab.TC_EXT));
    certificadoretgancab.setLetra(db.getString(DBComproCab.LETRA));
    certificadoretgancab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    certificadoretgancab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    certificadoretgancab.setNroext(db.getInteger(DBComproCab.NROEXT));
    certificadoretgancab.setEmision(db.getDate(DBComproCab.EMISION));
    certificadoretgancab.setEstado(db.getString(DBComproCab.ESTADO));
    certificadoretgancab.setComentario(db.getString(DBComproCab.COMENTARIO));
    certificadoretgancab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    certificadoretgancab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    certificadoretgancab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    certificadoretgancab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    certificadoretgancab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    certificadoretgancab.setOID(db.getInteger(DBCertificadoRetGanCab.OID_CCO_CERT));
    certificadoretgancab.setOrdendepago(ComproCab.findByOidCompro(db.getInteger(DBCertificadoRetGanCab.OID_CCO_OP),getSesion()));
    certificadoretgancab.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBCertificadoRetGanCab.OID_PROVEEDOR),getSesion()));
    certificadoretgancab.setPeriretgan(PeriRetGan.findByOidProxy(db.getInteger(DBCertificadoRetGanCab.OID_PERI_RET_GAN),getSesion()));
    certificadoretgancab.setCatretgan(CatRetGan.findByOidProxy(db.getInteger(DBCertificadoRetGanCab.OID_CAT_RET_GAN),getSesion()));
    certificadoretgancab.setPorclib(db.getMoney(DBCertificadoRetGanCab.PORC_LIB));
    certificadoretgancab.setDecreto(db.getString(DBCertificadoRetGanCab.DECRETO));

  }
}
