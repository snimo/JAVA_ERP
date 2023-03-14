package com.srn.erp.impuestos.op;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveComproAnuIVAVtas extends Operation {

  public SaveComproAnuIVAVtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTalonarios");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
    while (!dataset.EOF()) {
    	  
    	IDataSet dsComproFaltante = dataset.getDataSet("TFacturasFaltantesLibroIVA");
    	
    	dsComproFaltante.first();
    	while (!dsComproFaltante.EOF()) {
    		if (dsComproFaltante.getBoolean("sel"))
    			generarComproAnuladoIVAVtas(dsComproFaltante);
    		dsComproFaltante.next();
    	}
    	
    	dataset.next();
        
    }
    
  }
  
  private void generarComproAnuladoIVAVtas(IDataSet dsComproFaltante) throws BaseException {
	
	Talonario talonario = Talonario.findByOid(dsComproFaltante.getInteger("oid_talonario"), this.getSesion());
	Integer nroExt = dsComproFaltante.getInteger("nro_ext");
	java.util.Date fecha = dsComproFaltante.getDate("fecha");
	
	FacturaCab facturaCab = (FacturaCab) FacturaCab.getNew(FacturaCab.NICKNAME, this.getSesion());
	facturaCab.setTalonario(talonario);
	facturaCab.setContabiliza(new Boolean(false));
	facturaCab.setEmision(fecha);
	facturaCab.setImputac(fecha);
	facturaCab.setTipoCompro(talonario.getTipo_comprobante());
	facturaCab.setLetra(talonario.getLetra());
	facturaCab.setLugarEmision(talonario.getLugar_emision());
	facturaCab.setNrolugemision(talonario.getLugar_emision().getLugemi());
	facturaCab.setNroext(nroExt);
	facturaCab.setComentario("");
	facturaCab.setMoneda(Moneda.getMonedaCursoLegal(this.getSesion()));
	facturaCab.setTipoCtaCteClie(TipoCtaCteClie.getTipoCtaCteClie(getSesion()));
	Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(), this.getSesion());
	facturaCab.setSucursal(sucursal);
	facturaCab.setOC("");
	facturaCab.setTipo_oper("FACT_MOST");
	facturaCab.setActivo(new Boolean(false));
	facturaCab.setCond_pago(CondicionPago.getCondicionPagoDefaultVtaMostrador(this.getSesion()));
	facturaCab.setCaja(Caja.getCajaDefVtaMostrador(this.getSesion()));
	facturaCab.setTotal(new Money(0));
	facturaCab.setActivo(new Boolean(false));
	facturaCab.setCargaFactComoAnulada(true);
	facturaCab.setSujeto(Sujeto.getSujetoDefaultConsFinal(this.getSesion()));
	facturaCab.setProvincia(Provincia.getProvinciaDefaultVtaMos(this.getSesion()));
	facturaCab.setCotizacion(new ValorCotizacion(new Double(1)));
	facturaCab.setVendedor(Vendedor.getVendedorDefVtaMostrador(this.getSesion()));
	facturaCab.setFec_base(fecha);
	facturaCab.setSujeto_impositivo(Sujeto.getSujetoDefaultConsFinal(this.getSesion()).getSujeto_impositivo());
	if (facturaCab.isFacturaNotaDebito())
		facturaCab.setSigno(1);
	else
		facturaCab.setSigno(-1);
	facturaCab.setLista_precios(ListaPrecios.getLPDefaultVtaAlPublico(this.getSesion()));
	facturaCab.setPorc_dto(new Porcentaje(0));
	facturaCab.setDescuento(new Money(0));
	facturaCab.setPorc_recar(new Porcentaje(0));
	facturaCab.setRecargo(new Money(0));
	facturaCab.setIva(new Money(0));
	facturaCab.setIva2(new Money(0));
	facturaCab.setPerc_iva(new Money(0));
	facturaCab.setImp_internos(new Money(0));
	facturaCab.setNetoGravado(new Money(0));
	facturaCab.setNetoNoGravado(new Money(0));
	
	this.addTransaccion(facturaCab);
	
  }

}
