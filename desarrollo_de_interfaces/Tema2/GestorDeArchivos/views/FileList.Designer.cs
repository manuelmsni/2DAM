namespace GestorDeArchivos
{
    partial class FileList
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            flowLayoutPanel1 = new FlowLayoutPanel();
            menuClickDerecho = new ContextMenuStrip(components);
            crearCarpeta = new ToolStripMenuItem();
            crearArchivo = new ToolStripMenuItem();
            panel1 = new Panel();
            panel2 = new Panel();
            url = new Label();
            flowLayoutPanel2 = new FlowLayoutPanel();
            goBack = new Button();
            MenuBorrar = new ContextMenuStrip(components);
            borrarToolStripMenuItem = new ToolStripMenuItem();
            menuClickDerecho.SuspendLayout();
            panel1.SuspendLayout();
            panel2.SuspendLayout();
            flowLayoutPanel2.SuspendLayout();
            MenuBorrar.SuspendLayout();
            SuspendLayout();
            // 
            // flowLayoutPanel1
            // 
            flowLayoutPanel1.AutoSizeMode = AutoSizeMode.GrowAndShrink;
            flowLayoutPanel1.Dock = DockStyle.Fill;
            flowLayoutPanel1.Location = new Point(0, 31);
            flowLayoutPanel1.Name = "flowLayoutPanel1";
            flowLayoutPanel1.Size = new Size(680, 470);
            flowLayoutPanel1.TabIndex = 0;
            flowLayoutPanel1.Click += OpenRightClickMenu;
            // 
            // menuClickDerecho
            // 
            menuClickDerecho.Items.AddRange(new ToolStripItem[] { crearCarpeta, crearArchivo });
            menuClickDerecho.Name = "contextMenuStrip1";
            menuClickDerecho.Size = new Size(152, 48);
            // 
            // crearCarpeta
            // 
            crearCarpeta.Name = "crearCarpeta";
            crearCarpeta.Size = new Size(151, 22);
            crearCarpeta.Text = "Nueva carpeta";
            crearCarpeta.Click += OpenCreateDirectoryWindow;
            // 
            // crearArchivo
            // 
            crearArchivo.Name = "crearArchivo";
            crearArchivo.Size = new Size(151, 22);
            crearArchivo.Text = "Nuevo archivo";
            crearArchivo.Click += OpenCreateFileWindow;
            // 
            // panel1
            // 
            panel1.Controls.Add(panel2);
            panel1.Controls.Add(flowLayoutPanel2);
            panel1.Dock = DockStyle.Top;
            panel1.Location = new Point(0, 0);
            panel1.Name = "panel1";
            panel1.Size = new Size(680, 31);
            panel1.TabIndex = 0;
            // 
            // panel2
            // 
            panel2.Controls.Add(url);
            panel2.Dock = DockStyle.Fill;
            panel2.Location = new Point(0, 0);
            panel2.Name = "panel2";
            panel2.Size = new Size(551, 31);
            panel2.TabIndex = 1;
            // 
            // url
            // 
            url.AutoSize = true;
            url.Location = new Point(12, 7);
            url.Name = "url";
            url.Size = new Size(0, 15);
            url.TabIndex = 0;
            // 
            // flowLayoutPanel2
            // 
            flowLayoutPanel2.Controls.Add(goBack);
            flowLayoutPanel2.Dock = DockStyle.Right;
            flowLayoutPanel2.FlowDirection = FlowDirection.RightToLeft;
            flowLayoutPanel2.Location = new Point(551, 0);
            flowLayoutPanel2.Name = "flowLayoutPanel2";
            flowLayoutPanel2.Size = new Size(129, 31);
            flowLayoutPanel2.TabIndex = 0;
            // 
            // goBack
            // 
            goBack.Location = new Point(51, 3);
            goBack.Name = "goBack";
            goBack.Size = new Size(75, 23);
            goBack.TabIndex = 0;
            goBack.Text = "Volver";
            goBack.UseVisualStyleBackColor = true;
            goBack.Click += GoBack_Click;
            // 
            // MenuBorrar
            // 
            MenuBorrar.Items.AddRange(new ToolStripItem[] { borrarToolStripMenuItem });
            MenuBorrar.Name = "MenuBorrar";
            MenuBorrar.Size = new Size(107, 26);
            // 
            // borrarToolStripMenuItem
            // 
            borrarToolStripMenuItem.Name = "borrarToolStripMenuItem";
            borrarToolStripMenuItem.Size = new Size(106, 22);
            borrarToolStripMenuItem.Text = "Borrar";
            borrarToolStripMenuItem.Click += Delete_Click;
            // 
            // FileList
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(680, 501);
            Controls.Add(flowLayoutPanel1);
            Controls.Add(panel1);
            Name = "FileList";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "FileList";
            menuClickDerecho.ResumeLayout(false);
            panel1.ResumeLayout(false);
            panel2.ResumeLayout(false);
            panel2.PerformLayout();
            flowLayoutPanel2.ResumeLayout(false);
            MenuBorrar.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private FlowLayoutPanel flowLayoutPanel1;
        private ContextMenuStrip menuClickDerecho;
        private ToolStripMenuItem crearCarpeta;
        private ToolStripMenuItem crearArchivo;
        private Panel panel1;
        private FlowLayoutPanel flowLayoutPanel2;
        private Button goBack;
        private Panel panel2;
        private Label url;
        private ContextMenuStrip MenuBorrar;
        private ToolStripMenuItem borrarToolStripMenuItem;
    }
}