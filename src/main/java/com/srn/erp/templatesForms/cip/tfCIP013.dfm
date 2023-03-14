inherited FHabIngCIP: TFHabIngCIP
  Left = 155
  Width = 822
  Height = 350
  BorderIcons = [biSystemMenu]
  Caption = 'Habilitar Ingreso o Egreso'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 806
    Height = 266
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object snLabel1: TsnLabel
      Left = 24
      Top = 16
      Width = 83
      Height = 24
      Caption = 'Habilitar '
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clGreen
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object snLabel2: TsnLabel
      Left = 23
      Top = 136
      Width = 54
      Height = 24
      Caption = 'Fecha'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel3: TsnLabel
      Left = 353
      Top = 136
      Width = 99
      Height = 24
      Caption = 'Hora desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel4: TsnLabel
      Left = 582
      Top = 136
      Width = 90
      Height = 24
      Caption = 'Hora hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel5: TsnLabel
      Left = 23
      Top = 94
      Width = 145
      Height = 24
      Caption = 'Punto de Acceso'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel6: TsnLabel
      Left = 24
      Top = 173
      Width = 97
      Height = 24
      Caption = 'Comentario'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel7: TsnLabel
      Left = 23
      Top = 54
      Width = 55
      Height = 24
      Caption = 'Motivo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBHabilitar: TsnDBLookup
      Left = 178
      Top = 12
      DataBinding.DataField = 'habilitar'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTabNov
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 599
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 178
      Top = 132
      DataBinding.DataField = 'fecha'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBMaskEdit1: TsnDBMaskEdit
      Left = 457
      Top = 132
      DataBinding.DataField = 'hora_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.EditMask = '!90:00;1;_'
      Properties.MaxLength = 0
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 97
    end
    object snDBMaskEdit2: TsnDBMaskEdit
      Left = 678
      Top = 132
      DataBinding.DataField = 'hora_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.EditMask = '!90:00;1;_'
      Properties.MaxLength = 0
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      Width = 97
    end
    object snDBLookup2: TsnDBLookup
      Left = 178
      Top = 92
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
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 599
    end
    object snDBMemo1: TsnDBMemo
      Left = 178
      Top = 174
      DataBinding.DataField = 'observacion'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 6
      ReadOnlyAlways = False
      Height = 84
      Width = 601
    end
    object snDBLookup1: TsnDBLookup
      Left = 178
      Top = 52
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
      Style.Font.Height = -19
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 599
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 266
    Width = 806
    Height = 46
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object BotonAceptar: TsnButton
      Left = 456
      Top = 5
      Width = 97
      Height = 33
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
      Left = 568
      Top = 4
      Width = 97
      Height = 33
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
        DataSet = THabNov
        TableName = 'THabNov'
      end
      item
        DataSet = TGrupoPuerto
        TableName = 'TGrupoPuerto'
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
      '  Inicializar();'
      '  snDBHabilitar.setFoco();'
      'end.')
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'habilitar'
        Source.Strings = (
          'begin'
          ''
          '   TInput.FieldName(''oid_punto_acceso'').Clear;'
          ''
          '   operacion.InicioOperacion();'
          '   operacion.setOper(''TraerPueHabUsuParaOtoPerm'');'
          '   operacion.AddAtribute(''accion'',''HABILITAR''); '
          
            '   operacion.AddAtribute(''habilitar'',TInput.FieldName(''habilitar' +
            ''').AsString); '
          '   operacion.execute();'
          ''
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          '  TInput.FieldName(''fecha'').Value :=  varios.getFecha();'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TMotivos.loadFromHelp(''HelpMotivos'');'
          '  TraerHabNov();'
          '  funcEspSeguridad();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure funcEspSeguridad();'
          'begin'
          ''
          '  if (Varios.isFuncionSeguridadHabilitada(1004,'''',false)=false)'
          '     then begin'
          ''
          '             THabNov.First;'
          '             if (THabNov.Locate(''codigo'',''HAB_ING'' ,[]))'
          '                then THabNov.borrar();'
          ''
          '             end;'
          ''
          '  if (Varios.isFuncionSeguridadHabilitada(1005,'''',false)=false)'
          '     then begin'
          ''
          '             THabNov.First;'
          '             if (THabNov.Locate(''codigo'',''HAB_EGR'' ,[]))'
          '                then THabNov.borrar();'
          ''
          '             end;'
          ''
          '  if (Varios.isFuncionSeguridadHabilitada(1006,'''',false)=false)'
          '     then begin'
          ''
          '             THabNov.First;'
          '             if (THabNov.Locate(''codigo'',''AMBOS'' ,[]))'
          '                then THabNov.borrar();'
          ''
          '             end;'
          ''
          'end;'
          ''
          ''
          'procedure validarCargaDatos();'
          'begin'
          ' TInput.PostRecord;'
          '  if (TInput.FieldName(''habilitar'').AsString='''')'
          
            '     then raiseException(erCustomError,''Debe indicar si habilita' +
            ' un ingreso o egreso'');'
          '  if (TInput.FieldName(''oid_motivo'').AsInteger=0)'
          
            '     then raiseException(erCustomError,''Debe ingresar el Motivo''' +
            ');'
          '  if (TInput.FieldName(''oid_punto_acceso'').AsInteger = 0)'
          
            '     then raiseException(erCustomError,''Debe indicar el Punto de' +
            ' Acceso'');'
          '  if (TInput.FieldName(''fecha'').IsNull)'
          
            '     then raiseException(erCustomError,''Debe ingresar la Fecha'')' +
            ';'
          '  if (TInput.FieldName(''hora_desde'').AsString='''')'
          
            '     then raiseException(erCustomError,''Debe ingresar la hora de' +
            'sde'');'
          '  if (TInput.FieldName(''hora_hasta'').AsString='''')'
          
            '     then raiseException(erCustomError,''Debe ingresar la hora ha' +
            'sta'');'
          'end;'
          ''
          'procedure TraerHabNov();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper(''TraerHabilitacionesNov'');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          '  TGrupoPuerto.Close; '
          '  TGrupoPuerto.Open;'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.appendRecord;'
          '  TInput.FieldName(''acepto'').AsBoolean := False;'
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
          '  TInput.FieldName(''acepto'').AsBoolean := True;'
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
    object TGrupoPuertohora: TStringField
      FieldName = 'hora'
      Size = 5
    end
  end
  object HelpGrupoPuerta: TsnHelp
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
        Titulo = 'Descripción'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 100
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 100
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'Código'
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
        Titulo = 'Descripción'
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
        Titulo = 'Código'
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
end
