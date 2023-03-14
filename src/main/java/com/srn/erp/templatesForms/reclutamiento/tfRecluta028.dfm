inherited FRecluConsEstCandi: TFRecluConsEstCandi
  Left = 65
  Top = 7
  Width = 1131
  Height = 680
  Caption = 'Consulta de Estados de Candidatos'
  Font.Charset = ANSI_CHARSET
  Font.Height = -13
  Font.Name = 'Arial'
  PixelsPerInch = 96
  TextHeight = 16
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1115
    Height = 48
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object BotonVerFoto: TsnButton
      Left = 16
      Top = 8
      Width = 89
      Height = 25
      Caption = 'Ver Foto'
      TabOrder = 0
      Visible = False
      LookAndFeel.Kind = lfOffice11
    end
    object BotonBajarCV: TsnButton
      Left = 16
      Top = 3
      Width = 89
      Height = 42
      Cursor = crHandPoint
      Caption = 'Baja CV'
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
    object DBNavigator1: TDBNavigator
      Left = 688
      Top = 5
      Width = 144
      Height = 37
      DataSource = DSConsulta
      VisibleButtons = [nbPrior, nbNext]
      TabOrder = 2
    end
    object BotonVerPostulante: TsnButton
      Left = 128
      Top = 3
      Width = 225
      Height = 42
      Cursor = crHandPoint
      Caption = 'Ver Datos del Postulante'
      TabOrder = 3
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7A6F
        DD7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F586B7035
        F141DC77FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F786BD241B220
        4E149552FF7FFF7FFF7FFF7FFF7FDE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7F
        FE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFF7FFE7B3767D241B220D224
        701CB75AFF7FFF7FFF7F3A6B6B2D8C318C358C358C358C358C358C358C358C35
        8C358C358C358C358C35AD35AD35AD35AD358C35AD35892D9039F42CD324B120
        C81C504AFF7FFF7F5C6BD331B029F22DD22DD22DD22DD12DD12DD22DD22DD22D
        D22DD12DD12DF22DF3311232D02DD02D123214368D252D29D328D3249020512D
        3236C714D65ADE7B564AD94A7C5F5B5B5B5B5B5B5B5B7C5B7C5B5B5B5B5B5B5B
        5B5B5B5B7C5B5B579542D13190298F29F131174FB74EF428D324701C90319A5F
        1C4F4D21524EBE77B8525A5F5A5F5A5F5B5F9C677B673A5F5B5F9C677B635A5F
        3A5F7B633857323ED3393746BB52BB521642912D734E74390E149131BC639D67
        FB4E6E257352DE7BD8563A5B3B5B5C5F7C63195B5542B331B33176463B5F7C5F
        5C5B5B5B133E584EBF77FF73BF67BF6BDF735E63163E1146F23D7B5F7D635B5F
        FB524D257352BE77B9525B5BBD677B63143E912574219421341DF0143025B74E
        DE6BB74E394AFF7FFF735E573E575E575F57DF6B9F6FB5317A5BDF6F7C639C67
        FB4E4D257352BE77D9529D67195BB12D7121B529D62DB629741D6D29311D5225
        7A5F57465D6FFF7F7F675F5F9F679F6B9F637F63FF7BFD5E2D21CD39EF39395F
        3C574D259352BE77FA5A5B679129711DF52D1636F531D529F139EC3D7325F118
        754A994EDF73DF737F67DF73DF7BDF7BDF77BF6FDF6FDF73503128256B29395B
        5D5B4D217352BE771A5FB752B2251532363A3636D429B852F56230467325D110
        F239B94EBF6B5F577F67FF7BFF7FFF7FDF7BDF77FF77DF77BA563A5B7C639C67
        3C574D217352BD771A5F764A14329742974298425C673B676A3132469529F114
        D035984A7F5F3F53BF6BFF7BFF7FFF7FFF7BFF7FFF7FBF7BFB5A9D6B9E6FBD6F
        3C574D257352BD771A5BF956D22DD846DA4A9E6FFF7F9F6FD035553E9521EF1C
        3242B94E5E5F9F67BF6FDF73DF7BFF7BFF7FFF7FFF7FDF7B13466B318D315B63
        7E5F2D217352BD77D956DE73F8561436DB4A7B73F466D25ED45EB94E92293242
        BC6B3C5F994EFF77BF6FBF6FDF73DF77FF7FFF7FFF7F3D6BF03D6B31AD317B63
        7E634D217352BD77D856BE6BFF775C63324A8C66EB760B7BEC7A2C5AB652FF73
        DF73DE735842BA4EFF7BFF73BF6BDF73FF7FFF7F5E6B3C63BD6FBF6FBE6FBE6F
        7C5F4D257352BD77D9569E6BDF6F7B6B0D774D7F4E7F2D7F0C7BE97E8E665C67
        BE6FBD6FDE73794E7A4A7F6BDF77DF779F6FDB5A3D63FF77FF73DF73FF73DF73
        7E5F4E217352BD77D956DF6FDF6F2D56CD6E927F2E7F2D7F0D7B0C7B676E915A
        FF6FDE6FFF7BB452CA1C4F29913592356F2D6E31EF3DCF39CE39AE35AE357B6B
        9F674E21734EBD77D856FF73586FE0404C5ED57F707F4E7F0D7B0D7BC9766D5A
        BF6BDF73FF77534A8C31CE358D318C31CD35CE398D31AD35AE358D318D317B6B
        BF6B4E25734EBD77D856FF77F26620494D620A5AEE6E917F2D7F0D7BC9768E5E
        DF6FDF77BE73DF77DF77DF77FF77FF77DF73BE6FBE73BE73BE73BE73BE6FFF77
        9E634E25734EBD77D856FF77F3662362C359E044C855937F6F7F2E7FAA6ED45E
        FF73DE73FE73DE73BD73BD73BD73BD73DE73FF77FF77FF77FF77FF77FF77FF77
        9D634E25734EBD77D856FF777B6F4962E876636AA3552B5A2A5E075E095A9C6F
        FF77DE73FF7B524629258C318C3129253246FF7BFE73DE73DE73DE73DE73FF7B
        9E674E21734EBD73D856DF77FF7B156B6966E972C4760062605940516D5EFF7B
        FF77DF77FF7F944EAD35103E103EAD359452FF7FDF77DF77DF77DF77DF77FF7B
        9F674E21734EBD73D85ADE7BFF7BFF7B1767B066CC6EC86E4662AF62DF77FF7B
        DF77DF77DF77DF7BFF7BFF7BFF7BFF7BFF7BDF77DF77DF77DF77DF77DF77FF7F
        9E676E21734EBD73D856DE77FF77FF77FF7BFF7B9D73BF73FF77FF7BFF7BFF77
        FF77FF77FF77FF7BFF7BFF7BFF7BFF7BFF7BFF77FF77FF77FF77FF77FF77FF7F
        BF6B2D21314A9D73B856DF7BFF7BFF7BFF7BFF7BFF7FFF7FFF7FFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7F
        9F672D21D55ADE7B3A63BD77DF7BDF77DF77DF77DF77DF77DF77DF77DF77DF77
        DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DE7B
        D952964EFF7FFF7FDF7B7C6F7B6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F
        7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F5B6B
        195FFF7BFF7FFF7FFF7FFF7FFE7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonVerBusqueda: TsnButton
      Left = 368
      Top = 3
      Width = 225
      Height = 42
      Cursor = crHandPoint
      Caption = 'Ver B'#250'squeda'
      TabOrder = 4
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7A6F
        DD7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F586B7035
        F141DC77FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F786BD241B220
        4E149552FF7FFF7FFF7FFF7FFF7FDE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7F
        FE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFE7FFF7FFE7B3767D241B220D224
        701CB75AFF7FFF7FFF7F3A6B6B2D8C318C358C358C358C358C358C358C358C35
        8C358C358C358C358C35AD35AD35AD35AD358C35AD35892D9039F42CD324B120
        C81C504AFF7FFF7F5C6BD331B029F22DD22DD22DD22DD12DD12DD22DD22DD22D
        D22DD12DD12DF22DF3311232D02DD02D123214368D252D29D328D3249020512D
        3236C714D65ADE7B564AD94A7C5F5B5B5B5B5B5B5B5B7C5B7C5B5B5B5B5B5B5B
        5B5B5B5B7C5B5B579542D13190298F29F131174FB74EF428D324701C90319A5F
        1C4F4D21524EBE77B8525A5F5A5F5A5F5B5F9C677B673A5F5B5F9C677B635A5F
        3A5F7B633857323ED3393746BB52BB521642912D734E74390E149131BC639D67
        FB4E6E257352DE7BD8563A5B3B5B5C5F7C63195B5542B331B33176463B5F7C5F
        5C5B5B5B133E584EBF77FF73BF67BF6BDF735E63163E1146F23D7B5F7D635B5F
        FB524D257352BE77B9525B5BBD677B63143E912574219421341DF0143025B74E
        DE6BB74E394AFF7FFF735E573E575E575F57DF6B9F6FB5317A5BDF6F7C639C67
        FB4E4D257352BE77D9529D67195BB12D7121B529D62DB629741D6D29311D5225
        7A5F57465D6FFF7F7F675F5F9F679F6B9F637F63FF7BFD5E2D21CD39EF39395F
        3C574D259352BE77FA5A5B679129711DF52D1636F531D529F139EC3D7325F118
        754A994EDF73DF737F67DF73DF7BDF7BDF77BF6FDF6FDF73503128256B29395B
        5D5B4D217352BE771A5FB752B2251532363A3636D429B852F56230467325D110
        F239B94EBF6B5F577F67FF7BFF7FFF7FDF7BDF77FF77DF77BA563A5B7C639C67
        3C574D217352BD771A5F764A14329742974298425C673B676A3132469529F114
        D035984A7F5F3F53BF6BFF7BFF7FFF7FFF7BFF7FFF7FBF7BFB5A9D6B9E6FBD6F
        3C574D257352BD771A5BF956D22DD846DA4A9E6FFF7F9F6FD035553E9521EF1C
        3242B94E5E5F9F67BF6FDF73DF7BFF7BFF7FFF7FFF7FDF7B13466B318D315B63
        7E5F2D217352BD77D956DE73F8561436DB4A7B73F466D25ED45EB94E92293242
        BC6B3C5F994EFF77BF6FBF6FDF73DF77FF7FFF7FFF7F3D6BF03D6B31AD317B63
        7E634D217352BD77D856BE6BFF775C63324A8C66EB760B7BEC7A2C5AB652FF73
        DF73DE735842BA4EFF7BFF73BF6BDF73FF7FFF7F5E6B3C63BD6FBF6FBE6FBE6F
        7C5F4D257352BD77D9569E6BDF6F7B6B0D774D7F4E7F2D7F0C7BE97E8E665C67
        BE6FBD6FDE73794E7A4A7F6BDF77DF779F6FDB5A3D63FF77FF73DF73FF73DF73
        7E5F4E217352BD77D956DF6FDF6F2D56CD6E927F2E7F2D7F0D7B0C7B676E915A
        FF6FDE6FFF7BB452CA1C4F29913592356F2D6E31EF3DCF39CE39AE35AE357B6B
        9F674E21734EBD77D856FF73586FE0404C5ED57F707F4E7F0D7B0D7BC9766D5A
        BF6BDF73FF77534A8C31CE358D318C31CD35CE398D31AD35AE358D318D317B6B
        BF6B4E25734EBD77D856FF77F26620494D620A5AEE6E917F2D7F0D7BC9768E5E
        DF6FDF77BE73DF77DF77DF77FF77FF77DF73BE6FBE73BE73BE73BE73BE6FFF77
        9E634E25734EBD77D856FF77F3662362C359E044C855937F6F7F2E7FAA6ED45E
        FF73DE73FE73DE73BD73BD73BD73BD73DE73FF77FF77FF77FF77FF77FF77FF77
        9D634E25734EBD77D856FF777B6F4962E876636AA3552B5A2A5E075E095A9C6F
        FF77DE73FF7B524629258C318C3129253246FF7BFE73DE73DE73DE73DE73FF7B
        9E674E21734EBD73D856DF77FF7B156B6966E972C4760062605940516D5EFF7B
        FF77DF77FF7F944EAD35103E103EAD359452FF7FDF77DF77DF77DF77DF77FF7B
        9F674E21734EBD73D85ADE7BFF7BFF7B1767B066CC6EC86E4662AF62DF77FF7B
        DF77DF77DF77DF7BFF7BFF7BFF7BFF7BFF7BDF77DF77DF77DF77DF77DF77FF7F
        9E676E21734EBD73D856DE77FF77FF77FF7BFF7B9D73BF73FF77FF7BFF7BFF77
        FF77FF77FF77FF7BFF7BFF7BFF7BFF7BFF7BFF77FF77FF77FF77FF77FF77FF7F
        BF6B2D21314A9D73B856DF7BFF7BFF7BFF7BFF7BFF7FFF7FFF7FFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7BFF7F
        9F672D21D55ADE7B3A63BD77DF7BDF77DF77DF77DF77DF77DF77DF77DF77DF77
        DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DE7B
        D952964EFF7FFF7FDF7B7C6F7B6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F
        7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F7C6F5B6B
        195FFF7BFF7FFF7FFF7FFF7FFE7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 601
    Width = 1115
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Label1: TLabel
      Left = 16
      Top = 11
      Width = 118
      Height = 20
      Caption = 'Total coincidencias:'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Arial Narrow'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 272
      Top = 11
      Width = 146
      Height = 20
      Caption = 'Registros Recuperados:'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Arial Narrow'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 584
      Top = 10
      Width = 273
      Height = 20
      Cursor = crHandPoint
      Caption = 'Traer los pr'#243'ximos registros de candidatos ...'
      Font.Charset = ANSI_CHARSET
      Font.Color = clBlue
      Font.Height = -16
      Font.Name = 'Arial Narrow'
      Font.Style = [fsUnderline]
      ParentFont = False
    end
    object snDBEdit1: TsnDBEdit
      Left = 144
      Top = 9
      DataBinding.DataField = 'cant_registros'
      DataBinding.DataSource = DSPreparacion
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Arial Narrow'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 97
    end
    object snDBEdit2: TsnDBEdit
      Left = 424
      Top = 9
      DataBinding.DataField = 'cant_recuperados'
      DataBinding.DataSource = DSPreparacion
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Arial Narrow'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 97
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 48
    Width = 1115
    Height = 553
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 1115
      Height = 553
      Align = alClient
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Arial'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LevelTabs.Slants.Positions = [spLeft, spRight]
      LevelTabs.Style = 3
      LookAndFeel.Kind = lfFlat
      RootLevelOptions.DetailTabsPosition = dtpTop
      AllowInsert = False
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso1'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso1'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso1'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso2'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso2'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso2'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso3'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso3'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso3'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso4'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso4'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso4'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso5'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso5'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso5'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso6'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso6'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso6'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso7'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso7'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso7'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso8'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso8'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso8'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso9'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso9'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso9'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso10'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso10'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso10'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso11'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso11'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso11'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso12'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso12'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso12'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso13'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso13'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso13'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso14'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso14'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso14'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso15'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso15'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso15'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso16'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso16'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso16'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso17'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso17'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso17'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso18'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso18'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso18'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso19'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso19'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso19'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso20'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso20'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'NO APTO'
          TipoCondFiltro2 = tcfIgual
          Color = 10198015
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'proceso20'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'PROGRAMADO'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '1'
          TipoCondFiltro2 = tcfIgual
          Color = 5855743
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '2'
          TipoCondFiltro2 = tcfIgual
          Color = 41984
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '3'
          TipoCondFiltro2 = tcfIgual
          Color = 50372
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '4'
          TipoCondFiltro2 = tcfIgual
          Color = 13421568
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '5'
          TipoCondFiltro2 = tcfIgual
          Color = 10921638
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '6'
          TipoCondFiltro2 = tcfIgual
          Color = 295679
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '7'
          TipoCondFiltro2 = tcfIgual
          Color = 26058
        end
        item
          TipoPintadaCelda = tpcSoloColumnaCampo
          FieldName1 = 'color'
          TipoCondFiltro1 = tcfIgual
          Valor1 = '8'
          TipoCondFiltro2 = tcfIgual
          Color = 16740863
        end>
      object dxDBGridSN1DBCardView1: TcxGridDBCardView
        NavigatorButtons.ConfirmDelete = False
        NavigatorButtons.Insert.Enabled = False
        NavigatorButtons.Insert.Visible = False
        NavigatorButtons.Append.Enabled = False
        NavigatorButtons.Delete.Enabled = False
        NavigatorButtons.Delete.Visible = False
        NavigatorButtons.Edit.Enabled = False
        NavigatorButtons.Edit.Visible = False
        NavigatorButtons.Post.Enabled = False
        NavigatorButtons.Post.Visible = False
        NavigatorButtons.Cancel.Enabled = False
        NavigatorButtons.Cancel.Visible = False
        NavigatorButtons.Refresh.Enabled = False
        NavigatorButtons.Refresh.Visible = False
        NavigatorButtons.Filter.Enabled = False
        NavigatorButtons.Filter.Visible = False
        FilterBox.CustomizeDialog = False
        DataController.DataSource = DSConsulta
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        Filtering.MRUItemsList = False
        Filtering.RowMRUItemsList = False
        LayoutDirection = ldVertical
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.IncSearch = True
        OptionsBehavior.ExpandRowOnDblClick = False
        OptionsCustomize.CardExpanding = True
        OptionsCustomize.LayeredRows = True
        OptionsCustomize.RowFiltering = False
        OptionsCustomize.RowHiding = True
        OptionsCustomize.RowMoving = True
        OptionsData.Deleting = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.HideFocusRectOnExit = False
        OptionsSelection.MultiSelect = True
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.Navigator = True
        OptionsView.NavigatorOffset = 5
        OptionsView.NoDataToDisplayInfoText = 'Sin Datos'
        OptionsView.CardAutoWidth = True
        OptionsView.CardWidth = 680
        OptionsView.CategoryIndent = 10
        OptionsView.CategorySeparatorWidth = 1
        OptionsView.CellAutoHeight = True
        RowLayout = rlVertical
      end
      object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsulta
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.CellSelect = False
        OptionsView.CellAutoHeight = True
        OptionsView.Indicator = True
        Styles.Content = cxStyle2
        Styles.Selection = cxStyle3
        Styles.Header = cxStyle2
        Styles.BandHeader = cxStyle2
        Bands = <
          item
            Caption = 'Candidato'
            FixedKind = fkLeft
            Width = 518
          end
          item
            Caption = 'Procesos'
            Width = 900
          end
          item
            Caption = 'Otros'
            Width = 20
          end>
        object dxDBGridSN1DBBandedTableView1nro_docu: TcxGridDBBandedColumn
          Caption = 'Nro. Docu.'
          DataBinding.FieldName = 'nro_docu'
          HeaderAlignmentHorz = taCenter
          Width = 91
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1ape_y_nom: TcxGridDBBandedColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 137
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column1: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso1'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column2: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso2'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column3: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso3'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column4: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso4'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column5: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso5'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column6: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso6'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column7: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso7'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column8: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso8'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column9: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso9'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column10: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso10'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 9
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column11: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso11'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 10
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column12: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso12'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 11
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column13: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso13'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 12
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column14: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso14'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 13
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column15: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso15'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 14
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column16: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso16'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 15
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column17: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso17'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 16
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column18: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso18'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 17
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column19: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso19'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 18
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column20: TcxGridDBBandedColumn
          DataBinding.FieldName = 'proceso20'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 1
          Position.ColIndex = 19
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column21: TcxGridDBBandedColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'empresa'
          Visible = False
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 0
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column22: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'sector'
          Visible = False
          GroupIndex = 1
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 0
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column23: TcxGridDBBandedColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto'
          HeaderAlignmentHorz = taCenter
          Width = 159
          Position.BandIndex = 0
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column24: TcxGridDBBandedColumn
          Caption = 'color'
          DataBinding.FieldName = 'activo'
          Visible = False
          Position.BandIndex = 0
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column25: TcxGridDBBandedColumn
          Caption = 'Estado'
          DataBinding.FieldName = 'oid_est_cand_busq'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSEstCandidatoBusq
          HeaderAlignmentHorz = taCenter
          Width = 77
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN1DBBandedTableView1Column26: TcxGridDBBandedColumn
          DataBinding.FieldName = 'color'
          Width = 20
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
          IsCaptionAssigned = True
        end
      end
      object dxDBGridSN1DBCardView2: TcxGridDBCardView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsulta
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        object dxDBGridSN1DBCardView2Row1: TcxGridDBCardViewRow
          Position.BeginsLayer = True
        end
      end
      object dxDBGridSN1DBCardView3: TcxGridDBCardView
        NavigatorButtons.ConfirmDelete = False
        NavigatorButtons.First.Visible = False
        NavigatorButtons.PriorPage.Visible = False
        NavigatorButtons.Next.Visible = True
        NavigatorButtons.NextPage.Visible = False
        NavigatorButtons.Last.Visible = False
        NavigatorButtons.Insert.Visible = False
        NavigatorButtons.Delete.Visible = False
        NavigatorButtons.Edit.Visible = False
        NavigatorButtons.Post.Visible = False
        NavigatorButtons.Cancel.Visible = False
        NavigatorButtons.Refresh.Visible = False
        NavigatorButtons.SaveBookmark.Visible = False
        NavigatorButtons.GotoBookmark.Visible = False
        NavigatorButtons.Filter.Visible = False
        DataController.DataSource = DSConsulta
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        LayoutDirection = ldVertical
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Inserting = False
        OptionsView.Navigator = True
        OptionsView.CardAutoWidth = True
        OptionsView.CardWidth = 800
        OptionsView.CellAutoHeight = True
        RowLayout = rlVertical
        object dxDBGridSN1DBCardView3Row33: TcxGridDBCardViewRow
          Caption = 'Datos'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = True
          Position.Width = 300
        end
        object dxDBGridSN1DBCardView3Row6: TcxGridDBCardViewRow
          Caption = 'Estado'
          DataBinding.FieldName = 'estado_postulante'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row3: TcxGridDBCardViewRow
          Caption = 'Ape. y Nom.'
          DataBinding.FieldName = 'ape_y_nom'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row4: TcxGridDBCardViewRow
          Caption = 'Tipo Docu.'
          DataBinding.FieldName = 'tipo_documento'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row2: TcxGridDBCardViewRow
          Caption = 'Nro. Documento'
          DataBinding.FieldName = 'nro_docu'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row7: TcxGridDBCardViewRow
          Caption = 'Fec. Nac.'
          DataBinding.FieldName = 'fec_nacimiento'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row5: TcxGridDBCardViewRow
          Caption = 'Referido'
          DataBinding.FieldName = 'referido'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row21: TcxGridDBCardViewRow
          DataBinding.FieldName = 'bajar_cv'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row9: TcxGridDBCardViewRow
          Caption = 'Fuente'
          DataBinding.FieldName = 'fuente'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row1: TcxGridDBCardViewRow
          DataBinding.FieldName = 'foto'
          PropertiesClassName = 'TcxImageProperties'
          Properties.GraphicClassName = 'TJPEGImage'
          Properties.Stretch = True
          Options.ShowCaption = False
          Position.BeginsLayer = False
          Position.LineCount = 9
          Position.Width = 200
        end
        object dxDBGridSN1DBCardView3Row8: TcxGridDBCardViewRow
          Caption = 'Domicilio / Datos de Contacto'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = True
          Position.Width = 300
        end
        object dxDBGridSN1DBCardView3Row10: TcxGridDBCardViewRow
          DataBinding.FieldName = 'direccion'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row11: TcxGridDBCardViewRow
          DataBinding.FieldName = 'localidad'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row12: TcxGridDBCardViewRow
          DataBinding.FieldName = 'codigo_postal'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row13: TcxGridDBCardViewRow
          DataBinding.FieldName = 'telefono_fijo'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row14: TcxGridDBCardViewRow
          DataBinding.FieldName = 'telefono_celular'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row15: TcxGridDBCardViewRow
          Caption = 'Competencias'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row16: TcxGridDBCardViewRow
          DataBinding.FieldName = 'competencias'
          PropertiesClassName = 'TcxMemoProperties'
          Properties.ScrollBars = ssVertical
          Options.ShowCaption = False
          Position.BeginsLayer = False
          Position.LineCount = 2
        end
        object dxDBGridSN1DBCardView3Row17: TcxGridDBCardViewRow
          Caption = 'Postulaciones que Aplica'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row18: TcxGridDBCardViewRow
          DataBinding.FieldName = 'postu_aplica'
          PropertiesClassName = 'TcxMemoProperties'
          Properties.ScrollBars = ssVertical
          Options.ShowCaption = False
          Position.BeginsLayer = False
          Position.LineCount = 3
        end
        object dxDBGridSN1DBCardView3Row19: TcxGridDBCardViewRow
          Caption = 'Anotaciones'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row20: TcxGridDBCardViewRow
          DataBinding.FieldName = 'anotaciones'
          PropertiesClassName = 'TcxMemoProperties'
          Properties.ScrollBars = ssVertical
          Options.ShowCaption = False
          Position.BeginsLayer = False
          Position.LineCount = 2
        end
        object dxDBGridSN1DBCardView3Row22: TcxGridDBCardViewRow
          Caption = 'B'#250'squeda Candidato'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = True
          Position.Width = 300
          Styles.Content = cxStyle4
        end
        object dxDBGridSN1DBCardView3Row37: TcxGridDBCardViewRow
          Caption = 'Est.Cand.Busq.'
          DataBinding.FieldName = 'estado_cand_busq'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row23: TcxGridDBCardViewRow
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto_busq'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row34: TcxGridDBCardViewRow
          Caption = 'Aprobada:'
          DataBinding.FieldName = 'aprob_busqueda'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row28: TcxGridDBCardViewRow
          Caption = 'Inicio Busq.'
          DataBinding.FieldName = 'inicio_busq'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row24: TcxGridDBCardViewRow
          DataBinding.FieldName = 'empresa_sector_busq'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row25: TcxGridDBCardViewRow
          Caption = 'Motivo'
          DataBinding.FieldName = 'motivo_busqueda'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row27: TcxGridDBCardViewRow
          Caption = 'Selector'
          DataBinding.FieldName = 'selector'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row29: TcxGridDBCardViewRow
          Caption = 'Convenio'
          DataBinding.FieldName = 'convenio'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row30: TcxGridDBCardViewRow
          Caption = 'Sueldo Bruto'
          DataBinding.FieldName = 'sueldo_bruto'
          PropertiesClassName = 'TcxTextEditProperties'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row31: TcxGridDBCardViewRow
          Caption = 'Contrato'
          DataBinding.FieldName = 'contrato'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row32: TcxGridDBCardViewRow
          Caption = 'Vancantes'
          DataBinding.FieldName = 'vancantes'
          PropertiesClassName = 'TcxTextEditProperties'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView3Row26: TcxGridDBCardViewRow
          Caption = 'Obs.'
          DataBinding.FieldName = 'obs_busqueda'
          PropertiesClassName = 'TcxMemoProperties'
          Properties.ScrollBars = ssVertical
          Position.BeginsLayer = False
          Position.LineCount = 4
        end
        object dxDBGridSN1DBCardView3Row35: TcxGridDBCardViewRow
          Caption = 'Procesos'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = True
        end
        object dxDBGridSN1DBCardView3Row36: TcxGridDBCardViewRow
          DataBinding.FieldName = 'procesos'
          PropertiesClassName = 'TcxMemoProperties'
          Properties.ScrollBars = ssVertical
          Options.ShowCaption = False
          Position.BeginsLayer = False
          Position.LineCount = 15
          Position.Width = 300
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        Caption = 'Vista Resumida'
        GridView = dxDBGridSN1DBBandedTableView1
      end
      object dxDBGridSN1Level3: TcxGridLevel
        Caption = 'Vista Detallada'
        GridView = dxDBGridSN1DBCardView3
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TPreparacion
        TableName = 'TPreparacion'
      end
      item
        DataSet = TResulttadoBusq
        TableName = 'TResulttadoBusq'
      end
      item
        DataSet = TConsulta
        TableName = 'TConsulta'
      end
      item
        DataSet = TVisuColProc
        TableName = 'TVisuColProc'
      end>
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
    OnDblClick = <
      item
        CompoName = 'dxDBGridSN1'
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'TInputCompetencias'
      end
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'TCompetenciasPostulantes'
      end
      item
        VariableName = 'TCandidatosEnEstado'
      end
      item
        VariableName = 'TPostulacionesAplica'
      end
      item
        VariableName = 'TProcesosEnEstado'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TConsulta.Close;'
          '  TConsulta.Open;'
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          
            '  TInputCompetencias.loadFromAllData(getParamValue('#39'TInputCompet' +
            'encias'#39'));'
          ''
          
            '  TCompetenciasPostulantes.loadFromAllData(getParamValue('#39'TCompe' +
            'tenciasPostulantes'#39'));'
          
            '  TCandidatosEnEstado.loadFromAllData(getParamValue('#39'TCandidatos' +
            'EnEstado'#39'));'
          
            '  TPostulacionesAplica.loadFromAllData(getParamValue('#39'TPostulaci' +
            'onesAplica'#39'));'
          
            '  TProcesosEnEstado.loadFromAllData(getParamValue('#39'TProcesosEnEs' +
            'tado'#39'));'
          ''
          ''
          '  TraerResultadosBusquedas();'
          '   dxDBGridSN1.ActivarEventoPintarCeldas();'
          '  TEstCandidatoBusq.loadFromHelp('#39'HelpEstCandidatoBusq'#39');'
          '   InicializarBotones();'
          ''
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          ''
          ''
          ''
          'procedure TraerFotoPostulante();'
          'var'
          '  mensajeError : string;'
          '  nomTempFile  : string;'
          'begin   '
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownloadFotoPostulante'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TConsulta.FieldName('#39'oid' +
            '_postulante'#39').AsString, mensajeError);'
          '  TConsulta.cargarImagen('#39'foto'#39',nomTempFile);'
          '  TConsulta.EditRecord;'
          '  TConsulta.FieldName('#39'trajo_foto'#39').Value := true;'
          '  TConsulta.PostRecord; '
          'end;'
          ''
          'procedure TraerMasRegistros();'
          'begin'
          '  TConsulta.marcarRegistro();'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluCandiEnProceso'#39');'
          '  operacion.addAtribute('#39'EJECUTAR_CONSULTA'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'NRO_LOTE'#39', IntToStr(TPreparacion.FieldN' +
            'ame('#39'nro_lote'#39').AsInteger));'
          
            '  operacion.AddAtribute('#39'NRO_DESDE'#39', IntToStr(TPreparacion.Field' +
            'Name('#39'utl_nro_registro'#39').AsInteger+1));'
          
            '  operacion.AddAtribute('#39'NRO_HASTA'#39', IntToStr(TPreparacion.Field' +
            'Name('#39'utl_nro_registro'#39').AsInteger+TPreparacion.FieldName('#39'prox_' +
            'cant_registros'#39').AsInteger));'
          
            '  operacion.AddAtribute('#39'CANT_REGISTROS'#39', IntToStr(TPreparacion.' +
            'FieldName('#39'cant_registros'#39').AsInteger));'
          
            '  operacion.AddAtribute('#39'PROX_CANT_REGISTROS'#39', IntToStr(TPrepara' +
            'cion.FieldName('#39'prox_cant_registros'#39').AsInteger));'
          '  operacion.execute();  '
          '  TConsulta.AppendRecords(TResulttadoBusq.getDataSet());'
          ''
          '  TResulttadoBusq.first;'
          '  while (not TResulttadoBusq.eof) do'
          '  begin'
          ''
          
            '    if (TConsulta.locate('#39'oid_candidato_busq'#39', TResulttadoBusq.F' +
            'ieldName('#39'oid_candidato_busq'#39').AsInteger,[]))'
          '        then begin'
          
            '                 if (TConsulta.FieldName('#39'trajo_foto'#39').AsBoolean' +
            '=false)'
          '                       then TraerFotoPostulante();'
          '                end;'
          ''
          '    TResulttadoBusq.next;'
          ''
          '  end;'
          ''
          ''
          '  TConsulta.gotoToRegistroMarcado();'
          ''
          
            '  if (TPreparacion.FieldName('#39'cant_registros'#39').AsInteger =  TPre' +
            'paracion.FieldName('#39'cant_recuperados'#39').AsInteger)'
          
            '     then mensaje.information('#39'Se recuperaron todos los registro' +
            's.'#39');'
          ''
          '  dxDBGridSN1.refresh();'
          ''
          'end;'
          ''
          'procedure TraerResultadosBusquedas();'
          'var'
          '  i : integer;'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluCandiEnProceso'#39');'
          '  operacion.addAtribute('#39'PREPARAR_CONSULTA'#39','#39#39');'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.AddDataSet(TInputCompetencias.getDataSet());'
          '  operacion.AddDataSet(TCompetenciasPostulantes.getDataSet());'
          '  operacion.AddDataSet(TCandidatosEnEstado.getDataSet());'
          '  operacion.AddDataSet(TPostulacionesAplica.getDataSet());'
          '  operacion.AddDataSet(TProcesosEnEstado.getDataSet());'
          '  operacion.execute();  '
          ''
          '  traerMasRegistros();'
          ''
          '  for i:=1 to 20 do'
          '    begin'
          
            '    dxDBGridSN1.setColumnaVisible('#39'proceso'#39'+IntToStr(i),TVisuCol' +
            'Proc.FieldName('#39'proceso'#39'+IntToStr(i)).AsBoolean);'
          
            '    dxDBGridSN1.setCaptionColumn('#39'proceso'#39'+IntToStr(i),TVisuColP' +
            'roc.FieldName('#39'desc_proceso'#39'+IntToStr(i)).AsString);'
          '    end;'
          ''
          'end;'
          ''
          'procedure BajaCV();'
          'var'
          '  nomTempFile : string;'
          '  mensajeError : string;'
          'begin'
          ''
          '  if (TConsulta.FieldName('#39'oid_cv'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'El postulante no tiene C' +
            'V'#39');'
          ''
          '  mensajeError := '#39#39';'
          
            '  SaveAdjunto.setFileName(TConsulta.FieldName('#39'nombre_archivo_cv' +
            #39').AsString);'
          
            '  SaveAdjunto.setDefaultExt(Varios.getFileExtension(TConsulta.Fi' +
            'eldName('#39'nombre_archivo_cv'#39').AsString));'
          '  if (SaveAdjunto.show())'
          '     then begin'
          ''
          '               operacion.InicioOperacion();'
          '               operacion.setOper('#39'DownloadCVPostulante'#39');'
          
            '               nomTempFile := operacion.DownLoadFile(TConsulta.F' +
            'ieldName('#39'oid_cv'#39').AsString, mensajeError);                     ' +
            '             '
          
            '               nomTempFile := varios.renombrarArchivo(nomTempFil' +
            'e, SaveAdjunto.getFileName());                        '
          ''
          '               if (varios.abrirArchivo(nomTempFile)=false)'
          
            '                  then mensaje.information('#39'No se encontr'#243' aplic' +
            'aci'#243'n asociada al archivo que se desea abrir'#39');                 ' +
            '       '
          ''
          '               end;'
          'end;'
          ''
          ''
          'procedure consultaPostulante();'
          'begin'
          ''
          '  if (TConsulta.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'No se encuentra seleccio' +
            'nado un postulante'#39');'
          ''
          '  TConsulta.marcarRegistro;'
          '  '
          '  formPostulante.ventana := getVentana();'
          '  formPostulante.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '  formPostulante.setString('#39'oid_cco'#39',IntToStr(TConsulta.FieldNam' +
            'e('#39'oid_postulante'#39').AsInteger));'
          '  formPostulante.Mostrar(false);'
          ''
          '  TConsulta.gotoToRegistroMarcado;'
          ''
          'end;'
          ''
          'procedure consultaBusqueda();'
          'begin'
          ''
          '  if (TConsulta.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'No se encuentra seleccio' +
            'nada una B'#250'squeda'#39');'
          ''
          '  TConsulta.marcarRegistro;'
          ''
          ' TInput.Close;'
          ' TInput.Open;'
          ' TInput.AppendRecord;'
          
            ' TInput.FieldName('#39'oid_busqueda_act'#39').AsInteger :=  TConsulta.Fi' +
            'eldName('#39'oid_busqueda_act'#39').AsInteger;'
          ' TInput.PostRecord;'
          ' '
          ''
          '  TInputCompetencias.Close;'
          '  TInputCompetencias.Open;'
          ''
          '  TCompetenciasPostulantes.close;'
          '  TCompetenciasPostulantes.open;'
          ''
          '  TCandidatosEnEstado.close;'
          '  TCandidatosEnEstado.open;'
          ''
          '  TPostulacionesAplica.close;'
          '  TPostulacionesAplica.open;'
          ''
          '  TProcesosEnEstado.close;'
          '  TProcesosEnEstado.open;'
          ''
          '  variable.newVariantArray('#39'parametros'#39',6);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TInputCompetencia' +
            's'#39','#39'TInputCompetencias'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',2,'#39'TCompetenciasPost' +
            'ulantes'#39','#39'TCompetenciasPostulantes'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',3,'#39'TCandidatosEnEsta' +
            'do'#39','#39'TCandidatosEnEstado'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',4,'#39'TPostulacionesApl' +
            'ica'#39','#39'TPostulacionesAplica'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',5,'#39'TProcesosEnEstado' +
            #39','#39'TProcesosEnEstado'#39');  '
          ''
          '   FormBusqueda.params :=  variable.getValue('#39'parametros'#39');  '
          '   FormBusqueda.ventana := getVentana();'
          '   FormBusqueda.Mostrar(false);'
          ''
          '  TConsulta.gotoToRegistroMarcado;'
          ''
          ''
          'end;'
          ''
          ''
          'procedure InicializarBotones();'
          'begin'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000018,'#39#39',false))'
          '     then BotonBajarCV.setVisible(true)'
          '     else BotonBajarCV.setVisible(false);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000019,'#39#39',false))'
          '     then BotonVerPostulante.setVisible(true)'
          '     else BotonVerPostulante.setVisible(false);'
          ''
          '  if (varios.isFuncionSeguridadHabilitada(1000020,'#39#39',false))'
          '     then BotonVerBusqueda.setVisible(true)'
          '     else BotonVerBusqueda.setVisible(false);'
          ''
          ''
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'Label3'
        Source.Strings = (
          'begin'
          '  TraerMasRegistros();'
          'end.')
      end
      item
        ButtonName = 'BotonVerFoto'
        Source.Strings = (
          'begin'
          '   TraerFotoPostulante();'
          'end.')
      end
      item
        ButtonName = 'BotonBajarCV'
        Source.Strings = (
          'begin'
          '  BajaCV();'
          'end.')
      end
      item
        ButtonName = 'BotonVerPostulante'
        Source.Strings = (
          'begin'
          '  consultaPostulante();'
          'end.')
      end
      item
        ButtonName = 'BotonVerBusqueda'
        Source.Strings = (
          'begin'
          '   consultaBusqueda();'
          'end.')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 384
    Top = 208
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TInputCompetencias: TsnTable
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
    Left = 816
    Top = 54
    object TInputCompetenciasoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TInputCompetenciasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
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
    Left = 776
    Top = 54
    object TInputbuscar: TStringField
      FieldName = 'buscar'
      Size = 100
    end
    object TInputoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TInputoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TInputoid_selector: TIntegerField
      FieldName = 'oid_selector'
    end
    object TInputoid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TInputabiertas: TBooleanField
      FieldName = 'abiertas'
    end
    object TInputcerradas: TBooleanField
      FieldName = 'cerradas'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputcodigo_sexo: TStringField
      FieldName = 'codigo_sexo'
      Size = 10
    end
    object TInputoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TInputoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TInputes_referido: TStringField
      FieldName = 'es_referido'
      Size = 2
    end
    object TInputgenero_postulante: TStringField
      FieldName = 'genero_postulante'
    end
    object TInputoid_estado_postulante: TIntegerField
      FieldName = 'oid_estado_postulante'
    end
  end
  object TResulttadoBusq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_candidato_busq'
        DataType = ftInteger
      end
      item
        Name = 'oid_busqueda_act'
        DataType = ftInteger
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'nro_docu'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_est_cand_busq'
        DataType = ftInteger
      end
      item
        Name = 'estado_cand_busq'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'comentario'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'oid_mot_est_cand'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'proceso20'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso19'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso18'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso17'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso16'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso15'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso14'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso13'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso12'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso11'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso10'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso9'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso8'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso7'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso6'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso5'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso4'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso3'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso2'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso1'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'empresa'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'sector'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'puesto'
        DataType = ftString
        Size = 200
      end
      item
        Name = 'color'
        DataType = ftInteger
      end
      item
        Name = 'foto'
        DataType = ftGraphic
      end
      item
        Name = 'tipo_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'referido'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'estado_postulante'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_nacimiento'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fuente'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'direccion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'localidad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'codigo_postal'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'telefono_fijo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'telefono_celular'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'bajar_cv'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'oid_cv'
        DataType = ftInteger
      end
      item
        Name = 'nombre_archivo_cv'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'competencias'
        DataType = ftMemo
      end
      item
        Name = 'anotaciones'
        DataType = ftMemo
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
    Left = 104
    Top = 305
    object TResulttadoBusqoid_candidato_busq: TIntegerField
      FieldName = 'oid_candidato_busq'
    end
    object TResulttadoBusqoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TResulttadoBusqoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TResulttadoBusqnro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 30
    end
    object TResulttadoBusqape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TResulttadoBusqoid_est_cand_busq: TIntegerField
      FieldName = 'oid_est_cand_busq'
    end
    object TResulttadoBusqestado_cand_busq: TStringField
      FieldName = 'estado_cand_busq'
      Size = 100
    end
    object TResulttadoBusqcomentario: TStringField
      FieldName = 'comentario'
      Size = 4000
    end
    object TResulttadoBusqoid_mot_est_cand: TIntegerField
      FieldName = 'oid_mot_est_cand'
    end
    object TResulttadoBusqactivo: TBooleanField
      FieldName = 'activo'
    end
    object TResulttadoBusqproceso20: TStringField
      FieldName = 'proceso20'
      Size = 255
    end
    object TResulttadoBusqproceso19: TStringField
      FieldName = 'proceso19'
      Size = 255
    end
    object TResulttadoBusqproceso18: TStringField
      FieldName = 'proceso18'
      Size = 255
    end
    object TResulttadoBusqproceso17: TStringField
      FieldName = 'proceso17'
      Size = 255
    end
    object TResulttadoBusqproceso16: TStringField
      FieldName = 'proceso16'
      Size = 255
    end
    object TResulttadoBusqproceso15: TStringField
      FieldName = 'proceso15'
      Size = 255
    end
    object TResulttadoBusqproceso14: TStringField
      FieldName = 'proceso14'
      Size = 255
    end
    object TResulttadoBusqproceso13: TStringField
      FieldName = 'proceso13'
      Size = 255
    end
    object TResulttadoBusqproceso12: TStringField
      FieldName = 'proceso12'
      Size = 255
    end
    object TResulttadoBusqproceso11: TStringField
      FieldName = 'proceso11'
      Size = 255
    end
    object TResulttadoBusqproceso10: TStringField
      FieldName = 'proceso10'
      Size = 255
    end
    object TResulttadoBusqproceso9: TStringField
      FieldName = 'proceso9'
      Size = 255
    end
    object TResulttadoBusqproceso8: TStringField
      FieldName = 'proceso8'
      Size = 255
    end
    object TResulttadoBusqproceso7: TStringField
      FieldName = 'proceso7'
      Size = 255
    end
    object TResulttadoBusqproceso6: TStringField
      FieldName = 'proceso6'
      Size = 255
    end
    object TResulttadoBusqproceso5: TStringField
      FieldName = 'proceso5'
      Size = 255
    end
    object TResulttadoBusqproceso4: TStringField
      FieldName = 'proceso4'
      Size = 255
    end
    object TResulttadoBusqproceso3: TStringField
      FieldName = 'proceso3'
      Size = 255
    end
    object TResulttadoBusqproceso2: TStringField
      FieldName = 'proceso2'
      Size = 255
    end
    object TResulttadoBusqproceso1: TStringField
      FieldName = 'proceso1'
      Size = 255
    end
    object TResulttadoBusqempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TResulttadoBusqsector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TResulttadoBusqpuesto: TStringField
      FieldName = 'puesto'
      Size = 200
    end
    object TResulttadoBusqcolor: TIntegerField
      FieldName = 'color'
    end
    object TResulttadoBusqfoto: TGraphicField
      FieldName = 'foto'
      BlobType = ftGraphic
    end
    object TResulttadoBusqtipo_documento: TStringField
      FieldName = 'tipo_documento'
      Size = 50
    end
    object TResulttadoBusqreferido: TStringField
      FieldName = 'referido'
      Size = 100
    end
    object TResulttadoBusqestado_postulante: TStringField
      FieldName = 'estado_postulante'
      Size = 100
    end
    object TResulttadoBusqfec_nacimiento: TStringField
      FieldName = 'fec_nacimiento'
      Size = 100
    end
    object TResulttadoBusqfuente: TStringField
      FieldName = 'fuente'
      Size = 100
    end
    object TResulttadoBusqdireccion: TStringField
      FieldName = 'direccion'
      Size = 100
    end
    object TResulttadoBusqlocalidad: TStringField
      FieldName = 'localidad'
      Size = 100
    end
    object TResulttadoBusqcodigo_postal: TStringField
      FieldName = 'codigo_postal'
      Size = 100
    end
    object TResulttadoBusqtelefono_fijo: TStringField
      FieldName = 'telefono_fijo'
      Size = 100
    end
    object TResulttadoBusqtelefono_celular: TStringField
      FieldName = 'telefono_celular'
      Size = 100
    end
    object TResulttadoBusqbajar_cv: TStringField
      FieldName = 'bajar_cv'
    end
    object TResulttadoBusqoid_cv: TIntegerField
      FieldName = 'oid_cv'
    end
    object TResulttadoBusqnombre_archivo_cv: TStringField
      FieldName = 'nombre_archivo_cv'
      Size = 100
    end
    object TResulttadoBusqcompetencias: TMemoField
      FieldName = 'competencias'
      BlobType = ftMemo
    end
    object TResulttadoBusqanotaciones: TMemoField
      FieldName = 'anotaciones'
      BlobType = ftMemo
    end
    object TResulttadoBusqpostu_aplica: TMemoField
      FieldName = 'postu_aplica'
      BlobType = ftMemo
    end
    object TResulttadoBusqempresa_busq: TStringField
      FieldName = 'empresa_busq'
      Size = 100
    end
    object TResulttadoBusqmotivo_busqueda: TStringField
      FieldName = 'motivo_busqueda'
      Size = 100
    end
    object TResulttadoBusqaprob_busqueda: TStringField
      FieldName = 'aprob_busqueda'
      Size = 100
    end
    object TResulttadoBusqobs_busqueda: TMemoField
      FieldName = 'obs_busqueda'
      BlobType = ftMemo
    end
    object TResulttadoBusqselector: TStringField
      FieldName = 'selector'
      Size = 100
    end
    object TResulttadoBusqestado_busqueda: TStringField
      FieldName = 'estado_busqueda'
      Size = 100
    end
    object TResulttadoBusqmotivo_est_busqueda: TStringField
      FieldName = 'motivo_est_busqueda'
      Size = 100
    end
    object TResulttadoBusqfec_cierre: TStringField
      FieldName = 'fec_cierre'
      Size = 100
    end
    object TResulttadoBusqinicio_busq: TStringField
      FieldName = 'inicio_busq'
      Size = 100
    end
    object TResulttadoBusqconvenio: TStringField
      FieldName = 'convenio'
      Size = 100
    end
    object TResulttadoBusqsueldo_bruto: TFloatField
      FieldName = 'sueldo_bruto'
    end
    object TResulttadoBusqvancantes: TIntegerField
      FieldName = 'vancantes'
    end
    object TResulttadoBusqcontrato: TStringField
      FieldName = 'contrato'
      Size = 100
    end
    object TResulttadoBusqfec_aprobo_busq: TStringField
      FieldName = 'fec_aprobo_busq'
      Size = 100
    end
    object TResulttadoBusqsector_busq: TStringField
      FieldName = 'sector_busq'
      Size = 100
    end
    object TResulttadoBusqpuesto_busq: TStringField
      FieldName = 'puesto_busq'
      Size = 100
    end
    object TResulttadoBusqempresa_sector_busq: TStringField
      FieldName = 'empresa_sector_busq'
      Size = 100
    end
    object TResulttadoBusqprocesos: TMemoField
      FieldName = 'procesos'
      BlobType = ftMemo
    end
  end
  object TPreparacion: TsnTable
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
    Top = 257
    object TPreparacionnro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
    object TPreparacioncant_registros: TIntegerField
      FieldName = 'cant_registros'
    end
    object TPreparacionutl_nro_registro: TIntegerField
      FieldName = 'utl_nro_registro'
    end
    object TPreparacionprox_cant_registros: TIntegerField
      FieldName = 'prox_cant_registros'
    end
    object TPreparacioncant_recuperados: TIntegerField
      FieldName = 'cant_recuperados'
    end
  end
  object DSPreparacion: TDataSource
    DataSet = TPreparacion
    Left = 136
    Top = 257
  end
  object dsResultadoBusq: TDataSource
    DataSet = TResulttadoBusq
    Left = 136
    Top = 305
  end
  object TConsulta: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_candidato_busq'
        DataType = ftInteger
      end
      item
        Name = 'oid_busqueda_act'
        DataType = ftInteger
      end
      item
        Name = 'oid_postulante'
        DataType = ftInteger
      end
      item
        Name = 'nro_docu'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_est_cand_busq'
        DataType = ftInteger
      end
      item
        Name = 'estado_cand_busq'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'comentario'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'oid_mot_est_cand'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'proceso1'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso2'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso3'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso4'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso5'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso6'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso7'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso8'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso9'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso10'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso11'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso12'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso13'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso14'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso15'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso16'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso17'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso18'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso19'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'proceso20'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'empresa'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'sector'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'puesto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'color'
        DataType = ftInteger
      end
      item
        Name = 'foto'
        DataType = ftGraphic
      end
      item
        Name = 'tipo_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'referido'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'estado_postulante'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_nacimiento'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fuente'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'direccion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'localidad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'codigo_postal'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'telefono_fijo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'telefono_celular'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'bajar_cv'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'oid_cv'
        DataType = ftInteger
      end
      item
        Name = 'competencias'
        DataType = ftMemo
      end
      item
        Name = 'anotaciones'
        DataType = ftMemo
      end
      item
        Name = 'postu_aplica'
        DataType = ftMemo
      end
      item
        Name = 'nombre_archivo_cv'
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
    Left = 104
    Top = 352
    object TConsultaoid_candidato_busq: TIntegerField
      FieldName = 'oid_candidato_busq'
    end
    object TConsultaoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TConsultaoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TConsultanro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 30
    end
    object TConsultaape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TConsultaoid_est_cand_busq: TIntegerField
      FieldName = 'oid_est_cand_busq'
    end
    object TConsultaestado_cand_busq: TStringField
      FieldName = 'estado_cand_busq'
      Size = 100
    end
    object TConsultacomentario: TStringField
      FieldName = 'comentario'
      Size = 4000
    end
    object TConsultaoid_mot_est_cand: TIntegerField
      FieldName = 'oid_mot_est_cand'
    end
    object TConsultaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TConsultaproceso1: TStringField
      FieldName = 'proceso1'
      Size = 255
    end
    object TConsultaproceso2: TStringField
      FieldName = 'proceso2'
      Size = 255
    end
    object TConsultaproceso3: TStringField
      FieldName = 'proceso3'
      Size = 255
    end
    object TConsultaproceso4: TStringField
      FieldName = 'proceso4'
      Size = 255
    end
    object TConsultaproceso5: TStringField
      FieldName = 'proceso5'
      Size = 255
    end
    object TConsultaproceso6: TStringField
      FieldName = 'proceso6'
      Size = 255
    end
    object TConsultaproceso7: TStringField
      FieldName = 'proceso7'
      Size = 255
    end
    object TConsultaproceso8: TStringField
      FieldName = 'proceso8'
      Size = 255
    end
    object TConsultaproceso9: TStringField
      FieldName = 'proceso9'
      Size = 255
    end
    object TConsultaproceso10: TStringField
      FieldName = 'proceso10'
      Size = 255
    end
    object TConsultaproceso11: TStringField
      FieldName = 'proceso11'
      Size = 255
    end
    object TConsultaproceso12: TStringField
      FieldName = 'proceso12'
      Size = 255
    end
    object TConsultaproceso13: TStringField
      FieldName = 'proceso13'
      Size = 255
    end
    object TConsultaproceso14: TStringField
      FieldName = 'proceso14'
      Size = 255
    end
    object TConsultaproceso15: TStringField
      FieldName = 'proceso15'
      Size = 255
    end
    object TConsultaproceso16: TStringField
      FieldName = 'proceso16'
      Size = 255
    end
    object TConsultaproceso17: TStringField
      FieldName = 'proceso17'
      Size = 255
    end
    object TConsultaproceso18: TStringField
      FieldName = 'proceso18'
      Size = 255
    end
    object TConsultaproceso19: TStringField
      FieldName = 'proceso19'
      Size = 255
    end
    object TConsultaproceso20: TStringField
      FieldName = 'proceso20'
      Size = 255
    end
    object TConsultaempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TConsultasector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TConsultapuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
    object TConsultacolor: TIntegerField
      FieldName = 'color'
    end
    object TConsultafoto: TGraphicField
      FieldName = 'foto'
      BlobType = ftGraphic
    end
    object TConsultatipo_documento: TStringField
      FieldName = 'tipo_documento'
      Size = 50
    end
    object TConsultareferido: TStringField
      FieldName = 'referido'
      Size = 100
    end
    object TConsultaestado_postulante: TStringField
      FieldName = 'estado_postulante'
      Size = 100
    end
    object TConsultafec_nacimiento: TStringField
      FieldName = 'fec_nacimiento'
      Size = 100
    end
    object TConsultafuente: TStringField
      FieldName = 'fuente'
      Size = 100
    end
    object TConsultadireccion: TStringField
      FieldName = 'direccion'
      Size = 100
    end
    object TConsultalocalidad: TStringField
      FieldName = 'localidad'
      Size = 100
    end
    object TConsultacodigo_postal: TStringField
      FieldName = 'codigo_postal'
      Size = 100
    end
    object TConsultatelefono_fijo: TStringField
      FieldName = 'telefono_fijo'
      Size = 100
    end
    object TConsultatelefono_celular: TStringField
      FieldName = 'telefono_celular'
      Size = 100
    end
    object TConsultabajar_cv: TStringField
      FieldName = 'bajar_cv'
    end
    object TConsultaoid_cv: TIntegerField
      FieldName = 'oid_cv'
    end
    object TConsultacompetencias: TMemoField
      FieldName = 'competencias'
      BlobType = ftMemo
    end
    object TConsultaanotaciones: TMemoField
      FieldName = 'anotaciones'
      BlobType = ftMemo
    end
    object TConsultapostu_aplica: TMemoField
      FieldName = 'postu_aplica'
      BlobType = ftMemo
    end
    object TConsultanombre_archivo_cv: TStringField
      FieldName = 'nombre_archivo_cv'
      Size = 100
    end
    object TConsultaempresa_busq: TStringField
      FieldName = 'empresa_busq'
      Size = 100
    end
    object TConsultamotivo_busqueda: TStringField
      FieldName = 'motivo_busqueda'
      Size = 100
    end
    object TConsultaaprob_busqueda: TStringField
      FieldName = 'aprob_busqueda'
      Size = 100
    end
    object TConsultaobs_busqueda: TMemoField
      FieldName = 'obs_busqueda'
      BlobType = ftMemo
    end
    object TConsultaselector: TStringField
      FieldName = 'selector'
      Size = 100
    end
    object TConsultaestado_busqueda: TStringField
      FieldName = 'estado_busqueda'
      Size = 100
    end
    object TConsultamotivo_est_busqueda: TStringField
      FieldName = 'motivo_est_busqueda'
      Size = 100
    end
    object TConsultafec_cierre: TStringField
      FieldName = 'fec_cierre'
      Size = 100
    end
    object TConsultainicio_busq: TStringField
      FieldName = 'inicio_busq'
      Size = 100
    end
    object TConsultaconvenio: TStringField
      FieldName = 'convenio'
      Size = 100
    end
    object TConsultasueldo_bruto: TFloatField
      FieldName = 'sueldo_bruto'
    end
    object TConsultavancantes: TIntegerField
      FieldName = 'vancantes'
    end
    object TConsultacontrato: TStringField
      FieldName = 'contrato'
      Size = 100
    end
    object TConsultafec_aprobo_busq: TStringField
      FieldName = 'fec_aprobo_busq'
      Size = 100
    end
    object TConsultasector_busq: TStringField
      FieldName = 'sector_busq'
      Size = 100
    end
    object TConsultapuesto_busq: TStringField
      FieldName = 'puesto_busq'
      Size = 100
    end
    object TConsultaempresa_sector_busq: TStringField
      FieldName = 'empresa_sector_busq'
      Size = 100
    end
    object TConsultaprocesos: TMemoField
      FieldName = 'procesos'
      BlobType = ftMemo
    end
    object TConsultatrajo_foto: TBooleanField
      FieldName = 'trajo_foto'
    end
  end
  object DSConsulta: TDataSource
    AutoEdit = False
    DataSet = TConsulta
    Left = 136
    Top = 353
  end
  object cxStyleRepository1: TcxStyleRepository
    Left = 40
    Top = 80
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
    end
    object cxStyle2: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Arial'
      Font.Style = []
    end
    object cxStyle3: TcxStyle
      AssignedValues = [svColor, svFont, svTextColor]
      Color = clBlack
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlack
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      TextColor = clDefault
    end
    object cxStyle4: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clBlue
      Font.Height = -11
      Font.Name = 'Arial Narrow'
      Font.Style = []
    end
  end
  object TVisuColProc: TsnTable
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
    Left = 352
    Top = 337
    object TVisuColProcproceso1: TBooleanField
      FieldName = 'proceso1'
    end
    object TVisuColProcproceso2: TBooleanField
      FieldName = 'proceso2'
    end
    object TVisuColProcproceso3: TBooleanField
      FieldName = 'proceso3'
    end
    object TVisuColProcproceso4: TBooleanField
      FieldName = 'proceso4'
    end
    object TVisuColProcproceso5: TBooleanField
      FieldName = 'proceso5'
    end
    object TVisuColProcproceso6: TBooleanField
      FieldName = 'proceso6'
    end
    object TVisuColProcproceso7: TBooleanField
      FieldName = 'proceso7'
    end
    object TVisuColProcproceso8: TBooleanField
      FieldName = 'proceso8'
    end
    object TVisuColProcproceso9: TBooleanField
      FieldName = 'proceso9'
    end
    object TVisuColProcproceso10: TBooleanField
      FieldName = 'proceso10'
    end
    object TVisuColProcproceso11: TBooleanField
      FieldName = 'proceso11'
    end
    object TVisuColProcproceso12: TBooleanField
      FieldName = 'proceso12'
    end
    object TVisuColProcproceso13: TBooleanField
      FieldName = 'proceso13'
    end
    object TVisuColProcproceso14: TBooleanField
      FieldName = 'proceso14'
    end
    object TVisuColProcproceso15: TBooleanField
      FieldName = 'proceso15'
    end
    object TVisuColProcproceso16: TBooleanField
      FieldName = 'proceso16'
    end
    object TVisuColProcproceso17: TBooleanField
      FieldName = 'proceso17'
    end
    object TVisuColProcproceso18: TBooleanField
      FieldName = 'proceso18'
    end
    object TVisuColProcproceso19: TBooleanField
      FieldName = 'proceso19'
    end
    object TVisuColProcproceso20: TBooleanField
      FieldName = 'proceso20'
    end
    object TVisuColProcdesc_proceso1: TStringField
      FieldName = 'desc_proceso1'
      Size = 100
    end
    object TVisuColProcdesc_proceso2: TStringField
      FieldName = 'desc_proceso2'
      Size = 100
    end
    object TVisuColProcdesc_proceso3: TStringField
      FieldName = 'desc_proceso3'
      Size = 100
    end
    object TVisuColProcdesc_proceso4: TStringField
      FieldName = 'desc_proceso4'
      Size = 100
    end
    object TVisuColProcdesc_proceso5: TStringField
      FieldName = 'desc_proceso5'
      Size = 100
    end
    object TVisuColProcdesc_proceso6: TStringField
      FieldName = 'desc_proceso6'
      Size = 100
    end
    object TVisuColProcdesc_proceso7: TStringField
      FieldName = 'desc_proceso7'
      Size = 100
    end
    object TVisuColProcdesc_proceso8: TStringField
      FieldName = 'desc_proceso8'
      Size = 100
    end
    object TVisuColProcdesc_proceso9: TStringField
      FieldName = 'desc_proceso9'
      Size = 100
    end
    object TVisuColProcdesc_proceso10: TStringField
      FieldName = 'desc_proceso10'
      Size = 100
    end
    object TVisuColProcdesc_proceso11: TStringField
      FieldName = 'desc_proceso11'
      Size = 100
    end
    object TVisuColProcdesc_proceso12: TStringField
      FieldName = 'desc_proceso12'
      Size = 100
    end
    object TVisuColProcdesc_proceso13: TStringField
      FieldName = 'desc_proceso13'
      Size = 100
    end
    object TVisuColProcdesc_proceso14: TStringField
      FieldName = 'desc_proceso14'
      Size = 100
    end
    object TVisuColProcdesc_proceso15: TStringField
      FieldName = 'desc_proceso15'
      Size = 100
    end
    object TVisuColProcdesc_proceso16: TStringField
      FieldName = 'desc_proceso16'
      Size = 100
    end
    object TVisuColProcdesc_proceso17: TStringField
      FieldName = 'desc_proceso17'
      Size = 100
    end
    object TVisuColProcdesc_proceso18: TStringField
      FieldName = 'desc_proceso18'
      Size = 100
    end
    object TVisuColProcdesc_proceso19: TStringField
      FieldName = 'desc_proceso19'
      Size = 100
    end
    object TVisuColProcdesc_proceso20: TStringField
      FieldName = 'desc_proceso20'
      Size = 100
    end
  end
  object HelpEstCandidatoBusq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstCandidatoBusq'
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
    Left = 110
    Top = 415
  end
  object TEstCandidatoBusq: TsnTable
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
    Top = 415
    object IntegerField2: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEstCandidatoBusq: TDataSource
    DataSet = TEstCandidatoBusq
    Left = 178
    Top = 415
  end
  object SaveAdjunto: TsnSaveDialog
    OptionsEx = [ofExNoPlacesBar]
    Left = 488
    Top = 166
  end
  object varios: TsnVarios
    Operacion = Operacion
    Left = 512
    Top = 70
  end
  object formPostulante: TFormulario
    AutoLiberar = True
    Nombre = 'TFRecluPostulante'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 610
    Top = 260
  end
  object FormBusqueda: TFormulario
    AutoLiberar = True
    Nombre = 'TFRecluBusquedas'
    CreateAlwaysANewForm = True
    Left = 610
    Top = 303
  end
  object TCompetenciasPostulantes: TsnTable
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
    Left = 816
    Top = 222
    object TCompetenciasPostulantesoid: TIntegerField
      FieldName = 'oid'
    end
    object TCompetenciasPostulantescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCompetenciasPostulantesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TCompetenciasPostulantesseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TCandidatosEnEstado: TsnTable
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
    Left = 816
    Top = 262
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
      FieldName = 'seleccionado'
    end
  end
  object TProcesosEnEstado: TsnTable
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
    MensajeValorDuplicadoIndice = 'TEstadosProceso'
    Left = 904
    Top = 262
    object IntegerField6: TIntegerField
      FieldName = 'oid'
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField3: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TPostulacionesAplica: TsnTable
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
    Left = 912
    Top = 222
    object IntegerField3: TIntegerField
      FieldName = 'oid'
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField2: TBooleanField
      FieldName = 'seleccionado'
    end
  end
end
