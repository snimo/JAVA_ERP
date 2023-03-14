package com.srn.erp.implementacion.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.implementacion.bm.TablaGeneral;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class BorrarTablasNuevaIns extends Operation { 

  	
	
  public BorrarTablasNuevaIns() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	 // TABLAS QUE NO SE BORRAR A PROPOSITO
	 // BDCONFIGURACION
	 // BDEMPSUCHAB
	 // CCTIPOCTACLIE
	 // CCTIPOCTAPROV
	 // CGCONCCTASCONTA
	 // CPCONCFACTPROV
	 // CPCONCFACTPROVIMP
 	 // CPCONDCPRAIMP
	 // CPFORMAPAGO
	 // GEEMPRESAS
 	 // GEENTIDAD
	 // GEIDIOMA
	 // GEINDICES
	 // GEMONEDAS
	 // GEPAISES
	 // GEPERIINCCAB
	 // GEPERIINCDET
	 // GEPERIODOS 
	 // GEPROVINCIAS
	 // GESUCURSALES
     // GETIPOCOMPRO 
	 // GETIPOSCAMBIO
	 // GEVALETIIDIOMA
	 // IMCATGAN 
	 // IMCATIB
	 // IMCATIVA 
	 // IMCATRETGAN
	 // IMCATRETIB
	 // IMCATRETIVA
	 // IMCOLLIBROIVA
	 // IMCONCIMPU  (ANALIZARLA PORQUE A ESTA TABLA HAY QUE HACERLE UN TRATAMIENTO ESPECIAL) EJ. BORRAR IMPUTABLES
	 // IMIMPINTERNOS
	 // IMIMPUESTOS
	 // IMTASAIVA 
	 // IMTASAPERCIB
	 // IMTASAPERCIVA
	 // OPPERIRETGAN 
	 // OPPERIRETIB
	 // OPPERIRETIVA
	 // SECLASIFPROG 
	 // SEEMPHABUSU 
	 // SEMODUHABPERFFUNC
 	 // SEOPCBOTPROG
	 // SEPAQUETE
	 // SEPERFFUNCAPLIC
	 // SEPERFFUNCUSU
	 // SEPERFILFUNC
	 // SEPROGHABPERFF
	 // SEPROGRAMAS
	 // SEUNIORGHABUSU
  	 // SEUSUARIOS
	 // SKESTADOSSTOCK
	 // SNAPLICACIONES
	 // SNCLASIFPARAM 
	 // SNDUMMY 
	 // SNMENUTEMA 
	 // SNMODULOS 
	 // SNMODULOSAPLIC 
	 // SNPARAMETROS 
	 // SNTEMAS
	 // SNTEMASMODULO
	 // SNVALORPARAM
	 // STUNIMED
	 // VATIPOVALORES
	 // VECATEGORIA
	 // VEESTADOCIVIL
	 // VETIPODOCUMENTO
	 // VETIPOUNIEDI
	 // GEETIQUETAIDIOMA
	 
	  
	  
	   
	  
	  
	  
	 borradoTablaFisicaTablasDeComponentes();
	 borrarTablas();
	 borrarParametros();
	 borrarColumnasPartTablas();
	 
	 
	 // BORRAR LAS TABLAS FISICAS CREADAS DE COMPONENTES
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
  } 
  
  private void borrarParametros() throws BaseException {
	  TablaGeneral.ejecutarSQL("delete from snValorParam ",this.getSesion());	  
  }
  
  private void borrarTablas() throws BaseException {
	  Iterator iterTablas = 
		  getTablasABorrar().iterator();
	  while (iterTablas.hasNext()) {
		  String tabla = (String) iterTablas.next();
		  try {
		  TablaGeneral.borrarTabla(tabla, this.getSesion());
		  } catch(Exception e) {}
	  }
  }
  
  private void borradoTablaFisicaTablasDeComponentes() throws BaseException {
	  Iterator iterComponentes = 
		  Componente.getAllComponentes(this.getSesion()).iterator();
	  while (iterComponentes.hasNext()) {
		  Componente compo = (Componente) iterComponentes.next();
		  TablaGeneral.dropTabla(compo.getTableName(), this.getSesion());
	  }
	  
  }
  
  private void borrarColumnasPartTablas() throws BaseException {
	  TablaGeneral.ejecutarSQL("UPDATE geTipoCompro SET OID_LEYENDA = NULL ",this.getSesion());
	  TablaGeneral.ejecutarSQL("UPDATE imConcImpu SET OID_AI = NULL",this.getSesion());
  }
  
  
  private List getTablasABorrar() throws BaseException {
	  List tablasABorrar = new ArrayList();
	  tablasABorrar.add("BUBIEN");
	  tablasABorrar.add("BUBIENALTAS");
	  tablasABorrar.add("BUBIENIMPU");
	  tablasABorrar.add("BUBIENVU");
	  tablasABorrar.add("BUCOMPROCAB");
	  tablasABorrar.add("BUCOMPRODET");
	  tablasABorrar.add("BUCOMPVTO");
	  tablasABorrar.add("BUCONFANEXOA");
	  tablasABorrar.add("BUCONFANEXOAMOV");
	  tablasABorrar.add("BUGRUPOBIENUSO");
	  tablasABorrar.add("BUMOVINBIEN");
	  tablasABorrar.add("BUSISTVAL");
	  tablasABorrar.add("BUVIDAUTILGRUPO");
	  tablasABorrar.add("CGANACON");
	  tablasABorrar.add("CGANAIMPCON");
	  tablasABorrar.add("CGANUASIMANDET");
	  tablasABorrar.add("CGANUCABASIMAN");
	  tablasABorrar.add("CGATRIBUTO");
	  tablasABorrar.add("CGATRIENTSEL");
	  tablasABorrar.add("CGCOMPO");
	  tablasABorrar.add("CGCOMPOATRI");
	  tablasABorrar.add("CGCOMPROCABANUASI");
	  tablasABorrar.add("CGCOMPROCABASIMAN");
	  tablasABorrar.add("CGCOMPROCONTA");
	  tablasABorrar.add("CGCOMPROCONTADET");
	  tablasABorrar.add("CGCOMPRODETANUASI");
	  tablasABorrar.add("CGCOMPRODETASIMAN");
	  tablasABorrar.add("CGCRITERIOSELCTA");
	  tablasABorrar.add("CGDIARIO");
	  tablasABorrar.add("CGEJERCICIO");
	  tablasABorrar.add("CGEJERCICIOPERI");
	  tablasABorrar.add("CGESTRUC");
	  tablasABorrar.add("CGESTRUCCOMPO");
	  tablasABorrar.add("CGGENVALCOMPOCI");
	  tablasABorrar.add("CGLEYENDAS");
	  tablasABorrar.add("CGMAYORDIA");
	  tablasABorrar.add("CGMAYORPERI");
	  tablasABorrar.add("CGREPCONTA");
	  tablasABorrar.add("CGREPCONTACOMPO");
	  tablasABorrar.add("CGREPCONTADET");
	  tablasABorrar.add("CGVALATRCRIIMPU");
	  tablasABorrar.add("CPACUERDOSLP");
	  tablasABorrar.add("CPACULPDET");
	  tablasABorrar.add("CPACULPDETDTO");
	  tablasABorrar.add("CPACULPDTOCANT");
	  tablasABorrar.add("CPACULPDTOS");
	  tablasABorrar.add("CPAPLICRETPROV");
	  tablasABorrar.add("CPAPLPROV");
	  tablasABorrar.add("CPARTCONCFACTPROV");
	  tablasABorrar.add("CPAUTORIZADORESOC");
	  tablasABorrar.add("CPAUTORIZCPRA");
	  tablasABorrar.add("CPAUTORIZCPRAMONTO");
	  tablasABorrar.add("CPAUTORIZFACTPROV");
	  tablasABorrar.add("CPAUTORIZFPROLES");
	  tablasABorrar.add("CPAUTORIZREQ");
	  tablasABorrar.add("CPCERTPROV");
	  tablasABorrar.add("CPCOMPROPROV");
	  tablasABorrar.add("CPCOMPROPROVAPL");
	  tablasABorrar.add("CPCOMPROPROVAPLDET");
	  tablasABorrar.add("CPCOMPROPROVCTAIMP");
	  tablasABorrar.add("CPCOMPROPROVDET");
	  tablasABorrar.add("CPCOMPROPROVIMP");
	  tablasABorrar.add("CPCOMPROPROVIROC");
	  tablasABorrar.add("CPCOMPROPROVTOTIMP");
	  tablasABorrar.add("CPCOMPROPROVVTOF");
	  tablasABorrar.add("CPCONDCOMPRA");
	  tablasABorrar.add("CPCONDCOMPRADET");
	  tablasABorrar.add("CPCONDCOMPRAPROV");
	  tablasABorrar.add("CPCONTACPROV");
	  tablasABorrar.add("CPCOTIZPROVCAB");
	  tablasABorrar.add("CPCOTIZPROVDET");
	  tablasABorrar.add("CPCTASCONCFACTPROV");
	  tablasABorrar.add("CPCTRLCALANU");
	  tablasABorrar.add("CPCTRLCALIDAD");
	  tablasABorrar.add("CPCTRLCALIDADDET");
	  tablasABorrar.add("CPDETCCANU");
	  tablasABorrar.add("CPDTOSCOMPROPROV");
	  tablasABorrar.add("CPDTOSPAGO");
	  tablasABorrar.add("CPESQAUTFACTMON");
	  tablasABorrar.add("CPESQAUTFACTPROV");
	  tablasABorrar.add("CPESQAUTFACTSEC");
	  tablasABorrar.add("CPESQAUTORIZ");
	  tablasABorrar.add("CPESQHABPROD");
	  tablasABorrar.add("CPESQHABPRODUSU");
	  tablasABorrar.add("CPFORMAPAGOTV");
	  tablasABorrar.add("CPHAUTORIZFACTPROV");
	  tablasABorrar.add("CPINFRECANU");
	  tablasABorrar.add("CPINFRECDETANU");
	  tablasABorrar.add("CPINFRECEP");
	  tablasABorrar.add("CPINFRECEPDET");
	  tablasABorrar.add("CPLUGENTREGA");
	  tablasABorrar.add("CPMOTIVADJU");
	  tablasABorrar.add("CPMOTIVORECCC");
	  tablasABorrar.add("CPMOTRECINFCC");
	  tablasABorrar.add("CPOBSGENOC");
	  tablasABorrar.add("CPOCCAB");
	  tablasABorrar.add("CPOCCABAUTORIZ");
	  tablasABorrar.add("CPOCDET");
	  tablasABorrar.add("CPOCDETENT");
	  tablasABorrar.add("CPPRECPORCLASIFART");
	  tablasABorrar.add("CPPROVEEDORES");
	  tablasABorrar.add("CPREQUICAB");
	  tablasABorrar.add("CPREQUIDET");
	  tablasABorrar.add("CPREQUIDETAUTORIZ");
	  tablasABorrar.add("CPREQUIDETOCDET");
	  tablasABorrar.add("CPROLAUROTIZ");
	  tablasABorrar.add("CPSECTORCOMPRAS");
	  tablasABorrar.add("CPSOLCOTIZCAB");
	  tablasABorrar.add("CPSOLCOTIZDET");
	  tablasABorrar.add("CPSOLCOTIZDETPROV");
	  tablasABorrar.add("CPSOLCOTIZPROV");
	  tablasABorrar.add("CPTIPOSACUERDOS");
	  tablasABorrar.add("CPTRANPROV");
	  tablasABorrar.add("CPTRANPROVVTO");
	  tablasABorrar.add("CPUSUHABREQ");
	  tablasABorrar.add("CPUSUROLAUTORIZ");
	  tablasABorrar.add("CPVIADESPACHO");
	  tablasABorrar.add("CRMCAMPANIA");
	  tablasABorrar.add("CRMCLASIFOPOR");
	  tablasABorrar.add("CRMESTADOCAMP");
	  tablasABorrar.add("CRMESTADOSOPOR");
	  tablasABorrar.add("CRMMOTIESTOPOR");
	  tablasABorrar.add("CRMOPORTUNIDADES");
	  tablasABorrar.add("CRMSENSACIERRE");
	  tablasABorrar.add("CRMTIPOCAMP");
	  tablasABorrar.add("CUDIMENSIONES");
	  tablasABorrar.add("CUFACTTABLE");
	  tablasABorrar.add("CUGRUPOMODELO");
	  tablasABorrar.add("GEATRIENGRUPO");
	  tablasABorrar.add("GEATRIENT");
	  tablasABorrar.add("GECLASIFENTIDADES");
	  tablasABorrar.add("GECOMENGENERALES");
	  tablasABorrar.add("GECOMPROCAB");
	  tablasABorrar.add("GECONFGENMASPROD");
	  tablasABorrar.add("GECOTIZACION");
	  
	  tablasABorrar.add("GEFACTCONV");
	  tablasABorrar.add("GEGRUPOATRIENTFIJ");
	  tablasABorrar.add("GEGRUPOATRIENTVAR");
	  tablasABorrar.add("GEGRUPOCLASIFENT");
	  tablasABorrar.add("GEGRUPODEATRI");
	  tablasABorrar.add("GEGRUPOSHABENT");
	  tablasABorrar.add("GEIMPCOMUN");
	  tablasABorrar.add("GEIMPFISCAL");
	  tablasABorrar.add("GEINDICESVAL");
	  tablasABorrar.add("GELUGEMI");
	  tablasABorrar.add("GEMOTIVOSCOMPRO");
	  tablasABorrar.add("GEMOTIVOSTC");
	  tablasABorrar.add("GENUMERADOR");
	  tablasABorrar.add("GERTMTALONARIOS");
	  tablasABorrar.add("GETALONARIO ");
	  tablasABorrar.add("GETIPOUNIORG");
	  tablasABorrar.add("GEUNIDADORG");
	  tablasABorrar.add("GEUNIORGTALONARIO");
	  tablasABorrar.add("GEVALCLASIFENT");
	  tablasABorrar.add("GEZONAS");
	  tablasABorrar.add("IMLISTADOIVACAB");
	  tablasABorrar.add("IMLISTADOIVAIMPU");
	  tablasABorrar.add("IMPORCLIBRETGAN");
	  tablasABorrar.add("IMPORCLIBRETIB");
	  tablasABorrar.add("IMPORCLIBRETIVA");
	  tablasABorrar.add("IMRETPORCLIB");
	  tablasABorrar.add("IMSUJETOIMPOSITIVO");
	  tablasABorrar.add("IMTALHABCATIVA");
	  tablasABorrar.add("OPANUFFPROV");
	  tablasABorrar.add("OPANUFFVALORES");
	  tablasABorrar.add("OPANUOPCAB");
	  tablasABorrar.add("OPANUOPMEDPAG");
	  tablasABorrar.add("OPANURENDFF");
	  tablasABorrar.add("OPCOMPROCABOP");
	  tablasABorrar.add("OPCOMPROCABOPDET");
	  tablasABorrar.add("OPCOMPROOPMEDPAGO");
	  tablasABorrar.add("OPCOMPROOPRETCIMP");
	  tablasABorrar.add("OPCOMPRORETGAN");
	  tablasABorrar.add("OPCOMPRORETGANDET");
	  tablasABorrar.add("OPCOMPRORETIB");
	  tablasABorrar.add("OPCOMPRORETIBDET");
	  tablasABorrar.add("OPCOMPRORETIVA");
	  tablasABorrar.add("OPCOMPRORETIVADET");
	  tablasABorrar.add("OPCONCPAGOSVAR");
	  tablasABorrar.add("OPCONCPVHAB");
	  tablasABorrar.add("OPMOTIVOSPAGO");
	  tablasABorrar.add("OPRENDFFCOMPRO");
	  tablasABorrar.add("OPRENDFFCOMPROIMPU");
	  tablasABorrar.add("OPRENDFFIMPU");
	  tablasABorrar.add("OPRENDFFIMPUESTOS");
	  tablasABorrar.add("OPRENDFFMEDPAGO");
	  tablasABorrar.add("OPRENDFONDOFIJO");
	  tablasABorrar.add("OPRETCABGAN");
	  tablasABorrar.add("OPRETCABGANDET");
	  tablasABorrar.add("OPRETCABIB");
	  tablasABorrar.add("OPRETCABIBDET");
	  tablasABorrar.add("OPRETCABIVA");
	  tablasABorrar.add("OPRETCABIVADET");
	  tablasABorrar.add("OPRETGANPAGOACUM");
	  tablasABorrar.add("OPUNIORGFF");
	  tablasABorrar.add("OPUNIORGFFCTA");
	  tablasABorrar.add("PESTRUCPLANCOMPO");
	  tablasABorrar.add("PLATRIBUTOS");
	  tablasABorrar.add("PLATRICOMPOPRESU");
	  tablasABorrar.add("PLATRIDICC");
	  tablasABorrar.add("PLCICLO");
	  tablasABorrar.add("PLCOMPOESCENARIO");
	  tablasABorrar.add("PLCOMPOPRESU");
	  tablasABorrar.add("PLDICCIONARIO");
	  tablasABorrar.add("PLELEMENTOUPC");
	  tablasABorrar.add("PLESCENARIO");
	  tablasABorrar.add("PLESCENARIOPRESU");
	  tablasABorrar.add("PLESTRUCPLAN");
	  tablasABorrar.add("PLESTRUCPLANIF");
	  tablasABorrar.add("PLESTRUCTIPOCICLO");
	  tablasABorrar.add("PLESTVERPLANIF");
	  tablasABorrar.add("PLESTVERPLANIFDET");
	  tablasABorrar.add("PLGRUPOCOMPO");
	  tablasABorrar.add("PLGRUPOESTPLANIF");
	  tablasABorrar.add("PLGRUPOREPOREAL");
	  tablasABorrar.add("PLGRUPOTIPOUPC");
	  tablasABorrar.add("PLGRUPOTIPOUPCDET");
	  tablasABorrar.add("PLGUPCTIPOCICLO");
	  tablasABorrar.add("PLMETRICA");
	  tablasABorrar.add("PLMONEDASPRESU");
	  tablasABorrar.add("PLNODOESTRUCPLANIF");
	  tablasABorrar.add("PLPERIODO");
	  tablasABorrar.add("PLPLANPRESU");
	  tablasABorrar.add("PLREPOREAL");
	  tablasABorrar.add("PLREPOREALDET");
	  tablasABorrar.add("PLTIPOCICLO");
	  tablasABorrar.add("PLTIPOPERI");
	  tablasABorrar.add("PLTIPOPLAN");
	  tablasABorrar.add("PLTIPOPRESUPUESTO");
	  tablasABorrar.add("PLTIPOSHABUPC"); 
	  tablasABorrar.add("PLTIPOUPC"); 
	  tablasABorrar.add("PLTITULOATRI");
	  tablasABorrar.add("PLUPC"); 
	  tablasABorrar.add("PLUPCNODO"); 
	  tablasABorrar.add("PLVALCOMPO"); 
	  tablasABorrar.add("PLVALDEFECTOATRI"); 
	  tablasABorrar.add("PLVALEQUIVREPOREAL"); 
	  tablasABorrar.add("PLVALORCOMPOREAL"); 
	  tablasABorrar.add("PLVALORESCENARIO"); 
	  tablasABorrar.add("PLVALORVARESCE"); 
	  tablasABorrar.add("PLVALREPOREAL"); 
	  tablasABorrar.add("PLVARESCECAB"); 
	  tablasABorrar.add("PLVARESCEDET"); 
	  tablasABorrar.add("PRRECCAB"); 
	  tablasABorrar.add("PRRECDET"); 
	  tablasABorrar.add("RB_FIELD"); 
	  tablasABorrar.add("RB_FOLDER"); 
	  tablasABorrar.add("RB_ITEM"); 
	  tablasABorrar.add("RB_JOIN"); 
	  tablasABorrar.add("RB_TABLE");
	  tablasABorrar.add("SKAGRUPADORDEPDET");
	  tablasABorrar.add("SKAGRUPADORDEPO");
	  tablasABorrar.add("SKAGRUPESTADOSDEPO");
	  tablasABorrar.add("SKAJUSTESTKCAB");
	  tablasABorrar.add("SKAJUSTESTKDET");
	  tablasABorrar.add("SKAJUSTKCABANU");
	  tablasABorrar.add("SKAJUSTKDETANU");
	  tablasABorrar.add("SKAJUSTKDETMOV");
	  tablasABorrar.add("SKAJUSTKMOVCAB");
	  tablasABorrar.add("SKAJUSTKPARTSERIE");
	  tablasABorrar.add("SKCOMPOTALAJUSTK");
	  tablasABorrar.add("SKCONFMOVSTKTAL");
	  tablasABorrar.add("SKCONFTALAJUSTK");
	  tablasABorrar.add("SKDEPOSITO");
	  tablasABorrar.add("SKESTADOSDEPO");
	  tablasABorrar.add("SKINVENTARIOCAB");
	  tablasABorrar.add("SKINVENTARIODET");
	  tablasABorrar.add("SKMOVSTKTAL");
	  tablasABorrar.add("SKOPERHABTALAJUSTK");
	  tablasABorrar.add("SKPARTIDA");
	  tablasABorrar.add("SKPERIODOSREALES");
	  tablasABorrar.add("SKPRODHABUBIDEPO");
	  tablasABorrar.add("SKSERIE");
	  tablasABorrar.add("SKSTOCKCAB");
	  tablasABorrar.add("SKSTOCKDIA");
	  tablasABorrar.add("SKSTOCKESTADODIA");
	  tablasABorrar.add("SKSTOCKMOV");
	  tablasABorrar.add("SKSTOCKPERI");
	  tablasABorrar.add("SKSTOCKSALDOESTADO");
	  tablasABorrar.add("SKSTOCKSALDOPROD");
	  tablasABorrar.add("SKSTOCKSALDOUBI");
	  tablasABorrar.add("SKSTOCKSALDOUBIEST");
	  tablasABorrar.add("SKSTOCKSALESTITEM");
	  tablasABorrar.add("SKSTOCKSALPARTSER");
	  tablasABorrar.add("SKTIPOCONFMOVSTK");
	  tablasABorrar.add("SKTRANSPORTE");
	  tablasABorrar.add("SKUBIDEPOHABTAL");
	  tablasABorrar.add("SKUBIDEPOSITO");
	  tablasABorrar.add("SNCATEGSOCIOS");
	  tablasABorrar.add("STCONCFACTPG");
	  tablasABorrar.add("STCONCIMPUPROD");
	  tablasABorrar.add("STCOSTOSPRODGRAL");
	  tablasABorrar.add("STCOSTOSPRODUCTO");
	  tablasABorrar.add("STEQUIVUMPROD");
	  tablasABorrar.add("STEXTENSIONPG");
	  tablasABorrar.add("STFACTCONVPROV");
	  tablasABorrar.add("STPRODPROVEECAPG");
	  tablasABorrar.add("STPRODPROVEEDOR");
	  tablasABorrar.add("STPRODUCTO");
	  tablasABorrar.add("STPRODUCTOATRI");
	  tablasABorrar.add("STSEGUISTOCK");
	  tablasABorrar.add("STTIPOPRODUCTO");
	  tablasABorrar.add("TEANURECCAB");
	  tablasABorrar.add("TEANURECVAL");
	  tablasABorrar.add("TECTASINGVAR");
	  tablasABorrar.add("TEFACTENRECIBOS");
	  tablasABorrar.add("TEINGVARUNIORG");
	  tablasABorrar.add("TEMOTHABCOBCLI");
	  tablasABorrar.add("TEMOTHABINGVAR"); 
	  tablasABorrar.add("TEMOTVARINGREC"); 
	  tablasABorrar.add("TERECIBOCAB"); 
	  tablasABorrar.add("TETRANSFEFE"); 
	  tablasABorrar.add("TETRANSFVAL"); 
	  tablasABorrar.add("TETRANSFVALORES"); 
	  tablasABorrar.add("TEVALENRECIBOS"); 
	  tablasABorrar.add("VAARQUEO"); 
	  tablasABorrar.add("VABANCOS"); 
	  tablasABorrar.add("VABOLDEPDET"); 
	  tablasABorrar.add("VABOLETADEPOSITO"); 
	  tablasABorrar.add("VACAJA"); 
	  tablasABorrar.add("VACAJAAPERCIERRE"); 
	  tablasABorrar.add("VACTASHABBANCOS"); 
	  tablasABorrar.add("VACUENTABANCARIA"); 
	  tablasABorrar.add("VAGASTOSBOLDEP"); 
	  tablasABorrar.add("VAMOVIMBANCO"); 
	  tablasABorrar.add("VAMOVIMBCOSFEC"); 
	  tablasABorrar.add("VAMOVIMBCOSPERI"); 
	  tablasABorrar.add("VANDNCBANCARIA"); 
	  tablasABorrar.add("VANDNCDET"); 
	  tablasABorrar.add("VATARJETASCREDITO"); 
	  tablasABorrar.add("VATICKETS"); 
	  tablasABorrar.add("VAVALORES");   
	  tablasABorrar.add("VEANUCOBVTAMOS"); 
	  tablasABorrar.add("VEANUFACTCAB"); 
	  tablasABorrar.add("VEANUFACTDET"); 
	  tablasABorrar.add("VEAPLCLIE"); 
	  tablasABorrar.add("VECANAL"); 
	  tablasABorrar.add("VECLASIFSUJ"); 
	  tablasABorrar.add("VECOBRABZAVTAMOS"); 
	  tablasABorrar.add("VECOBRADOR"); 
	  tablasABorrar.add("VECOMPOSTKTALFACT"); 
	  tablasABorrar.add("VECOMPOSTKTALRTO"); 
	  tablasABorrar.add("VECOMPROCLIEAPL"); 
	  tablasABorrar.add("VECOMPROCLIEAPLDET"); 
	  tablasABorrar.add("VECONDPAGO"); 
	  tablasABorrar.add("VECONDPAGOCHEQUE"); 
	  tablasABorrar.add("VECONDPAGOCUOTAS"); 
	  tablasABorrar.add("VECONDPAGOTIPOVAL"); 
	  tablasABorrar.add("VECONDPAGOUNIORG"); 
	  tablasABorrar.add("VECONDVENTA"); 
	  tablasABorrar.add("VECONDVENTADET"); 
	  tablasABorrar.add("VECONDVTAEXPIMP"); 
	  tablasABorrar.add("VECONFPRODGRALLP"); 
	  tablasABorrar.add("VECONFPRODPORLP"); 
	  tablasABorrar.add("VECONFTALFACT"); 
	  tablasABorrar.add("VECONFTALRTO"); 
	  tablasABorrar.add("VECONTACSUJ"); 
	  tablasABorrar.add("VECOTCABANU"); 
	  tablasABorrar.add("VECOTDETANU"); 
	  tablasABorrar.add("VEDEFESTRUCLPCAB"); 
	  tablasABorrar.add("VEDEFESTRUCLPDET"); 
	  tablasABorrar.add("VEESQBONIFCLASIF"); 
	  tablasABorrar.add("VEESQBONIFPROD"); 
	  tablasABorrar.add("VEESQBONIFPRODDET"); 
	  tablasABorrar.add("VEESQBONIFVIGSUJ"); 
	  tablasABorrar.add("VEESQUEMABONIF"); 
	  tablasABorrar.add("VEESTADOSITUACION"); 
	  tablasABorrar.add("VEFACTCABIMPU"); 
	  tablasABorrar.add("VEFACTURADOREMITO"); 
	  tablasABorrar.add("VEFACTURASCAB"); 
	  tablasABorrar.add("VEFACTURASDET"); 
	  tablasABorrar.add("VEFECFACTSUC"); 
	  tablasABorrar.add("VEFORMAENTREGA"); 
	  tablasABorrar.add("VEGRUPOCONDPAGO"); 
	  tablasABorrar.add("VEGRUPODETVTA"); 
	  tablasABorrar.add("VELIBIMPUSUJ"); 
	  tablasABorrar.add("VELISTAPRECIOCP"); 
	  tablasABorrar.add("VELISTAPRECIOSUJ"); 
	  tablasABorrar.add("VELOGSIMPFIS"); 
	  tablasABorrar.add("VELUGARENTREGAVTA"); 
	  tablasABorrar.add("VENCSOBREFACT"); 
	  tablasABorrar.add("VEOPERHABTALFACT");
	  tablasABorrar.add("VEOPERHABTALRTO"); 
	  tablasABorrar.add("VEPEDCABANU"); 
	  tablasABorrar.add("VEPEDDETANU"); 
	  tablasABorrar.add("VEPEDIDODESPACHOS"); 
	  tablasABorrar.add("VEPEDIDOFACTURADO"); 
	  tablasABorrar.add("VEPEDIDOSCAB"); 
	  tablasABorrar.add("VEPEDIDOSDET"); 
	  tablasABorrar.add("VEPERCIBBSAS"); 
	  tablasABorrar.add("VEPRECIOCABUNIORG"); 
	  tablasABorrar.add("VEPRECIOSCAB"); 
	  tablasABorrar.add("VEPRECIOSDET"); 
	  tablasABorrar.add("VEPRECIOSESTLP"); 
	  tablasABorrar.add("VEPRESUCAB"); 
	  tablasABorrar.add("VEPRESUDET"); 
	  tablasABorrar.add("VERELACION"); 
	  tablasABorrar.add("VEREMITOCAB"); 
	  tablasABorrar.add("VEREMITODET"); 
	  tablasABorrar.add("VERTOCABANU"); 
	  tablasABorrar.add("VERTOCABMOVSTK"); 
	  tablasABorrar.add("VERTODETANU"); 
	  tablasABorrar.add("VERTODETMOVSTOCK"); 
	  tablasABorrar.add("VERTODETPARTSERIE"); 
	  tablasABorrar.add("VERUBRO"); 
	  tablasABorrar.add("VESECTORDIRECCION"); 
	  tablasABorrar.add("VESUJBONIFRECAR"); 
	  tablasABorrar.add("VESUJETO");
	  tablasABorrar.add("VETRANCLIE");
	  tablasABorrar.add("VETRANCLIEVTO");
	  tablasABorrar.add("VEUNIDADEDILICIA");
	  tablasABorrar.add("VEVENDEDOR");
	  tablasABorrar.add("VEZONAS");
	  tablasABorrar.add("XLCAMPOSPRESEN"); 
	  tablasABorrar.add("XLDOMHAB"); 
	  tablasABorrar.add("XLDOMINIOXLOOK"); 
	  tablasABorrar.add("XLFIELD"); 
	  tablasABorrar.add("XLFILTROSVISTA"); 
	  tablasABorrar.add("XLFILTROWHERE"); 
	  tablasABorrar.add("XLFROM"); 
	  tablasABorrar.add("XLGROUPBY"); 
	  tablasABorrar.add("XLOBJETOXLOOK"); 
	  tablasABorrar.add("XLOPERACIONES"); 
	  tablasABorrar.add("XLOPERHAB"); 
	  tablasABorrar.add("XLPREFORMSEARCH"); 
	  tablasABorrar.add("XLPRESENTACION"); 
	  tablasABorrar.add("XLRELACIONDOMINIO"); 
	  tablasABorrar.add("XLRELDOMHAB"); 
	  tablasABorrar.add("XLRELOBJXLOOK"); 
	  tablasABorrar.add("XLSELECT"); 
	  tablasABorrar.add("XLTABLAXLOOK"); 
	  tablasABorrar.add("XLTIPODOMINIO"); 
	  tablasABorrar.add("XLVISTA"); 
	  tablasABorrar.add("XLWHERE");
	  tablasABorrar.add("BDEMPSUCHAB");
	  
	  return tablasABorrar;
  }

  
}
