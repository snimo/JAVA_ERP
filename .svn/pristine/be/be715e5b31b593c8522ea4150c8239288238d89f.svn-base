inherited FJuzgado: TFJuzgado
  Left = 124
  Top = 156
  Caption = 'Juzgados'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTJuzgado
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTJuzgado
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpJuzgados
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpJuzgados
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpJuzgados
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTJuzgado
        Leyendas = <
          item
            Titulo = 'Inactivo'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited PCabecera: TPanel
      Height = 83
      object Label1: TLabel
        Left = 24
        Top = 21
        Width = 81
        Height = 13
        Caption = 'Nro. / Secretar'#237'a'
      end
      object Label2: TLabel
        Left = 24
        Top = 56
        Width = 40
        Height = 13
        Caption = 'Juzgado'
      end
      object snDBEdit1: TsnDBEdit
        Left = 116
        Top = 17
        DataBinding.DataField = 'nro'
        DataBinding.DataSource = DSTJuzgado
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 229
      end
      object DBEDescripcion: TsnDBEdit
        Left = 116
        Top = 52
        DataBinding.DataField = 'juzgado'
        DataBinding.DataSource = DSTJuzgado
        Properties.MaxLength = 80
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
    end
    inherited PCuerpo: TPanel
      Top = 135
      Height = 456
      object Label3: TLabel
        Left = 24
        Top = 8
        Width = 45
        Height = 13
        Caption = 'Direcci'#243'n'
      end
      object Label4: TLabel
        Left = 24
        Top = 43
        Width = 47
        Height = 13
        Caption = 'Telefonos'
      end
      object Label5: TLabel
        Left = 24
        Top = 78
        Width = 71
        Height = 13
        Caption = 'Observaciones'
      end
      object snDBEdit2: TsnDBEdit
        Left = 116
        Top = 4
        DataBinding.DataField = 'direccion'
        DataBinding.DataSource = DSTJuzgado
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
      object snDBEdit3: TsnDBEdit
        Left = 116
        Top = 39
        DataBinding.DataField = 'telefono'
        DataBinding.DataSource = DSTJuzgado
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBMemo1: TsnDBMemo
        Left = 116
        Top = 76
        DataBinding.DataField = 'observacion'
        DataBinding.DataSource = DSTJuzgado
        Properties.MaxLength = 4000
        TabOrder = 2
        ReadOnlyAlways = False
        Height = 89
        Width = 429
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerJuzgado'
    OperGrabarObjeto = 'SaveJuzgado'
    CargaDataSets = <
      item
        DataSet = TJuzgado
        TableName = 'TJuzgado'
      end>
    BajaLogica = <
      item
        DataSet = TJuzgado
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TJuzgado
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TJuzgado: TsnTable [3]
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
    Left = 648
    Top = 59
    object TJuzgadooid_juzgado: TIntegerField
      FieldName = 'oid_juzgado'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TJuzgadonro: TStringField
      FieldName = 'nro'
    end
    object TJuzgadojuzgado: TStringField
      FieldName = 'juzgado'
      Size = 100
    end
    object TJuzgadodireccion: TStringField
      FieldName = 'direccion'
      Size = 100
    end
    object TJuzgadoobservacion: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object TJuzgadotelefono: TStringField
      FieldName = 'telefono'
      Size = 100
    end
    object TJuzgadoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTJuzgado: TDataSource [4]
    DataSet = TJuzgado
    Left = 680
    Top = 59
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
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
        TableName = 'TJuzgado'
        FieldName = 'nro'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorJuzgado.Value := Sender.AsString;'
          '  ValidadorJuzgado.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TJuzgado'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    Left = 320
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  object HelpJuzgados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.Juzgado'
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
    Titulo = 'Juzgados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorJuzgado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.Juzgado'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Juzgado duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
