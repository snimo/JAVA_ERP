inherited FTipoPericias: TFTipoPericias
  Left = 124
  Top = 156
  Caption = 'Tipo Pericias'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoPericia
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoPericia
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTipoPericias
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTipoPericias
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTipoPericias
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTipoPericia
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
      Height = 109
      object Label1: TLabel
        Left = 40
        Top = 24
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 20
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTTipoPericia
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
    end
    inherited PCuerpo: TPanel
      Top = 161
      Height = 430
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTipoPericia'
    OperGrabarObjeto = 'SaveTipoPericia'
    CargaDataSets = <
      item
        DataSet = TTipoPericia
        TableName = 'TTipoPericia'
      end>
    BajaLogica = <
      item
        DataSet = TTipoPericia
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTipoPericia
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTipoPericia: TsnTable [3]
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
    object TTipoPericiaoid_tipo_pericia: TIntegerField
      FieldName = 'oid_tipo_pericia'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTipoPericiacodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TTipoPericiadescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TTipoPericiaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTTipoPericia: TDataSource [4]
    DataSet = TTipoPericia
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
        TableName = 'TTipoPericia'
        FieldName = 'descripcion'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorTipoPericia.Value := Sender.AsString;'
          '  ValidadorTipoPericia.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TTipoPericia'
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
  object HelpTipoPericias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoPericia'
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
    Titulo = 'Tipos de Pericias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorTipoPericia: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoPericia'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Tipo de Pericia duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
