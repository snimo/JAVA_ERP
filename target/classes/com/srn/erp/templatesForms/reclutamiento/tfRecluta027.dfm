inherited FRecluEstadoPostulante: TFRecluEstadoPostulante
  Left = 158
  Top = 69
  Width = 770
  Caption = 'Estado de Postulante'
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
        DataSource = DSTRecluEstadoPostulante
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRecluEstadoPostulante
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEstado
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEstado
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEstado
      end
      inherited Panel2: TPanel
        Left = 713
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRecluEstadoPostulante
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
        Width = 24
        Height = 13
        Caption = 'Color'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRecluEstadoPostulante
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
        DataBinding.DataSource = DSTRecluEstadoPostulante
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
      object snDBLookup1: TsnDBLookup
        Left = 124
        Top = 84
        DataBinding.DataField = 'color'
        DataBinding.DataSource = DSTRecluEstadoPostulante
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSColores
        TabOrder = 2
        Width = 277
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 122
        Top = 128
        Caption = 'Selecionado'
        DataBinding.DataField = 'seleccionado'
        DataBinding.DataSource = DSTRecluEstadoPostulante
        TabOrder = 3
        Width = 121
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRecluEstadoPostulante'
    OperGrabarObjeto = 'SaveRecluEstadoPostulante'
    CargaDataSets = <
      item
        DataSet = TRecluEstadoPostulante
        TableName = 'TRecluEstadoPostulante'
      end>
    BajaLogica = <
      item
        DataSet = TRecluEstadoPostulante
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRecluEstadoPostulante
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRecluEstadoPostulante: TsnTable [3]
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
    object TRecluEstadoPostulanteoid_estado_postu: TIntegerField
      FieldName = 'oid_estado_postu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRecluEstadoPostulantecodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRecluEstadoPostulantedescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TRecluEstadoPostulanteactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TRecluEstadoPostulantecolor: TIntegerField
      FieldName = 'color'
    end
    object TRecluEstadoPostulanteseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSTRecluEstadoPostulante: TDataSource [4]
    DataSet = TRecluEstadoPostulante
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
        TableName = 'TRecluEstadoPostulante'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorEstado.Value := Sender.AsString;'
          '  ValidadorEstado.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRecluEstadoPostulante'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          '  DataSet.FieldName('#39'seleccionado'#39').Value := false;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  cargarColores();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarColores();'
          'begin'
          ''
          '  TColores.Close;'
          '  TColores.Open;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 1; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Rojo'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 2; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Verde'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 3; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Amarillo'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 4; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Celeste'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 5; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Gris'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 6; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Naranja'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 7; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Marron'#39'; '
          '  TColores.PostRecord;'
          ''
          '  TColores.AppendRecord;'
          '  TColores.FieldName('#39'codigo'#39').AsInteger := 8; '
          '  TColores.FieldName('#39'descripcion'#39').AsString := '#39'Rosa'#39'; '
          '  TColores.PostRecord;'
          ''
          ''
          'end;')
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
  object HelpEstado: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoPostulante'
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
    Titulo = 'Estados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorEstado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoPostulante'
    WhenRaiseException = teFound
    MensajeException = 'Codigo de Estado Existente'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TColores: TsnTable
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
    Left = 184
    Top = 323
    object TColorescodigo: TIntegerField
      FieldName = 'codigo'
    end
    object TColoresdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSColores: TDataSource
    DataSet = TColores
    Left = 224
    Top = 323
  end
end
