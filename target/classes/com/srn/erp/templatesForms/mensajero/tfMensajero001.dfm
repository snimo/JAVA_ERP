inherited FMaquinas: TFMaquinas
  Left = 80
  Top = 184
  Height = 465
  Caption = 'M'#225'quinas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 431
    inherited PPie: TPanel
      Top = 410
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMaquina
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMaquina
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMaquinas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMaquinas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMaquinas
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMaquina
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
    inherited PCuerpo: TPanel
      Height = 335
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 37
        Height = 13
        Caption = 'Nombre'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label3: TLabel
        Left = 40
        Top = 124
        Width = 10
        Height = 13
        Caption = 'IP'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTMaquina
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 277
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTMaquina
        Properties.MaxLength = 255
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 573
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 35
        Top = 88
        Caption = 'Es IP Din'#225'mica?'
        DataBinding.DataField = 'es_ip_dinamica'
        DataBinding.DataSource = DSTMaquina
        TabOrder = 2
        Width = 105
      end
      object snDBEdit2: TsnDBEdit
        Left = 124
        Top = 120
        DataBinding.DataField = 'ip'
        DataBinding.DataSource = DSTMaquina
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 189
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMaquina'
    OperGrabarObjeto = 'SaveMaquina'
    CargaDataSets = <
      item
        DataSet = TMaquina
        TableName = 'TMaquina'
      end>
    BajaLogica = <
      item
        DataSet = TMaquina
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMaquina
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMaquina: TsnTable [3]
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
    object TMaquinaoid_maquina: TIntegerField
      FieldName = 'oid_maquina'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMaquinanombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TMaquinadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
    object TMaquinaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TMaquinaes_ip_dinamica: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'es_ip_dinamica'
    end
    object TMaquinaip: TStringField
      FieldName = 'ip'
      Size = 50
    end
  end
  object DSTMaquina: TDataSource [4]
    DataSet = TMaquina
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
        TableName = 'TMaquina'
        FieldName = 'Nombre'
        Source.Strings = (
          'begin'
          '  ValidadorMaquina.Value := Sender.AsString;'
          '  ValidadorMaquina.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMaquina'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'es_ip_dinamica'#39').AsBoolean := False;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
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
    Titulo = 'M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMaquina: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de M'#225'quina duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
end
