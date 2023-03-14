inherited FConsVisEnPredio: TFConsVisEnPredio
  Left = 0
  Top = 0
  Width = 1024
  Height = 724
  Caption = 'Consulta de Visitas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1008
    Height = 67
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel1: TsnLabel
      Left = 17
      Top = 44
      Width = 155
      Height = 20
      Caption = 'Visitas en el Predio'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object BotonRefrescar: TsnButton
      Left = 68
      Top = 7
      Width = 145
      Height = 31
      Cursor = crHandPoint
      Caption = '&Refrescar Consulta'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 67
    Width = 1008
    Height = 619
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 1
    object dxMovimientos: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 998
      Height = 609
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxMovimientosDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object dxMovimientosDBTableView1codigo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'codigo'
          PropertiesClassName = 'TcxButtonEditProperties'
          Properties.Buttons = <
            item
              Default = True
              Kind = bkEllipsis
            end>
          HeaderAlignmentHorz = taCenter
          Width = 217
        end
        object dxMovimientosDBTableView1nombre: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'nombre'
          HeaderAlignmentHorz = taCenter
          Options.Focusing = False
          Width = 531
        end
      end
      object dxMovimientosDBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Deleting = False
        OptionsData.Inserting = False
        OptionsView.GroupByBox = False
        Bands = <
          item
          end>
        object dxMovimientosDBBandedTableView1legajo: TcxGridDBBandedColumn
          DataBinding.FieldName = 'legajo'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1ape_y_nom: TcxGridDBBandedColumn
          DataBinding.FieldName = 'ape_y_nom'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1puerta: TcxGridDBBandedColumn
          DataBinding.FieldName = 'puerta'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1fecha: TcxGridDBBandedColumn
          DataBinding.FieldName = 'fecha'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1hora: TcxGridDBBandedColumn
          DataBinding.FieldName = 'hora'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1sentido: TcxGridDBBandedColumn
          DataBinding.FieldName = 'sentido'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
      end
      object dxMovimientosDBTableView2: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSVistaEnPredio
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.IncSearch = True
        OptionsData.Deleting = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        object dxMovimientosDBTableView2nro_documento: TcxGridDBColumn
          Caption = 'Nro. Documento'
          DataBinding.FieldName = 'nro_documento'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 93
        end
        object dxMovimientosDBTableView2ape_y_nom: TcxGridDBColumn
          Caption = 'Ape. y Nombre.'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 154
        end
        object dxMovimientosDBTableView2empresa: TcxGridDBColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'empresa'
          HeaderAlignmentHorz = taCenter
          Width = 107
        end
        object dxMovimientosDBTableView2nro_tarjeta: TcxGridDBColumn
          Caption = 'Tarjeta'
          DataBinding.FieldName = 'nro_tarjeta'
          HeaderAlignmentHorz = taCenter
          Width = 116
        end
        object dxMovimientosDBTableView2grupo: TcxGridDBColumn
          Caption = 'Grupo Visita'
          DataBinding.FieldName = 'grupo'
          HeaderAlignmentHorz = taCenter
          Width = 97
        end
        object dxMovimientosDBTableView2motivo: TcxGridDBColumn
          Caption = 'Motivo Visita'
          DataBinding.FieldName = 'motivo'
          HeaderAlignmentHorz = taCenter
          Width = 89
        end
        object dxMovimientosDBTableView2zona: TcxGridDBColumn
          Caption = 'Zona Actual'
          DataBinding.FieldName = 'zona'
          HeaderAlignmentHorz = taCenter
          Width = 88
        end
        object dxMovimientosDBTableView2categ_acc_int: TcxGridDBColumn
          Caption = 'Acceso a'
          DataBinding.FieldName = 'categ_acc_int'
          Visible = False
          GroupIndex = 0
          Width = 94
        end
        object dxMovimientosDBTableView2ult_mov: TcxGridDBColumn
          Caption = 'Ingres'#243
          DataBinding.FieldName = 'ult_mov'
          HeaderAlignmentHorz = taCenter
          Width = 146
        end
        object dxMovimientosDBTableView2tiempo_perm: TcxGridDBColumn
          Caption = 'Tiempo Permanencia'
          DataBinding.FieldName = 'tiempo_perm'
          HeaderAlignmentHorz = taCenter
          Width = 121
        end
      end
      object dxMovimientosLevel1: TcxGridLevel
        GridView = dxMovimientosDBTableView2
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TVisitasEnPredio
        TableName = 'TVisitasEnPredio'
      end>
    Left = 368
    Top = 32
  end
  inherited Operacion: TOperacion
    Left = 408
    Top = 32
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 448
    Top = 32
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 488
    Top = 32
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  TraerVisitasEnPredio();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerVisitasEnPredio();'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerVisitasEnPredio'#39');'
          '  operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonRefrescar'
        Source.Strings = (
          'begin'
          '  TraerVisitasEnPredio();'
          'end.')
      end>
    Left = 528
    Top = 35
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
  object TVisitasEnPredio: TsnTable
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
    Top = 265
    object TVisitasEnPrediooid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TVisitasEnPredionro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TVisitasEnPredioape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TVisitasEnPredioempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TVisitasEnPredionro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
      Size = 100
    end
    object TVisitasEnPrediogrupo: TStringField
      FieldName = 'grupo'
      Size = 100
    end
    object TVisitasEnPrediomotivo: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object TVisitasEnPrediozona: TStringField
      FieldName = 'zona'
      Size = 100
    end
    object TVisitasEnPrediocateg_acc_int: TStringField
      FieldName = 'categ_acc_int'
      Size = 100
    end
    object TVisitasEnPredioult_mov: TStringField
      FieldName = 'ult_mov'
      Size = 100
    end
    object TVisitasEnPrediotiempo_perm: TStringField
      FieldName = 'tiempo_perm'
      Size = 100
    end
  end
  object DSVistaEnPredio: TDataSource
    DataSet = TVisitasEnPredio
    Left = 272
    Top = 265
  end
end
