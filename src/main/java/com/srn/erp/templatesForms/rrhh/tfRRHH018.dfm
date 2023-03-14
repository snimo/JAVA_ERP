inherited FMedicoRRHH: TFMedicoRRHH
  Top = 203
  Width = 749
  Height = 641
  Caption = 'M'#233'dicos '
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 733
    Height = 603
    inherited PPie: TPanel
      Top = 582
      Width = 733
      inherited StatusBarABM: TStatusBar
        Left = 628
      end
      inherited StatusBar2: TStatusBar
        Width = 628
      end
    end
    inherited PMenu: TPanel
      Width = 733
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMedicoRRHH
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMedicoRRHH
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMedicos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMedicos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMedicos
      end
      inherited Panel2: TPanel
        Left = 692
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMedicoRRHH
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
      Width = 733
    end
    inherited PCabecera: TPanel
      Width = 733
      Height = 530
      Align = alClient
      object Label1: TLabel
        Left = 32
        Top = 24
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label3: TLabel
        Left = 32
        Top = 64
        Width = 47
        Height = 13
        Caption = 'Definici'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTMedicoRRHH
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 181
      end
      object snDBEdit1: TsnDBEdit
        Left = 148
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTMedicoRRHH
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 517
      end
    end
    inherited PCuerpo: TPanel
      Top = 52
      Width = 733
      Height = 8
      Align = alNone
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMedicoRRHH'
    OperGrabarObjeto = 'SaveMedicoRRHH'
    CargaDataSets = <
      item
        DataSet = TMedicoRRHH
        TableName = 'TMedicoRRHH'
      end>
    BajaLogica = <
      item
        DataSet = TMedicoRRHH
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMedicoRRHH
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMedicoRRHH: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'definicion'
        DataType = ftString
        Size = 4000
      end>
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
    object TMedicoRRHHoid_medico: TIntegerField
      FieldName = 'oid_medico'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMedicoRRHHcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TMedicoRRHHdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TMedicoRRHHactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTMedicoRRHH: TDataSource [4]
    DataSet = TMedicoRRHH
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
    Left = 344
    Top = 80
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 456
    Top = 80
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TMedicoRRHH'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorMedico.Value := Sender.AsString;'
          '  ValidadorMedico.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TMedicoRRHH'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Descrip' +
            'ci'#243'n'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMedicoRRHH'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    Left = 424
    Top = 83
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 385
    Top = 80
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 464
    Top = 147
  end
  object HelpMedicos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MedicoRRHH'
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
    Titulo = 'M'#233'dicos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMedico: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.MedicoRRHH'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de M'#233'dico duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
