inherited FCentroImputacion: TFCentroImputacion
  Top = 32
  Width = 664
  Height = 490
  Caption = 'Centros de Imputación'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 656
    Height = 456
    inherited PPie: TPanel
      Top = 435
      Width = 656
      inherited StatusBarABM: TStatusBar
        Left = 551
      end
      inherited StatusBar2: TStatusBar
        Width = 551
      end
    end
    inherited PMenu: TPanel
      Width = 656
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSCentroImputacion
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSCentroImputacion
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCentroImputacion
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCentroImputacion
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCentroImputacion
      end
      inherited Panel2: TPanel
        Left = 615
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSCentroImputacion
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
      Width = 656
    end
    inherited PCabecera: TPanel
      Width = 656
      Height = 74
      object Label1: TLabel
        Left = 24
        Top = 16
        Width = 33
        Height = 13
        Caption = 'Código'
      end
      object Label2: TLabel
        Left = 24
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripción'
      end
      object DBECodigo: TsnDBEdit
        Left = 108
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSCentroImputacion
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 165
      end
      object DBEDescripcion: TsnDBEdit
        Left = 108
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSCentroImputacion
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 453
      end
    end
    inherited PCuerpo: TPanel
      Top = 126
      Width = 656
      Height = 309
      BorderWidth = 20
      object PageControlSN1: TPageControlSN
        Left = 20
        Top = 20
        Width = 616
        Height = 269
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Clasificadores'
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 608
            Height = 241
            Align = alClient
            BorderWidth = 5
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            AllowInsert = False
            CriteriosPintarCelda = <>
            object cxGridDBTableView4: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSValoresClasificadores
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Deleting = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView4desc_grupo_clasif: TcxGridDBColumn
                Caption = 'Tipo'
                DataBinding.FieldName = 'desc_grupo_clasif'
                Visible = False
                GroupIndex = 0
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 106
              end
              object cxGridDBTableView4desc_clasificador: TcxGridDBColumn
                Caption = 'Clasificador'
                DataBinding.FieldName = 'desc_clasificador'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 144
              end
              object cxGridDBCodValClasif: TcxGridDBColumn
                Caption = 'Cód. Valor'
                DataBinding.FieldName = 'cod_valor'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 101
              end
              object cxGridDBTableView4desc_valor: TcxGridDBColumn
                Caption = 'Descripción Valor'
                DataBinding.FieldName = 'desc_valor'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 242
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCentroImputacion'
    OperGrabarObjeto = 'SaveCentroImputacion'
    CargaDataSets = <
      item
        DataSet = TCentroImputacion
        TableName = 'TCentroImputacion'
      end
      item
        DataSet = TValoresClasificadores
        TableName = 'TValoresClasificadores'
      end
      item
        DataSet = TClasificadorEntidad
        TableName = 'TClasificadorEntidad'
      end
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end>
    BajaLogica = <
      item
        DataSet = TCentroImputacion
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCentroImputacion
    DataSetDet1 = TValoresClasificadores
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCentroImputacion: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_centro_imputac'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'descripcion'
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
    Left = 544
    Top = 107
    object TCentroImputacionoid_centro_imputac: TIntegerField
      FieldName = 'oid_centro_imputac'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCentroImputacioncodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TCentroImputaciondescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TCentroImputacionactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSCentroImputacion: TDataSource [4]
    DataSet = TCentroImputacion
    Left = 576
    Top = 107
  end
  inherited TOidObjSave: TsnTable
    Left = 504
    Top = 64
  end
  inherited TOpcHabPrograma: TsnTable
    Left = 544
    Top = 64
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
        TableName = 'TCentroImputacion'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorCentroImputacion.Value := Sender.AsString;'
          '  ValidadorCentroImputacion.Validar;'
          'end.')
      end
      item
        TableName = 'TValoresClasificadores'
        FieldName = 'cod_valor'
        Source.Strings = (
          'begin'
          
            '   ValidarValorClasifEntidad(TValoresClasificadores.FieldName(''o' +
            'id_clasif_ent'').AsInteger,'
          '                                           Sender.AsString);'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure MostrarHelpValoresClasificador();'
          'begin'
          
            '   HelpValoresClasificador.NickName           :=  TValoresClasif' +
            'icadores.FieldName(''nickname'').AsString;'
          
            '   HelpValoresClasificador.NroClasificador    :=  TValoresClasif' +
            'icadores.FieldName(''nro_clasif'').AsInteger;'
          '   HelpValoresClasificador.Mostrar();'
          'end;'
          ''
          ''
          'procedure inicializarClasif();'
          'begin'
          '  TClasificadorEntidad.First;'
          '  while (not TClasificadorEntidad.EOF) do'
          '    begin'
          ''
          '    TValoresClasificadores.AppendRecord;'
          '    TValoresClasificadores.FieldName(''oid_centro'').AsInteger :='
          '       TCentroImputacion.FieldName(''oid_centro'').AsInteger;'
          
            '    TValoresClasificadores.FieldName(''oid_clasif_ent'').AsInteger' +
            ' :='
          
            '      TClasificadorEntidad.FieldName(''oid_clasif_ent'').AsInteger' +
            ';'
          '    TValoresClasificadores.FieldName(''nro_clasif'').AsInteger :='
          '       TClasificadorEntidad.FieldName(''nro_clasif'').AsInteger;'
          
            '    TValoresClasificadores.FieldName(''desc_grupo_clasif'').AsStri' +
            'ng :='
          
            '       TClasificadorEntidad.FieldName(''desc_grupo_clasif'').AsStr' +
            'ing;'
          '    TValoresClasificadores.FieldName(''nickname'').AsString :='
          '      TClasificadorEntidad.FieldName(''nickname'').AsString;'
          
            '    TValoresClasificadores.FieldName(''activo'').AsBoolean := True' +
            ';'
          
            '    TValoresClasificadores.FieldName(''desc_clasificador'').AsStri' +
            'ng :='
          '      TClasificadorEntidad.FieldName(''descripcion'').AsString;'
          '    TValoresClasificadores.PostRecord;'
          ''
          '    TClasificadorEntidad.Next;'
          '    end;'
          ''
          'end;'
          ''
          'procedure inicializarValoresClasif();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper(''TraerCentroImputacion'');'
          '  operacion.addAtribute(''inicializarClasificadores'','''');'
          '  operacion.execute;'
          ''
          '  inicializarClasif();'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEntidad(OidClasifEnt : integer ;'
          
            '                                                        codigo :' +
            ' string);'
          'begin'
          ''
          '  if (codigo = '''')'
          '     then begin'
          '             TValoresClasificadores.EditRecord;'
          
            '             TValoresClasificadores.FieldName(''oid_val_clasif_en' +
            't'').AsInteger := 0;'
          
            '             TValoresClasificadores.FieldName(''desc_valor'').AsSt' +
            'ring := '''';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper(''TraerValorClasifEntidad'');'
          
            '  operacion.addAtribute(''oid_clasif_ent'',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute(''codigo'',codigo);'
          '  operacion.execute;'
          ''
          '  TValoresClasificadores.EditRecord;'
          
            '  TValoresClasificadores.FieldName(''oid_val_clasif_ent'').AsInteg' +
            'er :='
          
            '       TValorClaifEntidad.FieldName(''oid_valor_clasif_ent'').AsIn' +
            'teger;'
          '  TValoresClasificadores.FieldName(''desc_valor'').AsString :='
          '      TValorClaifEntidad.FieldName(''descripcion'').AsString;'
          ''
          'end;'
          ''
          '')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  inicializarValoresClasif();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBCodValClasif'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasificador();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpCentroImputacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'co.CentroImputacion'
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
    Titulo = 'Centros de Imputación'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorCentroImputacion: TValidador
    Operacion = Operacion
    NickNameObjLog = 'co.CentroImputacion'
    WhenRaiseException = teFound
    MensajeException = 'Código de Centro de Imputación Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TValoresClasificadores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'oid_centro'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif'
        DataType = ftInteger
      end
      item
        Name = 'desc_grupo_clasif'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cod_valor'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'desc_valor'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nickname'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'desc_clasificador'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_centro'
    IndexDefs = <
      item
        Name = 'TValoresClasificadoresIndex1'
        Fields = 'oid_centro'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_centro_imputac'
    MasterSource = DSCentroImputacion
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 374
    Top = 236
    object TValoresClasificadoresoid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoresoid_centro: TIntegerField
      FieldName = 'oid_centro'
    end
    object TValoresClasificadoresoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TValoresClasificadoresoid_val_clasif_ent: TIntegerField
      FieldName = 'oid_val_clasif_ent'
    end
    object TValoresClasificadoresnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TValoresClasificadoresdesc_grupo_clasif: TStringField
      FieldName = 'desc_grupo_clasif'
      Size = 100
    end
    object TValoresClasificadorescod_valor: TStringField
      FieldName = 'cod_valor'
      Size = 30
    end
    object TValoresClasificadoresdesc_valor: TStringField
      FieldName = 'desc_valor'
      Size = 100
    end
    object TValoresClasificadoresnickname: TStringField
      FieldName = 'nickname'
      Size = 50
    end
    object TValoresClasificadoresactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValoresClasificadoresdesc_clasificador: TStringField
      FieldName = 'desc_clasificador'
      Size = 100
    end
  end
  object DSValoresClasificadores: TDataSource
    DataSet = TValoresClasificadores
    Left = 406
    Top = 236
  end
  object HelpValoresClasificador: THelpValoresClasificador
    AsignarCampoCodigo = TValoresClasificadorescod_valor
    NroClasificador = 0
    Left = 200
    Top = 217
  end
  object TClasificadorEntidad: TsnTable
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
    Left = 525
    Top = 224
    object TClasificadorEntidadoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TClasificadorEntidadcodigo: TStringField
      FieldName = 'codigo'
    end
    object TClasificadorEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TClasificadorEntidadnickname: TStringField
      FieldName = 'nickname'
      Size = 30
    end
    object TClasificadorEntidadobligatorio: TBooleanField
      FieldName = 'obligatorio'
    end
    object TClasificadorEntidadactivo: TBooleanField
      FieldName = 'activo'
    end
    object TClasificadorEntidadnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TClasificadorEntidadoid_grupo_clasif: TIntegerField
      FieldName = 'oid_grupo_clasif'
    end
    object TClasificadorEntidadcod_grupo_clasif: TStringField
      FieldName = 'cod_grupo_clasif'
      Size = 50
    end
    object TClasificadorEntidaddesc_grupo_clasif: TStringField
      FieldName = 'desc_grupo_clasif'
      Size = 100
    end
  end
  object TValorClaifEntidad: TsnTable
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
    Left = 470
    Top = 204
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
end
