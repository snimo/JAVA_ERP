inherited FCipINOUTOficina: TFCipINOUTOficina
  Left = 139
  Top = 84
  Width = 892
  Height = 553
  Caption = 'An'#225'lisis IN/OUT Oficina'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 876
    Height = 77
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 16
      Width = 65
      Height = 13
      Caption = 'Fecha desde:'
    end
    object Label2: TLabel
      Left = 275
      Top = 16
      Width = 62
      Height = 13
      Caption = 'Fecha hasta:'
    end
    object ImageBuscar: TImage
      Left = 771
      Top = 21
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = '<F12> Buscar Comprobantes'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 819
      Top = 21
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label4: TLabel
      Left = 248
      Top = 16
      Width = 16
      Height = 13
      Caption = 'Hrs'
      Visible = False
    end
    object Label5: TLabel
      Left = 512
      Top = 16
      Width = 16
      Height = 13
      Caption = 'Hrs'
      Visible = False
    end
    object Label3: TLabel
      Left = 16
      Top = 44
      Width = 35
      Height = 13
      Caption = 'Legajo:'
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 84
      Top = 12
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 347
      Top = 12
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      TabOrder = 2
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBLookup2: TsnDBLookup
      Left = 203
      Top = 12
      DataBinding.DataField = 'hora_desde'
      DataBinding.DataSource = DSInput
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSHoras
      TabOrder = 1
      Visible = False
      Width = 43
    end
    object snDBLookup3: TsnDBLookup
      Left = 466
      Top = 12
      DataBinding.DataField = 'hora_hasta'
      DataBinding.DataSource = DSInput
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSHoras
      TabOrder = 3
      Visible = False
      Width = 43
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 84
      Top = 40
      DataBinding.DataField = 'cod_legajo'
      DataBinding.DataSource = DSInput
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      TabOrder = 4
      Help = HelpLegajos
      Width = 121
    end
    object snDBEdit1: TsnDBEdit
      Left = 203
      Top = 40
      DataBinding.DataField = 'nombre_legajo'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 5
      Width = 326
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 77
    Width = 876
    Height = 438
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object Splitter1: TSplitter
      Left = 1
      Top = 185
      Width = 874
      Height = 5
      Cursor = crVSplit
      Align = alTop
      Color = clMoneyGreen
      ParentColor = False
    end
    object Panel3: TPanel
      Left = 1
      Top = 1
      Width = 874
      Height = 184
      Align = alTop
      TabOrder = 0
      object dxDBGridSN1: TdxDBGridSN
        Left = 1
        Top = 1
        Width = 872
        Height = 182
        Align = alClient
        TabOrder = 0
        CriteriosPintarCelda = <
          item
            TipoPintadaCelda = tpcSoloColumnaCampo
            FieldName1 = 'ok_permanencia_jornada'
            TipoCondFiltro1 = tcfIgual
            Valor1 = '?'
            TipoCondFiltro2 = tcfIgual
            Color = 12566527
          end
          item
            TipoPintadaCelda = tpcSoloColumnaCampo
            FieldName1 = 'ok_cant_sal'
            TipoCondFiltro1 = tcfIgual
            Valor1 = '?'
            TipoCondFiltro2 = tcfIgual
            Color = 12566527
          end
          item
            TipoPintadaCelda = tpcSoloColumnaCampo
            FieldName1 = 'ok_cant_min_afu'
            TipoCondFiltro1 = tcfIgual
            Valor1 = '?'
            TipoCondFiltro2 = tcfIgual
            Color = 12566527
          end
          item
            TipoPintadaCelda = tpcSoloColumnaCampo
            FieldName1 = 'ok_perm_ofic'
            TipoCondFiltro1 = tcfIgual
            Valor1 = '?'
            TipoCondFiltro2 = tcfIgual
            Color = 12566527
          end>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSTCabecera
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
            DataBinding.FieldName = 'fecha'
            Visible = False
            GroupIndex = 0
          end
          object dxDBGridSN1DBTableView1legajo: TcxGridDBColumn
            DataBinding.FieldName = 'legajo'
          end
          object dxDBGridSN1DBTableView1ape_y_nombre: TcxGridDBColumn
            DataBinding.FieldName = 'ape_y_nombre'
          end
          object dxDBGridSN1DBTableView1cant_veces_fuera_ofic: TcxGridDBColumn
            DataBinding.FieldName = 'cant_veces_fuera_ofic'
          end
          object dxDBGridSN1DBTableView1tiempo_tot_fuera_ofic: TcxGridDBColumn
            DataBinding.FieldName = 'tiempo_tot_fuera_ofic'
          end
          object dxDBGridSN1DBTableView1tiempo_prom_fuera_ofic: TcxGridDBColumn
            DataBinding.FieldName = 'tiempo_prom_fuera_ofic'
          end
          object dxDBGridSN1DBTableView1cant_salidas_intervalo_1: TcxGridDBColumn
            DataBinding.FieldName = 'cant_salidas_intervalo_1'
          end
          object dxDBGridSN1DBTableView1cant_salidas_intervalo_2: TcxGridDBColumn
            DataBinding.FieldName = 'cant_salidas_intervalo_2'
          end
          object dxDBGridSN1DBTableView1cant_salidas_intervalo_3: TcxGridDBColumn
            DataBinding.FieldName = 'cant_salidas_intervalo_3'
          end
          object dxDBGridSN1DBTableView1cant_salidas_intervalo_4: TcxGridDBColumn
            DataBinding.FieldName = 'cant_salidas_intervalo_4'
          end
          object dxDBGridSN1DBTableView1tiempo_tot_dentro_ofic: TcxGridDBColumn
            DataBinding.FieldName = 'tiempo_tot_dentro_ofic'
          end
        end
        object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSTCabecera
          DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.CancelOnExit = False
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Editing = False
          OptionsData.Inserting = False
          OptionsView.GroupByBox = False
          Bands = <
            item
              Width = 445
            end
            item
              Caption = 'Fuera de Oficina'
              Width = 242
            end
            item
              Caption = 'En Oficina'
              Width = 158
            end>
          object dxDBGridSN1DBBandedTableView1ape_y_nom: TcxGridDBBandedColumn
            Caption = 'Apellido y Nombre'
            DataBinding.FieldName = 'ape_y_nom'
            Visible = False
            GroupIndex = 0
            Width = 208
            Position.BandIndex = 0
            Position.ColIndex = 0
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1cant_salidas: TcxGridDBBandedColumn
            Caption = 'Cant. Salidas'
            DataBinding.FieldName = 'cant_salidas'
            HeaderAlignmentHorz = taCenter
            HeaderAlignmentVert = vaCenter
            Width = 95
            Position.BandIndex = 1
            Position.ColIndex = 0
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1tiempo_tot_salida: TcxGridDBBandedColumn
            Caption = 'Minutos Fuera'
            DataBinding.FieldName = 'tiempo_tot_salida'
            HeaderAlignmentHorz = taCenter
            HeaderAlignmentVert = vaCenter
            Width = 106
            Position.BandIndex = 1
            Position.ColIndex = 2
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1tiempo_permanencia: TcxGridDBBandedColumn
            Caption = 'Permanencia en Oficina'
            DataBinding.FieldName = 'tiempo_permanencia'
            HeaderAlignmentHorz = taCenter
            Width = 116
            Position.BandIndex = 2
            Position.ColIndex = 0
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1fec_hor_desde: TcxGridDBBandedColumn
            Caption = 'Fecha Entrada'
            DataBinding.FieldName = 'fec_hor_desde'
            HeaderAlignmentHorz = taCenter
            Width = 73
            Position.BandIndex = 0
            Position.ColIndex = 1
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1hor_desde: TcxGridDBBandedColumn
            Caption = 'Hora Desde'
            DataBinding.FieldName = 'hor_desde'
            HeaderAlignmentHorz = taCenter
            HeaderAlignmentVert = vaCenter
            Width = 65
            Position.BandIndex = 0
            Position.ColIndex = 2
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1fec_hor_hasta: TcxGridDBBandedColumn
            Caption = 'Fecha Salida'
            DataBinding.FieldName = 'fec_hor_hasta'
            HeaderAlignmentHorz = taCenter
            Width = 78
            Position.BandIndex = 0
            Position.ColIndex = 3
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1hor_hasta: TcxGridDBBandedColumn
            Caption = 'Hora Salida'
            DataBinding.FieldName = 'hor_hasta'
            HeaderAlignmentHorz = taCenter
            Width = 64
            Position.BandIndex = 0
            Position.ColIndex = 4
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1Column1: TcxGridDBBandedColumn
            Caption = 'Permanencia Jornada'
            DataBinding.FieldName = 'permanencia_jornada'
            HeaderAlignmentHorz = taCenter
            Width = 128
            Position.BandIndex = 0
            Position.ColIndex = 5
            Position.RowIndex = 0
          end
          object dxDBGridSN1DBBandedTableView1Column2: TcxGridDBBandedColumn
            DataBinding.FieldName = 'ok_permanencia_jornada'
            Width = 20
            Position.BandIndex = 0
            Position.ColIndex = 6
            Position.RowIndex = 0
            IsCaptionAssigned = True
          end
          object dxDBGridSN1DBBandedTableView1Column3: TcxGridDBBandedColumn
            DataBinding.FieldName = 'ok_cant_sal'
            Width = 20
            Position.BandIndex = 1
            Position.ColIndex = 1
            Position.RowIndex = 0
            IsCaptionAssigned = True
          end
          object dxDBGridSN1DBBandedTableView1Column4: TcxGridDBBandedColumn
            DataBinding.FieldName = 'ok_cant_min_afu'
            Width = 21
            Position.BandIndex = 1
            Position.ColIndex = 3
            Position.RowIndex = 0
            IsCaptionAssigned = True
          end
          object dxDBGridSN1DBBandedTableView1Column5: TcxGridDBBandedColumn
            DataBinding.FieldName = 'ok_perm_ofic'
            Width = 20
            Position.BandIndex = 2
            Position.ColIndex = 1
            Position.RowIndex = 0
            IsCaptionAssigned = True
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBBandedTableView1
        end
      end
    end
    object Panel4: TPanel
      Left = 1
      Top = 190
      Width = 874
      Height = 247
      Align = alClient
      Color = clWindow
      TabOrder = 1
      object Panel5: TPanel
        Left = 1
        Top = 1
        Width = 872
        Height = 29
        Align = alTop
        Color = 14145535
        TabOrder = 0
        object Label6: TLabel
          Left = 593
          Top = 8
          Width = 6
          Height = 13
          Caption = '--'
        end
        object snDBEdit2: TsnDBEdit
          Left = 3
          Top = 4
          DataBinding.DataField = 'ape_y_nom'
          DataBinding.DataSource = DSTCabecera
          Properties.ReadOnly = True
          TabOrder = 0
          Width = 342
        end
        object snDBEdit3: TsnDBEdit
          Left = 353
          Top = 4
          DataBinding.DataField = 'fec_hor_desde'
          DataBinding.DataSource = DSTCabecera
          Properties.ReadOnly = True
          TabOrder = 1
          Width = 144
        end
        object snDBEdit4: TsnDBEdit
          Left = 495
          Top = 4
          DataBinding.DataField = 'hor_desde'
          DataBinding.DataSource = DSTCabecera
          Properties.ReadOnly = True
          TabOrder = 2
          Width = 97
        end
        object snDBEdit5: TsnDBEdit
          Left = 601
          Top = 4
          DataBinding.DataField = 'fec_hor_hasta'
          DataBinding.DataSource = DSTCabecera
          Properties.ReadOnly = True
          TabOrder = 3
          Width = 144
        end
        object snDBEdit6: TsnDBEdit
          Left = 743
          Top = 4
          DataBinding.DataField = 'hor_hasta'
          DataBinding.DataSource = DSTCabecera
          Properties.ReadOnly = True
          TabOrder = 4
          Width = 97
        end
      end
      object Panel6: TPanel
        Left = 1
        Top = 30
        Width = 872
        Height = 216
        Align = alClient
        Color = clWindow
        TabOrder = 1
        object dxDBGridSN2: TdxDBGridSN
          Left = 1
          Top = 1
          Width = 870
          Height = 214
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTFichadaOficina
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1fec_hor: TcxGridDBColumn
              Caption = 'Fecha/Hora'
              DataBinding.FieldName = 'fec_hor'
              HeaderAlignmentHorz = taCenter
              Width = 133
            end
            object dxDBGridSN1DBTableView1sentido: TcxGridDBColumn
              Caption = 'Sentido'
              DataBinding.FieldName = 'sentido'
              HeaderAlignmentHorz = taCenter
              Width = 61
            end
            object dxDBGridSN1DBTableView1pto_fichada: TcxGridDBColumn
              Caption = 'Lugar'
              DataBinding.FieldName = 'pto_fichada'
              HeaderAlignmentHorz = taCenter
              Width = 164
            end
            object dxDBGridSN1DBTableView1motivo: TcxGridDBColumn
              Caption = 'Motivo'
              DataBinding.FieldName = 'motivo'
              HeaderAlignmentHorz = taCenter
              Width = 219
            end
            object dxDBGridSN1DBTableView1observacion: TcxGridDBColumn
              Caption = 'Observaci'#243'n'
              DataBinding.FieldName = 'observacion'
              HeaderAlignmentHorz = taCenter
              Width = 242
            end
          end
          object cxGridLevel1: TcxGridLevel
            GridView = cxGridDBTableView1
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TCabecera
        TableName = 'TCabecera'
      end
      item
        DataSet = TFichadaOficina
        TableName = 'TFichadaOficina'
      end>
  end
  inherited TOidObjSave: TsnTable
    Top = 56
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
      '  snDBDateEdit1.setFoco();'
      'end.')
    OnValidate = <
      item
        TableName = 'Tinput'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'Tinput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'hora_desde'#39').AsInteger := -1;'
          '  DataSet.FieldName('#39'hora_hasta'#39').AsInteger := -1;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Tinput.close;'
          '  Tinput.open;'
          '  Tinput.appendRecord;'
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  cargarTipos();'
          '  cargarHorass();'
          '  dxDBGridSN1.ActivarEventoPintarCeldas();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarTipos();'
          'begin'
          ''
          '  TTipo.close;'
          '  TTipo.Open;'
          ''
          '  TTipo.appendRecord;'
          '  TTipo.FieldName('#39'codigo'#39').AsString := '#39'DETALLADA'#39';'
          
            '  TTipo.FieldName('#39'descripcion'#39').AsString := '#39'Detallada por DIA'#39 +
            ';'
          '  TTipo.PostRecord;'
          ''
          '  TTipo.appendRecord;'
          '  TTipo.FieldName('#39'codigo'#39').AsString := '#39'RESUMIDA'#39';'
          '  TTipo.FieldName('#39'descripcion'#39').AsString := '#39'Resumida'#39';'
          '  TTipo.PostRecord;'
          ''
          'end;'
          ''
          ''
          'procedure cargarHorass();'
          'var'
          '  i : integer;'
          'begin'
          ''
          '  Thoras.close;'
          '  Thoras.open;'
          ''
          '  Thoras.appendRecord;'
          '  Thoras.fieldname('#39'codigo'#39').AsInteger := -1;'
          '  Thoras.fieldname('#39'descripcion'#39').AsString := '#39'__'#39';'
          '  Thoras.postRecord;'
          ''
          '  for i:=0 to 23 do'
          '     begin'
          '         Thoras.appendRecord;'
          '         Thoras.fieldname('#39'codigo'#39').AsInteger := i;'
          
            '         Thoras.fieldname('#39'descripcion'#39').AsString := IntToStr(i)' +
            ';'
          '         Thoras.postRecord;'
          '     end;'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').Isnull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_hasta'#39').Isnull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerINOUTOficina'#39');'
          
            '  operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39 +
            ').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39 +
            ').AsString);'
          '  if (TInput.FieldName('#39'oid_legajo'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid_legajo'#39',TInput.FieldName('#39'o' +
            'id_legajo'#39').AsString);'
          '  operacion.execute();'
          ''
          'end.')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 376
    Top = 184
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Tinput: TsnTable
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
    Left = 144
    Top = 161
    object Tinputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object Tinputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object Tinputtipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
    object Tinputhora_desde: TIntegerField
      FieldName = 'hora_desde'
    end
    object Tinputhora_hasta: TIntegerField
      FieldName = 'hora_hasta'
    end
    object Tinputoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object Tinputcod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object Tinputnombre_legajo: TStringField
      FieldName = 'nombre_legajo'
      Size = 100
    end
  end
  object DSInput: TDataSource
    DataSet = Tinput
    Left = 176
    Top = 169
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 177
  end
  object TTipo: TsnTable
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
    Left = 328
    Top = 225
    object TTipocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipo: TDataSource
    DataSet = TTipo
    Left = 360
    Top = 225
  end
  object Thoras: TsnTable
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
    Left = 168
    Top = 257
    object Thorascodigo: TIntegerField
      FieldName = 'codigo'
    end
    object Thorasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
  end
  object DSHoras: TDataSource
    DataSet = Thoras
    Left = 200
    Top = 257
  end
  object TCabecera: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cant_salidas'
        DataType = ftInteger
      end
      item
        Name = 'tiempo_tot_salida'
        DataType = ftInteger
      end
      item
        Name = 'cant_sal_int1'
        DataType = ftInteger
      end
      item
        Name = 'cant_sal_int2'
        DataType = ftInteger
      end
      item
        Name = 'cant_sal_int3'
        DataType = ftInteger
      end
      item
        Name = 'tiempo_permanencia'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fec_hor_desde'
        DataType = ftDate
      end
      item
        Name = 'hor_desde'
        DataType = ftString
        Size = 8
      end
      item
        Name = 'fec_hor_hasta'
        DataType = ftDate
      end
      item
        Name = 'hor_hasta'
        DataType = ftString
        Size = 8
      end
      item
        Name = 'permanencia_jornada'
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
    Left = 528
    Top = 312
    object TCabecerasecu: TIntegerField
      FieldName = 'secu'
    end
    object TCabeceraoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TCabeceralegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TCabeceraape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TCabeceracant_salidas: TIntegerField
      FieldName = 'cant_salidas'
    end
    object TCabeceratiempo_tot_salida: TIntegerField
      FieldName = 'tiempo_tot_salida'
    end
    object TCabeceracant_sal_int1: TIntegerField
      FieldName = 'cant_sal_int1'
    end
    object TCabeceracant_sal_int2: TIntegerField
      FieldName = 'cant_sal_int2'
    end
    object TCabeceracant_sal_int3: TIntegerField
      FieldName = 'cant_sal_int3'
    end
    object TCabeceratiempo_permanencia: TStringField
      FieldName = 'tiempo_permanencia'
      Size = 50
    end
    object TCabecerafec_hor_desde: TDateField
      FieldName = 'fec_hor_desde'
    end
    object TCabecerahor_desde: TStringField
      FieldName = 'hor_desde'
      Size = 8
    end
    object TCabecerafec_hor_hasta: TDateField
      FieldName = 'fec_hor_hasta'
    end
    object TCabecerahor_hasta: TStringField
      FieldName = 'hor_hasta'
      Size = 8
    end
    object TCabecerapermanencia_jornada: TStringField
      FieldName = 'permanencia_jornada'
      Size = 50
    end
    object TCabeceraok_cant_sal: TStringField
      FieldName = 'ok_cant_sal'
      Size = 1
    end
    object TCabeceraok_cant_min_afu: TStringField
      FieldName = 'ok_cant_min_afu'
      Size = 1
    end
    object TCabeceraok_perm_ofic: TStringField
      FieldName = 'ok_perm_ofic'
      Size = 1
    end
    object TCabeceraok_permanencia_jornada: TStringField
      FieldName = 'ok_permanencia_jornada'
      Size = 1
    end
  end
  object DSTCabecera: TDataSource
    DataSet = TCabecera
    Left = 560
    Top = 313
  end
  object HelpLegajos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
        AsignarACampo = Tinputcod_legajo
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
    Titulo = 'Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 223
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = Tinputoid_legajo
    CampoDescripcion = Tinputnombre_legajo
    NroQuery = 0
    Cache = True
    Left = 254
    Top = 223
  end
  object TFichadaOficina: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_in_out_ofic'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'nombre_legajo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_hor'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'sentido'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_pto_fichada'
        DataType = ftInteger
      end
      item
        Name = 'pto_fichada'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_motivo_fichada'
        DataType = ftInteger
      end
      item
        Name = 'motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'secu'
        DataType = ftInteger
      end>
    IndexFieldNames = 'secu'
    IndexDefs = <
      item
        Name = 'TFichadaOficinaIndex1'
        Fields = 'secu'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'secu'
    MasterSource = DSTCabecera
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 320
    Top = 321
    object TFichadaOficinaoid_in_out_ofic: TIntegerField
      FieldName = 'oid_in_out_ofic'
    end
    object TFichadaOficinafec_hor: TStringField
      FieldName = 'fec_hor'
      Size = 30
    end
    object TFichadaOficinasentido: TStringField
      FieldName = 'sentido'
      Size = 1
    end
    object TFichadaOficinaoid_pto_fichada: TIntegerField
      FieldName = 'oid_pto_fichada'
    end
    object TFichadaOficinapto_fichada: TStringField
      FieldName = 'pto_fichada'
      Size = 100
    end
    object TFichadaOficinaoid_motivo_fichada: TIntegerField
      FieldName = 'oid_motivo_fichada'
    end
    object TFichadaOficinamotivo: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object TFichadaOficinaobservacion: TStringField
      FieldName = 'observacion'
      Size = 100
    end
    object TFichadaOficinaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TFichadaOficinalegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TFichadaOficinasecu: TIntegerField
      FieldName = 'secu'
    end
  end
  object DSTFichadaOficina: TDataSource
    DataSet = TFichadaOficina
    Left = 352
    Top = 321
  end
end
