inherited FSelVisita: TFSelVisita
  Left = 210
  Top = 204
  Width = 847
  Height = 301
  BorderIcons = []
  Caption = 'Seleccionar Visita'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 831
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 16
      Width = 122
      Height = 16
      Caption = 'Seleccionar la Visita'
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
    Top = 222
    Width = 831
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object SeleccionarBoton: TButton
      Left = 592
      Top = 0
      Width = 129
      Height = 33
      Cursor = crHandPoint
      Caption = 'Seleccionar'
      Default = True
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
    end
    object SeleccionCancelar: TButton
      Left = 432
      Top = 0
      Width = 123
      Height = 33
      Caption = 'Cancelar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      Visible = False
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 41
    Width = 831
    Height = 181
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object FranjaHoraria: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 831
      Height = 181
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
        DataController.DataSource = DSVisitasPorNroDocu
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
        object cxGridDBTableView1cod_tipo_docu: TcxGridDBColumn
          Caption = 'Documento'
          DataBinding.FieldName = 'cod_tipo_docu'
          HeaderAlignmentHorz = taCenter
          Width = 147
        end
        object cxGridDBTableView1nro_documento: TcxGridDBColumn
          Caption = 'N'#250'mero'
          DataBinding.FieldName = 'nro_documento'
          HeaderAlignmentHorz = taCenter
          Width = 98
        end
        object cxGridDBTableView1Column1: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 283
        end
        object cxGridDBTableView1empresa: TcxGridDBColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'empresa'
          HeaderAlignmentHorz = taCenter
          Width = 253
        end
      end
      object cxGridLevel1: TcxGridLevel
        GridView = cxGridDBTableView1
      end
    end
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
      '  MetodoAceptar(false);'
      '  FranjaHoraria.setFoco();'
      'end.')
    OnDblClick = <
      item
        CompoName = 'cxGridDBTableView1'
        Source.Strings = (
          'begin'
          '  Seleccionar();'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'TVisitasPorNroDocu'
      end
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure  MetodoAceptar(Aceptar : boolean);'
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := Aceptar;'
          '  TInput.PostRecord;'
          'end;'
          ''
          'procedure Seleccionar();'
          'begin'
          '  MetodoAceptar(true); '
          '  close();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'SeleccionCancelar'
        Source.Strings = (
          'begin'
          '  MetodoAceptar(false);'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'SeleccionarBoton'
        Source.Strings = (
          'begin'
          '  seleccionar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 552
    Top = 104
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
    Left = 592
    Top = 105
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
  end
  object TVisitasPorNroDocu: TsnTable
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
    Left = 537
    Top = 166
    object TVisitasPorNroDocuoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TVisitasPorNroDocuoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TVisitasPorNroDocucod_tipo_docu: TStringField
      FieldName = 'cod_tipo_docu'
    end
    object TVisitasPorNroDocunro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TVisitasPorNroDocuoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TVisitasPorNroDocuempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TVisitasPorNroDocuoid_visita_a: TIntegerField
      FieldName = 'oid_visita_a'
    end
    object TVisitasPorNroDocuoid_autoriza: TIntegerField
      FieldName = 'oid_autoriza'
    end
    object TVisitasPorNroDocuasignar: TBooleanField
      FieldName = 'asignar'
    end
    object TVisitasPorNroDocuingresar: TBooleanField
      FieldName = 'ingresar'
    end
    object TVisitasPorNroDocudevolvio: TBooleanField
      FieldName = 'devolvio'
    end
    object TVisitasPorNroDocuperdio: TBooleanField
      FieldName = 'perdio'
    end
    object TVisitasPorNroDocuegreso: TBooleanField
      FieldName = 'egreso'
    end
    object TVisitasPorNroDocuape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
  end
  object DSVisitasPorNroDocu: TDataSource
    DataSet = TVisitasPorNroDocu
    Left = 569
    Top = 166
  end
end
