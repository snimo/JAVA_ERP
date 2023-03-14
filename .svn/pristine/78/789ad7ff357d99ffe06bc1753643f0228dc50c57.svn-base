inherited FTarjConciAuto: TFTarjConciAuto
  Left = 299
  Top = 174
  Width = 381
  Height = 316
  BorderIcons = []
  Caption = 'Conciliar'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 373
    Height = 32
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 13
      Top = 12
      Width = 220
      Height = 16
      Caption = 'Conciliar las Tarjetas Seleccionadas'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 241
    Width = 373
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object BotonConciliar: TsnButton
      Left = 256
      Top = 8
      Width = 99
      Height = 25
      Caption = '&Conciliar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonSalir: TsnButton
      Left = 16
      Top = 8
      Width = 121
      Height = 25
      Caption = 'Salir sin conciliar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 32
    Width = 373
    Height = 209
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 363
      Height = 199
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTarjetas
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsCustomize.ColumnFiltering = False
        OptionsCustomize.ColumnSorting = False
        OptionsData.Deleting = False
        OptionsData.Inserting = False
        OptionsView.GroupByBox = False
        object dxDBGridSN1DBTableView1sel: TcxGridDBColumn
          Caption = 'Conciliar'
          DataBinding.FieldName = 'sel'
          Width = 49
        end
        object dxDBGridSN1DBTableView1descripcion: TcxGridDBColumn
          Caption = 'Tarjeta'
          DataBinding.FieldName = 'descripcion'
          HeaderAlignmentHorz = taCenter
          HeaderGlyphAlignmentHorz = taCenter
          Options.Editing = False
          Width = 288
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TTarjetas
        TableName = 'TTarjetas'
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
  inherited SaveDialog: TSaveDialog
    Left = 184
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  '
      '   operacion.InicioOperacion();'
      '   operacion.setOper('#39'TraerTarjConciAuto'#39');'
      ' operacion.execute();'
      ''
      '  TInput.Close;'
      '  TInput.Open;'
      '  TInput.AppendRecord;'
      ''
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'TTarjetas'
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := False;'
          '  TInput.PostRecord;'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonConciliar'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := True;'
          '  TInput.PostRecord;'
          '  close;'
          'end.')
      end>
    Left = 248
    Top = 27
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Top = 152
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TTarjetas: TsnTable
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
    Left = 32
    Top = 73
    object TTarjetassel: TBooleanField
      FieldName = 'sel'
    end
    object TTarjetasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TTarjetascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
  end
  object DSTarjetas: TDataSource
    DataSet = TTarjetas
    Left = 64
    Top = 73
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
    Left = 136
    Top = 56
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
  end
end
