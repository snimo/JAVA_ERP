inherited FFiltroCupImp: TFFiltroCupImp
  Left = 175
  Top = 141
  Width = 691
  Height = 396
  BorderIcons = []
  Caption = 'Cupones de Tarjetas Importados'
  UseDockManager = False
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Shape1: TShape [0]
    Left = 8
    Top = 10
    Width = 529
    Height = 33
    Brush.Color = 16767927
  end
  object snLabel1: TsnLabel [1]
    Left = 16
    Top = 16
    Width = 509
    Height = 20
    Caption = 'Filtros correspondientes a los cupones importados del POSNET'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold]
    ParentFont = False
    Transparent = True
  end
  object Label1: TLabel [2]
    Left = 24
    Top = 96
    Width = 126
    Height = 16
    Caption = 'Fecha Origen desde:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label2: TLabel [3]
    Left = 312
    Top = 96
    Width = 36
    Height = 16
    Caption = 'hasta:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label3: TLabel [4]
    Left = 24
    Top = 128
    Width = 147
    Height = 16
    Caption = 'Fecha Cierre lote desde:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label4: TLabel [5]
    Left = 312
    Top = 128
    Width = 36
    Height = 16
    Caption = 'hasta:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label5: TLabel [6]
    Left = 24
    Top = 160
    Width = 134
    Height = 16
    Caption = 'Cupones Presentados'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label6: TLabel [7]
    Left = 312
    Top = 160
    Width = 39
    Height = 16
    Caption = 'desde'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label7: TLabel [8]
    Left = 472
    Top = 160
    Width = 33
    Height = 16
    Caption = 'hasta'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label8: TLabel [9]
    Left = 24
    Top = 64
    Width = 46
    Height = 16
    Caption = 'Tarjeta:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label9: TLabel [10]
    Left = 208
    Top = 256
    Width = 39
    Height = 16
    Caption = 'desde'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label10: TLabel [11]
    Left = 368
    Top = 256
    Width = 33
    Height = 16
    Caption = 'hasta'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label13: TLabel [12]
    Left = 208
    Top = 232
    Width = 39
    Height = 16
    Caption = 'desde'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label14: TLabel [13]
    Left = 368
    Top = 232
    Width = 33
    Height = 16
    Caption = 'hasta'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object Label11: TLabel [14]
    Left = 24
    Top = 192
    Width = 260
    Height = 16
    Caption = 'Pendiente de Generar Asiento de Cobranza'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snDBDateEdit1: TsnDBDateEdit [15]
    Left = 176
    Top = 92
    DataBinding.DataField = 'fec_oper_desde'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 1
    ReadOnlyAlways = False
    Width = 105
  end
  object snDBDateEdit2: TsnDBDateEdit [16]
    Left = 360
    Top = 92
    DataBinding.DataField = 'fec_oper_hasta'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 2
    ReadOnlyAlways = False
    Width = 97
  end
  object BotonAplicarFiltros: TsnButton [17]
    Left = 488
    Top = 312
    Width = 153
    Height = 41
    Caption = 'Aplicar Filtros'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 8
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
  object BotonNoAplicar: TsnButton [18]
    Left = 24
    Top = 312
    Width = 161
    Height = 41
    Caption = 'Salir sin Aplicar Filtros'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 9
    LookAndFeel.Kind = lfOffice11
  end
  object snDBDateEdit3: TsnDBDateEdit [19]
    Left = 176
    Top = 124
    DataBinding.DataField = 'fec_cie_desde'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 3
    ReadOnlyAlways = False
    Width = 105
  end
  object snDBDateEdit4: TsnDBDateEdit [20]
    Left = 360
    Top = 124
    DataBinding.DataField = 'fec_cie_hasta'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 4
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBLookup1: TsnDBLookup [21]
    Left = 176
    Top = 156
    DataBinding.DataField = 'cupo_presentado'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.KeyFieldNames = 'CODIGO'
    Properties.ListColumns = <
      item
        FieldName = 'DESCRIPCION'
      end>
    Properties.ListOptions.RowSelect = False
    Properties.ListOptions.ShowHeader = False
    Properties.ListSource = DSSINO
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 5
    Width = 57
  end
  object snDBDateEdit5: TsnDBDateEdit [22]
    Left = 360
    Top = 156
    DataBinding.DataField = 'fec_des_presen'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 6
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBDateEdit6: TsnDBDateEdit [23]
    Left = 512
    Top = 156
    DataBinding.DataField = 'fec_has_presen'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 7
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBLookup2: TsnDBLookup [24]
    Left = 176
    Top = 60
    DataBinding.DataField = 'oid_tarjeta'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.ImmediatePost = True
    Properties.KeyFieldNames = 'oid'
    Properties.ListColumns = <
      item
        FieldName = 'descripcion'
      end>
    Properties.ListOptions.ShowHeader = False
    Properties.ListSource = DSTarjetas
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 0
    Width = 281
  end
  object snDBCheckEdit1: TsnDBCheckEdit [25]
    Left = 21
    Top = 230
    Caption = 'Pendiente de conciliar'
    DataBinding.DataField = 'pend_conci'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.ValueGrayed = 'False'
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 10
    Width = 161
  end
  object snDBCheckEdit2: TsnDBCheckEdit [26]
    Left = 21
    Top = 254
    Caption = 'Conciliado sin confirmar'
    DataBinding.DataField = 'conci_sin_confirmar'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.ValueGrayed = 'False'
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 11
    Width = 177
  end
  object snDBCheckEdit3: TsnDBCheckEdit [27]
    Left = 21
    Top = 278
    Caption = 'Confirmado'
    DataBinding.DataField = 'conci_confirmado'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.ValueGrayed = 'False'
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 14
    Width = 177
  end
  object snDBDateEdit7: TsnDBDateEdit [28]
    Left = 256
    Top = 252
    DataBinding.DataField = 'fec_desde_confirmado'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 15
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBDateEdit8: TsnDBDateEdit [29]
    Left = 408
    Top = 252
    DataBinding.DataField = 'fec_hasta_confirmado'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 16
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBDateEdit11: TsnDBDateEdit [30]
    Left = 256
    Top = 228
    DataBinding.DataField = 'fec_desde_conci_sin_conf'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 12
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBDateEdit12: TsnDBDateEdit [31]
    Left = 408
    Top = 228
    DataBinding.DataField = 'fec_hasta_conci_sin_conf'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 13
    ReadOnlyAlways = False
    Width = 97
  end
  object snDBLookup3: TsnDBLookup [32]
    Left = 312
    Top = 188
    DataBinding.DataField = 'pend_gen_asi_cob'
    DataBinding.DataSource = DSInput
    ParentFont = False
    Properties.KeyFieldNames = 'CODIGO'
    Properties.ListColumns = <
      item
        FieldName = 'DESCRIPCION'
      end>
    Properties.ListOptions.RowSelect = False
    Properties.ListOptions.ShowHeader = False
    Properties.ListSource = DSSINO
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = []
    Style.IsFontAssigned = True
    TabOrder = 17
    Width = 65
  end
  inherited DriverABM: TDriverABM
    Left = 192
    Top = 40
  end
  inherited Operacion: TOperacion
    Left = 232
    Top = 40
  end
  inherited TOidObjSave: TsnTable
    Left = 432
    Top = 80
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 272
    Top = 40
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 312
    Top = 40
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  TInput.EditRecord;'
      '  TInput.FieldName('#39'acepto'#39').AsBoolean := false;'
      'end.')
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'InicializarDatos'
      end>
    OnExternalCall = <
      item
        ExternalCall = 'InicializarDatos'
        Source.Strings = (
          'begin'
          '  InicializarFiltro();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  cargarDataSetSINO();'
          '  TTarjetas.loadFromHelp('#39'HelpTarjetas'#39');'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          '  TInput.FieldName('#39'cupo_presentado'#39').AsString := '#39'NA'#39';'
          '  TInput.FieldName('#39'pend_gen_asi_cob'#39').AsString := '#39'NA'#39';'
          '  TInput.FieldName('#39'pend_conci'#39').AsBoolean := True;'
          '  TInput.FieldName('#39'conci_sin_confirmar'#39').AsBoolean := True;'
          '  TInput.FieldName('#39'conci_confirmado'#39').AsBoolean := False;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarDataSetSINO();'
          'begin'
          '  TSINO.open;'
          ''
          '  TSINO.appendRecord;'
          '  TSINO.FieldName('#39'codigo'#39').AsString := '#39'SI'#39';'
          '  TSINO.FieldName('#39'descripcion'#39').AsString := '#39'SI'#39';'
          '  TSINO.PostRecord;'
          ''
          '  TSINO.appendRecord;'
          '  TSINO.FieldName('#39'codigo'#39').AsString := '#39'NO'#39';'
          '  TSINO.FieldName('#39'descripcion'#39').AsString := '#39'NO'#39';'
          '  TSINO.PostRecord;'
          ''
          '  TSINO.appendRecord;'
          '  TSINO.FieldName('#39'codigo'#39').AsString := '#39'NA'#39';'
          '  TSINO.FieldName('#39'descripcion'#39').AsString := '#39'NA'#39';'
          '  TSINO.PostRecord;'
          'end;'
          ''
          'procedure InicializarFiltro();'
          'begin'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonAplicarFiltros'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'BotonNoAplicar'
        Source.Strings = (
          'begin'
          '  TInput.CancelRecord;'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := false;'
          '  TInput.PostRecord;'
          '  close();'
          'end.'
          '')
      end>
    Left = 352
    Top = 43
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 504
    Top = 120
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 392
    Top = 104
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_tarjeta'
        DataType = ftInteger
      end
      item
        Name = 'fec_oper_desde'
        DataType = ftDate
      end
      item
        Name = 'fec_oper_hasta'
        DataType = ftDate
      end
      item
        Name = 'acepto'
        DataType = ftBoolean
      end
      item
        Name = 'fec_cie_desde'
        DataType = ftDate
      end
      item
        Name = 'fec_cie_hasta'
        DataType = ftDate
      end
      item
        Name = 'cupo_presentado'
        DataType = ftString
        Size = 2
      end
      item
        Name = 'fec_des_presen'
        DataType = ftDate
      end
      item
        Name = 'fec_has_presen'
        DataType = ftDate
      end
      item
        Name = 'pend_conci'
        DataType = ftBoolean
      end
      item
        Name = 'conci_sin_confirmar'
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
    Left = 96
    Top = 40
    object TInputoid_tarjeta: TIntegerField
      FieldName = 'oid_tarjeta'
    end
    object TInputfec_oper_desde: TDateField
      FieldName = 'fec_oper_desde'
    end
    object TInputfec_oper_hasta: TDateField
      FieldName = 'fec_oper_hasta'
    end
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
    object TInputfec_cie_desde: TDateField
      FieldName = 'fec_cie_desde'
    end
    object TInputfec_cie_hasta: TDateField
      FieldName = 'fec_cie_hasta'
    end
    object TInputcupo_presentado: TStringField
      FieldName = 'cupo_presentado'
      Size = 2
    end
    object TInputfec_des_presen: TDateField
      FieldName = 'fec_des_presen'
    end
    object TInputfec_has_presen: TDateField
      FieldName = 'fec_has_presen'
    end
    object TInputpend_conci: TBooleanField
      FieldName = 'pend_conci'
    end
    object TInputconci_sin_confirmar: TBooleanField
      FieldName = 'conci_sin_confirmar'
    end
    object TInputconci_confirmado: TBooleanField
      FieldName = 'conci_confirmado'
    end
    object TInputfec_desde_confirmado: TDateField
      FieldName = 'fec_desde_confirmado'
    end
    object TInputfec_hasta_confirmado: TDateField
      FieldName = 'fec_hasta_confirmado'
    end
    object TInputfec_desde_pend_conci: TDateField
      FieldName = 'fec_desde_pend_conci'
    end
    object TInputfec_hasta_pend_conci: TDateField
      FieldName = 'fec_hasta_pend_conci'
    end
    object TInputfec_desde_conci_sin_conf: TDateField
      FieldName = 'fec_desde_conci_sin_conf'
    end
    object TInputfec_hasta_conci_sin_conf: TDateField
      FieldName = 'fec_hasta_conci_sin_conf'
    end
    object TInputpend_gen_asi_cob: TStringField
      FieldName = 'pend_gen_asi_cob'
      Size = 2
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 128
    Top = 40
  end
  object TSINO: TsnTable
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
    Left = 232
    Top = 160
    object TSINOCODIGO: TStringField
      FieldName = 'CODIGO'
      Size = 10
    end
    object TSINODESCRIPCION: TStringField
      FieldName = 'DESCRIPCION'
      Size = 100
    end
  end
  object DSSINO: TDataSource
    DataSet = TSINO
    Left = 264
    Top = 160
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
    Left = 535
    Top = 62
  end
  object TTarjetas: TsnTable
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
    Left = 567
    Top = 62
    object TTarjetasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTarjetascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTarjetasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTarjetas: TDataSource
    DataSet = TTarjetas
    Left = 602
    Top = 60
  end
end
