package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ElementoBandaPlan;
import com.srn.erp.presupuesto.bm.ElementoFilaPlan;
import com.srn.erp.presupuesto.bm.ElementoFiltroPlan;
import com.srn.erp.presupuesto.bm.ManejadorPlan;
import com.srn.erp.presupuesto.bm.Metrica;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCreandoPlan extends Operation { 

  public TraerCreandoPlan() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	if (mapaDatos.containsKey("filtrosCompo"))
  		enviarFiltrosCompo(mapaDatos);
  	else if (mapaDatos.containsKey("valoresCompo"))
  		enviarValoresCompo(mapaDatos);
  	else if (mapaDatos.containsKey("confFilasPlanes"))
  		enviarConfFilasPlanes(mapaDatos);
  	else if (mapaDatos.containsKey("confColPlanes"))
  		enviarConfColumnasPlanes(mapaDatos);
  	else if (mapaDatos.containsKey("restringirValores"))
  		enviarValoresARestringir(mapaDatos);
  	else if (mapaDatos.containsKey("cargaValoresParaRestringir"))
  		enviarValCompoParaRestringir(mapaDatos);
  	
  }  
  
  private void enviarValCompoParaRestringir(MapDatos mapaDatos) throws BaseException {
  	
  	ManejadorPlan manejadorPlan = new ManejadorPlan();
  	cargarElementos(mapaDatos,manejadorPlan);
  	
  	IDataSet ds = manejadorPlan.getDSCamposCompoTablaEstrucPlan();
  	manejadorPlan.llenarTablaPlanConValCompo(ds);
  	this.writeCliente(ds);
  	
  }
  
  private void cargarElementos(MapDatos mapaDatos,ManejadorPlan manejadorPlan) throws BaseException {

  	IDataSet dsFiltros = mapaDatos.getDataSet("TFiltroCompo");
  	dsFiltros.first();
  	while (!dsFiltros.EOF()) {
  		ElementoFiltroPlan elementoFiltro = new ElementoFiltroPlan();
  		elementoFiltro.setCompoPresu(CompoPresupuestario.findByOidProxy(dsFiltros.getInteger("oid_compo_presu"),this.getSesion()));
  		elementoFiltro.setNroOrden(dsFiltros.getInteger("nro_orden").intValue());
  		elementoFiltro.setUsarEnFiltro(dsFiltros.getBoolean("usar_en_filtro").booleanValue());
  		elementoFiltro.setFiltroObligatorio(dsFiltros.getBoolean("filtro_obligatorio").booleanValue());
  		elementoFiltro.setTipoRestriccion(dsFiltros.getString("tipo_restriccion"));
  		elementoFiltro.setMultipleSeleccion(dsFiltros.getBoolean("multiple_seleccion").booleanValue());
  		
  		IDataSet dsValCompoFiltro = dsFiltros.getDataSet("TValoresCompoFiltro");
  		dsValCompoFiltro.first();
  		while (!dsValCompoFiltro.EOF()) {
  			if (dsValCompoFiltro.getBoolean("habilitado").booleanValue()) {
  				ValorCompoPresu valorCompoPresu = 
  					ValorCompoPresu.findByOidProxy(dsValCompoFiltro.getInteger("oid_val_compo_presu"),this.getSesion());
  				elementoFiltro.addValorPresu(valorCompoPresu);
  			}
  			dsValCompoFiltro.next();
  		}
  		
  		
  		
  		manejadorPlan.addFiltro(elementoFiltro);
  		
  		dsFiltros.next();
  	}
  	
  	
  	IDataSet dsBandas = mapaDatos.getDataSet("TBandas");
  	dsBandas.first();
  	while (!dsBandas.EOF()) {
  		
  		ElementoBandaPlan elementoBandaPlan = new ElementoBandaPlan();
  		elementoBandaPlan.setNroBanda(dsBandas.getInteger("oid_banda").intValue());
  		elementoBandaPlan.setNroOrden(dsBandas.getInteger("orden").intValue());
  		elementoBandaPlan.setTitulo(dsBandas.getString("banda"));
  		elementoBandaPlan.setUbicacion(dsBandas.getString("ubi_tipo_banda"));
  		manejadorPlan.addBanda(elementoBandaPlan);
  		
  		dsBandas.next();
  	}
  	 
  	
  	IDataSet dsFilasPlan = mapaDatos.getDataSet("TConfFilasPlan");
  	dsFilasPlan.first();
  	while (!dsFilasPlan.EOF()) {
  		
  		if (dsFilasPlan.getBoolean("mostrar").booleanValue()) {
  			
  			ElementoFilaPlan elementoFilaPlan = new ElementoFilaPlan();
  			elementoFilaPlan.setCompoPresu(CompoPresupuestario.findByOidProxy(dsFilasPlan.getInteger("oid_compo_presu"),this.getSesion()));
  			elementoFilaPlan.setNroPosCol(dsFilasPlan.getInteger("pos_col").intValue());
  			elementoFilaPlan.setTitulo(dsFilasPlan.getString("titulo_columna"));
  			elementoFilaPlan.setAgrupar(dsFilasPlan.getBoolean("agrupar").booleanValue());
  			elementoFilaPlan.setFiltros(dsFilasPlan.getBoolean("filtros").booleanValue());
  			elementoFilaPlan.setBusquedaInc(dsFilasPlan.getBoolean("busq_inc").booleanValue());
  			elementoFilaPlan.setPermitirCambiarOrden(dsFilasPlan.getBoolean("ordenar").booleanValue());
  			elementoFilaPlan.setOrdenPorDefecto(dsFilasPlan.getString("tipo_orden"));
  			elementoFilaPlan.setAnchoColumna(dsFilasPlan.getInteger("ancho_col").intValue());
  			elementoFilaPlan.setTipoCampo(dsFilasPlan.getInteger("nro_campo").intValue());  			
  			manejadorPlan.addFila(elementoFilaPlan);
  			
  		}
  		
  		
  		
  		dsFilasPlan.next();
  	}
  	
  	
  }
  
  private void enviarValoresARestringir(MapDatos mapaDatos) throws BaseException {
  	
  	ManejadorPlan manejadorPlan = new ManejadorPlan();
  	cargarElementos(mapaDatos,manejadorPlan);
  	
  	// Devolver el DataSet con los campos a Crear
  	IDataSet dsColGrillaPlan = manejadorPlan.getDSColumnasGrillaPlan();
  	manejadorPlan.enviarColumnasCompoGrillaPlan(dsColGrillaPlan);
  	writeCliente(dsColGrillaPlan);
  	
  	// Devolver la Estrutura de campos de components de la Tabla del Plan
  	IDataSet dsCamposEstrucPlan = manejadorPlan.getDSCamposTablaEstrucPlan();
  	manejadorPlan.enviarCampoCompoTablaPlan(dsCamposEstrucPlan);
  	writeCliente(dsCamposEstrucPlan);

  	
  	
  }
  
  private void enviarConfColumnasPlanes(MapDatos mapaDatos) throws BaseException {
    
  	int secu = 0;
  	IDataSet ds = this.getDataConfColumnasPlan();
    IDataSet dsPlanPresupuestario = mapaDatos.getDataSet("TPlanPresupuestario");
    dsPlanPresupuestario.first();
    while (!dsPlanPresupuestario.EOF()) {
    	
    	Integer cantPeriAPlanif = dsPlanPresupuestario.getInteger("cant_peri_planif");
    	
    	if (dsPlanPresupuestario.getBoolean("tipo_peri_planif_mismo_tipo").booleanValue()) {
    		  // Todos los periodos de Planificacion son del mismo tipo
    		  TipoPeriodo tipoPeriodo = TipoPeriodo.findByOidProxy(
    		  		dsPlanPresupuestario.getInteger("oid_tipo_peri"),
    		  		this.getSesion());
    		  
    		  for (int i=1;i<=cantPeriAPlanif.intValue();++i) {
    		  	++secu;
    		    cargarRegistroConfColumnaPlan(ds,
    		    															secu,
    		    															secu,
    		    															tipoPeriodo,
    		    															"PRESU",
    		    															secu,
    		    															null,
    		    															"",
    		    															null,
    		    															"",
    		    															"",
    		    															"",
    		    															0,
    		    															50);
    		  }
    			
    	} else {
    		// Los primeros periodos son de un tipo y el resto de otro tipo

    		// Primeros Periodos
    		Integer primerosPeriodos  = dsPlanPresupuestario.getInteger("cant_prim_peri");
    		TipoPeriodo tipoPrimPeriodos = 
    			TipoPeriodo.findByOidProxy(dsPlanPresupuestario.getInteger("oid_tipo_peri_prim_peri"), this.getSesion());
    		
    		// Segundos Periodos
    		Integer siguientesPeriodos  = dsPlanPresupuestario.getInteger("cant_sig_peri");
    		TipoPeriodo tipoSigPeriodos = 
    			TipoPeriodo.findByOidProxy(dsPlanPresupuestario.getInteger("oid_tipo_peri_sig"), this.getSesion());
    		
    		// El resto de los periodos
    		TipoPeriodo tipoRestoPeriodos = 
    			TipoPeriodo.findByOidProxy(dsPlanPresupuestario.getInteger("oid_tipo_peri_resto"), this.getSesion());
    		
    		TipoPeriodo tipoPeriodo = null;
    		
  		  for (int i=1;i<=cantPeriAPlanif.intValue();++i) {
  		  	++secu;
  		  	
  		  	if (secu<=primerosPeriodos.intValue())
  		  		tipoPeriodo = tipoPrimPeriodos;
  		  	else
  		  		if (secu<=(primerosPeriodos.intValue()+siguientesPeriodos.intValue()))
  		  			tipoPeriodo = tipoSigPeriodos;
  		  		else
  		  			tipoPeriodo = tipoRestoPeriodos;
  		  	
  		  	
  		    cargarRegistroConfColumnaPlan(ds,
  		    															secu,
  		    															secu,
  		    															tipoPeriodo,
  		    															"PRESU",
  		    															secu,
  		    															null,
  		    															"",
  		    															null,
  		    															"",
  		    															"",
  		    															"",
  		    															0,
  		    															50);
  		  }

    		
    	}
    	
    	
    	dsPlanPresupuestario.next();
    }
    writeCliente(ds);
    	
  	
  }
  
  
  private void enviarConfFilasPlanes(MapDatos mapaDatos) throws BaseException {
  
  	IDataSet ds = getDataConfFilasPlan();
    int nroReg = 0;
    IDataSet dsCompoEstrucPlan = mapaDatos.getDataSet("TCompoEstrucPlan");
    dsCompoEstrucPlan.first();
    while (!dsCompoEstrucPlan.EOF()) {
    	Integer oidValCompo = dsCompoEstrucPlan.getInteger("oid_val_compo");
    	CompoPresupuestario compoPresu = 
    		CompoPresupuestario.findByOid(dsCompoEstrucPlan.getInteger("oid_compo_presu"),this.getSesion());
    	if ((oidValCompo == null) || (oidValCompo.intValue()==0)) {
    		++nroReg;
    		// Por cada componente generar 4 registros
    		for(int i=1;i<=4;++i) {
    			String campo = "";
    			if (i==1) campo = "Código";
    			if (i==2) campo = "Descripción";
    			if (i==3) campo = "Código - Descripción";
    			if (i==4) campo = "Descripción - Código";
    			cargarRegistroConfFilaPlan(ds,
    					new Integer(nroReg),
    					compoPresu,
    					false,
    					0,
    					i,
    					campo,
    					"",
    					0,
    					false,
    					false,
    					false,
    					false,
    					"N_A",
    					100);
    		}
    	}
    		
    	dsCompoEstrucPlan.next();
    }
    writeCliente(ds);
    	
  	
  }
  
  private void enviarValoresCompo(MapDatos mapaDatos) throws BaseException {
  	
    CompoPresupuestario compoPresu = 
    	CompoPresupuestario.findByOid(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
    
    IDataSet dsValorCompo = this.getDataValCompoFiltro();
    
    Iterator iterValoresCompoPresu = compoPresu.getValores().iterator();
    while (iterValoresCompoPresu.hasNext()) {
    	ValorCompoPresu valorCompoPresu = (ValorCompoPresu) iterValoresCompoPresu.next();
    	if (valorCompoPresu.isActivo().booleanValue()) 
    		cargarRegistroValorCompo(dsValorCompo,compoPresu,valorCompoPresu);
    	
    }
    writeCliente(dsValorCompo);
  }
  
  
  private void enviarFiltrosCompo(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = this.getDataFiltroCompo();
    
    int nroOrden = 0;
    IDataSet dsCompoEstrucPlan = mapaDatos.getDataSet("TCompoEstrucPlan");
    dsCompoEstrucPlan.first();
    while (!dsCompoEstrucPlan.EOF()) {
    	Integer oidValCompo = dsCompoEstrucPlan.getInteger("oid_val_compo");
    	CompoPresupuestario compoPresu = 
    		CompoPresupuestario.findByOid(dsCompoEstrucPlan.getInteger("oid_compo_presu"),this.getSesion());
    	if ((oidValCompo == null) || (oidValCompo.intValue()==0)) {
    		++nroOrden;
    		cargarRegistroFitroCompo(dataset,
    				                     new Integer(nroOrden),
    				                     compoPresu,
    				                     new Boolean(false),
    				                     new Boolean(false),
    				                     "SIN_REST");
    	}
    		
    	dsCompoEstrucPlan.next();
    }
    
    
    writeCliente(dataset);
  }

  private IDataSet getDataFiltroCompo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFiltroCompo");
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_compo_presu", Field.STRING, 100));
    dataset.fieldDef(new Field("usar_en_filtro", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("filtro_obligatorio", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tipo_restriccion", Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDataConfFilasPlan() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConfFilasPlan");
    dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_compo_presu", Field.STRING, 100));
    dataset.fieldDef(new Field("mostrar", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("pos_col", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_campo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_campo", Field.STRING, 50));
    dataset.fieldDef(new Field("titulo_columna", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_banda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("agrupar",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("filtros",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("busq_inc",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ordenar",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tipo_orden",Field.STRING, 20));
    dataset.fieldDef(new Field("ancho_col",Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataConfColumnasPlan() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConfColPlan");
    dataset.fieldDef(new Field("nro_int", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_col", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_periodo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_columna", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_periodo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_metrica", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nombre_columna", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_repo_real", Field.INTEGER, 0));
    dataset.fieldDef(new Field("formula", Field.STRING, 255));
    dataset.fieldDef(new Field("formato", Field.STRING, 100));
    dataset.fieldDef(new Field("color_col", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_banda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("ancho_col", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataValCompoFiltro() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValorCompoFiltro");
    dataset.fieldDef(new Field("oid_valor_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_valor_compo_presu", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_valor_compo_presu", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    return dataset;
  }
  
  private void cargarRegistroValorCompo(IDataSet dataset,
  																			CompoPresupuestario compoPresu,
			 																	ValorCompoPresu valorCompoPresu) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_valor_compo_presu", valorCompoPresu.getOIDInteger());
  	dataset.fieldValue("cod_valor_compo_presu", valorCompoPresu.getCodigo());
  	dataset.fieldValue("desc_valor_compo_presu", valorCompoPresu.getDescripcion());
  	dataset.fieldValue("oid_compo_presu", compoPresu.getOIDInteger());
  }
  
  private void cargarRegistroConfFilaPlan(IDataSet dataset,
			 																		Integer nro,
			 																		CompoPresupuestario compoPresu,
			 																		boolean mostrar,
			 																		int posicionCol,
			 																		int nroCampo,
			 																		String descCampo,
			 																		String tituloColumna,
			 																		int oidBanda,
			 																		boolean agrupar,
			 																		boolean filtros,
			 																		boolean busqInc,
			 																		boolean ordenar,
			 																		String tipoOrden,
			 																		int anchoCol) throws BaseException {
			 																		
  	dataset.append();
  	dataset.fieldValue("nro", nro);
  	dataset.fieldValue("oid_compo_presu", compoPresu.getOIDInteger());
  	dataset.fieldValue("desc_compo_presu", compoPresu.getDescripcion());
  	dataset.fieldValue("mostrar", new Boolean(mostrar));
  	dataset.fieldValue("pos_col", new Integer(posicionCol));
  	dataset.fieldValue("nro_campo", new Integer(nroCampo));
  	dataset.fieldValue("desc_campo", descCampo);
  	dataset.fieldValue("titulo_columna", tituloColumna);
  	dataset.fieldValue("oid_banda", new Integer(oidBanda));
  	dataset.fieldValue("agrupar",new Boolean(agrupar));
  	dataset.fieldValue("filtros",new Boolean(filtros));
  	dataset.fieldValue("busq_inc",new Boolean(busqInc));
  	dataset.fieldValue("ordenar",new Boolean(ordenar));
  	dataset.fieldValue("tipo_orden",tipoOrden);
  	dataset.fieldValue("ancho_col",anchoCol);
  }
  
  private void cargarRegistroConfColumnaPlan(IDataSet dataset,
				int nroInterno,
				int nroCol,
				TipoPeriodo tipoPeriodo,
				String tipoColumna,
				int nroPeriodo,
			  Metrica metrica, 
				String nombreColumna,
				RepositorioReal repoReal,
				String formula,
				String formato,
				String colorColumna,
				int oidBanda,
				int anchoColumna) throws BaseException {
	      	
  	
  	dataset.append();
  	dataset.fieldValue("nro_int", new Integer(nroInterno));
  	dataset.fieldValue("nro_col", new Integer(nroCol));
  	if (tipoPeriodo!=null)
  		dataset.fieldValue("oid_tipo_periodo", tipoPeriodo.getOIDInteger());
  	else
  		dataset.fieldValue("oid_tipo_periodo", new Integer(0));
  	dataset.fieldValue("tipo_columna", tipoColumna);
  	dataset.fieldValue("nro_periodo", nroPeriodo);
  	if (metrica!=null)
  		dataset.fieldValue("oid_metrica", metrica.getOIDInteger());
  	else
  		dataset.fieldValue("oid_metrica", 0);
  	dataset.fieldValue("nombre_columna", nombreColumna);
  	if (repoReal!=null)
  		dataset.fieldValue("oid_repo_real", repoReal.getOIDInteger());
  	else
  		dataset.fieldValue("oid_repo_real", 0);
  	dataset.fieldValue("formula", formula);
  	dataset.fieldValue("formato", formato);
  	dataset.fieldValue("color_col", colorColumna);
  	dataset.fieldValue("oid_banda", oidBanda);
  	dataset.fieldValue("ancho_col", anchoColumna);
  	
     	
  	
}
  
  
  
  

  private void cargarRegistroFitroCompo(IDataSet dataset,
  											 Integer nroOrden,
                         CompoPresupuestario compoPresu,
                         Boolean usarEnFiltro,
                         Boolean filtroObligatorio,
                         String tipoRestriccion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_presu", compoPresu.getOIDInteger());
    dataset.fieldValue("nro_orden", nroOrden);
    dataset.fieldValue("desc_compo_presu", compoPresu.getDescripcion());
    dataset.fieldValue("usar_en_filtro", usarEnFiltro);
    dataset.fieldValue("filtro_obligatorio", filtroObligatorio);
    dataset.fieldValue("tipo_restriccion", tipoRestriccion);
  }
  
}
