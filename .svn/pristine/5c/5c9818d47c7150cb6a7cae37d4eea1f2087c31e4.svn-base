package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.AjuStkPartSerie;
import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ComproAjusteStkDet;
import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveComprobanteAjusteStock extends Operation {

  private ComproAjusteStk comproAjuStk = null;
  ComproCab informarCompro = null;

  public SaveComprobanteAjusteStock() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TComproAjuStkCab");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        comproAjuStk = ComproAjusteStk.findByOid(dataset.getInteger("oid_aju_stk_cab"),getSesion());
        
        if (dataset.getBoolean("activo").booleanValue()==false)	
        	if (comproAjuStk.isActivo().booleanValue()) {
        			comproAjuStk.delete();
        			this.addTransaccion(comproAjuStk);
        			dataset.next();
        			continue;
        	}
        
        
        comproAjuStk.setContabiliza(false);
        comproAjuStk.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        comproAjuStk.setLetra(dataset.getString("letra"));
        comproAjuStk.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        comproAjuStk.setNroext(dataset.getInteger("nro_ext"));
        comproAjuStk.setEmision(dataset.getDate("fec_emision"));
        comproAjuStk.setComentario(dataset.getString("observacion"));
        comproAjuStk.setTipo_aju_stk(dataset.getString("tipo_aju_stk"));
        comproAjuStk.setTalonario(Talonario.findByOid(dataset.getInteger("oid_talonario"),getSesion()));
        TipoConfMovStkTalonario tipoConfMovStkTal =
            TipoConfMovStkTalonario.findByOidProxy(dataset.getInteger("oid_tipo_conf_mov"),getSesion());
        comproAjuStk.setConf_mov_stk_tal(tipoConfMovStkTal.getConf_mov_stk());
        comproAjuStk.setTipo_conf_mov(tipoConfMovStkTal);
        comproAjuStk.setCompoStkTalAjuStk(CompoStkTalonarioAjuStk.findByOid(dataset.getInteger("oid_compo_stk_aju"),getSesion()));
        comproAjuStk.setActivo(new Boolean(true));
        comproAjuStk.setActuStock(true);
        
        

        // Detalles Ajustes de Stock
        IDataSet dsDet = dataset.getDataSet("TComproAjuStkDet");
        dsDet.first();
        while (!dsDet.EOF()) {
          ComproAjusteStkDet comproAjusteStkDet =
                ComproAjusteStkDet.findByOid(dsDet.getInteger("oid_aju_stk_det"),getSesion());
          comproAjusteStkDet.setAjuste_stock_cab(comproAjuStk);
          comproAjusteStkDet.setProducto(Producto.findByOidProxy(dsDet.getInteger("oid_producto"),getSesion()));
          comproAjusteStkDet.setCantidad(dsDet.getDouble("cantidad"));
          comproAjusteStkDet.setUm_carga(UnidadMedida.findByOidProxy(dsDet.getInteger("oid_um_carga"),getSesion()));

          TipoConfMovStkTalonario tipoConfMovStkTalDet =
            TipoConfMovStkTalonario.findByOidProxy(dsDet.getInteger("oid_tipo_conf_mov"),getSesion());
          if (tipoConfMovStkTalDet!=null) {
            comproAjusteStkDet.setConf_mov_stk(tipoConfMovStkTalDet.
                                               getConf_mov_stk());
            comproAjusteStkDet.setTipo_conf_mov(tipoConfMovStkTalDet);
          }
          else {
            comproAjusteStkDet.setConf_mov_stk(null);
            comproAjusteStkDet.setTipo_conf_mov(null);
          }
          comproAjusteStkDet.setObservaciones(dsDet.getString("observaciones"));
          comproAjusteStkDet.setCompo_stk_aju(CompoStkTalonarioAjuStk.findByOidProxy(dsDet.getInteger("oid_compo_stk_aju"),getSesion()));
          comproAjusteStkDet.setActivo(dsDet.getBoolean("activo"));
          comproAjuStk.addDetalle(comproAjusteStkDet);

          // Grabar las Partidas Series
          if (comproAjusteStkDet.getProducto()==null)
            throw new ExceptionValidation(null,"Debe ingresar el Producto");

          if (comproAjusteStkDet.getProducto().isLlevaPartida().booleanValue() ||
              comproAjusteStkDet.getProducto().isLlevaSerie().booleanValue())
            procesarPartidasSeries(dsDet,comproAjusteStkDet);
          
          UbicacionDeposito ubiDepo1 = UbicacionDeposito.findByOid(dsDet.getInteger("oid_ubi_1"),getSesion());
          UbicacionDeposito ubiDepo2 = UbicacionDeposito.findByOid(dsDet.getInteger("oid_ubi_2"),getSesion());
          
          // Reajuste de Bornes del compresor
          
          
          comproAjusteStkDet.setUbiDepo1(ubiDepo1);
          comproAjusteStkDet.setUbiDepo2(ubiDepo2);       
          dsDet.next();
        }
        addTransaccion(comproAjuStk);
        dataset.next();
    }
  }

  protected void afterSave() throws BaseException {

  	
  	if (comproAjuStk!=null)
  	   informarCompro = comproAjuStk;
  	else 
  		 return;
  	
      InformarComprobante infoCompro = 
      	new InformarComprobante(
      			informarCompro.getOIDInteger(),
      			informarCompro.getDescripcion());

      writeCliente(infoCompro.getDataSetInfoCompro());

  }

  private void procesarPartidasSeries(IDataSet dsDet,ComproAjusteStkDet comproAjusteStkDet) throws BaseException {
    IDataSet dsPartidaSerie = dsDet.getDataSet("TPartidaSerieDet");
    dsPartidaSerie.first();
    while (!dsPartidaSerie.EOF()) {
      AjuStkPartSerie ajuStkPartSerie =
          AjuStkPartSerie.findByOid(dsPartidaSerie.getInteger("oid_aju_stk_p_s"),getSesion());
      ajuStkPartSerie.setAju_stk_det(comproAjusteStkDet);
      ajuStkPartSerie.setPartida(Partida.findByOidProxy(dsPartidaSerie.getInteger("oid_partida"),getSesion()));
      ajuStkPartSerie.setSerie(Serie.findByOidProxy(dsPartidaSerie.getInteger("oid_serie"),getSesion()));
      ajuStkPartSerie.setCantidad(dsPartidaSerie.getDouble("cantidad"));
      ajuStkPartSerie.setActivo(new Boolean(true));
      comproAjusteStkDet.addDetPartSerie(ajuStkPartSerie);
      dsPartidaSerie.next();
    }

  }


}
