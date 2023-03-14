inherited FDefDiasCacheo: TFDefDiasCacheo
  Left = 71
  Top = 130
  Width = 807
  Height = 563
  Caption = 'Definici'#243'n de D'#237'as y Puertas para cacheo'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 799
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object BotonGrabar: TsnButton
      Left = 87
      Top = 10
      Width = 106
      Height = 25
      Caption = 'Grabar Cambios'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 799
    Height = 488
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Panel3: TPanel
      Left = 0
      Top = 0
      Width = 799
      Height = 31
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object Label1: TLabel
        Left = 24
        Top = 8
        Width = 148
        Height = 16
        Caption = 'Realizar el cacheo el d'#237'a'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
    end
    object Panel4: TPanel
      Left = 0
      Top = 31
      Width = 799
      Height = 457
      Align = alClient
      BevelOuter = bvNone
      BorderWidth = 5
      Color = clWindow
      TabOrder = 1
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 789
        Height = 447
        ActivePage = TabSheet1
        Align = alClient
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Lunes'
          object Label3: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label2: TLabel
            Left = 47
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label4: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel1: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel2: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label5: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit1: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_lun_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpLunesEnt
            Width = 160
          end
          object srnDBButtonEdit2: TsrnDBButtonEdit
            Left = 108
            Top = 159
            DataBinding.DataField = 'cod_lun_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            Help = HelpLunesSal
            Width = 160
          end
          object snDBEdit1: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_lun_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 2
            Width = 459
          end
          object snDBEdit2: TsnDBEdit
            Left = 265
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_lun_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Martes'
          ImageIndex = 1
          object Label6: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label7: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label8: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label9: TLabel
            Left = 48
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel3: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel4: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit3: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_mar_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpMartesEnt
            Width = 160
          end
          object snDBEdit3: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_mar_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 459
          end
          object srnDBButtonEdit4: TsrnDBButtonEdit
            Left = 107
            Top = 159
            DataBinding.DataField = 'cod_mar_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 2
            Help = HelpMartesSal
            Width = 160
          end
          object snDBEdit4: TsnDBEdit
            Left = 264
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_mar_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'Mi'#233'rcoles'
          ImageIndex = 2
          object Label18: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label19: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label20: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label21: TLabel
            Left = 49
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel9: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel10: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit9: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_mie_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpMiercolesEnt
            Width = 160
          end
          object snDBEdit9: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_mie_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 459
          end
          object srnDBButtonEdit10: TsrnDBButtonEdit
            Left = 107
            Top = 159
            DataBinding.DataField = 'cod_mie_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 2
            Help = HelpMiercolesSal
            Width = 160
          end
          object snDBEdit10: TsnDBEdit
            Left = 264
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_mie_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
        object TabSheet4: TTabSheet
          Caption = 'Jueves'
          ImageIndex = 3
          object Label22: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label23: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label24: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label25: TLabel
            Left = 47
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel11: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel12: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit11: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_jue_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpJuevesEnt
            Width = 160
          end
          object snDBEdit11: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_jue_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 459
          end
          object srnDBButtonEdit12: TsrnDBButtonEdit
            Left = 106
            Top = 159
            DataBinding.DataField = 'cod_jue_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 2
            Help = HelpJuevesSal
            Width = 160
          end
          object snDBEdit12: TsnDBEdit
            Left = 263
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_jue_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
        object TabSheet5: TTabSheet
          Caption = 'Viernes'
          ImageIndex = 4
          object Label26: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label27: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label28: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label29: TLabel
            Left = 47
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel13: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel14: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit13: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_vie_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpViernesEnt
            Width = 160
          end
          object snDBEdit13: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_vie_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 459
          end
          object srnDBButtonEdit14: TsrnDBButtonEdit
            Left = 106
            Top = 159
            DataBinding.DataField = 'cod_vie_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 2
            Help = HelpViernesSal
            Width = 160
          end
          object snDBEdit14: TsnDBEdit
            Left = 263
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_vie_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
        object TabSheet6: TTabSheet
          Caption = 'S'#225'bado'
          ImageIndex = 5
          object Label14: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label15: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label16: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label17: TLabel
            Left = 45
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel7: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel8: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit7: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_sab_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpSabadoEnt
            Width = 160
          end
          object snDBEdit7: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_sab_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 459
          end
          object srnDBButtonEdit8: TsrnDBButtonEdit
            Left = 105
            Top = 159
            DataBinding.DataField = 'cod_sab_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 2
            Help = HelpSabadoSal
            Width = 160
          end
          object snDBEdit8: TsnDBEdit
            Left = 262
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_sab_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
        object TabSheet7: TTabSheet
          Caption = 'Domingo'
          ImageIndex = 6
          object Label10: TLabel
            Left = 16
            Top = 27
            Width = 262
            Height = 16
            Caption = 'Al producirse la entrada de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label11: TLabel
            Left = 45
            Top = 64
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label12: TLabel
            Left = 16
            Top = 123
            Width = 253
            Height = 16
            Caption = 'Al producirse la salida de una persona por'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object Label13: TLabel
            Left = 46
            Top = 163
            Width = 46
            Height = 16
            Caption = 'Puertas'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel5: TsnLabel
            Left = 16
            Top = 224
            Width = 457
            Height = 13
            Caption = 
              'Nota: Si se deja en blanco las Puertas no se realizar'#225' cacheo pa' +
              'ra ese d'#237'a en la salida o entrada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snLabel6: TsnLabel
            Left = 16
            Top = 240
            Width = 94
            Height = 13
            Caption = 'seg'#250'n corresponda.'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clRed
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object srnDBButtonEdit5: TsrnDBButtonEdit
            Left = 105
            Top = 60
            DataBinding.DataField = 'cod_dom_ent'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 0
            Help = HelpDomingoEnt
            Width = 160
          end
          object snDBEdit5: TsnDBEdit
            Left = 262
            Top = 60
            TabStop = False
            DataBinding.DataField = 'desc_dom_ent'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 459
          end
          object srnDBButtonEdit6: TsrnDBButtonEdit
            Left = 105
            Top = 159
            DataBinding.DataField = 'cod_dom_sal'
            DataBinding.DataSource = DSTDefPuertas
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
            TabOrder = 2
            Help = HelpDomingoSal
            Width = 160
          end
          object snDBEdit6: TsnDBEdit
            Left = 262
            Top = 159
            TabStop = False
            DataBinding.DataField = 'desc_dom_sal'
            DataBinding.DataSource = DSTDefPuertas
            ParentFont = False
            Properties.ReadOnly = True
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 3
            Width = 455
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TDefPuertas
        TableName = 'TDefPuertas'
      end>
    Left = 600
    Top = 40
  end
  inherited Operacion: TOperacion
    Left = 640
    Top = 40
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 680
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
    Left = 720
    Top = 40
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_lun_ent'
        Source.Strings = (
          'begin'
          '  ValidadorLunesEnt.Value := Sender.AsString;'
          '  ValidadorLunesEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_lun_sal'
        Source.Strings = (
          'begin'
          '  ValidadorLunesSal.Value := Sender.AsString;'
          '  ValidadorLunesSal.Validar();'
          'end.'
          '')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_mar_ent'
        Source.Strings = (
          'begin'
          '  ValidadorMartesEnt.Value := Sender.AsString;'
          '  ValidadorMartesEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_mar_sal'
        Source.Strings = (
          'begin'
          '  ValidadorMartesSal.Value := Sender.AsString;'
          '  ValidadorMartesSal.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_mie_ent'
        Source.Strings = (
          'begin'
          '  ValidadorMiercolesEnt.Value := Sender.AsString;'
          '  ValidadorMiercolesEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_mie_sal'
        Source.Strings = (
          'begin'
          '  ValidadorMiercolesSal.Value := Sender.AsString;'
          '  ValidadorMiercolesSal.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_jue_ent'
        Source.Strings = (
          'begin'
          '  ValidadorJuevesEnt.Value := Sender.AsString;'
          '  ValidadorJuevesEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_jue_sal'
        Source.Strings = (
          'begin'
          '  ValidadorJuevesSal.Value := Sender.AsString;'
          '  ValidadorJuevesSal.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_vie_ent'
        Source.Strings = (
          'begin'
          '  ValidadorViernesEnt.Value := Sender.AsString;'
          '  ValidadorViernesEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_vie_sal'
        Source.Strings = (
          'begin'
          '  ValidadorViernesSal.Value := Sender.AsString;'
          '  ValidadorViernesSal.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_sab_ent'
        Source.Strings = (
          'begin'
          '  ValidadorSabadoEnt.Value := Sender.AsString;'
          '  ValidadorSabadoEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_sab_sal'
        Source.Strings = (
          'begin'
          '  ValidadorSabadoSal.Value := Sender.AsString;'
          '  ValidadorSabadoSal.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_dom_ent'
        Source.Strings = (
          'begin'
          '  ValidadorDomingoEnt.Value := Sender.AsString;'
          '  ValidadorDomingoEnt.Validar();'
          'end.')
      end
      item
        TableName = 'TDefPuertas'
        FieldName = 'cod_dom_sal'
        Source.Strings = (
          'begin'
          '  ValidadorDomingoSal.Value := Sender.AsString;'
          '  ValidadorDomingoSal.Validar();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);  '
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerPlanifDiaCacheo'#39');'
          ' operacion.execute();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure GrabarCambios();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SavePlanifDiaCacheo'#39');'
          '  operacion.AddDataSet(TDefPuertas.getDataSet());'
          '  operacion.execute(); '
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
        ButtonName = 'BotonGrabar'
        Source.Strings = (
          'begin'
          '  GrabarCambios();'
          '  mensaje.information('#39'Se grabaron los cambios con EXITO'#39');'
          'end.')
      end>
    Left = 760
    Top = 43
  end
  inherited SaveArchivo: TSaveDialog
    Top = 120
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 424
    Top = 120
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TPathHelp: TsnTable
    Top = 437
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 376
    Top = 17
  end
  object TDefPuertas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_lun_ent'
        DataType = ftInteger
      end
      item
        Name = 'cod_lun_ent'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_lun_ent'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_lun_sal'
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
    Left = 457
    Top = 216
    object TDefPuertasoid_planif_dia: TIntegerField
      FieldName = 'oid_planif_dia'
    end
    object TDefPuertasoid_lun_ent: TIntegerField
      FieldName = 'oid_lun_ent'
    end
    object TDefPuertascod_lun_ent: TStringField
      FieldName = 'cod_lun_ent'
      Size = 50
    end
    object TDefPuertasdesc_lun_ent: TStringField
      FieldName = 'desc_lun_ent'
      Size = 100
    end
    object TDefPuertasoid_lun_sal: TIntegerField
      FieldName = 'oid_lun_sal'
    end
    object TDefPuertascod_lun_sal: TStringField
      FieldName = 'cod_lun_sal'
      Size = 50
    end
    object TDefPuertasdesc_lun_sal: TStringField
      FieldName = 'desc_lun_sal'
      Size = 100
    end
    object TDefPuertasoid_mar_ent: TIntegerField
      FieldName = 'oid_mar_ent'
    end
    object TDefPuertascod_mar_ent: TStringField
      FieldName = 'cod_mar_ent'
      Size = 50
    end
    object TDefPuertasdesc_mar_ent: TStringField
      FieldName = 'desc_mar_ent'
      Size = 100
    end
    object TDefPuertasoid_mar_sal: TIntegerField
      FieldName = 'oid_mar_sal'
    end
    object TDefPuertascod_mar_sal: TStringField
      FieldName = 'cod_mar_sal'
      Size = 50
    end
    object TDefPuertasdesc_mar_sal: TStringField
      FieldName = 'desc_mar_sal'
      Size = 100
    end
    object TDefPuertasoid_mie_ent: TIntegerField
      FieldName = 'oid_mie_ent'
    end
    object TDefPuertascod_mie_ent: TStringField
      FieldName = 'cod_mie_ent'
      Size = 50
    end
    object TDefPuertasdesc_mie_ent: TStringField
      FieldName = 'desc_mie_ent'
      Size = 100
    end
    object TDefPuertasoid_mie_sal: TIntegerField
      FieldName = 'oid_mie_sal'
    end
    object TDefPuertascod_mie_sal: TStringField
      FieldName = 'cod_mie_sal'
      Size = 50
    end
    object TDefPuertasdesc_mie_sal: TStringField
      FieldName = 'desc_mie_sal'
      Size = 100
    end
    object TDefPuertasoid_jue_ent: TIntegerField
      FieldName = 'oid_jue_ent'
    end
    object TDefPuertascod_jue_ent: TStringField
      FieldName = 'cod_jue_ent'
      Size = 50
    end
    object TDefPuertasdesc_jue_ent: TStringField
      FieldName = 'desc_jue_ent'
      Size = 100
    end
    object TDefPuertasoid_jue_sal: TIntegerField
      FieldName = 'oid_jue_sal'
    end
    object TDefPuertascod_jue_sal: TStringField
      FieldName = 'cod_jue_sal'
      Size = 50
    end
    object TDefPuertasdesc_jue_sal: TStringField
      FieldName = 'desc_jue_sal'
      Size = 100
    end
    object TDefPuertasoid_vie_ent: TIntegerField
      FieldName = 'oid_vie_ent'
    end
    object TDefPuertascod_vie_ent: TStringField
      FieldName = 'cod_vie_ent'
      Size = 50
    end
    object TDefPuertasdesc_vie_ent: TStringField
      FieldName = 'desc_vie_ent'
      Size = 100
    end
    object TDefPuertasoid_vie_sal: TIntegerField
      FieldName = 'oid_vie_sal'
    end
    object TDefPuertascod_vie_sal: TStringField
      FieldName = 'cod_vie_sal'
      Size = 50
    end
    object TDefPuertasdesc_vie_sal: TStringField
      FieldName = 'desc_vie_sal'
      Size = 100
    end
    object TDefPuertasoid_sab_ent: TIntegerField
      FieldName = 'oid_sab_ent'
    end
    object TDefPuertascod_sab_ent: TStringField
      FieldName = 'cod_sab_ent'
      Size = 50
    end
    object TDefPuertasdesc_sab_ent: TStringField
      FieldName = 'desc_sab_ent'
      Size = 100
    end
    object TDefPuertasoid_sab_sal: TIntegerField
      FieldName = 'oid_sab_sal'
    end
    object TDefPuertascod_sab_sal: TStringField
      FieldName = 'cod_sab_sal'
      Size = 50
    end
    object TDefPuertasdesc_sab_sal: TStringField
      FieldName = 'desc_sab_sal'
      Size = 100
    end
    object TDefPuertasoid_dom_ent: TIntegerField
      FieldName = 'oid_dom_ent'
    end
    object TDefPuertascod_dom_ent: TStringField
      FieldName = 'cod_dom_ent'
      Size = 50
    end
    object TDefPuertasdesc_dom_ent: TStringField
      FieldName = 'desc_dom_ent'
      Size = 100
    end
    object TDefPuertasoid_dom_sal: TIntegerField
      FieldName = 'oid_dom_sal'
    end
    object TDefPuertascod_dom_sal: TStringField
      FieldName = 'cod_dom_sal'
      Size = 50
    end
    object TDefPuertasdesc_dom_sal: TStringField
      FieldName = 'desc_dom_sal'
      Size = 100
    end
  end
  object DSTDefPuertas: TDataSource
    DataSet = TDefPuertas
    Left = 489
    Top = 216
  end
  object HelpLunesEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_lun_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 124
  end
  object HelpLunesSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_lun_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 124
  end
  object HelpMartesEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_mar_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 160
  end
  object HelpMartesSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_mar_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 160
  end
  object HelpMiercolesEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_mie_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 195
  end
  object HelpMiercolesSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_mie_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 195
  end
  object HelpJuevesEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_jue_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 229
  end
  object HelpJuevesSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_jue_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 229
  end
  object HelpViernesEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_vie_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 262
  end
  object HelpViernesSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_vie_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 262
  end
  object HelpSabadoEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_sab_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 294
  end
  object HelpSabadoSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_sab_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 294
  end
  object HelpDomingoEnt: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_dom_ent
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 162
    Top = 326
  end
  object HelpDomingoSal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
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
        AsignarACampo = TDefPuertascod_dom_sal
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
    Titulo = 'Grupo de Puntos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 196
    Top = 326
  end
  object ValidadorLunesEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_lun_ent
    CampoDescripcion = TDefPuertasdesc_lun_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 123
  end
  object ValidadorLunesSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_lun_sal
    CampoDescripcion = TDefPuertasdesc_lun_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 123
  end
  object ValidadorMartesEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_mar_ent
    CampoDescripcion = TDefPuertasdesc_mar_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 161
  end
  object ValidadorMartesSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_mar_sal
    CampoDescripcion = TDefPuertasdesc_mar_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 161
  end
  object ValidadorMiercolesEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_mie_ent
    CampoDescripcion = TDefPuertasdesc_mie_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 194
  end
  object ValidadorMiercolesSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_mie_sal
    CampoDescripcion = TDefPuertasdesc_mie_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 194
  end
  object ValidadorJuevesEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_jue_ent
    CampoDescripcion = TDefPuertasdesc_jue_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 227
  end
  object ValidadorJuevesSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_jue_sal
    CampoDescripcion = TDefPuertasdesc_jue_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 227
  end
  object ValidadorViernesEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_vie_ent
    CampoDescripcion = TDefPuertasdesc_vie_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 260
  end
  object ValidadorViernesSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_vie_sal
    CampoDescripcion = TDefPuertasdesc_vie_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 260
  end
  object ValidadorSabadoEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_sab_ent
    CampoDescripcion = TDefPuertasdesc_sab_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 292
  end
  object ValidadorSabadoSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_sab_sal
    CampoDescripcion = TDefPuertasdesc_sab_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 292
  end
  object ValidadorDomingoEnt: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_dom_ent
    CampoDescripcion = TDefPuertasdesc_dom_ent
    NroQuery = 0
    Cache = False
    Left = 280
    Top = 323
  end
  object ValidadorDomingoSal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    MensajeException = 'C'#243'digo de Puertas Inexistente'
    CampoOID = TDefPuertasoid_dom_sal
    CampoDescripcion = TDefPuertasdesc_dom_sal
    NroQuery = 0
    Cache = False
    Left = 315
    Top = 323
  end
end
