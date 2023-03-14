inherited FMovCIPPtoFichada: TFMovCIPPtoFichada
  Left = 100
  Top = 44
  Width = 1107
  Caption = 'Movimientos Puntos Fichada'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1091
    Height = 73
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 14
      Width = 62
      Height = 13
      Caption = 'Fecha desde'
    end
    object Label2: TLabel
      Left = 248
      Top = 14
      Width = 59
      Height = 13
      Caption = 'Fecha hasta'
    end
    object Label3: TLabel
      Left = 16
      Top = 46
      Width = 32
      Height = 13
      Caption = 'Legajo'
    end
    object ImagenSalir: TImage
      Left = 666
      Top = 12
      Width = 43
      Height = 37
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      Proportional = True
      ShowHint = True
      Transparent = True
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 96
      Top = 10
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSTInput
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 320
      Top = 10
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSTInput
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 121
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 96
      Top = 40
      DataBinding.DataField = 'cod_legajo'
      DataBinding.DataSource = DSTInput
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      TabOrder = 2
      Help = HelpLegajos
      Width = 121
    end
    object snDBEdit1: TsnDBEdit
      Left = 214
      Top = 40
      DataBinding.DataField = 'desc_legajo'
      DataBinding.DataSource = DSTInput
      Properties.ReadOnly = True
      TabOrder = 3
      Width = 225
    end
    object BotonMovimientos: TsnButton
      Left = 456
      Top = 8
      Width = 193
      Height = 49
      Cursor = crHandPoint
      Caption = 'Traer Movimientos'
      TabOrder = 4
      Glyph.Data = {
        36080000424D3608000000000000360400002800000020000000200000000100
        0800000000000004000000000000000000000001000000000000FFFFFF000000
        000049246D00472B6300432C590045276200402E5B003E2C6100442B5E004028
        60003E286000432C5E003C2662004029600041295D0041295F00412A5F00412A
        5E0040295E0042295F0041295E00402B5D00402A5D00402B5E0042295F00412B
        5E00402A5E0042295E00412B5E00412A5E0041295E00422B5F00412A5E00412A
        5F00402B5E00412A5E00412A5E00402A5F0041295E00412B5E00402B5F00412A
        5E00402A5F00412B5F00412B5F00412B5E00412A5F00412B5F00412A5F00412B
        5F00422B5F00422C5F00412B5F00412B5F00422B5F00412A5F00412A5E00422A
        5E00422A5F00493361003F2D650049376A004B3B6D004C3B6D004C3D6E004C3D
        6F00412C5F00422C5F00432D5F00402B6000412C6000422C6000422D6000432D
        6100432E6100432F6200442F6200443062004430630045316400513E64005340
        640054426500564466005A4A670044396D004A3B6D004C3E6F004E4171005046
        7600524878003C367900544D7C0056507E00412A5E00412B5E00422B5E00422C
        5E00412A5F00412B5F00422B5F004B3762004E3A6300513E6400564466005A49
        67005F5069006C606E006D616E006E626F007267700073687100776D72007D75
        74007E777500898479008D897A00534B7B00908D7C00918E7C0096947E005752
        80009C9C80009D9D810058558300595785005A5786005B598600ACB086005C5B
        8800B3B98900B4BA8900B7BE8A005E5E8B00B8BF8B00BAC18B00BCC48C00BDC6
        8D00BFC78D00BFC88D00C1CA8E0038408F004D5B8F0060628F00616490006266
        9200646A9500646A9600676F9A0068709B0068729C006B76A0006F7EA7007080
        A8007385AD007487AF007589B000768AB100567EB200778DB300788DB4005781
        B5007990B6005884B8007B93B9005887BB007E99BE007F9ABF00829FC40082A0
        C40083A1C50083A3C6002E58C7002E59C70084A4C80084A5C8002D5AC90085A6
        C9002E5ACA002D5ACB002D5ACC0087AACD005D9ACE008DB3D5008DB4D60090BA
        DB0091BBDB0092BDDD0092BEDE0093BFDF0095C3E20063B0E40063B2E60098C9
        E80099CBE9009ACCEA009BCEEC009CCFED009DD1EF009ED2F0009ED3F0009ED4
        F1009FD4F100266BF2009FD5F200256FFB002471FF0000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        000000000000000000000000000000000000000000000000000001142D342209
        00000000000000000000000000000000000000000000000000000E5E3C5B5E30
        0A00000000000000000000000000000000000000000000000000253CCBCEAC45
        300A0000000000000000000000000000000000000000000000002E5BCECECEB2
        45300A0000000000000000000000000000000000000000000000185EACCECECE
        B245300A00000000000000000000000000000000000000000000043045B3CECE
        CEB245300A000000000000000000000000000000000000000000000A3045B3CE
        CECEB245300C000000000000000000000000000000000000000000000A3045B3
        CECECEAD62380A000000000000000000000000000000000000000000000A3045
        B4CECD8D5E5F310A00000B131D242A2012060000000000000000000000000A30
        45B08D5E8EA3423113295E5E5E5E48475E5E2B1501000000000000000000000A
        30625E8EBFC09E5E5E6385B1BEC4CCC3A894565E270500000000000000000000
        0A3763A5C0B6555E7DBCCCCCCCCCCCCCCCCCC5965E330F000000000000000000
        000A3146A1554AA4CCCCC29F935A58909ABCCCCCAF3D36080000000000000000
        00000A31635EA4CCCCAB3E5E5E5053615E4D9DC9CCB55E260000000000000000
        000000125E7ECCCC975E3B76868C8C887B515E7CC6CC955E1100000000000000
        000000225EBCCCAE5E6A838C8C8C8C8C8C886F5E98CCC3413503000000000000
        0000073981CCC23F3B838C8C8C8C8C8C8C8C8A5443B7CCA25E0F000000000000
        0000165EAACC9F5E768C8C8C8C8C8C8C8C8C8C806092CCB85E19000000000000
        00001C5EBDCC935E868C8C8C8C8C8C8C8C8C8C8C5259CCC64923000000000000
        00001E5EC2CC5A508C8C8C8C8C8C8C8C8C8C8C8C6D64C4CC752F000000000000
        00002147CCCC58538C8C8C8C8C8C8C8C8C8C8C8C6F5EC1CC7932000000000000
        00001F47C3CC9061888C8C8C8C8C8C8C8C8C8C8C6957CCC94F28000000000000
        0000125EA8CC9A5E7B8C7A71878C8C8B77788C84448FCCB95E1B000000000000
        0000065E94CCBD4E5188735E666E70685E6C8C6B5EA9CCA65E10000000000000
        0000002B56C5CCA05E6F8A76675E5E657289745E91CCC85C3908000000000000
        000000155E96CCCA7F5E54808C86828C846B5E40C1CC9B5E1A00000000000000
        00000001275EAFCCC7994860526D6F69445E91C1CCBB4B2C0200000000000000
        0000000005333DB5CCCCB89259645E578FA9CCCCBB753A0D0000000000000000
        00000000000F365E95C3CCCCCCC4C1CCCCCCC99C4C3A17000000000000000000
        00000000000008265E41A2B8C6CCCCC9BAA75D5E2C0D00000000000000000000
        000000000000000011355E5E4975794F5E5E391A020000000000000000000000
        000000000000000000030F19232F32281B100800000000000000}
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 73
    Width = 1091
    Height = 394
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 1089
      Height = 392
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
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
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          Width = 107
        end
        object dxDBGridSN1DBTableView1nombre_legajo: TcxGridDBColumn
          Caption = 'Nombre'
          DataBinding.FieldName = 'nombre_legajo'
          Width = 222
        end
        object dxDBGridSN1DBTableView1fec_hor: TcxGridDBColumn
          Caption = 'Fecha/Hora'
          DataBinding.FieldName = 'fec_hor'
          Width = 124
        end
        object dxDBGridSN1DBTableView1sentido: TcxGridDBColumn
          Caption = 'Sentido'
          DataBinding.FieldName = 'sentido'
          Width = 45
        end
        object dxDBGridSN1DBTableView1pto_fichada: TcxGridDBColumn
          Caption = 'Lugar'
          DataBinding.FieldName = 'pto_fichada'
          Width = 164
        end
        object dxDBGridSN1DBTableView1motivo: TcxGridDBColumn
          Caption = 'Motivo'
          DataBinding.FieldName = 'motivo'
          Width = 180
        end
        object dxDBGridSN1DBTableView1observacion: TcxGridDBColumn
          Caption = 'Observaci'#243'n'
          DataBinding.FieldName = 'observacion'
          Width = 232
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TFichadaOficina
        TableName = 'TFichadaOficina'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 600
    Top = 80
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
      '  Varios.setImagen('#39'ImagenSalir'#39',7);'
      'end.')
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TInput.close;'
          '  TInput.open;'
          '  TInput.appendRecord;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerEstadistica();'
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'Desde'#39');'
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la fecha ' +
            'Hasta'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFichadaOficina'#39');'
          
            '  operacion.AddAtribute('#39'fec_desde'#39', TInput.FieldName('#39'fec_desde' +
            #39').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39', TInput.FieldName('#39'fec_hasta' +
            #39').AsString);'
          '  if (TInput.FieldName('#39'oid_legajo'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid_legajo'#39', TInput.FieldName('#39 +
            'oid_legajo'#39').AsString);'
          '  operacion.execute();'
          ''
          '  if (TFichadaOficina.IsEmpty())'
          
            '     then mensaje.information('#39'No se encontraron fichadas para l' +
            'a selecci'#243'n realizada.'#39');'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImagenSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonMovimientos'
        Source.Strings = (
          'begin'
          '  TraerEstadistica();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TInput: TsnTable
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
    Left = 112
    Top = 169
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TInputcod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TInputdesc_legajo: TStringField
      FieldName = 'desc_legajo'
      Size = 100
    end
    object TInputoid_motivo_fichada: TIntegerField
      FieldName = 'oid_motivo_fichada'
    end
    object TInputmotivo: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object TInputobservacion: TStringField
      FieldName = 'observacion'
      Size = 100
    end
    object TInputactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTInput: TDataSource
    DataSet = TInput
    Left = 144
    Top = 169
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 456
    Top = 141
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
        AsignarACampo = TInputcod_legajo
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
    CampoOID = TInputoid_legajo
    CampoDescripcion = TInputdesc_legajo
    NroQuery = 0
    Cache = True
    Left = 254
    Top = 223
  end
  object TFichadaOficina: TsnTable
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
    Left = 312
    Top = 289
    object TFichadaOficinaoid_in_out_ofic: TIntegerField
      FieldName = 'oid_in_out_ofic'
    end
    object TFichadaOficinaoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TFichadaOficinanombre_legajo: TStringField
      FieldName = 'nombre_legajo'
      Size = 100
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
  end
  object DSTFichadaOficina: TDataSource
    DataSet = TFichadaOficina
    Left = 352
    Top = 289
  end
end
