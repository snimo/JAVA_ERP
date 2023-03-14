inherited FRing: TFRing
  Left = 62
  Top = 119
  Height = 422
  Caption = 'Rings'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 388
    inherited PPie: TPanel
      Top = 367
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRing
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRing
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCertificacionProveedor
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCertificacionProveedor
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCertificacionProveedor
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRing
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
    inherited PCuerpo: TPanel
      Height = 292
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object ImageSonido: TsnImage
        Left = 137
        Top = 116
        Width = 128
        Height = 109
        Picture.Data = {
          0A544A504547496D616765FA080000FFD8FFE000104A46494600010101006000
          600000FFDB004300080606070605080707070909080A0C140D0C0B0B0C191213
          0F141D1A1F1E1D1A1C1C20242E2720222C231C1C2837292C30313434341F2739
          3D38323C2E333432FFDB0043010909090C0B0C180D0D1832211C213232323232
          3232323232323232323232323232323232323232323232323232323232323232
          32323232323232323232323232FFC0001108006A008203012200021101031101
          FFC4001F0000010501010101010100000000000000000102030405060708090A
          0BFFC400B5100002010303020403050504040000017D01020300041105122131
          410613516107227114328191A1082342B1C11552D1F02433627282090A161718
          191A25262728292A3435363738393A434445464748494A535455565758595A63
          6465666768696A737475767778797A838485868788898A92939495969798999A
          A2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6
          D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F01000301
          01010101010101010000000000000102030405060708090A0BFFC400B5110002
          0102040403040705040400010277000102031104052131061241510761711322
          328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728
          292A35363738393A434445464748494A535455565758595A636465666768696A
          737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7
          A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3
          E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00F786
          699AE1A38DA350A8ADF32139C93EE3D2976DD7FCF687FEFD1FFE2A85FF008FD9
          7FEB9A7F36A9A8021DB75FF3DA1FFBF47FF8AA36DD7FCF687FEFD1FF00E2AA6A
          28021DB75FF3DA1FFBF47FF8AA36DD7FCF687FEFD1FF00E2AA6A4CD0045B6EBF
          E7B43FF7E8FF00F1546DBAFF009ED0FF00DFA3FF00C554B9A3340116DBAFF9ED
          0FFDFA3FFC551B6EBFE7B43FF7E8FF00F1552E68CD0045B6EBFE7B43FF007E8F
          FF001546DBAFF9ED0FFDFA3FFC554B9A3340116DBAFF009ED0FF00DFA3FF00C5
          51B6EBFE7B43FF007E8FFF001553668A00876DD7FCF687FEFD1FFE2A889E5F3E
          48E4646DAAAC0AA91D49F73E953542BFF1FB2FFD734FE6D4013514514010AFFC
          7ECBFF005CD3F9B54D50AFFC7ECBFF005CD3F9B54D400D91822331190066B0A7
          BA9276DC5885EC056CDD9C5A4A7FD935CFD002EE6FEF1FCCD1B9BFBC7F3A4A28
          017737F78FE746E6FEF1FCE928A005DCDFDE3F9D1B9BFBC7F3A4A28017737F78
          FE74066CFDE6FCE928A00D4D3AEDDDFC9909638E0D6966B0AC33F6D8F1EFFCAB
          73BD002D42BFF1FB2FFD734FE6D53542BFF1FB2FFD734FE6D4013514514010AF
          FC7ECBFF005CD3F9B54D50AFFC7ECBFF005CD3F9B54D40105E7FC79CBFEE9AC0
          ADFBCFF8F397FDD3581400514528059D51412C7380050025041CE3BD482D6E1D
          822C4C19B8CB0C01EE692EE34B4BB10A9DCBE5A9E4F258B11FE14015CCF04732
          A4F3792AC3872B95CFA1F4FAF4A9991E295E29061979F623D47B5471AC8D31D3
          6F63502427CA9081B91BAE1BFBC0FAFF0090DB7626C658241892C4EE4C9C9087
          82BF8107F25A0097B671451CE3DB3C51401674FF00F8FE8FF1FE46B70561E9FF
          00F1FD1FE3FC8D6E0A005A857FE3F65FFAE69FCDAA6A857FE3F65FFAE69FCDA8
          026A28A280215FF8FD97FEB9A7F36A9AA15FF8FD97FEB9A7F36A9A8020BCFF00
          8F397FDD35815BF79FF1E72FFBA6B02800A58678ADEF6DE69E548E35620B3360
          720D2521008208041EC6803660D5F4EB9956186FADE4958121125049C75E2B33
          5808F7ECAE018CC08307DD9AA9CD6D14AA38D8C082ACBC1523A107B1A7969AE5
          835EF972308C2330180F827923B75FF3D2801245DD77A75A24A6596DC46923AF
          3C86040CF72006FCE9CAC8F71ABCC3EE08A5427D496C0FD54D411DCA5AC661B3
          B775BB6CA6EF2F0910E995FEF123A63F4A95E316D02E9AA4195887B8E73B5474
          5CFA9E0FE740122E42807AF7A5A07FFAE8A00B3A7FFC7F47F8FF00235B82B0F4
          FF00F8FE8FF1FE46B705002D42BFF1FB2FFD734FE6D53542BFF1FB2FFD734FE6
          D4013514514010AFFC7ECBFF005CD3F9B54D50AFFC7ECBFF005CD3F9B54D4010
          5E7FC79CBFEE9AC0ADFBCFF8F397FDD35804E31400514BB4F607F23480123EE9
          FCBF2FE46800A3033401919F6CF4ED4BB581C1520F4E9401130B8560D6F71E53
          60A92173C7B67A1A482058108059893966639673EA4F73536D3D81FCA930719D
          A71F4A0028A5DADFDD39E9D3BFA5250059D3FF00E3FA3FC7F91ADC1587A7FF00
          C7F47F8FF235B828016A15FF008FD97FEB9A7F36A9AA15FF008FD97FEB9A7F36
          A009A8A28A00857FE3F65FFAE69FCDAA6A857FE3F65FFAE69FCDAA6A0086EC66
          D251FECD73FCF1FCEBA5232307915973694C1CB42C08639C13D28033774C3211
          E3505958EE8CB1CA9047391DC5289EF159584B06E57320FDC9C64E41FE2F7AB9
          FD9971E8BF9D1FD9971E8BF9D0051DD7461F2BCE8CAF97E5644473B7FEFAEB4E
          335D912BB4F08CBABB620663918E8A1BA7033F5CD5C3A65C7A27E74C7D2AEF78
          64117CA4300C4F0477041046470474A00ACB35DA95659A0F959997F74483BB93
          CEEE473C7D699BAEBCA3109A20A6358B888E76AE71FC5EF57974BB903E6DA58E
          3273E8297FB32E3D17F3A00A7E75D972FE6C392E2423CA38DD8C7F7BA6051976
          C976C924B1FA9EB8E78AB9FD9971E8BF9D1FD9971EA83EA6801BA783F6E8F8F5
          3FA56D8AAB6766B6E3731DD21EFE956E800A857FE3F65FFAE69FCDAA6A857FE3
          F65FFAE69FCDA8026A28A2802B34822BC7665930D1A80550B742DE83DC53FED5
          1FF766FF00BF2FFE153514010FDAA3FEECDFF7E5FF00C293ED51FF00766FFBF2
          FF00E153D140107DA62FEE4BFF007E5FFC28FB4C5FDC97FEFCBFF854F450041F
          698BFB92FF00DF97FF000A3ED317F725FF00BF2FFE153D140107DA62FEE4BFF7
          E5FF00C28FB4C5FDC97FEFCBFF00854F450041F698BFB92FFDF97FF0A3ED31FF
          00765FFBF2FF00E153D14010FDAA3FEECDFF007E5FFC28FB547FDD9BFEFCBFF8
          54D450043F6A8FFBB37FDF97FF000A6C2DE65D4AE15C2EC419642BCE5BD7EB56
          28A0028A28A00FFFD9}
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRing
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 157
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRing
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 453
      end
      object BotonElegirSonido: TsnButton
        Left = 124
        Top = 88
        Width = 153
        Height = 25
        Caption = 'Seleccionar archivo Sonido ...'
        TabOrder = 2
        LookAndFeel.Kind = lfOffice11
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRing'
    OperGrabarObjeto = 'SaveRing'
    CargaDataSets = <
      item
        DataSet = TRing
        TableName = 'TRing'
      end>
    BajaLogica = <
      item
        DataSet = TRing
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRing
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRing: TsnTable [3]
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
    Left = 648
    Top = 59
    object TRingoid_ring: TIntegerField
      FieldName = 'oid_ring'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRingcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TRingdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TRingactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTRing: TDataSource [4]
    DataSet = TRing
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
        TableName = 'TRing'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorRing.Value := Sender.AsString;'
          '  ValidadorRing.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  SeleccionFile.setTipoWAV();'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  TraerFileSound();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerFileSound();'
          'var'
          '   mensajeError : string;'
          '   nomTempFile : string;'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'DownLoadSoundFile'#39');'
          
            '   nomTempFile := operacion.DownLoadFile(TOidObjSave.FieldName('#39 +
            'oid'#39').AsString, mensajeError);'
          '   SeleccionFile.LoadFromFile(nomTempFile);'
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  SeleccionFile.clearStream();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'var'
          '  mensajeError : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'UploadSoundFile'#39');'
          '  operacion.UploadFile('
          '        SeleccionFile.getDataStream(),'
          '        TOidObjSave.FieldName('#39'oid'#39').AsString,'
          '        '#39#39','#39#39',true,mensajeError);'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonElegirSonido'
        Source.Strings = (
          'begin'
          
            '  if (not (DriverABM.isModificar or DriverABM.isNuevo)) then exi' +
            't;'
          '  SeleccionFile.execute();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListGruposPopUp: TImageList
    Top = 67
  end
  inherited ImageListItemsPopUp: TImageList
    Top = 107
  end
  inherited TPathHelp: TsnTable
    Left = 568
    Top = 245
  end
  object HelpCertificacionProveedor: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Ring'
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
    Titulo = 'Rings'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorRing: TValidador
    Operacion = Operacion
    NickNameObjLog = 'me.Ring'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Ring Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object SeleccionFile: TSeleccionFile
    Left = 305
    Top = 214
  end
end
