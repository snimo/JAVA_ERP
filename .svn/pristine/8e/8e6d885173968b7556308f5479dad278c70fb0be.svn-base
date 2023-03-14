inherited FTarjetaConcil: TFTarjetaConcil
  Left = 103
  Top = 139
  Width = 726
  Height = 562
  Caption = 'Tarjetas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 718
    Height = 528
    inherited PPie: TPanel
      Top = 507
      Width = 718
      inherited StatusBarABM: TStatusBar
        Left = 613
      end
      inherited StatusBar2: TStatusBar
        Width = 613
      end
    end
    inherited PMenu: TPanel
      Width = 718
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTarjetaConciTar
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTarjetaConciTar
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTarjetas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTarjetas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTarjetas
      end
      inherited Panel2: TPanel
        Left = 677
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTarjetaConciTar
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
      Width = 718
    end
    inherited PCabecera: TPanel
      Width = 718
      Height = 261
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label3: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label2: TLabel
        Left = 40
        Top = 80
        Width = 114
        Height = 13
        Caption = 'Identificaci'#243'n de Tarjeta'
      end
      object Label4: TLabel
        Left = 40
        Top = 112
        Width = 80
        Height = 13
        Caption = 'C'#243'digo POSNET'
      end
      object Label5: TLabel
        Left = 40
        Top = 144
        Width = 90
        Height = 13
        Caption = 'Agrupador Tarjetas'
      end
      object Label6: TLabel
        Left = 40
        Top = 173
        Width = 176
        Height = 13
        Caption = 'Tolerancia D'#237'as Conciliaci'#243'n Dudosa'
      end
      object Label7: TLabel
        Left = 40
        Top = 205
        Width = 154
        Height = 13
        Caption = 'Tolerancia D'#237'as Conciliaci'#243'n OK'
      end
      object Label9: TLabel
        Left = 41
        Top = 264
        Width = 54
        Height = 13
        Caption = 'Liquidaci'#243'n'
        Visible = False
      end
      object DBECodigo: TsnDBEdit
        Left = 226
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTTarjetaConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 156
      end
      object snDBEdit1: TsnDBEdit
        Left = 226
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTTarjetaConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 372
      end
      object DBEmpresa: TsnDBLookup
        Left = 226
        Top = 76
        DataBinding.DataField = 'identif_tarj'
        DataBinding.DataSource = DSTTarjetaConciTar
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTTiposTarjConci
        TabOrder = 2
        Width = 253
      end
      object snDBEdit2: TsnDBEdit
        Left = 226
        Top = 108
        DataBinding.DataField = 'codigo_posnet'
        DataBinding.DataSource = DSTTarjetaConciTar
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 372
      end
      object snDBLookup1: TsnDBLookup
        Left = 226
        Top = 140
        DataBinding.DataField = 'oid_agrupador'
        DataBinding.DataSource = DSTTarjetaConciTar
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSAgrupador
        TabOrder = 4
        Width = 253
      end
      object snDBEdit3: TsnDBEdit
        Left = 226
        Top = 169
        DataBinding.DataField = 'tol_dias_fec_conci'
        DataBinding.DataSource = DSTTarjetaConciTar
        TabOrder = 5
        Width = 41
      end
      object snDBEdit4: TsnDBEdit
        Left = 226
        Top = 201
        DataBinding.DataField = 'tol_dias_conc_ok'
        DataBinding.DataSource = DSTTarjetaConciTar
        TabOrder = 6
        Width = 41
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 37
        Top = 232
        Caption = 'Ignorar Movimiento POSNET'
        DataBinding.DataField = 'ignorar_mov_posnet'
        DataBinding.DataSource = DSTTarjetaConciTar
        TabOrder = 7
        Width = 169
      end
      object snDBLookup2: TsnDBLookup
        Left = 227
        Top = 260
        DataBinding.DataField = 'oid_modelo_liq'
        DataBinding.DataSource = DSTTarjetaConciTar
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSLiquidaciones
        TabOrder = 8
        Visible = False
        Width = 197
      end
    end
    inherited PCuerpo: TPanel
      Top = 313
      Width = 718
      Height = 194
      BorderWidth = 10
      object PageControlSN1: TPageControlSN
        Left = 10
        Top = 10
        Width = 698
        Height = 174
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Cuentas Contables'
          object Label8: TLabel
            Left = 56
            Top = 40
            Width = 76
            Height = 13
            Caption = 'Tarjeta a Cobrar'
          end
          object snLabel1: TsnLabel
            Left = 56
            Top = 64
            Width = 34
            Height = 13
            Caption = 'Cuenta'
          end
          object snLabel2: TsnLabel
            Left = 256
            Top = 40
            Width = 69
            Height = 13
            Caption = 'Componente 1'
          end
          object snLabel3: TsnLabel
            Left = 408
            Top = 40
            Width = 69
            Height = 13
            Caption = 'Componente 2'
          end
          object snLabel4: TsnLabel
            Left = 24
            Top = 16
            Width = 155
            Height = 13
            Caption = 'Utilizar en asiento a Cobrar'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clNavy
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold]
            ParentFont = False
          end
          object snDBEdit5: TsnDBEdit
            Left = 101
            Top = 61
            DataBinding.DataField = 'acob_cta_tarj'
            DataBinding.DataSource = DSTTarjetaConciTar
            TabOrder = 0
            Width = 140
          end
          object snDBEdit6: TsnDBEdit
            Left = 253
            Top = 61
            DataBinding.DataField = 'acob_cta_tarj_c1'
            DataBinding.DataSource = DSTTarjetaConciTar
            TabOrder = 1
            Width = 140
          end
          object snDBEdit7: TsnDBEdit
            Left = 405
            Top = 61
            DataBinding.DataField = 'acob_cta_tarj_c2'
            DataBinding.DataSource = DSTTarjetaConciTar
            TabOrder = 2
            Width = 140
          end
        end
        object TabSheet2: TTabSheet
          BorderWidth = 5
          Caption = 'Modelos de Liquidaciones por Empresa'
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 680
            Height = 136
            Align = alClient
            TabOrder = 0
            CriteriosPintarCelda = <>
            object dxDBGridSN1DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTTarjModeloLiq
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object dxDBGridSN1DBTableView1oid_empresa: TcxGridDBColumn
                Caption = 'Empresa'
                DataBinding.FieldName = 'oid_empresa'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSEmpresas
                HeaderAlignmentHorz = taCenter
                Width = 171
              end
              object dxDBGridSN1DBTableView1oid_modelo_liq: TcxGridDBColumn
                Caption = 'Modelo'
                DataBinding.FieldName = 'oid_modelo_liq'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSLiquidaciones
                HeaderAlignmentHorz = taCenter
                Width = 160
              end
              object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 51
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
    OperTraerObjeto = 'TraerTarjetaConciTar'
    OperGrabarObjeto = 'SaveTarjetaConciTar'
    CargaDataSets = <
      item
        DataSet = TTarjetaConciTar
        TableName = 'TTarjetaConciTar'
      end
      item
        DataSet = TTiposTarjConci
        TableName = 'TTiposTarjConci'
      end
      item
        DataSet = TComporTipoArch
        TableName = 'TComporTipoArch'
      end
      item
        DataSet = TTarjModeloLiq
        TableName = 'TTarjModeloLiq'
      end>
    BajaLogica = <
      item
        DataSet = TTarjetaConciTar
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTarjetaConciTar
    DataSetDet1 = TTarjModeloLiq
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTarjetaConciTar: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tar_conci'
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
        Name = 'identif_tarj'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'codigo_posnet'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_agrupador'
        DataType = ftInteger
      end
      item
        Name = 'tol_dias_fec_conci'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'tol_dias_conc_ok'
        DataType = ftInteger
      end
      item
        Name = 'acob_cta_tarj'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'acob_cta_tarj_c1'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'acob_cta_tarj_c2'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ignorar_mov_posnet'
        DataType = ftBoolean
      end
      item
        Name = 'liquidacion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_modelo_liq'
        DataType = ftInteger
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
    object TTarjetaConciTaroid_tar_conci: TIntegerField
      FieldName = 'oid_tar_conci'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTarjetaConciTarcodigo: TStringField
      FieldName = 'codigo'
    end
    object TTarjetaConciTardescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TTarjetaConciTaridentif_tarj: TStringField
      FieldName = 'identif_tarj'
    end
    object TTarjetaConciTarcodigo_posnet: TStringField
      FieldName = 'codigo_posnet'
      Size = 100
    end
    object TTarjetaConciTaroid_agrupador: TIntegerField
      FieldName = 'oid_agrupador'
    end
    object TTarjetaConciTartol_dias_fec_conci: TIntegerField
      FieldName = 'tol_dias_fec_conci'
    end
    object TTarjetaConciTaractivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TTarjetaConciTartol_dias_conc_ok: TIntegerField
      FieldName = 'tol_dias_conc_ok'
    end
    object TTarjetaConciTaracob_cta_tarj: TStringField
      FieldName = 'acob_cta_tarj'
      Size = 50
    end
    object TTarjetaConciTaracob_cta_tarj_c1: TStringField
      FieldName = 'acob_cta_tarj_c1'
    end
    object TTarjetaConciTaracob_cta_tarj_c2: TStringField
      FieldName = 'acob_cta_tarj_c2'
    end
    object TTarjetaConciTarignorar_mov_posnet: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'ignorar_mov_posnet'
    end
    object TTarjetaConciTarliquidacion: TStringField
      FieldName = 'liquidacion'
      Size = 50
    end
    object TTarjetaConciTaroid_modelo_liq: TIntegerField
      FieldName = 'oid_modelo_liq'
    end
  end
  object DSTTarjetaConciTar: TDataSource [4]
    DataSet = TTarjetaConciTar
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
      
        '  snLabel2.setCaption(Varios.getValorString('#39'LABEL_COMP1_CONC_TA' +
        'RJ'#39'));'
      
        '  snLabel3.setCaption(Varios.getValorString('#39'LABEL_COMP2_CONC_TA' +
        'RJ'#39'));'
      'end.')
    OnValidate = <
      item
        TableName = 'TTarjetaConciTar'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorTarjeta.Value := Sender.AsString;'
          '  ValidadorTarjeta.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TTarjModeloLiq'
        Source.Strings = (
          'begin'
          '  if (TTarjModeloLiq.FieldName('#39'oid_empresa'#39').AsInteger<=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');'
          '  if (TTarjModeloLiq.FieldName('#39'oid_modelo_liq'#39').AsInteger<=0)'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar el Modelo d' +
            'e Liquidaci'#243'n'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TTarjModeloLiq'
        Source.Strings = (
          'begin'
          
            '   DataSet.FieldName('#39'oid_tar_conci'#39').AsInteger := TTarjetaConci' +
            'Tar.FieldName('#39'oid_tar_conci'#39').AsInteger;'
          '   DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TEmpresas.loadFromHelp('#39'HelpEmpresas'#39');'
          '  TraerTiposTarjConci();'
          '  TAgrupador.loadFromHelp('#39'HelpAgrupador'#39');'
          '  TLiquidaciones.loadFromHelp('#39'HelpLiquidaciones'#39');'
          '  TraerComportamientos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerComportamientos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTipoArchConciTar'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure TraerTiposTarjConci();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposTarjConci'#39');'
          ' operacion.execute();'
          'end;')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 488
    Top = 144
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 160
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 592
    Top = 139
  end
  object HelpTarjetas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.TarjetaConciTar'
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
    Titulo = 'Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorTarjeta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.TarjetaConciTar'
    WhenRaiseException = teFound
    MensajeException = 'Tarjeta Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TTiposTarjConci: TsnTable
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
    Left = 752
    Top = 27
    object TTiposTarjConcicodigo: TStringField
      FieldName = 'codigo'
    end
    object TTiposTarjConcidescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTiposTarjConci: TDataSource
    DataSet = TTiposTarjConci
    Left = 784
    Top = 27
  end
  object TAgrupador: TsnTable
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
    Left = 416
    Top = 291
    object TAgrupadoroid: TIntegerField
      FieldName = 'oid'
    end
    object TAgrupadorcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TAgrupadordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TAgrupadoractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object HelpAgrupador: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.AgrupadorTarjConci'
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
    Titulo = 'Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 450
    Top = 292
  end
  object DSAgrupador: TDataSource
    DataSet = TAgrupador
    Left = 488
    Top = 291
  end
  object TComporTipoArch: TsnTable
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
    Left = 280
    Top = 244
    object TComporTipoArchcodigo: TStringField
      FieldName = 'codigo'
    end
    object TComporTipoArchdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
  end
  object DSTComporTipoArch: TDataSource
    DataSet = TComporTipoArch
    Left = 312
    Top = 244
  end
  object TLiquidaciones: TsnTable
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
    Left = 416
    Top = 330
    object IntegerField1: TIntegerField
      FieldName = 'oid'
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
  end
  object HelpLiquidaciones: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.CabModeloLiq'
    NroHelp = 5
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
    Titulo = 'Tarjetas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 450
    Top = 331
  end
  object DSLiquidaciones: TDataSource
    DataSet = TLiquidaciones
    Left = 488
    Top = 329
  end
  object TTarjModeloLiq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tarj_mod_liq'
        DataType = ftInteger
      end
      item
        Name = 'oid_tar_conci'
        DataType = ftInteger
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'oid_modelo_liq'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_tar_conci'
    IndexDefs = <
      item
        Name = 'TTarjModeloLiqIndex1'
        Fields = 'oid_tar_conci;secu'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_tar_conci'
    MasterSource = DSTTarjetaConciTar
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 100
    object TTarjModeloLiqoid_tarj_mod_liq: TIntegerField
      FieldName = 'oid_tarj_mod_liq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTarjModeloLiqoid_tar_conci: TIntegerField
      FieldName = 'oid_tar_conci'
    end
    object TTarjModeloLiqoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TTarjModeloLiqoid_modelo_liq: TIntegerField
      FieldName = 'oid_modelo_liq'
    end
    object TTarjModeloLiqactivo: TBooleanField
      FieldName = 'activo'
    end
    object TTarjModeloLiqsecu: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'secu'
    end
  end
  object DSTTarjModeloLiq: TDataSource
    DataSet = TTarjModeloLiq
    Left = 680
    Top = 100
  end
  object TEmpresas: TsnTable
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
    Left = 416
    Top = 370
    object IntegerField2: TIntegerField
      FieldName = 'oid'
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
  end
  object HelpEmpresas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.EmpresaConciTar'
    NroHelp = 5
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
    Titulo = 'Empresas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 450
    Top = 371
  end
  object DSEmpresas: TDataSource
    DataSet = TEmpresas
    Left = 488
    Top = 369
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 536
    Top = 260
  end
end
