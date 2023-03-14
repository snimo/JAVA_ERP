inherited FMotivoFaltasRRHH: TFMotivoFaltasRRHH
  Left = 133
  Top = 206
  Width = 749
  Height = 641
  Caption = 'Motivos Faltas'
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
        DataSource = DSTMotivoFaltaRRHH
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivoFaltaRRHH
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMotivosFaltas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMotivosFaltas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMotivosFaltas
      end
      inherited Panel2: TPanel
        Left = 692
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMotivoFaltaRRHH
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
        Caption = 'Código'
      end
      object Label3: TLabel
        Left = 32
        Top = 64
        Width = 47
        Height = 13
        Caption = 'Definición'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTMotivoFaltaRRHH
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
        DataBinding.DataSource = DSTMotivoFaltaRRHH
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
    OperTraerObjeto = 'TraerMotivoFaltaRRHH'
    OperGrabarObjeto = 'SaveMotivoFaltaRRHH'
    CargaDataSets = <
      item
        DataSet = TMotivoFaltaRRHH
        TableName = 'TMotivoFaltaRRHH'
      end>
    BajaLogica = <
      item
        DataSet = TMotivoFaltaRRHH
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMotivoFaltaRRHH
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMotivoFaltaRRHH: TsnTable [3]
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
    object TMotivoFaltaRRHHoid_mot_falta: TIntegerField
      FieldName = 'oid_mot_falta'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoFaltaRRHHcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivoFaltaRRHHdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivoFaltaRRHHactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTMotivoFaltaRRHH: TDataSource [4]
    DataSet = TMotivoFaltaRRHH
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
        TableName = 'TMotivoFaltaRRHH'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorMotivoFalta.Value := Sender.AsString;'
          '  ValidadorMotivoFalta.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TMotivoFaltaRRHH'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName(''codigo'').AsString='''')'
          
            '     then raiseException(erCustomError,''Debe ingresar el código''' +
            ');'
          '  if (DataSet.FieldName(''descripcion'').AsString='''')'
          
            '     then raiseException(erCustomError,''Debe ingresar la Descrip' +
            'ción'');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMotivoFaltaRRHH'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName(''activo'').AsBoolean := True;'
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
  object HelpMotivosFaltas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.MotivoFaltaRRHH'
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
        Titulo = 'Descripción'
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
        Titulo = 'Código'
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
    Titulo = 'Motivos Faltas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMotivoFalta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.MotivoFaltaRRHH'
    WhenRaiseException = teFound
    MensajeException = 'Código de Motivo duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
