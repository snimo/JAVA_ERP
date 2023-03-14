inherited FEstadoSeclo: TFEstadoSeclo
  Left = 124
  Top = 156
  Caption = 'Estados de Seclos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSEstadoSeclo
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSEstadoSeclo
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEstadosSeclo
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEstadosSeclo
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEstadosSeclo
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSEstadoSeclo
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
      object Label2: TLabel
        Left = 40
        Top = 8
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSEstadoSeclo
        Properties.MaxLength = 80
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerEstadoSeclo'
    OperGrabarObjeto = 'SaveEstadoSeclo'
    CargaDataSets = <
      item
        DataSet = TEstadoSeclo
        TableName = 'TEstadoSeclo'
      end>
    BajaLogica = <
      item
        DataSet = TEstadoSeclo
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TEstadoSeclo
    ControlFocoAlta = DBEDescripcion
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TEstadoSeclo: TsnTable [3]
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
    object TEstadoSeclooid_estado_seclo: TIntegerField
      FieldName = 'oid_estado_seclo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEstadoSeclocodigo: TStringField
      DisplayWidth = 10
      FieldName = 'codigo'
      Size = 10
    end
    object TEstadoSeclodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 80
    end
    object TEstadoSecloactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSEstadoSeclo: TDataSource [4]
    DataSet = TEstadoSeclo
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
        TableName = 'TEstadoSeclo'
        FieldName = 'descripcion'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorEstadoSeclo.Value := Sender.AsString;'
          '  ValidadorEstadoSeclo.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TEstadoSeclo'
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
  object HelpEstadosSeclo: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.EstadoSeclo'
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
        Visible = False
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
    Titulo = 'Estados Seclos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorEstadoSeclo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.EstadoSeclo'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Estado de Seclo duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
