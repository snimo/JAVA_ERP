inherited FPreFormPasesNoValidos: TFPreFormPasesNoValidos
  Left = 49
  Top = 116
  Width = 894
  Height = 613
  Caption = 'Pases No V'#225'lidos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 878
    Height = 95
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageBuscar: TImage
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = '<F12> Buscar Comprobantes'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 66
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label1: TLabel
      Left = 16
      Top = 77
      Width = 119
      Height = 16
      Caption = 'Legajos a Consultar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Visible = False
    end
    object Label2: TLabel
      Left = 48
      Top = 56
      Width = 80
      Height = 16
      Caption = 'Fecha desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 256
      Top = 56
      Width = 74
      Height = 16
      Caption = 'Fecha hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object DBFechaDesde: TsnDBDateEdit
      Left = 142
      Top = 53
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 89
    end
    object DBFechaHasta: TsnDBDateEdit
      Left = 342
      Top = 53
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 89
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 556
    Width = 878
    Height = 19
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 95
    Width = 878
    Height = 461
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object PanelEstado1: TPanelEstado
      Left = 0
      Top = 0
      Width = 878
      Height = 461
      Align = alClient
      BorderWidth = 10
      Color = clWindow
      TabOrder = 0
      Leyendas = <>
      object dxDBGridSN1: TdxDBGridSN
        Left = 11
        Top = 11
        Width = 856
        Height = 439
        Align = alClient
        PopupMenu = snPopMenu1
        TabOrder = 0
        Visible = False
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSLegajosAPlanif
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
          object dxDBGridSN1DBTableView1codigo: TcxGridDBColumn
            Caption = 'Legajo'
            DataBinding.FieldName = 'codigo'
            PropertiesClassName = 'TcxButtonEditProperties'
            Properties.Buttons = <
              item
                Default = True
                Kind = bkEllipsis
              end>
            HeaderAlignmentHorz = taCenter
            Width = 147
          end
          object dxDBGridSN1DBTableView1nombre: TcxGridDBColumn
            Caption = 'Apellido y Nombre'
            DataBinding.FieldName = 'nombre'
            HeaderAlignmentHorz = taCenter
            Options.Focusing = False
            Width = 438
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    Top = 112
  end
  inherited Operacion: TOperacion
    Top = 112
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 112
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 112
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      'end.')
    OnValidate = <
      item
        TableName = 'TLegajosAPlanif'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar;'
          'end.')
      end>
    OnClickItemMenuPopUp = <
      item
        PopUpMenuName = 'snPopMenu1'
        ItemMenuName = 'EliminarLegajo1'
        Source.Strings = (
          'begin'
          '  TLegajosAPlanif.borrar;'
          'end.')
        HabilitadoNuevo = True
        HabilitadoModificar = True
        HabilitadoOtros = True
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TLegajosAPlanif'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid'#39').AsInteger := TInput.FieldName('#39'oid'#39').' +
            'AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  inicializarDatos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure inicializarDatos();'
          'begin'
          ' TInput.Close;'
          ' TInput.Open;'
          ' TLegajosAPlanif.Close;'
          ' TLegajosAPlanif.Open;'
          'end;'
          ''
          'procedure EjecutarConsultaPlanificacion();'
          'begin'
          ''
          '  TInput.PostRecord;'
          '  TLegajosAPlanif.postRecord;'
          '  '
          '  variable.newVariantArray('#39'parametros'#39',2);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TLegajosAPlanif'#39',' +
            #39'TLegajosAPlanif'#39');  '
          ''
          '  FormConsPasesNoVal.params :=  variable.getValue('#39'parametros'#39');'
          '  FormConsPasesNoVal.Ventana := getVentana();'
          '  FormConsPasesNoVal.Mostrar(false);'
          ''
          'end;'
          '')
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
        ButtonName = 'imageBuscar'
        Source.Strings = (
          'begin'
          '  EjecutarConsultaPlanificacion();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN1DBTableView1codigo'
        Source.Strings = (
          'begin'
          '  HelpLegajos.Mostrar();'
          'end.')
      end>
    Top = 115
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 504
    Top = 240
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_clasif_agrupador'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnIndex = True
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
    MensajeValorDuplicadoIndice = 'Legajo ya ingresado'
    Left = 496
    Top = 104
    object TInputoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 528
    Top = 105
  end
  object HelpClasifLegActivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.ClasificadorEntidad'
    TipoHelp = thCustom
    NroHelp = 105
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
    Titulo = 'Clasificadores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 359
    Top = 78
  end
  object TLegajosAPlanif: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_leg_a_planif'
        DataType = ftInteger
      end
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid;orden'
    IndexDefs = <
      item
        Name = 'TLegajosAPlanifIndex1'
        Fields = 'oid;orden'
      end
      item
        Name = 'TLegajosAPlanifIndex2'
        Fields = 'codigo'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSInput
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 592
    Top = 145
    object TLegajosAPlanifoid_leg_a_planif: TIntegerField
      FieldName = 'oid_leg_a_planif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TLegajosAPlanifoid: TIntegerField
      FieldName = 'oid'
    end
    object TLegajosAPlanifoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TLegajosAPlanifcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TLegajosAPlanifnombre: TStringField
      FieldName = 'nombre'
      Size = 255
    end
    object TLegajosAPlaniforden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSLegajosAPlanif: TDataSource
    DataSet = TLegajosAPlanif
    Left = 624
    Top = 145
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
        AsignarACampo = TLegajosAPlanifcodigo
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
    Left = 218
    Top = 223
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TLegajosAPlanifoid_legajo
    CampoDescripcion = TLegajosAPlanifnombre
    NroQuery = 0
    Cache = True
    Left = 254
    Top = 223
  end
  object snPopMenu1: TsnPopMenu
    Left = 128
    Top = 167
    object EliminarLegajo1: TMenuItem
      Caption = 'Eliminar Legajo'
    end
  end
  object FormConsPasesNoVal: TFormulario
    Nombre = 'TFPasesNoValidos'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
  object snPopMenu2: TsnPopMenu
    Left = 400
    Top = 428
    object MenuItem1: TMenuItem
      Caption = 'Eliminar Valor'
    end
  end
end
