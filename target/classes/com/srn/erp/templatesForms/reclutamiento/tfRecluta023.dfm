inherited FRecluConsBusqDet: TFRecluConsBusqDet
  Left = 163
  Top = 38
  Width = 795
  Height = 536
  Caption = 'Consulta de B'#250'squedas Detalladas'
  Font.Charset = ANSI_CHARSET
  Font.Height = -13
  Font.Name = 'Verdana'
  PixelsPerInch = 96
  TextHeight = 16
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 779
    Height = 88
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 32
      Top = 13
      Width = 104
      Height = 27
      Caption = 'B'#250'squedas'
      Font.Charset = ANSI_CHARSET
      Font.Color = clBlack
      Font.Height = -24
      Font.Name = 'Times New Roman'
      Font.Style = []
      ParentFont = False
    end
    object snButton1: TsnButton
      Left = 11
      Top = 45
      Width = 185
      Height = 33
      Caption = 'Traer Candidatos'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 457
    Width = 779
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 88
    Width = 779
    Height = 369
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 779
      Height = 369
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
      end
      object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSBusqueda
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.Deleting = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.HideFocusRectOnExit = False
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
        Styles.Content = cxStyle1
        Styles.Header = cxStyle1
        Styles.BandHeader = cxStyle1
        Bands = <
          item
            Caption = 'B'#250'squeda'
            FixedKind = fkLeft
            Width = 603
          end
          item
            Caption = 'Otros Datos'
            Width = 1200
          end>
        object dxDBGridSN1DBBandedTableView1oid_puesto_busqueda: TcxGridDBBandedColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'oid_puesto_busqueda'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluPuesto
          HeaderAlignmentHorz = taCenter
          Width = 188
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1fec_inicio_busq: TcxGridDBBandedColumn
          Caption = 'Fec. I. Busq.'
          DataBinding.FieldName = 'fec_inicio_busq'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Width = 110
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1cant_vacantes: TcxGridDBBandedColumn
          Caption = 'Vacantes'
          DataBinding.FieldName = 'cant_vacantes'
          HeaderAlignmentHorz = taCenter
          Width = 73
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_motivo_busq: TcxGridDBBandedColumn
          Caption = 'Motivo B'#250'squeda'
          DataBinding.FieldName = 'oid_motivo_busq'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluMotiBusq
          HeaderAlignmentHorz = taCenter
          Width = 153
          Position.BandIndex = 1
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1observaciones: TcxGridDBBandedColumn
          Caption = 'Observaciones'
          DataBinding.FieldName = 'observaciones'
          HeaderAlignmentHorz = taCenter
          Width = 150
          Position.BandIndex = 1
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_operacion: TcxGridDBBandedColumn
          Caption = 'Operaci'#243'n'
          DataBinding.FieldName = 'oid_operacion'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluOperacion
          Visible = False
          GroupIndex = 0
          Position.BandIndex = 0
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1sueldo_bruto: TcxGridDBBandedColumn
          Caption = 'Sueldo Bruto'
          DataBinding.FieldName = 'sueldo_bruto'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1estado_busqueda: TcxGridDBBandedColumn
          Caption = 'Estado'
          DataBinding.FieldName = 'estado_busqueda'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'codigo'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSEstadosBusque
          HeaderAlignmentHorz = taCenter
          Width = 94
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1sexo: TcxGridDBBandedColumn
          Caption = 'Genero Requerido'
          DataBinding.FieldName = 'sexo'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'codigo'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListSource = DSTSexoBusqueda
          HeaderAlignmentHorz = taCenter
          Width = 90
          Position.BandIndex = 1
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_tipo_contrato: TcxGridDBBandedColumn
          Caption = 'Tipo Contrato'
          DataBinding.FieldName = 'oid_tipo_contrato'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluTipoContrato
          HeaderAlignmentHorz = taCenter
          Width = 90
          Position.BandIndex = 1
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_selector: TcxGridDBBandedColumn
          Caption = 'Selector'
          DataBinding.FieldName = 'oid_selector'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluSelector
          HeaderAlignmentHorz = taCenter
          Width = 114
          Position.BandIndex = 1
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_est_aprob_busq: TcxGridDBBandedColumn
          Caption = 'Aprobaci'#243'n'
          DataBinding.FieldName = 'oid_est_aprob_busq'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSEstAprobBusq
          HeaderAlignmentHorz = taCenter
          Width = 77
          Position.BandIndex = 1
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_sector: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'oid_sector'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluSectores
          Visible = False
          GroupIndex = 1
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 0
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1fec_est_aprob: TcxGridDBBandedColumn
          Caption = 'Fec. Est. Aprob.'
          DataBinding.FieldName = 'fec_est_aprob'
          HeaderAlignmentHorz = taCenter
          Width = 93
          Position.BandIndex = 1
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1oid_convenio: TcxGridDBBandedColumn
          Caption = 'Convenio'
          DataBinding.FieldName = 'oid_convenio'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluConvenio
          HeaderAlignmentHorz = taCenter
          Width = 62
          Position.BandIndex = 1
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column1: TcxGridDBBandedColumn
          Caption = 'Motivo'
          DataBinding.FieldName = 'oid_mot_est_busq'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = dsTRecluMotiEstBusq
          HeaderAlignmentHorz = taCenter
          Width = 104
          Position.BandIndex = 0
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBBandedTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TBusqueda
        TableName = 'TBusqueda'
      end
      item
        DataSet = TSexoBusqueda
        TableName = 'TSexoBusqueda'
      end
      item
        DataSet = TEstadosBusqueda
        TableName = 'TEstadosBusqueda'
      end>
    Top = 144
  end
  inherited Operacion: TOperacion
    Top = 144
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 144
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 144
  end
  inherited DriverEvent: TDriverEvent
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          '  TRecluPuesto.loadFromHelp('#39'HelpRecluPuesto'#39');'
          '  TRecluOperacion.loadFromHelp('#39'HelpOperacion'#39');'
          '  TRecluSectores.loadFromHelp('#39'HelpSector'#39');'
          '  TRecluMotivoBusq.loadFromHelp('#39'HelpMotivoBusqueda'#39');'
          '  TRecluEstAprobBusq.loadFromHelp('#39'HelpAprobacion'#39');'
          '  TRecluSelector.loadFromHelp('#39'HelpSelector'#39');'
          '  TRecluTipoContrato.loadFromHelp('#39'HelpTipoContrato'#39');'
          '  TRecluConvenio.loadFromHelp('#39'HelpConvenio'#39');'
          '  TraerRecluGeneroRequerido();'
          '  TraerEstadosBusquedas();'
          '  TMotiEstCandBusq.loadFromHelp('#39'HelpMotiEstCandBusq'#39');'
          '  TRecluMotiEstBusq.loadFromHelp('#39'HelpMotEstBusq'#39');  '
          ''
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerRecluDetBusquedas'#39');'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.execute();'
          ''
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerEstadosBusquedas();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluEstadoBusq'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerRecluGeneroRequerido();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluSexoBusq'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          '')
      end>
    Top = 147
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TInput: TsnTable
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
    Left = 56
    Top = 310
    object TInputbuscar: TStringField
      FieldName = 'buscar'
      Size = 100
    end
    object TInputoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TInputoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TInputoid_selector: TIntegerField
      FieldName = 'oid_selector'
    end
    object TInputoid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TInputabiertas: TBooleanField
      FieldName = 'abiertas'
    end
    object TInputcerradas: TBooleanField
      FieldName = 'cerradas'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object TBusqueda: TsnTable
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
    Left = 368
    Top = 281
    object TBusquedaoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TBusquedaoid_puesto_busqueda: TIntegerField
      FieldName = 'oid_puesto_busqueda'
    end
    object TBusquedafec_inicio_busq: TDateField
      FieldName = 'fec_inicio_busq'
    end
    object TBusquedacant_vacantes: TIntegerField
      FieldName = 'cant_vacantes'
    end
    object TBusquedaoid_motivo_busq: TIntegerField
      FieldName = 'oid_motivo_busq'
    end
    object TBusquedaobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TBusquedaoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TBusquedasueldo_bruto: TFloatField
      FieldName = 'sueldo_bruto'
    end
    object TBusquedaestado_busqueda: TStringField
      FieldName = 'estado_busqueda'
      Size = 10
    end
    object TBusquedasexo: TStringField
      FieldName = 'sexo'
      Size = 1
    end
    object TBusquedaoid_tipo_contrato: TIntegerField
      FieldName = 'oid_tipo_contrato'
    end
    object TBusquedaoid_selector: TIntegerField
      FieldName = 'oid_selector'
    end
    object TBusquedaoid_est_aprob_busq: TIntegerField
      FieldName = 'oid_est_aprob_busq'
    end
    object TBusquedaoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TBusquedafec_est_aprob: TDateField
      FieldName = 'fec_est_aprob'
    end
    object TBusquedaoid_convenio: TIntegerField
      FieldName = 'oid_convenio'
    end
    object TBusquedaoid_mot_est_busq: TIntegerField
      FieldName = 'oid_mot_est_busq'
    end
    object TBusquedaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSBusqueda: TDataSource
    DataSet = TBusqueda
    Left = 408
    Top = 281
  end
  object HelpRecluPuesto: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPuesto'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 48
    Top = 180
  end
  object TRecluPuesto: TsnTable
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
    Left = 82
    Top = 180
    object IntegerField5: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluPuesto: TDataSource
    DataSet = TRecluPuesto
    Left = 116
    Top = 180
  end
  object HelpOperacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluOperacion'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 48
    Top = 220
  end
  object TRecluOperacion: TsnTable
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
    Left = 82
    Top = 220
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluOperacion: TDataSource
    DataSet = TRecluOperacion
    Left = 116
    Top = 220
  end
  object HelpSector: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSectores'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 48
    Top = 259
  end
  object TRecluSectores: TsnTable
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
    Left = 82
    Top = 259
    object IntegerField2: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluSectores: TDataSource
    DataSet = TRecluSectores
    Left = 116
    Top = 259
  end
  object HelpMotivoBusqueda: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluMotivoBusqueda'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 48
    Top = 292
  end
  object TRecluMotivoBusq: TsnTable
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
    Left = 82
    Top = 292
    object IntegerField3: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluMotiBusq: TDataSource
    DataSet = TRecluMotivoBusq
    Left = 116
    Top = 292
  end
  object DSEstAprobBusq: TDataSource
    DataSet = TRecluEstAprobBusq
    Left = 115
    Top = 329
  end
  object TRecluEstAprobBusq: TsnTable
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
    Left = 81
    Top = 329
    object IntegerField4: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField9: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField10: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object HelpAprobacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstAprobBusq'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 47
    Top = 329
  end
  object HelpMotiEstCandBusq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluMotiEstCandBusq'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 47
    Top = 365
  end
  object TMotiEstCandBusq: TsnTable
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
    Left = 81
    Top = 365
    object IntegerField9: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField19: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField20: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DStMotiEstCandBusq: TDataSource
    DataSet = TMotiEstCandBusq
    Left = 115
    Top = 365
  end
  object HelpConvenio: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluConvenio'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 169
    Top = 246
  end
  object TRecluConvenio: TsnTable
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
    Left = 203
    Top = 246
    object IntegerField8: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField15: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField16: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluConvenio: TDataSource
    DataSet = TRecluConvenio
    Left = 237
    Top = 246
  end
  object DSRecluTipoContrato: TDataSource
    DataSet = TRecluTipoContrato
    Left = 237
    Top = 212
  end
  object TRecluTipoContrato: TsnTable
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
    Left = 203
    Top = 212
    object IntegerField7: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField13: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField14: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object HelpTipoContrato: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoContrato'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 169
    Top = 212
  end
  object HelpSelector: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSelector'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 169
    Top = 180
  end
  object TRecluSelector: TsnTable
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
    Left = 203
    Top = 180
    object IntegerField6: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluSelector: TDataSource
    DataSet = TRecluSelector
    Left = 237
    Top = 180
  end
  object dsTRecluMotiEstBusq: TDataSource
    DataSet = TRecluMotiEstBusq
    Left = 236
    Top = 134
  end
  object TRecluMotiEstBusq: TsnTable
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
    Left = 202
    Top = 133
    object IntegerField10: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField21: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField22: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object HelpMotEstBusq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluMotiEstBusq'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 168
    Top = 133
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
    end
  end
  object TSexoBusqueda: TsnTable
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
    Left = 656
    Top = 380
    object StringField17: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField18: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTSexoBusqueda: TDataSource
    DataSet = TSexoBusqueda
    Left = 688
    Top = 380
  end
  object TEstadosBusqueda: TsnTable
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
    Left = 656
    Top = 339
    object TEstadosBusquedacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEstadosBusquedadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEstadosBusque: TDataSource
    DataSet = TEstadosBusqueda
    Left = 688
    Top = 339
  end
end
