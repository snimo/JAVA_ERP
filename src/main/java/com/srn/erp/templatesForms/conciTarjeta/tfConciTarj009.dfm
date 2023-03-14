inherited FImpArchCobranzaConci: TFImpArchCobranzaConci
  Left = 181
  Top = 203
  Width = 706
  Height = 159
  BorderIcons = []
  Caption = 'Importaci'#243'n de Cobranza de Tarjetas'
  DragKind = dkDrag
  DragMode = dmManual
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 698
    Height = 79
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 16
      Width = 98
      Height = 16
      Caption = 'Tipo de Archivo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Visible = False
    end
    object Label2: TLabel
      Left = 10
      Top = 48
      Width = 48
      Height = 16
      Caption = 'Archivo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 8
      Top = 16
      Width = 58
      Height = 16
      Caption = 'Empresa:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBLookup1: TsnDBLookup
      Left = 116
      Top = 12
      DataBinding.DataField = 'tipo_archivo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSCompoTipoArch
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Visible = False
      Width = 145
    end
    object BotonSeleccionarArchivo: TsrnDBButtonEdit
      Left = 115
      Top = 44
      DataBinding.DataField = 'archivo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 566
    end
    object snDBLookup2: TsnDBLookup
      Left = 115
      Top = 12
      TabStop = False
      DataBinding.DataField = 'oid_empresa'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid_empresa'
      Properties.ListColumns = <
        item
          FieldName = 'razon_social'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSEmpresasConciTar
      Properties.ReadOnly = True
      Style.Color = 16760962
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 333
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 79
    Width = 698
    Height = 46
    Align = alBottom
    Color = clWindow
    TabOrder = 1
    object BotonSalir: TsnButton
      Left = 16
      Top = 0
      Width = 161
      Height = 41
      Caption = 'Salir'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonImportar: TsnButton
      Left = 520
      Top = 0
      Width = 137
      Height = 41
      Caption = 'Importar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      Glyph.Data = {
        36100000424D3610000000000000360000002800000020000000200000000100
        2000000000000010000000000000000000000000000000000000FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF0038D8470142E2503B46E3522A63FD7208FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF0037D4463C147D18E0329536FF44D84D2C94FFA007FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF0029CA
        393C0C7711DE4CB851FF9CF9A6FF2F9D34FF60D7662CA5FFAE07FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF001BBA2A3C0970
        0EDD42C04AFF83FF90FF83FF90FF8AFE95FF299C2EFF53D65A2C76FF8408FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF000DAE1D3B086C0CDE3AB6
        41FF68FF78FF64FF73FF67FF75FF71FF7FFF79FE86FF249B28FF37D0402C55F2
        6505FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00049E133C046909DD37B13FFF5BFA
        6AFF53F663FF59F867FF62FA70FF5BFC6AFF62FE71FF69FE77FF209B25FF2AC8
        342C45E45405FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00018C0F3C026808DD33AD3BFF4FEE5EFF45EA
        55FF55ED64FF79F384FF83F58EFF62F470FF52F562FF59F969FF5FFB6EFF1F99
        24FF22C22C2C36D54605FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF0003790F3C026309DE2FAF39FF3FE04FFF39DD49FF5EE4
        6BFF85EC8FFF88EE92FF83EF8DFF7FF08AFF5CEE6AFF4BEE5BFF52F262FF59F5
        68FF1F9624FF1CB2252C27C83705FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF0010741A3B106116DE2DA638FF2ED13DFF37D246FF72E07CFF8FE7
        98FF89E892FF85E88EFF86EB8FFF80EA8AFF7BEB86FF56E764FF44E754FF4BEB
        5AFF53EE62FF1D8A22FF129C1C2C17B92605FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF001D7E263C2F6D33DD3EA747FF1EC12EFF46CC52FF89DF91FF95E39CFF8CE2
        94FF88E390FF8CE494FF99E29FFF7DE587FF7CE586FF77E682FF4FE05DFF3CDE
        4BFF43E452FF4BE75AFF1B7D1FFF098A122C08A91805FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF0000770A021B85
        263A356B37E753B15CFF18B426FF63CD6DFF9CE0A3FF97DF9EFF90DE97FF8DDF
        95FF91E299FFA9E3ADFF27AC2FFDB6F0BBFF7FE188FF78E082FF73E07DFF49D9
        56FF34D643FF3BDC4AFF43E052FF17711BFF017C0A2C01931005FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00017B0B0F0F62
        14D275BB7CFF2EB23BFF87D48FFFA9E0AEFF9CDCA2FF96DB9DFF92DB99FF97DE
        9DFFABE3AFFF088412D328BA355A2C7A30EEA9EFB0FF7DDD86FF74DB7EFF6FDB
        79FF41D24FFF2CCE3BFF33D442FF3BD74AFF146A18FF006A072C01790D04FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF0001800C050D62
        12AFADD8B1FFB3DEB8FFB5DFB9FFA4DAA9FF9FD9A4FF9AD9A0FF9EDCA4FFAAE1
        AFFF04800ED512B12121FFFFFF0015B5241D118B1AE8A6ECADFF7AD883FF70D6
        7AFF6BD675FF3ACA48FF23C532FF2ACC3AFF33CE41FF126116FF0057072C005D
        0A04FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00098A
        1609227728B1B6E0BBFFB0DAB5FFB2D9B6FFA7D5ABFFAAD8AFFFC4E8C7FF007B
        09D50AAA1921FFFFFF00FFFFFF00FFFFFF0010B01F1D0D8717E7A6EBADFF77D3
        7FFF6CD176FF66D070FF33C240FF1ABC29FF21C330FF29C538FF116116FF004B
        072B004D0904FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF0000900F08006E07B1C8E9CAFFB8DDBEFFC5DFC9FFD7EFD9FF007806D504A4
        1321FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF000BAB1A1D098313E8A4E9
        ABFF73CF7CFF68CC71FF62CA6CFF2BBA38FF10B220FF17BA27FF21BE30FF0F62
        16FF0145082C004B0804FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00019E1009007205B1D9F1DBFFE2F3E3FF007C0AD503A21221FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF0005A5141D067F
        0FE8A3E7AAFF6FC978FF64C66DFF5DC567FF23B230FF06A915FF0DB01DFF17B4
        26FF0E6014FF02460A2B034C0B04FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF0008A7170906740DAF04750BCB09A91922FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00009D
        0E1D05770DE8A3E4AAFF6FC178FF63BF6CFF5BBE65FF1CA82AFF009E0CFF03A5
        12FF0DA91BFF116318FF2C64322B12561804FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF000CA91A020DA91A06FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF0000960C1D05770EE8A5E3ABFF72B879FF65B56DFF5DB465FF1C9A28FF008F
        08FF00960DFF089C14FF28682CFF507E552B054B0C03FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF0000980C1D07790FE8A5E2ABFF74B17AFF67AD6EFF5EAA66FF1D8B
        27FF007C07FF008209FF159421FF2D632FFF023F042400470601FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00009B0C1D077A0FE8A6E2ACFF76AE7BFF69AA6FFF60A6
        67FF1D8026FF006F07FF167E21FF106117F9004A0631FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00009D0C1E077B0FE8A6E2ADFF78AC7DFF6AA8
        70FF61A368FF2D8636FF065B0CFA00590633FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00009D0C1D077B10E8A8E2AEFF80AE
        85FF7DB483FF2A7930FB006A0933FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00009C0C1D087B11E7A3D8
        A7FF3E7941FC228C2D33FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00009B0D1D0068
        04D217902219FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00008E
        0C06FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00}
      LookAndFeel.Kind = lfOffice11
      LookAndFeel.NativeStyle = True
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TComporTipoArch
        TableName = 'TComporTipoArch'
      end
      item
        DataSet = TEmpresaConciTar
        TableName = 'TEmpresaConciTar'
      end
      item
        DataSet = TInfoArchTarj
        TableName = 'TInfoArchTarj'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 416
    Top = 67
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
      '  Inicializar();'
      '  TInput.close;'
      '  TInput.open;'
      '  TInput.appendRecord;'
      
        '  TInput.FieldName('#39'oid_empresa'#39').AsInteger := variable.getInteg' +
        'er('#39'oid_empresa'#39');'
      '  TInput.FieldName('#39'acepto'#39').AsBoolean := false; '
      '  ImportarArchivoCobranza();'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'oid_empresa'
      end
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTipoConci();'
          '  TraerEmpresas();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure enviarArchCobranza();'
          'var'
          '  mensajeError : string;'
          'begin'
          ''
          '  if (TInput.FieldName('#39'oid_empresa'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar una emp' +
            'resa.'#39');'
          ''
          '  if (TInput.FieldName('#39'archivo'#39').AsString = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un Arch' +
            'ivo.'#39');'
          ''
          '  TInfoArchTarj.Close;'
          '  TInfoArchTarj.Open;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'UploadArchCobTarj'#39');'
          
            '  operacion.AddAtribute('#39'oid_empresa'#39',TInput.FieldName('#39'oid_empr' +
            'esa'#39').AsString);'
          
            '  operacion.UploadFile(ImpArchivoCobranza.getDataStream(),ImpArc' +
            'hivoCobranza.getPathAndFile(),'#39#39','#39#39',true,mensajeError);'
          ''
          '  if (TInfoArchTarj.FieldName('#39'proceso_ok'#39').AsBoolean)'
          
            '      then Varios.borrarArchivo(ImpArchivoCobranza.getPathAndFil' +
            'e()); '
          ''
          
            '  mensaje.information('#39'Se importaron '#39'+TInfoArchTarj.FieldName('#39 +
            'cant_reg_imp'#39').AsString+'#39' cupones'#39');'
          ''
          'end;  '
          ''
          'procedure Inicializar();'
          'begin'
          'end;'
          ''
          'procedure TraerTipoConci();'
          'begin'
          '  operacion.InicioOperacion;'
          '  operacion.setOper('#39'TraerTipoArchConciTar'#39');'
          '  operacion.execute(); '
          'end;'
          ''
          'procedure TraerEmpresas();'
          'begin'
          '    operacion.InicioOperacion();'
          '    operacion.setOper('#39'TraerEmpresasConciTar'#39');'
          '    operacion.execute();'
          'end;'
          ''
          'procedure Importar();'
          'begin'
          '  enviarArchCobranza();'
          'end;'
          ''
          'procedure ImportarArchivoCobranza();'
          'begin'
          '  if (ImpArchivoCobranza.Show())'
          '     then begin'
          '             TInput.EditRecord; '
          
            '             TInput.FieldName('#39'archivo'#39').AsString := ImpArchivoC' +
            'obranza.getPathAndFile();'
          '             end;'
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonImportar'
        Source.Strings = (
          'begin'
          '   Importar();'
          '   close();'
          'end.')
      end
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    OnClickButtonEdit = <
      item
        ButtonEdit = 'BotonSeleccionarArchivo'
        Source.Strings = (
          'begin'
          '  ImportarArchivoCobranza();'
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
    Left = 464
    Top = 65528
    object TInputtipo_archivo: TStringField
      FieldName = 'tipo_archivo'
      Size = 50
    end
    object TInputoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TInputarchivo: TStringField
      DisplayWidth = 255
      FieldName = 'archivo'
      Size = 255
    end
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 496
    Top = 65528
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
    Left = 488
    Top = 32
    object TComporTipoArchcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TComporTipoArchdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCompoTipoArch: TDataSource
    DataSet = TComporTipoArch
    Left = 520
    Top = 32
  end
  object TEmpresaConciTar: TsnTable
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
    Left = 104
    Top = 48
    object TEmpresaConciTaroid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TEmpresaConciTarrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 100
    end
    object TEmpresaConciTarcuit: TStringField
      FieldName = 'cuit'
      Size = 50
    end
    object TEmpresaConciTaractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSEmpresasConciTar: TDataSource
    DataSet = TEmpresaConciTar
    Left = 136
    Top = 48
  end
  object ImpArchivoCobranza: TSNOpenDialog
    Left = 216
    Top = 94
  end
  object TInfoArchTarj: TsnTable
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
    Left = 582
    Top = 31
    object TInfoArchTarjcant_reg_imp: TIntegerField
      FieldName = 'cant_reg_imp'
    end
    object TInfoArchTarjproceso_ok: TBooleanField
      FieldName = 'proceso_ok'
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 216
    Top = 8
  end
end
