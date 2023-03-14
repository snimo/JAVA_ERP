inherited FResPlanifCacheo: TFResPlanifCacheo
  Left = 82
  Top = 141
  Width = 832
  Height = 513
  Caption = 'Resultado de Planificaci'#243'n de Cacheos'
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
    object BotonGrabar: TsnButton
      Left = 503
      Top = 10
      Width = 186
      Height = 25
      Caption = 'Grabar Planificaci'#243'n de Cacheos'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
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
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsSelection.InvertSelect = False
        OptionsView.Navigator = True
        object dxDBGridSN1DBTableView1fec_planif_cacheo: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fec_planif_cacheo'
          PropertiesClassName = 'TcxDateEditProperties'
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Width = 76
        end
        object dxDBGridSN1DBTableView1ent_o_sal: TcxGridDBColumn
          Caption = 'Entrada / Salida'
          DataBinding.FieldName = 'ent_o_sal'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'codigo'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSEntSal
          HeaderAlignmentHorz = taCenter
          Width = 96
        end
        object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
          Caption = 'Controlar por Puertas'
          DataBinding.FieldName = 'oid_grupo_puerta'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid_grupo_puerta'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSGrupoPuertas
          HeaderAlignmentHorz = taCenter
          Width = 138
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
          Width = 79
        end
        object dxDBGridSN1DBTableView1ape_y_nom: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Options.Focusing = False
          Width = 166
        end
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          Caption = 'Cacheo realizado el'
          DataBinding.FieldName = 'estado'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Options.Focusing = False
          Width = 127
        end
        object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
          Caption = 'Activo'
          DataBinding.FieldName = 'activo'
          PropertiesClassName = 'TcxCheckBoxProperties'
          HeaderAlignmentHorz = taCenter
          Width = 48
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
        DataSet = TGrupoPuertasCacheo
        TableName = 'TGrupoPuertasCacheo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar]
    Left = 176
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 216
    Top = 16
  end
  inherited TOidObjSave: TsnTable
    Left = 704
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 256
    Top = 16
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 296
    Top = 16
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
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          '  snTitulo.setCaption(getTitulo());'
          '  cargarEntradasSalidas();'
          '  TraerCacheos();'
          '  TraerGrupoPuertasCacheo();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'function getTitulo() : string;'
          'begin'
          
            '  result := '#39'Planificaci'#243'n de cacheo del '#39'+TInput.FieldName('#39'fec' +
            '_desde'#39').AsString+'#39' al '#39'+TInput.FieldName('#39'fec_hasta'#39').AsString;'
          'end;'
          ''
          'procedure TraerCacheos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCacheosPlanif'#39');'
          
            ' operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39')' +
            '.AsString); '
          
            ' operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39')' +
            '.AsString); '
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
        ButtonName = 'BotonGrabar'
        Source.Strings = (
          'begin'
          '  Grabar();'
          '  mensaje.information('#39'Se grabaron los cambios con EXITO'#39');'
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
    Top = 19
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 376
    Top = 17
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
    object TCacheosestado: TStringField
      FieldName = 'estado'
      Size = 100
    end
    object TCacheosread_only: TBooleanField
      FieldName = 'read_only'
    end
    object TCacheosoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
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
  object HelpLegajos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
    Titulo = 'Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 138
    Top = 124
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TCacheosoid_legajo
    CampoDescripcion = TCacheosape_y_nom
    NroQuery = 0
    Cache = False
    Left = 176
    Top = 123
  end
  object DSCacheo: TsnDataSource
    DataSet = TCacheos
    ActivarROAfterScroll = True
    Left = 328
    Top = 265
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
    Left = 138
    Top = 167
  end
  object TGrupoPuertasCacheo: TsnTable
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
    object TGrupoPuertasCacheooid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TGrupoPuertasCacheocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoPuertasCacheodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSGrupoPuertas: TDataSource
    DataSet = TGrupoPuertasCacheo
    Left = 432
    Top = 345
  end
end
