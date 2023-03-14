inherited FCompaniaSeguro: TFCompaniaSeguro
  Left = 124
  Top = 156
  Caption = 'Compa'#241'ias de Seguros'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCompaniaSeguro
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCompaniaSeguro
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCompaniaSeguris
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCompaniaSeguris
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCompaniaSeguris
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTCompaniaSeguro
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
        Left = 24
        Top = 24
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snDBEdit1: TsnDBEdit
        Left = 108
        Top = 20
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTCompaniaSeguro
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 565
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 16
        Top = 56
        Caption = 'Es cauci'#243'n?'
        DataBinding.DataField = 'es_caucion'
        DataBinding.DataSource = DSTCompaniaSeguro
        TabOrder = 1
        Width = 105
      end
    end
    inherited PCuerpo: TPanel
      Top = 161
      Height = 430
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCompaniaSeguro'
    OperGrabarObjeto = 'SaveCompaniaSeguro'
    CargaDataSets = <
      item
        DataSet = TCompaniaSeguro
        TableName = 'TCompaniaSeguro'
      end>
    BajaLogica = <
      item
        DataSet = TCompaniaSeguro
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCompaniaSeguro
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCompaniaSeguro: TsnTable [3]
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
    object TCompaniaSeguroid_comp_seg: TIntegerField
      FieldName = 'id_comp_seg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCompaniaSeguroes_caucion: TBooleanField
      FieldName = 'es_caucion'
    end
    object TCompaniaSeguronombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TCompaniaSeguroactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTCompaniaSeguro: TDataSource [4]
    DataSet = TCompaniaSeguro
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
        TableName = 'TCompaniaSeguro'
        FieldName = 'nombre'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorCompania.Value := Sender.AsString;'
          '  ValidadorCompania.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TCompaniaSeguro'
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
  object HelpCompaniaSeguris: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.CompaniaSeguro'
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
    Titulo = 'Compa'#241'ia de Seguro'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorCompania: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.CompaniaSeguro'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Compa'#241'ia duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
