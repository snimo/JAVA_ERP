package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.bm.AnteojoExcluido;
import com.srn.erp.excluidos.bm.CaracterExcluido;
import com.srn.erp.excluidos.bm.CargoLegajoExcluido;
import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.bm.ColorExcluido;
import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.bm.DifImporteExcluido;
import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.GerenteExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.LugarHechoExcluido;
import com.srn.erp.excluidos.bm.MarcaExcluido;
import com.srn.erp.excluidos.bm.MotDifPagoExc;
import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.RasgoExcluido;
import com.srn.erp.excluidos.bm.RazaExcluido;
import com.srn.erp.excluidos.bm.SeRetiraEnExc;
import com.srn.erp.excluidos.bm.SectorLegajoExcluido;
import com.srn.erp.excluidos.bm.SupervisorExcluido;
import com.srn.erp.excluidos.bm.TipoBarba;
import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
import com.srn.erp.excluidos.bm.TipoNariz;
import com.srn.erp.excluidos.bm.TurnoExcluido;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDatosInicioExcluidos extends Operation {

	IndividuoExcluido individuoExcluido = null;
	
	public TraerDatosInicioExcluidos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		if  (mapaDatos.containsKey("oid_individuo")) 
			individuoExcluido = IndividuoExcluido.findByOid(mapaDatos.getInteger("oid_individuo"), this.getSesion()); 
		
		IDataSet dsTipoIndi = this.getDataSetTipoIndividuos();
		IDataSet dsTipoDocu = this.getDataSetTipoDocumento();
		IDataSet dsNacionalidad = this.getDataSetNacionalidad();
		IDataSet dsSexo = this.getDataSetSexo();
		IDataSet dsRaza = getDataSetRaza();
		IDataSet dsAltura = getDataSetAltura();
		IDataSet dsComplexion = this.getDataSetComplexion();
		IDataSet dsEdad = this.getDataSetEdad();
		IDataSet dsColor = this.getDataSetColor();
		IDataSet dsTipoBarba = this.getDataSetTipoBarba();
		IDataSet dsTipoCabello = this.getDataSetCabello();
		IDataSet dsTipoNariz = this.getDataSetNariz();
		IDataSet dsEstados = this.getDataSetEstados();
		IDataSet dsSector = this.getDataSetSector();
		IDataSet dsCargo = this.getDataSetCargo();
		IDataSet dsCondicion = this.getDataSetCondicion();
		IDataSet dsMonedas = this.getDataSetMonedas();
		IDataSet dsMotDifPago = this.getDataSetMotivosDigPago();
		IDataSet dsMotNov = this.getDataSetMotNov();
		IDataSet dsSupExc = this.getDataSetSupervisor();
		IDataSet dsTurno = this.getDataSetTurno();
		IDataSet dsSeRetira = this.getDataSetSeRetira();
		IDataSet dsColorCabello = this.getDataSetColorCabello();
		IDataSet dsCaracter = getDataSetCaracter();
		IDataSet dsGerentes = getDataSetGerentes();
		IDataSet dsLugarHecho = getDataSetLugarHecho(); 
		IDataSet dsMarcas = getDataSetMarcas();
		IDataSet dsRasgos = getDataSetRasgos();
		IDataSet dsAnteojos = getDataSetAnteojos(); 
		IDataSet dsPeligrosidad = getDataSetPeligrosidad();
		IDataSet dsPredios = this.getDataSetPredios();
		
		
		
		enviarTiposIndividuos(dsTipoIndi,individuoExcluido);
		enviarTiposTiposDocu(dsTipoDocu,individuoExcluido);
		enviarNacionalidades(dsNacionalidad,individuoExcluido);
		enviarSexo(dsSexo,individuoExcluido);
		enviarRaza(dsRaza,individuoExcluido);
		enviarAltura(dsAltura,individuoExcluido);
		enviarComplexion(dsComplexion,individuoExcluido);
		enviarEdades(dsEdad,individuoExcluido);
		enviarColor(dsColor,individuoExcluido);
		enviarTiposBarba(dsTipoBarba,individuoExcluido);
		enviarTipoCabello(dsTipoCabello,individuoExcluido);
		enviarTiposNariz(dsTipoNariz,individuoExcluido);
		enviarEstados(dsEstados,individuoExcluido);
		enviarSector(dsSector,individuoExcluido);
		enviarCargo(dsCargo,individuoExcluido);
		enviarCondicion(dsCondicion,individuoExcluido);
		enviarMonedas(dsMonedas,individuoExcluido);
		enviarMotDif(dsMotDifPago,individuoExcluido);
		enviarMotNov(dsMotNov,individuoExcluido);
		enviarSupervisor(dsSupExc,individuoExcluido);
		enviarTurno(dsTurno,individuoExcluido);
		enviarSeRetita(dsSeRetira,individuoExcluido);
		enviarColorCabello(dsColorCabello,individuoExcluido);
		enviarCaracter(dsCaracter,individuoExcluido);
		enviarGerentes(dsGerentes,individuoExcluido);
		enviarLugarHecho(dsLugarHecho,individuoExcluido);
		enviarMarcas(dsMarcas,individuoExcluido);
		enviarRasgos(dsRasgos,individuoExcluido);
		enviarTiposAnteojos(dsAnteojos,individuoExcluido);
		enviarPeligrosidad(dsPeligrosidad,individuoExcluido);
		enviarPredios(dsPredios,individuoExcluido);
		
		
		
		writeCliente(dsTipoIndi);
		writeCliente(dsTipoDocu);
		writeCliente(dsNacionalidad);
		writeCliente(dsSexo);
		writeCliente(dsRaza);
		writeCliente(dsAltura);
		writeCliente(dsComplexion);
		writeCliente(dsEdad);
		writeCliente(dsColor);
		writeCliente(dsTipoBarba);
		writeCliente(dsTipoCabello);
		writeCliente(dsTipoNariz);
		writeCliente(dsEstados);
		writeCliente(dsSector);
		writeCliente(dsCargo);
		writeCliente(dsCondicion);
		writeCliente(dsMonedas);
		writeCliente(dsMotDifPago);
		writeCliente(dsMotNov);
		writeCliente(dsSupExc);
		writeCliente(dsTurno);
		writeCliente(dsSeRetira);
		writeCliente(dsColorCabello);
		writeCliente(dsCaracter);
		writeCliente(dsGerentes);
		writeCliente(dsLugarHecho);
		writeCliente(dsMarcas);
		writeCliente(dsRasgos);
		writeCliente(dsAnteojos);
		writeCliente(dsPeligrosidad);
		writeCliente(dsPredios);
		
		
	}

	private IDataSet getDataSetTipoDocumento() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoDocumento");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	

	private IDataSet getDataSetRaza() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRaza");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetMotivosDigPago() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosDifPago");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetMonedas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMonedas");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetColorCabello() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColorCabello");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	
	private IDataSet getDataSetNariz() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNariz");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetSupervisor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSupervisor");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	
	
	
	
	private IDataSet getDataSetCabello() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCabello");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetMotNov() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivoNovedad");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetCondicion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondicion");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	
	
	private IDataSet getDataSetColor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColor");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetPredios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPredios");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}	
	
	
	private IDataSet getDataSetNacionalidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNacionalidad");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetAltura() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAltura");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetComplexion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComplexion");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetEdad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEdad");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetTipoBarba() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoBarba");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	
	private IDataSet getDataSetTipoIndividuos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoEmpleado");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetEstados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstados");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("color", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getDataSetLugarHecho() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLugarHecho");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetPeligrosidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPeligrosidad");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetCaracter() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCaracter");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetGerentes() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGerentes");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetMarcas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMarcas");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetAnteojos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAnteojos");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	

	private IDataSet getDataSetRasgos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRasgos");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	
	private IDataSet getDataSetSector() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSector");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetTurno() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTurno");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetCargo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCargo");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetSeRetira() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSeRetira");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	private IDataSet getDataSetSexo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSexo");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	
	private void cargarRegistroTipoDocu(IDataSet dataset, TipoDocumento tipoDocu) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", tipoDocu.getOIDInteger());
		dataset.fieldValue("codigo", tipoDocu.getCodigo());
		dataset.fieldValue("descripcion", tipoDocu.getDescripcion());
	}
	
	private void cargarRegistroPeligrosidad(IDataSet dataset, PeligrosidadExcluido peligrosidad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", peligrosidad.getOIDInteger());
		dataset.fieldValue("codigo", peligrosidad.getCodigo());
		dataset.fieldValue("descripcion", peligrosidad.getDescripcion());
	}	
	
	private void cargarRegistroPredio(IDataSet dataset, PredioExcluido predio) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", predio.getOIDInteger());
		dataset.fieldValue("codigo", predio.getCodigo());
		dataset.fieldValue("descripcion", predio.getDescripcion());
	}	
	
	private void cargarRegistroTipoNariz(IDataSet dataset, TipoNariz tipoNariz) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", tipoNariz.getOIDInteger());
		dataset.fieldValue("codigo", tipoNariz.getCodigo());
		dataset.fieldValue("descripcion", tipoNariz.getDescripcion());
	}
	
	private void cargarRegistroTurno(IDataSet dataset, TurnoExcluido aTurno) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", aTurno.getOIDInteger());
		dataset.fieldValue("codigo", aTurno.getCodigo());
		dataset.fieldValue("descripcion", aTurno.getDescripcion());
	}
	
	private void cargarRegistroSeRetiraEn(IDataSet dataset, SeRetiraEnExc aSeRetira) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", aSeRetira.getOIDInteger());
		dataset.fieldValue("codigo", aSeRetira.getCodigo());
		dataset.fieldValue("descripcion", aSeRetira.getDescripcion());
	}
	
	
	
	private void cargarRegistroCargo(IDataSet dataset, CargoLegajoExcluido cargo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", cargo.getOIDInteger());
		dataset.fieldValue("codigo", cargo.getCodigo());
		dataset.fieldValue("descripcion", cargo.getDescripcion());
	}
	
	private void cargarRegistroColorCabello(IDataSet dataset, ColorCabelloExcluido color) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", color.getOIDInteger());
		dataset.fieldValue("codigo", color.getCodigo());
		dataset.fieldValue("descripcion", color.getDescripcion());
	}

	private void cargarRegistroGerente(IDataSet dataset, GerenteExcluido gerente) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", gerente.getOIDInteger());
		dataset.fieldValue("codigo", gerente.getCodigo());
		dataset.fieldValue("descripcion", gerente.getDescripcion());
	}
	
	private void cargarRegistroLugarHecho(IDataSet dataset, LugarHechoExcluido lugar) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", lugar.getOIDInteger());
		dataset.fieldValue("codigo", lugar.getCodigo());
		dataset.fieldValue("descripcion", lugar.getDescripcion());
	}
	
	private void cargarRegistroCaracter(IDataSet dataset, CaracterExcluido caracter) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", caracter.getOIDInteger());
		dataset.fieldValue("codigo", caracter.getCodigo());
		dataset.fieldValue("descripcion", caracter.getDescripcion());
	}
	
	
	private void cargarRegistroSector(IDataSet dataset, SectorLegajoExcluido sector) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", sector.getOIDInteger());
		dataset.fieldValue("codigo", sector.getCodigo());
		dataset.fieldValue("descripcion", sector.getDescripcion());
	}
	
	private void cargarRegistroCabello(IDataSet dataset, TipoCabelloExcluido tipoCabello) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", tipoCabello.getOIDInteger());
		dataset.fieldValue("codigo", tipoCabello.getCodigo());
		dataset.fieldValue("descripcion", tipoCabello.getDescripcion());
	}
	
	
	private void cargarRegistroColor(IDataSet dataset, ColorExcluido color) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", color.getOIDInteger());
		dataset.fieldValue("codigo", color.getCodigo());
		dataset.fieldValue("descripcion", color.getDescripcion());
	}
	
	private void cargarRegistroMarca(IDataSet dataset, MarcaExcluido marca) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", marca.getOIDInteger());
		dataset.fieldValue("codigo", marca.getCodigo());
		dataset.fieldValue("descripcion", marca.getDescripcion());
	}
	
	private void cargarRegistroRasgo(IDataSet dataset, RasgoExcluido rasgo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", rasgo.getOIDInteger());
		dataset.fieldValue("codigo", rasgo.getCodigo());
		dataset.fieldValue("descripcion", rasgo.getDescripcion());
	}
	
	
	
	private void cargarRegistroTipoBarba(IDataSet dataset, TipoBarba tipoBarba) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", tipoBarba.getOIDInteger());
		dataset.fieldValue("codigo", tipoBarba.getCodigo());
		dataset.fieldValue("descripcion", tipoBarba.getDescripcion());
	}
	
	private void cargarRegistroCondicion(IDataSet dataset,String codigo,String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);		
	}
	
	private void cargarRegistroAltura(IDataSet dataset, AlturaExcluido altura) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", altura.getOIDInteger());
		dataset.fieldValue("codigo", altura.getCodigo());
		dataset.fieldValue("descripcion", altura.getDescripcion());
	}
	
	private void cargarRegistroSupervisor(IDataSet dataset, SupervisorExcluido supervisor) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", supervisor.getOIDInteger());
		dataset.fieldValue("codigo", supervisor.getCodigo());
		dataset.fieldValue("descripcion", supervisor.getDescripcion());
	}	
	
	private void cargarRegistroAnteojo(IDataSet dataset, AnteojoExcluido anteojo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", anteojo.getOIDInteger());
		dataset.fieldValue("codigo", anteojo.getCodigo());
		dataset.fieldValue("descripcion", anteojo.getDescripcion());
	}
	
	
	private void cargarRegistroNacionalidad(IDataSet dataset, Nacionalidad nacionalidad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", nacionalidad.getOIDInteger());
		dataset.fieldValue("codigo", nacionalidad.getCodigo());
		dataset.fieldValue("descripcion", nacionalidad.getDescripcion());
	}
	
	private void cargarRegistroMonedas(IDataSet dataset, Moneda moneda) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", moneda.getOIDInteger());
		dataset.fieldValue("codigo", moneda.getCodigo());
		dataset.fieldValue("descripcion", moneda.getDescripcion());
	}	
	
	
	private void cargarRegistroMotDifPago(IDataSet dataset, MotDifPagoExc motDifPago) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", motDifPago.getOIDInteger());
		dataset.fieldValue("codigo", motDifPago.getCodigo());
		dataset.fieldValue("descripcion", motDifPago.getDescripcion());
	}	
	
	private void cargarRegistroRaza(IDataSet dataset, RazaExcluido aRaza) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", aRaza.getOIDInteger());
		dataset.fieldValue("codigo", aRaza.getCodigo());
		dataset.fieldValue("descripcion", aRaza.getDescripcion());
	}
	
	private void cargarRegistroComplexion(IDataSet dataset, ComplexionExcluido complexion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", complexion.getOIDInteger());
		dataset.fieldValue("codigo", complexion.getCodigo());
		dataset.fieldValue("descripcion", complexion.getDescripcion());
	}

	private void cargarMotDifImp(IDataSet dataset, MotDifPagoExc motDifPagoExc) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", motDifPagoExc.getOIDInteger());
		dataset.fieldValue("codigo", motDifPagoExc.getCodigo());
		dataset.fieldValue("descripcion", motDifPagoExc.getDescripcion());
	}
	
	private void cargarMotNovedad(IDataSet dataset, MotivoNovedadExcluido motivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", motivo.getOIDInteger());
		dataset.fieldValue("codigo", motivo.getCodigo());
		dataset.fieldValue("descripcion", motivo.getDescripcion());
	}	
	
	
	
	private void cargarRegistroEdad(IDataSet dataset, EdadExcluido edad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", edad.getOIDInteger());
		dataset.fieldValue("codigo", edad.getCodigo());
		dataset.fieldValue("descripcion", edad.getDescripcion());
	}
	
	private void cargarRegistroEstado(IDataSet dataset, EstadoExcluido estado) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", estado.getOIDInteger());
		dataset.fieldValue("codigo", estado.getCodigo());
		dataset.fieldValue("descripcion", estado.getDescripcion());
		if (estado.getColor()!=null)
			dataset.fieldValue("color", (String)EstadoExcluido.getCodigosColores().get(estado.getColor()));
		else
			dataset.fieldValue("color", "");
	}
	
	
	
	
	private void cargarRegistro(IDataSet dataset, String codigo,String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	
	
	private void enviarNacionalidades(IDataSet dsNacionalidades  , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterNacionalidades = 
			Nacionalidad.getAllActivos(this.getSesion()).iterator();
		while (iterNacionalidades.hasNext()) {
			Nacionalidad nacionalidad = (Nacionalidad) iterNacionalidades.next();
			cargarRegistroNacionalidad(dsNacionalidades, nacionalidad);
		}
		
		if (individuoExcluido!=null)
			if (individuoExcluido.getNacionalidad()!=null)
				if (!individuoExcluido.getNacionalidad().isActivo())
					cargarRegistroNacionalidad(dsNacionalidades, individuoExcluido.getNacionalidad());
				
		
	}
	
	private void enviarTiposBarba(IDataSet dsTiposBarba , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterTiposBarba = 
			TipoBarba.getAllActivos(this.getSesion()).iterator();
		while (iterTiposBarba.hasNext()) {
			TipoBarba tipoBarba = (TipoBarba) iterTiposBarba.next();
			cargarRegistroTipoBarba(dsTiposBarba, tipoBarba);
		}
		
		if (individuoExcluido!=null)
			if (individuoExcluido.getTipo_barba()!=null)
				if (!individuoExcluido.getTipo_barba().isActivo())
					cargarRegistroTipoBarba(dsTiposBarba, individuoExcluido.getTipo_barba());					
		
	}
	
	private void enviarTiposNariz(IDataSet dsTiposNariz , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterTiposNariz = 
			TipoNariz.getAllActivos(this.getSesion()).iterator();
		while (iterTiposNariz.hasNext()) {
			TipoNariz tipoNariz = (TipoNariz) iterTiposNariz.next();
			cargarRegistroTipoNariz(dsTiposNariz, tipoNariz);
		}
		
		if (individuoExcluido!=null)
			if (individuoExcluido.getTipo_nariz()!=null)
				if (!individuoExcluido.getTipo_nariz().isActivo())
					cargarRegistroTipoNariz(dsTiposNariz, individuoExcluido.getTipo_nariz());					
		
		
	}
	
	
	
	private void enviarEdades(IDataSet dsEdades , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterEdades = 
			EdadExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterEdades.hasNext()) {
			EdadExcluido edad = (EdadExcluido) iterEdades.next();
			cargarRegistroEdad(dsEdades, edad);
		}
	
		if (individuoExcluido!=null)
			if (individuoExcluido.getEdad()!=null)
				if (!individuoExcluido.getEdad().isActivo())
					cargarRegistroEdad(dsEdades, individuoExcluido.getEdad());					
		
	}

	private void enviarCargo(IDataSet dsCarga , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterCargo = 
			CargoLegajoExcluido.getAllAtivos(this.getSesion()).iterator();
		while (iterCargo.hasNext()) {
			CargoLegajoExcluido cargo = (CargoLegajoExcluido) iterCargo.next();
			cargarRegistroCargo(dsCarga, cargo);
		}

		if (individuoExcluido!=null)
			if (individuoExcluido.getCargo()!=null)
				if (!individuoExcluido.getCargo().isActivo())
					cargarRegistroCargo(dsCarga, individuoExcluido.getCargo());					
		
		
	}

	private void enviarMotNov(IDataSet dsMotNov , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterMotNov = 
			MotivoNovedadExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterMotNov.hasNext()) {
			MotivoNovedadExcluido motNovExc = (MotivoNovedadExcluido) iterMotNov.next();
			cargarMotNovedad(dsMotNov, motNovExc);
		}
		
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getNovedadExcluido()!=null)
			if (individuoExcluido.getNovedadExcluido().getMotivo()!=null)
				if (!individuoExcluido.getNovedadExcluido().getMotivo().isActivo()) {
						listaAnulados.put(individuoExcluido.getNovedadExcluido().getMotivo().getOIDInteger(),"");
						cargarMotNovedad(dsMotNov, individuoExcluido.getNovedadExcluido().getMotivo());
					}
		
		Iterator iterNov = 
			individuoExcluido.getNovedades().iterator();
		while (iterNov.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNov.next();
			if (novedad.getMotivo()!=null)
				if (!novedad.getMotivo().isActivo()) {
					if (listaAnulados.get(novedad.getMotivo().getOIDInteger())==null) {
						listaAnulados.put(novedad.getMotivo().getOIDInteger(),"");
						cargarMotNovedad(dsMotNov, novedad.getMotivo());
					}
				}
		}
					
	}	
	
	private void enviarMotDif(IDataSet dsCarga , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterMotDifImp = 
			MotDifPagoExc.getAllActivos(this.getSesion()).iterator();
		while (iterMotDifImp.hasNext()) {
			MotDifPagoExc motDifPagoExc = (MotDifPagoExc) iterMotDifImp.next();
			cargarMotDifImp(dsCarga, motDifPagoExc);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterDifImpo = 
			individuoExcluido.getDifImportes().iterator();
		while (iterDifImpo.hasNext()) {
			DifImporteExcluido difImpExc = (DifImporteExcluido) iterDifImpo.next();
			if (difImpExc.getMotivo()!=null)
				if (!difImpExc.getMotivo().isActivo())
					if (listaAnulados.get(difImpExc.getMotivo().getOIDInteger())==null) {
						cargarMotDifImp(dsCarga, difImpExc.getMotivo());
						listaAnulados.put(difImpExc.getMotivo().getOIDInteger(),"");
					}
		}
	}
	
	private void enviarColorCabello(IDataSet dsColor , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterColorCabello = 
			ColorCabelloExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterColorCabello.hasNext()) {
			ColorCabelloExcluido color = (ColorCabelloExcluido) iterColorCabello.next();
			cargarRegistroColorCabello(dsColor, color);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getColor()!=null)
			if (!individuoExcluido.getColor().isActivo())
				cargarRegistroColorCabello(dsColor, individuoExcluido.getColor());									
		
	}
	
	
	private void enviarCaracter(IDataSet dsCaracter , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterCaracter = 
			CaracterExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterCaracter.hasNext()) {
			CaracterExcluido caracter = (CaracterExcluido) iterCaracter.next();
			cargarRegistroCaracter(dsCaracter, caracter);
		}

		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getCaracter()!=null)
			if (!individuoExcluido.getCaracter().isActivo())
				cargarRegistroCaracter(dsCaracter, individuoExcluido.getCaracter());									
		
		
	}	

	private void enviarLugarHecho(IDataSet dsLugarHecho , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterLugarHecho = 
			LugarHechoExcluido.getLugaresHecho(this.getSesion()).iterator();
		while (iterLugarHecho.hasNext()) {
			LugarHechoExcluido lugarHechoExcluido = (LugarHechoExcluido) iterLugarHecho.next();
			cargarRegistroLugarHecho(dsLugarHecho, lugarHechoExcluido);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterNov = 
			individuoExcluido.getNovedades().iterator();
		while (iterNov.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNov.next();
			if (novedad.getLugar_del_hecho()!=null)
				if (!novedad.getLugar_del_hecho().isActivo()) {
					if (listaAnulados.get(novedad.getLugar_del_hecho().getOIDInteger())==null) {
						listaAnulados.put(novedad.getLugar_del_hecho().getOIDInteger(),"");
						cargarRegistroLugarHecho(dsLugarHecho, novedad.getLugar_del_hecho());
					}
				}
		}

		
	}	
	
	private void enviarGerentes(IDataSet dsGerentes , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterGerentes = 
			GerenteExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterGerentes.hasNext()) {
			GerenteExcluido gerente = (GerenteExcluido) iterGerentes.next();
			cargarRegistroGerente(dsGerentes, gerente);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterNov = 
			individuoExcluido.getNovedades().iterator();
		while (iterNov.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNov.next();
			if (novedad.getGerenteExcluido()!=null)
				if (!novedad.getGerenteExcluido().isActivo()) {
					if (listaAnulados.get(novedad.getGerenteExcluido().getOIDInteger())==null) {
						listaAnulados.put(novedad.getGerenteExcluido().getOIDInteger(),"");
						cargarRegistroGerente(dsGerentes, novedad.getGerenteExcluido());
					}
				}
		}
		
		
	}	
	
	
	private void enviarSector(IDataSet dsSector , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterSector = 
			SectorLegajoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterSector.hasNext()) {
			SectorLegajoExcluido sector = (SectorLegajoExcluido) iterSector.next();
			cargarRegistroSector(dsSector, sector);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getSector()!=null)
			if (!individuoExcluido.getSector().isActivo())
				cargarRegistroSector(dsSector,individuoExcluido.getSector());									
		
		
	}
	
	
	
	private void enviarCondicion(IDataSet dsCondicion , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterCondLeg = IndividuoExcluido.getCondicionesLegajo().keySet().iterator();
		while (iterCondLeg.hasNext()) {
			String codigo = (String) iterCondLeg.next();
			String descripcion = (String) IndividuoExcluido.getCondicionesLegajo().get(codigo);
			cargarRegistroCondicion(dsCondicion,codigo,descripcion);
		}
		
		
	}
	
	
	private void enviarEstados(IDataSet dsEstados , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterEstados = 
			EstadoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterEstados.hasNext()) {
			EstadoExcluido estado = (EstadoExcluido) iterEstados.next();
			cargarRegistroEstado(dsEstados, estado);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getEstado()!=null)
			if (!individuoExcluido.getEstado().isActivo())
				cargarRegistroEstado(dsEstados,individuoExcluido.getEstado());									
		
		
	}
	
	
	
	private void enviarRaza(IDataSet dsRaza , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterRaza = 
			RazaExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterRaza.hasNext()) {
			RazaExcluido raza = (RazaExcluido) iterRaza.next();
			cargarRegistroRaza(dsRaza, raza);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getRaza()!=null)
			if (!individuoExcluido.getRaza().isActivo())
				cargarRegistroRaza(dsRaza, individuoExcluido.getRaza());									
		
		
	}
	
	private void enviarComplexion(IDataSet dsComplexion , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterComplexion = 
			ComplexionExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterComplexion.hasNext()) {
			ComplexionExcluido complexion = (ComplexionExcluido) iterComplexion.next();
			cargarRegistroComplexion(dsComplexion, complexion);
		}

		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getComplexion()!=null)
			if (!individuoExcluido.getComplexion().isActivo())
				cargarRegistroComplexion(dsComplexion, individuoExcluido.getComplexion());									
		
	}
	
	private void enviarTipoCabello(IDataSet dsCabello , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterCabello = 
			TipoCabelloExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterCabello.hasNext()) {
			TipoCabelloExcluido tipoCabello = (TipoCabelloExcluido) iterCabello.next();
			cargarRegistroCabello(dsCabello, tipoCabello);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getTipo_cabello()!=null)
			if (!individuoExcluido.getTipo_cabello().isActivo())
				cargarRegistroCabello(dsCabello, individuoExcluido.getTipo_cabello());									
		
	}
	
	
	private void enviarTiposTiposDocu(IDataSet dsTipoDocu , IndividuoExcluido individuoExcluido) throws BaseException {
				
		Iterator iterTiposDocu = 
			TipoDocumento.getAllTiposDocumentosActivos(this.getSesion()).iterator();
		while (iterTiposDocu.hasNext()) {
			TipoDocumento tipoDocumento = (TipoDocumento) iterTiposDocu.next();
			cargarRegistroTipoDocu(dsTipoDocu, tipoDocumento);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getTipo_documento()!=null)
			if (!individuoExcluido.getTipo_documento().isActivo())
				cargarRegistroTipoDocu(dsTipoDocu, individuoExcluido.getTipo_documento());									
		
	}
	
	private void enviarAltura(IDataSet dsAltura , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterAltura = 
			AlturaExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterAltura.hasNext()) {
			AlturaExcluido altura = (AlturaExcluido) iterAltura.next();
			cargarRegistroAltura(dsAltura, altura);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getAltura()!=null)
			if (!individuoExcluido.getAltura().isActivo())
				cargarRegistroAltura(dsAltura, individuoExcluido.getAltura());									
		
	}
	
	private void enviarMonedas(IDataSet dsMonedas , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterMonedas = 
			Moneda.getAllActivos(this.getSesion()).iterator();
		while (iterMonedas.hasNext()) {
			Moneda moneda = (Moneda) iterMonedas.next();
			cargarRegistroMonedas(dsMonedas, moneda);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterDifImpo = 
			individuoExcluido.getDifImportes().iterator();
		while (iterDifImpo.hasNext()) {
			DifImporteExcluido difImpExc = (DifImporteExcluido) iterDifImpo.next();
			if (difImpExc.getMoneda()!=null)
				if (!difImpExc.getMoneda().isActivo())
					if (listaAnulados.get(difImpExc.getMoneda().getOIDInteger())==null) {
						cargarRegistroMonedas(dsMonedas, difImpExc.getMoneda());
						listaAnulados.put(difImpExc.getMoneda().getOIDInteger(),"");
					}
		}

	}
	
	private void enviarSupervisor(IDataSet dsSupervisor , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterSupervisor = 
			SupervisorExcluido.getSupervisorExcluidosActivos(this.getSesion()).iterator();
		while (iterSupervisor.hasNext()) {
			SupervisorExcluido supervisor = (SupervisorExcluido) iterSupervisor.next();
			cargarRegistroSupervisor(dsSupervisor, supervisor);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterNov = 
			individuoExcluido.getNovedades().iterator();
		while (iterNov.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNov.next();
			if (novedad.getSupervisor()!=null)
				if (!novedad.getSupervisor().isActivo()) {
					if (listaAnulados.get(novedad.getSupervisor().getOIDInteger())==null) {
						listaAnulados.put(novedad.getSupervisor().getOIDInteger(),"");
						cargarRegistroSupervisor(dsSupervisor, novedad.getSupervisor());
					}
				}
		}
		
		
		
	}
	
	private void enviarTurno(IDataSet dsTurno , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterTurnos = 
			TurnoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterTurnos.hasNext()) {
			TurnoExcluido turnoExcluido = (TurnoExcluido) iterTurnos.next();
			cargarRegistroTurno(dsTurno, turnoExcluido);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterNov = 
			individuoExcluido.getNovedades().iterator();
		while (iterNov.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNov.next();
			if (novedad.getTurno()!=null)
				if (!novedad.getTurno().isActivo()) {
					if (listaAnulados.get(novedad.getTurno().getOIDInteger())==null) {
						listaAnulados.put(novedad.getTurno().getOIDInteger(),"");
						cargarRegistroTurno(dsTurno, novedad.getTurno());
					}
				}
		}
		
		
	}
	
	private void enviarSeRetita(IDataSet dsSeRetira , IndividuoExcluido individuoExcluido) throws BaseException {
		
		HashTableDatos listaAnulados = new HashTableDatos();
		
		Iterator iterSeRetira = 
			SeRetiraEnExc.getAllActivos(this.getSesion()).iterator();
		while (iterSeRetira.hasNext()) {
			SeRetiraEnExc seRetira = (SeRetiraEnExc) iterSeRetira.next();
			cargarRegistroSeRetiraEn(dsSeRetira, seRetira);
		}
		
		if (individuoExcluido == null) return;
		
		Iterator iterNov = 
			individuoExcluido.getNovedades().iterator();
		while (iterNov.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNov.next();
			if (novedad.getSe_retira_en()!=null)
				if (!novedad.getSe_retira_en().isActivo()) {
					if (listaAnulados.get(novedad.getSe_retira_en().getOIDInteger())==null) {
						listaAnulados.put(novedad.getSe_retira_en().getOIDInteger(),"");
						cargarRegistroSeRetiraEn(dsSeRetira, novedad.getSe_retira_en());
					}
				}
		}
		
		
	}	
	
	private void enviarColor(IDataSet dsColor , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterColor = 
			ColorExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterColor.hasNext()) {
			ColorExcluido color = (ColorExcluido) iterColor.next();
			cargarRegistroColor(dsColor, color);
		}
		
	}
	
	
	private void enviarMarcas(IDataSet dsMarcas , IndividuoExcluido individuoExcluido) throws BaseException {
		Iterator iterMarcas = 
			MarcaExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterMarcas.hasNext()) {
			MarcaExcluido marca = (MarcaExcluido) iterMarcas.next();
			cargarRegistroMarca(dsMarcas, marca);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getMarca()!=null)
			if (!individuoExcluido.getMarca().isActivo())
				cargarRegistroMarca(dsMarcas, individuoExcluido.getMarca());					
		
	}
	
	private void enviarRasgos(IDataSet dsRasgos , IndividuoExcluido individuoExcluido) throws BaseException {
		
		Iterator iterRasgos = 
			RasgoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterRasgos.hasNext()) {
			RasgoExcluido rasgo = (RasgoExcluido) iterRasgos.next();
			cargarRegistroRasgo(dsRasgos, rasgo);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getRasgo()!=null)
			if (!individuoExcluido.getRasgo().isActivo())
				cargarRegistroRasgo(dsRasgos, individuoExcluido.getRasgo());					
		
	}	
		
	
	private void enviarTiposIndividuos(IDataSet dsTipoIndi , IndividuoExcluido individuoExcluido) throws BaseException {
		Iterator iterTiposIndi = 
			IndividuoExcluido.getTiposEmpleados().keySet().iterator();
		while (iterTiposIndi.hasNext()) {
			String codigo = (String) iterTiposIndi.next();
			String descripcion = (String) IndividuoExcluido.getTiposEmpleados().get(codigo);
			cargarRegistro(dsTipoIndi, codigo, descripcion);
		}
	}
	
	private void enviarTiposAnteojos(IDataSet dsAnteojos , IndividuoExcluido individuoExcluido) throws BaseException {
		Iterator iterAnteojos = 
			AnteojoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterAnteojos.hasNext()) {
			AnteojoExcluido anteojo = (AnteojoExcluido) iterAnteojos.next();
			cargarRegistroAnteojo(dsAnteojos, anteojo);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getAnteojo()!=null)
			if (!individuoExcluido.getAnteojo().isActivo())
				cargarRegistroAnteojo(dsAnteojos, individuoExcluido.getAnteojo());					
		
	}
	
	private void enviarPeligrosidad(IDataSet dsPeligrosidad , IndividuoExcluido individuoExcluido) throws BaseException {
		Iterator iterPeligrosidad = 
			PeligrosidadExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterPeligrosidad.hasNext()) {
			PeligrosidadExcluido peligrosidadExcluido = (PeligrosidadExcluido) iterPeligrosidad.next();
			cargarRegistroPeligrosidad(dsPeligrosidad, peligrosidadExcluido);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getPeligrosidad()!=null)
			if (!individuoExcluido.getPeligrosidad().isActivo())
				cargarRegistroPeligrosidad(dsPeligrosidad, individuoExcluido.getPeligrosidad());					
		
	}	
	
	private void enviarPredios(IDataSet dsPredios , IndividuoExcluido individuoExcluido) throws BaseException {
		Iterator iterPredios = 
			PredioExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterPredios.hasNext()) {
			PredioExcluido predio = (PredioExcluido) iterPredios.next();
			cargarRegistroPredio(dsPredios, predio);
		}
		
		if (individuoExcluido == null) return;
		
		if (individuoExcluido.getPeligrosidad()!=null)
			if (!individuoExcluido.getPeligrosidad().isActivo())
				cargarRegistroPredio(dsPredios, individuoExcluido.getPredioExcluido());					
		
	}	
	
	
	private void enviarSexo(IDataSet dsSexo , IndividuoExcluido individuoExcluido) throws BaseException {
		Iterator iterSexo = 
			IndividuoExcluido.getSexoIndividuos().keySet().iterator();
		while (iterSexo.hasNext()) {
			String codigo = (String) iterSexo.next();
			String descripcion = (String) IndividuoExcluido.getSexoIndividuos().get(codigo);
			cargarRegistro(dsSexo, codigo, descripcion);
		}
	}
	
}
