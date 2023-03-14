inherited FConsPlanifRotas: TFConsPlanifRotas
  Left = 123
  Top = 118
  Width = 915
  Height = 694
  Caption = 'Consulta Planificaci'#243'n de Rotas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 899
    Height = 168
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 24
      Top = 19
      Width = 52
      Height = 16
      Caption = 'Legajos:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 24
      Top = 51
      Width = 41
      Height = 16
      Caption = 'Fecha:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 256
      Top = 51
      Width = 80
      Height = 16
      Caption = 'Fecha Hasta:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Visible = False
    end
    object Label4: TLabel
      Left = 24
      Top = 81
      Width = 32
      Height = 16
      Caption = 'Rota:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 626
      Top = 17
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageBuscar: TImage
      Left = 670
      Top = 17
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Ejecutar Consulta Planificaci'#243'n de Rotas'
      ParentShowHint = False
      ShowHint = True
    end
    object Shape1: TShape
      Left = 20
      Top = 185
      Width = 749
      Height = 32
      Brush.Color = 12177407
      Shape = stRoundRect
      Visible = False
    end
    object Label5: TLabel
      Left = 35
      Top = 193
      Width = 117
      Height = 13
      Caption = 'Cant. Empleados 1er d'#237'a'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlack
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Transparent = True
      Visible = False
    end
    object Label6: TLabel
      Left = 214
      Top = 193
      Width = 170
      Height = 13
      Caption = 'Cant. Empleados No Vienen 1er d'#237'a'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlack
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Transparent = True
      Visible = False
    end
    object Label7: TLabel
      Left = 416
      Top = 192
      Width = 76
      Height = 13
      Caption = 'Solo con Sanc.:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlack
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Transparent = True
      Visible = False
    end
    object Label8: TLabel
      Left = 518
      Top = 193
      Width = 87
      Height = 13
      Caption = 'Con Nov. y Sanc.:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlack
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Transparent = True
      Visible = False
    end
    object Label9: TLabel
      Left = 256
      Top = 81
      Width = 184
      Height = 16
      Caption = 'Juegos separados por comas:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label12: TLabel
      Left = 24
      Top = 115
      Width = 60
      Height = 16
      Caption = 'Horizonte:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 372
      Top = 111
      Caption = 'No Mostrar si tiene Franco o Novedad el primer d'#237'a'
      DataBinding.DataField = 'exc_si_tiene_nov'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 333
    end
    object snDBCheckEdit2: TsnDBCheckEdit
      Left = 364
      Top = 177
      Caption = 'Excluir si tiene sanciones'
      DataBinding.DataField = 'exc_si_tiene_sanc'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Visible = False
      Width = 183
    end
    object snDBLookup1: TsnDBLookup
      Left = 120
      Top = 15
      DataBinding.DataField = 'oid_filtro'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'oid_filtro'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSFiltros
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 489
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 120
      Top = 47
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 344
      Top = 47
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Visible = False
      ReadOnlyAlways = False
      Width = 121
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 120
      Top = 79
      DataBinding.DataField = 'rota'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      Help = HelpRotas
      Width = 121
    end
    object snDBEdit1: TsnDBEdit
      Left = 157
      Top = 190
      DataBinding.DataField = 'cant_leg_sinnov'
      DataBinding.DataSource = DSCantidadesTotales
      Properties.ReadOnly = True
      Style.Color = 14540253
      TabOrder = 8
      Visible = False
      Width = 49
    end
    object snDBEdit2: TsnDBEdit
      Left = 392
      Top = 190
      DataBinding.DataField = 'cant_leg_connov'
      DataBinding.DataSource = DSCantidadesTotales
      Properties.ReadOnly = True
      Style.Color = 14540253
      TabOrder = 9
      Visible = False
      Width = 49
    end
    object snDBEdit3: TsnDBEdit
      Left = 469
      Top = 190
      DataBinding.DataField = 'cant_leg_sinnov_consanc'
      DataBinding.DataSource = DSCantidadesTotales
      Properties.ReadOnly = True
      Style.Color = 14540253
      TabOrder = 10
      Visible = False
      Width = 49
    end
    object snDBEdit4: TsnDBEdit
      Left = 605
      Top = 190
      DataBinding.DataField = 'cant_leg_connov_consanc'
      DataBinding.DataSource = DSCantidadesTotales
      Properties.ReadOnly = True
      Style.Color = 14540253
      TabOrder = 11
      Visible = False
      Width = 49
    end
    object snDBEdit5: TsnDBEdit
      Left = 650
      Top = 180
      DataBinding.DataField = 'fecha_hora'
      DataBinding.DataSource = DSCantidadesTotales
      Properties.Alignment.Horz = taCenter
      Properties.ReadOnly = True
      Style.Color = 14540253
      Style.Edges = []
      TabOrder = 12
      Width = 109
    end
    object snDBEdit6: TsnDBEdit
      Left = 448
      Top = 77
      DataBinding.DataField = 'juego'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.CharCase = ecUpperCase
      Properties.MaxLength = 100
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 6
      Width = 257
    end
    object snDBLookup2: TsnDBLookup
      Left = 120
      Top = 111
      DataBinding.DataField = 'dias'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'dias'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSHorizonte
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 7
      Width = 121
    end
    object BotonGrabarConsulta: TsnButton
      Left = 720
      Top = 48
      Width = 161
      Height = 33
      Caption = 'Grabar Consulta'
      TabOrder = 13
      Glyph.Data = {
        C6050000424DC605000000000000360400002800000014000000140000000100
        0800000000009001000000000000000000000001000000000000000000001313
        130088471C00A3781E00AA491F00B0581F00B07C1F00BD6B2000BC6D2000BD74
        2000BD882000CA642100CA832100CA8E2100D7772200D86B2300EB632400E570
        2400E5812400E4882400ED852A00ED922A00EE7F3600EE8E360097763800EF87
        4400EF954400EF7E4A00F0905200F09B5200B3905600B3A95600F1A35F00F192
        6400F2A16B00F3A97800F3B27800F4A68000F4B18500F5B99100F5C29300F6B6
        9800CDC99E00F6C19F00F6CDA000F7BFA500DCD7AA00F7CAAC00F7D1AC00F8C7
        B300F8D1B800F8E3BA00F5F5F500B0DBF800C7DCF800BAE3F800E1ECFB000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        000000000000000000000000000000000000000000000000000017120F080808
        080505040404040000000000001B26220A022A2E2E2E02090907040000000000
        001B29242218021E33331F090B09040000000000001B2B262418010233331F0E
        0E0B050000000000001D2D2B2618181818181F14110E050000000000001D2F2F
        2B262422211C1B1614110F0000000000001D3130191514130D0C060316140F00
        000000000023321A343438373637353503160F00000000000023321C34343438
        37363735061A0F00000000000023322034343434383736370C1C0F0000000000
        0028322234343434343837360D210F0000000000002832253434343434343837
        13021000000000000028322734343434343434381410100000000000002C2C2C
        2C23231D1D1B1B1B1B1B1B000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        00000000000000000000}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonAbrirConsulta: TsnButton
      Left = 720
      Top = 88
      Width = 161
      Height = 33
      Caption = 'Abrir Consulta Grabada'
      TabOrder = 14
      Glyph.Data = {
        D6050000424DD605000000000000360000002800000014000000120000000100
        200000000000A005000000000000000000000000000000000000FFFFFF00FFFF
        FF0000000000000000170000000D000000100000000F0000000E0000000C0000
        0009000000060000000300000001FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF000000006E00000032000000300000
        002200000023000000220000001F0000001C00000019000000150000000F0000
        000B000000070000000300000001FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00040000FF365E77FF5CA8DCFF5B98C0FF7096ADF08B969CCE5E6A759A625E
        617E67534D5F0200002700000020000000200000001B00000016000000100000
        000900000003FFFFFF00FFFFFF00FFFFFF00223B4EFF000000FF32566DFF63B7
        EEFF5BB0EAFF56B1EFFF5BABDEFF5BA0CCFF6196B6FF65869DDC637782B9655F
        638A1722283E171A1B3A0000002C0000001E0000000BFFFFFF00FFFFFF00FFFF
        FF003CA0EBF9415968FF000000FF385A6EFF6AB6E2FE71C2F0FE6FC3F2FE6ABB
        E9FF65B8EBFF60AFE4FF60ABDAFF61ADDAFF5DA2CAFF568CAAFF828180A91B1A
        163700000013FFFFFF00FFFFFF00FFFFFF003A8AD4F4B7FCFFFF334F5DFF0200
        00FF517E91FE487185FF0F1921FF2A3127FF373E3CFF607F94FF71ADD5FD6EB3
        D5FD77CDF0FF6BD2FEFF5593BAFF2B39445600000018FFFFFF00FFFFFF00FFFF
        FF003289CCFFC0FCFFFF83E6FFFE7AA6B9FE4D453CFF5F644DFFB3CDB7FEBCCC
        A3FFE4CB5EFFC3A41CFF7A7061FF72AAC3FE77BBD4FE80D8F4FF5198D1FF6A53
        326400000019FFFFFF00FFFFFF00FFFFFF003692D0FFC3F7FFFF8EEBFFFEA3D7
        F0FF9C9363FFCFD3A8FFC6DFC4FFC0D8C7FFC3CDA3FFDDCB6EFFCCA609FF7C8C
        89FF7BBED5FE84DBF2FF529DD7FF9D7252880000001BFFFFFF00FFFFFF00FFFF
        FF003897D4FFC4F6FBFF97EFFFFEBBBC90FFF8E4B0FFE8F0C4FFDEE3B9FFD3DD
        B8FFC5D7BBFFC1D0ADFFDAE587FF876A26FF84CCE2FF8DE6F6FE5DA8DBFF7570
        769A0000001AFFFFFF00FFFFFF00FFFFFF003A9BD7FFC7F3FBFE9CF7FFFEC6BC
        6FFFFFEFBAFFEBE3A7FFE4DB9EFFD9D79CFFC8D1A1FFBED5B5FFC0F3D6FF7E74
        4FFF89D3E3FE96F1F6FD6EB8E3FF61727DAA0000001CFFFFFF00FFFFFF00FFFF
        FF00389CD7FFDAEDF6FEC0FFFFFED5D0A6FFFFFFC6FFF3E69CFFEBD484FFE0CC
        83FFD2CB8CFFC2CB97FFC2F6DCFF675B38FF99DAEBFFA6F4F8FE82C8EAFF5575
        87BA0000001EFFFFFF00FFFFFF00FFFFFF004FBBE6FF51B0E0FD63B8E1FE8091
        94FFFFFFB9FFFFFFAFFFF5DC78FFE8CC6CFFDCCA73FFD3D28FFECDCA8EFE4239
        21FFB8F1FEFEBCF5FAFD93D3F4FF59809BD100000021FFFFFF00FFFFFF00FFFF
        FF0058C6F3FFA8F4FBFD53D7F5FE43C3DEFF8B9075FFF9B900FFFFF96DFFFAE4
        5EFFF1D75BFFEABF52FF6D5006FF94A7A7FFEDFFFFFEE1FFFFFEB3E5FFFF6693
        B1ED0000001EFFFFFF00FFFFFF00FFFFFF0050C6F3FF9FF5FEFFA2F3FEFEA3F5
        FFFE99DBE1FFB2C8A8FFB0930AFFD29200FFB48600FF9EA87EFF87AFBEFEA8D1
        F2FDC4DFF2FDDEFBFCFFACDAF3FF82BEDEFF0000000CFFFFFF00FFFFFF00FFFF
        FF0094C0E2FF9CFAFEFF97F3FFFD96F0FDFE98F5FFFED4FFFFFF83CCFFFF60C6
        FFF762C5FFFF5BC2F7FF55C2E9FF56C2E8FF5AC2E8FF4DADDCFF4385B7FD2D6B
        A973FFFFFF00FFFFFF00FFFFFF00FFFFFF006EB2DEFEC9F5F8FFB7EFF9FFAEF1
        FBFFCEFEFFFF66A7D5E7235D97327CA3BF03B0D2E90EB4D4E415B6DEE7107DC5
        E47D8FCAE8C65CB6E1A117537C0BFFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF0053A5D947408CCD9D93C0E2FF93C0E2FF76B3D9AB2470AB45FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00A3C3DE07FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFF
        FF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00FFFFFF00}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonEjecutarConsulta: TsnButton
      Left = 720
      Top = 8
      Width = 161
      Height = 33
      Caption = 'Ejecutar Consulta'
      TabOrder = 15
      Glyph.Data = {
        36040000424D3604000000000000360000002800000010000000100000000100
        2000000000000004000000000000000000000000000000000000FFFFFF00FFFF
        FF000000001D0000003400000036000000360000003600000036000000360000
        003600000036000000360000003600000036000000330000001DFFFFFF00FFFF
        FF0000000034F9F9F9F5FCFCFCFDFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFC
        FCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFDF9F9F9F300000033FFFFFF000000
        000113546F5AD6ECF6FEFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFC
        FCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFD00000036FFFFFF000000
        0001196E8F703FB0DFFFB7E0F1FFFCFCFCFFFCFCFCFFFCFCFCFFFBFBFBFFFBFB
        FBFFFBFBFBFFFBFBFBFFFBFBFBFFFBFBFBFFFCFCFCFF00000036FFFFFF000000
        0001000000365FBFE5FF42B4E3FF6BBFE5FFEEF6FAFFFBFBFBFFFBFBFBFFFAFA
        FAFFFAFAFAFFFAFAFAFFFAFAFAFFFAFAFAFFFCFCFCFF00000036FFFFFF000000
        000100000036F1F8FAFF30AEDFFF50B9E6FF3AACDEFFA7D7EEFFFBFBFBFFFBFB
        FBFFFAFAFAFFFAFAFAFFF8F8F8FFF8F8F8FFFCFCFCFF0000003636C0E67434BC
        E58C299BBEA08AD5EDFF3CB6E2FF7CD0F0FF6CC7ECFF43B1E2FF71BFE5FFDDEE
        F7FFFBFBFBFFF9F9F9FFF9F9F9FFF8F8F8FFFCFCFCFF0000003639C4E8CA6DD8
        F0FF67D3EFFF65CFEDFF83D9F3FF87D7F4FF7CCFF1FF57BBE8FF51B6E5FF219C
        D7FFA3D2EBFFEFF4F7FFF6F6F6FFF6F6F6FFFCFCFCFF000000363BC9E93739C4
        E8EB8FE6F8FF8CE3F7FF5FD2F2FF83D7F4FF3BB6E2FF85D0EBFF8AD0EBFF81CA
        E9FF8DCCE8FFDDEBF2FFF3F3F3FFF2F2F2FFFCFCFCFF000000363ECCEB063CC9
        EA846AD9F1FF95E7F8FF46CFF2FF88DCF4FF37B8E3FFA3DDF0FFFBFBFBFFF8F8
        F8FFF5F5F5FFF2F2F2FFEFEFEFFFEDEDEDFFFCFCFCFF00000036FFFFFF003CC5
        E4213BC7E7F592E7F8FF5ED8F4FF8FE0F6FF7CD6F2FF51C2E9FFA7DDEFFFF5F5
        F5FFF1F1F1FFECECECFFEAEAEAFFE6E6E6FFFCFCFCFF00000036FFFFFF00309A
        B00436B1CDAC73DEF3FF88E3F6FF84DEF5FF80D9F4FF77D3F1FF4FC1E8FFAADB
        ECFFE9EBEBFFFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFF00000036FFFFFF000000
        00012882936B5CD5EEFF58D1ECFF56CEEBFF54CBE9FF52C8E9FF4CC2E6FF56C2
        E6FFD5E4E9FFFCFCFCFFF6F6F6FFF4F4F4FF9898989100000020FFFFFF00FFFF
        FF0000000036FBFBFBFDF4F4F4FFF5F5F5FFF5F5F5FFF5F5F5FFF1F1F1FFEFEF
        EFFFE9E9E9FFFCFCFCFFE7E7E7FF949494910000002000000002FFFFFF00FFFF
        FF0000000033F8F8F8F0FBFBFBFDFCFCFCFFFCFCFCFFFCFCFCFFFCFCFCFFFCFC
        FCFFFCFCFCFFF8F8F8FF939393910000002000000002FFFFFF00FFFFFF00FFFF
        FF000000001C0000003300000036000000360000003600000036000000360000
        003600000036000000360000002000000002FFFFFF00FFFFFF00}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonVerifNov: TsnButton
      Left = 720
      Top = 128
      Width = 161
      Height = 9
      Caption = 'Verificar si hay Novedades'
      TabOrder = 16
      Visible = False
      LookAndFeel.Kind = lfOffice11
    end
    object snDBEdit7: TsnDBEdit
      Left = 120
      Top = 144
      DataBinding.DataField = 'novedad'
      DataBinding.DataSource = DSNovedadesRotas
      ParentFont = False
      Properties.ReadOnly = True
      Style.Edges = []
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clRed
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = [fsBold]
      Style.IsFontAssigned = True
      TabOrder = 17
      Width = 577
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 168
    Width = 899
    Height = 488
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object PageControlSN1: TPageControlSN
      Left = 1
      Top = 1
      Width = 897
      Height = 486
      ActivePage = TabSheet1
      Align = alClient
      TabOrder = 0
      object TabSheet1: TTabSheet
        Caption = 'Detalle de Empleados      '
        object Splitter1: TSplitter
          Left = 869
          Top = 0
          Width = 5
          Height = 458
          Color = 8404992
          ParentColor = False
        end
        object dxDBGridSN1: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 869
          Height = 458
          Hint = 'Utilice la Barra azul para cambiar el ancho de la grilla'
          Align = alLeft
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_1'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_2'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_3'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_4'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_5'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_6'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'nov_dia_7'
              TipoCondFiltro1 = tcfDistinto
              TipoCondFiltro2 = tcfIgual
              Color = 9094655
            end
            item
              TipoPintadaCelda = tpcSoloColumnaCampo
              FieldName1 = 'novedad'
              TipoCondFiltro1 = tcfDistinto
              Valor1 = ' '
              TipoCondFiltro2 = tcfIgual
              Color = 8224255
            end>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSConsultaPlanif
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
            object dxDBGridSN1DBTableView1nro_legajo: TcxGridDBColumn
              Caption = 'Legajo'
              DataBinding.FieldName = 'nro_legajo'
              HeaderAlignmentHorz = taCenter
              Width = 84
            end
            object dxDBGridSN1DBTableView1ape_y_nom: TcxGridDBColumn
              Caption = 'Apellido y Nombre'
              DataBinding.FieldName = 'ape_y_nom'
              HeaderAlignmentHorz = taCenter
              Width = 173
            end
            object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
              Caption = 'Fecha'
              DataBinding.FieldName = 'fecha'
              HeaderAlignmentHorz = taCenter
              SortIndex = 0
              SortOrder = soAscending
              Width = 82
            end
            object dxDBGridSN1DBTableView1rota: TcxGridDBColumn
              Caption = 'Rota'
              DataBinding.FieldName = 'rota'
              HeaderAlignmentHorz = taCenter
              SortIndex = 1
              SortOrder = soAscending
              Width = 84
            end
            object dxDBGridSN1DBTableView1juegos: TcxGridDBColumn
              Caption = 'Juegos'
              DataBinding.FieldName = 'juegos'
              HeaderAlignmentHorz = taCenter
              Width = 175
            end
            object dxDBGridSN1DBTableView1categoria: TcxGridDBColumn
              Caption = 'Categor'#237'a'
              DataBinding.FieldName = 'categoria'
              HeaderAlignmentHorz = taCenter
              Width = 350
            end
            object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
              Caption = 'Novedad'
              DataBinding.FieldName = 'novedad'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 250
            end
            object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
              Caption = 'Sanci'#243'n'
              DataBinding.FieldName = 'sancion'
              HeaderAlignmentHorz = taCenter
              Width = 250
            end
          end
          object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSConsultaPlanif
            DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
            DataController.Summary.DefaultGroupSummaryItems = <
              item
                Kind = skCount
                Position = spFooter
                Column = dxDBGridSN1DBBandedTableView1Column3
              end>
            DataController.Summary.FooterSummaryItems = <
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_novedad'
                Column = dxDBGridSN1DBBandedTableView1novedad
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_1'
                Column = dxDBGridSN1DBBandedTableView1Column3
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_2'
                Column = dxDBGridSN1DBBandedTableView1Column4
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_3'
                Column = dxDBGridSN1DBBandedTableView1Column5
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_4'
                Column = dxDBGridSN1DBBandedTableView1Column6
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_5'
                Column = dxDBGridSN1DBBandedTableView1Column7
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_6'
                Column = dxDBGridSN1DBBandedTableView1Column8
              end
              item
                Format = '####0'
                Kind = skSum
                FieldName = 'viene_nov_dia_7'
                Column = dxDBGridSN1DBBandedTableView1Column9
              end>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.FocusCellOnTab = True
            OptionsBehavior.GoToNextCellOnEnter = True
            OptionsBehavior.IncSearch = True
            OptionsBehavior.FocusCellOnCycle = True
            OptionsCustomize.ColumnHiding = True
            OptionsCustomize.ColumnsQuickCustomization = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
            OptionsView.ColumnAutoWidth = True
            OptionsView.Footer = True
            Styles.Content = cxStyle1
            Bands = <
              item
                Caption = 'Legajo'
                FixedKind = fkLeft
                Width = 333
              end
              item
                Caption = 'Planificaci'#243'n'
                Visible = False
              end
              item
                Caption = 'Novedades'
                Options.HoldOwnColumnsOnly = True
                Width = 520
              end>
            object dxDBGridSN1DBBandedTableView1nro_legajo: TcxGridDBBandedColumn
              Caption = 'Legajo'
              DataBinding.FieldName = 'nro_legajo'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 41
              Position.BandIndex = 0
              Position.ColIndex = 0
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1ape_y_nom: TcxGridDBBandedColumn
              Caption = 'Apellido y Nombre'
              DataBinding.FieldName = 'ape_y_nom'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 143
              Position.BandIndex = 0
              Position.ColIndex = 1
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1rota: TcxGridDBBandedColumn
              Caption = 'Rota'
              DataBinding.FieldName = 'rota'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 85
              Position.BandIndex = 1
              Position.ColIndex = 1
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1fecha: TcxGridDBBandedColumn
              Caption = 'Fecha'
              DataBinding.FieldName = 'fecha'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 86
              Position.BandIndex = 1
              Position.ColIndex = 0
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1juegos: TcxGridDBBandedColumn
              Caption = 'Juegos'
              DataBinding.FieldName = 'juegos'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 149
              Position.BandIndex = 0
              Position.ColIndex = 2
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1categoria: TcxGridDBBandedColumn
              Caption = 'Categor'#237'a'
              DataBinding.FieldName = 'categoria'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              SortIndex = 1
              SortOrder = soAscending
              Width = 104
              Position.BandIndex = 2
              Position.ColIndex = 0
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1novedad: TcxGridDBBandedColumn
              Caption = 'Hoy'
              DataBinding.FieldName = 'novedad'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 53
              Position.BandIndex = 2
              Position.ColIndex = 1
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column1: TcxGridDBBandedColumn
              Caption = 'Sector'
              DataBinding.FieldName = 'sector'
              Visible = False
              GroupIndex = 2
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Position.BandIndex = -1
              Position.ColIndex = -1
              Position.RowIndex = -1
            end
            object dxDBGridSN1DBBandedTableView1Column2: TcxGridDBBandedColumn
              Caption = 'Empresa'
              DataBinding.FieldName = 'empresa'
              Visible = False
              GroupIndex = 1
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Position.BandIndex = -1
              Position.ColIndex = -1
              Position.RowIndex = -1
            end
            object dxDBGridSN1DBBandedTableView1Column3: TcxGridDBBandedColumn
              Caption = '1'
              DataBinding.FieldName = 'nov_dia_1'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 51
              Position.BandIndex = 2
              Position.ColIndex = 2
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column4: TcxGridDBBandedColumn
              Caption = '2'
              DataBinding.FieldName = 'nov_dia_2'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 53
              Position.BandIndex = 2
              Position.ColIndex = 3
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column5: TcxGridDBBandedColumn
              Caption = '3'
              DataBinding.FieldName = 'nov_dia_3'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 52
              Position.BandIndex = 2
              Position.ColIndex = 4
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column6: TcxGridDBBandedColumn
              Caption = '4'
              DataBinding.FieldName = 'nov_dia_4'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 50
              Position.BandIndex = 2
              Position.ColIndex = 5
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column7: TcxGridDBBandedColumn
              Caption = '5'
              DataBinding.FieldName = 'nov_dia_5'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 53
              Position.BandIndex = 2
              Position.ColIndex = 6
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column8: TcxGridDBBandedColumn
              Caption = '6'
              DataBinding.FieldName = 'nov_dia_6'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 51
              Position.BandIndex = 2
              Position.ColIndex = 7
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column9: TcxGridDBBandedColumn
              Caption = '7'
              DataBinding.FieldName = 'nov_dia_7'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 53
              Position.BandIndex = 2
              Position.ColIndex = 8
              Position.RowIndex = 0
            end
            object dxDBGridSN1DBBandedTableView1Column10: TcxGridDBBandedColumn
              DataBinding.FieldName = 'agrupador'
              Visible = False
              GroupIndex = 0
              Position.BandIndex = 0
              Position.ColIndex = 3
              Position.RowIndex = 0
              IsCaptionAssigned = True
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBBandedTableView1
          end
        end
        object Panel3: TPanel
          Left = 874
          Top = 0
          Width = 15
          Height = 458
          Align = alClient
          Color = clWindow
          TabOrder = 1
        end
      end
      object TabSheet2: TTabSheet
        Caption = 'Gr'#225'fico Te'#243'rico de Empleados a concurrir     '
        ImageIndex = 1
        object dxDBGridSN2: TdxDBGridSN
          Left = 0
          Top = 41
          Width = 889
          Height = 443
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object dxDBGridSN2DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSConsultaPlanif
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
          end
          object dxDBGridSN2DBChartView1: TcxGridDBChartView
            DataController.DataSource = DSConsultaPlanif
            DiagramBar.Values.CaptionPosition = cdvcpCenter
            DiagramColumn.Active = True
            DiagramColumn.Values.CaptionPosition = cdvcpOutsideEnd
            DiagramLine.Values.CaptionPosition = ldvcpBelow
            Legend.Alignment = cpaEnd
            Legend.Position = cppRight
            OptionsBehavior.ValueHotTrack = vhAlways
            OptionsCustomize.DataGroupHiding = True
            OptionsView.CategoriesPerPage = 10
            Title.Alignment = cpaCenter
            Title.Text = 'Gr'#225'fico Te'#243'rico de Empleados a Concurrir'
            Title.Position = cppTop
            ToolBox.CustomizeButton = True
            ToolBox.DataLevelsInfoVisible = dlivNever
            ToolBox.Position = tpBottom
            ToolBox.Visible = tvAlways
            object dxDBGridSN2DBChartView1DataGroup1: TcxGridDBChartDataGroup
              DataBinding.FieldName = 'empleados_a_venir'
              DisplayText = 'Empleados'
            end
            object dxDBGridSN2DBChartView1DataGroup3: TcxGridDBChartDataGroup
              DataBinding.FieldName = 'sector'
              DisplayText = 'Sector'
            end
            object dxDBGridSN2DBChartView1DataGroup2: TcxGridDBChartDataGroup
              DataBinding.FieldName = 'categoria'
              DisplayText = 'Categor'#237'a'
              VisibleForCustomization = False
            end
            object dxDBGridSN2DBChartView1DataGroup4: TcxGridDBChartDataGroup
              DataBinding.FieldName = 'ape_y_nom'
              DisplayText = 'Legajo'
            end
            object dxDBGridSN2DBChartView1DataGroup5: TcxGridDBChartDataGroup
              DataBinding.FieldName = 'ape_y_nom'
              DisplayText = 'Legajo'
            end
            object dxDBGridSN2DBChartView1Series1: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_novedad'
            end
            object dxDBGridSN2DBChartView1Series2: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_1'
            end
            object dxDBGridSN2DBChartView1Series3: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_2'
            end
            object dxDBGridSN2DBChartView1Series4: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_3'
            end
            object dxDBGridSN2DBChartView1Series5: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_4'
            end
            object dxDBGridSN2DBChartView1Series6: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_5'
            end
            object dxDBGridSN2DBChartView1Series7: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_6'
            end
            object dxDBGridSN2DBChartView1Series8: TcxGridDBChartSeries
              DataBinding.FieldName = 'viene_nov_dia_7'
            end
          end
          object dxDBGridSN2Level1: TcxGridLevel
            GridView = dxDBGridSN2DBChartView1
          end
        end
        object Panel4: TPanel
          Left = 0
          Top = 0
          Width = 889
          Height = 41
          Align = alTop
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 1
          object Label10: TLabel
            Left = 16
            Top = 4
            Width = 500
            Height = 13
            Caption = 
              '(Haga un click con el bot'#243'n izquierdo del MOUSE sobre la barra d' +
              'el gr'#225'fico para explorar m'#225's informaci'#243'n)'
          end
          object Label11: TLabel
            Left = 16
            Top = 24
            Width = 497
            Height = 13
            Caption = 
              '(Haga un click con el bot'#243'n derecho del MOUSE sobre el gr'#225'fico d' +
              'e barras para volver al gr'#225'fico anterior)'
          end
        end
      end
      object TabSheet3: TTabSheet
        Caption = 'Novedades    '
        ImageIndex = 2
        object Panel5: TPanel
          Left = 0
          Top = 0
          Width = 889
          Height = 36
          Align = alTop
          Color = clWindow
          TabOrder = 0
          object Label13: TLabel
            Left = 8
            Top = 8
            Width = 108
            Height = 16
            Caption = 'Novedades a hoy'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
        end
        object Panel6: TPanel
          Left = 0
          Top = 36
          Width = 889
          Height = 422
          Align = alClient
          Color = clWindow
          TabOrder = 1
          object dxDBGridSN3: TdxDBGridSN
            Left = 1
            Top = 1
            Width = 887
            Height = 420
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <
              item
                TipoPintadaCelda = tpcTodasLasColumnas
                FieldName1 = 'viene'
                TipoCondFiltro1 = tcfIgual
                Valor1 = '0'
                TipoCondFiltro2 = tcfIgual
                Color = 5987327
              end
              item
                TipoPintadaCelda = tpcTodasLasColumnas
                FieldName1 = 'viene'
                TipoCondFiltro1 = tcfIgual
                Valor1 = '1'
                TipoCondFiltro2 = tcfIgual
                Color = 42496
              end>
            object dxDBGridSN3DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSNovedadesRotas
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsView.CellAutoHeight = True
              object dxDBGridSN3DBTableView1nro_legajo: TcxGridDBColumn
                Caption = 'Nro. Legajo'
                DataBinding.FieldName = 'nro_legajo'
                HeaderAlignmentHorz = taCenter
                Width = 70
              end
              object dxDBGridSN3DBTableView1ape_y_nom_legajo: TcxGridDBColumn
                Caption = 'Apellido y Nombre'
                DataBinding.FieldName = 'ape_y_nom_legajo'
                HeaderAlignmentHorz = taCenter
                Width = 241
              end
              object dxDBGridSN3DBTableView1anterior: TcxGridDBColumn
                Caption = 'Situaci'#243'n Anterior'
                DataBinding.FieldName = 'anterior'
                HeaderAlignmentHorz = taCenter
                Width = 250
              end
              object dxDBGridSN3DBTableView1actual: TcxGridDBColumn
                Caption = 'Situaci'#243'n Actual (Novedad)'
                DataBinding.FieldName = 'actual'
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object dxDBGridSN3DBTableView1juegos: TcxGridDBColumn
                Caption = 'Juegos'
                DataBinding.FieldName = 'juegos'
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object dxDBGridSN3DBTableView1categoria: TcxGridDBColumn
                Caption = 'Categor'#237'a'
                DataBinding.FieldName = 'categoria'
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object dxDBGridSN3DBTableView1sector: TcxGridDBColumn
                Caption = 'Sector'
                DataBinding.FieldName = 'sector'
                HeaderAlignmentHorz = taCenter
                Width = 200
              end
              object dxDBGridSN3DBTableView1empresa: TcxGridDBColumn
                Caption = 'Empresa'
                DataBinding.FieldName = 'empresa'
                HeaderAlignmentHorz = taCenter
                Width = 134
              end
              object dxDBGridSN3DBTableView1fecha_novedad: TcxGridDBColumn
                Caption = 'Fecha Rota'
                DataBinding.FieldName = 'fecha_novedad'
                Visible = False
                GroupIndex = 0
              end
            end
            object dxDBGridSN3DBBandedTableView1: TcxGridDBBandedTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSNovedadesRotas
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsData.Inserting = False
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Styles.Content = cxStyle1
              Bands = <
                item
                  Caption = 'Empleado'
                  FixedKind = fkLeft
                  Width = 525
                end
                item
                  Caption = 'Otros Datos'
                end>
              object dxDBGridSN3DBBandedTableView1nro_legajo: TcxGridDBBandedColumn
                Caption = 'Legajo'
                DataBinding.FieldName = 'nro_legajo'
                HeaderAlignmentHorz = taCenter
                Width = 104
                Position.BandIndex = 0
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1ape_y_nom_legajo: TcxGridDBBandedColumn
                Caption = 'Apellido y Nombre'
                DataBinding.FieldName = 'ape_y_nom_legajo'
                HeaderAlignmentHorz = taCenter
                Width = 200
                Position.BandIndex = 0
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1empresa: TcxGridDBBandedColumn
                Caption = 'Empresa'
                DataBinding.FieldName = 'empresa'
                HeaderAlignmentHorz = taCenter
                Width = 136
                Position.BandIndex = 1
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1sector: TcxGridDBBandedColumn
                Caption = 'Sector'
                DataBinding.FieldName = 'sector'
                HeaderAlignmentHorz = taCenter
                Width = 150
                Position.BandIndex = 1
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1categoria: TcxGridDBBandedColumn
                Caption = 'Categor'#237'a'
                DataBinding.FieldName = 'categoria'
                HeaderAlignmentHorz = taCenter
                Width = 150
                Position.BandIndex = 1
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1juegos: TcxGridDBBandedColumn
                Caption = 'Juegos'
                DataBinding.FieldName = 'juegos'
                HeaderAlignmentHorz = taCenter
                Width = 150
                Position.BandIndex = 1
                Position.ColIndex = 3
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1fecha_novedad: TcxGridDBBandedColumn
                Caption = 'Fecha ROTA'
                DataBinding.FieldName = 'fecha_novedad'
                Visible = False
                GroupIndex = 1
                Position.BandIndex = 1
                Position.ColIndex = 4
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1anterior: TcxGridDBBandedColumn
                Caption = 'Consulta Grabada'
                DataBinding.FieldName = 'anterior'
                HeaderAlignmentHorz = taCenter
                Width = 100
                Position.BandIndex = 0
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1actual: TcxGridDBBandedColumn
                Caption = 'Ejecuci'#243'n a Hoy '
                DataBinding.FieldName = 'actual'
                HeaderAlignmentHorz = taCenter
                Width = 100
                Position.BandIndex = 0
                Position.ColIndex = 3
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1Column1: TcxGridDBBandedColumn
                DataBinding.FieldName = 'viene'
                Visible = False
                Position.BandIndex = 0
                Position.ColIndex = 4
                Position.RowIndex = 0
              end
              object dxDBGridSN3DBBandedTableView1Column2: TcxGridDBBandedColumn
                DataBinding.FieldName = 'agrupador'
                Visible = False
                GroupIndex = 0
                Position.BandIndex = 0
                Position.ColIndex = 5
                Position.RowIndex = 0
                IsCaptionAssigned = True
              end
            end
            object dxDBGridSN3Level1: TcxGridLevel
              GridView = dxDBGridSN3DBBandedTableView1
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TFiltros
        TableName = 'TFiltros'
      end
      item
        DataSet = TConsPlanif
        TableName = 'TConsPlanif'
      end
      item
        DataSet = TCantidadesTotales
        TableName = 'TCantidadesTotales'
      end
      item
        DataSet = TDiasColumnas
        TableName = 'TDiasColumnas'
      end
      item
        DataSet = TInput
        TableName = 'TInput'
      end
      item
        DataSet = TNovedadesRotas
        TableName = 'TNovedadesRotas'
      end
      item
        DataSet = TNroConsultaGrabada
        TableName = 'TNroConsultaGrabada'
      end>
    Left = 152
    Top = 320
  end
  inherited Operacion: TOperacion
    Left = 192
    Top = 320
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 232
    Top = 320
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 272
    Top = 320
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'rota'
        Source.Strings = (
          'begin'
          '  ValidadorRora.Value := Sender.AsString;'
          '  ValidadorRora.Validar();'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'fec_desde'
        Source.Strings = (
          'begin'
          '  TInput.FieldName('#39'fec_hasta'#39').Value := Sender.Value;'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'dias'
        Source.Strings = (
          'begin'
          '  MostrarColumnasSegunHoriz();'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'oid_filtro'
        Source.Strings = (
          'begin'
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'fec_desde'
        Source.Strings = (
          'begin'
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          'end.')
      end
      item
        TableName = 'Tinput'
        FieldName = 'fec_hasta'
        Source.Strings = (
          'begin'
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'oid_rota'
        Source.Strings = (
          'begin'
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'juego'
        Source.Strings = (
          'begin'
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          'end.')
      end
      item
        TableName = 'Tinput'
        FieldName = 'exc_si_tiene_nov'
        Source.Strings = (
          'begin'
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'dias'#39').AsInteger := 1;'
          '  DataSet.FieldName('#39'exc_si_tiene_nov'#39').AsBoolean := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  cargarFiltros();'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          '  TInput.FieldName('#39'exc_si_tiene_nov'#39').Value := True;'
          '  TInput.FieldName('#39'exc_si_tiene_sanc'#39').Value := False;'
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  dxDBGridSN1.ActivarEventoPintarCeldas();'
          '  dxDBGridSN3.ActivarEventoPintarCeldas();'
          '  cargarHorizonteEnDias();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarFiltros();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFiltrosLegConsPlanifRotas'#39');'
          ' operacion.execute();'
          'end;'
          ''
          ''
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          ''
          
            '  TConsPlanif.FieldName('#39'viene_novedad'#39').DisplayLabel := '#39'viene_' +
            'novedad'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_1'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_1'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_2'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_2'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_3'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_3'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_4'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_4'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_5'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_5'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_6'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_6'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_7'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_7'#39';'
          ''
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConsPlanifRotasDM'#39');'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.execute();'
          '  dxDBGridSN1.gotoFirstRecord; '
          ''
          
            '  TConsPlanif.FieldName('#39'viene_novedad'#39').DisplayLabel := TDiasCo' +
            'lumnas.FieldName('#39'dia'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_1'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label1'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_2'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label2'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_3'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label3'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_4'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label4'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_5'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label5'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_6'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label6'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_7'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label7'#39').AsString;'
          ''
          
            '  dxDBGridSN1.setCaptionColumn('#39'novedad'#39',TDiasColumnas.FieldName' +
            '('#39'dia'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_1'#39',TDiasColumnas.FieldNa' +
            'me('#39'label1'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_2'#39',TDiasColumnas.FieldNa' +
            'me('#39'label2'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_3'#39',TDiasColumnas.FieldNa' +
            'me('#39'label3'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_4'#39',TDiasColumnas.FieldNa' +
            'me('#39'label4'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_5'#39',TDiasColumnas.FieldNa' +
            'me('#39'label5'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_6'#39',TDiasColumnas.FieldNa' +
            'me('#39'label6'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_7'#39',TDiasColumnas.FieldNa' +
            'me('#39'label7'#39').AsString);'
          ''
          ''
          '  dxDBGridSN1.goFirstRecord;'
          ''
          '  if (TConsPlanif.IsEmpty())'
          
            '      then mensaje.information('#39'No se encontr'#243' planificaci'#243'n de ' +
            'rotas para los filtros seleccionados'#39')'
          
            '      else mensaje.information('#39'Se ejecut'#243' la consulta EXITOSAME' +
            'NTE!'#39'); '
          ''
          ''
          'end;'
          ''
          ''
          'procedure cargarHorizonteEnDias();'
          'begin'
          ''
          'THorizonte.Close;'
          'THorizonte.Open;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 1;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'1 D'#237'a'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 2;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'2 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 3;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'3 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 4;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'4 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 5;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'5 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 6;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'6 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 7;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'7 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'THorizonte.AppendRecord;'
          'THorizonte.FieldName('#39'dias'#39').AsInteger := 8;'
          'THorizonte.FieldName('#39'descripcion'#39').AsString := '#39'8 D'#237'as'#39';'
          'THorizonte.PostRecord;'
          ''
          'end;'
          ''
          'procedure MostrarColumnasSegunHoriz();'
          'var'
          '  i : integer;'
          'begin'
          ''
          '   dxDBGridSN1.setWidthBand(0,400);'
          ''
          '  dxDBGridSN1.setColumnaVisible('#39'novedad'#39',true);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_1'#39',false);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_2'#39',false);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_3'#39',false);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_4'#39',false);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_5'#39',false);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_6'#39',false);'
          '  dxDBGridSN1.setColumnaVisible('#39'nov_dia_7'#39',false);'
          ''
          '  for i:=1 to (TInput.FieldName('#39'dias'#39').AsInteger-1) do'
          '     begin'
          '     dxDBGridSN1.setColumnaVisible('#39'nov_dia_'#39'+IntToStr(i),true);'
          '     end;'
          ''
          '  if (TInput.FieldName('#39'dias'#39').AsInteger=1)'
          
            '     then dxDBGridSN1.setWidthBand(2,100+(60*TInput.FieldName('#39'd' +
            'ias'#39').AsInteger))'
          
            '     else  dxDBGridSN1.setWidthBand(2,80+(60*TInput.FieldName('#39'd' +
            'ias'#39').AsInteger));'
          ''
          ''
          'end;'
          ''
          ''
          'procedure cargarDataSetParaEnv();'
          'begin'
          ''
          'TEnviar.Close;'
          'TEnviar.Open;'
          ''
          'TConsPlanif.First;'
          'while (not TConsPlanif.EOF()) do'
          '   begin'
          ' '
          '   TEnviar.AppendRecord;  '
          
            '   TEnviar.FieldName('#39'oid_legajo'#39').Value := TConsPlanif.FieldNam' +
            'e('#39'oid_legajo'#39').Value;'
          
            '   TEnviar.FieldName('#39'novedad'#39').Value := TConsPlanif.FieldName('#39 +
            'novedad'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_1'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_1'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_2'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_2'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_3'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_3'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_4'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_4'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_5'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_5'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_6'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_6'#39').Value;'
          
            '   TEnviar.FieldName('#39'nov_dia_7'#39').Value := TConsPlanif.FieldName' +
            '('#39'nov_dia_7'#39').Value;'
          
            '   TEnviar.FieldName('#39'agrupador'#39').Value := TConsPlanif.FieldName' +
            '('#39'agrupador'#39').Value;'
          
            '   TEnviar.FieldName('#39'nro_consulta'#39').Value := TConsPlanif.FieldN' +
            'ame('#39'nro_consulta'#39').Value;'
          '   TEnviar.PostRecord; '
          ''
          '   TConsPlanif.next;'
          '   end;'
          ''
          'end;'
          ''
          ''
          'procedure grabarConsultaRotas();'
          'begin'
          ''
          '  cargarDataSetParaEnv();'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveConsRotas'#39');'
          '  operacion.addDataSet(TInput.getDataSet());'
          '  operacion.addDataSet(TEnviar.getDataSet());'
          '  operacion.execute(); '
          ''
          
            '  mensaje.information('#39'Se grab'#243' la consulta Nro.:'#39'+TNroConsultaG' +
            'rabada.FieldName('#39'oid'#39').AsString);'
          ''
          'end;'
          ''
          'procedure TraerConsultaGrabada(OidGrabCons : integer);'
          'begin'
          ''
          '  TConsPlanif.Close;'
          '  TConsPlanif.Open;'
          '  TNovedadesRotas.Close;'
          '  TNovedadesRotas.Open;'
          ''
          
            '  TConsPlanif.FieldName('#39'viene_novedad'#39').DisplayLabel := '#39'viene_' +
            'novedad'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_1'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_1'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_2'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_2'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_3'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_3'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_4'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_4'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_5'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_5'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_6'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_6'#39';'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_7'#39').DisplayLabel := '#39'vien' +
            'e_nov_dia_7'#39';'
          ''
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConsPlanifRotasDM'#39');'
          '  operacion.AddAtribute('#39'TRAER_CONS_GRABADA'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'oid_grab_cons_rota'#39',IntToStr(OidGrabCon' +
            's));'
          '  operacion.execute();'
          ''
          'dxDBGridSN1.gotoFirstRecord;'
          
            '  TConsPlanif.FieldName('#39'viene_novedad'#39').DisplayLabel := TDiasCo' +
            'lumnas.FieldName('#39'dia'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_1'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label1'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_2'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label2'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_3'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label3'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_4'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label4'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_5'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label5'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_6'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label6'#39').AsString;'
          
            '  TConsPlanif.FieldName('#39'viene_nov_dia_7'#39').DisplayLabel := TDias' +
            'Columnas.FieldName('#39'label7'#39').AsString;'
          ''
          
            '  dxDBGridSN1.setCaptionColumn('#39'novedad'#39',TDiasColumnas.FieldName' +
            '('#39'dia'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_1'#39',TDiasColumnas.FieldNa' +
            'me('#39'label1'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_2'#39',TDiasColumnas.FieldNa' +
            'me('#39'label2'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_3'#39',TDiasColumnas.FieldNa' +
            'me('#39'label3'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_4'#39',TDiasColumnas.FieldNa' +
            'me('#39'label4'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_5'#39',TDiasColumnas.FieldNa' +
            'me('#39'label5'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_6'#39',TDiasColumnas.FieldNa' +
            'me('#39'label6'#39').AsString);'
          
            '  dxDBGridSN1.setCaptionColumn('#39'nov_dia_7'#39',TDiasColumnas.FieldNa' +
            'me('#39'label7'#39').AsString);'
          ''
          ''
          '  dxDBGridSN1.goFirstRecord;'
          ''
          '  MostrarColumnasSegunHoriz();'
          ''
          '  if (TConsPlanif.IsEmpty())'
          
            '      then mensaje.information('#39'No se encontr'#243' planificaci'#243'n de ' +
            'rotas para los filtros seleccionados'#39');'
          ''
          ''
          'end;'
          ''
          ''
          'procedure EjecutarLaConsulta();'
          'begin'
          ' TInput.PostRecord();'
          '  EjecutarConsulta();'
          '  MostrarColumnasSegunHoriz();'
          'end;'
          ''
          'procedure getNovedades(soloNovedadesPrimerDia : boolean);'
          'begin'
          '  cargarDataSetParaEnv();'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerConsPlanifRotasDM'#39');'
          '  operacion.AddAtribute('#39'OBTENER_NOVEDADES'#39','#39#39');'
          '  if (soloNovedadesPrimerDia)'
          '      then  operacion.AddAtribute('#39'SOLO_NOV_PRIMER_DIA'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'agrupador'#39',TConsPlanif.FieldName('#39'agrup' +
            'ador'#39').AsString);'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.AddDataSet(TEnviar.getDataSet());'
          '  operacion.execute();'
          ''
          '  dxDBGridSN3.gotoFirstRecord;'
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
          '  EjecutarLaConsulta();'
          'end.')
      end
      item
        ButtonName = 'BotonGrabarConsulta'
        Source.Strings = (
          'begin'
          ''
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'oid_filtro'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar el filt' +
            'ro de Legajos'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar la fech' +
            'a Desde'#39');'
          ''
          ''
          '  if ((TConsPlanif.Active=false) or (TConsPlanif.count()=0))'
          '      then begin'
          
            '              if (not mensaje.question('#39'La consulta que intenta ' +
            'grabar esta vac'#237'a. '#191'Desea continuar?'#39'))'
          '                  then exit;'
          '              end;'
          ''
          '  FormGrabar.ShowModal();'
          
            '  if (FormGrabar.getDataSet('#39'TInput'#39').FieldName('#39'acepto'#39').AsInte' +
            'ger=1)'
          '      then begin'
          '              TInput.EditRecord;'
          
            '              TInput.FieldName('#39'grabar_nombre'#39').AsString := Form' +
            'Grabar.getDataSet('#39'TInput'#39').FieldName('#39'nombre'#39').AsString;'
          
            '              TInput.FieldName('#39'agrupador'#39').AsString := TConsPla' +
            'nif.FieldName('#39'agrupador'#39').AsString;'
          '              TInput.PostRecord;'
          '              grabarConsultaRotas();   '
          '              end;'
          'end.')
      end
      item
        ButtonName = 'BotonAbrirConsulta'
        Source.Strings = (
          'begin'
          '  FormAbrirConsulta.ShowModal();'
          
            '  if (FormAbrirConsulta.getDataSet('#39'TInput'#39').FieldName('#39'acepto'#39')' +
            '.Value=true)'
          '      then begin'
          
            '              if (FormAbrirConsulta.getDataSet('#39'TConsultasGrabad' +
            'as'#39').FieldName('#39'nro_int'#39').AsInteger=0)'
          
            '                  then raiseException(erCustomError,'#39'Debe selecc' +
            'ionar una consulta'#39');'
          
            '              TraerConsultaGrabada(FormAbrirConsulta.getDataSet(' +
            #39'TConsultasGrabadas'#39').FieldName('#39'oid'#39').AsInteger);'
          '              dxDBGridSN1.gotoFirstRecord;'
          
            '              if (FormAbrirConsulta.getDataSet('#39'TInput'#39').FieldNa' +
            'me('#39'ver_novedades'#39').AsBoolean)'
          '                 then begin'
          
            '                         getNovedades(FormAbrirConsulta.getDataS' +
            'et('#39'TInput'#39').FieldName('#39'solo_novedades_primer_dia'#39').AsBoolean);'
          '                         dxDBGridSN1.gotoFirstRecord; '
          '                         end'
          '                 else begin '
          '                         end; '
          '                end;'
          ' '
          'end.')
      end
      item
        ButtonName = 'BotonEjecutarConsulta'
        Source.Strings = (
          'begin'
          '  EjecutarLaConsulta();'
          'end.')
      end
      item
        ButtonName = 'BotonVerifNov'
        Source.Strings = (
          'begin'
          '  getNovedades();'
          'end.')
      end>
    Left = 312
    Top = 323
  end
  inherited SaveArchivo: TSaveDialog
    Left = 784
    Top = 184
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 280
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Top = 288
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
    Left = 520
    Top = 64
    object TInputoid_filtro: TIntegerField
      FieldName = 'oid_filtro'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TInputrota: TStringField
      FieldName = 'rota'
      Size = 50
    end
    object TInputexc_si_tiene_nov: TBooleanField
      FieldName = 'exc_si_tiene_nov'
    end
    object TInputexc_si_tiene_sanc: TBooleanField
      FieldName = 'exc_si_tiene_sanc'
    end
    object TInputjuego: TStringField
      FieldName = 'juego'
      Size = 100
    end
    object TInputdias: TIntegerField
      FieldName = 'dias'
    end
    object TInputgrabar_nombre: TStringField
      FieldName = 'grabar_nombre'
      Size = 100
    end
    object TInputagrupador: TStringField
      FieldName = 'agrupador'
      Size = 500
    end
    object TInputfec_novedad: TDateField
      FieldName = 'fec_novedad'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 552
    Top = 64
  end
  object TFiltros: TsnTable
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
    Left = 72
    Top = 243
    object TFiltrosoid_filtro: TIntegerField
      FieldName = 'oid_filtro'
    end
    object TFiltrosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSFiltros: TDataSource
    DataSet = TFiltros
    Left = 112
    Top = 243
  end
  object ValidadorRora: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    CampoOID = TInputoid_rota
    NroQuery = 0
    Cache = False
    Left = 48
    Top = 323
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
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        AsignarACampo = TInputrota
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
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
    Left = 90
    Top = 332
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 121
  end
  object TConsPlanif: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'nro_legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'oid_rota'
        DataType = ftInteger
      end
      item
        Name = 'rota'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fecha'
        DataType = ftDate
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
    Left = 376
    Top = 353
    object TConsPlanifoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TConsPlanifnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TConsPlanifape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
    object TConsPlanifoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TConsPlanifrota: TStringField
      FieldName = 'rota'
      Size = 50
    end
    object TConsPlaniffecha: TDateField
      FieldName = 'fecha'
    end
    object TConsPlanifjuegos: TStringField
      FieldName = 'juegos'
      Size = 100
    end
    object TConsPlanifcategoria: TStringField
      FieldName = 'categoria'
      Size = 150
    end
    object TConsPlanifnovedad: TMemoField
      FieldName = 'novedad'
      BlobType = ftMemo
    end
    object TConsPlanifsancion: TMemoField
      FieldName = 'sancion'
      BlobType = ftMemo
    end
    object TConsPlanifempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TConsPlanifsector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TConsPlanifnov_dia_1: TStringField
      FieldName = 'nov_dia_1'
    end
    object TConsPlanifnov_dia_2: TStringField
      FieldName = 'nov_dia_2'
    end
    object TConsPlanifnov_dia_3: TStringField
      FieldName = 'nov_dia_3'
    end
    object TConsPlanifnov_dia_4: TStringField
      FieldName = 'nov_dia_4'
    end
    object TConsPlanifnov_dia_5: TStringField
      FieldName = 'nov_dia_5'
    end
    object TConsPlanifnov_dia_6: TStringField
      FieldName = 'nov_dia_6'
    end
    object TConsPlanifnov_dia_7: TStringField
      FieldName = 'nov_dia_7'
    end
    object TConsPlanifagrupador: TStringField
      FieldName = 'agrupador'
      Size = 500
    end
    object TConsPlanifviene_novedad: TIntegerField
      FieldName = 'viene_novedad'
    end
    object TConsPlanifviene_nov_dia_1: TIntegerField
      FieldName = 'viene_nov_dia_1'
    end
    object TConsPlanifviene_nov_dia_2: TIntegerField
      FieldName = 'viene_nov_dia_2'
    end
    object TConsPlanifviene_nov_dia_3: TIntegerField
      FieldName = 'viene_nov_dia_3'
    end
    object TConsPlanifviene_nov_dia_4: TIntegerField
      FieldName = 'viene_nov_dia_4'
    end
    object TConsPlanifviene_nov_dia_5: TIntegerField
      FieldName = 'viene_nov_dia_5'
    end
    object TConsPlanifviene_nov_dia_6: TIntegerField
      FieldName = 'viene_nov_dia_6'
    end
    object TConsPlanifviene_nov_dia_7: TIntegerField
      FieldName = 'viene_nov_dia_7'
    end
    object TConsPlanifempleados_a_venir: TStringField
      FieldName = 'empleados_a_venir'
      Size = 100
    end
    object TConsPlanifid: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'id'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TConsPlanifnro_consulta: TIntegerField
      FieldName = 'nro_consulta'
    end
  end
  object DSConsultaPlanif: TDataSource
    DataSet = TConsPlanif
    Left = 416
    Top = 353
  end
  object TCantidadesTotales: TsnTable
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
    Left = 640
    Top = 313
    object TCantidadesTotalescant_leg_sinnov_sinsanc: TIntegerField
      FieldName = 'cant_leg_sinnov_sinsanc'
    end
    object TCantidadesTotalescant_leg_connov_consanc: TIntegerField
      FieldName = 'cant_leg_connov_consanc'
    end
    object TCantidadesTotalescant_leg_sinnov_consanc: TIntegerField
      FieldName = 'cant_leg_sinnov_consanc'
    end
    object TCantidadesTotalescant_leg_connov_sinsanc: TIntegerField
      FieldName = 'cant_leg_connov_sinsanc'
    end
    object TCantidadesTotalesfecha_hora: TStringField
      FieldName = 'fecha_hora'
      Size = 50
    end
    object TCantidadesTotalescant_leg_connov: TIntegerField
      FieldName = 'cant_leg_connov'
    end
    object TCantidadesTotalescant_leg_sinnov: TIntegerField
      FieldName = 'cant_leg_sinnov'
    end
  end
  object DSCantidadesTotales: TDataSource
    DataSet = TCantidadesTotales
    Left = 672
    Top = 312
  end
  object TDiasColumnas: TsnTable
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
    Top = 308
    object TDiasColumnasnro: TIntegerField
      FieldName = 'nro'
    end
    object TDiasColumnasdia: TStringField
      FieldName = 'dia'
      Size = 50
    end
    object TDiasColumnaslabel1: TStringField
      FieldName = 'label1'
      Size = 50
    end
    object TDiasColumnaslabel2: TStringField
      FieldName = 'label2'
      Size = 50
    end
    object TDiasColumnaslabel3: TStringField
      FieldName = 'label3'
      Size = 50
    end
    object TDiasColumnaslabel4: TStringField
      FieldName = 'label4'
      Size = 50
    end
    object TDiasColumnaslabel5: TStringField
      FieldName = 'label5'
      Size = 50
    end
    object TDiasColumnaslabel6: TStringField
      FieldName = 'label6'
      Size = 50
    end
    object TDiasColumnaslabel7: TStringField
      FieldName = 'label7'
      Size = 50
    end
  end
  object THorizonte: TsnTable
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
    Left = 661
    Top = 465
    object THorizontedias: TIntegerField
      FieldName = 'dias'
    end
    object THorizontedescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSHorizonte: TDataSource
    DataSet = THorizonte
    Left = 693
    Top = 465
  end
  object FormGrabar: TFormulario
    Nombre = 'TFNomGrabConsRot'
    CreateAlwaysANewForm = False
    Left = 285
    Top = 415
  end
  object TEnviar: TsnTable
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
    Left = 341
    Top = 535
    object TEnviaroid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEnviarnovedad: TStringField
      FieldName = 'novedad'
      Size = 100
    end
    object TEnviarnov_dia_1: TStringField
      FieldName = 'nov_dia_1'
      Size = 100
    end
    object TEnviarnov_dia_2: TStringField
      FieldName = 'nov_dia_2'
      Size = 100
    end
    object TEnviarnov_dia_3: TStringField
      FieldName = 'nov_dia_3'
      Size = 100
    end
    object TEnviarnov_dia_4: TStringField
      FieldName = 'nov_dia_4'
      Size = 100
    end
    object TEnviarnov_dia_5: TStringField
      FieldName = 'nov_dia_5'
      Size = 100
    end
    object TEnviarnov_dia_6: TStringField
      FieldName = 'nov_dia_6'
      Size = 100
    end
    object TEnviarnov_dia_7: TStringField
      FieldName = 'nov_dia_7'
      Size = 100
    end
    object TEnviaragrupador: TStringField
      FieldName = 'agrupador'
      Size = 500
    end
    object TEnviarnro_consulta: TIntegerField
      FieldName = 'nro_consulta'
    end
  end
  object FormAbrirConsulta: TFormulario
    Nombre = 'TFSelConsGrabRota'
    CreateAlwaysANewForm = False
    Left = 285
    Top = 456
  end
  object TNovedadesRotas: TsnTable
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
    Left = 725
    Top = 399
    object TNovedadesRotasoid_novedad: TIntegerField
      FieldName = 'oid_novedad'
    end
    object TNovedadesRotasoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TNovedadesRotasnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TNovedadesRotasape_y_nom_legajo: TStringField
      FieldName = 'ape_y_nom_legajo'
      Size = 100
    end
    object TNovedadesRotasempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TNovedadesRotassector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TNovedadesRotascategoria: TStringField
      FieldName = 'categoria'
      Size = 100
    end
    object TNovedadesRotasjuegos: TStringField
      FieldName = 'juegos'
      Size = 100
    end
    object TNovedadesRotasfecha_novedad: TDateField
      FieldName = 'fecha_novedad'
    end
    object TNovedadesRotasanterior: TStringField
      FieldName = 'anterior'
      Size = 100
    end
    object TNovedadesRotasactual: TStringField
      FieldName = 'actual'
      Size = 100
    end
    object TNovedadesRotasviene: TIntegerField
      FieldName = 'viene'
    end
    object TNovedadesRotasagrupador: TStringField
      FieldName = 'agrupador'
      Size = 500
    end
    object TNovedadesRotasnovedad: TStringField
      FieldName = 'novedad'
      Size = 100
    end
  end
  object DSNovedadesRotas: TDataSource
    DataSet = TNovedadesRotas
    Left = 765
    Top = 399
  end
  object TNroConsultaGrabada: TsnTable
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
    Left = 85
    Top = 519
    object TNroConsultaGrabadaoid: TIntegerField
      FieldName = 'oid'
    end
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
    end
  end
end
