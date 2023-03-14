inherited FComposiCalif: TFComposiCalif
  Left = 151
  Top = 131
  Width = 890
  Height = 626
  Caption = 'Composici'#243'n Calificaci'#243'n'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 874
    Height = 83
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 14
      Top = 18
      Width = 45
      Height = 16
      Caption = 'Legajo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 14
      Top = 55
      Width = 78
      Height = 16
      Caption = 'Cronograma:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 438
      Top = 55
      Width = 27
      Height = 16
      Caption = 'A'#241'o:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 550
      Top = 55
      Width = 29
      Height = 16
      Caption = 'Mes:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 732
      Top = 10
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBEdit1: TsnDBEdit
      Left = 104
      Top = 16
      DataBinding.DataField = 'nro_legajo'
      DataBinding.DataSource = DSTCabCalif
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 121
    end
    object snDBEdit2: TsnDBEdit
      Left = 223
      Top = 16
      DataBinding.DataField = 'ape_y_nom'
      DataBinding.DataSource = DSTCabCalif
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 498
    end
    object snDBEdit3: TsnDBEdit
      Left = 104
      Top = 51
      DataBinding.DataField = 'desc_cronograma'
      DataBinding.DataSource = DSTCabCalif
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 329
    end
    object snDBEdit4: TsnDBEdit
      Left = 466
      Top = 51
      DataBinding.DataField = 'anio'
      DataBinding.DataSource = DSTCabCalif
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 79
    end
    object snDBEdit5: TsnDBEdit
      Left = 581
      Top = 51
      DataBinding.DataField = 'desc_mes'
      DataBinding.DataSource = DSTCabCalif
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 188
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 83
    Width = 874
    Height = 499
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 864
      Height = 489
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTDetCalif
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <
          item
            Format = '###,###,###,##0.00'
            Kind = skSum
            Position = spFooter
            Column = dxDBGridSN1DBTableView1tot_punt_pond
          end
          item
            Format = '###,###,###,##0.00'
            Column = dxDBGridSN1DBTableView1tot_punt_pond
          end>
        DataController.Summary.FooterSummaryItems = <
          item
            Format = '###,###,###,##0.00'
            Kind = skSum
            Column = dxDBGridSN1DBTableView1tot_punt_pond
          end>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.Footer = True
        OptionsView.GroupByBox = False
        OptionsView.GroupFooters = gfAlwaysVisible
        object dxDBGridSN1DBTableView1agrupador: TcxGridDBColumn
          Caption = 'Agrupador'
          DataBinding.FieldName = 'agrupador'
          Visible = False
          GroupIndex = 0
          SortIndex = 1
          SortOrder = soDescending
        end
        object dxDBGridSN1DBTableView1orden: TcxGridDBColumn
          Caption = 'Orden'
          DataBinding.FieldName = 'orden'
          Visible = False
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 28
        end
        object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
          HeaderAlignmentHorz = taCenter
          Width = 80
        end
        object dxDBGridSN1DBTableView1motivo: TcxGridDBColumn
          Caption = 'Motivo'
          DataBinding.FieldName = 'motivo'
          HeaderAlignmentHorz = taCenter
          Width = 389
        end
        object dxDBGridSN1DBTableView1puntaje: TcxGridDBColumn
          Caption = 'Puntaje'
          DataBinding.FieldName = 'puntaje'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
        end
        object dxDBGridSN1DBTableView1cantidad: TcxGridDBColumn
          Caption = 'Cantidad'
          DataBinding.FieldName = 'cantidad'
          HeaderAlignmentHorz = taCenter
        end
        object dxDBGridSN1DBTableView1ponderacion: TcxGridDBColumn
          Caption = 'Ponderaci'#243'n'
          DataBinding.FieldName = 'ponderacion'
          HeaderAlignmentHorz = taCenter
          Width = 74
        end
        object dxDBGridSN1DBTableView1tot_punt_pond: TcxGridDBColumn
          Caption = 'Tot. Punt. Pond.'
          DataBinding.FieldName = 'tot_punt_pond'
          HeaderAlignmentHorz = taCenter
          Width = 91
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 582
    Width = 874
    Height = 6
    Align = alBottom
    Color = clWindow
    TabOrder = 2
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TCabCalif
        TableName = 'TCabCalif'
      end
      item
        DataSet = TDetCalif
        TableName = 'TDetCalif'
      end>
    Left = 192
    Top = 40
  end
  inherited Operacion: TOperacion
    Left = 232
    Top = 40
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 272
    Top = 40
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 312
    Top = 40
  end
  inherited DriverEvent: TDriverEvent
    OnPublicVariable = <
      item
        VariableName = 'TFiltros'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  TFiltros.loadFromAllData(getParamValue('#39'TFiltros'#39'));  '
          '  EjecutarConsulta();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure EjecutarConsulta();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerComposiCalif'#39');'
          '  operacion.AddDataSet(TFiltros.getDataSet());'
          '  operacion.execute;'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  Close();'
          'end.')
      end>
    Left = 352
    Top = 43
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 672
    Top = 76
  end
  object TCabCalif: TsnTable
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
    Left = 152
    Top = 193
    object TCabCalifoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TCabCalifnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TCabCalifape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TCabCalifoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TCabCalifdesc_cronograma: TStringField
      FieldName = 'desc_cronograma'
      Size = 100
    end
    object TCabCalifanio: TIntegerField
      FieldName = 'anio'
    end
    object TCabCalifmes: TStringField
      FieldName = 'mes'
      Size = 100
    end
    object TCabCalifdesc_mes: TStringField
      FieldName = 'desc_mes'
      Size = 50
    end
  end
  object DSTCabCalif: TDataSource
    DataSet = TCabCalif
    Left = 184
    Top = 193
  end
  object TDetCalif: TsnTable
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
    Left = 152
    Top = 241
    object TDetCalifagrupador: TStringField
      FieldName = 'agrupador'
      Size = 100
    end
    object TDetCaliffecha: TDateField
      FieldName = 'fecha'
    end
    object TDetCalifmotivo: TStringField
      DisplayWidth = 500
      FieldName = 'motivo'
      Size = 500
    end
    object TDetCalifpuntaje: TCurrencyField
      FieldName = 'puntaje'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetCalifponderacion: TCurrencyField
      FieldName = 'ponderacion'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetCaliftot_punt_pond: TCurrencyField
      FieldName = 'tot_punt_pond'
      DisplayFormat = '###,###,###,##0.00'
    end
    object TDetCaliforden: TIntegerField
      FieldName = 'orden'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDetCalifcantidad: TCurrencyField
      FieldName = 'cantidad'
      DisplayFormat = '###,###,###,###.##'
    end
  end
  object DSTDetCalif: TDataSource
    DataSet = TDetCalif
    Left = 184
    Top = 241
  end
  object TFiltros: TsnTable
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
    Top = 121
    object TFiltrosoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TFiltrosdesc_cronograma: TStringField
      FieldName = 'desc_cronograma'
      Size = 100
    end
    object TFiltrosmes: TStringField
      FieldName = 'mes'
      Size = 100
    end
    object TFiltrosacciones: TStringField
      FieldName = 'acciones'
      Size = 4000
    end
    object TFiltrosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TFiltrosoid_accion: TIntegerField
      FieldName = 'oid_accion'
    end
    object TFiltroscodigo_mes: TStringField
      FieldName = 'codigo_mes'
      Size = 10
    end
    object TFiltrosanio: TIntegerField
      FieldName = 'anio'
    end
    object TFiltrosdesc_mes: TStringField
      FieldName = 'desc_mes'
      Size = 50
    end
  end
  object DSFiltros: TDataSource
    DataSet = TFiltros
    Left = 104
    Top = 121
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
    end
    object cxStyle2: TcxStyle
      AssignedValues = [svFont, svTextColor]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      TextColor = 10485760
    end
  end
end
