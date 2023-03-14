inherited FModLiquiTarj: TFModLiquiTarj
  Left = 137
  Top = 146
  Height = 438
  Caption = 'Modelos de Liquidaciones'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 404
    inherited PPie: TPanel
      Top = 383
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCabModeloLiq
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCabModeloLiq
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpModLiq
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpModLiq
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpModLiq
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTCabModeloLiq
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
      Height = 90
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 40
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label3: TLabel
        Left = 40
        Top = 64
        Width = 91
        Height = 13
        Caption = 'Comentario Asiento'
      end
      object DBECodigo: TsnDBEdit
        Left = 157
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTCabModeloLiq
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 164
      end
      object snDBEdit1: TsnDBEdit
        Left = 157
        Top = 36
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTCabModeloLiq
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 252
      end
      object snDBEdit2: TsnDBEdit
        Left = 157
        Top = 60
        DataBinding.DataField = 'comen_asiento'
        DataBinding.DataSource = DSTCabModeloLiq
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 255
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 460
      end
    end
    inherited PCuerpo: TPanel
      Top = 142
      Height = 241
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 709
        Height = 221
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Modelo de Asiento'
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 701
            Height = 193
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN1DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTDetModeloLiq
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object dxDBGridSN1DBTableView1orden: TcxGridDBColumn
                Caption = 'Orden'
                DataBinding.FieldName = 'orden'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soAscending
                Width = 43
              end
              object dxDBGridSN1DBTableView1cuenta: TcxGridDBColumn
                Caption = 'Cuenta'
                DataBinding.FieldName = 'cuenta'
                HeaderAlignmentHorz = taCenter
                Width = 103
              end
              object dxDBGridSN1DBTableView1desc_cuenta: TcxGridDBColumn
                Caption = 'Desc. Cuenta'
                DataBinding.FieldName = 'desc_cuenta'
                HeaderAlignmentHorz = taCenter
                Width = 120
              end
              object dxDBGridSN1DBTableView1compo1: TcxGridDBColumn
                Caption = 'Compo. 1'
                DataBinding.FieldName = 'compo1'
                HeaderAlignmentHorz = taCenter
                Width = 64
              end
              object dxDBGridSN1DBTableView1compo2: TcxGridDBColumn
                Caption = 'Compo. 2'
                DataBinding.FieldName = 'compo2'
                HeaderAlignmentHorz = taCenter
                Width = 64
              end
              object dxDBGridSN1DBTableView1debe: TcxGridDBColumn
                Caption = 'Debe'
                DataBinding.FieldName = 'debe'
                HeaderAlignmentHorz = taCenter
                Width = 60
              end
              object dxDBGridSN1DBTableView1haber: TcxGridDBColumn
                Caption = 'Haber'
                DataBinding.FieldName = 'haber'
                HeaderAlignmentHorz = taCenter
                Width = 62
              end
              object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
                Caption = 'Cod. Impuesto'
                DataBinding.FieldName = 'cod_impuesto'
                HeaderAlignmentHorz = taCenter
                Width = 80
              end
              object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
                Caption = '% Imp.'
                DataBinding.FieldName = 'porc_imp'
                HeaderAlignmentHorz = taCenter
                Width = 48
              end
              object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
                Caption = 'Act.'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 35
              end
            end
            object dxDBGridSN1Level1: TcxGridLevel
              GridView = dxDBGridSN1DBTableView1
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCabModeloLiq'
    OperGrabarObjeto = 'SaveCabModeloLiq'
    CargaDataSets = <
      item
        DataSet = TCabModeloLiq
        TableName = 'TCabModeloLiq'
      end
      item
        DataSet = TDetModeloLiq
        TableName = 'TDetModeloLiq'
      end>
    BajaLogica = <
      item
        DataSet = TCabModeloLiq
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCabModeloLiq
    DataSetDet1 = TDetModeloLiq
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCabModeloLiq: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_modelo_liq'
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
    object TCabModeloLiqoid_modelo_liq: TIntegerField
      FieldName = 'oid_modelo_liq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCabModeloLiqcodigo: TStringField
      FieldName = 'codigo'
    end
    object TCabModeloLiqdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TCabModeloLiqactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TCabModeloLiqcomen_asiento: TStringField
      FieldName = 'comen_asiento'
      Size = 255
    end
  end
  object DSTCabModeloLiq: TDataSource [4]
    DataSet = TCabModeloLiq
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
    OnShow.Strings = (
      'begin'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo1'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo2'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP2_CONC_TARJ'#39'));'
      'end.')
    OnValidate = <
      item
        TableName = 'TCabModeloLiq'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorLiquidacion.Value := Sender.AsString;'
          '  ValidadorLiquidacion.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TDetModeloLiq'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_modelo_liq'#39').AsInteger := TCabModeloLiq' +
            '.FieldName('#39'oid_modelo_liq'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          ' operacion.execute();  '
          'end.')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 384
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 576
    Top = 203
  end
  object HelpModLiq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.CabModeloLiq'
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
    Titulo = 'Liquidaciones'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorLiquidacion: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.CabModeloLiq'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Modelo de Liquidaci'#243'n de Tarjeta Duplicada'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TDetModeloLiq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_modelo_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_modelo_liq'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'cuenta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_cuenta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'compo1'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'compo2'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'debe'
        DataType = ftCurrency
      end
      item
        Name = 'haber'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_modelo_liq'
    IndexDefs = <
      item
        Name = 'TDetModeloLiqIndex1'
        Fields = 'oid_modelo_liq'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_modelo_liq'
    MasterSource = DSTCabModeloLiq
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 646
    Top = 95
    object TDetModeloLiqoid_modelo_det: TIntegerField
      FieldName = 'oid_modelo_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDetModeloLiqoid_modelo_liq: TIntegerField
      FieldName = 'oid_modelo_liq'
    end
    object TDetModeloLiqorden: TIntegerField
      FieldName = 'orden'
    end
    object TDetModeloLiqcuenta: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object TDetModeloLiqdesc_cuenta: TStringField
      FieldName = 'desc_cuenta'
      Size = 100
    end
    object TDetModeloLiqcompo1: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object TDetModeloLiqcompo2: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object TDetModeloLiqdebe: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetModeloLiqhaber: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetModeloLiqactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDetModeloLiqcod_impuesto: TStringField
      FieldName = 'cod_impuesto'
    end
    object TDetModeloLiqporc_imp: TFloatField
      FieldName = 'porc_imp'
      DisplayFormat = '% ###.##'
    end
  end
  object DSTDetModeloLiq: TDataSource
    DataSet = TDetModeloLiq
    Left = 680
    Top = 93
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 536
    Top = 260
  end
end
