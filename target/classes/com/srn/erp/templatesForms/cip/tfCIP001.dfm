inherited FRotas: TFRotas
  Left = 34
  Top = 103
  Width = 908
  Height = 625
  Caption = 'Rotas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 892
    Height = 587
    inherited PPie: TPanel
      Top = 566
      Width = 892
      inherited StatusBarABM: TStatusBar
        Left = 787
      end
      inherited StatusBar2: TStatusBar
        Width = 787
      end
    end
    inherited PMenu: TPanel
      Width = 892
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRotas
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRotas
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpRotas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpRotas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpRotas
      end
      inherited Panel2: TPanel
        Left = 851
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRotas
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
      Width = 892
    end
    inherited PCabecera: TPanel
      Width = 892
      Height = 308
      object Label1: TLabel
        Left = 32
        Top = 32
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 32
        Top = 72
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snLabel1: TsnLabel
        Left = 32
        Top = 152
        Width = 60
        Height = 13
        Caption = 'Tipo entrada'
      end
      object snLabel2: TsnLabel
        Left = 488
        Top = 152
        Width = 51
        Height = 13
        Caption = 'Tipo salida'
      end
      object Label3: TLabel
        Left = 33
        Top = 188
        Width = 66
        Height = 13
        Caption = 'Horario desde'
      end
      object Label6: TLabel
        Left = 489
        Top = 186
        Width = 63
        Height = 13
        Caption = 'Horario hasta'
      end
      object Label4: TLabel
        Left = 32
        Top = 224
        Width = 105
        Height = 13
        Caption = 'Minutos entrada antes'
      end
      object Label7: TLabel
        Left = 488
        Top = 222
        Width = 96
        Height = 13
        Caption = 'Minutos salida antes'
      end
      object Label5: TLabel
        Left = 32
        Top = 258
        Width = 119
        Height = 13
        Caption = 'Minutos entrada despu'#233's'
      end
      object Label8: TLabel
        Left = 488
        Top = 256
        Width = 110
        Height = 13
        Caption = 'Minutos salida despu'#233's'
      end
      object snLabel3: TsnLabel
        Left = 32
        Top = 292
        Width = 96
        Height = 13
        Caption = 'Leyenda No Ingresa'
      end
      object snLabel4: TsnLabel
        Left = 488
        Top = 289
        Width = 94
        Height = 13
        Caption = 'Leyenda No Egresa'
      end
      object snLabel5: TsnLabel
        Left = 32
        Top = 112
        Width = 113
        Height = 20
        AutoSize = False
        Caption = '   ENTRADA   '
        Color = clGreen
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWhite
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel6: TsnLabel
        Left = 488
        Top = 112
        Width = 113
        Height = 20
        AutoSize = False
        Caption = '   SALIDA   '
        Color = clGreen
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWhite
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRotas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 68
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRotas
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 565
      end
      object DBTipoEntrada: TsnDBLookup
        Left = 156
        Top = 148
        DataBinding.DataField = 'tipo_acceso'
        DataBinding.DataSource = DSTRotas
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        TabOrder = 2
        Width = 145
      end
      object DBTipoSalida: TsnDBLookup
        Left = 612
        Top = 148
        DataBinding.DataField = 'tipo_egreso'
        DataBinding.DataSource = DSTRotas
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        TabOrder = 7
        Width = 145
      end
      object DBHorarioDesde: TsnDBMaskEdit
        Left = 156
        Top = 184
        DataBinding.DataField = 'horario_desde'
        DataBinding.DataSource = DSTRotas
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        TabOrder = 3
        Width = 57
      end
      object DBHorarioHasta: TsnDBMaskEdit
        Left = 612
        Top = 182
        DataBinding.DataField = 'horario_hasta'
        DataBinding.DataSource = DSTRotas
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        TabOrder = 8
        Width = 57
      end
      object DBMinSalAntes: TsnDBEdit
        Left = 612
        Top = 218
        DataBinding.DataField = 'min_sal_antes'
        DataBinding.DataSource = DSTRotas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 9
        Width = 37
      end
      object DBMinEntAntes: TsnDBEdit
        Left = 156
        Top = 220
        DataBinding.DataField = 'min_ent_antes'
        DataBinding.DataSource = DSTRotas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 37
      end
      object DBMinEntDesp: TsnDBEdit
        Left = 156
        Top = 254
        DataBinding.DataField = 'min_ent_desp'
        DataBinding.DataSource = DSTRotas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 5
        Width = 37
      end
      object DBMinSalDespues: TsnDBEdit
        Left = 612
        Top = 252
        DataBinding.DataField = 'min_sal_despues'
        DataBinding.DataSource = DSTRotas
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 10
        Width = 37
      end
      object DBLeyendaNoIngresa: TsnDBEdit
        Left = 156
        Top = 288
        DataBinding.DataField = 'ley_no_ingresa'
        DataBinding.DataSource = DSTRotas
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 6
        Width = 245
      end
      object DBLeyendaNoEgresa: TsnDBEdit
        Left = 612
        Top = 286
        DataBinding.DataField = 'ley_no_egresa'
        DataBinding.DataSource = DSTRotas
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 11
        Width = 268
      end
    end
    inherited PCuerpo: TPanel
      Top = 360
      Width = 892
      Height = 206
      BorderWidth = 20
      object PageControlSN1: TPageControlSN
        Left = 20
        Top = 20
        Width = 852
        Height = 166
        ActivePage = TabSheet3
        Align = alClient
        TabOrder = 0
        object TabSheet3: TTabSheet
          BorderWidth = 5
          Caption = 'Motivos Entradas Intermedias'
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 834
            Height = 128
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSMotivoEntradasInterRota
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
              object cxGridDBTableView1oid_motivo: TcxGridDBColumn
                Caption = 'Motivo'
                DataBinding.FieldName = 'oid_motivo'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSMotivos
                HeaderAlignmentHorz = taCenter
                Width = 187
              end
              object cxGridDBTableView1horario_desde: TcxGridDBColumn
                Caption = 'Hora Desde'
                DataBinding.FieldName = 'horario_desde'
                HeaderAlignmentHorz = taCenter
                Width = 82
              end
              object cxGridDBTableView1horario_hasta: TcxGridDBColumn
                Caption = 'Hora Hasta'
                DataBinding.FieldName = 'horario_hasta'
                HeaderAlignmentHorz = taCenter
                Width = 87
              end
              object cxGridDBTableView1Column1: TcxGridDBColumn
                Caption = 'Acceso'
                DataBinding.FieldName = 'asignacion'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'codigo'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSTCompoEntInter
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object cxGridDBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 52
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object TabSheet1: TTabSheet
          Caption = 'Equivalencias'
          object PageControlSN2: TPageControlSN
            Left = 0
            Top = 0
            Width = 852
            Height = 142
            Align = alClient
            TabOrder = 0
          end
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 852
            Height = 142
            Align = alClient
            BorderWidth = 5
            TabOrder = 1
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN3DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSEquivalenciaRotasCIP
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
    OperTraerObjeto = 'TraerRota'
    OperGrabarObjeto = 'SaveRota'
    CargaDataSets = <
      item
        DataSet = TRotas
        TableName = 'TRotas'
      end
      item
        DataSet = TTiposEntradas
        TableName = 'TTiposEntradas'
      end
      item
        DataSet = TTiposSalidas
        TableName = 'TTiposSalidas'
      end
      item
        DataSet = TEquivalenciaRotasCIP
        TableName = 'TEquivalenciaRotasCIP'
      end
      item
        DataSet = TMotivoEntradasInterRota
        TableName = 'TMotivoEntradasInterRota'
      end
      item
        DataSet = TCompoEntInter
        TableName = 'TCompoEntInter'
      end>
    BajaLogica = <
      item
        DataSet = TRotas
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRotas
    DataSetDet1 = TEquivalenciaRotasCIP
    DataSetDet2 = TMotivoEntradasInterRota
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRotas: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rota'
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
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_antes'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_desp'
        DataType = ftInteger
      end
      item
        Name = 'tipo_acceso'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_egreso'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'min_sal_despues'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_antes'
        DataType = ftInteger
      end
      item
        Name = 'ley_no_ingresa'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ley_no_egresa'
        DataType = ftString
        Size = 50
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
    object TRotasoid_rota: TIntegerField
      FieldName = 'oid_rota'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRotascodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRotasdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TRotasactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TRotashorario_desde: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TRotashorario_hasta: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TRotasmin_ent_antes: TIntegerField
      FieldName = 'min_ent_antes'
    end
    object TRotasmin_ent_desp: TIntegerField
      FieldName = 'min_ent_desp'
    end
    object TRotastipo_acceso: TStringField
      FieldName = 'tipo_acceso'
    end
    object TRotastipo_egreso: TStringField
      FieldName = 'tipo_egreso'
    end
    object TRotasmin_sal_despues: TIntegerField
      FieldName = 'min_sal_despues'
    end
    object TRotasmin_sal_antes: TIntegerField
      FieldName = 'min_sal_antes'
    end
    object TRotasley_no_ingresa: TStringField
      FieldName = 'ley_no_ingresa'
      Size = 50
    end
    object TRotasley_no_egresa: TStringField
      FieldName = 'ley_no_egresa'
      Size = 50
    end
  end
  object DSTRotas: TDataSource [4]
    DataSet = TRotas
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
        TableName = 'TRotas'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorRota.Value := Sender.AsString;'
          '  ValidadorRota.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TMotivoEntradasInterRota'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Motivo'#39 +
            ');'
          '  if (Trim(DataSet.FieldName('#39'horario_desde'#39').AsString) = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el horario' +
            ' desde '#39');'
          '  if (Trim(DataSet.FieldName('#39'horario_hasta'#39').AsString) = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el horario' +
            ' hasta '#39');     '
          '  if (Trim(DataSet.FieldName('#39'asignacion'#39').AsString) = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el comport' +
            'amiento del Motivo'#39');     '
          ''
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TEquivalenciaRotasCIP'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_rota'#39').AsInteger := TRotas.FieldName('#39'o' +
            'id_rota'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterRota'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_rota'#39').AsInteger := TRotas.FieldName('#39'o' +
            'id_rota'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean  := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTiposEntradas();'
          '  TraerTiposSalidas();'
          '  TMotivos.loadFromHelp('#39'HelpMotivos'#39');'
          '  TraerComporMotivos();'
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
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposSalidasRotas'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerComporMotivos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCompoMotEntInter'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          '')
      end>
    Left = 320
  end
  inherited SaveArchivo: TSaveDialog
    Top = 128
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 328
    Top = 272
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 280
    Top = 123
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 512
    Top = 59
  end
  object HelpRotas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
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
    Titulo = 'Rotas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Rota duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
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
    Left = 240
    Top = 294
    object TTiposEntradascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposEntradasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposEntradas: TDataSource
    DataSet = TTiposEntradas
    Left = 272
    Top = 294
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
    Left = 240
    Top = 335
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposSalidas: TDataSource
    DataSet = TTiposSalidas
    Left = 272
    Top = 335
  end
  object TEquivalenciaRotasCIP: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rota_equiv'
        DataType = ftInteger
      end
      item
        Name = 'oid_rota'
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
    IndexFieldNames = 'oid_rota;orden'
    IndexDefs = <
      item
        Name = 'TEquivalenciaRotasCIPIndex1'
        Fields = 'oid_rota;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rota'
    MasterSource = DSTRotas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 592
    Top = 100
    object TEquivalenciaRotasCIPoid_rota_equiv: TIntegerField
      FieldName = 'oid_rota_equiv'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEquivalenciaRotasCIPoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TEquivalenciaRotasCIPcodigo_externo: TStringField
      FieldName = 'codigo_externo'
      Size = 50
    end
    object TEquivalenciaRotasCIPactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEquivalenciaRotasCIPorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSEquivalenciaRotasCIP: TDataSource
    DataSet = TEquivalenciaRotasCIP
    Left = 624
    Top = 100
  end
  object TMotivoEntradasInterRota: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mot_rota'
        DataType = ftInteger
      end
      item
        Name = 'oid_rota'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rota'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_rota'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rota'
    MasterSource = DSTRotas
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 720
    Top = 100
    object TMotivoEntradasInterRotaoid_mot_rota: TIntegerField
      FieldName = 'oid_mot_rota'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoEntradasInterRotaoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TMotivoEntradasInterRotaoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TMotivoEntradasInterRotahorario_desde: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivoEntradasInterRotahorario_hasta: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivoEntradasInterRotaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TMotivoEntradasInterRotaasignacion: TStringField
      FieldName = 'asignacion'
    end
  end
  object DSMotivoEntradasInterRota: TDataSource
    DataSet = TMotivoEntradasInterRota
    Left = 752
    Top = 100
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoEntIntermedias'
    NroHelp = 6
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
    Left = 663
    Top = 478
  end
  object TMotivos: TsnTable
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
    Left = 695
    Top = 478
    object TMotivosoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMotivos: TDataSource
    DataSet = TMotivos
    Left = 728
    Top = 476
  end
  object TCompoEntInter: TsnTable
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
    Left = 192
    Top = 164
    object TCompoEntIntercodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCompoEntInterdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTCompoEntInter: TDataSource
    DataSet = TCompoEntInter
    Left = 224
    Top = 164
  end
end
