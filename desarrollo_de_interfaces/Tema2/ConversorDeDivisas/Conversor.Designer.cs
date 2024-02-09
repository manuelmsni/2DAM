namespace ConversorDeDivisas
{
    partial class Conversor
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Conversor));
            Main_FlowLayoutPanel = new FlowLayoutPanel();
            Origin_FlowLayoutPanel = new FlowLayoutPanel();
            label1 = new Label();
            Origin_ComboBox = new ComboBox();
            DataSource_flowLayoutPanel = new FlowLayoutPanel();
            DataOrigin_Label = new Label();
            DataOrigin_TextBox = new TextBox();
            Swap_Button = new Button();
            Destination_FlowLayoutPanel = new FlowLayoutPanel();
            label2 = new Label();
            Destination_ComboBox = new ComboBox();
            Mid_FlowLayoutPanel = new FlowLayoutPanel();
            Submit_Button = new Button();
            Output_RichTextBox = new RichTextBox();
            flowLayoutPanel1 = new FlowLayoutPanel();
            Signature_Label = new Label();
            Main_FlowLayoutPanel.SuspendLayout();
            Origin_FlowLayoutPanel.SuspendLayout();
            DataSource_flowLayoutPanel.SuspendLayout();
            Destination_FlowLayoutPanel.SuspendLayout();
            Mid_FlowLayoutPanel.SuspendLayout();
            flowLayoutPanel1.SuspendLayout();
            SuspendLayout();
            // 
            // Main_FlowLayoutPanel
            // 
            Main_FlowLayoutPanel.AutoSize = true;
            Main_FlowLayoutPanel.AutoSizeMode = AutoSizeMode.GrowAndShrink;
            Main_FlowLayoutPanel.Controls.Add(Origin_FlowLayoutPanel);
            Main_FlowLayoutPanel.Controls.Add(DataSource_flowLayoutPanel);
            Main_FlowLayoutPanel.Controls.Add(Destination_FlowLayoutPanel);
            Main_FlowLayoutPanel.Controls.Add(Mid_FlowLayoutPanel);
            Main_FlowLayoutPanel.Controls.Add(flowLayoutPanel1);
            Main_FlowLayoutPanel.Dock = DockStyle.Fill;
            Main_FlowLayoutPanel.Location = new Point(0, 0);
            Main_FlowLayoutPanel.Margin = new Padding(0);
            Main_FlowLayoutPanel.Name = "Main_FlowLayoutPanel";
            Main_FlowLayoutPanel.Size = new Size(450, 245);
            Main_FlowLayoutPanel.TabIndex = 0;
            // 
            // Origin_FlowLayoutPanel
            // 
            Origin_FlowLayoutPanel.BackColor = SystemColors.WindowFrame;
            Origin_FlowLayoutPanel.Controls.Add(label1);
            Origin_FlowLayoutPanel.Controls.Add(Origin_ComboBox);
            Origin_FlowLayoutPanel.FlowDirection = FlowDirection.TopDown;
            Origin_FlowLayoutPanel.ForeColor = Color.White;
            Origin_FlowLayoutPanel.Location = new Point(0, 0);
            Origin_FlowLayoutPanel.Margin = new Padding(0);
            Origin_FlowLayoutPanel.Name = "Origin_FlowLayoutPanel";
            Origin_FlowLayoutPanel.Size = new Size(150, 100);
            Origin_FlowLayoutPanel.TabIndex = 5;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(0, 0);
            label1.Margin = new Padding(0);
            label1.MinimumSize = new Size(150, 0);
            label1.Name = "label1";
            label1.Padding = new Padding(0, 10, 0, 10);
            label1.Size = new Size(150, 35);
            label1.TabIndex = 0;
            label1.Text = "Divisa de origen";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // Origin_ComboBox
            // 
            Origin_ComboBox.BackColor = Color.White;
            Origin_ComboBox.FormattingEnabled = true;
            Origin_ComboBox.Location = new Point(10, 35);
            Origin_ComboBox.Margin = new Padding(10, 0, 10, 0);
            Origin_ComboBox.Name = "Origin_ComboBox";
            Origin_ComboBox.Size = new Size(130, 23);
            Origin_ComboBox.TabIndex = 1;
            // 
            // DataSource_flowLayoutPanel
            // 
            DataSource_flowLayoutPanel.BackColor = Color.FromArgb(64, 64, 64);
            DataSource_flowLayoutPanel.Controls.Add(DataOrigin_Label);
            DataSource_flowLayoutPanel.Controls.Add(DataOrigin_TextBox);
            DataSource_flowLayoutPanel.Controls.Add(Swap_Button);
            DataSource_flowLayoutPanel.FlowDirection = FlowDirection.TopDown;
            DataSource_flowLayoutPanel.Location = new Point(150, 0);
            DataSource_flowLayoutPanel.Margin = new Padding(0);
            DataSource_flowLayoutPanel.Name = "DataSource_flowLayoutPanel";
            DataSource_flowLayoutPanel.Size = new Size(150, 100);
            DataSource_flowLayoutPanel.TabIndex = 8;
            // 
            // DataOrigin_Label
            // 
            DataOrigin_Label.AutoSize = true;
            DataOrigin_Label.ForeColor = Color.White;
            DataOrigin_Label.Location = new Point(0, 0);
            DataOrigin_Label.Margin = new Padding(0);
            DataOrigin_Label.MinimumSize = new Size(150, 0);
            DataOrigin_Label.Name = "DataOrigin_Label";
            DataOrigin_Label.Padding = new Padding(0, 10, 0, 10);
            DataOrigin_Label.Size = new Size(150, 35);
            DataOrigin_Label.TabIndex = 1;
            DataOrigin_Label.Text = "Introduce cantidad";
            DataOrigin_Label.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // DataOrigin_TextBox
            // 
            DataOrigin_TextBox.Location = new Point(10, 35);
            DataOrigin_TextBox.Margin = new Padding(10, 0, 10, 0);
            DataOrigin_TextBox.Name = "DataOrigin_TextBox";
            DataOrigin_TextBox.Size = new Size(130, 23);
            DataOrigin_TextBox.TabIndex = 2;
            DataOrigin_TextBox.TextChanged += DataOrigin_TextChanged;
            // 
            // Swap_Button
            // 
            Swap_Button.Cursor = Cursors.Hand;
            Swap_Button.Location = new Point(30, 68);
            Swap_Button.Margin = new Padding(30, 10, 30, 0);
            Swap_Button.Name = "Swap_Button";
            Swap_Button.Size = new Size(90, 23);
            Swap_Button.TabIndex = 3;
            Swap_Button.Text = " < = >";
            Swap_Button.UseVisualStyleBackColor = true;
            Swap_Button.Click += Swap_Button_Clicked;
            // 
            // Destination_FlowLayoutPanel
            // 
            Destination_FlowLayoutPanel.BackColor = SystemColors.WindowFrame;
            Destination_FlowLayoutPanel.Controls.Add(label2);
            Destination_FlowLayoutPanel.Controls.Add(Destination_ComboBox);
            Destination_FlowLayoutPanel.FlowDirection = FlowDirection.TopDown;
            Destination_FlowLayoutPanel.ForeColor = Color.White;
            Destination_FlowLayoutPanel.Location = new Point(300, 0);
            Destination_FlowLayoutPanel.Margin = new Padding(0);
            Destination_FlowLayoutPanel.Name = "Destination_FlowLayoutPanel";
            Destination_FlowLayoutPanel.Size = new Size(150, 100);
            Destination_FlowLayoutPanel.TabIndex = 9;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(0, 0);
            label2.Margin = new Padding(0);
            label2.MinimumSize = new Size(150, 0);
            label2.Name = "label2";
            label2.Padding = new Padding(0, 10, 0, 10);
            label2.Size = new Size(150, 35);
            label2.TabIndex = 1;
            label2.Text = "Divisa de destino";
            label2.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // Destination_ComboBox
            // 
            Destination_ComboBox.FormattingEnabled = true;
            Destination_ComboBox.Location = new Point(10, 35);
            Destination_ComboBox.Margin = new Padding(10, 0, 10, 0);
            Destination_ComboBox.Name = "Destination_ComboBox";
            Destination_ComboBox.Size = new Size(130, 23);
            Destination_ComboBox.TabIndex = 2;
            // 
            // Mid_FlowLayoutPanel
            // 
            Mid_FlowLayoutPanel.AutoSize = true;
            Mid_FlowLayoutPanel.BackColor = Color.FromArgb(64, 64, 64);
            Mid_FlowLayoutPanel.Controls.Add(Submit_Button);
            Mid_FlowLayoutPanel.Controls.Add(Output_RichTextBox);
            Mid_FlowLayoutPanel.Dock = DockStyle.Fill;
            Mid_FlowLayoutPanel.Location = new Point(0, 100);
            Mid_FlowLayoutPanel.Margin = new Padding(0);
            Mid_FlowLayoutPanel.MinimumSize = new Size(0, 120);
            Mid_FlowLayoutPanel.Name = "Mid_FlowLayoutPanel";
            Mid_FlowLayoutPanel.Size = new Size(450, 120);
            Mid_FlowLayoutPanel.TabIndex = 10;
            // 
            // Submit_Button
            // 
            Submit_Button.Cursor = Cursors.Hand;
            Submit_Button.Enabled = false;
            Submit_Button.Location = new Point(10, 10);
            Submit_Button.Margin = new Padding(10);
            Submit_Button.Name = "Submit_Button";
            Submit_Button.Size = new Size(75, 23);
            Submit_Button.TabIndex = 0;
            Submit_Button.Text = "Calcular";
            Submit_Button.UseVisualStyleBackColor = true;
            Submit_Button.MouseClick += Submit_Button_Clicked;
            // 
            // Output_RichTextBox
            // 
            Output_RichTextBox.Cursor = Cursors.No;
            Output_RichTextBox.Dock = DockStyle.Fill;
            Output_RichTextBox.Font = new Font("Alef", 9F, FontStyle.Regular, GraphicsUnit.Point);
            Output_RichTextBox.Location = new Point(95, 10);
            Output_RichTextBox.Margin = new Padding(0, 10, 10, 10);
            Output_RichTextBox.MinimumSize = new Size(0, 100);
            Output_RichTextBox.Name = "Output_RichTextBox";
            Output_RichTextBox.ReadOnly = true;
            Output_RichTextBox.ScrollBars = RichTextBoxScrollBars.Vertical;
            Output_RichTextBox.Size = new Size(345, 100);
            Output_RichTextBox.TabIndex = 1;
            Output_RichTextBox.Text = "";
            // 
            // flowLayoutPanel1
            // 
            flowLayoutPanel1.BackColor = SystemColors.ControlDarkDark;
            flowLayoutPanel1.Controls.Add(Signature_Label);
            flowLayoutPanel1.Dock = DockStyle.Bottom;
            flowLayoutPanel1.Location = new Point(0, 220);
            flowLayoutPanel1.Margin = new Padding(0);
            flowLayoutPanel1.Name = "flowLayoutPanel1";
            flowLayoutPanel1.Size = new Size(450, 25);
            flowLayoutPanel1.TabIndex = 11;
            // 
            // Signature_Label
            // 
            Signature_Label.AutoSize = true;
            Signature_Label.BackColor = SystemColors.WindowFrame;
            Signature_Label.Font = new Font("Segoe Script", 9F, FontStyle.Bold | FontStyle.Italic, GraphicsUnit.Point);
            Signature_Label.ForeColor = Color.White;
            Signature_Label.Location = new Point(0, 0);
            Signature_Label.Margin = new Padding(0);
            Signature_Label.MinimumSize = new Size(450, 25);
            Signature_Label.Name = "Signature_Label";
            Signature_Label.Size = new Size(450, 25);
            Signature_Label.TabIndex = 0;
            Signature_Label.Text = "manuelmsni";
            Signature_Label.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // Conversor
            // 
            AutoSizeMode = AutoSizeMode.GrowAndShrink;
            ClientSize = new Size(450, 245);
            Controls.Add(Main_FlowLayoutPanel);
            Icon = (Icon)resources.GetObject("$this.Icon");
            Name = "Conversor";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Conversor de divisas";
            FormClosing += Form_Close;
            Main_FlowLayoutPanel.ResumeLayout(false);
            Main_FlowLayoutPanel.PerformLayout();
            Origin_FlowLayoutPanel.ResumeLayout(false);
            Origin_FlowLayoutPanel.PerformLayout();
            DataSource_flowLayoutPanel.ResumeLayout(false);
            DataSource_flowLayoutPanel.PerformLayout();
            Destination_FlowLayoutPanel.ResumeLayout(false);
            Destination_FlowLayoutPanel.PerformLayout();
            Mid_FlowLayoutPanel.ResumeLayout(false);
            flowLayoutPanel1.ResumeLayout(false);
            flowLayoutPanel1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private FlowLayoutPanel Main_FlowLayoutPanel;
        private FlowLayoutPanel Origin_FlowLayoutPanel;
        private Label label1;
        private ComboBox Origin_ComboBox;
        private FlowLayoutPanel DataSource_flowLayoutPanel;
        private Label DataOrigin_Label;
        private TextBox DataOrigin_TextBox;
        private FlowLayoutPanel Destination_FlowLayoutPanel;
        private Label label2;
        private ComboBox Destination_ComboBox;
        private FlowLayoutPanel Mid_FlowLayoutPanel;
        private Button Submit_Button;
        private RichTextBox Output_RichTextBox;
        private FlowLayoutPanel flowLayoutPanel1;
        private Button Swap_Button;
        private Label Signature_Label;
    }
}