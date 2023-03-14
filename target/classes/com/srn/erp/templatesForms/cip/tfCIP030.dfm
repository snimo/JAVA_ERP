inherited FConsCacheosPendF: TFConsCacheosPendF
  Left = 52
  Top = 87
  Width = 794
  Height = 564
  Caption = 'Consulta de Cacheos Pendientes'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 786
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 82
      Top = 6
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageBuscar: TImage
      Left = 34
      Top = 6
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = '<F12> Traer Cacheos Planificados'
      ParentShowHint = False
      ShowHint = True
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 786
    Height = 489
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object snLabel1: TsnLabel
      Left = 32
      Top = 16
      Width = 140
      Height = 16
      Caption = 'Cacheos hasta la fecha'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel2: TsnLabel
      Left = 32
      Top = 56
      Width = 42
      Height = 16
      Caption = 'Legajo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel3: TsnLabel
      Left = 32
      Top = 96
      Width = 105
      Height = 16
      Caption = 'Grupo de Puertas'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 192
      Top = 12
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 192
      Top = 52
      DataBinding.DataField = 'cod_legajo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Help = HelpLegajos
      Width = 153
    end
    object snDBEdit1: TsnDBEdit
      Left = 342
      Top = 52
      TabStop = False
      DataBinding.DataField = 'ape_y_nom'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 393
    end
    object snDBLookup1: TsnDBLookup
      Left = 192
      Top = 92
      DataBinding.DataField = 'oid_grupo_puerta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSGrupoPuertas
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 241
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
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString; '
          '  ValidadorLegajo.Validar();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);  '
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  TGrupoPuertas.loadFromHelp('#39'HelpGrupoPuertas'#39');'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  variable.newVariantArray('#39'parametros'#39',1);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          ''
          '  FormCacheoPend.params :=  variable.getValue('#39'parametros'#39');'
          '  FormCacheoPend.Ventana := getVentana();'
          '  FormCacheoPend.Mostrar(false);'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  EjecutarConsulta();'
          'end.')
      end>
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
    Left = 152
    Top = 25
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
  object DSInput: TDataSource
    DataSet = TInput
    Left = 184
    Top = 25
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
        AsignarACampo = TInputcod_legajo
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
    Left = 170
    Top = 164
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TInputoid_legajo
    CampoDescripcion = TInputape_y_nom
    NroQuery = 0
    Cache = False
    Left = 208
    Top = 163
  end
  object HelpGrupoPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    NroHelp = 102
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
        AsignarACampo = TInputcod_legajo
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
    Left = 170
    Top = 197
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
    Left = 208
    Top = 196
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
    Left = 241
    Top = 196
  end
  object FormCacheoPend: TFormulario
    Nombre = 'TFConsCacheosPend'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
end
