inherited FUltNrosActasyRev: TFUltNrosActasyRev
  Left = 131
  Top = 202
  Width = 782
  Height = 471
  BorderIcons = [biSystemMenu]
  Caption = 'Ultimos Nros de Actas y Revocaciones'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 774
    Height = 47
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Left = 23
      Top = 11
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
    Top = 47
    Width = 774
    Height = 390
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object Panel3: TPanel
      Left = 1
      Top = 1
      Width = 772
      Height = 41
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object Label1: TLabel
        Left = 8
        Top = 16
        Width = 213
        Height = 20
        Caption = 'Ultimos N'#250'meros de Actas'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object Label2: TLabel
        Left = 392
        Top = 16
        Width = 311
        Height = 20
        Caption = 'Ultimos N'#250'meros de Actas Levantadas'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentFont = False
      end
    end
    object Panel4: TPanel
      Left = 1
      Top = 42
      Width = 772
      Height = 347
      Align = alClient
      Color = clWindow
      TabOrder = 1
      object dxDBGridSN1: TdxDBGridSN
        Left = 8
        Top = 0
        Width = 361
        Height = 329
        TabOrder = 0
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSUltNroActa
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsCustomize.ColumnFiltering = False
          OptionsData.CancelOnExit = False
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Editing = False
          OptionsData.Inserting = False
          OptionsView.GroupByBox = False
          Styles.ContentOdd = cxStyle1
          object dxDBGridSN1DBTableView1descripcion: TcxGridDBColumn
            Caption = 'Estado'
            DataBinding.FieldName = 'descripcion'
            HeaderAlignmentHorz = taCenter
            Styles.Content = cxStyle2
            Width = 226
          end
          object dxDBGridSN1DBTableView1ult_nro: TcxGridDBColumn
            Caption = 'Ult. Nro. Acta'
            DataBinding.FieldName = 'ult_nro'
            HeaderAlignmentHorz = taCenter
            Styles.Content = cxStyle2
            Width = 100
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
      object dxDBGridSN2: TdxDBGridSN
        Left = 392
        Top = 0
        Width = 361
        Height = 329
        TabOrder = 1
        CriteriosPintarCelda = <>
        object cxGridDBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSTUltNroActaRev
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsCustomize.ColumnFiltering = False
          OptionsData.CancelOnExit = False
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Editing = False
          OptionsData.Inserting = False
          OptionsView.GroupByBox = False
          Styles.ContentOdd = cxStyle1
          object cxGridDBColumn1: TcxGridDBColumn
            Caption = 'Estado'
            DataBinding.FieldName = 'descripcion'
            HeaderAlignmentHorz = taCenter
            Styles.Content = cxStyle2
            Width = 226
          end
          object cxGridDBColumn2: TcxGridDBColumn
            Caption = 'Ult. Nro. Acta'
            DataBinding.FieldName = 'ult_nro'
            HeaderAlignmentHorz = taCenter
            Styles.Content = cxStyle2
            Width = 100
          end
        end
        object cxGridLevel1: TcxGridLevel
          GridView = cxGridDBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TUltNroActa
        TableName = 'TUltNroActa'
      end
      item
        DataSet = TUltNroActaRev
        TableName = 'TUltNroActaRev'
      end>
    Left = 224
    Top = 128
  end
  inherited Operacion: TOperacion
    Top = 128
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 280
    Top = 8
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 320
    Top = 8
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Varios.setImagen('#39'ImageSalir'#39',7);'
          '  Inicializar();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '   operacion.inicioOperacion();'
          '   operacion.setOper('#39'TraerUltNroActaEstados'#39');'
          '   operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 360
    Top = 11
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 128
    Top = 139
  end
  object TUltNroActa: TsnTable
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
    Top = 137
    object TUltNroActaoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TUltNroActadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TUltNroActault_nro: TIntegerField
      FieldName = 'ult_nro'
    end
  end
  object DSUltNroActa: TDataSource
    DataSet = TUltNroActa
    Left = 88
    Top = 137
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svColor]
      Color = clInfoBk
    end
    object cxStyle2: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
    end
  end
  object TUltNroActaRev: TsnTable
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
    Top = 169
    object IntegerField1: TIntegerField
      FieldName = 'oid_estado'
    end
    object StringField1: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object IntegerField2: TIntegerField
      FieldName = 'ult_nro'
    end
  end
  object DSTUltNroActaRev: TDataSource
    DataSet = TUltNroActaRev
    Left = 88
    Top = 169
  end
end
