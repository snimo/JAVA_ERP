inherited FConsCacheosRea: TFConsCacheosRea
  Left = 78
  Top = 69
  Width = 832
  Height = 513
  Caption = 'Resultado Cacheos realizados'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 824
    Height = 41
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
    object snTitulo: TsnLabel
      Left = 72
      Top = 13
      Width = 47
      Height = 16
      Caption = 'snTitulo'
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
    Top = 41
    Width = 824
    Height = 438
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 814
      Height = 428
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        NavigatorButtons.PriorPage.Visible = False
        NavigatorButtons.Prior.Visible = False
        NavigatorButtons.Next.Visible = False
        NavigatorButtons.NextPage.Visible = False
        NavigatorButtons.Insert.Visible = True
        NavigatorButtons.Append.Visible = False
        NavigatorButtons.Delete.Visible = False
        NavigatorButtons.Edit.Visible = False
        NavigatorButtons.Post.Visible = False
        NavigatorButtons.Cancel.Visible = False
        NavigatorButtons.Refresh.Visible = False
        NavigatorButtons.SaveBookmark.Visible = False
        NavigatorButtons.GotoBookmark.Visible = False
        NavigatorButtons.Filter.Visible = False
        DataController.DataSource = DSCacheo
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoInsertOnNewItemRowFocusing]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.Deleting = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.InvertSelect = False
        OptionsView.Navigator = True
        OptionsView.CellAutoHeight = True
        object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Width = 66
        end
        object dxDBGridSN1DBTableView1hora: TcxGridDBColumn
          Caption = 'Hora'
          DataBinding.FieldName = 'hora'
          HeaderAlignmentHorz = taCenter
          Width = 56
        end
        object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
          Caption = 'Resultado'
          DataBinding.FieldName = 'desc_resultado'
          HeaderAlignmentHorz = taCenter
          Width = 63
        end
        object dxDBGridSN1DBTableView1cod_legajo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'cod_legajo'
          HeaderAlignmentHorz = taCenter
          Width = 83
        end
        object dxDBGridSN1DBTableView1desc_legajo: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'desc_legajo'
          HeaderAlignmentHorz = taCenter
          Width = 181
        end
        object dxDBGridSN1DBTableView1observacion: TcxGridDBColumn
          Caption = 'Observaci'#243'n'
          DataBinding.FieldName = 'observacion'
          HeaderAlignmentHorz = taCenter
          Width = 308
        end
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          Caption = 'Personal de Seguridad'
          DataBinding.FieldName = 'desc_pers_segu'
          HeaderAlignmentHorz = taCenter
          Width = 124
        end
        object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
          Caption = 'Activo'
          DataBinding.FieldName = 'activo'
          Visible = False
          HeaderAlignmentHorz = taCenter
          Width = 50
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
        DataSet = TCacheos
        TableName = 'TCacheos'
      end
      item
        DataSet = TPersonalSeguridad
        TableName = 'TGrupoPuertasCacheo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar]
    Left = 208
    Top = 8
  end
  inherited Operacion: TOperacion
    Left = 240
    Top = 8
  end
  inherited TOidObjSave: TsnTable
    Left = 704
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 272
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
    Left = 304
    Top = 8
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  DriverABM.OperNuevo();'
          '  varios.setImagen('#39'ImageSalir'#39',7);  '
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          '  snTitulo.setCaption(getTitulo());'
          '  cargarEntradasSalidas();'
          '  TPersonalSeguridad.loadFromHelp('#39'HelpPersonalSeguridad'#39');'
          '  TResultadoCacheo.loadFromHelp('#39'HelpResultadoCacheo'#39');'
          '  TraerCacheos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'function getTitulo() : string;'
          'begin'
          '  result := '#39'Cacheos realizados'#39';'
          'end;'
          ''
          'procedure TraerCacheos();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCacheosRealizados'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'desde'#39');'
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'hasta'#39');'
          ''
          
            '  operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39 +
            ').AsString); '
          
            '  operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39 +
            ').AsString); '
          ''
          '  if (TInput.FieldName('#39'oid_legajo'#39').AsInteger>0)'
          
            '    then operacion.AddAtribute('#39'oid_legajo'#39',TInput.FieldName('#39'oi' +
            'd_legajo'#39').AsString); '
          ''
          '  if (TInput.FieldName('#39'oid_pers_segu'#39').AsInteger>0)'
          
            '    then operacion.AddAtribute('#39'oid_pers_segu'#39',TInput.FieldName(' +
            #39'oid_pers_segu'#39').AsString); '
          ''
          ' operacion.execute();'
          ''
          ' dxDBGridSN1.gotoFirstRecord(); '
          ''
          'end;'
          ''
          'procedure cargarEntradasSalidas();'
          'begin'
          '  TEntSal.Close;'
          '  TEntSal.Open;'
          ''
          '  TEntSal.AppendRecord;'
          '  TEntSal.FieldName('#39'codigo'#39').AsString := '#39'E'#39';'
          '  TEntSal.FieldName('#39'descripcion'#39').AsString := '#39'Entrada'#39';'
          '  TEntSal.PostRecord;'
          ''
          '  TEntSal.AppendRecord;'
          '  TEntSal.FieldName('#39'codigo'#39').AsString := '#39'S'#39';'
          '  TEntSal.FieldName('#39'descripcion'#39').AsString := '#39'Salida'#39';'
          '  TEntSal.PostRecord;'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 336
    Top = 11
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 376
    Top = 9
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
    Left = 480
    Top = 129
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TInputcod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TInputape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 50
    end
    object TInputoid_pers_segu: TIntegerField
      FieldName = 'oid_pers_segu'
    end
  end
  object TCacheos: TsnTable
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
    Left = 296
    Top = 265
    object TCacheosoid_cacheo_pers: TIntegerField
      FieldName = 'oid_cacheo_pers'
    end
    object TCacheosoid_pers_segu: TIntegerField
      FieldName = 'oid_pers_segu'
    end
    object TCacheosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TCacheoscod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TCacheosdesc_legajo: TStringField
      FieldName = 'desc_legajo'
      Size = 100
    end
    object TCacheosfecha: TDateField
      FieldName = 'fecha'
    end
    object TCacheoshora: TStringField
      FieldName = 'hora'
      Size = 5
    end
    object TCacheosobservacion: TStringField
      FieldName = 'observacion'
      Size = 255
    end
    object TCacheosactivo: TBooleanField
      FieldName = 'activo'
    end
    object TCacheosdesc_pers_segu: TStringField
      FieldKind = fkLookup
      FieldName = 'desc_pers_segu'
      LookupDataSet = TPersonalSeguridad
      LookupKeyFields = 'oid'
      LookupResultField = 'descripcion'
      KeyFields = 'oid_pers_segu'
      Size = 100
      Lookup = True
    end
    object TCacheosoid_res_cacheo: TIntegerField
      FieldName = 'oid_res_cacheo'
    end
    object TCacheosdesc_resultado: TStringField
      FieldKind = fkLookup
      FieldName = 'desc_resultado'
      LookupDataSet = TResultadoCacheo
      LookupKeyFields = 'oid'
      LookupResultField = 'codigo'
      KeyFields = 'oid_res_cacheo'
      Size = 100
      Lookup = True
    end
  end
  object TEntSal: TsnTable
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
    Left = 104
    Top = 209
    object TEntSalcodigo: TStringField
      FieldName = 'codigo'
      Size = 10
    end
    object TEntSaldescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEntSal: TDataSource
    DataSet = TEntSal
    Left = 144
    Top = 209
  end
  object HelpPersonalSeguridad: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PersonalSeguridad'
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
    Titulo = 'Personal de Seguridad'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 354
    Top = 351
  end
  object TPersonalSeguridad: TsnTable
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
    Left = 384
    Top = 353
    object TPersonalSeguridadoid: TIntegerField
      FieldName = 'oid'
    end
    object TPersonalSeguridadcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPersonalSeguridaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCacheo: TDataSource
    DataSet = TCacheos
    Left = 328
    Top = 265
  end
  object HelpResultadoCacheo: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.ResultadoCacheo'
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
    Titulo = 'Resultados Cacheo'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 354
    Top = 392
  end
  object TResultadoCacheo: TsnTable
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
    Left = 384
    Top = 394
    object IntegerField1: TIntegerField
      FieldName = 'oid'
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
end
