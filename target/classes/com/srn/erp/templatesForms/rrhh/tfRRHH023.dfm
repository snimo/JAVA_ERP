inherited FFiltroCronoDesa: TFFiltroCronoDesa
  Top = 205
  Height = 706
  Caption = 'Cronograma de desarrollo'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 779
    Height = 49
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Shape1: TShape
      Left = 16
      Top = 12
      Width = 201
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object snLabel2: TsnLabel
      Left = 32
      Top = 17
      Width = 168
      Height = 16
      Caption = 'Cronograma de Desarrollo'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
      Transparent = True
    end
    object BotonEjecutarConsulta: TImage
      Left = 366
      Top = 9
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Ejecutar Consulta de Cronograma'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 414
      Top = 9
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
    Top = 49
    Width = 779
    Height = 619
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Panel3: TPanel
      Left = 0
      Top = 0
      Width = 779
      Height = 88
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object snLabel6: TsnLabel
        Left = 24
        Top = 15
        Width = 75
        Height = 16
        Caption = 'Cronograma'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snLabel4: TsnLabel
        Left = 368
        Top = 15
        Width = 27
        Height = 16
        Caption = 'A'#241'o:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snLabel3: TsnLabel
        Left = 504
        Top = 15
        Width = 85
        Height = 16
        Caption = 'Mes a evaluar'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object Shape2: TShape
        Left = 16
        Top = 59
        Width = 201
        Height = 28
        Brush.Color = 16769217
        Shape = stRoundRect
      end
      object snLabel1: TsnLabel
        Left = 32
        Top = 64
        Width = 140
        Height = 16
        Caption = 'Seleccionar Acciones'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
        Transparent = True
      end
      object snDBLookup2: TsnDBLookup
        Left = 111
        Top = 12
        DataBinding.DataField = 'oid_cronograma'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.ImmediatePost = True
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSCronogramas
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 0
        Width = 242
      end
      object snDBEdit1: TsnDBEdit
        Left = 400
        Top = 11
        DataBinding.DataField = 'anio'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 1
        Width = 89
      end
      object snDBLookup1: TsnDBLookup
        Left = 596
        Top = 10
        DataBinding.DataField = 'mes'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.ImmediatePost = True
        Properties.KeyFieldNames = 'mes'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTMesesDesarrollo
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 2
        Width = 170
      end
    end
    object Panel4: TPanel
      Left = 0
      Top = 88
      Width = 779
      Height = 531
      Align = alClient
      BorderWidth = 10
      Color = clWindow
      TabOrder = 1
      object dxDBGridSN1: TdxDBGridSN
        Left = 11
        Top = 11
        Width = 757
        Height = 509
        Align = alClient
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSAccionesCronograma
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Inserting = False
          OptionsView.CellAutoHeight = True
          OptionsView.GroupByBox = False
          Styles.Content = cxStyle1
          Styles.Header = cxStyle1
          object dxDBGridSN1DBTableView1seleccionar: TcxGridDBColumn
            Caption = 'Selecionar?'
            DataBinding.FieldName = 'seleccionar'
            PropertiesClassName = 'TcxCheckBoxProperties'
            Properties.ImmediatePost = True
            Width = 86
          end
          object dxDBGridSN1DBTableView1descripcion: TcxGridDBColumn
            Caption = 'Acci'#243'n'
            DataBinding.FieldName = 'descripcion'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 644
          end
          object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
            DataBinding.FieldName = 'orden'
            Visible = False
            SortIndex = 0
            SortOrder = soAscending
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TMesesDesarrollo
        TableName = 'TMesesDesarrollo'
      end
      item
        DataSet = TAccionesCronograma
        TableName = 'TAccionesCronograma'
      end>
    Left = 32
    Top = 400
  end
  inherited Operacion: TOperacion
    Left = 72
    Top = 400
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 112
    Top = 400
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 152
    Top = 400
  end
  inherited DriverEvent: TDriverEvent
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'oid_cronograma'
        Source.Strings = (
          'begin'
          '  TAccionesCronograma.Close;'
          '  TAccionesCronograma.Open;'
          '  if (Sender.AsInteger>0)'
          
            '     then TraerAcciones(Sender.AsInteger,TInput.FieldName('#39'mes'#39')' +
            '.AsString);'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'mes'
        Source.Strings = (
          'begin'
          '  TAccionesCronograma.Close;'
          '  TAccionesCronograma.Open;'
          
            '  TraerAcciones(TInput.FieldName('#39'oid_cronograma'#39').AsInteger,Sen' +
            'der.AsString);'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '    varios.setImagen('#39'BotonEjecutarConsulta'#39',0);'
          '    varios.setImagen('#39'ImageSalir'#39',7);'
          '    Inicializar();'
          '    TCronogramas.loadFromHelp('#39'HelpCronogramas'#39');'
          '    TraerMeses();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          'end;'
          ''
          'procedure TraerMeses();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerMesesDesarrollo'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerAcciones(oidCronograma : integer; mes : string);'
          'begin'
          ''
          '  if (OidCronograma<=0)'
          '     then begin'
          '             TAccionesCronograma.Close;'
          '             TAccionesCronograma.Open;'
          '             Exit;'
          '             end;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerAccionesDesa'#39');'
          
            '  operacion.addAtribute('#39'oid_cronograma'#39', inttostr(oidCronograma' +
            '));'
          '  operacion.addAtribute('#39'mes'#39',mes);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure validarCarga();'
          'begin'
          ''
          'if (TInput.FieldName('#39'oid_cronograma'#39').AsInteger = 0)'
          
            '   then raiseException(erCustomError,'#39'Debe ingresar el cronogram' +
            'a'#39');'
          'if (TInput.FieldName('#39'mes'#39').AsString = '#39#39')'
          '   then raiseException(erCustomError,'#39'Debe ingresar el mes'#39');'
          'if (TInput.FieldName('#39'anio'#39').AsInteger = 0)'
          '   then raiseException(erCustomError,'#39'Debe ingresar el anio'#39');'
          ''
          'end;'
          ''
          ''
          ''
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  TInput.postRecord;'
          '  TAccionesCronograma.postRecord;'
          ''
          '  validarCarga();'
          ''
          '  variable.newVariantArray('#39'parametros'#39',2);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TAccionesCronogra' +
            'ma'#39','#39'TAccionesCronograma'#39');  '
          ''
          '  FormConsPlanDesa.params :=  variable.getValue('#39'parametros'#39');'
          '  FormConsPlanDesa.Ventana := getVentana();'
          '  FormConsPlanDesa.Mostrar(false);'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  Close();'
          'end.')
      end
      item
        ButtonName = 'BotonEjecutarConsulta'
        Source.Strings = (
          'begin'
          '  EjecutarConsulta();'
          'end.')
      end>
    Left = 192
    Top = 403
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
    FieldDefs = <
      item
        Name = 'oid_cronograma'
        DataType = ftInteger
      end
      item
        Name = 'mes'
        DataType = ftString
        Size = 10
      end>
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
    Left = 568
    Top = 159
    object TInputoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TInputmes: TStringField
      FieldName = 'mes'
      Size = 10
    end
    object TInputanio: TIntegerField
      FieldName = 'anio'
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 672
    Top = 76
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 600
    Top = 159
  end
  object HelpCronogramas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.CronogramaDesa'
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
    Titulo = 'Cronogramas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 458
    Top = 204
  end
  object TCronogramas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end>
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
    Left = 490
    Top = 204
    object TCronogramasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCronogramascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCronogramasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCronogramas: TDataSource
    DataSet = TCronogramas
    Left = 520
    Top = 207
  end
  object TMesesDesarrollo: TsnTable
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
    Left = 512
    Top = 319
    object TMesesDesarrollomes: TStringField
      FieldName = 'mes'
      Size = 50
    end
    object TMesesDesarrollodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTMesesDesarrollo: TDataSource
    DataSet = TMesesDesarrollo
    Left = 544
    Top = 319
  end
  object TAccionesCronograma: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cronograma'
        DataType = ftInteger
      end
      item
        Name = 'oid_accion'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 1000
      end
      item
        Name = 'seleccionar'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cronograma'
    IndexDefs = <
      item
        Name = 'TAccionesCronogramaIndex1'
        Fields = 'oid_cronograma'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cronograma'
    MasterSource = DSInput
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 568
    Top = 199
    object TAccionesCronogramaoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TAccionesCronogramaoid_accion: TIntegerField
      FieldName = 'oid_accion'
    end
    object TAccionesCronogramadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 1000
    end
    object TAccionesCronogramaseleccionar: TBooleanField
      FieldName = 'seleccionar'
    end
    object TAccionesCronogramaorden: TIntegerField
      FieldName = 'orden'
    end
  end
  object DSAccionesCronograma: TDataSource
    DataSet = TAccionesCronograma
    Left = 600
    Top = 199
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
    end
  end
  object FormConsPlanDesa: TFormulario
    Nombre = 'TFConsPlanDesa'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
end
