inherited FAbogado: TFAbogado
  Left = 124
  Top = 156
  Caption = 'Abogado'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTAbogado
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTAbogado
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpAbogados
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpAbogados
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpAbogados
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTAbogado
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
      Height = 413
      object Label2: TLabel
        Left = 40
        Top = 32
        Width = 37
        Height = 13
        Caption = 'Apellido'
      end
      object Label1: TLabel
        Left = 40
        Top = 72
        Width = 37
        Height = 13
        Caption = 'Nombre'
      end
      object Label3: TLabel
        Left = 40
        Top = 112
        Width = 47
        Height = 13
        Caption = 'Telefonos'
      end
      object Label4: TLabel
        Left = 40
        Top = 152
        Width = 28
        Height = 13
        Caption = 'E-mail'
      end
      object Label5: TLabel
        Left = 40
        Top = 192
        Width = 45
        Height = 13
        Caption = 'Direcci'#243'n'
      end
      object Label6: TLabel
        Left = 40
        Top = 232
        Width = 35
        Height = 13
        Caption = 'Estudio'
      end
      object Label7: TLabel
        Left = 40
        Top = 272
        Width = 37
        Height = 13
        Caption = 'C.U.I.T.'
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'apellido'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 325
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 68
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 325
      end
      object snDBEdit2: TsnDBEdit
        Left = 124
        Top = 108
        DataBinding.DataField = 'telefonos'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 325
      end
      object snDBEdit3: TsnDBEdit
        Left = 124
        Top = 148
        DataBinding.DataField = 'mail'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 517
      end
      object snDBEdit4: TsnDBEdit
        Left = 124
        Top = 188
        DataBinding.DataField = 'direccion'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 517
      end
      object snDBEdit5: TsnDBEdit
        Left = 124
        Top = 228
        DataBinding.DataField = 'estudio'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 5
        Width = 517
      end
      object snDBEdit6: TsnDBEdit
        Left = 124
        Top = 268
        DataBinding.DataField = 'cuit'
        DataBinding.DataSource = DSTAbogado
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 6
        Width = 197
      end
    end
    inherited PCuerpo: TPanel
      Top = 465
      Height = 126
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerAbogado'
    OperGrabarObjeto = 'SaveAbogado'
    CargaDataSets = <
      item
        DataSet = TAbogado
        TableName = 'TAbogado'
      end>
    BajaLogica = <
      item
        DataSet = TAbogado
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TAbogado
    ControlFocoAlta = DBEDescripcion
    ControlFocoModif = DBEDescripcion
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TAbogado: TsnTable [3]
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
    object TAbogadooid_abogado: TIntegerField
      FieldName = 'oid_abogado'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAbogadoapellido: TStringField
      FieldName = 'apellido'
      Size = 50
    end
    object TAbogadonombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
    object TAbogadotelefonos: TStringField
      FieldName = 'telefonos'
      Size = 50
    end
    object TAbogadomail: TStringField
      FieldName = 'mail'
      Size = 100
    end
    object TAbogadodireccion: TStringField
      FieldName = 'direccion'
      Size = 100
    end
    object TAbogadoestudio: TStringField
      FieldName = 'estudio'
      Size = 100
    end
    object TAbogadoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TAbogadocuit: TStringField
      FieldName = 'cuit'
    end
  end
  object DSTAbogado: TDataSource [4]
    DataSet = TAbogado
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
    Top = 48
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited DriverEvent: TDriverEvent
    OnNuevoRegistro = <
      item
        TableName = 'TAbogado'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    Left = 320
    Top = 43
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 272
    Top = 44
  end
  object HelpAbogados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.Abogado'
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
    Titulo = 'Abogados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 186
    Top = 44
  end
  object ValidadorAbogado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'leg.Abogado'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Abogado duplicado'
    NroQuery = 0
    Cache = False
    Left = 224
    Top = 43
  end
end
