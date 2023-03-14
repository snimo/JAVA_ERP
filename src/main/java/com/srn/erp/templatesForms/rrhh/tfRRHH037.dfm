inherited FConsSECLOS: TFConsSECLOS
  Left = 91
  Top = 103
  Width = 1088
  Height = 743
  Caption = 'Consulta de SECLOS'
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
      Width = 318
      Height = 21
      Caption = 'Consulta de SECLOS \ Acuerdos Internos'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'Times New Roman'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 342
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
    Height = 664
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxGrillaSECLOS: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 1070
      Height = 662
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
      object dxGrillaSECLOSDBTableViewRequisiciones: TcxGridDBTableView
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
      object dxGrillaSECLOSBandedTableView1: TcxGridBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        Bands = <
          item
          end>
      end
      object dxGrillaSECLOSDBBandedTableView: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsSeclo
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
            Caption = 'SECLO'
            Width = 1263
          end
          item
            Caption = 'Monto Acordado'
            Width = 450
          end
          item
            Caption = 'Pagos'
            Width = 600
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
            Caption = 'Acuerdo Interno'
            Width = 500
          end>
        object dxGrillaSECLOSDBBandedTableViewColumn5: TcxGridDBBandedColumn
          Caption = 'Tipo'
          DataBinding.FieldName = 'tipo'
          HeaderAlignmentHorz = taCenter
          Width = 85
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewcodigo_interno: TcxGridDBBandedColumn
          Caption = 'C'#243'd. Interno'
          DataBinding.FieldName = 'codigo_interno'
          HeaderAlignmentHorz = taCenter
          Width = 92
          Position.BandIndex = 2
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewlegajo: TcxGridDBBandedColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          Width = 68
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewape_y_nom: TcxGridDBBandedColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 218
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewprocedencia: TcxGridDBBandedColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'procedencia'
          HeaderAlignmentHorz = taCenter
          Width = 148
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewrequerido: TcxGridDBBandedColumn
          Caption = 'Requerido'
          DataBinding.FieldName = 'requerido'
          HeaderAlignmentHorz = taCenter
          Width = 199
          Position.BandIndex = 2
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpuesto: TcxGridDBBandedColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto'
          HeaderAlignmentHorz = taCenter
          Width = 278
          Position.BandIndex = 1
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewseco: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'seco'
          HeaderAlignmentHorz = taCenter
          Width = 261
          Position.BandIndex = 1
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_ant_reco: TcxGridDBBandedColumn
          Caption = 'Fec.Ant.Rec.'
          DataBinding.FieldName = 'fec_ant_reco'
          HeaderAlignmentHorz = taCenter
          Width = 107
          Position.BandIndex = 1
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_ing_real: TcxGridDBBandedColumn
          Caption = 'Fec.Ing.Real'
          DataBinding.FieldName = 'fec_ing_real'
          HeaderAlignmentHorz = taCenter
          Width = 105
          Position.BandIndex = 1
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_egreso: TcxGridDBBandedColumn
          Caption = 'Fec.Egreso'
          DataBinding.FieldName = 'fec_egreso'
          HeaderAlignmentHorz = taCenter
          Width = 107
          Position.BandIndex = 1
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewtipo_reclamo: TcxGridDBBandedColumn
          Caption = 'Tipo SECLO'
          DataBinding.FieldName = 'tipo_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 111
          Position.BandIndex = 2
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewestado_seclo: TcxGridDBBandedColumn
          Caption = 'Estado SECLO'
          DataBinding.FieldName = 'estado_seclo'
          HeaderAlignmentHorz = taCenter
          Width = 108
          Position.BandIndex = 2
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewobservaciones: TcxGridDBBandedColumn
          Caption = 'Observaciones'
          DataBinding.FieldName = 'observaciones'
          HeaderAlignmentHorz = taCenter
          Width = 253
          Position.BandIndex = 2
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_recepcion: TcxGridDBBandedColumn
          Caption = '  Fec. Recepci'#243'n'
          DataBinding.FieldName = 'fec_recepcion'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Width = 92
          Position.BandIndex = 2
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_reclamo: TcxGridDBBandedColumn
          Caption = 'Monto Reclamo'
          DataBinding.FieldName = 'monto_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 100
          Position.BandIndex = 2
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_acuerdo: TcxGridDBBandedColumn
          Caption = 'Acuerdo/Condena'
          DataBinding.FieldName = 'monto_acuerdo'
          HeaderAlignmentHorz = taCenter
          Width = 97
          Position.BandIndex = 3
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewhono_letrado: TcxGridDBBandedColumn
          Caption = 'Hon. Letrado'
          DataBinding.FieldName = 'hono_letrado'
          HeaderAlignmentHorz = taCenter
          Width = 88
          Position.BandIndex = 3
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewhono_conciliador: TcxGridDBBandedColumn
          Caption = 'Hon. Conciliador'
          DataBinding.FieldName = 'hono_conciliador'
          HeaderAlignmentHorz = taCenter
          Width = 89
          Position.BandIndex = 3
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewhono_otros: TcxGridDBBandedColumn
          Caption = 'Hon. Otros'
          DataBinding.FieldName = 'hono_otros'
          HeaderAlignmentHorz = taCenter
          Width = 88
          Position.BandIndex = 3
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewtotal: TcxGridDBBandedColumn
          Caption = 'Total'
          DataBinding.FieldName = 'total'
          HeaderAlignmentHorz = taCenter
          Width = 88
          Position.BandIndex = 3
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpagado: TcxGridDBBandedColumn
          Caption = 'Pagado'
          DataBinding.FieldName = 'pagado'
          HeaderAlignmentHorz = taCenter
          Width = 96
          Position.BandIndex = 4
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpagos_realizados: TcxGridDBBandedColumn
          Caption = 'Detalle Pagos'
          DataBinding.FieldName = 'pagos_realizados'
          HeaderAlignmentHorz = taCenter
          HeaderGlyphAlignmentHorz = taCenter
          Width = 407
          Position.BandIndex = 4
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewsaldo: TcxGridDBBandedColumn
          Caption = 'Saldo'
          DataBinding.FieldName = 'saldo'
          HeaderAlignmentHorz = taCenter
          Width = 97
          Position.BandIndex = 4
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewaudiencias: TcxGridDBBandedColumn
          Caption = 'Audiencias SECLOS'
          DataBinding.FieldName = 'audiencias'
          HeaderAlignmentHorz = taCenter
          Width = 20
          Position.BandIndex = 5
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewdocu_enviada: TcxGridDBBandedColumn
          Caption = 'Documentaci'#243'n'
          DataBinding.FieldName = 'docu_enviada'
          HeaderAlignmentHorz = taCenter
          Width = 57
          Position.BandIndex = 6
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn1: TcxGridDBBandedColumn
          Caption = 'S.'
          DataBinding.FieldName = 'seguimiento'
          PropertiesClassName = 'TcxCheckBoxProperties'
          Width = 28
          Position.BandIndex = 0
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn2: TcxGridDBBandedColumn
          Caption = 'Forma Extincion'
          DataBinding.FieldName = 'forma_extincion'
          HeaderAlignmentHorz = taCenter
          Width = 135
          Position.BandIndex = 7
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn3: TcxGridDBBandedColumn
          Caption = 'Fec. Novedad'
          DataBinding.FieldName = 'fec_novedad'
          HeaderAlignmentHorz = taCenter
          Width = 110
          Position.BandIndex = 2
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn4: TcxGridDBBandedColumn
          Caption = 'Causal Acuerdo'
          DataBinding.FieldName = 'causal_acuerdo'
          HeaderAlignmentHorz = taCenter
          Width = 365
          Position.BandIndex = 7
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn6: TcxGridDBBandedColumn
          Caption = 'Rubros Reclamos'
          DataBinding.FieldName = 'rubros_reclamos'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 198
          Position.BandIndex = 2
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
      end
      object dxGrillaSECLOSLevel1: TcxGridLevel
        GridView = dxGrillaSECLOSDBBandedTableView
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsSECLO
        TableName = 'TConsSECLO'
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
          '  dxGrillaSECLOS.ActivarEventoPintarCeldas();'
          '  EjecutarConsulta();'
          ''
          'end.'
          ''
          '')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  dxGrillaSECLOS.setDataSource(nil);'
          ''
          '  try'
          ''
          '    operacion.inicioOperacion;'
          '    operacion.setOper('#39'TraerConsultaSECLOS'#39');'
          '    operacion.AddDataSet(Tinput.getDataSet());'
          '    operacion.AddDataSet(TSelTipoReclamo.getDataSet());'
          '    operacion.AddDataSet(TSelEstadoSECLO.getDataSet());'
          '    operacion.AddDataSet(TSelLegajos.getDataSet());'
          '    operacion.AddDataSet(TSelEmpresas.getDataSet());'
          '    operacion.AddDataSet(TSelSector.getDataSet());'
          '    operacion.AddDataSet(TSelPuesto.getDataSet());'
          '    operacion.AddDataSet(TSelEstado.getDataSet());'
          '    operacion.execute();'
          ''
          '  finally'
          ''
          '  dxGrillaSECLOS.setDataSourceByName('#39'DSConsSeclo'#39');'
          ''
          '  end;'
          ''
          '  dxGrillaSECLOS.gotoFirstRecord;'
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
    object Tinputtipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
  end
  object TConsSECLO: TsnTable
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
    Top = 57
    object TConsSECLOcodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object TConsSECLOlegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TConsSECLOape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
    object TConsSECLOprocedencia: TStringField
      FieldName = 'procedencia'
      Size = 1000
    end
    object TConsSECLOrequerido: TMemoField
      FieldName = 'requerido'
      BlobType = ftMemo
    end
    object TConsSECLOpuesto: TStringField
      FieldName = 'puesto'
      Size = 255
    end
    object TConsSECLOseco: TStringField
      FieldName = 'seco'
      Size = 255
    end
    object TConsSECLOfec_ant_reco: TDateField
      FieldName = 'fec_ant_reco'
    end
    object TConsSECLOfec_ing_real: TDateField
      FieldName = 'fec_ing_real'
    end
    object TConsSECLOfec_egreso: TDateField
      FieldName = 'fec_egreso'
    end
    object TConsSECLOtipo_reclamo: TStringField
      FieldName = 'tipo_reclamo'
      Size = 100
    end
    object TConsSECLOestado_seclo: TStringField
      FieldName = 'estado_seclo'
      Size = 255
    end
    object TConsSECLOobservaciones: TMemoField
      FieldName = 'observaciones'
      BlobType = ftMemo
    end
    object TConsSECLOfec_recepcion: TDateField
      FieldName = 'fec_recepcion'
    end
    object TConsSECLOmonto_reclamo: TFloatField
      FieldName = 'monto_reclamo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOmonto_acuerdo: TFloatField
      FieldName = 'monto_acuerdo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOhono_letrado: TFloatField
      FieldName = 'hono_letrado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOhono_conciliador: TFloatField
      FieldName = 'hono_conciliador'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOhono_otros: TFloatField
      FieldName = 'hono_otros'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOtotal: TFloatField
      FieldName = 'total'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOpagado: TFloatField
      FieldName = 'pagado'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOsaldo: TFloatField
      FieldName = 'saldo'
      DisplayFormat = '###,###,###,###.##'
    end
    object TConsSECLOaudiencias: TMemoField
      FieldName = 'audiencias'
      BlobType = ftMemo
    end
    object TConsSECLOdocu_enviada: TMemoField
      FieldName = 'docu_enviada'
      BlobType = ftMemo
    end
    object TConsSECLOpagos_realizados: TMemoField
      FieldName = 'pagos_realizados'
      BlobType = ftMemo
    end
    object TConsSECLOseguimiento: TBooleanField
      FieldName = 'seguimiento'
    end
    object TConsSECLOforma_extincion: TStringField
      FieldName = 'forma_extincion'
      Size = 100
    end
    object TConsSECLOfec_novedad: TDateField
      FieldName = 'fec_novedad'
    end
    object TConsSECLOcausal_acuerdo: TMemoField
      FieldName = 'causal_acuerdo'
      BlobType = ftMemo
    end
    object TConsSECLOtipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object TConsSECLOrubros_reclamos: TMemoField
      FieldName = 'rubros_reclamos'
      BlobType = ftMemo
    end
  end
  object DSConsSeclo: TDataSource
    DataSet = TConsSECLO
    Left = 520
    Top = 57
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 688
    Top = 76
  end
end
