inherited FConcPagoSeclo: TFConcPagoSeclo
  Left = 124
  Top = 156
  Caption = 'Concepto Pago SECLO'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTConcPagoSeclo
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTConcPagoSeclo
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpConceptoPago
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpConceptoPago
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpConceptoPago
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTConcPagoSeclo
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
        DataBinding.DataSource = DSTConcPagoSeclo
        Properties.MaxLength = 80
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerConcPagoSeclo'
    OperGrabarObjeto = 'SaveConcPagoSeclo'
    CargaDataSets = <
      item
        DataSet = TConcPagoSeclo
        TableName = 'TConcPagoSeclo'
      end>
    BajaLogica = <
      item
        DataSet = TConcPagoSeclo
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TConcPagoSeclo
    ControlFocoAlta = DBEDescripcion
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TConcPagoSeclo: TsnTable [3]
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
    object TConcPagoSeclooid_conc_pago_seclo: TIntegerField
      FieldName = 'oid_conc_pago_seclo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TConcPagoSeclodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 80
    end
    object TConcPagoSecloactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTConcPagoSeclo: TDataSource [4]
    DataSet = TConcPagoSeclo
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
        TableName = 'TConcPagoSeclo'
        FieldName = 'descripcion'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorConcepto.Value := Sender.AsString;'
          '  ValidadorConcepto.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TConcPagoSeclo'
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
  object HelpConceptoPago: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.ConcPagoSeclo'
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
    Titulo = 'Conceptos Pagos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorConcepto: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.ConcPagoSeclo'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Concepto duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
end
