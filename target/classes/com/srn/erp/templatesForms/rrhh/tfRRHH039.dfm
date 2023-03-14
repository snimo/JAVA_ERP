inherited FConsJUICIOS: TFConsJUICIOS
  Left = 95
  Top = 103
  Width = 1088
  Height = 587
  Caption = 'Consulta de JUICIOS'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1072
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 10
      Width = 164
      Height = 21
      Caption = 'Consulta de JUICIOS'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'Times New Roman'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 206
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 1072
    Height = 508
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxGrillaJUICIOS: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 1070
      Height = 506
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      AllowInsert = False
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'seguimiento'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'true'
          TipoCondFiltro2 = tcfIgual
          Color = 10329599
        end>
      object dxGrillaJUICIOSDBTableViewRequisiciones: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        FilterBox.Visible = fvAlways
        DataController.Filter.Active = True
        DataController.Filter.AutoDataSetFilter = True
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.IncSearch = True
        OptionsCustomize.ColumnsQuickCustomization = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
      end
      object dxGrillaJUICIOSBandedTableView1: TcxGridBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        Bands = <
          item
          end>
      end
      object dxGrillaJUICIOSDBBandedTableView: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = dsTConsJUICIO
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupFooters = gfAlwaysVisible
        Bands = <
          item
            Caption = 'Legajos'
            FixedKind = fkLeft
            Width = 547
          end
          item
            Caption = 'Datos Empresa'
            Width = 858
          end
          item
            Caption = 'JUICIOS'
            Width = 2200
          end
          item
            Caption = 'Montos'
            Width = 844
          end
          item
            Caption = 'Pagos'
            Width = 400
          end
          item
            Caption = 'Audiencias'
            Width = 330
          end
          item
            Caption = 'Documentaci'#243'n Enviada'
            Width = 330
          end
          item
            Caption = 'Rubros'
            Width = 500
          end
          item
            Caption = 'Otros'
            Width = 333
          end
          item
            Caption = 'Finanzas'
            Width = 250
          end>
        object dxGrillaJUICIOSDBBandedTableViewcodigo_interno: TcxGridDBBandedColumn
          Caption = 'C'#243'd. Interno'
          DataBinding.FieldName = 'codigo_interno'
          HeaderAlignmentHorz = taCenter
          Width = 97
          Position.BandIndex = 8
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewlegajo: TcxGridDBBandedColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          Width = 84
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewape_y_nom: TcxGridDBBandedColumn
          Caption = 'Actor'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 274
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewprocedencia: TcxGridDBBandedColumn
          Caption = 'Procedencia Empresa'
          DataBinding.FieldName = 'procedencia'
          HeaderAlignmentHorz = taCenter
          Width = 189
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewrequerido: TcxGridDBBandedColumn
          Caption = 'Demandadas'
          DataBinding.FieldName = 'requerido'
          HeaderAlignmentHorz = taCenter
          Width = 108
          Position.BandIndex = 2
          Position.ColIndex = 9
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewpuesto: TcxGridDBBandedColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto'
          HeaderAlignmentHorz = taCenter
          Width = 278
          Position.BandIndex = 1
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewseco: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'seco'
          HeaderAlignmentHorz = taCenter
          Width = 261
          Position.BandIndex = 1
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewfec_ant_reco: TcxGridDBBandedColumn
          Caption = 'Fec.Ant.Rec.'
          DataBinding.FieldName = 'fec_ant_reco'
          HeaderAlignmentHorz = taCenter
          Width = 107
          Position.BandIndex = 1
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewfec_ing_real: TcxGridDBBandedColumn
          Caption = 'Fec.Ing.Real'
          DataBinding.FieldName = 'fec_ing_real'
          HeaderAlignmentHorz = taCenter
          Width = 105
          Position.BandIndex = 1
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewfec_egreso: TcxGridDBBandedColumn
          Caption = 'Fec.Egreso'
          DataBinding.FieldName = 'fec_egreso'
          HeaderAlignmentHorz = taCenter
          Width = 107
          Position.BandIndex = 1
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewtipo_reclamo: TcxGridDBBandedColumn
          Caption = 'Tipo de Reclamo'
          DataBinding.FieldName = 'tipo_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 96
          Position.BandIndex = 2
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewestado_seclo: TcxGridDBBandedColumn
          Caption = '% Previsi'#243'n'
          DataBinding.FieldName = 'porc_prevision'
          HeaderAlignmentHorz = taCenter
          Width = 78
          Position.BandIndex = 3
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewobservaciones: TcxGridDBBandedColumn
          Caption = 'Observaciones'
          DataBinding.FieldName = 'observaciones'
          HeaderAlignmentHorz = taCenter
          Width = 373
          Position.BandIndex = 2
          Position.ColIndex = 15
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewfec_recepcion: TcxGridDBBandedColumn
          Caption = '  Fec. Demanda'
          DataBinding.FieldName = 'fec_recepcion'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Width = 77
          Position.BandIndex = 2
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewmonto_reclamo: TcxGridDBBandedColumn
          Caption = 'Monto Reclamo'
          DataBinding.FieldName = 'monto_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 74
          Position.BandIndex = 2
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewmonto_acuerdo: TcxGridDBBandedColumn
          Caption = 'Previsi'#243'n'
          DataBinding.FieldName = 'estimado'
          HeaderAlignmentHorz = taCenter
          Width = 79
          Position.BandIndex = 3
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewhono_letrado: TcxGridDBBandedColumn
          Caption = 'Hon. Letrado'
          DataBinding.FieldName = 'hono_letrado'
          HeaderAlignmentHorz = taCenter
          Width = 72
          Position.BandIndex = 3
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewhono_conciliador: TcxGridDBBandedColumn
          Caption = 'Hon. Conciliador'
          DataBinding.FieldName = 'hono_conciliador'
          HeaderAlignmentHorz = taCenter
          Width = 89
          Position.BandIndex = 3
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewhono_otros: TcxGridDBBandedColumn
          Caption = 'Hon. Otros'
          DataBinding.FieldName = 'hono_otros'
          HeaderAlignmentHorz = taCenter
          Width = 81
          Position.BandIndex = 3
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewpagado: TcxGridDBBandedColumn
          Caption = 'Pagado'
          DataBinding.FieldName = 'pagado'
          HeaderAlignmentHorz = taCenter
          Width = 93
          Position.BandIndex = 3
          Position.ColIndex = 9
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewpagos_realizados: TcxGridDBBandedColumn
          Caption = 'Detalle Pagos'
          DataBinding.FieldName = 'pagos_realizados'
          HeaderAlignmentHorz = taCenter
          HeaderGlyphAlignmentHorz = taCenter
          Width = 343
          Position.BandIndex = 4
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewaudiencias: TcxGridDBBandedColumn
          Caption = 'Audiencias JUICIOS'
          DataBinding.FieldName = 'audiencias'
          HeaderAlignmentHorz = taCenter
          Width = 20
          Position.BandIndex = 5
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewdocu_enviada: TcxGridDBBandedColumn
          Caption = 'Documentaci'#243'n'
          DataBinding.FieldName = 'docu_enviada'
          HeaderAlignmentHorz = taCenter
          Width = 57
          Position.BandIndex = 6
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn1: TcxGridDBBandedColumn
          Caption = 'Causal Distracto'
          DataBinding.FieldName = 'motivo_egreso'
          HeaderAlignmentHorz = taCenter
          HeaderGlyphAlignmentHorz = taCenter
          Width = 104
          Position.BandIndex = 2
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn2: TcxGridDBBandedColumn
          Caption = 'Etapa Procesal'
          DataBinding.FieldName = 'etapa_procesal'
          HeaderAlignmentHorz = taCenter
          Width = 149
          Position.BandIndex = 2
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn3: TcxGridDBBandedColumn
          Caption = 'Nro. Juzgado'
          DataBinding.FieldName = 'juzgado'
          HeaderAlignmentHorz = taCenter
          Width = 161
          Position.BandIndex = 2
          Position.ColIndex = 10
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn4: TcxGridDBBandedColumn
          Caption = 'Fec. Novedad'
          DataBinding.FieldName = 'fec_novedad'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 11
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn5: TcxGridDBBandedColumn
          Caption = 'Resultado Juicio'
          DataBinding.FieldName = 'resultado_juicio'
          HeaderAlignmentHorz = taCenter
          Width = 89
          Position.BandIndex = 2
          Position.ColIndex = 12
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn6: TcxGridDBBandedColumn
          Caption = 'Cap Acue/Conde'
          DataBinding.FieldName = 'monto_acuerdo'
          HeaderAlignmentHorz = taCenter
          Width = 98
          Position.BandIndex = 3
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn7: TcxGridDBBandedColumn
          Caption = 'Hon. Perito'
          DataBinding.FieldName = 'hono_perito'
          HeaderAlignmentHorz = taCenter
          Width = 69
          Position.BandIndex = 3
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn8: TcxGridDBBandedColumn
          Caption = 'Hon. Justicia'
          DataBinding.FieldName = 'hono_justicia'
          HeaderAlignmentHorz = taCenter
          Width = 93
          Position.BandIndex = 3
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn9: TcxGridDBBandedColumn
          Caption = 'Rubro Condena'
          DataBinding.FieldName = 'rubros_condena'
          HeaderAlignmentHorz = taCenter
          Width = 160
          Position.BandIndex = 7
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn10: TcxGridDBBandedColumn
          Caption = 'Nro. Expediente'
          DataBinding.FieldName = 'nro_expediente'
          HeaderAlignmentHorz = taCenter
          Width = 95
          Position.BandIndex = 2
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn11: TcxGridDBBandedColumn
          Caption = 'Abogado'
          DataBinding.FieldName = 'abogado'
          HeaderAlignmentHorz = taCenter
          Width = 130
          Position.BandIndex = 2
          Position.ColIndex = 18
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn12: TcxGridDBBandedColumn
          Caption = 'Estado Juicio'
          DataBinding.FieldName = 'estado_juicio'
          HeaderAlignmentHorz = taCenter
          Width = 101
          Position.BandIndex = 2
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn13: TcxGridDBBandedColumn
          Caption = 'Per'#237'odo Finan.'
          DataBinding.FieldName = 'periodo'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Position.BandIndex = 9
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn14: TcxGridDBBandedColumn
          Caption = 'Prev. Finanzas'
          DataBinding.FieldName = 'prev_finanzas'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Position.BandIndex = 9
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn15: TcxGridDBBandedColumn
          Caption = 'S.'
          DataBinding.FieldName = 'seguimiento'
          PropertiesClassName = 'TcxCheckBoxProperties'
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn16: TcxGridDBBandedColumn
          Caption = 'Embargo'
          DataBinding.FieldName = 'embargo'
          HeaderAlignmentHorz = taCenter
          Width = 69
          Position.BandIndex = 2
          Position.ColIndex = 13
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn17: TcxGridDBBandedColumn
          Caption = 'Tipo Pericia'
          DataBinding.FieldName = 'tipo_pericia'
          HeaderAlignmentHorz = taCenter
          Width = 162
          Position.BandIndex = 8
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn18: TcxGridDBBandedColumn
          Caption = 'Fuero'
          DataBinding.FieldName = 'fuero'
          HeaderAlignmentHorz = taCenter
          Width = 93
          Position.BandIndex = 2
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn19: TcxGridDBBandedColumn
          Caption = 'Rubro Reclamados'
          DataBinding.FieldName = 'rubro_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 140
          Position.BandIndex = 7
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn20: TcxGridDBBandedColumn
          Caption = 'Seguro Cauci'#243'n'
          DataBinding.FieldName = 'desc_comp_seg_cau'
          HeaderAlignmentHorz = taCenter
          Width = 124
          Position.BandIndex = 2
          Position.ColIndex = 14
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn21: TcxGridDBBandedColumn
          Caption = 'Caratula'
          DataBinding.FieldName = 'caratula'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Options.Editing = False
          Width = 277
          Position.BandIndex = 2
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn22: TcxGridDBBandedColumn
          Caption = '% Incapacidad'
          DataBinding.FieldName = 'porc_incapacidad'
          Width = 74
          Position.BandIndex = 8
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn23: TcxGridDBBandedColumn
          Caption = 'Inte. Acue/Conde'
          DataBinding.FieldName = 'monto_interes'
          Width = 92
          Position.BandIndex = 3
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn24: TcxGridDBBandedColumn
          Caption = '1er. Instancia'
          DataBinding.FieldName = 'primera_instancia'
          HeaderAlignmentHorz = taCenter
          Width = 200
          Position.BandIndex = 2
          Position.ColIndex = 16
          Position.RowIndex = 0
        end
        object dxGrillaJUICIOSDBBandedTableViewColumn25: TcxGridDBBandedColumn
          Caption = '2da. Instancia'
          DataBinding.FieldName = 'segunda_instancia'
          HeaderAlignmentHorz = taCenter
          Width = 200
          Position.BandIndex = 2
          Position.ColIndex = 17
          Position.RowIndex = 0
        end
      end
      object dxGrillaJUICIOSLevel1: TcxGridLevel
        GridView = dxGrillaJUICIOSDBBandedTableView
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsJUICIO
        TableName = 'TConsJUICIO'
      end>
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '   varios.setImagen('#39'ImageSalir'#39',7);'
          '  Tinput.loadFromAllData(getParamValue('#39'Tinput'#39'));'
          
            '  TSelTipoReclamo.loadFromAllData(getParamValue('#39'TSelTipoReclamo' +
            #39'));'
          '  TSelLegajos.loadFromAllData(getParamValue('#39'TSelLegajos'#39'));'
          '  TSelEmpresas.loadFromAllData(getParamValue('#39'TSelEmpresas'#39'));'
          '  TSelSector.loadFromAllData(getParamValue('#39'TSelSector'#39'));'
          '  TSelPuesto.loadFromAllData(getParamValue('#39'TSelPuesto'#39'));'
          '  TSelEstado.loadFromAllData(getParamValue('#39'TSelEstado'#39'));'
          
            '  TSelEstadoSECLO.loadFromAllData(getParamValue('#39'TSelEstadoSECLO' +
            #39'));'
          
            '  TSelCausalDistracto.loadFromAllData(getParamValue('#39'TSelCausalD' +
            'istracto'#39'));'
          
            '  TResulProbJuicio.loadFromAllData(getParamValue('#39'TResulProbJuic' +
            'io'#39'));'
          
            '  TEstadosProcesales.loadFromAllData(getParamValue('#39'TEstadosProc' +
            'esales'#39'));'
          '  TJuzgado.loadFromAllData(getParamValue('#39'TJuzgado'#39'));'
          '  TEstadoJuicio.loadFromAllData(getParamValue('#39'TEstadoJuicio'#39'));'
          
            '  TResultadoJuicio.loadFromAllData(getParamValue('#39'TResultadoJuic' +
            'io'#39'));'
          '  TAbogados.loadFromAllData(getParamValue('#39'TAbogados'#39'));'
          '  TFuero.loadFromAllData(getParamValue('#39'TFuero'#39'));'
          ''
          ''
          '  dxGrillaJUICIOS.ActivarEventoPintarCeldas();'
          '  EjecutarConsulta();'
          '  end.'
          ''
          '')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  dxGrillaJUICIOS.setDataSource(nil);'
          ''
          '  try'
          ''
          '    operacion.inicioOperacion;'
          '    operacion.setOper('#39'TraerConsultaJUICIOS'#39');'
          '    operacion.AddDataSet(Tinput.getDataSet());'
          '    operacion.AddDataSet(TSelTipoReclamo.getDataSet());'
          '    operacion.AddDataSet(TSelEstadoSECLO.getDataSet());'
          '    operacion.AddDataSet(TSelLegajos.getDataSet());'
          '    operacion.AddDataSet(TSelEmpresas.getDataSet());'
          '    operacion.AddDataSet(TSelSector.getDataSet());'
          '    operacion.AddDataSet(TSelPuesto.getDataSet());'
          '    operacion.AddDataSet(TSelEstado.getDataSet());'
          '    operacion.AddDataSet(TSelCausalDistracto.getDataSet());'
          '    operacion.AddDataSet(TResulProbJuicio.getDataSet());'
          '    operacion.AddDataSet(TEstadosProcesales.getDataSet());'
          '    operacion.AddDataSet(TJuzgado.getDataSet());'
          '    operacion.AddDataSet(TEstadoJuicio.getDataSet());'
          '    operacion.AddDataSet(TResultadoJuicio.getDataSet());'
          '    operacion.AddDataSet(TAbogados.getDataSet());'
          '    operacion.AddDataSet(TFuero.getDataSet());'
          ''
          '    operacion.execute();'
          ''
          '  finally'
          ''
          '  dxGrillaJUICIOS.setDataSourceByName('#39'dsTConsJUICIO'#39');'
          ''
          '  end;'
          ''
          '  dxGrillaJUICIOS.gotoFirstRecord;'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  Close;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TSelTipoReclamo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 72
    Top = 362
    object BooleanField6: TBooleanField
      FieldName = 'sel'
    end
    object TSelTipoReclamooid_tipo_reclamo: TIntegerField
      FieldName = 'oid_tipo_reclamo'
    end
    object TSelTipoReclamodesc_tipo_reclamo: TStringField
      FieldName = 'desc_tipo_reclamo'
      Size = 100
    end
  end
  object TSelEstadoSECLO: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 72
    Top = 404
    object BooleanField7: TBooleanField
      FieldName = 'sel'
    end
    object TSelEstadoSECLOoid_estado_seclo: TIntegerField
      FieldName = 'oid_estado_seclo'
    end
    object TSelEstadoSECLOdesc_estado_seclo: TStringField
      FieldName = 'desc_estado_seclo'
      Size = 255
    end
  end
  object TSelLegajos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 151
    Top = 321
    object BooleanField1: TBooleanField
      FieldName = 'sel'
    end
    object TSelLegajosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TSelLegajosnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TSelLegajosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
  end
  object TSelEmpresas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 232
    Top = 321
    object BooleanField2: TBooleanField
      FieldName = 'sel'
    end
    object TSelEmpresasoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TSelEmpresasrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 100
    end
  end
  object TSelSector: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 307
    Top = 321
    object BooleanField3: TBooleanField
      FieldName = 'sel'
    end
    object TSelSectoroid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TSelSectordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TSelPuesto: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 383
    Top = 321
    object BooleanField4: TBooleanField
      FieldName = 'sel'
    end
    object TSelPuestooid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object StringField1: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TSelEstado: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 452
    Top = 321
    object BooleanField5: TBooleanField
      FieldName = 'sel'
    end
    object TSelEstadooid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object Tinput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 112
    Top = 240
    object Tinputmonto_desde: TCurrencyField
      FieldName = 'monto_desde'
      DisplayFormat = '###,###,###,###.##'
    end
    object Tinputmonto_hasta: TCurrencyField
      FieldName = 'monto_hasta'
      DisplayFormat = '###,###,###,###.##'
    end
    object Tinputcodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object Tinputsolo_con_aud_pend: TBooleanField
      FieldName = 'solo_con_aud_pend'
    end
    object Tinputfec_rec_desde: TDateField
      FieldName = 'fec_rec_desde'
    end
    object Tinputfec_rec_hasta: TDateField
      FieldName = 'fec_rec_hasta'
    end
    object Tinputsolo_con_prev_finan: TBooleanField
      FieldName = 'solo_con_prev_finan'
    end
    object Tinputsolo_con_embargos: TBooleanField
      FieldName = 'solo_con_embargos'
    end
  end
  object TConsJUICIO: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 488
    Top = 89
    object TConsJUICIOcodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object TConsJUICIOlegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TConsJUICIOape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
    object TConsJUICIOprocedencia: TStringField
      FieldName = 'procedencia'
      Size = 1000
    end
    object TConsJUICIOrequerido: TMemoField
      FieldName = 'requerido'
      BlobType = ftMemo
    end
    object TConsJUICIOpuesto: TStringField
      FieldName = 'puesto'
      Size = 255
    end
    object TConsJUICIOseco: TStringField
      FieldName = 'seco'
      Size = 255
    end
    object TConsJUICIOfec_ant_reco: TDateField
      FieldName = 'fec_ant_reco'
    end
    object TConsJUICIOfec_ing_real: TDateField
      FieldName = 'fec_ing_real'
    end
    object TConsJUICIOfec_egreso: TDateField
      FieldName = 'fec_egreso'
    end
    object TConsJUICIOtipo_reclamo: TStringField
      FieldName = 'tipo_reclamo'
      Size = 100
    end
    object TConsJUICIOestado_seclo: TStringField
      FieldName = 'estado_seclo'
      Size = 255
    end
    object TConsJUICIOobservaciones: TMemoField
      FieldName = 'observaciones'
      BlobType = ftMemo
    end
    object TConsJUICIOfec_recepcion: TDateField
      FieldName = 'fec_recepcion'
    end
    object TConsJUICIOmonto_reclamo: TFloatField
      FieldName = 'monto_reclamo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOmonto_acuerdo: TFloatField
      FieldName = 'monto_acuerdo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOhono_letrado: TFloatField
      FieldName = 'hono_letrado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOhono_conciliador: TFloatField
      FieldName = 'hono_conciliador'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOhono_otros: TFloatField
      FieldName = 'hono_otros'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOhono_perito: TFloatField
      FieldName = 'hono_perito'
    end
    object TConsJUICIOhono_justicia: TFloatField
      FieldName = 'hono_justicia'
    end
    object TConsJUICIOtotal: TFloatField
      FieldName = 'total'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOpagado: TFloatField
      FieldName = 'pagado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOsaldo: TFloatField
      FieldName = 'saldo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOaudiencias: TMemoField
      FieldName = 'audiencias'
      BlobType = ftMemo
    end
    object TConsJUICIOdocu_enviada: TMemoField
      FieldName = 'docu_enviada'
      BlobType = ftMemo
    end
    object TConsJUICIOpagos_realizados: TMemoField
      FieldName = 'pagos_realizados'
      BlobType = ftMemo
    end
    object TConsJUICIOmotivo_egreso: TStringField
      FieldName = 'motivo_egreso'
      Size = 100
    end
    object TConsJUICIOetapa_procesal: TStringField
      FieldName = 'etapa_procesal'
      Size = 100
    end
    object TConsJUICIOjuzgado: TMemoField
      FieldName = 'juzgado'
      BlobType = ftMemo
    end
    object TConsJUICIOfec_novedad: TDateField
      FieldName = 'fec_novedad'
    end
    object TConsJUICIOresultado_juicio: TStringField
      FieldName = 'resultado_juicio'
      Size = 50
    end
    object TConsJUICIOporc_prevision: TFloatField
      FieldName = 'porc_prevision'
    end
    object TConsJUICIOestimado: TFloatField
      FieldName = 'estimado'
    end
    object TConsJUICIOrubros_condena: TMemoField
      FieldName = 'rubros_condena'
      BlobType = ftMemo
    end
    object TConsJUICIOnro_expediente: TStringField
      FieldName = 'nro_expediente'
      Size = 50
    end
    object TConsJUICIOabogado: TStringField
      FieldName = 'abogado'
      Size = 255
    end
    object TConsJUICIOestado_juicio: TStringField
      FieldName = 'estado_juicio'
      Size = 100
    end
    object TConsJUICIOperiodo: TStringField
      FieldName = 'periodo'
      Size = 10
    end
    object TConsJUICIOprev_finanzas: TFloatField
      FieldName = 'prev_finanzas'
    end
    object TConsJUICIOseguimiento: TBooleanField
      FieldName = 'seguimiento'
    end
    object TConsJUICIOembargo: TFloatField
      FieldName = 'embargo'
    end
    object TConsJUICIOtipo_pericia: TStringField
      FieldName = 'tipo_pericia'
      Size = 100
    end
    object TConsJUICIOoid_fuero: TIntegerField
      FieldName = 'oid_fuero'
    end
    object TConsJUICIOfuero: TStringField
      FieldName = 'fuero'
      Size = 100
    end
    object TConsJUICIOrubro_reclamo: TMemoField
      FieldName = 'rubro_reclamo'
      BlobType = ftMemo
    end
    object TConsJUICIOoid_comp_seg_cau: TIntegerField
      FieldName = 'oid_comp_seg_cau'
    end
    object TConsJUICIOdesc_comp_seg_cau: TStringField
      FieldName = 'desc_comp_seg_cau'
      Size = 100
    end
    object TConsJUICIOcaratula: TStringField
      FieldName = 'caratula'
      Size = 250
    end
    object TConsJUICIOporc_incapacidad: TFloatField
      FieldName = 'porc_incapacidad'
    end
    object TConsJUICIOmonto_interes: TFloatField
      FieldName = 'monto_interes'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsJUICIOprimera_instancia: TStringField
      FieldName = 'primera_instancia'
      Size = 4000
    end
    object TConsJUICIOsegunda_instancia: TStringField
      FieldName = 'segunda_instancia'
      Size = 4000
    end
  end
  object dsTConsJUICIO: TDataSource
    DataSet = TConsJUICIO
    Left = 520
    Top = 89
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 688
    Top = 76
  end
  object TAbogados: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 968
    Top = 394
    object BooleanField14: TBooleanField
      FieldName = 'sel'
    end
    object StringField13: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TAbogadosoid_abogado: TIntegerField
      FieldName = 'oid_abogado'
    end
  end
  object TResultadoJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 888
    Top = 394
    object BooleanField13: TBooleanField
      FieldName = 'sel'
    end
    object StringField10: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField11: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TEstadoJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 888
    Top = 354
    object BooleanField12: TBooleanField
      FieldName = 'sel'
    end
    object StringField8: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField9: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TJuzgado: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 888
    Top = 321
    object BooleanField11: TBooleanField
      FieldName = 'sel'
    end
    object StringField6: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField7: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TEstadosProcesales: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 888
    Top = 285
    object BooleanField10: TBooleanField
      FieldName = 'sel'
    end
    object TEstadosProcesalesoid: TIntegerField
      FieldName = 'oid'
    end
    object StringField4: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField5: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TResulProbJuicio: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 888
    Top = 250
    object BooleanField9: TBooleanField
      FieldName = 'sel'
    end
    object TResulProbJuiciocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TResulProbJuiciodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TSelCausalDistracto: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 888
    Top = 217
    object BooleanField8: TBooleanField
      FieldName = 'sel'
    end
    object IntegerField1: TIntegerField
      FieldName = 'oid_estado_seclo'
    end
    object StringField3: TStringField
      FieldName = 'desc_estado_seclo'
      Size = 255
    end
  end
  object TFuero: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 508
    Top = 319
    object BooleanField15: TBooleanField
      FieldName = 'sel'
    end
    object TFuerooid_fuero: TIntegerField
      FieldName = 'oid_fuero'
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
end
