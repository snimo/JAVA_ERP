package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.bm.AnteojoExcluido;
import com.srn.erp.excluidos.bm.CaracterExcluido;
import com.srn.erp.excluidos.bm.CargoLegajoExcluido;
import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.MarcaExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.RasgoExcluido;
import com.srn.erp.excluidos.bm.RazaExcluido;
import com.srn.erp.excluidos.bm.SectorLegajoExcluido;
import com.srn.erp.excluidos.bm.TipoBarba;
import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
import com.srn.erp.excluidos.bm.TipoNariz;
import com.srn.erp.excluidos.da.DBIndividuoExcluido;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIndividuoExcluido extends FactoryObjetoLogico {

	public FactoryIndividuoExcluido() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		IndividuoExcluido individuoexcluido = (IndividuoExcluido) objLog;
		individuoexcluido.setOID(db.getInteger(DBIndividuoExcluido.OID_INDIVIDUO));
		individuoexcluido.setTipo(db.getString(DBIndividuoExcluido.TIPO));
		individuoexcluido.setApellido(db.getString(DBIndividuoExcluido.APELLIDO));
		individuoexcluido.setNombre(db.getString(DBIndividuoExcluido.NOMBRE));
		individuoexcluido.setTipo_documento(TipoDocumento
				.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_TIPO_DOCUMENTO), getSesion()));
		individuoexcluido.setNro_documento(db.getString(DBIndividuoExcluido.NRO_DOCUMENTO));
		individuoexcluido.setApodo(db.getString(DBIndividuoExcluido.APODO));
		individuoexcluido.setNacionalidad(Nacionalidad.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_NACIONALIDAD), getSesion()));
		individuoexcluido.setNro_legajo(db.getString(DBIndividuoExcluido.LEGAJO));
		individuoexcluido.setSector(SectorLegajoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_SECTOR), getSesion()));
		individuoexcluido.setCargo(CargoLegajoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_CARGO), getSesion()));
		individuoexcluido.setTipo_condicion(db.getString(DBIndividuoExcluido.TIPO_CONDICION));
		individuoexcluido.setSexo(db.getString(DBIndividuoExcluido.SEXO));
		individuoexcluido.setRaza(RazaExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_RAZA), getSesion()));
		individuoexcluido.setAltura(AlturaExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_ALTURA), getSesion()));
		individuoexcluido.setComplexion(ComplexionExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_COMPLEXION), getSesion()));
		individuoexcluido.setEdad(EdadExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_EDAD), getSesion()));
		individuoexcluido.setColor(ColorCabelloExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_COLOR), getSesion()));
		individuoexcluido.setTipo_barba(TipoBarba.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_TIPO_BARBA), getSesion()));
		individuoexcluido.setTipo_cabello(TipoCabelloExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_TIPO_CABELLO),
				getSesion()));
		individuoexcluido.setTipo_nariz(TipoNariz.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_TIPO_NARIZ), getSesion()));
		individuoexcluido.setAnteojos(db.getBoolean(DBIndividuoExcluido.ANTEOJOS));
		individuoexcluido.setMarcas(db.getString(DBIndividuoExcluido.MARCAS));
		individuoexcluido.setRasgos(db.getString(DBIndividuoExcluido.RASGOS));
		individuoexcluido.setLegajo(Legajo.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_LEGAJO), getSesion()));
		individuoexcluido.setActivo(db.getBoolean(DBIndividuoExcluido.ACTIVO));
		individuoexcluido.setActuAutoEstInd(db.getBoolean(DBIndividuoExcluido.ACTU_AUTO_EST_IND));
		individuoexcluido.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_ESTADO), getSesion()));
		individuoexcluido.setEstado_anterior(EstadoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_ESTADO_ANT), getSesion()));
		individuoexcluido.setNovedadExcluido(NovedadExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_NOVEDAD), getSesion()));
		individuoexcluido.setObsPrincipal(db.getString(DBIndividuoExcluido.OBS_PRINCIPAL));
		individuoexcluido.setCaracter(CaracterExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_CARACTER),
				getSesion()));
		individuoexcluido.setMarca(MarcaExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_MARCA),
				getSesion()));		
		individuoexcluido.setRasgo(RasgoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_RASGO),
				getSesion()));		
		individuoexcluido.setAnteojo(AnteojoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_ANTEOJO),
				getSesion()));
		individuoexcluido.setFotoPrincipal(db.getInteger(DBIndividuoExcluido.FOTO_PRINCIPAL));
		individuoexcluido.setPeligrosidad(PeligrosidadExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_PELIGROSIDAD),this.getSesion()));
		individuoexcluido.setPredioExcluido(PredioExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_PREDIO),this.getSesion()));
		individuoexcluido.setPredioFoto1(PredioExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluido.OID_PREDIO_FOTO_1),this.getSesion()));
		if (db.getDate(DBIndividuoExcluido.FEC_ESTADO)!=null)
			individuoexcluido.setFec_estado(new java.util.Date(db.getDate(DBIndividuoExcluido.FEC_ESTADO).getTime()));
		
		individuoexcluido.setNroVersionFoto1(db.getInteger(DBIndividuoExcluido.NRO_VER_FOTO_1));
		individuoexcluido.setNroVersionFoto2(db.getInteger(DBIndividuoExcluido.NRO_VER_FOTO_2));
		individuoexcluido.setNroVersionFoto3(db.getInteger(DBIndividuoExcluido.NRO_VER_FOTO_3));
		
	}
}
