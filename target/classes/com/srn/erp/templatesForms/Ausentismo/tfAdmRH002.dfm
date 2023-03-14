inherited FCertificacionProveedor: TFCertificacionProveedor
  Left = 326
  Top = 113
  Width = 953
  Height = 871
  Caption = 'Agrupador de Rotas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 937
    Height = 833
    inherited PPie: TPanel
      Top = 812
      Width = 937
      inherited StatusBarABM: TStatusBar
        Left = 832
      end
      inherited StatusBar2: TStatusBar
        Width = 832
      end
    end
    inherited PMenu: TPanel
      Width = 937
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupo
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupo
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited Panel2: TPanel
        Left = 896
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTGrupo
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
      Width = 937
    end
    inherited PCabecera: TPanel
      Width = 937
      Height = 61
      object Label1: TLabel
        Left = 32
        Top = 24
        Width = 37
        Height = 13
        Caption = 'Nombre'
      end
      object DBENOMBRE: TsnDBEdit
        Left = 92
        Top = 20
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTGrupo
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 15
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 397
      end
    end
    inherited PCuerpo: TPanel
      Top = 113
      Width = 937
      Height = 699
      object dxDBCotizacionesFecha: TdxDBGridSN
        Left = 0
        Top = 0
        Width = 937
        Height = 699
        Align = alClient
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBCotizacionesFechaDBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSRotas
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsBehavior.FocusFirstCellOnNewRecord = True
          OptionsBehavior.GoToNextCellOnEnter = True
          OptionsCustomize.ColumnFiltering = False
          OptionsCustomize.ColumnSorting = False
          OptionsData.Appending = True
          OptionsData.Deleting = False
          OptionsSelection.InvertSelect = False
          OptionsView.GroupByBox = False
          object dxDBCotizacionesFechaDBTableView1Column1: TcxGridDBColumn
            Caption = 'Codigo'
            DataBinding.FieldName = 'tracodigo'
            Width = 106
          end
          object dxDBCotizacionesFechaDBTableView1Column2: TcxGridDBColumn
            Caption = 'Descripcion'
            DataBinding.FieldName = 'tradescrip'
            Width = 287
          end
          object dxDBCotizacionesFechaDBTableView1Column3: TcxGridDBColumn
            Caption = 'Hora Inicio'
            DataBinding.FieldName = 'trahoraini'
            Width = 142
          end
          object dxDBCotizacionesFechaDBTableView1Column4: TcxGridDBColumn
            Caption = 'Hora Fin'
            DataBinding.FieldName = 'trahorafin'
            Width = 155
          end
          object dxDBCotizacionesFechaDBTableView1Column5: TcxGridDBColumn
            Caption = 'Seleccionar'
            DataBinding.FieldName = 'seleccionado'
            Width = 76
          end
        end
        object dxDBCotizacionesFechaLevel1: TcxGridLevel
          GridView = dxDBCotizacionesFechaDBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoRRHHRotas'
    OperGrabarObjeto = 'SaveGrupoRRHHRotas'
    CargaDataSets = <
      item
        DataSet = TGrupo
        TableName = 'TGrupo'
      end
      item
        DataSet = TRotas
        TableName = 'TRotas'
      end>
    BajaLogica = <
      item
        DataSet = TGrupo
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupo
    DataSetDet1 = TRotas
    Left = 488
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 528
    Top = 16
  end
  object TGrupo: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
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
    Left = 536
    Top = 227
    object TGrupooid_grupo: TIntegerField
      FieldName = 'oid_grupo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupotipo: TStringField
      FieldName = 'tipo'
      Size = 50
    end
    object TGruponombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TGrupoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTGrupo: TDataSource [4]
    DataSet = TGrupo
    Left = 568
    Top = 227
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 288
    Top = 224
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 376
    Top = 128
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TGrupo'
        FieldName = 'nombre'
        Source.Strings = (
          'begin'
          '  ValidadorGruposRRHH.Value := Sender.AsString;'
          '  ValidadorGruposRRHH.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TGrupo'
        Source.Strings = (
          'begin'
          '    Operacion.inicioOperacion();'
          '    Operacion.setOper('#39'TraerRotasByGrupoDet'#39');'
          
            '    Operacion.AddAtribute('#39'oid_padre'#39',TGrupo.FieldName('#39'oid_grup' +
            'o'#39').AsString);'
          '    Operacion.execute();'
          'end.')
      end>
    Left = 416
    Top = 259
  end
  inherited SaveArchivo: TSaveDialog
    Left = 416
    Top = 128
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 256
    Top = 224
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 808
    Top = 208
  end
  inherited PopUp: TsnPopUp
    Left = 409
    Top = 224
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 200
    Top = 123
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 248
    Top = 123
  end
  inherited TPathHelp: TsnTable
    Left = 760
    Top = 213
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 760
    Top = 59
  end
  object HelpGrupos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'admRRHH.Grupo'
    NroHelp = 101
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
    Titulo = 'Grupos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 18
    Top = 52
  end
  object ValidadorGruposRRHH: TValidador
    Operacion = Operacion
    NickNameObjLog = 'admRRHH.Grupo'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Certificaci'#243'n Existente'
    NroQuery = 0
    Cache = False
    Left = 56
    Top = 51
  end
  object TRotas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo'
        DataType = ftInteger
      end
      item
        Name = 'tracodigo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'tradescrip'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'trahoraini'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'trahorafin'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'seleccionado'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_grupo'
    IndexDefs = <
      item
        Name = 'TRotasIndex1'
        Fields = 'oid_grupo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo'
    MasterSource = DSTGrupo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 536
    Top = 301
    object TRotasoid: TIntegerField
      FieldName = 'oid'
    end
    object TRotasoid_grupo: TIntegerField
      FieldName = 'oid_grupo'
    end
    object TRotastracodigo: TStringField
      FieldName = 'tracodigo'
      Size = 100
    end
    object TRotastradescrip: TStringField
      FieldName = 'tradescrip'
      Size = 100
    end
    object TRotastrahoraini: TStringField
      FieldName = 'trahoraini'
      Size = 100
    end
    object TRotastrahorafin: TStringField
      FieldName = 'trahorafin'
      Size = 100
    end
    object TRotasseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSRotas: TDataSource
    DataSet = TRotas
    Left = 568
    Top = 299
  end
end
