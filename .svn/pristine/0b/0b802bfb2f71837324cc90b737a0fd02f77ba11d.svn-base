package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.bm.AnteojoExcluido;
import com.srn.erp.excluidos.bm.ArchAdjExc;
import com.srn.erp.excluidos.bm.CaracterExcluido;
import com.srn.erp.excluidos.bm.CargoLegajoExcluido;
import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.bm.ColorExcluido;
import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.bm.DifImporteExcluido;
import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.GerenteExcluido;
import com.srn.erp.excluidos.bm.ImagenesExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.LugarHechoExcluido;
import com.srn.erp.excluidos.bm.MarcaExcluido;
import com.srn.erp.excluidos.bm.MotDifPagoExc;
import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.ObsGeneralesExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.RasgoExcluido;
import com.srn.erp.excluidos.bm.RazaExcluido;
import com.srn.erp.excluidos.bm.RelacionExcluido;
import com.srn.erp.excluidos.bm.SeRetiraEnExc;
import com.srn.erp.excluidos.bm.SectorLegajoExcluido;
import com.srn.erp.excluidos.bm.SupervisorExcluido;
import com.srn.erp.excluidos.bm.TipoBarba;
import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
import com.srn.erp.excluidos.bm.TipoNariz;
import com.srn.erp.excluidos.bm.TurnoExcluido;
import com.srn.erp.excluidos.bm.VehiAsigExcluido;
import com.srn.erp.excluidos.bm.VehiculoExcluido;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveIndividuoExcluido extends Operation {

	public SaveIndividuoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TIndividuoExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			IndividuoExcluido individuoexcluido = IndividuoExcluido.findByOid(dataset.getInteger("oid_individuo"), getSesion());
			individuoexcluido.setOID(dataset.getInteger("oid_individuo"));
			individuoexcluido.setTipo(dataset.getString("tipo"));
			individuoexcluido.setApellido(dataset.getString("apellido"));
			individuoexcluido.setNombre(dataset.getString("nombre"));
			individuoexcluido.setTipo_documento(TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_documento"), this.getSesion()));
			individuoexcluido.setNro_documento(dataset.getString("nro_documento"));
			individuoexcluido.setApodo(dataset.getString("apodo"));
			individuoexcluido.setNacionalidad(Nacionalidad.findByOidProxy(dataset.getInteger("oid_nacionalidad"), this.getSesion()));
			individuoexcluido.setNro_legajo(dataset.getString("legajo"));
			individuoexcluido.setSector(SectorLegajoExcluido.findByOidProxy(dataset.getInteger("oid_sector"), this.getSesion()));
			individuoexcluido.setCargo(CargoLegajoExcluido.findByOidProxy(dataset.getInteger("oid_cargo"), this.getSesion()));
			individuoexcluido.setTipo_condicion(dataset.getString("tipo_condicion"));
			individuoexcluido.setSexo(dataset.getString("sexo"));
			individuoexcluido.setRaza(RazaExcluido.findByOidProxy(dataset.getInteger("oid_raza"), this.getSesion()));
			individuoexcluido.setAltura(AlturaExcluido.findByOidProxy(dataset.getInteger("oid_altura"), this.getSesion()));
			individuoexcluido.setComplexion(ComplexionExcluido.findByOidProxy(dataset.getInteger("oid_complexion"), this.getSesion()));
			individuoexcluido.setEdad(EdadExcluido.findByOidProxy(dataset.getInteger("oid_edad"), this.getSesion()));
			individuoexcluido.setColor(ColorCabelloExcluido.findByOidProxy(dataset.getInteger("oid_color"), this.getSesion()));
			individuoexcluido.setTipo_barba(TipoBarba.findByOidProxy(dataset.getInteger("oid_tipo_barba"), this.getSesion()));
			individuoexcluido.setTipo_cabello(TipoCabelloExcluido.findByOidProxy(dataset.getInteger("oid_tipo_cabello"), this.getSesion()));
			individuoexcluido.setTipo_nariz(TipoNariz.findByOidProxy(dataset.getInteger("oid_tipo_nariz"), this.getSesion()));
			individuoexcluido.setMarca(MarcaExcluido.findByOidProxy(dataset.getInteger("oid_marca"), this.getSesion()));
			individuoexcluido.setRasgo(RasgoExcluido.findByOidProxy(dataset.getInteger("oid_rasgo"), this.getSesion()));
			individuoexcluido.setAnteojo(AnteojoExcluido.findByOidProxy(dataset.getInteger("oid_anteojo"), this.getSesion()));
			individuoexcluido.setFotoPrincipal(dataset.getInteger("foto_principal"));
			individuoexcluido.setPredioFoto1(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_foto_1"), this.getSesion()));
			
			individuoexcluido.setNroVersionFoto1(dataset.getInteger("nro_ver_foto_1"));
			individuoexcluido.setNroVersionFoto2(dataset.getInteger("nro_ver_foto_2"));
			individuoexcluido.setNroVersionFoto3(dataset.getInteger("nro_ver_foto_3"));
			
			

			individuoexcluido.setPeligrosidad(PeligrosidadExcluido.findByOidProxy(dataset.getInteger("oid_peligrosidad"), this.getSesion()));
			individuoexcluido.setPredioExcluido(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio"), this.getSesion()));

			if (dataset.getInteger("anteojos") != null) {
				if (dataset.getInteger("anteojos").intValue() == 1)
					individuoexcluido.setAnteojos(true);
				else
					individuoexcluido.setAnteojos(false);
			} else
				individuoexcluido.setAnteojos(false);

			individuoexcluido.setMarcas(dataset.getString("marcas"));
			individuoexcluido.setRasgos(dataset.getString("rasgos"));
			individuoexcluido.setEstado(EstadoExcluido.findByOidProxy(dataset.getInteger("oid_estado"), this.getSesion()));
			individuoexcluido.setLegajo(Legajo.findByOidProxy(dataset.getInteger("oid_legajo"), this.getSesion()));
			individuoexcluido.setActivo(dataset.getBoolean("activo"));
			individuoexcluido.setActuAutoEstInd(dataset.getBoolean("act_aut_est_ind"));
			individuoexcluido.setObsPrincipal(dataset.getString("obs_principal"));
			individuoexcluido.setCaracter(CaracterExcluido.findByOidProxy(dataset.getInteger("oid_caracter"), this.getSesion()));

			ArchAdjExc archAdjExc1 = ArchAdjExc.getArchivoAdjExc(individuoexcluido, 1, this.getSesion());
			if (archAdjExc1 == null)
				archAdjExc1 = (ArchAdjExc) ArchAdjExc.getNew(ArchAdjExc.NICKNAME, this.getSesion());

			archAdjExc1.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_1"), this.getSesion()));

			if (dataset.getString("arch_adj_oper_1").equals("A")) {
				archAdjExc1.setFecha(Fecha.getFechaActual());
				archAdjExc1.setNombre(dataset.getString("arch_adj_nombre_1"));
				archAdjExc1.setTitulo(dataset.getString("arch_adj_titulo_1"));
				archAdjExc1.setOrden(1);
				archAdjExc1.setIndividuo(individuoexcluido);
				archAdjExc1.setActivo(true);
				archAdjExc1.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_1"), this.getSesion()));
				
				individuoexcluido.addArchivoAdjunto(archAdjExc1);
			}
			if (dataset.getString("arch_adj_oper_1").equals("E")) {
				archAdjExc1.setTitulo(dataset.getString("arch_adj_titulo_1"));
				archAdjExc1.setActivo(false);
				archAdjExc1.delete();
				individuoexcluido.addArchivoAdjunto(archAdjExc1);
			} else {
				archAdjExc1.setTitulo(dataset.getString("arch_adj_titulo_1"));
				archAdjExc1.setActivo(true);
				archAdjExc1.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_1"), this.getSesion()));
				archAdjExc1.setOrden(1);
				individuoexcluido.addArchivoAdjunto(archAdjExc1);
			}

			ArchAdjExc archAdjExc2 = ArchAdjExc.getArchivoAdjExc(individuoexcluido, 2, this.getSesion());
			if (archAdjExc2 == null)
				archAdjExc2 = (ArchAdjExc) ArchAdjExc.getNew(ArchAdjExc.NICKNAME, this.getSesion());
			archAdjExc2.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_2"), this.getSesion()));

			if (dataset.getString("arch_adj_oper_2").equals("A")) {
				archAdjExc2.setFecha(Fecha.getFechaActual());
				archAdjExc2.setNombre(dataset.getString("arch_adj_nombre_2"));
				archAdjExc2.setTitulo(dataset.getString("arch_adj_titulo_2"));
				archAdjExc2.setOrden(2);
				archAdjExc2.setIndividuo(individuoexcluido);
				archAdjExc2.setActivo(true);
				archAdjExc2.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_2"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc2);
			}
			if (dataset.getString("arch_adj_oper_2").equals("E")) {
				archAdjExc2.setTitulo(dataset.getString("arch_adj_titulo_2"));
				archAdjExc2.setActivo(false);
				archAdjExc2.delete();
				individuoexcluido.addArchivoAdjunto(archAdjExc2);
			} else {
				archAdjExc2.setTitulo(dataset.getString("arch_adj_titulo_2"));
				archAdjExc2.setActivo(true);
				archAdjExc2.setOrden(2);
				archAdjExc2.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_2"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc2);
			}

			ArchAdjExc archAdjExc3 = ArchAdjExc.getArchivoAdjExc(individuoexcluido, 3, this.getSesion());
			if (archAdjExc3 == null)
				archAdjExc3 = (ArchAdjExc) ArchAdjExc.getNew(ArchAdjExc.NICKNAME, this.getSesion());

			archAdjExc3.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_3"), this.getSesion()));

			if (dataset.getString("arch_adj_oper_3").equals("A")) {
				archAdjExc3.setFecha(Fecha.getFechaActual());
				archAdjExc3.setNombre(dataset.getString("arch_adj_nombre_3"));
				archAdjExc3.setTitulo(dataset.getString("arch_adj_titulo_3"));
				archAdjExc3.setOrden(3);
				archAdjExc3.setIndividuo(individuoexcluido);
				archAdjExc3.setActivo(true);
				archAdjExc3.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_3"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc3);
			}
			if (dataset.getString("arch_adj_oper_3").equals("E")) {
				archAdjExc3.setTitulo(dataset.getString("arch_adj_titulo_3"));
				archAdjExc3.setActivo(false);
				archAdjExc3.delete();
				individuoexcluido.addArchivoAdjunto(archAdjExc3);
			} else {
				archAdjExc3.setTitulo(dataset.getString("arch_adj_titulo_3"));
				archAdjExc3.setActivo(true);
				archAdjExc3.setOrden(3);
				archAdjExc3.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_3"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc3);
			}

			ArchAdjExc archAdjExc4 = ArchAdjExc.getArchivoAdjExc(individuoexcluido, 4, this.getSesion());
			if (archAdjExc4 == null)
				archAdjExc4 = (ArchAdjExc) ArchAdjExc.getNew(ArchAdjExc.NICKNAME, this.getSesion());

			archAdjExc4.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_4"), this.getSesion()));

			if (dataset.getString("arch_adj_oper_4").equals("A")) {
				archAdjExc4.setFecha(Fecha.getFechaActual());
				archAdjExc4.setNombre(dataset.getString("arch_adj_nombre_4"));
				archAdjExc4.setTitulo(dataset.getString("arch_adj_titulo_4"));
				archAdjExc4.setOrden(4);
				archAdjExc4.setIndividuo(individuoexcluido);
				archAdjExc4.setActivo(true);
				archAdjExc4.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_4"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc4);
			}
			if (dataset.getString("arch_adj_oper_4").equals("E")) {
				archAdjExc4.setTitulo(dataset.getString("arch_adj_titulo_4"));
				archAdjExc4.setActivo(false);
				archAdjExc4.delete();
				individuoexcluido.addArchivoAdjunto(archAdjExc4);
			} else {
				archAdjExc4.setTitulo(dataset.getString("arch_adj_titulo_4"));
				archAdjExc4.setActivo(true);
				archAdjExc4.setOrden(4);
				archAdjExc4.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_4"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc4);
			}

			ArchAdjExc archAdjExc5 = ArchAdjExc.getArchivoAdjExc(individuoexcluido, 5, this.getSesion());
			if (archAdjExc5 == null)
				archAdjExc5 = (ArchAdjExc) ArchAdjExc.getNew(ArchAdjExc.NICKNAME, this.getSesion());

			archAdjExc5.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_5"), this.getSesion()));

			if (dataset.getString("arch_adj_oper_5").equals("A")) {
				archAdjExc5.setFecha(Fecha.getFechaActual());
				archAdjExc5.setNombre(dataset.getString("arch_adj_nombre_5"));
				archAdjExc5.setTitulo(dataset.getString("arch_adj_titulo_5"));
				archAdjExc5.setOrden(5);
				archAdjExc5.setIndividuo(individuoexcluido);
				archAdjExc5.setActivo(true);
				archAdjExc5.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_5"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc5);
			}
			if (dataset.getString("arch_adj_oper_5").equals("E")) {
				archAdjExc5.setTitulo(dataset.getString("arch_adj_titulo_5"));
				archAdjExc5.setActivo(false);
				archAdjExc5.delete();
				individuoexcluido.addArchivoAdjunto(archAdjExc5);
			} else {
				archAdjExc5.setTitulo(dataset.getString("arch_adj_titulo_5"));
				archAdjExc5.setActivo(true);
				archAdjExc5.setOrden(5);
				archAdjExc5.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_arch_adj_5"), this.getSesion()));
				individuoexcluido.addArchivoAdjunto(archAdjExc5);
			}

			if (!individuoexcluido.isActivo())
				individuoexcluido.delete();

			// Individuo secuencia Numero 1
			RelacionExcluido relacionExcluido1 = RelacionExcluido.getRelacionExcluido(individuoexcluido, 1, this.getSesion());
			if (relacionExcluido1 == null)
				relacionExcluido1 = (RelacionExcluido) RelacionExcluido.getNew(RelacionExcluido.NICKNAME, this.getSesion());
			relacionExcluido1.setIndividuo(individuoexcluido);
			IndividuoExcluido individuoRelacionExcluido = IndividuoExcluido.findByOidProxy(dataset.getInteger("oid_ind_rel_1"), this.getSesion());
			relacionExcluido1.setIndividuo_rel(individuoRelacionExcluido);
			relacionExcluido1.setSecu(1);
			relacionExcluido1.setComentario(dataset.getString("obs_rel_1"));
			relacionExcluido1.setActivo(true);
			relacionExcluido1.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_rel_1"), this.getSesion()));
			individuoexcluido.addRelacion(relacionExcluido1);

			// Individuo secuencia Numero 2
			RelacionExcluido relacionExcluido2 = RelacionExcluido.getRelacionExcluido(individuoexcluido, 2, this.getSesion());
			if (relacionExcluido2 == null)
				relacionExcluido2 = (RelacionExcluido) RelacionExcluido.getNew(RelacionExcluido.NICKNAME, this.getSesion());
			relacionExcluido2.setIndividuo(individuoexcluido);
			individuoRelacionExcluido = IndividuoExcluido.findByOidProxy(dataset.getInteger("oid_ind_rel_2"), this.getSesion());
			relacionExcluido2.setIndividuo_rel(individuoRelacionExcluido);
			relacionExcluido2.setSecu(2);
			relacionExcluido2.setComentario(dataset.getString("obs_rel_2"));
			relacionExcluido2.setActivo(true);
			relacionExcluido2.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_rel_2"), this.getSesion()));
			individuoexcluido.addRelacion(relacionExcluido2);

			// Individuo secuencia Numero 3
			RelacionExcluido relacionExcluido3 = RelacionExcluido.getRelacionExcluido(individuoexcluido, 3, this.getSesion());
			if (relacionExcluido3 == null)
				relacionExcluido3 = (RelacionExcluido) RelacionExcluido.getNew(RelacionExcluido.NICKNAME, this.getSesion());
			relacionExcluido3.setIndividuo(individuoexcluido);
			individuoRelacionExcluido = IndividuoExcluido.findByOidProxy(dataset.getInteger("oid_ind_rel_3"), this.getSesion());
			relacionExcluido3.setIndividuo_rel(individuoRelacionExcluido);
			relacionExcluido3.setSecu(3);
			relacionExcluido3.setComentario(dataset.getString("obs_rel_3"));
			relacionExcluido3.setActivo(true);
			relacionExcluido3.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_rel_3"), this.getSesion()));
			individuoexcluido.addRelacion(relacionExcluido3);

			// Individuo secuencia Numero 4
			RelacionExcluido relacionExcluido4 = RelacionExcluido.getRelacionExcluido(individuoexcluido, 4, this.getSesion());
			if (relacionExcluido4 == null)
				relacionExcluido4 = (RelacionExcluido) RelacionExcluido.getNew(RelacionExcluido.NICKNAME, this.getSesion());
			relacionExcluido4.setIndividuo(individuoexcluido);
			individuoRelacionExcluido = IndividuoExcluido.findByOidProxy(dataset.getInteger("oid_ind_rel_4"), this.getSesion());
			relacionExcluido4.setIndividuo_rel(individuoRelacionExcluido);
			relacionExcluido4.setSecu(4);
			relacionExcluido4.setComentario(dataset.getString("obs_rel_4"));
			relacionExcluido4.setActivo(true);
			relacionExcluido4.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_rel_4"), this.getSesion()));
			individuoexcluido.addRelacion(relacionExcluido4);

			// Grabar la Imagen 2
			ImagenesExcluido imagenExluido1 = individuoexcluido.getImagenExcluido(new Integer(1));
			if (imagenExluido1 == null)
				imagenExluido1 = (ImagenesExcluido) ImagenesExcluido.getNew(ImagenesExcluido.NICKNAME, this.getSesion());
			imagenExluido1.setIndividuo(individuoexcluido);
			imagenExluido1.setComentario(dataset.getString("comen_foto_2"));
			imagenExluido1.setOrden(new Integer(1));
			imagenExluido1.setActivo(true);
			imagenExluido1.setFecha(Fecha.getFechaActual());
			imagenExluido1.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_foto_2"), this.getSesion()));
			individuoexcluido.addImagenIndividuo(imagenExluido1);

			// Grabar la Imagen 3
			ImagenesExcluido imagenExluido2 = individuoexcluido.getImagenExcluido(new Integer(2));
			if (imagenExluido2 == null)
				imagenExluido2 = (ImagenesExcluido) ImagenesExcluido.getNew(ImagenesExcluido.NICKNAME, this.getSesion());
			imagenExluido2.setIndividuo(individuoexcluido);
			imagenExluido2.setComentario(dataset.getString("comen_foto_3"));
			imagenExluido2.setOrden(new Integer(2));
			imagenExluido2.setActivo(true);
			imagenExluido2.setFecha(Fecha.getFechaActual());
			imagenExluido2.setPredio(PredioExcluido.findByOidProxy(dataset.getInteger("oid_predio_foto_3"), this.getSesion()));
			individuoexcluido.addImagenIndividuo(imagenExluido2);

			IDataSet dsDifImportes = dataset.getDataSet("TDifImporteExcluido");
			dsDifImportes.first();
			while (!dsDifImportes.EOF()) {

				DifImporteExcluido difImporteExcluido = DifImporteExcluido.findByOid(dsDifImportes.getInteger("oid_dif_importe"), this.getSesion());
				difImporteExcluido.setIndividuo(individuoexcluido);
				difImporteExcluido.setFecha(dsDifImportes.getDate("fecha"));
				difImporteExcluido.setMotivo(MotDifPagoExc.findByOidProxy(dsDifImportes.getInteger("oid_mot_dif_imp"), this.getSesion()));
				difImporteExcluido.setMoneda(Moneda.findByOidProxy(dsDifImportes.getInteger("oid_moneda"), this.getSesion()));
				difImporteExcluido.setMonto(dsDifImportes.getDouble("monto"));
				difImporteExcluido.setObservacion(dsDifImportes.getString("observacion"));
				difImporteExcluido.setOrden(dsDifImportes.getInteger("orden"));
				difImporteExcluido.setPredioExcluido(PredioExcluido.findByOidProxy(dsDifImportes.getInteger("oid_predio"), this.getSesion()));

				if (dsDifImportes.getInteger("activo").intValue() == 1)
					difImporteExcluido.setActivo(true);
				else
					difImporteExcluido.setActivo(false);
				if (!difImporteExcluido.isActivo())
					difImporteExcluido.delete();

				individuoexcluido.addDifImporte(difImporteExcluido);

				dsDifImportes.next();
			}

			IDataSet dsVehiculosExcluidos = dataset.getDataSet("TVehiculos");
			dsVehiculosExcluidos.first();
			while (!dsVehiculosExcluidos.EOF()) {

				String dominio = dsVehiculosExcluidos.getString("dominio");
				VehiculoExcluido vehiculo = VehiculoExcluido.getVehiculoExcluido(dominio, this.getSesion());
				if (vehiculo == null) {
					vehiculo = (VehiculoExcluido) VehiculoExcluido.getNew(VehiculoExcluido.NICKNAME, this.getSesion());
					vehiculo.setActivo(true);
				}

				vehiculo.setPredio(PredioExcluido.findByOidProxy(dsVehiculosExcluidos.getInteger("oid_predio"), this.getSesion()));
				vehiculo.setDominio(dsVehiculosExcluidos.getString("dominio"));
				vehiculo.setMarca(dsVehiculosExcluidos.getString("marca"));
				vehiculo.setModelo(dsVehiculosExcluidos.getString("modelo"));
				vehiculo.setPredio(PredioExcluido.findByOidProxy(dsVehiculosExcluidos.getInteger("oid_predio"), this.getSesion()));
				vehiculo.setColor(ColorExcluido.findByOidProxy(dsVehiculosExcluidos.getInteger("oid_color"), this.getSesion()));

				if (dsVehiculosExcluidos.getInteger("activo").intValue() == 1)
					vehiculo.setActivo(true);

				individuoexcluido.addAuto(vehiculo);

				VehiAsigExcluido vehiAsigExc = VehiAsigExcluido.findByOid(dsVehiculosExcluidos.getInteger("oid_vehiculo"), this.getSesion());
				vehiAsigExc.setPredio(PredioExcluido.findByOidProxy(dsVehiculosExcluidos.getInteger("oid_predio"), this.getSesion()));
				vehiAsigExc.setIndividuo(individuoexcluido);
				vehiAsigExc.setVehiculo(vehiculo);
				vehiAsigExc.setActivo(true);

				// vehiculo.setActivo(false);
				if (dsVehiculosExcluidos.getInteger("activo").intValue() == 2) {
					vehiAsigExc.setActivo(false);
					vehiAsigExc.delete();
				}

				individuoexcluido.addVehiculo(vehiAsigExc);

				dsVehiculosExcluidos.next();
			}

			IDataSet dsObsGenerales = dataset.getDataSet("TObsGenerales");
			dsObsGenerales.first();
			while (!dsObsGenerales.EOF()) {
				ObsGeneralesExcluido obsGenExc = ObsGeneralesExcluido.findByOid(dsObsGenerales.getInteger("oid_obs_grales"), this.getSesion());
				obsGenExc.setIndividuo(IndividuoExcluido.findByOidProxy(dsObsGenerales.getInteger("oid_individuo"), this.getSesion()));
				obsGenExc.setFecha(dsObsGenerales.getDate("fecha"));
				obsGenExc.setObservacion(dsObsGenerales.getString("observacion"));
				obsGenExc.setPredioExcluido(PredioExcluido.findByOidProxy(dsObsGenerales.getInteger("oid_predio"), this.getSesion()));
				if (dsObsGenerales.getString("activo").equals("1"))
					obsGenExc.setActivo(true);
				else
					obsGenExc.setActivo(false);
				if (!obsGenExc.isActivo())
					obsGenExc.delete();
				individuoexcluido.addObservacionGeneral(obsGenExc);
				dsObsGenerales.next();
			}

			IDataSet dsNovedades = dataset.getDataSet("TNovedadExcluido");
			dsNovedades.first();
			while (!dsNovedades.EOF()) {
				NovedadExcluido novedadExc = NovedadExcluido.findByOid(dsNovedades.getInteger("oid_novedad"), this.getSesion());
				novedadExc.setFecha(dsNovedades.getDate("fecha"));
				novedadExc.setHora(dsNovedades.getString("hora"));
				novedadExc.setEstado(EstadoExcluido.findByOidProxy(dsNovedades.getInteger("oid_estado"), this.getSesion()));
				novedadExc.setLugar_del_hecho(LugarHechoExcluido.findByOidProxy(dsNovedades.getInteger("oid_lugar_hecho"), this.getSesion()));
				novedadExc.setSe_retira_en(SeRetiraEnExc.findByOidProxy(dsNovedades.getInteger("oid_se_retira"), this.getSesion()));
				novedadExc.setHora_desde(dsNovedades.getString("hora_desde"));
				novedadExc.setPredio(PredioExcluido.findByOidProxy(dsNovedades.getInteger("oid_predio"), this.getSesion()));
				novedadExc.setMotivo(MotivoNovedadExcluido.findByOidProxy(dsNovedades.getInteger("oid_motivo"), this.getSesion()));
				novedadExc.setTurno(TurnoExcluido.findByOidProxy(dsNovedades.getInteger("oid_turno"), this.getSesion()));
				novedadExc.setHora_hasta(dsNovedades.getString("hora_hasta"));
				novedadExc.setSupervisor(SupervisorExcluido.findByOidProxy(dsNovedades.getInteger("oid_supervisor"), this.getSesion()));
				novedadExc.setGerenteExcluido(GerenteExcluido.findByOidProxy(dsNovedades.getInteger("oid_gerente"), this.getSesion()));
				novedadExc.setObservacion(dsNovedades.getString("observacion"));
				novedadExc.setVig_desde(dsNovedades.getDate("vig_desde"));
				novedadExc.setVig_hasta(dsNovedades.getDate("vig_hasta"));
				if (dsNovedades.getInteger("dejar_sin_efecto").intValue() == 1)
					novedadExc.setDejar_sin_efecto(true);
				else
					novedadExc.setDejar_sin_efecto(false);
				novedadExc.setIndividuoExcluido(IndividuoExcluido.findByOidProxy(dsNovedades.getInteger("oid_individuo"), this.getSesion()));
				novedadExc.setNroActa(dsNovedades.getInteger("nro_acta"));
				novedadExc.setNroRevocamiento(dsNovedades.getInteger("nro_revocamiento"));
				novedadExc.setFecRevocamiento(dsNovedades.getDate("fec_rev"));
				novedadExc.setIrrevocable(dsNovedades.getBoolean("irrevocable"));
				novedadExc.setRestriccionAcceso(dsNovedades.getBoolean("restriccion_acceso"));

				if (dsNovedades.getInteger("activo").intValue() == 1)
					novedadExc.setActivo(true);
				else
					novedadExc.setActivo(false);
				if (!novedadExc.isActivo())
					novedadExc.delete();

				individuoexcluido.addNovedad(novedadExc);

				dsNovedades.next();
			}

			addTransaccion(individuoexcluido);
			dataset.next();
		}
	}

}
