inherited FTipoCausa: TFTipoCausa
  Left = 124
  Top = 156
  Caption = 'Tipo de Causas Cartas Documentos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoCausaLegales
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoCausaLegales
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTiposCausas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTiposCausas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTiposCausas
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTipoCausaLegales
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
        DataBinding.DataSource = DSTTipoCausaLegales
        Properties.MaxLength = 80
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTipoCausaLegales'
    OperGrabarObjeto = 'SaveTipoCausaLegales'
    CargaDataSets = <
      item
        DataSet = TTipoCausaLegales
        TableName = 'TTipoCausaLegales'
      end>
    BajaLogica = <
      item
        DataSet = TTipoCausaLegales
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTipoCausaLegales
    ControlFocoAlta = DBEDescripcion
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTipoCausaLegales: TsnTable [3]
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
    object TTipoCausaLegalesoid_tipo_causa: TIntegerField
      FieldName = 'oid_tipo_causa'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTipoCausaLegalescodigo: TStringField
      DisplayWidth = 10
      FieldName = 'codigo'
      Size = 10
    end
    object TTipoCausaLegalesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 80
    end
    object TTipoCausaLegalesactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTTipoCausaLegales: TDataSource [4]
    DataSet = TTipoCausaLegales
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
        TableName = 'TTipoCausaLegales'
        FieldName = 'descripcion'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorTipoCausa.Value := Sender.AsString;'
          '  ValidadorTipoCausa.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TTipoCausaLegales'
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
  object HelpTiposCausas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoCausaLegales'
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
    Titulo = 'Tipos Causas Cartas Documento'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorTipoCausa: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoCausaLegales'
    WhenRaiseException = teFound
    MensajeException = 'Tipo de Causa Carta duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
