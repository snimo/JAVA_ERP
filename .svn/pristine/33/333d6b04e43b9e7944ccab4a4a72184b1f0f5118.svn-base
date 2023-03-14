inherited FMotivosNovCIP: TFMotivosNovCIP
  Left = 94
  Top = 104
  Caption = 'Motivos Novedades'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivosNovCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivosNovCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMotivosNovCIP
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
      Height = 350
      object Label1: TLabel
        Left = 40
        Top = 24
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 64
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snLabel1: TsnLabel
        Left = 56
        Top = 168
        Width = 114
        Height = 13
        Caption = 'Comportamiento Ingreso'
      end
      object snLabel2: TsnLabel
        Left = 400
        Top = 168
        Width = 112
        Height = 13
        Caption = 'Comportamiento Egreso'
      end
      object Label3: TLabel
        Left = 56
        Top = 272
        Width = 107
        Height = 13
        Caption = 'Minutos Entrada Antes'
      end
      object Label4: TLabel
        Left = 56
        Top = 304
        Width = 122
        Height = 13
        Caption = 'Minutos Entrada Despu'#233's'
      end
      object snLabel3: TsnLabel
        Left = 40
        Top = 136
        Width = 87
        Height = 13
        Caption = 'Para el Ingreso'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold, fsUnderline]
        ParentFont = False
      end
      object snLabel4: TsnLabel
        Left = 376
        Top = 136
        Width = 84
        Height = 13
        Caption = 'Para el Egreso'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold, fsUnderline]
        ParentFont = False
      end
      object Label5: TLabel
        Left = 57
        Top = 201
        Width = 66
        Height = 13
        Caption = 'Horario desde'
      end
      object Label6: TLabel
        Left = 198
        Top = 201
        Width = 26
        Height = 13
        Caption = 'hasta'
      end
      object Label7: TLabel
        Left = 401
        Top = 204
        Width = 66
        Height = 13
        Caption = 'Horario desde'
        Visible = False
      end
      object Label8: TLabel
        Left = 550
        Top = 204
        Width = 26
        Height = 13
        Caption = 'hasta'
        Visible = False
      end
      object snLabel5: TsnLabel
        Left = 40
        Top = 240
        Width = 302
        Height = 13
        Caption = 'Impacto en la rota Planificada del d'#237'a de la Novedad'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold, fsUnderline]
        ParentFont = False
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 36
        Top = 96
        Caption = 'Mostrar en habilitaciones Manuales?'
        DataBinding.DataField = 'hab_para_ingreso'
        DataBinding.DataSource = DSTMotivosNovCIP
        TabOrder = 2
        Width = 269
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 332
        Top = 95
        Caption = 'Mostrar en inhabilitaciones Manuales?'
        DataBinding.DataField = 'hab_para_egreso'
        DataBinding.DataSource = DSTMotivosNovCIP
        TabOrder = 3
        Width = 269
      end
      object snDBLookup1: TsnDBLookup
        Left = 184
        Top = 164
        DataBinding.DataField = 'compo_ext_ing'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        TabOrder = 4
        Width = 145
      end
      object snDBLookup2: TsnDBLookup
        Left = 520
        Top = 164
        DataBinding.DataField = 'compo_ext_egr'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        TabOrder = 10
        Width = 145
      end
      object snDBEdit2: TsnDBEdit
        Left = 256
        Top = 268
        DataBinding.DataField = 'min_ent_ant'
        DataBinding.DataSource = DSTMotivosNovCIP
        TabOrder = 7
        Width = 81
      end
      object snDBEdit3: TsnDBEdit
        Left = 256
        Top = 300
        DataBinding.DataField = 'min_ent_des'
        DataBinding.DataSource = DSTMotivosNovCIP
        TabOrder = 8
        Width = 81
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 52
        Top = 333
        Caption = 'Anula Rota del D'#237'a'
        DataBinding.DataField = 'anula_rota_del_dia'
        DataBinding.DataSource = DSTMotivosNovCIP
        TabOrder = 9
        Width = 133
      end
      object DBHorarioDesde: TsnDBMaskEdit
        Left = 132
        Top = 197
        DataBinding.DataField = 'hora_desde_ing'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        TabOrder = 5
        Width = 57
      end
      object snDBMaskEdit1: TsnDBMaskEdit
        Left = 233
        Top = 197
        DataBinding.DataField = 'hora_hasta_ing'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        TabOrder = 6
        Width = 57
      end
      object snDBMaskEdit2: TsnDBMaskEdit
        Left = 484
        Top = 200
        DataBinding.DataField = 'hora_desde_egr'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        TabOrder = 11
        Visible = False
        Width = 57
      end
      object snDBMaskEdit3: TsnDBMaskEdit
        Left = 585
        Top = 200
        DataBinding.DataField = 'hora_hasta_egr'
        DataBinding.DataSource = DSTMotivosNovCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        TabOrder = 12
        Visible = False
        Width = 57
      end
    end
    inherited PCuerpo: TPanel
      Top = 402
      Height = 189
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 701
        Height = 169
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Equivalencias Externas de C'#243'digos'
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 693
            Height = 141
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN3DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Enabled = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSMotiEquivCIP
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
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object dxDBGridSN3DBTableView1Column1: TcxGridDBColumn
                DataBinding.FieldName = 'orden'
                Visible = False
                SortIndex = 0
                SortOrder = soAscending
              end
              object dxDBGridCodPuerta: TcxGridDBColumn
                Caption = 'C'#243'digo'
                DataBinding.FieldName = 'codigo_externo'
                HeaderAlignmentHorz = taCenter
                Width = 177
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
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMotivosNovCIP'
    OperGrabarObjeto = 'SaveMotivosNovCIP'
    CargaDataSets = <
      item
        DataSet = TMotivosNovCIP
        TableName = 'TMotivosNovCIP'
      end
      item
        DataSet = TMotivosEquivCIP
        TableName = 'TMotivosEquivCIP'
      end
      item
        DataSet = TTiposEntradas
        TableName = 'TTiposEntradas'
      end
      item
        DataSet = TTiposSalidas
        TableName = 'TTiposSalidas'
      end>
    BajaLogica = <
      item
        DataSet = TMotivosNovCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMotivosNovCIP
    DataSetDet1 = TMotivosEquivCIP
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMotivosNovCIP: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_motivo'
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
    object TMotivosNovCIPoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivosNovCIPcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TMotivosNovCIPdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivosNovCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TMotivosNovCIPhab_para_ingreso: TBooleanField
      FieldName = 'hab_para_ingreso'
    end
    object TMotivosNovCIPhab_para_egreso: TBooleanField
      FieldName = 'hab_para_egreso'
    end
    object TMotivosNovCIPcompo_ext_ing: TStringField
      FieldName = 'compo_ext_ing'
    end
    object TMotivosNovCIPcompo_ext_egr: TStringField
      FieldName = 'compo_ext_egr'
    end
    object TMotivosNovCIPmin_ent_ant: TIntegerField
      FieldName = 'min_ent_ant'
    end
    object TMotivosNovCIPmin_ent_des: TIntegerField
      FieldName = 'min_ent_des'
    end
    object TMotivosNovCIPanula_rota_del_dia: TBooleanField
      FieldName = 'anula_rota_del_dia'
    end
    object TMotivosNovCIPhora_desde_ing: TStringField
      FieldName = 'hora_desde_ing'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivosNovCIPhora_hasta_ing: TStringField
      FieldName = 'hora_hasta_ing'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivosNovCIPhora_desde_egr: TStringField
      FieldName = 'hora_desde_egr'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivosNovCIPhora_hasta_egr: TStringField
      FieldName = 'hora_hasta_egr'
      EditMask = '!90:00;1;_'
      Size = 5
    end
  end
  object DSTMotivosNovCIP: TDataSource [4]
    DataSet = TMotivosNovCIP
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
        TableName = 'TMotivosNovCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorMotivo.Value := Sender.AsString;'
          '  ValidadorMotivo.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMotivosEquivCIP'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_motivo'#39').AsInteger :='
          '    TMotivosNovCIP.FieldName('#39'oid_motivo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivosNovCIP'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'anula_rota_del_dia'#39').AsBoolean := False;'
          '  DataSet.FieldName('#39'hab_para_ingreso'#39').AsBoolean := False;'
          '  DataSet.FieldName('#39'hab_para_egreso'#39').AsBoolean := False;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTiposEntradas();'
          '  TraerTiposSalidas();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTiposEntradas();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposEntradasRotas'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerTiposSalidas();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerTiposSalidasRotas'#39');'
          '   operacion.execute();'
          'end;')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 336
    Top = 104
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 104
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 512
    Top = 304
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 256
    Top = 115
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivosNovCIP'
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
    Titulo = 'Motivos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMotivo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivosNovCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Motivo duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TMotivosEquivCIP: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mot_equiv'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'codigo_externo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_motivo'
    IndexDefs = <
      item
        Name = 'TMotivosEquivCIPIndex2'
        Fields = 'oid_motivo;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_motivo'
    MasterSource = DSTMotivosNovCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 100
    object TMotivosEquivCIPoid_mot_equiv: TIntegerField
      FieldName = 'oid_mot_equiv'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivosEquivCIPoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TMotivosEquivCIPcodigo_externo: TStringField
      FieldName = 'codigo_externo'
      Size = 50
    end
    object TMotivosEquivCIPactivo: TBooleanField
      FieldName = 'activo'
    end
    object TMotivosEquivCIPorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSMotiEquivCIP: TDataSource
    DataSet = TMotivosEquivCIP
    Left = 680
    Top = 100
  end
  object TTiposEntradas: TsnTable
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
    Left = 390
    Top = 325
    object TTiposEntradascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposEntradasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TTiposSalidas: TsnTable
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
    Left = 486
    Top = 325
    object TTiposSalidascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposSalidasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposEntradas: TDataSource
    DataSet = TTiposEntradas
    Left = 422
    Top = 325
  end
  object DSTiposSalidas: TDataSource
    DataSet = TTiposSalidas
    Left = 518
    Top = 325
  end
end
