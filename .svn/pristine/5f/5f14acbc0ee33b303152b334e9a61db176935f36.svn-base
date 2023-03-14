inherited FAltaMotivoFichada: TFAltaMotivoFichada
  Left = 190
  Top = 118
  Width = 730
  Height = 396
  Caption = 'Motivos de Fichadas'
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
        DataSource = DSTMotivoFichadaCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivoFichadaCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMotivoFichadaCIP
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMotivoFichadaCIP
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMotivoFichadaCIP
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMotivoFichadaCIP
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
      object Label2: TLabel
        Left = 40
        Top = 8
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label1: TLabel
        Left = 40
        Top = 56
        Width = 45
        Height = 13
        Caption = 'Entrada'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object Label3: TLabel
        Left = 304
        Top = 56
        Width = 36
        Height = 13
        Caption = 'Salida'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object Label4: TLabel
        Left = 40
        Top = 140
        Width = 29
        Height = 13
        Caption = 'Orden'
      end
      object Label5: TLabel
        Left = 304
        Top = 140
        Width = 29
        Height = 13
        Caption = 'Orden'
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 35
        Top = 88
        Caption = #191'Entrada?'
        DataBinding.DataField = 'entrada'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        TabOrder = 1
        Width = 121
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 35
        Top = 112
        Caption = #191'Requiere Observaci'#243'n?'
        DataBinding.DataField = 'requiere_obs_ent'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        TabOrder = 2
        Width = 158
      end
      object snDBEdit2: TsnDBEdit
        Left = 88
        Top = 136
        DataBinding.DataField = 'orden_entrada'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        TabOrder = 3
        Width = 33
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 299
        Top = 88
        Caption = #191'Salida?'
        DataBinding.DataField = 'salida'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        TabOrder = 4
        Width = 121
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 299
        Top = 112
        Caption = #191'Requiere Observaci'#243'n?'
        DataBinding.DataField = 'requiere_obs_sal'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        TabOrder = 5
        Width = 158
      end
      object snDBEdit3: TsnDBEdit
        Left = 352
        Top = 136
        DataBinding.DataField = 'orden_salida'
        DataBinding.DataSource = DSTMotivoFichadaCIP
        TabOrder = 6
        Width = 33
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMotivoFichadaCIP'
    OperGrabarObjeto = 'SaveMotivoFichadaCIP'
    CargaDataSets = <
      item
        DataSet = TMotivoFichadaCIP
        TableName = 'TMotivoFichadaCIP'
      end>
    BajaLogica = <
      item
        DataSet = TMotivoFichadaCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMotivoFichadaCIP
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMotivoFichadaCIP: TsnTable [3]
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
    object TMotivoFichadaCIPoid_motivo_fichada: TIntegerField
      FieldName = 'oid_motivo_fichada'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoFichadaCIPdescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TMotivoFichadaCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TMotivoFichadaCIPentrada: TBooleanField
      FieldName = 'entrada'
    end
    object TMotivoFichadaCIPrequiere_obs_ent: TBooleanField
      FieldName = 'requiere_obs_ent'
    end
    object TMotivoFichadaCIPsalida: TBooleanField
      FieldName = 'salida'
    end
    object TMotivoFichadaCIPrequiere_obs_sal: TBooleanField
      FieldName = 'requiere_obs_sal'
    end
    object TMotivoFichadaCIPorden_entrada: TIntegerField
      FieldName = 'orden_entrada'
    end
    object TMotivoFichadaCIPorden_salida: TIntegerField
      FieldName = 'orden_salida'
    end
  end
  object DSTMotivoFichadaCIP: TDataSource [4]
    DataSet = TMotivoFichadaCIP
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
        TableName = 'TMotivoFichadaCIP'
        FieldName = 'descripcion'
        Source.Strings = (
          'begin'
          '  ValidadorMotivoFichadaCIP.Value := Sender.AsString;'
          '  ValidadorMotivoFichadaCIP.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMotivoFichadaCIP'
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
  object HelpMotivoFichadaCIP: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoFichadaCIP'
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
    Titulo = 'Motivos Fichadas CIP'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMotivoFichadaCIP: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoFichadaCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Motivo Fichada Duplicado duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
