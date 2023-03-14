inherited FBuscarEmpCIP: TFBuscarEmpCIP
  Left = 168
  Top = 196
  Width = 455
  BorderIcons = []
  Caption = 'Empresas que coinciden con la Raz'#243'n Social ingresada'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 439
    Height = 75
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object snLabel1: TsnLabel
      Left = 16
      Top = 16
      Width = 301
      Height = 16
      Caption = 'Empresas que coinciden con el nombre ingresado'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBEdit1: TsnDBEdit
      Left = 16
      Top = 40
      DataBinding.DataField = 'empresa'
      DataBinding.DataSource = DSinput
      ParentFont = False
      Properties.CharCase = ecUpperCase
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 409
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 436
    Width = 439
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object BotonSeleccionar: TsnButton
      Left = 32
      Top = 0
      Width = 97
      Height = 33
      Caption = 'Seleccionar'
      Default = True
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonDejar: TsnButton
      Left = 208
      Top = 0
      Width = 201
      Height = 33
      Caption = 'Dejar el Nombre Ingresado'
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
    Top = 75
    Width = 439
    Height = 361
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object FranjaHoraria: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 439
      Height = 361
      Align = alClient
      BorderWidth = 5
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'baja'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'true'
          TipoCondFiltro2 = tcfIgual
          Color = clRed
        end>
      object cxGridDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsCustomize.ColumnFiltering = False
        OptionsCustomize.ColumnSorting = False
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
      end
      object cxGridLevel1: TcxGridLevel
        GridView = cxGridDBTableView1
      end
    end
    object dxDBGridSN1: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 439
      Height = 361
      Align = alClient
      BorderWidth = 5
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'baja'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'true'
          TipoCondFiltro2 = tcfIgual
          Color = clRed
        end>
      object cxGridDBTableView2: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSEmpresaLike
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsCustomize.ColumnFiltering = False
        OptionsCustomize.ColumnSorting = False
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.InvertSelect = False
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
        object cxGridDBTableView2empresa: TcxGridDBColumn
          Caption = 'Empresas'
          DataBinding.FieldName = 'empresa'
          Width = 404
        end
      end
      object cxGridLevel2: TcxGridLevel
        GridView = cxGridDBTableView2
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TEmpresasLike
        TableName = 'TEmpresasLike'
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
    OnShow.Strings = (
      'begin'
      ' TInput.Close;'
      ' TInput.Open;'
      ' TInput.AppendRecord;  '
      
        ' TInput.FieldName('#39'empresa'#39').AsString := variable.getString('#39'emp' +
        'resa'#39'); '
      ' dxDBGridSN1.setFoco(); '
      'end.')
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'empresa'
        Source.Strings = (
          'begin'
          '  TraerLikeEmpresas(Sender.AsString);'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'empresa'
      end
      item
        VariableName = 'TResultado'
      end
      item
        VariableName = 'TEmpresasLike'
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerLikeEmpresas(Empresa : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConciEmpCIP'#39');'
          '  operacion.AddAtribute('#39'empresa'#39',Empresa);'
          '  operacion.execute();'
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSeleccionar'
        Source.Strings = (
          'begin'
          '  TResultado.Close;'
          '  TResultado.Open;'
          '  TResultado.AppendRecord; '
          '  TResultado.FieldName('#39'valor'#39').AsString := '#39'SELECCIONAR'#39';'
          '  TResultado.PostRecord;'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonDejar'
        Source.Strings = (
          'begin'
          '  TResultado.Close;'
          '  TResultado.Open;'
          '  TResultado.AppendRecord; '
          '  TResultado.FieldName('#39'valor'#39').AsString := '#39'DEJAR'#39';'
          '  TResultado.PostRecord;'
          '  close;'
          'end.'
          '')
      end>
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
    Left = 176
    Top = 171
    object TInputempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
  end
  object DSinput: TDataSource
    DataSet = TInput
    Left = 216
    Top = 171
  end
  object TEmpresasLike: TsnTable
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
    Left = 177
    Top = 209
    object TEmpresasLikeoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TEmpresasLikeempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
  end
  object DSEmpresaLike: TDataSource
    DataSet = TEmpresasLike
    Left = 216
    Top = 211
  end
  object TResultado: TsnTable
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
    Left = 176
    Top = 251
    object TResultadovalor: TStringField
      FieldName = 'valor'
      Size = 50
    end
  end
end
