inherited FRecluSelector: TFRecluSelector
  Left = 174
  Width = 770
  Caption = 'Selector'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 754
    inherited PPie: TPanel
      Width = 754
      inherited StatusBarABM: TStatusBar
        Left = 649
      end
      inherited StatusBar2: TStatusBar
        Width = 649
      end
    end
    inherited PMenu: TPanel
      Width = 754
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluSelector
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluSelector
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpSelector
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpSelector
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpSelector
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluSelector
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
      Width = 754
    end
    inherited PCabecera: TPanel
      Width = 754
    end
    inherited PCuerpo: TPanel
      Width = 754
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label3: TLabel
        Left = 40
        Top = 88
        Width = 36
        Height = 13
        Caption = 'Usuario'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluSelector
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRecluSelector
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
      object snDBLookup1: TsnDBLookup
        Left = 125
        Top = 84
        DataBinding.DataField = 'oid_usuario'
        DataBinding.DataSource = DSTRecluSelector
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSUsuarios
        TabOrder = 2
        Width = 276
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluSelector'
    OperGrabarObjeto = 'SaveRecluSelector'
    CargaDataSets = <
      item
        DataSet = TRecluSelector
        TableName = 'TRecluSelector'
      end>
    BajaLogica = <
      item
        DataSet = TRecluSelector
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluSelector
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluSelector: TsnTable [3]
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
    Left = 640
    Top = 59
    object TRecluSelectoroid_selector: TIntegerField
      FieldName = 'oid_selector'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluSelectorcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluSelectordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluSelectoroid_usuario: TIntegerField
      FieldName = 'oid_usuario'
    end
    object TRecluSelectoractivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRecluSelector: TDataSource [4]
    DataSet = TRecluSelector
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
        TableName = 'TRecluSelector'
        FieldName = 'codigo'
        Source.Strings = (
          'program validar;'
          'begin'
          '  ValidadorSelector.Value := Sender.AsString;'
          '  ValidadorSelector.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TRecluSelector'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la descrip' +
            'ci'#243'n'#39');'
          '  if (DataSet.FieldName('#39'oid_usuario'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el usuario' +
            #39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluSelector'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TUsuarios.loadFromHelp('#39'HelpUsuarios'#39');'
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
  object HelpSelector: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSelector'
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
    Titulo = 'Selectores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorSelector: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSelector'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Selector Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object HelpUsuarios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
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
    Titulo = 'Usuarios'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 144
    Top = 206
  end
  object TUsuarios: TsnTable
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
    Left = 178
    Top = 206
    object IntegerField5: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSUsuarios: TDataSource
    DataSet = TUsuarios
    Left = 212
    Top = 208
  end
end
