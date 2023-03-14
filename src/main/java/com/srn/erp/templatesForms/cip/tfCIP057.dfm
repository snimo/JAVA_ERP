inherited FHabIngVis: TFHabIngVis
  Left = 115
  Top = 57
  Width = 822
  Height = 399
  BorderIcons = [biSystemMenu]
  Caption = 'Habilitar Ingreso de Visita'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 806
    Height = 315
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object snLabel2: TsnLabel
      Left = 23
      Top = 104
      Width = 45
      Height = 20
      Caption = 'Fecha'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel3: TsnLabel
      Left = 353
      Top = 104
      Width = 83
      Height = 20
      Caption = 'Hora desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel4: TsnLabel
      Left = 582
      Top = 104
      Width = 79
      Height = 20
      Caption = 'Hora hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel5: TsnLabel
      Left = 23
      Top = 62
      Width = 121
      Height = 20
      Caption = 'Punto de Acceso'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel6: TsnLabel
      Left = 24
      Top = 141
      Width = 82
      Height = 20
      Caption = 'Comentario'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel7: TsnLabel
      Left = 23
      Top = 22
      Width = 46
      Height = 20
      Caption = 'Motivo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 25
      Top = 240
      Width = 56
      Height = 20
      Caption = 'Visita a:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 25
      Top = 272
      Width = 63
      Height = 20
      Caption = 'Autoriza:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 178
      Top = 100
      DataBinding.DataField = 'fecha'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBMaskEdit1: TsnDBMaskEdit
      Left = 457
      Top = 100
      DataBinding.DataField = 'hora_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.EditMask = '!90:00;1;_'
      Properties.MaxLength = 0
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 97
    end
    object snDBMaskEdit2: TsnDBMaskEdit
      Left = 678
      Top = 100
      DataBinding.DataField = 'hora_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.EditMask = '!90:00;1;_'
      Properties.MaxLength = 0
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 97
    end
    object snDBLookup2: TsnDBLookup
      Left = 178
      Top = 60
      DataBinding.DataField = 'oid_punto_acceso'
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
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 599
    end
    object snDBMemo1: TsnDBMemo
      Left = 178
      Top = 142
      DataBinding.DataField = 'observacion'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.MaxLength = 255
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      ReadOnlyAlways = False
      Height = 84
      Width = 601
    end
    object snDBLookup1: TsnDBLookup
      Left = 178
      Top = 20
      DataBinding.DataField = 'oid_motivo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSMotivos
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 599
    end
    object snDBLookup3: TsnDBLookup
      Left = 177
      Top = 236
      DataBinding.DataField = 'oid_visita_a'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTVisitaA
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 6
      Width = 393
    end
    object snDBLookup4: TsnDBLookup
      Left = 177
      Top = 268
      DataBinding.DataField = 'oid_autoriza'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = dsTAutoriza
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 7
      Width = 393
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 315
    Width = 806
    Height = 46
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object BotonAceptar: TsnButton
      Left = 552
      Top = 5
      Width = 97
      Height = 33
      Cursor = crHandPoint
      Caption = '&Aceptar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 664
      Top = 4
      Width = 97
      Height = 33
      Cursor = crHandPoint
      Caption = '&Cancelar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TMotivos
        TableName = 'TMotivos'
      end>
    Left = 200
    Top = 208
  end
  inherited Operacion: TOperacion
    Left = 240
    Top = 208
  end
  inherited TOidObjSave: TsnTable
    Left = 640
    Top = 48
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 280
    Top = 208
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
    Top = 208
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '    Inicializar();'
      '    snDBLookup1.setFoco();'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TGrupoPuerto.loadFromHelp('#39'HelpGrupoPuerta'#39');'
          '  FuncTraerMotivos();'
          '  TVisitaA.loadFromHelp('#39'HelpVisitaA'#39');'
          '  TAutoriza.loadFromHelp('#39'HelpAutoriza'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          ''
          'procedure validarCargaDatos();'
          'begin'
          ' TInput.PostRecord;'
          '  if (TInput.FieldName('#39'oid_punto_acceso'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe indicar el Punto de' +
            ' Acceso'#39');'
          '  if (TInput.FieldName('#39'fecha'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Fecha'#39')' +
            ';'
          '  if (TInput.FieldName('#39'hora_desde'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la hora de' +
            'sde'#39');'
          '  if (TInput.FieldName('#39'hora_hasta'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la hora ha' +
            'sta'#39');'
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.appendRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := False;'
          'end;'
          ''
          'procedure FuncTraerMotivos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'FuncIngManualVisita'#39');'
          '  operacion.AddAtribute('#39'MOTIVOS_HABILITADOS'#39','#39#39');'
          '  operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          '  validarCargaDatos();'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := True;'
          '  TInput.PostRecord;'
          ''
          '  Close;'
          'end.')
      end
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end>
    Left = 360
    Top = 211
  end
  inherited SaveArchivo: TSaveDialog
    Left = 328
    Top = 96
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 512
    Top = 216
  end
  inherited TPathHelp: TsnTable
    Left = 456
    Top = 213
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'habilitar'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_punto_acceso'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'hora_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'hora_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 500
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
    Left = 328
    Top = 40
    object TInputhabilitar: TStringField
      FieldName = 'habilitar'
      Size = 50
    end
    object TInputoid_punto_acceso: TIntegerField
      FieldName = 'oid_punto_acceso'
    end
    object TInputfecha: TDateField
      FieldName = 'fecha'
      EditMask = '!99/99/0099;1;_'
    end
    object TInputhora_desde: TStringField
      FieldName = 'hora_desde'
      Size = 5
    end
    object TInputhora_hasta: TStringField
      FieldName = 'hora_hasta'
      Size = 5
    end
    object TInputobservacion: TStringField
      FieldName = 'observacion'
      Size = 500
    end
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
    object TInputoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TInputoid_visita_a: TIntegerField
      FieldName = 'oid_visita_a'
    end
    object TInputoid_autoriza: TIntegerField
      FieldName = 'oid_autoriza'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 360
    Top = 40
  end
  object THabNov: TsnTable
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
    Left = 264
    Top = 96
    object THabNovcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object THabNovdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTabNov: TDataSource
    DataSet = THabNov
    Left = 296
    Top = 96
  end
  object TGrupoPuerto: TsnTable
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
    Left = 464
    Top = 120
    object TGrupoPuertooid: TIntegerField
      FieldName = 'oid'
    end
    object TGrupoPuertocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoPuertodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object HelpGrupoPuerta: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    NroHelp = 103
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
    Titulo = 'Grupos de Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 426
    Top = 119
  end
  object DSGrupoPuertas: TDataSource
    DataSet = TGrupoPuerto
    Left = 496
    Top = 120
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivosNovCIP'
    TipoHelp = thCustom
    NroHelp = 100
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
    Titulo = 'Motivos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 471
    Top = 78
  end
  object TMotivos: TsnTable
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
    Left = 503
    Top = 54
    object TMotivosoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMotivos: TDataSource
    DataSet = TMotivos
    Left = 536
    Top = 56
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 448
    Top = 157
  end
  object HelpVisitaA: TsnHelp
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
    Titulo = 'Visita'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 276
  end
  object TVisitaA: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TVisitaAIndex1'
        Fields = 'descripcion'
      end>
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
    Left = 255
    Top = 276
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
  object DSTVisitaA: TDataSource
    DataSet = TVisitaA
    Left = 290
    Top = 277
  end
  object HelpAutoriza: TsnHelp
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
    Titulo = 'Autorizadores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 315
  end
  object TAutoriza: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TAutorizaIndex1'
        Fields = 'descripcion'
      end>
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
    Left = 255
    Top = 315
    object IntegerField2: TIntegerField
      FieldName = 'oid'
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object dsTAutoriza: TDataSource
    DataSet = TAutoriza
    Left = 290
    Top = 316
  end
end
