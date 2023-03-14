inherited FGrupoPuerta: TFGrupoPuerta
  Left = 109
  Top = 115
  Width = 873
  Height = 542
  Caption = 'Grupo de Puntos de Acceso'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 857
    Height = 504
    inherited PPie: TPanel
      Top = 483
      Width = 857
      inherited StatusBarABM: TStatusBar
        Left = 752
      end
      inherited StatusBar2: TStatusBar
        Width = 752
      end
    end
    inherited PMenu: TPanel
      Width = 857
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoPuerta
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoPuerta
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupoPutnosAcceso
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupoPutnosAcceso
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupoPutnosAcceso
      end
      inherited Panel2: TPanel
        Left = 816
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTGrupoPuerta
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
      Width = 857
    end
    inherited PCabecera: TPanel
      Width = 857
      Height = 125
      object Label1: TLabel
        Left = 40
        Top = 32
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 72
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTGrupoPuerta
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 68
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTGrupoPuerta
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 120
        Top = 104
        Caption = 'Grupo de puertas habilitado para cacheo'
        DataBinding.DataField = 'es_para_cacheo'
        DataBinding.DataSource = DSTGrupoPuerta
        TabOrder = 2
        Width = 217
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 372
        Top = 104
        Caption = 'Utilizar para ingreso de Visitas'
        DataBinding.DataField = 'hab_para_ing_vis'
        DataBinding.DataSource = DSTGrupoPuerta
        TabOrder = 3
        Width = 217
      end
    end
    inherited PCuerpo: TPanel
      Top = 177
      Width = 857
      Height = 306
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 837
        Height = 286
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          BorderWidth = 5
          Caption = 'Puertas que integran el punto de Acceso         '
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 819
            Height = 248
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN3DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSGrupoPuertaDet
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
                DataBinding.FieldName = 'cod_puerta'
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
                DataBinding.FieldName = 'desc_puerta'
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
        object TabSheet2: TTabSheet
          BorderWidth = 5
          Caption = 'Perfiles Habilitados para otorgar permisos       '
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 819
            Height = 248
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSPerfilGrupoPuerta
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
            end
            object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSPerfilGrupoPuerta
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              Bands = <
                item
                  Caption = 'Perfil'
                  Width = 447
                end
                item
                  Caption = 'Habilitar'
                  Width = 171
                end
                item
                  Caption = 'Denegar'
                  Width = 163
                end>
              object dxDBGridSN1DBBandedTableView1cod_perfil_func: TcxGridDBBandedColumn
                Caption = 'Nombre del Perfil'
                DataBinding.FieldName = 'desc_perfil_func'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 297
                Position.BandIndex = 0
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1desc_perfil_func: TcxGridDBBandedColumn
                Caption = 'Perfil'
                DataBinding.FieldName = 'cod_perfil_func'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                HeaderAlignmentHorz = taCenter
                Width = 102
                Position.BandIndex = 0
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1activo: TcxGridDBBandedColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 48
                Position.BandIndex = 0
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1hab_ing: TcxGridDBBandedColumn
                Caption = 'Ingreso'
                DataBinding.FieldName = 'hab_ing'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 1
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1hab_egr: TcxGridDBBandedColumn
                Caption = 'Egreso'
                DataBinding.FieldName = 'hab_egr'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 1
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1hab_ambos: TcxGridDBBandedColumn
                Caption = 'Ing. / Egr.'
                DataBinding.FieldName = 'hab_ambos'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 1
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1den_ing: TcxGridDBBandedColumn
                Caption = 'Ingreso'
                DataBinding.FieldName = 'den_ing'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 2
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1den_egr: TcxGridDBBandedColumn
                Caption = 'Egreso'
                DataBinding.FieldName = 'den_egr'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 2
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1den_ambos: TcxGridDBBandedColumn
                Caption = 'Ing. / Egr.'
                DataBinding.FieldName = 'den_ambos'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Position.BandIndex = 2
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = dxDBGridSN1DBBandedTableView1
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoPuerta'
    OperGrabarObjeto = 'SaveGrupoPuerta'
    CargaDataSets = <
      item
        DataSet = TGrupoPuerta
        TableName = 'TGrupoPuerta'
      end
      item
        DataSet = TGrupoPuertaDet
        TableName = 'TGrupoPuertaDet'
      end
      item
        DataSet = TPerfilGrupoPuerta
        TableName = 'TPerfilGrupoPuerta'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoPuerta
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoPuerta
    DataSetDet1 = TGrupoPuertaDet
    DataSetDet2 = TPerfilGrupoPuerta
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TGrupoPuerta: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_puerta'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'es_para_cacheo'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'hab_para_ing_vis'
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
    object TGrupoPuertaoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoPuertacodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TGrupoPuertadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TGrupoPuertaes_para_cacheo: TBooleanField
      FieldName = 'es_para_cacheo'
    end
    object TGrupoPuertaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TGrupoPuertahab_para_ing_vis: TBooleanField
      FieldName = 'hab_para_ing_vis'
    end
  end
  object DSTGrupoPuerta: TDataSource [4]
    DataSet = TGrupoPuerta
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
        TableName = 'TGrupoPuerta'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoPuerta.Value := Sender.AsString;'
          '  ValidadorGrupoPuerta.Validar;'
          'end.')
      end
      item
        TableName = 'TGrupoPuertaDet'
        FieldName = 'cod_puerta'
        Source.Strings = (
          'begin'
          '  ValidadorPuerta.Value := Sender.AsString;'
          '  ValidadorPuerta.Validar;'
          'end.')
      end
      item
        TableName = 'TPerfilGrupoPuerta'
        FieldName = 'cod_perfil_func'
        Source.Strings = (
          'begin'
          '  ValidadorPerfil.Value := Sender.AsString;'
          '  ValidadorPerfil.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TGrupoPuertaDet'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_puerta'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la puerta'#39 +
            ');'
          'end.')
      end
      item
        TableName = 'TPerfilGrupoPuerta'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_perfil_func'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Perfil ' +
            'Funcional'#39');  '
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TGrupoPuertaDet'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_grupo_puerta'#39').AsInteger :='
          '    TGrupoPuerta.FieldName('#39'oid_grupo_puerta'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TGrupoPuerta'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'es_para_cacheo'#39').AsBoolean := false;'
          'end.')
      end
      item
        TableName = 'TPerfilGrupoPuerta'
        Source.Strings = (
          'begin'
          ''
          
            '   DataSet.FieldName('#39'oid_grupo_puerta'#39').Value := TGrupoPuerta.F' +
            'ieldName('#39'oid_grupo_puerta'#39').AsInteger;'
          '   DataSet.FieldName('#39'activo'#39').Value := True;'
          ''
          '  DataSet.FieldName('#39'hab_ing'#39').Value := false;'
          '  DataSet.FieldName('#39'hab_egr'#39').Value := false;'
          '  DataSet.FieldName('#39'hab_ambos'#39').Value := false;'
          '  DataSet.FieldName('#39'den_ing'#39').Value := false;'
          '  DataSet.FieldName('#39'den_egr'#39').Value := false;'
          '  DataSet.FieldName('#39'den_ambos'#39').Value := false;'
          ''
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridCodPuerta'
        Source.Strings = (
          'begin'
          '  HelpPuerta.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'dxDBGridSN1DBBandedTableView1desc_perfil_func'
        Source.Strings = (
          'begin'
          '  HelpPerfiles.Mostrar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 272
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 520
    Top = 280
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 56
    Top = 131
  end
  object HelpGrupoPutnosAcceso: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGrupoPuerta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Punto de Acceso duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TGrupoPuertaDet: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_det'
        DataType = ftInteger
      end
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
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_grupo_puerta;orden'
    IndexDefs = <
      item
        Name = 'TGrupoPuertaDetIndex1'
        Fields = 'oid_grupo_puerta;orden'
      end
      item
        Name = 'TGrupoPuertaDetIndex2'
        Fields = 'cod_puerta'
        Options = [ixUnique]
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_puerta'
    MasterSource = DSTGrupoPuerta
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Puerta Duplicada'
    Left = 648
    Top = 100
    object TGrupoPuertaDetoid_grupo_det: TIntegerField
      FieldName = 'oid_grupo_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoPuertaDetoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TGrupoPuertaDetoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TGrupoPuertaDetcod_puerta: TStringField
      FieldName = 'cod_puerta'
      Size = 50
    end
    object TGrupoPuertaDetdesc_puerta: TStringField
      FieldName = 'desc_puerta'
      Size = 100
    end
    object TGrupoPuertaDetorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
    object TGrupoPuertaDetactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSGrupoPuertaDet: TDataSource
    DataSet = TGrupoPuertaDet
    Left = 680
    Top = 100
  end
  object HelpPuerta: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
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
        AsignarACampo = TGrupoPuertaDetcod_puerta
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
    Titulo = 'Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 210
    Top = 271
  end
  object ValidadorPuerta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    MensajeException = 'C'#243'digo de Puerta Inexistente'
    CampoOID = TGrupoPuertaDetoid_puerta
    CampoDescripcion = TGrupoPuertaDetdesc_puerta
    NroQuery = 0
    Cache = True
    Left = 246
    Top = 271
  end
  object TPerfilGrupoPuerta: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_per_gru_pue'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_puerta'
        DataType = ftInteger
      end
      item
        Name = 'oid_perfil_func'
        DataType = ftInteger
      end
      item
        Name = 'hab_ing'
        DataType = ftBoolean
      end
      item
        Name = 'hab_egr'
        DataType = ftBoolean
      end
      item
        Name = 'hab_ambos'
        DataType = ftBoolean
      end
      item
        Name = 'den_ing'
        DataType = ftBoolean
      end
      item
        Name = 'den_egr'
        DataType = ftBoolean
      end
      item
        Name = 'den_ambos'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_grupo_puerta;orden'
    IndexDefs = <
      item
        Name = 'TPerfilGrupoPuertaIndex1'
        Fields = 'oid_grupo_puerta;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_puerta'
    MasterSource = DSTGrupoPuerta
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 584
    Top = 148
    object TPerfilGrupoPuertaoid_per_gru_pue: TIntegerField
      FieldName = 'oid_per_gru_pue'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPerfilGrupoPuertaoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TPerfilGrupoPuertahab_ing: TBooleanField
      FieldName = 'hab_ing'
    end
    object TPerfilGrupoPuertahab_egr: TBooleanField
      FieldName = 'hab_egr'
    end
    object TPerfilGrupoPuertahab_ambos: TBooleanField
      FieldName = 'hab_ambos'
    end
    object TPerfilGrupoPuertaden_ing: TBooleanField
      FieldName = 'den_ing'
    end
    object TPerfilGrupoPuertaden_egr: TBooleanField
      FieldName = 'den_egr'
    end
    object TPerfilGrupoPuertaden_ambos: TBooleanField
      FieldName = 'den_ambos'
    end
    object TPerfilGrupoPuertaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TPerfilGrupoPuertaoid_perfil_func: TIntegerField
      FieldName = 'oid_perfil_func'
    end
    object TPerfilGrupoPuertadesc_perfil_func: TStringField
      FieldName = 'desc_perfil_func'
      Size = 100
    end
    object TPerfilGrupoPuertacod_perfil_func: TStringField
      FieldName = 'cod_perfil_func'
      Size = 50
    end
    object TPerfilGrupoPuertaorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSPerfilGrupoPuerta: TDataSource
    DataSet = TPerfilGrupoPuerta
    Left = 624
    Top = 148
  end
  object HelpPerfiles: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.PerfilFuncional'
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
        Longitud = 50
        Visible = True
        AsignarACampo = TPerfilGrupoPuertacod_perfil_func
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
    Titulo = 'Perfiles Funcionales'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 210
    Top = 308
  end
  object ValidadorPerfil: TValidador
    Operacion = Operacion
    NickNameObjLog = 'se.PerfilFuncional'
    MensajeException = 'C'#243'digo de Perfil Inexistente'
    CampoOID = TPerfilGrupoPuertaoid_perfil_func
    CampoDescripcion = TPerfilGrupoPuertadesc_perfil_func
    NroQuery = 0
    Cache = True
    Left = 246
    Top = 308
  end
end
