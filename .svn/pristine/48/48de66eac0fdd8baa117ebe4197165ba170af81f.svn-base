package com.srn.erp.bancos.op;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.BoletaDepositoDet;
import com.srn.erp.bancos.bm.GastoBoletaDeposito;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveBoletaDeposito extends Operation {

  BoletaDeposito boletaDeposito = null;
  HashTableDatos listaCotiz = null;

  public SaveBoletaDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
    IDataSet dataset = mapaDatos.getDataSet("TBoletaDeposito");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        boletaDeposito = BoletaDeposito.findByOid(dataset.getInteger("oid_boleta_dep"),getSesion());
        boletaDeposito.addCotizacionesMonedas(listaCotiz);
        boletaDeposito.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        boletaDeposito.setContabiliza(true);
        boletaDeposito.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        boletaDeposito.setLetra(ComproCab.getLetraDefault(getSesion()));
        boletaDeposito.setLugarEmision(ComproCab.getLugEmiDafault(getSesion()));
        boletaDeposito.setEmision(dataset.getDate("fec_emision"));
        boletaDeposito.setComentario(dataset.getString("comentario"));
        boletaDeposito.setImputac(dataset.getDate("fec_emision"));
        boletaDeposito.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        boletaDeposito.setFec_deposito(dataset.getDate("fec_deposito"));
        boletaDeposito.setClearing(dataset.getInteger("clearing"));
        boletaDeposito.setCuenta_bancaria(CuentaBancaria.findByOidProxy(dataset.getInteger("oid_cta_bancaria"),getSesion()));
        boletaDeposito.setCotizacion(dataset.getCotizacion("cotizacion"));
        boletaDeposito.setMontoDeposito(dataset.getMoney("monto_deposito"));
        boletaDeposito.setGastos(dataset.getMoney("gastos"));
        boletaDeposito.setNetoDeposito(dataset.getMoney("neto_deposito"));
        boletaDeposito.setActivo(dataset.getBoolean("activo"));
        boletaDeposito.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja"),getSesion()));
        
        
        procesarValores(dataset);
        procesarGastos(dataset);
        
        addTransaccion(boletaDeposito);
        dataset.next();
    }
  }
  
  public void procesarGastos(IDataSet dataset) throws BaseException {
  	IDataSet dsGastos = dataset.getDataSet("TGastoBoletaDeposito");
  	dsGastos.first();
  	while (!dsGastos.EOF()) {
  		GastoBoletaDeposito gastoBoletaDeposito = GastoBoletaDeposito.findByOid(dsGastos.getInteger("oid_gasto_bd"),getSesion());
  		gastoBoletaDeposito.setBoleta_deposito(boletaDeposito);
  		gastoBoletaDeposito.setCuenta_imputable(CuentaImputable.findByOidProxy(dsGastos.getInteger("oid_ai"),getSesion()));
  		gastoBoletaDeposito.setDebe(dsGastos.getMoney("debe"));
  		gastoBoletaDeposito.setHaber(dsGastos.getMoney("haber"));
  		gastoBoletaDeposito.setComentario(dsGastos.getString("comentario"));
  		boletaDeposito.addGastoBoletaDeposito(gastoBoletaDeposito);
  		dsGastos.next();
  	}
  	
  }
  
  public void procesarValores(IDataSet dataset) throws BaseException {
  	IDataSet dsValores = dataset.getDataSet("TBoletaDepositoValores");
  	dsValores.first();
  	while (!dsValores.EOF()) {
  		
  		if (!dsValores.getBoolean("sel").booleanValue()) {
  			dsValores.next();
  			continue;
  		}
  		BoletaDepositoDet boletaDepositoDet = (BoletaDepositoDet)BoletaDepositoDet.getNew(BoletaDepositoDet.NICKNAME,this.getSesion());
  		boletaDepositoDet.setBoleta_deposito(boletaDeposito);
  		boletaDepositoDet.setTipo_valor(TipoValor.findByOidProxy(dsValores.getInteger("oid_tipo_valor"),getSesion()));
  		boletaDepositoDet.setValor(Valor.findByOidProxy(dsValores.getInteger("oid_valor"),getSesion()));
  		boletaDepositoDet.setCaja(Caja.findByOidProxy(dsValores.getInteger("oid_caja"),getSesion()));
  		boletaDepositoDet.setImporte(dsValores.getMoney("importe_mon_cta"));
  		boletaDepositoDet.setCotizacion(dsValores.getCotizacion("cotizacion"));
  		boletaDepositoDet.setImpoMonValor(dsValores.getMoney("importe"));
  		
  		boletaDeposito.addDetalleBoletaDeposito(boletaDepositoDet);
  		dsValores.next();
  	}
  	
  }

  protected void afterSave() throws BaseException {

      InformarComprobante infoCompro = new InformarComprobante(
      		boletaDeposito.getOIDInteger(),
      		boletaDeposito.getDescripcion());

      writeCliente(infoCompro.getDataSetInfoCompro());

  }
  
  private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
	  HashTableDatos listaCotizaciones = new HashTableDatos();
	  dsCotizaciones.first();
	  while (!dsCotizaciones.EOF()) {
		  Moneda moneda              = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"),getSesion());
		  ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
		  listaCotizaciones.put(moneda,valorCotiz);
		  dsCotizaciones.next();
	  }
	  return listaCotizaciones;
  }
  


}
