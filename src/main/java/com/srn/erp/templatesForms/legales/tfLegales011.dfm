inherited FRubroCondena: TFRubroCondena
  Left = 124
  Top = 156
  Caption = 'Rubro Condena'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSRubriCondena
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSRubriCondena
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpRubroCondena
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpRubroCondena
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpRubroCondena
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSRubriCondena
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
      object Label2: TLabel
        Left = 40
        Top = 32
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label1: TLabel
        Left = 40
        Top = 72
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSRubriCondena
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 189
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 68
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSRubriCondena
        Properties.MaxLength = 255
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 565
      end
    end
    inherited PCuerpo: TPanel
      Top = 161
      Height = 430
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRubroCondena'
    OperGrabarObjeto = 'SaveRubroCondena'
    CargaDataSets = <
      item
        DataSet = TRubroCondena
        TableName = 'TRubroCondena'
      end>
    BajaLogica = <
      item
        DataSet = TRubroCondena
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRubroCondena
    ControlFocoAlta = DBEDescripcion
    ControlFocoModif = DBEDescripcion
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRubroCondena: TsnTable [3]
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
    object TRubroCondenaoid_rubro_condena: TIntegerField
      FieldName = 'oid_rubro_condena'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRubroCondenacodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TRubroCondenadescripcion: TStringField
      DisplayWidth = 255
      FieldName = 'descripcion'
      Size = 255
    end
    object TRubroCondenaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSRubriCondena: TDataSource [4]
    DataSet = TRubroCondena
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
        TableName = 'TRubroCondena'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorRubroCondena.Value := Sender.AsString;'
          '  ValidadorRubroCondena.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRubroCondena'
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
  object HelpRubroCondena: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.RubroCondena'
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
    Titulo = 'Rubros Condena'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorRubroCondena: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.RubroCondena'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Rubro Condena duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
