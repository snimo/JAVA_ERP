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
import com.srn.erp.excluidos.bm.IndividuoExcluidoSinc;
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
import com.srn.erp.excluidos.da.DBIndividuoExcluidoSinc;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIndividuoExcluidoSinc extends FactoryObjetoLogico {

	public FactoryIndividuoExcluidoSinc() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		IndividuoExcluidoSinc individuoexcluido = (IndividuoExcluidoSinc) objLog;
		individuoexcluido.setNroLote(db.getInteger(DBIndividuoExcluidoSinc.OID_LOTE_SINC));
		
		
		//IndividuoExcluido individuoexcluido = new IndividuoExcluido();
		
		individuoexcluido.setOID(db.getInteger(DBIndividuoExcluidoSinc.OID_INDIVIDUO));
		individuoexcluido.setTipo(db.getString(DBIndividuoExcluidoSinc.TIPO));
		individuoexcluido.setApellido(db.getString(DBIndividuoExcluidoSinc.APELLIDO));
		individuoexcluido.setNombre(db.getString(DBIndividuoExcluidoSinc.NOMBRE));
		individuoexcluido.setTipo_documento(TipoDocumento
				.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_TIPO_DOCUMENTO), getSesion()));
		individuoexcluido.setNro_documento(db.getString(DBIndividuoExcluidoSinc.NRO_DOCUMENTO));
		individuoexcluido.setApodo(db.getString(DBIndividuoExcluidoSinc.APODO));
		individuoexcluido.setNacionalidad(Nacionalidad.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_NACIONALIDAD), getSesion()));
		individuoexcluido.setNro_legajo(db.getString(DBIndividuoExcluidoSinc.LEGAJO));
		individuoexcluido.setSector(SectorLegajoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_SECTOR), getSesion()));
		individuoexcluido.setCargo(CargoLegajoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_CARGO), getSesion()));
		individuoexcluido.setTipo_condicion(db.getString(DBIndividuoExcluidoSinc.TIPO_CONDICION));
		individuoexcluido.setSexo(db.getString(DBIndividuoExcluidoSinc.SEXO));
		individuoexcluido.setRaza(RazaExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_RAZA), getSesion()));
		individuoexcluido.setAltura(AlturaExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_ALTURA), getSesion()));
		individuoexcluido.setComplexion(ComplexionExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_COMPLEXION), getSesion()));
		individuoexcluido.setEdad(EdadExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_EDAD), getSesion()));
		individuoexcluido.setColor(ColorCabelloExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_COLOR), getSesion()));
		individuoexcluido.setTipo_barba(TipoBarba.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_TIPO_BARBA), getSesion()));
		individuoexcluido.setTipo_cabello(TipoCabelloExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_TIPO_CABELLO),
				getSesion()));
		individuoexcluido.setTipo_nariz(TipoNariz.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_TIPO_NARIZ), getSesion()));
		individuoexcluido.setAnteojos(db.getBoolean(DBIndividuoExcluidoSinc.ANTEOJOS));
		individuoexcluido.setMarcas(db.getString(DBIndividuoExcluidoSinc.MARCAS));
		individuoexcluido.setRasgos(db.getString(DBIndividuoExcluidoSinc.RASGOS));
		individuoexcluido.setLegajo(Legajo.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_LEGAJO), getSesion()));
		individuoexcluido.setActivo(db.getBoolean(DBIndividuoExcluidoSinc.ACTIVO));
		individuoexcluido.setActuAutoEstInd(db.getBoolean(DBIndividuoExcluidoSinc.ACTU_AUTO_EST_IND));
		individuoexcluido.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_ESTADO), getSesion()));
		individuoexcluido.setEstado_anterior(EstadoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_ESTADO_ANT), getSesion()));
		individuoexcluido.setNovedadExcluido(NovedadExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_NOVEDAD), getSesion()));
		individuoexcluido.setObsPrincipal(db.getString(DBIndividuoExcluidoSinc.OBS_PRINCIPAL));
		individuoexcluido.setCaracter(CaracterExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_CARACTER),
				getSesion()));
		individuoexcluido.setMarca(MarcaExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_MARCA),
				getSesion()));		
		individuoexcluido.setRasgo(RasgoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_RASGO),
				getSesion()));		
		individuoexcluido.setAnteojo(AnteojoExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_ANTEOJO),
				getSesion()));
		individuoexcluido.setFotoPrincipal(db.getInteger(DBIndividuoExcluidoSinc.FOTO_PRINCIPAL));
		individuoexcluido.setPeligrosidad(PeligrosidadExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_PELIGROSIDAD),this.getSesion()));
		individuoexcluido.setPredioExcluido(PredioExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_PREDIO),this.getSesion()));
		individuoexcluido.setPredioFoto1(PredioExcluido.findByOidProxy(db.getInteger(DBIndividuoExcluidoSinc.OID_PREDIO_FOTO_1),this.getSesion()));
		individuoexcluido.setFec_estado(new java.util.Date(db.getDate(DBIndividuoExcluidoSinc.FEC_ESTADO).getTime()));
		
		//individuoexcluidoSinc.setExcluido(individuoexcluido);
	}
}
