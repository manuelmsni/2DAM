namespace ExamencitoManuel.views
{
    partial class FilesList
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
            Contenedor = new FlowLayoutPanel();
            SuspendLayout();
            // 
            // Contenedor
            // 
            Contenedor.Dock = DockStyle.Fill;
            Contenedor.Location = new Point(0, 0);
            Contenedor.Name = "Contenedor";
            Contenedor.Size = new Size(800, 450);
            Contenedor.TabIndex = 0;
            // 
            // FilesList
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(Contenedor);
            Name = "FilesList";
            Text = "FilesList";
            ResumeLayout(false);
        }

        #endregion

        private FlowLayoutPanel Contenedor;
    }
}