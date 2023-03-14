package com.srn.erp.general.op;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class BuscarComprobante extends Operation {

  public BuscarComprobante() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCompro = getDataSetCompro();

    ComproCab comproCab = null;
    String buscarPor = mapaDatos.getString("BUSCAR_POR");
    if (buscarPor.equals("TAL_NRO_EXT")) {
    	Talonario talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"),getSesion());
    	Integer   nroExt    = mapaDatos.getInteger("nro_ext");
    	if (mapaDatos.containsKey("SOLO_ACTIVO"))
    		comproCab = getComproPorTalonarioNroExtActivo(talonario,nroExt);
    	else
    		comproCab = getComproPorTalonarioNroExt(talonario,nroExt);
    } else
    if (buscarPor.equals("OID_CCO")) {
      	Integer oid_cco = mapaDatos.getInteger("oid_cco");
      	comproCab 			= getComproByOidCCO(oid_cco);
    }
    if (comproCab!=null)
    	cargarComprobante(datasetCompro,comproCab);
    writeCliente(datasetCompro);
  }
  
  private ComproCab getComproPorTalonarioNroExt(Talonario talonario,Integer nroExt) throws BaseException {
  	return ComproCab.getComproCab(talonario,nroExt,getSesion());
  }
  
  private ComproCab getComproPorTalonarioNroExtActivo(Talonario talonario,Integer nroExt) throws BaseException {
  	return ComproCab.getComproCabActivo(talonario,nroExt,getSesion());
  }
  
  private ComproCab getComproByOidCCO(Integer oidCCO) throws BaseException {
  	return ComproCab.findByOidCompro(oidCCO,getSesion());
  } 
  
  private IDataSet getDataSetCompro() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComproCab");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tc_ext", Field.STRING, 20));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("emision", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
    dataset.fieldDef(new Field("fec_alta", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("estado", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("imputac", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_motivo_compro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    return dataset;
  }

  private void cargarComprobante(IDataSet dataset,
                         ComproCab comproCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco", comproCab.getOID());
    dataset.fieldValue("oid_tc", comproCab.getTipoCompro().getOID());
    dataset.fieldValue("tc_ext", comproCab.getTcExt());
    dataset.fieldValue("letra", comproCab.getLetra());
    dataset.fieldValue("nro_ext", comproCab.getNroExt());
    dataset.fieldValue("lug_emi", comproCab.getNroLugEmision());
    dataset.fieldValue("emision", comproCab.getEmision());
    dataset.fieldValue("oid_lug_emi", comproCab.getLugarEmision().getOID());
    dataset.fieldValue("comentario", comproCab.getComentario());
    dataset.fieldValue("fec_alta", comproCab.getFecAlta());
    dataset.fieldValue("oid_usuario", comproCab.getUsuario().getOID());
    dataset.fieldValue("estado", comproCab.getEstado());
    dataset.fieldValue("activo", comproCab.isActivo());
    dataset.fieldValue("oid_talonario", comproCab.getTalonario().getOID());
    dataset.fieldValue("oid_sucursal", comproCab.getSucursal().getOID());
    dataset.fieldValue("imputac", comproCab.getImputac());
    if (comproCab.getMotivoComprobante()!=null)
    	dataset.fieldValue("oid_motivo_compro",comproCab.getMotivoComprobante().getOID());
    else
    	dataset.fieldValue("oid_motivo_compro",0);    	
    dataset.fieldValue("comprobante",comproCab.getCodigo());
  }
}
