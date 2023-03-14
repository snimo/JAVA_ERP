inherited FArchExcJSON: TFArchExcJSON
  Caption = 'Generaci'#243'n de Archivo para Importaci'#243'n en TABLET'
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel [0]
    Left = 32
    Top = 90
    Width = 277
    Height = 20
    Caption = 'Archivos restantes pendientes de Bajar'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object DBText1: TDBText [1]
    Left = 336
    Top = 82
    Width = 121
    Height = 35
    Alignment = taCenter
    DataField = 'cantidad'
    DataSource = DSBajandoArchivos
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -24
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Paso1: TLabel [2]
    Left = 33
    Top = 120
    Width = 4
    Height = 20
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel1: TsnLabel [3]
    Left = 32
    Top = 120
    Width = 333
    Height = 16
    Caption = 'Seleccione la Carpeta donde se guardar'#225'n los archivos'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label2: TLabel [4]
    Left = 28
    Top = 21
    Width = 102
    Height = 16
    Caption = 'Dispositivo M'#243'vil'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label3: TLabel [5]
    Left = 28
    Top = 53
    Width = 130
    Height = 16
    Caption = 'Ultimo Nro. Lote Sinc.:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object BotonGenerarArchivo: TButton [6]
    Left = 560
    Top = 8
    Width = 185
    Height = 41
    Caption = 'Generar Datos para Tablet '
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
  end
  object snShellTreeView1: TsnShellTreeView [7]
    Left = 32
    Top = 144
    Width = 737
    Height = 321
    ObjectTypes = [otFolders]
    Root = 'rfDesktop'
    UseShellImages = True
    AutoRefresh = False
    Indent = 19
    ParentColor = False
    RightClickSelect = True
    ShowRoot = False
    TabOrder = 1
  end
  object snDBLookup1: TsnDBLookup [8]
    Left = 168
    Top = 17
    DataBinding.DataField = 'oid_disp_movil'
    DataBinding.DataSource = DSCantIndividuos
    ParentFont = False
    Properties.KeyFieldNames = 'oid'
    Properties.ListColumns = <
      item
        FieldName = 'descripcion'
      end>
    Properties.ListOptions.ShowHeader = False
    Properties.ListSource = DSTGrupoImp
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 2
    Width = 234
  end
  object snDBMaskEdit1: TsnDBMaskEdit [9]
    Left = 168
    Top = 48
    DataBinding.DataField = 'ult_nro_lote_sinc'
    DataBinding.DataSource = DSCantIndividuos
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 3
    Width = 121
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TArchivosABajar
        TableName = 'TArchivosABajar'
      end
      item
        DataSet = TArchivoJSON
        TableName = 'TArchivoJSON'
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
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          '  TInput.FieldName('#39'ult_nro_lote_sinc'#39').AsInteger := 0;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord; '
          ''
          '  TGrupoImportacionExcluido.loadFromHelp('#39'HelpGrupoImpExc'#39');'
          '  TDispMovil.loadFromHelp('#39'HelpDispMovil'#39');'
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerArchivo(PathDestino : string ; Archivo : string);'
          'var'
          '  mensajeError : string;'
          '  nomTempFile : string;'
          'begin'
          '  '
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageFotoArchExc'#39');'
          '  nomTempFile := operacion.DownLoadFile(archivo, mensajeError);'
          '  varios.copiarArchivo(nomTempFile,PathDestino+'#39'\'#39'+Archivo);  '
          ''
          'end;'
          ''
          ''
          
            'procedure TraerArchivoJSON(PathDestino : string ; Archivo : stri' +
            'ng);'
          'var'
          '  mensajeError : string;'
          '  nomTempFile : string;'
          'begin'
          '  '
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageFotoArchExc'#39');'
          '  nomTempFile := operacion.DownLoadFile(archivo, mensajeError);'
          '  varios.copiarArchivo(nomTempFile,PathDestino+'#39'\'#39'+Archivo);'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonGenerarArchivo'
        Source.Strings = (
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'oid_disp_movil'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un disp' +
            'ositivo'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'GenerarArchJSONExc'#39');'
          
            '  operacion.AddAtribute('#39'oid_disp_movil'#39',IntToStr(TInput.FieldNa' +
            'me('#39'oid_disp_movil'#39').AsInteger));'
          
            '  operacion.AddAtribute('#39'ult_nro_lote_sinc'#39',IntToStr(TInput.Fiel' +
            'dName('#39'ult_nro_lote_sinc'#39').AsInteger));'
          '  operacion.execute();'
          '  '
          '   TBajandoArchivos.Close;'
          '   TBajandoArchivos.Open; '
          ''
          '   TBajandoArchivos.AppendRecord; '
          
            '   TBajandoArchivos.FieldName('#39'cantidad'#39').AsInteger := TArchivos' +
            'ABajar.count();'
          '   TBajandoArchivos.PostRecord;'
          ''
          ''
          '   TArchivosABajar.First;'
          '   while (not TArchivosABajar.EOF) do'
          '      begin'
          
            '      TraerArchivo(snShellTreeView1.getPath(),TArchivosABajar.Fi' +
            'eldName('#39'archivo'#39').AsString);'
          '      TArchivosABajar.next;'
          ''
          '      TBajandoArchivos.EditRecord; '
          
            '      TBajandoArchivos.FieldName('#39'cantidad'#39').AsInteger := TBajan' +
            'doArchivos.FieldName('#39'cantidad'#39').AsInteger - 1;'
          '      TBajandoArchivos.PostRecord;'
          '  '
          '      varios.RefrescarPantalla();'
          '      end;'
          ''
          ''
          '    TArchivoJSON.first;'
          '    while (not TArchivoJSON.eof) do'
          '        begin'
          ''
          
            '        TraerArchivoJSON(snShellTreeView1.getPath(),TArchivoJSON' +
            '.FieldName('#39'contenido'#39').AsString);'
          ''
          '        TArchivoJSON.next;'
          '        end;'
          ''
          '     mensaje.information('#39'Generaci'#243'n Finalizada'#39');'
          '  '
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    object TTempVarFormoid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
  end
  object TArchivosABajar: TsnTable
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
    Left = 336
    Top = 256
    object TArchivosABajararchivo: TStringField
      FieldName = 'archivo'
      Size = 50
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 464
    Top = 120
  end
  object TBajandoArchivos: TsnTable
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
    Left = 128
    Top = 224
    object TBajandoArchivoscantidad: TIntegerField
      FieldName = 'cantidad'
    end
  end
  object DSBajandoArchivos: TDataSource
    DataSet = TBajandoArchivos
    Left = 160
    Top = 224
  end
  object TArchivoJSON: TsnTable
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
    Top = 312
    object TArchivoJSONcontenido: TMemoField
      FieldName = 'contenido'
      BlobType = ftMemo
    end
  end
  object DSArchivoJSON: TDataSource
    DataSet = TArchivoJSON
    Left = 184
    Top = 312
  end
  object SaveJSON: TsnSaveDialog
    DefaultExt = 'jpg'
    OptionsEx = [ofExNoPlacesBar]
    Left = 208
    Top = 242
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
    Left = 464
    Top = 64
    object TInputcant_individuos: TIntegerField
      FieldName = 'cant_individuos'
    end
    object TInputoid_grupo_imp_exc: TIntegerField
      FieldName = 'oid_grupo_imp_exc'
    end
    object TInputoid_disp_movil: TIntegerField
      FieldName = 'oid_disp_movil'
    end
    object TInputult_nro_lote_sinc: TIntegerField
      FieldName = 'ult_nro_lote_sinc'
    end
  end
  object DSCantIndividuos: TDataSource
    DataSet = TInput
    Left = 499
    Top = 65
  end
  object HelpGrupoImpExc: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.GrupoImportacionExcluido'
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
    Titulo = 'Grupo Importaci'#243'n Excluido'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 194
    Top = 363
  end
  object TGrupoImportacionExcluido: TsnTable
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
    Left = 226
    Top = 363
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
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
  object DSGrupoImportacionExcluido: TDataSource
    DataSet = TGrupoImportacionExcluido
    Left = 256
    Top = 363
  end
  object HelpDispMovil: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.DispMovilExc'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 610
    Top = 169
  end
  object TDispMovil: TsnTable
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
    Left = 642
    Top = 169
    object TDispMoviloid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDispMovilcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TDispMovildescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTGrupoImp: TDataSource
    DataSet = TDispMovil
    Left = 680
    Top = 171
  end
end
