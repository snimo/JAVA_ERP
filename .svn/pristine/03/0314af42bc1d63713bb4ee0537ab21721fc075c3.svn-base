inherited FAgrupadorTarjeta: TFAgrupadorTarjeta
  Left = 141
  Top = 197
  Height = 438
  Caption = 'Agrupador de Tarjetas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 404
    inherited PPie: TPanel
      Top = 383
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSAgrupadorTarjetas
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSAgrupadorTarjetas
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpAgrupador
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpAgrupador
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpAgrupador
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSAgrupadorTarjetas
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
      Height = 308
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 157
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSAgrupadorTarjetas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 164
      end
      object snDBEdit1: TsnDBEdit
        Left = 157
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSAgrupadorTarjetas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 252
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerAgrupadorTarjConci'
    OperGrabarObjeto = 'SaveAgrupadorTarjConci'
    CargaDataSets = <
      item
        DataSet = TAgrupadorTarjetas
        TableName = 'TAgrupadorTarjetas'
      end>
    BajaLogica = <
      item
        DataSet = TAgrupadorTarjetas
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TAgrupadorTarjetas
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TAgrupadorTarjetas: TsnTable [3]
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
    object TAgrupadorTarjetasoid_agrup_tar: TIntegerField
      FieldName = 'oid_agrup_tar'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAgrupadorTarjetascodigo: TStringField
      FieldName = 'codigo'
    end
    object TAgrupadorTarjetasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TAgrupadorTarjetasactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSAgrupadorTarjetas: TDataSource [4]
    DataSet = TAgrupadorTarjetas
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
        TableName = 'TAgrupadorTarjetas'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorAgrupador.Value := Sender.AsString;'
          '  ValidadorAgrupador.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          ' operacion.execute();  '
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
  end
  object HelpAgrupador: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.AgrupadorTarjConci'
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
    Titulo = 'Agrupadores de Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorAgrupador: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.AgrupadorTarjConci'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Agrupador de Tarjeta Duplicada'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
end
