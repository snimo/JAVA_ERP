package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPCondPago;
import com.srn.erp.compras.bm.AcuerdoLPDetalle;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDto;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDtoCant;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAcuerdoLP extends Operation { 

  public SaveAcuerdoLP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAcuerdoLP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AcuerdoLP acuerdolp = AcuerdoLP.findByOid(dataset.getInteger("oid_acuerdo_lp"),getSesion());
        acuerdolp.setTipo_acuerdo(TipoAcuerdo.findByOidProxy(dataset.getInteger("oid_tipo_acuerdo"),getSesion()));
        acuerdolp.setProveedor(Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor"),getSesion()));
        acuerdolp.setActivo(dataset.getBoolean("activo"));
        acuerdolp.setDescripcion(dataset.getString("descripcion"));
        
        
        IDataSet dsPreciosCompraClasifArt = dataset.getDataSet("TDefEstrucLPDet");
        dsPreciosCompraClasifArt.first();
        while (!dsPreciosCompraClasifArt.EOF()) {
        	 
        	acuerdolp.addPrecioClasifArt(
        			ClasificadorEntidad.findByOidProxy(dsPreciosCompraClasifArt.getInteger("oid_clasificador_2"),this.getSesion()),
        			ValorClasifEntProdGen.findByOidProxy(dsPreciosCompraClasifArt.getInteger("oid_clasif_art_2"),this.getSesion()),
        			dsPreciosCompraClasifArt.getMoney("cantidad"),
        			UnidadMedida.findByOidProxy(dsPreciosCompraClasifArt.getInteger("oid_um"),this.getSesion()),
        			dsPreciosCompraClasifArt.getMoney("precio"),
        			Moneda.findByOidProxy(dsPreciosCompraClasifArt.getInteger("oid_moneda"),this.getSesion()),
        			dsPreciosCompraClasifArt.getBoolean("activo"),
        			null);
        			
        	dsPreciosCompraClasifArt.next();
        }
                
        IDataSet dsAcuerdoCondPago = dataset.getDataSet("TAcuerdoLPCondPago");
        dsAcuerdoCondPago.first();
        while (!dsAcuerdoCondPago.EOF()) {
        	AcuerdoLPCondPago acuerdoLPCondPago = AcuerdoLPCondPago.findByOid(dsAcuerdoCondPago.getInteger("oid_acu_lp_dtos"),getSesion());
        	acuerdoLPCondPago.setAcuerdolp(acuerdolp);
        	acuerdoLPCondPago.setCondicion_pago(CondicionCompra.findByOidProxy(dsAcuerdoCondPago.getInteger("oid_cond_compra"),getSesion()));
        	acuerdoLPCondPago.setDto_1(dsAcuerdoCondPago.getDouble("dto_1"));
        	acuerdoLPCondPago.setDto_2(dsAcuerdoCondPago.getDouble("dto_2"));
        	acuerdoLPCondPago.setDto_3(dsAcuerdoCondPago.getDouble("dto_3"));
        	acuerdoLPCondPago.setDto_4(dsAcuerdoCondPago.getDouble("dto_4"));
        	acuerdoLPCondPago.setDto_5(dsAcuerdoCondPago.getDouble("dto_5"));
        	acuerdoLPCondPago.setEn_cascada(dsAcuerdoCondPago.getBoolean("en_cascada"));
        	acuerdoLPCondPago.setActivo(dsAcuerdoCondPago.getBoolean("activo"));
        	if (!acuerdoLPCondPago.isActivo().booleanValue()) acuerdoLPCondPago.delete(); 
        	acuerdolp.addCondPagoDto(acuerdoLPCondPago);
        	dsAcuerdoCondPago.next();
        }
        
        IDataSet dsAcuerdoLPDetalles = dataset.getDataSet("TAcuerdoLPDetalle");
        dsAcuerdoLPDetalles.first();
        while (!dsAcuerdoLPDetalles.EOF()) {
        	AcuerdoLPDetalle acuerdoLPDetalle = AcuerdoLPDetalle.findByOid(dsAcuerdoLPDetalles.getInteger("oid_acu_lp_det"),getSesion());
        	acuerdoLPDetalle.setAcuerdo_lp(acuerdolp);
        	acuerdoLPDetalle.setProducto(Producto.findByOidProxy(dsAcuerdoLPDetalles.getInteger("oid_producto"),getSesion()));
        	acuerdoLPDetalle.setVigencia_desde(dsAcuerdoLPDetalles.getDate("vigencia_desde"));
        	acuerdoLPDetalle.setVigencia_hasta(dsAcuerdoLPDetalles.getDate("vigencia_hasta"));
        	acuerdoLPDetalle.setCantidad(dsAcuerdoLPDetalles.getDouble("cantidad"));
        	acuerdoLPDetalle.setUnidad_medida(UnidadMedida.findByOidProxy(dsAcuerdoLPDetalles.getInteger("oid_um"),getSesion()));
        	acuerdoLPDetalle.setMoneda(Moneda.findByOidProxy(dsAcuerdoLPDetalles.getInteger("oid_moneda"),getSesion()));
        	acuerdoLPDetalle.setPrecio(dsAcuerdoLPDetalles.getMoney("precio"));
        	acuerdoLPDetalle.setComentario(dsAcuerdoLPDetalles.getString("comentario"));
        	acuerdoLPDetalle.setActivo(dsAcuerdoLPDetalles.getBoolean("activo"));
        	acuerdoLPDetalle.setCodProdProv(dsAcuerdoLPDetalles.getString("cod_prod_prov"));
        	acuerdoLPDetalle.setDescProdProv(dsAcuerdoLPDetalles.getString("desc_prod_prov"));
        	
        	IDataSet dsAcuerdoLPDetallesDtos = dsAcuerdoLPDetalles.getDataSet("TAcuerdoLPDetalleDto");
        	dsAcuerdoLPDetallesDtos.first();
        	while (!dsAcuerdoLPDetallesDtos.EOF()) {
        		AcuerdoLPDetalleDto acuerdoLPDetalleDto = AcuerdoLPDetalleDto.findByOid(dsAcuerdoLPDetallesDtos.getInteger("oid_acu_lp_det_dto"),getSesion());
        		acuerdoLPDetalleDto.setAcuerdo_lp_detalle(acuerdoLPDetalle);
        		acuerdoLPDetalleDto.setCondicion_pago(CondicionCompra.findByOidProxy(dsAcuerdoLPDetallesDtos.getInteger("oid_cond_compra"),getSesion()));
        		acuerdoLPDetalleDto.setDto_1(dsAcuerdoLPDetallesDtos.getDouble("dto_1"));
        		acuerdoLPDetalleDto.setDto_2(dsAcuerdoLPDetallesDtos.getDouble("dto_2"));
        		acuerdoLPDetalleDto.setDto_3(dsAcuerdoLPDetallesDtos.getDouble("dto_3"));
        		acuerdoLPDetalleDto.setDto_4(dsAcuerdoLPDetallesDtos.getDouble("dto_4"));
        		acuerdoLPDetalleDto.setDto_5(dsAcuerdoLPDetallesDtos.getDouble("dto_5"));
        		acuerdoLPDetalleDto.setTipo_dto(dsAcuerdoLPDetallesDtos.getString("tipo_dto"));
        		acuerdoLPDetalleDto.setEn_cascada(dsAcuerdoLPDetallesDtos.getBoolean("en_cascada"));
        		acuerdoLPDetalleDto.setActivo(dsAcuerdoLPDetallesDtos.getBoolean("activo"));
        		
        		IDataSet dsAcuerdoLPDetallesDtosCant = dsAcuerdoLPDetallesDtos.getDataSet("TAcuerdoLPDetalleDtoCant");
        		dsAcuerdoLPDetallesDtosCant.first();
        		while (!dsAcuerdoLPDetallesDtosCant.EOF()) {
        			AcuerdoLPDetalleDtoCant acuerdoLPDetalleDtoCant = AcuerdoLPDetalleDtoCant.findByOid(dsAcuerdoLPDetallesDtosCant.getInteger("oid_dto_cant"),getSesion());
        			acuerdoLPDetalleDtoCant.setAcu_lp_det_dto(acuerdoLPDetalleDto);
        			acuerdoLPDetalleDtoCant.setCant_desde(dsAcuerdoLPDetallesDtosCant.getDouble("cant_desde"));
        			acuerdoLPDetalleDtoCant.setCant_hasta(dsAcuerdoLPDetallesDtosCant.getDouble("cant_hasta"));
        			acuerdoLPDetalleDtoCant.setDto_1(dsAcuerdoLPDetallesDtosCant.getDouble("dto_1"));
        			acuerdoLPDetalleDtoCant.setDto_2(dsAcuerdoLPDetallesDtosCant.getDouble("dto_2"));
        			acuerdoLPDetalleDtoCant.setDto_3(dsAcuerdoLPDetallesDtosCant.getDouble("dto_3"));
        			acuerdoLPDetalleDtoCant.setDto_4(dsAcuerdoLPDetallesDtosCant.getDouble("dto_4"));
        			acuerdoLPDetalleDtoCant.setDto_5(dsAcuerdoLPDetallesDtosCant.getDouble("dto_5"));
        			acuerdoLPDetalleDtoCant.setEn_cascada(dsAcuerdoLPDetallesDtosCant.getBoolean("en_cascada"));
        			acuerdoLPDetalleDtoCant.setActivo(dsAcuerdoLPDetallesDtosCant.getBoolean("activo"));
        			acuerdoLPDetalleDto.addAcuerdoLPDetalleDtoCant(acuerdoLPDetalleDtoCant);
        			dsAcuerdoLPDetallesDtosCant.next();
        		}
        		
        		acuerdoLPDetalle.addAcuerdoLPDetalleDto(acuerdoLPDetalleDto);
        		dsAcuerdoLPDetallesDtos.next();
        	}
        	acuerdolp.addAcuerdoLPDetalle(acuerdoLPDetalle);
        	dsAcuerdoLPDetalles.next();
        }        
        
        
        
        
        addTransaccion(acuerdolp);
        dataset.next();
    }
  }
  
}
