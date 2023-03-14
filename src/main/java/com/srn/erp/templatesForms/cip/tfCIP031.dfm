inherited FConsCacheosPend: TFConsCacheosPend
  Left = 80
  Top = 127
  Width = 832
  Height = 513
  Caption = 'Resultado Cacheos pendientes'
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
      Left = 112
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
    object ImageRefrescar: TImage
      Tag = 7
      Left = 66
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Refrescar cacheos pendientes'
      ParentShowHint = False
      ShowHint = True
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
        object dxDBGridSN1DBTableView1fec_planif_cacheo: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fec_planif_cacheo'
          PropertiesClassName = 'TcxDateEditProperties'
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Width = 60
        end
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          Caption = 'Rota'
          DataBinding.FieldName = 'rota'
          GroupIndex = 1
          HeaderAlignmentHorz = taCenter
          Width = 124
        end
        object dxDBGridSN1DBTableView1ent_o_sal: TcxGridDBColumn
          Caption = 'Entrada / Salida'
          DataBinding.FieldName = 'desc_ent_sal'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'codigo'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 101
        end
        object dxDBGridSN1DBTableView1nro_legajo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'nro_legajo'
          PropertiesClassName = 'TcxButtonEditProperties'
          Properties.Buttons = <
            item
              Default = True
              Kind = bkEllipsis
            end>
          HeaderAlignmentHorz = taCenter
          Width = 85
        end
        object dxDBGridSN1DBTableView1ape_y_nom: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Options.Focusing = False
          Width = 233
        end
        object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
          Caption = 'Controlar por Puertas'
          DataBinding.FieldName = 'desc_grupo_puerta'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          HeaderAlignmentHorz = taCenter
          Width = 122
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
        DataSet = TGrupoPuertas
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
    OnValidate = <
      item
        TableName = 'TCacheos'
        FieldName = 'nro_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TCacheos'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_legajo'#39').AsInteger=0)'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar el Legajo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'fec_planif_cacheo'#39').IsNull)'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar el fecha d' +
            'e Planificaci'#243'n'#39');'
          '  if (DataSet.FieldName('#39'ent_o_sal'#39').AsString='#39#39')'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar la entrada' +
            ' o salida'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TCacheos'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  DriverABM.OperNuevo();'
          '  varios.setImagen('#39'ImageSalir'#39',7);  '
          '  varios.setImagen('#39'ImageRefrescar'#39',0);    '
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          '  TGrupoPuertas.loadFromHelp('#39'HelpGrupoPuertas'#39');'
          '  snTitulo.setCaption(getTitulo());'
          '  cargarEntradasSalidas();'
          '  TraerCacheos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'function getTitulo() : string;'
          'begin'
          '  result := '#39'Cacheos pendientes'#39';'
          'end;'
          ''
          'procedure TraerCacheos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCacheosPendAHoy'#39');'
          '  if (NOT TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '    then operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec' +
            '_hasta'#39').AsString); '
          '  if (TInput.FieldName('#39'oid_legajo'#39').AsInteger>0)'
          
            '    then operacion.AddAtribute('#39'oid_legajo'#39',TInput.FieldName('#39'oi' +
            'd_legajo'#39').AsString); '
          '  if (TInput.FieldName('#39'oid_grupo_puerta'#39').AsInteger>0)'
          
            '    then operacion.AddAtribute('#39'oid_grupo_puerta'#39',TInput.FieldNa' +
            'me('#39'oid_grupo_puerta'#39').AsString); '
          ' operacion.execute();'
          ' dxDBGridSN1.gotoFirstRecord(); '
          'end;'
          ''
          'procedure TraerGrupoPuertasCacheo();'
          'begin'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerGrupoPueCacheo'#39');'
          ' operacion.execute();'
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
          ''
          'procedure Grabar();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SavePlanifCacheo'#39');'
          '  operacion.AddDataSet(TCacheos.getDataSet());  '
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
        ButtonName = 'ImageRefrescar'
        Source.Strings = (
          'begin'
          '  TraerCacheos();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1nro_legajo'
        Source.Strings = (
          'begin'
          '  HelpLegajos.Mostrar();'
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
    Left = 367
    Top = 11
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
    object TInputoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
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
    object TCacheosoid_cacheo: TIntegerField
      FieldName = 'oid_cacheo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCacheosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TCacheosnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TCacheosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TCacheosfec_planif_cacheo: TDateField
      FieldName = 'fec_planif_cacheo'
    end
    object TCacheosent_o_sal: TStringField
      FieldName = 'ent_o_sal'
      Size = 1
    end
    object TCacheosactivo: TBooleanField
      FieldName = 'activo'
    end
    object TCacheosoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TCacheosdesc_ent_sal: TStringField
      FieldKind = fkLookup
      FieldName = 'desc_ent_sal'
      LookupDataSet = TEntSal
      LookupKeyFields = 'codigo'
      LookupResultField = 'descripcion'
      KeyFields = 'ent_o_sal'
      Size = 100
      Lookup = True
    end
    object TCacheosdesc_grupo_puerta: TStringField
      FieldKind = fkLookup
      FieldName = 'desc_grupo_puerta'
      LookupDataSet = TGrupoPuertas
      LookupKeyFields = 'oid'
      LookupResultField = 'descripcion'
      KeyFields = 'oid_grupo_puerta'
      Size = 50
      Lookup = True
    end
    object TCacheosrota: TStringField
      FieldName = 'rota'
      Size = 100
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
  object HelpGrupoPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TCacheosnro_legajo
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
    Titulo = 'Grupo de Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 354
    Top = 351
  end
  object TGrupoPuertas: TsnTable
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
    Left = 392
    Top = 345
    object TGrupoPuertasoid: TIntegerField
      FieldName = 'oid'
    end
    object TGrupoPuertascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoPuertasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSGrupoPuertas: TDataSource
    DataSet = TGrupoPuertas
    Left = 424
    Top = 345
  end
  object DSCacheo: TDataSource
    DataSet = TCacheos
    Left = 328
    Top = 265
  end
end
