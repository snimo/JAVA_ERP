inherited FImagen: TFImagen
  Left = 62
  Top = 119
  Height = 530
  Caption = 'Im'#225'genes'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 496
    inherited PPie: TPanel
      Top = 475
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTImagen
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTImagen
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpImagenes
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpImagenes
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpImagenes
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTImagen
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
      Height = 400
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
      object Imagen: TsnImage
        Left = 126
        Top = 120
        Width = 457
        Height = 265
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTImagen
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 157
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTImagen
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 453
      end
      object BotonElegirImagen: TsnButton
        Left = 124
        Top = 88
        Width = 153
        Height = 25
        Caption = 'Seleccionar archivo ...'
        TabOrder = 2
        LookAndFeel.Kind = lfOffice11
      end
      object BorrarImagen: TsnButton
        Left = 300
        Top = 88
        Width = 153
        Height = 25
        Caption = 'Borrar Im'#225'gen'
        TabOrder = 3
        LookAndFeel.Kind = lfOffice11
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerImagen'
    OperGrabarObjeto = 'SaveImagen'
    CargaDataSets = <
      item
        DataSet = TImagen
        TableName = 'TImagen'
      end>
    BajaLogica = <
      item
        DataSet = TImagen
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TImagen
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TImagen: TsnTable [3]
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
    object TImagenoid_imagen: TIntegerField
      FieldName = 'oid_imagen'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TImagencodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TImagendescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TImagenactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTImagen: TDataSource [4]
    DataSet = TImagen
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
        TableName = 'TImagen'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorImagen.Value := Sender.AsString;'
          '  ValidadorImagen.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  SeleccionFile.setTipoImagen();'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  TraerImagenGral();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerImagenGral();'
          'var'
          '  mensajeError : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageGeneral'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TImagen.FieldName('#39'oid_i' +
            'magen'#39').AsString, mensajeError);'
          '  Imagen.LoadFromFile(nomTempFile);'
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  SeleccionFile.clearStream();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'var'
          '  mensajeError : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'UploadImagenGeneral'#39');'
          '  operacion.UploadFile('
          '        Imagen.getDataStream(),'
          '        TOidObjSave.FieldName('#39'oid'#39').AsString,'
          '        '#39#39','#39#39',true,mensajeError);'
          'end.'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonElegirImagen'
        Source.Strings = (
          'begin'
          
            '  if (not (DriverABM.isModificar or DriverABM.isNuevo)) then exi' +
            't;'
          '  if (SeleccionFile.execute())'
          '     then imagen.LoadFromFile(SeleccionFile.getFileName());'
          'end.')
      end
      item
        ButtonName = 'BorrarImagen'
        Source.Strings = (
          'begin'
          
            '  if (not (DriverABM.isModificar or DriverABM.isNuevo)) then exi' +
            't;'
          '  Imagen.LoadFromFile('#39#39#39#39');'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListGruposPopUp: TImageList
    Top = 67
  end
  inherited ImageListItemsPopUp: TImageList
    Top = 107
  end
  inherited TPathHelp: TsnTable
    Left = 568
    Top = 245
  end
  object HelpImagenes: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.Imagen'
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
    Titulo = 'Im'#225'genes'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorImagen: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ge.Imagen'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Im'#225'gen Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object SeleccionFile: TSeleccionFile
    Left = 305
    Top = 214
  end
end
