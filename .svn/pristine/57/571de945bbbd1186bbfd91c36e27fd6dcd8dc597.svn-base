inherited FPtoFichada: TFPtoFichada
  Left = 138
  Top = 129
  Width = 730
  Height = 396
  Caption = 'Puntos de Fichadas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 358
    inherited PPie: TPanel
      Top = 337
      Width = 714
      inherited StatusBarABM: TStatusBar
        Left = 609
      end
      inherited StatusBar2: TStatusBar
        Width = 609
      end
    end
    inherited PMenu: TPanel
      Width = 714
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPuntoFichadaCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPuntoFichadaCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPtoFichada
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPtoFichada
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPtoFichada
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPuntoFichadaCIP
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
      Width = 714
    end
    inherited PCabecera: TPanel
      Width = 714
    end
    inherited PCuerpo: TPanel
      Width = 714
      Height = 262
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
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPuntoFichadaCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTPuntoFichadaCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit5: TsnDBCheckEdit
        Left = 35
        Top = 80
        Caption = #191'Control Antipassback Entrada?'
        DataBinding.DataField = 'antipassback_ent'
        DataBinding.DataSource = DSTPuntoFichadaCIP
        TabOrder = 2
        Width = 206
      end
      object snDBCheckEdit6: TsnDBCheckEdit
        Left = 300
        Top = 80
        Caption = #191'Control Antipassback Salida?'
        DataBinding.DataField = 'antipassback_sal'
        DataBinding.DataSource = DSTPuntoFichadaCIP
        TabOrder = 3
        Width = 206
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPuntoFichadaCIP'
    OperGrabarObjeto = 'SavePuntoFichadaCIP'
    CargaDataSets = <
      item
        DataSet = TPuntoFichadaCIP
        TableName = 'TPuntoFichadaCIP'
      end>
    BajaLogica = <
      item
        DataSet = TPuntoFichadaCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPuntoFichadaCIP
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TPuntoFichadaCIP: TsnTable [3]
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
    object TPuntoFichadaCIPoid_pto_fichada: TIntegerField
      FieldName = 'oid_pto_fichada'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPuntoFichadaCIPcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPuntoFichadaCIPdescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TPuntoFichadaCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPuntoFichadaCIPantipassback_ent: TBooleanField
      FieldName = 'antipassback_ent'
    end
    object TPuntoFichadaCIPantipassback_sal: TBooleanField
      FieldName = 'antipassback_sal'
    end
  end
  object DSTPuntoFichadaCIP: TDataSource [4]
    DataSet = TPuntoFichadaCIP
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
        TableName = 'TPuntoFichadaCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPtoFichada.Value := Sender.AsString;'
          '  ValidadorPtoFichada.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TPuntoFichadaCIP'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo' +
            #39');'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la descri' +
            'pci'#243'n'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TPuntoFichadaCIP'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpPtoFichada: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PuntoFichadaCIP'
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
    Titulo = 'Punto Fichada CIP'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPtoFichada: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PuntoFichadaCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Punto Fichada duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
