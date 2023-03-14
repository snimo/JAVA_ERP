inherited FGrupoMaquinas: TFGrupoMaquinas
  Left = 82
  Top = 99
  Width = 760
  Height = 487
  Caption = 'Grupos de M'#225'quinas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 752
    Height = 453
    inherited PPie: TPanel
      Top = 432
      Width = 752
      inherited StatusBarABM: TStatusBar
        Left = 647
      end
      inherited StatusBar2: TStatusBar
        Width = 647
      end
    end
    inherited PMenu: TPanel
      Width = 752
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoMaquina
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoMaquina
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
        Left = 711
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTGrupoMaquina
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
      Width = 752
    end
    inherited PCabecera: TPanel
      Width = 752
      Height = 54
      object Label2: TLabel
        Left = 24
        Top = 24
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snDBEdit1: TsnDBEdit
        Left = 92
        Top = 20
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTGrupoMaquina
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 534
      end
    end
    inherited PCuerpo: TPanel
      Top = 106
      Width = 752
      Height = 326
      BorderWidth = 10
      object dxDBGridSN3: TdxDBGridSN
        Left = 10
        Top = 10
        Width = 732
        Height = 306
        Align = alClient
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBGridSN3DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSTGrupoMaquinaDet
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsBehavior.AlwaysShowEditor = True
          OptionsBehavior.FocusCellOnTab = True
          OptionsBehavior.FocusFirstCellOnNewRecord = True
          OptionsBehavior.GoToNextCellOnEnter = True
          OptionsBehavior.FocusCellOnCycle = True
          OptionsCustomize.ColumnFiltering = False
          OptionsData.Appending = True
          OptionsData.Deleting = False
          OptionsSelection.InvertSelect = False
          OptionsView.GroupByBox = False
          object dxDBGridSN3DBTableView1Column1: TcxGridDBColumn
            DataBinding.FieldName = 'orden'
            Visible = False
            SortIndex = 0
            SortOrder = soAscending
          end
          object dxDBGridCodPuerta: TcxGridDBColumn
            Caption = 'C'#243'digo'
            DataBinding.FieldName = 'cod_maquina'
            PropertiesClassName = 'TcxButtonEditProperties'
            Properties.Buttons = <
              item
                Default = True
                Kind = bkEllipsis
              end>
            Properties.ClickKey = 112
            HeaderAlignmentHorz = taCenter
            Width = 122
          end
          object dxDBGridSN3DBTableView1desc_valor_clasif: TcxGridDBColumn
            Caption = 'Descripci'#243'n'
            DataBinding.FieldName = 'desc_maquina'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Options.Focusing = False
            Width = 380
          end
          object dxDBGridSN3DBTableView1Column2: TcxGridDBColumn
            Caption = 'Activo'
            DataBinding.FieldName = 'activo'
            PropertiesClassName = 'TcxCheckBoxProperties'
            HeaderAlignmentHorz = taCenter
            Width = 53
          end
        end
        object dxDBGridSN3Level1: TcxGridLevel
          GridView = dxDBGridSN3DBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoMaquina'
    OperGrabarObjeto = 'SaveGrupoMaquina'
    CargaDataSets = <
      item
        DataSet = TGrupoMaquina
        TableName = 'TGrupoMaquina'
      end
      item
        DataSet = TGrupoMaquinaDet
        TableName = 'TGrupoMaquinaDet'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoMaquina
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoMaquina
    DataSetDet1 = TGrupoMaquinaDet
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TGrupoMaquina: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_maq'
        DataType = ftInteger
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
    Left = 648
    Top = 59
    object TGrupoMaquinaoid_grupo_maq: TIntegerField
      FieldName = 'oid_grupo_maq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoMaquinanombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TGrupoMaquinaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTGrupoMaquina: TDataSource [4]
    DataSet = TGrupoMaquina
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
        TableName = 'TGrupoMaquinaDet'
        FieldName = 'cod_maquina'
        Source.Strings = (
          'begin'
          '  ValidadorMaquina.Value := Sender.AsString;'
          '  ValidadorMaquina.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TGrupoMaquina'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'nombre'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el nombre ' +
            'del Grupo'#39');'
          'end.')
      end
      item
        TableName = 'TGrupoMaquinaDet'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_maquina'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la M'#225'quina' +
            #39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TGrupoMaquinaDet'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_grupo_maq'#39').AsInteger :='
          '    TGrupoMaquina.FieldName('#39'oid_grupo_maq'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridCodPuerta'
        Source.Strings = (
          'begin'
          '  HelpMaquinas.Mostrar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 192
    Top = 179
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 592
    Top = 43
  end
  object HelpGrupos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
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
        Visible = False
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
    Titulo = 'Grupos de M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGrupoMaquina: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Grupo de M'#225'quina duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TGrupoMaquinaDet: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_puerta'
        DataType = ftInteger
      end
      item
        Name = 'oid_puerta'
        DataType = ftInteger
      end
      item
        Name = 'cod_puerta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_puerta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_grupo_dest_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_dest_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_usuario'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'oid_grupo_maq_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_maq'
        DataType = ftInteger
      end
      item
        Name = 'oid_maquina'
        DataType = ftInteger
      end
      item
        Name = 'cod_maquina'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_maquina'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_grupo_maq;orden'
    IndexDefs = <
      item
        Name = 'TGrupoPuertaDetIndex1'
        Fields = 'oid_grupo_maq;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_maq'
    MasterSource = DSTGrupoMaquina
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Puerta Duplicada'
    Left = 648
    Top = 108
    object TGrupoMaquinaDetoid_grupo_maq_det: TIntegerField
      FieldName = 'oid_grupo_maq_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoMaquinaDetoid_grupo_maq: TIntegerField
      FieldName = 'oid_grupo_maq'
    end
    object TGrupoMaquinaDetoid_maquina: TIntegerField
      FieldName = 'oid_maquina'
    end
    object TGrupoMaquinaDetcod_maquina: TStringField
      FieldName = 'cod_maquina'
      Size = 50
    end
    object TGrupoMaquinaDetdesc_maquina: TStringField
      FieldName = 'desc_maquina'
      Size = 255
    end
    object TGrupoMaquinaDetactivo: TBooleanField
      FieldName = 'activo'
    end
    object TGrupoMaquinaDetorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSTGrupoMaquinaDet: TDataSource
    DataSet = TGrupoMaquinaDet
    Left = 680
    Top = 108
  end
  object HelpMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
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
        AsignarACampo = TGrupoMaquinaDetcod_maquina
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
    Titulo = 'M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 242
    Top = 239
  end
  object ValidadorMaquina: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.Maquina'
    MensajeException = 'Maquina Inexistente'
    CampoOID = TGrupoMaquinaDetoid_maquina
    CampoDescripcion = TGrupoMaquinaDetdesc_maquina
    NroQuery = 0
    Cache = True
    Left = 278
    Top = 239
  end
  object TAmbito: TsnTable
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
    Left = 152
    Top = 220
    object TAmbitocodigo: TStringField
      FieldName = 'codigo'
      Size = 1
    end
    object TAmbitodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSAmbito: TDataSource
    DataSet = TAmbito
    Left = 184
    Top = 220
  end
end
