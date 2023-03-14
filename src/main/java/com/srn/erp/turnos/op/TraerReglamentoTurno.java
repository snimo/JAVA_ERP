package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.ReglamentoTurno;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerReglamentoTurno extends Operation { 

  public TraerReglamentoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ReglamentoTurno reglamentoturno = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reglamentoturno = ReglamentoTurno.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reglamentoturno = ReglamentoTurno.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetReglamentoTurno = getDataSetReglamentoTurno();
    if (reglamentoturno != null) { 
        cargarRegistroReglamentoTurno(datasetReglamentoTurno, 
                         reglamentoturno.getOIDInteger(),
                         reglamentoturno.getCodigo(),
                         reglamentoturno.getDescripcion(),
                         reglamentoturno.getComportamiento(),
                         reglamentoturno.isActivo(),
                         reglamentoturno.isUsar(),
                         reglamentoturno.isReglaJugadorInactivo(),
                         reglamentoturno.isReglaJugadorSuspension(),
                         reglamentoturno.isReglaUnturnoActivo(),
                         reglamentoturno.isReglaDeudaCategoria(),
                         reglamentoturno.isReglaDeudaGeneral(),
                         reglamentoturno.getMontoDeudaGral(),
                         reglamentoturno.isReglaAntiguedadDeuda(),
                         reglamentoturno.getDiasAntDeuda(),
                         reglamentoturno.isReglaTurnoSegunCategoria(),
                         reglamentoturno.isReglaTurnoSegunRelacion(),
                         reglamentoturno.isReglaDeudaConcepto(),
                         reglamentoturno.isReglaConcSufCateg()
                         
                         );
    }
    writeCliente(datasetReglamentoTurno);
  }

  private IDataSet getDataSetReglamentoTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TReglamentoTurno");
    dataset.fieldDef(new Field("oid_regla_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("usar", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_jug_inactivo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_jug_susp", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_juj_1tur_act", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_deuda_categ", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_deuda_gral", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("monto_deuda_gral", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("regla_ant_deuda", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("dias_ant_deuda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("regla_no_tur_categ", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_no_tur_rela", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_deuda_conc", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_conc_suf_cat", Field.BOOLEAN, 0));
    
    
    
    return dataset;
  }

  private void cargarRegistroReglamentoTurno(IDataSet dataset, 
                         Integer oid_regla_cab,
                         String codigo,
                         String descripcion,
                         String comportamiento,
                         Boolean activo,
                         Boolean usar,
                         Boolean reglaJugInactivo,
                         Boolean reglaJugSuspendido,
                         Boolean regla1TurnoActivo,
                         Boolean reglaDeudaCategoria,
                         Boolean reglaDeudaGeneral,
                         Money montoDeudaGeneral,
                         Boolean reglaAntDeuda,
                         Integer diasAntDeuda,
                         Boolean reglaTurSegunCateg,
                         Boolean reglaTurSegunRela,
                         Boolean reglaDeudaConc,
                         Boolean reglaConcSufCateg) {
    dataset.append(); 
    dataset.fieldValue("oid_regla_cab", oid_regla_cab);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("usar", usar);
    dataset.fieldValue("regla_jug_inactivo",reglaJugInactivo);
    dataset.fieldValue("regla_jug_susp",reglaJugSuspendido);
    dataset.fieldValue("regla_juj_1tur_act",regla1TurnoActivo);
    dataset.fieldValue("regla_deuda_categ", reglaDeudaCategoria);
    dataset.fieldValue("regla_deuda_gral", reglaDeudaGeneral);
    dataset.fieldValue("monto_deuda_gral", montoDeudaGeneral);
    dataset.fieldValue("regla_ant_deuda", reglaAntDeuda);
    dataset.fieldValue("dias_ant_deuda", diasAntDeuda);
    dataset.fieldValue("regla_no_tur_categ", reglaTurSegunCateg);
    dataset.fieldValue("regla_no_tur_rela", reglaTurSegunRela);
    dataset.fieldValue("regla_deuda_conc", reglaDeudaConc);
    dataset.fieldValue("regla_conc_suf_cat", reglaConcSufCateg);
    
    
  }
}
