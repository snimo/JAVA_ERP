inherited FRecluTipoContrato: TFRecluTipoContrato
  Left = 193
  Top = 69
  Width = 770
  Caption = 'Tipos de Contratos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 754
    inherited PPie: TPanel
      Width = 754
      inherited StatusBarABM: TStatusBar
        Left = 649
      end
      inherited StatusBar2: TStatusBar
        Width = 649
      end
    end
    inherited PMenu: TPanel
      Width = 754
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluTipoContrato
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluTipoContrato
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTipoContrato
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTipoContrato
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTipoContrato
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluTipoContrato
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
    inherited POpcionesMenu: TPanel
      Width = 754
    end
    inherited PCabecera: TPanel
      Width = 754
    end
    inherited PCuerpo: TPanel
      Width = 754
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluTipoContrato
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluTipoContrato
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluTipoContrato'
    OperGrabarObjeto = 'SaveRecluTipoContrato'
    CargaDataSets = <
      item
        DataSet = TRecluTipoContrato
        TableName = 'TRecluTipoContrato'
      end>
    BajaLogica = <
      item
        DataSet = TRecluTipoContrato
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluTipoContrato
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluTipoContrato: TsnTable [3]
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
    Left = 640
    Top = 59
    object TRecluTipoContratooid_tipo_contrato: TIntegerField
      FieldName = 'oid_tipo_contrato'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluTipoContratocodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluTipoContratodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluTipoContratoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRecluTipoContrato: TDataSource [4]
    DataSet = TRecluTipoContrato
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
        TableName = 'TRecluTipoContrato'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorTipoContrato.Value := Sender.AsString;'
          '  ValidadorTipoContrato.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluTipoContrato'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
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
  object HelpTipoContrato: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoContrato'
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
    Titulo = 'Tipos de Contratos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorTipoContrato: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoContrato'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Tipo de Contrato Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
