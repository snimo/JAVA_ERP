package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.ventas.bm.ListaPrecioSujeto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaRapidaSujeto extends Operation {

	Sujeto sujeto = null;
	
  public SaveAltaRapidaSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCliente");
    procesarRegistros(dataset);
  }
  
  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
      	
        sujeto = (Sujeto)Sujeto.getNew(Sujeto.NICKNAME,this.getSesion());
        SujetoImpositivo sujetoImpositivo = 
        	(SujetoImpositivo)SujetoImpositivo.getNew(SujetoImpositivo.NICKNAME,this.getSesion());
        sujeto.setSujeto_impositivo(sujetoImpositivo);
        
        // Datos principales del Sujeto
        sujeto.setCodigo(dataset.getString("codigo"));
        sujeto.setFisica_juridica(dataset.getString("fisica_juridica"));
        sujeto.setRazon_social(dataset.getString("razon_social_cliente"));
        
        TipoDocumento tipoDocu = TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_docu"), getSesion());
        if (tipoDocu == null)
        	throw new ExceptionValidation(null,"Debe ingresar el tipo de documento");
        
        sujeto.setTipo_documento(tipoDocu);
        if (sujeto.getTipo_documento()==null)
        	throw new ExceptionValidation(null,"Debe ingresar el tipo de documento");
        
        // Si es CUIT o CUIT se carga en el sujeto Impositivo 
        if (!sujeto.getTipo_documento().isCUIT())
        	sujeto.setNro_documento(dataset.getString("nro_documento"));
        
        sujeto.setCalle_y_nro(dataset.getString("direccion"));
        sujeto.setLocalidad(dataset.getString("localidad"));
        sujeto.setCodigo_postal(dataset.getString("codigo_postal"));
        sujeto.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"), getSesion()));
        sujeto.setVendedor_comercial(Vendedor.findByOidProxy(dataset.getInteger("oid_vendedor"), getSesion()));
        sujeto.setContacto(dataset.getString("contacto"));
        sujeto.setTelefonos(dataset.getString("telefonos"));
        
        sujeto.setEs_prospecto(dataset.getBoolean("es_prospecto"));
        sujeto.setEs_contacto(dataset.getBoolean("es_contacto"));
        sujeto.setEs_cliente(dataset.getBoolean("es_cliente"));
        sujeto.setEs_socio(dataset.getBoolean("es_socio"));
        
        
        sujeto.setFax(dataset.getString("fax"));
        sujeto.setFax(dataset.getString("e_mail"));
        sujeto.setActivo(new Boolean(true));
        
        
        // Sujeto Impositivo
        sujetoImpositivo.setRazon(dataset.getString("razon_social_cliente"));
        
        if (sujeto.getTipo_documento().isCUIT())
           sujetoImpositivo.setCuit(dataset.getString("nro_documento"));
        
        CategoriaIVA categoriaIVA = CategoriaIVA.findByOidProxy(dataset.getInteger("oid_categ_iva"),this.getSesion());
        if (categoriaIVA == null)
        	throw new ExceptionValidation(null,"Debe ingresar la categoría de IVA");
        
        if (sujeto.getTipo_documento().isCUIT() && (!categoriaIVA.isRequiereCUIT()))
        	throw new ExceptionValidation(null,"Se debe ingresar una categoría de IVA Válida que requiera CUIT");
        	
        
        if (categoriaIVA.isRequiereCUIT() && (!tipoDocu.isCUIT()))
        	throw new ExceptionValidation(null,"Se debe seleccionar el tipo de documento CUIT para la categoría de IVA seleccionada");
                	
        sujetoImpositivo.setCategiva(categoriaIVA);
        sujetoImpositivo.setCategib(CategoriaIB.findByOidProxy(dataset.getInteger("oid_categ_ib"),this.getSesion()));
        sujetoImpositivo.setActivo(new Boolean(true));
        
        if (sujetoImpositivo.getCategiva() == null)
        	throw new ExceptionValidation(null,"Debe ingresar la categoría de IVA");
        
        if (dataset.getBoolean("dom_ent").booleanValue()) {
        	// Dar de alta el domicilio de entrega
        	altaDomicilioEntrega(dataset , sujeto);
        }
        
        altaListaPrecios(sujeto);

        addTransaccion(sujeto);
        dataset.next();
    }
  }
  
  private void altaDomicilioEntrega(IDataSet ds , Sujeto sujeto) throws BaseException {
  	
  	UnidadEdilicia unidadEdilicia = (UnidadEdilicia)UnidadEdilicia.getNew(UnidadEdilicia.NICKNAME,this.getSesion());
  	unidadEdilicia.setCodigo(UnidadEdilicia.getCodigoDomEntAltaRapidaCliente(this.getSesion()));
  	unidadEdilicia.setCalle_y_mro(ds.getString("direccion"));
  	unidadEdilicia.setLocalidad(ds.getString("localidad"));
  	unidadEdilicia.setCodigo_postal(ds.getString("codigo_postal"));
  	unidadEdilicia.setProvincia(Provincia.findByOidProxy(ds.getInteger("oid_provincia"), getSesion()));
  	unidadEdilicia.setActivo(new Boolean(true));
  	unidadEdilicia.setDom_ent(new Boolean(true));
  	
  	
  	sujeto.addUnidadEdilicia(unidadEdilicia);
  	
  }
  
	protected void afterSave() throws BaseException {
		
		IDataSet ds = this.getDataSetNuevoCliente();
		if (sujeto!=null)
			enviarSujeto(ds,sujeto);
		writeCliente(ds);
		
	}
	
	private void altaListaPrecios(Sujeto sujeto) throws BaseException {
    ListaPrecioSujeto listaPrecioSujeto = (ListaPrecioSujeto) ListaPrecioSujeto.getNew(ListaPrecioSujeto.NICKNAME,this.getSesion());
    listaPrecioSujeto.setFecha_desde(Fecha.getFechaActual());
    listaPrecioSujeto.setFecha_hasta(Fecha.getFechaMasMeses(Fecha.getFechaActual(),244));
    listaPrecioSujeto.setActivo(new Boolean(true));
    listaPrecioSujeto.setSujeto(sujeto);
    listaPrecioSujeto.setLista_precio(ListaPrecios.getLPDefaultVtaAlPublico(this.getSesion()));

    sujeto.addListaPrecioSujeto(listaPrecioSujeto);
		
	}
  
  
  private void enviarSujeto(IDataSet ds,Sujeto aSujeto) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_sujeto",aSujeto.getOIDInteger());
  	ds.fieldValue("cod_sujeto",aSujeto.getCodigo());
  	ds.fieldValue("rs_sujeto",aSujeto.getRazon_social());
  }
  
  private IDataSet getDataSetNuevoCliente() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNuevoCliente");
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		return dataset;
	}
  
  



}
