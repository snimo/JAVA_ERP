inherited FLPPorProdGral: TFLPPorProdGral
  Left = 47
  Top = 10
  Width = 1091
  Height = 712
  Caption = 'Lista de Precios por Producto General'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 1083
    Height = 678
    inherited PPie: TPanel
      Top = 657
      Width = 1083
      inherited StatusBarABM: TStatusBar
        Left = 978
      end
      inherited StatusBar2: TStatusBar
        Width = 978
      end
    end
    inherited PMenu: TPanel
      Width = 1083
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSFormacionPrecios
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSFormacionPrecios
        ValorEstadoVisible = 'False'
      end
      inherited Panel2: TPanel
        Left = 1042
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSFormacionPrecios
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
      Width = 1083
    end
    inherited PCabecera: TPanel
      Width = 1083
      Height = 20
    end
    inherited PCuerpo: TPanel
      Top = 72
      Width = 1083
      Height = 585
      object Panel1: TPanel
        Left = 0
        Top = 37
        Width = 1083
        Height = 548
        Align = alClient
        BorderWidth = 5
        Color = clWindow
        TabOrder = 1
        object PageControl1: TPageControlSN
          Left = 6
          Top = 6
          Width = 1071
          Height = 536
          ActivePage = PageName1
          Align = alClient
          TabOrder = 0
          object PageName1: TTabSheet
            BorderWidth = 10
            Caption = 'Actualizaci'#243'n de Precios de Lista'
            ImageIndex = 1
            object dxDBGrilla: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 1043
              Height = 488
              Align = alClient
              PopupMenu = PopMenuDetInv
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object dxDBGrillaDBBandedTableView1: TcxGridDBBandedTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSProductosLP
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.AlwaysShowEditor = True
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.IncSearch = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsCustomize.ColumnsQuickCustomization = True
                OptionsCustomize.BandsQuickCustomization = True
                OptionsData.Deleting = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                Styles.ContentEven = cxStyle3
                Bands = <
                  item
                    Caption = 'Producto'
                    FixedKind = fkLeft
                    Width = 478
                  end
                  item
                    Caption = 'Actualizaci'#243'n de Precios'
                    Width = 539
                  end
                  item
                    Caption = 'Costo'
                    Visible = False
                    Width = 229
                  end
                  item
                    Caption = 'Precio de Venta'
                    Visible = False
                    Width = 226
                  end>
                object DBColCodProducto: TcxGridDBBandedColumn
                  Caption = 'Lista de Precios'
                  DataBinding.FieldName = 'cod_lp'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 82
                  Position.BandIndex = 0
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1desc_producto: TcxGridDBBandedColumn
                  Caption = 'Descripci'#243'n'
                  DataBinding.FieldName = 'desc_lp'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 264
                  Position.BandIndex = 0
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1fec_ult_costo: TcxGridDBBandedColumn
                  Caption = 'Fec. Costo'
                  DataBinding.FieldName = 'fec_ult_costo'
                  Visible = False
                  HeaderAlignmentHorz = taCenter
                  Options.IncSearch = False
                  Width = 68
                  Position.BandIndex = 1
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1simbolo_mon_costo: TcxGridDBBandedColumn
                  Caption = 'Mon.'
                  DataBinding.FieldName = 'oid_moneda_costo'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListSource = DSMonedas
                  HeaderAlignmentHorz = taCenter
                  Options.IncSearch = False
                  Width = 47
                  Position.BandIndex = 1
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1cant_costo: TcxGridDBBandedColumn
                  Caption = 'Cantidad'
                  DataBinding.FieldName = 'cant_costo'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Width = 68
                  Position.BandIndex = 2
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1cod_um_costo: TcxGridDBBandedColumn
                  Caption = 'U.M.'
                  DataBinding.FieldName = 'oid_um_costo'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = dsUniMed
                  HeaderAlignmentHorz = taCenter
                  Width = 66
                  Position.BandIndex = 2
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1costo: TcxGridDBBandedColumn
                  Caption = 'Costo'
                  DataBinding.FieldName = 'costo'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Options.Filtering = False
                  Options.IncSearch = False
                  Width = 67
                  Position.BandIndex = 1
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1fec_ult_pv: TcxGridDBBandedColumn
                  Caption = 'Fec. Act. P.V.'
                  DataBinding.FieldName = 'fec_ult_pv'
                  GroupSummaryAlignment = taCenter
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 97
                  Position.BandIndex = 3
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1simbolo_mon_pv: TcxGridDBBandedColumn
                  Caption = 'Mon.'
                  DataBinding.FieldName = 'oid_moneda_pv'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListSource = DSMonedas
                  HeaderAlignmentHorz = taCenter
                  Options.IncSearch = False
                  Width = 60
                  Position.BandIndex = 1
                  Position.ColIndex = 7
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1cant_pv: TcxGridDBBandedColumn
                  Caption = 'Cantidad'
                  DataBinding.FieldName = 'cant_pv'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Width = 61
                  Position.BandIndex = 3
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1cod_um_pv: TcxGridDBBandedColumn
                  Caption = 'U.M.'
                  DataBinding.FieldName = 'oid_um_pv'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'codigo'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = dsUniMed
                  HeaderAlignmentHorz = taCenter
                  Width = 68
                  Position.BandIndex = 3
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1precio_venta: TcxGridDBBandedColumn
                  Caption = 'P.A. S/IVA'
                  DataBinding.FieldName = 'precio_venta'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.IncSearch = False
                  Width = 70
                  Position.BandIndex = 1
                  Position.ColIndex = 5
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1porc_rent_actual: TcxGridDBBandedColumn
                  Caption = '% Actual'
                  DataBinding.FieldName = 'porc_rent_actual'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.IncSearch = False
                  Width = 47
                  Position.BandIndex = 1
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1nuevo_porc_rent: TcxGridDBBandedColumn
                  Caption = '% Nuevo'
                  DataBinding.FieldName = 'nuevo_porc_rent'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Options.IncSearch = False
                  Width = 51
                  Position.BandIndex = 1
                  Position.ColIndex = 8
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1nuevo_precio_vta: TcxGridDBBandedColumn
                  Caption = 'P. S/IVA'
                  DataBinding.FieldName = 'nuevo_precio_vta'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Options.IncSearch = False
                  Width = 53
                  Position.BandIndex = 1
                  Position.ColIndex = 9
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1Column1: TcxGridDBBandedColumn
                  Caption = 'Dec.'
                  DataBinding.FieldName = 'cant_decimales'
                  Visible = False
                  Options.IncSearch = False
                  Width = 26
                  Position.BandIndex = 1
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1Column2: TcxGridDBBandedColumn
                  Caption = 'P.C/IVA'
                  DataBinding.FieldName = 'nuevo_precio_vta_con_iva'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.UseLeftAlignmentOnEditing = False
                  HeaderAlignmentHorz = taCenter
                  Width = 83
                  Position.BandIndex = 1
                  Position.ColIndex = 10
                  Position.RowIndex = 0
                end
                object dxDBGrillaDBBandedTableView1Column3: TcxGridDBBandedColumn
                  Caption = 'P.A. C/IVA'
                  DataBinding.FieldName = 'precio_venta_con_iva'
                  PropertiesClassName = 'TcxCurrencyEditProperties'
                  Properties.DisplayFormat = ',0.00;-,0.00'
                  Properties.ReadOnly = True
                  Width = 61
                  Position.BandIndex = 1
                  Position.ColIndex = 6
                  Position.RowIndex = 0
                end
              end
              object dxDBGrillaLevel1: TcxGridLevel
                GridView = dxDBGrillaDBBandedTableView1
              end
            end
          end
        end
      end
      object Panel3: TPanel
        Left = 0
        Top = 0
        Width = 1083
        Height = 37
        Align = alTop
        BevelOuter = bvNone
        Color = clWindow
        TabOrder = 0
        object Label1: TLabel
          Left = 31
          Top = 10
          Width = 43
          Height = 13
          Caption = 'Producto'
        end
        object LVerCotizaciones: TLabel
          Left = 897
          Top = 8
          Width = 78
          Height = 13
          Cursor = crHandPoint
          Caption = 'Ver cotizaciones'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clBlue
          Font.Height = -11
          Font.Name = 'MS Sans Serif'
          Font.Style = [fsUnderline]
          ParentFont = False
        end
        object snDBEdit24: TsnDBEdit
          Left = 268
          Top = 6
          TabStop = False
          DataBinding.DataField = 'desc_prod_gral'
          DataBinding.DataSource = DSInput
          Style.BorderColor = clWindowFrame
          Style.Shadow = False
          TabOrder = 0
          ReadOnlyAlways = True
          Width = 605
        end
        object dbCodProdGral: TsrnDBButtonEdit
          Left = 86
          Top = 6
          DataBinding.DataField = 'cod_prod_gral'
          DataBinding.DataSource = DSInput
          Properties.Buttons = <
            item
              Default = True
              Kind = bkEllipsis
            end>
          Properties.ClickKey = 112
          TabOrder = 1
          Width = 185
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPreciosProdGralEnLP'
    OperGrabarObjeto = 'SavePreciosProdGralLP'
    CargaDataSets = <
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end
      item
        DataSet = TClasificadorEntidad
        TableName = 'TClasificadorEntidad'
      end
      item
        DataSet = TValoresClasificadores
        TableName = 'TValoresClasificadores'
      end
      item
        DataSet = TValProducto
        TableName = 'TValProducto'
      end
      item
        DataSet = TTraerStockProd
        TableName = 'TTraerStockProd'
      end
      item
        DataSet = TProductosLP
        TableName = 'TProductosLP'
      end
      item
        DataSet = TCostoEnUMVta
        TableName = 'TCostoEnUMVta'
      end
      item
        DataSet = TClasifProdGeneral
        TableName = 'TClasifProdGeneral'
      end
      item
        DataSet = TInput
        TableName = 'TInput'
      end>
    BajaLogica = <
      item
        DataSet = TFormacionPrecios
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TInput
    DataSetDet1 = TFormacionPreciosDet
    DataSetDet2 = TProductosLP
    ControlFocoAlta = dbCodProdGral
    ControlFocoModif = dbCodProdGral
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TFormacionPrecios: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_formacion_precio'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_clasif_presen'
        DataType = ftInteger
      end
      item
        Name = 'cod_clasif_presen'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_clasif_presen'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'codigo_producto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'desc_producto'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'oid_lp'
        DataType = ftInteger
      end
      item
        Name = 'cod_lp'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_lp'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'sugerir_nuevos_precios'
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
    object TFormacionPreciosoid_formacion_precio: TIntegerField
      FieldName = 'oid_formacion_precio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFormacionPreciosactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TFormacionPreciosoid_clasif_presen: TIntegerField
      FieldName = 'oid_clasif_presen'
    end
    object TFormacionPrecioscod_clasif_presen: TStringField
      FieldName = 'cod_clasif_presen'
      Size = 50
    end
    object TFormacionPreciosdesc_clasif_presen: TStringField
      FieldName = 'desc_clasif_presen'
      Size = 100
    end
    object TFormacionPrecioscodigo_producto: TStringField
      FieldName = 'codigo_producto'
      Size = 100
    end
    object TFormacionPreciosdesc_producto: TStringField
      FieldName = 'desc_producto'
      Size = 255
    end
    object TFormacionPreciosoid_lp: TIntegerField
      FieldName = 'oid_lp'
    end
    object TFormacionPrecioscod_lp: TStringField
      FieldName = 'cod_lp'
      Size = 50
    end
    object TFormacionPreciosdesc_lp: TStringField
      FieldName = 'desc_lp'
      Size = 100
    end
    object TFormacionPreciossugerir_nuevos_precios: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'sugerir_nuevos_precios'
    end
    object TFormacionPrecioscant_decimales: TIntegerField
      FieldName = 'cant_decimales'
    end
    object TFormacionPreciosaplicar_cant_decimales: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'aplicar_cant_decimales'
    end
    object TFormacionPrecioscant_decimales_sin_iva: TIntegerField
      FieldName = 'cant_decimales_sin_iva'
    end
    object TFormacionPreciosaplicar_cant_decimales_sin_iva: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'aplicar_cant_decimales_sin_iva'
    end
    object TFormacionPreciosaplicar_porc: TCurrencyField
      FieldName = 'aplicar_porc'
    end
  end
  object DSFormacionPrecios: TDataSource [4]
    DataSet = TFormacionPrecios
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
    Left = 288
    Top = 88
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 672
    Top = 120
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TFormacionPrecios'
        FieldName = 'cod_clasif_presen'
        Source.Strings = (
          'begin'
          '  ValidadorClasificadorEntidad.Value := Sender.AsString;'
          '  ValidadorClasificadorEntidad.Validar();'
          'end.')
      end
      item
        TableName = 'TClasificadorEntidad'
        FieldName = 'cod_valor_clasif'
        Source.Strings = (
          'begin'
          
            '   ValidarValorClasifEntidad(TClasificadorEntidad.FieldName('#39'oid' +
            '_clasif_ent'#39').AsInteger,'
          '                                          Sender.AsString);'
          'end.'
          '')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'cod_producto'
        Source.Strings = (
          'begin'
          '  //habControles(false);'
          '  //ValidarProducto(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TFormacionPrecios'
        FieldName = 'cod_lp'
        Source.Strings = (
          'begin'
          '  ValidadorListaPrecio.Value := Sender.AsString;'
          '  ValidadorListaPrecio.Validar;'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'costo'
        Source.Strings = (
          'begin'
          '  if (Sender.AsCurrency<0)'
          
            '     then raiseexception(erCustomError,'#39'El costo ingresado debe ' +
            'ser positivo'#39');'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'nuevo_porc_rent'
        Source.Strings = (
          'begin'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'nuevo_precio_vta'
        Source.Strings = (
          'begin'
          '  if (Sender.AsCurrency<0)'
          
            '    then raiseexception(erCustomError,'#39'El precio de venta debe s' +
            'er mayor o igual a cero'#39');'
          'end.'
          '')
      end
      item
        TableName = 'TFormacionPrecios'
        FieldName = 'aplicar_porc'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39'Desea aplicar a los productos el porcent' +
            'aje ingresado?'#39'))'
          '     then actuPorcRent(Sender.AsCurrency);'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'cod_prod_gral'
        Source.Strings = (
          'begin'
          
            '   ValidarValorClasifEntidad(TClasifProdGeneral.FieldName('#39'oid_c' +
            'lasificador'#39').AsInteger,'
          '                                           Sender.AsString);'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TProductosLP'
        FieldName = 'nuevo_porc_rent'
        Source.Strings = (
          'begin'
          '  calcPrecioEnBaseAPorcRent();'
          'end.')
      end
      item
        TableName = 'TFormacionPrecios'
        FieldName = 'aplicar_cant_decimales'
        Source.Strings = (
          'begin'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'nuevo_precio_vta'
        Source.Strings = (
          'begin'
          '  calcNuevoPorcRent();'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'costo'
        Source.Strings = (
          'begin'
          '  CalcCambioCosto();'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'oid_moneda_costo'
        Source.Strings = (
          'begin'
          '  calcPorcRentActual();'
          '  calcPrecioEnBaseAPorcRent();'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'oid_moneda_pv'
        Source.Strings = (
          'begin'
          '  calcPrecioEnBaseAPorcRent();'
          'end.'
          '')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'oid_producto'
        Source.Strings = (
          'begin'
          '  if (Sender.AsInteger>0)'
          '    then TraerFormacionPrecioProducto(Sender.AsInteger);'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'oid_um_pv'
        Source.Strings = (
          'begin'
          '  calcPrecioEnBaseAPorcRent();'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'cant_pv'
        Source.Strings = (
          'begin'
          '  calcPrecioEnBaseAPorcRent();'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'cant_costo'
        Source.Strings = (
          'begin'
          '  CalcCambioCosto();'
          'end.'
          '')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'oid_um_costo'
        Source.Strings = (
          'begin'
          '  CalcCambioCosto();'
          'end.'
          '')
      end
      item
        TableName = 'TFormacionPrecios'
        FieldName = 'oid_lp'
        Source.Strings = (
          'begin'
          '  TProductosLP.Close;'
          '  TProductosLP.Open;'
          'end.')
      end
      item
        TableName = 'TProductosLP'
        FieldName = 'nuevo_precio_vta_con_iva'
        Source.Strings = (
          'begin'
          '  calcNuevoPorcRentyPrecioSinIVA();'
          'end.')
      end>
    OnClickItemMenuPopUp = <
      item
        PopUpMenuName = 'PopMenuDetInv'
        ItemMenuName = 'EliminarDetInventario'
        Source.Strings = (
          'begin'
          '  TProductosLP.borrar;'
          'end.')
        HabilitadoNuevo = True
        HabilitadoModificar = False
        HabilitadoOtros = False
      end
      item
        PopUpMenuName = 'PopMenuDetInv'
        ItemMenuName = 'Expandirtodo'
        Source.Strings = (
          'begin'
          '  dxDBGrilla.fullExpand;'
          'end.')
        HabilitadoNuevo = True
        HabilitadoModificar = False
        HabilitadoOtros = False
      end
      item
        PopUpMenuName = 'PopMenuDetInv'
        ItemMenuName = 'ContraerTodo'
        Source.Strings = (
          'begin'
          '  dxDBGrilla.fullCollapse();'
          'end.')
        HabilitadoNuevo = True
        HabilitadoModificar = False
        HabilitadoOtros = False
      end>
    OnAfterSetOperacion = <
      item
        OperationName = 'TraerPreciosProdGralEnLP'
        Source.Strings = (
          'begin'
          
            '  //CompoCotizaciones.ExternalCall('#39'TraerDataSetCotizacion'#39','#39#39');' +
            ' '
          
            '  //operacion.AddDataSet(CompoCotizaciones.getVarTable('#39'pTCotiza' +
            'ciones'#39').getDataSet); '
          ''
          'end.'
          '')
      end>
    OnBeforePost = <
      item
        TableName = 'TProductosLP'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_producto'#39').AsInteger = 0)'
          
            '      then raiseexception(erCustomError,'#39'Debe ingresar un produc' +
            'to'#39');'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'var'
          '  oidMoneda : integer;'
          'begin'
          '  TraerClasifGenProd();'
          '  HelpProductoGral.NroClasificador := '
          '     TClasifProdGeneral.FieldName('#39'nro_clasificador'#39').AsInteger;'
          '  TUnidadMedida.LoadFromHelp('#39'HelpUnidadMedida'#39');'
          '  TMonedas.loadFromHelp('#39'HelpMonedas'#39');'
          '  cargarCotizacionDeHoy();'
          '  oidMoneda :=  Varios.getParamOidObjNeg('#39'MONEDA_CURSO_LEGAL'#39');'
          '  getVariable.setValue('#39'oid_moneda_curso_legal'#39',oidMoneda);  '
          'end.')
      end>
    OnBeforeBuscar = <
      item
        Source.Strings = (
          'begin'
          '  HelpProductoGral.mostrar();'
          '  if (HelpProductoGral.Acepto)'
          '      then DriverABM.buscarObjetoByOid(HelpProductoGral.getOid);'
          'end.')
      end>
    OnPrint = <
      item
        Source.Strings = (
          'begin   '
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ValidarValorClasifEntidad(OidClasifEnt : integer ;'
          
            '                                                         codigo ' +
            ': string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TInput.EditRecord;'
          '             TInput.FieldName('#39'oid_prod_gral'#39').AsInteger := 0;'
          '             TInput.FieldName('#39'desc_prod_gral'#39').AsString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.addAtribute('#39'solo_titulos'#39','#39#39');'
          '  operacion.execute;'
          ''
          '   TInput.EditRecord;  '
          '   TInput.FieldName('#39'oid_prod_gral'#39').AsInteger := '
          
            '            TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39')' +
            '.AsInteger;'
          '   TInput.FieldName('#39'desc_prod_gral'#39').AsString :='
          
            '            TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString' +
            ';'
          ''
          'end;'
          ''
          ''
          'procedure TraerClasifGenProd();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerIniProdGen'#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure actuPorcRent(porc : currency);'
          'begin'
          'TProductosLP.First;'
          'while (not TProductosLP.eof) do'
          '  begin'
          '  TProductosLP.EditRecord;'
          '  TProductosLP.FieldName('#39'nuevo_porc_rent'#39').AsCurrency := porc;'
          '  TProductosLP.PostRecord;  '
          '  TProductosLP.next;'
          '  end;'
          'end;'
          ''
          ''
          'function getCostoEnUMVta() : currency;'
          'begin'
          ''
          '  if (TProductosLP.FieldName('#39'oid_producto'#39').AsInteger = 0)'
          '      then begin'
          '           result := 0;'
          '           exit;'
          '           end;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCostoConvAUMVtaGral'#39');'
          
            '  operacion.AddAtribute('#39'oid_producto'#39',TProductosLP.FieldName('#39'o' +
            'id_producto'#39').AsString);'
          
            '  operacion.AddAtribute('#39'costo'#39',FloatToStr(TProductosLP.FieldNam' +
            'e('#39'costo'#39').AsCurrency));'
          
            '  operacion.AddAtribute('#39'cant_costo'#39',FloatToStr(TProductosLP.Fie' +
            'ldName('#39'cant_costo'#39').AsCurrency));'
          
            '  operacion.AddAtribute('#39'oid_um_costo'#39',IntToStr(TProductosLP.Fie' +
            'ldName('#39'oid_um_costo'#39').AsInteger));'
          
            '  operacion.AddAtribute('#39'cant_venta'#39',FloatToStr(TProductosLP.Fie' +
            'ldName('#39'cant_pv'#39').AsCurrency));'
          
            '  operacion.AddAtribute('#39'oid_um_venta'#39',IntToStr(TProductosLP.Fie' +
            'ldName('#39'oid_um_pv'#39').AsInteger));'
          '  operacion.execute;'
          ''
          '  result := TCostoEnUMVta.FieldName('#39'costo'#39').AsCurrency;'
          '  dxDBGrilla.fullExpand; '
          'end;'
          ''
          'function getDescMoneda(OidMoneda : integer) : string;'
          'begin'
          '   TMonedas.First;'
          '   if TMonedas.Locate('#39'oid'#39',OidMoneda,[])'
          '       then result := TMonedas.FieldName('#39'descripcion'#39').AsString'
          '       else result := '#39#39';'
          'end;'
          ''
          ''
          'function getCotizacion(OidMoneda : integer) : currency;'
          'begin'
          '          '
          
            'if (getVariable().getInteger('#39'oid_moneda_curso_legal'#39')=OidMoneda' +
            ')  '
          '   then begin'
          '        result := 1;'
          '        end '
          '   else begin'
          '        CompoCotizaciones.setInteger('#39'pOidMoneda'#39',OidMoneda);'
          
            '        CompoCotizaciones.externalCall('#39'getCotizacionMoneda'#39','#39#39')' +
            ';'
          '        result := CompoCotizaciones.getCurrency('#39'pCotizacion'#39');'
          '        end;'
          'end; '
          ''
          ''
          'function getConvAMoneda(Importe : currency ;'
          
            '                                           OidMonedaOri : intege' +
            'r;'
          #9#9'           OidMonedaDest : integer) : currency;'
          'var'
          '   cotizOri   : currency;'
          '   cotizDest  : currency;'
          '   importeConv : currency;'
          'begin'
          '   '
          '   cotizOri  := getCotizacion(OidMonedaOri);'
          '   if (cotizOri = 0)'
          
            '       then raiseexception(erCustomError, '#39'Falta cargar la cotiz' +
            'aci'#243'n para la moneda '#39'+getDescMoneda(OidMonedaOri));'
          '   cotizDest := getCotizacion(OidMonedaDest);'
          '   if (cotizDest = 0)'
          
            '      then raiseexception(erCustomError, '#39'Falta cargar la cotiza' +
            'ci'#243'n para la moneda '#39'+getDescMoneda(OidMonedaDest));'
          
            '    importeConv := Varios.Redondear((Importe * cotizOri) / cotiz' +
            'Dest,2);'
          '    result := importeConv;'
          ''
          'end;'
          ''
          ''
          'function getCodUM(OidUM : integer) : string;'
          'begin'
          '  TUnidadMedida.First;'
          '  if (TUnidadMedida.Locate('#39'oid'#39',OidUM,[]))'
          '     then result := TUnidadMedida.FieldName('#39'codigo'#39').AsString'
          '     else result := '#39#39';'
          'end;'
          ''
          
            'procedure TraerFormacionPrecioProducto(oidProducto : integer);be' +
            'gin  '
          ''
          '  if (oidProducto = 0)'
          '     then begin'
          '             exit;'
          '             end;          '
          ''
          
            '   if (TFormacionPrecios.FieldName('#39'oid_lp'#39').Value = null)      ' +
            '    '
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Lista d' +
            'e Precios'#39');'
          ''
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFormacionPreciosLPProdGral'#39');'
          '  operacion.AddAtribute('#39'NO_INCLUIR_CAB'#39','#39#39');'
          '  operacion.AddAtribute('#39'nombre_table'#39','#39'TFormacionPreciosDet'#39');'
          '  operacion.AddAtribute('#39'oid_producto'#39', IntToStr(OidProducto));'
          
            '  operacion.AddAtribute('#39'oid'#39', TFormacionPrecios.FieldName('#39'oid_' +
            'lp'#39').AsString);'
          '  CompoCotizaciones.ExternalCall('#39'TraerDataSetCotizacion'#39','#39#39'); '
          
            '  operacion.AddDataSet(CompoCotizaciones.getVarTable('#39'pTCotizaci' +
            'ones'#39').getDataSet); '
          '  operacion.execute();'
          ''
          '  TProductosLP.desHabilitarAllEvents();'
          ''
          '  try'
          ''
          '  TProductosLP.EditRecord;'
          
            '  TProductosLP.FieldName('#39'cant_decimales'#39').AsInteger := TFormaci' +
            'onPreciosDet.FieldName('#39'cant_decimales'#39').AsInteger;'
          
            '  TProductosLP.FieldName('#39'costo'#39').AsCurrency := TFormacionPrecio' +
            'sDet.FieldName('#39'costo'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'oid_moneda_costo'#39').AsInteger := TForma' +
            'cionPreciosDet.FieldName('#39'oid_moneda_costo'#39').AsInteger;'
          
            '  TProductosLP.FieldName('#39'porc_rent_actual'#39').AsCurrency := TForm' +
            'acionPreciosDet.FieldName('#39'porc_rent_actual'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'precio_venta'#39').AsCurrency := TFormacio' +
            'nPreciosDet.FieldName('#39'precio_venta'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'precio_venta_con_iva'#39').AsCurrency := T' +
            'FormacionPreciosDet.FieldName('#39'precio_venta_con_iva'#39').AsCurrency' +
            ';'
          
            '  TProductosLP.FieldName('#39'oid_moneda_pv'#39').AsInteger := TFormacio' +
            'nPreciosDet.FieldName('#39'oid_moneda_pv'#39').AsInteger;'
          
            '  TProductosLP.FieldName('#39'nuevo_porc_rent'#39').AsCurrency := TForma' +
            'cionPreciosDet.FieldName('#39'nuevo_porc_rent'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'nuevo_precio_vta'#39').AsCurrency := TForm' +
            'acionPreciosDet.FieldName('#39'nuevo_precio_vta'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'fec_ult_costo'#39').Value := TFormacionPre' +
            'ciosDet.FieldName('#39'fec_ult_costo'#39').Value;'
          
            '  TProductosLP.FieldName('#39'cant_costo'#39').AsCurrency := TFormacionP' +
            'reciosDet.FieldName('#39'cant_costo'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'oid_um_costo'#39').AsInteger := TFormacion' +
            'PreciosDet.FieldName('#39'oid_um_costo'#39').AsInteger;'
          
            '  TProductosLP.FieldName('#39'fec_ult_pv'#39').Value := TFormacionPrecio' +
            'sDet.FieldName('#39'fec_ult_pv'#39').Value;'
          
            '  TProductosLP.FieldName('#39'cant_pv'#39').AsCurrency := TFormacionPrec' +
            'iosDet.FieldName('#39'cant_pv'#39').AsCurrency;'
          
            '  TProductosLP.FieldName('#39'oid_um_pv'#39').AsInteger := TFormacionPre' +
            'ciosDet.FieldName('#39'oid_um_pv'#39').AsInteger;'
          
            '  TProductosLP.FieldName('#39'titulo'#39').AsString := TFormacionPrecios' +
            'Det.FieldName('#39'titulo'#39').AsString;'
          ' '
          ''
          '  finally '
          ''
          '  TProductosLP.HabilitarAllEvents();'
          ''
          '   end;'
          ''
          '   dxDBGrilla.gotoFirstRecord;'
          ''
          ''
          'end;'
          ''
          ''
          ''
          'procedure TraerPreciosLP();'
          'begin  '
          ''
          '  TFormacionPrecios.PostRecord;'
          '  TValoresClasificadores.PostRecord;'
          ''
          '  if (TFormacionPrecios.FieldName('#39'oid_lp'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Lista d' +
            'e Precios'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFormacionPreciosLPProdGral'#39');'
          ''
          '  if (TFormacionPrecios.FieldName('#39'oid_lp'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid'#39', TFormacionPrecios.FieldNa' +
            'me('#39'oid_lp'#39').AsString);'
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'oid_clasif_presen'#39').AsInteger' +
            '>0)'
          
            '      then operacion.AddAtribute('#39'oid_clasif_presen'#39', TFormacion' +
            'Precios.FieldName('#39'oid_clasif_presen'#39').AsString);'
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'codigo_producto'#39').AsString<>'#39 +
            #39')'
          
            '      then operacion.AddAtribute('#39'cod_producto'#39', TFormacionPreci' +
            'os.FieldName('#39'codigo_producto'#39').AsString);'
          ''
          '  if (TFormacionPrecios.FieldName('#39'desc_producto'#39').AsString<>'#39#39')'
          
            '      then operacion.AddAtribute('#39'desc_producto'#39', TFormacionPrec' +
            'ios.FieldName('#39'desc_producto'#39').AsString);'
          ''
          ' operacion.AddDataSet(TClasificadorEntidad.getDataSet());'
          ' CompoCotizaciones.ExternalCall('#39'TraerDataSetCotizacion'#39','#39#39'); '
          
            ' operacion.AddDataSet(CompoCotizaciones.getVarTable('#39'pTCotizacio' +
            'nes'#39').getDataSet); '
          ' operacion.execute();'
          ''
          ' PageControl1.setActivePageName('#39'PageName1'#39');'
          ''
          '   dxDBGrilla.gotoFirstRecord;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure TraerClasificadoresProducto();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifProdGen'#39');'
          '  operacion.addAtribute('#39'inicializarClasificadores'#39','#39#39');'
          '  operacion.execute;'
          'end;'
          ''
          ''
          'procedure MostrarHelpValoresClasificador();'
          'begin'
          
            '  HelpValoresClasificador.NickName :=  TClasificadorEntidad.Fiel' +
            'dName('#39'nickname'#39').AsString;'
          
            '  HelpValoresClasificador.NroClasificador    :=  TClasificadorEn' +
            'tidad.FieldName('#39'nro_clasif'#39').AsInteger;'
          '  HelpValoresClasificador.Mostrar();'
          'end;'
          ''
          ''
          'procedure MostrarHelpProducto();'
          'begin'
          '   HelpProductos.clearParams();'
          '   HelpProductos.addParam('#39'vendible'#39','#39#39');'
          '   HelpProductos.Mostrar();'
          'end;'
          ''
          'procedure ValidarProducto(Codigo : string);'
          'begin  '
          '  if (Trim(Codigo)='#39#39')'
          '     then begin'
          '             TProductosLP.EditRecord;'
          '             TProductosLP.FieldName('#39'oid_producto'#39').Clear;'
          '             TProductosLP.FieldName('#39'desc_producto'#39').Clear;'
          '             end'
          '     else begin'
          '            operacion.InicioOperacion;'
          '            operacion.setOper('#39'ValidarProducto'#39');'
          '            operacion.addAtribute('#39'vendible'#39','#39#39');'
          '            operacion.addAtribute('#39'codigo'#39',Codigo);'
          '            operacion.execute; '
          ''
          '            TProductosLP.EditRecord;'
          '            TProductosLP.FieldName('#39'oid_producto'#39').AsInteger := '
          '                 TValProducto.FieldName('#39'oid'#39').AsInteger;'
          '            TProductosLP.FieldName('#39'desc_producto'#39').AsString := '
          '                TValProducto.FieldName('#39'descripcion'#39').AsString;'
          '             end;'
          ''
          'end;'
          ''
          'procedure calcPrecioEnBaseAPorcRent();'
          'var'
          '  cantDecimales , cantDecimalesSinIVA : integer;'
          '  nuevoPrecio : currency;'
          '  costo : currency;'
          '  costoEnUMVta : currency;'
          '  nuevoPrecioConIVA : currency;'
          'begin'
          ''
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'aplicar_cant_decimales'#39').AsBo' +
            'olean)'
          
            '     then cantDecimales :=TFormacionPrecios.FieldName('#39'cant_deci' +
            'males'#39').AsInteger'
          
            '     else cantDecimales := TProductosLP.FieldName('#39'cant_decimale' +
            's'#39').AsInteger;'
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'aplicar_cant_decimales_sin_iv' +
            'a'#39').AsBoolean)'
          
            '     then cantDecimalesSinIVA :=TFormacionPrecios.FieldName('#39'can' +
            't_decimales_sin_iva'#39').AsInteger'
          '     else cantDecimalesSinIVA := 2;'
          ''
          '  costoEnUMVta := getCostoEnUMVta();'
          ''
          '  costo :='
          '     getConvAMoneda(costoEnUMVta,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_costo'#39').As' +
            'Integer,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_pv'#39').AsInt' +
            'eger) '
          ''
          ''
          
            '  nuevoPrecio := varios.redondear(costo * (1+(TProductosLP.Field' +
            'Name('#39'nuevo_porc_rent'#39').AsCurrency/100)),cantDecimalesSinIVA);'
          
            '  nuevoPrecioConIVA := nuevoPrecio * (1+(TProductosLP.fieldName(' +
            #39'porc_iva'#39').AsCurrency/100));'
          ''
          '  TProductosLP.desHabilitarEventoOnChange('#39'nuevo_precio_vta'#39');'
          
            '  TProductosLP.desHabilitarEventoOnChange('#39'nuevo_precio_vta_con_' +
            'iva'#39');'
          ''
          '  try'
          ''
          '     TProductosLP.EditRecord;'
          
            '     TProductosLP.FieldName('#39'nuevo_precio_vta'#39').AsCurrency :=  n' +
            'uevoPrecio;'
          
            '     TProductosLP.FieldName('#39'nuevo_precio_vta_con_iva'#39').AsCurren' +
            'cy :=  varios.redondear(nuevoPrecioConIVA,cantDecimales);'
          ''
          '  finally'
          ''
          
            '    TProductosLP.HabilitarEventoOnChange('#39'nuevo_precio_vta'#39');   ' +
            ' '
          
            '    TProductosLP.HabilitarEventoOnChange('#39'nuevo_precio_vta_con_i' +
            'va'#39');    '
          ''
          '  end;'
          ''
          'end;'
          ''
          'procedure calcNuevoPorcRentyPrecioSinIVA();'
          'var'
          '  nuevoPorcRent : currency;  '
          '  costo : currency;'
          '  costoEnUMVta  : currency;'
          '  nuevoPrecioVtaSinIVA : currency;'
          '  cantDecimales  , cantDecimalesSinIVA: integer;'
          'begin'
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'aplicar_cant_decimales'#39').AsBo' +
            'olean)'
          
            '     then cantDecimales :=TFormacionPrecios.FieldName('#39'cant_deci' +
            'males'#39').AsInteger'
          
            '     else cantDecimales := TProductosLP.FieldName('#39'cant_decimale' +
            's'#39').AsInteger;'
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'aplicar_cant_decimales_sin_iv' +
            'a'#39').AsBoolean)'
          
            '     then cantDecimalesSinIVA :=TFormacionPrecios.FieldName('#39'can' +
            't_decimales_sin_iva'#39').AsInteger'
          '     else cantDecimalesSinIVA := 2;'
          ''
          '  costoEnUMVta := getCostoEnUMVta();'
          ''
          '  costo :='
          '     getConvAMoneda(costoEnUMVta,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_costo'#39').As' +
            'Integer,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_pv'#39').AsInt' +
            'eger);'
          ''
          
            '  nuevoPrecioVtaSinIVA :=  varios.redondear(TProductosLP.FieldNa' +
            'me('#39'nuevo_precio_vta_con_iva'#39').AsCurrency / (1+(TProductosLP.fie' +
            'ldName('#39'porc_iva'#39').AsCurrency/100)),cantDecimalesSinIVA);'
          ''
          '  nuevoPorcRent := nuevoPrecioVtaSinIVA - costo;'
          ''
          '  if (costo = 0)'
          '      then nuevoPorcRent := 100'
          
            '      else nuevoPorcRent := varios.redondear((nuevoPorcRent / co' +
            'sto)*100,2);'
          ''
          '  TProductosLP.desHabilitarEventoOnChange('#39'nuevo_porc_rent'#39');'
          '  TProductosLP.desHabilitarEventoOnChange('#39'nuevo_precio_vta'#39');'
          ''
          '  try'
          ''
          '  TProductosLP.EditRecord;'
          
            '  TProductosLP.FieldName('#39'nuevo_porc_rent'#39').AsCurrency :=  vario' +
            's.redondear(nuevoPorcRent,2);'
          
            '  TProductosLP.FieldName('#39'nuevo_precio_vta'#39').AsCurrency := nuevo' +
            'PrecioVtaSinIVA;'
          ''
          '  finally'
          ''
          '  TProductosLP.HabilitarEventoOnChange('#39'nuevo_porc_rent'#39');    '
          '  TProductosLP.HabilitarEventoOnChange('#39'nuevo_precio_vta'#39');    '
          ''
          ''
          ''
          '  end;'
          ''
          'end;'
          ''
          ''
          ''
          ''
          'procedure calcNuevoPorcRent();'
          'var'
          '  nuevoPorcRent : currency;  '
          '  costo : currency;'
          '  costoEnUMVta  : currency;'
          '  nuevoPrecioVtaConIVA : currency;'
          '  cantDecimales : integer;'
          'begin'
          ''
          
            '  if (TFormacionPrecios.FieldName('#39'aplicar_cant_decimales'#39').AsBo' +
            'olean)'
          
            '     then cantDecimales :=TFormacionPrecios.FieldName('#39'cant_deci' +
            'males'#39').AsInteger'
          
            '     else cantDecimales := TProductosLP.FieldName('#39'cant_decimale' +
            's'#39').AsInteger;'
          ''
          ''
          '  costoEnUMVta := getCostoEnUMVta();'
          ''
          '  costo :='
          '     getConvAMoneda(costoEnUMVta,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_costo'#39').As' +
            'Integer,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_pv'#39').AsInt' +
            'eger) '
          ''
          
            '  nuevoPorcRent := TProductosLP.FieldName('#39'nuevo_precio_vta'#39').As' +
            'Currency - costo'
          ''
          '  if (costo = 0)'
          '      then nuevoPorcRent := 100'
          
            '      else nuevoPorcRent := varios.redondear((nuevoPorcRent / co' +
            'sto)*100,2);'
          ''
          '   nuevoPrecioVtaConIVA := '
          
            '      TProductosLP.FieldName('#39'nuevo_precio_vta'#39').AsCurrency * (1' +
            '+(TProductosLP.fieldName('#39'porc_iva'#39').AsCurrency/100));'
          ''
          '  TProductosLP.desHabilitarEventoOnChange('#39'nuevo_porc_rent'#39');'
          
            '  TProductosLP.desHabilitarEventoOnChange('#39'nuevo_precio_vta_con_' +
            'iva'#39');'
          ''
          '  try'
          ''
          '  TProductosLP.EditRecord;'
          
            '  TProductosLP.FieldName('#39'nuevo_porc_rent'#39').AsCurrency :=  vario' +
            's.redondear(nuevoPorcRent,2);'
          
            '  TProductosLP.FieldName('#39'nuevo_precio_vta_con_iva'#39').AsCurrency ' +
            ':= varios.redondear(nuevoPrecioVtaConIVA,cantDecimales);'
          ''
          '  finally'
          ''
          '  TProductosLP.HabilitarEventoOnChange('#39'nuevo_porc_rent'#39');    '
          
            '  TProductosLP.HabilitarEventoOnChange('#39'nuevo_precio_vta_con_iva' +
            #39');    '
          ''
          ''
          ''
          '  end;'
          ''
          'end;'
          ''
          'procedure CalcCambioCosto();'
          'var'
          '  PorcRent : currency;  '
          '  costo : currency;'
          '  costoEnUMVta : currency;'
          'begin'
          ''
          ''
          '  // CALCULAR NUEVO PORCENTAJE DE RENTABILIDAD'
          ''
          '  costoEnUMVta := getCostoEnUMVta();'
          ''
          ''
          '  costo :='
          '     getConvAMoneda(costoEnUMVta,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_costo'#39').As' +
            'Integer,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_pv'#39').AsInt' +
            'eger) '
          ''
          
            '  PorcRent := TProductosLP.FieldName('#39'precio_venta'#39').AsCurrency ' +
            '- costo;'
          ''
          '  if (costo = 0)'
          '      then PorcRent := 100'
          
            '      else PorcRent := varios.redondear((PorcRent / costo)*100,2' +
            ');'
          ''
          ''
          '  TProductosLP.desHabilitarEventoOnChange('#39'porc_rent_actual'#39');'
          '  '
          '  try'
          ''
          '  TProductosLP.EditRecord;'
          
            '  TProductosLP.FieldName('#39'porc_rent_actual'#39').AsCurrency :=  vari' +
            'os.redondear(PorcRent,2);'
          ''
          '  finally'
          ''
          '  TProductosLP.HabilitarEventoOnChange('#39'porc_rent_actual'#39');    '
          ''
          '  end;'
          ''
          '  calcPrecioEnBaseAPorcRent();'
          ''
          'end;'
          ''
          'procedure cargarCotizacionDeHoy();'
          'begin'
          '  CompoCotizaciones.setString('#39'pFecha'#39',varios.getFecha());'
          
            '  CompoCotizaciones.setInteger('#39'pOidTipoCambio'#39',Varios.getParamO' +
            'idObjNeg('#39'TIPO_CAMBIO_FORM_PRECIO'#39'));'
          '  CompoCotizaciones.Externalcall('#39'cargarCotizaciones'#39','#39#39');  '
          'end;'
          ''
          ''
          'procedure calcPorcRentActual();'
          'var'
          '  porcRentActual : currency;  '
          '  costo : currency;'
          '  costoEnUMVta : currency;'
          'begin'
          ''
          '  costoEnUMVta := getCostoEnUMVta();'
          ''
          '  costo :='
          '     getConvAMoneda(costoEnUMVta,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_costo'#39').As' +
            'Integer,'
          
            '                   TProductosLP.FieldName('#39'oid_moneda_pv'#39').AsInt' +
            'eger) '
          ''
          
            '  porcRentActual := TProductosLP.FieldName('#39'precio_venta'#39').AsCur' +
            'rency - costo'
          ''
          '  if (costo = 0)'
          '      then porcRentActual := 100'
          
            '      else porcRentActual := varios.redondear((porcRentActual / ' +
            'costo)*100,2);'
          ''
          ''
          '  TProductosLP.desHabilitarEventoOnChange('#39'porc_rent_actual'#39');'
          '  '
          '  try'
          ''
          '  TProductosLP.EditRecord;'
          
            '  TProductosLP.FieldName('#39'porc_rent_actual'#39').AsCurrency :=  vari' +
            'os.redondear(porcRentActual,2);'
          ''
          '  finally'
          ''
          '  TProductosLP.HabilitarEventoOnChange('#39'porc_rent_actual'#39');    '
          ''
          '  end;'
          ''
          'end;'
          ''
          ''
          '')
      end>
    OnBeforeNuevo = <
      item
        Source.Strings = (
          'begin'
          '  PageControl1.setActivePageName('#39'TabSheet1'#39');'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'LVerCotizaciones'
        Source.Strings = (
          'begin'
          '  if (not driverabm.isNuevo) then exit;'
          '  CompoCotizaciones.Externalcall('#39'mostrar'#39','#39#39');'
          'end.')
      end
      item
        ButtonName = 'ImagenSiguiente'
        Source.Strings = (
          'begin'
          '  HelpProductoGral.proximo();'
          '  if (HelpProductoGral.getOidValorClasifActivo()>0)'
          
            '      then DriverABM.buscarObjetoByOid(HelpProductoGral.getOidVa' +
            'lorClasifActivo());'
          'end.')
      end
      item
        ButtonName = 'ImagenAnterior'
        Source.Strings = (
          'begin'
          '  HelpProductoGral.anterior();'
          '  if (HelpProductoGral.getOidValorClasifActivo()>0)'
          
            '      then DriverABM.buscarObjetoByOid(HelpProductoGral.getOidVa' +
            'lorClasifActivo());'
          'end.'
          '')
      end>
    OnAddAtributeHelp = <
      item
        HelpName = 'HelpClasificadores'
        Source.Strings = (
          'begin'
          '  operacion.addAtribute('#39'nickname'#39','#39'st.ExtensionProdGen'#39');'
          'end.')
      end>
    Left = 632
    Top = 119
  end
  inherited SaveArchivo: TSaveDialog
    Left = 712
    Top = 120
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 593
    Top = 120
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 72
    Top = 267
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 560
    Top = 123
  end
  object HelpListasPrecios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.ListaPrecios'
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
    Titulo = 'Listas de Precios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorDeposito: TValidador
    Operacion = Operacion
    NickNameObjLog = 'st.Deposito'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Dep'#243'sito Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object HelpEstadosStock: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'st.EstadoStock'
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
    Titulo = 'Estados Stock'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 410
    Top = 230
  end
  object TEstadoStock: TsnTable
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
    Left = 445
    Top = 230
    object TEstadoStockoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEstadoStockcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TEstadoStockdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TAgrupadorEstados: TsnTable
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
    Left = 448
    Top = 265
    object TAgrupadorEstadosoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAgrupadorEstadoscodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TAgrupadorEstadosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
  end
  object DSAgrupadoresEstado: TDataSource
    DataSet = TAgrupadorEstados
    Left = 486
    Top = 263
  end
  object HelpAgrupadoresEstado: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'st.AgrupadorEstadoStock'
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
    Titulo = 'Agrupador Estados de Stock'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 410
    Top = 266
  end
  object HelpDepositos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'st.Deposito'
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
    Titulo = 'Depositos'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 410
    Top = 186
  end
  object TDepositos: TsnTable
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
    Left = 445
    Top = 186
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSDepositos: TDataSource
    DataSet = TDepositos
    Left = 480
    Top = 185
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 122
    Top = 288
  end
  object HelpClasificadores: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.ClasificadorEntidad'
    NroHelp = 102
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
        AsignarACampo = TFormacionPrecioscod_clasif_presen
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
    Titulo = 'Clasificadores de Productos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 410
    Top = 313
  end
  object ValidadorClasificadorEntidad: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ge.ClasificadorEntidad'
    MensajeException = 'C'#243'digo de Clasificador Inexistente'
    CampoOID = TFormacionPreciosoid_clasif_presen
    CampoDescripcion = TFormacionPreciosdesc_clasif_presen
    NroQuery = 103
    Cache = False
    Left = 454
    Top = 315
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
        Name = 'oid_producto'
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
    IndexFieldNames = 'oid_producto'
    IndexDefs = <
      item
        Name = 'TValoresClasificadoresIndex1'
        Fields = 'oid_producto'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_producto'
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 614
    Top = 332
    object TValoresClasificadoresoid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoresoid_producto: TIntegerField
      FieldName = 'oid_producto'
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
    Left = 646
    Top = 332
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
    Left = 614
    Top = 364
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      DisplayWidth = 255
      FieldName = 'descripcion'
      Size = 255
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
  object TClasificadorEntidad: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'oid_producto'
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
    Left = 614
    Top = 300
    object TClasificadorEntidadoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TClasificadorEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TClasificadorEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TClasificadorEntidadnickname: TStringField
      FieldName = 'nickname'
      Size = 50
    end
    object TClasificadorEntidadobligatorio: TBooleanField
      FieldName = 'obligatorio'
    end
    object TClasificadorEntidadoid_val_default: TIntegerField
      FieldName = 'oid_val_default'
    end
    object TClasificadorEntidadactivo: TBooleanField
      FieldName = 'activo'
    end
    object TClasificadorEntidadnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TClasificadorEntidadcod_valor_default: TStringField
      DisplayWidth = 50
      FieldName = 'cod_valor_default'
      Size = 50
    end
    object TClasificadorEntidaddesc_valor_default: TStringField
      FieldName = 'desc_valor_default'
      Size = 100
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
    object TClasificadorEntidadoid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
    end
    object TClasificadorEntidadcod_valor_clasif: TStringField
      FieldName = 'cod_valor_clasif'
      Size = 50
    end
    object TClasificadorEntidaddesc_valor_clasif: TStringField
      FieldName = 'desc_valor_clasif'
      Size = 100
    end
  end
  object dsTClasificadorEntidad: TDataSource
    DataSet = TClasificadorEntidad
    Left = 646
    Top = 300
  end
  object HelpValoresClasificador: THelpValoresClasificador
    AsignarCampoCodigo = TClasificadorEntidadcod_valor_clasif
    NroClasificador = 0
    Left = 224
    Top = 417
  end
  object TFormacionPreciosDet: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_formacion_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_formacion_precio'
        DataType = ftInteger
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_producto'
        DataType = ftInteger
      end
      item
        Name = 'cod_producto'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_producto'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'fec_ult_costo'
        DataType = ftDate
      end
      item
        Name = 'oid_moneda_costo'
        DataType = ftInteger
      end
      item
        Name = 'cod_moneda_costo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'simbolo_mon_costo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'cant_costo'
        DataType = ftCurrency
      end
      item
        Name = 'oid_um_costo'
        DataType = ftInteger
      end
      item
        Name = 'cod_um_costo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'costo'
        DataType = ftCurrency
      end
      item
        Name = 'fec_ult_pv'
        DataType = ftDate
      end
      item
        Name = 'oid_moneda_pv'
        DataType = ftInteger
      end
      item
        Name = 'cod_moneda_pv'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'simbolo_mon_pv'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'cant_pv'
        DataType = ftCurrency
      end
      item
        Name = 'oid_um_pv'
        DataType = ftInteger
      end
      item
        Name = 'cod_um_pv'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'precio_venta'
        DataType = ftCurrency
      end
      item
        Name = 'porc_rent_actual'
        DataType = ftCurrency
      end
      item
        Name = 'nuevo_porc_rent'
        DataType = ftCurrency
      end
      item
        Name = 'nuevo_precio_vta'
        DataType = ftCurrency
      end>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSFormacionPrecios
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'C'#243'digo de Producto ya ingresado'
    Left = 688
    Top = 94
    object TFormacionPreciosDetoid_formacion_det: TIntegerField
      FieldName = 'oid_formacion_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFormacionPreciosDetoid_formacion_precio: TIntegerField
      FieldName = 'oid_formacion_precio'
    end
    object TFormacionPreciosDettitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TFormacionPreciosDetoid_producto: TIntegerField
      FieldName = 'oid_producto'
    end
    object TFormacionPreciosDetcod_producto: TStringField
      FieldName = 'cod_producto'
      Size = 50
    end
    object TFormacionPreciosDetdesc_producto: TStringField
      FieldName = 'desc_producto'
      Size = 255
    end
    object TFormacionPreciosDetfec_ult_costo: TDateField
      FieldName = 'fec_ult_costo'
    end
    object TFormacionPreciosDetoid_moneda_costo: TIntegerField
      FieldName = 'oid_moneda_costo'
    end
    object TFormacionPreciosDetcod_moneda_costo: TStringField
      FieldName = 'cod_moneda_costo'
      Size = 50
    end
    object TFormacionPreciosDetsimbolo_mon_costo: TStringField
      FieldName = 'simbolo_mon_costo'
      Size = 10
    end
    object TFormacionPreciosDetcant_costo: TCurrencyField
      FieldName = 'cant_costo'
    end
    object TFormacionPreciosDetoid_um_costo: TIntegerField
      FieldName = 'oid_um_costo'
    end
    object TFormacionPreciosDetcod_um_costo: TStringField
      FieldName = 'cod_um_costo'
    end
    object TFormacionPreciosDetcosto: TCurrencyField
      FieldName = 'costo'
    end
    object TFormacionPreciosDetfec_ult_pv: TDateField
      FieldName = 'fec_ult_pv'
    end
    object TFormacionPreciosDetoid_moneda_pv: TIntegerField
      FieldName = 'oid_moneda_pv'
    end
    object TFormacionPreciosDetcod_moneda_pv: TStringField
      FieldName = 'cod_moneda_pv'
      Size = 50
    end
    object TFormacionPreciosDetsimbolo_mon_pv: TStringField
      FieldName = 'simbolo_mon_pv'
    end
    object TFormacionPreciosDetcant_pv: TCurrencyField
      FieldName = 'cant_pv'
    end
    object TFormacionPreciosDetoid_um_pv: TIntegerField
      FieldName = 'oid_um_pv'
    end
    object TFormacionPreciosDetcod_um_pv: TStringField
      FieldName = 'cod_um_pv'
      Size = 50
    end
    object TFormacionPreciosDetprecio_venta: TCurrencyField
      FieldName = 'precio_venta'
    end
    object TFormacionPreciosDetporc_rent_actual: TCurrencyField
      FieldName = 'porc_rent_actual'
    end
    object TFormacionPreciosDetnuevo_porc_rent: TCurrencyField
      FieldName = 'nuevo_porc_rent'
    end
    object TFormacionPreciosDetnuevo_precio_vta: TCurrencyField
      FieldName = 'nuevo_precio_vta'
    end
    object TFormacionPreciosDetleyenda_costo: TStringField
      FieldName = 'leyenda_costo'
    end
    object TFormacionPreciosDetleyenda_precio_venta: TStringField
      FieldName = 'leyenda_precio_venta'
    end
    object TFormacionPreciosDetcant_decimales: TIntegerField
      FieldName = 'cant_decimales'
    end
    object TFormacionPreciosDetfec_costo: TDateField
      FieldName = 'fec_costo'
    end
    object TFormacionPreciosDetprecio_venta_con_iva: TCurrencyField
      FieldName = 'precio_venta_con_iva'
    end
  end
  object DSFormacionPreciosDet: TDataSource
    DataSet = TFormacionPreciosDet
    Left = 720
    Top = 95
  end
  object HelpProductos: TCustomHelp
    Acepto = False
    Oid = 0
    HelpName = 'TFHelpProductos'
    AsignarCodigoA = TProductosLPcod_producto
    CacheForm = False
    Left = 288
    Top = 295
  end
  object TValProducto: TsnTable
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
    Left = 228
    Top = 295
    object TValProductooid: TIntegerField
      FieldName = 'oid'
    end
    object TValProductocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TValProductodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TValProductodesc_abrev: TStringField
      FieldName = 'desc_abrev'
      Size = 50
    end
    object TValProductocomprable: TBooleanField
      FieldName = 'comprable'
    end
    object TValProductovendible: TBooleanField
      FieldName = 'vendible'
    end
    object TValProductostockeable: TBooleanField
      FieldName = 'stockeable'
    end
    object TValProductoprodPropia: TBooleanField
      FieldName = 'prodPropia'
    end
    object TValProductoimportado: TBooleanField
      FieldName = 'importado'
    end
    object TValProductosinonimo: TStringField
      FieldName = 'sinonimo'
      Size = 50
    end
    object TValProductocodigo_barra: TStringField
      FieldName = 'codigo_barra'
      Size = 50
    end
    object TValProductooid_um_vta: TIntegerField
      FieldName = 'oid_um_vta'
    end
    object TValProductooid_um_stk: TIntegerField
      FieldName = 'oid_um_stk'
    end
    object TValProductooid_um_stk_alt: TIntegerField
      FieldName = 'oid_um_stk_alt'
    end
    object TValProductooid_um_cpra: TIntegerField
      FieldName = 'oid_um_cpra'
    end
    object TValProductooid_um_prod: TIntegerField
      FieldName = 'oid_um_prod'
    end
    object TValProductotol_recep: TCurrencyField
      FieldName = 'tol_recep'
    end
    object TValProductoporc_cump_oc: TCurrencyField
      FieldName = 'porc_cump_oc'
    end
    object TValProductosistema_calidad: TBooleanField
      FieldName = 'sistema_calidad'
    end
    object TValProductoai_cpra: TIntegerField
      FieldName = 'ai_cpra'
    end
    object TValProductomodif_ai_cpra: TBooleanField
      FieldName = 'modif_ai_cpra'
    end
    object TValProductoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValProductooid_tipo_producto: TIntegerField
      FieldName = 'oid_tipo_producto'
    end
    object TValProductolt_entrega: TIntegerField
      FieldName = 'lt_entrega'
    end
    object TValProductooid_conc_fact_prov: TIntegerField
      FieldName = 'oid_conc_fact_prov'
    end
    object TValProductolleva_partida: TBooleanField
      FieldName = 'lleva_partida'
    end
    object TValProductolleva_serie: TBooleanField
      FieldName = 'lleva_serie'
    end
    object TValProductonro: TIntegerField
      FieldName = 'nro'
    end
  end
  object HelpUnidadMedida: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'st.UnidadMedida'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 408
    Top = 369
  end
  object TUnidadMedida: TsnTable
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
    Left = 442
    Top = 369
    object TUnidadMedidaoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TUnidadMedidacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TUnidadMedidadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TTraerStockProd: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <
      item
        Name = 'TDetInventarioIndex1'
        Fields = 'oid_inventario'
      end>
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
    Left = 539
    Top = 374
    object IntegerField2: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'oid_det_inventario'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_inventario'
    end
    object StringField3: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_producto'
    end
    object StringField4: TStringField
      FieldName = 'cod_producto'
      Size = 50
    end
    object StringField5: TStringField
      FieldName = 'desc_producto'
      Size = 255
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_um'
    end
    object StringField6: TStringField
      FieldName = 'cod_um'
      Size = 50
    end
    object CurrencyField1: TCurrencyField
      FieldName = 'fisico'
      DisplayFormat = '###,###,###,###.##'
    end
    object BooleanField1: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'sin_stock'
    end
    object CurrencyField2: TCurrencyField
      FieldName = 'conteo'
      DisplayFormat = '###,###,###,###.##'
    end
    object CurrencyField3: TCurrencyField
      FieldName = 'diferencia'
      DisplayFormat = '###,###,###,###.##'
    end
    object StringField7: TStringField
      FieldName = 'observacion'
      Size = 255
    end
  end
  object PopMenuDetInv: TsnPopMenu
    Left = 211
    Top = 374
    object EliminarDetInventario: TMenuItem
      Caption = 'Eliminar'
    end
    object Expandirtodo: TMenuItem
      Caption = 'Expandir todo'
    end
    object ContraerTodo: TMenuItem
      Caption = 'Contraer Todo'
    end
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
    end
    object cxStyle2: TcxStyle
    end
    object cxStyle3: TcxStyle
      AssignedValues = [svColor]
      Color = 15132390
    end
  end
  object HelpComprobantes: TCustomHelp
    Acepto = False
    Oid = 0
    HelpName = 'TFHelpInventario'
    CacheForm = False
    Left = 32
    Top = 96
  end
  object HelpListaPrecios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.ListaPrecios'
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
        AsignarACampo = TFormacionPrecioscod_lp
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
    Titulo = 'Lista de Precios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 74
    Top = 452
  end
  object ValidadorListaPrecio: TValidador
    Operacion = Operacion
    NickNameObjLog = 've.ListaPrecios'
    MensajeException = 'C'#243'digo Lista de Precios Inexistente'
    CampoOID = TFormacionPreciosoid_lp
    CampoDescripcion = TFormacionPreciosdesc_lp
    NroQuery = 0
    Cache = False
    Left = 111
    Top = 456
  end
  object TProductosLP: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_producto'
        DataType = ftInteger
      end
      item
        Name = 'cod_producto'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_producto'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'fec_ult_costo'
        DataType = ftDate
      end
      item
        Name = 'oid_moneda_costo'
        DataType = ftInteger
      end
      item
        Name = 'cod_moneda_costo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'simbolo_mon_costo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'cant_costo'
        DataType = ftCurrency
      end
      item
        Name = 'oid_um_costo'
        DataType = ftInteger
      end
      item
        Name = 'cod_um_costo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'costo'
        DataType = ftCurrency
      end
      item
        Name = 'fec_ult_pv'
        DataType = ftDate
      end
      item
        Name = 'oid_moneda_pv'
        DataType = ftInteger
      end
      item
        Name = 'cod_moneda_pv'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'simbolo_mon_pv'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'cant_pv'
        DataType = ftCurrency
      end
      item
        Name = 'oid_um_pv'
        DataType = ftInteger
      end
      item
        Name = 'cod_um_pv'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'precio_venta'
        DataType = ftCurrency
      end
      item
        Name = 'porc_rent_actual'
        DataType = ftCurrency
      end
      item
        Name = 'nuevo_porc_rent'
        DataType = ftCurrency
      end
      item
        Name = 'nuevo_precio_vta'
        DataType = ftCurrency
      end
      item
        Name = 'leyenda_costo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'leyenda_precio_venta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'cant_decimales'
        DataType = ftInteger
      end
      item
        Name = 'fec_costo'
        DataType = ftDate
      end
      item
        Name = 'nuevo_precio_vta_con_iva'
        DataType = ftCurrency
      end
      item
        Name = 'porc_iva'
        DataType = ftCurrency
      end
      item
        Name = 'precio_venta_con_iva'
        DataType = ftCurrency
      end
      item
        Name = 'oid_lp'
        DataType = ftInteger
      end
      item
        Name = 'cod_lp'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_lp'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_producto'
    IndexDefs = <
      item
        Name = 'TProductosLPIndex1'
        Fields = 'oid_producto'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_prod_gral'
    MasterSource = DSInput
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'C'#243'digo de Producto ya ingresado'
    Left = 608
    Top = 99
    object StringField8: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object IntegerField8: TIntegerField
      FieldName = 'oid_producto'
    end
    object TProductosLPcod_producto: TStringField
      FieldName = 'cod_producto'
      Size = 50
    end
    object StringField10: TStringField
      FieldName = 'desc_producto'
      Size = 255
    end
    object DateField1: TDateField
      FieldName = 'fec_ult_costo'
    end
    object IntegerField9: TIntegerField
      FieldName = 'oid_moneda_costo'
    end
    object StringField11: TStringField
      FieldName = 'cod_moneda_costo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'simbolo_mon_costo'
      Size = 10
    end
    object CurrencyField4: TCurrencyField
      FieldName = 'cant_costo'
    end
    object IntegerField10: TIntegerField
      FieldName = 'oid_um_costo'
    end
    object StringField13: TStringField
      FieldName = 'cod_um_costo'
    end
    object CurrencyField5: TCurrencyField
      FieldName = 'costo'
    end
    object DateField2: TDateField
      FieldName = 'fec_ult_pv'
    end
    object IntegerField11: TIntegerField
      FieldName = 'oid_moneda_pv'
    end
    object StringField14: TStringField
      FieldName = 'cod_moneda_pv'
      Size = 50
    end
    object StringField15: TStringField
      FieldName = 'simbolo_mon_pv'
    end
    object CurrencyField6: TCurrencyField
      FieldName = 'cant_pv'
    end
    object TProductosLPoid_um_pv: TIntegerField
      FieldName = 'oid_um_pv'
    end
    object StringField16: TStringField
      FieldName = 'cod_um_pv'
      Size = 50
    end
    object CurrencyField7: TCurrencyField
      FieldName = 'precio_venta'
    end
    object CurrencyField8: TCurrencyField
      FieldName = 'porc_rent_actual'
      DisplayFormat = '###,###.##'
    end
    object CurrencyField9: TCurrencyField
      FieldName = 'nuevo_porc_rent'
    end
    object CurrencyField10: TCurrencyField
      FieldName = 'nuevo_precio_vta'
    end
    object StringField17: TStringField
      FieldName = 'leyenda_costo'
    end
    object StringField18: TStringField
      FieldName = 'leyenda_precio_venta'
    end
    object TProductosLPcant_decimales: TIntegerField
      FieldName = 'cant_decimales'
    end
    object TProductosLPfec_costo: TDateField
      FieldName = 'fec_costo'
    end
    object TProductosLPnuevo_precio_vta_con_iva: TCurrencyField
      FieldName = 'nuevo_precio_vta_con_iva'
    end
    object TProductosLPporc_iva: TCurrencyField
      FieldName = 'porc_iva'
    end
    object TProductosLPprecio_venta_con_iva: TCurrencyField
      FieldName = 'precio_venta_con_iva'
    end
    object TProductosLPoid_lp: TIntegerField
      FieldName = 'oid_lp'
    end
    object TProductosLPcod_lp: TStringField
      FieldName = 'cod_lp'
      Size = 50
    end
    object TProductosLPdesc_lp: TStringField
      FieldName = 'desc_lp'
      Size = 100
    end
  end
  object DSProductosLP: TDataSource
    DataSet = TProductosLP
    Left = 640
    Top = 96
  end
  object HelpMonedas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.Moneda'
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
    Titulo = 'Monedas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 74
    Top = 412
  end
  object TMonedas: TsnTable
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
    Left = 106
    Top = 412
    object TMonedasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMonedascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMonedasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMonedas: TDataSource
    DataSet = TMonedas
    Left = 138
    Top = 413
  end
  object dsUniMed: TDataSource
    DataSet = TUnidadMedida
    Left = 570
    Top = 373
  end
  object CompoCotizaciones: TCustomCompo
    CustomFormName = 'TFCompoCotizacion'
    Left = 664
    Top = 202
  end
  object TCostoEnUMVta: TsnTable
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
    Left = 467
    Top = 438
    object TCostoEnUMVtacosto: TCurrencyField
      FieldName = 'costo'
    end
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_prod_gral'
        DataType = ftInteger
      end
      item
        Name = 'cod_prod_gral'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_prod_gral'
        DataType = ftString
        Size = 255
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
    Left = 456
    Top = 60
    object TInputoid_prod_gral: TIntegerField
      FieldName = 'oid_prod_gral'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TInputcod_prod_gral: TStringField
      FieldName = 'cod_prod_gral'
      Size = 50
    end
    object TInputdesc_prod_gral: TStringField
      FieldName = 'desc_prod_gral'
      Size = 255
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 488
    Top = 64
  end
  object HelpProductoGral: THelpValoresClasificador
    NickName = 'st.Producto'
    NroClasificador = 0
    Left = 93
    Top = 25
  end
  object TClasifProdGeneral: TsnTable
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
    Left = 288
    Top = 235
    object TClasifProdGeneraloid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TClasifProdGeneralnro_clasificador: TIntegerField
      FieldName = 'nro_clasificador'
    end
    object TClasifProdGeneraldescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
  end
  object HelpValoresClasificador1: THelpValoresClasificador
    NickName = 'st.Producto'
    NroClasificador = 0
    Left = 357
    Top = 233
  end
end
